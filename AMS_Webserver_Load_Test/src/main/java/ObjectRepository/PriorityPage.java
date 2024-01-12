package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class PriorityPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='priority_id']")
	private WebElement priorityIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This PriorityID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
 public PriorityPage(WebDriver driver)
 {
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

	public WebElement getPriorityIdTbx() {
		return priorityIdTbx;
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

	public void addPriority(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Priority");
		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			String priorityid = Long.toString(epochTime);
			//String priorityid = elib.readDataFromExcel("Priority", i, 0);
			String description = elib.readDataFromExcel("Priority", i, 0);
			String metadata = elib.readDataFromExcel("Priority", i, 1);
			AddBtn.click();
			Thread.sleep(1000);
			priorityIdTbx.sendKeys(priorityid);
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
					System.out.println(priorityid+" "+duplicateID);
					
			    }
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-priority_id mat-column-priority_id ng-star-inserted' and text()='"
							+ " " + "" + priorityid + "']"))
					.getText();
			Assert.assertEquals(priorityid, ActualId);
			elib.writeDataIntoExcel("Problem", i, 9, priorityid);
			Reporter.log(priorityid+"priority id added successfully",true);
		}
	}
}
