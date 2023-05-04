package com.workoutTracker;

public class Set {
	
	int setId;
	double weightLbs;
	double weightKg;
	int reps;
	
	public Set(double weightLbs, int reps) {
		this.weightLbs = weightLbs;
		this.reps = reps;
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
}
