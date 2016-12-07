package com.bookstore.data.tools;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JExcel {

	public static String[][] getTableArray(String xlFilePath, String sheetName,
			String tableName) throws BiffException, IOException {

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();

		String[][] tabArray = new String[endRow - startRow][endCol - startCol
				- 1];
		ci = 0;
		for (int i = startRow + 1; i <= endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return tabArray;
	}

	public static void WriteTableArray(String xlFilePath, String sheetName,
			String tableName, String[][] array) throws IOException {

		WritableWorkbook workbook = Workbook
				.createWorkbook(new File(xlFilePath));
		WritableSheet sheet = workbook.createSheet("new1", 0);
		Cell[] row = sheet.getRow(1);
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.err.println(array[i][j]);
			}
		}

	}
}
