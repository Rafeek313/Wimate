package Excel_Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Read {

	public static String Excelread(String filename, int row, int cell, int sheetno) {
		String s = null;
		try {
			DataFormatter df = new DataFormatter();
			FileInputStream fis = new FileInputStream("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/" + filename + "");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheetAt(sheetno);
			int col = sh.getRow(row).getLastCellNum();
			//System.out.println(col);
			Cell c = sh.getRow(row).getCell(cell);
			s = df.formatCellValue(c);
		} catch (Exception e) {
			System.out.println("Read :"+e);
		}
		return s;

	}
	

}
