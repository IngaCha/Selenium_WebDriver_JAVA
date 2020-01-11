package com.trainings.maven.Locators;

import org.testng.annotations.Test;
import java.io.IOException;

public class CreateNewAccountTest extends AbstractTest {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test
	public void createNewAccount() throws IOException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.countFields();
		registerAccountPage.createNewAccount();
		registerAccountPage.waitForJavascript(driver);

	}

}
