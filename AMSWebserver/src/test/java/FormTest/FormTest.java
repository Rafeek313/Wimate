package FormTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.FormParameterPage;
import ObjectRepository.FormTypePage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;


public class FormTest extends BaseClass{
LoginPage loginpage;
HomePage homePage;
FormParameterPage formParameterPage;
FormTypePage formtypePage;
ExcelFileUtility elib=new ExcelFileUtility();

@ Test
public void createFormParameter() throws Throwable {
	homePage=new HomePage(driver);
	homePage.clickonFormParameter();
	 formParameterPage = new FormParameterPage(driver);
	formParameterPage.createFormParameter(driver);	
	Reporter.log("form parameter added successfully",true);
}
@Test
public void createFormType() throws Throwable {
	wlib.waitForPageLoad(driver);
	homePage=new HomePage(driver);
	homePage.clickonFormType();
	formtypePage=new FormTypePage(driver);
	formtypePage.creatingFormType(driver);
	
}
}
