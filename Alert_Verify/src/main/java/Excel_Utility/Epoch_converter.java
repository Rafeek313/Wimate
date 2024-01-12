package Excel_Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Epoch_converter {
	
	public static String epoch_con(long epoch) {
		Date date = new Date(epoch * 1000L);
		DateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		dateformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = dateformat.format(date);
		// format.setTimeZone(TimeZone.getTimeZone("India"));
		return formatted;
	}

}
