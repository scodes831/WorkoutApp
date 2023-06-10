package com.workoutTracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Exercise {

	private static int ID = 1;

	int exerciseId;
	int exerciseTime;

	Exercise() {
		this.exerciseId = generateExerciseId();
	}

	public int generateExerciseId() {
		int id = Exercise.getID();
		id++;
		Exercise.setID(id);
		return id;
	}

	public void addExerciseDetails(Connection connection, Workout workout, ExerciseTable exerciseTable,
			BikeTable bikeTable, RunTable runTable, HIITTable hiitTable, StrengthTrainingTable stTable,
			SetTable setTable) {
		int exerciseTime = UserPrompts.askTime("exercise");
		this.setExerciseTime(exerciseTime);
		addExerciseToDatabase(connection, workout, exerciseTable);
		if (this instanceof StrengthTraining) {
			((StrengthTraining) this).addStrengthTrainingDetails(connection, stTable, setTable);
		} else if (this instanceof Bike) {
			((Bike) this).addBikeDetails(connection, bikeTable);
		} else if (this instanceof HIIT) {
			((HIIT) this).addHIITDetails(connection, hiitTable);
		} else if (this instanceof Run) {
			((Run) this).addRunDetails(connection, runTable);
		}
	}

	public void addExerciseToDatabase(Connection connection, Workout workout, ExerciseTable exerciseTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(getExerciseId());
		values.add(workout.getWorkoutId());
		values.add(getClass().getSimpleName());
		values.add(getExerciseTime());
		exerciseTable.insertRow(connection, values);
	}

	public void editExerciseDetails(Connection connection, Workout workout, ExerciseTable exerciseTable,
			BikeTable bikeTable, HIITTable hiitTable, RunTable runTable, StrengthTrainingTable stTable, SetTable setTable) {
		System.out.println("start: edit exercise details");
		if (this instanceof StrengthTraining) {
			System.out.println("this is an instance of st");
			((StrengthTraining) this).editStrengthTrainingDetails(connection, workout, exerciseTable, stTable, setTable);
		} else if (this instanceof Bike) {
			System.out.println("this is an instance of bike");
			((Bike) this).editBikeDetails(connection, workout, exerciseTable, bikeTable);
		} else if (this instanceof HIIT) {
			System.out.println("this is an instance of hiit");
			((HIIT) this).editHIITDetails(connection, workout, exerciseTable, hiitTable);
		} else if (this instanceof Run) {
			System.out.println("this is an instance of run");
			((Run) this).editRunDetails(connection, workout, exerciseTable, runTable);
		}
	}
	
	public int findExerciseIndex(Workout workout, Exercise exercise) {
		int index = -1;
		for (int i = 0; i < workout.getExercises().size(); i++) {
			if (workout.getExercises().get(i).getExerciseId() == this.getExerciseId()) {
				index = i;
				break;
			}
		}
		return index;
	}

	public double calculateMPH(double miles, int time) {
		BigDecimal mph = new BigDecimal((miles * 60) / time).setScale(1, RoundingMode.HALF_UP);
		return mph.doubleValue();
	}

	public LocalTime calculatePace(double mph) {
		int hour = 0;
		int minutes = (int) (60.0 / mph);
		if (minutes > 59) {
			hour++;
		}
		int seconds = (int) (((60.0 / mph) - minutes) * 60);
		LocalTime pace = LocalTime.of(hour, minutes, seconds);
		return pace;
	}

	public double convertMilesToKilometers(double miles) {
		BigDecimal km = new BigDecimal(miles * 1.609344).setScale(2, RoundingMode.HALF_UP);
		return km.doubleValue();
	}

	public double convertPoundsToKilograms(double pounds) {
		BigDecimal kg = new BigDecimal(pounds * 0.453592).setScale(2, RoundingMode.HALF_UP);
		return kg.doubleValue();
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

	public int getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(int exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

}
