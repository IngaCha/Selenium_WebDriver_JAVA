package com.trainings.maven.DataPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataPrepTest {

	private static WebDriver driver;

	@BeforeTest(alwaysRun = true) // for group running
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
	}

	@AfterTest
	public static void closeBrowser() {
		driver.close();
	}

	@Test(priority = 0)
	public void fillAccount() throws IOException {
		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();

		List<String> td = getTestData("src/test/java/resources/Data.txt");
		driver.findElement(By.name("firstname")).sendKeys(td.get(0));
		driver.findElement(By.id("input-lastname")).sendKeys(td.get(1));

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
