package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BikeTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists bike (exerciseId INTEGER PRIMARY KEY, mph NUMERIC(6,1), pace TIME, distance_mi NUMERIC(6,2),"
					+ " distance_km NUMERIC(6,2), resistance INTEGER, is_stationary_bike BOOLEAN, FOREIGN KEY (exerciseId) REFERENCES exercises(exerciseId))";
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
					"insert into bike (exerciseId, mph, pace, distance_mi, distance_km, resistance, is_stationary_bike) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6));
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
					"update bike set mph = '%s', pace = '%s', distance_mi = '%s', distance_km = '%s', resistance = '%s', is_stationary_bike = '%s' where exerciseid = '%s'",
					newValues.get(0), newValues.get(1), newValues.get(2), newValues.get(3), newValues.get(4), newValues.get(5), newValues.get(6), id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from bike where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, Workout workout, Exercise exercise) {
		System.out.println("inside bikeTable.readTable");
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from bike where exerciseId = " + exercise.getExerciseId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				double mph = Double.valueOf(result.getString("mph"));
				double distanceMi = Double.valueOf(result.getString("distance_mi"));
				double distanceKm = Double.valueOf(result.getString("distance_km"));
				int resistance = Integer.valueOf(result.getString("resistance"));
				String stringSB = result.getString("is_stationary_bike");
				boolean isStationaryBike = getBooleanValue(stringSB);
				((Bike) exercise).setMph(mph);
				((Bike) exercise).setPace(exercise.calculatePace(mph));
				((Bike) exercise).setDistanceMi(distanceMi);
				((Bike) exercise).setDistanceKm(distanceKm);
				((Bike) exercise).setResistance(resistance);
				((Bike) exercise).setStationaryBike(isStationaryBike);					
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private boolean getBooleanValue(String sb) {
		if (sb.equals("t")) {
			return true;
		}  else {
			return false;
		}
	}

}
