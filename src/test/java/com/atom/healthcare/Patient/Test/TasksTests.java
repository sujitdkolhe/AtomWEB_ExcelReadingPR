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
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Patients.Tasks;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class TasksTests extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("doctor.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("doctor.pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}
	
	// PatientTaskList
	@Test
	public void testPatientTaskListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
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
		patientPage.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		tasks.clickOnPatientTaskTab();
		tasks.addNewTask(AtomHC.propData.getProperty("medicine.name"), AtomHC.propData.getProperty("doses"),
				AtomHC.propData.getProperty("frequency"), 0, 3);
		log("Verify Patient Task List Page Fields");
		SoftAssert softAssert = new SoftAssert();
		String taskTitle = tasks.getPatientTaskTitle();
		String[] getTitle = taskTitle.split(" ");
		String educationHeadernew = getTitle[0] + " " + getTitle[1];
		softAssert.assertEquals(educationHeadernew, "Assign Task");
		String count = taskTitle.substring(6, 5);
		log("Task Count is: " + count);
		int title = Integer.parseInt(count);
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.clickOnPatientTaskItemDropdown();
		tasks.clickOnPatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		int newCount = title + 1;
		log("Task New Count is: " + newCount);
		softAssert.assertTrue(tasks.isPatientTaskSearchTextboxDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskSearchPlaceholderText(),
				AtomHC.propData.getProperty("patient.search.placeholder"));
		softAssert.assertEquals(tasks.getPatientTaskAddButtonCaption(),
				AtomHC.propData.getProperty("patient.task.add.button.caption"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderName(),
				AtomHC.propData.getProperty("patient.task.list.header.name"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderTaskType(),
				AtomHC.propData.getProperty("patient.task.list.header.type"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderProgram(),
				AtomHC.propData.getProperty("patient.task.list.header.program"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderFromDate(),
				AtomHC.propData.getProperty("patient.task.list.header.from.date"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderEndDate(),
				AtomHC.propData.getProperty("patient.task.list.header.end.date"));
		softAssert.assertEquals(tasks.getPatientTaskListHeaderStatus(),
				AtomHC.propData.getProperty("patient.task.list.header.status"));
		String missedstatus = tasks.getPatientTaskStatusMissed().trim();
		softAssert.assertEquals(missedstatus, AtomHC.propData.getProperty("patient.task.missed"));
		String completedstatus = tasks.getPatientTaskStatusCompleted().trim();
		softAssert.assertEquals(completedstatus, AtomHC.propData.getProperty("patient.task.completed"));
		softAssert.assertAll();
	}

	@Test
	public void testFieldsForNewAddedTaskWithoutProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.clickOnPatientTaskItemDropdown();
		tasks.clickOnPatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		log("Verify program name is not displayed if task is added directly");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getProgramNameForTaskWithoutAProgram(),
				AtomHC.propData.getProperty("task.without.program.name"));
		String status = tasks.getPatientTaskStatusNew().trim();
		softAssert.assertEquals(status, AtomHC.propData.getProperty("patient.task.new"));
		softAssert.assertAll();
	}

	@Test
	public void testFieldsForNewAddedTaskWithProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientProgramTab();
		tasks.clickAddButtonInPatientProgramTab();
		tasks.clickOnProgramItemForTask();
		tasks.clickOnSaveButtonInMyProgramsPage();
		driver.navigate().refresh();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		log("Verify Program is Displayed when Task is added through program");
		assertEquals(tasks.getPatientTaskProgramName(), AtomHC.propData.getProperty("task.with.program.name"));
	}

	@Test
	public void testSearchTextboxFeildsForPatientTask() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.sendTaskSearchWord(AtomHC.propData.getProperty("task.valid.search.word"));
		String educationTitle = tasks.getPatientTaskTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0] + " " + getTitle[1];
		log("Verify Patient Task Search Count is Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationHeadernew, "Patient Tasks");
		String count = educationTitle.substring(15, 17);
		log("Task Search Count is: " + count);
		softAssert.assertEquals(tasks.getPatientTaskTitle(), AtomHC.propData.getProperty("patient.task.search.count"));
		tasks.sendTaskSearchWord(AtomHC.propData.getProperty("invalid.searchword"));
		log("Verify Patient Task Search No Record Message is Displayed");
		softAssert.assertEquals(tasks.getPatientTaskSearchNoRecordMsg(),
				AtomHC.propData.getProperty("patient.list.no.record.found"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnPatientAssignTaskPageAfterClickingOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		log("Verify user lands on Assign Task Page after clicking on Add Button");
		assertEquals(tasks.getPatientAssignTaskTitle(), AtomHC.propData.getProperty("patient.assign.task.title"));
	}

	@Test
	public void testUserLandsOnPatientTaskDetailPageAfterClickingOnTaskInListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskListItem();
		log("Verify user lands on Task Detail Page after clicking on Task List Item");
		assertEquals(tasks.getPatientTaskDetailTitle(), AtomHC.propData.getProperty("patient.detail.task.title"));
	}

	@Test
	public void testNoRecordMessageIsDisplayedIfThereIsNoTaskInListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		log("Verify No Record View Is Displayed if Tasks are not added");
		assertEquals(tasks.getPatientTaskNoRecordView(),
				AtomHC.propData.getProperty("patient.education.overview.no.record"));
	}

	// Assign Task
	@Test
	public void testPatientAssignTaskPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		log("Verify Assign Task Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getPatientAssignTaskTitle(), AtomHC.propData.getProperty("patient.assign.task.title"));
		softAssert.assertTrue(tasks.isAssignTaskCrossIconDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskTypeLabel(), AtomHC.propData.getProperty("patient.assign.task.type"));
		softAssert.assertTrue(tasks.isPatientTaskTypeDropdownDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskTypePlaceholder(),
				AtomHC.propData.getProperty("patient.assign.task.type.placeholder"));
		softAssert.assertEquals(tasks.getPatientTaskItemLabel(), AtomHC.propData.getProperty("patient.assign.task.item"));
		softAssert.assertTrue(tasks.isPatientItemDropdownDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskItemPlaceholder(),
				AtomHC.propData.getProperty("patient.assign.task.item.placeholder"));
		softAssert.assertEquals(tasks.getPatientTaskFromDateLabel(),
				AtomHC.propData.getProperty("patient.assign.task.from.date"));
		softAssert.assertTrue(tasks.isTaskFromDateCanlendarControlDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskFromDatePlaceholder(),
				AtomHC.propData.getProperty("patient.assign.task.from.date.placeholder"));
		softAssert.assertEquals(tasks.getPatientTaskEndDateLabel(),
				AtomHC.propData.getProperty("patient.assign.task.end.date"));
		softAssert.assertTrue(tasks.isTaskEndDateCanlendarControlDisplayed());
		softAssert.assertEquals(tasks.getPatientTaskEndDatePlaceholder(),
				AtomHC.propData.getProperty("patient.assign.task.end.date.placeholder"));
		softAssert.assertEquals(tasks.getPatientAssignTaskSaveButton(),
				AtomHC.propData.getProperty("patient.assign.task.save"));
		softAssert.assertEquals(tasks.getPatientAssignTaskCancelButton(),
				AtomHC.propData.getProperty("patient.assign.task.cancel"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnTaskListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		log("Verify user lands on Task List Page after clicking on Cancel Button");
		tasks.clickOnPatientAssignTaskCancelButton();
		String educationTitle = tasks.getPatientTaskTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0] + " " + getTitle[1];
		assertEquals(educationHeadernew, "Patient Tasks");
	}

	@Test
	public void testAssignTaskTypeDropdownListValues() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		log("Verify Task Type List Values as configured in the system");
		tasks.clickOnTaskTypeDropdwon();
		List<String> actualAssignTaskList = tasks.getAssignTaskTypeList();
		List<String> expectedAssignTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("assign.task.type.list"), "assigntasktypelist");
		assertEquals(actualAssignTaskList, expectedAssignTaskList);
	}

	@Test
	public void testIfSelectedTaskTypeItemValuesAreDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnTaskTypeDropdwon();
		tasks.clickOnEducationTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		log("verify after selecting education task type, education items are displayed");
		SoftAssert softAssert = new SoftAssert();
		List<String> actualEducationTaskList = tasks.getSelectedTaskItemList();
		List<String> expectedExpectedTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("assign.task.type.list"), "educationtaskitemlist");
		softAssert.assertEquals(actualEducationTaskList, expectedExpectedTaskList);
		tasks.clickOnTaskTypeDropdwon();
		tasks.clickOnQuestionnaireTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		log("verify after selecting questionnaire task type, questionnaire items are displayed");
		List<String> actualQuestionnaireTaskList = tasks.getSelectedTaskItemList();
		List<String> expectedQuestionnaireTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("assign.task.type.list"), "questionnairetaskitemlist");
		softAssert.assertEquals(actualQuestionnaireTaskList, expectedQuestionnaireTaskList);
		tasks.clickOnTaskTypeDropdwon();
		tasks.clickOnInstructionTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		log("verify after selecting instruction task type, instruction items are displayed");
		List<String> actualInstructionTaskList = tasks.getSelectedTaskItemList();
		List<String> expectedInstructionTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("assign.task.type.list"), "instructionstaskitemlist");
		softAssert.assertEquals(actualInstructionTaskList, expectedInstructionTaskList);
		softAssert.assertAll();
	}

	@Test
	public void testUserCannotSelectPastDateForTask() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		tasks.isAssignTaskFromDateEnabled(currentDay);
		log("Verify that the user cannot select past from date");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(tasks.isAssignTaskFromDateEnabled(currentDay));
		tasks.isAssignTaskEndDateEnabled(currentDay);
		log("Verify that the user cannot select past end date");
		softAssert.assertFalse(tasks.isAssignTaskEndDateEnabled(currentDay));
		softAssert.assertAll();
	}

	@Test
	public void testIfRequiredMsgIsDisplayedForPatientAssignTaskRequiredFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnAssignTaskSaveButton();
		log("Verify if error message is displayed for all patient task required fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.isPatientTaskTypeRequiredErrorColorDisplayed(),
				AtomHC.propData.getProperty("task.error.color"));
		softAssert.assertEquals(tasks.getPatientTaskRequiredErrorMsg(),
				AtomHC.propData.getProperty("task.type.required.msg"));
		softAssert.assertEquals(tasks.isPatientTaskItemRequiredErrorColorDisplayed(),
				AtomHC.propData.getProperty("task.error.color"));
		softAssert.assertEquals(tasks.getPatientItemRequiredErrorMsg(),
				AtomHC.propData.getProperty("task.item.required.msg"));
		softAssert.assertEquals(tasks.isPatientTaskFromDateRequiredErrorColorDisplayed(),
				AtomHC.propData.getProperty("task.error.color"));
		softAssert.assertEquals(tasks.getPatientFromDateRequiredErrorMsg(),
				AtomHC.propData.getProperty("task.from.date.required.msg"));
		// softAssert.assertEquals(tasks.isPatientTaskEndDateRequiredErrorColorDisplayed(),
		// AtomHC.propData.getProperty("task.error.color"));
		softAssert.assertEquals(tasks.getPatientEndDateRequiredErrorMsg(),
				AtomHC.propData.getProperty("task.end.date.required.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testIfDuplicateDataMsgIsDisplayedForPatientTask() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.assignTaskToPatient();
		log("Verify if Duplicate Data message is displayed for patient task");
		assertEquals(tasks.getDuplicateDataErrorLabel(), "Duplicate Data");
	}

	@Test
	public void testUserLandsOnTaskListPageAfterAssigningTaskSuccessfully() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.assignTaskToPatient();
		String educationTitle = tasks.getPatientTaskTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeadernew = getTitle[0] + " " + getTitle[1];
		log("Verify user lands to patint list page after successfulyy assigning task");
		assertEquals(educationHeadernew, "Patient Tasks");
	}

	@Test
	public void testMeasurementItemsAreVisibleAfterSelectingMeasurementTaskType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientProgramTab();
		tasks.clickAddButtonInPatientProgramTab();
		tasks.clickOnProgramItemForTask();
		tasks.clickOnSaveButtonInMyProgramsPage();
		driver.navigate().refresh();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnMeasurementTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		List<String> actualMeasurementTaskList = tasks.getSelectedTaskItemList();
		List<String> expectedMeasurementTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("assign.task.type.list"), "measurementItemList");
		log("Verify Measurement Items are visible after selecting task type as measurement");
		assertEquals(actualMeasurementTaskList, expectedMeasurementTaskList);
	}

	@Test
	public void testErrorMessageIsDisplayedWhenUserSelectsGreaterDateForFromDateField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.clickOnPatientTaskItemDropdown();
		tasks.clickOnTaskQuestionnaireItem();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate) + 2;
		tasks.isAssignTaskFromDateEnabled(currentDay + 2);
		tasks.isAssignTaskEndDateEnabled(currentDay - 1);
		tasks.clickOnPatientTaskSaveButton();
		log("Verify Error Message is displayed when user selects greater date than end date for from date fields");
		assertEquals(tasks.getFromDateErrorMessage(), AtomHC.propData.getProperty("greater.from.date.error.msg"));
	}

	// patient task details page
	@Test
	public void testPatientTaskDetailsPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		log("Verify patient task details page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isTaskDetailsPageDisplayed());
		softAssert.assertEquals(tasks.getTextTaskDetailsPageHeader(),
				AtomHC.propData.getProperty("task.details.page.header"));
		softAssert.assertTrue(tasks.isTaskDetailsPageCrossIconDisplayed());
		softAssert.assertEquals(tasks.getTaskTypeLabel(), AtomHC.propData.getProperty("get.task.type.label"));
		softAssert.assertEquals(tasks.getTaskTypePrefilledData(),
				AtomHC.propData.getProperty("get.task.type.prefilled.data"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNameLabel(),
				AtomHC.propData.getProperty("get.task.name.field.label"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNamePrefilledData(),
				AtomHC.propData.getProperty("get.task.name.field.prefilled.data"));
		softAssert.assertEquals(tasks.getProgramLabelInTaskDetailPage(),
				AtomHC.propData.getProperty("get.task.program.label"));
		softAssert.assertEquals(tasks.getProgramPrefilledDetail(), AtomHC.propData.getProperty("get.program.details"));
		softAssert.assertEquals(tasks.getStartEndDateLabel(), AtomHC.propData.getProperty("get.start.end.date.label"));
		String startEndDate = tasks.getStartEndDateDetails();
		log("start End Date is : " + startEndDate);
		String getStartEndDate = startEndDate.toString();
		String[] startEndDates = getStartEndDate.split(" ");
		String currentFromDate = startEndDates[0] + " " + startEndDates[1] + " " + startEndDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), currentFromDate);
		softAssert.assertEquals(tasks.getStatusLabel(), AtomHC.propData.getProperty("get.status.label"));
		softAssert.assertEquals(tasks.getStatusLabellPrefilledData(), AtomHC.propData.getProperty("get.status.data"));
		softAssert.assertEquals(tasks.getLastUpdatedLabel(), AtomHC.propData.getProperty("get.last.updated.date.label"));
		String lastUpdatedDate = tasks.getLastUpdatedDateDetails();
		log("Last updated date is : " + lastUpdatedDate);
		String getLastUpdatedDate = lastUpdatedDate.toString();
		String[] lastUpdatedDates = getLastUpdatedDate.split(" ");
		String updatedDate = lastUpdatedDates[0] + " " + lastUpdatedDates[1] + " " + lastUpdatedDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), updatedDate);
		softAssert.assertAll();
	}

	@Test
	public void testInstructionTaskDetailsPageView() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnTaskTypeDropdwon();
		tasks.clickOnInstructionTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		tasks.clickOnInstructionValue();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		log("Verify instruction details page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isTaskDetailsPageDisplayed());
		softAssert.assertEquals(tasks.getTextTaskDetailsPageHeader(),
				AtomHC.propData.getProperty("task.details.page.header"));
		softAssert.assertTrue(tasks.isTaskDetailsPageCrossIconDisplayed());
		softAssert.assertEquals(tasks.getTaskTypeLabel(), AtomHC.propData.getProperty("get.task.type.label"));
		softAssert.assertEquals(tasks.getTaskTypePrefilledData(),
				AtomHC.propData.getProperty("get.task.type.instruction.prefilled.data"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNameLabel(),
				AtomHC.propData.getProperty("get.task.name.field.label"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNamePrefilledData(),
				AtomHC.propData.getProperty("get.task.type.instruction.name.prefilled.data"));
		softAssert.assertEquals(tasks.getProgramLabelInTaskDetailPage(),
				AtomHC.propData.getProperty("get.task.program.label"));
		softAssert.assertEquals(tasks.getProgramPrefilledDetail(), AtomHC.propData.getProperty("get.program.details"));
		softAssert.assertEquals(tasks.getStartEndDateLabel(), AtomHC.propData.getProperty("get.start.end.date.label"));
		String startEndDate = tasks.getStartEndDateDetails();
		log("start End Date is : " + startEndDate);
		String getStartEndDate = startEndDate.toString();
		String[] startEndDates = getStartEndDate.split(" ");
		String currentFromDate = startEndDates[0] + " " + startEndDates[1] + " " + startEndDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), currentFromDate);
		softAssert.assertEquals(tasks.getStatusLabel(), AtomHC.propData.getProperty("get.status.label"));
		softAssert.assertEquals(tasks.getStatusLabellPrefilledData(), AtomHC.propData.getProperty("get.status.data"));
		softAssert.assertEquals(tasks.getLastUpdatedLabel(), AtomHC.propData.getProperty("get.last.updated.date.label"));
		String lastUpdatedDate = tasks.getLastUpdatedDateDetails();
		log("Last updated date is : " + lastUpdatedDate);
		String getLastUpdatedDate = lastUpdatedDate.toString();
		String[] lastUpdatedDates = getLastUpdatedDate.split(" ");
		String updatedDate = lastUpdatedDates[0] + " " + lastUpdatedDates[1] + " " + lastUpdatedDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), updatedDate);
		softAssert.assertAll();
	}

	@Test
	public void testPatientTaskListStatus() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnEducationPatient();
		tasks.clickOnPatientTaskTab();
		String status = tasks.getPatientTaskStatusNew().trim();
		log("Verify patient task list status");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(status, AtomHC.propData.getProperty("patient.task.new"));
		String missedstatus = tasks.getPatientTaskStatusMissed().trim();
		softAssert.assertEquals(missedstatus, AtomHC.propData.getProperty("patient.task.missed"));
		String completedstatus = tasks.getPatientTaskStatusCompleted().trim();
		softAssert.assertEquals(completedstatus, AtomHC.propData.getProperty("patient.task.completed"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnPatientTaskListPageAfterClickingOnOkButtonInEditMode() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		tasks.clickOkButtonInEditMode();
		log("Verify in edit mode user click on ok button it should be land on patient tasks list page");
		assertTrue(tasks.isPatientTaskListPageDisplay());
	}

	@Test
	public void testUserLandsOnPatientTaskListPageAfterClickingOnCrossButtonInEditMode() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		tasks.clickCrossIcon();
		log("Verify user lands on patient task list page after clicking on cross icon in edit mode");
		assertTrue(tasks.isPatientTaskListPageDisplay());
	}

	@Test
	public void testDeleteButtonFunctionalityWhenTaskIsDirectlyAssignToPatient() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		log("Verify delete button functionality is visible when task is directly assign to patient");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getOkButtonInEditMode(), AtomHC.propData.getProperty("task.ok.button.in.edit.mode"));
		softAssert.assertEquals(tasks.getTaskDeleteButton(), AtomHC.propData.getProperty("get.task.delete.button"));
		tasks.clickOnTaskDeleteButton();
		softAssert.assertTrue(tasks.isDeleteButtonPopUpPageDisplay());
		softAssert.assertEquals(tasks.getTaskDeleteButtonPageHeading(),
				AtomHC.propData.getProperty("get.delete.button.page.heading"));
		softAssert.assertTrue(tasks.isCrossIconDisplay());
		softAssert.assertEquals(tasks.getTaskDeleteButtonPageMsg(),
				AtomHC.propData.getProperty("get.task.delete.button.msg"));
		softAssert.assertEquals(tasks.getTaskCancelButtonCaption(),
				AtomHC.propData.getProperty("get.cancel.button.caption"));
		softAssert.assertEquals(tasks.getTaskOkButtonCaption(), AtomHC.propData.getProperty("get.ok.button.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnTaskDetailsPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		tasks.clickOnTaskDeleteButton();
		tasks.clickOnTaskCancelButton();
		log("Verify user navigate to task details page after clicking on cancel button");
		assertTrue(tasks.isTaskDetailsPageDisplayed());
	}

	@Test
	public void testUserLandsOnPatientTaskListPageAfterClickingOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnPatientTaskTypeDropdown();
		tasks.selectValueItemInDropdown();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		tasks.clickOnTaskDeleteButton();
		tasks.clickOnTaskOkButton();
		log("verify user navigate to patient task list page after clicking on ok button");
		assertTrue(tasks.isPatientTaskListPageDisplay());
	}

	@Test
	public void testForNewAddedTaskWithProgramItDisplayPrefilledProgramName() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientProgramTab();
		tasks.clickAddButtonInPatientProgramTab();
		tasks.clickOnProgramItemForTask();
		tasks.clickOnSaveButtonInMyProgramsPage();
		driver.navigate().refresh();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.selectAddedPatientTask();
		log("Verify Program prefilled data when Task is added through program");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isTaskDetailsPageDisplayed());
		softAssert.assertEquals(tasks.getTextTaskDetailsPageHeader(),
				AtomHC.propData.getProperty("task.details.page.header"));
		softAssert.assertTrue(tasks.isTaskDetailsPageCrossIconDisplayed());
		softAssert.assertEquals(tasks.getTaskTypeLabel(), AtomHC.propData.getProperty("get.task.type.label"));
		softAssert.assertEquals(tasks.getTaskTypePrefilledData(), AtomHC.propData.getProperty("get.prefilled.data"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNameLabel(),
				AtomHC.propData.getProperty("get.task.name.field.label"));
		softAssert.assertEquals(tasks.getTaskDetailsPageNamePrefilledData(),
				AtomHC.propData.getProperty("get.name.prefilled.data"));
		softAssert.assertEquals(tasks.getProgramLabelInTaskDetailPage(),
				AtomHC.propData.getProperty("get.task.program.label"));
		softAssert.assertEquals(tasks.getProgramPrefilledDetail(), AtomHC.propData.getProperty("task.with.program.name"));
		softAssert.assertEquals(tasks.getStartEndDateLabel(), AtomHC.propData.getProperty("get.start.end.date.label"));
		String startEndDate = tasks.getStartEndDateDetails();
		log("start End Date is : " + startEndDate);
		String getStartEndDate = startEndDate.toString();
		String[] startEndDates = getStartEndDate.split(" ");
		String currentFromDate = startEndDates[0] + " " + startEndDates[1] + " " + startEndDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), currentFromDate);
		softAssert.assertEquals(tasks.getStatusLabel(), AtomHC.propData.getProperty("get.status.label"));
		softAssert.assertEquals(tasks.getStatusLabellPrefilledData(), AtomHC.propData.getProperty("get.status.data"));
		softAssert.assertEquals(tasks.getLastUpdatedLabel(), AtomHC.propData.getProperty("get.last.updated.date.label"));
		String lastUpdatedDate = tasks.getLastUpdatedDateDetails();
		log("Last updated date is : " + lastUpdatedDate);
		String getLastUpdatedDate = lastUpdatedDate.toString();
		String[] lastUpdatedDates = getLastUpdatedDate.split(" ");
		String updatedDate = lastUpdatedDates[0] + " " + lastUpdatedDates[1] + " " + lastUpdatedDates[2] + " "
				+ startEndDates[3] + " " + startEndDates[4] + " " + startEndDates[5] + " " + startEndDates[6];
		softAssert.assertEquals(tasks.getStartEndDateDetails(), updatedDate);
		softAssert.assertFalse(tasks.isTaskDeleteButtonNotDiaplay());
		softAssert.assertAll();
	}

	@Test
	public void testTaskTypeLabelAsMeasurement() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks (driver);
		tasks.clickOnPatientsTab();
		tasks.clickOnAddButton();
		tasks.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientProgramTab();
		tasks.clickAddButtonInPatientProgramTab();
		tasks.clickOnProgramItemForTask();
		tasks.clickOnSaveButtonInMyProgramsPage();
		driver.navigate().refresh();
		tasks.selectFirstPatientInList();
		tasks.clickOnPatientTaskTab();
		tasks.clickOnPatientTaskAddButton();
		tasks.clickOnMeasurementTaskType();
		tasks.clickOnPatientTaskItemDropdown();
		tasks.clickOnMeasurementValue();
		tasks.selectpatientTaskFromDate();
		tasks.selectPatientTaskEndDate();
		tasks.clickOnPatientTaskSaveButton();
		tasks.selectAddedPatientTask();
		log("Verify task type label should be measurement");
		assertEquals(tasks.getTaskTypeLabelMeasurementValue(),
				AtomHC.propData.getProperty("task.type.label.measurement"));
	}

}
