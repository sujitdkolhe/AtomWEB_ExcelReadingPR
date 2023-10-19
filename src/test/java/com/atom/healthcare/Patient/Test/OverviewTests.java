package com.atom.healthcare.Patient.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.Overview;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class OverviewTests extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// DashboardVitals
	@Test
	public void testUserLandsOnPatientReadingOverview() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		log("Verify Reading Overview Header and Show More button");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientPage.getReadingOverviewHeader(),
				AtomHC.propData.getProperty("reading.overview.header"));
		softAssert.assertTrue(patientPage.isReadingShowMoreDisplay());
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testVerifyReadingObservationCategoryFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		Overview overview = new Overview(driver);
		log("Verify Observation Category Label and Icon");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(overview.isVitalsIconDisplay());
		softAssert.assertEquals(overview.getVitalsLabel(), AtomHC.propData.getProperty("vitals.label"));
		softAssert.assertTrue(overview.isFoodIconDisplay());
		softAssert.assertEquals(overview.getFoodLabel(), AtomHC.propData.getProperty("food.label"));
		softAssert.assertTrue(overview.isExerciseIconDisplay());
		softAssert.assertEquals(overview.getExerciseLabel(), AtomHC.propData.getProperty("exercise.label"));
		softAssert.assertEquals(overview.getBloodGlucoseLabel(), AtomHC.propData.getProperty("blood.label"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyByDefaultReadingFirstCategorySelected() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		Overview overview = new Overview(driver);
		log("Verify By Default First Reading Category Selected");
		assertEquals(overview.getReadingOverviewHeader(), AtomHC.propData.getProperty("reading.overview.header"));
	}

	@Test
	public void testNoDataFoundViewMessageDisplayInReadingCard() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patientPage.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patientPage.clickOnNewAddedPatient();
		Overview overview = new Overview(driver);
		log("Verify No data found Message, if no readings added");
		assertEquals(overview.getReadingOverviewNoDataFoundMessage(),
				AtomHC.propData.getProperty("no.record.found.msg"));
	}

	@Test(enabled=false)
	public void testVerifyReadingCardsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		log("Verify Reading Cards Displayed");
		SoftAssert softAssert = new SoftAssert();
		Overview overview = new Overview(driver);
		softAssert.assertTrue(overview.isWeightReadingCardDisplay());
		softAssert.assertTrue(overview.isBloodGlucoseReadingCardDisplay());
		softAssert.assertTrue(overview.isHeartRateReadingCardDisplay());
		softAssert.assertTrue(overview.isBabyKickCounterReadingCardDisplay());
		softAssert.assertTrue(overview.isBloodPressureReadingCardDisplay());
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testVerifyReadingCardsNameDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		log("Verify Reading Card Name");
		SoftAssert softAssert = new SoftAssert();
		Overview overview = new Overview(driver);
		softAssert.assertEquals(overview.getReadingCardWeightLabel(),
				AtomHC.propData.getProperty("reading.weight.label"));
		softAssert.assertEquals(overview.getReadingCardBloodGlucoseLabel(),
				AtomHC.propData.getProperty("reading.blood.glucose.label"));
		softAssert.assertEquals(overview.getReadingCardHeartRateLabel(),
				AtomHC.propData.getProperty("reading.heart.rate.label"));
		softAssert.assertEquals(overview.getReadingCardBabyKickCounterLabel(),
				AtomHC.propData.getProperty("reading.baby.counter.label"));
		softAssert.assertEquals(overview.getReadingCardBloodPressureLabel(),
				AtomHC.propData.getProperty("reading.blood.pressure.label"));
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testVerifyReadingLatestValueAndUnit() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		Overview overview = new Overview(driver);
		String weightValue = overview.getReadingWeightValue();
		String getWeightValue = weightValue.toString();
		String[] weight = getWeightValue.split(" ");
		String currentWeight = weight[0];
		log("Verify Reading Latest Value");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(overview.getReadingWeightValue(), currentWeight);
		String bloodGlucoseValue = overview.getReadingBloodGlucoseValue();
		String getBloodGlucoseValue = bloodGlucoseValue.toString();
		String[] bloodGlucose = getBloodGlucoseValue.split(" ");
		String currentBloodGlucose = bloodGlucose[0];
		softAssert.assertEquals(overview.getReadingBloodGlucoseValue(), currentBloodGlucose);
		log("Verify Reading Unit");
		softAssert.assertEquals(overview.getReadingWeightUnit(), AtomHC.propData.getProperty("weight.unit"));
		softAssert.assertEquals(overview.getReadingBloodGlucoseUnit(),
				AtomHC.propData.getProperty("blood.glucose.unit"));
		softAssert.assertTrue(overview.isWeightGraphDisplay());
		softAssert.assertTrue(overview.isBloodGlucoseGraphDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testNavigatToActivityListPageAfterClickOnShowMore() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		Overview overview = new Overview(driver);
		overview.clickOnReadingShowMoreButton();
		log("Verify It navigate to Activity List Page On Click Show More button");
		assertEquals(overview.getReadingOverviewHeader(), AtomHC.propData.getProperty("reading.overview.header"));
	}

	@Test
	public void testNavigateToReadingDetailPageAfterClickOnAnyCards() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnExistingPatient();
		Overview overview = new Overview(driver);
		overview.clickOnReadingShowMoreButton();
		overview.clickOnWeightReadingCard();
		log("Verify It Naviagate to Reading Detail Page, On Click Any weight card");
		assertEquals(overview.getWeightHeader(), AtomHC.propData.getProperty("reading.weight.label"));
	}

}
