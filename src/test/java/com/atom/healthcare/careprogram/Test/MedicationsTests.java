package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Medications;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class MedicationsTests extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;
	static String programName= "Dieting Plan";

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("u.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("u.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// ProgramMedication Add/Edit
	@Test(priority = 1)
	public void testMedicationPageFieldsWhenUserClickOnMedicationAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.CreateNewProgram();	
		log("programName  "+programName);
		medications.enterProgramName(programName);
		medications.clickOnProgramSaveButton();
		medications.clickOnNewCreatedProgram(programName);
		medications.clickOnMedicationAddButton();
		log("verifywhen user click on Add button its navigated to Medication AddEdit page Field");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getMedicationAddEditHeader(),
				AtomHC.propData.getProperty("medication.add.edit.header"));
		softAssert.assertEquals(medications.getMedicationAddEditMedicineNameLabel(),
				AtomHC.propData.getProperty("medicine.name.label"));
		softAssert.assertTrue(medications.isMedicationAddEditMedicineNameTextboxDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditDosesLabel(),
				AtomHC.propData.getProperty("doses.label"));
		softAssert.assertTrue(medications.isMedicationAddEditDosesTextboxDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditUnitLabel(), AtomHC.propData.getProperty("unit.label"));
		softAssert.assertTrue(medications.isMedicationAddEditUnitDropdownDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditFrequencyLabel(),
				AtomHC.propData.getProperty("frequency.label"));
		softAssert.assertTrue(medications.isMedicationAddEditFrequencyTextboxDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditHowOftenLabel(),
				AtomHC.propData.getProperty("how.often.label"));
		softAssert.assertTrue(medications.isMedicationAddEditHowOftenDropdownDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditAssignForDayLabel(),
				AtomHC.propData.getProperty("assign.after.day.label"));
		softAssert.assertTrue(medications.isMedicationAddEditAssignForDayTextboxDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditShowForDayLabel(),
				AtomHC.propData.getProperty("show.after.day.label"));
		softAssert.assertTrue(medications.isMedicationAddEditShowForDayTextboxDisplay());
		softAssert.assertEquals(medications.getMedicationAddEditNoteLabel(), AtomHC.propData.getProperty("note.label"));
		softAssert.assertTrue(medications.isMedicationAddEditNoteTextboxDisplay());
		softAssert.assertTrue(medications.isMedicationAddEditSaveButtonDisplay());
		softAssert.assertTrue(medications.isMedicationAddEditCancelButtonDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testMedicationEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		AtomHC.medicationName = "Tablet" + BasePageObject.createRandomCharacter(2);
		log("Appointment Subject-- " + AtomHC.medicationName);
		medications.enterTextInMedicationSearchTextbox(AtomHC.medicationName);
		medications.clcikOnSearchIconInMedicationName();
		medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.number"));
		medications.isMedicationFrequencyField(AtomHC.propData.getProperty("medication.doses.number"));
		medications.clickOnMedicationAddEditUnitDropdown();
		medications.selectUnitDropdownTabletselect();
		medications.clickOnMedicationAddEditDosesTextbox();
		medications.clickOnMedicationAddEditHowOftenDropdown();
		medications.selectProgramMedicationDailyDropdownLabel();
		medications
				.isMedicationAddEditAssignForDayTextbox(AtomHC.propData.getProperty("medication.assign.for.day.min"));
		medications.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("medication.assign.for.day.max"));
		medications.clickOnProgramSaveButton();
		medications.addMedicationName(AtomHC.medicationName);
		log("verify In edit mode Delete Save And Cancel button should display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(medications.isMedicationAddEditDeleteButtonDisplay());
		softAssert.assertTrue(medications.isMedicationAddEditSaveButtonDisplay());
		softAssert.assertTrue(medications.isMedicationAddEditCancelButtonDisplay());
		softAssert.assertAll();

	}

	@Test
	public void testMedicationNameTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In Medication Name TextChange enter special character");
		medications
				.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.special.character"));
		log("verify In Medication Name TextChange enter Space");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.space"));
		log("verify In Medication Name TextChange enter Number");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.number"));
		medications.clickOnMedicationNameTextbox();
		medications.clearTextInMedicationSearchTextbox();
		log("verify In Medication Name TextChange enter Alphabet");
		String Tablet = "Tablet" + BasePageObject.createRandomCharacter(2);
		medications.enterTextInMedicationSearchTextbox(Tablet);
		medications.clcikOnSearchIconInMedicationName();
		medications.clickOnMedicationAddEditUnitDropdown();
		medications.selectUnitDropdownTabletselect();
		medications.clickOnMedicationAddEditFrequencyTextbox();
		assertTrue(medications.isMedicationUnitTabletLabel());

	}

	@Test
	public void testInMedicationNameTextAutomaticallyCalculateTheUnit() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In Medication Name TextChange enter special character");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.special.character"));
		medications.clickOnMedicationNameTextbox();
		medications.clearTextInMedicationSearchTextbox();
		log("verify In Medication Name TextChange enter Space");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.space"));
		medications.clickOnMedicationNameTextbox();
		medications.clearTextInMedicationSearchTextbox();
		log("verify In Medication Name TextChange enter Number");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.doses.number"));
		medications.clickOnMedicationNameTextbox();
		medications.clearTextInMedicationSearchTextbox();
		log("verify In Medication Name Text Change enter alphabets automatically calculate the Unit");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.name.sendkey"));
		medications.clickOnMedicationAddEditDosesTextbox();
		assertTrue(medications.isMedicationUnitTabletLabel());
	}

	@Test
	public void testInDosesFieldTextChange() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In Doses field validation");
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.name.sendkey"));
		medications.clickOnMedicationAddEditDosesTextbox();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.special.character")));
		softAssert.assertTrue(medications.isMedicationDosesField(AtomHC.propData.getProperty("added.textbox")));
		softAssert
				.assertTrue(medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.space")));
		softAssert
				.assertTrue(medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.number")));
		medications.clickOnMedicationAddEditFrequencyTextbox();
		softAssert.assertAll();

	}

	@Test
	public void testInFrequencyFieldTextChangetestInFrequencyFieldTextChange() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In Frequency Field validation");
		SoftAssert softAssert = new SoftAssert();
		medications.enterTextInMedicationSearchTextbox(AtomHC.propData.getProperty("medication.name.sendkey"));
		medications.clickOnMedicationAddEditDosesTextbox();
		softAssert
				.assertTrue(medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.number")));
		medications.clickOnMedicationAddEditFrequencyTextbox();
		softAssert.assertTrue(medications
				.isMedicationFrequencyField(AtomHC.propData.getProperty("medication.doses.special.character")));
		softAssert.assertTrue(medications.isMedicationFrequencyField(AtomHC.propData.getProperty("added.textbox")));
		softAssert.assertTrue(
				medications.isMedicationFrequencyField(AtomHC.propData.getProperty("medication.doses.space")));
		softAssert.assertTrue(
				medications.isMedicationFrequencyField(AtomHC.propData.getProperty("medication.doses.number")));
		medications.clickOnMedicationAddEditHowOftenDropdown();
		softAssert.assertAll();
	}

	@Test
	public void testInSelectDropdownValueAlternateForField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		medications.clickOnMedicationAddButton();
		medications.clickOnMedicationAddEditHowOftenDropdown();
		medications.clickOnMedicationAddEditAlternateFor();
		log("verify In Medication Name Text Change automatically calculate the Unit");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getMedicationAddEditAlternateForLabel(),
				AtomHC.propData.getProperty("medication.alternate.for.label"));
		softAssert.assertTrue(medications.isMedicationAddEditAlternateForTextbox());
		softAssert.assertAll();

	}

	@Test
	public void testInSelectDropdownValueAlternateForMinCharValidation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		medications.clickOnMedicationAddEditHowOftenDropdown();
		medications.clickOnMedicationAddEditAlternateFor();
		log("Select Dropdown Value Alternate For verify field Validation");
		medications
				.sendMedicationAddEditAlternateForTextboxd(AtomHC.propData.getProperty("medication.alternate.for.min"));
		assertEquals(medications.getMedicationAddEditAlternateForErrorMessage(),
				AtomHC.propData.getProperty("medication.alternate.for.error.message"));

	}

	@Test
	public void testInSelectDropdownValueAlternateForMaxCharValidation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		medications.clickOnMedicationAddEditHowOftenDropdown();
		medications.clickOnMedicationAddEditAlternateFor();
		log("Select Dropdown Value Alternate For verify field Validation");
		medications
				.sendMedicationAddEditAlternateForTextboxd(AtomHC.propData.getProperty("medication.alternate.for.max"));
		assertEquals(medications.getMedicationAddEditAlternateForErrorMessage(),
				AtomHC.propData.getProperty("medication.alternate.for.error.message"));

	}

	@Test
	public void testInAssignForDayFieldTextChange() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In Assign For Day Field validation");
		medications.clickOnMedicationAddEditAssignForDay();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(medications.isMedicationAddEditAssignForDayTextbox(
				AtomHC.propData.getProperty("medication.doses.special.character")));
		softAssert.assertTrue(
				medications.isMedicationAddEditAssignForDayTextbox(AtomHC.propData.getProperty("added.textbox")));
		assertTrue(medications
				.isMedicationAddEditAssignForDayTextbox(AtomHC.propData.getProperty("medication.doses.space")));
		softAssert.assertTrue(medications
				.isMedicationAddEditAssignForDayTextbox(AtomHC.propData.getProperty("medication.assign.for.day.max")));
		softAssert.assertEquals(medications.getMedicationAddEditAssignForErrorMessage(),
				AtomHC.propData.getProperty("error.msg.in.assign.after.days"));
		softAssert.assertAll();

	}

	@Test
	public void testInShowForDayFieldTextChange() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify In show For Day Field validation");
		medications.clickOnMedicationAddEditShowForDay();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(medications.isMedicationAddEditShowForDayTextbox(
				AtomHC.propData.getProperty("medication.doses.special.character")));
		softAssert.assertTrue(
				medications.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("added.textbox")));
		softAssert.assertTrue(medications
				.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("medication.doses.space")));
		softAssert.assertTrue(medications
				.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("medication.alternate.for.min")));
		medications.clearTextInMedicationShowForDayTextbox();
		softAssert.assertTrue(medications
				.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("medication.show.for.day.max")));
		softAssert.assertEquals(medications.getMedicationAddEditShowForErrorMessage(),
				AtomHC.propData.getProperty("error.msg.in.show.for.days"));
		softAssert.assertAll();

	}

	@Test
	public void testClickOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		medications.clickOnMedicationAddEditCancelButton();
		log("verify In show For Day Field validation");
		SoftAssert softAssert = new SoftAssert();
		String title = medications.getMedicationListLabel();
		String[] getTitle = title.split(" ");
		String medicationLabel = getTitle[0];
		softAssert.assertEquals(medicationLabel, "Medications");
		softAssert.assertEquals(medications.getMedicationListLabel(),
				AtomHC.propData.getProperty("medication.list.label"));
		softAssert.assertAll();

	}

	@Test
	public void testClickOnSaveButtonValidateAllData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
