package com.trainings.maven.DataPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPrepParametersTestNGTestPOM extends AbstractTestTestNG {

	MainPage mainPage;
	RegisterAccountPage registerAccountPage;

	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() throws IOException {
		List<String> td = getTestData("src/test/java/resources/Data.txt");
		return new Object[][] { { td.get(0) }, { td.get(1) } };

	}

	@Test(dataProvider = "data-provider")
	public void createNewAccount(String data) {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();
		mainPage.clickLinkContinue();
		registerAccountPage = new RegisterAccountPage(driver);
		registerAccountPage.inputFirstName.sendKeys(data);
		registerAccountPage.inputFirstName.clear();
		System.out.println("Data is: " + data);
	}

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

}
