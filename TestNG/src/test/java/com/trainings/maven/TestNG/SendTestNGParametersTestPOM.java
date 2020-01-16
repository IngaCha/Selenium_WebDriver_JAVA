package com.trainings.maven.TestNG;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendTestNGParametersTestPOM extends AbstractTest {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test(priority = 0)
	@Parameters({ "name", "surname" })
	public void createNewAccount(String name, String surname) {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.inputFirstName.sendKeys(name);
		registerAccountPage.inputLastName.sendKeys(surname);

	}

	@Test(priority = 1)
	// meant to fail
	public void assertSelectedValueIsSeychelles() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		MatcherAssert.assertThat("Selected value is not Seychelles", registerAccountPage.getInputCountryText(),
				CoreMatchers.is("Seychelles"));
	}

}
