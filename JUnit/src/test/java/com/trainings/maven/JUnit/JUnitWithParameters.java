package com.trainings.maven.JUnit;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class JUnitWithParameters {

	String name;
	private static WebDriver driver;

	// constructor
	public JUnitWithParameters(String name) {
		this.name = name;
	}

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}

	@Parameters
	public static List<String> input() {
		return Arrays.asList("Inga", "Tomas", "Blavla");
	}

	@Test
	public void parameterizeName() throws InterruptedException {
		driver.findElement(By.name("firstname")).sendKeys(name);
		driver.findElement(By.name("firstname")).clear();
	}

}
