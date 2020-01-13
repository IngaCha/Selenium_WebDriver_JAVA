package com.trainings.maven.BasicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * 
 * VERSION WITH BEST PRACTISES APPLIED IS IN TEST FOLDER.
 * 
 */

public class BasicSelenium {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		// WebDriver ieDriver = new InternetExplorerDriver();
		// WebDriver ffDriver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
		WebElement searchElement = driver.findElement(By.name("search"));
		String productName = "MaxBook";
		searchElement.sendKeys(productName);
		driver.findElement(By.className("input-group-btn")).click();
		System.out.println(driver.findElement(By.id("button-search")).isDisplayed());
		System.out.println(driver.findElements(By.name("search")).size());
		driver.findElement(By.name("search")).clear(); // Session crashes. Define element again.
		driver.findElement(By.name("search")).sendKeys("MacBook");
		driver.findElement(By.className("input-group-btn")).click();
		Select dropDown = new Select(driver.findElement(By.id("input-sort")));
		dropDown.selectByVisibleText("Price (High > Low)");
		// Alternatively:
		// dropDown.selectByIndex(4);
		// dropDown.selectByValue("http://akademijait.vtmc.lt/opencartone/index.php?route=product/search&sort=p.price&order=DESC&search=MacBook");
		dropDown = new Select(driver.findElement(By.id("input-sort")));// Session crashes. Developers should fix this
																		// bug: do not reload page when select something
																		// from dropdown
		System.out.println(dropDown.getFirstSelectedOption().getText());
		driver.quit();

	}
}
