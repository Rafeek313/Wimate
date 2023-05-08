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

public class DepartmentPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy (xpath="//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy (xpath="//input[@ng-reflect-name='dept_id']")
	private WebElement departmentID;
	@FindBy (xpath="//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy (xpath="//input[@ng-reflect-name='Metadata']")
	private WebElement metadataTbx;
	@FindBy (xpath="//span[text()='Save']")
	private WebElement saveBtn;
	public DepartmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDepartmentID() {
		return departmentID;
	}
	public WebElement getAddBtn() {
		return AddBtn;
	}
	public WebElement getDescriptionTbx() {
		return descriptionTbx;
	}
	public WebElement getMetadataTbx() {
		return metadataTbx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/** 
	 * this method is used for Adding  department in the ticket configuration
	 * @author rafeek
	 */
	public void addDepartment(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Department");
		for(int i=1;i<=count;i++) {
		String departmentid = elib.readDataFromExcel("Department", i, 0);
		String description = elib.readDataFromExcel("Department", i, 1);
		String Metadata = elib.readDataFromExcel("Department", i, 2);
		AddBtn.click();
		Thread.sleep(2000);
		departmentID.sendKeys(departmentid);
		descriptionTbx.sendKeys(description);
		metadataTbx.sendKeys(Metadata);
		saveBtn.click();
		String ActualId = driver.findElement(By.xpath("//mat-cell[@class=\"mat-cell cdk-cell cdk-column-dept_id mat-column-dept_id ng-star-inserted\" and text()='"+" "+""+departmentid+"']")).getText();
		Assert.assertEquals(departmentid, ActualId);
		
		
	}
	
	}

}
