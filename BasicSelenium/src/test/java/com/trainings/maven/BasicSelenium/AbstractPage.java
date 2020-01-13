package com.trainings.maven.BasicSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Page constructor
public abstract class AbstractPage {
	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
