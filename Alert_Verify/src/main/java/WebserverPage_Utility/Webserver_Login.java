package WebserverPage_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Config_Utility.config_read;
import Selenium_utility.Selenium_functions;
import Webdrivermanager_Utility.WebdriverManager_Setup;

public class Webserver_Login extends WebdriverManager_Setup {

	WebDriver driver;

	public Webserver_Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='full-size']/h4")
	public WebElement LoginPage_Title;

	@FindBy(id = "username")
	public WebElement Username;

	@FindBy(id = "password")
	public WebElement PassWord;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement Submit_Btn;
	

	public void SendUserName(String username) {
		//Using WebElement passing username
		Username.sendKeys(username);
	}

	public void SendPassword(String Password) {
		//Using WebElement passing Password
		PassWord.sendKeys(Password);
	}

	public void ClickSubmit() {
		//Clicking on Submit button
		Submit_Btn.click();
	}
	
	public Dashboard_Page Login_Cloud() throws Exception {	
		//properties file
		config_read Prop_data= new config_read();
		String URL= Prop_data.read_configvalue("url0");
	
		driver.get(URL);
		Selenium_functions Sel_Utility = new Selenium_functions();
		Sel_Utility.waitForElement(driver,LoginPage_Title);
		String username =Prop_data.read_configvalue("UserName0");
		String Password =Prop_data.read_configvalue("PassWord0"); 
				
		SendUserName(username);
		SendPassword(Password);
		ClickSubmit();
		return new Dashboard_Page(driver); 
	}


}
