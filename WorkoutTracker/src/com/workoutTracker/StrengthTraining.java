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
	
	public void addExerciseDetails(Workout workout) {
		String exerciseName = UserPrompts.askStrengthTrainingExerciseName();
		String muscleGroup = UserPrompts.askMuscleGroupName();
		this.setExerciseName(exerciseName);
		this.setMuscleGroup(muscleGroup);
		addSetDetails();
	}
	
	public void addSetDetails() {
		double setWeightLbs = UserPrompts.askSetWeight();
		int sets = UserPrompts.askNumSets();
		int reps = UserPrompts.askSetReps();
		for (int i = 1; i < sets+1; i++) {
			Set set = new Set(setWeightLbs, reps);
			getSets().add(set);
		}
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
