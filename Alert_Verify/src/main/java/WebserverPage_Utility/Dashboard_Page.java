package WebserverPage_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DateFormat_converter.Dashboard_Page_DT;
import DateFormat_converter.Report_Page_DT;
import Excel_Utility.Excel_Read;
import Excel_Utility.Excel_write;
import MQTT_Utility.MQTT_Send_Data;
import Selenium_utility.Selenium_functions;
import net.bytebuddy.asm.Advice.Return;

public class Dashboard_Page {

	WebDriver driver;

	public Dashboard_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@uib-tooltip='Diagnostics']")
	private WebElement Diagnostics_Icon;

	@FindBy(xpath = "//*[@class='tooltip1 ng-scope']")
	private WebElement Timeout_icon;

	@FindBy(xpath = "//button[@ng-click='treedisplay()']")
	private WebElement Location_Tree;

	@FindBy(xpath = "//*[@placeholder='Search for Devices']")
	private WebElement Location_Search;

	@FindBy(xpath = "(//span[text()='Automation_Device1'])[1]")
	private WebElement Select_device;

	@FindBy(id = "toggleSpinners")
	private WebElement Ok_Button;

	@FindBy(id = "chart")
	private WebElement Energy_Donut;

//	@FindBy(xpath = "//*[@class='table table-hover  center']//tbody/tr[1]/td[1]")
//	private WebElement Latest_Alerts;

	@FindBy(xpath = "(//*[@class='ibox-content']//tbody/tr[1]/td[1])[1]")
	private WebElement Latest_Alerts;

	@FindBy(xpath = "//*[@class='modal-content']")
	private WebElement Alert_Details;

	@FindBy(xpath = "//*[@ng-class=\"alertObject.status == 'Closed' ?  'label label-primary' :'label label-danger'\"]")
	private WebElement Alert_Status;

	@FindBy(xpath = "(//span[@class='alertPopUpValues ng-binding'])[3]")
	private WebElement Alert_Date;

	@FindBy(xpath = "//button[@class='close']")
	private WebElement Alert_Close_popup;

	@FindBy(xpath = "//*[@ng-show='reports']")
	private WebElement RP_page_Icon;

	@FindBy(xpath = "//*[@class='font-bold ng-binding' and text()='VLN Average']")
	private WebElement Tile_Name;

	@FindBy(xpath = "//*[text()='Column visibility']")
	private WebElement Load_Table_dashboard;

	Selenium_functions Wait = new Selenium_functions();

	public void Wait_Load_DBPage() {
		Wait.waitForElement(driver, Diagnostics_Icon);
		// Wait.waitForElement(driver, Timeout_icon);
		// Wait.waitForElement(driver, Tile_Name);
		Wait.waitForElement(driver, Load_Table_dashboard);
	}

	public void WaitForTree_Clickable() {
		Wait_Load_DBPage();
		Wait.waitForElementtoClickable(driver, Location_Tree);
		Location_Tree.click();
	}

	public void WaitForSelect_Device() {
		Wait.waitForElement(driver, Location_Search);
		Location_Search.click();
		String Device_Name = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 0, 0);
		Location_Search.sendKeys(Device_Name);
		Select_device.click();
		Ok_Button.click();
	}

	public void Generate_Alert() {
		try {
			// Alert is configured for greater than 10 values...
			MQTT_Send_Data.MainMEthod(12);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block In Generate Alert : " + e);
		}
	}

	public void close_Alertpopup() {
		Alert_Close_popup.click();
	}

	public void scollup_page() {
		Wait.Scoll_PageUP_Element(driver);
	}

	public void Closed_Alert() {
		try {
			// Alert is configured for greater than 10 values...
			MQTT_Send_Data.MainMEthod(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block In Closed Alert : " + e);
		}
	}

	public void Closed_Alert_No_DT() {
		try {
			// Alert is configured for greater than 10 values...
			MQTT_Send_Data.MainMEthod(5);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Catch block In Closed Alert : " + e);
		}
	}

	public void DB_Alert_DT_Status() {
		try {
			Wait.waitForElement(driver, Energy_Donut);

			Wait.waitForElement(driver, Tile_Name);
			// Sometimes its throwing stale element exception so added hard sleep for 3
			// sec...
			Selenium_functions sel_util = new Selenium_functions();
			sel_util.Sleep();
			Wait.waitForElement(driver, Latest_Alerts);
			Wait.Sleep();
			Latest_Alerts.click();
			Wait.waitForElement(driver, Alert_Details);

			String Alert_status = Alert_Status.getText();
			System.out.println("Alert Status :" + Alert_status);

			Dashboard_Page_DT DT_Convert = new Dashboard_Page_DT();

			String AlertDB_DT = Alert_Date.getText();
			System.out.println("Alert DB DT :" + AlertDB_DT);

			for (int i = 1; i < AlertDB_DT.length(); i++) {
				char ch[] = AlertDB_DT.toCharArray();

				if (ch[i] == 'o' && ch[i + 1] == ' ') {
					// int DT_Index = AlertDB_DT.indexOf("to");
					// Just for October month passing Index static...Otherwise need to add
					AlertDB_DT = AlertDB_DT.substring(i + 2);
					// System.out.println("CLosed date :" + AlertDB_DT);
					String Converted_DT = DT_Convert.DBconvdate(AlertDB_DT);
					Excel_write.excelWrite_overwrite(Converted_DT, 1, 7, "Alert_Verify.xlsx", 0);
					Excel_write.excelWrite_overwrite(Alert_status, 1, 8, "Alert_Verify.xlsx", 0);
				}

				else {
					String Converted_DT = DT_Convert.DBconvdate(AlertDB_DT);
					// System.out.println("Alert Converted DT : " + Converted_DT);
					Excel_write.excelWrite_overwrite(Converted_DT, 1, 2, "Alert_Verify.xlsx", 0);
					Excel_write.excelWrite_overwrite(Alert_status, 1, 3, "Alert_Verify.xlsx", 0);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in DB :" + e);
			e.printStackTrace();
		}
	}

	public Report_Page Report_page() {
		System.out.println("Report Page...");
		RP_page_Icon.click();
		System.out.println("Report Page clicked...");
		return new Report_Page(driver);
	}

}
