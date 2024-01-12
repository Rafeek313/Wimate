package com.CloudTesla.Generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLib {

public static String ReadExcel(int row, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fl=new FileInputStream("./src/test/resources/Report/User.xlsx");
	Workbook workbook = WorkbookFactory.create(fl);
	return workbook.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
	
  }

}
