package com.atom.healthcare.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.ExcelSheetReader;

public class ST_Test {
	String testClass;
	String runMode;
	private static XSSFCell Cell;
	private static XSSFWorkbook workbook;

	@Test
	public void scenarioTest() throws Exception {
	}
}

