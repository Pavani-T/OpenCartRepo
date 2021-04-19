package com.opencart.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Workbook book;
	public static Sheet sh;
	public static Cell cell;

	public static void setExcelFile(String sheetname) throws IOException {

		String filePath = System.getProperty("user.dir");
		String fileName = "OpenCart.xlsx";
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		// Workbook book = null;
		// String fileExtensionName = fileName.substring(fileName.indexOf("."));
		book = new XSSFWorkbook(inputStream);
		System.out.println(sheetname);
		sh = book.getSheet(sheetname);
	}

	public static String getCellData(int rowNumber, int cellNumber) {
		// getting the cell value from rowNumber and cell Number
		cell = sh.getRow(rowNumber).getCell(cellNumber);

		// returning the cell value as string
		return cell.getStringCellValue();
	}

	public static int getRowCountInSheet() {
		int rowcount = sh.getLastRowNum() - sh.getFirstRowNum();
		return rowcount;
	}

	public static String getcellvalue(String rowval) {
		// TODO Auto-generated method stub
		int row = getRowCountInSheet();
		for (int i = 0; i <= row; i++) {

			Cell key = sh.getRow(i).getCell(0);

			String key1 = key.toString();
			// System.out.println("Row key value "+key.toString());
			// System.out.println(" row value "+rowval);
			if (key1.equalsIgnoreCase(rowval) == true) {
				cell = sh.getRow(i).getCell(1);
				// System.out.println("cell value mathed with key "+ cell);
			}
		}

		return cell.getStringCellValue();

	}

	/*
	 * public static void main(String...strings) throws IOException{ // public void
	 * readExcel() throws IOException{ String filePath =
	 * System.getProperty("user.dir"); String fileName = "HCL.xlsx"; File file = new
	 * File(filePath+"\\"+fileName); FileInputStream inputStream = new
	 * FileInputStream(file); Workbook book = null; String fileExtensionName =
	 * fileName.substring(fileName.indexOf("."));
	 * if(fileExtensionName.equals(".xlsx")){ book = new XSSFWorkbook(inputStream);
	 * } else if(fileExtensionName.equals(".xls")){ book = new
	 * HSSFWorkbook(inputStream); } Sheet sh = book.getSheet("demo"); int rowCount =
	 * sh.getLastRowNum(); for (int i = 0; i < rowCount+1; i++) { Row row =
	 * sh.getRow(i); for (int j = 0; j < row.getLastCellNum(); j++) {
	 * 
	 * System.out.print(row.getCell(j).getStringCellValue()+"|| "); // if (
	 * row.getCell(j) == cell.CELL_TYPE_NUMERIC) //
	 * System.out.println(cell.getNumericCellValue() + "\t"); // else if
	 * (cell.getCellType() == Cell.CELL_TYPE_STRING) //
	 * System.out.println(cell.getStringCellValue() + "\t"); } }
	 * System.out.println(); } }
	 */

}
