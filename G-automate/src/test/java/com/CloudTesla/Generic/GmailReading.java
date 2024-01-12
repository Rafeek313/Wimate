package com.CloudTesla.Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartHeader;

public class GmailReading {

	final static JacksonFactory Json_factory = JacksonFactory.getDefaultInstance();
	private static final String APPLICATION_NAME = "cloudtesla";
	private static String CREDENTIALS_FILE_PATH;
	private static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
	private static String TOKENS_DIRECTORY_PATH;
	private static final String USER_ID = "me";


	

	public  long getMail(String user, String key) throws GeneralSecurityException, IOException {

		

			CREDENTIALS_FILE_PATH = System.getProperty("user.dir") +
					File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "source" + File.separator + user
					+ File.separator + user + ".json";

			TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "source" + File.separator + user;

			Gmail service = getService();
			String keyword = key;
			System.out.println("Key : " + keyword);
			String query = "in:inbox " + keyword;
			// System.out.println("Query : "+query);
			List<Message> hm = listMessagesByKeyword(service, USER_ID, keyword);
			System.out.println("mails of " + user);
			System.out.println(
			"==================================**********************************==================================");
			if(hm!=null) {
			for (Message message : hm) {
				// Get the full message details by retrieving the message using its ID
				Message fullMessage = service.users().messages().get(USER_ID, message.getId()).execute();

				// Extract the subject and time (date) from the full message details

				String subject = (String) fullMessage.getPayload().getHeaders().stream()
						.filter(header -> header.getName().equals("Subject")).findFirst()
						.map(header -> header.getValue()).orElse("No subject");

				String body = extractMessageBody(fullMessage.getPayload());

				long timestampMillis = fullMessage.getInternalDate();
				java.util.Date date = new java.util.Date(timestampMillis);
				String sender = getSenderFromMessage(fullMessage);

				System.out.println("From:---->" + sender);
				System.out.println("Subject:-> " + subject);
				System.out.println("Time:----> " + date);
				System.out.println("Body:----->" + body);
				System.out.println("-------------------");
				System.out.println("***********************************************");
				ListMessagesResponse response = service.users().messages().list(USER_ID).setQ(query).execute();
				System.out.println("Total messages retrieved: " + response.getMessages().size());
				return timestampMillis;
				
			}
			}
			else
			{
				System.out.println("No messages");
				return 0;
			}
		return 0;
			
		}

	

	private static List<Message> listMessagesByKeyword(Gmail service, String userId, String keyword) {
		String query = "in:inbox " + keyword; // Search for the keyword in the inbox
		System.out.println(query);
		try {
			ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
			return response.getMessages();
		} catch (Exception e) {
			System.out.println("inbox not contain required email");
			return null;
		}

	}

	private static Gmail getService() throws GeneralSecurityException, IOException {
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, Json_factory, getcredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		return service;
	}

	@SuppressWarnings("unused")
	private static Credential getcredentials(NetHttpTransport transport) throws IOException {
		// Load client secrets.
		InputStream in = new FileInputStream(new File(CREDENTIALS_FILE_PATH));
		if (in == null) 
		{
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

	public static String extractMessageBody(MessagePart messagePart) {
		String mimeType = messagePart.getMimeType();
		if (messagePart.getBody().getAttachmentId() != null) {
			// Handle attachment
			return "Attachment included";
		} else if (mimeType.startsWith("text/plain")) {
			return new String(messagePart.getBody().decodeData());
		}

		else if (mimeType.startsWith("multipart/")) {
			// Handle multipart message
			List<MessagePart> parts = messagePart.getParts();
			for (MessagePart part : parts) {
				if (part.getMimeType().startsWith("text/plain")) {
					return new String(part.getBody().decodeData());
				}
			}
		}
		return "not available";
	}

	public static String getSenderFromMessage(Message message) {
		for (MessagePartHeader header : message.getPayload().getHeaders()) {
			if ("From".equalsIgnoreCase(header.getName())) {
				return header.getValue();
			}
		}
		return "Unknown Sender";
	}

}
