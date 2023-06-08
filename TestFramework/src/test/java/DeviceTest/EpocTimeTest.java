package DeviceTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EpocTimeTest {
     public static void  MQTT_DB() throws ParseException{
    	 String MQTT = "29/12/2022:9:42";
 		String DEB_DT ="29/12/2022:9:42";
 		String REP_DT ="29/12/2022:9:43";
 		
 		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy:HH:mm");
 		Date MQTTdate = df.parse(MQTT);
 		Date DEB_DTdate = df.parse(DEB_DT);
 		Date REP_DTdate = df.parse(REP_DT);
 		long MQTTepoch = MQTTdate.getTime();
 		long DEB_DTepoch = DEB_DTdate.getTime();
		long REP_DTepoch=REP_DTdate.getTime();
 		
 		System.out.println(MQTTepoch);
 		System.out.println(DEB_DTepoch);
 		System.out.println(REP_DTepoch);
 		
 		if(MQTTepoch == DEB_DTepoch && DEB_DTepoch==REP_DTepoch)
 		{
 			System.out.println("MQTT,DB AND REPORT time is same");
 		}
     
 		else if(MQTTepoch<DEB_DTepoch)
 		{
 			if(MQTTepoch+60000==DEB_DTepoch) {
 				
 			System.out.println("Dashboard time  has 1 second diffrence than MQTT time. pass");
 			}
 		}
 		else if(MQTTepoch<REP_DTepoch)
 		{
 			if(MQTTepoch+60000== REP_DTepoch)
 			{
 			System.out.println("report time  has 1 second diffrence than mqtt time. pass");
 		}
 		}
 		else if(MQTTepoch>DEB_DTepoch || MQTTepoch>REP_DTepoch)
 		{
 			if(MQTTepoch==DEB_DTepoch+60000)
 			{
 				System.out.println("MQTTtime has 1 second diffrence than db time. pass");
 			}
 			else if(MQTTepoch==REP_DTepoch+60000)
 			{
 				System.out.println("MQTTtime has 1 second diffrence than report time. pass");
 			}
 		}
 		else
 		{
 			System.out.println("fail");
 		}
    	 
     }
    	
	public static void main(String[] args) throws ParseException {
		MQTT_DB();
		}

		
		
	}