//		medications.clickOnProgramMedicationAddButton();
		medications.clickOnMedicationAddEditSaveButton();
		log("verifyIn Medication add button Click on Save button valiated required fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getProgramMedicationMedicineNameErrorLabel(),
				AtomHC.propData.getProperty("medication.name.error.message"));
		softAssert.assertEquals(medications.getProgramMedicationDosesErrorLabel(),
				AtomHC.propData.getProperty("doses.error.message"));
		softAssert.assertEquals(medications.getProgramMedicationFrequencyErrorLabel(),
				AtomHC.propData.getProperty("frequency.error.message"));
		softAssert.assertEquals(medications.getProgramMedicationHowOftenErrorLabel(),
				AtomHC.propData.getProperty("how.often.error.message"));
		softAssert.assertEquals(medications.getProgramMedicationAssignAfterDaysErrorLabel(),
				AtomHC.propData.getProperty("assign.after.days.is.required.error.msg"));
		softAssert.assertEquals(medications.getProgramMedicationShowForDaysErrorLabel(),
				AtomHC.propData.getProperty("show.for.days.is.required.error.msg"));
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void testClickOnSaveButtonItsNagivatedToMedicationListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnMedicationAddButton();
		log("verify Click On Save Button Its Nagivated To Medication List Page");
		AtomHC.medicationName = "Tablet" + BasePageObject.createRandomCharacter(2);
		log("Appointment Subject-- " + AtomHC.medicationName);
		medications.enterTextInMedicationSearchTextbox(AtomHC.medicationName);
		medications.clcikOnSearchIconInMedicationName();
		medications.isMedicationDosesField(AtomHC.propData.getProperty("medication.doses.number"));
		medications.isMedicationFrequencyField(AtomHC.propData.getProperty("medication.doses.number"));
		medications.clickOnMedicationAddEditUnitDropdown();
		medications.selectUnitDropdownTabletselect();
		medications.clickOnMedicationAddEditDosesTextbox();
		medications.clickOnMedicationAddEditHowOftenDropdown();
		medications.selectProgramMedicationDailyDropdownLabel();
		medications
				.isMedicationAddEditAssignForDayTextbox(AtomHC.propData.getProperty("medication.assign.for.day.min"));
		medications.isMedicationAddEditShowForDayTextbox(AtomHC.propData.getProperty("medication.assign.for.day.max"));
		medications.clickOnProgramSaveButton();
		String title = medications.getMedicationListLabel();
		String[] getTitle = title.split(" ");
		String medicationLabel = getTitle[0];
		assertEquals(medicationLabel, "Medications");
	}

	@Test(priority = 2, dependsOnMethods = { "testClickOnSaveButtonItsNagivatedToMedicationListPage" })
	public void testClickOnDeleteButtonPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnProgramMedicationsTab();
		medications.addMedicationName(AtomHC.medicationName);
		medications.clickOnMedicationAddEditDeleteButtonDisplay();
		log("verify Click On Delete Button Its Nagivated To Delete Page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(medications.getProgramMedicationDeleteLabel(),
				AtomHC.propData.getProperty("delete.page.label"));
		softAssert.assertEquals(medications.getAlternateDeleteConfirmationMessage(),
				AtomHC.propData.getProperty("delete.page.confirm.message"));
		softAssert.assertTrue(medications.isAlternateConfirmationCancelButtonDisplayed());
		softAssert.assertEquals(medications.getAlternateConfirmationCancelButtonText(),
				AtomHC.propData.getProperty("cancel.button"));
		softAssert.assertTrue(medications.isAlternateConfirmationOkButtonDisplayed());
		softAssert.assertEquals(medications.getAlternateConfirmationOkButtonText(),
				AtomHC.propData.getProperty("delete.page.ok.label"));
		softAssert.assertAll();
	}

	@Test(priority = 3, dependsOnMethods = { "testClickOnSaveButtonItsNagivatedToMedicationListPage" })
	public void testClickOnDeletePageCancelButtonItsNagivatedToListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnProgramMedicationsTab();
		medications.addMedicationName(AtomHC.medicationName);
		medications.clickOnMedicationAddEditDeleteButtonDisplay();
		medications.clickOnCancelButtonInDeletePage();
		log("verify Click On Cancel Button from delete page Its Nagivated To Medication List Page");
		String title = medications.getMedicationListLabel();
		String[] getTitle = title.split(" ");
		String medicationLabel = getTitle[0];
		assertEquals(medicationLabel, "Medications");
	}

	@Test(priority = 4, dependsOnMethods = { "testClickOnSaveButtonItsNagivatedToMedicationListPage" })
	public void testClickOnDeletePageOkButtonItsNagivatedToListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Medications medications = new Medications(driver);
		medications.clickOnExstingProgram();
		medications.clickOnNewCreatedProgram(programName);
		log("programName  "+programName);
		medications.searchProgramName(programName);
		medications.clickOnProgramMedicationsTab();
		medications.addMedicationName(AtomHC.medicationName);
		medications.clickOnMedicationAddEditDeleteButtonDisplay();
		medications.clickOnOkButtonInDeletePage();
		log("verify Click On ok Button from delete page Its Nagivated To Medication List Page");
		String title = medications.getMedicationListLabel();
		String[] getTitle = title.split(" ");
		String medicationLabel = getTitle[0];
		assertEquals(medicationLabel, "Medications");
	}
}
