package com.workoutTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists users (userId SERIAL PRIMARY KEY, firstName VARCHAR(30), lastName VARCHAR (30), age INTEGER, "
					+ "weightLbs NUMERIC(6,1), weightKgs NUMERIC(6,1))";
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
					"insert into users (firstName, lastName, age, weightLbs, weightKgs) values ('%s', '%s', '%s', '%s', '%s');",
					values.get(0), values.get(1), values.get(2), values.get(3), values.get(4));
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void readTable(Connection connection, UserManager userManager, WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable) {
		Statement statement;
		ResultSet result;
		try {
			String query = "select * from users";
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				boolean alreadyExists = false;
				int userId = Integer.valueOf(result.getString("userId"));
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				int age = Integer.valueOf(result.getString("age"));
				double weightLbs = Double.valueOf(result.getString("weightLbs"));
				double weightKgs = Double.valueOf(result.getString("weightKgs"));
				for (User user : userManager.getUsers()) {
					if (user.getUserId() == userId) {
						alreadyExists = true;
					}
				}
				if (!alreadyExists) {
					User user = new User(firstName, lastName, age, weightLbs);
					user.setUserId(userId);
					user.setWeightKg(weightKgs);
					userManager.getUsers().add(user);
					workoutTable.readTable(connection, user, exerciseTable, stTable);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
