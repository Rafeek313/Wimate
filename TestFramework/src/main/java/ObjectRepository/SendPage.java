package ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;

public class SendPage extends BaseClass {
	LoginPage loginpage = new LoginPage(driver);
	@FindBy(xpath="//button[@class='btn btn-primary dim btn-xs treebtn ng-binding']")
	private WebElement locationbutton;
	@FindBy(xpath="//input[@placeholder='Search for Devices']")
	private WebElement searchdevice;
	@FindBy(xpath="//button[text()='Ok ']")
	private WebElement okbtn;
	@FindBy(xpath="//a[@class='chosen-single']/div/b")
	private WebElement dropdownbtn;
	@FindBy(xpath="//ul[@class='chosen-results']/li[text()='Generate Hourly data (24) Mongodb']")
	private WebElement genhourly24mdb;
	@FindBy(xpath="//a[text()='Click here']")
	private WebElement reloginclk;
	@FindBy(xpath="//input[@type='date']")
	private WebElement datebtn;
	@FindBy(xpath="//a[@href='/reports/create']")
	private WebElement reportspage;
	@FindBy(xpath="//a/span[text()='Parameters']/following-sibling::div/b")
	private WebElement reporttype;
	@FindBy(xpath="//button[@class='btn dim btn-primary pull-right ng-scope']")
	private WebElement generatebtn;
	@FindBy(xpath="//li[@class='active-result result-selected ng-binding ng-scope']/em[text()='Hourly consumption']")
	private WebElement hourlyconsumption;
	@FindBy (id="treedata")
	private WebElement locationtree;
	@FindBy (xpath="//button[text()='Ok']")
	private WebElement repOKbutton;
	@FindBy (xpath="(//input[@type='date'])[1]")
	private WebElement repDate;
	@FindBy (xpath="(//input[@type='text' and @value='Select parameters'])[1]")
	private WebElement parametertbx;
	@FindBy (xpath="//ul[@class=\"chosen-results\"]/li[text()='Rafeek_SP_Lab']")
	private WebElement allParameter;
	@FindBy (id="apply")
	private WebElement applybtn;
	@FindBy(xpath="//div[@class='dt-buttons']/a/span[text()='Column visibility']")
	private WebElement columnvisiblitybtn;
	@FindBy(xpath="//span[text()='created date']")
	private WebElement createddatebtn;
	@FindBy (xpath="//table[@id='example']/tbody/tr[1]/td[4]")
	private WebElement createdate;
	public WebElement getLocationbutton() {
		return locationbutton;
	}
	public WebElement getSearchdevice() {
		return searchdevice;
	}

	public WebElement getOkbtn() {
		return okbtn;
	}
	public WebElement getDropdownbtn() {
		return dropdownbtn;
	}

	public WebElement getGenhourly24mdb() {
		return genhourly24mdb;
	}

	public LoginPage getLoginpage() {
		return loginpage;
	}
	public WebElement getReloginclk() {
		return reloginclk;
	}
	public WebElement getDatebtn() {
		return datebtn;
	}

	public WebElement getReportspage() {
		return reportspage;
	}
	public WebElement getReporttype() {
		return reporttype;
	}
	public WebElement getGeneratebtn() {
		return generatebtn;
	}
	public WebElement getHourlyconsumption() {
		return hourlyconsumption;
	}

	public WebElement getLocationtree() {
		return locationtree;
	}

	public WebElement getRepOKbutton() {
		return repOKbutton;
	}
	public WebElement getRepDate() {
		return repDate;
	}
	public WebElement getParametertbx() {
		return parametertbx;
	}
	public WebElement getAllParameter() {
		return allParameter;
	}
	public WebElement getApplybtn() {
		return applybtn;
	}
	public WebElement getColumnvisiblitybtn() {
		return columnvisiblitybtn;
	}
	public WebElement getCreateddatebtn() {
		return createddatebtn;
	}
	public WebElement getCreatedate() {
		return createdate;
	}
	public SendPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clickLocationTree(WebDriver driver) throws Throwable {
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelFileUtility elib=new ExcelFileUtility();
		int count = elib.getRowCount("TestData2");
		System.out.println(count);
		for(int i=1;i<=count;i++)
		{

			String deviceName = elib.readDataFromExcel("TestData2", i, 0);

			String dataType = elib.readDataFromExcel("TestData2", i, 1);


			locationbutton.click();
			
			if(i>1 && i<=count)
			{
				searchdevice.clear();
				String previousdevicename = elib.readDataFromExcel("TestData2", i-1, 0);
				searchdevice.sendKeys(previousdevicename);
				driver.findElement(By.xpath("//span[text()='"+previousdevicename+"']")).click();
			}	
				searchdevice.clear();
				searchdevice.sendKeys(deviceName);
				driver.findElement(By.xpath("//span[@class='node-name ng-binding']/parent::span/parent::span/descendant::span[text()='"+deviceName+"']")).click();
				okbtn.click();
				dropdownbtn.click();
				driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+dataType+"']")).click();
				String date = elib.readDataFromExcel("TestData2", i, 2);
				datebtn.sendKeys(date);
				generatebtn.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				System.out.println(date);
				elib.writeDataIntoExcel("TestData2", i, 3, "Generated successfully");
			}
		}

		/* reportspage.click();
		reporttype.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Hourly consumption']")).click();
		//hourlyconsumption.click();
		locationtree.click();
		searchdevice.sendKeys(deviceName);
		driver.findElement(By.xpath("//span[@class=\"node-name ng-binding\" and text()='"+deviceName+"']")).click();
		repOKbutton.click();
		repDate.sendKeys(repdate);
		Thread.sleep(5000);
		parametertbx.click();
		Thread.sleep(1000);
		allParameter.click();
		applybtn.click();
		wlib.scrollActionBottom(driver);
		Thread.sleep(5000);
		columnvisiblitybtn.click();
		//wlib.doublecClickAction(driver);
		Thread.sleep(5000);
		wlib.scrollActionBottom(driver);
		createddatebtn.click();
		String generatedate = createdate.getText();
		System.out.println(generatedate); */


	

}
