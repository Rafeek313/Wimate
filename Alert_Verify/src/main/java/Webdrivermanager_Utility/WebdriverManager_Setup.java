package Webdrivermanager_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverManager_Setup {

	public WebDriver driver = null;

	public void driver_Setup() {
		try {
			
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}