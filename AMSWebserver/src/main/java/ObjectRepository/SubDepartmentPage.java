package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class SubDepartmentPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy (xpath="//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy (xpath="//input[@ng-reflect-name='sub_dept_id']")
	private WebElement subDeptId;
	@FindBy (xpath="//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy (xpath="//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy (xpath="//span[text()='Save']")
	private WebElement saveBtn;
	public SubDepartmentPage(WebDriver driver) {
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
	public WebElement getSubDeptId() {
		return subDeptId;
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
	/** 
	 * this method is used for Adding Sub department in the ticket configuration
	 * @author rafeek
	 */
	public void AddSubDepartment(WebDriver driver) throws Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("SubDepartment");
		for(int i=1;i<=count;i++) {
		String subdepartmentid = elib.readDataFromExcel("SubDepartment", i, 0);
		String description = elib.readDataFromExcel("SubDepartment", i, 1);
		String metadata = elib.readDataFromExcel("SubDepartment", i, 2);
		AddBtn.click();
		Thread.sleep(1000);
		subDeptId.sendKeys(subdepartmentid);
		descriptionTbx.sendKeys(description);
		MetaDataTbx.sendKeys(metadata);
		saveBtn.click();
		String ActualId = driver.findElement(By.xpath("//mat-cell[@class='mat-cell cdk-cell cdk-column-sub_dept_id mat-column-sub_dept_id ng-star-inserted' and text()='"+" "+""+subdepartmentid+"']")).getText();
		Assert.assertEquals(subdepartmentid, ActualId);
	}
	
}
}
