package com.atom.healthcare.Patient.Test;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Dsahboard.Dashboard;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.Users.UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.Log4jUtil;
import com.atom.healthcare.util.YopMail;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientTest extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("user.email"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Patient list
	@Test
	public void testUserOnPatientListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		log("verify patient list page field");
		String patientHeader = patientPage.getPatientListPageTitle();
		String[] getTitle = patientHeader.split(" ");
		String patientTitle = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientTitle, "Patients");
		softAssert.assertTrue(patientPage.isPatientSearchBoxDisplay());
		softAssert.assertTrue(patientPage.isPatientSearchIconDisplay());
		softAssert.assertEquals(patientPage.getPatientListSearchPlaceholderText(),
				AtomHC.propData.getProperty("placeholder"));
		softAssert.assertEquals(patientPage.getAddButtonText(), AtomHC.propData.getProperty("add.button.caption"));
		softAssert.assertAll();
	}

	@Test//it is failing because it has &nbsp
	public void testSystemDisplayNoRecordFoundMessageOnPatientListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		log("verify system Display no record found message");
		patientPage.enterTextInPatientsSearchBox(AtomHC.propData.getProperty("invalid.patient.data"));
		assertEquals(patientPage.getNoRecordFoundMessage(),
				AtomHC.propData.getProperty("patient.list.no.record.found"));
	}

	@Test
	public void testPatientAlreadyAddedInPatientListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		log("verify System should display Patient list");
		assertTrue(patientPage.displayFullPatientList());
	}

	@Test
	public void testCreatedNewPatientCardDetails() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify User Added new patient for check the card details");
		patientPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.propData.getProperty("patient.image"));
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(patientPage.isPatientProfileDisplay());
		softAssert.assertEquals(patientPage.getPatientNameInCardDetailsFormat(),
				AtomHC.propData.getProperty("patient.name.in.detail.card"));
		softAssert.assertEquals(patientPage.getPatientAgeAndGenderInCardDetailsFormat(),
				AtomHC.propData.getProperty("patient.age.&.gender.in.detail.card"));
		softAssert.assertTrue(patientPage.getPatientMobileNoInCardDetailsFormat());
		softAssert.assertTrue(patientPage.isPatientEmailInCardDetailsDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testCreatedNewPatientWithoutProfileImage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify User Added new patient for check the card details");
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		log("Verify if user not Added profile image");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(patientPage.isPatientProfileIsNotAdded());
		softAssert.assertEquals(patientPage.getPatientNameInCardDetailsFormat(),
				AtomHC.propData.getProperty("patient.name.in.detail.card"));
		softAssert.assertEquals(patientPage.getPatientAgeAndGenderInCardDetailsFormat(),
				AtomHC.propData.getProperty("patient.age.&.gender.in.detail.card"));
		softAssert.assertTrue(patientPage.getPatientMobileNoInCardDetailsFormat());
		softAssert.assertTrue(patientPage.getPatientEmailInCardDetailsFormat());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserEnterInputInPatientSearboxInList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patientPage.clickOnSearchbox();
		log("Verify if user enter the input in searchbox");
		SoftAssert softAssert = new SoftAssert();
		patientPage.enterTextInPatientsSearchBox(
				AtomHC.propData.getProperty("patient.fname") + " " + AtomHC.propData.getProperty("patient.lname"));
		softAssert.assertEquals(patientPage.getSearchedPatientName(),
				AtomHC.propData.getProperty("patient.fname") + " " + AtomHC.propData.getProperty("patient.lname"));
		patientPage.clearSearchTextbox();
		patientPage.enterTextInPatientsSearchBox(AtomHC.propData.getProperty("patient.search.age"));
		softAssert.assertEquals(patientPage.getSearchedPatientAgeAndGender(),
				AtomHC.propData.getProperty("display.searched.patient.age"));
		patientPage.clearSearchTextbox();
		patientPage.enterTextInPatientsSearchBox(AtomHC.propData.getProperty("patient.search.gender"));
		softAssert.assertEquals(patientPage.getSearchedPatientAgeAndGender(),
				AtomHC.propData.getProperty("display.searched.patient.gender"));
		patientPage.clearSearchTextbox();
		patientPage.enterTextInPatientsSearchBox(AtomHC.mobileNum);
		softAssert.assertEquals(patientPage.getSearchedPatientMobileNo(), "+91-"+AtomHC.mobileNum);
		patientPage.clearSearchTextbox();
		patientPage.enterTextInPatientsSearchBox(AtomHC.email);
		softAssert.assertEquals(patientPage.getSearchedPatientEmail(), AtomHC.email);
		patientPage.clearSearchTextbox();
		softAssert.assertTrue(patientPage.displayFullPatientList());
		softAssert.assertAll();
	}

	// Add/Edit Page
	@Test
	public void testUserPatientAddEditPageField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify Patient Add Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientPage.getAddPageHeadingText(),
				AtomHC.propData.getProperty("patient.add.page.title"));
		softAssert.assertEquals(patientPage.getAddPageHeadingText(),
				AtomHC.propData.getProperty("patient.add.page.title"));
		softAssert.assertEquals(patientPage.getSaveButtonCaption(), AtomHC.propData.getProperty("save.button.caption"));
		softAssert.assertEquals(patientPage.getCancelButtonCaption(), AtomHC.propData.getProperty("cancel.button"));
		softAssert.assertEquals(patientPage.getBasicInformationHeading(), AtomHC.propData.getProperty("heading"));
		softAssert.assertEquals(patientPage.getProfileImageLabel(),
				AtomHC.propData.getProperty("patient.Profile.Image.label"));
		softAssert.assertEquals(patientPage.getFNameLabel(), AtomHC.propData.getProperty("patient.fname.label"));
		softAssert.assertTrue(patientPage.isFNameTextboxDisplay());
		softAssert.assertEquals(patientPage.getFNamePlaceholder(), AtomHC.propData.getProperty("fname.placeholder"));
		softAssert.assertEquals(patientPage.getLNameLabel(), AtomHC.propData.getProperty("patient.lname.label"));
		softAssert.assertTrue(patientPage.isLNameTextboxDisplay());
		softAssert.assertEquals(patientPage.getLNamePlaceholder(), AtomHC.propData.getProperty("lname.placeholder"));
		softAssert.assertEquals(patientPage.getGenderLabel(), AtomHC.propData.getProperty("patient.gender.label"));
		softAssert.assertTrue(patientPage.isGenderDropdownDisplay());
		softAssert.assertEquals(patientPage.getGenderPlaceholder(), AtomHC.propData.getProperty("gender.placeholder"));
		softAssert.assertEquals(patientPage.getDOBLabel(), AtomHC.propData.getProperty("patient.dob.label"));
		softAssert.assertTrue(patientPage.isDOBCalenderControlDisplay());
		softAssert.assertEquals(patientPage.getBloodGroupLabel(),
				AtomHC.propData.getProperty("patient.bloodgroup.label"));
		softAssert.assertTrue(patientPage.isBloodGroupDropdownDisplay());
		softAssert.assertEquals(patientPage.getBloodGroupPlaceholder(),
				AtomHC.propData.getProperty("bloodgroup.placeholder"));
		softAssert.assertEquals(patientPage.getPreferredLangLabel(),
				AtomHC.propData.getProperty("patient.preferred.lang.label"));
		softAssert.assertTrue(patientPage.isPreferredLangDropdownDisplay());
		softAssert.assertEquals(patientPage.getPreferredLangDropdownPlaceholder(),
				AtomHC.propData.getProperty("preferred.lang.placeholder"));
		softAssert.assertEquals(patientPage.getSocialSecurityNoLabel(),
				AtomHC.propData.getProperty("patient.social.social.no.label"));
		softAssert.assertTrue(patientPage.isSocialSecurityNoTextboxDisplay());
		softAssert.assertEquals(patientPage.getSocialSecurityNoTextboxPlaceholder(),
				AtomHC.propData.getProperty("social.social.no.textbox"));
		softAssert.assertEquals(patientPage.getInternalCodeLabel(),
				AtomHC.propData.getProperty("patient.internal.code.label"));
		softAssert.assertTrue(patientPage.isInternalCodeTextboxDisplay());
		softAssert.assertEquals(patientPage.getInternalCodeTextboxPlaceholder(),
				AtomHC.propData.getProperty("internal.code.placeholder"));
		softAssert.assertEquals(patientPage.getExternalCodeLabel(),
				AtomHC.propData.getProperty("patient.external.code.label"));
		softAssert.assertTrue(patientPage.isExternalCodeTextboxDisplay());
		softAssert.assertEquals(patientPage.getExternalCodeTextboxPlaceholder(),
				AtomHC.propData.getProperty("external.code.placeholder"));
		softAssert.assertEquals(patientPage.getMobileNumberLabel(),
				AtomHC.propData.getProperty("patient.mobile.number.label"));
		softAssert.assertTrue(patientPage.isMobileNumberTextboxDisplay());
		softAssert.assertEquals(patientPage.getMobileNumberTextboxPlaceholder(),
				AtomHC.propData.getProperty("mobile.number.placeholder"));
		softAssert.assertEquals(patientPage.getEmailLabel(), AtomHC.propData.getProperty("patient.email.label"));
		softAssert.assertTrue(patientPage.isEmailTextboxDisplay());
		softAssert.assertEquals(patientPage.getEmailTextboxPlaceholder(),
				AtomHC.propData.getProperty("email.placeholder"));
		softAssert.assertAll();
	}

	@Test
	public void testGenderDropdownListFromPatientAddEdit() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.clickOnGenderDropdownValue();
		List<String> actualDefaultGenderList = patientPage.getGenderList();
		List<String> expectedDefaultGenderList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.gender.dropdown.list"), "usersGenderDropdownList");
		assertEquals(actualDefaultGenderList, expectedDefaultGenderList);
	}

	@Test
	public void testBloodGroupDropdownListFromPatientAddEdit() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.clickOnBloodGroupDropdownValue();
		List<String> actualDefaultBloodGroupList = patientPage.getBloodGroupList();
		List<String> expectedDefaultBloodGroupList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.blood.group.dropdown.list"), "bloodGroupList");
		assertEquals(actualDefaultBloodGroupList, expectedDefaultBloodGroupList);
	}

	@Test(enabled=false)
	public void testPreferredLangDropdownListFromPatientAddEdit() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.clickOnPreferredLangDropdownValue();
		List<String> actualDefaultLangList = patientPage.getPreferredLangList();
		List<String> expectedDefaultLangList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.preferred.lang"), "selectLanguageDropdownList");
		assertEquals(actualDefaultLangList, expectedDefaultLangList);
	}

	@Test
	public void testPatientDemographicsDetailsPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		log("verfiy after click on any card in patient list page");
		patientPage.clickOnAnyCardInPatientList();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(patientPage.isOverViewTabDisplay());
		log("verify after clicking on demographics tab in added patient card");
		patientPage.clickOnDemographicsTab();
		softAssert.assertTrue(patientPage.isSelctedPatientHeadingDisplay());
		softAssert.assertEquals(patientPage.getDemographicsCancelButtonCaption(),
				AtomHC.propData.getProperty("demographics.cancel.button.caption"));
		softAssert.assertEquals(patientPage.getResendActivationButtonCaption(),
				AtomHC.propData.getProperty("demographics.resendactivation.button.caption"));
		softAssert.assertEquals(patientPage.getDemographicsDeleteButtonCaption(),
				AtomHC.propData.getProperty("demographics.delete.button.caption"));
		softAssert.assertFalse(patientPage.isPatientProfileImageDisplay(
				AtomHC.propData.getProperty("patient.name") + " " + AtomHC.propData.getProperty("patient.lname")));
		softAssert.assertTrue(patientPage.isProfileDisplay(
				AtomHC.propData.getProperty("patient.name") + " " + AtomHC.propData.getProperty("patient.lname")));
		softAssert.assertEquals(patientPage.getDemographicsPatientName(),
				AtomHC.propData.getProperty("display.patient.name"));
		softAssert.assertEquals(patientPage.getDemographicsPatientAgeGender(),
				AtomHC.propData.getProperty("patient.Age.and.gender.demographics"));
		softAssert.assertEquals(patientPage.getDemographicsPatientEmail(),
				AtomHC.propData.getProperty("added.patient.email"));
		softAssert.assertEquals(patientPage.getDemographicsPatientEmailLabel(),
				AtomHC.propData.getProperty("demographics.email.label"));
		softAssert.assertEquals(patientPage.getDemographicsPatientMobileNumberLabel(),
				AtomHC.propData.getProperty("demographics.mobile.no.label"));
		softAssert.assertEquals(patientPage.getDemographicsPatientMobileNo(),
				AtomHC.propData.getProperty("added.patient.mobile.no"));
		softAssert.assertEquals(patientPage.getDemographicsPatientHeightLabel(),
				AtomHC.propData.getProperty("demographics.patient.height.label"));
		softAssert.assertEquals(patientPage.getDemographicsPatientHeight(),
				AtomHC.propData.getProperty("added.patient.height"));
		softAssert.assertEquals(patientPage.getDemographicsPatientBloodgroupLabel(),
				AtomHC.propData.getProperty("demographics.patient.bloodgroup.label"));
		softAssert.assertEquals(patientPage.getDemographicsPatientBloodgroup(),
				AtomHC.propData.getProperty("added.patient.bloodgroup"));
		softAssert.assertEquals(patientPage.getDemographicsPatientWeightLabel(),
				AtomHC.propData.getProperty("demographics.patient.weight.label"));
		softAssert.assertEquals(patientPage.getDemographicsPatientWeight(),
				AtomHC.propData.getProperty("added.patient.weight"));
		log("verify all the tabs display");
		softAssert.assertEquals(patientPage.getOverViewTab(),
				AtomHC.propData.getProperty("patient.overview.tabs.display"));
		softAssert.assertEquals(patientPage.getReadingsTab(),
				AtomHC.propData.getProperty("patient.readings.tabs.display"));
		softAssert.assertEquals(patientPage.getPatientEducationsTab(),
				AtomHC.propData.getProperty("patient.educations.tabs.display"));
		softAssert.assertEquals(patientPage.getPatientTasksTab(),
				AtomHC.propData.getProperty("patient.Tasks.tabs.display"));
		softAssert.assertEquals(patientPage.getChatsTab(), AtomHC.propData.getProperty("patient.chats.tabs.display"));
		softAssert.assertEquals(patientPage.getMedicationsTab(),
				AtomHC.propData.getProperty("patient.medications.tabs.display"));
		softAssert.assertEquals(patientPage.getFilesAndDocumentsTab(),
				AtomHC.propData.getProperty("patient.Files.and.documents.tabs.display"));
		softAssert.assertEquals(patientPage.getPatientAppointmentsTab(),
				AtomHC.propData.getProperty("patient.appointments.tabs.display"));
		softAssert.assertEquals(patientPage.getCaregiversTab(),
				AtomHC.propData.getProperty("patient.cargivers.tabs.display"));
		softAssert.assertEquals(patientPage.getPatientProgramTab(),
				AtomHC.propData.getProperty("patient.programs.tabs.display"));
		softAssert.assertEquals(patientPage.getDemographicsTab(),
				AtomHC.propData.getProperty("patient.demographics.tabs.display"));
		softAssert.assertEquals(patientPage.getContactsTab(),
				AtomHC.propData.getProperty("patient.contacts.tabs.display"));
		patientPage.clickOnDemographicsCancelButton();
		softAssert.assertTrue(patientPage.navigateToPatientListPage());
		patientPage.clickOnAddButtonToFillPatientDetails();
		softAssert.assertAll();
	}

	@Test
	public void testPatientCardPrefilledData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAnyCardInPatientList();
		patientPage.clickOnDemographicsTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientPage.getEditPatientName(),
				AtomHC.propData.getProperty("patient.prefilled.name"));
		softAssert.assertEquals(patientPage.getEditPatientAgeAndGender(),
				AtomHC.propData.getProperty("patient.prefilled.age.gender"));
		softAssert.assertEquals(patientPage.getEditPatientEmail(),
				AtomHC.propData.getProperty("patient.prefilled.email"));
		softAssert.assertEquals(patientPage.getEditPatientMobileNo(),
				AtomHC.propData.getProperty("patient.prefilled.mobile.no"));
		softAssert.assertAll();
	}

	@Test
	public void testUserSelectIncorrectFormatForPatientImage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("User upload incorrect image format");
		patientPage.uploadInvalidFormatProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("patient.invalid.image"));
		assertEquals(patientPage.getIncorrectFormatErrorMsgDisplay(),
				AtomHC.propData.getProperty("patient.invalid.image.format"));
	}

	@Test
	public void testUserSelectIncorrectProfileImageSize() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify after user select incorrect profile image size");
		patientPage.uploadInvalidFormatProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("patient.incorrect.profile.image.size"));
		assertEquals(patientPage.getInvalidImageUploadSizeFormat(),
				AtomHC.propData.getProperty("patient.profile.image.upload.size"));
	}

	@Test
	public void testUserSelectCorrectProfileImage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify Patient Profile Picture If Added");
		patientPage.uploadProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("patient.profile.image"));
		assertTrue(patientPage.isPatientProfileImageDisplay());
	}

	@Test
	public void testPatientsSaveButtonWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.clickOnSaveButton();
		log("Verify when user click on save button without entering any data the all the required field should get highlighted");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientPage.getFirstNameRequiredLabel(),
				AtomHC.propData.getProperty("patient.fname.required"));
		softAssert.assertTrue(patientPage.getFirstNameFieldHighlighted());
		softAssert.assertEquals(patientPage.getLastNameRequiredLabel(),
				AtomHC.propData.getProperty("patient.lname.required"));
		softAssert.assertTrue(patientPage.getLastNameFieldHighlighted());
		softAssert.assertEquals(patientPage.getGenderRequiredLabel(),
				AtomHC.propData.getProperty("patioent.gender.required"));
		softAssert.assertTrue(patientPage.getGenderFieldHighlighted());
		softAssert.assertEquals(patientPage.getDOBRequiredLabel(), AtomHC.propData.getProperty("patient.DOB.required"));
		softAssert.assertTrue(patientPage.getDOBFieldHighlighted());
		softAssert.assertEquals(patientPage.getPreferredLangRequiredLabel(),
				AtomHC.propData.getProperty("patient.preferred.lang.required"));
		softAssert.assertTrue(patientPage.getPreferredLangFieldHighlighted());
		softAssert.assertEquals(patientPage.getMobileNoRequiredLabel(),
				AtomHC.propData.getProperty("patient.mobile.no.required"));
		softAssert.assertTrue(patientPage.getMobileNoFieldHighlighted());
		softAssert.assertEquals(patientPage.getEmailRequiredLabel(),
				AtomHC.propData.getProperty("patient.email.required"));
		softAssert.assertTrue(patientPage.getEmailFieldHighlighted());
		softAssert.assertAll();
	}

	@Test
	public void testLastNameFieldWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.blank.field"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patientPage.clickOnSaveButton();
		log("verify if user not enter last name field and click on save button");
		assertEquals(patientPage.getLastNameRequiredLabel(), AtomHC.propData.getProperty("patient.lname.required"));
	}

	@Test
	public void testPatientMobileNoAndEmailText() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Verify mobile number and email field on patient page");
		SoftAssert softAssert = new SoftAssert();
		patientPage.wrongMobileNoAndEmail(AtomHC.propData.getProperty("patient.invalid.mobile.no"),
				AtomHC.propData.getProperty("patient.invalid.email"));
		softAssert.assertEquals(patientPage.getMobileNoErrorMessage(),
				AtomHC.propData.getProperty("patient.mobile.no.invalid.error.message"));
		softAssert.assertEquals(patientPage.getEmailErrorMessage(),
				AtomHC.propData.getProperty("patient.email.range.error.message"));
		patientPage.clearEmailTextbox();
		patientPage.fillAgainEmailFiled(AtomHC.propData.getProperty("patient.invalid.data.email"));
		softAssert.assertEquals(patientPage.getEmailErrorMessageDataInvalid(),
				AtomHC.propData.getProperty("patient.invalid.data"));
		softAssert.assertAll();
	}

	@Test
	public void testPatientDemographicsPrefilledData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAnyCardInPatientList();
		patientPage.clickOnDemographicsTab();
		log("verify demographics prefilled data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(patientPage.getPatientDemographicesFName(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.fname"));
		softAssert.assertEquals(patientPage.getPatientDemographicesLName(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.lname"));
//		softAssert.assertEquals(patientPage.getPatientDemographicsPatientDOB(),
//				AtomHC.propData.getProperty("patient.demographics.prefilled.dob"));
		softAssert.assertEquals(patientPage.getPatientDemographicsPatientGender(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.gender"));
		softAssert.assertEquals(patientPage.getPatientDemographicsPatientBloodGroup(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.blood.group"));
		softAssert.assertEquals(patientPage.getPatientDemographicsPatientPreferredLang(),
				AtomHC.propData.getProperty("patient.lang.preferance"));
		softAssert.assertEquals(patientPage.getPatientDemographicsPatientEmail(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.email"));
		softAssert.assertEquals(patientPage.getPatientDemographicsPatientPhoneNo(),
				AtomHC.propData.getProperty("patient.demographics.prefilled.phone.no"));
		softAssert.assertAll();
	}

	@Test
	public void testPatientDeleteButtonFunctionality() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnFirstPatient();
		log("Verify delete button functionality");
		SoftAssert softAssert = new SoftAssert();
		patientPage.clickOnDeleteButtonInPatient();
		softAssert.assertEquals(patientPage.getDeletePoPUpMessage(),
				AtomHC.propData.getProperty("patient.delete.pop.up.message"));
		softAssert.assertTrue(patientPage.isXIconButtonDisplay());
		softAssert.assertEquals(patientPage.getEditPageCancelButtonCaption(),
				AtomHC.propData.getProperty("patient.program.edit.mode.cancel.button.caption"));
		softAssert.assertEquals(patientPage.isOKButtonDisplay(),
				AtomHC.propData.getProperty("patient.program.edit.mode.ok.button.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testPatientClickOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnFirstPatient();
		patientPage.clickOnDeleteButtonInPatient();
		log("Verify if user click on cancel button");
		patientPage.clickOnCancelButtonInPatientEditPage();
		assertTrue(patientPage.isOverViewTabDisplay());
	}

	@Test
	public void testPatientClickOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnFirstPatient();
		patientPage.clickOnDeleteButtonInPatient();
		log("Verify if user click on ok button and patient should be deleted");
		patientPage.clickOnOkButton();
		assertTrue(patientPage.displayFullPatientList());
	}

	@Test
	public void testPatientClickOnResendActivationButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		log("Verify if user click on resend activation button");
		YopMail yopMail = new YopMail(driver);
		log(AtomHC.propData.getProperty("user.creat.link.subject") + title);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject"), 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		assertFalse(registrationLink.isEmpty());
	}
	
}
