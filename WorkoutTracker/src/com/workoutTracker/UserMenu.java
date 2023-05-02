package com.workoutTracker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu extends Menu {

	public void displayMenu(UserManager userManager, MainMenu mainMenu, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(userManager, mainMenu, selection, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);

	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection, Connection connection, UserTable userTable,
			WorkoutTable workoutTable, ExerciseTable exerciseTable, StrengthTrainingTable stTable, SetTable setTable) {
		switch (selection) {
		case 1:
			ArrayList<Object> values = userManager.getNewUserDetails();
			User user = userManager.addNewUser(values);
			userManager.addUserToDatabase(user, connection, userTable);
			System.out.println("You have added a new user: " + user.getFirstName() + " " + user.getLastName() + " is "
					+ user.getAge() + " years old and weighs " + user.getWeightLbs() + " pounds.");
			break;
		case 2:
			System.out.println("Displaying all users:\n");
			userManager.displayUsers(userManager.getUsers());
			break;
		case 3:
			User selectedUser = userManager.selectAUser(userManager);
			userManager.editUser(selectedUser);
			break;
		case 4:
			mainMenu.displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable);
			break;
		}
		displayMenu(userManager, mainMenu, connection, userTable, workoutTable, exerciseTable, stTable, setTable);

	}

	public int makeSelection() {
		System.out
				.println("User Menu Options:\n1 - Add User\n2 - Display Users\n3 - Edit Users\n4 - Back to Main Menu");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
