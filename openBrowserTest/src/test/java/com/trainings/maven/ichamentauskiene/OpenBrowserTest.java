package com.trainings.maven.ichamentauskiene;

import org.testng.annotations.Test;

public class OpenBrowserTest extends AbstractTest {
	MainPage mainPage;

	@Test
	public void searchElement() {
		mainPage = new MainPage(driver);

	}

}
