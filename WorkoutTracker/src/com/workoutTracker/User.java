package com.workoutTracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

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
		this.weightKg = convertPoundsToKilograms(weightLbs);
	}

	public User(Object firstName, Object lastName, Object age, Object weightLbs) {
		this.userId = generateUserId();
		this.firstName = (String) firstName;
		this.lastName = (String) lastName;
		this.age = (int) age;
		this.weightLbs = (double) weightLbs;
		this.weightKg = convertPoundsToKilograms((double) weightLbs);
	}

	public int generateUserId() {
		int id = User.getID();
		id++;
		User.setID((id));
		return id;
	}

	public Workout addWorkout(User user) {
		LocalDate workoutDate = UserPrompts.askWorkoutDate();
		int workoutTime = UserPrompts.askTime("workout");
		int heartRate = UserPrompts.askHeartRate();
		int calories = UserPrompts.askCalories();
		Workout workout = new Workout(workoutDate, workoutTime, heartRate, calories);
		user.getWorkouts().add(workout);
		return workout;
	}

	public void addWorkoutToDatabase(Workout workout, Connection connection, WorkoutTable workoutTable) {
		ArrayList<Object> workoutValues = new ArrayList<Object>();
		workoutValues.add(workout.getDate());
		workoutValues.add(workout.getTime());
		workoutValues.add(workout.getHeartRate());
		workoutValues.add(workout.getCalories());
		workoutTable.insertRow(connection, workoutValues);
	}

	public void displayAllWorkouts() {
		if (getWorkouts().size() == 0) {
			System.out.println("No workouts to display for this user\n");
		} else {
			Formatter table = new Formatter();
			table.format("%15s %15s %15s %15s %15s\n", "WorkoutId", "Date", "Time", "Heart Rate", "Calories");
			for (Workout workout : getWorkouts()) {
				table.format("%15s %15s %15s %15s %15s\n", workout.getWorkoutId(), workout.getDate(), workout.getTime(),
						workout.getHeartRate(), workout.getCalories());
			}
			System.out.println(table);
		}
	}

	public Workout selectWorkout() {
		int selectedWorkoutId = UserPrompts.askWorkoutSelection(this);
		for (Workout workout : getWorkouts()) {
			if (workout.getWorkoutId() == selectedWorkoutId) {
				return workout;
			}
		}
		return null;
	}

	public double convertPoundsToKilograms(double pounds) {
		BigDecimal kg = new BigDecimal(pounds * 0.453592).setScale(2, RoundingMode.HALF_UP);
		return kg.doubleValue();
	}

	public double convertKilogramsToPounds(double kilograms) {
		BigDecimal lbs = new BigDecimal(kilograms * 2.20462).setScale(2, RoundingMode.HALF_UP);
		return lbs.doubleValue();
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
