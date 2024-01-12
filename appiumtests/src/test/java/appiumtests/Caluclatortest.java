package appiumtests;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Permission;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;

public class Caluclatortest {
	
	//static WebDriver driver;
	//public static AppiumDriver<MobileElement> driver;
	public static AndroidDriver driver;
	@Test
	public  static void opentask() throws IOException, InterruptedException {
			 DesiredCapabilities cap= new DesiredCapabilities();
			 //device name from  mobile settings
			 cap.setCapability("deviceName", "OnePlus Nord2 5G");
			 cap.setCapability("udid", "10.0.1.131:5555");
			 cap.setCapability("platformName", "Android");
			 cap.setCapability("platformVersion", "12");
			 cap.setCapability("appPackage", "io.ionic.amsv2");
			 cap.setCapability("appActivity", "io.ionic.starter.MainActivity");
			 URL url=new URL("http://127.0.0.1:4723/wd/hub");
			 //driver = new AppiumDriver<MobileElement>(url,cap);
			 driver=new AndroidDriver(url,cap);
			 System.out.println("Application started");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 //driver.findElement(By.xpath("//android.view.View[@resource-id='email']")).sendKeys("rafiq");
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[1]")).sendKeys("rafeek@wimate.in");
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[2]")).sendKeys("Rafeek317322*"); 
			 driver.findElement(By.xpath("//android.widget.Button[@text='Sign in']")).click();
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Task']")).click();
			 driver.findElement(By.xpath("//android.widget.Button[@text='Create New Task']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//android.widget.RadioButton[@text='FT_001']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='Create']")).click();
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[1]")).sendKeys("label");
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[2]")).sendKeys("label");
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[3]")).sendKeys("label");
			 driver.findElement(By.xpath("(//android.widget.EditText[@index='0'])[4]")).click();
			 KeyEvent keyevent9 = new KeyEvent().withKey(AndroidKey.DIGIT_9);
			 driver.pressKey(keyevent9);
			 KeyEvent keyevent2 = new KeyEvent().withKey(AndroidKey.DIGIT_2);
			 driver.pressKey(keyevent2);
			 Point startPoint = new Point(500, 1500);
		        // Using 0,0 100% page is scrooling upto 7 Assigned Ticeket is scrolling...
		        // Using -500,-1500 300% page is scrolling upto 21 Assigned Ticket is scrolling.
		        Point endPoint = new Point(100, 1000);
		        // Create a new PointerInput object
		        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		        //Create a new Sequence object
		        Sequence swipe = new Sequence(finger, 2);
		        //Add a pointer move action to the starting point
		        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint.x, startPoint.y));
		        //Add a pointer down action to simulate touching the screen
		        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		        //Add a pointer move action to the ending point
		        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endPoint.x, endPoint.y));
		        //Add a pointer up action to simulate releasing the screen
		        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		        //Perform the swipe gesture
		        driver.perform(Arrays.asList(swipe));
			 driver.findElement(By.xpath("//android.widget.Button[@text='Add Signature']")).click();
			 WebElement element = driver.findElement(By.xpath("//android.widget.Image[@index='0']"));
			 Dimension sizeofimg = element.getSize();
			 System.out.println(sizeofimg);
			 int centreOfX = sizeofimg.getWidth();
			 int centreOfY = sizeofimg.getHeight();
			  int xbutton = (centreOfX/3)*1;
			  int ybutton = (centreOfY/3)*2;
			  System.out.println(centreOfX);
			  System.out.println(centreOfY);
			  System.out.println(xbutton);
			  System.out.println(ybutton);
			 Actions a=new Actions(driver);
			 Thread.sleep(2000);
//			 a.moveToElement(element, xbutton, ybutton).click().build().perform();
//		    	a.doubleClick(element).perform();
//			    Actions a = new Actions(driver);
			    a.dragAndDropBy(element, xbutton, ybutton).clickAndHold(element).build().perform();
//			    a.doubleClick(element).build().perform();
//			    Thread.sleep(5000);
////			    Action drawAction = builder.moveToElement(element,596,700) //start points x axis and y axis. 
//			              .click()
//			              .moveByOffset(598,702) // 2nd points (x1,y1)
//			              .click()
//			              .moveByOffset(594,704)// 3rd points (x2,y2)
//			              .doubleClick()
//			              .build();
//			    drawAction.perform();
//			 Action signature= builder.contextClick(element)                       
//                     .clickAndHold()
//                     .moveToElement(element,596,700)
//                     .moveByOffset(50, 50)
//                     .moveByOffset(80,-50)
//                     .moveByOffset(100,50)
//                     .release(element)
//                      .build();                       
//              signature.perform();
			 
			 driver.findElement(By.xpath("//android.widget.Button[@text='Confirm']")).click();
			 driver.findElement(By.xpath("//android.widget.Button[@text='Confirm']")).click();
			 String text = driver.findElement(By.xpath("//android.widget.EditText[@text='FT_001']")).getText();
			 Assert.assertEquals("FT_001", text);
			 System.out.println("task created successfully");
			 

		 }
	}


