package com.trainings.maven.Exam2019;

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

	@FindBy(linkText = "MP3 Players")
	private WebElement linkMP3Players;

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

	public void clickLinkMP3Players() {
		linkMP3Players.click();
	}

}
