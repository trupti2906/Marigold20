package com.testing.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {

	public static WebDriver driver;
	static WebElement element;

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("SAFARI")) {
			driver = new SafariDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		System.out.println("Launching Browser :" + browserName);
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("Xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("ID")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("Classname")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));
		} else {
			System.err.println("Invalid locator Type :" + locatorType);
		}
		return element;
	}

	public void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public void enterText(String locatorType, String locatorVlaue, String textToEnter) {
		getWebElement(locatorType, locatorVlaue).sendKeys(textToEnter);
	}
}