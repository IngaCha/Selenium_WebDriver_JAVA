package com.trainings.maven.Exam2019;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckProductExistsTest extends AbstractTest {

	MainPage mainPage;
	MP3PlayersPage mp3PlayersPage;
	ChosenMP3PlayersPage chosenMP3PlayersPage;

	@Test
	public void searchProductName() throws IOException, InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMP3Players();
		mp3PlayersPage = new MP3PlayersPage(driver);
		System.out.println(mp3PlayersPage.linkProductNames.size());
		List<String> td = getTestData("src/test/java/resources/Data.txt");
		List<String> existingProducts = new ArrayList<>();

		for (WebElement webElement : mp3PlayersPage.linkProductNames) {
			String elementName = webElement.getText();
			existingProducts.add(elementName);
		}

		int itemsInCart = 0;
		for (String name : td) {
			for (String elName : existingProducts) {

				if (existingProducts.contains(name) && name.equals(elName)) {
					Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
					System.out.println(name + " " + elName);
					assertEquals(elName, name, "Names do not match");
					driver.findElement(By.linkText(elName)).click();
					chosenMP3PlayersPage = new ChosenMP3PlayersPage(driver);
					chosenMP3PlayersPage.clickButtonWishList();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
					Assert.assertTrue(chosenMP3PlayersPage.isContentContainsMessageYouMustLogin());
					chosenMP3PlayersPage.clickButtonAddToCart();
					itemsInCart++;
					waitForJavascript(driver);
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
					Assert.assertTrue(chosenMP3PlayersPage.isContentContainsMessageAddToCart());
					assertTrue(chosenMP3PlayersPage.getButtonCartText().contains(itemsInCart + " item(s)"),
							"Item has not been added");
					chosenMP3PlayersPage.clickLinkMP3Players();
					break;
				}

				else if (existingProducts.contains(name) && !(name.equals(elName))) {
				} else {
					System.out.println(name + " does not exists in opencart");
				}
			}

		}

	}

	public List<String> getTestData(String fileName) throws IOException {
		List<String> records = new ArrayList<String>();
		String record;
		try (BufferedReader buffer = new BufferedReader(new FileReader(fileName));) {
			while ((record = buffer.readLine()) != null) {
				records.add(record);
			}
		}
		return records;
	}

	private static void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);

			}
		});
	}

}
