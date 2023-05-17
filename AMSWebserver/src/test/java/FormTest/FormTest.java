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
import ObjectRepository.PriorityPage;
import ObjectRepository.SubDepartmentPage;
import ObjectRepository.UserPage;

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
	ExcelFileUtility elib = new ExcelFileUtility();

	/**
	 * this method used for creating form parameter in AMSv2 app
	 * 
	 * @author rafeek
	 */
	@Test
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
	@Test
	public void createFormType() throws Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonFormType();
		formtypePage = new FormTypePage(driver);
		formtypePage.creatingFormType(driver);

	}

	/**
	 * this method is used for adding department for ticket configuration
	 */
	@Test
	public void addDepartment() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonDepartmentButton();
		departmentPage = new DepartmentPage(driver);
		departmentPage.addDepartment(driver);
		Reporter.log("department added successfully",true);

	}

	/**
	 * this method is used for adding sub department for ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test
	public void addSubDepartment() throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonSubDepartmentButton(driver);
		subdepartmentpage = new SubDepartmentPage(driver);
		subdepartmentpage.AddSubDepartment(driver);
		Reporter.log("sub department added successfully",true);

	}

	/**
	 * this method is used for adding manufacture for ticket configuration
	 * 
	 * @author rafeek
	 */
	@Test
	public void addManufacture() throws IOException, Throwable {

		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
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
	@Test
	public void addModel() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
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
	@Test
	public void addPriority() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonPriorityButton(driver);
		prioritypage = new PriorityPage(driver);
		prioritypage.addPriority(driver);
		Reporter.log("model added successfully",true);

	}
	/**
	 * this method is used for adding location type for ticket configuration
	 * @author rafeek
	 */
	@Test
	public void addLocationType() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonLocationTypeButton(driver);
		locationTypePage = new LocationTypePage(driver);
		locationTypePage.addLocationType(driver);
		Reporter.log("location type   added successfully",true);

	}
	/**
	 * this method is used for adding location for ticket configuration 
	 * @author rafeek
	 */
	@Test
	public void addLocation() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonLocationButton(driver);
		locationpage = new LocationPage(driver);
		locationpage.addLocation(driver);
		Reporter.log("location  added successfully",true);

	}
	/**
	 * this method is used for adding asset map for ticket configuration 
	 * @author rafeek
	 */
	@Test
	public void addAssetMap() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonAssetMapButton(driver);
		assetMapPage = new AssetMapPage(driver);
		assetMapPage.addAssetMap(driver);
		Reporter.log("asset map added successfully",true);

	}
	/**
	 * this method is used for adding user for ticket configuration 
	 * @author rafeek
	 */
	@Test
	public void addUser() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonUserButton(driver);
		userPage = new UserPage(driver);
		userPage.addUser(driver);
		Reporter.log(" new user added successfully",true);

	}
	/**
	 * this method is used for adding asset for ticket configuration 
	 * @author rafeek
	 */
	@Test
	public void addAsset() throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		homePage = new HomePage(driver);
		homePage.clickonConfigButton();
		homePage.clickonAssetButton(driver);
		assetPage = new AssetPage(driver);
		assetPage.addAsset(driver);
		Reporter.log(" new user added successfully",true);

	}
}
