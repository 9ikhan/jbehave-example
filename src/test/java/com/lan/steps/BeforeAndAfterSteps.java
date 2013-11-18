package com.lan.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;

public class BeforeAndAfterSteps {
	
	private WebDriver driver;

	
	public BeforeAndAfterSteps(WebDriver driver) {
		this.driver = driver;
	}
	
	@BeforeScenario
	public void beforeScenario(){
		driver.manage().deleteAllCookies();
	}

	
}
