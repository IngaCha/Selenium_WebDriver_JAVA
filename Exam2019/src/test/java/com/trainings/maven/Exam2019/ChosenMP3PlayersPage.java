package com.trainings.maven.Exam2019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChosenMP3PlayersPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=product/search&search=iPod%20Classic";

	public ChosenMP3PlayersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "product-thumb")
	private WebElement itemMp3Player;

	@FindBy(xpath = "//div[@class = 'alert alert-success']")
	private WebElement messageAlert;

	@FindBy(id = "button-cart")
	private WebElement buttonAddToCart;

	@FindBy(xpath = "//button[@data-original-title = 'Add to Wish List']")
	private WebElement buttonWishList;

	@FindBy(linkText = "MP3 Players")
	private WebElement linkMP3Players;

	@FindBy(id = "cart")
	private WebElement buttonCart;

	public boolean isMP3Visible() {
		return itemMp3Player.isDisplayed();
	}

	public void clickButtonWishList() {
		buttonWishList.click();
	}

	public void clickButtonAddToCart() {
		buttonAddToCart.click();
	}

	public String getTextFromAlert() {
		return messageAlert.getText();
	}

	public boolean isContentContainsMessageYouMustLogin() {
		return messageAlert.getText().contains("You must login");
	}

	public boolean isContentContainsMessageAddToCart() {
		return messageAlert.getText().contains("Success: You have");
	}

	public void clickLinkMP3Players() {
		linkMP3Players.click();
	}

	public String getButtonCartText() {
		return buttonCart.getText();
	}

}
