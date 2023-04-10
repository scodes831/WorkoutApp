package com.workoutTracker.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.workoutTracker.Run;
import com.workoutTracker.StrengthTraining;


public class ExerciseTests {
	
	Run run;
	StrengthTraining st;
	
	@BeforeEach
	public void setup() {
		run = new Run();
		st = new StrengthTraining("squats", "legs");
	}
	
	@Test
	void convert1MileToKm() {
		double converted = run.convertMilesToKilometers(1);
		double expected = 1.61;
		Assert.assertEquals("Incorrect conversion to km", expected, converted, 0.001);
	}

	@Test
	void convert5MilesToKm() {
		double converted = run.convertMilesToKilometers(5);
		double expected = 8.05;
		Assert.assertEquals("Incorrect conversion to km", expected, converted, 0.001);
	}

	@Test
	void convert1PoundToKg() {
		double converted = st.convertPoundsToKilograms(1);
		double expected = 0.45;
		Assert.assertEquals("Incorrect conversion to kg", expected, converted, 0.001);
	}

	@Test
	void convert5PoundToKg() {
		double converted = st.convertPoundsToKilograms(5);
		double expected = 2.27;
		Assert.assertEquals("Incorrect conversion to kg", expected, converted, 0.001);
	}
	
	@Test
	void calculateMPH() {
		Assert.assertEquals("Incorrect calculation 1mph", 1.0, run.calculateMPH(1, 60), 0.001);
		Assert.assertEquals("Incorrect calculation 2.3mph", 2.3, run.calculateMPH(5, 130), 0.001);
	}

}
