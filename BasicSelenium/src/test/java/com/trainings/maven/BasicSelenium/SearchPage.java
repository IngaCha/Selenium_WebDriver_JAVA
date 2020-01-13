package com.trainings.maven.BasicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends AbstractPage {

	public String URL = "https://demo.opencart.com/index.php?route=product/search";

	@FindBy(name = "search")
	private WebElement inputSearch;

	@FindBy(className = "input-group-btn")
	private WebElement buttonSearch;

	@FindBy(id = "input-sort")
	private WebElement dropDownSortBy;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void clearInputSearch() {
		inputSearch.clear();
	}

	public void enterInputSearch(String value) {
		inputSearch.sendKeys(value);
	}

	public void clickButtonSearch() {
		buttonSearch.click();
	}

	public void sortByPrice() {
		Select dropDown = new Select(dropDownSortBy);
		dropDown.selectByVisibleText("Price (High > Low)");
	}

}
