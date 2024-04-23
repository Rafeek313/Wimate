package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

	public class FormUserPermissionPage {
		public static ExcelFileUtility elib = new ExcelFileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		@FindBy(xpath = "//mat-icon[text()='refresh']")
		private WebElement refreshbtn;
		@FindBy(xpath = "//mat-paginator[@class='mat-paginator']")
		private WebElement itemlength;
		@FindBy(xpath = "//mat-row[@role='row']")
		private WebElement rowdata;


		

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

		public FormUserPermissionPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public String loadFormUserPermission(WebDriver driver) throws Throwable {
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
			Reporter.log("Total item of form user permission table: "+totalItem,true);
			double endTime = System.currentTimeMillis();
			   double formuserpermissionloadTimeInSeconds = (endTime - startTime)/1000;
			return formuserpermissionloadTimeInSeconds+" seconds";
		}
	

}
