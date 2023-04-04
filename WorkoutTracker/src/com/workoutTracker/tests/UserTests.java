package com.workoutTracker.tests;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.workoutTracker.User;

public class UserTests {
	
	User user1;
	User user2;
	
	@BeforeEach
	public void setup() {
		user1 = new User("Jane", "Doe", 34, 125);
		user2 = new User("Jim", "Jacks", 24, 162);
	}

	@Test
	void doesUserIdGenerate() {
		int id1 = user1.getUserId();
		Assert.assertTrue(id1 != 0);
	}

	@Test
	void doesUniqueUserIdGenerate() {
		int id1 = user1.getUserId();
		int id2 = user2.getUserId();
		Assert.assertTrue(id1 != id2);
	}

	@Test
	void testForUserConstructor() {
		Assert.assertTrue(user2.getFirstName().equals("Jim"));
		Assert.assertTrue(user2.getLastName().equals("Jacks"));
		Assert.assertTrue(user2.getAge() == 24);
		Assert.assertTrue(user2.getWeightLbs() == 162);
	}
	
	@Test
	void doKilogramsConvertToPounds() {
		Assert.assertTrue("incorrect kg to lb conversion", user1.convertKilogramsToPounds(12) == 26.46);
		Assert.assertTrue("incorrect decimal kg to lb conversion", user1.convertKilogramsToPounds(34.6) == 76.28);
	}
	
	@Test
	void doPoundsConverToKilograms(){
		Assert.assertTrue("incorrect lb to kg conversion", user1.convertPoundsToKilograms(96) == 43.54);
		Assert.assertTrue("incorrect decimal lb to kg conversion", user1.convertPoundsToKilograms(168.47) == 76.42);
	}
	

	

}
