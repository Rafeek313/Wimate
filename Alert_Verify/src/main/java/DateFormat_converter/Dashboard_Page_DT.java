package DateFormat_converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dashboard_Page_DT {
	
	public static String DBconvdate(String datetime) throws Exception {
		DateFormat formatter = new SimpleDateFormat("E dd-MMMM-yyyy HH:mm");
		Date date = (Date) formatter.parse(datetime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/20"
				+ cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);
		return formatedDate;
	}

}
