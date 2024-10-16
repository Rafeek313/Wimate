package FormTest;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.SkipLogin;
import ObjectRepository.AssetMapPage;
import ObjectRepository.AssetPage;
//import ObjectRepository.CustomerMaster;
import ObjectRepository.Equipmentmaster;
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
//import ObjectRepository.RegisterComplaints;
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
	 Equipmentmaster empage;
//	 CustomerMaster cmpage;
//	 RegisterComplaints rcpage;
	ExcelFileUtility elib = new ExcelFileUtility();
	public void setUp(Method method) throws IOException {
        // Check if the method is annotated with @SkipLogin
        if (method.getAnnotation(SkipLogin.class) == null) {
            login(); // Call login from the BaseClass
        }
    }
	/**
	 * this method used for creating MQTT Broker in AMSv2 app
	 * 
	 * @author rafeek
	 */
	@Test(priority = 1,enabled=false )
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
	@Test(priority = 3,enabled=false)
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
	@Test(priority = 4,enabled=false)
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
	@Test(priority = 5,enabled=false)
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
	@Test(priority = 5,enabled=false)
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
	@Test(priority = 6,enabled=false)
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
	@Test(priority = 7,enabled=false)
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
	@Test(priority = 8,enabled=false)
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
	@Test(priority = 9,enabled=false)
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
	@Test(priority = 10,enabled=true)
	public void addProblemBtn() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonProblemButton(driver);
		problemPage= new ProblemPage(driver);
		problemPage.addProblem(driver);
		Reporter.log("problems added successfully",true);

	}
	/**
	 * this method is used for adding asset map for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 11,enabled=true)
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
	@Test(priority =7)
	public void addUser() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonUserButton(driver);
		userPage = new UserPage(driver);
		userPage.addUser(driver);
		Reporter.log(" new user added successfully",true);

	}
	@Test(priority =7)
	public void updateUser() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonUserButton(driver);
		userPage = new UserPage(driver);
		userPage.updateuser(driver);
		Reporter.log("  user updated  successfully",true);

	}
	/**
	 * this method is used for adding asset for ticket configuration 
	 * @author rafeek
	 */
	@Test(priority = 12,enabled=false)
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
	@Test(priority = 13, enabled=true)
	public void addAsset() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton(driver);
		homePage.clickonAssetButton(driver);
		assetPage = new AssetPage(driver);
		assetPage.addAsset(driver);
		Reporter.log(" new user added successfully",true);

	}
	/**
	 * this method is used for delete Equipment master for climaveneta 
	 * @author rafeek
	 */
	@Test(priority = 13, enabled=true)
	public void deleteEMitem() throws IOException, Throwable {
		empage = new Equipmentmaster(driver);
		empage.deleteEMitem(driver);
		Reporter.log(" equipment deleted successfully",true);

	}
	/**
	 * this method is used for verifying CID for ticket configuration 
	 * @author rafeek
	 */
//	@Test(priority = 13, enabled=true)
//	public void verifyCID() throws IOException, Throwable {
//		cmpage = new CustomerMaster(driver);
//		cmpage.verifyCID(driver);
//		Reporter.log(" equipment deleted successfully",true);
//
//	}
//	/**
//	 * this method is used for finding duplicate id   IN Customer master new table 
//	 * @author rafeek
//	 */
//	@Test(priority = 13, enabled=true)
//	public void duplicatecid() throws IOException, Throwable {
//		cmpage = new CustomerMaster(driver);
//		cmpage.duplicateID(driver);
//		Reporter.log(" duplicate cid fetched successfully",true);
//
//	}
//	@Test
//    @SkipLogin
//	public void raisedcomplaint() throws IOException, Throwable {
//		rcpage=new RegisterComplaints(driver);
//		rcpage.raisedcomplaint(driver,"TEST_RFK","TEST","rafeek",9483460652l,"rafeek@wimate.in","banglore","Others","issue");
//	}
}
