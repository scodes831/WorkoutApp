package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class StrengthTrainingTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists strengthTraining (strengthtrainingId SERIAL PRIMARY KEY, exerciseId SERIAL, "
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
					"insert into strengthtraining (exerciseName, muscleGroup) values ('%s', '%s');",
					values.get(0), values.get(1));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
