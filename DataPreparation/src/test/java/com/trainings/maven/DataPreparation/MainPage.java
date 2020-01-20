package com.trainings.maven.DataPreparation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/";

	@FindBy(xpath = "//div[@id='top-links']//a[@title='My Account']")
	private WebElement linkMyAccount;

	@FindBy(linkText = "Login")
	private WebElement linkLogin;

	@FindBy(linkText = "Continue")
	private WebElement linkContinue;

	@FindBy(xpath = "//a[@id='wishlist-total']")
	private WebElement linkWishList;

	@FindAll(@FindBy(id = "search"))
	List<WebElement> fieldsSearch;

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

	public int countSearchFields() {
		return fieldsSearch.size();

	}

	public String getWishListButtonText() {
		return linkWishList.getAttribute("title");

	}

}
