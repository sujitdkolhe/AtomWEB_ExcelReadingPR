package com.atom.healthcare.ProgramRegressionDay_2_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Medications;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Patients.Programs;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.RegisterPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.ReadExcel;

public class MedicationScenarios_Day_2_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForMedication_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p17.fname") + " "
				+ AtomHC.propData.getProperty("patient.p17.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p17.fname") + " "
				+ AtomHC.propData.getProperty("patient.p17.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M1 Should be Visible: " + readExcel.getFirstMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFirstMedicationName()),
				readExcel.getFirstMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFirstMedicationName());

		log("*********** Medication M1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM1 = BasePageObject.getDate_yyyy_mm_dd(twoDayBeforeDate);//From Date:Today days before Date
		log("Expected 'From date' for Medication M1 Should be 2 day's before date: " + expectedFromDateM1);
		String actualFromDateM1 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' for Medication M1: " + actualFromDateM1);
		log("Verify for Medication M1 Expected 'From Date': " + expectedFromDateM1 + "  and actual 'From Date': "
				+ actualFromDateM1 + "  Should be 2 day before date");
		softAssert.assertEquals(actualFromDateM1, expectedFromDateM1);

		log("*********** Medication M1 'End Date' ***********");
		String expectedEndDateM1 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today's date
		log("Expected 'End date' Should be Todays date for Medication M1: " + expectedEndDateM1);
		String actualEndDateM1 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays ' date for Medication M1: " + actualEndDateM1);
		log("Verify for Medication M1 expected 'End Date': " + expectedEndDateM1 + "  and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M2 Should be Visible: " + readExcel.getSecondMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSecondMedicationName()),
				readExcel.getSecondMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSecondMedicationName());

		log("*********** Medication M2 'From Date' ***********");
		String expectedFromDateM2 = BasePageObject.getDate_yyyy_mm_dd(0);//From Date: Today's date
		log("Expected 'From date' Should be 'Todays' date for Medication M2: " + expectedFromDateM2);
		String actualFromDateM2 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays' date for Medication M2: " + actualFromDateM2);
		log("Verify for Medication M2 expected 'From Date': " + expectedFromDateM2 + " and actual 'From Date': "
				+ actualFromDateM2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateM2, expectedFromDateM2);

		log("*********** Medication M2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getDate_yyyy_mm_dd(add3days); //End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays +  3 Days' date for Medication M2: " + expectedEndDateM2);
		String actualEndDateM2 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M2: " + actualEndDateM2);
		log("Verify for Medication M2 expected 'End Date': " + expectedEndDateM2 + " and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M3 Should be Visible: " + readExcel.getThirdMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getThirdMedicationName()),
				readExcel.getThirdMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getThirdMedicationName());

		log("*********** Medication M3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM3 = BasePageObject.getDate_yyyy_mm_dd(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M3: " + expectedFromDateM3);
		String actualFromDateM3 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M3: " + actualFromDateM3);
		log("Verify for Medication M3 expected 'From Date': " + expectedFromDateM3 + " and actual 'From Date': "
				+ actualFromDateM3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateM3, expectedFromDateM3);

		log("*********** Medication M3 'End Date' ***********");
		String expectedEndDateM3 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Medication M3: " + expectedEndDateM3);
		String actualEndDateM3 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Medication M3: " + actualEndDateM3);
		log("Verify for Medication M3 expected 'End Date': " + expectedEndDateM3 + " and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForMedication_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1");
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p18.fname") + " "
				+ AtomHC.propData.getProperty("patient.p18.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p18.fname") + " "
				+ AtomHC.propData.getProperty("patient.p18.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p18.fname") + " "
				+ AtomHC.propData.getProperty("patient.p18.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p18.fname") + " "
				+ AtomHC.propData.getProperty("patient.p18.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForMedication_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p19.fname") + " "
				+ AtomHC.propData.getProperty("patient.p19.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p19.fname") + " "
				+ AtomHC.propData.getProperty("patient.p19.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M1 Should be Visible: " + readExcel.getFirstMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFirstMedicationName()),
				readExcel.getFirstMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFirstMedicationName());

		log("*********** Medication M1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM1 = BasePageObject.getDate_yyyy_mm_dd(twoDayBeforeDate);// From Date:Two day before date
		log("Expected 'From date' for Medication M1 Should be two day before date: " + expectedFromDateM1);
		String actualFromDateM1 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' for Medication M1: " + actualFromDateM1);
		log("Verify for Medication M1 Expected 'From Date': " + expectedFromDateM1 + "  and actual 'From Date': "
				+ actualFromDateM1 + "  Should be two day before date");
		softAssert.assertEquals(actualFromDateM1, expectedFromDateM1);

		log("*********** Medication M1 'End Date' ***********");
		String expectedEndDateM1 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Todays date
		log("Expected 'End date' Should be Todays date for Medication M1: " + expectedEndDateM1);
		String actualEndDateM1 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays' date for Medication M1: " + actualEndDateM1);
		log("Verify for Medication M1 expected 'End Date': " + expectedEndDateM1 + " and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M2 Should be Visible: " + readExcel.getSecondMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSecondMedicationName()),
				readExcel.getSecondMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSecondMedicationName());

		log("*********** Medication M2 'From Date' ***********");
		String expectedFromDateM2 = BasePageObject.getDate_yyyy_mm_dd(0);// From Date: Todays date
		log("Expected 'From date' Should be 'Todays ' date for Medication M2: " + expectedFromDateM2);
		String actualFromDateM2 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays ' date for Medication M2: " + actualFromDateM2);
		log("Verify for Medication M2 expected 'From Date': " + expectedFromDateM2 + " and actual 'From Date': "
				+ actualFromDateM2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateM2, expectedFromDateM2);

		log("*********** Medication M2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Medication M2: " + expectedEndDateM2);
		String actualEndDateM2 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Medication M2: " + actualEndDateM2);
		log("Verify for Medication M2 expected 'End Date': " + expectedEndDateM2 + " and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M3 Should be Visible: " + readExcel.getThirdMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getThirdMedicationName()),
				readExcel.getThirdMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getThirdMedicationName());

		log("*********** Medication M3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM3 = BasePageObject.getDate_yyyy_mm_dd(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M3: " + expectedFromDateM3);
		String actualFromDateM3 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M3: " + actualFromDateM3);
		log("Verify for Medication M3 expected 'From Date': " + expectedFromDateM3 + " and actual 'From Date': "
				+ actualFromDateM3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateM3, expectedFromDateM3);

		log("*********** Medication M3 'End Date' ***********");
		String expectedEndDateM3 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Medication M3: " + expectedEndDateM3);
		String actualEndDateM3 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Medication M3: " + actualEndDateM3);
		log("Verify for Medication M3 expected 'End Date': " + expectedEndDateM3 + " and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForMedication_Day_2() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C2: " + readExcel.getFirstCaregiverName());
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p20.fname") + " "
				+ AtomHC.propData.getProperty("patient.p20.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p20.fname") + " "
				+ AtomHC.propData.getProperty("patient.p20.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p20.fname") + " "
				+ AtomHC.propData.getProperty("patient.p20.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p20.fname") + " "
				+ AtomHC.propData.getProperty("patient.p20.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForMedication_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p21.fname") + " "
				+ AtomHC.propData.getProperty("patient.p21.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p21.fname") + " "
				+ AtomHC.propData.getProperty("patient.p21.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M1 Should be Visible: " + readExcel.getFirstMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFirstMedicationName()),
				readExcel.getFirstMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFirstMedicationName());

		log("*********** Medication M1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM1 = BasePageObject.getDate_yyyy_mm_dd(twoDayBeforeDate);
		log("Expected 'From date' for Medication M1 Should be two days before date: " + expectedFromDateM1);
		String actualFromDateM1 = patientMedication.getMedicationFromDate();// From Date:two days before date
		log("Actual 'From Date' for Medication M1: " + actualFromDateM1);
		log("Verify for Medication M1 Expected 'From Date': " + expectedFromDateM1 + "  and actual 'From Date': "
				+ actualFromDateM1 + "  Should be two days before date");
		softAssert.assertEquals(actualFromDateM1, expectedFromDateM1);

		log("*********** Medication M1 'End Date' ***********");
		String expectedEndDateM1 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Medication M1: " + expectedEndDateM1);
		String actualEndDateM1 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays' date for Medication M1: " + actualEndDateM1);
		log("Verify for Medication M1 expected 'End Date': " + expectedEndDateM1 + " and actual 'End Date': "
				+ actualEndDateM1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM1, expectedEndDateM1);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M2 Should be Visible: " + readExcel.getSecondMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSecondMedicationName()),
				readExcel.getSecondMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSecondMedicationName());

		log("*********** Medication M2 'From Date' ***********");
		String expectedFromDateM2 = BasePageObject.getDate_yyyy_mm_dd(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Medication M2: " + expectedFromDateM2);
		String actualFromDateM2 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays date for Medication M2: " + actualFromDateM2);
		log("Verify for Medication M2 expected 'From Date': " + expectedFromDateM2 + " and actual 'From Date': "
				+ actualFromDateM2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateM2, expectedFromDateM2);

		log("*********** Medication M2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM2 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Todays + 3 days
		log("Expected 'End date' Should be 'Todays +  3 Days' date for Medication M2: " + expectedEndDateM2);
		String actualEndDateM2 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M2: " + actualEndDateM2);
		log("Verify for Medication M2 expected 'End Date': " + expectedEndDateM2 + " and actual 'End Date': "
				+ actualEndDateM2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM2, expectedEndDateM2);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M3 Should be Visible: " + readExcel.getThirdMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getThirdMedicationName()),
				readExcel.getThirdMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getThirdMedicationName());

		log("*********** Medication M3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM3 = BasePageObject.getDate_yyyy_mm_dd(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M3: " + expectedFromDateM3);
		String actualFromDateM3 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M3: " + actualFromDateM3);
		log("Verify for Medication M3 expected 'From Date': " + expectedFromDateM3 + " and actual 'From Date': "
				+ actualFromDateM3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateM3, expectedFromDateM3);

		log("*********** Medication M3 'From Date' ***********");
		String expectedEndDateM3 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Medication M3: " + expectedEndDateM3);
		String actualEndDateM3 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Medication M3: " + actualEndDateM3);
		log("Verify for Medication M3 expected 'End Date': " + expectedEndDateM3 + " and actual 'End Date': "
				+ actualEndDateM3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateM3, expectedEndDateM3);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForMedication_Day_2() throws Exception {
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p22.fname") + " "
				+ AtomHC.propData.getProperty("patient.p22.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p22.fname") + " "
				+ AtomHC.propData.getProperty("patient.p22.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver M2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p22.fname") + " "
				+ AtomHC.propData.getProperty("patient.p22.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p22.fname") + " "
				+ AtomHC.propData.getProperty("patient.p22.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForMedication_Day_2()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to four caregiver C4: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p23.fname") + " "
				+ AtomHC.propData.getProperty("patient.p23.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p23.fname") + " "
				+ AtomHC.propData.getProperty("patient.p23.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M4 Should be Visible: " + readExcel.getFourthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFourthMedicationName()),
				readExcel.getFourthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFourthMedicationName());

		log("*********** Medication M4 'From Date' ***********");
		long twodaysBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM4 = BasePageObject.getDate_yyyy_mm_dd(twodaysBeforeDate);// From Date: two days Before date
		log("Expected 'From date' for Medication M4 Should be two day before date: " + expectedFromDateM4);
		String actualFromDateM4 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' for Medication M4: " + actualFromDateM4);
		log("Verify for Medication M4 Expected 'From Date': " + expectedFromDateM4 + "  and actual 'From Date': "
				+ actualFromDateM4 + "  Should be before two day date");
		softAssert.assertEquals(actualFromDateM4, expectedFromDateM4);

		log("*********** Medication M4 'End Date' ***********");
		String expectedEndDateM4 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays date for Medication M4: " + expectedEndDateM4);
		String actualEndDateM4 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays' date for Medication M4: " + actualEndDateM4);
		log("Verify for Medication M4 expected 'End Date': " + expectedEndDateM4 + " and actual 'End Date': "
				+ actualEndDateM4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM4, expectedEndDateM4);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M5 Should be Visible: " + readExcel.getFifthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFifthMedicationName()),
				readExcel.getFifthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFifthMedicationName());

		log("*********** Medication M5 'From Date' ***********");
		String expectedFromDateM5 = BasePageObject.getDate_yyyy_mm_dd(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Medication M5: " + expectedFromDateM5);
		String actualFromDateM5 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays' date for Medication M5: " + actualFromDateM5);
		log("Verify for Medication M5 expected 'From Date': " + expectedFromDateM5 + " and actual 'From Date': "
				+ actualFromDateM5 + "  Should be 'Todays ' date");
		softAssert.assertEquals(actualFromDateM5, expectedFromDateM5);

		log("*********** Medication M5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM5 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Medication M5: " + expectedEndDateM5);
		String actualEndDateM5 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays +  3 Days' date for Medication M5: " + actualEndDateM5);
		log("Verify for Medication M5 expected 'End Date': " + expectedEndDateM5 + " and actual 'End Date': "
				+ actualEndDateM5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM5, expectedEndDateM5);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M6 Should be Visible: " + readExcel.getSixthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSixthMedicationName()),
				readExcel.getSixthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSixthMedicationName());

		log("*********** Medication M6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM6 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M6: " + expectedFromDateM6);
		String actualFromDateM6 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M6: " + actualFromDateM6);
		log("Verify for Medication M6 expected 'From Date': " + expectedFromDateM6 + " and actual 'From Date': "
				+ actualFromDateM6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateM6, expectedFromDateM6);

		log("*********** Medication M6 'End Date' ***********");
		String expectedEndDateM6 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Medication M6: " + expectedEndDateM6);
		String actualEndDateM6 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M6: " + actualEndDateM6);
		log("Verify for Medication M6 expected 'End Date': " + expectedEndDateM6 + " and actual 'End Date': "
				+ actualEndDateM6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM6, expectedEndDateM6);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForMedication_Day_2()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to four caregiver C4: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		readExcel = new ReadExcel();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		Programs patientProgram = new Programs(driver);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p24.fname") + " "
				+ AtomHC.propData.getProperty("patient.p24.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p24.fname") + " "
				+ AtomHC.propData.getProperty("patient.p24.lname"));
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M4 Should be Visible: " + readExcel.getFourthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFourthMedicationName()),
				readExcel.getFourthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFourthMedicationName());

		log("*********** Medication M4 'From Date' ***********");
		long beforetwodayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM4 = BasePageObject.getDate_yyyy_mm_dd(beforetwodayDate);// From Date:Two days before test
		log("Expected 'From date' for Medication M4 Should be before two day date: " + expectedFromDateM4);
		String actualFromDateM4 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' for Medication M4: " + actualFromDateM4);
		log("Verify for Medication M4 Expected 'From Date': " + expectedFromDateM4 + "  and actual 'From Date': "
				+ actualFromDateM4 + "  Should be before two days date");
		softAssert.assertEquals(actualFromDateM4, expectedFromDateM4);

		log("*********** Medication M4 'End Date' ***********");
		String expectedEndDateM4 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Medication M4: " + expectedEndDateM4);
		String actualEndDateM4 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays ' date for Medication M4: " + actualEndDateM4);
		log("Verify for Medication M4 expected 'End Date': " + expectedEndDateM4 + " and actual 'End Date': "
				+ actualEndDateM4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM4, expectedEndDateM4);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M5 Should be Visible: " + readExcel.getFifthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFifthMedicationName()),
				readExcel.getFifthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFifthMedicationName());
		
		log("*********** Medication M5 'From Date' ***********");
		String expectedFromDateM5 = BasePageObject.getDate_yyyy_mm_dd(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays ' date for Medication M5: " + expectedFromDateM5);
		String actualFromDateM5 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays ' date for Medication M5: " + actualFromDateM5);
		log("Verify for Medication M5 expected 'From Date': " + expectedFromDateM5 + " and actual 'From Date': "
				+ actualFromDateM5 + "  Should be 'Todays ' date");
		softAssert.assertEquals(actualFromDateM5, expectedFromDateM5);

		log("*********** Medication M5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM5 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Medication M5: " + expectedEndDateM5);
		String actualEndDateM5 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays +  3 Days' date for Medication M5: " + actualEndDateM5);
		log("Verify for Medication M5 expected 'End Date': " + expectedEndDateM5 + " and actual 'End Date': "
				+ actualEndDateM5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM5, expectedEndDateM5);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M6 Should be Visible: " + readExcel.getSixthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSixthMedicationName()),
				readExcel.getSixthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSixthMedicationName());

		log("*********** Medication M6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM6 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M6: " + expectedFromDateM6);
		String actualFromDateM6 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M6: " + actualFromDateM6);
		log("Verify for Medication M6 expected 'From Date': " + expectedFromDateM6 + " and actual 'From Date': "
				+ actualFromDateM6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateM6, expectedFromDateM6);

		log("*********** Medication M6 'End Date' ***********");
		String expectedEndDateM6 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Medication M6: " + expectedEndDateM6);
		String actualEndDateM6 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M6: " + actualEndDateM6);
		log("Verify for Medication M6 expected 'End Date': " + expectedEndDateM6 + " and actual 'End Date': "
				+ actualEndDateM6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM6, expectedEndDateM6);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForMedication_Day_2()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to four caregiver C4: " + readExcel.getFourthCaregiverName());
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p25.fname") + " "
				+ AtomHC.propData.getProperty("patient.p25.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p25.fname") + " "
				+ AtomHC.propData.getProperty("patient.p25.lname"));
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Medication tab");
		Medications patientMedication = new Medications(driver);
		patientMedication.clickOnPatientMedicationTab();

		log("Verify Medication M4 Should be Visible: " + readExcel.getFourthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFourthMedicationName()),
				readExcel.getFourthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getFourthMedicationName());

		log("*********** Medication M4 'From Date' ***********");
		long beforeTwodayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateM4 = BasePageObject.getDate_yyyy_mm_dd(beforeTwodayDate);// From Date:Two days before date
		log("Expected 'From date' for Medication M4 Should be before two day date: " + expectedFromDateM4);
		String actualFromDateM4 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' for Medication M4: " + actualFromDateM4);
		log("Verify for Medication M4 Expected 'From Date': " + expectedFromDateM4 + "  and actual 'From Date': "
				+ actualFromDateM4 + "  Should be before two day date");
		softAssert.assertEquals(actualFromDateM4, expectedFromDateM4);

		log("*********** Medication M4 'End Date' ***********");
		String expectedEndDateM4 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today date
		log("Expected 'End date' Should be Todays date for Medication M4: " + expectedEndDateM4);
		String actualEndDateM4 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays' date for Medication M4: " + actualEndDateM4);
		log("Verify for Medication M4 expected 'End Date': " + expectedEndDateM4 + " and actual 'End Date': "
				+ actualEndDateM4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateM4, expectedEndDateM4);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M5 Should be Visible: " + readExcel.getFifthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getFifthMedicationName()),
				readExcel.getFifthMedicationName());

		log("*********** Medication M5 'From Date' ***********");
		patientMedication.clickOnMedicationName(readExcel.getFifthMedicationName());
		String expectedFromDateM5 = BasePageObject.getDate_yyyy_mm_dd(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Medication M5: " + expectedFromDateM5);
		String actualFromDateM5 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays' date for Medication M5: " + actualFromDateM5);
		log("Verify for Medication M5 expected 'From Date': " + expectedFromDateM5 + " and actual 'From Date': "
				+ actualFromDateM5 + "  Should be 'Today' date");
		softAssert.assertEquals(actualFromDateM5, expectedFromDateM5);

		log("*********** Medication M5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateM5 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Medication M5: " + expectedEndDateM5);
		String actualEndDateM5 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M5: " + actualEndDateM5);
		log("Verify for Medication M5 expected 'End Date': " + expectedEndDateM5 + " and actual 'End Date': "
				+ actualEndDateM5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM5, expectedEndDateM5);
		patientMedication.clickOnMedicationCrossIcon();

		log("Verify Medication M6 Should be Visible: " + readExcel.getSixthMedicationName());
		softAssert.assertEquals(patientMedication.getMedicationName(readExcel.getSixthMedicationName()),
				readExcel.getSixthMedicationName());
		patientMedication.clickOnMedicationName(readExcel.getSixthMedicationName());

		log("*********** Medication M6 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateM6 = BasePageObject.getDate_yyyy_mm_dd(add2days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Medication M6: " + expectedFromDateM6);
		String actualFromDateM6 = patientMedication.getMedicationFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Medication M6: " + actualFromDateM6);
		log("Verify for Medication M6 expected 'From Date': " + expectedFromDateM6 + " and actual 'From Date': "
				+ actualFromDateM6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateM6, expectedFromDateM6);

		log("*********** Medication M6 'End Date' ***********");
		String expectedEndDateM6 = BasePageObject.getDate_yyyy_mm_dd(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays  + 3 Days' date for Medication M6: " + expectedEndDateM6);
		String actualEndDateM6 = patientMedication.getMedicationEndDate();
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Medication M6: " + actualEndDateM6);
		log("Verify for Medication M6 expected 'End Date': " + expectedEndDateM6 + " and actual 'End Date': "
				+ actualEndDateM6 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateM6, expectedEndDateM6);
		patientMedication.clickOnMedicationCrossIcon();
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

}
