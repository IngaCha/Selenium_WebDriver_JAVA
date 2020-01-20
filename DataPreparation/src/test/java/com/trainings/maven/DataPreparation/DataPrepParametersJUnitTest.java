package com.trainings.maven.DataPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class DataPrepParametersJUnitTest {
	String item;
	private static WebDriver driver;

	// constructor
	public DataPrepParametersJUnitTest(String item) {
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

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");
		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	public void parameterizeName() {
		driver.findElement(By.name("firstname")).sendKeys(item);
		driver.findElement(By.name("firstname")).clear();
	}

}
