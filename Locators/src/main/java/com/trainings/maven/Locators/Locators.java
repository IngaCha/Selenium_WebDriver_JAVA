package com.trainings.maven.Locators;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 
 * 	 By.id
 * 	 By.name
 * 	 By.linkText
 * 	 By.partialLinkText
 * 	 By.tagName
 * 	 By.className
 * 
 * 	 Version with best practices applied is in test folder.
 * 
 */

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");

		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.name("firstname")).sendKeys("Inga");
		driver.findElement(By.id("input-lastname")).sendKeys("Chamentauskiene");

		// random email
		WebElement emailText = driver.findElement(By.id("input-email"));
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailText.sendKeys("username" + randomInt + "@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("862399107");
		driver.findElement(By.id("input-address-1")).sendKeys("S. B. Jundzilo 15");
		driver.findElement(By.id("input-city")).sendKeys("Vilnius");
		driver.findElement(By.id("input-postcode")).sendKeys("LT-10256");

		// DropDown Country
		Select dropDownCountry = new Select(driver.findElement(By.id("input-country")));
		dropDownCountry.selectByVisibleText("Lithuania");

		// Explicit wait. Expected Conditions
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-zone")));

		// DropDown City
		Select dropDownCity = new Select(driver.findElement(By.id("input-zone")));
		dropDownCity.selectByVisibleText("Vilnius");

		driver.findElement(By.id("input-password")).sendKeys("labas");
		driver.findElement(By.id("input-confirm")).sendKeys("labas");

		WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1'] "));
		newsletterYes.click();
		// Open and Close Privacy Policy
		driver.findElement(By.partialLinkText("Privacy")).click();
		// Explicit wait. Expected Conditions
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button'][@class='close']")));
		driver.findElement(By.xpath("//button[@type='button'][@class='close']")).click();

		// Is Selected
		WebElement agree = driver.findElement(By.name("agree"));
		System.out.println(agree.isSelected());
		agree.click();

		// Count of input fields 14 //better find with xpath, it's easier
		System.out.println(driver.findElement(By.id("content")).findElements(By.className("form-control")).size());

		// Count Your Address input fields 7
		System.out.println(driver.findElements(By.xpath("//fieldset[@id='address']/div")).size());

		// Count Your Address Select fields 2
		System.out.println(driver.findElements(By.xpath("//fieldset[@id='address']/div//select")).size());

		// Count all elements with class attribute 'form-control' 15
		System.out.println(driver.findElements(By.className("form-control")).size());

		// Count all fieldsets (Your Personal Details, Your Address, Your Password,
		// Newsletter)
		System.out.println(driver.findElements(By.tagName("fieldset")).size());

		// CSS (submit button)
		WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit'][value='Continue']"));
		// Xpath (submit button)
		// WebElement continueButton =
		// driver.findElement(By.xpath("//input[@type='submit'][@value='Continue'] "));
		continueButton.click();

		driver.close();

	}

}
