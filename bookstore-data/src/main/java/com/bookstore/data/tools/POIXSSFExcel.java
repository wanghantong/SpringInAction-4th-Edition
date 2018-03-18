package com.bookstore.data.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIXSSFExcel {

	/**
	 * Operate by event
	 */
	public void readByXSSF_Sax() {

	}

	/**
	 * Operate in memory
	 */
	public void writeByXSSF_Dom() {
		
	}

	/**
	 * POI provides a low-memory footprint SXSSF API built on top of XSSF.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void writeBySXSSF(String filePath, String sheetName, Object[][] array)
			throws FileNotFoundException, IOException {

		XSSFWorkbook XSSFWorkbook = new XSSFWorkbook(new FileInputStream(
				"dataSource/SXSSF.xlsx"));
		SXSSFWorkbook workbook = new SXSSFWorkbook(XSSFWorkbook);
		Sheet sheet = workbook.createSheet(sheetName);
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(5);
		cell.setCellValue("caseStart");
		FileOutputStream fileOut = new FileOutputStream("dataSource/SXSSF.xlsx");
		workbook.write(fileOut);
		fileOut.close();

	}
}
