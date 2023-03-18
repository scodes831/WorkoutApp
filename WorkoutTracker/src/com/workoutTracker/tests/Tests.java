package com.workoutTracker.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.workoutTracker.Run;
import com.workoutTracker.StrengthTraining;

public class Tests {

	@Test
	 void convert1MileToKm() {
		Run run = new Run();
		double converted = run.convertMilesToKilometers(1);
		double expected = 1.61;
		Assert.assertEquals("Incorrect conversion to km", expected, converted, 0.001);
	}
	
	@Test
	 void convert5MilesToKm() {
		Run run = new Run();
		double converted = run.convertMilesToKilometers(5);
		double expected = 8.05;
		Assert.assertEquals("Incorrect conversion to km", expected, converted, 0.001);
	}
	
	@Test
	void convert1PoundToKg() {
		StrengthTraining st = new StrengthTraining();
		double converted = st.convertPoundsToKilograms(1);
		double expected = 0.45;
		Assert.assertEquals("Incorrect conversion to kg", expected, converted, 0.001);
	}
	
	@Test
	void convert5PoundToKg() {
		StrengthTraining st = new StrengthTraining();
		double converted = st.convertPoundsToKilograms(5);
		double expected = 2.27;
		Assert.assertEquals("Incorrect conversion to kg", expected, converted, 0.001);
	}
}
