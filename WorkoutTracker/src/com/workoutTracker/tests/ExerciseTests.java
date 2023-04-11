package com.workoutTracker.tests;

import java.time.LocalDate;
import java.time.LocalTime;

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
	
	@Test
	void calculatePace1MPH() {
		Assert.assertTrue("Incorrect pace calculation 00:15:00", run.calculatePace(4.0).equals(LocalTime.of(0, 15, 0)));
	}
	
	@Test
	void calculatePaceInteger(){
		Assert.assertTrue("Incorrect pace calculation 00:08:34)", run.calculatePace(7).equals(LocalTime.of(0, 8, 34)));
	}
	
	@Test
	void calculatePaceDecimal() {
		Assert.assertTrue("Incorrect pace calculation 00:13:20", run.calculatePace(4.5).equals(LocalTime.of(0, 13, 20)));
	}
}
