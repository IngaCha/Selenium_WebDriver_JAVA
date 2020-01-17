package com.trainings.maven.Wait;

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

	@FindBy(linkText = "Forgotten Password")
	private WebElement linkForgottenPassword;

	@FindBy(xpath = "//img[@alt='Burger King']")
	WebElement pictureBurgerKing;

	@FindBy(linkText = "Continue")
	private WebElement linkContinue;

	@FindBy(xpath = "//a[@id='wishlist-total']")
	private WebElement linkWishList;

	@FindAll(@FindBy(id = "search"))
	List<WebElement> fieldsSearch;

	@FindBy(linkText = "Desktops")
	private WebElement linkDesktops;

	@FindBy(linkText = "Show All Desktops")
	private WebElement linkShowAllDesktops;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkMyAccount() {
		linkMyAccount.click();
	}

	public void clickLinkLogin() {
		linkLogin.click();
	}

	public void clickLinkForgottenPassword() {
		linkForgottenPassword.click();
	}

	public void clickLinkDesktops() {
		linkDesktops.click();
	}

	public void clickLinkShowAllDesktops() {
		linkShowAllDesktops.click();
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

	public Boolean isImgDisplayed() {
		return pictureBurgerKing.isDisplayed();

	}

}
