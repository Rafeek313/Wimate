package FormTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.DepartmentPage;
import ObjectRepository.FormParameterPage;
import ObjectRepository.FormTypePage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ManufacturePage;
import ObjectRepository.SubDepartmentPage;


public class FormTest extends BaseClass{
LoginPage loginpage;
HomePage homePage;
FormParameterPage formParameterPage;
FormTypePage formtypePage;
DepartmentPage departmentPage;
SubDepartmentPage subdepartmentpage;
ManufacturePage manufacturepage;
ExcelFileUtility elib=new ExcelFileUtility();
/**
 * this method used for creating form parameter in AMSv2 app
 * @author rafeek
 */
@ Test
public void createFormParameter() throws Throwable {
	homePage=new HomePage(driver);
	homePage.clickonFormParameter();
	 formParameterPage = new FormParameterPage(driver);
	formParameterPage.createFormParameter(driver);	
	Reporter.log("form parameter added successfully",true);
}
/**
 * this method used for creating form type in AMSv2 app
 * @author rafeek
 */
@Test
public void createFormType() throws Throwable {
	wlib.waitForPageLoad(driver);
	homePage=new HomePage(driver);
	homePage.clickonFormType();
	formtypePage=new FormTypePage(driver);
	formtypePage.creatingFormType(driver);
	
}
/**
 * this method is used for adding department for ticket configuration
 */
@Test
public void addDepartment() throws IOException, Throwable {
	wlib.waitForPageLoad(driver);
	homePage=new HomePage(driver);
	homePage.clickonConfigButton();
	homePage.clickonDepartmentButton();
	departmentPage=new DepartmentPage(driver);
	departmentPage.addDepartment(driver);
	Reporter.log("department added successfully");
	
}
/**
 * this method is used for adding sub department for ticket configuration
 * @author rafeek
 */
@Test
public void addSubDepartment() throws IOException, Throwable {
	
	wlib.waitForPageLoad(driver);
	homePage=new HomePage(driver);
	homePage.clickonConfigButton();
	homePage.clickonSubDepartmentButton(driver);
	subdepartmentpage=new SubDepartmentPage(driver);
	subdepartmentpage.AddSubDepartment(driver);
	Reporter.log("sub department added successfully");
	
}
/**
 * this method is used for adding manufacture for ticket configuration
 * @author rafeek
 */
@Test
public void addManufacture() throws IOException, Throwable {
	
	wlib.waitForPageLoad(driver);
	homePage=new HomePage(driver);
	homePage.clickonConfigButton();
	homePage.clickonManufactureButton(driver);
	manufacturepage=new ManufacturePage(driver);
	manufacturepage.addManufacture(driver);
	Reporter.log("manufacture added successfully");
	
}
}
