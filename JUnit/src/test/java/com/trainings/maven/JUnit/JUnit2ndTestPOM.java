package com.trainings.maven.JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

public class JUnit2ndTestPOM extends AbstractTest {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test
	public void searchFieldCount2() {
		mainPage = new MainPage(driver);
		Assert.assertSame("Search Field is not 1", 1, mainPage.countSearchFields());
	}

	@Test
	@Category({ FastRunningTests.class })
	public void wishList2() {
		mainPage = new MainPage(driver);
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				mainPage.getWishListButtonText());
	}

	@Test
	public void wishListButtonText() {
		mainPage = new MainPage(driver);
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				mainPage.getWishListButtonText());
	}

}
