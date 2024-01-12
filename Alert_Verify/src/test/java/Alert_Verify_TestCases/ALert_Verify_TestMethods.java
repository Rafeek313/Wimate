package Alert_Verify_TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.text.ParseException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import DateFormat_converter.One_minute_Offest;
import DateFormat_converter.Report_Page_DT;
import Excel_Utility.Excel_Read;
import Excel_Utility.Excel_write;
import MQTT_Utility.MQTT_Send_Data;
import Selenium_utility.Selenium_functions;
import Telegram_Utility.Telegram_Connect;
import Webdrivermanager_Utility.WebdriverManager_Setup;
import WebserverPage_Utility.Dashboard_Page;
import WebserverPage_Utility.Report_Page;
import WebserverPage_Utility.Webserver_Login;

@Listeners(itestListener_Utility.Isuitelistener_test.class)

public class ALert_Verify_TestMethods extends WebdriverManager_Setup {

	Webserver_Login Login;
	Dashboard_Page DB_Page;
	Selenium_functions sel_Fun;
	Report_Page RP_Page;
	Telegram_Connect Telegram_msg;

	@BeforeMethod
	public void Beforemethod() {
		// Setup for Chrome driver using webdriver Manager
		driver_Setup();
	}

	@Test
	public void Alert_Active() throws Exception {
		Login = new Webserver_Login(driver);
		DB_Page = new Dashboard_Page(driver);
		sel_Fun = new Selenium_functions();
		RP_Page = new Report_Page(driver);
		//DB_Page.Generate_Alert();
		sel_Fun.full_Screen(driver);
		Login.Login_Cloud();
		DB_Page.WaitForTree_Clickable();
		DB_Page.Generate_Alert();
		DB_Page.WaitForSelect_Device();
		DB_Page.DB_Alert_DT_Status();
		DB_Page.close_Alertpopup();
		DB_Page.Report_page();
		RP_Page.Selcting_Device();

		String MQTT_DT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 1, 0);
		String DEB_DT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 2, 0);
		String REP_DT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 5, 0);
		String DB_Alert_status = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 3, 0);
		String RP_Alert_Status = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 4, 0);

		System.out.println("MQTT DT :" + MQTT_DT);
		System.out.println("DEB_DT :" + DEB_DT);
		System.out.println("REP_DT :" + REP_DT);
		
		DB_Page.Closed_Alert();//If u close alert here then alert duration will be less.


		if (MQTT_DT.equals(DEB_DT)) {
			if (DEB_DT.equals(REP_DT)) {
				if (DB_Alert_status.equals(RP_Alert_Status)) {
					Excel_write.excelWrite_overwrite("PASS", 1, 11, "Alert_Verify.xlsx", 0);
					//Telegram_Connect.Telegram_request("Alert Generationis working in IN-memory and MongoDB through MQTT");
				} else {
					Excel_write.excelWrite_overwrite("FAIL", 1, 11, "Alert_Verify.xlsx", 0);
					Telegram_Connect.Telegram_request("Alert Generation is not working in IN-memory and MongoDB through MQTT");
				}
			} else {
				// int Diff_Min1 = One_minute_Offest.DT_Comapre(DEB_DT, REP_DT);
				int Diff_Min1 = One_minute_Offest.DT_Comapre(DEB_DT, REP_DT);
				if (Diff_Min1 <= 1) {
					if (DB_Alert_status.equals(RP_Alert_Status)) {
						Excel_write.excelWrite_overwrite("PASS", 1, 11, "Alert_Verify.xlsx", 0);
						//Telegram_Connect.Telegram_request("Alert Generation is working in IN-memory and MongoDB through MQTT");
					} else {
						Excel_write.excelWrite_overwrite("FAIL", 1, 11, "Alert_Verify.xlsx", 0);
						Telegram_Connect.Telegram_request("Alert Generation is not working in IN-memory and MongoDB through MQTT");
					}
				} else {
					System.out.println("Between Two Dates Difference is more than 1 minute...");
				}
			}
		} else {
			int Diff_Min = One_minute_Offest.DT_Comapre(MQTT_DT, DEB_DT);
			if (Diff_Min <= 1) {
				if (DEB_DT.equals(REP_DT)) {
					if (DB_Alert_status.equals(RP_Alert_Status)) {
						Excel_write.excelWrite_overwrite("PASS", 1, 11, "Alert_Verify.xlsx", 0);
						//Telegram_Connect.Telegram_request("Alert Generation is working in IN-memory and MongoDB through MQTT");
					} else {
						Excel_write.excelWrite_overwrite("FAIL", 1, 11, "Alert_Verify.xlsx", 0);
						Telegram_Connect.Telegram_request("Alert Generation is not working in IN-memory and MongoDB through MQTT");
					}
				} else {
					int Diff_Min1 = One_minute_Offest.DT_Comapre(DEB_DT, REP_DT);
					if (Diff_Min1 <= 1) {
						if (DB_Alert_status.equals(RP_Alert_Status)) {
							Excel_write.excelWrite_overwrite("PASS", 1, 11, "Alert_Verify.xlsx", 0);
							//Telegram_Connect.Telegram_request("Alert Generation is working in IN-memory and MongoDB through MQTT");
						} else {
							Excel_write.excelWrite_overwrite("FAIL", 1, 11, "Alert_Verify.xlsx", 0);
							Telegram_Connect.Telegram_request("Alert Generation is not working in IN-memory and MongoDB through MQTT");
						}
					} else {
						System.out.println("Between Two Dates Difference is more than 1 minute...");
					}
				}
			} else {
				System.out.println("Between Two Dates Difference is more than 1 minute...");
			}
		}

		String Result_Value = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 11, 0);
		Assert.assertEquals(Result_Value, "PASS");
	}

	@Test
	public void Alert_Close() throws Exception {

		Login = new Webserver_Login(driver);
		DB_Page = new Dashboard_Page(driver);
		sel_Fun = new Selenium_functions();
		RP_Page = new Report_Page(driver);
		//DB_Page.Closed_Alert();//Alert closed is adding in first method so duration will be less
		sel_Fun.full_Screen(driver);
		Login.Login_Cloud();
		DB_Page.WaitForTree_Clickable();
		DB_Page.WaitForSelect_Device();
		DB_Page.DB_Alert_DT_Status();
		DB_Page.close_Alertpopup();
		DB_Page.Report_page();
		RP_Page.Selcting_Device();

		String MQTT_CDT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 6, 0);
		String DEB_CDT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 7, 0);
		String REP_CDT = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 9, 0);
		String DB_Alert_status = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 8, 0);
		String RP_Alert_Status = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 10, 0);

		System.out.println("MQTT DT :" + MQTT_CDT);
		System.out.println("DEB_DT :" + DEB_CDT);
		System.out.println("REP_DT :" + REP_CDT);

		if (MQTT_CDT.equals(DEB_CDT)) {
			if (DEB_CDT.equals(REP_CDT)) {
				if (DB_Alert_status.equals(RP_Alert_Status)) {
					Excel_write.excelWrite_overwrite("PASSED", 1, 11, "Alert_Verify.xlsx", 0);
					//Telegram_Connect.Telegram_request("Alert Closing is working in IN-memory and MongoDB through MQTT");
				} else {
					Excel_write.excelWrite_overwrite("FAILED", 1, 11, "Alert_Verify.xlsx", 0);
					Telegram_Connect
							.Telegram_request("Alert Closing is not working in IN-memory and MongoDB through MQTT");
				}
			} else {
				int Diff_Min1 = One_minute_Offest.DT_Comapre(DEB_CDT, REP_CDT);
				if (Diff_Min1 <= 1) {
					if (DB_Alert_status.equals(RP_Alert_Status)) {
						Excel_write.excelWrite_overwrite("PASSED", 1, 11, "Alert_Verify.xlsx", 0);
						//Telegram_Connect.Telegram_request("Alert Closing is working in IN-memory and MongoDB through MQTT");
					} else {
						Excel_write.excelWrite_overwrite("FAILED", 1, 11, "Alert_Verify.xlsx", 0);
						Telegram_Connect
								.Telegram_request("Alert Closing is not working in IN-memory and MongoDB through MQTT");
					}
				} else {
					System.out.println("Between Two Dates Difference is more than 1 minute...");
				}
			}
		} else {
			System.out.println("MQTT_CDT and DEB_CDT both are not equals...");

			int Diff_Min = One_minute_Offest.DT_Comapre(MQTT_CDT, DEB_CDT);
			System.out.println("Difference between MQTT_CDT and DEB_CDT..." + Diff_Min);

			if (Diff_Min <= 1) {
				if (DEB_CDT.equals(REP_CDT)) {
					if (DB_Alert_status.equals(RP_Alert_Status)) {
						Excel_write.excelWrite_overwrite("PASSED", 1, 11, "Alert_Verify.xlsx", 0);
					//	Telegram_Connect.Telegram_request("Alert Generation is working in IN-memory and MongoDB through MQTT");
					} else {
						Excel_write.excelWrite_overwrite("FAILED", 1, 11, "Alert_Verify.xlsx", 0);
						Telegram_Connect
								.Telegram_request("Alert Closing is not working in IN-memory and MongoDB through MQTT");
					}
				} else {
					System.out.println("DEB_CDT and REP_CDT both are not equals...");

					int Diff_Min1 = One_minute_Offest.DT_Comapre(DEB_CDT, REP_CDT);
					
					System.out.println("Difference between DEB_CDT and REP_CDT..." + Diff_Min);

					if (Diff_Min1 <= 1) {
						if (DB_Alert_status.equals(RP_Alert_Status)) {
							Excel_write.excelWrite_overwrite("PASSED", 1, 11, "Alert_Verify.xlsx", 0);
							//Telegram_Connect.Telegram_request("Alert Generation is working in IN-memory and MongoDB through MQTT");
						} else {
							Excel_write.excelWrite_overwrite("FAILED", 1, 11, "Alert_Verify.xlsx", 0);
							Telegram_Connect.Telegram_request("Alert Closing is not working in IN-memory and MongoDB through MQTT");
						}
					} else {
						System.out.println("Between Two Dates Difference is more than 1 minute...");
					}
				}
			} else {
				System.out.println("Between Two Dates Difference is more than 1 minute...");
			}
		}

		String Result_Value = Excel_Read.Excelread("Alert_Verify.xlsx", 1, 11, 0);
		Assert.assertEquals(Result_Value, "PASSED");

	}

	@AfterMethod
	public void Close_Browser() {
		sel_Fun.Quit_Browser(driver);
	}

	@AfterClass
	public void Close_All_alert() {
		DB_Page.Closed_Alert_No_DT();
	}

}
