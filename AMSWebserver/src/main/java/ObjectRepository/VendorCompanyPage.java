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

public class VendorCompanyPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='vendor_id']")
	private WebElement vendorIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='ph_no']")
	private WebElement phoneNoTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='email']")
	private WebElement emailTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement metaDataTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='name']")
	private WebElement vendorCompanyNameTbx;
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[contains(text(),'already')]")
	private WebElement errorMsg;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshBtn;

	public VendorCompanyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddBtn() {
		return AddBtn;
	}
	public WebElement getVendorIdTbx() {
		return vendorIdTbx;
	}
	public WebElement getDescTbx() {
		return descTbx;
	}
	public WebElement getPhoneNoTbx() {
		return phoneNoTbx;
	}
	public WebElement getEmailTbx() {
		return emailTbx;
	}
	public WebElement getMetaDataTbx() {
		return metaDataTbx;
	}
	public WebElement getVendorCompanyNameTbx() {
		return vendorCompanyNameTbx;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getRefreshBtn() {
		return refreshBtn;

	}
	
	public void addVendorCompany(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("VendorCompany");
		System.out.println(count);

		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			String vcid = Long.toString(epochTime);
			// Reading all field data from excel
			//locationid = elib.readDataFromExcel("VendorCompany", i, 0);
			String description = elib.readDataFromExcel("VendorCompany", i, 0);
			String phoneno = elib.readDataFromExcel("VendorCompany", i, 1);
			String email = elib.readDataFromExcel("VendorCompany", i, 2);
			String metadata = elib.readDataFromExcel("VendorCompany", i, 3);
			String vcname = elib.readDataFromExcel("VendorCompany", i, 4);
			// click on Add new button

			AddBtn.click();
			Thread.sleep(1000);
			// adding value into the vendor company id textbox
			vendorIdTbx.sendKeys(vcid);
			descTbx.sendKeys(description);
			// adding value into the phone no textbox
			//lattitudeTbx.clear();
			phoneNoTbx.sendKeys(phoneno);
			// adding value into the vc email textbox
			//longitudeTbx.clear();
			emailTbx.sendKeys(email);
			// adding value into the metadata textbox
			metaDataTbx.sendKeys(metadata);
			// adding value into the vc company name textbox
			vendorCompanyNameTbx.sendKeys(vcname);
			// scroll action for the save button
			wlib.scrollAction(driver, saveBtn);
			Thread.sleep(1000);
			try {
				saveBtn.click();
			} catch (Exception e) {
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver, cancelBtn);
				cancelBtn.click();
				System.out.println(vcid + " " + duplicateID);

			}
			//String ActualId = driver.findElement(By.xpath(
				//	"//mat-cell[@class='mat-cell cdk-cell cdk-column-location_id mat-column-location_id ng-star-inserted' and text()='"
				//			+ " " + "" + locationid + "']"))
					//.getText();
			Thread.sleep(1000);
			refreshBtn.click();
			//String ActualId= driver.findElement(By.xpath("//mat-cell[@class='mat-cell cdk-cell cdk-column-location_id mat-column-location_id ng-star-inserted' and text()='"+" "+""+vcid+"']")).getText();
			String ActualId= driver.findElement(By.xpath("//mat-cell[text()='"+" "+""+vcid+"']")).getText();
			Assert.assertEquals(vcid, ActualId);
			elib.writeDataIntoExcel("Asset", i, 7, vcid);
			String vcidasset = elib.readDataFromExcel("Asset", i, 7);
			System.out.println(vcidasset);
			System.out.println(vcid + " added successfully");

		}
	}

	
}
