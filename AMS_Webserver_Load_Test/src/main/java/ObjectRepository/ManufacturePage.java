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

public class ManufacturePage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy (xpath="//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy (xpath="//input[@ng-reflect-name='manufacturer_id']")
	private WebElement manufactureIdTbx;
	@FindBy (xpath="//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy (xpath="//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This ManufacturerID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
	public ManufacturePage(WebDriver driver) {
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
	
	public WebElement getManufactureIdTbx() {
		return manufactureIdTbx;
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
	/** 
	 * this method is used for Adding manufacture in the ticket configuration
	 * @author rafeek
	 * @throws Throwable 
	 * @throws IOException 
	 */
	public void addManufacture(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Manufacture");
		System.out.println(count);
		for(int i=1;i<=count;i++) {
			long epochTime = System.currentTimeMillis();
			String manufactureid = Long.toString(epochTime);
		//String manufactureid = elib.readDataFromExcel("Manufacture", i, 0);
		String description = elib.readDataFromExcel("Manufacture", i, 0);
		String metadata = elib.readDataFromExcel("Manufacture", i, 1);
		Thread.sleep(1000);
		AddBtn.click();
		Thread.sleep(500);
		manufactureIdTbx.sendKeys(manufactureid);
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
				System.out.println(manufactureid+" "+duplicateID);
				
		    }
		String ActualId = driver.findElement(By.xpath("//mat-cell[@class='mat-cell cdk-cell cdk-column-manufacturer_id mat-column-manufacturer_id ng-star-inserted' and text()='"+" "+""+manufactureid+"']")).getText();
		Assert.assertEquals(manufactureid, ActualId);
		elib.writeDataIntoExcel("Asset", i, 9, manufactureid);
	}
}
}
