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

public class RegisterAccountPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=account/register";

	@FindBy(name = "firstname")
	private WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	private WebElement inputLastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;

	@FindBy(id = "input-address-1")
	private WebElement inputAddress;

	@FindBy(id = "input-city")
	private WebElement inputCity;

	@FindBy(id = "input-postcode")
	private WebElement inputPostCode;

	@FindBy(id = "input-country")
	private WebElement inputCountry;

	@FindBy(id = "input-zone")
	private WebElement inputZone;

	@FindBy(id = "input-password")
	private WebElement inputPassword;

	@FindBy(id = "input-confirm")
	private WebElement inputPasswordConfirm;

	@FindBy(name = "agree")
	private WebElement checkboxPrivacyPolicy;

	@FindBy(css = "input[type='submit'][value='Continue']")
	private WebElement buttonContinue;

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);
	String randomEmail = ("username" + randomInt + "@gmail.com");

	public void createNewAccount() {
		inputFirstName.sendKeys("Inga");
		inputLastName.sendKeys("Chamentauskiene");
		inputEmail.sendKeys(randomEmail);
		inputTelephone.sendKeys("862399107");
		inputAddress.sendKeys("S. B. Jundzilo 15");
		inputCity.sendKeys("Vilnius");
		inputPostCode.sendKeys("LT-10256");
		Select dropDownCountry = new Select(inputCountry);
		dropDownCountry.selectByVisibleText("Lithuania");
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-zone")));
		Select dropDownCity = new Select(inputZone);
		dropDownCity.selectByVisibleText("Vilnius");
		MatcherAssert.assertThat("Selected value is not Vilnius", dropDownCity.getFirstSelectedOption().getText(),
				CoreMatchers.is("Vilnius"));
		inputPassword.sendKeys("labas");
		inputPasswordConfirm.sendKeys("labas");
		checkboxPrivacyPolicy.click();
		buttonContinue.click();
	}

}
