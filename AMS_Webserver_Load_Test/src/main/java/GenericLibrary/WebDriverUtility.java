package GenericLibrary;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.google.common.*;
import com.google.common.io.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility extends JavaUtility{
	JavaUtility	jlib=new JavaUtility();
	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method will make fullscreen of the window
	 * 
	 * @author rafeek
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	/**
	 * this method will wait 20 seconds for the page loading
	 * @param driver
	 */
	public void waitForPageLoadTimeOut(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait 5 seconds for the find elements
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	/**
	 * this method will wait until element visible in the Dom 
	 * 
	 * @param driver
	 */
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait until element presence in the Dom 
	 * 
	 * @param driver
	 */
	public static void waitForElementToBePresent(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class )
		.until(ExpectedConditions.elementToBeClickable(element));


	}
	public static void waitForElementToBePresent(WebDriver driver, WebElement element,String attribute,String value) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).ignoring(StaleElementReferenceException.class )
		.until(ExpectedConditions.attributeContains(element, attribute, value));


	}
	/**
	 * this method will select data from dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * this method will setect data from dropdown using visible text
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * this method will setect data from dropdown using value
	 * 
	 * @param text
	 * @param element
	 */
	public void select(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByValue(text);
	}

	/**
	 * this custom wait method will wait until element is clickable (10 times)
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(WebElement element) {
		int count = 0;
		while (count < 10) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				count++;
			}
		}

	}

	public void mousehover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		;
	}

	public void dragAndDrop(WebDriver driver, WebElement element, WebElement src, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, target).perform();
		;

	}

	public void doublecClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
		;
	}

	public void doublecClickAction(WebDriver driver) {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
		;
	}

	public void rightclick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	public void rightclick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	public void enterKey() throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}

	public void enterRelease() throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, String nameorld) {
		driver.switchTo().frame(nameorld);
	}

	/**
	 * this method will switch the frame based of address of the element
	 * 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}

	/**
	 * this method press accept button in alert popup
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	/**
	 * this method will get the text from in alert popup
	 * 
	 * @param driver
	 */
	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();

	}

	/**
	 * this method press cancel button in alert popup
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will switch to window depending on partial window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if (currentTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}

	/**
	 * this method will take takescreenshot on the webpage
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		String path = "./Screenshot/"+screenShotName+jlib.getSystemDateAndTime()+".png";
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest = new File("./Screenshot/"+screenShotName+".png");
	 Files.copy(src, dest);
	 
	 return dest.getAbsolutePath();
		
	}

	/**
	 * this method will perform page up by using action
	 * 
	 * @param driver
	 * @author rafeek
	 */
	public void pageUpAct(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();

	}

	/**
	 * this method will perform page down by using action
	 * 
	 * @param driver
	 * @author rafeek
	 */

	public void pageDownAct(WebDriver driver) {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	/**
	 * this method will perform random scroll
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(100,500)", " ");
	}

	/**
	 * this method will scroll perform top of webpage
	 * 
	 * @param driver
	 */
	public void scrollActionTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.scrollHeight, 0", " ");
	}
	/**
	 * this method will scroll perform bottom of webpage
	 * 
	 * @param driver
	 */
	public void scrollActionBottom(WebDriver driver) {
	}

	/**
	 * this method will scroll until the specific element found
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
		// js.executeScript("argument[0].scrollIntoView()",element);
	}
	public void specificScrollAction(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).clickAndHold().release().perform();
	}
	

}
