package com.magento.TestData;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelCode {
	
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType celltype;
	
	public static Object[][] readFromExcelSheetMagentoLogin(String sheetName) throws Exception {
		
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\magento\\TestData\\ExcelData_Magento.xlsx");
        workbook = new XSSFWorkbook(ip); 
		sheet = workbook.getSheet(sheetName); 
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];
		
		for(int i=0 ; i<rows ; i++) {
			row = sheet.getRow(i+1);
			for(int j=0 ; j<cols ; j++) {
					 cell = row.getCell(j);
					 celltype = cell.getCellType();
					
					switch(celltype) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
						
					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;
						
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;
				}
			 }
		}
		return data;
	}
	
	
	@DataProvider(name = "LoginMAGENTO")
	public Object[][] getMagentoLoginExcelData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetMagentoLogin("LoginMagento");
		return data;
	}
	
	
	public static Object[][] readFromExcelSheetMagentoCreateAccount(String sheetName) throws Exception {
		
	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\magento\\TestData\\ExcelData_Magento.xlsx");
    workbook = new XSSFWorkbook(ip);
	sheet = workbook.getSheet(sheetName); 
			
	 int rows = sheet.getLastRowNum(); 
	 int cols = sheet.getRow(0).getLastCellNum();
			
	
			Object[][] data = new Object[rows][cols];
			
			for(int i=0 ; i<rows ; i++) {
				row = sheet.getRow(i+1);
				for(int j=0 ; j<cols ; j++) {
						 cell = row.getCell(j);
						 celltype = cell.getCellType();
						
						switch(celltype) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
							break;
							
						case NUMERIC:
							data[i][j] = Integer.toString((int)cell.getNumericCellValue());
							break;
							
						case BOOLEAN:
							data[i][j] = cell.getBooleanCellValue();
							break;
					}
				 }
			}
			return data;
}
	
	@DataProvider(name = "CreateAccountMAGENTO")
	public Object[][] getMagentoCreateAccountExcelData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetMagentoCreateAccount("CreateAccountMagento");
		return data;
	}
	
}
