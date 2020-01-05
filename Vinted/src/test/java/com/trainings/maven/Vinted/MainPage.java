package com.trainings.maven.Vinted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public String URL = "https://www.vinted.lt/";

	public MainPage(WebDriver driver) {
		super(driver);
	}

	// links
	@FindBy(linkText = "Moteriški")
	private WebElement linkMoteriski;

	@FindBy(xpath = "//a[@href='/moteriski/moteriski-aksesuarai']")
	private WebElement linkAksesuarai;

	@FindBy(xpath = "//a[@href='/moteriski/skeciai']")
	private WebElement linkSkeciai;

	public void clickLinkMoteriski() {
		linkMoteriski.click();
	}

	public void clickLinkAksesuarai() {
		linkAksesuarai.click();
	}

	public void clickLinkSkeciai() {
		linkSkeciai.click();
	}

}
