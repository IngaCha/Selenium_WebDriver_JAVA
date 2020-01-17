package com.trainings.maven.JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Category({ FastRunningTests.class })
public class JUnit1stTest {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}

	@Before
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@After
	public void afterMethod() {
		System.out.println("After Method");
	}

	@Test(timeout = 100)
	public void searchFieldCount() {
		Assert.assertSame("Search Field is not 1", 1, driver.findElements(By.id("search")).size());
	}

	@Test
	public void wishList() {
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"));
	}

	@Ignore
	@Test
	public void wishListButtonText() {
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"));
	}

}
