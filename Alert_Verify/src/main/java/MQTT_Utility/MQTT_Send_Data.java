package MQTT_Utility;

import java.io.StringWriter;
import java.text.ParseException;
import java.util.Random;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONArray;
import org.json.JSONObject;

import DateFormat_converter.MQTT_DT;
import Excel_Utility.Epoch_converter;
import Excel_Utility.Excel_Read;
import Excel_Utility.Excel_count_row;
import Excel_Utility.Excel_write;

public class MQTT_Send_Data {
	static JSONArray MPJsonArray = null;
	static String topic = "WIMATE/UR/UTMS/";
	static int value = 0;
	static int i;
	static MqttClient sampleClient;
	static StringWriter out;
	static int choice = 1;
	static int num = 1;

	static MqttConnectOptions connopts = null;

	public static void MainMEthod(int a) throws Exception, InterruptedException, MqttException, ParseException {
		// System.out.println("Enter your Choice");
		System.out.println("Sending Data To Device Using MQTT Broker...");

		// int No_of_Device = Excel_count_row.Last_rowNumber("Alert_Verify.xlsx",0);

		System.out.println("0 : tcp://35.185.83.78:1883");
		choice = 0;

		switch (choice) {
		case 0:
			for (int x = 1; x <= 1; x++) {
				System.out.println("Sending Packet to Main Broker");
				MQTT_Genral(x, a);
			}
			break;
		}
	}

	public static MqttConnectOptions setUpConnectionOptions(String username, String password) {
		connopts = new MqttConnectOptions();
		connopts.setCleanSession(true);
		connopts.setUserName(username);
		connopts.setPassword(password.toCharArray());
		return connopts;
	}

	public static void MQTT_Genral(int l, int a) throws Exception {
		String content;
		int qos = 0;
		// MQTT broker IP
		String broker[] = new String[] { "tcp://35.185.83.78:1883" };

		String clientId = "12345";
		// String numoftimes = Excel_Read.Excelread("Alert_Verify.xlsx", l, 2,0);
		String deviceName = Excel_Read.Excelread("Alert_Verify.xlsx", l, 0, 0);
		// String numofpa = Excel_Read.Excelread("Alert_Verify.xlsx", l, 2,0);

		int numOfTimesToRun = Integer.valueOf(1);

		int numOfPara = Integer.valueOf(51);

		JSONObject packet = new JSONObject();
		packet.put("MI", "101");
		packet.put("UD", "1111");
		packet.put("UI", "1111");
		packet.put("SD", 0);
		packet.put("NSS", 1);

		String str;
		MPJsonArray = new JSONArray();
		out = new StringWriter();
		if (choice == 0) {
			sampleClient = new MqttClient(broker[choice], clientId);
			connopts = new MqttConnectOptions();
			connopts.setCleanSession(true);
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
			long epoch = (System.currentTimeMillis() + 19800000) / 1000; // current time calculation
			packet.put("DT", epoch);
			for (i = 0; i < numOfPara; i++) {
				// To send the packet with random numbers
				// Random rand = new Random();
				MPJsonArray.put(a);
				a++;
			}
			str = "";
			MP.put("MM", MPJsonArray);
			packet.put("MP", MP);
			packet.write(out);
			content = packet.toString();
			try {
				System.out.println("Publishing message: " + content);
				MqttMessage message = new MqttMessage(content.getBytes());
				message.setQos(qos);
				sampleClient.publish(topic, message);
				System.out.println("Message published: " + i);
				System.out.println("-------------------------------------------------------------------");
			}

			catch (MqttException me) {
				System.out.println("reason " + me.getReasonCode());
				System.out.println("msg " + me.getMessage());
				System.out.println("loc " + me.getLocalizedMessage());
				System.out.println("cause " + me.getCause());
				System.out.println("excep " + me);
				me.printStackTrace();
			}
			// Incrementing the packet value
			value = value + 1;
			// epoch=epoch+300; // half an hour difference
			// System.out.println(":" + epoch);
			// current time 5:30 Hrs time difference(For GMT Difference)
			//System.out.println(("Actual Time:" + (epoch - 23400)));
			String date = Epoch_converter.epoch_con(epoch);
			//System.out.println(date);
			//System.out.println("a value :" + a);
			String Coverted_DT = MQTT_DT.Mqtt_DT(date);
			System.out.println(Coverted_DT);

			if (a == 63) {
				//On Alert Geneataion a value is 63.
				Excel_write.excelWrite_overwrite(Coverted_DT, 1, 1, "Alert_Verify.xlsx", 0);
				//System.out.println("a value :" + a);
			} else if (a == 51) {
				//On Alert Geneataion a value is 51.
				Excel_write.excelWrite_overwrite(Coverted_DT, 1, 6, "Alert_Verify.xlsx", 0);
				//System.out.println("a value :" + a);
			}
			Thread.sleep(500);
			System.out.println("Succesfully Data Sent to Device..!");
		}
		sampleClient.disconnect();
		System.out.println("Disconnected");
	}
}
