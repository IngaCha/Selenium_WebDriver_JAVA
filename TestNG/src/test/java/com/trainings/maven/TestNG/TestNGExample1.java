package com.trainings.maven.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//TestNG
//assertFalse(Boolean test, String message)
//assertNull(Object actual, String message)
//assertNotNull(Object actual , String message)
//assertEquals(Object actual, Object expected , String message)
//assertSame(Object actual, Object expected , String message)
//assertNotSame(Object actual, Object expected , String message)

public class TestNGExample1 {
	private static WebDriver driver;

	@BeforeTest(alwaysRun = true) // for group running
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterTest(alwaysRun = true) // for group running
	public static void closeBrowser() {
		driver.quit();
	}

	@Test(priority = 0)
	public void searchFieldCount() {
		assertSame(driver.findElements(By.id("search")).size(), 1, "Search Field is not 1");
	}

	@Test(priority = 1)
	public void wishListContainsText() {
		assertEquals(driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"), "Wish List (0)",
				"WishList button does not contain Wishlist");
	}

	@Test(priority = 2)
	public void wishListNotNullText() {
		assertNotNull(driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"),
				"String is null"); // PASSED, not null, but "Wish List (0)"
	}

	@Test(priority = 3, groups = { "car" })
	public void sendKeys() {

		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.name("firstname")).sendKeys("Inga");
		driver.findElement(By.id("input-lastname")).sendKeys("Chamentauskiene");
	}

	@Test(priority = 4, groups = { "car" })
	public void assertDropdown() {
		Select dropDownCountry = new Select(driver.findElement(By.id("input-country")));
		dropDownCountry.selectByVisibleText("Lithuania");
		assertNotSame(dropDownCountry.getFirstSelectedOption().getText(), "Seychelles", "Values are the same");

	}

	@Test(priority = 5)
	public void assertAgreeCheckbox() {
		WebElement agree = driver.findElement(By.name("agree"));
		assertFalse(agree.isSelected(), "Agree field is selected");
	}

	@Test(priority = 6)
	public void assertNullExample() {
		assertNull(null, "String is not null");// PASSED got null
	}

}
