package com.trainings.maven.Wait;

import static org.testng.Assert.assertTrue;

import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitExamplesTestPOM extends AbstractTest {
	MainPage mainPage;
	ShowAllDesktopsPage showAllDesktopsPage;

	@Test
	public void addToCart() throws InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.clickLinkDesktops();
		mainPage.clickLinkShowAllDesktops();
		showAllDesktopsPage = new ShowAllDesktopsPage(driver);
		showAllDesktopsPage.clickLinkAddiPhone();
		showAllDesktopsPage.clickLinkAddMacBook();
		showAllDesktopsPage.clickLinkAddSony();
		waitForJavascript(driver); // wait for JS to show smth (a.k.a wait for all items in cart)
		showAllDesktopsPage.clickButtonCart();
		// Another wait example
		// WebDriverWait wait = new WebDriverWait(driver, 120); //Wait until Remove button is visible. 120 seconds in total.
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Remove']")));
		showAllDesktopsPage.clickButtonRemove();
		waitForJavascript(driver);
		showAllDesktopsPage.clickButtonCart();
		showAllDesktopsPage.clickButtonRemove();
		waitForJavascript(driver);
		showAllDesktopsPage.clickButtonCart();
		showAllDesktopsPage.clickButtonRemove();
		waitForJavascript(driver);
		// ASSERT NO MORE ITEMS IN CART:
		System.out.println(showAllDesktopsPage.getButtonCartTotalText());
		assertTrue(showAllDesktopsPage.getButtonCartTotalText().contains("0 item(s)"), "Cart still has more items");
	}

	// method that wait for JS to return smth. Explicit Wait
	private static void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);// Until JS return smth.
			}
		});
	}

}
