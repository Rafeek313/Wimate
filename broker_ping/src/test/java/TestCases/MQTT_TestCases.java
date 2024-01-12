package TestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import mqtt_broker_test.Send_data;


@Listeners(itestListener_Utility.Isuitelistener_test.class)

public class MQTT_TestCases {

	@Test(priority = 1, description = "mqtt://35.185.83.78:1883")
	public static void Test_Broker() throws Exception {
		try {
			Send_data.MainMEthod(0);
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}

	@Test(priority = 2, description = "mqtt://mitsubishi.cloudtesla.com")
	public static void Mitsubishi_cloudtesla() throws Exception {
		try {
			Send_data.MainMEthod(1);
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}

	@Test(priority = 3, description = "mqtts://msg.cloudtesla.com:8883")
	public static void Message_cloudtesla() throws Exception {
		try {
			Send_data.MainMEthod(2);
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}
}
