package com.workoutTracker;

public abstract class Menu {
	
	public abstract void displayMenu(UserManager userManager, MainMenu mainMenu);
	
	public abstract void processSelection(UserManager userManager, MainMenu mainMenu, int selection);

}
