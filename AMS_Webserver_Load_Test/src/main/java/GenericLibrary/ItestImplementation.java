package GenericLibrary;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
@Listeners
public class ItestImplementation implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("This is Test Success");
		ITestContext re = result.getTestContext();
		
		
		String v = "<tr style=\"background-color:  lightblue\";>\r\n";
		
		
		v+="<td style=\"text-align: center;\" >"+re.getSuite().getAttribute("Module Name")+"</td>";
		v+="<td style=\"text-align: center;\">"+re.getSuite().getAttribute("Loading Time")+"</td>"; 
		//v+="<td style=\"text-align: center;\">"+re.getSuite().getAttribute("Result")+"</td>";
		//v+="<td style=\"text-align: center;\">"+re.getSuite().getAttribute("Loading Time")+"</td>";
		v+="<td style=\"background-color: rgb(169, 212, 169); color: black; width :50px;text-align: center; \">pass</td>";
		v+="</tr>";
		IsuitListenerIplementation.concatReport(v);
		
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		ITestContext re = result.getTestContext();
		String v ="<tr style=\"background-color:  lightcoral;\">\r\n";
		v +="<td style=color: rgb(254, 148, 148)\" >"+re.getSuite().getAttribute("Module Name")+"</td>";
		v +="<td style=color: rgb(254, 148, 148)\">"+re.getSuite().getAttribute("Loading Time")+"</td>"; 
		//v +="<td style=color: rgb(254, 148, 148)\">"+re.getSuite().getAttribute("Result")+"</td>";
		//v +="<td style=color: rgb(254, 148, 148)\">"+re.getSuite().getAttribute("Loading Time")+"</td>";
		v +="<td style=\"background-color: rgb(254, 148, 148); color: black; width :50px;text-align: center; \">Fail</td>"; 
		
		v+="</tr>";
		IsuitListenerIplementation.concatReport(v);
		//System.out.println("Result____________________>>>>>>>>"+result.getThrowable()+"++++++++++++++++++++++++++>>>>");
		
		
		//ITestListener.super.onTestFailure(result);
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		IResultMap passedMethods = context.getPassedTests();
	    IResultMap FailedMethods = context.getFailedTests();	
		
			
		ITestListener.super.onFinish(context);
	}
	
	@Override
	 public void onTestStart(ITestResult result) {
		    // not implemented
		// System.out.println("This is test start");
		  }
	
	
	

}
