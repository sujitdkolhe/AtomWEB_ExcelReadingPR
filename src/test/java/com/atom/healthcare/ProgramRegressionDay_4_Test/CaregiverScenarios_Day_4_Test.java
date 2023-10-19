package com.atom.healthcare.ProgramRegressionDay_4_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Caregivers;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Patients.Programs;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.RegisterPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.ReadExcel;

public class CaregiverScenarios_Day_4_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForCaregiver_Day_4() throws Exception {
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		Programs patientProgram = new Programs(driver);
		Caregivers patientCaregiver = new Caregivers(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		long fourDayBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(fourDayBeforeDate);// 4 day before date
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate); // End DATE: 2 day before date
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + " and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate);// From Date: 2 day before date
		log("Expected 'From date' Should be '2 days before' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be '2 days before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + " and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 days before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); // From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + " and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + " and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to Third caregiver C3: " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1); // 4 day before date
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");// End DATE: 2 day before date
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date: 2 day before date
		log("Expected 'From date' Should be '2 day before' date for caregiver C2: " + expectedFromDateC2);
		log("Actual 'From Date' should be '2 day before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 day before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForCaregiver_Day_4() throws Exception {
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForCaregiver_Day_4() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to First caregiver C1: " + readExcel.getFirstCaregiverName());
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to Second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		Programs patientProgram = new Programs(driver);
		Caregivers patientCaregiver = new Caregivers(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		long fourDayBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(fourDayBeforeDate);// 4 day before date
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate); // End DATE: 2 day before date
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + " and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));
		
		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate);// From Date: 2 day before date
		log("Expected 'From date' Should be '2 day before' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be '2 day before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + " and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 day before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); // From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + " and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + " and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to Third caregiver C2: " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1); // 4 day before date
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");// End DATE: 2 day before date
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date: 2 day before date
		log("Expected 'From date' Should be '2 day before' date for caregiver C2: " + expectedFromDateC2);
		log("Actual 'From Date' should be '2 day before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 day before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForCaregiver_Day_4() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		readExcel = new ReadExcel();
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForCaregiver_Day_4() throws Exception {
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
		log("Verify patient " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to Second caregiver C1: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		Programs patientProgram = new Programs(driver);
		Caregivers patientCaregiver = new Caregivers(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		long fourDayBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(fourDayBeforeDate);// 4 day before date
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate); // End DATE: 2 day before date
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + " and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(twoDayBeforeDate);// From Date: 2 day before date
		log("Expected 'From date' Should be '2 day before' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be '2 day before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + " and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 day before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long oneDayBeforeDate = -24 * 60 * 60 * 1000 * 1;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(oneDayBeforeDate); // From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + " and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + " and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		log("Expected 'From date' for caregiver C1 Should be 4 day before date: " + expectedFromDateC1);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1); // 4 day before date
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1 + " and Actual 'From Date': "
				+ actualFromDateC1 + "  Should be 4 day before date in 'Red Color'");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C1 'End Date' ***********");// End DATE: 2 day before date
		log("Expected 'End date' Should be '2 day before' date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be '2 day before ' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be '2 day before' date in 'Red Color'");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFirstCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date: 2 day before date
		log("Expected 'From date' Should be '2 day before' date for caregiver C2: " + expectedFromDateC2);
		log("Actual 'From Date' should be '2 day before' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be '2 day before' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End Date: Todays date + 1 days
		log("Expected 'End date' Should be 'Todays date + 1 Days' date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Todays date + 1 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays date + 1 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: 1 day before date
		log("Expected 'From date' Should be '1 day before' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be '1 day before' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be '1 day before' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C3: " + expectedEndDateC3);
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from Third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForCaregiver_Day_4() throws Exception {
		log("************************************************** Caregiver C1 **************************************************");
		readExcel = new ReadExcel();
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		readExcel = new ReadExcel();
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : " + readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForCaregiver_Day_4() throws Exception {
		log("************************************************** Caregiver C4 **************************************************");
		readExcel = new ReadExcel();
		log("Login to fourth caregiver C4 : " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		
		log("Verify patient " + AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname")));
		log("Logout from fourth caregiver C4");
		mainPage.logout();

		log("************************************************** Caregiver C5 **************************************************");
		log("Login to fifth caregiver C5 : " + readExcel.getFifthCaregiverName());
		appointemetPage.login(readExcel.getFifthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFifthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Select patient: " + AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C4 Should be Visible: " + readExcel.getFourthCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFourthCaregiverName()),
				readExcel.getFourthCaregiverName());
		
		log("*********** Caregiver C4 'From Date' ***********");
		long fourDayBefore = -24 * 60 * 60 * 1000 * 4;
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(fourDayBefore);// From Date : four days Before date
		log("Expected 'From date' for caregiver C4 Should be four days before date: " + expectedFromDateC4);
		String actualFromDateC4 = patientCaregiver.getFromDate(readExcel.getFourthCaregiverName());
		log("Actual 'From Date' for caregiver C4: " + actualFromDateC4);
		log("Verify for Caregiver C4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be Before four day date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);
		softAssert.assertEquals(patientCaregiver.getCaregiverFromDateColor(readExcel.getFourthCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Caregiver C4 'End Date' ***********");
		long twoDayBefore = -24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC4 = BasePageObject.getEpochTimeInDate(twoDayBefore); // End DATE: two day before Date
		log("Expected 'End date' Should be two day before date for caregiver C4: " + expectedEndDateC4);
		String actualEndDateC4 = patientCaregiver.getEndDate(readExcel.getFourthCaregiverName());
		log("Actual 'End Date' should be 'two day before' date for caregiver C4: " + actualEndDateC4);
		log("Verify for Caregiver C4 expected 'End Date': " + expectedEndDateC4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'two day before' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateC4);
		softAssert.assertEquals(patientCaregiver.getCaregiverEndDateColor(readExcel.getFourthCaregiverName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Caregiver C5 Should be Visible: " + readExcel.getFifthCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFifthCaregiverName()),
				readExcel.getFifthCaregiverName());

		log("*********** Caregiver C5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getEpochTimeInDate(twoDayBefore);// From Date: one day before Date
		log("Expected 'From date' Should be 'two day before' date for caregiver C5: " + expectedFromDateC5);
		String actualFromDateC5 = patientCaregiver.getFromDate(readExcel.getFifthCaregiverName());
		log("Actual 'From Date' should be 'two day before' date for caregiver C5: " + actualFromDateC5);
		log("Verify for Caregiver C5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'two day before' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Caregiver C5 'End Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC5 = BasePageObject.getEpochTimeInDate(add1days); // End Date: Today + 1 days
		log("Expected 'End date' Should be 'Todays + 1 Days' date for caregiver C5: " + expectedEndDateC5);
		String actualEndDateC5 = patientCaregiver.getEndDate(readExcel.getFifthCaregiverName());
		log("Actual 'End Date' should be 'Todays + 1 Days' date for caregiver C5: " + actualEndDateC5);
		log("Verify for Caregiver C5 expected 'End Date': " + expectedEndDateC5 + "and actual 'End Date': "
				+ actualEndDateC5 + "  Should be 'Todays + 1 Days' date");
		softAssert.assertEquals(actualEndDateC5, expectedEndDateC5);
		log("Logout from fifth caregiver C5");
		mainPage.logout();
		softAssert.assertAll();
	}

}
