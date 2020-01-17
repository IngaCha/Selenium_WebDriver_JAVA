package com.trainings.maven.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FluentWaitTest {

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

	@Test
	public void somethingUseless() {
		System.out.println(driver.findElement(By.xpath("//img[@alt='Burger King']")).isDisplayed());
	}

	@Test
	public void logoAppearanceTest() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

// Does not work
//		WebElement alertElement = wait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath("//img[@alt='Burger King']"));
//			}
//		});
//		Assert.assertTrue(alertElement.isDisplayed());

		WebElement burgerKing = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Burger King']")));

		Assert.assertTrue(burgerKing.isDisplayed());

	}

}
