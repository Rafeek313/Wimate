package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrary.WebDriverUtility;

public class LoginPage {
	WebDriverUtility wlib=new WebDriverUtility();
@FindBy(id="username")
private WebElement userTbx;
@FindBy(id="password")
private WebElement pwdtbx;
@FindBy (xpath="//button[.='Sign in']")
private WebElement loginBtn;
@FindBy(xpath="//a[contains(text(),'Forgot ')]")
private WebElement forgotpwdlink;
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
public WebElement getUserTbx() {
	return userTbx;
}
public WebElement getPwdtbx() {
	return pwdtbx;
}
public WebElement getLoginBtn() {
	return loginBtn;
}
public WebElement getForgotpwdlink() {
	return forgotpwdlink;
}
/**
 * this method will perform login to the application
 * @param username
 * @param pwd
 * @author rafeek
 */
public void login(String username,String pwd,WebDriver driver) {
	wlib.waitForPageLoad(driver);
	userTbx.clear();
	userTbx.sendKeys(username);
	pwdtbx.clear();
	pwdtbx.sendKeys(pwd);
	loginBtn.click();
}
}
