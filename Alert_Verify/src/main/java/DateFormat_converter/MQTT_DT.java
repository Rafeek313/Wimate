package DateFormat_converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MQTT_DT {
	
	public static String Mqtt_DT(String MQTT_DT) throws Exception {
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Date date = (Date) formatter.parse(MQTT_DT);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String mongoDb_DT = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR)
				+ ":" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);
		return mongoDb_DT;

	}
	

}
