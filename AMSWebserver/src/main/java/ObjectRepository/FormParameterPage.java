package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.WebDriverUtility;

public class FormParameterPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement addicon;
	@FindBy(xpath = "//input[@ng-reflect-name='parameterID']")
	private WebElement parameterIdtbx;
	@FindBy(xpath = "//input[@ng-reflect-name='parameterLable']")
	private WebElement parameterLabeltbx;
	@FindBy(xpath = "//input[@ng-reflect-name='parameterDescription']")
	private WebElement parameterdescriptiontbx;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow ng-tns')])[3]")
	private WebElement requireddropdwnbtn;
	@FindBy(xpath = "//span[text()=' True ']")
	private WebElement trueOption;
	@FindBy(xpath = "//span[text()=' False ']")
	private WebElement falseOption;
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow-wrapper')])[2]")
	private WebElement paramTypeDrpDwnbtn;
	@FindBy(xpath = "//span[text()=' Text ']")
	private WebElement textOption;
	@FindBy(xpath = "//span[text()=' Number ']")
	private WebElement numberOption;
	@FindBy(xpath = "//span[text()=' Single-Select ']")
	private WebElement singleSelectOption;
	@FindBy(xpath = "//input[@ng-reflect-name='list']")
	private WebElement listOption;
	@FindBy(xpath = "//span[text()=' Multi-Select ']")
	private WebElement multiSelectOption;
	@FindBy(xpath = "//span[text()=' Date ']")
	private WebElement DateOption;
	@FindBy(xpath = "//span[text()=' Time ']")
	private WebElement TimeOption;
	@FindBy(xpath = "//span[text()=' Signature ']")
	private WebElement SignatureOption;
	@FindBy(xpath = "//span[text()=' User Single-Select ']")
	private WebElement singleUserOption;
	@FindBy(xpath = "//span[text()=' User Multi-Select ']")
	private WebElement multiUserOption;
	@FindBy(xpath = "//span[text()=' From-System-Show ']")
	private WebElement formSystemShowOption;
	@FindBy(xpath = "//span[text()=' From-System-Hide ']")
	private WebElement formSystemHideOption;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement mintbx;
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement maxtbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelbtn;
	@FindBy(xpath = "//button[@ng-reflect-message='Next page']")
	private WebElement nextPageBtn;
	@FindBy(xpath = "//input[@placeholder='Search' and @type='text']")
	private WebElement searchBtn;
	@FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	private WebElement pageDetails;
	@FindBy(xpath = "//mat-icon[text()='refresh']")
	private WebElement refreshbtn;
	public FormParameterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddicon() {
		return addicon;
	}

	public WebElement getParameterIdtbx() {
		return parameterIdtbx;
	}

	public WebElement getParameterLabeltbx() {
		return parameterLabeltbx;
	}

	public WebElement getParameterdescriptiontbx() {
		return parameterdescriptiontbx;
	}

	public WebElement getRequireddropdwnbtn() {
		return requireddropdwnbtn;
	}

	public WebElement getTrueOption() {
		return trueOption;
	}

	public WebElement getFalseOption() {
		return falseOption;
	}

	public WebElement getParamTypeDrpDwnbtn() {
		return paramTypeDrpDwnbtn;
	}

	public WebElement getTextOption() {
		return textOption;
	}

	public WebElement getNumberOption() {
		return numberOption;
	}

	public WebElement getSingleSelectOption() {
		return singleSelectOption;
	}

	public WebElement getMultiSelectOption() {
		return multiSelectOption;
	}

	public WebElement getDateOption() {
		return DateOption;
	}

	public WebElement getTimeOption() {
		return TimeOption;
	}

	public WebElement getSignatureOption() {
		return SignatureOption;
	}

	public WebElement getSingleUserOption() {
		return singleUserOption;
	}

	public WebElement getMultiUserOption() {
		return multiUserOption;
	}

	public WebElement getFormSystemShowOption() {
		return formSystemShowOption;
	}

	public WebElement getFormSystemHideOption() {
		return formSystemHideOption;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebDriverUtility getWlib() {
		return wlib;
	}

	public ExcelFileUtility getElib() {
		return elib;
	}

	public WebElement getListOption() {
		return listOption;
	}

	public WebElement getMintbx() {
		return mintbx;
	}

	public WebElement getMaxtbx() {
		return maxtbx;
	}

	public void createFormParameter(WebDriver driver) throws Throwable {
		wlib.waitForPageLoad(driver);
		int rowcount = elib.getRowCount("FormParameterData");
		System.out.println(rowcount);
		for (int i = 1; i <= rowcount; i++) {
			String parameterId = elib.readDataFromExcel("FormParameterData", i, 0);
			String parameterLabel = elib.readDataFromExcel("FormParameterData", i, 1);
			String parameterDesc = elib.readDataFromExcel("FormParameterData", i, 2);
			String parameterType = elib.readDataFromExcel("FormParameterData", i, 3);
			String requiredField = elib.readDataFromExcel("FormParameterData", i, 4);
			String listoption = elib.readDataFromExcel("FormParameterData", i, 5);
			String minvalue = elib.readDataFromExcel("FormParameterData", i, 6);
			String maxvalue = elib.readDataFromExcel("FormParameterData", i, 7);

			addicon.click();
			Thread.sleep(1000);
			parameterIdtbx.sendKeys(parameterId);
			parameterLabeltbx.sendKeys(parameterLabel);
			parameterdescriptiontbx.sendKeys(parameterDesc);
			paramTypeDrpDwnbtn.click();
			if (parameterType.equals("Text")) {
				textOption.click();
			} else if (parameterType.equals("Number")) {
				numberOption.click();
				wlib.scrollAction(driver, mintbx);
				mintbx.sendKeys(minvalue);
				maxtbx.sendKeys(maxvalue);
			} else if (parameterType.equals("Single-Select")) {
				singleSelectOption.click();
				wlib.scrollAction(driver, listOption);
				listOption.sendKeys(listoption);
			} else if (parameterType.equals("Multi-Select")) {
				multiSelectOption.click();
				wlib.scrollAction(driver, listOption);
				listOption.sendKeys(listoption);
			} else if (parameterType.equals("Date")) {
				DateOption.click();
			} else if (parameterType.equals("Time")) {
				TimeOption.click();
			} else if (parameterType.equals("Signature")) {
				wlib.scrollAction(driver, SignatureOption);
				SignatureOption.click();
			} else if (parameterType.equals("User Single-Select")) {
				wlib.scrollAction(driver, singleUserOption);
				singleUserOption.click();
			} else if (parameterType.equals("User Multi-Select")) {
				wlib.scrollAction(driver, multiUserOption);
				multiUserOption.click();
			} else if (parameterType.equals("Form-System-Show")) {
				wlib.scrollAction(driver, formSystemShowOption);
				formSystemShowOption.click();
			} else if (parameterType.equals("Form-System-Hide")) {
				wlib.scrollAction(driver, formSystemShowOption);
				formSystemHideOption.click();
			} else {
				System.out.println("please check your parameter type field value");
			}
			requireddropdwnbtn.click();
			if (requiredField.equals("TRUE")) {

				trueOption.click();
			} else {
				falseOption.click();
			}
			wlib.scrollAction(driver, saveBtn);
			String disabletxt = driver.findElement(By.xpath("//button[contains(@type,'submit()')]"))
					.getAttribute("ng-reflect-disabled");
			if (disabletxt.equals("false")) {
				Thread.sleep(1000);
				saveBtn.click();
				refreshbtn.click();
				searchBtn.clear();
				searchBtn.sendKeys(parameterId);
				String Expecteddata = parameterId;
				System.out.println(Expecteddata);

				String ActualData = driver.findElement(By.xpath("//div[text()='"+parameterId+"']")).getText();
				if (Expecteddata.contains(ActualData)) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
				//Assert.assertEquals(Expecteddata, ActualData);
				System.out.println(parameterId + " Added successfully");
			} else {
				Thread.sleep(1000);
				cancelbtn.click();
				refreshbtn.click();
				searchBtn.clear();
				searchBtn.sendKeys(parameterId);
				String Expecteddata = parameterId;
				System.out.println(Expecteddata);

				String ActualData = driver.findElement(By.xpath("//div[text()='"+parameterId+"']")).getText();
				
				//Assert.assertEquals(Expecteddata, ActualData);
				if (Expecteddata.contains(ActualData)) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

				System.out.println(parameterId + " Already exist");
               
			}

		}

	}

}
