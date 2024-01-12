package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class LocationTypePage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='location_type_id']")
	private WebElement locationTypeIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This LocationTypeID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
	public LocationTypePage(WebDriver driver) {
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

	public WebElement getLocationTypeIdTbx() {
		return locationTypeIdTbx;
	}

	public WebElement getDescriptionTbx() {
		return descriptionTbx;
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

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void addLocationType(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("LocationType");
		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			String locationTypeid = Long.toString(epochTime);
			// String locationTypeid = elib.readDataFromExcel("LocationType", i, 0);
			String description = elib.readDataFromExcel("LocationType", i, 0);
			String metadata = elib.readDataFromExcel("LocationType", i, 1);
			AddBtn.click();
			elib.writeDataIntoExcel("Location", i, 5,locationTypeid);
			Thread.sleep(1000);
			locationTypeIdTbx.sendKeys(locationTypeid);
			descriptionTbx.sendKeys(description);
			MetaDataTbx.sendKeys(metadata);
			try {
				saveBtn.click();
				}
				catch(Exception e)
				{ 
					String duplicateID = errorMsg.getText();
					wlib.scrollAction(driver,cancelBtn);
					cancelBtn.click();
					System.out.println(locationTypeid+" "+duplicateID);
					
			    }
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-location_type_id mat-column-location_type_id ng-star-inserted' and text()='"
							+ " " + "" + locationTypeid + "']"))
					.getText();
			Assert.assertEquals(locationTypeid, ActualId);
			elib.writeDataIntoExcel("Location", i, 5, locationTypeid);
		}
	}
}
