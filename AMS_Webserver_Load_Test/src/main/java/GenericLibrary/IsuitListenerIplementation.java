package GenericLibrary;

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


@Listeners
public class IsuitListenerIplementation implements ISuiteListener {
ExcelFileUtility elib=new ExcelFileUtility();
public static String report;

	@Override
	public void onFinish(ISuite suite) {
		
		//adding button
			report+="</table>\r\n"
					+ "    <br>\r\n"
					+ "    <div id=\"div1\">\r\n"
					+ "        <!-- Link styled as a button -->\r\n"
					+ "        <a href=\"https://amsdevtwo.d3g445nw7r26eg.amplifyapp.com/\" class=\"button-link\">Go to AMSV2 webserver</a>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ "</html>";
			System.out.println(report);
			
			try {
				SendMail.sendMail(report);
				
			} catch (MessagingException | IOException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		public static String html() {
			
			
			String html="<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <style>\r\n"
	+"table {\r\n"
	+ "    border-collapse: collapse;\r\n"
	+ "    width: 100%;\r\n"
	+ "  }\r\n"
	+ "  th, td {\r\n"
	+ "    border: 1px solid black;\r\n"
	+ "    padding: 8px;\r\n"
	+ "    text-align: center; /* Center align all headings */\r\n"
	+ "    transition: background-color 0.3s ease; /* Smooth transition for background color */\r\n"
	+ "  }\r\n"
	+ "  tr:nth-child(even) {\r\n"
	+ "    background-color: #f2f2f2;\r\n"
	+ "  }\r\n"
	+ "  th {\r\n"
	+ "    background-color: #4CAF50;\r\n"
	+ "    color: white;\r\n"
	+ "  }\r\n"
	+ "  th:hover {\r\n"
	+ "    background-color: #008CBA; /* Change header background color on hover */\r\n"
	+ "  }\r\n"
	+ "  td {\r\n"
	+ "    position: relative; /* Relative positioning for zoom effect */\r\n"
	+ "  }\r\n"
	+ "  td:hover {\r\n"
	+ "    background-color: #e2f972; /* Change cell background color on hover */\r\n"
	+ "    z-index: 1; /* Ensure hovered cell stays on top */\r\n"
	+ "  }\r\n"
	+" td:hover {\r\n"
	+ "    background-color: #e3ec86; /* Change cell background color on hover */\r\n"
	+ "  }"
				+" .button-link {\r\n"
				+ "            display: inline-block;\r\n"
				+ "            padding: 10px 20px;\r\n"
				+ "            background-color: #6bd976; /* Updated button background color */\r\n"
				+ "            color: #fff; /* Button text color */\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            border-radius: 5px;\r\n"
				+ "            cursor: pointer; /* Change cursor to hand */\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Hover state for the button link */\r\n"
				+ "        .button-link:hover {\r\n"
				 +"cursor: help;\r\n"
				 + "    transform: scale(1.5); /* Increase the size of the cursor */\r\n"
				 + "    transition: transform 0.1s ease;"
				+ "        }"
					+ "td:hover {\r\n"
					+ "      transform: scale(1.1); /* Zoom in by 10% on hover */\r\n"
					+ "background-color: #c4fcf1;"
					+ "    }"
					+ "div {\r\n"
					+ "	 text-align: center;\r\n"
					+ "	 height: auto;\r\n"
					+ "			    margin: 0;\r\n"
					+ "		       } "
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <h1 style=\"text-align: center;\"><font color=\"rgb(73, 85, 85);\"><u><b>Test Case Report</b></u></font></h1>\r\n"
					+ "    <h4 style=\"color: black; text-align: left;\">Project Name: <span style=\"color: black;\">AMS V2</span></h2>\r\n"
					+ "    <table width=\"100%\">\r\n"
					+ "        <tr>\r\n"
					+ "            <th id=\"heading1\">Module Name</th>\r\n"
					+ "            <th id=\"heading2\">Loading Time</th>\r\n"
					//+ "            <th id=\"heading3\">Result</th>\r\n"
					//+ "            <th id=\"heading4\">Loading Time(in Seconds)</th>\r\n"
					+ "            <th id=\"heading6\">Status</th> <!-- Corrected duplicate ID and adjusted heading number -->\r\n"
					+ "        </tr>";
			
			
			//html +=s;
			/*html +=" </table><br>\r\n"
					+ "<div id=\"div1\">"
					+ "    <!-- Link styled as a button -->\r\n"
					+ "    <a href=https://www.cv2beta.cloudtesla.com\" class=\"button-link\">Go to WWW.cloudTeslaV2</a>\r\n"
					+ "</div>"
					+ "</body>\r\n"
					+ "</html>";*/
		/*	html += "<h5 style=\"text-align: left;\">Yours truly</h5><br</br>"
					+ "<h6 style=\"text-align: left; padding:0;\"line-height: 0;\">ningraj</h6>";*/
			//System.out.println(html);
			return html;
		}
		@Override
		public void onStart(ISuite suite) {
			
			//suite.setAttribute("Report", html());
			//System.out.println(suite.getAttribute("Report"));
			report=html();
		
		}
		
		public static void concatReport(String s)
		{
			report+=s;
		}
		
	

}
