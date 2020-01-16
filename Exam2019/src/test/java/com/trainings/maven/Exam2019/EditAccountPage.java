package com.trainings.maven.Exam2019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=account/edit";

	public EditAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "firstname")
	private WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	private WebElement inputLastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;

	public String getNameFromInput() {
		return inputFirstName.getAttribute("value");
	}

	public String getLastNameFromInput() {
		return inputLastName.getAttribute("value");
	}

	public String getEmailFromInput() {
		return inputEmail.getAttribute("value");
	}

	public String getTelephoneFromInput() {
		return inputTelephone.getAttribute("value");
	}

}
