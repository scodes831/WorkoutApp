package com.workoutTracker;

import java.sql.Connection;
import java.sql.Statement;

public class Table {
	
	public void createTable(Connection connection, String tableName, String columns) {
		Statement statement;
		try {
			String query = "create table if not exists " + tableName + " " + columns;
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
