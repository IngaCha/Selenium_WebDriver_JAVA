package com.trainings.maven.Wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotYourPasswordPage extends AbstractPage {

	public String URL = "https://demo.opencart.com/index.php?route=account/forgotten";

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement buttonContinue;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertWarning;

	public ForgotYourPasswordPage(WebDriver driver) {
		super(driver);
	}

	public void sendInputEmail() {
		inputEmail.sendKeys("blablabla");
	}

	public void clickButtonContinue() {
		buttonContinue.click();
	}

	public boolean alertContainsWarning() {
		return alertWarning.getText().contains("Warning");
	}

}
