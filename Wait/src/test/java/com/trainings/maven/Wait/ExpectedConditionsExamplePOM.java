package com.trainings.maven.Wait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpectedConditionsExamplePOM extends AbstractTest {

	MainPage mainPage;
	ForgotYourPasswordPage forgotYourPasswordPage;

	@Test
	public void assertErrorMessage() throws InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkForgottenPassword();
		forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
		forgotYourPasswordPage.sendInputEmail();
		forgotYourPasswordPage.clickButtonContinue();
		// Wait. Expected Conditions. 2 working examples:
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		wait.until(ExpectedConditions.textToBePresentInElement(forgotYourPasswordPage.alertWarning, "Warning"));
		// Assertion
		Assert.assertFalse(forgotYourPasswordPage.alertContainsWarning(), "text contains warning");

	}

}
