package com.trainings.maven.Wait;

import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=account/register";

	@FindBy(name = "firstname")
	WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	WebElement inputLastName;

	@FindBy(id = "input-country")
	private WebElement inputCountry;

	@FindBy(name = "agree")
	private WebElement checkboxPrivacyPolicy;

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}

	public void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);

			}
		});
	}

	public void fillNameSurname() {
		inputFirstName.sendKeys("Inga");
		inputLastName.sendKeys("Chamentauskiene");
	}

	public Boolean isAgreeFieldSelected() {
		return checkboxPrivacyPolicy.isSelected();
	}

	public String getInputCountryText() {
		Select dropDownCountry = new Select(inputCountry);
		dropDownCountry.selectByVisibleText("Lithuania");
		return dropDownCountry.getFirstSelectedOption().getText();
	}

}
