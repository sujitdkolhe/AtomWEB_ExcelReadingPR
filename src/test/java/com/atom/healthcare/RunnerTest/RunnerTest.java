package com.atom.healthcare.RunnerTest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Utils.ExcelSheetReader;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.util.BasePageObject;

public class RunnerTest {
	String testClass;
	String runMode;
	private static XSSFCell Cell;
	private static XSSFWorkbook workbook;

	/*
	 * This main method is used to read prerequisite data from "Test_CONFIG.xlsx"
	 * excel sheet and Run test cases It will get Environment details, Browsers
	 * details , Device name, Platform name, Platform versions details from "Config"
	 * sheet It will compare DeviceName column from "Config" sheet with "TestClass"
	 * sheet It will take class name from "TestClass" sheet And Run test cases
	 */

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		AtomHC.filePath = scanner.nextLine().trim();
		scanner.close();
		System.out.println("Input file path " + AtomHC.filePath);
		AtomHC.browserStackPermission = ExcelSheetReader.getBrowserStackPermission(AtomHC.filePath);// It will take "Browser Stack" permission
		FileInputStream fis = new FileInputStream(AtomHC.filePath);
		workbook = new XSSFWorkbook(fis);
		Sheet configSheet = workbook.getSheet("Config");
		String envName = null;
		Row row = configSheet.getRow(0);
		for (int configRow = 0; configRow < row.getLastCellNum(); configRow++) {
			String env = row.getCell(configRow).getStringCellValue().trim();
			if (env.equals("ENV")) {
				for (int configCell = 1; configCell <= configSheet.getLastRowNum(); configCell++) {
					envName = configSheet.getRow(configCell).getCell(configRow).getStringCellValue().trim();
					if (!envName.equals(null) && !envName.equals("")) {
						Sheet configurSheet = workbook.getSheet("Config");
						Row configurRow = configurSheet.getRow(0);
						for (int rowValue = 0; rowValue < configurRow.getLastCellNum(); rowValue++) {
							String deviceName = configurRow.getCell(rowValue).getStringCellValue().trim();
							String testDevice = null;
							if (deviceName.equals("DeviceName")) {
								try {
									testDevice = configurSheet.getRow(configCell).getCell(rowValue).getStringCellValue()
											.trim();
									int versionValue = rowValue + 2;
									double version = configurSheet.getRow(configCell).getCell(versionValue)
											.getNumericCellValue();
									AHC.platformVersion = String.valueOf(version);
									AHC.platformName = configurSheet.getRow(configCell).getCell(rowValue + 1)
											.getStringCellValue();
									// AHC.batFilePath =
									// configurSheet.getRow(configCell).getCell(rowValue+3).getStringCellValue();
								} catch (Exception e) {
									break;
								}
								XmlSuite suite = new XmlSuite();
								suite.setName("Suite");
								XmlTest test = new XmlTest(suite);
								test.setName("AlphaMD");
								List<XmlSuite> suites = null;
								List<XmlClass> classes = new ArrayList<XmlClass>();
								Sheet testClassSheet = workbook.getSheet("TestClass");
								Row testRow = testClassSheet.getRow(0);
								for (int testRowValue = 0; testRowValue < testRow.getLastCellNum(); testRowValue++) {
									String device = testRow.getCell(testRowValue).getStringCellValue().trim();
									if (device.equals(testDevice)) { // Compare Device
										AHC.deviceName = testDevice;
										for (int testCellValue = 1; testCellValue <= testClassSheet
												.getLastRowNum(); testCellValue++) {
											try {
												AtomHC.className = testClassSheet.getRow(testCellValue)
														.getCell(testRowValue).getStringCellValue().trim();
												BasePageObject.log("Class Name: " + AtomHC.className);
												classes.add(
														new XmlClass("com.atom.healthcare.Test." + AtomHC.className));
											} catch (Exception e) {
												break;
											}
										}
										test.setXmlClasses(classes);// add all classes in classes tag
										suites = new ArrayList<XmlSuite>();
										suites.add(suite);
										TestNG testng = new TestNG();
										testng.setXmlSuites(suites);// add suites
										testng.run();// start run suite
									}
								}
								break;
							}
						}
						break;
					}
					
				}
			} 
		}
	}

}
