package DeviceTest;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.DDHomePage;
import ObjectRepository.DevicePage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class DeviceTest extends BaseClass {
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	DevicePage devicepage = new DevicePage(driver);

//    @BeforeMethod
//     public void fullscreen() {
//    	 sdriver.manage().window().fullscreen();
//     }
	/**
	 * This method will be perform Adding new device and verifying device is exist
	 * or not taking data from excel and properties file
	 * 
	 * @throws Throwable
	 * @author rafeek
	 */
	@Test
	public void AddingDeviceTests() throws Throwable {
		// sdriver.manage().window().fullscreen();
		wlib.waitForPageLoad(driver);
		PropertyFileUtility pobj = new PropertyFileUtility();
		String USERNAME = pobj.readDataFromPropertyFile("username");
		String PASSWORD = pobj.readDataFromPropertyFile("password");
		loginpage = new LoginPage(driver);
		loginpage.login(USERNAME, PASSWORD,driver);
		Thread.sleep(5000);
		homepage = new HomePage(driver);
		homepage.clickOnConfigurationDevice();
		devicepage = new DevicePage(driver);
		devicepage.clickOnAddButton();
		Thread.sleep(3000);
	}
	@Test
	public void filterDeviceTests( ) throws Throwable {
		// sdriver.manage().window().fullscreen();
		wlib.waitForPageLoad(driver);
		homepage = new HomePage(driver);
		homepage.clickOnConfigurationDevice();
		devicepage = new DevicePage(driver);
		Thread.sleep(10000);
		int count=5;
		for(int i=1; i<=count;i++) {
		String text = driver.findElement(By.xpath("(//table//tbody/tr["+i+"]/td[2])[1]")).getText();
		System.out.println("device"+i+":"+text);
		}
		devicepage.filterDevice();	
	
}
	@Test
	public void verifyDYDB( ) throws InterruptedException {
		wlib.waitForPageLoad(driver);
		homepage = new HomePage(driver);
		homepage.clickOnDynamicDashboardpage(driver);
		DDHomePage ddHomePage=new DDHomePage(driver);
		ddHomePage.selectDeviceorLocation(driver,"Test_DB36");
		Reporter.log("");
		
		
	}
}
