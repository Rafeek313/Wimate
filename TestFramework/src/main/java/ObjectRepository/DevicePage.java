package ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;
import freemarker.ext.jsp.TaglibFactory.WebInfPerLibJarMetaInfTldSource;
import io.reactivex.rxjava3.exceptions.Exceptions;

public class DevicePage extends BaseClass {
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//i[@class='fa fa-cog']")
	private WebElement addbtn;

	@FindBy(xpath = "//a[.='  New Device']")
	private WebElement NewDeviceBtn;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Unifier Differentiator (Client ID in Unifier gateway settings )']/following-sibling::input[@type='text']")
	private WebElement udtxtbx;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Unifier Identifier (Unifier Mac ID)']/following-sibling::input[@type='text']")
	private WebElement uitxtbx;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Device Name (Check device settings in Unifier) ']/following-sibling::input[@type='text']")
	private WebElement deviceNametxtbx;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Display label (Will be shown in navigation menu and reports)']/following-sibling::input[@type='text']")
	private WebElement displayLabeltxtbx;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Description']/following-sibling::input[@type='text']")
	private WebElement discriptiontxtbx;

	// @FindBy(xpath="//li[.='system_info_grp_check']/ancestor::div[@class='chosen-container
	// chosen-container-single']/a[@class='chosen-single chosen-default']/div")
	// @FindBy(xpath="//select[@class='parameters_Group_Name_for_Reading
	// form-control ng-pristine localytics-chosen ng-empty ng-invalid
	// ng-invalid-required ng-touched']/ancestor::div[@class='form-group']")
	// @FindBy(xpath="//*[@class='parameters_Group_Name_for_Reading form-control
	// localytics-chosen ng-touched ng-dirty ng-empty ng-invalid
	// ng-invalid-required']")
	@FindBy(xpath = "//div[@id='model-body']/div/div/div[2]/div/form/div[2]/div/div/a/span[1]")
	// @FindBy(xpath="//select[@ng-options='item as item for item in
	// groupOfparameters_']")
	// @FindBy(xpath="//select[@ng-model=\"parameters_Group_Name_for_Reading\"]/following-sibling::div/a/div/b")
	// @FindBy(xpath="//select[@ng-model='parameters_Group_Name_for_Reading']/following-sibling::div/div[@class='chosen-drop'/div[@class='chosen-search']]")
	private WebElement rdttxtbx;
	// ByAngularModel rdttxt=ByAngular.model("parameters_Group_Name_for_Reading");

	// @FindBy(xpath="//label[.='Reading Device
	// Type']/following-sibling::input[@type='text']/ancestor::div[@class='col-sm-12']/div[@class='form-group']/div[@class='chosen-container
	// chosen-container-single']/div[@class='chosen-drop']/div[@class='chosen-search']/input[@type='text']")
	@FindBy(xpath = "(//div[@id='model-body']/div/div/div[2]/div/form/div[2]/div/div/div/div[1]/input[@type='text'])[1]")
	// @FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement rdt;
	// @FindBy(xpath="(//div[@class='chosen-drop'])[13]/ul/li/em[.='Rafeek_RDT']")
	// @FindBy(xpath="//li[@class='active-result highlighted' and
	// text()='Rafeek_RDT']")
	@FindBy(xpath = "//li[@class='active-result highlighted']/em[text()='Rafeek_RDT']")
	private WebElement rdtclick;

	// @FindBy(xpath="//select[@class='parameters_Group_Name_for_Writing
	// form-control ng-pristine localytics-chosen ng-empty ng-invalid
	// ng-invalid-required
	// ng-touched']/following-sibling::div/div/ul[@class='chosen-results']")
	@FindBy(xpath = "(//div[@id='model-body']/div/div/div[2]/div/form/div[2]/div/div/a/span)[2]")
	private WebElement wdttxtbx;
	@FindBy(xpath = "//div[@id='model-body']/div/div/div[2]/div/form/div[2]/div[2]/div/div/div/input[@type='text']")
	private WebElement wdt;
	@FindBy(xpath = "//li[@class='active-result highlighted']/em[text()='Rafeek_WDT01']")
	private WebElement wdtclick;

	@FindBy(xpath = "//div[@class='form-group']/label[.='Schedule Month Day']/following-sibling::input[@type='number']")
	private WebElement schedulemonthtxtbx;

	@FindBy(xpath = "//button[@id='btnSensorSubmit' and @class='btn btn-sm btn-primary btn2close pull-right m-t-n-xs dim']")
	private WebElement submitbtn;

	@FindBy(xpath = "//button[@id='btn3' and @class='btn btn-sm btn-danger btnclose pull-right m-t-n-xs dim']")
	private WebElement cancelbtn;

	@FindBy(xpath = "//div[@id='example2_filter']/label/input[@type='search']")
	private WebElement searchbtn;
	@FindBy(xpath = "//label[text()='MN Already exist']")
	private WebElement mnexist;
	@FindBy(xpath = "//button[text()=' Filter Device Table ']")
	private WebElement filterBtn;
	@FindBy(xpath = "//span[text()='Select an Option']")
	private WebElement filterOptn;
	@FindBy(xpath = "//li[text()='Latest Updated']")
	private WebElement latestUpdateOptn;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement limitOptn;
	@FindBy(xpath = "//button[text()=' Apply  ']")
	private WebElement applyBtn;
	@FindBy(xpath = "//input[@type='number' and @placeholder='High Limit']")
	private WebElement highLimitTbx;
	@FindBy(xpath = "//button[@ng-disabled='limitTo_flag']")
	private WebElement filter2tbx;
	@FindBy(xpath = "//div[@id='example2_info']")
	private WebElement deviceTablerow;
	
	
	public DevicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getNewDeviceBtn() {
		return NewDeviceBtn;
	}

