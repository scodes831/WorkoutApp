package com.workoutTracker;

import java.sql.Connection;
import java.util.ArrayList;

public class Set {
	
	private static int ID = 1;
	
	int setId;
	double weightLbs;
	double weightKg;
	int reps;
	
	Set(double weightLbs, int reps) {
		this.setId = generateSetId();
		this.weightLbs = weightLbs;
		this.reps = reps;
	}
	
	Set(int setId, double weightLbs, double weightKg, int reps) {
		this.setId = setId;
		this.weightLbs = weightLbs;
		this.weightKg = weightKg;
		this.reps = reps;
	}
	
	private int generateSetId() {
		int id = Set.getID();
		id++;
		Set.setID(id);
		return id;
	}
	
	public void addToSetTable(Connection connection, StrengthTraining st, SetTable setTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(getSetId());
		values.add(st.getExerciseId());
		values.add(getWeightLbs());
		values.add(getWeightKg());
		values.add(getReps());
		setTable.insertRow(connection, values);
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
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}
}
