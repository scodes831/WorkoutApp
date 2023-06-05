package com.workoutTracker;

import java.sql.Connection;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;

public class Run extends Exercise {
	
	double mph;
	LocalTime pace;
	double distanceMi;
	double distanceKm;
	
	public Run(int exerciseId, double mph, double distanceMi, double distanceKm){
		this.exerciseId = exerciseId;
		this.mph = mph;
		this.distanceMi = distanceMi;
		this.distanceKm = distanceKm;
	}
	
	public Run() {}
	
	public void addRunDetails(Connection connection, RunTable runTable) {
		double distanceMi = UserPrompts.askDistanceMiles();
		this.setDistanceMi(distanceMi);
		this.setDistanceKm(this.convertMilesToKilometers(distanceMi));
		this.setMph(this.calculateMPH(distanceMi, this.getExerciseTime()));
		this.setPace(this.calculatePace(this.getMph()));
		addToRunTable(connection, runTable);
	}
	
	public void addToRunTable(Connection connection, RunTable runTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(this.getExerciseId());
		values.add(this.getMph());
		values.add(this.getPace());
		values.add(this.getDistanceMi());
		values.add(this.getDistanceKm());
		runTable.insertRow(connection, values);
	}
	
	public void editRunDetails(Connection connection, Workout workout, ExerciseTable exerciseTable, RunTable runTable) {
		boolean stillEditing = true;
		ArrayList<Object> exerciseValues = new ArrayList<Object>();
		ArrayList<Object> runValues = new ArrayList<Object>();
		do {
			int selection = UserPrompts.askRunEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					break;
				case 2:
					double newDistanceMi = UserPrompts.askDistanceMiles();
					this.setDistanceMi(newDistanceMi);
					this.setDistanceKm(this.convertMilesToKilometers(newDistanceMi));
					this.setMph(this.calculateMPH(newDistanceMi, this.getExerciseTime()));
					this.setPace(this.calculatePace(this.getMph()));
					break;
				}
				exerciseValues.add(this.getExerciseTime());
				runValues.add(this.getExerciseId());
				runValues.add(this.getMph());
				runValues.add(this.getPace());
				runValues.add(this.getDistanceMi());
				runValues.add(this.getDistanceKm());
				exerciseTable.updateRow(connection, this.getExerciseId(), runValues);
				runTable.updateRow(connection, this.getExerciseId(), runValues);
			} else {
				stillEditing = false;
			}
		} while (stillEditing);
	}
	
	public void displayRunExercises() {
		Formatter table = new Formatter();
		table.format("%15s %15s %15s %15s %15s %15s %15s\n", "ExerciseId", "Time", "MPH", "Pace",
				"Distance (miles)", "Distance (km)");
		table.format("%15s %15s %15s %15s %15s %15s %15s\n", this.getExerciseId(), this.getExerciseTime(),
				this.getMph(), this.getPace(), this.getDistanceMi(), this.getDistanceKm());
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

	

}
