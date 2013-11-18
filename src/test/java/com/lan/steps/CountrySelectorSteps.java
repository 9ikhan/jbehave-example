package com.lan.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.lan.pages.CountrySelectorPage;
import com.lan.pages.HomePage;
import com.lan.utils.JavaUtils;

public class CountrySelectorSteps {

	private CountrySelectorPage countrySelectorPage;
	private HomePage homePage;

	public CountrySelectorSteps(WebDriver driver) {
		countrySelectorPage = new CountrySelectorPage(driver);
	}
	
	@Given("I am on Country Selector Page")
	public void openCountrySelectorPage() {
		String url = JavaUtils.getValfromTestDataBundle("country.selector.page.url");
		countrySelectorPage.open(url);
	}

	@When("I select $country")
	public void selectCountry(String country) {
		homePage = countrySelectorPage.selectCountry(country);
	}

	@Then("$country should be in the top navigation of the Home page")
	public void countryShouldBeInTopNav(String country) {
		String actual = homePage.getSelectedCountry();
		if (!actual.equals(country)) {
			Assert.fail("Actual: " + actual + " Expected: " + country);
		}
	}

}
