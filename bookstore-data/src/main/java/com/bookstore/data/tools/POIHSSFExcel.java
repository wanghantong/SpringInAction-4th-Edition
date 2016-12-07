package com.bookstore.data.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * use HSSF to read Excel, same with jxl(JavaExcelApi) to read
 * 
 * the case data format should be liked this:
 * 
 * * caseStart A A A A A * B B B B B * C C C C C caseEnd
 * 
 * attention : one case data must be put in one sheet, the start flag is
 * "caseStart" and the end flag is "caseEnd", when read the data, it will return
 * an Object of an Object of an array(array[][]). It is easy to use by Junit4 @parameters
 * or TestNg @DataProvider(name = "") for test.
 * 
 * @author T.Y
 * 
 */
public class POIHSSFExcel {

	/**
	 * Operate by event
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public static String[][] readByHSSF_Sax(String filePath, String sheetName)
			throws InvalidFormatException, IOException {
		InputStream inp = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet(sheetName);
		if (sheet.equals("") || sheet == null) {
			throw new RuntimeException("sorry, can't find the sheet by name :"
					+ sheetName);
		}
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		// System.out.println("firstRowNum   " + firstRowNum +
		// "   lastRowNum   "
		// + lastRowNum);
		Row firstRow = sheet.getRow(firstRowNum);
		Row lastRow = sheet.getRow(lastRowNum);

		short firstCellNum = firstRow.getFirstCellNum();
		Cell firstCell = firstRow.getCell(firstCellNum);

		short lastCellNum = lastRow.getLastCellNum();
		Cell lastCell = lastRow.getCell(lastCellNum - 1);

		// System.out.println("firstCellNum   " + firstCellNum
		// + "   lastCellNum   " + lastCellNum);

		String firstCellText = firstCell.getRichStringCellValue().toString();
		String lastCellText = lastCell.getRichStringCellValue().toString();

		// System.out.println("firstCellText   " + firstCellText
		// + "   lastCellText   " + lastCellText);

		if (!firstCellText.equalsIgnoreCase("caseStart")
				|| !lastCellText.equalsIgnoreCase("caseEnd")) {
			throw new RuntimeException("warning: the data format error!");
		}
		/**
		 * 行数就是末行-初始行+1, 列是从firstRow的firstCellNum+1 到 lastRow的lastCellNum - 1
		 * 数据格式: S A A A A B B B B C C C C E
		 */
		String[][] toArray = new String[lastRowNum - firstRowNum + 1][lastCellNum
				- firstCellNum - 2];
		// for (Row row : sheet) {
		for (int i = 0; i < lastRowNum - firstRowNum + 1; i++) {
			for (int j = 1; j <= lastCellNum - firstCellNum - 2; j++) {
				// for (Cell cell : row) {
				// CellReference cellRef = new CellReference(firstRowNum + i,
				// sheet.getRow(firstRowNum + i).getCell(firstCellNum + j)
				// .getColumnIndex());
				// System.out.print(cellRef.formatAsString());
				// System.out.print(" - ");
				switch (sheet.getRow(firstRowNum + i).getCell(firstCellNum + j)
						.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					String text = sheet.getRow(firstRowNum + i)
							.getCell(firstCellNum + j).getRichStringCellValue()
							.getString();
					// System.out.println(text);
					toArray[i][j - 1] = text;
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(sheet.getRow(
							firstRowNum + i).getCell(firstCellNum + j))) {
						Date dateCellValue = sheet.getRow(firstRowNum + i)
								.getCell(firstCellNum + j).getDateCellValue();
						text = DateFormat.dateChange(dateCellValue,
								"yyyy-MM-dd hh:mm:ss");
						// System.out.println(text);
						toArray[i][j - 1] = text;
					} else {
						double numericCellValue = sheet.getRow(firstRowNum + i)
								.getCell(firstCellNum + j)
								.getNumericCellValue();
						text = numericCellValue + "";
						System.out.println(text);
						toArray[i][j - 1] = text;
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					boolean booleanCellValue = sheet.getRow(firstRowNum + i)
							.getCell(firstCellNum + j).getBooleanCellValue();
					text = Boolean.toString(booleanCellValue);
					// System.out.println(text);
					toArray[i][j - 1] = text;
					break;
				case Cell.CELL_TYPE_FORMULA:
					String cellFormula = sheet.getRow(firstRowNum + i)
							.getCell(firstCellNum + j).getCellFormula();
					text = cellFormula;
					// System.out.println(cellFormula);
					toArray[i][j - 1] = text;
					break;
				default:
					// System.out.println();
				}
			}
		}
		return toArray;
		// System.out.println("toarray   :   " + toArray);
	}

	/**
	 * Operate by event
	 */
	public void readByHSSF_Dom() {

	}

	/**
	 * Operate in memory
	 * 
	 * @throws IOException
	 */
	public static void writeByHSSF_Dom(String filePath, String sheetName,
			String tableName, Object[][] array, int startRow, int startColumn)
			throws IOException {

		Workbook wb = new HSSFWorkbook(); // or new HSSFWorkbook();
		Sheet sheet = wb.createSheet(sheetName);

		for (int i = startRow; i < startRow + array.length; i++) {
			Row row = sheet.createRow(i);
			for (int j = startColumn; j < startColumn + array[i].length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue((String) array[i][j]);
			}
		}
		// to enable newlines you need set a cell styles with wrap=true
		// CellStyle cs = wb.createCellStyle();
		// cs.setWrapText(false);
		// cell.setCellStyle(cs);

		// increase row height to accomodate two lines of text
		// row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));

		// adjust column width to fit the content
		// sheet.autoSizeColumn((short) 2);

		FileOutputStream fileOut = new FileOutputStream(filePath);
		wb.write(fileOut);
		fileOut.close();

	}

	public Cell findCell(HSSFSheet sheet, String contents) {
		Cell cell = null;
		boolean found = false;

		// for (int i = 0; i < sheet.getRows() && found == false; i++) {
		// Cell[] row = sheet.getRow(i);
		// for (int j = 0; j < row.length && found == false; j++) {
		// if (row[j].getContents().equals(contents)) {
		// cell = row[j];
		// found = true;
		// }
		// }
		// }

		return cell;
	}

}
