package com.workoutTracker;

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
		int age = in.nextInt();
		return age;
	}
	
	public static double askWeight(Scanner in) {
		System.out.println("Enter weight in pounds:");
		double weight = in.nextDouble();
		return weight;
	}
	

}
