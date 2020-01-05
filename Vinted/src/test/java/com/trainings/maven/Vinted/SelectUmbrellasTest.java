package com.trainings.maven.Vinted;

import org.testng.annotations.Test;

public class SelectUmbrellasTest extends AbstractTest {
	MainPage mainPage;
	UmbrellasPage umbrellasPage;

	@Test
	public void searchElement() {
		mainPage = new MainPage(driver);
		mainPage.clickLinkMoteriski();
		mainPage.clickLinkAksesuarai();
		mainPage.clickLinkSkeciai();
		umbrellasPage = new UmbrellasPage(driver);
		umbrellasPage.clickLinkSpalva();
		umbrellasPage.checkIfCheckboxBlackIsChecked();
		umbrellasPage.clickElementBlack();
		umbrellasPage.clickLinkKaina();
		umbrellasPage.sendPriceFrom();
		umbrellasPage.sendPriceTo();
		umbrellasPage.clickTitle();
		umbrellasPage.clickLinkSpalva();
		umbrellasPage.checkIfCheckboxBlackIsChecked();

	}

}
