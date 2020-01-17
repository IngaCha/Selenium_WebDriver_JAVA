package com.trainings.maven.JUnit;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=account/register";

	// inputs
	@FindBy(name = "firstname")
	WebElement inputFirstName;

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

	// buttons
	@FindBy(xpath = "//input[@name='newsletter'][@value='1'] ")
	private WebElement buttonNewsletterYes;

	@FindBy(xpath = "//button[@type='button'][@class='close']")
	private WebElement buttonClosePrivacyPolicy;

	@FindBy(css = "input[type='submit'][value='Continue']")
	private WebElement buttonContinue;

	// links
	@FindBy(partialLinkText = "Privacy")
	private WebElement linkPrivacyPolicy;

	// checkboxes
	@FindBy(name = "agree")
	private WebElement checkboxPrivacyPolicy;

	// fields
	@FindAll(@FindBy(xpath = "//fieldset[@id='address']/div"))
	List<WebElement> fieldsAddressInput;

	@FindAll(@FindBy(xpath = "//fieldset[@id='address']/div//select"))
	List<WebElement> fieldsAddressSelectInput;

	@FindAll(@FindBy(className = "form-control"))
	List<WebElement> fieldsClassAttributeFormControl;

	@FindAll(@FindBy(tagName = "fieldset"))
	List<WebElement> fieldsTagNameFieldset;

	@FindAll(@FindBy(xpath = "//div[@id='content']//input[@class='form-control'] | //div[@id='content']//select[@class='form-control']"))
	List<WebElement> fieldsInput;

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}

	public void createNewAccount() {
		inputFirstName.sendKeys("Inga");
		inputLastName.sendKeys("Chamentauskiene");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		inputEmail.sendKeys("username" + randomInt + "@gmail.com");
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
		inputPassword.sendKeys("labas");
		inputPasswordConfirm.sendKeys("labas");
		buttonNewsletterYes.click();
		linkPrivacyPolicy.click();
		waitForJavascript(driver);
		buttonClosePrivacyPolicy.click();
		checkboxPrivacyPolicy.click();
		buttonContinue.click();
	}

	public void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);

			}
		});
	}

	public void countFields() {
		System.out.println("Address Fields: " + getAddressFieldCount());
		System.out.println("Address Select Fields: " + getAddressSelectInputFieldCount());
		System.out.println("Class Attribute Form Control Fields: " + getClassAttributeFormControlFieldCount());
		System.out.println("Tag Name Fieldset Fields: " + getTagNameFieldsetFieldCount());
		System.out.println("Input Fields: " + getFieldsInputFieldCount());
	}

	public int getAddressFieldCount() {
		return fieldsAddressInput.size();
	}

	public int getAddressSelectInputFieldCount() {
		return fieldsAddressSelectInput.size();
	}

	public int getClassAttributeFormControlFieldCount() {
		return fieldsClassAttributeFormControl.size();
	}

	public int getTagNameFieldsetFieldCount() {
		return fieldsTagNameFieldset.size();
	}

	public int getFieldsInputFieldCount() {
		return fieldsInput.size();
	}

	public String getInputCountryText() {
		Select dropDownCountry = new Select(inputCountry);
		dropDownCountry.selectByVisibleText("Lithuania");
		return dropDownCountry.getFirstSelectedOption().getText();
	}

	public Boolean isPasswordFieldEnabled() {
		return inputPassword.isEnabled();
	}

	public String getPrivacyPolicyLinkText() {
		return linkPrivacyPolicy.getText();
	}

	public Boolean isAgreeFieldSelected() {
		return checkboxPrivacyPolicy.isSelected();
	}

}
