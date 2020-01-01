package com.trainings.maven.ichamentauskiene;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * This is first version. Version with best practices applied is in test folder.
 *
 */
public class FirstTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
		driver.quit();
	}
}
