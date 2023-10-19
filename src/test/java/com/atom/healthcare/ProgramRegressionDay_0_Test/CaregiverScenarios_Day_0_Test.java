package com.atom.healthcare.ProgramRegressionDay_0_Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
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

public class CaregiverScenarios_Day_0_Test extends BaseTest {
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
	public void testEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p1.fname"),
				AtomHC.propData.getProperty("patient.p1.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C1 Should be Todays date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());// From Date:Today Date
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1
				+ " and Actual 'From Date': " + actualFromDateC1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);

		log("*********** Caregiver C1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(add2days); // End Date: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for caregiver C1: " + expectedEndDateC1);
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p1.fname") + " "
				+ AtomHC.propData.getProperty("patient.p1.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDaysInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p2.fname"),
				AtomHC.propData.getProperty("patient.p2.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));

		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '4' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.days"),
				AtomHC.propData.getProperty("program.entry.point.4"));
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());// From Date: Today's Date
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Today + 2 days + 3days-4days=( Tomorrow's date)
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(0); // From Date: Today + 2 days-4 days(Todays date)
		log("Expected 'From date' Should be 'Today's' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Today's' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Today + 3days + 2days-4days(=Tomorrow's date)
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p2.fname") + " "
				+ AtomHC.propData.getProperty("patient.p2.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date:Today +2 days- 4days (= Today's date )
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End DATE: Today + 2 days + 3days-4days=( Tomorrow's date)
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: Today + 2 days-4 days(=-1=Todays date)
		log("Expected 'From date' Should be 'Todays' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be 'Todays' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays' date in Red color");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today +3days+2days-4days(=Tomorrow's date)
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsDateInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p3.fname"),
				AtomHC.propData.getProperty("patient.p3.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Date' in patient's program tab");
		String getTodayDate = BasePageObject.getDateFormat(0);
		log("Get Today's date " + getTodayDate);
		String addDate=BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsDate(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.date"), getTodayDate,addDate);
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname"));

		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(0); // From Date:Today date
		log("Expected 'From date' for caregiver C1 Should be Today's date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1
				+ " and Actual 'From Date': " + actualFromDateC1 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);

		log("*********** Caregiver C1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Expected 'End date' Should be Todays + 2 days date for caregiver C1: " + expectedEndDateC1);
		log("Actual 'End Date' should be 'Todays + 2 days' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'From Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p3.fname") + " "
				+ AtomHC.propData.getProperty("patient.p3.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsDateInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p4.fname"),
				AtomHC.propData.getProperty("patient.p4.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '4' days before (entry point '0')and Type as 'Date' in patient's program tab");
		long fourDaysBeforeDate = -24 * 60 * 60 * 1000 * 4;
		String getFourthDaysBeforeDate = BasePageObject.getDateFormat(fourDaysBeforeDate);
		log("Get four days before date: " + getFourthDaysBeforeDate);
		String getBeforeDate = BasePageObject.getDate_MM_d_yyyy(fourDaysBeforeDate);
		log("Get four days before date: " + getBeforeDate);
		patientProgram.addPrevProgramEntryPointWithTypeAsDate(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.date"), getFourthDaysBeforeDate,getBeforeDate);
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date:Today +2 days- 4days (=Today's date )
		String expectedFromDateC2 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's date ");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1Days); // End DATE: Today + 2 days + 3days-4days=( Tomorrow's date)
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: Today + 2 days-4 days(=-1=Todays date)
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(0);
		log("Expected 'From date' Should be 'Today's' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Today's' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays' date ");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1Days); // End Date: Today + 3days + 2days-4days(=Tomorrow's date)
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p4.fname") + " "
				+ AtomHC.propData.getProperty("patient.p4.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date:Today +2 days- 4days (= Today's date )
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End DATE: Today + 2 days + 3days-4days=( Tomorrow's date)
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: Today + 2 days-4 days(=-1=Todays date)
		log("Expected 'From date' Should be 'Today's' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be 'Today's' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Today's' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today +3days+2days-4days(=Tomorrow's date)
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsZeroAndTypeAsTrackerInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p5.fname"),
				AtomHC.propData.getProperty("patient.p5.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as Todays date (entry point '0') and Type as 'Tracker' in patient's program tab");
		String getDate = BasePageObject.getDateFormat(0);
		log("Get todays date " + getDate);
		String addDate = BasePageObject.getDate_MM_d_yyyy(0);
		log("Get todays date " + addDate);
		patientProgram.addProgramEntryPointWithTypeAsTracker(readExcel.getProgramName(),
				AtomHC.propData.getProperty("program.entry.tracker"), AtomHC.propData.getProperty("tracker.name"),
				getDate,addDate);
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 Should be Visible: " + readExcel.getFirstCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFirstCaregiverName()),
				readExcel.getFirstCaregiverName());

		log("*********** Caregiver C1 'From Date' ***********");
		String expectedFromDateC1 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C1 Should be Todays date: " + expectedFromDateC1);
		String actualFromDateC1 = patientCaregiver.getFromDate(readExcel.getFirstCaregiverName());// From Date:Today date
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC1);
		log("Verify for Caregiver C1 Expected 'From Date': " + expectedFromDateC1
				+ " and Actual 'From Date': " + actualFromDateC1 + "  Should be Todays date");
		softAssert.assertEquals(actualFromDateC1, expectedFromDateC1);

		log("*********** Caregiver C1 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC1 = BasePageObject.getEpochTimeInDate(add2days); // End DATE: Today + 2 days
		log("Expected 'End date' Should be Todays + 2 days date for caregiver C1: " + expectedEndDateC1);
		String actualEndDateC1 = patientCaregiver.getEndDate(readExcel.getFirstCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days' date for caregiver C1: " + actualEndDateC1);
		log("Verify for Caregiver C1 expected 'End Date': " + expectedEndDateC1 + "and actual 'End Date': "
				+ actualEndDateC1 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualEndDateC1, expectedEndDateC1);

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");
		String expectedFromDateC2 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for caregiver C2: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for caregiver C2: " + actualFromDateC2);
		log("Verify for Caregiver C2 expected 'From Date': " + expectedFromDateC2 + "and actual 'From Date': "
				+ actualFromDateC2 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(add3days); // From Date: Today + 3 days
		log("Expected 'From date' Should be 'Todays + 3 days' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Todays + 3 days' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays + 3 days' date");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'From Date' ***********");
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 3 days + 2 days
		log("Expected 'End date' Should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Todays + 3 days + 2 Days' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Todays + 3 days + 2 Days' date");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname")));
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p5.fname") + " "
				+ AtomHC.propData.getProperty("patient.p5.lname")));
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testEnterAnEntryPointsAsFourAndTypeAsTrackerInPatientProgramTabForCaregiver_Day_0() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p6.fname"),
				AtomHC.propData.getProperty("patient.p6.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		log("Select patient: " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
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
				getDate,getBeforeDate);
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C1 **************************************************");
		log("Login to first caregiver C1: "+readExcel.getFirstCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFirstCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFirstCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname")));
		log("Logout from first caregiver C1");
		mainPage.logout();

		log("************************************************** Caregiver C2 **************************************************");
		log("Login to second caregiver C2 : "+readExcel.getSecondCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		Caregivers patientCaregiver = new Caregivers(driver);
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date:Today +2days- 4days (=Today's date )
		String expectedFromDateC2 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		String actualFromDateC2 = patientCaregiver.getFromDate(readExcel.getSecondCaregiverName());
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End DATE: Today + 2 days +3days-4days=( Tomorrow's date)
		long add1Days = 24 * 60 * 60 * 1000 * 1;
		String expectedEndDateC2 = BasePageObject.getEpochTimeInDate(add1Days);
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		String actualEndDateC2 = patientCaregiver.getEndDate(readExcel.getSecondCaregiverName());
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: Today + 2 days-4 days(=-1=Todays date)
		String expectedFromDateC3 = BasePageObject.getEpochTimeInDate(0);
		log("Expected 'From date' Should be 'Todays' date for caregiver C3: " + expectedFromDateC3);
		String actualFromDateC3 = patientCaregiver.getFromDate(readExcel.getThirdCaregiverName());
		log("Actual 'From Date' should be 'Todays' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Todays' date in Red color");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today +3days+2days-4days(=Tomorrow's date)
		String expectedEndDateC3 = BasePageObject.getEpochTimeInDate(add1Days);
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		String actualEndDateC3 = patientCaregiver.getEndDate(readExcel.getThirdCaregiverName());
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date in Red color ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from second caregiver C2");
		mainPage.logout();

		log("************************************************** Caregiver C3 **************************************************");
		log("Login to third caregiver C3 : "+readExcel.getThirdCaregiverName());
		appointemetPage.login(readExcel.getThirdCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getThirdCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p6.fname") + " "
				+ AtomHC.propData.getProperty("patient.p6.lname"));
		patientProgram.clickOnPatientProgramTab();

		log("Verify 'Program name': " + readExcel.getProgramName());
		softAssert.assertEquals(patientProgram.getProgramName(readExcel.getProgramName()), readExcel.getProgramName());
		log("Select Caregiver tab");
		patientCaregiver.clickOnCaregiverTab();

		log("Verify Caregiver C1 " + readExcel.getFirstCaregiverName() + " Should not be Visible in Caregiver C2");
		softAssert.assertFalse(patientCaregiver.isCaregiverDisplay(readExcel.getFirstCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("Verify Caregiver C2 Should be Visible: " + readExcel.getSecondCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getSecondCaregiverName()),
				readExcel.getSecondCaregiverName());

		log("*********** Caregiver C2 'From Date' ***********");// From Date:Today +2 days- 4days (= Today's date )
		log("Expected 'From date' for caregiver C2 Should be Today's date: " + expectedFromDateC2);
		log("Actual 'From Date' for caregiver C1: " + actualFromDateC2);
		log("Verify for Caregiver C2 Expected 'From Date': " + expectedFromDateC2
				+ " and Actual 'From Date': " + actualFromDateC2 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC2, expectedFromDateC2);

		log("*********** Caregiver C2 'End Date' ***********");// End DATE: Today + 2 days + 3days-4days=( Tomorrow's date)
		log("Expected 'End date' Should be Tomorrow's  date for caregiver C2: " + expectedEndDateC2);
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C2: " + actualEndDateC2);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC2 + "and actual 'End Date': "
				+ actualEndDateC2 + "  Should be 'Tomorrow's' date");
		softAssert.assertEquals(actualEndDateC2, expectedEndDateC2);

		log("Verify Caregiver C3 Should be Visible: " + readExcel.getThirdCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getThirdCaregiverName()),
				readExcel.getThirdCaregiverName());

		log("*********** Caregiver C3 'From Date' ***********");// From Date: Today + 2 days-4 days(=-1=Todays date)
		log("Expected 'From date' Should be 'Today's' date for caregiver C3: " + expectedFromDateC3);
		log("Actual 'From Date' should be 'Today's' date for caregiver C3: " + actualFromDateC3);
		log("Verify for Caregiver C3 expected 'From Date': " + expectedFromDateC3 + "and actual 'From Date': "
				+ actualFromDateC3 + "  Should be 'Today's' date in Red color");
		softAssert.assertEquals(actualFromDateC3, expectedFromDateC3);

		log("*********** Caregiver C3 'End Date' ***********");// End Date: Today +3days+2days-4days(=Tomorrow's date)
		log("Expected 'End date' Should be 'Tomorrow's' date for caregiver C3: " + expectedEndDateC3);
		log("Actual 'End Date' should be 'Tomorrow's' date for caregiver C3: " + actualEndDateC3);
		log("Verify for Caregiver C3 expected 'End Date': " + expectedEndDateC3 + "and actual 'End Date': "
				+ actualEndDateC3 + "  Should be 'Tomorrow's' date ");
		softAssert.assertEquals(actualEndDateC3, expectedEndDateC3);
		log("Logout from third caregiver C3");
		mainPage.logout();
		softAssert.assertAll();
	}

	@Test
	public void testSubscribeProgramEnterAnEntryPointsAsZeroAndTypeAsDaysInPatientProgramTabForCaregiver_Day_0()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Patients patient = new Patients(driver);
		patient.clickOnPatientsTab();
		log("Create new Patient");
		patient.clickOnAddButton();
		patient.creatPatient(AtomHC.propData.getProperty("patient.p7.fname"),
				AtomHC.propData.getProperty("patient.p7.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);

		log("Select patient: " + AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		Programs patientProgram = new Programs(driver);
		patientProgram.clickOnPatientProgramTab();

		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
		patientProgram.addProgramEntryPointWithTypeAsDay(readExcel.getSubscribeProgramName(),
				AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		log("Logout from Admin");
		mainPage.logout();
		
		log("************************************************** Caregiver C4 **************************************************");
		log("Login to fourth caregiver C4 : "+readExcel.getFourthCaregiverName());
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(readExcel.getFourthCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getFourthCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();

		log("Select patient: " + AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		patient.clickOnPatient(AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname"));
		patientProgram.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();

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
		String expectedFromDateC4 = BasePageObject.getEpochConvertDate(0);
		log("Expected 'From date' for caregiver C4 Should be Today's date: " + expectedFromDateC4);
		String actualFromDateC4 = patientCaregiver.getFromDate(readExcel.getFourthCaregiverName());// From Date:Today's date
		log("Actual 'From Date' for caregiver C4: " + actualFromDateC4);
		log("Verify for Caregiver C4 Expected 'From Date': " + expectedFromDateC4
				+ " and Actual 'From Date': " + actualFromDateC4 + "  Should be Today's date");
		softAssert.assertEquals(actualFromDateC4, expectedFromDateC4);

		log("*********** Caregiver C4 'End Date' ***********");
		long add2days = 24 * 60 * 60 * 1000 * 2;
		String expectedEndDateC4 = BasePageObject.getEpochTimeInDate(add2days); // End Date: Today + 2 days
		String actualEndDateC4 = patientCaregiver.getEndDate(readExcel.getFourthCaregiverName());
		log("Expected 'End date' Should be Today's + 2 days date for caregiver C4: " + expectedEndDateC4);
		log("Actual 'End Date' should be 'Today's + 2 days' date for caregiver C4: " + actualEndDateC4);
		log("Verify for Caregiver C4 expected 'End Date': " + expectedEndDateC4 + "and actual 'End Date': "
				+ actualEndDateC4 + "  Should be 'Today's + 2 days' date");
		softAssert.assertEquals(actualEndDateC4, expectedEndDateC4);

		log("Verify Caregiver C5 Should be Visible: " + readExcel.getFifthCaregiverName());
		softAssert.assertEquals(patientCaregiver.getCaregiverName(readExcel.getFifthCaregiverName()),
				readExcel.getFifthCaregiverName());

		log("*********** Caregiver C5 'From Date' ***********");
		String expectedFromDateC5 = BasePageObject.getEpochTimeInDate(add2days);// From Date: Today + 2 days
		log("Expected 'From date' Should be 'Todays + 2 days' date for caregiver C5: " + expectedFromDateC5);
		String actualFromDateC5 = patientCaregiver.getFromDate(readExcel.getFifthCaregiverName());
		log("Actual 'From Date' should be 'Todays + 2 days' date for caregiver C5: " + actualFromDateC5);
		log("Verify for Caregiver C5 expected 'From Date': " + expectedFromDateC5 + "and actual 'From Date': "
				+ actualFromDateC5 + "  Should be 'Todays + 2 days' date");
		softAssert.assertEquals(actualFromDateC5, expectedFromDateC5);

		log("*********** Caregiver C5 'End Date' ***********");
		long add5days = 24 * 60 * 60 * 1000 * 5;
		String expectedEndDateC5 = BasePageObject.getEpochTimeInDate(add5days); // End Date: Today + 2 days + 3 days
		log("Expected 'End date' Should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + expectedEndDateC5);
		String actualEndDateC5 = patientCaregiver.getEndDate(readExcel.getFifthCaregiverName());
		log("Actual 'End Date' should be 'Todays + 2 days + 3 Days' date for caregiver C2: " + actualEndDateC5);
		log("Verify for Caregiver C2 expected 'End Date': " + expectedEndDateC5 + "and actual 'End Date': "
				+ actualEndDateC5 + "  Should be 'Todays + 2 days + 3 Days' date");
		softAssert.assertEquals(actualEndDateC5, expectedEndDateC5);
		log("Logout from fourth caregiver C4");
		mainPage.logout();

		log("************************************************** Caregiver C5 **************************************************");
		log("Login to fifth caregiver C5 : "+readExcel.getFifthCaregiverName());
		appointemetPage.login(readExcel.getSecondCaregiverUsername(),
				AtomHC.key.getDecrypt(readExcel.getSecondCaregiverPassword()),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		patient.clickOnPatientsTab();
		log("Verify patient " + AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname") + " is not visible to patient");
		softAssert.assertFalse(patient.isPatientDisplay(AtomHC.propData.getProperty("patient.p7.fname") + " "
				+ AtomHC.propData.getProperty("patient.p7.lname")));
		log("Logout from fifth caregiver C5");
		mainPage.logout();
		softAssert.assertAll();
	}

}
