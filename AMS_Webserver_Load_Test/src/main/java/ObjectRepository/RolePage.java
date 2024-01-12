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

public class RolePage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='role_id']")
	private WebElement modelIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='time_mult']")
	private WebElement timeMultiplerTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This ModelID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshBtn;

	public RolePage(WebDriver driver) {
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

	public void addRole(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Role");
		System.out.println(count);
		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			//String roleid = Long.toString(epochTime);
			String roleid = elib.readDataFromExcel("Role", i, 0);
			String description = elib.readDataFromExcel("Role", i, 1);
			String metadata = elib.readDataFromExcel("Role", i, 2);
			String timeMultiplier = elib.readDataFromExcel("Role", i, 3);
			AddBtn.click();
			Thread.sleep(1000);
			modelIdTbx.sendKeys(roleid);
			descriptionTbx.sendKeys(description);
			MetaDataTbx.sendKeys(metadata);
			timeMultiplerTbx.sendKeys(timeMultiplier);
			try {
				saveBtn.click();
				}
				catch(Exception e)
				{ 
					String duplicateID = errorMsg.getText();
					wlib.scrollAction(driver,cancelBtn);
					cancelBtn.click();
					System.out.println(roleid+" "+duplicateID);
					
			    }
			refreshBtn.click();
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-role_id mat-column-role_id ng-star-inserted' and text()='"
							+ " " + "" + roleid + "']"))
					.getText();
			Assert.assertEquals(roleid, ActualId);
			//elib.writeDataIntoExcel("User", i, 14, roleid);
		}
		{
		}
	}
}


