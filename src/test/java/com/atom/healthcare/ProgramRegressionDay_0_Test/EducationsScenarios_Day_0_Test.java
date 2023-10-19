package com.atom.healthcare.ProgramRegressionDay_0_Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
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

public class EducationsScenarios_Day_0_Test extends BaseTest {
	HealthcareLogin appointemetPage;
	RegisterPage registerPage;
	ReadExcel readExcel;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException, IOException {
		log("Login as Admin");
		readExcel = new ReadExcel();
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.adminUsername(), AtomHC.key.getDecrypt(readExcel.adminPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p8.fname"),
				AtomHC.propData.getProperty("patient.p8.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p8.fname") + " "
				+ AtomHC.propData.getProperty("patient.p8.lname"));
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
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(0);// From Date:Today Date
		log("Expected 'From date' for Education E1 Should be Todays date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());
		log("Actual 'From Date' for Education E1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + expectedFromDateE1 + " and Actual 'From Date': "
				+ actualFromDateE1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);

		log("*********** Education E1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education E1: " + actualEndDateE1);
		log("Verify for Education E1 expected 'End Date': " + expectedEndDateE1 + " and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + " and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + " and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + " and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + " and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p9.fname"),
				AtomHC.propData.getProperty("patient.p9.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '4' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.days"),
				AtomHC.propData.getProperty("program.entry.point.4"));
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p9.fname") + " "
				+ AtomHC.propData.getProperty("patient.p9.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 " + readExcel.getFirstEducationName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientEducation.isEducationDisplay(readExcel.getFirstEducationName()),
				readExcel.getFirstEducationName());

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochConvertDate(0);// From Date: Today's date
		log("Expected 'From date' for Education E2 Should be Todays date: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateE2 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add1Days); // End DATE: Tomorrow's date
		log("Expected 'End date' Should be Tomorrow's  date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + " and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(0); // From Date: Todays date
		log("Expected 'From date' Should be 'Todays' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E3: " + actualFromDateE3);

		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + " and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays' date ");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Tomorrow's date
		log("Expected 'End date' Should be 'Tomorrow's' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + " and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p10.fname"),
				AtomHC.propData.getProperty("patient.p10.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Date' in patient's program tab");
		String getDate = BasePageObject.getDateFormat(0);
		log("Get todays date " + getDate);
		String addDate = BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsDate(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.date"), getDate, addDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p10.fname") + " "
				+ AtomHC.propData.getProperty("patient.p10.lname"));
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
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for Education E1 Should be Todays date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());// From Date:Today
		log("Actual 'From Date' for Education C1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateE1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);

		log("*********** Education E1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education E1: " + actualEndDateE1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateE1 + "and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + "and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p11.fname"),
				AtomHC.propData.getProperty("patient.p11.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '4' days before (entry point '0')and Type as 'Date' in patient's program tab");
		long fourDaysBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String getDate = BasePageObject.getDateFormat(fourDaysBeforeDate);
		log("Get four days before date: " + getDate);
		String getBeforeDate = BasePageObject.getDate_MM_d_yyyy(fourDaysBeforeDate);
		log("Get four days before date: " + getBeforeDate);
		patientProgram.addPrevProgramEntryPointWithTypeAsDate(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.date"), getDate, getBeforeDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p11.fname") + " "
				+ AtomHC.propData.getProperty("patient.p11.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 " + readExcel.getFirstEducationName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientEducation.isEducationDisplay(readExcel.getFirstEducationName()),
				readExcel.getFirstEducationName());

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochConvertDate(0);// From Date: Today's date
		log("Expected 'From date' for Education E2 Should be Today's date: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' for Education E2 Should be Today's date: " + actualFromDateE2);
		log("Verify for Education E2 Expected 'From Date': " + expectedFromDateE2 + " and Actual 'From Date': "
				+ actualFromDateE2 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add1Days); // End DATE: Tomorrow's date
		log("Expected 'End date' Should be Tomorrow's  date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(0); // From Date:Todays date
		log("Expected 'From date' Should be 'Todays' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Tomorrow's date
		log("Expected 'End date' Should be 'Tomorrow's' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p12.fname"),
				AtomHC.propData.getProperty("patient.p12.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Tracker' in patient's program tab");
		String getDate = BasePageObject.getDateFormat(0);
		log("Get todays date " + getDate);
		String addDate = BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsTracker(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.tracker"), AtomHC.propData.getProperty("tracker.name"),
				getDate, addDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p12.fname") + " "
				+ AtomHC.propData.getProperty("patient.p12.lname"));
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
		String expectedFromDateE1 = BasePageObject.getEpochConvertDate(0);// From Date:Today date 
		log("Expected 'From date' for Education E1 Should be Todays date: " + expectedFromDateE1);
		String actualFromDateE1 = patientEducation.getFromDate(readExcel.getFirstEducationName());
		log("Actual 'From Date' for Education E1: " + actualFromDateE1);
		log("Verify for Education E1 Expected 'From Date': " + expectedFromDateE1 + " and Actual 'From Date': "
				+ actualFromDateE1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateE1, expectedFromDateE1);

		log("*********** Education E1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE1 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for Education E1: " + expectedEndDateE1);
		String actualEndDateE1 = patientEducation.getEndDate(readExcel.getFirstEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education E1: " + actualEndDateE1);
		log("Verify for Education E1 expected 'End Date': " + expectedEndDateE1 + "and actual 'End Date': "
				+ actualEndDateE1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE1, expectedEndDateE1);

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E2: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 expected 'From Date': " + expectedFromDateE2 + "and actual 'From Date': "
				+ actualFromDateE2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E2: " + expectedEndDateE2);
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'From Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from first caregiver C1");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForEducation_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p13.fname"),
				AtomHC.propData.getProperty("patient.p13.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '4' days before (entry point '0')and Type as 'Tracker' in patient's program tab");
		long fourDaysBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String getDate = BasePageObject.getDateFormat(fourDaysBeforeDate);
		log("Get four days before date " + getDate);
		String getBeforeDate = BasePageObject.getDate_MM_d_yyyy(fourDaysBeforeDate);
		log("Get four days before date: " + getBeforeDate);
		patientProgram.addPrevProgramEntryPointWithTypeAsTracker(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.tracker"), AtomHC.propData.getProperty("tracker.name"),
				getDate, getBeforeDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: " + readExcel.getFirstCaregiverName());
		Thread.sleep(2000);
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();

		log("Verify patient " + AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C1: " + readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p13.fname") + " "
				+ AtomHC.propData.getProperty("patient.p13.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Education tab");
		Educations patientEducation = new Educations(driver);
		patientEducation.clickOnPatientEducationTab();

		log("Verify Education E1 " + patientEducation.isEducationDisplay(readExcel.getFirstEducationName())
				+ " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientEducation.isEducationDisplay(readExcel.getFirstEducationName()),
				readExcel.getSecondEducationName());

		log("Verify Education E2 Should be Visible: " + readExcel.getSecondEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSecondEducationName()),
				readExcel.getSecondEducationName());

		log("*********** Education E2 'From Date' ***********");
		String expectedFromDateE2 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for Education E2 Should be Todays date: " + expectedFromDateE2);
		String actualFromDateE2 = patientEducation.getFromDate(readExcel.getSecondEducationName());// From Date:Today's date 
		log("Actual 'From Date' for Education E2: " + actualFromDateE2);
		log("Verify for Education E2 Expected 'From Date': " + patient.getSimpleDateFormat()
				+ " and Actual 'From Date': " + actualFromDateE2 + "  Should be Todays date in Red color");
		softAssert.assertEquals(actualFromDateE2, expectedFromDateE2);

		log("*********** Education E2 'End Date' ***********");
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateE2 = BasePageObject.getEpochTimeInDate(add1Days); // End DATE: Tomorrow's date
		String actualEndDateE2 = patientEducation.getEndDate(readExcel.getSecondEducationName());
		log("Expected 'End date' Should be Tomorrow's  date for Education E2: " + expectedEndDateE2);
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E2: " + actualEndDateE2);
		log("Verify for Education E2 expected 'End Date': " + expectedEndDateE2 + "and actual 'End Date': "
				+ actualEndDateE2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateE2, expectedEndDateE2);

		log("Verify Education E3 Should be Visible: " + readExcel.getThirdEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getThirdEducationName()),
				readExcel.getThirdEducationName());

		log("*********** Education E3 'From Date' ***********");
		String expectedFromDateE3 = BasePageObject.getEpochTimeInDate(0); // From Date: Todays date
		log("Expected 'From date' Should be 'Todays' date for Education E3: " + expectedFromDateE3);
		String actualFromDateE3 = patientEducation.getFromDate(readExcel.getThirdEducationName());
		log("Actual 'From Date' should be 'Todays' date for Education E3: " + actualFromDateE3);
		log("Verify for Education E3 expected 'From Date': " + expectedFromDateE3 + "and actual 'From Date': "
				+ actualFromDateE3 + "  Should be 'Todays' date in Red color");
		softAssert.assertEquals(actualFromDateE3, expectedFromDateE3);

		log("*********** Education E3 'End Date' ***********");
		String expectedEndDateE3 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Tomorrow's date
		log("Expected 'End date' Should be 'Tomorrow's' date for Education E3: " + expectedEndDateE3);
		String actualEndDateE3 = patientEducation.getEndDate(readExcel.getThirdEducationName());
		log("Actual 'End Date' should be 'Tomorrow's' date for Education E3: " + actualEndDateE3);
		log("Verify for Education E3 expected 'End Date': " + expectedEndDateE3 + "and actual 'End Date': "
				+ actualEndDateE3 + "  Should be 'Tomorrow's' date in Red color ");
		softAssert.assertEquals(actualEndDateE3, expectedEndDateE3);
		log("Logout from second caregiver C2");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForEducation_Day_0()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p14.fname"),
				AtomHC.propData.getProperty("patient.p14.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p14.fname") + " "
				+ AtomHC.propData.getProperty("patient.p14.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p14.fname") + " "
				+ AtomHC.propData.getProperty("patient.p14.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getSubscribeProgramName(),
				AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C4 **************************************************");
		log("Login to fourth caregiver C4: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

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
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(0);// From Date:Today Date
		log("Expected 'From date' for Education E4 Should be Todays date: " + expectedFromDateC4);
		String actualFromDateC4 = patientEducation.getFromDate(readExcel.getFourthEducationName());
		log("Actual 'From Date' for Education E4: " + actualFromDateC4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Education E4 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Expected 'End date' Should be Todays + 2 days date for Education C4: " + expectedEndDateE4);
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education C4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);

		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());

		log("*********** Education E5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E5: " + expectedFromDateC5);
		String actualFromDateC5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E5: " + actualFromDateC5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Education E5 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);

		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC6 = BasePageObject.getEpochTimeInDate(add3days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E6: " + expectedFromDateC6);
		String actualFromDateC6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E6: " + actualFromDateC6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateC6 + "and actual 'From Date': "
				+ actualFromDateC6 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC6, expectedFromDateC6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E5: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getSixthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E5: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForEducation_Day_0()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p15.fname"),
				AtomHC.propData.getProperty("patient.p15.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p15.fname") + " "
				+ AtomHC.propData.getProperty("patient.p15.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p15.fname") + " "
				+ AtomHC.propData.getProperty("patient.p15.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Date' in patient's program tab");
		String getDate = BasePageObject.getDateFormat(0);
		log("Get todays date " + getDate);
		String addDate = BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsDate(readExcel.getSubscribeProgramName(),
				AtomHC.propData.getProperty("program.entry.date"), getDate, addDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C4 **************************************************");
		log("Login to fourth caregiver C4: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

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
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for Education C4 Should be Todays date: " + expectedFromDateC4);
		String actualFromDateC4 = patientEducation.getFromDate(readExcel.getFourthEducationName());// From Date:Today Date
		log("Actual 'From Date' for Education E4: " + actualFromDateC4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Education E4 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Expected 'End date' Should be Todays + 2 days date for Education E4: " + expectedEndDateE4);
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education E4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);

		log("*********** Education E5 'From Date' ***********");
		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());
		String expectedFromDateC5 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E5: " + expectedFromDateC5);
		String actualFromDateC5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E5: " + actualFromDateC5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Education E5 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);

		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC6 = BasePageObject.getEpochTimeInDate(add3days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E6: " + expectedFromDateC6);
		String actualFromDateC6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E6: " + actualFromDateC6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateC6 + "and actual 'From Date': "
				+ actualFromDateC6 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC6, expectedFromDateC6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E6: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E6: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from fourth caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForEducation_Day_0()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p16.fname"),
				AtomHC.propData.getProperty("patient.p16.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Tracker' in patient's program tab");
		String getDate = BasePageObject.getDateFormat(0);
		log("Get todays date " + getDate);
		String addDate = BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsTracker(readExcel.getSubscribeProgramName(),
				AtomHC.propData.getProperty("program.entry.tracker"), AtomHC.propData.getProperty("subs.tracker.name"),
				getDate, addDate);
		log("Logout from Admin");
		mainPage.logout();

		log("************************************************** Caregiver C4 **************************************************");
		log("Login to fourth caregiver C1: " + readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p16.fname") + " "
				+ AtomHC.propData.getProperty("patient.p16.lname"));
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
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for Education C4 Should be Todays date: " + expectedFromDateC4);
		String actualFromDateC4 = patientEducation.getFromDate(readExcel.getFourthEducationName());// From Date:Today
		log("Actual 'From Date' for Education E4: " + actualFromDateC4);
		log("Verify for Education E4 Expected 'From Date': " + expectedFromDateC4 + " and Actual 'From Date': "
				+ actualFromDateC4 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Education E4 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateE4 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for Education E4: " + expectedEndDateE4);
		String actualEndDateE4 = patientEducation.getEndDate(readExcel.getFourthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for Education E4: " + actualEndDateE4);
		log("Verify for Education E4 expected 'End Date': " + expectedEndDateE4 + "and actual 'End Date': "
				+ actualEndDateE4 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateE4, expectedEndDateE4);

		log("Verify Education E5 Should be Visible: " + readExcel.getFifthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getFifthEducationName()),
				readExcel.getFifthEducationName());

		log("*********** Education E5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for Education E5: " + expectedFromDateC5);
		String actualFromDateC5 = patientEducation.getFromDate(readExcel.getFifthEducationName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for Education E5: " + actualFromDateC5);
		log("Verify for Education E5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Education E5 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateE5 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E5: " + expectedEndDateE5);
		String actualEndDateE5 = patientEducation.getEndDate(readExcel.getFifthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E5: " + actualEndDateE5);
		log("Verify for Education E5 expected 'End Date': " + expectedEndDateE5 + "and actual 'End Date': "
				+ actualEndDateE5 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE5, expectedEndDateE5);

		log("Verify Education E6 Should be Visible: " + readExcel.getSixthEducationName());
		softAssert.assertEquals(patientEducation.getEducationName(readExcel.getSixthEducationName()),
				readExcel.getSixthEducationName());

		log("*********** Education E6 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC6 = BasePageObject.getEpochTimeInDate(add3days);// From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for Education E6: " + expectedFromDateC6);
		String actualFromDateC6 = patientEducation.getFromDate(readExcel.getSixthEducationName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for Education E6: " + actualFromDateC6);
		log("Verify for Education E6 expected 'From Date': " + expectedFromDateC6 + "and actual 'From Date': "
				+ actualFromDateC6 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC6, expectedFromDateC6);

		log("*********** Education E6 'End Date' ***********");
		String expectedEndDateE6 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for Education E6: " + expectedEndDateE6);
		String actualEndDateE6 = patientEducation.getEndDate(readExcel.getSixthEducationName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for Education E6: " + actualEndDateE6);
		log("Verify for Education E6 expected 'End Date': " + expectedEndDateE6 + "and actual 'End Date': "
				+ actualEndDateE6 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateE6, expectedEndDateE6);
		log("Logout from first caregiver C4");
		mainPage.logout();
		softAssert.assertAll();
	}

}
