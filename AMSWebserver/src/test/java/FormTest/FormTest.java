package FormTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.AssetMapPage;
import ObjectRepository.AssetPage;
import ObjectRepository.DepartmentPage;
import ObjectRepository.FormParameterPage;
import ObjectRepository.FormTypePage;
import ObjectRepository.HomePage;
import ObjectRepository.LocationPage;
import ObjectRepository.LocationTypePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ManufacturePage;
import ObjectRepository.ModelPage;
import ObjectRepository.MqttPage;
import ObjectRepository.PriorityPage;
import ObjectRepository.ProblemPage;
import ObjectRepository.RolePage;
import ObjectRepository.SubDepartmentPage;
import ObjectRepository.UserPage;
import ObjectRepository.VendorCompanyPage;

public class FormTest extends BaseClass {
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
	ExcelFileUtility elib = new ExcelFileUtility();
	/**
	 * this method used for creating MQTT Broker in AMSv2 app
	 * 
	 * @author rafeek
	 */
	@Test(priority = 1 )
	public void createMqttbroker() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonMqttButton(driver);
		mqttPage = new MqttPage(driver);
		mqttPage.addMqttBroker(driver);
		Reporter.log("mqtt broker added successfully", true);
	}
	/**
	 * this method used for creating form parameter in AMSv2 app
	 * 
	 * @author rafeek
	 */
	@Test(priority = 1,enabled=false )
	public void createFormParameter() throws Throwable {
		homePage = new HomePage(driver);
		homePage.clickonFormParameter();
		formParameterPage = new FormParameterPage(driver);
		formParameterPage.createFormParameter(driver);
		Reporter.log("form parameter added successfully", true);
	}

	/**
	 * this method used for creating form type in AMSv2 app
	 * 
	 * @author rafeek
	 */
	@Test(priority = 2, enabled=false)
	public void createFormType() throws Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonFormType();
		formtypePage = new FormTypePage(driver);
		formtypePage.creatingFormType(driver);

	}

	/**
	 * this method is used for adding department for user configuration
	 */
	@Test(priority = 3)
	public void addDepartment() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonDepartmentButton();
		departmentPage = new DepartmentPage(driver);
		departmentPage.addDepartment(driver);
		Reporter.log("department added successfully",true);

	}

	/**
	 * this method is used for adding sub department for user configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 4)
	public void addSubDepartment() throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonSubDepartmentButton(driver);
		subdepartmentpage = new SubDepartmentPage(driver);
		subdepartmentpage.AddSubDepartment(driver);
		Reporter.log("sub department added successfully",true);

	}
	/**
	 * this method is used for adding role for user configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 4)
	public void addRole() throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonRoleButton(driver);
		rolePage = new RolePage(driver);
		rolePage.addRole(driver);
		Reporter.log("role added successfully",true);

	}

	/**
	 * this method is used for adding manufacture for ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 5)
	public void addManufacture() throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonManufactureButton(driver);
		manufacturepage = new ManufacturePage(driver);
		manufacturepage.addManufacture(driver);
		Reporter.log("manufacture added successfully",true);

	}

	/**
	 * this method is used for adding model for ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 6)
	public void addModel() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonModelButton(driver);
		modelpage = new ModelPage(driver);
		modelpage.addModel(driver);
		Reporter.log("model added successfully",true);

	}
	/**
	 * this method is used for adding priority for ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test(priority = 7)
	public void addPriority() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonPriorityButton(driver);
		prioritypage = new PriorityPage(driver);
		prioritypage.addPriority(driver);
		Reporter.log("model added successfully",true);

	}
	/**
	 * this method is used for adding location type for ticket configuration
	 * @author rafeek
	 */
	@Test(priority = 8)
	public void addLocationType() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonLocationTypeButton(driver);
		locationTypePage = new LocationTypePage(driver);
		locationTypePage.addLocationType(driver);
		Reporter.log("location type   added successfully",true);

	}
	/**
	 * this method is used for adding location for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 9)
	public void addLocation() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonLocationButton(driver);
		locationpage = new LocationPage(driver);
		locationpage.addLocation(driver);
		Reporter.log("location  added successfully",true);

	}
	/**
	 * this method is used for adding  for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 10)
	public void addProblemBtn() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonProblemButton(driver);
		problemPage= new ProblemPage(driver);
		problemPage.addProblem(driver);
		Reporter.log("asset map added successfully",true);

	}
	/**
	 * this method is used for adding asset map for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 11)
	public void addAssetMap() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonAssetMapButton(driver);
		assetMapPage = new AssetMapPage(driver);
		assetMapPage.addAssetMap(driver);
		Reporter.log("asset map added successfully",true);

	}

	/**
	 * this method is used for adding user for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 0, enabled=false)
	public void addUser() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonUserButton(driver);
		userPage = new UserPage(driver);
		userPage.addUser(driver);
		Reporter.log(" new user added successfully",true);

	}
	/**
	 * this method is used for adding asset for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 12)
	public void addVendorCompany() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonVendorCompanyButton(driver);
		vcPage=new VendorCompanyPage(driver);
		vcPage.addVendorCompany(driver);
		Reporter.log(" new vendor company added successfully",true);

	}
	/**
	 * this method is used for adding asset for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 13)
	public void addAsset() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonAssetButton(driver);
		assetPage = new AssetPage(driver);
		assetPage.addAsset(driver);
		Reporter.log(" new user added successfully",true);

	}
}
