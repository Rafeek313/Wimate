package objectRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import GenericLibrary.ExcelFileUtility;

public class Mqtt_broker {
	public static ExcelFileUtility elib=new ExcelFileUtility();

    public static void main(String[] args) throws IOException, Throwable {
    	String UD = elib.readDataFromExcel("MqttData", 1, 0);
    	String UI = elib.readDataFromExcel("MqttData", 1, 1);
    	String DL = elib.readDataFromExcel("MqttData", 1, 2);
    	String MM = elib.readDataFromExcel("MqttData", 1, 3);
    	System.out.println(MM);
    	String MN = elib.readDataFromExcel("MqttData", 1, 4);
    	
    	long epochTimeInSeconds = (System.currentTimeMillis()+19800000) / 1000;
    	System.out.println(epochTimeInSeconds);
 

      
        String broker = "tcp://35.185.83.78:1883"; // Change this to your broker URL
        String clientId = "73eac1f7-0c1e-4194-a7f5-313ae5c0c48b"; // Client ID should be unique
        String topic = "WIMATE/UR/UTMS/";
        System.out.println(topic);
        //String content = "{\"MI\":1,\"UD\":\""+UD+"\",\"UI\":\""+UI+"\",\"DT\": "+epochTimeInSeconds+",\"SD\":0,\"NSS\":101,\"MP\":{\"MT\":1,\"MD\":1,\"FI\":1,\"SSS\":0,\"CS\":1,\"PT\":0,\"PS\":0,\"PQ\":4,\"MM\":["+MM+"],\"DL\":"+DL+",\"MN\":\""+MN+"\"}}";
        String content = "{\"DT\":"+epochTimeInSeconds+",\"SD\":0,\"MP\":{\"CS\":1,\"MM\":["+MM+"],\"PQ\":1,\"MN\":\""+MN+"\",\"SSS\":0,\"FI\":1001,\"PS\":0,\"PT\":0,\"MT\":1,\"MD\":1,\"DL\":"+DL+"},\"UI\":\""+UI+"\",\"MI\":\"101\",\"UD\":\""+UD+"\",\"NSS\":1}";
        System.out.println(content);

        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            client.connect(options);

            MqttMessage message = new MqttMessage(content.getBytes());
            client.publish(topic, message);
            System.out.println(message);

            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}




