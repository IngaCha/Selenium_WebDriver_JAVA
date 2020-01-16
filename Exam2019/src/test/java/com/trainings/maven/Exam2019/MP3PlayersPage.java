package com.trainings.maven.Exam2019;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MP3PlayersPage extends AbstractPage {

	public String URL = "http://akademijait.vtmc.lt/opencartone/index.php?route=product/category&path=34";

	@FindBy(name = "search")
	private WebElement inputSearch;

	@FindBy(className = "input-group-btn")
	private WebElement buttonSearch;

	@FindAll(@FindBy(xpath = "//div[@id='content']//h4"))
	List<WebElement> linkProductNames;

	public MP3PlayersPage(WebDriver driver) {
		super(driver);
	}

	public void findMp3Names() throws IOException {

	}

	public void checkIfProductExists() {

	}

	public void clickSearchButton() {
		buttonSearch.click();
	}

}
