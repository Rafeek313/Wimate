package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class ProblemPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	String locationid = "";
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='problem_id']")
	private WebElement problemIdTbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[2]")
	private WebElement userCommentDrpDwn;
	//@FindBy(xpath = "//span[contains(text(),' Required ')]")
	@FindBy(xpath = "//mat-option/span[text()=' Required ']")
	private WebElement requiredOption;
	//@FindBy(xpath = "//span[contains(text(),' Required ')]")
	@FindBy(xpath = "//mat-option/span[text()=' Optional ']")
	//mat-option/span[text()=' Optional ']
	private WebElement optionalOption;
	@FindBy(xpath = "//input[@ng-reflect-name='comment_Header']")
	private WebElement commentHeaderTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='comment_Prefix']")
	private WebElement commentPrefixTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='comment_Suffix']")
	private WebElement commentSufixTbx;

	@FindBy(xpath = "//input[@ng-reflect-name='description']")
	private WebElement problemLabelTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='escalation_lvl']")
	private WebElement escalationLevelTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='impact']")
	private WebElement impactTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='metadata']")
	private WebElement metadatTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='notif_policy_rem']")
	private WebElement notificationpolicyreminderTbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[3]")
	private WebElement priorityIDDrpDwn;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[4]")
	private WebElement originStatusDrpDwn;
	@FindBy(xpath = "//span[contains(text(),'Open')]")
	private WebElement openStatus;
	@FindBy(xpath = "//span[contains(text(),'In-progress')]")
	private WebElement inprogressStatus;
	@FindBy(xpath = "//span[contains(text(),'Solved')]")
	private WebElement solvedStatus;
	@FindBy(xpath = "//span[contains(text(),'Closed')]")
	private WebElement closedStatus;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[5]")
	private WebElement technicianCommentDrpDwn;
	@FindBy(xpath = "//input[@ng-reflect-name='prob_time']")
	private WebElement problemTimeTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='detail']")
	private WebElement problemDetailTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This ProblemID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshBtn;


	public ProblemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebDriverUtility getWlib() {
		return wlib;
	}



	public ExcelFileUtility getElib() {
		return elib;
	}



	public String getLocationid() {
		return locationid;
	}



	public WebElement getAddBtn() {
		return AddBtn;
	}



	public WebElement getProblemIdTbx() {
		return problemIdTbx;
	}



	public WebElement getUserCommentDrpDwn() {
		return userCommentDrpDwn;
	}



	public WebElement getRequiredOption() {
		return requiredOption;
	}



	public WebElement getOptionalOption() {
		return optionalOption;
	}



	public WebElement getCommentHeaderTbx() {
		return commentHeaderTbx;
	}



	public WebElement getCommentPrefixTbx() {
		return commentPrefixTbx;
	}



	public WebElement getCommentSufixTbx() {
		return commentSufixTbx;
	}



	public WebElement getProblemLabelTbx() {
		return problemLabelTbx;
	}



	public WebElement getEscalationLevelTbx() {
		return escalationLevelTbx;
	}



	public WebElement getImpactTbx() {
		return impactTbx;
	}



	public WebElement getMetadatTbx() {
		return metadatTbx;
	}



	public WebElement getNotificationpolicyreminderTbx() {
		return notificationpolicyreminderTbx;
	}



	public WebElement getPriorityIDDrpDwn() {
		return priorityIDDrpDwn;
	}



	public WebElement getOriginStatusDrpDwn() {
		return originStatusDrpDwn;
	}



	public WebElement getOpenStatus() {
		return openStatus;
	}



	public WebElement getInprogressStatus() {
		return inprogressStatus;
	}



	public WebElement getSolvedStatus() {
		return solvedStatus;
	}



	public WebElement getClosedStatus() {
		return closedStatus;
	}



	public WebElement getTechnicianCommentDrpDwn() {
		return technicianCommentDrpDwn;
	}



	public WebElement getProblemTimeTbx() {
		return problemTimeTbx;
	}



	public WebElement getProblemDetailTbx() {
		return problemDetailTbx;
	}



	public WebElement getCancelBtn() {
		return cancelBtn;
	}



	public WebElement getErrorMsg() {
		return errorMsg;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}



	public WebElement getRefreshBtn() {
		return refreshBtn;
	}



	public void addProblem(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("Problem");
		String[] problems = new String[count];
		for (int i = 17; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			//String problemId = Long.toString(epochTime);
			// Reading all field data from excel
			String problemId = elib.readDataFromExcel("Problem", i, 15);
			String userComment = elib.readDataFromExcel("Problem", i, 0);
			String commentHeader = elib.readDataFromExcel("Problem", i, 1);
			String commentPrefix = elib.readDataFromExcel("Problem", i, 2);
			String commentSufix = elib.readDataFromExcel("Problem", i, 3);
			String problemlabel = elib.readDataFromExcel("Problem", i, 4);
			String escalationlevel = elib.readDataFromExcel("Problem", i, 5);
			String impact = elib.readDataFromExcel("Problem", i, 6);
			String metadata = elib.readDataFromExcel("Problem", i, 7);
			String notificationpolicyreminder = elib.readDataFromExcel("Problem", i, 8);
			String priorityid = elib.readDataFromExcel("Problem", i, 9);
			String originStatus = elib.readDataFromExcel("Problem", i, 10);
			String techniciancomment = elib.readDataFromExcel("Problem", i, 11);
			String problemTime = elib.readDataFromExcel("Problem", i, 12);
			String problemDetail = elib.readDataFromExcel("Problem", i, 13);

			// click on Add new button

			AddBtn.click();
			Thread.sleep(1000);
			// adding value into the Problem id textbox
			problemIdTbx.sendKeys(problemId);
			// clicking usercomment dropdown option
			userCommentDrpDwn.click();
			// select value into the usercomment  select box.
			if(userComment.equals("Required"))
			{
				wlib.waitForElementToBeClickable(driver, requiredOption);
				requiredOption.click();
			}
			else if(userComment.equals("Optional"))
			{
				wlib.waitForElementToBeClickable(driver, optionalOption);
				optionalOption.click();
			}
			else {
				System.out.println("please add proper input for user comment");
			}
			//adding value into the comment header textbox
			commentHeaderTbx.sendKeys(commentHeader);
			// adding value into the comment prefix textbox
			commentPrefixTbx.sendKeys(commentPrefix);
			// adding value into the comment sufix textbox
			commentSufixTbx.sendKeys(commentSufix);
			// adding value into the problem label textbox
			problemLabelTbx.sendKeys(problemlabel);
			// adding value into the escaltion level textbox
			escalationLevelTbx.sendKeys(escalationlevel);
			// adding value into the impact textbox
			impactTbx.sendKeys(impact);
			// adding value into the metadata textbox
			metadatTbx.sendKeys(metadata);
			// adding value into the NPR textbox
			notificationpolicyreminderTbx.sendKeys(notificationpolicyreminder);
			// click on Priority id dropdown
			Thread.sleep(1000);
			priorityIDDrpDwn.click();
			// dynamic xpath for priority id webelement
			WebElement priorityidWe = driver
					.findElement(By.xpath("//span[contains(text(),'" + " " + "" + priorityid + "" + " " + "')]"));
			// scroll action for the dynamic Problem id webelement
			wlib.scrollAction(driver, priorityidWe);
			// click on specific Problem id webelement
			priorityidWe.click();
			// click on origin status dropdown
			originStatusDrpDwn.click();	
			if(originStatus.equalsIgnoreCase("Open"))
			{
				wlib.waitForElementToBeClickable(driver, openStatus);
				openStatus.click();
			}
			else if(originStatus.equalsIgnoreCase("in-progress"))
			{
				wlib.waitForElementToBeClickable(driver, inprogressStatus);
				inprogressStatus.click();
			}
			else if(originStatus.equalsIgnoreCase("solved"))
			{
				wlib.waitForElementToBeClickable(driver, solvedStatus);
				solvedStatus.click();
			}
			else
			{
				System.out.println("enter proper input in origin status");
			}

			// click on technician comment  dropdown
			technicianCommentDrpDwn.click();
			// select value into the technician comment  select box.
			if(userComment.equals("Required"))
			{
				wlib.waitForElementToBeClickable(driver, requiredOption);
				requiredOption.click();
			}
			else if(userComment.equals("Optional"))
			{
				wlib.waitForElementToBeClickable(driver, optionalOption);
				optionalOption.click();
			}
			else {
				System.out.println("please add proper input for technician comment");
			}
			// adding value into the problem time  textbox
			problemTimeTbx.sendKeys(problemTime);
			// adding value into the problem detail  textbox
			problemDetailTbx.sendKeys(problemDetail); 

			// scroll action for the save button
			wlib.scrollAction(driver, saveBtn);
			Thread.sleep(1000);
			try {
				saveBtn.click();
			} catch (Exception e) {
				String duplicateID = errorMsg.getText();
				wlib.scrollAction(driver, cancelBtn);
				cancelBtn.click();
				System.out.println(locationid + " " + duplicateID);

			}
			Thread.sleep(1000);
			refreshBtn.click();
			String ActualId= driver.findElement(By.xpath("//mat-cell[contains(@class,'problem_id ')  and text()='"+" "+""+problemId+"']")).getText();
			Assert.assertEquals(problemId, ActualId);
			// all problems will store problems array
			problems[i-1]=problemId;
			//System.out.println(problemId + " added successfully");
            elib.writeDataIntoExcel("Problem", i, 14, "Added");      

		}
		// this method used to add all problems into the assetmap excel sheet with seperation of comma
		StringBuilder result = new StringBuilder();

        for (int i = 0; i < problems.length; i++) {
            result.append(problems[i]);
            if (i < problems.length - 1) {
                result.append(", ");
            }
        }

        elib.writeDataIntoExcel("AssetMap", 1, 1, result.toString());
		 
	}
}
