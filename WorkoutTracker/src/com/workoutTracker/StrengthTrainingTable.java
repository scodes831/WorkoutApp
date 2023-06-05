package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StrengthTrainingTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists strengthTraining (exerciseId INTEGER PRIMARY KEY, "
					+ "exerciseName VARCHAR(40), muscleGroup VARCHAR(20), FOREIGN KEY (exerciseId) REFERENCES exercises(exerciseId))";
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
					"insert into strengthtraining (exerciseId, exerciseName, muscleGroup) values ('%s', '%s', '%s');", values.get(0),
					values.get(1), values.get(2));
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
					"update strengthtraining set exercisename = '%s', musclegroup = '%s' where exerciseid = '%s'",
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
			String query = String.format("delete from strengthtraining where exerciseId = '%s'", id);
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void readTable(Connection connection, Workout workout, Exercise exercise, SetTable setTable) {
		Statement statement;
		ResultSet result = null;
		try {
			String query = "select * from strengthtraining where exerciseId = " + exercise.getExerciseId();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				String exerciseName = result.getString("exercisename");
				String muscleGroup = result.getString("musclegroup");
				((StrengthTraining) exercise).setExerciseName(exerciseName);
				((StrengthTraining) exercise).setMuscleGroup(muscleGroup);
				setTable.readTable(connection, (StrengthTraining) exercise);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
