package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ExerciseTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists exercises (exerciseId INTEGER PRIMARY KEY, workoutId INTEGER, type VARCHAR(20), time TIME,"
					+ " FOREIGN KEY (workoutId) REFERENCES workouts(workoutId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertRow(Connection connection, ArrayList<Object> values) {
		Statement statement;
		try {
			String query = String.format("insert into exercises (exerciseId, workoutId, type, time) values ('%s', '%s', '%s', '%s');", values.get(0),
					values.get(1), values.get(2), values.get(3));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateRow(Connection connection, int id, ArrayList<Object> values) {
		Statement statement;
		try {
			String query = String.format("update exercises set time = '%s' where exerciseId = '%s'",
					values.get(0), id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from exercises where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, Workout workout, BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable, SetTable setTable) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from exercises where workoutId = " + workout.getWorkoutId() + " order by exerciseId";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				String exerciseType = result.getString("type");
				int exerciseId = Integer.valueOf(result.getString("exerciseId"));
				LocalTime time = LocalTime.parse(result.getString("time"));
				for (Exercise exercise : workout.getExercises()) {
					if (exercise.getExerciseId() == exerciseId) {
						alreadyExists = true;
					}
				}
				if ((!alreadyExists) || workout.getExercises().size() == 0) {
					Exercise newExercise = workout.addNewExercise(exerciseType);
					newExercise.setExerciseId(exerciseId);
					newExercise.setExerciseTime(time);
					workout.getExercises().add(newExercise);
					switch (exerciseType) {
					case "StrengthTraining":
						stTable.readTable(connection, workout, newExercise, setTable);
						break;
					case "Bike":
						bikeTable.readTable(connection, workout, newExercise);
						break;
					case "HIIT":
						hiitTable.readTable(connection, workout, newExercise);
						break;
					case "Run":
						runTable.readTable(connection, workout, newExercise);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
