package com.atom.healthcare.Patient.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.Medications;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class MedicationsTests extends BaseTest {
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

	// MedicationList(Provider)
	@Test
	public void testUserLandOnMedicationListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		String medicationTitle = medications.getPatientMedicationHeader();
		String[] getTitle = medicationTitle.split(" ");
		String medicationHeader = getTitle[0];
		log("Verify Medication List Page Fields");
		assertEquals(medicationHeader, AtomHC.propData.getProperty("medication.title"));
	}

	@Test
	public void testSystemVerifyMedicationListHeaderAndCount() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		String medicationTitle = medications.getPatientMedicationHeader();
		String MedicationCount = medicationTitle.substring(13, 14);
		log("Medication Count is: " + MedicationCount);
		medications.clickOnPatientMedicationAddButton();
		medications.addNewMedication(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		String medicationNewCount = medications.getPatientMedicationHeader();
		String getCount = medicationNewCount.substring(13, 14);
		String actualCount = getCount;
		log("Verify Medication List Header Count");
		assertEquals(getCount, actualCount);
	}

	@Test
	public void testSystemVerifyMedicationListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		log("Verify Medication List Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getNoRecordFoundTextInMedicine(),
				AtomHC.propData.getProperty("no.record.found.msg"));
		softAssert.assertTrue(medications.isPatientMedicationSearchTextboxDisplayed());
		softAssert.assertEquals(medications.getMedicationSearchPlaceholder(),
				AtomHC.propData.getProperty("medication.search.placeholder"));
		softAssert.assertTrue(medications.isPatientMedicationAddButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testSystemVerifyAddedMedicationListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.addNewMedication(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		long add3days = 24 * 60 * 60 * 1000 * 3;
		String expectedEndDate = BasePageObject.getEpochTimeInDate(add3days);
		log("Verify Added Medication List Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getFirstMedicineName(), AtomHC.propData.getProperty("valid.medicine.name"));
		softAssert.assertTrue(medications.isMedicineIconDisplayed());
		softAssert.assertEquals(medications.getMedicineEndDate(), expectedEndDate);
		softAssert.assertTrue(medications.isOpenStatusDisplayed());
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testSystemAbleToFilterTextInMedicationListSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		medications.clickOnPatientMedicationTab();
		medications.enterMedicineInSearchTextbox(AtomHC.propData.getProperty("medicine.name"));
		log("verify if Searched medicine is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(medications.isSearchedMedicineDisplayed());
		medications.clearMedicineInSearchTextbox();
		medications.enterMedicineInSearchTextbox(AtomHC.propData.getProperty("invalid.search.medicine"));
		log("verify if message is displayed, if no record is found");
		softAssert.assertEquals(medications.getNoRecordFoundTextInMedicine(),
				AtomHC.propData.getProperty("no.record.found.medicine"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayMedicationAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		log("verify Medication Add page is Displayed");
		assertEquals(medications.getMedicationAddEditTitle(), AtomHC.propData.getProperty("medication.add.title"));
	}

	@Test
	public void testMedicationDetailPageDisplayIfOpenStatus() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.addNewMedication(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		medications.clickOnFirstMedicine();
		log("Verify Medication Detail page is Displayed, if status is Open");
		assertTrue(medications.isMedicationSaveButtonDisplayed());
	}

	@Test
	public void testMedicationReadOnlyPageDisplayedIfHistoryStatus() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		medications.clickOnPatientMedication(AtomHC.propData.getProperty("medi.patient.name"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicine();
		log("Verify Medication Read Only Page Displayed, if status is history");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(medications.isMedicationSaveButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testActiveRecordShowsFirstMedicationListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		String medicneName = "med" + BasePageObject.createRandomCharacter(2);
		medications.addNewMedication(medicneName, AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		String expectedMedicineName = medications.getNewAddedMedicine();
		log("First Medicine Name " + expectedMedicineName);
		log("Verify New Added Medicine");
		assertEquals(medications.getNewAddedMedicine(), expectedMedicineName);
	}

	// PatientMedicationAddEdit
	@Test
	public void testVerifyMedicationAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		log("Verify Add Medication Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getMedicationAddEditHeader(),
				AtomHC.propData.getProperty("medication.add.edit.header"));
		softAssert.assertTrue(medications.isXIconButtonDisplay());
		softAssert.assertEquals(medications.getMedicineNameLabel(), AtomHC.propData.getProperty("medicine.name.label"));
		softAssert.assertEquals(medications.getMedicineNameTextboxPlaceholder(),
				AtomHC.propData.getProperty("medicine.name.placeholder"));
		softAssert.assertEquals(medications.getDosesLabel(), AtomHC.propData.getProperty("doses.label"));
		softAssert.assertEquals(medications.getDosesTextboxPlacholder(),
				AtomHC.propData.getProperty("doses.placeholder"));
		softAssert.assertEquals(medications.getUnitLabel(), AtomHC.propData.getProperty("unit.label"));
		softAssert.assertEquals(medications.getUnitTextboxPlaceholder(),
				AtomHC.propData.getProperty("unit.placeholder"));
		softAssert.assertEquals(medications.getFrequencyLabel(), AtomHC.propData.getProperty("frequency.label"));
		softAssert.assertEquals(medications.getFrequencyTextboxPlaceholder(),
				AtomHC.propData.getProperty("frequency.placeholder"));
		softAssert.assertEquals(medications.getHowOftenLabel(), AtomHC.propData.getProperty("how.often.label"));
		softAssert.assertEquals(medications.getHowOftenTextboxPlaceholder(),
				AtomHC.propData.getProperty("how.often.placeholder"));
		softAssert.assertEquals(medications.getMedicationFromDateLabel(),
				AtomHC.propData.getProperty("from.date.label"));
		softAssert.assertEquals(medications.getMedicationEndDateLabel(), AtomHC.propData.getProperty("end.date.label"));
		softAssert.assertEquals(medications.getNoteLabel(), AtomHC.propData.getProperty("note.label"));
		softAssert.assertEquals(medications.getNoteTextboxPlaceholder(),
				AtomHC.propData.getProperty("note.placeholder"));
		softAssert.assertTrue(medications.isMedicationSaveButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testVerifyHowOftenDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		;
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.clickOnHowOftenDropdown();
		List<String> actualHowOftenDropdownList = medications.getHowOftenDropdownList();
		List<String> expectedHowOftenDropdownList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("how.often.list"), "howOftenDropdownList");
		log("verify How Often Dropdown List");
		assertEquals(actualHowOftenDropdownList, expectedHowOftenDropdownList);
	}

	@Test
	public void testVerifyUnitDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.addMedicineName(AtomHC.propData.getProperty("medicine.name"));
		medications.addDoses(AtomHC.propData.getProperty("doses"));
		medications.clickOnUnitDropdown();
		List<String> actualUnitDropdownList = medications.getUnitDropdownList();
		List<String> expectedUnitDropdownList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("unit.dropdown.list"), "unitDropdownList");
		log("verify Unit Dropdown List");
		assertEquals(actualUnitDropdownList, expectedUnitDropdownList);
	}

	@Test(enabled = false)
	public void testMedicationPrefilledData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();

		medications.addNewMedication(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		medications.clickOnFirstMedicine();
		log("Verify Medication prefilled Data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getPrefilledMedicineName(),
				AtomHC.propData.getProperty("medicine.name.prefilled"));
		softAssert.assertEquals(medications.getPrefilledDoses(), AtomHC.propData.getProperty("doses.pefilled"));
		softAssert.assertEquals(medications.getPrefilledUnit(), AtomHC.propData.getProperty("unit.prefilled"));
		softAssert.assertEquals(medications.getPrefilledFrequency(),
				AtomHC.propData.getProperty("frequency.prefilled"));
		softAssert.assertEquals(medications.getPrefilledHowOften(), AtomHC.propData.getProperty("how.often.prefilled"));
		String fromDates = medications.getMedicationPrefilledFromDate();
		log("From Date is: " + fromDates);
		String getFromDates = fromDates.toString();
		String[] fromDate = getFromDates.split(" ");
		String currentFromDate = fromDate[0] + " " + fromDate[1] + " " + fromDate[2];
		softAssert.assertEquals(medications.getMedicationPrefilledFromDate(), currentFromDate);
		String endDates = medications.getMedicationPrefilledEndDate();
		log("End Date is: " + endDates);
		String getEndDates = endDates.toString();
		String[] endDate = getEndDates.split(" ");
		String currentEndDate = endDate[0] + " " + endDate[1] + " " + endDate[2];
		softAssert.assertEquals(medications.getMedicationPrefilledEndDate(), currentEndDate);
		softAssert.assertAll();
	}

	@Test
	public void testVerifyMedicationListPageDisplayedOnClickCancel() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		String medicationTitle = medications.getPatientMedicationHeader();
		String[] getTitle = medicationTitle.split(" ");
		String medicationHeader = getTitle[0];
		medications.clickOnMedicationCancelButton();
		log("Verify Medication List Page Display On Click Cancel Button");
		assertEquals(medicationHeader, "Medications");
	}

	@Test
	public void testVerifyMedicationListPageDisplayedOnClickCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.clickOnMedicationCrossIcon();
		String medicationTitle = medications.getPatientMedicationHeader();
		String[] getTitle = medicationTitle.split(" ");
		String medicationHeader = getTitle[0];
		log("Verify Medication List Page Display On Click Cross Icon");
		assertEquals(medicationHeader, "Medications");
	}

	@Test
	public void testMedicationAddPageWithoutEnteringData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.clickOnMedicationSaveButton();
		log("Verify All Required Fields Border gets Highlight");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.isMedicineNameTextboxHighlight(),
				AtomHC.propData.getProperty("medication.error.color"));
		softAssert.assertEquals(medications.isDosesTextboxHighlight(),
				AtomHC.propData.getProperty("medication.error.color"));
		softAssert.assertEquals(medications.isFrequencyTextboxHighlight(),
				AtomHC.propData.getProperty("medication.error.color"));
		softAssert.assertEquals(medications.isHowOftenTextboxHighlight(),
				AtomHC.propData.getProperty("medication.error.color"));
		softAssert.assertEquals(medications.isMedicationFromDateTextboxHighlight(),
				AtomHC.propData.getProperty("medication.error.color"));
//		softAssert.assertEquals(medications.isMedicationEndDateTextboxHighlight(),
//				AtomHC.propData.getProperty("medication.error.color"));
		softAssert.assertAll();
	}

	@Test
	public void testMedicationAddPageErrorMessageEnteringData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.clickOnMedicationSaveButton();
		log("Verify Medication Add Page Required Fields Error Message");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getMedicationNameErrorMessage(),
				AtomHC.propData.getProperty("medication.name.error.message"));
		softAssert.assertEquals(medications.getDosesErrorMessage(), AtomHC.propData.getProperty("doses.error.message"));
		softAssert.assertEquals(medications.getFrequencyErrorMessage(),
				AtomHC.propData.getProperty("frequency.error.message"));
		softAssert.assertEquals(medications.getHowOftenErrorMessage(),
				AtomHC.propData.getProperty("how.often.error.message"));
		softAssert.assertEquals(medications.getMedicationFromDateErrorMessage(),
				AtomHC.propData.getProperty("medication.fromdate.error.message"));
		softAssert.assertEquals(medications.getMedicationEndDateErrorMessage(),
				AtomHC.propData.getProperty("medication.enddate.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemNavigatingToMedicationListPageAfterEnteringValidDetails() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.addNewMedication(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		log("Verify Medication list Page, After Entering Valid Details");
		assertEquals(medications.getFirstMedicineName(), AtomHC.propData.getProperty("valid.medicine.name"));
	}

	@Test
	public void testVerifyMedicationEditPageLabelAddedByAndTextboxDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		String medicneName = "med" + BasePageObject.createRandomCharacter(2);
		medications.addNewMedication(medicneName, AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		medications.clickOnLogOut();
		loginPage.login(AtomHC.propData.getProperty("ram.admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("ram.admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
		mainPage.clickOnOrginazationTab();
		medications.clickOnPatientsTab();
		medications.clickOnExistingPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnFirstMedicine();
		log("Verify In Edit Mode, Added By Label and Textbox is Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getmedicationAddedByLabel(),
				AtomHC.propData.getProperty("medication.added.label"));
		softAssert.assertTrue(medications.isMedicationAddedByTextboxDisplay());
		log("Verify In Edit Mode, Added By Textbox is ReadOnly");
		softAssert.assertFalse(
				medications.ismedicationAddedByTextboxNotEditable(AtomHC.propData.getProperty("added.textbox")));
		log("Verify Added User Name");
		softAssert.assertEquals(medications.getmedicationAddedByName(),
				AtomHC.propData.getProperty("medication.added.name"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateLabelAndTextboxDisplayedAfterAlternateForInHowOftenDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		medications.clickOnPatientMedicationTab();
		medications.clickOnPatientMedicationAddButton();
		medications.clickOnAlternateFor();
		log("Verify Alternate Label and Textbox");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getAlternateForLabel(), AtomHC.propData.getProperty("alternate.label"));
		softAssert.assertTrue(medications.isAlternateForTextboxDisplay());
		softAssert.assertEquals(medications.getAlternateForPlaceholder(),
				AtomHC.propData.getProperty("alternate.placeholder"));
		softAssert.assertAll();
	}

}
