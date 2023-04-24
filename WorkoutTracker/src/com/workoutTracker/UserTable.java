package com.workoutTracker;

import java.sql.Connection;
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

}
