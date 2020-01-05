package com.trainings.maven.Vinted;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UmbrellasPage extends AbstractPage {

	public UmbrellasPage(WebDriver driver) {
		super(driver);
	}

	// links
	@FindBy(xpath = "//span[contains(text(), 'Spalva')]")
	private WebElement linkSpalva;
	@FindBy(xpath = "//span[contains(.//span, 'Kaina')]")
	private WebElement linkKaina;

	// element
	@FindBy(xpath = "//div[contains(@class, 'c-cell') and contains(.//span,'Juoda')]//label[contains(@class, 'c-checkbox')]")
	private WebElement elementBlack;

	// checkbox
	@FindBy(xpath = "//div[contains(@class, 'c-cell') and contains(.//span, 'Juoda')]//input[@type = 'checkbox']")
	private WebElement checkboxBlack;

	// input fields
	@FindBy(id = "price_from")
	private WebElement inputPriceFrom;
	@FindBy(id = "price_to")
	private WebElement inputPriceTo;

	// title
	@FindBy(xpath = "//h1[contains(text(), 'Skėčiai')]")
	private WebElement title;

	public void clickLinkSpalva() {
		linkSpalva.click();
	}

	public void checkIfCheckboxBlackIsChecked() {
		System.out.println(checkboxBlack.isSelected());
	}

	public void clickElementBlack() {
		elementBlack.click();
	}

	public void clickLinkKaina() {
		linkKaina.click();
	}

	public void sendPriceFrom() {
		inputPriceFrom.sendKeys("6");
	}

	public void sendPriceTo() {
		inputPriceTo.sendKeys("10");
		inputPriceTo.sendKeys(Keys.TAB);
	}

	public void clickTitle() {
		title.click();
	}

}
