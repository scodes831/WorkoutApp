package com.workoutTracker;

import java.sql.Connection;
import java.util.ArrayList;

public class StrengthTraining extends Exercise {
	
	String exerciseName;
	String muscleGroup;
	
	ArrayList<Set> sets = new ArrayList<Set>();
	
	public StrengthTraining(String exerciseName, String muscleGroup) {
		this.exerciseName = exerciseName;
		this.muscleGroup = muscleGroup;
	}
	
	StrengthTraining(int id, int time, String exerciseName, String muscleGroup) {
		this.exerciseId = id;
		this.exerciseTime = time;
		this.exerciseName = exerciseName;
		this.muscleGroup = muscleGroup;
	}
	
	StrengthTraining() {}
	
	public void addStrengthTrainingDetails(Connection connection, StrengthTrainingTable stTable) {
		String exerciseName = UserPrompts.askStrengthTrainingExerciseName();
		String muscleGroup = UserPrompts.askMuscleGroupName();
		this.setExerciseName(exerciseName);
		this.setMuscleGroup(muscleGroup);
		addToStrengthTrainingTable(connection, stTable);
		addSetDetails();
	}
	
	private void addToStrengthTrainingTable(Connection connection, StrengthTrainingTable stTable) {
		ArrayList<Object> values = new ArrayList<Object>();
		values.add(getExerciseName());
		values.add(getMuscleGroup());
		stTable.insertRow(connection, values);
	}
	
	public void deleteFromStrengthTrainingTable(Connection connection, Workout workout, StrengthTraining st, StrengthTrainingTable stTable) {
		stTable.deleteRow(connection, st.getExerciseId());
		int exerciseIndex = -1;
		for (int i = 0; i < workout.getExercises().size(); i++) {
			if (workout.getExercises().get(i).getExerciseId() == st.getExerciseId()) {
				exerciseIndex = i;
				break;
			}
		}
		workout.getExercises().remove(exerciseIndex);
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
					String exerciseName = UserPrompts.askStrengthTrainingExerciseName();
					this.setExerciseName(exerciseName);
					break;
				case 3:
					String newMuscleGroup = UserPrompts.askMuscleGroupName();
					this.setMuscleGroup(newMuscleGroup);
					break;
				case 4:
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
