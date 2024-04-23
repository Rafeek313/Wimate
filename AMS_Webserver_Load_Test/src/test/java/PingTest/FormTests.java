package PingTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.ItestImplementation;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.AssetMapPage;
import ObjectRepository.AssetPage;
import ObjectRepository.DepartmentPage;
import ObjectRepository.FormParameterPage;
import ObjectRepository.FormTypePage;
import ObjectRepository.FormUserPermissionPage;
import ObjectRepository.HomePage;
import ObjectRepository.LocationPage;
import ObjectRepository.LocationTypePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ManufacturePage;
import ObjectRepository.ModelPage;
import ObjectRepository.MqttPage;
import ObjectRepository.PriorityPage;
import ObjectRepository.ProblemPage;
import ObjectRepository.ReportsPage;
import ObjectRepository.RolePage;
import ObjectRepository.SubDepartmentPage;
import ObjectRepository.UserPage;
import ObjectRepository.VendorCompanyPage;

@Listeners({GenericLibrary.IsuitListenerIplementation.class,ItestImplementation.class})
public class FormTests extends BaseClass {
	static double startTime;
	LoginPage loginpage;
	HomePage homePage;
	FormParameterPage formParameterPage;
	FormTypePage formtypePage;
	DepartmentPage departmentPage;
	SubDepartmentPage subdepartmentpage;
	ManufacturePage manufacturepage;
	ModelPage modelpage;
	PriorityPage prioritypage;
	LocationTypePage locationTypePage;
	LocationPage locationpage;
	AssetMapPage assetMapPage;
	UserPage userPage;
	AssetPage assetPage;
	ProblemPage problemPage;
	 VendorCompanyPage vcPage;
	 RolePage rolePage;
	 MqttPage mqttPage;
	 ReportsPage reportsPage;
	 FormUserPermissionPage formpermissionpage;
	ExcelFileUtility elib = new ExcelFileUtility();
	/**
	 * this method used for ping ticket reports page in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 0,enabled=true )
	public void loadTicketReportTest(ITestContext c) throws Throwable {
		//double startTime = System.currentTimeMillis();
		homePage = new HomePage(driver);
		homePage.clickonReportButton(driver);
		Thread.sleep(1000);
		homePage.clickonTicketButton(driver);
		reportsPage = new ReportsPage(driver);
		String loadtime = reportsPage.loadTicketTable(driver);
		System.out.println("LD:"+loadtime);
		c.getSuite().setAttribute("Module Name", "Ticket report table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		//c.getSuite().setAttribute("Result","pass" );
		Reporter.log(" Ticket Report  table loaded successfully", true);

		
	}
	/**
	 * this method used for ping form reports table in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 1,enabled=true )
	public void loadFormReportTest(ITestContext c) throws Throwable {
		//double startTime = System.currentTimeMillis();
		homePage = new HomePage(driver);
		homePage.clickonReportButton(driver);
		Thread.sleep(1000);
		homePage.clickonFormButton(driver);
		reportsPage = new ReportsPage(driver);
		String loadtime = reportsPage.loadFormTable(driver);
		c.getSuite().setAttribute("Module Name", "Form report table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		//c.getSuite().setAttribute("Result","pass" );
		Reporter.log(" form Report  table loaded successfully", true);
	}
	/**
	 * this method used for ping form parameter in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 2,enabled=true )
	public void loadFormParameterTest(ITestContext c) throws Throwable {
		//double startTime = System.currentTimeMillis();
		homePage = new HomePage(driver);
		homePage.clickonFormParameter();
		formParameterPage = new FormParameterPage(driver);
		String loadtime = formParameterPage.LoadFormParameter(driver);
		c.getSuite().setAttribute("Module Name", "Form parameter table ");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("form parameter table loaded successfully", true);
	}

	/**
	 * this method used for ping form type in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 3, enabled=true)
	public void loadFormTypeTest(ITestContext c) throws Throwable {
		//double startTime = System.currentTimeMillis();
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonFormType();
		formtypePage = new FormTypePage(driver);
		String loadtime = formtypePage.loadFormtype(driver);
		c.getSuite().setAttribute("Module Name", "Form type table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("form type table loaded successfully", true);

	}
	/**
	 * this method used for ping form user permission in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 4, enabled=true)
	public void loadFormuserPermissionTest(ITestContext c) throws Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonFormPermissonButton(driver);
		formpermissionpage = new FormUserPermissionPage(driver);
		String loadtime = formpermissionpage.loadFormUserPermission(driver);
		c.getSuite().setAttribute("Module Name", "Form user permission table ");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("form user permission table loaded successfully", true);

	}

	/**
	 * this method is used for ping from department for user configuration
	 */
	@Test(priority = 5,enabled=true)
	public void loadDepartmentTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonDepartmentButton();
		departmentPage = new DepartmentPage(driver);
		String loadtime=departmentPage.loadDepartmentTable(driver);
		c.getSuite().setAttribute("Module Name", "Department table ");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("department table loaded successfully",true);

	}

	/**
	 * this method is used for ping from sub department table in user configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 6,enabled=true)
	public void addSubDepartmentTest(ITestContext c) throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonSubDepartmentButton(driver);
		subdepartmentpage = new SubDepartmentPage(driver);
		String loadtime=subdepartmentpage.loadSubDepartmentTable(driver);
		c.getSuite().setAttribute("Module Name", "Sub Department table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("sub department table loaded successfully",true);

	}
	/**
	 * this method is used for ping from role table in ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 7,enabled=true)
	public void loadRoleTableTest(ITestContext c) throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonRoleButton(driver);
		rolePage = new RolePage(driver);
		String loadtime = rolePage.loadRoleTable(driver);
		c.getSuite().setAttribute("Module Name", "Role table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("role  table loaded successfully",true);

	}

	/**
	 * this method is used for ping from manufacture table in ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 8,enabled=true)
	public void loadManufactureTableTest(ITestContext c) throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonManufactureButton(driver);
		manufacturepage = new ManufacturePage(driver);
		String loadtime=manufacturepage.loadManufactureTable(driver);
		c.getSuite().setAttribute("Module Name", "Manufacture table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("manufacture table loaded successfully",true);

	}

	/**
	 * this method is used for ping from model table in ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 9,enabled=true)
	public void loadModelTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonModelButton(driver);
		modelpage = new ModelPage(driver);
		String loadtime=modelpage.loadModelTable(driver);
		c.getSuite().setAttribute("Module Name", "Model table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("model table loaded successfully",true);

	}
	/**
	 * this method used for ping MQTT Broker table in AMSv2 webserver
	 * 
	 * @author rafeek
	 */
	@Test(priority = 10,enabled=true )
	public void loadMQTTTableTest(ITestContext c) throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonMqttButton(driver);
		mqttPage = new MqttPage(driver);
		String loadtime=mqttPage.loadMQTTTable(driver);
		c.getSuite().setAttribute("Module Name", "MQTT table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("mqtt broker table loaded successfully", true);
	}
	/**
	 * this method is used for ping from priority table in ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 11,enabled=true)
	public void loadPriorityTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonPriorityButton(driver);
		prioritypage = new PriorityPage(driver);
		String loadtime=prioritypage.loadPriorityTable(driver);
		c.getSuite().setAttribute("Module Name", "Priority table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("priority table loaded successfully",true);

	}
	/**
	 * this method is used for ping from location type table in ticket configuration
	 * @author rafeek
	 */
	@Test(priority = 12,enabled=true)
	public void loadLocationTypeTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonLocationTypeButton(driver);
		locationTypePage = new LocationTypePage(driver);
		String loadtime=locationTypePage.loadLocationTypeTable(driver);
		c.getSuite().setAttribute("Module Name", "Location type table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("location type   table loaded successfully",true);

	}
	/**
	 * this method is used for ping from location table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 13,enabled=true)
	public void loadLocationTable(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonLocationButton(driver);
		locationpage = new LocationPage(driver);
		String loadtime=locationpage.loadLocationTable(driver);
		c.getSuite().setAttribute("Module Name", "Location  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("location  table loaded successfully",true);

	}
	/**
	 * this method is used for ping test for problem   table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 14,enabled=true)
	public void loadProblemTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonProblemButton(driver);
		problemPage= new ProblemPage(driver);
		String loadtime=problemPage.loadProblemTable(driver);
		c.getSuite().setAttribute("Module Name", "Problem  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("location  table loaded successfully",true);
		Reporter.log("problem table loaded successfully",true);

	}
	/**
	 * this method is used for ping from asset map table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 15,enabled=true)
	public void loadAssetMapTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonAssetMapButton(driver);
		assetMapPage = new AssetMapPage(driver);
		String loadtime=assetMapPage.loadAssetMapTable(driver);
		c.getSuite().setAttribute("Module Name", "Problem  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("asset map table loaded successfully",true);

	}

	/**
	 * this method is used for ping from user table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority =16,enabled=true)
	public void loadUserTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonUserButton(driver);
		userPage = new UserPage(driver);
		String loadtime=userPage.loadUserTable(driver);
		c.getSuite().setAttribute("Module Name", "User  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("  user table loaded successfully",true);

	}
	/**
	 * this method is used for ping from vendor company table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 17,enabled=false)
	public void loadVendorCompanyTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonVendorCompanyButton(driver);
		vcPage=new VendorCompanyPage(driver);
		String loadtime=vcPage.loadVendorCompanyTable(driver);
		c.getSuite().setAttribute("Module Name", "Vendor company  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("  vendor company table loaded successfully",true);

	}
	/**
	 * this method is used for ping from asset table in ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 18, enabled=false)
	public void loadAssetTableTest(ITestContext c) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonAssetButton(driver);
		assetPage = new AssetPage(driver);
		String loadtime=assetPage.loadAssetTable(driver);
		c.getSuite().setAttribute("Module Name", "Asset  table");
		c.getSuite().setAttribute("Loading Time",loadtime );
		Reporter.log("  Asset table loaded successfully",true);

	}
}
