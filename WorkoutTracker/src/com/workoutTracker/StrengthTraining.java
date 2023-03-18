package com.workoutTracker;

public class StrengthTraining extends Exercise {
	
	String exerciseName;
	String muscleGroup;
	double weightLb;
	double weightKg;
	int sets;
	int reps;
	
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getMuscleGroup() {
		return muscleGroup;
	}
	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	public double getWeightLb() {
		return weightLb;
	}
	public void setWeightLb(double weightLb) {
		this.weightLb = weightLb;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}

}
