package com.workoutTracker;

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
		userTable.format("%15s %15s %15s %15s %15s %15s\n", "User Id", "First Name", "Last Name", "Age", "Weight (lbs)",
				"Weight (kg)");
		for (User user : users) {
			userTable.format("%15s %15s %15s %15s %15s %15s\n", user.getUserId(), user.getFirstName(),
					user.getLastName(), user.getAge(), user.getWeightLbs(), user.getWeightKg());
		}
		System.out.println(userTable);
	}

	public void editUser(User user) {
		Scanner in = new Scanner(System.in);
		boolean stillEditing = true;
		do {
			int selection = UserPrompts.askUserEditField(user);
			if (selection > 0) {
				switch (selection) {
				case 1: 
					String firstName = UserPrompts.askFirstName(in);
					user.setFirstName(firstName);
					System.out.println("User first name has been updated to " + user.getFirstName());
					break;
				case 2: 
					String lastName = UserPrompts.askLastName(in);
					user.setLastName(lastName);
					System.out.println("User last name has been updated to " + user.getLastName());
					break;
				case 3: 
					int age = UserPrompts.askAge(in);
					user.setAge(age);
					System.out.println("User age has been updated to " + user.getAge() + "years old");
					break;
				case 4: 
					double weightLbs = UserPrompts.askWeight(in, true);
					user.setWeightLbs(weightLbs);
					user.setWeightKg(user.convertPoundsToKilograms(user.getWeightLbs()));
					System.out.println("User weight has been updated to " + user.getWeightLbs() + " pounds");
					break;
				case 5:
					double weightKg = UserPrompts.askWeight(in, true);
					user.setWeightKg(weightKg);
					user.setWeightLbs(user.convertKilogramsToPounds(user.getWeightKg()));
					System.out.println("User weight has been updated to " + user.getWeightKg() + " kilograms");
					break;
				}
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
	}
	
	public User getUserById(UserManager um, int id) {
		for (int i = 0; i < um.getUsers().size(); i++) {
			if (um.getUsers().get(i).getUserId() == id) {
				return um.getUsers().get(i);
			}
		}
		return null;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
