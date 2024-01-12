package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import GenericLibrary.WebDriverUtility;

public class HomePage {
	WebDriverUtility wlib=new WebDriverUtility();
	//@FindBy(xpath="//*[@name='cog']")
	//@FindBy(xpath="//ion-icon[@name='cog']")
	@FindBy(xpath="//ion-button[@class='ios button button-clear in-toolbar button-has-icon-only ion-activatable ion-focusable hydrated']")
	private WebElement menubtn;
	@FindBy(xpath="//h3[text()='Sign out']")
	private WebElement logoutbtn;
	@FindBy(xpath = "//h3[text()='Task']")
	private WebElement taskbtn;
		public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	
    }
	
	public WebElement getMenubtn() {
			return menubtn;
		}
		public WebElement getLogoutbtn() {
			return logoutbtn;
		}

		
	public void logout(WebDriver driver) throws InterruptedException {
		menubtn.click();
		wlib.mousehover(driver, logoutbtn);
		logoutbtn.click();
		
		
	}
	public void clickOnTaskButton() {
		taskbtn.click();
		
	}
	
}
