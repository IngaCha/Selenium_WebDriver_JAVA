package com.trainings.maven.Wait;

import static org.testng.Assert.assertTrue;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitExamplesTest {
	private static WebDriver driver;

	// Wait 3 seconds. Implicit wait
	// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	// Thread.sleep(3000);

	@BeforeTest
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
	}

	@AfterTest
	public static void closeBrowser() {
		driver.close();
	}

	@Test
	public void addToCart() throws InterruptedException {

		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Show All Desktops")).click();

		// ADD TO CART:
		// Click ant IPhone->click add to cart->go back to previous page. GOOD.
		WebElement iPhone = driver.findElement(By.linkText("iPhone"));
		iPhone.click();
		driver.findElement(By.id("button-cart")).click();
		// go back to previous page
		driver.findElement(By.xpath("//div[@id='product-product']//a[text()='Desktops']")).click();

		Thread.sleep(3000);
		// Find parent div that has class='product-thumb' and h4='MacBook' and than go
		// to FIRST button. BETTER.
		WebElement mcBook = driver.findElement(By.xpath(
				"//div[contains(@class, 'product-thumb') and contains(.//h4, 'MacBook')]//button[contains(@onclick, 'cart.add')]"));
		mcBook.click();
		// Find parent div that has class='product-thumb' and h4='MacBook' and than go to button that contains span with text 'Add to Cart'. BEST.
		WebElement vaIO = driver.findElement(By.xpath(
				"//div[contains(@class, 'product-thumb') and contains(.//h4, 'Sony VAIO')]//button[contains(.//span, 'Add to Cart')]"));
		vaIO.click();

		// OPEN CART:
		waitForJavascript(driver); // wait for JS to show smth (a.k.a wait for all items in cart)
		WebElement cart = driver.findElement(By.id("cart"));
		cart = driver.findElement(By.id("cart"));
		cart.click();

		// DELETE FROM CART:
		// WebDriverWait wait = new WebDriverWait(driver, 120); //Wait until Remove button is visible. 120 seconds in total.
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Remove']")));
		driver.findElement(By.xpath("//button[@title='Remove']")).click();
		waitForJavascript(driver);
		cart.click();
		driver.findElement(By.xpath("//button[contains(@onclick, 'cart.remove')]")).click();
		waitForJavascript(driver);
		cart.click();
		driver.findElement(By.xpath("//button[contains(@onclick, 'cart.remove')]")).click();
		waitForJavascript(driver);

		// ASSERT NO MORE ITEMS IN CART:
		System.out.println(driver.findElement(By.xpath("//span[@id='cart-total']")).getText());
		assertTrue(driver.findElement(By.xpath("//span[@id='cart-total']")).getText().contains("0 item(s)"),
				"Cart still has more items");
	}

	// method that wait for JS to return smth. Explicit Wait
	private static void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);// JS returns smth.
			}
		});
	}

}
