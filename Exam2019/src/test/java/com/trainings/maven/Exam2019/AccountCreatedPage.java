package com.trainings.maven.Exam2019;

import java.util.Random;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=account/success";

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "content")
	private WebElement contentSuccess;

	@FindBy(linkText = "Edit Account")
	private WebElement linkEditAccount;

	public boolean isContentContainsMessage() {
		return contentSuccess.getText().contains("Your Account Has Been Created!");
	}

	public void clickLinkEditAccount() {
		linkEditAccount.click();
	}

}
