package com.workoutTracker;

public class Set {
	
	int sets;
	double weightLbs;
	double weightKg;
	int reps;
	
	public Set(int sets, double weightLbs, int reps) {
		this.sets = sets;
		this.weightLbs = weightLbs;
		this.reps = reps;
	}
	
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
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
