package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;

public class UserTable extends Table {

	public void createTable(Connection connection) {
		Statement statement;
		try {
			String query = "create table if not exists users (userId SERIAL PRIMARY KEY, firstName VARCHAR(30), lastName VARCHAR (30), age INTEGER, "
					+ "weightLbs NUMERIC(3,1), weightKgs NUMERIC(3,1))";
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
