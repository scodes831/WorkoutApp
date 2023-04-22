package com.workoutTracker;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		UserManager um = new UserManager();
		MainMenu mainMenu = new MainMenu();
		UserMenu userMenu = new UserMenu();
		mainMenu.displayMenu(um, mainMenu);
	}
}
