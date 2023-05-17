package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class LocationPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	String locationid = "";
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='location_id']")
	private WebElement locationIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='latitude']")
	private WebElement lattitudeTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='longitude']")
	private WebElement longitudeTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='gmt_diff']")
	private WebElement gmtDiffTbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[2]")
	private WebElement locationIdDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='name']")
	private WebElement locationNameTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This LocationID already exists']")
	private WebElement errorMsg;
	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
	private WebElement saveBtn;

	public LocationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebDriverUtility getWlib() {
		return wlib;
	}

	public ExcelFileUtility getElib() {
		return elib;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}

	public WebElement getLocationIdTbx() {
		return locationIdTbx;
	}

	public WebElement getLattitudeTbx() {
		return lattitudeTbx;
	}

	public WebElement getLongitudeTbx() {
		return longitudeTbx;
	}

	public WebElement getGmtDiffTbx() {
		return gmtDiffTbx;
	}

	public WebElement getLocationIdDrpDwn() {
		return locationIdDrpDwn;
	}

	public WebElement getLocationNameTbx() {
		return locationNameTbx;
	}

	public WebElement getMetaDataTbx() {
		return MetaDataTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public String getLocationid() {
		return locationid;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void addLocation(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Location");
		System.out.println(count);

		for (int i = 1; i <= count; i++) {

			// Reading all field data from excel
			locationid = elib.readDataFromExcel("Location", i, 0);
			String lattitude = elib.readDataFromExcel("Location", i, 1);
			String longitude = elib.readDataFromExcel("Location", i, 2);
			String gmtDiffrence = elib.readDataFromExcel("Location", i, 3);
			String metadata = elib.readDataFromExcel("Location", i, 4);
			String locationName = elib.readDataFromExcel("Location", i, 5);
			String locationTypeId = elib.readDataFromExcel("Location", i, 6);
			// click on Add new button

			AddBtn.click();
			Thread.sleep(1000);
			// adding value into the location id textbox
			locationIdTbx.sendKeys(locationid);
			// adding value into the lattitude textbox
			lattitudeTbx.clear();
			lattitudeTbx.sendKeys(lattitude);
			// adding value into the longitude textbox
			longitudeTbx.clear();
			longitudeTbx.sendKeys(longitude);
			// adding value into the gmtDiffrence textbox
			gmtDiffTbx.sendKeys(gmtDiffrence);
			// adding value into the metadata textbox
			MetaDataTbx.sendKeys(metadata);
			// adding value into the locationName textbox
			locationNameTbx.sendKeys(locationName);
			Thread.sleep(1000);
			System.out.println(locationTypeId);
			// click on location id dropdown
			locationIdDrpDwn.click();
			// dynamic xpath for location id webelement
			WebElement locationTypeWe = driver
					.findElement(By.xpath("//span[text()='" + " " + "" + locationTypeId + "" + " " + "']"));
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, locationTypeWe);
			// click on specific location id webelement
			locationTypeWe.click();
			// scroll action for the save button
			wlib.scrollAction(driver, saveBtn);
			Thread.sleep(1000);
			try {
				saveBtn.click();
			} catch (Exception e) {
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver, cancelBtn);
				cancelBtn.click();
				System.out.println(locationid + " " + duplicateID);

			}
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-location_id mat-column-location_id ng-star-inserted' and text()='"
							+ " " + "" + locationid + "']"))
					.getText();
			Assert.assertEquals(locationid, ActualId);
			System.out.println(locationid + " added successfully");

		}
	}
}
