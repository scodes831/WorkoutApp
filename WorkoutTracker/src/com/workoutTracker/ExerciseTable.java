package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExerciseTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists exercises (exerciseId SERIAL PRIMARY KEY, workoutId SERIAL, type VARCHAR(20), time INTEGER,"
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
			String query = String.format("insert into exercises (type, time) values ('%s', '%s');", values.get(0),
					values.get(1));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateRow(Connection connection, int id, ArrayList<Object> newValues) {
		Statement statement;
		try {
			String query = String.format("update exercises set type = '%s', time = '%s' where exerciseId = '%s'",
					newValues.get(0), newValues.get(1), id);
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
			System.out.println("row deleted from exercise table");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, Workout workout, StrengthTrainingTable stTable, SetTable setTable) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from exercises where workoutId = " + workout.getWorkoutId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				int exerciseId = Integer.valueOf(result.getString("exerciseId"));
				int time = Integer.valueOf(result.getString("time"));
				for (Exercise exercise : workout.getExercises()) {
					if (exercise.getExerciseId() == exerciseId) {
						alreadyExists = true;
					}
				}
				if ((!alreadyExists) || workout.getExercises().size() == 0) {
					stTable.readTable(connection, workout, exerciseId, time, setTable);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
