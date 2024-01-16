package GenericLibrary;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass  implements ITestListener{
	JavaUtility jlib=new JavaUtility();
	
	
	ExtentReports report;
    ExtentTest test;

    public void onStart(ITestContext context) {
        report = new ExtentReports();
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/Report"+ new JavaUtility().getSystemDateAndTime()+".html");
		htmlreport.config().setDocumentTitle("AMS V2 PING Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("AMS ping report");
		report.attachReporter(htmlreport);
		report.setSystemInfo("base-Browser", "chrome");
		report.setSystemInfo("os", "Windows");
		report.setSystemInfo("base-url", "http://10.0.1.5:8080");
		report.setSystemInfo("reporter-name", "Rafeek T M");
		
//        report.attachReporter(htmlreport);
        
        // You can customize the report settings here
    }

    public void onTestStart(ITestResult result) {
        if (report == null) {
            // Report not initialized, log an error or throw an exception
            System.err.println("ExtentReports not properly initialized. Ensure onStart is executed before onTestStart.");
            // Add proper error handling here
        } else {
            String methodName = result.getMethod().getMethodName();
            test = report.createTest(methodName);
        }
    }
    
@Override
	public void onTestSuccess(ITestResult result) {
	String path=null;
	String methodName = result.getMethod().getMethodName();
    test = report.createTest(methodName);
    //test.pass(methodName+" passed successfully");
	JavaUtility jLib=new JavaUtility();
    String screenshotName = methodName+jLib.getSystemDateAndTime();
	System.out.println(screenshotName);
	try {
		
		new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName);
		test.log(Status.PASS, result.getThrowable());
		test.addScreenCaptureFromPath(new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName));
		//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		//File src = eDriver.getScreenshotAs(OutputType.FILE);
		//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
		//String path = "./Screenshots/"+screenshotName+".png";
		//File dst = new File(pa);
		//Files.copy(src, dst);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		
		test.log(Status.PASS, methodName+"------->passed");
				test.addScreenCaptureFromPath(path);
		

		
		
		
	}
    
}

public void onTestFailure(ITestResult result) {
		
		String path=null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		Reporter.log(MethodName + "--- TestScript Failed",true);
       test.log(Status.INFO,MethodName+" TestScript failed " );
		JavaUtility jLib=new JavaUtility();
		//Step 1: Configure screenshot name
		//String screenshotName = MethodName+jLib.getSystemDateInFormat();
		String screenshotName = MethodName+jLib.getSystemDateAndTime();
		System.out.println(screenshotName);

		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName);
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName));
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			test.log(Status.FAIL, MethodName+"------->failed");
			
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(path);
			

			
			
			
		}
}
    // Implement other ITestListener methods as needed

    public void onFinish(ITestContext context) {
        if (report != null) {
            report.flush();
        }
    }

}