package com.trainings.maven.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/";

	@FindBy(xpath = "//div[@id='top-links']//a[@title='My Account']")
	private WebElement linkMyAccount;

	@FindBy(linkText = "Login")
	private WebElement linkLogin;

	@FindBy(linkText = "Continue")
	private WebElement linkContinue;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkMyAccount() {
		linkMyAccount.click();
	}

	public void clickLinkLogin() {
		linkLogin.click();
	}

	public void clickLinkContinue() {
		linkContinue.click();
	}

}
