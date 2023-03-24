package com.workoutTracker;

import java.util.Scanner;

public class UserPrompts {
	
	private static String askFirstName(Scanner in) {
		System.out.println("Enter first name:");
		String firstName = in.next();
		return firstName;
	}
	
	private static String askLastName(Scanner in) {
		System.out.println("Enter last name:");
		String lastName = in.next();
		return lastName;
	}
	
	private static int askAge(Scanner in) {
		System.out.println("Enter age:");
		boolean inputError = false;
		do {
			int age = in.nextInt();
			if (validateAgeInput(age)) {
				return age;
			} else {
				inputError = true;
				System.out.println("Please enter a valid age between 1 and 100");
			}
			
		} while (inputError);
		return 0;
	}
	
	private static double askWeight(Scanner in, boolean isUserWeight) {
		System.out.println("Enter weight in pounds:");
		boolean inputError = false;
		do {
			double weight = in.nextDouble();
			if (validateWeightInput(weight) || !isUserWeight) {
				return weight;
			} else {
				inputError = true;
				System.out.println("Weight must be greater than 0");
			}

		} while (inputError);
		return 0;
	}
	
	private static int askSetsReps(Scanner in, String sr) {
		System.out.println("How many " + sr + "?");
		boolean inputError = false;
		do {
			int sets = in.nextInt();
			if (validateSetRepInput(sets)) {
				return sets;
			} else {
				inputError = true;
				System.out.println("Sets/reps must be greater than 0");
			}
		} while (inputError);
		return 0;
	}
	
	private static boolean validateAgeInput(int age) {
		boolean isValidAge = (age < 100 && age > 1) ? true : false;
		return isValidAge;
	}
	
	private static boolean validateWeightInput(double weight) {
		boolean isValidWeight = (weight > 0) ? true : false;
		return isValidWeight;
	}
	
	private static boolean validateSetRepInput(int sr) {
		boolean isValidNum = (sr > 0) ? true : false;
		return isValidNum;
	}


}
