package com.atom.healthcare.ProgramRegressionDay_2_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Patients.Programs;
import com.atom.healthcare.Patients.Tasks;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.RegisterPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.ReadExcel;

public class TaskScenario_Day_2_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		
		log("Select patient: " + AtomHC.propData.getProperty("patient.p26.fname") + " "
				+ AtomHC.propData.getProperty("patient.p26.lname"));
		patient.clickOnPatient(
				AtomHC.propData.getProperty("patient.p26.fname") + " " + AtomHC.propData.getProperty("patient.p26.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();
		log("Verify Task T1 Should be Visible: " + readExcel.getFirstTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFirstTaskItemName()),
				readExcel.getFirstTaskItemName());
		
		log("*********** Task T1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);// From Date:Two days before Date
		log("Expected 'From date' for Task T1 Should be 2 day before date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + expectedFromDateT1
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be 2 day before date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);
		
		log("*********** Task T1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateM1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Todays date
		log("Expected 'End date' Should be Todays date for Task T1: " + expectedEndDateM1);
		String actualEndDateM1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Actual 'End Date' should be 'Todays' date for Task T1: " + actualEndDateM1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateM1 + "and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getFirstTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		
		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);
		
		log("*********** Task T2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays +  3 Days' date for Task T2: " + expectedEndDateM2);
		String actualEndDateM2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Task T2: " + actualEndDateM2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateM2 + "and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);
		
		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateM3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Task T3: " + expectedEndDateM3);
		String actualEndDateM3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Task T3: " + actualEndDateM3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateM3 + "and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		
		log("Verify patient " + AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		 appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll(); 
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p28.fname") + " "
				+ AtomHC.propData.getProperty("patient.p28.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p28.fname") + " "
				+ AtomHC.propData.getProperty("patient.p28.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T1 Should be Visible: " + readExcel.getFirstTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFirstTaskItemName()),
				readExcel.getFirstTaskItemName());
		
		log("*********** Task T1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);// From Date:Two days before Date
		log("Expected 'From date' for Task T1 Should be two day before date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be two day before date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);

		log("*********** Task T1 'End Date' ***********");
		String expectedEndDateM1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today date
		String actualEndDateM1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Expected 'End date' Should be Todays date for Task T1: " + expectedEndDateM1);
		log("Actual 'End Date' should be 'Todays' date for Task T1: " + actualEndDateM1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateM1 + "and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		
		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(0);// From Date: Todays date
		log("Expected 'From date' Should be 'Todays ' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays ' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays ' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today  + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Task T2: " + expectedEndDateM2);
		String actualEndDateM2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays  + 3 Days' date for Task T2: " + actualEndDateM2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateM2 + "and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);

		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());

		log("*********** Task T3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(add1days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateM3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Task T3: " + expectedEndDateM3);
		String actualEndDateM3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Task T3: " + actualEndDateM3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateM3 + "and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		readExcel = new ReadExcel();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		
		log("Verify patient " + AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		 appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p30.fname") + " "
				+ AtomHC.propData.getProperty("patient.p30.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p30.fname") + " "
				+ AtomHC.propData.getProperty("patient.p30.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T1 Should be Visible: " + readExcel.getFirstTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFirstTaskItemName()),
				readExcel.getFirstTaskItemName());
		
		log("*********** Task T1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);// From Date:two days before test
		log("Expected 'From date' for Task T1 Should be Todays date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + expectedFromDateT1
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);

		log("*********** Task T1 'End Date' ***********");
		String expectedEndDateM1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Task T1: " + expectedEndDateM1);
		String actualEndDateM1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Actual 'End Date' should be 'Todays ' date for Task T1: " + actualEndDateM1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateM1 + "and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		
		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays +  3 Days' date for Task T2: " + expectedEndDateM2);
		String actualEndDateM2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Task T2: " + actualEndDateM2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateM2 + "and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		long oneDaysBeforeDate = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(oneDaysBeforeDate); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'From Date' ***********");
		String expectedEndDateM3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Task T3: " + expectedEndDateM3);
		String actualEndDateM3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Task T3: " + actualEndDateM3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateM3 + "and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();
		log("************************************************** Caregiver M2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		 appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C1: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p32.fname") + " "
				+ AtomHC.propData.getProperty("patient.p32.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p32.fname") + " "
				+ AtomHC.propData.getProperty("patient.p32.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()), readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T4 Should be Visible: " + readExcel.getFourthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFourthTaskItemName()),
				readExcel.getFourthTaskItemName());
		
		log("*********** Task T4 'From Date' ***********");
		long beforetwodayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforetwodayDate);// From Date: Two days before Date
		log("Expected 'From date' for Task T4 Should be before two day date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be before two day date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		String expectedEndDateC4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Task T4: " + expectedEndDateC4);
		String actualEndDateT4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Actual 'End Date' should be 'Todays ' date for Task T4: " + actualEndDateT4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateC4 + "and actual 'End Date': "
				+ actualEndDateT4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateT4, expectedEndDateC4);
		
		log("*********** Task T5 'From Date' ***********");
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());
		
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays ' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays ' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Todays ' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateC5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Task T5: " + expectedEndDateC5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays +  3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateC5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateC5);
		
		log("*********** Task T6 'From Date' ***********");
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateC6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays +  3 Days' date for Task T6: " + expectedEndDateC6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays  + 3 Days' date for Task T6: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateC6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateC6);
		log("Logout from Fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C1: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		Programs patientProgram = new Programs(driver);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p33.fname") + " "
				+ AtomHC.propData.getProperty("patient.p33.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p33.fname") + " "
				+ AtomHC.propData.getProperty("patient.p33.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()), readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T4 Should be Visible: " + readExcel.getFourthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFourthTaskItemName()),
				readExcel.getFourthTaskItemName());
		
		log("*********** Task T4 'From Date' ***********");
		long beforetwodayDate = -24 * 60 * 60 * 1000 * 2 ;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforetwodayDate);// From Date:Two days before Date
		log("Expected 'From date' for Task T4 Should be before two day date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be before two day date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		String expectedEndDateC4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		String actualEndDateT4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Expected 'End date' Should be Todays date for Task T4: " + expectedEndDateC4);
		log("Actual 'End Date' should be 'Todays ' date for Task T4: " + actualEndDateT4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateC4 + "and actual 'End Date': "
				+ actualEndDateT4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateT4, expectedEndDateC4);
		
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());
		
		log("*********** Task T5 'From Date' ***********");
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today + Date
		log("Expected 'From date' Should be 'Todays ' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays ' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Todays ' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateC5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Task T5: " + expectedEndDateC5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays +  3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateC5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateC5);
		
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		log("*********** Task T6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateC6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Task T6: " + expectedEndDateC6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Task T6: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateC6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateC6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTask_Day_2() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C1: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		Programs patientProgram = new Programs(driver);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p34.fname") + " "
				+ AtomHC.propData.getProperty("patient.p34.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p34.fname") + " "
				+ AtomHC.propData.getProperty("patient.p34.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()), readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver);  
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T4 Should be Visible: " + readExcel.getFourthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFourthTaskItemName()),
				readExcel.getFourthTaskItemName());
		
		log("*********** Task T4 'From Date' ***********");
		long beforeTwodayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforeTwodayDate);// From Date:Before two days date
		log("Expected 'From date' for Task T4 Should be before two day date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be before two day date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		String expectedEndDateC4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Task T4: " + expectedEndDateC4);
		String actualEndDateT4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Actual 'End Date' should be 'Todays' date for Task T4: " + actualEndDateT4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateC4 + "and actual 'End Date': "
				+ actualEndDateT4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateT4, expectedEndDateC4);
		
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());
		
		log("*********** Task T5 'From Date' ***********");
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Today' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateC5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Task T5: " + expectedEndDateC5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateC5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateC5);
		
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		log("*********** Task T6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateC6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today days + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Task T6: " + expectedEndDateC6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Task T6: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateC6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateC6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}


}
