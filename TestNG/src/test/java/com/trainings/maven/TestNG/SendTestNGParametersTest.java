package com.trainings.maven.TestNG;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//TestNG
//assertFalse(Boolean test, String message)
//assertNull(Object object, String message)
//assertNotNull(Object object , String message)
//assertEquals(Object expected, Object actual , String message)
//assertSame(Object expected, Object actual , String message)
//assertNotSame(Object expected, Object actual , String message)

public class SendTestNGParametersTest {
	private static WebDriver driver;

	@BeforeTest
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterTest
	public static void closeBrowser() {
		driver.close();
	}

	@Test(priority = 0)
	@Parameters({ "name", "surname" })
	public void sendKeys(String name, String surname) {
		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.name("firstname")).sendKeys(name);
		driver.findElement(By.id("input-lastname")).sendKeys(surname);
	}

	@Test(priority = 1)
	public void assertDropdown() {
		Select dropDownCountry = new Select(driver.findElement(By.id("input-country")));
		dropDownCountry.selectByVisibleText("Lithuania");
		MatcherAssert.assertThat("Selected value is not Seychelles", dropDownCountry.getFirstSelectedOption().getText(),
				CoreMatchers.is("Seychelles"));

	}

}
