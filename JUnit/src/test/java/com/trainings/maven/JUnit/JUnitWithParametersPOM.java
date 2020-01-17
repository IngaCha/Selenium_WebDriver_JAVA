package com.trainings.maven.JUnit;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class JUnitWithParametersPOM extends AbstractTest {
	MainPage mainPage;
	RegisterAccountPage registerAccountPage;
	String name;

	// constructor
	public JUnitWithParametersPOM(String name) {
		this.name = name;
	}

	@Parameters
	public static List<String> input() {
		return Arrays.asList("Inga", "Tomas", "Blavla");
	}

	@Test
	public void parameterizeName() throws InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.inputFirstName.sendKeys(name);
		registerAccountPage.inputFirstName.clear();

	}

}
