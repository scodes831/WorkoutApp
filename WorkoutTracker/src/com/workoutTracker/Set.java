package com.workoutTracker;

public class Set {
	
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
}
