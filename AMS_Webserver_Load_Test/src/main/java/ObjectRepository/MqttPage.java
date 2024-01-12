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

public class MqttPage {
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	@FindBy(xpath = "//mat-icon[text()='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//input[@ng-reflect-name='mqtt_id']")
	private WebElement mqttIdTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='name']")
	private WebElement nameTbx;
	@FindBy(xpath = "//mat-select[@ng-reflect-name='host']")
	private WebElement hostTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='url']")
	private WebElement urlTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='username']")
	private WebElement usernameTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='port']")
	private WebElement portTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='topic']")
	private WebElement topicTbx;
	@FindBy(xpath = "//input[@ng-reflect-name='password']")
	private WebElement passwordTbx;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//span[text()='This ModelID already exists']")
	private WebElement errorMsg;
//	@FindBy(xpath = "(//button[@ng-reflect-disabled='false'])[2]")
//	private WebElement saveBtn ;
	@FindBy(xpath = "//span[.='Save']")
	private WebElement saveBtn;

	public MqttPage(WebDriver driver) {
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

	

	public WebElement getMqttIdTbx() {
		return mqttIdTbx;
	}

	public WebElement getNameTbx() {
		return nameTbx;
	}

	public WebElement getHostTbx() {
		return hostTbx;
	}

	public WebElement getUrlTbx() {
		return urlTbx;
	}

	public WebElement getUsernameTbx() {
		return usernameTbx;
	}

	public WebElement getPortTbx() {
		return portTbx;
	}

	public WebElement getTopicTbx() {
		return topicTbx;
	}

	public WebElement getPasswordTbx() {
		return passwordTbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
     
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void addMqttBroker(WebDriver driver) throws IOException, Throwable {
		wlib.waitForPageLoad(driver);
		int count = elib.getRowCount("MQTT");
		System.out.println(count);
		for (int i = 1; i <= count; i++) {
			long epochTime = System.currentTimeMillis();
			String mqttId = Long.toString(epochTime);
			//String modelid = elib.readDataFromExcel("Model", i, 0);
			String name = elib.readDataFromExcel("MQTT", i, 0);
			String host = elib.readDataFromExcel("MQTT", i, 1);
			String url = elib.readDataFromExcel("MQTT", i, 2);
			String port = elib.readDataFromExcel("MQTT", i, 3);
			String username = elib.readDataFromExcel("MQTT", i, 4);
			String topic = elib.readDataFromExcel("MQTT", i, 5);
			String password = elib.readDataFromExcel("MQTT", i, 6);
			AddBtn.click();
			Thread.sleep(1000);
			mqttIdTbx.sendKeys(mqttId);
			nameTbx.sendKeys(name);
			hostTbx.sendKeys(host);
			urlTbx.sendKeys(url);
			portTbx.sendKeys(port);
			usernameTbx.sendKeys(username);
			topicTbx.sendKeys(topic);
			passwordTbx.sendKeys(password);
			try {
				saveBtn.click();
				}
				catch(Exception e)
				{ 
					String duplicateID = errorMsg.getText();
					wlib.scrollAction(driver,cancelBtn);
					cancelBtn.click();
					System.out.println(mqttId+" "+duplicateID);
					
			    }
			String ActualId = driver.findElement(By.xpath(
					"//mat-cell[@class='mat-cell cdk-cell cdk-column-mqtt_id mat-column-mqtt_id ng-star-inserted' and text()='"
							+ " " + "" + mqttId + "']"))
					.getText();
			Assert.assertEquals(mqttId, ActualId);
			elib.writeDataIntoExcel("FormTypedata", i, 12, mqttId);
		}
		{
		}
	}
}
