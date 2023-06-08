package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.WebDriverUtility;

public class DDHomePage {
	WebDriverUtility wlib=new WebDriverUtility();
	@FindBy(xpath = "//span[.='Add New Dynamic Dashboard']")
	private WebElement AddNewDDBtn;
	@FindBy(xpath = "//input[@id='dashboard_id' and @ng-model='dashboard_id']")
	private WebElement DashboardIdtxtbx;
	@FindBy(xpath = "//input[@id='dashboard_name' and @ng-model='dashboard_name']")
	private WebElement DashboardName;
	@FindBy(xpath = "(//a[@class='chosen-single chosen-default']/span)[1]")
	private WebElement DTypeClick;
	@FindBy(xpath = "(//div[@class=\\\"chosen-search\\\"]/input[@type='text'])[1]")
	private WebElement DTypeTxt;
	@FindBy(xpath = "//li[@data-option-array-index='3']")
	private WebElement DTypeSelectClick;
	@FindBy(xpath = "(//input[@id=\\\"dashboard_desc\\\"])[1]")
	private WebElement descriptiontxtbx;
	@FindBy(xpath = "(//div[@class='chosen-container chosen-container-single']/a[@class='chosen-single chosen-default']/div)[1]")
	private WebElement deviceTypeClick;
	@FindBy(xpath = "(//div[@class='chosen-search']/input[@type='text'])[2]")
	private WebElement deviceTypeTxtbx;
	@FindBy(xpath = "//li[@class='active-result highlighted']/em[text()='Rafeek_RDT")
	private WebElement DTSelectclick;
	@FindBy(xpath = "//button[@ng-click='addDynmDash()']")
	private WebElement addbtn;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchbtn;
	@FindBy(xpath = "//table/tbody/tr/td[@ng-show=\\\"dynmDashId\\\"]/a[@class='label label-warning ng-binding']")
	private WebElement ddid;
	@FindBy(xpath = "//button[@class='btn btn-primary dim btn-xs ng-binding']")
	private WebElement locationBtn;
	@FindBy(xpath="//input[@placeholder='Search for Devices']")
	private WebElement searchdevice;
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement okbtn;
	@FindBy(xpath="//button[@ng-click='poll_now()']")
	private WebElement pollNowBtn;
	public DDHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
  public WebDriverUtility getWlib() {
		return wlib;
	}
	public WebElement getAddNewDDBtn() {
		return AddNewDDBtn;
	}
	public WebElement getDashboardIdtxtbx() {
		return DashboardIdtxtbx;
	}
	public WebElement getDashboardName() {
		return DashboardName;
	}
	public WebElement getDTypeClick() {
		return DTypeClick;
	}
	public WebElement getDTypeTxt() {
		return DTypeTxt;
	}
	public WebElement getDTypeSelectClick() {
		return DTypeSelectClick;
	}
	public WebElement getDescriptiontxtbx() {
		return descriptiontxtbx;
	}
	public WebElement getDeviceTypeClick() {
		return deviceTypeClick;
	}
	public WebElement getDeviceTypeTxtbx() {
		return deviceTypeTxtbx;
	}
	public WebElement getDTSelectclick() {
		return DTSelectclick;
	}
	public WebElement getAddbtn() {
		return addbtn;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getDdid() {
		return ddid;
	}
	public WebElement getLocationBtn() {
		return locationBtn;
	}
	public WebElement getSearchdevice() {
		return searchdevice;
	}
	public WebElement getOkbtn() {
		return okbtn;
	}
	public WebElement getPollNowBtn() {
		return pollNowBtn;
	}
public void AddDynamicDashboard() {
	  AddNewDDBtn.click();
	  DashboardIdtxtbx.sendKeys("DD_Test03");
	  DashboardName.sendKeys("DD_TEST03");
	  DTypeClick.click();
	  DTypeTxt.sendKeys("Tertiary");
	  DTypeSelectClick.click();
	  descriptiontxtbx.sendKeys("DDashboard  Tertiary test");
	  deviceTypeClick.click();
	  deviceTypeTxtbx.sendKeys("Rafeek_RDT");
	  DTSelectclick.click();
	  addbtn.click();
	  searchbtn.sendKeys("DD_Test03");
	  Assert.assertEquals(ddid, "DD_Test03");
	  
	  
  }
  /**
   * this method is used for selecting device or location from location tree and verify pollnow button clickable or not
   * @param location
   * @author rafeek
   */
  public void selectDeviceorLocation(WebDriver driver,String location) {
	  wlib.waitForPageLoad(driver);
	  locationBtn.click();
	  searchdevice.sendKeys(location);
	  okbtn.click(); 
	  Assert.assertTrue( pollNowBtn.isEnabled());
	  Reporter.log("dydb dashboard loaded successfully",true);
  }
}

