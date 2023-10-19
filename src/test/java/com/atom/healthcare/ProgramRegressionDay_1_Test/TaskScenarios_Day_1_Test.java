package com.atom.healthcare.ProgramRegressionDay_1_Test;

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

public class TaskScenarios_Day_1_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTask_Day_1() throws Exception {
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
		long oneDayBeforeDate = -24 * 60 * 60 * 1000;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);//From Date:one day before test
		log("Expected 'From date' for Task T1 Should be Todays date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + expectedFromDateT1
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);
		
		log("*********** Task T1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT1 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today date
		String actualEndDateT1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Expected 'End date' Should be Todays + 1 days date for Task T1: " + expectedEndDateT1);
		log("Actual 'End Date' should be 'Todays + 1 days' date for Task T1: " + actualEndDateT1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateT1 + "and actual 'End Date': "
				+ actualEndDateT1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateT1, expectedEndDateT1);
		
		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);
		
		log("*********** Task T2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(add2days); // From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);
		
		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 2 days + 2 Days' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 2 days + 2 Days' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Todays + 2 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForTask_Day_1() throws Exception {
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
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p27.fname") + " "
				+ AtomHC.propData.getProperty("patient.p27.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver); 
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T1 " + readExcel.getFirstTaskItemName()
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTask.isTaskDisplay(readExcel.getFirstTaskItemName()),
				readExcel.getFirstTaskItemName());

		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
	
		log("*********** Task T2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT2 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date: one days before date 
		log("Expected 'From date' for Task T2 Should be one day before date: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 Expected 'From Date': " + expectedFromDateT2
				+ " and Actual 'From Date': " + actualFromDateT2 + "  Should be one days before date");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Today's' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Today's' date");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); // From Date: one days before date
		log("Expected 'From date' Should be 'one day before' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'one day before' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(0); // End Date: Todays date 
		log("Expected 'End date' Should be 'Today's' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Today's' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Today's' date ");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll(); 
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTask_Day_1() throws Exception {
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
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date: One day before date
		log("Expected 'From date' for Task T1 Should be One day before date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + expectedFromDateT1
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be One day before date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);

		log("*********** Task T1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT1 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 2 days date for Task T1: " + expectedEndDateT1);
		String actualEndDateT1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for Task T1: " + actualEndDateT1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateT1 + "and actual 'End Date': "
				+ actualEndDateT1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateT1, expectedEndDateT1);

		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(add2days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 2 days + 2 Days' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 2 days + 2 Days' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Todays + 2 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForTask_Day_1() throws Exception {
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
		
		log("Verify patient " + AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p29.fname") + " "
				+ AtomHC.propData.getProperty("patient.p29.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver); 
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T1 " + readExcel.getFirstTaskItemName()
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTask.isTaskDisplay(readExcel.getFirstTaskItemName()),
				readExcel.getFirstTaskItemName());

		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());

		log("*********** Task T2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT2 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date:one day before date
		log("Expected 'From date' for Task T2 Should be one day before date: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 Expected 'From Date': " + expectedFromDateT2
				+ " and Actual 'From Date': " + actualFromDateT2 + "  Should be one day before date in red color");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);
		
		log("*********** Task T2 'End Date' ***********");
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today date
		log("Expected 'End date' Should be Today's  date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Today's' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Today's' date");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);

		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());
		
		log("*********** Task T3 'From Date' ***********");
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); //From Date:one day before date
		log("Expected 'From date' Should be 'one day before' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'one day before' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(0); // End Date: Today date
		log("Expected 'End date' Should be 'Today' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Today' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Today' date ");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from second caregiver C2");
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTask_Day_1() throws Exception {
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
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT1 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date:one day before test
		log("Expected 'From date' for Task T1 Should be Todays date: " + expectedFromDateT1);
		String actualFromDateT1 = patientTask.getTaskFromDate(readExcel.getFirstTaskItemName());
		log("Actual 'From Date' for Task T1: " + actualFromDateT1);
		log("Verify for Task T1 Expected 'From Date': " + expectedFromDateT1
				+ " and Actual 'From Date': " + actualFromDateT1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateT1, expectedFromDateT1);

		log("*********** Task T1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT1 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Task T1: " + expectedEndDateT1);
		String actualEndDateT1 = patientTask.getTaskEndDate(readExcel.getFirstTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days' date for Task T1: " + actualEndDateT1);
		log("Verify for Task T1 expected 'End Date': " + expectedEndDateT1 + "and actual 'End Date': "
				+ actualEndDateT1 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateT1, expectedEndDateT1);
		
		log("Verify Task T2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());
		
		log("*********** Task T2 'From Date' ***********");
		String expectedFromDateT2 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T2: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 expected 'From Date': " + expectedFromDateT2 + "and actual 'From Date': "
				+ actualFromDateT2 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);
		
		log("Verify Task T3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());

		log("*********** Task T3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(add2days); // From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'From Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForTask_Day_1() throws Exception {
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

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p31.fname") + " "
				+ AtomHC.propData.getProperty("patient.p31.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Tasks patientTask= new Tasks(driver); 
		patientTask.clickOnPatientTaskTab();

		log("Verify Task T1 " + readExcel.getFirstTaskItemName()
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTask.isTaskDisplay(readExcel.getFirstTaskItemName()),
				readExcel.getSecondTaskItemName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSecondTaskItemName()),
				readExcel.getSecondTaskItemName());

		log("*********** Task T2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT2 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date: one day before date
		log("Expected 'From date' for Task T2 Should be one day before date: " + expectedFromDateT2);
		String actualFromDateT2 = patientTask.getTaskFromDate(readExcel.getSecondTaskItemName());
		log("Actual 'From Date' for Task T2: " + actualFromDateT2);
		log("Verify for Task T2 Expected 'From Date': " + expectedFromDateT2
				+ " and Actual 'From Date': " + actualFromDateT2 + "  Should be one day before date in Red color");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT2, expectedFromDateT2);

		log("*********** Task T2 'End Date' ***********");
		String expectedEndDateT2 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Task T2: " + expectedEndDateT2);
		String actualEndDateT2 = patientTask.getTaskEndDate(readExcel.getSecondTaskItemName());
		log("Actual 'End Date' should be 'Today's' date for Task T2: " + actualEndDateT2);
		log("Verify for Task T2 expected 'End Date': " + expectedEndDateT2 + "and actual 'End Date': "
				+ actualEndDateT2 + "  Should be 'Today's' date");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getSecondTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT2, expectedEndDateT2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getThirdTaskItemName()),
				readExcel.getThirdTaskItemName());

		log("*********** Task T3 'From Date' ***********");
		String expectedFromDateT3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); // From Date: one day before date
		log("Expected 'From date' Should be 'one day before' date for Task T3: " + expectedFromDateT3);
		String actualFromDateT3 = patientTask.getTaskFromDate(readExcel.getThirdTaskItemName());
		log("Actual 'From Date' should be 'one day before' date for Task T3: " + actualFromDateT3);
		log("Verify for Task T3 expected 'From Date': " + expectedFromDateT3 + "and actual 'From Date': "
				+ actualFromDateT3 + "  Should be 'one day before' date in Red color");
		softAssert.assertEquals(patientTask.getTaskFromDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualFromDateT3, expectedFromDateT3);

		log("*********** Task T3 'End Date' ***********");
		String expectedEndDateT3 = BasePageObject.getEpochTimeInDate(0); // End Date: Today's date
		log("Expected 'End date' Should be 'Today's' date for Task T3: " + expectedEndDateT3);
		String actualEndDateT3 = patientTask.getTaskEndDate(readExcel.getThirdTaskItemName());
		log("Actual 'End Date' should be 'Today's' date for Task T3: " + actualEndDateT3);
		log("Verify for Task T3 expected 'End Date': " + expectedEndDateT3 + "and actual 'End Date': "
				+ actualEndDateT3 + "  Should be 'Today's' date in Red color ");
		softAssert.assertEquals(patientTask.getTaskEndDateColor(readExcel.getThirdTaskItemName()),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(actualEndDateT3, expectedEndDateT3);
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTask_Day_1() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C4: " + readExcel.getFourthCaregiverName());
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
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforeOnedayDate);// From Date: One day before date
		log("Expected 'From date' for Task T4 Should be  One day before date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be before One day date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT4 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Task T4: " + expectedEndDateT4);
		String actualEndDateC4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days' date for Task T4: " + actualEndDateC4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateT4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateT4);
		
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());
		
		log("*********** Task T5 'From Date' ***********");
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT5 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T5: " + expectedEndDateT5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateT5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateT5);
		
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		log("*********** Task T6 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateT6 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T5: " + expectedEndDateT6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getSixthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T5: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateT6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateT6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTask_Day_1() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C4: " + readExcel.getFourthCaregiverName());
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
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforeOnedayDate);// From Date:One day before date
		log("Expected 'From date' for Task T4 Should be before One day date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be  One day before date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT4 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Task T4: " + expectedEndDateT4);
		String actualEndDateC4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days' date for Task T4: " + actualEndDateC4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateT4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateT4);
		
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());

		log("*********** Task T5 'From Date' ***********");
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT5 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T5: " + expectedEndDateT5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateT5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateT5);
		
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		log("*********** Task T6 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add3days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateT6 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T6: " + expectedEndDateT6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getSixthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T6: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateT6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateT6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}
	
	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTask_Day_1() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C4: " + readExcel.getFourthCaregiverName());
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
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateT4 = BasePageObject.getEpochConvertDate(beforeOnedayDate);// From Date:One day before date
		log("Expected 'From date' for Task T4 Should be One day before date: " + expectedFromDateT4);
		String actualFromDateT4 = patientTask.getTaskFromDate(readExcel.getFourthTaskItemName());
		log("Actual 'From Date' for Task T4: " + actualFromDateT4);
		log("Verify for Task T4 Expected 'From Date': " + expectedFromDateT4
				+ " and Actual 'From Date': " + actualFromDateT4 + "  Should be before One day date");
		softAssert.assertEquals(actualFromDateT4, expectedFromDateT4);

		log("*********** Task T4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateT4 = BasePageObject.getEpochTimeInDate(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Task T4: " + expectedEndDateT4);
		String actualEndDateC4 = patientTask.getTaskEndDate(readExcel.getFourthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days' date for Task T4: " + actualEndDateC4);
		log("Verify for Task T4 expected 'End Date': " + expectedEndDateT4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateT4);
		
		log("Verify Task T5 Should be Visible: " + readExcel.getFifthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getFifthTaskItemName()),
				readExcel.getFifthTaskItemName());
		
		log("*********** Task T5 'From Date' ***********");
		String expectedFromDateT5 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Task T5: " + expectedFromDateT5);
		String actualFromDateT5 = patientTask.getTaskFromDate(readExcel.getFifthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Task T5: " + actualFromDateT5);
		log("Verify for Task T5 expected 'From Date': " + expectedFromDateT5 + "and actual 'From Date': "
				+ actualFromDateT5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateT5, expectedFromDateT5);

		log("*********** Task T5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateT5 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T5: " + expectedEndDateT5);
		String actualEndDateT5 = patientTask.getTaskEndDate(readExcel.getFifthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T5: " + actualEndDateT5);
		log("Verify for Task T5 expected 'End Date': " + expectedEndDateT5 + "and actual 'End Date': "
				+ actualEndDateT5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT5, expectedEndDateT5);
		
		log("*********** Task T6 'From Date' ***********");
		log("Verify Task T6 Should be Visible: " + readExcel.getSixthTaskItemName());
		softAssert.assertEquals(patientTask.getTaskName(readExcel.getSixthTaskItemName()),
				readExcel.getSixthTaskItemName());
		
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateT6 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Task T6: " + expectedFromDateT6);
		String actualFromDateT6 = patientTask.getTaskFromDate(readExcel.getSixthTaskItemName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Task T6: " + actualFromDateT6);
		log("Verify for Task T6 expected 'From Date': " + expectedFromDateT6 + "and actual 'From Date': "
				+ actualFromDateT6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateT6, expectedFromDateT6);

		log("*********** Task T6 'End Date' ***********");
		String expectedEndDateT6 = BasePageObject.getEpochTimeInDate(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Task T6: " + expectedEndDateT6);
		String actualEndDateT6 = patientTask.getTaskEndDate(readExcel.getSixthTaskItemName());
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Task T6: " + actualEndDateT6);
		log("Verify for Task T6 expected 'End Date': " + expectedEndDateT6 + "and actual 'End Date': "
				+ actualEndDateT6 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateT6, expectedEndDateT6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}



}
