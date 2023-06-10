package com.workoutTracker;

import java.sql.Connection;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;

public class Bike extends Exercise {

	double mph;
	LocalTime pace;
	double distanceMi;
	double distanceKm;
	int resistance;
	boolean isStationaryBike;

	public Bike(int exerciseId, double mph, double distanceMi, double distanceKm, int resistance,
			boolean isStationaryBike) {
		this.exerciseId = exerciseId;
		this.mph = mph;
		this.distanceMi = distanceMi;
		this.distanceKm = distanceKm;
		this.resistance = resistance;
		this.isStationaryBike = isStationaryBike;
	}

	public Bike() {
	}

	public void addBikeDetails(Connection connection, BikeTable bikeTable) {
		boolean isStationaryBike = UserPrompts.askIfStationaryBike();
		this.setStationaryBike(isStationaryBike);
		double distanceMi = UserPrompts.askDistanceMiles();
		this.setDistanceMi(distanceMi);
		this.setDistanceKm(this.convertMilesToKilometers(distanceMi));
		int resistance = UserPrompts.askResistance();
		this.setResistance(resistance);
		this.setMph(this.calculateMPH(distanceMi, this.getExerciseTime()));
		this.setPace(this.calculatePace(this.getMph()));
		addToBikeTable(connection, bikeTable);
	}

	public void addToBikeTable(Connection connection, BikeTable bikeTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(this.getExerciseId());
		values.add(this.getMph());
		values.add(this.getPace());
		values.add(this.getDistanceMi());
		values.add(this.getDistanceKm());
		values.add(this.getResistance());
		values.add(this.getIsStationaryBike());
		bikeTable.insertRow(connection, values);
	}

	public void editBikeDetails(Connection connection, Workout workout, ExerciseTable exerciseTable,
			BikeTable bikeTable) {
		boolean stillEditing = true;
		ArrayList<Object> exerciseValues = new ArrayList<Object>();
		ArrayList<Object> bikeValues = new ArrayList<Object>();
		do {
			int selection = UserPrompts.askBikeEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					this.setMph(this.calculateMPH(this.getDistanceMi(), newExerciseTime));
					this.setPace(this.calculatePace(this.getMph()));
					break;
				case 2:
					boolean isStationaryBike = UserPrompts.askIfStationaryBike();
					this.setStationaryBike(isStationaryBike);
					break;
				case 3:
					double newDistanceMi = UserPrompts.askDistanceMiles();
					this.setDistanceMi(newDistanceMi);
					this.setDistanceKm(this.convertMilesToKilometers(newDistanceMi));
					this.setMph(this.calculateMPH(this.getDistanceMi(), this.getExerciseTime()));
					this.setPace(this.calculatePace(this.getMph()));
					break;
				case 4:
					int newResistance = UserPrompts.askResistance();
					this.setResistance(newResistance);
					break;
				case 5: 
					stillEditing = false;
					deleteBikeExercise(exerciseTable, bikeTable, workout, connection);
					break;
				}
				exerciseValues.add(this.getExerciseTime());
				bikeValues.add(this.getMph());
				bikeValues.add(this.getPace());
				bikeValues.add(this.getDistanceMi());
				bikeValues.add(this.getDistanceKm());
				bikeValues.add(this.getResistance());
				bikeValues.add(this.getIsStationaryBike());
				exerciseTable.updateRow(connection, this.getExerciseId(), exerciseValues);
				bikeTable.updateRow(connection, this.getExerciseId(), bikeValues);
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
	}
	
	private void deleteBikeExercise(ExerciseTable exerciseTable, BikeTable bikeTable, Workout workout, Connection connection) {
		bikeTable.deleteRow(connection, this.getExerciseId());
		exerciseTable.deleteRow(connection,  this.getExerciseId());
		workout.getExercises().remove(findExerciseIndex(workout, this));
	}

	public void displayBikeExercises() {
		Formatter table = new Formatter();
		table.format("%15s %15s %15s %15s %15s %15s %15s %15s\n", "ExerciseId", "Time", "MPH", "Pace",
				"Distance (miles)", "Distance (km)", "Resistance", "Stationary Bike?");
		table.format("%15s %15s %15s %15s %15s %15s %15s %15s\n", this.getExerciseId(), this.getExerciseTime(),
				this.getMph(), this.getPace(), this.getDistanceMi(), this.getDistanceKm(), this.getResistance(),
				this.getIsStationaryBike());
		System.out.println(table);
	}

	public double getMph() {
		return mph;
	}

	public void setMph(double mph) {
		this.mph = mph;
	}

	public LocalTime getPace() {
		return pace;
	}

	public void setPace(LocalTime pace) {
		this.pace = pace;
	}

	public double getDistanceMi() {
		return distanceMi;
	}

	public void setDistanceMi(double distanceMi) {
		this.distanceMi = distanceMi;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public boolean getIsStationaryBike() {
		return isStationaryBike;
	}

	public void setStationaryBike(boolean isStationaryBike) {
		this.isStationaryBike = isStationaryBike;
	}

}
