package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HIITTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists hiit (exerciseId INTEGER PRIMARY KEY, active_interval_seconds INTEGER, rest_interval_seconds INTEGER, intervals INTEGER, "
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
					"insert into hiit (exerciseId, active_interval_seconds, rest_interval_seconds, intervals) values ('%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3));
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
					"update hiit set active_interval_seconds = '%s', rest_interval_seconds = '%s', intervals = '%s' where exerciseid = '%s'",
					newValues.get(0), newValues.get(1), newValues.get(2), id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from hiit where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void readTable(Connection connection, Workout workout, int exerciseId, int exerciseTime) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from hiit where exerciseId = " + exerciseId;
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				int activeIntervalSec = Integer.valueOf(result.getString("active_interval_seconds"));
				int restIntervalSec = Integer.valueOf(result.getString("rest_interval_seconds"));
				int numIntervals = Integer.valueOf(result.getString("intervals"));
				for (Exercise exercise : workout.getExercises()) {
					if (exercise instanceof HIIT) {
						if (exercise.getExerciseId() == exerciseId) {
							alreadyExists = true;
						} else {
							HIIT hiit = new HIIT(activeIntervalSec, restIntervalSec, numIntervals);
							workout.getExercises().add(hiit);
						}
					} else {
						continue;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
