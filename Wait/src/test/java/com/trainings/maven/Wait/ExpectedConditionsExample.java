package com.trainings.maven.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpectedConditionsExample {
	private static WebDriver driver;

	@BeforeTest
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
	}

	@AfterTest
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	public void assertErrorMessage() throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Forgotten Password")).click();
		driver.findElement(By.id("input-email")).sendKeys("blabla");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Wait. Expected Conditions. 2 working examples:
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")), "Warning"));
		// Assertion. Meant to fail.
		Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText().contains("Warning"), "text contains warning");

	}

}
