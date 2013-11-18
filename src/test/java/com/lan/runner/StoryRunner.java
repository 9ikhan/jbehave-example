package com.lan.runner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parameterized.class)
public class StoryRunner {

	public WebDriver driver;
	public final String url = "http://<browserstack-user>:<browserstack-key>@hub.browserstack.com/wd/hub/";
	public String os;
	public String osVersion;
	public String browser;
	public String browserVersion;

	public StoryRunner(String os, String osVersion, String browser,
			String browserVersion) {
		this.os = os;
		this.osVersion = osVersion;
		this.browser = browser;
		this.browserVersion = browserVersion;
	}

	@Before
	public void setUp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("os", os);
		dc.setCapability("os_version", osVersion);
		dc.setCapability("browser", browser);
		dc.setCapability("browser_version", browserVersion);
		dc.setCapability("browserstack.debug", "true");
		dc.setCapability("build", "jbehave_tests_lan_com");
		try {
			driver = new RemoteWebDriver(new URL(url), dc);
		} catch (MalformedURLException e) {
			System.err.println("Exception in url: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "windows", "7", "chrome", "29.0" },
				{ "windows", "xp", "firefox", "23.0" } };
		return Arrays.asList(data);
	}

	@Test
	public void runStories() {
		Embedder storyEmbedder = new StoryEmbedder(driver);
		List<String> storyPaths = Arrays.asList("country_selector.story");
		storyEmbedder.runStoriesAsPaths(storyPaths);
	}

}
