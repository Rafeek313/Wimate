package Selenium_utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Webdrivermanager_Utility.WebdriverManager_Setup;

public class Selenium_functions {

	public void full_Screen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void Sleep() throws Exception {
		Thread.sleep(3000);
	}

	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementtoClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void Scoll_PageDown(WebDriver driver) {
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void Scoll_PageUP_Element(WebDriver driver) {
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_UP).build().perform();

	}

	public void scroll_to_top(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)", "");
	}

	public void Disableaction(WebDriver driver) throws Exception {
		Actions action = new Actions(driver);
		Robot robot = new Robot();
		robot.mouseMove(50, 50);
		action.click().build().perform();
		System.setProperty("java.awt.headless", "false");
	}

	public void Quit_Browser(WebDriver driver) {
		driver.close();
	}

	public void Sleeponemin() throws Exception {
		Thread.sleep(1500);
	}

}
