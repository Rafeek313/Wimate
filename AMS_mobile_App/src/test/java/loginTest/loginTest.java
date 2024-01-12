package loginTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.TaskPage;

public class loginTest extends BaseClass{
LoginPage loginpage=new LoginPage(driver);
HomePage homePage=new HomePage(driver);
TaskPage taskPage=new TaskPage(driver);
@Test
public void loginapp() throws IOException, InterruptedException
{
	wlib.waitForPageLoad(driver);
	Thread.sleep(1000);
}
@ Test
public void createTask() throws InterruptedException, AWTException {
	homePage=new HomePage(driver);
	homePage.clickOnTaskButton();
	taskPage=new TaskPage(driver);
	taskPage.createNewTask();
	Reporter.log("task is created", true);
	
}
}
