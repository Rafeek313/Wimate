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

public class ModelPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='model_id']")
	private WebElement modelIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This ModelID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;

	public ModelPage(WebDriver driver) {
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

	public WebElement getModelIdTbx() {
		return modelIdTbx;
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

	public void addModel(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Model");
		System.out.println(count);
		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			String modelid = Long.toString(epochTime);
			//String modelid = elib.readDataFromExcel("Model", i, 0);
			String description = elib.readDataFromExcel("Model", i, 0);
			String metadata = elib.readDataFromExcel("Model", i, 1);
			AddBtn.click();
			Thread.sleep(1000);
			modelIdTbx.sendKeys(modelid);
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
					System.out.println(modelid+" "+duplicateID);
					
			    }
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-model_id mat-column-model_id ng-star-inserted' and text()='"
							+ " " + "" + modelid + "']"))
					.getText();
			Assert.assertEquals(modelid, ActualId);
			elib.writeDataIntoExcel("Asset", i, 10, modelid);
		}
		{
		}
	}
}
