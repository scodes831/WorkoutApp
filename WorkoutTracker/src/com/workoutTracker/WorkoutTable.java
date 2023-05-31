package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class WorkoutTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists workouts (workoutId INTEGER PRIMARY KEY, userId INTEGER, date DATE, time INTEGER, heartRate INTEGER, "
					+ "calories INTEGER, FOREIGN KEY (userId) REFERENCES users(userId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertRow(Connection connection, ArrayList<Object> values) {
		Statement statement;
		try {
			String query = String.format(
					"insert into workouts (workoutId, userId, date, time, heartRate, calories) values ('%s', '%s', '%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateRow(Connection connection, int id, ArrayList<Object> newValues) {
		Statement statement;
		try {
			String query = String.format(
					"update workouts set date = '%s', time = '%s', heartRate = '%s', calories = '%s' where workoutId = '%s'",
					newValues.get(0), newValues.get(1), newValues.get(2), newValues.get(3), id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteRow(Connection connection, int id) {
		System.out.println("inside workouttable delete row");
		Statement statement;
		try {
			String query = String.format("delete from workouts where workoutid = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteWorkoutDependencies(Connection connection, Workout workout, ExerciseTable exerciseTable,
			StrengthTrainingTable stTable, SetTable setTable) {
		for (int e = 0; e < workout.getExercises().size(); e++) {
			if (workout.getExercises().get(e).getClass().getSimpleName().equals("StrengthTraining")) {
				StrengthTraining st = (StrengthTraining) workout.getExercises().get(e);
				for (int s = 0; s < st.getSets().size(); s++) {
					setTable.deleteRow(connection, st.getSets().get(s).getSetId());
					st.getSets().remove(s);
				}
				stTable.deleteRow(connection, workout.getExercises().get(e).getExerciseId());
			}
			exerciseTable.deleteRow(connection, workout.getExercises().get(e).getExerciseId());
			workout.getExercises().remove(e);
		}
	}

	public void readTable(Connection connection, User user, ExerciseTable exerciseTable, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, 
			StrengthTrainingTable stTable, SetTable setTable) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from workouts where userId = " + user.getUserId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				int workoutId = Integer.valueOf(result.getString("workoutId"));
				String[] dateStr = result.getString("date").split("-");
				int year = Integer.valueOf(dateStr[0]);
				int month = Integer.valueOf(dateStr[1]);
				int day = Integer.valueOf(dateStr[2]);
				LocalDate date = LocalDate.of(year, month, day);
				int time = Integer.valueOf(result.getString("time"));
				int heartRate = Integer.valueOf(result.getString("heartrate"));
				int calories = Integer.valueOf(result.getString("calories"));
				if (user.getWorkouts().size() != 0) {
					for (Workout workout : user.getWorkouts()) {
						if (workout.getWorkoutId() == workoutId) {
							alreadyExists = true;
						}
					}
				}

				if ((!alreadyExists) || user.getWorkouts().size() == 0) {
					Workout workout = new Workout(date, time, heartRate, calories);
					workout.setWorkoutId(workoutId);
					user.getWorkouts().add(workout);
					exerciseTable.readTable(connection, workout, bikeTable, runTable, hiitTable, stTable, setTable);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
