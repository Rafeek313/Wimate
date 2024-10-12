package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class AssetPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='asset_id']")
	private WebElement assetIDTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='tag_id']")
	private WebElement tagIDTbx;
	//@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[2]")
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'assetMapAssetsId')]")
	private WebElement assetTypeIDDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'departmentAssetsId')]")
	private WebElement departmentIDDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'subDepartmentAssetsId')]")
	private WebElement subDepartmentIDDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='amc_expiry']")
	private WebElement amcExpireDate;
	@FindBy(xpath = "//input[@ng-reflect-name='bought_price']")
	private WebElement boughtPriceTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='current_price']")
	private WebElement currentPriceTbx;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'locationAssetsId')]")
	private WebElement locationIdDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'vendorCompanyAssetsId')]")
	private WebElement vendorCompanyIdDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'asset_type')]")
	private WebElement assetTypeDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'manufacturerAssetsId')]")
	private WebElement manufacturerIdDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'modelAssetsId')]")
	private WebElement modelIdDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='metadata']")
	private WebElement metadataTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='installation_date']")
	private WebElement installationDateTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='last_service']")
	private WebElement lastServiceDateTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='next_service']")
	private WebElement nextServiceDateTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='group']")
	private WebElement groupTbx;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'tech_id')]")
	private WebElement technicianIdDrpDwn;
	@FindBy(xpath = "//mat-select[contains(@ng-reflect-name,'user_notify_id')]")
	private WebElement userNotifyDrpDwn;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This AssetID already exists']")
	private WebElement errorMsg;
	@FindBy(xpath = "(//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary' and @ng-reflect-disabled='false'])")
	private WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButton;

	public AssetPage(WebDriver driver) {
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

	public WebElement getAssetIDTbx() {
		return assetIDTbx;
	}

	public WebElement getTagIDTbx() {
		return tagIDTbx;
	}

	public WebElement getAssetTypeIDDrpDwn() {
		return assetTypeIDDrpDwn;
	}

	public WebElement getDepartmentIDDrpDwn() {
		return departmentIDDrpDwn;
	}

	public WebElement getSubDepartmentIDDrpDwn() {
		return subDepartmentIDDrpDwn;
	}

	public WebElement getAmcExpireDate() {
		return amcExpireDate;
	}

	public WebElement getBoughtPriceTbx() {
		return boughtPriceTbx;
	}

	public WebElement getCurrentPriceTbx() {
		return currentPriceTbx;
	}

	public WebElement getLocationIdDrpDwn() {
		return locationIdDrpDwn;
	}

	public WebElement getVendorCompanyIdDrpDwn() {
		return vendorCompanyIdDrpDwn;
	}

	public WebElement getAssetTypeDrpDwn() {
		return assetTypeDrpDwn;
	}

	public WebElement getManufacturerIdDrpDwn() {
		return manufacturerIdDrpDwn;
	}

	public WebElement getModelIdDrpDwn() {
		return modelIdDrpDwn;
	}

	public WebElement getMetadataTbx() {
		return metadataTbx;
	}

	public WebElement getInstallationDate() {
		return installationDateTbx;
	}

	public WebElement getLastServiceDate() {
		return lastServiceDateTbx;
	}

	public WebElement getNextServiceDate() {
		return nextServiceDateTbx;
	}

	public WebElement getGroupTbx() {
		return groupTbx;
	}

	public WebElement getTechnicianIdDrpDwn() {
		return technicianIdDrpDwn;
	}

	public WebElement getUserNotifyDrpDwn() {
		return userNotifyDrpDwn;
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

	public void addAsset(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Asset");
		System.out.println(count);

		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			//String assetID = Long.toString(epochTime);

			// Reading all field data from excel
			//String assetID = elib.readDataFromExcel("Asset", i, 0);
			//String tagID = elib.readDataFromExcel("Asset", i, 0);
			String assetTypeID = elib.readDataFromExcel("Asset", i, 0);
			//String tagID = Long.toString(epochTime);
			String departmentID = elib.readDataFromExcel("Asset", i, 1);
			String subDepartmentID = elib.readDataFromExcel("Asset", i, 2);
			String amcExpiryDate = elib.readDataFromExcel("Asset", i, 3);
			String boughtprice = elib.readDataFromExcel("Asset", i, 4);
			String currentprice = elib.readDataFromExcel("Asset", i, 5);
			String locationid = elib.readDataFromExcel("Asset", i, 6);
			String vendorCompanyID = elib.readDataFromExcel("Asset", i, 7);
			String assetType = elib.readDataFromExcel("Asset", i, 8);
			String manufacturerID = elib.readDataFromExcel("Asset", i, 9);
			String modelID = elib.readDataFromExcel("Asset", i, 10);
			String metaData = elib.readDataFromExcel("Asset", i, 11);
			String installationDate = elib.readDataFromExcel("Asset", i, 12);
			String latestServiceDate = elib.readDataFromExcel("Asset", i, 13);
			String nextServiceDate = elib.readDataFromExcel("Asset", i, 14);
			String group = elib.readDataFromExcel("Asset", i, 15);
			String technicianID = elib.readDataFromExcel("Asset", i, 16);
			String userNotifyID = elib.readDataFromExcel("Asset", i, 17);
			String tagID = elib.readDataFromExcel("Asset", i, 18);
			String assetID = elib.readDataFromExcel("Asset", i, 19);
			Thread.sleep(1000);
			// click on Add new button
			AddBtn.click();
			Thread.sleep(1000);
			// adding value into the asset id textbox
			assetIDTbx.sendKeys(assetID);
			// adding value into the tag ID  textbox
			tagIDTbx.sendKeys(tagID);
			Thread.sleep(1000);
			System.out.println(assetTypeID);
			Thread.sleep(500);
			// click on asset type id dropdown
			assetTypeIDDrpDwn.click();
			System.out.println("dropdown clicked successfully");
			Thread.sleep(500);
			// dynamic xpath for asset type id webelement
			WebElement assetTypeIDWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'" + "" + assetTypeID + "" +  "')]"));
			System.out.println(assetTypeIDWe);
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, assetTypeIDWe);
			// click on specific location id webelement
			assetTypeIDWe.click();
			// click on department id dropdown
			departmentIDDrpDwn.click();
			// dynamic xpath for department id webelement
			WebElement departmentIDWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'" +  "" + departmentID + "" + "')]"));
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, departmentIDWe);
			// click on specific location id webelement
			departmentIDWe.click();
			// click on subdepartment id dropdown
			subDepartmentIDDrpDwn.click();
			// dynamic xpath for subdepartment id webelement
			WebElement subdepartmentIDWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'" + ""  + subDepartmentID + "" +  "')]"));
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, subdepartmentIDWe);
			// click on specific location id webelement
			subdepartmentIDWe.click();

			// adding value into the amc expire date textbox
			amcExpireDate.sendKeys(amcExpiryDate);
			// adding value into the bought price textbox
			boughtPriceTbx.sendKeys(boughtprice);
			// adding value into the current price textbox
			currentPriceTbx.sendKeys(currentprice);
			Thread.sleep(1000);
			// click on location id dropdown
			locationIdDrpDwn.click();
			// dynamic xpath for location id webelement
			WebElement locationIDWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'"  + "" + locationid + "" + "')]"));
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, locationIDWe);
			// click on specific location id webelement
			locationIDWe.click();
			// click on vendor company id dropdown
			vendorCompanyIdDrpDwn.click();
			// dynamic xpath for vendor company  id webelement
			WebElement vendorCompanyIDWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'" +  "" + vendorCompanyID + "" + "')]"));
			// scroll action for the dynamic location id webelement
			wlib.scrollAction(driver, vendorCompanyIDWe);
			// click on specific location id webelement
			vendorCompanyIDWe.click();
			// click on asset type dropdown
			assetTypeDrpDwn.click();
			// dynamic xpath for asset type webelement
			WebElement assetTypeWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'"  + "" + assetType + "" +  "')]"));
			// scroll action for the dynamic asset type webelement
			wlib.scrollAction(driver, assetTypeWe);
			// click on specific asset type webelement
			assetTypeWe.click();
			// click on Manfacturer id dropdown
			manufacturerIdDrpDwn.click();
			// dynamic xpath for Manfacturer id webelement
			WebElement manufacturerWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'"  + "" + manufacturerID + "" + "')]"));
			// scroll action for the dynamic Manfacturer id webelement
			wlib.scrollAction(driver, manufacturerWe);
			// click on specific Manfacturer id webelement
			manufacturerWe.click();
			// click on Model id dropdown
			modelIdDrpDwn.click();
			// dynamic xpath for Model id webelement
			WebElement modelWe = driver
					.findElement(By.xpath("//mat-option[contains(@ng-reflect-value,'"  + "" + modelID + "" +  "')]"));
			// scroll action for the dynamic Model id webelement
			wlib.scrollAction(driver, modelWe);
			// click on specific Model id webelement
			modelWe.click();
			// adding value into the metadata  textbox
			metadataTbx.sendKeys(metaData);
			// adding value into the installation date  textbox
			installationDateTbx.sendKeys(installationDate);
			// adding value into the latest service date textbox
			lastServiceDateTbx.sendKeys(latestServiceDate);
			// adding value into the next service  date  textbox
			nextServiceDateTbx.sendKeys(nextServiceDate);
			// adding value into the group  textbox
			groupTbx.sendKeys(group);
			// click on technician id dropdown
			technicianIdDrpDwn.click();
			// dynamic xpath for technician id webelement
			WebElement technicianIDWe = driver
					.findElement(By.xpath("(//span[contains(text(),'" + "" + technicianID + "" +  "')])[2]"));
			// scroll action for the dynamic technician id webelement
			wlib.scrollAction(driver, technicianIDWe);
			// click on specific technician id webelement
			technicianIDWe.click();
			// click on user notify id dropdown
			userNotifyDrpDwn.click();
			wlib.waitForPageLoad(driver);
			// dynamic xpath for problem id web element
			//WebElement UNWe = driver.findElement(By.xpath("//span[contains(text(),'" + userNotifyID + "" +  "')]"));
			//WebElement UNWe = driver.findElement(By.xpath("//span[contains(text(),'"+userNotifyID+"')]/ancestor::div[@class='cdk-overlay-pane']/div/div[@id=\"mat-select-20-panel\"]/descendant::span[contains(text(),'"+userNotifyID+"')]"));
			//WebElement UNWe =driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']/descendant-or-self::span[contains(text(),'"+userNotifyID+"') and @class='mat-option-text']"));
			WebElement UNWe=driver.findElement(By.xpath("//mat-pseudo-checkbox[@class='mat-pseudo-checkbox mat-option-pseudo-checkbox ng-star-inserted']/following-sibling::span[contains(text(),'"+userNotifyID+"')]"));
			System.out.println("usernotifyid"+userNotifyID);
			// scroll action for the dynamic problem id web element
			wlib.scrollAction(driver, UNWe);
			// click on specific problem id web element
			wlib.waitForPageLoad(driver);
			UNWe.click();
			wlib.waitForPageLoad(driver);
			
			// scroll action for the save button
			//wlib.scrollAction(driver, saveButton);
			try {
				//wlib.scrollAction(driver, saveButton);
				//saveBtn.click();
				// action class will close the hidden popup after selecting problems
				Actions actions = new Actions(driver);
				actions.moveToElement(saveButton).doubleClick(saveButton).build().perform();
			} catch (Exception e) {
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver, cancelBtn);
				cancelBtn.click();
				System.out.println(locationid + " " + duplicateID);

			}
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-asset_id mat-column-asset_id ng-star-inserted' and text()='"
							+ " " + "" + assetID + "']"))
					.getText();
			Assert.assertEquals(assetID, ActualId);
			System.out.println(assetID + " added successfully");

		}

	}
}
