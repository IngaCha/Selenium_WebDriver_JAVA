package com.trainings.maven.Exam2019;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewAccountTest extends AbstractTest {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;
	AccountCreatedPage accountCreatedPage;
	EditAccountPage editAccountPage;

	@Test
	public void createNewAccount() throws IOException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.createNewAccount();
		accountCreatedPage = new AccountCreatedPage(driver);
		Assert.assertTrue(accountCreatedPage.isContentContainsMessage());
		accountCreatedPage.clickLinkEditAccount();
		editAccountPage = new EditAccountPage(driver);
		Assert.assertEquals(editAccountPage.getNameFromInput(), "Inga", "Name is incorrect");
		Assert.assertEquals(editAccountPage.getLastNameFromInput(), "Chamentauskiene", "Last Name is incorrect");
		Assert.assertEquals(editAccountPage.getEmailFromInput(), registerAccountPage.randomEmail, "Email is incorrect");
		Assert.assertEquals(editAccountPage.getTelephoneFromInput(), "862399107", "Telephone is incorrect");

	}

}
