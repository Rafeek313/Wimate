package DateFormat_converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class One_minute_Offest {

	public static int DT_Comapre(String First_Date, String Second_date) throws Exception {
		System.out.println("MQTT DT and DB DT both are not same...");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy:HH:mm");

		Date date1 = formatter.parse(First_Date);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		String formatedDate1 = cal1.get(Calendar.DATE) + "/" + (cal1.get(Calendar.MONTH) + 1) + "/"
				+ cal1.get(Calendar.YEAR) + ":" + cal1.get(Calendar.HOUR);

		Date date2 = formatter.parse(Second_date);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		String formatedDate2 = cal2.get(Calendar.DATE) + "/" + (cal2.get(Calendar.MONTH) + 1) + "/"
				+ cal2.get(Calendar.YEAR) + ":" + cal2.get(Calendar.HOUR);

		System.out.println("MQTT DT Upto Hour values :" + formatedDate1);
		System.out.println("DB DT Upto Hour values :" + formatedDate2);

		int Diff_Min = 0;

		if (formatedDate1.equals(formatedDate2)) {
			int D_Min1 = cal1.get(Calendar.MINUTE);
			int D_Min2 = cal2.get(Calendar.MINUTE);
			Diff_Min = D_Min2 - D_Min1;

			System.out.println("Difference between two dates is : " + Math.abs(Diff_Min));
		} else {
			System.out.println("Two dates are not Equal...");
		}
		return Diff_Min;
	}

}