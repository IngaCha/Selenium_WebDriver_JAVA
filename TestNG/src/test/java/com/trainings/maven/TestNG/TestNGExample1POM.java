package com.trainings.maven.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExample1POM extends AbstractTest {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test(priority = 0)
	public void assertSearchField() {
		mainPage = new MainPage(driver);
		assertSame(mainPage.countSearchFields(), 1, "Search Field is not 1");
	}

	@Test(priority = 1)
	public void assertWishListButton() {
		mainPage = new MainPage(driver);
		Assert.assertEquals(mainPage.getWishListButtonText(), "Wish List (0)",
				"WishList button does not contain Wishlist");
	}

	@Test(priority = 2)
	public void wishListNotNullText() {
		mainPage = new MainPage(driver);
		assertNotNull(mainPage.getWishListButtonText(), "String is null"); // PASSED, not null, but "Wish List (0)"
	}

	@Test(priority = 3, groups = { "car" })
	public void sendKeys() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.fillNameSurname();
	}

	@Test(priority = 4, groups = { "car" })
	public void assertDropdown() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertNotSame(registerAccountPage.getInputCountryText(), "Seychelles", "Values are the same");

	}

	@Test(priority = 5)
	public void assertAgreeCheckbox() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertFalse(registerAccountPage.isAgreeFieldSelected(), "Agree field is selected");
	}

	@Test(priority = 6)
	public void assertNullExample() {
		assertNull(null, "String is not null");// PASSED got null
	}

}
