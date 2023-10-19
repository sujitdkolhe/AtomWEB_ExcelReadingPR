package com.atom.healthcare.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;

import org.testng.annotations.ITestAnnotation;

import com.atom.healthcare.Pojo.AtomHC;

public class AnnotationTransformer implements IAnnotationTransformer {
	String testClass;
	private static XSSFCell Cell;
	private static XSSFWorkbook workbook;

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		double priority = 0;
		String methodName = testMethod.getName();
		String testClassName = testMethod.getDeclaringClass().getName();
		String[] getClass = testClassName.split("Test.");
		String className = getClass[1];
		if (AtomHC.className.contains("ST_")) {
			priority = getST_TestcaseNameFromExcel(methodName);
		} else {
			priority = getTestcaseNameFromExcel(methodName, className);
		}
		annotation.setPriority((int) priority);
	}

	double priority;
	public double getTestcaseNameFromExcel(String method, String className) {
		try {
			FileInputStream fis = new FileInputStream(AtomHC.filePath);
			workbook = new XSSFWorkbook(fis);
			Sheet configSheet = workbook.getSheet(className);
			Row configurRow = configSheet.getRow(0);
			for (int rowValue = 0; rowValue < configurRow.getLastCellNum(); rowValue++) {
				String testSecnario = configurRow.getCell(rowValue).getStringCellValue().trim();
				String testMethods = null;
				if (testSecnario.equals("TestScenario")) {
					try {
						for (int testCellValue = 1; testCellValue <= configSheet.getLastRowNum(); testCellValue++) {
							testMethods = configSheet.getRow(testCellValue).getCell(rowValue).getStringCellValue()
									.trim();
							if (testMethods.equals(method)) {
								priority = configSheet.getRow(testCellValue).getCell(rowValue + 1)
										.getNumericCellValue();
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					return priority;
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getST_TestcaseNameFromExcel(String method) {
		try {
			FileInputStream fis = new FileInputStream(AtomHC.filePath);
			workbook = new XSSFWorkbook(fis);
			Sheet configSheet = workbook.getSheet(AtomHC.className);
			Row configurRow = configSheet.getRow(0);
			for (int rowValue = 0; rowValue < configurRow.getLastCellNum(); rowValue++) {
				String testSecnario = configurRow.getCell(rowValue).getStringCellValue().trim();
				String testMethods = null;
				if (testSecnario.equals("TestScenario")) {
					try {
						for (int testCellValue = 1; testCellValue <= configSheet.getLastRowNum(); testCellValue++) {
							testMethods = configSheet.getRow(testCellValue).getCell(rowValue).getStringCellValue()
									.trim();
							if (testMethods.equals(method)) {
								priority = configSheet.getRow(testCellValue).getCell(rowValue + 1)
										.getNumericCellValue();
								break;
							}
						}
					} catch (Exception e) {
						break;
					}
					return priority;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
