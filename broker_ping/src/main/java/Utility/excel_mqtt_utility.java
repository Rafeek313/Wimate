package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_mqtt_utility {
	
	public static void exceloverWrite(String Data, int rown, int cellno, String filename) throws Exception {
		File file = new File("/Users/aneesh/eclipse-workspace/mqtt_broker/src/test/resources/"
				+ filename + "");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		sh.getRow(rown).createCell(cellno).setCellValue(Data);
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
	}

	public static String Excelread(String filename, int row, int cell) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(
				"/Users/aneesh/eclipse-workspace/mqtt_broker/src/test/resources/" + filename
						+ "");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int col = sh.getRow(row).getLastCellNum();
		Cell c = sh.getRow(row).getCell(cell);
		String s = df.formatCellValue(c);
		// s.trim();
		return s;
	}

	public static int row_count(String FileName) throws Exception {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(
				"/Users/aneesh/eclipse-workspace/mqtt_broker/src/test/resources/" + FileName
						+ "");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);
		int row = sh.getPhysicalNumberOfRows();
		return row;
	}

	public static String epoch_con(long epoch) {
		Date date = new Date(epoch * 1000L);
		DateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		dateformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = dateformat.format(date);
		// format.setTimeZone(TimeZone.getTimeZone("India"));
		return formatted;
	}

	public static String report_dateconverter(String Repport_DT) throws Exception {
		DateFormat formatter = new SimpleDateFormat("E dd MMM yyyy HH:mm:ss");
		Date date = (Date) formatter.parse(Repport_DT);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String mongoDb_DT = cal.get(Calendar.DATE) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.YEAR)
				+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		return mongoDb_DT;

	}

}
