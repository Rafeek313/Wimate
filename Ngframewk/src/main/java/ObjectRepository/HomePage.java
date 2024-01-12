package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import com.paulhammant.ngwebdriver.*;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.ByAngularModel.FindBy;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class HomePage {
WebDriver driver;
@FindBy(model="first")
private WebElement firsttxtbx;
@FindBy(model="second")
private WebElement secondtxtbx;
@FindBy(model="operator")
private WebElement operatorselecttxtbx;
@com.paulhammant.ngwebdriver.ByAngularButtonText.FindBy(buttonText="Go!")
 WebElement button;
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void addSum(int a,int b) {
	 firsttxtbx.sendKeys("+a+");
	 secondtxtbx.sendKeys("b");
}
}
