package com.trainings.maven.BasicSelenium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends AbstractTest {
	MainPage mainPage;
	SearchPage searchPage;

	@Test
	public void searchElement() throws IOException {
		mainPage = new MainPage(driver);
		List<String> td = getTestData("src/test/java/resources/Data.txt");
		mainPage.enterInputSearch(td.get(0));
		mainPage.clickButtonSearch();
		searchPage = new SearchPage(driver);
		searchPage.clearInputSearch();
		searchPage.enterInputSearch(td.get(1));
		searchPage.clickButtonSearch();
		searchPage.sortByPrice();

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
