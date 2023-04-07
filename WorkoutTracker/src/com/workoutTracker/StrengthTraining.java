package com.workoutTracker;

import java.util.ArrayList;

public class StrengthTraining extends Exercise {
	
	String exerciseName;
	String muscleGroup;
	
	ArrayList<Set> sets = new ArrayList<Set>();
	
	public StrengthTraining(String exerciseName, String muscleGroup) {
		this.exerciseName = exerciseName;
		this.muscleGroup = muscleGroup;
	}
	
	StrengthTraining() {}
	
	public void addNewSet(int sets, double weightLbs, int reps) {
		Set set = new Set(sets, weightLbs, reps);
		getSets().add(set);
	}
		
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
	public ArrayList<Set> getSets() {
		return sets;
	}
	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}

}
