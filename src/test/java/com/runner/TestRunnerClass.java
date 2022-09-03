 package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources" }, glue = { "com.stepdefenition" })
public class TestRunnerClass {
	
	public void reporting() {

		System.out.println("End of statement");
	}
}
