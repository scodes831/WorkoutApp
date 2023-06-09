package com.workoutTracker;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class Table {
	
	public abstract void createTable(Connection connection);
	
	public abstract void insertRow(Connection connection, ArrayList<Object> values);
	
	public abstract void updateRow(Connection connection, int id, ArrayList<Object> newValues);
	
	public abstract void deleteRow(Connection connection, int id);
		
}
