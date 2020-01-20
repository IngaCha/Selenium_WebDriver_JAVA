package com.trainings.maven.DataPreparation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTestJUnit {

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

}
