package com.flipkart.stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	private void beforeMethod() {
		System.out.println("Before Scenario");
	}
	
	@After
	private void afterMethod() {
		System.out.println("After Scenario");
	}
}
