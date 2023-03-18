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
		Assert.assertEquals("test", expected, converted, 0.001);
	}
}
