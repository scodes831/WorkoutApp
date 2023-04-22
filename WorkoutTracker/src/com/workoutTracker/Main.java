package com.workoutTracker;

public class Main {

	public static void main(String[] args) {
		DatabaseManager dm = new DatabaseManager();
		dm.connectDatabase("workouttracker", null, null);
		UserManager um = new UserManager();
		MainMenu mainMenu = new MainMenu();
		UserMenu userMenu = new UserMenu();
		mainMenu.displayMenu(um, mainMenu);
	}
}
