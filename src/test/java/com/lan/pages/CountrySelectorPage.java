package com.lan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lan.utils.WebdriverUtils;

public class CountrySelectorPage extends BasePage{

	private WebDriver driver;
	
	public CountrySelectorPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public HomePage selectCountry(String country){
		By locator = By.linkText(country);
		WebElement countryLink = WebdriverUtils.getClickableElement(driver, locator);
		countryLink.click();
		return new HomePage(driver);
	}	

}
