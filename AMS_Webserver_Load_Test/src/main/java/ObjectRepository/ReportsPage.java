package ObjectRepository;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	//@FindBy(xpath = "//mat-row[@role='row']")
	@FindBy(xpath = "//div[@role='status']")
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
	@FindBy(xpath ="(//mat-option[@tabindex='0'])[1]")
	private WebElement firstform;
	@FindBy(xpath ="//button/span[contains(text(),'Submit Query')]")
	private WebElement submitquery;
	@FindBy(xpath ="//div[@id='table0_info']")
	private WebElement itemLengthform;
	@FindBy(xpath ="//div/p[contains(text(),'NO FORMS ')]")
	private WebElement noforms;
	

	

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

	public String loadTicketTable(WebDriver driver) throws Throwable {
		//String iL="";
		wlib.waitForPageLoad(driver);
        wlib.waitForPageLoadTimeOut(driver);
		//Thread.sleep(10000);
		double startTime = System.currentTimeMillis();
		wlib.waitForElementToBePresent(driver, rowdata);
		 double endTime = System.currentTimeMillis();
	        //long loadTimeInSeconds = (endTime - startTime) / 1000;
	        double loadTimeInSeconds = (endTime - startTime)/1000;
        //System.out.println("Dashboard load time: " + loadTimeInmilliSeconds + " ms");
		// Get the text content of the element
		String itemLength = rowdata.getText();
		System.out.println("rowdata: "+itemLength);
		Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(itemLength);

        // Find and print the last number in the string
        int lastNumber = 0;
        while (matcher.find()) {
            lastNumber = Integer.parseInt(matcher.group());
        }
        System.out.println("Last number: " + lastNumber);

//		// Extract the numeric value from the text (assuming it is always in the format "x – y of z.")
//		String[] parts = itemLength.split(" ");
//		 iL = parts[parts.length - 2];
//
//		// Convert the numeric value to an integer
//		int totalItem = Integer.parseInt(iL);

		// Verify the actual value is greater than 10 using TestNG assertion
		Assert.assertTrue(lastNumber > 0, "Total items greter than zero");
		Reporter.log("Total item of ticket reports table: "+lastNumber,true);
		//System.out.println("ITEM:"+iL);
		return loadTimeInSeconds+" seconds";
        
	}
	public String loadFormTable(WebDriver driver) throws Throwable {
	//	String iL="";
		//wlib.waitForPageLoad(driver);
        wlib.waitForPageLoadTimeOut(driver);
        wlib.waitForElementToBeClickable(choosemeoption);
        //choosemeoption.click();
        formtype.click();
        Thread.sleep(1000);
        choosemeoptionFT.click();
        Thread.sleep(1000);
        firstform.click();
        submitquery.click();
        double startTime = System.currentTimeMillis();
		//Thread.sleep(10000);
		//wlib.waitForElementToBeClickable(driver, rowdata);
		// Get the text content of the element
        try {
           String message = noforms.getText();
 	        System.out.println(message);
        }
        catch(Exception e)
        {
    		wlib.waitForElementToBeClickable(driver, rowdata);
    		 
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
        double endTime = System.currentTimeMillis();
		   double formloadTimeInSeconds = (endTime - startTime)/1000;
		   
		return formloadTimeInSeconds+" seconds";

	}
	
}
