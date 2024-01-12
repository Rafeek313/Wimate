package Excel_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_write {

	public static void excelWrite_overwrite(String Data, int rown, int cellno, String filename, int sheetno) {
		try {
			File file = new File("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/" + filename + "");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(sheetno);
			int row = sh.getLastRowNum();
			if (row < rown) {
				sh.createRow(rown).createCell(cellno).setCellValue(Data);
			} else {
				sh.getRow(rown).createCell(cellno).setCellValue(Data);
			}
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			System.out.println("Write 1:"+e);
		}

	}
	
	public static void excelWrite(String Data, int rown, int cellno, String filename, int sheetno) {
		try {
			File file = new File("/Users/testingwimate/eclipse-workspace/Alert_Verify/src/main/resources/" + filename + "");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(sheetno);						
			sh.getRow(rown).createCell(cellno).setCellValue(Data);
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			System.out.println("Write 2: "+e);
		}

	}
	
}
