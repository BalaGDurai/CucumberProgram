package com.flipkart.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\MobileValidation.feature",
				 glue="com.flipkart.stepdefinition",monochrome=true,
				 plugin="html:C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target.MobileValidation")

public class TestRunner {

}