	public WebElement getUdtxtbx() {
		return udtxtbx;
	}

	public WebElement getUitxtbx() {
		return uitxtbx;
	}

	public WebElement getDeviceNametxtbx() {
		return deviceNametxtbx;
	}

	public WebElement getDisplayLabeltxtbx() {
		return displayLabeltxtbx;
	}

	public WebElement getDiscriptiontxtbx() {
		return discriptiontxtbx;
	}

	public WebElement getRdttxtbx() {
		return rdttxtbx;
	}

	public WebElement getRdt() {
		return rdt;
	}

	public WebElement getRdtclick() {
		return rdtclick;
	}

	public WebElement getWdt() {
		return wdt;
	}

	public WebElement getWdttxtbx() {
		return wdttxtbx;
	}

	public WebElement getWdtclick() {
		return wdtclick;
	}

	public WebElement getSchedulemonthtxtbx() {
		return schedulemonthtxtbx;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	/**
	 * This method will be perform Adding new device and verifying device is exist
	 * or not taking data from excel and properties file
	 * 
	 * @author rafeek
	 * @throws IOException
	 * @throws Throwable
	 */
	public void clickOnAddButton() throws IOException, Throwable {
		int rowcount = elib.getRowCount("TestData1");
		System.out.println("row count=" + rowcount);
		for (int i = 1; i <= rowcount; i++) {
			wlib.fullscreenWindow(sdriver);
			addbtn.click();
			Thread.sleep(1000);
			NewDeviceBtn.click();
			try {
				Thread.sleep(2000);
				String uDData = elib.readDataFromExcel("TestData1", i, 0);
				String uIData = elib.readDataFromExcel("TestData1", i, 1);
				String dndata = elib.readDataFromExcel("TestData1", i, 2);
				String dldata = elib.readDataFromExcel("TestData1", i, 3);
				String descriptiondata = elib.readDataFromExcel("TestData1", i, 4);
				String rdtdata = elib.readDataFromExcel("TestData1", i, 5);
				String wdtdata = elib.readDataFromExcel("TestData1", i, 6);
				String smdata = elib.readDataFromExcel("TestData1", i, 7);
				System.out.println(uDData + " " + uIData + " " + dndata + " " + dldata + " " + descriptiondata + " "
						+ rdtdata + " " + wdtdata + " " + smdata);
				//wlib.waitForElementToBeClickable(sdriver, udtxtbx);
				//error bcz selenium server update
				udtxtbx.sendKeys(uDData);
				uitxtbx.sendKeys(uIData);
				deviceNametxtbx.sendKeys(dndata);
				displayLabeltxtbx.sendKeys(dldata);
				discriptiontxtbx.sendKeys(descriptiondata);
				rdttxtbx.click();
				rdt.sendKeys(rdtdata);
				rdtclick.click();
				wdttxtbx.click();
				wdt.sendKeys(wdtdata);
				wdtclick.click();
				schedulemonthtxtbx.clear();
				schedulemonthtxtbx.sendKeys(smdata);
				Thread.sleep(1000);
				submitbtn.click();
				Thread.sleep(2000);
				searchbtn.clear();
				searchbtn.sendKeys(dndata);
				String devicename = sdriver.findElement(By.xpath(
						"(//table[@id='example2']/tbody/tr/td[@class='ng-scope']/center[text()='" + dndata + "'])[1]"))
						.getText();
				if (devicename.equalsIgnoreCase(dndata)) {
					System.out.println("device is verified, udname= " + devicename);
					elib.writeDataIntoExcel("TestData1", i, 8, "pass");
					System.out.println("device is added");
				}
			} catch (Exception e) {
				try {
					Thread.sleep(3000);
					String errormsg = sdriver.switchTo().alert().getText();
					System.out.println(errormsg);
					sdriver.switchTo().alert().accept();
					Thread.sleep(1000);
					cancelbtn.click();
					elib.writeDataIntoExcel("TestData1", i, 8, "FAIL");
					System.out.println("device already exist, rowno=" + i);

				} // try
				catch (NoAlertPresentException Ex) {
					Thread.sleep(3000);
					System.out.println("alert was not present");
					cancelbtn.click();
					elib.writeDataIntoExcel("TestData1", i, 8, "FAIL");
					System.out.println("device already exist, rowno=" + i);

				}

			}

		}
	}
	/**
	 * 
	 */
	
	public void filterDevice() {
		String actualText = "200";
		filterBtn.click();
		filterOptn.click();
		latestUpdateOptn.click();
		limitOptn.clear();
		limitOptn.sendKeys("200");
		applyBtn.click();	
		highLimitTbx.clear();
		highLimitTbx.sendKeys("200");
		filter2tbx.click();
		String totalrow = deviceTablerow.getText();
		System.out.println("total device filtered on the device table: "+ totalrow);
		Assert.assertTrue(totalrow.contains(actualText));
		
		
	}

}
