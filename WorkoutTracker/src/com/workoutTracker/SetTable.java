package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SetTable extends Table {
	
	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists sets (setId SERIAL PRIMARY KEY, exerciseId SERIAL, weightLbs NUMERIC(6,1), weightKg NUMERIC(6,1), "
					+ "reps INTEGER, FOREIGN KEY (exerciseId) REFERENCES exercises(exerciseId))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertRow(Connection connection, ArrayList<Object> values) {
		
	}

	public void updateRow(Connection connection, int id, ArrayList<Object> newValues) {
		
	}

	public void deleteRow(Connection connection, int id) {
		Statement statement;
		try {
			String query = String.format("delete from sets where exerciseId = '%s'", id);
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
			String query = "select * from sets where exerciseId = " + st.getExerciseId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int setId = Integer.valueOf(result.getString("setId"));
				double weightLbs = Double.valueOf(result.getString("weightLbs"));
				double weightKgs = Double.valueOf(result.getString("weightKg"));
				int reps = Integer.valueOf(result.getString("reps"));
				Set set = new Set(setId, weightLbs, weightKgs, reps);
				st.getSets().add(set);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
