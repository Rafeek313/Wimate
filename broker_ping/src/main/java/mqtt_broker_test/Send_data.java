package mqtt_broker_test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.excel_mqtt_utility;

public class Send_data {

	static JSONArray MPJsonArray = null;

	private static final String USERNAME_Mist = "WiAuth_Server";
	private static final String PASSWORD_Mist = "A1brk@T3s!";

	private static final String USERNAME_MSG = "wi_server";
	private static final String PASSWORD_MSG = "s1brk&msc_5";

	static String topic = "WIMATE/UR/UTMS/Auto_Broker_ping";
	static String caFilePath = "/Users/aneesh/Desktop/ca_root.pem";

	static int value = 0;
	static int i;
	static MqttClient sampleClient;
	static StringWriter out;
	static int choice;
	// static int a=11;
	static int num = 1;

	static MqttConnectOptions connopts = null;

	public static void MainMEthod(int broker) throws Exception, InterruptedException, MqttException, ParseException {
		// System.out.println("Enter your Choice");
	//	int No_of_Device = excel_mqtt_utility.row_count("Device_Info.xlsx");

		//System.out.println("0 : tcp://35.185.83.78:1883");
		//System.out.println("1 : ssl://msg.cloudtesla.com:8883");
		//System.out.println("2 : tcp://mitsubishi.cloudtesla.com");
		//System.out.println("3 : Succesfully exit");

		// Scanner sc = new Scanner(System.in);
		// choice = sc.nextInt();

		// for (int ch = 0; ch <= 0; ch++) {
		choice = broker;

		switch (choice) {
		case 0:
			for (int x = 0; x < 1; x++) {
				System.out.println("Sending Packet to Main Broker");
				MQTT_Genral(x, broker);
			}
			break;

		case 1:
			for (int z = 0; z < 1; z++) {
				System.out.println("Sending Packet to mitsubishi.cloudtesla.com");
				MQTT_Genral(z, broker);
			}
			break;

		case 2:
			for (int y = 0; y < 1; y++) {
				System.out.println("Sending Packet to msg.cloudtesla.com:8883");
				MQTT_Genral(y, broker);
			}
			break;

		case 3:
			System.exit(0);

		default:
			System.out.println("Invalid choice");
		}
	}
	// }

	public static MqttConnectOptions setUpConnectionOptions(String username, String password) {
		connopts = new MqttConnectOptions();
		connopts.setCleanSession(true);
		connopts.setUserName(username);
		connopts.setPassword(password.toCharArray());
		return connopts;
	}

	public static SSLSocketFactory getSocketFactory(final String caFilePath) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		// load certificate
		X509Certificate caCert = null;
		FileInputStream fis = new FileInputStream(caFilePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		while (bis.available() > 0) {
			caCert = (X509Certificate) cf.generateCertificate(bis);
			// System.out.println(caCert.toString());
		}
		// CA certificate is used to authenticate server
		KeyStore caKs = KeyStore.getInstance(KeyStore.getDefaultType());
		caKs.load(null, null);
		caKs.setCertificateEntry("ca-certificate", caCert);
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
		tmf.init(caKs);
		// Creating SSL Factory
		SSLContext context = SSLContext.getInstance("TLSv1.2");
		context.init(null, null, null);
		System.out.println("LAST");
		return context.getSocketFactory();
	}

	public static void MQTT_Genral(int l, int brokr) throws Exception {
		String content;
		int qos = 0;
		// MQTT broker IP
		String broker[] = new String[] { "tcp://35.185.83.78:1883", "tcp://mitsubishi.cloudtesla.com",
				"ssl://msg.cloudtesla.com:8883" };

		String clientId = "4321";
		String numoftimes = "1";
		String deviceName = "Auto_Broker_ping";
		String numofpa = "6";

		int numOfTimesToRun = Integer.valueOf(numoftimes);
		int numOfPara = Integer.valueOf(numofpa);

		JSONObject packet = new JSONObject();
		packet.put("MI", "7");
		// GD changed to UD and GI is achnged to UI
		packet.put("UD", "1234");
		packet.put("UI", "1234");
		packet.put("SD", 0);
		packet.put("NSS", 1);

		String str;
		MPJsonArray = new JSONArray();
		out = new StringWriter();

		if (choice == 0) {
			sampleClient = new MqttClient(broker[choice], clientId);
			connopts = new MqttConnectOptions();
			connopts.setCleanSession(true);
		} else if (choice == 1) {
			sampleClient = new MqttClient(broker[choice], clientId);
			connopts = setUpConnectionOptions(USERNAME_Mist, PASSWORD_Mist);
		} else if (choice == 2) {
			sampleClient = new MqttClient(broker[choice], clientId);
			connopts = new MqttConnectOptions();
			connopts.setUserName(USERNAME_MSG);
			connopts.setPassword(PASSWORD_MSG.toCharArray());
			connopts.setConnectionTimeout(60);
			connopts.setKeepAliveInterval(60);
			connopts.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1);
			SSLSocketFactory socketFactory = getSocketFactory(caFilePath);
			connopts.setSocketFactory(socketFactory);
		}

		System.out.println("Connecting to broker: " + broker[choice]);
		sampleClient.connect(connopts);
		System.out.println("Connected");

		JSONObject MP = new JSONObject();
		MP.put("MT", 1);
		MP.put("MD", 1);
		MP.put("FI", 1001);
		MP.put("SSS", 0);
		MP.put("CS", 1);
		MP.put("PT", 0);
		MP.put("PS", 0);
		MP.put("PQ", 1);
		MP.put("DL", numOfPara);
		MP.put("MN", deviceName);

		for (int c = 1; c <= numOfTimesToRun; c++) {

			long epoch = (System.currentTimeMillis() + 19800000) / 1000;
			// current time calculation
			// packet.put("DT", epoch);

			for (i = 0; i < numOfPara; i++) {
				// To send the packet with random numbers
				Random rand = new Random();
				int max = 100, min = 50;
				MPJsonArray.put(rand.nextInt(max - min + 1) + min);
			}

			str = "";
			MP.put("MM", MPJsonArray);
			packet.put("DT", epoch);
			packet.put("MP", MP);
			packet.write(out);
			content = packet.toString();

			try {
				System.out.println("Publishing message : " + content);
				MqttMessage message = new MqttMessage(content.getBytes());
				message.setQos(qos);
				sampleClient.publish(topic, message);
				System.out.println("Message published : " + i);
				System.out.println("MQTT Connection is connected : " + sampleClient.isConnected());
				Assert.assertEquals(sampleClient.isConnected(), false);
				System.out.println("-------------------------------------------------------------------");
			}

			catch (MqttException me) {
				System.out.println("Reason : " + me.getReasonCode());
				System.out.println("Error Message : " + me.getMessage());
				System.out.println("Local Message : " + me.getLocalizedMessage());
				System.out.println("Cause : " + me.getCause());
				System.out.println("Exception : " + me);
				me.printStackTrace();
			}

			// Incrementing the packet value
			value = value + 1;

			// epoch=epoch+300;//5 min difference
			// Half an hour difference
			// System.out.println(":" + epoch);
			// Current time 5:30 Hrs time difference(For GMT Difference)

			System.out.println(("Actual Time:" + (epoch - 23400)));
			String date = excel_mqtt_utility.epoch_con(epoch);
			System.out.println(date);
			Thread.sleep(1000);
			MPJsonArray = new JSONArray();
		}
		sampleClient.disconnect();
		System.out.println("Disconnected");
	}

}
