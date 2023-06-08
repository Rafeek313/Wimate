package DeviceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import ObjectRepository.DDHomePage;
import ObjectRepository.HomePage;

public class DynamicDahboardTest extends BaseClass{
	HomePage homepage = new HomePage(driver);
	DDHomePage ddhomepage=new DDHomePage(driver);
@Test
public void ddtest() throws InterruptedException {
	wlib.waitForPageLoad(driver);
	Thread.sleep(2000);
	homepage.clickOnDynamicDashboard();
	ddhomepage.AddDynamicDashboard();
//	driver.findElement(By.xpath("//a[@href='/dynamics/dynamic_dynamic']/i[@class='fa fa-dashboard']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//a[.='Dashboard Configuration ']")).click();
//	Thread.sleep(2000);
//    driver.findElement(By.xpath("//span[.='Add New Dynamic Dashboard']")).click();
//	driver.findElement(By.xpath("//input[@id='dashboard_id' and @ng-model='dashboard_id']")).sendKeys("DD_Test03");
//	driver.findElement(By.xpath("//input[@id='dashboard_name' and @ng-model='dashboard_name']")).sendKeys("DD_TEST03");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//a[@class='chosen-single chosen-default']/span)[1]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//div[@class=\"chosen-search\"]/input[@type='text'])[1]")).sendKeys("Tertiary");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@data-option-array-index='3']")).click();
//	driver.findElement(By.xpath("(//input[@id=\"dashboard_desc\"])[1]")).sendKeys("DDashboard  Tertiary test");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//div[@class='chosen-container chosen-container-single']/a[@class='chosen-single chosen-default']/div)[1]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//div[@class='chosen-search']/input[@type='text'])[2]")).sendKeys("Rafeek_RDT");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//li[@class='active-result highlighted']/em[text()='Rafeek_RDT']")).click();
//	driver.findElement(By.xpath("//button[@ng-click='addDynmDash()']")).click();
//	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("DD_Test03");
//	Thread.sleep(2000);
//	String ddid = driver.findElement(By.xpath("//table/tbody/tr/td[@ng-show=\"dynmDashId\"]/a[@class='label label-warning ng-binding']")).getText();
//	Assert.assertEquals(ddid, "DD_Test03");
	//System.out.println(ddid);
}
}
