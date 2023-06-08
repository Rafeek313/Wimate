package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLibrary.BaseClass;
import GenericLibrary.WebDriverUtility;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//*[@uib-tooltip='Configuration']")
	private WebElement configurationmodule;
	@FindBy(xpath = "//a[.='Device ']")
	private WebElement Deviceconfiguration;
	@FindBy(xpath="//h1[@contains(text(),'hours ']")
	private WebElement officehrs;
	@FindBy(xpath = "//a[@href='/dynamics/dynamic_dynamic']/i[@class='fa fa-dashboard']")
	private WebElement Dynamicmodule;
	@FindBy(xpath = "//a[.='Dashboard Configuration ']")
	private WebElement dahboardconfiguration;
	@FindBy(xpath = "//i[@uib-tooltip='Send']")
	private WebElement sendbutton;
	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dydbBtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConfigurationmodule() {
		return configurationmodule;
	}

	public WebElement getDeviceconfiguration() {
		return Deviceconfiguration;
	}
	
public WebElement getOfficehrs() {
		return officehrs;
	}

	public WebElement getDynamicmodule() {
		return Dynamicmodule;
	}

	public WebElement getDahboardconfiguration() {
		return dahboardconfiguration;
	}

	public WebElement getSendbutton() {
		return sendbutton;
	}

/**
 * this method will be perform clicking on configuration>device
 * @throws InterruptedException
 * @author rafeek123
 */
	public void clickOnConfigurationDevice() throws InterruptedException {
		wlib.waitForElementToBeClickable(officehrs);
		configurationmodule.click();
		Deviceconfiguration.click();
	}
/**
 * this method will be perform clicking on Dynamic Dashboard>dashboard configuration	
 */
	public void clickOnDynamicDashboard() {
		Dynamicmodule.click();
		dahboardconfiguration.click();
	}
	public void clickOnDynamicDashboardpage(WebDriver driver) {
		wlib.waitForPageLoad(driver);
		Dynamicmodule.click();
		dydbBtn.click();
	}
	public void clickOnSendButton() {
		sendbutton.click();
	}
	
}
