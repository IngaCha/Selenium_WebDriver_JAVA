package com.trainings.maven.JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTest {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt/opencartone/");

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

	@Before
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@After
	public void afterMethod() {
		System.out.println("After Method");
	}

}
