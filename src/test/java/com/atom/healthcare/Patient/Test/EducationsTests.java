package com.atom.healthcare.Patient.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.Educations;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class EducationsTests extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("usr"), AtomHC.key.getDecrypt(AtomHC.propData.getProperty("pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Education Dashboard (Patient)
	@Test
	public void testEducationFieldsInPatientOverview() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		educations.enterTextInPatientsSearchBox(AtomHC.propData.getProperty("education.overview.patient"));
		educations.clickOnFirstPatient();
		String patientEducationTitle = educations.getTitleForPatientEducationOverview();
		log("Patient Education Overview Title is: " + patientEducationTitle.substring(0));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(educations.isPatientEducationShowMoreButtonDisplayed());
		softAssert.assertTrue(educations.isEducationTitleDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testPatientEducationListPageAfterUserClicksOnShowMoreButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		educations.clickOnFirstPatient();
		educations.clickOnEducationShowMoreButton();
		log("verify if user navigates to education list page");
		String educationTitle = educations.getTitleForPatientEducationOverview();
		assertEquals(educationTitle, "Educations");
	}

	@Test
	public void testPatientEducationDetailPageAfterUserClicksOnEducationListItem() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		educations.clickOnPatientEducationTab();
		educations.addEducationFromPatientTab(0, 3);
		educations.clickOnEducationCrossTitle();
		educations.clickOnEducationListItemInPatientOverview();
		log("verify if user navigates to education detail page");
		assertEquals(educations.getAssignEducationTitle(), AtomHC.propData.getProperty("assign.education.page.title"));
	}

	@Test
	public void testPatientEducationOverviewForNoRecordView() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		log("Adding new Patients");
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
		log("verify if no record found message is displayed");
		assertEquals(educations.getPatientEducationOverviewNoRecordMessage(),
				AtomHC.propData.getProperty("patient.education.overview.no.record"));
	}

	// Patient Education list page(Need to add education category in master data for
	// the test case)
	@Test(enabled=false)
	public void testPatientEducationTabFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		educations.clickOnPatientEducationTab();
		SoftAssert softAssert = new SoftAssert();
		log("Verify Patient Education ListPage Fields");
		assertEquals(educations.getPatientEducationTabText(), "Educations");
		String educationTitle = educations.getPatientEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0];
		assertEquals(educationHeadernew, "Educations");
		educations.addEducationFromPatientTab(0, 3);
		softAssert.assertTrue(educations.isEducationSearchTextDisplayed());
