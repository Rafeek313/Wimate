package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class FormTypePage {
	public static ExcelFileUtility elib = new ExcelFileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement addicon;
	@FindBy(xpath = "//input[@ng-reflect-name='typeID']")
	private WebElement typeIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='typeLable']")
	private WebElement typeLabelTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='typeDescription']")
	private WebElement typeDescriptionTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='emailSubject']")
	private WebElement emailSubjectTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='emailHeader']")
	private WebElement emailHeaderTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='emailBody']")
	private WebElement emailBodyTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='emailFooter']")
	private WebElement emailFooterTbx;
	@FindBy(xpath = "//ng-multiselect-dropdown[@ng-reflect-name='emailRecipent']/descendant::input[@type='text' and @placeholder='Search']")
	private WebElement searchERTbx;
	@FindBy(xpath = "//ng-multiselect-dropdown[@ng-reflect-name='typeparameterID']/descendant::input[@type='text' and @placeholder='Search']")
	private WebElement searchTPIdTbx;
	@FindBy(xpath = "//ng-multiselect-dropdown[@ng-reflect-name='emailRecipent']")
	private WebElement emailRecipientDrpdwn;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='emailEnable']")
	private WebElement emailEnableDrpdwn;
	@FindBy(xpath = "//ng-multiselect-dropdown[@ng-reflect-name='typeparameterID']")
	private WebElement typeParamIdDrpdwn;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='formIDvisible']")
	private WebElement formVisibleDrpdwn;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='lablevisible']")
	private WebElement labelVisibleDrpdwn;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='descriptionvisible']")
	private WebElement descriptionVisibleDrpdwn;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='other']")
	private WebElement otherDrpdwn;
	@FindBy(xpath = "//span[text()=' None ']")
	private WebElement noneOption;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='mqtt_id']")
	private WebElement mqttIdDrpdwn;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement savebtn;
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary mat-button-disabled']")
	private WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelbtn;
	@FindBy(xpath = "//span[text()=' True ']")
	private WebElement trueoption;
	@FindBy(xpath = "//span[text()=' False ']")
	private WebElement falseoption;
	@FindBy(xpath = "//input[@placeholder='Search' and @type='text']")
	private WebElement searchBtn;
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshbtn;

	public WebElement getAddicon() {
		return addicon;
	}

	public WebElement getTypeIdTbx() {
		return typeIdTbx;
	}

	public WebElement getTypeLabelTbx() {
		return typeLabelTbx;
	}

	public WebElement getTypeDescriptionTbx() {
		return typeDescriptionTbx;
	}

	public WebElement getEmailSubjectTbx() {
		return emailSubjectTbx;
	}

	public WebElement getEmailHeaderTbx() {
		return emailHeaderTbx;
	}

	public WebElement getEmailBodyTbx() {
		return emailBodyTbx;
	}

	public WebElement getEmailFooterTbx() {
		return emailFooterTbx;
	}

	public WebElement getEmailRecipientDrpdwn() {
		return emailRecipientDrpdwn;
	}

	public WebElement getEmailEnableDrpdwn() {
		return emailEnableDrpdwn;
	}

	public WebElement getTypeParamIdDrpdwn() {
		return typeParamIdDrpdwn;
	}

	public WebElement getFormVisibleDrpdwn() {
		return formVisibleDrpdwn;
	}

	public WebElement getLabelVisibleDrpdwn() {
		return labelVisibleDrpdwn;
	}

	public WebElement getDescriptionVisibleDrpdwn() {
		return descriptionVisibleDrpdwn;
	}

	public WebElement getOtherDrpdwn() {
		return otherDrpdwn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public FormTypePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void creatingFormType(WebDriver driver) throws Throwable {
		wlib.waitForPageLoad(driver);

		int rowcount = elib.getRowCount("FormTypedata");
		System.out.println(rowcount);
		for (int i = 1; i <= rowcount; i++) {
			long epochTime = System.currentTimeMillis();
			String typeId = Long.toString(epochTime);
			String typeLabel = Long.toString(epochTime);
			//String typeId = elib.readDataFromExcel("FormTypedata", i, 0);
			//String typeLabel = elib.readDataFromExcel("FormTypedata", i, 0);
			String typedescription = elib.readDataFromExcel("FormTypedata", i, 0);
			String emailSubject = elib.readDataFromExcel("FormTypedata", i, 1);
			String emailHeader = elib.readDataFromExcel("FormTypedata", i, 2);
			String emailBody = elib.readDataFromExcel("FormTypedata", i, 3);
			String emailFooter = elib.readDataFromExcel("FormTypedata", i, 4);
			String emailReciepient = elib.readDataFromExcel("FormTypedata", i, 5);
			String emailEnable = elib.readDataFromExcel("FormTypedata", i, 6);
			String typeParameterId = elib.readDataFromExcel("FormTypedata", i, 7);
			String formVisible = elib.readDataFromExcel("FormTypedata", i, 8);
			String labelVisible = elib.readDataFromExcel("FormTypedata", i, 9);
			String descriptionVisible = elib.readDataFromExcel("FormTypedata", i, 10);
			String other = elib.readDataFromExcel("FormTypedata", i, 11);
			String mqttId = elib.readDataFromExcel("FormTypedata", i, 12);
			addicon.click();
			Thread.sleep(1000);
			typeIdTbx.sendKeys(typeId);
			typeLabelTbx.sendKeys(typeLabel);
			typeDescriptionTbx.sendKeys(typedescription);
			emailSubjectTbx.sendKeys(emailSubject);
			emailHeaderTbx.sendKeys(emailHeader);
			emailBodyTbx.sendKeys(emailBody);
			emailFooterTbx.sendKeys(emailFooter);
			//wlib.scrollAction(driver, otherDrpdwn);
			emailRecipientDrpdwn.click();
			List<String> users = elib.readExcelDatawithCommaSeperation(6, 5, 1);
			System.out.println(users.toString());
			for (String emailreciepient : users)
			{
				searchERTbx.sendKeys(emailreciepient);
				WebElement emailrecipientelement = driver
						.findElement(By.xpath("//div[text()='"+ emailreciepient +"']"));				// scroll action for the dynamic problem id web element
				Thread.sleep(1000);
				wlib.scrollAction(driver, emailrecipientelement);
				Thread.sleep(1000);
				emailrecipientelement.click();
				Thread.sleep(2000);
				WebElement searchcleartbx=driver.findElement(By.xpath("//input[contains(@ng-reflect-model,'"+emailreciepient+"') and @placeholder='Search']"));
				searchcleartbx.clear();
			}
			
			
			WebElement eeelement = driver.findElement(By.xpath("//mat-select[@ng-reflect-name='emailEnable']"));
			wlib.mousehover(driver, eeelement);
			wlib.doublecClickAction(driver);
			// wlib.doublecClickAction(driver, eeelement);
			Thread.sleep(1000);
			emailEnableDrpdwn.click();
			if (emailEnable.equals("TRUE")) {
				Thread.sleep(1000);
				trueoption.click();
			} else {
				falseoption.click();
			}
			Thread.sleep(1000);
			//wlib.scrollAction(driver, otherDrpdwn);
			typeParamIdDrpdwn.click();
			//this 
			List<String> typeParamIds = elib.readCommaSeparatedColumn(6, 7);
			System.out.println(typeParamIds.toString());
			for (String typeParamId : typeParamIds)
			{
				searchTPIdTbx.sendKeys(typeParamId);
				//WebElement parameteridelement = driver.findElement(By.xpath("//div[contains(text(),'"+typeParamId+"')]"));
				WebElement parameteridelement = driver.findElement(By.xpath("//li[@class='multiselect-item-checkbox ng-star-inserted']/div[contains(text(),'"+typeParamId+"')]"));
				Thread.sleep(1000);
				wlib.scrollAction(driver, parameteridelement);
				Thread.sleep(1000);
				parameteridelement.click();
				WebElement searchcleartbx=driver.findElement(By.xpath("//input[contains(@ng-reflect-model,'"+typeParamId+"') and @placeholder='Search']"));
				searchcleartbx.clear();
			}
			wlib.mousehover(driver, formVisibleDrpdwn);
			wlib.doublecClickAction(driver);
			//wlib.doublecClickAction(driver, formVisibleDrpdwn);
			Thread.sleep(1000);
			formVisibleDrpdwn.click();
			if (formVisible.equals("TRUE")) {
				Thread.sleep(1000);
				trueoption.click();
			} else {
				falseoption.click();
			}
			wlib.scrollAction(driver, otherDrpdwn);
			labelVisibleDrpdwn.click();
			if (labelVisible.equals("TRUE")) {
				Thread.sleep(1000);
				trueoption.click();
			} else {
				Thread.sleep(1000);
				falseoption.click();
			}
			descriptionVisibleDrpdwn.click();
			if (descriptionVisible.equals("TRUE")) {
				Thread.sleep(1000);
				trueoption.click();
			} else {
				Thread.sleep(1000);
				falseoption.click();
			}
			otherDrpdwn.click();
			if (other.equals("None")) {
				Thread.sleep(1000);
				noneOption.click();
			} else {
				falseoption.click();
			}
			Thread.sleep(1000);
			mqttIdDrpdwn.click();
			WebElement mqttoption = driver.findElement(By.xpath("//span[contains(text(),' "+	mqttId+"')]"));
			wlib.scrollAction(driver, mqttoption);
			Thread.sleep(1000);
			mqttoption.click();
			Thread.sleep(1000);
			wlib.scrollAction(driver);
			String disabletxt = driver.findElement(By.xpath("//button[contains(@type,'submit()')]"))
					.getAttribute("ng-reflect-disabled");
			// String disabletxt = saveBtn.getAttribute("ng-reflect-disabled");
			Thread.sleep(1000);
			if (disabletxt.equals("false")) {
				Thread.sleep(1000);
				savebtn.click();
				Thread.sleep(1000);
				refreshbtn.click();
				searchBtn.clear();
				searchBtn.sendKeys(typeId);
				String Expecteddata = typeId;
				System.out.println(Expecteddata);

				// String ActualData = driver.findElement(By.xpath("//mat-cell[contains(text(),'" + typeId + "')]"))
				//		.getText();
				String ActualData = driver.findElement(By.xpath("//div[text()='" + typeId + "']"))
								.getText();
//				if (Expecteddata.contains(ActualData)) {
//					Assert.assertTrue(true);
//				} else {
//					Assert.assertTrue(false);
//				}
				Assert.assertEquals(Expecteddata, ActualData);
				System.out.println(typeId + " Added successfully");
			} else {
				Thread.sleep(1000);

				cancelbtn.click();
				refreshbtn.click();
				searchBtn.clear();
				searchBtn.sendKeys(typeId);
				String Expecteddata = typeId;
				System.out.println(Expecteddata);
				Thread.sleep(2000);
				String ActualData = driver.findElement(By.xpath("//mat-cell[contains(text(),'" + typeId + "')]"))
						.getText();
//				if (Expecteddata.contains(ActualData)) {
//					Assert.assertTrue(true);
//				} 
//				else {
//					Assert.assertTrue(false);
//				}
				Assert.assertEquals(Expecteddata, ActualData);
				System.out.println(typeId + " Already exist");
			}
		}
		Reporter.log("form type added successfully", true);
	}
}
