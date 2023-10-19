package com.atom.healthcare.ProgramRegressionDay_1_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Patients.Programs;
import com.atom.healthcare.Patients.Tasks;
import com.atom.healthcare.Patients.Trackers;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.RegisterPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.ReadExcel;

public class TrackerScenarios_Day_1_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to First caregiver C1 : " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Trackers tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 Should be Visible: " + readExcel.getFirstTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFirstTrackerName()),
				readExcel.getFirstTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFirstTrackerName());

		log("*********** Tracker TR1 'From Date' ***********");
		long oneDayBeforeTest = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR1 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeTest);// From Date:One day before
																							// Date
		log("Expected 'From date' for Tracker TR1 Should be One day before date: " + expectedFromDateTR1);
		String actualFromDateTR1 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR1: " + actualFromDateTR1);
		log("Verify for Tracker TR1 Expected 'From Date': " + expectedFromDateTR1 + " and Actual 'From Date': "
				+ actualFromDateTR1 + "  Should be One day before date");
		softAssert.assertEquals(actualFromDateTR1, expectedFromDateTR1);

		log("*********** Tracker TR1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR1 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Tracker TR1: " + expectedEndDateTR1);
		String actualEndDateTR1 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days' date for Tracker TR1: " + actualEndDateTR1);
		log("Verify for Tracker TR1 expected 'End Date': " + expectedEndDateTR1 + "and actual 'End Date': "
				+ actualEndDateTR1 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateTR1, expectedEndDateTR1);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		String expectedFromDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR2: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 expected 'From Date': " + expectedFromDateTR2 + "and actual 'From Date': "
				+ actualFromDateTR2 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add2days); // From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 2 days + 2 Days' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Todays + 2 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p35.fname") + " "
				+ AtomHC.propData.getProperty("patient.p35.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1 : " + readExcel.getFirstCaregiverName());
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + readExcel.getFirstTrackerName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getFirstTrackerName());

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR2 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate);// From Date: one Day Before
																							// Date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + expectedFromDateTR2 + " and Actual 'From Date': "
				+ actualFromDateTR2 + "  Should be one Day Before date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate); // From Date: one Day Before
																							// Date
		log("Expected 'From date' Should be 'one day before' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'one day before' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(0); // End Date: Today date
		log("Expected 'End date' Should be 'Today's' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Today's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Today's' date ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p36.fname") + " "
				+ AtomHC.propData.getProperty("patient.p36.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + readExcel.getFirstTrackerName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getFirstTrackerName());

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");// From Date: one Day Before Date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + expectedFromDateTR2 + " and Actual 'From Date': "
				+ actualFromDateTR2 + "  Should be one Day Before date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********"); // End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********"); // From Date: one Day Before Date
		log("Expected 'From date' Should be 'one day before' date for Tracker TR3: " + expectedFromDateTR3);
		log("Actual 'From Date' should be 'one day before' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********"); // End Date: Today date
		log("Expected 'End date' Should be 'Today's' date for Tracker TR3: " + expectedEndDateTR3);
		log("Actual 'End Date' should be 'Today's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Today's' date ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from Third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1 : " + readExcel.getFirstCaregiverName());
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 Should be Visible: " + readExcel.getFirstTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFirstTrackerName()),
				readExcel.getFirstTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFirstTrackerName());

		log("*********** Tracker TR1 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR1 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate);// From Date:One day before
																							// date
		log("Expected 'From date' for Tracker TR1 Should be One day before date: " + expectedFromDateTR1);
		String actualFromDateTR1 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR1: " + actualFromDateTR1);
		log("Verify for Tracker TR1 Expected 'From Date': " + expectedFromDateTR1 + " and Actual 'From Date': "
				+ actualFromDateTR1 + "  Should be One day before date");
		softAssert.assertEquals(actualFromDateTR1, expectedFromDateTR1);

		log("*********** Tracker TR1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR1 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Tracker TR1: " + expectedEndDateTR1);
		String actualEndDateTR1 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days' date for Tracker TR1: " + actualEndDateTR1);
		log("Verify for Tracker TR1 expected 'End Date': " + expectedEndDateTR1 + "and actual 'End Date': "
				+ actualEndDateTR1 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateTR1, expectedEndDateTR1);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		String expectedFromDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR2: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 expected 'From Date': " + expectedFromDateTR2 + "and actual 'From Date': "
				+ actualFromDateTR2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add2days); // From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 2 days + 2 Days' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 2 days + 2 Days' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Todays + 2 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p37.fname") + " "
				+ AtomHC.propData.getProperty("patient.p37.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1 : " + readExcel.getFirstCaregiverName());
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Tracker tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + readExcel.getFirstTrackerName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getSecondTrackerName());

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR2 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate);// From Date: one day before
																							// date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + expectedFromDateTR2 + " and Actual 'From Date': "
				+ actualFromDateTR2 + "  Should be one day before date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate); // From Date:one day before
																							// date
		log("Expected 'From date' Should be 'Todays' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'Todays' date in Red color");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(0); // End Date:Todays's date
		log("Expected 'End date' Should be 'Tomorrow's' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Tomorrow's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p38.fname") + " "
				+ AtomHC.propData.getProperty("patient.p38.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Tracker tab");
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + readExcel.getFirstTrackerName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getSecondTrackerName());

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");// From Date: one day before date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + expectedFromDateTR2 + " and Actual 'From Date': "
				+ actualFromDateTR2 + "  Should be one day before date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");// End DATE: Today's date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********"); // From Date:one day before date
		log("Expected 'From date' Should be 'Todays' date for Tracker TR3: " + expectedFromDateTR3);
		log("Actual 'From Date' should be 'Todays' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'Todays' date in Red color");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********"); // End Date: Todays's date
		log("Expected 'End date' Should be 'Tomorrow's' date for Tracker TR3: " + expectedEndDateTR3);
		log("Actual 'End Date' should be 'Tomorrow's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from second caregiver C3");
		mainPage.logout();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1 : " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 Should be Visible: " + readExcel.getFirstTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFirstTrackerName()),
				readExcel.getFirstTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFirstTrackerName());

		log("*********** Tracker TR1 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR1 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);// From Date: one day before
																							// test
		log("Expected 'From date' for Tracker TR1 Should be Todays date: " + expectedFromDateTR1);
		String actualFromDateTR1 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR1: " + actualFromDateTR1);
		log("Verify for Tracker TR1 Expected 'From Date': " + expectedFromDateTR1 + " and Actual 'From Date': "
				+ actualFromDateTR1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateTR1, expectedFromDateTR1);

		log("*********** Tracker TR1 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR1 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Tracker TR1: " + expectedEndDateTR1);
		String actualEndDateTR1 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days' date for Tracker TR1: " + actualEndDateTR1);
		log("Verify for Tracker TR1 expected 'End Date': " + expectedEndDateTR1 + "and actual 'End Date': "
				+ actualEndDateTR1 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateTR1, expectedEndDateTR1);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		String expectedFromDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR2: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 expected 'From Date': " + expectedFromDateTR2 + "and actual 'From Date': "
				+ actualFromDateTR2 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add2days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'From Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 2 days + 2 days
		log("Expected 'End date' Should be 'Todays + 2 days + 2 Days' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 2 days + 2 Days' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Todays + 2 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p39.fname") + " "
				+ AtomHC.propData.getProperty("patient.p39.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForTracker_Day_1() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1 : " + readExcel.getFirstCaregiverName());
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName())
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getSecondTrackerName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateTR2 = BasePageObject.getEpochConvertDate(oneDayBeforeDate);/// From Date: one day before
																							/// date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		String actualFromDateTR2 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + expectedFromDateTR2 + " and Actual 'From Date': "
				+ actualFromDateTR2 + "  Should be one day before date ");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********");
		String expectedEndDateTR2 = BasePageObject.getDate_yyyy_mm_dd(0); // End DATE: Todays date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		String actualEndDateTR2 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********");
		String expectedFromDateTR3 = BasePageObject.getDate_yyyy_mm_dd(oneDayBeforeDate); // From Date: one day before
																							// date
		log("Expected 'From date' Should be 'one day before' date for Tracker TR3: " + expectedFromDateTR3);
		String actualFromDateTR3 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'one day before' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********");
		String expectedEndDateTR3 = BasePageObject.getDate_yyyy_mm_dd(0); // End Date: End DATE: Todays date
		log("Expected 'End date' Should be 'Today's' date for Tracker TR3: " + expectedEndDateTR3);
		String actualEndDateTR3 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Today's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Today's' date ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to second caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p40.fname") + " "
				+ AtomHC.propData.getProperty("patient.p40.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Task tab");
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR1 " + patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName())
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientTracker.isTrackerDisplay(readExcel.getFirstTrackerName()),
				readExcel.getSecondTrackerName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSecondTrackerName()),
				readExcel.getSecondTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSecondTrackerName());

		log("*********** Tracker TR2 'From Date' ***********");// From Date: one day before date
		log("Expected 'From date' for Tracker TR2 Should be one day before date: " + expectedFromDateTR2);
		log("Actual 'From Date' for Tracker TR2: " + actualFromDateTR2);
		log("Verify for Tracker TR2 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateTR2 + "  Should be one day before date ");
		softAssert.assertEquals(actualFromDateTR2, expectedFromDateTR2);

		log("*********** Tracker TR2 'End Date' ***********"); // End DATE: Todays date
		log("Expected 'End date' Should be Today's  date for Tracker TR2: " + expectedEndDateTR2);
		log("Actual 'End Date' should be 'Today's' date for Tracker TR2: " + actualEndDateTR2);
		log("Verify for Tracker TR2 expected 'End Date': " + expectedEndDateTR2 + "and actual 'End Date': "
				+ actualEndDateTR2 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateTR2, expectedEndDateTR2);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getThirdTrackerName()),
				readExcel.getThirdTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getThirdTrackerName());

		log("*********** Tracker TR3 'From Date' ***********"); // From Date: one day before date
		log("Expected 'From date' Should be 'one day before' date for Tracker TR3: " + expectedFromDateTR3);
		log("Actual 'From Date' should be 'one day before' date for Tracker TR3: " + actualFromDateTR3);
		log("Verify for Tracker TR3 expected 'From Date': " + expectedFromDateTR3 + "and actual 'From Date': "
				+ actualFromDateTR3 + "  Should be 'one day before' date ");
		softAssert.assertEquals(actualFromDateTR3, expectedFromDateTR3);

		log("*********** Tracker TR3 'End Date' ***********"); // End Date: End DATE: Todays date
		log("Expected 'End date' Should be 'Today's' date for Tracker TR3: " + expectedEndDateTR3);
		log("Actual 'End Date' should be 'Today's' date for Tracker TR3: " + actualEndDateTR3);
		log("Verify for Tracker TR3 expected 'End Date': " + expectedEndDateTR3 + "and actual 'End Date': "
				+ actualEndDateTR3 + "  Should be 'Today's' date in Red color ");
		softAssert.assertEquals(actualEndDateTR3, expectedEndDateTR3);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForTracker_Day_1()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C4 : " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p41.fname") + " "
				+ AtomHC.propData.getProperty("patient.p41.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p41.fname") + " "
				+ AtomHC.propData.getProperty("patient.p41.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR4 Should be Visible: " + readExcel.getFourthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFourthTrackerName()),
				readExcel.getFourthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFourthTrackerName());

		log("*********** Tracker TR4 'From Date' ***********");
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(beforeOnedayDate); // From Date:one day before
																							// date
		log("Expected 'From date' for Medication C4 Should be before One day date: " + expectedFromDateC4);
		String actualFromDateC4 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR4: " + actualFromDateC4);
		log("Verify for Tracker TR4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be before One day date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Tracker TR4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR4 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Tracker TR4: " + expectedEndDateTR4);
		String actualEndDateC4 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days' date for Tracker TR4: " + actualEndDateC4);
		log("Verify for Tracker TR4 expected 'End Date': " + expectedEndDateTR4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateTR4);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR5 Should be Visible: " + readExcel.getFifthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFifthTrackerName()),
				readExcel.getFifthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFifthTrackerName());

		log("*********** Tracker TR5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR5: " + expectedFromDateC5);
		String actualFromDateC5 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR5: " + actualFromDateC5);
		log("Verify for Tracker TR5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Tracker TR5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR5 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + expectedEndDateTR5);
		String actualEndDateTR5 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + actualEndDateTR5);
		log("Verify for Tracker TR5 expected 'End Date': " + expectedEndDateTR5 + "and actual 'End Date': "
				+ actualEndDateTR5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR5, expectedEndDateTR5);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR6 Should be Visible: " + readExcel.getSixthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSixthTrackerName()),
				readExcel.getSixthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSixthTrackerName());

		log("*********** Tracker TR6 'From Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR6: " + expectedFromDateTR6);
		String actualFromDateTR6 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR6: " + actualFromDateTR6);
		log("Verify for Tracker TR6 expected 'From Date': " + expectedFromDateTR6 + "and actual 'From Date': "
				+ actualFromDateTR6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateTR6, expectedFromDateTR6);

		log("*********** Tracker TR6 'End Date' ***********");
		String expectedEndDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + expectedEndDateTR6);
		String actualEndDateTR6 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + actualEndDateTR6);
		log("Verify for Tracker TR6 expected 'End Date': " + expectedEndDateTR6 + "and actual 'End Date': "
				+ actualEndDateTR6 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR6, expectedEndDateTR6);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from fourth caregiver C4");
		mainPage.logout();

		log("************************************************** Caregiver C5 **************************************************");
		log("Login to fifth caregiver C5 : " + readExcel.getFifthCaregiverName());
		appointemetPage.login(readExcel.getFifthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p41.fname") + " "
				+ AtomHC.propData.getProperty("patient.p41.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p41.fname") + " "
				+ AtomHC.propData.getProperty("patient.p41.lname")));
		log("Logout from fifth caregiver C5");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForTracker_Day_1()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		log("Login to first caregiver C4");
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p42.fname") + " "
				+ AtomHC.propData.getProperty("patient.p42.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p42.fname") + " "
				+ AtomHC.propData.getProperty("patient.p42.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR4 Should be Visible: " + readExcel.getFourthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFourthTrackerName()),
				readExcel.getFourthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFourthTrackerName());

		log("*********** Tracker TR4 'From Date' ***********");
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(beforeOnedayDate);// From Date:One day before
																							// date
		log("Expected 'From date' for Medication C4 Should be before One day date: " + expectedFromDateC4);
		String actualFromDateC4 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR4: " + actualFromDateC4);
		log("Verify for Tracker TR4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be before One day date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Tracker TR4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR4 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		log("Expected 'End date' Should be Todays + 1 days date for Medication E4: " + expectedEndDateTR4);
		String actualEndDateC4 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days' date for Medication E4: " + actualEndDateC4);
		log("Verify for Tracker TR4 expected 'End Date': " + expectedEndDateTR4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateTR4);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR5 Should be Visible: " + readExcel.getFifthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFifthTrackerName()),
				readExcel.getFifthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFifthTrackerName());

		log("*********** Tracker TR5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR5: " + expectedFromDateC5);
		String actualFromDateC5 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR5: " + actualFromDateC5);
		log("Verify for Tracker TR5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Tracker TR5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR5 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + expectedEndDateTR5);
		String actualEndDateTR5 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + actualEndDateTR5);
		log("Verify for Tracker TR5 expected 'End Date': " + expectedEndDateTR5 + "and actual 'End Date': "
				+ actualEndDateTR5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR5, expectedEndDateTR5);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR6 Should be Visible: " + readExcel.getSixthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSixthTrackerName()),
				readExcel.getSixthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSixthTrackerName());

		log("*********** Tracker TR6 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add3days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR6: " + expectedFromDateTR6);
		String actualFromDateTR6 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR6: " + actualFromDateTR6);
		log("Verify for Tracker TR6 expected 'From Date': " + expectedFromDateTR6 + "and actual 'From Date': "
				+ actualFromDateTR6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateTR6, expectedFromDateTR6);

		log("*********** Tracker TR6 'End Date' ***********");
		String expectedEndDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR6: " + expectedEndDateTR6);
		String actualEndDateTR6 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR6: " + actualEndDateTR6);
		log("Verify for Tracker TR6 expected 'End Date': " + expectedEndDateTR5 + "and actual 'End Date': "
				+ actualEndDateTR5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR6, expectedEndDateTR6);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from first caregiver C4");
		mainPage.logout();

		log("************************************************** Caregiver C5 **************************************************");
		log("Login to fifth caregiver C5 : " + readExcel.getFifthCaregiverName());
		appointemetPage.login(readExcel.getFifthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p42.fname") + " "
				+ AtomHC.propData.getProperty("patient.p42.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p42.fname") + " "
				+ AtomHC.propData.getProperty("patient.p42.lname")));
		log("Logout from fifth caregiver C5");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForTracker_Day_1()
			throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		log("Login to fourth caregiver C4");
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p43.fname") + " "
				+ AtomHC.propData.getProperty("patient.p43.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p43.fname") + " "
				+ AtomHC.propData.getProperty("patient.p43.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Task tab");
		Trackers patientTracker = new Trackers(driver);
		patientTracker.clickOnPatientTrackerTab();

		log("Verify Tracker TR4 Should be Visible: " + readExcel.getFourthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFourthTrackerName()),
				readExcel.getFourthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFourthTrackerName());

		log("*********** Tracker TR4 'From Date' ***********");
		long beforeOnedayDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(beforeOnedayDate);// From Date:One day before
																							// Date
		log("Expected 'From date' for Medication C4 Should be before One day date: " + expectedFromDateC4);
		String actualFromDateC4 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' for Tracker TR4: " + actualFromDateC4);
		log("Verify for Tracker TR4 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateC4 + "  Should be before One day date");
		softAssert.assertEquals(actualFromDateC4, BasePageObject.getEpochConvertDate(beforeOnedayDate));

		log("*********** Tracker TR4 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateTR4 = BasePageObject.getDate_yyyy_mm_dd(add1days); // End DATE: Today + 1 days
		String actualEndDateC4 = patientTracker.getTrackerEndDate();
		log("Expected 'End date' Should be Todays + 1 days date for Tracker TR4: " + expectedEndDateTR4);
		log("Actual 'End Date' should be 'Todays + 1 days' date for Tracker TR4: " + actualEndDateC4);
		log("Verify for Tracker TR4 expected 'End Date': " + expectedEndDateTR4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateTR4);
		patientTracker.clickOnTrackerCrossIcon();

		log("Verify Tracker TR5 Should be Visible: " + readExcel.getFifthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getFifthTrackerName()),
				readExcel.getFifthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getFifthTrackerName());

		log("*********** Tracker TR5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getDate_yyyy_mm_dd(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Tracker TR5: " + expectedFromDateC5);
		String actualFromDateC5 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 1 days' date for Tracker TR5: " + actualFromDateC5);
		log("Verify for Tracker TR5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Tracker TR5 'End Date' ***********");
		long add4days = 24 * 60 * 60 * 1000 * 4;
		String expectedEndDateTR5 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + expectedEndDateTR5);
		String actualEndDateTR5 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR5: " + actualEndDateTR5);
		log("Verify for Tracker TR5 expected 'End Date': " + expectedEndDateTR5 + "and actual 'End Date': "
				+ actualEndDateTR5 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR5, expectedEndDateTR5);
		patientTracker.clickOnTrackerCrossIcon();

		log("*********** Tracker TR6 'From Date' ***********");
		log("Verify Tracker TR6 Should be Visible: " + readExcel.getSixthTrackerName());
		softAssert.assertEquals(patientTracker.getTrackerName(readExcel.getSixthTrackerName()),
				readExcel.getSixthTrackerName());
		patientTracker.clickOnTrackerName(readExcel.getSixthTrackerName());

		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedFromDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add2days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Tracker TR6: " + expectedFromDateTR6);
		String actualFromDateTR6 = patientTracker.getTrackerFromDate();
		log("Actual 'From Date' should be 'Todays + 2 days' date for Tracker TR6: " + actualFromDateTR6);
		log("Verify for Tracker TR6 expected 'From Date': " + expectedFromDateTR6 + "and actual 'From Date': "
				+ actualFromDateTR6 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateTR6, expectedFromDateTR6);

		log("*********** Tracker TR6 'End Date' ***********");
		String expectedEndDateTR6 = BasePageObject.getDate_yyyy_mm_dd(add4days); // End Date: Today + 1 days + 3 days
		log("Expected 'End date' Should be 'Todays + 1 days + 3 Days' date for Tracker TR6: " + expectedEndDateTR6);
		String actualEndDateTR6 = patientTracker.getTrackerEndDate();
		log("Actual 'End Date' should be 'Todays + 1 days + 3 Days' date for Tracker TR6: " + actualEndDateTR6);
		log("Verify for Tracker TR6 expected 'End Date': " + expectedEndDateTR6 + "and actual 'End Date': "
				+ actualEndDateTR6 + "  Should be 'Todays + 1 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateTR6, expectedEndDateTR6);
		patientTracker.clickOnTrackerCrossIcon();
		log("Logout from fourth caregiver C4");
		mainPage.logout();

		log("************************************************** Caregiver C5 **************************************************");
		log("Login to fifth caregiver C5 : " + readExcel.getFifthCaregiverName());
		appointemetPage.login(readExcel.getFifthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p43.fname") + " "
				+ AtomHC.propData.getProperty("patient.p43.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p43.fname") + " "
				+ AtomHC.propData.getProperty("patient.p43.lname")));
		log("Logout from fifth caregiver C5");
		mainPage.logout();
		softAssert.assertAll();
	}

}
