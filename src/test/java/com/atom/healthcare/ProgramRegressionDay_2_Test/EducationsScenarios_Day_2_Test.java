package com.atom.healthcare.ProgramRegressionDay_2_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Educations;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Patients.Programs;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.RegisterPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.ReadExcel;

public class EducationsScenarios_Day_2_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Educations tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 Should be Visible: " + readExcel.getFirstEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFirstEducationName()),
				readExcel.getFirstEducationName());

		log("*********** Education E1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);// From Date: 2 days before date
		log("Expected 'From date' for Education E1 Should be 2 days before date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());
		log("Actual 'From Date' for Education E1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + expectedFromDateE1
				+ " and Actual 'From Date': " + actualFromDateE1 + "  Should be 2 days before date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E1 'End Date' ***********");
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Today's date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Today's' date for Education E1: " + actualEndDateE1);
		log("Verify for Education E1 expected 'End Date': " + expectedEndDateE1 + "and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(0);// From Date: Todays Date
		log("Expected 'From date' Should be 'Todays' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + "and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 Should be Visible: " + readExcel.getFirstEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFirstEducationName()),
				readExcel.getFirstEducationName());

		log("*********** Education E1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);// From Date: two day before date
		log("Expected 'From date' for Education E1 Should be two day before date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());
		log("Actual 'From Date' for Education E1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + expectedFromDateE1 + " and Actual 'From Date': "
				+ actualFromDateE1 + "  Should be two day before date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E1 'End Date' ***********");
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Todays date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Todays ' date for Education E1: " + actualEndDateE1);
		log("Verify for Education E1 expected 'End Date': " + expectedEndDateE1 + "and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(0);// From Date: Today Date
		log("Expected 'From date' Should be 'Todays' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + "and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Caregiver E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 Should be Visible: " + readExcel.getFirstEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFirstEducationName()),
				readExcel.getFirstEducationName());

		log("*********** Education E1 'From Date' ***********");
		long twoDayBeforeDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(twoDayBeforeDate);//From Date: two day before date
		log("Expected 'From date' for Education E1 Should be two day before date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());
		log("Actual 'From Date' for Education E1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + expectedFromDateE1
				+ " and Actual 'From Date': " + actualFromDateE1 + "  Should be two day before date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E1 'End Date' ***********");
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Todays date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Todays ' date for Education E1: " + actualEndDateE1);
		log("Verify for Education E1 expected 'End Date': " + expectedEndDateE1 + "and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFirstEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(0);// From Date: Today Date
		log("Expected 'From date' Should be 'Todays' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + "and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add1days); // From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 1 days + 2 days
		log("Expected 'End date' Should be 'Todays + 1 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 1 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 1 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Verify patient " + AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		readExcel = new ReadExcel();
		log("Login to Second caregiver C2: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p14.fname") + " "
				+ AtomHC.propData.getProperty("patient.p14.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p14.fname") + " "
				+ AtomHC.propData.getProperty("patient.p14.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E4 Should be Visible: " + readExcel.getFourthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFourthEducationName()),
				readExcel.getFourthEducationName());

		log("*********** Education E4 'From Date' ***********");
		long twoBeforeDayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE4 = BasePageObject.getEpochConvertDate(twoBeforeDayDate);// From Date:before two day Date
		log("Expected 'From date' for Education E4 Should be before two day Date date: " + expectedFromDateE4);
		String actualFromDateE4 = patientEducation.getFromDate(readExcel.getFourthEducationName());
		log("Actual 'From Date' for Education E4: " + actualFromDateE4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateE4
				+ " and Actual 'From Date': " + actualFromDateE4 + "  Should be before two days date");
		softAssert.assertEquals(actualFromDateE4, BasePageObject.getEpochConvertDate(twoBeforeDayDate));
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E4 'End Date' ***********");
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Todays date for Education E4: " + expectedEndDateE4);
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Actual 'End Date' should be 'Todays' date for Education E4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());

		log("*********** Education E5 'From Date' ***********");
		String expectedFromDateE5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today date
		log("Expected 'From date' Should be 'Todays' date for Education E5: " + expectedFromDateE5);
		String actualFromDateE5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E5: " + actualFromDateE5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateE5 + "and actual 'From Date': "
				+ actualFromDateE5 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE5, expectedFromDateE5);

		log("*********** Education E5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);

		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E6: " + expectedFromDateE6);
		String actualFromDateE6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E6: " + actualFromDateE6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateE6 + "and actual 'From Date': "
				+ actualFromDateE6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE6, expectedFromDateE6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E6: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getSixthEducationName());
		log("Actual 'End Date' should be 'Todays  + 3 Days' date for Education E6: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays  + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p15.fname") + " "
				+ AtomHC.propData.getProperty("patient.p15.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p15.fname") + " "
				+ AtomHC.propData.getProperty("patient.p15.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()),
				readExcel.getSubscribeProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E4 Should be Visible: " + readExcel.getFourthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFourthEducationName()),
				readExcel.getFourthEducationName());

		log("*********** Education E4 'From Date' ***********");
		long twoBeforeDayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE4 = BasePageObject.getEpochConvertDate(twoBeforeDayDate);// From Date:before two day Date
		log("Expected 'From date' for Education E4 Should be before two day Date date: " + expectedFromDateE4);
		String actualFromDateE4 = patientEducation.getFromDate(readExcel.getFourthEducationName());
		log("Actual 'From Date' for Education E4: " + actualFromDateE4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateE4
				+ " and Actual 'From Date': " + actualFromDateE4 + "  Should be before two days date");
		softAssert.assertEquals(actualFromDateE4, expectedFromDateE4);
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E4 'End Date' ***********");
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Todays date for Education E4: " + expectedEndDateE4);
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Actual 'End Date' should be 'Todays' date for Education E4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());

		log("*********** Education E5 'From Date' ***********");
		String expectedFromDateE5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays' date for Education E5: " + expectedFromDateE5);
		String actualFromDateE5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays ' date for Education E5: " + actualFromDateE5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateE5 + "and actual 'From Date': "
				+ actualFromDateE5 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE5, expectedFromDateE5);

		log("*********** Education E5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);

		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E6: " + expectedFromDateE6);
		String actualFromDateE6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E6: " + actualFromDateE6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateE6 + "and actual 'From Date': "
				+ actualFromDateE6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE6, expectedFromDateE6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E5: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getSixthEducationName());
		log("Actual 'End Date' should be 'Todays  + 3 Days' date for Education E5: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays  + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForEducation_Day_2() throws Exception {
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

		log("Select patient: " + AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getSubscribeProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getSubscribeProgramName()), readExcel.getSubscribeProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E4 Should be Visible: " + readExcel.getFourthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFourthEducationName()),
				readExcel.getFourthEducationName());

		log("*********** Education E4 'From Date' ***********");
		long twoBeforeDayDate = -24 * 60 * 60 * 1000 * 2;
		String expectedFromDateE4 = BasePageObject.getEpochConvertDate(twoBeforeDayDate);// From Date:before two day Date
		log("Expected 'From date' for Education C4 Should be before One day Date date: " + expectedFromDateE4);
		String actualFromDateE4 = patientEducation.getFromDate(readExcel.getFourthEducationName());
		log("Actual 'From Date' for Education E4: " + actualFromDateE4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateE4
				+ " and Actual 'From Date': " + actualFromDateE4 + "  Should be before two days date");
		softAssert.assertEquals(actualFromDateE4, expectedFromDateE4);
		softAssert.assertEquals(patientEducation.getEducationFromDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));

		log("*********** Education E4 'End Date' ***********");
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(0); // End DATE: Today Date
		log("Expected 'End date' Should be Todays date for Education E4: " + expectedEndDateE4);
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Actual 'End Date' should be 'Todays' date for Education E4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);
		softAssert.assertEquals(patientEducation.getEducationEndDateColor(readExcel.getFourthEducationName()),
				AtomHC.propData.getProperty("error.color"));
		
		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());

		log("*********** Education E5 'From Date' ***********");
		String expectedFromDateE5 = BasePageObject.getEpochTimeInDate(0);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays' date for Education E5: " + expectedFromDateE5);
		String actualFromDateE5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays ' date for Education E5: " + actualFromDateE5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateE5 + "and actual 'From Date': "
				+ actualFromDateE5 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE5, expectedFromDateE5);

		log("*********** Education E5 'End Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);
		
		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add1days = 24 * 60 * 60 * 1000 * 1;
		String expectedFromDateE6 = BasePageObject.getEpochTimeInDate(add1days);// From Date: Today + 1 days
		log("Expected 'From date' Should be 'Todays + 1 days' date for Education E6: " + expectedFromDateE6);
		String actualFromDateE6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 1 days' date for Education E6: " + actualFromDateE6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateE6 + "and actual 'From Date': "
				+ actualFromDateE6 + "  Should be 'Todays + 1 days' date");
		softAssert.assertEquals(actualFromDateE6, expectedFromDateE6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add3days); // End Date: Today + 3 days
		log("Expected 'End date' Should be 'Todays + 3 Days' date for Education E6: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getSixthEducationName());
		log("Actual 'End Date' should be 'Todays  + 3 Days' date for Education E6: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays  + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}
}
