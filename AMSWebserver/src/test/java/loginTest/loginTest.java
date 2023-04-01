package loginTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.FormParameterPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;


public class loginTest extends BaseClass{
LoginPage loginpage=new LoginPage(driver);
HomePage homePage=new HomePage(driver);
FormParameterPage formParameterPage=new FormParameterPage(driver);
ExcelFileUtility elib=new ExcelFileUtility();

@ Test
public void createFormParameter() throws Throwable {
	homePage=new HomePage(driver);
	homePage.clickonFormParameter();
	 formParameterPage = new FormParameterPage(driver);
	formParameterPage.createFormParameter(driver);	
	Reporter.log("form parameter added successfully",true);
}
}
