package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;

public class ExerciseTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists exercises (exerciseId SERIAL PRIMARY KEY, workout SERIAL, type VARCHAR(20), mph INTEGER, "
					+ "distanceMi NUMERIC(6,1), distanceKm NUMERIC(6,1), pace TIME, resistance INTEGER, stationaryBike BOOLEAN, activeInterval INTEGER, "
					+ "restInterval INTEGER, numIntervals INTEGER, exerciseName VARCHAR(30), muscleGroup VARCHAR(20), "
					+ "FOREIGN KEY (workout) REFERENCES workouts(workoutId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
