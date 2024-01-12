package Excel_Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_count_row {
	
	public static int Last_rowNumber(String FileName,int sheetno){
		int row = 0;
		try {
			DataFormatter df = new DataFormatter();
			FileInputStream fis = new FileInputStream("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/" + FileName + "");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheetAt(sheetno);
			row = sh.getLastRowNum();
			System.out.println("No of column : "+row);			
		} catch (Exception e) {
			System.out.println(e);
			}		
		return row;
	}
	

}