//		assertEquals(educations.getEducationListSearchPlaceholder(),
//				AtomHC.propData.getProperty("patient.education.search.placeholder"));
		softAssert.assertEquals(educations.getPatientEducationListAddButtoncaption(),
				AtomHC.propData.getProperty("patient.education.add.button"));
		softAssert.assertTrue(educations.isEducationNameDisplayed());
		softAssert.assertTrue(educations.isEducationCategoryNameDisplayed());
		softAssert.assertTrue(educations.isEducationProgramNameDisplayed());
		softAssert.assertAll();
	}

	@Test//space in message (no record found)
	public void testPatientEducationSearchTextboxFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		educations.clickOnPatientEducationTab();
		log("Verify Patient Education Search TextBox Fields");
		educations.sendPatientEducationSearchWord(AtomHC.propData.getProperty("patient.education.valid.search.word"));
		String educationTitle = educations.getPatientEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationHeadernew, "Educations");
		softAssert.assertEquals(educations.getPatientEducationListCountBasedOnSearch(),
				AtomHC.propData.getProperty("patient.education.searched.count"));
		educations.clearEducationSearchTextbox();
		educations.sendPatientEducationSearchWord(AtomHC.propData.getProperty("invalid.searchword"));
		softAssert.assertEquals(educations.getPatientEducationSearchNoRecordMsg(),
				AtomHC.propData.getProperty("patient.education.search.no.record.msg"));
		softAssert.assertAll();
	}

	// Assign Education(Need to add education category in master data for the test
	// case)
	@Test
	public void testVerifyAssignEducationPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		educations.clickOnPatientEducationTab();
		educations.clickOnEducationAddButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify Assign Education Page Fields");
		softAssert.assertEquals(educations.getAssignEducationPageTitle(),
				AtomHC.propData.getProperty("assign.education.page.title"));
		softAssert.assertTrue(educations.isAssignEducationCrossIconDisplayed());
		softAssert.assertEquals(educations.getAssignEducationCategoryLabel(),
				AtomHC.propData.getProperty("assign.education.category"));
		softAssert.assertTrue(educations.isAssignEducationCategoryDropdownDisplayed());
		softAssert.assertEquals(educations.getAssignEducationSelectLabel(),
				AtomHC.propData.getProperty("assign.education.select"));
		softAssert.assertTrue(educations.isAssignEducationSelectDropdownDisplayed());
		softAssert.assertEquals(educations.getAssignEducationCancelButtonCaption(),
				AtomHC.propData.getProperty("assign.education.cancel"));
		softAssert.assertAll();
	}

	@Test
	public void tesUserLandsOnEducationListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		educations.clickOnPatientEducationTab();
		educations.clickOnEducationAddButton();
		educations.clickOnAssignEducationCancelButton();
		log("Verify user lands on Education List Page, after clicking on Cancel Button of Assign Education");
		String educationTitle = educations.getPatientEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0];
		assertEquals(educationHeadernew, "Educations");
	}

	@Test
	public void tesUserLandsOnEducationDetailPageAfterClickingOnPreviewButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();

		patient.clickOnAddButton();
		log("Adding new Patients");
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
		educations.clickOnPatientEducationTab();
		educations.addEducationFromPatientTab(0, 3);
		educations.clickEducationName();
		educations.clickOnAssignEducationPreviewButton();
		log("Verify User Lands On Education Detail Page After Clicking On Preview Button");
		assertTrue(educations.isPreviewPageDisplay());
	}

	@Test
	public void testAssignEducationAssignButtonFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		log("Adding new Patients");
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
		educations.clickOnPatientEducationTab();
		educations.clickOnEducationAddButton();
		educations.clickOnEducationSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify fields when user does not select both the required fields");
		softAssert.assertEquals(educations.getAssignEducationCategoryErrorMsg(),
				AtomHC.propData.getProperty("assign.education.category.error.msg"));
		softAssert.assertEquals(educations.getAssignEducationSelectErrorMsg(),
				AtomHC.propData.getProperty("assign.education.select.error.msg"));
		educations.selectEducationCategory();
		log("Verify fields when user selects only one required field");
		softAssert.assertEquals(educations.getAssignEducationSelectErrorMsg(),
				AtomHC.propData.getProperty("assign.education.select.error.msg"));
		softAssert.assertAll();
	}

	// Education Details
	@Test
	public void testEducationDetailPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		log("Adding new Patients");
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
		educations.clickOnPatientEducationTab();
		educations.addEducationFromPatientTab(0, 3);
		educations.clickEducationName();
		educations.clickOnAssignEducationPreviewButton();
		log("Verify User Lands On Education Detail Page After Clicking On Preview Button");
		assertTrue(educations.isEducationDetailViewDisplayed());
		assertTrue(educations.isEducationDetailPageTitleDisplayed());
		assertTrue(educations.isEducationDetailPageCrossIconDisplayed());
		assertTrue(educations.isEducationDetailTextContentDisplayed());
		assertEquals(educations.getEducatioDetailOkButton(), AtomHC.propData.getProperty("education.detail.ok.button"));
	}

	@Test
	public void testUserLandsOnAssignEducationPageAfterClickingOnPreviewCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		log("Adding new Patients");
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
		educations.clickOnPatientEducationTab();
		educations.addEducationFromPatientTab(0, 3);
		educations.clickEducationName();
		educations.clickOnAssignEducationPreviewButton();
		educations.clickOnEducationDetailPageCrossIcon();
		log("Verify User Lands On Assign Education Page After Clicking On Preview Cross Icon");
		assertEquals(educations.getAssignEducationPageTitle(),
				AtomHC.propData.getProperty("assign.education.page.title"));
	}

	@Test
	public void testUserLandsOnAssignEducationPageAfterClickingOnPreviewOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Educations educations = new Educations(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		log("Adding new Patients");
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
		educations.clickOnPatientEducationTab();
		educations.addEducationFromPatientTab(0, 3);
		educations.clickEducationName();
		educations.clickOnAssignEducationPreviewButton();
		educations.clickOnEducationDetailOkButton();
		log("Verify User Lands On Assign Education Page After Clicking On Preview Ok Button");
		assertEquals(educations.getAssignEducationPageTitle(),
				AtomHC.propData.getProperty("assign.education.page.title"));
	}

}
