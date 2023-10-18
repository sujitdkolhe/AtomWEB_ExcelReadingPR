package com.atom.healthcare.Utils;

import java.io.BufferedInputStream;
import java.lang.reflect.Method;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.page.Pojo.AHC;

public class ExcelSheetReader {

	private static XSSFWorkbook workBook;
	private InputStream inputStream;
	private FileOutputStream fileoutputStream;
	private Integer rowIndex = 0;
	public String resourcePath = null;

	public ExcelSheetReader(String pathName, String fileName) throws IOException {
		super();

		// String resourcePath = fileName;
		resourcePath = fileName;
		String pad = null;

		// If pathName is not null then the users delibereated
		// specified the resource file in other location
		// than the classpaths.
		// If pathName is null, then the resouce file can be
		// found using the classpath.
		if (pathName != null) {
			// Checking the last "/" from the pathName
			if (pathName.endsWith("/"))
				pad = "";
			else
				pad = "/";

			resourcePath = pathName + pad + fileName;
		}

		// By default file stream writes one byte of data at a time,
		// BufferedInputStream will buffer the stream and write multi-bytes
		// at a time, this will enhance file throughput
		InputStream fileStream = getInputFileStream(resourcePath);
		inputStream = new BufferedInputStream(fileStream);

		if (fileName.endsWith("xlsx")) {
			workBook = new XSSFWorkbook(inputStream);

		} else if (fileName.endsWith("xls")) {
			HSSFWorkbook	workBook = new HSSFWorkbook(inputStream);
		}
	}

	public ExcelSheetReader(String fileName) throws IOException {
		this(null, fileName);
	}

	private InputStream getInputFileStream(String fileName) {

		ClassLoader loader = this.getClass().getClassLoader();
		InputStream inputStream = loader.getResourceAsStream(fileName);
		if (inputStream == null) {

			try {
				inputStream = new FileInputStream(fileName);

			} catch (FileNotFoundException e) {
				closeFileHandle();

				return null;
			}
		}

		return inputStream;

	}

