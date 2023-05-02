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
			String query = "create table if not exists workouts (workoutId SERIAL PRIMARY KEY, userId SERIAL, date DATE, time INTEGER, heartRate INTEGER, "
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
					"insert into workouts (date, time, heartRate, calories) values ('%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, User user, ExerciseTable exerciseTable, StrengthTrainingTable stTable) {
		Statement statement;
		ResultSet result = null;
		System.out.println("the user's id is " + user.getUserId());
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
				System.out.println("the workout's id on table is " + workoutId);
				if (user.getWorkouts().size() != 0) {
					for (Workout workout : user.getWorkouts()) {
						System.out.println("the workout's id in class is " + workout.getWorkoutId());
						if (workout.getWorkoutId() == workoutId) {
							System.out.println("workout already exists");
							alreadyExists = true;
						}
					}
				}
				
				if ((!alreadyExists) || user.getWorkouts().size() == 0) {
					Workout workout = new Workout(date, time, heartRate, calories);
					workout.setWorkoutId(workoutId);
					user.getWorkouts().add(workout);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
