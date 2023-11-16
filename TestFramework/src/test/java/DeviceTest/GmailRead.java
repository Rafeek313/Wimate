package DeviceTest;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;




public class GmailRead {

	    public static void main(String[] args) {
	        // Replace these with your actual email credentials
	        String email = "rafeek@wimate.in";
	        String password = "Rafeek317322*";

	        // Connect to the mail server and read the email subjects
	        readEmailSubjects(email, password);
	    }

	    public static void readEmailSubjects(String email, String password) {
	        try {
	            // Set the properties for the mail session
	            Properties props = new Properties();
	            props.put("mail.store.protocol", "imaps"); // Using IMAP protocol to access Gmail
	            props.put("mail.imaps.host", "imap.gmail.com");
	            props.put("mail.imaps.port", "993");
	            props.put("mail.imaps.ssl.enable", "true");

	            // Create the mail session and authenticate with the server
	            Session session = Session.getInstance(props);
	            Store store = session.getStore("imaps");
	            store.connect(email, password);

	            // Open the inbox folder to read emails
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);

	            // Get the list of messages in the inbox folder
	            Message[] messages = inbox.getMessages();

	            // Loop through each message and print the subject
	            for (Message message : messages) {
	                System.out.println("Subject: " + message.getSubject());
	            }

	            // Close the folder and store
	            inbox.close(false);
	            store.close();

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	}


