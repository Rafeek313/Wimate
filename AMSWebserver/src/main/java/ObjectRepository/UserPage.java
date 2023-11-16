package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class UserPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='user_id']")
	private WebElement userIdTbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[2]")
	private WebElement alertEmailDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[3]")
	private WebElement alertSMSDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[4]")
	private WebElement reportingToUserIDDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[5]")
	private WebElement escalationEmailDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[6]")
	private WebElement escalationSMSDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[7]")
	private WebElement mobilePrivacyDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[8]")
	private WebElement deptIDDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[9]")
	private WebElement subDeptIDDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[10]")
	private WebElement roleIDDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[11]")
	private WebElement telegramDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[12]")
	private WebElement notificationrecievedDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[13]")
	private WebElement smsrecievedDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[14]")
	private WebElement usertypeDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='Description']")
	private WebElement descriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='Metadata']")
	private WebElement MetaDataTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='email']")
	private WebElement emailTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='mobile']")
	private WebElement phoneNoTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='name']")
	private WebElement usernameTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='username']")
	private WebElement passwordTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='client']")
	private WebElement clientIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='telegramID']")
	private WebElement telegramIdTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindAll({@FindBy(xpath = "//span[text()='This UserID already exists']"),@FindBy(xpath = "//span[text()='This Email ID already exists']")})
	private WebElement errorMsg;
	@FindBy(xpath = "//mat-icon[.='refresh']")
	private WebElement refreshBtn;

	@FindBy(xpath = "//span[text()='Save']")
	//@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
	private WebElement saveBtn ;
	@FindAll({ @FindBy(xpath = "//span[text()=' Enable ']"),@FindBy(xpath="//mat-option[@ng-reflect-value='true']") })
	private WebElement enableOption;
	@FindAll({@FindBy(xpath = "//span[text()=' Disable ']"),@FindBy(xpath="//mat-option[@ng-reflect-value='false']") })
	private WebElement disableOption;
	@FindAll({@FindBy(xpath = "//span[text()=' Visible ']"),@FindBy(xpath="//mat-option[@ng-reflect-value='true']") })
	private WebElement visibleOption;
	@FindAll({@FindBy(xpath = "//span[text()=' Invisible ']"),@FindBy(xpath="//mat-option[@ng-reflect-value='false']") })
	private WebElement invisibleOption;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebDriverUtility getWlib() {
		return wlib;
	}

	public ExcelFileUtility getElib() {
		return elib;
	}

	public WebElement getAddBtn() {
		return AddBtn;
	}

	public WebElement getUserIdTbx() {
		return userIdTbx;
	}

	public WebElement getAlertEmailDrpDwn() {
		return alertEmailDrpDwn;
	}

	public WebElement getAlertSMSDrpDwn() {
		return alertSMSDrpDwn;
	}

	public WebElement getReportingToUserIDDrpDwn() {
		return reportingToUserIDDrpDwn;
	}

	public WebElement getEscalationEmailDrpDwn() {
		return escalationEmailDrpDwn;
	}

	public WebElement getEscalationSMSDrpDwn() {
		return escalationSMSDrpDwn;
	}

	public WebElement getMobilePrivacyDrpDwn() {
		return mobilePrivacyDrpDwn;
	}

	public WebElement getDeptIDDrpDwn() {
		return deptIDDrpDwn;
	}

	public WebElement getSubDeptIDDrpDwn() {
		return subDeptIDDrpDwn;
	}

	public WebElement getRoleIDDrpDwn() {
		return roleIDDrpDwn;
	}



	public WebElement getTelegramDrpDwn() {
		return telegramDrpDwn;
	}

	public WebElement getNotificationrecievedDrpDwn() {
		return notificationrecievedDrpDwn;
	}

	public WebElement getSmsrecievedDrpDwn() {
		return smsrecievedDrpDwn;
	}

	public WebElement getUsertypeDrpDwn() {
		return usertypeDrpDwn;
	}

	public WebElement getTelegramIdTbx() {
		return telegramIdTbx;
	}

	public WebElement getDescriptionTbx() {
		return descriptionTbx;
	}

	public WebElement getMetaDataTbx() {
		return MetaDataTbx;
	}

	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getPhoneNoTbx() {
		return phoneNoTbx;
	}

	public WebElement getUsernameTbx() {
		return usernameTbx;
	}

	public WebElement getClientIdTbx() {
		return clientIdTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getEnableOption() {
		return enableOption;
	}

	public WebElement getDisableOption() {
		return disableOption;
	}

	public WebElement getVisibleOption() {
		return visibleOption;
	}

	public WebElement getInvisibleOption() {
		return invisibleOption;
	}

	public void addUser(WebDriver driver) throws Throwable {
		wlib.waitForPageLoadTimeOut(driver);
		wlib.waitForPageLoad(driver);
		int rowcount = elib.getRowCount("User");
		String[] users = new String[rowcount];
		int fprowcount = elib.getRowCount("formTypeData");
		for (int i = 1; i <= rowcount; i++) {
			wlib.fullscreenWindow(driver);
			wlib.waitForPageLoadTimeOut(driver);
			wlib.waitForPageLoad(driver);
			long epochTime = System.currentTimeMillis();
			String userId = Long.toString(epochTime);
			//String userId = elib.readDataFromExcel("User", i, 0);
			String alertEmail = elib.readDataFromExcel("User", i, 0);
			String alertSMS = elib.readDataFromExcel("User", i, 1);
			String description = elib.readDataFromExcel("User", i, 2);
			String emailID = elib.readDataFromExcel("User", i, 3);
			String reportingToUserID = elib.readDataFromExcel("User", i, 4);
			String escalationemail = elib.readDataFromExcel("User", i, 5);
			String escalationSMS = elib.readDataFromExcel("User", i, 6);
			String phoneNo = elib.readDataFromExcel("User", i, 7);
			String mobilePrivacy = elib.readDataFromExcel("User", i, 8);
			String metadata = elib.readDataFromExcel("User", i, 9);
			String username = elib.readDataFromExcel("User", i, 10);
			String password = elib.readDataFromExcel("User", i, 11);
			String departmentID = elib.readDataFromExcel("User", i, 12);
			String subdepartmentID = elib.readDataFromExcel("User", i, 13);
			String roleID = elib.readDataFromExcel("User", i, 14);
			String clientID = elib.readDataFromExcel("User", i, 15);
			String telegramID = elib.readDataFromExcel("User", i, 16);
			String telegramNotification = elib.readDataFromExcel("User", i, 17);
			String notificationrecieved = elib.readDataFromExcel("User", i, 18);
			String smsnotification = elib.readDataFromExcel("User", i, 19);
			String userType = elib.readDataFromExcel("User", i, 20);
			System.out.println(userType);

			// click on Add icon
			AddBtn.click();
			Thread.sleep(1000);
			// enter the value in the user id texbox
			userIdTbx.sendKeys(userId);
			// click alert email dropdown
			alertEmailDrpDwn.click();
			// selecting the option based on excel value
			if (alertEmail.equalsIgnoreCase("Enable")) {
				wlib.waitForElementToBePresent(driver, enableOption);
				enableOption.click();
			} else {
				wlib.waitForElementToBePresent(driver, disableOption);
				disableOption.click();
			}
			// click on alert alert SMS drop down button
			alertSMSDrpDwn.click();
			// selecting the option based on excel value
			if (alertSMS.equalsIgnoreCase("Enable")) {
				wlib.waitForElementToBePresent(driver, enableOption);
				Thread.sleep(1000);
				enableOption.click();
			} else {
				wlib.waitForElementToBePresent(driver, disableOption);
				disableOption.click();
			}
			// Adding value into the description text field
			descriptionTbx.sendKeys(description);
			// Adding value in to the email text field
			emailTbx.sendKeys(emailID);
			// click on Reporting to user id drop down button
			reportingToUserIDDrpDwn.click();
			// dynamic xpath for selecting the reporting user id
			WebElement reportingUser = driver.findElement(By.xpath("//span[contains(text(),' " + reportingToUserID+ " ')]"));
			Thread.sleep(1000);
			// scroll action to the specific element
			wlib.scrollAction(driver, reportingUser);
			Thread.sleep(1000);
			reportingUser.click();
			// click on Escalation email drop down button
			escalationEmailDrpDwn.click();
			// selecting the option based on excel value
			if (escalationemail.equalsIgnoreCase("Enable")) {
				enableOption.click();
			} else {
				disableOption.click();
			}
			// click on Escalation SMS drop down button
			escalationSMSDrpDwn.click();
			// selecting the option based on excel value
			if (escalationSMS.equalsIgnoreCase("Enable")) {
				wlib.waitForElementToBePresent(driver, enableOption);
				enableOption.click();
			} else {
				wlib.waitForElementToBePresent(driver, disableOption);
				disableOption.click();
			}
			// Adding value in to the phone no text field
			phoneNoTbx.sendKeys(phoneNo);
			// click on Mobile privacy drop down button
			mobilePrivacyDrpDwn.click();
			// selecting the option based on excel value
			if (mobilePrivacy.equalsIgnoreCase("Visible")) {
				visibleOption.click();
			} else {
				invisibleOption.click();
			}
			// Adding value in to the metadata  text field
			MetaDataTbx.sendKeys(metadata);
			// Adding value in to the metadata  text field
			usernameTbx.sendKeys(username);
			// Adding value in to the metadata  text field
			passwordTbx.sendKeys(password);
			//click on department id drop down button
			deptIDDrpDwn.click();
			// dynamic xpath for selecting the department id
			WebElement departmentId = driver.findElement(By.xpath("//span[contains(text(),' " + departmentID + " ')]"));
			Thread.sleep(1000);
			// scroll action to the specific element
			wlib.scrollAction(driver, departmentId);
			Thread.sleep(1000);
			departmentId.click();

			//click on sub department id drop down button
			subDeptIDDrpDwn.click();
			// dynamic xpath for selecting the sub department id
			WebElement subDepartmentId = driver.findElement(By.xpath("//span[contains(text(),' " + subdepartmentID + " ')]"));
			Thread.sleep(1000);
			// scroll action to the specific element
			wlib.scrollAction(driver, subDepartmentId);
			Thread.sleep(1000);
			subDepartmentId.click();
			//click on role id drop down button
			roleIDDrpDwn.click();
			// dynamic xpath for selecting the role id
			WebElement roleId = driver.findElement(By.xpath("//span[contains(text(),' " + roleID + " ')]"));
			Thread.sleep(1000);
			// scroll action to the specific element
			wlib.scrollAction(driver, roleId);
			Thread.sleep(1000);
			roleId.click();
			// Adding value in to the client id text field
			clientIdTbx.sendKeys(clientID);
			// Adding value in to the telegram id text field
			telegramIdTbx.sendKeys(telegramID);
			//click on telegram notification  drop down button
			telegramDrpDwn.click();
			//dynamic xpath for selecting the telegram notification option 
			WebElement telegramoption = driver.findElement(By.xpath("//span[text()='"+" "+""+telegramNotification+""+" "+"']"));
			telegramoption.click();
			//click on  notification recieved drop down button
			// scroll action to the specific element
			wlib.scrollAction(driver, saveBtn);
			notificationrecievedDrpDwn.click();
			//dynamic xpath for selecting the notification recieved option 
			WebElement notificationoption = driver.findElement(By.xpath("//span[text()='"+" "+""+notificationrecieved+""+" "+"']"));

			wlib.waitForPageLoad(driver);
			notificationoption.click();
			wlib.scrollAction(driver, saveBtn);
			//click on sms  notification recieved drop down button
			smsrecievedDrpDwn.click();
			//dynamic xpath for selecting the  sms  notification recieved option 
			WebElement smsrecievedoption = driver.findElement(By.xpath("//span[text()='"+" "+""+smsnotification+""+" "+"']"));
			wlib.waitForPageLoad(driver);
			smsrecievedoption.click();
			//click on user type  drop down button
			usertypeDrpDwn.click();
			//dynamic xpath for selecting the user Type id
			WebElement usertype = driver.findElement(By.xpath("//span[text()='"+" "+""+userType+""+" "+"']"));	
			wlib.waitForPageLoad(driver);
			usertype.click();

			//click on save button
			try {
				saveBtn.click();
				users[i-1]=username;
			}
			catch(Exception e)
			{ 
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver,cancelBtn);
				cancelBtn.click();
				System.out.println(userId+" "+duplicateID);
			}
			try{
				refreshBtn.click();
				wlib.waitForPageLoad(driver);
				String ActualId = driver.findElement(By.xpath(
						"//mat-cell[@class='mat-cell cdk-cell cdk-column-user_id mat-column-user_id ng-star-inserted' and text()='"
								+ " " + "" + userId + "']"))
						.getText();
				Assert.assertEquals(userId, ActualId);
			}
			catch(Exception e)
			{   refreshBtn.click();
			wlib.waitForPageLoad(driver);
			String ActualId=driver.findElement(By.xpath("//div[text()='"+emailID+"']")).getText();
			Assert.assertEquals(emailID, ActualId);
			}
			elib.writeDataIntoExcel("Asset", i, 16, username);
			elib.writeDataIntoExcel("Asset", i, 17, userId+" "+"-"+" "+username);
	
		}
		// this method used to add all users into the formtype excel sheet with seperation of comma
					StringBuilder result = new StringBuilder();

			        for (int i = 0; i < users.length; i++) {
			            result.append(users[i]);
			            if (i < users.length - 1) {
			                result.append(", ");
			            }
			        }


	}


}
