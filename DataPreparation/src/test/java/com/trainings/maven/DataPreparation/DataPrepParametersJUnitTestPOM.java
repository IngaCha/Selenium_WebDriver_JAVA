package com.trainings.maven.DataPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DataPrepParametersJUnitTestPOM extends AbstractTestJUnit {
	String item;
	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	// constructor
	public DataPrepParametersJUnitTestPOM(String item) {
		this.item = item;
	}

	@Parameters
	public static List<String> input() throws IOException {
		return getTestData("src/test/java/resources/Data.txt");
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

	@Test
	public void parameterizeName() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.inputFirstName.sendKeys(item);
		registerAccountPage.inputFirstName.clear();
	}

}