	/**
	 * This function will closes file input stream and release the file handle to
	 * release the memory used by the stream.
	 * 
	 * <h3>Sample usage:</h3>
	 * 
	 * <pre>
	 * closeFileHandle();
	 * </pre>
	 */
	public void closeFileHandle() {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {

			}
		}
	}

	/*
	 * Search for the input key from the specified sheet name and return the index
	 * position of the row that contained the key
	 */
	private int getRowIndexByKey(String sheetName, String key) {
		int rowCount, index = -1;
		int i;
		String cellValue;
		Sheet sheet;

		// key = "-1" indicate that this caller will access
		// all row of the excel sheet, therefore the global
		// this.rowIndex is returned without using the key
		// to search for the return row.
		if (key.contains("-1")) {
			this.rowIndex++;

			return this.rowIndex;

		}

		sheet = workBook.getSheet(sheetName);
		rowCount = sheet.getPhysicalNumberOfRows();
		for (i = 0; i < rowCount; i++) {
			cellValue = sheet.getRow(i).getCell(0).toString();
			if (key.compareTo(cellValue) == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	private List<String> getRowContents(String sheetName, String key, int size) {
		int rowIndex = getRowIndexByKey(sheetName, key);
		// BaseUtilities.numberofRowsToProcess=rowIndex;
		XSSFSheet sheet = workBook.getSheet(sheetName);

		List<String> rowData = new ArrayList<String>();

		for (int i = 1; i < size + 1; i++) {
			if (sheet.getRow(rowIndex).getCell(i) != null) {
				rowData.add(sheet.getRow(rowIndex).getCell(i).toString());

			} else {
				rowData.add(null);

			}
		}
		return rowData;
	}

	public Object getSingleExcelRow(Object userObj, String key) throws ClassNotFoundException, IllegalAccessException {
		// if key is empty, the don't bother reading
		// the data. It will not be used any way.
		if ((key == null) || (key == ""))
			return null;

		List<String> excelRowData;

		String fieldType = null;
		String data = null;

		// For sub class
		String className = null;
		Object myObj = null;

		Class<?> cls = Class.forName(userObj.getClass().getName());
		Field[] fields = cls.getDeclaredFields();

		int i, j;

		try {
			// Create a new instance of the data so we can
			// store it here before return everything to the users.
			myObj = userObj.getClass().newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		}

		// Reading a row of excel data here
		className = cls.getSimpleName();
		excelRowData = getRowContents(className, key, fields.length);

		// Assigning data to user defined object
		for (i = 0; i < fields.length; i++) {
			fieldType = fields[i].getType().getName();
			data = excelRowData.get(i);

			// ---===***===---
			// primitive data type, not array
			if (data != null) {
				if (fieldType.contains(".String"))
					fields[i].set(myObj, data);
				else if (fieldType.contains(".Integer"))
					fields[i].set(myObj, new Integer(data));
				else if (fieldType.contains("int"))
					fields[i].set(myObj, Integer.parseInt(data));
				else if (fieldType.contains(".Boolean"))
					fields[i].set(myObj, new Boolean(data));
				else if (fieldType.contains("boolean"))
					fields[i].set(myObj, Boolean.parseBoolean(data));
				else if (fieldType.contains(".Double"))
					fields[i].set(myObj, new Double(data));
				else if (fieldType.contains("double"))
					fields[i].set(myObj, Double.parseDouble(data));
				else if (fieldType.contains(".Long"))
					fields[i].set(myObj, new Long(data));
				else if (fieldType.contains("long"))
					fields[i].set(myObj, Long.parseLong(data));
				else if (fieldType.contains(".Float"))
					fields[i].set(myObj, new Float(data));
				else if (fieldType.contains("float"))
					fields[i].set(myObj, Float.parseFloat(data));
				else if (fieldType.contains(".Byte"))
					fields[i].set(myObj, new Byte(data));
				else if (fieldType.contains("byte"))
					fields[i].set(myObj, Byte.parseByte(data));
				else {
					fields[i].set(myObj, data);
				}
			}
		}
		return myObj;
	}
	
	 public static String getBrowserStackPermission(String file) throws IOException {
	        FileInputStream fis = new FileInputStream(file);
		workBook = new XSSFWorkbook(fis);
		Sheet configSheet = workBook.getSheet("Config");
		String envName = null;
		String testBrowser = null;
		Row row = configSheet.getRow(0);
		for (int configRow = 0; configRow < row.getLastCellNum(); configRow++) {
			String env = row.getCell(configRow).getStringCellValue().trim();
			if (env.equals("ENV")) {
				for (int configCell = 1; configCell <= configSheet.getLastRowNum(); configCell++) {
					try {
						envName = configSheet.getRow(configCell).getCell(configRow).getStringCellValue().trim();
					} catch (Exception e) {
						break;
					}
					Sheet configurSheet = workBook.getSheet("Config");
					Row configurRow = configurSheet.getRow(0);
					for (int rowValue = 0; rowValue < configurRow.getLastCellNum(); rowValue++) {
						String ConfigBrowser = configurRow.getCell(rowValue).getStringCellValue().trim();
						
						if (ConfigBrowser.equals("BrowserStack")) {
							AtomHC.appName = configurSheet.getRow(configCell).getCell(rowValue+3).getStringCellValue()
									.trim();
							try {
								testBrowser = configurSheet.getRow(configCell).getCell(rowValue).getStringCellValue()
										.trim();
								AtomHC.brUserName = configurSheet.getRow(configCell).getCell(rowValue+1).getStringCellValue()
										.trim();
								AtomHC.brPassword = configurSheet.getRow(configCell).getCell(rowValue+2).getStringCellValue()
										.trim();
								AHC.url = configurSheet.getRow(configCell).getCell(rowValue+4).getStringCellValue()
										.trim();
								AHC.language = configurSheet.getRow(configCell).getCell(rowValue+5).getStringCellValue()
										.trim();
								AHC.udid= configurSheet.getRow(configCell).getCell(rowValue+6).getStringCellValue()
										.trim();
							} catch (Exception e) {
								break;
							}
							
						}
					}
					break;
				}
			}
		}
		return testBrowser;
	}
}