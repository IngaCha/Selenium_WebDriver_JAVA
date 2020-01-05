package com.trainings.maven.Vinted;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * 
 * Version with best practices applied is in test folder.
 * 
 */

public class VintedHomework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions(); // to open browser full screen
		options.addArguments("--start-maximized"); // to open browser full screen
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.vinted.lt/");
		// Moteriški
		WebElement navElement = driver.findElement(By.linkText("Moteriški"));
		navElement.click();
		// Aksesuarai
		WebElement navElement2 = driver.findElement(By.xpath("//a[@href='/moteriski/moteriski-aksesuarai']"));
		navElement2.click();
		// Skėčiai
		WebElement navElement3 = driver.findElement(By.xpath("//a[@href='/moteriski/skeciai']"));
		navElement3.click();
		// Spalva
		WebElement selectElement = driver.findElement(By.xpath("//span[contains(text(), 'Spalva')]"));
		selectElement.click();
		// Check if 'Juoda' is selected
		WebElement checkIfMarked = driver.findElement(By
				.xpath("//div[contains(@class, 'c-cell') and contains(.//span, 'Juoda')]//input[@type = 'checkbox']"));
		System.out.println(checkIfMarked.isSelected());
		// Juoda
		WebElement blackElement = driver
				.findElement(By.xpath("//div[@class='u-overflow-auto']//span[@class='c-checkbox__button']"));
		blackElement.click();
		// Kaina
		WebElement priceElement = driver.findElement(By.xpath("//span[contains(.//span, 'Kaina')]"));
		priceElement.click();
		// Kaina nuo 6
		driver.findElement(By.id("price_from")).sendKeys("6");
		// Kaina iki 10
		WebElement priceTo = driver.findElement(By.id("price_to"));
		priceTo.sendKeys("10");
		priceTo.sendKeys(Keys.TAB);
		// Click outside form
		WebElement title = driver.findElement(By.xpath("//h1[contains(text(), 'Skėčiai')]"));
		title.click();
		selectElement.click();
		// Defined again to avoid stale element ref. NOTE: isSelected works ONLY with input tag!!!
		checkIfMarked = driver.findElement(By
				.xpath("//div[contains(@class, 'c-cell') and contains(.//span, 'Juoda')]//input[@type = 'checkbox']"));
		System.out.println(checkIfMarked.isSelected());
		// Closing browser
		driver.close();

	}

}
