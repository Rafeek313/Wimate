package Alertverification;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.PropertyFileUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.Mqtt_broker;

public class Alertverify extends BaseClass {
	LoginPage loginpage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	// DevicePage devicepage = new DevicePage(driver);

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
	public void alert_generate_test() throws Throwable {
		Mqtt_broker.main(new String[] { "arg1", "arg2" });
		// sdriver.manage().window().fullscreen();
		wlib.waitForPageLoad(driver);
		homepage = new HomePage(driver);
		homepage.selectDeviceFromLocationTree(driver);

	}
}
