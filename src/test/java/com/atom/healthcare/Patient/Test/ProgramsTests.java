package com.atom.healthcare.Patient.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Patients.Programs;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class ProgramsTests extends BaseTest {
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
	// patient program list page

	@Test
	public void testPatientNavigateToProgramTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.selectPatientFromPatientList();
		programs.clickOnPatientProgramTab();
		log("verify when user click on PatientProgram tab");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(programs.getProgramTab(), AtomHC.propData.getProperty("program.tab.name"));
		softAssert.assertEquals(programs.isPatientProgramTabHightlight(),
				AtomHC.propData.getProperty("patient.program.highlight.color"));
		softAssert.assertAll();
	}

	@Test(priority=1)
	public void testPatientProgramListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Add new patient");
		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
				programs.selectProgram(AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(programs.isPatientProgramTabHightlight(),
				AtomHC.propData.getProperty("patient.program.highlight.color"));
		log("verify PatientPrograms list page field");
		String patientProgramsListHeader = programs.getPatientProgramListPageTitle();
		String[] getTitle = patientProgramsListHeader.split(" ");
		String patientProgramListTitle = getTitle[0];
		softAssert.assertEquals(patientProgramListTitle, "Patient");
		softAssert.assertEquals(programs.getPatientProgramSearchBox(),
				AtomHC.propData.getProperty("patient.programs.search.placeholder"));
		softAssert.assertTrue(programs.isPatientProgramSearchIconDisplay());
		softAssert.assertEquals(programs.getPatientProgramAddButton(),
				AtomHC.propData.getProperty("patient.programs.add.button.caption"));
		softAssert.assertTrue(programs.isPatientProgramListDisplay());
		log("verify default program colour");
		softAssert.assertEquals(programs.isDefaultProgramIconDisplay(),
				AtomHC.propData.getProperty("default.patient.program.color"));
		softAssert.assertEquals(programs.getPatientsProgramName(), AtomHC.propData.getProperty("patient.program.name"));
		softAssert.assertEquals(programs.getPatientProgramEnrolledDate(),
				AtomHC.propData.getProperty("program.enrolled.date"));
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testPatientProgramIconColor() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		assertEquals(programs.getPatientProgramColour(), AtomHC.propData.getProperty("get.program.colour"));
	}

	@Test( enabled=false)
	public void testSystemAbleToFilterTextInPatientProgramsSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("Verify when user enter value in searchbox");
		SoftAssert softAssert = new SoftAssert();
		programs.enterValueInProgramSearchBox(AtomHC.propData.getProperty("program.search.box"));
		String patientProgramsListHeader = programs.getPatientProgramListPageTitle();
		String[] getTitle = patientProgramsListHeader.split(" ");
		String patientProgramListTitle = getTitle[0];
		softAssert.assertEquals(patientProgramListTitle, "Patient");
		programs.clearValueInProgramSearchBox();
		softAssert.assertEquals(programs.getPatientProgramSearchBox(),
				AtomHC.propData.getProperty("patient.programs.search.placeholder"));
		softAssert.assertAll();
	}

	@Test(priority=3)
	public void testSystemDisplayNoRecordFoundMsgInPatientProgramListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("Verify when user enter wrong value in search box");
		SoftAssert softAssert = new SoftAssert();
		programs.enterValueInProgramSearchBox(AtomHC.propData.getProperty("invalid.search.patient.program"));
		String patientProgramsListHeader = programs.getPatientProgramListPageTitle();
		String[] getTitle = patientProgramsListHeader.split(" ");
		String patientProgramListTitle = getTitle[0];
		softAssert.assertEquals(patientProgramListTitle, "Programs");
		softAssert.assertEquals(programs.getNoRecordFoundMsgInProgram(),
				AtomHC.propData.getProperty("patient.program"));
		programs.clearValueInProgramSearchBox();
		softAssert.assertEquals(programs.getPatientProgramSearchBox(),
				AtomHC.propData.getProperty("patient.programs.search.placeholder"));
		softAssert.assertAll();
	}

	@Test(priority=4)
	public void testPatientAbleToNavigatProgramAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("verify user able to navigate in patient programs tab add page");
		programs.clickAddButtonInPatientProgramTab();
		assertEquals(programs.getMyProgramsPageTitle(), AtomHC.propData.getProperty("my.programs.page.title"));
	}

	// Patient Program Add Page

	@Test(priority=5)
	public void testMyProgramsAddPageFieldsFromPatientView() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("verify user able to navigate on my programs add/edit page");
		SoftAssert softAssert = new SoftAssert();
		programs.clickAddButtonInPatientProgramTab();
		softAssert.assertEquals(programs.getMyProgramsPageTitle(),
				AtomHC.propData.getProperty("my.programs.page.title"));
		softAssert.assertTrue(programs.isMyProgramsPageXIconDisplay());
		softAssert.assertEquals(programs.getMyProgramsNameLabelText(),
				AtomHC.propData.getProperty("my.programs.name.label"));
		softAssert.assertTrue(programs.isMyProgramsNameDropdownDisplay());
		softAssert.assertEquals(programs.getMyProgramNameTextboxPlaceholder(),
				AtomHC.propData.getProperty("my.program.name.textbox.placeholder"));
		softAssert.assertEquals(programs.getMyProgramsEntryPointLabelText(),
				AtomHC.propData.getProperty("my.program.entry.point.label"));
		softAssert.assertTrue(programs.isMyProgramsEntryPointTextboxDisplay());
		softAssert.assertEquals(programs.isMyProgramNameByDefaultEntryPointDisplay(),
				AtomHC.propData.getProperty("default.entry.point"));
		softAssert.assertEquals(programs.getMyProgramsAddPageSaveButtonCaption(),
				AtomHC.propData.getProperty("my.program.save.button.caption"));
		softAssert.assertEquals(programs.getMyProgramsAddPageCancelButtonCaption(),
				AtomHC.propData.getProperty("my.program.cancel.button.caption"));
		softAssert.assertAll();
	}

	@Test(priority=6,enabled=false)
	public void testMyProgramsAddPageNameDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickAddButtonInPatientProgramTab();
		programs.clickOnNameLabelDropdownInMyPrograms();
		List<String> actualDefaultProgramList = programs.getMyProgramsNameTypeOperationList();
		List<String> expectedDefaultProgramList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "myProgramNameItemList");
		log("Verify my program name operation type list");
		assertEquals(actualDefaultProgramList, expectedDefaultProgramList);
	}

	@Test(priority=7)
	public void testMyProgramsAddPageEntryPointTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickAddButtonInPatientProgramTab();
		log("verify patient click on entry point textbox");
		assertEquals(programs.isMyProgramNameByDefaultEntryPointDisplay(),
				AtomHC.propData.getProperty("default.entry.point"));
		programs.clearEntryPointDefaultValue();
		log("Verify when user tries to enter Alphabet in Entry point text");
		programs.changeEntryPointValueAndEnterChar(AtomHC.propData.getProperty("is.empty.entry.point"));
	}

	@Test(priority=8)
	public void testClickOnSaveButtonWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickAddButtonInPatientProgramTab();
		log("verify without enter any data and click on save button");
		programs.clickOnSaveButtonInMyProgramsPage();
		assertEquals(programs.getNameIsRequiresErrorMsg(), AtomHC.propData.getProperty("name.filed.error.msg"));
	}

	@Test(priority=9,enabled=false)
	public void testUserEnterDuplicateDataClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickAddButtonInPatientProgramTab();
		log("Verify User enter duplicate data in patient Program tab");
		programs.clickOnNameLabelDropdownInMyPrograms();
		programs.clickOnNameDropdownValue();
		programs.clickOnEntryPointTextbox();
		programs.clearEntryPointTextboxValue();
		programs.enterDuplicateEntryPointData(System.getProperty("duplicate.entry.point.data"));
		programs.clickOnSaveButtonInMyProgramsPage();
		assertEquals(programs.getErrorMsgOnHeaderIsDuplicateData(),
				AtomHC.propData.getProperty("get.error.msg.duplicate.data"));
	}

	@Test(priority=10)
	public void testUserEnterValidDataAndClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnAddButton();
		programs.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(programs.displayPatientProgramList());
		programs.clickAddButtonInPatientProgramTab();
		softAssert.assertTrue(programs.displayMyProgramPage());
		log("verify enter valid data and click on save button");
		programs.clickOnNameLabelDropdownInMyPrograms();
		softAssert.assertTrue(programs.displayProgramNameDropdown());
		programs.getNewValueInDropdownField();
		programs.clearEntryPointValue();
		softAssert.assertTrue(programs.displayentryPointTextbox());
		programs.enterNewValueInEntryPointTextbox(AtomHC.propData.getProperty("enter.new.entry.point"));
		programs.clickOnSaveButtonInMyProgramsPage();
		softAssert.assertTrue(programs.displayPatientProgramList());
		softAssert.assertAll();
	}

	@Test(priority=11)
	public void testUserClickOnCancelButtonItShouldNavigateToPatientProgramListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickAddButtonInPatientProgramTab();
		log("verify on click on cancel button it should navigate to patient programs list page");
		programs.clickOnCancelButtonInMyProgramAddPage();
		assertTrue(programs.isPatientProgramsListPageDisplay());
	}

	@Test(priority=12,enabled=false)
	public void testPatientPrefilledDataAndEditPageFromPatientProgramPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickOnAnyRecordInPatientProgramsListPage();
		log("verify prefilled data and Edit in my program page from patient");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(programs.getAlreadyAddedProgramName(),
				AtomHC.propData.getProperty("get.prefilled.name.data.in.my.program"));
		softAssert.assertEquals(programs.getAlreadyAddedEntryPoint(),
				AtomHC.propData.getProperty("get.prefilled.entry.point.data.in.my.program"));
		softAssert.assertEquals(programs.getMyProgramsPageTitle(),
				AtomHC.propData.getProperty("my.programs.page.title"));
		softAssert.assertTrue(programs.isMyProgramsPageXIconDisplay());
		softAssert.assertTrue(programs.isDeleteLinkButtonDisplay());
		softAssert.assertAll();
	}

	@Test(priority=13,enabled=false)
	public void testUserClickOnSaveButtonInEditModeItNavigateToPatientProgramListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		log("Verify user change the entry point in edit mode");
		programs.clickOnAnyRecordInPatientProgramsListPage();
		programs.clearEntryPointDefaultValue();
		programs.changeEntryPointValue(AtomHC.propData.getProperty("edit.default.value"));
		log("verify user click on save button in edit mode");
		SoftAssert softAssert = new SoftAssert();
		programs.clickOnSaveButtonInMyProgramsPage();
		softAssert.assertEquals(programs.getConfirmationMsgOnSaveButtonClick(),
				AtomHC.propData.getProperty("confirmation.msg.on.click.on.save.button.in.edit.mode"));
		softAssert.assertTrue(programs.isXIconDisplayInEditModeSaveButtonClick());
		softAssert.assertEquals(programs.isCancelButtonDisplayInEditModeSaveButtonClick(),
				AtomHC.propData.getProperty("my.program.cancel.button.caption"));
		softAssert.assertEquals(programs.getOkButtonDisplayInEditModeSaveButtonClick(),
				AtomHC.propData.getProperty("get.ok.button.caption.in.edit.mode.Save.Button.Click"));
		programs.clickOnCancelButtonDisplayInEditModeSaveButtonClick();
		softAssert.assertTrue(programs.displayMyProgramPage());
		programs.clickOnSaveButtonInMyProgramsPage();
		programs.clickOnOkButtonInEditModeSaveButtonClick();
		softAssert.assertTrue(programs.isPatientProgramsListPageDisplay());
		softAssert.assertAll();
	}

	@Test(priority=14)
	public void testUserClickOnCancelButtonInEditModeItShouldNavigateToPatientProgramAddEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		programs.clickOnPatientsTab();
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		programs.clickOnAnyPatientProgram();
		programs.clickOnDeleteButtonInEditMode();
		log("Verify user click on cancel button in edit mode");
		programs.clickOnCancelButtonInEditMode();
		assertTrue(programs.displayMyProgramPage());
	}
	
	@Test(priority=15)
		public void testDeleteButtonFunctionalityInEditMode() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			Programs programs = new Programs(driver);
			programs.clickOnPatientsTab();
			programs.clickOnFirstPatient();
			programs.clickOnPatientProgramTab();
			log("Verify user delete the edit record in edit mode");
			programs.clickOnAnyPatientProgram();
			programs.clickOnDeleteButtonInEditMode();
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(programs.getDeleteButtonHeading(),
					AtomHC.propData.getProperty("get.delete.button.heading"));
			softAssert.assertTrue(programs.isXIconDisplayWhenClickOnDeleteButtonPopUp());
			softAssert.assertEquals(programs.getErrorMsgInDeleteButtonPopUpPage(),
					AtomHC.propData.getProperty("get.delete.button.popup.msg"));
			softAssert.assertEquals(programs.getCancelButtonDeleteButtonPopUpPage(),
					AtomHC.propData.getProperty("get.delete.page.cancel.caption"));
			softAssert.assertEquals(programs.getOkButtonDeleteButtonPopUpPage(),
					AtomHC.propData.getProperty("get.delete.page.ok.caption"));
			softAssert.assertAll();
		}

	@Test
	public void testUserClickOnDeleteButtonInEditModeItShouldNavigateToPatientProgramListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programs = new Programs(driver);
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
//		patientPage.clickOnAddButton();
//		log("Add new patient");
//		patientPage.creatPatient(AtomHC.propData.getProperty("patient.fname"),
//				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
//				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
//				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
//				AtomHC.propData.getProperty("patient.lang.preferance"),
//				AtomHC.propData.getProperty("patient.security.code"),
//				AtomHC.propData.getProperty("patient.internal.code"),
//				AtomHC.propData.getProperty("patient.external.code"), 3);
		programs.clickOnFirstPatient();
		programs.clickOnPatientProgramTab();
		
		
		
		log("Enter an entry point as '0' and Type as 'Days' in patient's program tab");
				programs.selectProgram(AtomHC.propData.getProperty("program.entry.days"), AtomHC.propData.getProperty("program.entry.point"));
		//programs.clickOnFirstPatient();
		SoftAssert softAssert = new SoftAssert();
		programs.clickOnAnyPatientProgram();
		programs.clickOnDeleteButtonInEditMode();
		programs.clickOnOkButtonInEditMode();
		softAssert.assertTrue(programs.isPatientProgramsListPageDisplay());
		String patientProgramsListHeader = programs.getPatientProgramListPageTitle();
		String[] getTitle = patientProgramsListHeader.split(" ");
		String patientProgramListTitle = getTitle[0];
		softAssert.assertEquals(patientProgramListTitle, "Programs");
		softAssert.assertFalse(programs.isProgramDisplay());
		softAssert.assertAll();
	}
}
