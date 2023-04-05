package com.workoutTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu extends Menu {

	public void displayMenu(UserManager userManager, MainMenu mainMenu) {
		boolean inputError = false;
		do {
			try {
				int selection = makeSelection();
				processSelection(userManager, mainMenu, selection);
			} catch (Exception e) {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);

	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection) {
		switch (selection) {
		case 1:
			ArrayList<Object> values = userManager.getNewUserDetails();
			User user = userManager.addNewUser(values);
			System.out.println("You have added a new user: " + user.getFirstName() + " " + user.getLastName() + " is "
					+ user.getAge() + " years old and weighs " + user.getWeightLbs() + " pounds.");
			break;
		case 2:
			System.out.println("Displaying all users:\n");
			userManager.displayUsers(userManager.getUsers());
			break;
		case 3:
			userManager.displayUsers(userManager.getUsers());
			int selectedId = UserPrompts.askUserId(userManager);
			User selectedUser = userManager.getUserById(userManager, selectedId);
			userManager.editUser(selectedUser);
			break;
		}
		displayMenu(userManager, mainMenu);

	}

	public int makeSelection() {
		System.out.println("User Menu Options:\n1 - Add User\n2 - Display Users\n3 - Edit Users");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

}
