package WebserverPage_Utility;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import DateFormat_converter.Report_Page_DT;
import Excel_Utility.Excel_write;
import Selenium_utility.Selenium_functions;

public class Report_Page {

	WebDriver driver;

	public Report_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(.,'Parameters')]")
	private WebElement Select_Report_Type;

	@FindBy(xpath = "//div[@id='tickets']/div/form/div/s002/div/div/div/div/div/input")
	private WebElement Report_Type_Input;

	@FindBy(xpath = "(//ul[@class='chosen-results'])[1]")
	private WebElement Select_Alert;

	@FindBy(xpath = "//button[@id='treedata']")
	private WebElement Location_click;

	@FindBy(xpath ="(//input[@type='text'])[2]")
	private WebElement Location_Tree_Input;

	@FindBy(xpath = "(//span[text()='Automation_Device1'])[1]")
	private WebElement Selected_Device;

	@FindBy(xpath = "//button[@type='button']")
	private WebElement Click_ok;

	@FindBy(xpath = "(//div[@class='chosen-container chosen-container-single'])[2]")
	private WebElement Click_date;

	@FindBy(xpath = "(//input[@type='text'])[3]") // Any
	private WebElement Date_Filter;

	@FindBy(xpath = "//div[@id='tickets']/div/form/div[3]/s6/div/div/div/div/ul/li")
	private WebElement Select_any;

	@FindBy(xpath = "//button[@id='apply']")
	private WebElement Apply_reports;

	@FindBy(xpath = "//*[text()=' Table']")
	private WebElement Alert_table;

	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	private WebElement Table_row;

	@FindBy(xpath = "//*[@class='dt-button buttons-collection buttons-colvis']")
	private WebElement Column_Visibility;

	@FindBy(xpath = "//*[@class='dt-button buttons-columnVisibility']/*[text()='created date']")
	private WebElement Select_created_date;

	@FindBy(xpath = "//table/tbody/tr[1]/td[8]")
	private WebElement Alert_Status;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	private WebElement AlertActive_DT;

	@FindBy(xpath = "//table/tbody/tr[1]/td[10]")
	private WebElement AlertClosed_DT;

	public void Selcting_Device() throws Exception {
			Selenium_functions sel_utility = new Selenium_functions();
			sel_utility.scroll_to_top(driver);
			sel_utility.waitForElementtoClickable(driver, Select_Report_Type);
			System.out.println("Report Page is open...");
			Select_Report_Type.click();
			System.out.println("Clicked on report type...");

			Report_Type_Input.sendKeys("Alerts");
			System.out.println("Report Type  is sent in input fields...");

			Select_Alert.click();
			System.out.println("Report Type  is selected...");

			Location_click.click();
			System.out.println("Clicked on Loaction tree...");
			Thread.sleep(500);

			Location_Tree_Input.sendKeys("Automation_Device1");
			System.out.println("Sending device name iin tree..");

			sel_utility.Sleeponemin();
			sel_utility.waitForElement(driver, Selected_Device);
			Thread.sleep(500);
			Selected_Device.click();
			System.out.println("Device is slected in loaction tree");

			Click_ok.click();
			System.out.println("clicked on Loaction OK btn");

			Click_date.click();
			Date_Filter.sendKeys("Any");
			Select_any.click();
			System.out.println("date is slected");

			sel_utility.waitForElementtoClickable(driver, Apply_reports);
			Apply_reports.click();
			System.out.println("Reports applied");

			
			sel_utility.waitForElement(driver, Alert_table);
			// sel_utility.Scoll_PageDown(driver);
			sel_utility.waitForElement(driver, Table_row);
			
			Column_Visibility.click();
			Select_created_date.click();
			sel_utility.Sleeponemin();
			sel_utility.Disableaction(driver);
			String RP_Alert_Status = Alert_Status.getText();

			if (RP_Alert_Status.contains("Active")) {
				Excel_write.excelWrite_overwrite(RP_Alert_Status, 1, 4, "Alert_Verify.xlsx", 0);

				String RP_Alert_DT = AlertActive_DT.getText();
				RP_Alert_DT = Report_Page_DT.RPconvdate(RP_Alert_DT);
				System.out.println("Report Page :"+RP_Alert_DT);
				
				Excel_write.excelWrite_overwrite(RP_Alert_DT, 1, 5, "Alert_Verify.xlsx", 0);
			} else {
				Excel_write.excelWrite_overwrite(RP_Alert_Status, 1, 10, "Alert_Verify.xlsx", 0);

				String RP_Alert_DT = AlertClosed_DT.getText();
				RP_Alert_DT = Report_Page_DT.RPconvdate(RP_Alert_DT);
				System.out.println("RP_ALert_DT :" + RP_Alert_DT);
				System.out.println("Report Page :"+RP_Alert_DT);

				Excel_write.excelWrite_overwrite(RP_Alert_DT, 1, 9, "Alert_Verify.xlsx", 0);
			}

	}

}
