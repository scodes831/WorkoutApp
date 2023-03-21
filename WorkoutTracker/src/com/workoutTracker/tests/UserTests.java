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
		Assert.assertTrue(user1.getFirstName().equals("Jim"));
		Assert.assertTrue(user1.getLastName().equals("Jacks"));
		Assert.assertTrue(user1.getAge() == 24);
		Assert.assertTrue(user1.getWeightLbs() == 162);
	}

	

	

}
