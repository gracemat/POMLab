package com.qa.activecampaign.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public static Workbook book;
	public static Sheet sheet;// import Sheet from apache poi ss usermodel()
	public static String PATH_OF_THE_SHEET = "C:\\Users\\prave\\eclipse-workspace\\POMLab\\src\\main\\java\\com\\qa\\activecampaign\\testdata\\ActiveCampaignTestData.xlsx";

	public static Object[][] fetchTestData(String nameOfTheSheet) {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(PATH_OF_THE_SHEET);// First step to get the file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fileInput);// WorBookFactory will return WorkBook class object// control is on
														// the workbook
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(nameOfTheSheet);// getSheet method returns sheetobj---- control is reached From the
												// workbook to sheet

		// We need to create 2D array object
		// Object testData[][] = new Object[6][4]; use sheet.getRow getLAstRowNum etc
		// methods

		Object[][] testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];// to avaoid hard
																									// coded values

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				testData[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return testData;
	}

}
