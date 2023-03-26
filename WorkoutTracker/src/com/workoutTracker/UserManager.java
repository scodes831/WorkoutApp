package com.workoutTracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class UserManager {
	
	ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<Object> getNewUserDetails() {
		Scanner in = new Scanner(System.in);
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(UserPrompts.askFirstName(in));
		values.add(UserPrompts.askLastName(in));
		values.add(UserPrompts.askAge(in));
		values.add(UserPrompts.askWeight(in, true));
		return values;
	}
	
	public User addNewUser(ArrayList<Object> values) {
		User user = new User(values.get(0), values.get(1), values.get(2), values.get(3));
		getUsers().add(user);
		return user;
	}
	
	public void displayUsers(ArrayList<User> users) {
		Formatter userTable = new Formatter();
		userTable.format("%15s %15s %15s %15s %15s %15s\n", "User Id", "First Name", "Last Name", "Age", "Weight (lbs)", "Weight (kg)");
		for (User user : users) {
			userTable.format("%15s %15s %15s %15s %15s %15s\n", user.getUserId(), user.getFirstName(), user.getLastName(), user.getAge(), user.getWeightLbs(), user.getWeightKg());
		}
		System.out.println(userTable);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
