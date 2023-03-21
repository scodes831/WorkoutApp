package com.workoutTracker.tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.workoutTracker.UserManager;

public class UserManagerTests {
	
	@Test
	void newUserGetsAdded() {
		UserManager userManager = new UserManager();
		userManager.addNewUser("Jessica", "Green", 29, 138);
		Assert.assertTrue("user is not added to list", userManager.getUsers().size() == 1);
	}

}
