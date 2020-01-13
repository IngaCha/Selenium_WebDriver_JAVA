package com.trainings.maven.Assertions;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
/*
 * 
 * JUnit
 * assertTrue(String message, Boolean test)
 * assertFalse(String message, Boolean test)
 * assertNull(String message, Object object)
 * assertNotNull(String message, Object object)
 * assertEquals(String message, Object expected, Object actual) (uses equals method)
 * assertSame(String message, Object expected, Object actual) (uses == operator)
 * assertNotSame(String message, Object expected, Object actual)
 * 
 * Hamcrest
 * assertThat(actual, is(not(equalTo(expected))));
 * assertThat(actual, is(not(equalTo(expected))));
 * assertThat(actual, containsString(expected));
 * assertThat(123, is("abc")); //does not compile
 * assertThat("test", anyOf(is("test2"), containsString("ca"))); allOf => AND; anyOf => OR
 * 
 * VERSION WITH BEST PRACTISES APPLIED IS IN TEST FOLDER.
 * 
 */


public class Assertions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://akademijait.vtmc.lt/opencartone/");

		// JUnit assertSame. Checks how many search fields in page.
		Assert.assertSame("Search Field is not 1", 1, driver.findElements(By.id("search")).size());

		// JUnit assertEquals. Checks if ‘WishList’ button contains ‘Wishlist’
		// (Wish List (0))
		System.out.println(driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"));
		Assert.assertEquals("WishList button does not contain Wishlist", "Wish List (0)",
				driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"));

		// TestNG. PASSED, not null, but "Wish List (0)". Commented as not to mix up with JUnit.
		// assertNotNull("String is null", driver.findElement(By.xpath("//a[@id='wishlist-total']")).getAttribute("title"));

		// Hamcrest. AssertThat ShoppingCart is displayed
		// System.out.println(driver.findElement(By.xpath("//a[@title='ShoppingCart']")).isDisplayed());
		assertThat(driver.findElement(By.xpath("//a[@title='Shopping Cart']")).isDisplayed(), is(not(equalTo(false))));

		WebElement myAccount = driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']"));
		myAccount.click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Continue")).click();

		// JUnit. PASSED got null
		Assert.assertNull("String is not null", null);

		driver.findElement(By.name("firstname")).sendKeys("Inga");
		driver.findElement(By.id("input-lastname")).sendKeys("Chamentauskiene");

		WebElement emailText = driver.findElement(By.id("input-email"));
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		emailText.sendKeys("username" + randomInt + "@gmail.com");

		driver.findElement(By.id("input-telephone")).sendKeys("862399107");
		driver.findElement(By.id("input-address-1")).sendKeys("S. B. Jundzilo 15");
		driver.findElement(By.id("input-city")).sendKeys("Vilnius");
		driver.findElement(By.id("input-postcode")).sendKeys("LT-10256");

		Select dropDownCountry = new Select(driver.findElement(By.id("input-country")));
		dropDownCountry.selectByVisibleText("Lithuania");

		// Hamcrest "assertThat - is". Check that selected value is "Seychelles"
		// MatcherAssert.assertThat("Selected value is not Seychelles", dropDownCountry.getFirstSelectedOption().getText() , CoreMatchers.is("Seychelles") );
		// assertThat("Selected value is not Seychelles", dropDownCountry.getFirstSelectedOption().getText() , is("Seychelles") );

		// Hamcrest "assertThat - is(equalTo)". Check that slected value is "AmericanSamoa"
		// MatcherAssert.assertThat("Selected value is not American Samoa", dropDownCountry.getFirstSelectedOption().getText(), CoreMatchers.is(CoreMatchers.equalTo("American Samoa")) );
		// assertThat("Selected value is not American Samoa", dropDownCountry.getFirstSelectedOption().getText(), is(equalTo("AmericanSamoa")) );

		// Hamcrest "assertThat - containsString". Check that selected value contains "Alg"
		// MatcherAssert.assertThat("Country dropdown doesn’t contain Alg", dropDownCountry.getFirstSelectedOption().getText(),
		// CoreMatchers.containsString("Alg")); assertThat("Country dropdown doesn’t contain Alg", dropDownCountry.getFirstSelectedOption().getText(), containsString("Alg"));

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Select dropDownZone = new Select(driver.findElement(By.id("input-zone")));
		dropDownZone.selectByVisibleText("Vilnius");

		// JUnit assertTrue. Password field is enabled
		Assert.assertTrue("Search box is not enabled", driver.findElement(By.id("input-password")).isEnabled());

		driver.findElement(By.id("input-password")).sendKeys("labas");
		driver.findElement(By.id("input-confirm")).sendKeys("labas");

		WebElement newsletterYes = driver.findElement(By.xpath("//input[@name='newsletter'][@value='1'] "));
		newsletterYes.click();

		WebElement policy = driver.findElement(By.partialLinkText("Privacy"));
		// assertThat("test", anyOf(is("test2"), containsString("ca"))); allOf => AND; anyOf => OR
		// assertThat(policy.getText(), anyOf(is("Policy"), containsString("ca"))); //FAILS, IS is exact match!
		assertThat(policy.getText(), anyOf(is("Policy"), containsString("Privacy"))); // PASSES, contains Privacy
		assertThat(policy.getText(), allOf(containsString("Policy"), containsString("Privacy"))); // PASSES contains both Privacy and Policy

		policy.click();
		driver.findElement(By.xpath("//button[@type='button'][@class='close'] ")).click();

		WebElement agree = driver.findElement(By.name("agree"));

		// JUnit assertFalse. Agree field is not selected
		Assert.assertFalse("Agree field is selected", agree.isSelected());
		System.out.println(agree.isSelected());
		agree.click();

		// JUnit assert Count of input fields 14 ASSERT
		System.out.println(driver.findElement(By.id("content")).findElements(By.className("form-control")).size());
		Assert.assertSame("Input fields number is not 14", 14,
				driver.findElement(By.id("content")).findElements(By.className("form-control")).size());

		// JUnit assert Count Your Address input fields 7 ASSERT
		System.out.println(driver.findElements(By.xpath("//fieldset[@id='address']/div")).size());
		Assert.assertSame("Your address fields number is not 7", 7,
				driver.findElements(By.xpath("//fieldset[@id='address']/div")).size());

		// JUnit assert Count Your Address Select fields 2 ASSERT
		System.out.println(driver.findElements(By.xpath("//fieldset[@id='address']/div//select")).size());
		Assert.assertSame("Your address select fields number is not 2", 2,
				driver.findElements(By.xpath("//fieldset[@id='address']/div//select")).size());

		// JUnit assert Count all elements with class attribute 'form-control' 15 ASSERT
		System.out.println(driver.findElements(By.className("form-control")).size());
		Assert.assertNotSame("Elements with class attribute 'form-control' number is 16, not 15", 16,
				driver.findElements(By.className("form-control")).size());

		System.out.println(driver.findElements(By.tagName("fieldset")).size());

		WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit'][value='Continue']"));
		// Xpath (submit button)
		// WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Continue'] "));
		continueButton.click();

		driver.close();

	}

}
