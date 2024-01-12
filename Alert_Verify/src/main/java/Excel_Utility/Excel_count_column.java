package Excel_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_count_column {
	
	public static int Last_columnNumber(String FileName,int sheetno){
		int row = 0;
		int maxCell = 0;
		try {
			DataFormatter df = new DataFormatter();
			FileInputStream fis = new FileInputStream("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/" + FileName + "");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheetAt(sheetno);
			row = sh.getLastRowNum();
			Row r = sh.getRow(row);
			maxCell=  r.getLastCellNum();
			System.out.println("No of column : "+maxCell);			
		} catch (Exception e) {
			System.out.println(e);
			}
		
		return maxCell;
	}
	

}
