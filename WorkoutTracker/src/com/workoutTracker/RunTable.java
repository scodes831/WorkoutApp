package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RunTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists run (exerciseId INTEGER PRIMARY KEY, mph NUMERIC(6,1), pace TIME, distance_mi NUMERIC(6,2), distance_km NUMERIC(6,2), "
					+ "FOREIGN KEY (exerciseId) REFERENCES exercises(exerciseId))";
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
					"insert into run (exerciseId, mph, pace, distance_mi, distance_km) values ('%s', '%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
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
					"update run set mph = '%s', pace = '%s', distance_mi = '%s', distance_km = '%s' where exerciseid = '%s'",
					newValues.get(0), newValues.get(1), newValues.get(2), newValues.get(3), id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from run where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void readTable(Connection connection, Workout workout, Exercise exercise) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from run where exerciseId = " + exercise.getExerciseId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				double mph = Double.valueOf(result.getString("mph"));
				double distanceMi = Double.valueOf(result.getString("distance_mi"));
				double distanceKm = Double.valueOf(result.getString("distance_km"));
				((Run) exercise).setMph(mph);
				((Run) exercise).setPace(exercise.calculatePace(mph));
				((Run) exercise).setDistanceMi(distanceMi);
				((Run) exercise).setDistanceKm(distanceKm);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
