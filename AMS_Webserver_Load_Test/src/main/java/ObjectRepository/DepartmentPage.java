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
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshbtn;
	@FindBy(xpath = "//mat-paginator[@class='mat-paginator']")
	private WebElement itemlength;
	@FindBy(xpath = "//mat-row[@role='row']")
	private WebElement rowdata;
	public DepartmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebDriverUtility getWlib() {
		return wlib;
	}

	public ExcelFileUtility getElib() {
		return elib;
	}


	public WebElement getRefreshbtn() {
		return refreshbtn;
	}
	public WebElement getItemlength() {
		return itemlength;
	}
	public WebElement getRowdata() {
		return rowdata;
	}
	/** 
	 * this method is used for loading  and ping testing   department table  in the ticket configuration
	 * @author rafeek
	 */
	public String loadDepartmentTable(WebDriver driver) throws IOException, Throwable {
        double startTime = System.currentTimeMillis();
		//wlib.waitForPageLoad(driver);
		//refreshbtn.click();
        wlib.waitForPageLoadTimeOut(driver);
		//Thread.sleep(1000);
		wlib.waitForElementToBeClickable(driver, rowdata);
		// Get the text content of the element
		String itemLength = itemlength.getText();

		// Extract the numeric value from the text (assuming it is always in the format "x – y of z.")
		String[] parts = itemLength.split(" ");
		String iL = parts[parts.length - 1];

		// Convert the numeric value to an integer
		int totalItem = Integer.parseInt(iL);

		// Verify the actual value is greater than 10 using TestNG assertion
		Assert.assertTrue(totalItem > 0, "Total items greter than zero");
		Reporter.log("Total item of department table: "+totalItem,true);
		double endTime = System.currentTimeMillis();
		   double departmentloadTimeInSeconds = (endTime - startTime)/1000;
		return departmentloadTimeInSeconds+" seconds";
			
	    }
}
