package DeviceTest;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.DevicePage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.SendPage;

public class Generate_Hourly_Data extends BaseClass {
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	DevicePage devicepage = new DevicePage(driver);
	SendPage sendpage=new SendPage(driver);
	@Test
	public void generate_hourly_data_1() throws Throwable
	{
		
		wlib.waitForPageLoad(driver);
		Thread.sleep(5000);
		homepage = new HomePage(driver);
		Thread.sleep(8000);
		homepage.clickOnSendButton();
		sendpage =new SendPage(driver);
		sendpage.clickLocationTree(driver);		
	}

}