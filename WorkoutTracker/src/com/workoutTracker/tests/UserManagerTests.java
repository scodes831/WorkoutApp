package com.workoutTracker.tests;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.workoutTracker.UserManager;

public class UserManagerTests {
	
	UserManager userManager;
	ArrayList<Object> user1;
	ArrayList<Object> user2;
	
	@BeforeEach
	public void setup() {
		userManager = new UserManager();
		user1 = new ArrayList<Object>();
		user1.add("Jessica");
		user1.add("Green");
		user1.add(29);
		user1.add(138.0);
		
		user2 = new ArrayList<Object>();
		user2.add("Henry");
		user2.add("Smith");
		user2.add(34);
		user2.add(178.4);
	}
	
	@Test
	void newUserGetsAdded() {
		userManager.addNewUser(user1);
		Assert.assertTrue("user is not added to list", userManager.getUsers().size() == 1);
	}
	
	@Test
	void getCorrectUserByUserId() {
		userManager.addNewUser(user1);
		userManager.addNewUser(user2);
		Assert.assertTrue("userId is not found", userManager.getUserById(userManager, 1002).getFirstName().equals("Henry"));
	}
	
}
