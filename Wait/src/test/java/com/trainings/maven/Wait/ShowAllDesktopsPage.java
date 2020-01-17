package com.trainings.maven.Wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowAllDesktopsPage extends AbstractPage {

	@FindBy(xpath = "//div[contains(@class, 'product-thumb') and contains(.//h4, 'iPhone')]//button[contains(.//span, 'Add to Cart')]")
	private WebElement linkAddiPhone;

	@FindBy(xpath = "//div[contains(@class, 'product-thumb') and contains(.//h4, 'MacBook')]//button[contains(.//span, 'Add to Cart')]")
	private WebElement linkAddMacBook;

	@FindBy(xpath = "//div[contains(@class, 'product-thumb') and contains(.//h4, 'Sony VAIO')]//button[contains(.//span, 'Add to Cart')]")
	private WebElement linkAddSony;

	@FindBy(id = "cart")
	private WebElement buttonCart;

	@FindBy(xpath = "//button[@title='Remove']")
	private WebElement buttonRemove;

	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement buttonCartTotal;

	public ShowAllDesktopsPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkAddiPhone() {
		linkAddiPhone.click();
	}

	public void clickLinkAddMacBook() {
		linkAddMacBook.click();
	}

	public void clickLinkAddSony() {
		linkAddSony.click();
	}

	public void clickButtonCart() {
		buttonCart.click();
	}

	public void clickButtonRemove() {
		buttonRemove.click();
	}

	public String getButtonCartTotalText() {
		return buttonCartTotal.getText();
	}

}
