package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class AssetMapPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='assetmap_id']")
	private WebElement assetTypeIdTbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[2]")
	private WebElement problemsDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This AssetID already exists']")
	private WebElement errorMsg;
	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
	private WebElement saveButton;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtn;

	public AssetMapPage(WebDriver driver) {
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

	public WebElement getAssetTypeIdTbx() {
		return assetTypeIdTbx;
	}

	public WebElement getProblemsDrpDwn() {
		return problemsDrpDwn;
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

	public void addAssetMap(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("AssetMap");
		for (int i = 1; i <= count; i++) {
			String assettypeid = elib.readDataFromExcel("AssetMap", i, 0);
			String description = elib.readDataFromExcel("AssetMap", i, 1);
			String problemid = elib.readDataFromExcel("AssetMap", i, 2);
			String metadata = elib.readDataFromExcel("AssetMap", i, 3);
			Thread.sleep(1000);
			AddBtn.click();
			Thread.sleep(1000);
			assetTypeIdTbx.sendKeys(assettypeid);
			// click on problem id dropdown
			problemsDrpDwn.click();
			// dynamic xpath for problem id web element
			WebElement problemWe = driver.findElement(By.xpath("//span[text()='" + problemid + "" + " " + "']"));
			// scroll action for the dynamic problem id web element
			wlib.scrollAction(driver, problemWe);
			// click on specific problem id web element
			problemWe.click();
			Thread.sleep(2000);
			// action class will close the hidden popup after selecting problems
			Actions actions = new Actions(driver);
			actions.moveToElement(saveBtn).doubleClick(saveBtn).build().perform();
			Thread.sleep(2000);
			// sending value to the description textbox
			descriptionTbx.sendKeys(description);
			// sending value to the metadata textbox
			MetaDataTbx.sendKeys(metadata);
			// click on save button
			try {
				saveButton.click();
			} catch (Exception e) {
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver, cancelBtn);
				cancelBtn.click();
				System.out.println(assettypeid + " " + duplicateID);

			}
			// validation of newly added asset map by using assertion
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-assetmap_id mat-column-assetmap_id ng-star-inserted' and text()='"
							+ " " + "" + assettypeid + "']"))
					.getText();

			Assert.assertEquals(assettypeid, ActualId);
		}
	}
}
