package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SetTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists sets (setId INTEGER PRIMARY KEY, exerciseId INTEGER, weightLbs NUMERIC(6,1), weightKg NUMERIC(6,1), "
					+ "reps INTEGER, FOREIGN KEY (exerciseId) REFERENCES exercises(exerciseId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertRow(Connection connection, ArrayList<Object> values) {
		Statement statement;
		try {
			String query = String.format("insert into sets (setId, exerciseId, weightLbs, weightKg, reps) values ('%s', '%s', '%s', '%s', '%s');",
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
					"update sets set weightLbs = '%s', weightKg = '%s', reps = '%s' where setId = '%s'",
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
			String query = String.format("delete from sets where setId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteSetsByExerciseId(Connection connection, int exerciseId) {
		Statement statement;
		try {
			String query = String.format("delete from sets where exerciseId = '%s'", exerciseId);
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, StrengthTraining st) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from sets where exerciseId = " + st.getExerciseId() + " order by setId";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				int setId = Integer.valueOf(result.getString("setId"));
				double weightLbs = Double.valueOf(result.getString("weightLbs"));
				double weightKgs = Double.valueOf(result.getString("weightKg"));
				int reps = Integer.valueOf(result.getString("reps"));
				for (Set set : st.getSets()) {
					if (set.getSetId() == setId) {
						alreadyExists = true;
					}
				}
				if (!alreadyExists) {
					Set set = new Set(setId, weightLbs, weightKgs, reps);
					st.getSets().add(set);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
