package com.workoutTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private static int ID = 1000;
	
	int userId;
	String firstName;
	String lastName;
	int age;
	double weightLbs;
	double weightKg;
	
	ArrayList<Workout> workouts = new ArrayList<Workout>();
	
	public User(String firstName, String lastName, int age, double weightLbs) {
		this.userId = generateUserId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.weightLbs = weightLbs;
	}

	public int generateUserId() { 
		int id = User.getID();
		id++;
		User.setID((id));  
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(double weightLbs) {
		this.weightLbs = weightLbs;
	}

	public double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}

	public ArrayList<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(ArrayList<Workout> workouts) {
		this.workouts = workouts;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}
	

}
