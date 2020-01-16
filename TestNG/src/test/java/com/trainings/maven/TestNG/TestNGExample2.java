package com.trainings.maven.TestNG;

import static org.testng.Assert.assertSame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample2 {
	private static WebDriver driver;

	@BeforeTest(alwaysRun = true) // for group running
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterTest(alwaysRun = true) // for group running
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	public void searchFieldCount2() {
		assertSame(driver.findElements(By.id("search")).size(), 1, "Search Field is not 1");
	}

}
