package com.trainings.maven.JUnit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

@Category({ FastRunningTests.class })
public class JUnit1stTestPOM extends AbstractTest {
	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test(timeout = 100)
	public void searchFieldCount() {
		mainPage = new MainPage(driver);
		Assert.assertSame("Search Field is not 1", 1, mainPage.countSearchFields());
	}

	@Test
	public void wishList() {
		mainPage = new MainPage(driver);
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				mainPage.getWishListButtonText());
	}

	@Ignore
	@Test
	public void wishListButtonText() {
		mainPage = new MainPage(driver);
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				mainPage.getWishListButtonText());
	}

}
