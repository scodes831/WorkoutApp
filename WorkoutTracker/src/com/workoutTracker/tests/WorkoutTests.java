package com.workoutTracker.tests;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.workoutTracker.Exercise;
import com.workoutTracker.Workout;

public class WorkoutTests {
	
	Workout workout1;
	Workout workout2;
	ArrayList<Exercise> exercises1;
	ArrayList<Exercise> exercises2;
	
	@BeforeEach
	public void setup() {
		workout1 = new Workout(LocalDate.of(2023, 4, 1), 60, exercises1);
		workout2 = new Workout(LocalDate.of(2023, 3, 29), 85, exercises2);
	}
	
	@Test
	void doesWorkoutIdGenerate() {
		int id1 = workout1.getWorkoutId();
		Assert.assertTrue(id1 != 0);
	}
	
	@Test
	void doesUniqueWorkoutIdGenerate() {
		int id1 = workout1.getWorkoutId();
		int id2 = workout2.getWorkoutId();
		Assert.assertTrue(id1 != id2);
	}

}
