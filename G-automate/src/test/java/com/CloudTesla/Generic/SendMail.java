package com.CloudTesla.Generic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;


import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.*;



public class SendMail {
	final static JacksonFactory Json_factory = JacksonFactory.getDefaultInstance();
	private static final String APPLICATION_NAME = "NAUTOMATION";
	private static String 	CREDENTIALS_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "source" + File.separator + "rafeek"
			+ File.separator + "rafeek" + ".json";
	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	private static String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "source" + File.separator + "rafeek";
	private static final String USER_ID = "me";
	private static final String path="C:\\Users\\Ningaraj\\New programming\\G-automate\\test-output\\emailable-report.html";
	
	public static Gmail getService() throws GeneralSecurityException, IOException {
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, Json_factory, getcredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		//System.out.println(getcredentials(HTTP_TRANSPORT)); 
		return service;
	}
	
	private static Credential getcredentials(NetHttpTransport transport) throws IOException {
		// Load client secrets.
		InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(Json_factory, new InputStreamReader(in));
		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(transport, Json_factory,
				clientSecrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
				.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(9999).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}
	
	public static void sendMail(String body) throws MessagingException, IOException, GeneralSecurityException 
	{
	
	createEmail("automationwimate@gmail.com", "ningaraj@wimate.in","rohit@untangleds.com","rafeek@wimate.in", "Automated Test Report", body, getService());
    }
	
	private static void createEmail(String from, String to1,String to2, String to3, String subject, String body, Gmail service) throws MessagingException, IOException {
        Properties props = new Properties();
        Session session=Session.getDefaultInstance(props, null);

        MimeMessage emailMessage = new MimeMessage(session);
        emailMessage.setFrom(new InternetAddress(from));
        emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));
        emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(to2));
        emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(to3));
        emailMessage.setSubject(subject);
        //emailMessage.setText(body);
        emailMessage.setContent(body,"text/html");
        MultipartContent m=new MultipartContent();
        ByteArrayOutputStream buffer=new ByteArrayOutputStream();
        emailMessage.writeTo(buffer);
        byte[] rawMessage = buffer.toByteArray();
        String encodeMail=Base64.encodeBase64URLSafeString(rawMessage);
        com.google.api.services.gmail.model.Message msg= new com.google.api.services.gmail.model.Message();
        msg.setRaw(encodeMail);
        try {
        	msg=service.users().messages().send("me", msg).execute();
        	System.out.println("message Id:"+msg.getId());
        	System.out.println(msg.toPrettyString());
        }
        catch(GoogleJsonResponseException e)
        {
        	System.out.println("Message not sent: "+e.getDetails());
        }
        
    }

}
