package com.workoutTracker;

import java.util.ArrayList;

public class UserManager {
	
	ArrayList<User> users = new ArrayList<User>();

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
