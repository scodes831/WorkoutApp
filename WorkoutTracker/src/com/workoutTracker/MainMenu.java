package com.workoutTracker;

import java.util.Scanner;

public class MainMenu extends Menu {
	
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
	
	public int makeSelection() {
		System.out.println("Menu options:\n1 - Users\n2 - Workouts");
		Scanner in = new Scanner(System.in);
		int selection = in.nextInt();
		return selection;
	}

	public void processSelection(UserManager userManager, MainMenu mainMenu, int selection) {
		switch (selection) {
		case 1: 
			UserMenu userMenu = new UserMenu();
			userMenu.displayMenu(userManager, mainMenu);
		}
		
	}
	
	

}
