package com.trainings.maven.BasicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public String URL = "https://demo.opencart.com/";

	// private - this element is not visible
	@FindBy(name = "search")
	private WebElement inputSearch;

	@FindBy(className = "input-group-btn")
	private WebElement buttonSearch;

	public MainPage(WebDriver driver) {
		super(driver);

	}

	// public - we will be using this method
	public void enterInputSearch(String value) {
		inputSearch.sendKeys(value);
	}

	public void clickButtonSearch() {
		buttonSearch.click();
	}

}
