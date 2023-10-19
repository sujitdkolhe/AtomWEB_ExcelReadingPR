package com.atom.healthcare.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@SuppressWarnings("resource")
public class ReadExcel {

	public String adminUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(2);
		String username = cell.getStringCellValue();
		return username;
	}

	public String adminPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(3);
		String password = cell.getStringCellValue();
		return password.trim();
	}

	public String getProgramName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(7);
		XSSFCell cell = row.getCell(1);
		String programName = cell.getStringCellValue();
		return programName.trim();
	}

	public String getFirstCaregiverName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}

	public String getFirstCaregiverUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(3);
		String firstCaregiverUsername = cell.getStringCellValue();
		return firstCaregiverUsername.trim();
	}

	public String getFirstCaregiverPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(4);
		String firstCaregiverPassword = cell.getStringCellValue();
		return firstCaregiverPassword.trim();
	}

	public String getSecondCaregiverName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(0);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}

	public String getSecondCaregiverUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(3);
		String secondCaregiverUsername = cell.getStringCellValue();
		return secondCaregiverUsername.trim();
	}

	public String getSecondCaregiverPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(4);
		String secondCaregiverPassword = cell.getStringCellValue();
		return secondCaregiverPassword.trim();
	}

	public String getThirdCaregiverName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(0);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}

	public String getThirdCaregiverUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(3);
		String thirdCaregiverUsername = cell.getStringCellValue();
		return thirdCaregiverUsername.trim();
	}

	public String getThirdCaregiverPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(4);
		String thirdCaregiverPassword = cell.getStringCellValue();
		return thirdCaregiverPassword.trim();
	}
	
	public String getSubscribeProgramName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(18);
		XSSFCell cell = row.getCell(1);
		String programName = cell.getStringCellValue();
		return programName.trim();
	}
	
	public String getFourthCaregiverUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(3);
		String firstCaregiverUsername = cell.getStringCellValue();
		return firstCaregiverUsername.trim();
	}
	
	public String getFourthCaregiverPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(4);
		String firstCaregiverPassword = cell.getStringCellValue();
		return firstCaregiverPassword.trim();
	}
	
	public String getFourthCaregiverName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFifthCaregiverUsername() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(3);
		String firstCaregiverUsername = cell.getStringCellValue();
		return firstCaregiverUsername.trim();
	}
	
	public String getFifthCaregiverPassword() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(4);
		String firstCaregiverPassword = cell.getStringCellValue();
		return firstCaregiverPassword.trim();
	}
	
	public String getFifthCaregiverName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Caregivers");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFirstEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSecondEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(0);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}
	
	public String getThirdEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(0);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}
	
	public String getFourthEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFifthEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSixthEducationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Educations");
		XSSFRow row = sheet.getRow(30);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFirstMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSecondMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(0);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}
	
	public String getThirdMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(0);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}
	
	public String getFourthMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFifthMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSixthMedicationName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Medications");
		XSSFRow row = sheet.getRow(30);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFirstTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(1);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSecondTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(1);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}
	
	public String getThirdTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(1);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}
	
	public String getFourthTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(1);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFifthTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(1);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSixthTaskItemName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Tasks");
		XSSFRow row = sheet.getRow(30);
		XSSFCell cell = row.getCell(1);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFirstTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSecondTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(0);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}
	
	public String getThirdTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(0);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}
	
	public String getFourthTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(28);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFifthTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(29);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSixthTrackerName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Trackers");
		XSSFRow row = sheet.getRow(30);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getFirstReadingName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Readings");
		XSSFRow row = sheet.getRow(11);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public String getSecondReadingName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Readings");
		XSSFRow row = sheet.getRow(12);
		XSSFCell cell = row.getCell(0);
		String secondCaregiverName = cell.getStringCellValue();
		return secondCaregiverName.trim();
	}
	
	public String getThirdReadingName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Readings");
		XSSFRow row = sheet.getRow(13);
		XSSFCell cell = row.getCell(0);
		String thirdCaregiverName = cell.getStringCellValue();
		return thirdCaregiverName.trim();
	}
	
	public String getFourthReadingName() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Readings");
		XSSFRow row = sheet.getRow(14);
		XSSFCell cell = row.getCell(0);
		String firstCaregiverName = cell.getStringCellValue();
		return firstCaregiverName.trim();
	}
	
	public void writeEmailId(String programs,String email) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(programs);
		XSSFRow row = null;
		XSSFCell cell = null;
			try {	
				row=sheet.createRow(33);
				cell=row.createCell(1);
				cell.setCellValue(email);
				System.out.println("Email ID : " + email);
			}catch(Exception e){
				System.out.println("Email ID not set : " +email);
			}
			Thread.sleep(1000);
		
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")
				+ "/src/test/resources/data-driven/ReadExcelDataForProgramScenario.xlsx");
		wb.write(fos);
		fos.close();
	}

}
