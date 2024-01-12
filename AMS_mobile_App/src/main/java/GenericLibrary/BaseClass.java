package GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	// creating object of webdriver utility methods
		public PropertyFileUtility plib = new PropertyFileUtility();
		public ExcelFileUtility elib = new ExcelFileUtility();
		public WebDriverUtility wlib = new WebDriverUtility();
		public WebDriver driver = null;
		public static WebDriver sdriver;
		LoginPage loginpage = new LoginPage(driver);
		HomePage homePage=new HomePage(driver);

		@BeforeClass
		public void launchBrowser() throws Throwable {
			// read data from property file
			String BROWSER = plib.readDataFromPropertyFile("browser");
			String URL = plib.readDataFromPropertyFile("url");
			if (BROWSER.equalsIgnoreCase("chrome")) {
				
				//ChromeOptions options=new ChromeOptions();
				//options.addArguments("--headless=new");
				//options.setHeadless(true);
				driver = new ChromeDriver();
				
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();

			} else {
				System.out.println("invalid browser");
			}
			sdriver = driver;
			wlib.maximizeWindow(sdriver);
			// driver.manage().window().fullscreen();
			wlib.waitForPageLoad(driver);
			driver.get(URL);
			Reporter.log("launching browser successful=====", true);
		}
		@BeforeClass
		public void login() throws IOException {
			wlib.waitForPageLoad(driver);
			PropertyFileUtility pobj = new PropertyFileUtility();
			String USERNAME = pobj.readDataFromPropertyFile("username");
			String PASSWORD = pobj.readDataFromPropertyFile("password");
			loginpage = new LoginPage(driver);
			loginpage.login(USERNAME, PASSWORD);
			Reporter.log("login successful", true);
			
		}

		@AfterClass
		public void closebrowser() throws InterruptedException {
			//homePage=new HomePage(driver);
			//homePage.logout(driver);
			sdriver.quit();
			Reporter.log("logout successful", true);
		}

	}

