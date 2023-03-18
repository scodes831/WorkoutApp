package com.workoutTracker.tests;

import org.junit.jupiter.api.Test;

import com.workoutTracker.Run;

import org.junit.Assert;

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
}
