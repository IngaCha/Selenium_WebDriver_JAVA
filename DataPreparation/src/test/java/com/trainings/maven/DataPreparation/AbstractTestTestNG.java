package com.trainings.maven.DataPreparation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTestTestNG {

	protected static WebDriver driver;

	@BeforeTest(alwaysRun = true) // for group running
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterTest(alwaysRun = true) // for group running
	public static void closeBrowser() {
		driver.quit();
	}

}
