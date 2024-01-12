package ObjectRepository;

import java.awt.AWTException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TaskPage {
	static WebDriver driver;
@FindBy (xpath="//ion-button[@class=\"ios button button-full button-solid ion-activatable ion-focusable hydrated\" and text()='Create New Task ']")
private WebElement createNewTaskbtn;
@FindBy (xpath="//ion-button[@class=\"ios button button-full button-solid ion-activatable ion-focusable hydrated\" and text()='Scan ']")
private WebElement scanbtn;
@FindBy (xpath="//div[text()='FT_001']")
private WebElement selectformbtn;
//@FindBy (xpath="//span[text()='Create']")
//@FindBy (xpath="//*[text()='Create']")
//@FindBy (xpath="//span[@class='alert-button-inner sc-ion-alert-ios' and text()='Create']")
//@FindBy(xpath="(//button[@type='button'])[5]")
//@FindBy(xpath="//*[@type='button']/*[text()='Create']")
@FindBy(xpath="//button[@type='button' and @class='alert-button ion-focusable ion-activatable alert-button-role-create sc-ion-alert-ios']")
private WebElement createbtn;
//@FindBy(xpath="//span[text()=' This Field is required ']/parent::ion-input/parent::ion-label/h3[text()='ID']/parent::ion-label/ion-input")
//@FindBy(xpath="(//span[text()=' This Field is required '])[1]")
//@FindBy(xpath="//h3[text()='ID']")
@FindBy(xpath="//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary']")
private WebElement formlabeltbx;
@FindBy(xpath="(//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary'])[1]")
private WebElement formidtbx;
@FindBy(xpath="//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary']")
private WebElement descriptiontbx;
@FindBy(xpath="(//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary'])[3]")
private WebElement param1tbx;
@FindBy(xpath="(//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary'])[4]")
private WebElement param2tbx;
@FindBy(xpath="(//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary'])[5]")
private WebElement param3tbx;
@FindBy(xpath="(//ion-item[@class='item-interactive item-input item ios item-fill-none in-list hydrated ion-untouched ion-pristine ion-valid item-label item-label-stacked item-label-color ion-color-tertiary'])[6]")
private WebElement param4tbx;
@FindBy(xpath="//ion-button[text()='Save Task']")
private WebElement saveTaskbtn;
@FindBy(xpath="//button[@type='button' and @class='action-sheet-button ion-activatable ion-focusable action-sheet-confirm sc-ion-action-sheet-ios']")
private WebElement confirmbtn;
@FindBy(xpath="(//ion-input[@class=\"font-size-small ion-text-right ion-no-padding-end sc-ion-input-ios-h sc-ion-input-ios-s ios has-value hydrated\"])[2]")
private WebElement labelnameDetails;
public TaskPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getCreateNewTaskbtn() {
	return createNewTaskbtn;
}

public WebElement getScanbtn() {
	return scanbtn;
}

public static WebDriver getDriver() {
	return driver;
}

public WebElement getSelectformbtn() {
	return selectformbtn;
}

public WebElement getCreatebtn() {
	return createbtn;
}

public WebElement getFormidtbx() {
	return formidtbx;
}

public WebElement getFormlabeltbx() {
	return formlabeltbx;
}

public WebElement getDescriptiontbx() {
	return descriptiontbx;
}

public WebElement getParam1tbx() {
	return param1tbx;
}

public WebElement getParam2tbx() {
	return param2tbx;
}

public WebElement getParam3tbx() {
	return param3tbx;
}

public WebElement getParam4tbx() {
	return param4tbx;
}

public void createNewTask() throws InterruptedException, AWTException {
	createNewTaskbtn.click();
	 selectformbtn.click();
	 Thread.sleep(2000);
	// WebDriverWait wait=new WebDriverWait(driver,10);
	 //wait.until(ExpectedConditions.elementToBeClickable(createbtn));
	 createbtn.click();
	 Thread.sleep(1000);
	 formidtbx.sendKeys("TestID");
	 formlabeltbx.sendKeys("Test1label");
	 descriptiontbx.sendKeys("Test1 description");
	 //param1tbx.sendKeys("Test parameter tbx");
	 saveTaskbtn.click();
	 confirmbtn.click();
	 String labelname = labelnameDetails.getAttribute("ng-reflect-value");
	 System.out.println(labelname+" created successfully");	
}
public void clickonScanbtn() {
	scanbtn.click();
	
}

}
