package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import GenericLibrary.WebDriverUtility;

public class HomePage {
	WebDriverUtility wlib = new WebDriverUtility();
	@FindBy(xpath = "//span[text()='Forms ']")
	private WebElement formsbtn;
	@FindBy(xpath = "//a[text()=' Form Parameter ']")
	private WebElement formParameterbtn;
	@FindBy(xpath = "//a[text()=' Form Type ']")
	private WebElement formTypebtn;
	@FindBy(xpath = "//a[text()=' Form User Permission ']")
	private WebElement formUserPermissionbtn;
	@FindBy(xpath = "//img[@alt='User']")
	private WebElement profileicon;
	@FindBy(xpath = "(//a[@href='javascript:void(0);'])[4]")
	private WebElement logoutbtn;
	@FindBy(xpath = "//span[text()='Configuration ']")
	private WebElement configButton;
	@FindBy(xpath = "//a[text()=' Department ']")
	private WebElement DepBtn;
	@FindBy(xpath = "//a[text()=' Sub Department ']")
	private WebElement SubDepbtn;
	@FindBy(xpath = "//a[text()=' Manufacturer ']")
	private WebElement manufacturebtn;
	@FindBy(xpath = "//a[text()=' Problem ']")
	private WebElement Problembtn;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

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

	public WebElement getConfigButton() {
		return configButton;
	}

	public WebElement getDepBtn() {
		return DepBtn;
	}

	public WebElement getSubDepbtn() {
		return SubDepbtn;
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

	public void logout() throws InterruptedException {
		profileicon.click();
		Thread.sleep(1000);
		logoutbtn.click();
	}

	public void clickonConfigButton() {
		configButton.click();
	}

	public void clickonDepartmentButton() {
		DepBtn.click();
	}
/**
 * this method is used for click on subdepartment option and action class used for scroll to the specific element
 * @param driver
 * @throws InterruptedException
 */
	public void clickonSubDepartmentButton(WebDriver driver) throws InterruptedException {
		wlib.maximizeWindow(driver);
		wlib.specificScrollAction(driver, SubDepbtn); 
	
	}
	/** this method is used for click on manufacture option and action class used for scroll to the specific element
	 * @param driver
	 * @throws InterruptedException
	 */
		public void clickonManufactureButton(WebDriver driver) throws InterruptedException {
			wlib.maximizeWindow(driver);
			wlib.specificScrollAction(driver, manufacturebtn);
			
		}
}
