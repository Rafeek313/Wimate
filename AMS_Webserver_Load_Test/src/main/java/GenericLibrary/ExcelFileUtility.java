package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtility {
	/**
	 * this method read the data from excel file by using the parameter if user is
	 * specified
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
		String s = null;
		   try {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		Sheet sh = wb.getSheet(sheetname);
				Cell c=sh.getRow(rownum).getCell(cellnum);
			s=df.formatCellValue(c)	;
		   } catch (Exception e) {
		       System.out.println(e);
		   }
		return s;
	}

	/**
	 * this method write the data into excel file by using the parameter if user is
	 * specified
	 * 
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetname, int rownum, int cellnum, String value) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row ro = sh.getRow(rownum);
		Cell cel = ro.createCell(cellnum);
		cel.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fos);

	}

	/**
	 * this method will read the last count no.of the row by using the parameter if
	 * user is specified
	 * 
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		return count;
	}

	/**
	 * This method will read multiple data from excel sheet with the help of
	 * sheetname and return 2 dimensional object [][]
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */

	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable

	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++)

		{
			for (int j = 0; j < lastCell; j++)

			{

				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	/**
	 * this method will read data from the excel sheet and extract value from the column with comma seperation
	 * @param sheetIndex
	 * @param columnIndex
	 * @author rafeek
	 * @return
	 */
	  public static List<String> readCommaSeparatedColumn( int sheetIndex, int columnIndex) {
	        List<String> data = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheetAt(sheetIndex);
	            boolean isFirstRow = true;
	            for (Row row : sheet) {
	            	if (isFirstRow) {
	                    isFirstRow = false;
	                    continue; // Skip the first row
	                }
	                Cell cell = row.getCell(columnIndex);
	                if (cell != null) {
	                    String cellValue = cell.getStringCellValue();
	                    String[] values = cellValue.split(",");
	                    for (String value : values) {
	                        data.add(value.trim());
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return data;
	    }
	  /**
		 * this method will read data from the excel sheet and extract value from the column with comma seperation based on row
		 * @param sheetIndex
		 * @param columnIndex
		 * @param rownum
		 * @author rafeek
		 * @return
		 */
	  public static List<String> readExcelDatawithCommaSeperation(int sheetIndex, int columnIndex, int rowNum) {
	        List<String> values = new ArrayList<>();

	        try {
	            FileInputStream fileInputStream = new FileInputStream(IpathConstants.ExcelPath);

	            Workbook workbook = new XSSFWorkbook(fileInputStream);
	            Sheet sheet = workbook.getSheetAt(sheetIndex);

	            Row row = sheet.getRow(rowNum);

	            if (row != null) {
	                Cell cell = row.getCell(columnIndex);

	                if (cell != null) {
	                    String cellValue = cell.toString();
	                    String[] splitValues = cellValue.split(",");

	                    for (String value : splitValues) {
	                        values.add(value.trim());
	                    }
	                }
	            }
	            	
	            workbook.close();
	            fileInputStream.close();
	        }
	            catch (IOException e) {
	            e.printStackTrace();
	        }

	        return values;
	    }
	  public static String ReadExcel(int row, int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fl=new FileInputStream(IpathConstants.ExcelPath);
			Workbook workbook = WorkbookFactory.create(fl);
			return workbook.getSheet("Report").getRow(row).getCell(cell).getStringCellValue();
			
		  } 
	  
	  

}
