package com.trainings.maven.TestNG;

import static org.testng.Assert.assertSame;

import org.testng.annotations.Test;

public class TestNGExample2POM extends AbstractTest {

	MainPage mainPage;

	@Test(priority = 0)
	public void assertSearchField() {
		mainPage = new MainPage(driver);
		assertSame(mainPage.countSearchFields(), 1, "Search Field is not 1");
	}

}
