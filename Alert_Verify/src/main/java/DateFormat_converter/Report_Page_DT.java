package DateFormat_converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Report_Page_DT {
	
	public static String RPconvdate(String datetime) throws Exception {
		DateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy HH:mm");
		Date date = (Date) formatter.parse(datetime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
				+ cal.get(Calendar.YEAR) + ":" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);
		//System.out.println("Date :"+formatedDate);

		return formatedDate;
	}

}
