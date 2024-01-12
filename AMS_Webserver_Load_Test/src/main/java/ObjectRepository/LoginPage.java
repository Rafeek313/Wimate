package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class LoginPage {
		@FindBy(xpath="//input[@ng-reflect-name='username']")
		private WebElement usernameTbx;
		@FindBy(xpath="//input[@type='password']")
		private WebElement pwdtbx;
		@FindBy (xpath="//button[@type='submit']")
		private WebElement loginBtn;
		@FindBy(xpath="//a[text()='Forgot Password?']")
		private WebElement forgotpwdlink;
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public WebElement getUsernameTbx() {
			return usernameTbx;
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
		public void login(String username,String pwd) {
			usernameTbx.sendKeys(username);
			pwdtbx.sendKeys(pwd);
			loginBtn.click();
		}
		}

