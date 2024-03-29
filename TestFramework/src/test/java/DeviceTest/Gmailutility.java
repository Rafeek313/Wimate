package DeviceTest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
public class Gmailutility {
	static ExcelFileUtility e=new ExcelFileUtility();
	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			 String toAddress, String subject, String message) throws AddressException, MessagingException {

			 // sets SMTP server properties
			 Properties properties = new Properties();
			        properties.put("mail.smtp.socketFactory.port", "465");
			        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			        properties.put("mail.smtp.auth", "true");
			        properties.put("mail.smtp.host", host);
			        properties.put("mail.smtp.port", port);
			        properties.put("mail.smtp.auth", "true");
			        properties.put("mail.smtp.starttls.enable", "true");
			        properties.put("mail.user", userName);
			        properties.put("mail.password", password);
			        // creates a new session with an authenticator

			        Authenticator auth = new Authenticator() {
			         public PasswordAuthentication getPasswordAuthentication() {
			                return new PasswordAuthentication(userName, password);
			         }
			        };

			        Session session = Session.getInstance(properties, auth);

			        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			        LocalDateTime now = LocalDateTime.now();
			        // creates a new e-mail message

			        MimeMessage msg = new MimeMessage(session);
			        msg.setFrom(new InternetAddress(userName));
			        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
			        msg.setRecipients(Message.RecipientType.TO, toAddresses);
			        // msg.addRecipient(RecipientType.CC, new
			        // InternetAddress("divya@untangleds.com"));
			        msg.setSubject(subject);
			        msg.setSentDate(new Date());
			        msg.setContent(message, "text/html");
			        Transport.send(msg);
			        }

			 public static void main(String message1) throws IOException, Throwable {

			        String host = "smtp.gmail.com";
			        String port = "587";
			        
			        String mailFrom = "automationwimate@gmail.com";
			        String password = "usclyhgnwbcwsfmg";// Others and Jenkins

			        
			        String mailTo = "rafeek@wimate.in";
			        String ProjectName = "e2e_inmemory_activities";
			        String message = "Test-cases Reports";
			        message = "<h1><font color=blue><b>Test Cases Reports<b></font></h1>";
			        message += "<h2><b>Project Name :" + ProjectName + "</b></h2>";

			        message += "<table cellpadding=\"0\" cellpadding=\"0\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;width:100%;margin:0;padding:35px 0\"> <tr><th>Test Status</th><th>Load Time</th><th>Results</th></tr>";
			        int count = 0;
			           for (int i = 0; i < message1.length(); i++) {
			               if (message1.charAt(i) == ',')
			               count++;
			           }

			           String[] Testcases_Name = message1.split(",");
			           for (int c = 0; c < 2; c++) {
			               String Testcases_Namec = Testcases_Name[c];
			               String LoadTime =e.Excelread("TestData.xlsx", c, 1, 2);
			               System.out.println(LoadTime);
			               int Con_Loadtime=Integer.parseInt(LoadTime);
			               float LoadTime_dec= Con_Loadtime;
			               LoadTime_dec= LoadTime_dec/1000;
			               String Loadtime_sec= String.valueOf(LoadTime_dec +" Sec");
			       if (Testcases_Namec.contains("Failed")) {
			               message += "<tr>";

			               Testcases_Namec = Testcases_Namec.substring(17);
			               LoadTime = "FAILED";
			               message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#ff0000;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
			                   + Testcases_Namec + "</font></h4></td>";
			               message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#ff0000;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
			                   + LoadTime + "</font></h4></td>";
			               message += "<td bgcolor=\"#ff0000\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#ff0000\">"
			                   + LoadTime + "</font></h4></td>";
			               message += "</tr>";
			               } else if (Testcases_Namec.contains("Passed")) {
			               message += "<tr>";
			               Testcases_Namec = Testcases_Namec.substring(17);
			               message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#009900;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
			                   + Testcases_Namec + "</font></h4></td>";
			               message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#009900;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
			                   + Loadtime_sec + "</font></h4></td>";
			               int loadtime = Integer.parseInt(LoadTime);
			               if (loadtime > 20000) {
			                   message += "<td bgcolor=\"#ff0000\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#ff3300\"></font></h4></td>";
			               } else if (loadtime > 15000) {
			                   message += "<td bgcolor=\"#ff9900\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#ff9966\"></font></h4></td>";
			               } else if (loadtime > 10000) {
			                   message += "<td bgcolor=\"#ffff00\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#ffff99\"></font></h4></td>";
			               }
			       else if (loadtime < 10000) {
			                   // Green Colour
			                   message += "<td bgcolor=\"#009900\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#66ff33\"></font></h4></td>";
			               }
			               message += "</tr>";
			               } else {
			               message += "<h4>" + Testcases_Namec + "</h4>";
			               }
			           }
			           message += "</table>";

			           String subject = "Load Testing For All Instances ," + LocalDateTime.now() + "";

			           try {
			               sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message);
			               System.out.println("Email sent Succesfully..");
			           } catch (Exception ex) {
			               System.out.println("Could not send email.");
			               ex.printStackTrace();
			           }
			           }

			       }



