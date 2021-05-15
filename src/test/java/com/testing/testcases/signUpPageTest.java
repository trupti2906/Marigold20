package com.testing.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.keywords.Keywords;

public class signUpPageTest extends Keywords {

	Keywords keyword = new Keywords();

	@BeforeMethod(description = "open chrom browser and launch the url")
	public void setUp() {
		openBrowser("CHROME"); 
		launchUrl("https://ijmeet.com/");

	}

	@AfterMethod(description = "Close all the browsers")
	public void tearDown() {
		driver.quit();
		System.out.println("Closed all browser windows");
	}

	@Test(description = "click on sign up btn of HomePage")
	public void clickOnSignUptext() {
		clickOnElement("Xpath", "//a[contains(text(),' Sign Up ')]");
	}

	@Test(description = "Click on signUp btn of signUp page")
	public void clickOnSignUpBtn() {
		enterText("Xpath", "//input[@id=\"name\"]", "Trupti");
		enterText("Xpath", "//input[@id=\"company_name\"]", "Aasara");
	}
}