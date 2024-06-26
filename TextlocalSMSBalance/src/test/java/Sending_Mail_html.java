


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

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
public class Sending_Mail_html {
	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String toAddress, String subject) throws AddressException, MessagingException {
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
		InternetAddress[] toAddresses = { new InternetAddress(toAddress), new InternetAddress("rohit@untangleds.com"),
				new InternetAddress("ningaraj@wimate.in") };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		// msg.addRecipient(RecipientType.CC, new
		// InternetAddress("divya@untangleds.com"));
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		Transport.send(msg);
	}

	public static void main(String message1) {

	        // Get the smsbalance using the getter
	        int currentsmsbalance = TextlocalSMSBalance.getSmsbalance();

       
       
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "587";

		// String mailFrom = "cloudtesla@wimate.in";
		// String password = "rnmfpibiyjllugqj";// Others and Jenkins

		String mailFrom = "automationwimate@gmail.com";
		String password = "usclyhgnwbcwsfmg";// Others and Jenkins

		// message info
		String mailTo = "rafeek@wimate.in";
		String ProjectName = "Text local SMS Balance:"+currentsmsbalance+"";
		String message = "Test-cases Reports";
		message = "<h1><font color=blue><b>Test Cases Reports<b></font></h1>";
		message += "<h2><b>Project Name :" + ProjectName + "</b></h2>";
//		message += "<h2><b>Project Name :" + "This is an automated email, please do not reply.\n"
//				+ "" + "</b></h2>";


		message += "<table cellpadding=\"0\" cellpadding=\"0\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;width:100%;margin:0;padding:35px 0\"> <tr><th>Test Name</th><th>Results</th></tr>";

		int count = 0;
		for (int i = 0; i < message1.length(); i++) {
			if (message1.charAt(i) == ',')
				count++;
		}

		String[] Testcases_Name = message1.split(",");
		for (int c = 0; c < count; c++) {
			String Testcases_Namec = Testcases_Name[c];
			if (Testcases_Namec.contains("Failed")) {
				message += "<tr>";
				Testcases_Namec = Testcases_Namec.substring(17);
				message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#b30000;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
						+ Testcases_Namec + "</font></h4></td>";
				message += "<td bgcolor=\"#b30000\" style=\"font-family:'Google Sans',Roboto,RobotoDraft"
						+ ",Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;"
						+ "line-height:18px;border-width:3px;border-style:solid;width:2em;height:"
						+ "1em;border-color:#fff;font-size:20px;text-align:center;"
						+ "color:#b30000\"></font></h4></td>";
				message += "</tr>";

			} else if (Testcases_Namec.contains("Passed")) {
				message += "<tr>";
				Testcases_Namec = Testcases_Namec.substring(17);
				message += "<td style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;color:#009900;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center\">"
						+ Testcases_Namec + "</font></h4></td>";

				message += "<td bgcolor=\"#009900\" style=\"font-family:'Google Sans',Roboto,RobotoDraft,Helvetica,Arial,sans-serif;box-sizing:border-box;padding:10px 5px;line-height:18px;border-width:3px;border-style:solid;width:2em;height:1em;border-color:#fff;font-size:20px;text-align:center;color:#009900\"></font></h4></td>";
				message += "</tr>";

			} else {
				message += "<h4>" + Testcases_Namec + "</h4>";
			}
		}

		String subject = "Text local SMS Balance is low!, smsbalance:"+currentsmsbalance+" ," + LocalDateTime.now() + "";

		try {
			sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject);
			System.out.println("Email sent Succesfully..");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}

	}

}
