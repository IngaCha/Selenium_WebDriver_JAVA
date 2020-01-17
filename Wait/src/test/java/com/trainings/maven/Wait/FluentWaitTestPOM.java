package com.trainings.maven.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FluentWaitTestPOM extends AbstractTest {

	MainPage mainPage;

	@Test
	public void somethingUseless() {
		mainPage = new MainPage(driver);
		System.out.println(mainPage.isImgDisplayed());
	}

	@Test
	public void logoAppearanceTest() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		WebElement burgerKing = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Burger King']")));

		Assert.assertTrue(burgerKing.isDisplayed());

	}

}
