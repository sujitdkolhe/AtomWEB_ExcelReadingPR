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
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.ExcelSheetReader;

public class RunnerTest {
	String testClass;
	String runMode;
	private static XSSFCell Cell;
	private static XSSFWorkbook workbook;

	/*
	 * This main method is used to read prerequisite data from "Test_CONFIG.xlsx"
	 * excel sheet and Run test cases It will get Environment details, Browsers
	 * details , browser specific version details, and Env Url from "Config" sheet
	 * It will compare browsers coloumn from "Config" sheet with "TestClass" sheet
	 * It will take class name from "TestClass" sheet And Run test cases
	 */

	public static void main(String[] args) throws Exception {
		System.out.println("Enter Test_ConfigPath:--   ");
		Scanner scanner = new Scanner(System.in);
		AtomHC.filePath = scanner.nextLine();
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
							String ConfigBrowser = configurRow.getCell(rowValue).getStringCellValue().trim();
							String testBrowser = null;
							if (ConfigBrowser.equals("Browser")) {
								try {
									testBrowser = configurSheet.getRow(configCell).getCell(rowValue)
											.getStringCellValue().trim();
									int versionValue = rowValue + 1;
									AtomHC.version = configurSheet.getRow(configCell).getCell(versionValue)
											.getNumericCellValue();
									AtomHC.URL = configurSheet.getRow(configCell).getCell(rowValue + 2)
											.getStringCellValue();
								} catch (Exception e) {
									break;
								}
								XmlSuite suite = new XmlSuite();
								suite.setName("Suite");
								XmlTest test = new XmlTest(suite);
								List<XmlSuite> suites = null;
								List<XmlClass> classes = new ArrayList<XmlClass>();
								Sheet testClassSheet = workbook.getSheet("TestClass");
								Row testRow = testClassSheet.getRow(0);
								for (int testRowValue = 0; testRowValue < testRow.getLastCellNum(); testRowValue++) {
									String browser = testRow.getCell(testRowValue).getStringCellValue().trim();
									if (browser.equals(testBrowser)) { // Compare browser
										AtomHC.browser = testBrowser;
										for (int testCellValue = 1; testCellValue <= testClassSheet
												.getLastRowNum(); testCellValue++) {
											try {
												AtomHC.className = testClassSheet.getRow(testCellValue)
														.getCell(testRowValue).getStringCellValue().trim();
												BasePageObject.log("Class Name: " + AtomHC.className);
												for (Object[] getData : BasePageObject
														.readExcelFile(AtomHC.className)) {
													String className = (String) getData[0];

													XmlClass testClass = new XmlClass(
															"com.atom.healthcare.Test." + className);
													List<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();
													AtomHC.methodName = (String) getData[1];
													XmlInclude method = new XmlInclude(AtomHC.methodName);
													methodsToRun.add(method);
													testClass.setIncludedMethods(methodsToRun);
													classes.add(testClass);// adding all testclasses the mention in
																			// 'testClass' excel sheet
												}
											} catch (Exception e) {
												break;
											}
										}
										test.setXmlClasses(classes);// add all classes in classes tag
										suites = new ArrayList<XmlSuite>();
										suite.addListener("com.atom.healthcare.Test.AnnotationTransformer");
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
