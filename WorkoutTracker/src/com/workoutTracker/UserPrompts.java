package com.workoutTracker;

import java.time.LocalDate;
import java.util.Scanner;

public class UserPrompts {

	public static String askFirstName(Scanner in) {
		System.out.println("Enter first name:");
		String firstName = in.next();
		return firstName;
	}

	public static String askLastName(Scanner in) {
		System.out.println("Enter last name:");
		String lastName = in.next();
		return lastName;
	}

	public static int askAge(Scanner in) {
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

	public static double askWeight(Scanner in, boolean isUserWeight) {
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

	public static int askSetsReps(Scanner in, String sr) {
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

	public static int askUserId(UserManager userManager) {
		System.out.println("Please enter the UserId of the user you want to edit:\n");
		boolean inputError;
		Scanner in = new Scanner(System.in);
		do {
			int id = in.nextInt();
			if (validateIdInput(userManager, id)) {
				return id;
			} else {
				inputError = true;
				System.out.println("Please enter a valid userId");
			}
		} while (inputError);
		return 0;
	}

	public static int askUserEditField(User user) {
		System.out.println("Please select the field to edit for : " + user.getFirstName() + " " + user.getLastName()
				+ " (enter 0 when finished editing):\n");
		System.out.print("1 - First Name\n2 - Last Name\n3 - Age\n4 - Weight (lbs)\n5 - Weight (kg)");
		boolean inputError;
		Scanner in = new Scanner(System.in);
		do {
			int selection = in.nextInt();
			if (selection > 0 && selection < 6) {
				return selection;
			} else if (selection == 0) {
				return 0;
			} else {
				inputError = true;
				System.out.println("Please enter a valid selection");
			}
		} while (inputError);
		return -1;
	}

	public static LocalDate askWorkoutDate() {
		System.out.println("Enter date of workout (MM/DD/YYYY):");
		boolean inputError;
		Scanner in = new Scanner(System.in);
		do {
			String dateInput = in.next();
			if (validateDateInput(dateInput)) {
				String[] dateArr = dateInput.split("/");
				LocalDate workoutDate = LocalDate.of(Integer.valueOf(dateArr[3]), Integer.valueOf(dateArr[0]),
						Integer.valueOf(dateArr[0]));
				return workoutDate;
			} else {
				inputError = true;
				System.out.println("Please enter a valid date");
			}
		} while (inputError);
		return LocalDate.now();
	}

	public static int askWorkoutTime() {
		System.out.println("How long was the workout (in minutes)?");
		Scanner in = new Scanner(System.in);
		int workoutTime = in.nextInt();
		return workoutTime;
	}

	public static String askExerciseType() {
		System.out.println(
				"Please enter the type of exercise:\n1 - Run\n2 - High Intensity Interval Training\n3 - Bike\n4 - Strength Training");
		Scanner in = new Scanner(System.in);
		boolean inputError = false;
		do {
			int selection = in.nextInt();
			if (validateExerciseTypeInput(selection)) {
				switch (selection) {
				case 1:
					return "Run";
				case 2:
					return "HIIT";
				case 3:
					return "Bike";
				case 4:
					return "Strength Training";
				}
			} else {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);
		return null;
	}

	public static String askStrengthTrainingExerciseName() {
		System.out.println("Enter exercise name:");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		return input;
	}

	public static String askMuscleGroupName() {
		System.out.println(
				"Select the muscle group for this exercise:\n1 - Shoulders\n2 - Triceps\nB3 - Biceps\n4 - Upper Back\n5 - Lower Back\n6 - Abs\n7 - Hamstrings\n8 - Quads\n9 - Glutes\n10 - Calves");
		Scanner in = new Scanner(System.in);
		boolean inputError = false;
		do {
			int selection = in.nextInt();
			if (validateMuscleGroupNameInput(selection)) {
				switch (selection) {
				case 1:
					return "Shoulders";
				case 2: 
					return "Triceps";
				case 3: 
					return "Biceps";
				case 4:
					return "Upper Back";
				case 5: 
					return "Lower Back";
				case 6: 
					return "Abs";
				case 7: 
					return "Hamstrings";
				case 8: 
					return "Quads";
				case 9:
					return "Glutes";
				case 10:
					return "Calves";
				}
			} else {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);
		return null;
	}
	
	public static int askNumSets() {
		System.out.println("How many sets?");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		return input;
	}
	
	public static double askSetWeight() {
		System.out.println("Enter weight for set (in pounds):");
		Scanner in = new Scanner(System.in);
		double input = in.nextDouble();
		return input;
	}
	
	public static int askSetReps() {
		System.out.println("Number of reps?");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		return input;
	}
	
	public static boolean askIfStationaryBike() {
		System.out.println("Was workout on a stationary bike?\n1 - Yes\n2 - No");
		Scanner in = new Scanner(System.in);
		boolean inputError = false;
		do {
			int selection = in.nextInt();
			if (validateBikeTypeInput(selection)) {
				if (selection == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				inputError = true;
				System.out.println("Please enter a valid selection.");
			}
		} while (inputError);
		return false;	
	}
	
	private static boolean validateDateInput(String input) {
		String regex = "[0-9]+/[0-9]+/[0-9]{4}";
		return input.matches(regex);
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

	private static boolean validateIdInput(UserManager userManager, int id) {
		for (User user : userManager.getUsers()) {
			if (user.getUserId() == id) {
				return true;
			}
		}
		return false;
	}

	private static boolean validateExerciseTypeInput(int input) {
		boolean isValidInput = (input > 0 && input < 5) ? true : false;
		return isValidInput;
	}
	
	private static boolean validateMuscleGroupNameInput(int input) {
		boolean isValidInput = (input > 0 && input < 11) ? true : false; 
		return isValidInput;
	}
	
	private static boolean validateBikeTypeInput(int input) {
		boolean isValidInput = (input == 1 || input == 2) ? true : false;
		return isValidInput;
	}

}
