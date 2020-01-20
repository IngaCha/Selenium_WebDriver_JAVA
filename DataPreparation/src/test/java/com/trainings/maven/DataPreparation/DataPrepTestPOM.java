package com.trainings.maven.DataPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class DataPrepTestPOM extends AbstractTestTestNG {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@Test(priority = 0)
	public void fillAccount() throws IOException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		List<String> td = getTestData("src/test/java/resources/Data.txt");
		registerAccountPage.inputFirstName.sendKeys(td.get(0));
		registerAccountPage.inputLastName.sendKeys(td.get(1));

	}

	private static List<String> getTestData(String fileName) throws IOException {
		List<String> records = new ArrayList<String>();
		String record;
		try (BufferedReader buffer = new BufferedReader(new FileReader(fileName));) {
			while ((record = buffer.readLine()) != null) {
				records.add(record);
			}
		}
		return records;
	}

}
