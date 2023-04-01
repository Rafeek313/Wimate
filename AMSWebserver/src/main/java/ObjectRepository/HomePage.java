package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import GenericLibrary.WebDriverUtility;

public class HomePage {
	@FindBy(xpath="//span[text()='Forms ']")
	private WebElement formsbtn;
	@FindBy(xpath="//a[text()=' Form Parameter ']")
	private WebElement formParameterbtn;
	@FindBy(xpath = "//a[text()=' Form Type ']")
	private WebElement formTypebtn;
	@FindBy(xpath = "//a[text()=' Form User Permission ']")
	private WebElement formUserPermissionbtn;
	@FindBy(xpath = "//img[@alt='User']")
	private WebElement profileicon;
	@FindBy(xpath ="(//a[@href='javascript:void(0);'])[4]")
	private WebElement logoutbtn;




	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);

	}

	public WebElement getFormsbtn() {
		return formsbtn;
	}


	public WebElement getFormParameterbtn() {
		return formParameterbtn;
	}


	public WebElement getFormTypebtn() {
		return formTypebtn;
	}


	public WebElement getFormUserPermissionbtn() {
		return formUserPermissionbtn;
	}


	public WebElement getProfileicon() {
		return profileicon;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public void clickonFormParameter() throws InterruptedException {
		formsbtn.click();
		formParameterbtn.click();	
	}
	public void clickonFormType() throws InterruptedException {
		formsbtn.click();
		formTypebtn.click();	
	}
	public void clickonFormUserPermission() throws InterruptedException {
		formsbtn.click();
		formUserPermissionbtn.click();	
	}	
	public void logout() throws InterruptedException
	{
		profileicon.click();
		Thread.sleep(1000);
		logoutbtn.click();	
	}
}
