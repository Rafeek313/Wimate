package com.CloudTesla.Generic;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.mail.MessagingException;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import com.CloudTesla.Generic.*;
@Listeners
public class IsuitListenerIplementation implements ISuiteListener {

	@Override
	public void onFinish(ISuite suite) {
		
	Map<String,ISuiteResult>result=suite.getResults();
	Set<String> key = result.keySet();
	Set<Entry<String, ISuiteResult>> value = result.entrySet();
	
	

	String mailBody="\n";
	LinkedHashMap<String, String> listFailed=new LinkedHashMap<>();
	ArrayList<String> a=new ArrayList<String>();
		for(String k:key)
		{
			int totalTestCases = result.get(k).getTestContext().getAllTestMethods().length;
			int passedTest = result.get(k).getTestContext().getPassedTests().size();
			int FailedTest=result.get(k).getTestContext().getFailedTests().size();
			int skippedTest=result.get(k).getTestContext().getSkippedTests().size();
			//to get failed test cases name
			Set<ITestResult> FailedTestName =  result.get(k).getTestContext().getFailedTests().getAllResults();
			for(ITestResult f:FailedTestName)
			{
				String FaildName = f.getName();
				if(FaildName!=null) {
				mailBody += "<tr>\r\n"
				+ " <td >"+FaildName+"</td>\r\n";
				try {
				if(FaildName.equals("rafeek"))
				{
				mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(1, 4)+"</td>";
				mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(1, 6)+"</td>"; 
				mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(1, 5)+"</td>"; 
				mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
				
				}
//				else if(FaildName.equals("manjurocky"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(2, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(2, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(2, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				else if(FaildName.equals("ningum40"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(3, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(3, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(3, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				else if(FaildName.equals("abhipv952"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(4, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(4, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(4, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				else if(FaildName.equals("pundunayak576"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(5, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(5, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(5, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				
//				else if(FaildName.equals("Wimatetest01"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(6, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(6, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(6, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				else if(FaildName.equals("Wimatetest02"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(7, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(7, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(7, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				else if(FaildName.equals("Wimatetest03"))
//				{
//					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(8, 4)+"</td>";
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(8, 6)+"</td>"; 
//					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(8, 5)+"</td>"; 
//					mailBody +="<td style=\"background-color: red; color: black; width :50px;text-align: center; \">Fail</td>"; 
//			    }
//				
				}
				catch(Exception e)
				{
					
				}
				}
			}
			
			//to get passed test cases name
			Set<ITestResult> passedTestName = result.get(k).getTestContext().getPassedTests().getAllResults();
			for(ITestResult p:passedTestName)
			{
				String passedName=p.getName();
				if(passedName!=null) {
				mailBody += "<tr>\r\n"
						+ "            <td ><b>"+passedName+"</b></td>\r\n";
				try {
					if(passedName.equals("rafeek"))
					{
					mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(1, 4)+"</td>";
					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(1, 6)+"</td>"; 
					mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(1, 5)+"</td>"; 
					mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
					
					}
//					else if(passedName.equals("manjurocky"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(2, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(2, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(2, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
//				    }
//					else if(passedName.equals("ningum40"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(3, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(3, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(3, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
//				    }
//					else if(passedName.equals("abhipv952"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(4, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(4, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(4, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
//				    }
//					else if(passedName.equals("pundunayak576"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(5, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(5, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(5, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
//				    }
//					
//					else if(passedName.equals("Wimatetest01"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(6, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(6, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(6, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">pass</td>"; 
//				    }
//					else if(passedName.equals("Wimatetest02"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(7, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(7, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(7, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">Pass</td>"; 
//				    }
//					else if(passedName.equals("Wimatetest03"))
//					{
//						mailBody +="<td style=\\\"text-align: center;\\\" >"+FileLib.ReadExcel(8, 4)+"</td>";
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(8, 6)+"</td>"; 
//						mailBody +="<td style=\\\"text-align: center;\\\">"+FileLib.ReadExcel(8, 5)+"</td>"; 
//						mailBody +="<td style=\"background-color: green; color: black; width :50px;text-align: center; \">Pass</td>"; 
//				    }
					
					}
					catch(Exception e)
					{
						
					}	
			}
			
	
		}

		mailBody=html(mailBody);
		try 
		{
			SendMail.sendMail(mailBody);
		} 
		catch (MessagingException | IOException | GeneralSecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	public static String html(String s) {
		
		
		String html="<title>Center-Aligned Table Cell Text</title>\r\n"
				+ "    <style>\r\n"
				+ "        td {\r\n"
				+ "            text-align: ;\r\n"
				+ "        }\r\n"
				+ " table {\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "            width: \n"
				+ "        }\r\n"
				+ "        td {\r\n"
				+ "            padding: 90px /* Adjust the value to increase or decrease spacing */\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "<h1><font color=blue><b>Test Cases Reports<b></font></h1>"
				
				+ "<h2 style=\"color: Black;\">Project Name: <span style=\"color: blue;\" >Device Timed out</span></h2>"
				
				+ "    <table border=\"0 cellspacing=\"2\" width=\"100%\" length=\"100%\"> <!-- You can add borders for visibility -->\r\n"
				+ "        <tr>\r\n"
				+"           <th style=\"text-align: left;\"><b>User Name</b></th>\r\n"
				+ "<th style=\"text-align: left;\"><b>Location Permission</b></th>\r\n"
				+ "<th style=\"text-align: left;\"><b>Device Permission</b></th>\r\n"
				+ "<th style=\"text-align: left;\"><b>RDT Permission</b></th>\r\n"
				+ "<th style=\"text-align: left;\"><b>Status</b></th>"
				+ "        </tr>";
				
		
		html +=s;
	/*	html += "<h5 style=\"text-align: left;\">Yours truly</h5><br</br>"
				+ "<h6 style=\"text-align: left; padding:0;\"line-height: 0;\">ningraj</h6>";*/
		
		
		return html;
	}

	
	

}
