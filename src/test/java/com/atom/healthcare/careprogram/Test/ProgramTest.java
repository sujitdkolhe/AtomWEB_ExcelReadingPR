package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class ProgramTest extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.username"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.password")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Program List
	@Test
	public void testIfProgramTabIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		log("verify if program tab is displayed");
		assertEquals(programPage.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		assertEquals(programPage.getProgramTabText(), AtomHC.propData.getProperty("program.tab.text"));
	}

	@Test
	public void testProgramListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		String programTitle = programPage.getProgramListTitle();
		String[] getTitle = programTitle.split(" ");
		String programHeader = getTitle[0];
		assertEquals(programHeader, "Programs");
		String subflowCount = getTitle[1];
		String count = subflowCount.substring(1, 2);
		log("Subflow Count is: " + count);
		int title = Integer.parseInt(count);
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnSubscribeNameDropdown();
		String value = BasePageObject.getRandomNumber(40);
		programPage.clickOnProgramItemForSubscription(value);
		programPage.clickOnSubscribeButton();
		programPage.clickOnSubscribeConfirmationOkButton();
		int newCount = title + 1;
		log("Program New Count is: " + newCount);
		log("verify all the fields of program list page");
		assertEquals(programPage.getProgramTabHighlightedColor(),
				AtomHC.propData.getProperty("instruction.tab.highlight.color"));
		assertTrue(programPage.isProgramSearchTextboxDisplayed());
		assertEquals(programPage.getProgramSearchPlaceholder(), AtomHC.propData.getProperty("placeholder"));
		assertEquals(programPage.getProgramSubscribeButtonCaption(),
				AtomHC.propData.getProperty("program.subscribe.button"));
		assertEquals(programPage.getProgramAddButtonCaption(), AtomHC.propData.getProperty("add.button.caption"));
		assertEquals(programPage.getProgramListNameHeader(), AtomHC.propData.getProperty("program.name.header"));
		assertEquals(programPage.getProgramTypeListHeader(), AtomHC.propData.getProperty("program.type.header"));
		assertEquals(programPage.getProgramListTaskHeader(), AtomHC.propData.getProperty("program.task.header"));
		assertEquals(programPage.getProgramListSubflowHeader(), AtomHC.propData.getProperty("program.subflow.header"));
		assertEquals(programPage.getProgramListCaregiverHeader(),
				AtomHC.propData.getProperty("program.caregiver.header"));
		assertEquals(programPage.getProgramListReadingHeader(), AtomHC.propData.getProperty("program.reading.header"));
		assertEquals(programPage.getProgramListEducationHeader(),
				AtomHC.propData.getProperty("program.education.header"));
		assertEquals(programPage.getProgramListMedicationHeader(),
				AtomHC.propData.getProperty("program.medication.header"));
		assertTrue(programPage.isProgramListRecordsDisplayed());
	}

	@Test
	public void testProgramListNoRecordView() throws Exception {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Programs programPage = new Programs(driver);
		mainPage.clickOnOrginazationTab();
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		log("verify if message is displayed if programs are not added");
		assertEquals(programPage.getProgramNoRecordErrorMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
	}

	@Test
	public void testProgramListSearchTextChangeEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.sendProgramSearchWord(AtomHC.propData.getProperty("chat.invalid.search.word"));
		log("Verify error message is displayed when user enter invalid word");
		assertEquals(programPage.getProgramNoRecordErrorMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
		programPage.clearProgramSearchTextbox();
		programPage.sendProgramSearchWord(AtomHC.propData.getProperty("search.program"));
		log("Verify search count when user enter valid search word");
		assertEquals(programPage.getProgramListTitle(), AtomHC.propData.getProperty("search.program.header.count"));
		programPage.clearProgramSearchTextbox();
		driver.navigate().refresh();
		assertTrue(programPage.isProgramListRecordsDisplayed());
	}

	@Test
	public void testSubscribeOtherProgramPageIsDisplayedAfterClickingOnSubscribeButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		log("Verify user lands on subscribe other program page after clicking on subscribe button");
		assertEquals(programPage.getSubscribeOtherProgramTitle(),
				AtomHC.propData.getProperty("subscribe.other.program.title"));
	}

	@Test
	public void testProgramAddPageIsDisplayedAfterClickingOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramAddButton();
		log("Verify user lands on program add page after clicking on add button");
		assertEquals(programPage.getSubscribeOtherProgramTitle(),
				AtomHC.propData.getProperty("program.add.page.title"));
	}

	@Test
	public void testProgramEditPageIsDisplayedAfterClickingOnAnyRecord() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramEditRecord();
		log("Verify user lands on program edit page after clicking on any record");
		assertEquals(programPage.getSubscribeOtherProgramTitle(),
				AtomHC.propData.getProperty("program.edit.page.title"));
		assertEquals(programPage.getPrefilledProgramName(), AtomHC.propData.getProperty("program.prefilled.name"));
		assertTrue(programPage.isDefaultProgramTaskIdentifierColorSelected());
	}

	// SubscribeOtherProgram
	@Test
	public void testSubscribeOtherProgramPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		log("Verify subscribe other program page fields");
		assertEquals(programPage.getSubscribeOtherProgramTitle(),
				AtomHC.propData.getProperty("subscribe.other.program.title"));
		assertTrue(programPage.isTaskAddPageCrossIconDisplayed());
		assertEquals(programPage.getSubscribeNameLabel(), AtomHC.propData.getProperty("subflow.add.name.label"));
		assertEquals(programPage.getNamePlaceholder(), AtomHC.propData.getProperty("subflow.name.placeholder"));
		assertTrue(programPage.isSubscribeNameDropdownDisplayed());
		assertEquals(programPage.getSubscribeDescriptionLabel(),
				AtomHC.propData.getProperty("subflow.add.description.label"));
		assertTrue(programPage.isSubscribeDescriptionAreaEmpty());
		assertEquals(programPage.getSubscribeButtonCaption(), AtomHC.propData.getProperty("subscribe.button.caption"));
		assertEquals(programPage.getSubscribeCancelButtonCaption(), AtomHC.propData.getProperty("cancel.button"));
	}

	@Test
	public void testUserLandsOnProgramListPageAfterClickingOnCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnCrossIcon();
		log("Verify user navigates to program list page after clicking on cross icon");
		assertTrue(programPage.isProgramListRecordsDisplayed());
	}

	@Test
	public void testUserLandsOnProgramListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnSubscribeCancelButton();
		log("Verify user navigates to program list page after clicking on cross icon");
		assertTrue(programPage.isProgramListRecordsDisplayed());
	}

	@Test(enabled=false)
	public void testSubscrieOtherButtonIsNotVisibleToSuperAdmin() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		log("Verify Subscribe other program button is not visible to super admin");
		assertFalse(programPage.isSubscribeOtherProgramButtonDisplayed());
	}

	@Test
	public void testAlreadySubscribedIsNotVisibleInNameDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.sendProgramSearchWord(AtomHC.propData.getProperty("subscribed.program.name"));
		log("Verify subscribed program is visible in the program list");
		assertEquals(programPage.getProgramListTitle(), AtomHC.propData.getProperty("search.program.header.count"));
		programPage.clickOnProgramSubscribeButton();
		programPage.sendSubscribedProgramWord(AtomHC.propData.getProperty("subscribed.program.name"));
		log("Verify Already subscribed program is not visible in the program name list");
		assertEquals(programPage.getSubscribeNoRecordMsg(), AtomHC.propData.getProperty("no.record.found.msg"));
	}

	@Test
	public void testDescriptionIsVisibleOrNotForSelectedSubscribeProgramName() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnSubscribeNameDropdown();
		String value = BasePageObject.getRandomNumber(40);
		programPage.clickOnProgramItemForSubscription(value);
		log("Verify Description For Selected Subscribe Program Name Is Visible or not");
		assertTrue(programPage.isSelectedSubscribeProgramDescriptionVisible());
	}

	@Test(enabled=false)
	public void testUserSuccessfullySubscribesAProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnSubscribeNameDropdown();
		String value = BasePageObject.getRandomNumber(40);
		programPage.clickOnProgramItemForSubscription(value);
		programPage.clickOnSubscribeButton();
		programPage.clickOnSubscribeConfirmationOkButton();
		log("Verify Subscribed label is visible after subscribing a program");
		assertEquals(programPage.getProgramListSubscribedLabel(),
				AtomHC.propData.getProperty("subscribed.label.caption"));
		
		programPage.clickOnSubscribedProgram();
		programPage.clickOnAllowSelfSubscriptionCheckbox();
		//assertTrue(programPage.isProgramAllowSeldSubscriptionCheckboxSelected());
		log("Verify user cannot add or edit subscribed program task");
		assertFalse(programPage.isProgramTaskAddButtonDisplayed());
		programPage.clickOnSubscribedProgramTaskRow();
		assertFalse(programPage.isProgramTaskAddEditPageDisplayed());
		log("Verify user cannot add or edit subscribed program alternate flows");
		programPage.clickOnProgramAlternateFlowTab();
		// assertFalse(programPage.isProgramAlternateFlowAddButtonDisplayed());
		programPage.clickOnSubscribedProgramAlternateFlowsRow();
		assertFalse(programPage.isProgramAlternateFlowsAddEditPageDisplayed());
		log("Verify user can add or edit subscribed program caregiver");
		programPage.clickOnProgramCaregiverTab();
		assertTrue(programPage.isProgramCaregiverAddButtonDisplayed());
		programPage.clickOnSubscribedProgramCaregiverRow();
		assertTrue(programPage.isProgramCaregiverAddButtonDisplayed());
		log("Verify user can add or edit subscribed program readings");
		programPage.clickOnProgramReadingTab();
		assertFalse(programPage.isProgramReadingAddButtonDisplayed());
		programPage.clickOnSubscribedProgramReadingRow();
		assertFalse(programPage.isProgramReadingAddEditPageDisplayed());
		log("Verify user cannot add or edit subscribed program education");
		programPage.clickOnProgramEducationTab();
		assertFalse(programPage.isProgramEducationAddButtonDisplayed());
		programPage.clickOnSubscribedProgramEducationsRow();
		assertFalse(programPage.isProgramEducationAddEditPageDisplayed());
		log("Verify user cannot add or edit subscribed program measurement");
		programPage.clickOnProgramMeasurementTab();
		assertFalse(programPage.isProgramMedicationAddButtonDisplayed());
		programPage.clickOnSubscribedProgramMedicationRow();
		assertFalse(programPage.isProgramMeasurementAddEditPageDisplayed());
	}

	@Test(enabled=false)
	public void testUserSuccessfullyAddsACaregiverToTheSubscribedProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramSubscribeButton();
		programPage.clickOnSubscribeNameDropdown();
		String value = BasePageObject.getRandomNumber(40);
		programPage.clickOnProgramItemForSubscription(value);
		programPage.getProgramSubscribeNameDropdown();
		String programName = programPage.getProgramSubscribeNameDropdown();
		programPage.clickOnSubscribeButton();
		programPage.clickOnSubscribeConfirmationOkButton();
		programPage.sendProgramSearchWord(programName);
		programPage.clickOnSusbcribedProgramFromProgramList();
		programPage.clickOnProgramCaregiverTabForSubscribe();
		programPage.clickOnProgramCaregiverAddButton();
		programPage.clickOnProgramProviderDropdown();
		String selectCaregiver = BasePageObject.getMinMaxRandomNumber(6, 4);
		programPage.clickOnProgramCaregiverForSubscription(selectCaregiver);
		programPage.getProgramSelectedCaregivernameForSubscription();
		String caregiverName = programPage.getProgramSelectedCaregivernameForSubscription();
		log("Caregiver name " + caregiverName);
		String[] cargName = caregiverName.split("-");
		String s = cargName[0];
		String selectedCaregiver = s.trim();
		programPage.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		programPage.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		programPage.clickOnProgramCaregiverSaveButton();
		programPage.clickOnProgramSaveButton();
		
		programPage.sendProgramSearchWord(programName);
		programPage.clickOnSusbcribedProgramFromProgramList();
		programPage.clickOnProgramCaregiverTabForSubscribe();
		programPage.sendProviderNameInProgramCaregiverSearchTextbox(selectedCaregiver);
		log("Verify it allows to add caregiver for subscribed program");
		assertEquals(programPage.getProgramCaregiverListTitle(), AtomHC.propData.getProperty("subscribe.caregiver"));
		programPage.clickOnSusbcribedProgramAddedCaregiver();
		programPage.clickOnProgramProviderDropdown();
		String editCaregiver = BasePageObject.getMinMaxRandomNumber(7, 4);
		programPage.clickOnProgramCaregiverForSubscription(editCaregiver);
		programPage.getProgramSelectedCaregivernameForSubscription();
		String editCaregiverName = programPage.getProgramSelectedCaregivernameForSubscription();
		log("Caregiver name " + editCaregiverName);
		String[] NewCargName = editCaregiverName.split("-");
		String c = NewCargName[1];
		String editededCaregiver = c.trim();
		programPage.clickOnProgramCaregiverSaveButton();
		programPage.sendProviderNameInProgramCaregiverSearchTextbox(editededCaregiver);
		log("verify it allows edit caregiver for subscribed program");
		assertEquals(programPage.getProgramCaregiverListTitle(), AtomHC.propData.getProperty("subscribe.caregiver"));
	}

	@Test(enabled=false)
	public void testUserLandsOnProgramTaskListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTabs();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramList();
		log("verify if program task tab is displayed");
		assertTrue(programPage.isprogramTaskTabDisplayed());
		assertEquals(programPage.getprogramTaskTabText(), AtomHC.propData.getProperty("get.task.text"));
	}

	// ProgramTask List

	@Test
	public void testProgramTaskListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTabs();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramList();
		String title = programPage.getProgramTaskHeadderLabel();
		String[] getTitle = title.split(" ");
		String taskLabel = getTitle[0];
		assertEquals(taskLabel, "Tasks");
	}

	@Test
	public void testInProgramTaskListPageField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTabs();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramNameInList();
		assertTrue(programPage.isProgramTaskSearchTextbox());
		assertTrue(programPage.isProgramTaskAddButtonDisplayed());
		String title = programPage.getProgramTaskHeadderLabel();
		String[] getTitle = title.split(" ");
		String taskLabel = getTitle[0];
		assertEquals(taskLabel, "Tasks");
		assertEquals(programPage.getProgramTaskListNameLabel(), AtomHC.propData.getProperty("list.header.1"));
		assertEquals(programPage.getProgramTaskListTaskTypeLabel(), AtomHC.propData.getProperty("list.header.2"));
		assertEquals(programPage.getProgramTaskListItemLabel(), AtomHC.propData.getProperty("list.header.3"));
		assertEquals(programPage.getProgramTaskListAssignAfterDaysLabel(),
				AtomHC.propData.getProperty("assign.after.days.column"));
		assertEquals(programPage.getProgramTaskListShowForDaysLabel(),
				AtomHC.propData.getProperty("show.for.days.column"));
	}

	@Test
	public void testInProgramTaskClicksOnAddButtonItsNagivgetdToAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTabs();
		programPage.clickOnProgramTab();
		programPage.clickOnProgramNameInList();
		programPage.clickOnProgramTaskAddButton();
		assertTrue(programPage.isTaskAddHeaderDisplayed());
		assertEquals(programPage.getTaskAddHeaderText(), AtomHC.propData.getProperty("get.task.add.header"));
	}

}
