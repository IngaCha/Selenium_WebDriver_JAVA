package com.trainings.maven.Assertions;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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

	@Test
	public void assertSearchField() {
		mainPage = new MainPage(driver);
		Assert.assertSame("Search Field is not 1", 1, mainPage.countSearchFields());

	}

	@Test
	public void assertWishListButton() {
		mainPage = new MainPage(driver);
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				mainPage.getWishListButtonText());

	}

	@Test
	public void assertShoppingCart() {
		mainPage = new MainPage(driver);
		assertThat(mainPage.isShoppingCartDisplayed(), is(not(equalTo(false))));

	}

	@Test
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

	@Test
	// meant to fail
	public void assertSelectedValueIsEqualToAmericanSamoa() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertThat("Selected value is not American Samoa", registerAccountPage.getInputCountryText(),
				is(equalTo("AmericanSamoa")));
	}

	@Test
	// meant to fail
	public void assertSelectedValueContainsAlg() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertThat("Country dropdown doesn’t contain Alg", registerAccountPage.getInputCountryText(),
				containsString("Alg"));
	}

	@Test
	public void assertPasswordFieldIsEnabled() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertTrue("Search box is not enabled", registerAccountPage.isPasswordFieldEnabled());
	}

	@Test
	public void assertTextIsPolicyORContainsPrivacy() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertThat(registerAccountPage.getPrivacyPolicyLinkText(), anyOf(is("Policy"), containsString("Privacy")));
	}

	@Test
	public void assertTextContainsPolicyANDContainsPrivacy() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		assertThat(registerAccountPage.getPrivacyPolicyLinkText(),
				allOf(containsString("Policy"), containsString("Privacy")));
	}

	@Test
	public void assertAgreeFieldIsSelected() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertFalse("Agree field is selected", registerAccountPage.isAgreeFieldSelected());
	}

	@Test
	public void assertInputFieldNumber() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertSame("Input fields number is not 14", 14, registerAccountPage.getFieldsInputFieldCount());
	}

	@Test
	public void assertAddressFieldNumber() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertSame("Your address fields number is not 7", 7, registerAccountPage.getAddressFieldCount());
	}

	@Test
	public void assertAddressSelectFieldNumber() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertSame("Your address select fields number is not 2", 2,
				registerAccountPage.getAddressSelectInputFieldCount());
	}

	@Test
	public void assertFormControlFieldNumber() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		Assert.assertNotSame("Elements with class attribute 'form-control' number is 16, not 15", 16,
				registerAccountPage.getClassAttributeFormControlFieldCount());
	}

}
