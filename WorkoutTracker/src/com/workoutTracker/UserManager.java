package com.workoutTracker;

import java.util.ArrayList;

public class UserManager {
	
	ArrayList<User> users = new ArrayList<User>();
	
	public void addNewUser(String firstName, String lastName, int age, double weight) {
		User user = new User(firstName, lastName, age, weight);
		getUsers().add(user);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
