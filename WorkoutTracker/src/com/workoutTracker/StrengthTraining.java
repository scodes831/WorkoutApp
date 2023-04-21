package com.workoutTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StrengthTraining extends Exercise {
	
	String exerciseName;
	String muscleGroup;
	
	ArrayList<Set> sets = new ArrayList<Set>();
	
	public StrengthTraining(String exerciseName, String muscleGroup) {
		this.exerciseName = exerciseName;
		this.muscleGroup = muscleGroup;
	}
	
	StrengthTraining() {}
	
	public void addStrengthTrainingDetails() {
		String exerciseName = UserPrompts.askStrengthTrainingExerciseName();
		String muscleGroup = UserPrompts.askMuscleGroupName();
		this.setExerciseName(exerciseName);
		this.setMuscleGroup(muscleGroup);
		addSetDetails();
	}
	
	public void editStrengthTrainingDetails() {
		boolean stillEditing = true;
		do {
			int selection = UserPrompts.askStrengthTrainingEditFields();
			if (selection > 0) {
				switch (selection) {
				case 1:
					int newExerciseTime = UserPrompts.askTime("exercise");
					this.setExerciseTime(newExerciseTime);
					break;
				case 2: 
					int newHeartRate = UserPrompts.askHeartRate();
					this.setHeartRate(newHeartRate);
					break;
				case 3: 
					int calories = UserPrompts.askCalories();
					this.setCalories(calories);
					break;
				case 4: 
					String exerciseName = UserPrompts.askStrengthTrainingExerciseName();
					this.setExerciseName(exerciseName);
					break;
				case 5:
					String newMuscleGroup = UserPrompts.askMuscleGroupName();
					this.setMuscleGroup(newMuscleGroup);
					break;
				case 6:
					System.out.println("editing sets");
					break;
				}
			} else {
				stillEditing = false;
			}
			
		} while (stillEditing);
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
