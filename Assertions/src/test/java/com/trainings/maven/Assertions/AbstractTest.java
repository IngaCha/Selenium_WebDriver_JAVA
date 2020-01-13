package com.trainings.maven.Assertions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTest {

	protected static WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt/opencartone/");

	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
