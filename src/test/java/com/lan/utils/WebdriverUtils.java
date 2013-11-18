package com.lan.utils;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {

	public static WebElement getClickableElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,
				CustomTimeouts.WEBELEMENT_TIMOUT);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));
		return element;
	}
	
	public static WebElement getVisibleElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,
				CustomTimeouts.WEBELEMENT_TIMOUT);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return element;
	}

	public static File getScreenshot(WebDriver driver){
		Augmenter augmentor = new Augmenter();
		WebDriver augmentedDriver = augmentor.augment(driver);
		return ( (TakesScreenshot)augmentedDriver ).getScreenshotAs(OutputType.FILE);
	}

}
