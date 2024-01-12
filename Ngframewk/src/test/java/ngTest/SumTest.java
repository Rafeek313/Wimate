package ngTest;

import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import genericlibrary.BaseClass;

public class SumTest extends BaseClass{
	HomePage homepage=new HomePage(driver);
@Test
public void sum() {
	 homepage=new HomePage(driver);
	 homepage.addSum(2, 3);
	
}
}
