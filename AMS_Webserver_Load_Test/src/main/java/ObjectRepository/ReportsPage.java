package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class ReportsPage {
	public static ExcelFileUtility elib = new ExcelFileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshbtn;
	@FindBy(xpath = "//mat-paginator[@class='mat-paginator']")
	private WebElement itemlength;
	@FindBy(xpath = "//mat-row[@role='row']")
	private WebElement rowdata;
	//@FindBy(xpath = "//mat-label[contains(text(),'Choose me')]")
	@FindBy(xpath = "//div[contains(@class,'mat-select-arrow-wrapper')]")
	//div[contains(@class,'mat-select-arrow-wrapper')]
	private WebElement choosemeoption;
	@FindBy(xpath = "//span[contains(text(),'Form Type')]")
	private WebElement formtype;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ')])[2]")
	//@FindBy(xpath = "//div[@class='col-sm ng-star-inserted']/mat-form-field/descendant::mat-label[contains(text(),'Choose me')]")
	private WebElement choosemeoptionFT;
	@FindBy(xpath ="//mat-option[@tabindex='0']")
	private WebElement firstform;
	@FindBy(xpath ="//button/span[contains(text(),'Submit Query')]")
	private WebElement submitquery;
	@FindBy(xpath ="//div[@id='table0_info']")
	private WebElement itemLengthform;
	
	

	

	public static ExcelFileUtility getElib() {
		return elib;
	}

	public WebDriverUtility getWlib() {
		return wlib;
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

	public ReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loadTicketTable(WebDriver driver) throws Throwable {
		wlib.waitForPageLoad(driver);
        wlib.waitForPageLoadTimeOut(driver);
		//Thread.sleep(10000);
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
		Reporter.log("Total item of ticket reports table: "+totalItem,true);
	}
	public void loadFormTable(WebDriver driver) throws Throwable {
		wlib.waitForPageLoad(driver);
        wlib.waitForPageLoadTimeOut(driver);
        wlib.waitForElementToBeClickable(choosemeoption);
        //choosemeoption.click();
        Thread.sleep(5000);
        formtype.click();
        Thread.sleep(2000);
        choosemeoptionFT.click();
        firstform.click();
        submitquery.click();
        
		//Thread.sleep(10000);
		//wlib.waitForElementToBeClickable(driver, rowdata);
		// Get the text content of the element
		String itemLength = itemLengthform.getText();

		// Extract the numeric value from the text (assuming it is always in the format "x – y of z.")
		String[] parts = itemLength.split(" ");
		String iL = parts[parts.length - 2];

		// Convert the numeric value to an integer
		int totalItem = Integer.parseInt(iL);

		// Verify the actual value is greater than 10 using TestNG assertion
		Assert.assertTrue(totalItem > 0, "Total items greter than zero");
		Reporter.log("Total item of form reports table: "+totalItem,true);
	}
	
}
