package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.EducationMaster.EducationMaster;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Programs.Tasks;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class TasksTests extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Tasklist page
	@Test
	public void testIfTasksTabIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		log("verify if tasks tab is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		softAssert.assertEquals(tasks.getTasksTabName(), AtomHC.propData.getProperty("tasks.tab.name"));
		softAssert.assertAll();
	}

	@Test
	public void testProgramTasksTabFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		String tasksTitle = tasks.getTasksListHeader();
		String[] getTitle = tasksTitle.split(" ");
		String tasksHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasksHeader, "Tasks");
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		log("verify all the fields of task tab");
		softAssert.assertTrue(tasks.isTaskSearchTextboxDisplay(), "Task search textbox was not display");
		softAssert.assertEquals(tasks.getTaskSearchPlaceholder(),
				AtomHC.propData.getProperty("task.searchbox.placeholder"), "Task search box placeholder");
		softAssert.assertEquals(tasks.getTaskAddButtonCaption(), AtomHC.propData.getProperty("task.add.button.caption"),
				"The add button caption was not displayed");
		softAssert.assertTrue(tasks.isTaskListDisplay(), "Task List was not display");
		softAssert.assertEquals(tasks.getNameTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.name"), "List header Name is not visible");
		softAssert.assertEquals(tasks.getTypeTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.task.type"), "List header Task Type is not visible");
		softAssert.assertEquals(tasks.getItemTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.item"), "List header Item is not visible");
		softAssert.assertEquals(tasks.getNoOfSubflowTypeTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.no.of.subflows"),
				"List headerOperation Type is not visible");
		softAssert.assertAll();
	}

	@Test
	public void testTaskListNoRecordView() throws Exception {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Tasks tasks = new Tasks(driver);
		mainPage.clickOnOrginazationTab();
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		log("verify if error message is displayed if there is no chat record");
		assertEquals(tasks.getTaskSearchErrorlabelText(), AtomHC.propData.getProperty("no.record.found.msg"),
				"Search error label was not displayed");
	}

	@Test
	public void testTaskTabSearchTextChangeEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		String taskTitle = tasks.getTaskListHeader();
		String[] getTitle = taskTitle.split(" ");
		String taskCount = getTitle[0] + " " + getTitle[1];
		log("verify search text change events");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(taskCount, "Tasks (1)");
		tasks.clearTaskSearchTextChangeword();
		softAssert.assertTrue(tasks.isTaskListPageDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserClickOnTaskAddButtonItNavigateToTaskAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		log("verify if user is on task add page");
		tasks.clickOnTasksAddButton();
		assertEquals(tasks.getTaskAddPageTitle(), AtomHC.propData.getProperty("task.addpage.title"),
				"task Add Page title was not displayed");
	}

	@Test
	public void testIfUserClickOnAnyRecordInTaskListItShouldNavigateToEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTaskListItem();
		log("verify if user is on task edit page");
		assertEquals(tasks.getTaskAddPageTitle(), AtomHC.propData.getProperty("task.editpage.title"),
				"task Edit Page title was not displayed");
	}

	// Task add Edit page
	@Test
	public void testTaskAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		log("verify all the fields of task add page");
		tasks.clickOnTasksAddButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getTaskAddPageTitle(), AtomHC.propData.getProperty("task.addpage.title"),
				"task Add Page title was not displayed");
		tasks.isTaskAddPageCrossIconDisplayed();
		softAssert.assertEquals(tasks.getTaskEngLangText(), AtomHC.propData.getProperty("task.first.lang"),
				"Lang 1 was not displayed");
		softAssert.assertEquals(tasks.getTaskHindiLangText(), AtomHC.propData.getProperty("task.second.lang"),
				"Lang 2 was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageNameLabelText(), AtomHC.propData.getProperty("task.name.label"),
				"Name label was not displayed");
		softAssert.assertEquals(tasks.getTaskNamePlaceholder(), AtomHC.propData.getProperty("task.name.placeholder"),
				"Name paceholder was not displayed");
		softAssert.assertTrue(tasks.isTaskAddPageNameTextboxDisplayed(), "Add page name textbox was not display");
		softAssert.assertEquals(tasks.getTaskAddPageDescriptionLabelText(),
				AtomHC.propData.getProperty("task.description.label"), "Description label was not displayed");
		tasks.isDescriptionTextboxDisplayed();
//			softAssert.assertEquals(tasks.getTaskAddPageDescriptionPlaceholderText(),AtomHC.propData.getProperty("task.description.textbox.placeholder"),"Description placeholder not found");
		softAssert.assertEquals(tasks.getTypeTextInTaskListHeader(), AtomHC.propData.getProperty("task.type.label"),
				"task type was not displayed");
		softAssert.assertTrue(tasks.isTaskTypeDropdownDisplayed(), "Task dropdown was not display");
		softAssert.assertEquals(tasks.getTaskAddPageTaskDropdown(),
				AtomHC.propData.getProperty("task.list.header.task.type"),
				"task type dropdown Placeholer was not displayed");
		softAssert.assertEquals(tasks.getItemTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.item"), "Item label was not displayed");
		softAssert.assertTrue(tasks.isItemDropdownBoxDisplayed(), "Item dropdown was not display");
		softAssert.assertEquals(tasks.getTaskAddpageItemDropdown(),
				AtomHC.propData.getProperty("task.list.header.item"), "Item label was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageSaveButtonCaption(),
				AtomHC.propData.getProperty("task.save.button.caption"), "Save button was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageCancelButtonCaption(),
				AtomHC.propData.getProperty("task.cancel.button.caption"), "Cancel button was not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testPrefilledDataInTaskEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		tasks.clickOnTask(eduTitle);
		log("Verify task prfilled data");
		tasks.getTaskNameTextboxPrefilledData(eduTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isSelectValueInTypeDropdownDisplay());
		softAssert.assertEquals(tasks.getTaskItemValue(), eduTitle);
		softAssert.assertTrue(tasks.isSelectValueInTypeDropdownDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserNavigatesToTaskListPageAfterClickingOnCrossButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnCrossIcon();
		log("verify on cross icon click of task add page, user naviagtes to task list page");
		assertTrue(tasks.isTaskListDisplay());
	}

	@Test
	public void testIfUserNavigatesToTaskListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskCancelButton();
		log("verify on cancel button click of task add page, user naviagtes to task list page");
		assertTrue(tasks.isTaskListDisplay());
	}

	@Test
	public void testIfUserSelectsADifferentLangTaskAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskTabInLangFirst();
		log("verify if it changes to the selected lang");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getTaskLangTwoTabHighlightedColor(),
				AtomHC.propData.getProperty("task.tab.highlight.color"));
		softAssert.assertEquals(tasks.getTaskEngLangText(), AtomHC.propData.getProperty("task.first.lang"),
				"Lang 1 was not displayed");
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testTaskTypeDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskTypeDropdown();
		List<String> actualDefaultTaskTypeList = tasks.getTaskList();
		List<String> expectedDefaultTaskTypeList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "taskTypeDropdownList");
		log("Verify task type dropdown list");
		assertEquals(actualDefaultTaskTypeList, expectedDefaultTaskTypeList);
	}

	@Test
	public void testUserSelectAnyValueInTypeDropdownListThenSelectedValueDisplayInDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskTypeDropdown();
		tasks.selectAnyTaskTypeValue();
		log("Verify task type selected value shown in task type dropdown");
		assertTrue(tasks.isSelectValueInTypeDropdownDisplay());
	}

	@Test(enabled = false)
	public void testTaskItemDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskTypeDropdown();
		tasks.selectInstructionsValue();
		tasks.clickOnItemDropdown();
		List<String> actualDefaultTaskItemList = tasks.getTaskItemList();
		List<String> expectedDefaultTaskItemList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "taskItemDropdownList");
		log("Verify task type item dropdown list");
		assertEquals(actualDefaultTaskItemList, expectedDefaultTaskItemList);
	}

	@Test
	public void testTaskItemValueDisplayInTaskItemDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTaskTypeDropdown();
		log("Verify item value display in item dropdown");
		assertTrue(tasks.isTaskItemsValueDisplayed());
	}

	@Test
	public void testUserDoesNotEnterAnyTaskDataAndClicksOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTasksSaveButton();
		log("Verify when user does not enter data for any field, mandatory fields are highlighted and error message is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getNameIsRequiredErrorMsgLabel(),
				AtomHC.propData.getProperty("get.task.name.is.required.error.msg"));
		softAssert.assertEquals(tasks.getTaskTypeIsRequiredErrorMsgLabel(),
				AtomHC.propData.getProperty("get.task.type.is.required.error.msg"));
		softAssert.assertEquals(tasks.getTaskItemIsRequiredErrorMsgLabel(),
				AtomHC.propData.getProperty("get.task.item.is.required.error.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUserDoesNotEnterDataForOneTaskMandatoryField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.sendTasksName(AtomHC.propData.getProperty("tasks.name"));
		tasks.clickOnTaskTypeDropdown();
		tasks.clickTaskEducationTypeValue();
		tasks.clickOnTasksSaveButton();
		log("verify mandatory field is highlighted and error msg is displayed when user does not enter data for one mandatory field");
		assertEquals(tasks.getTaskItemIsRequiredErrorMsgLabel(),
				AtomHC.propData.getProperty("get.task.item.is.required.error.msg"));
	}

	@Test
	public void testUserDoesNotEnterDataRequiredOtherLang() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.sendTasksName(AtomHC.propData.getProperty("tasks.name"));
		tasks.clickOnTaskTypeDropdown();
		tasks.clickTaskEducationTypeValue();
		tasks.clickOnTasksSaveButton();
		log("verify user doesn't enter the required langugae field");
		assertEquals(tasks.getAllLangRequiredErrorMsgLabel(),
				AtomHC.propData.getProperty("get.all.language.required.error.msg"));
	}

	@Test
	public void testDuplicateDataErrorMsgIsDisplayedInTaskAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		log("Again trying to create same task");
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		log("Verify Duplicate Data error message is displayed for task");
		assertEquals(tasks.getDuplicateDataErrorLabel(), "Duplicate Data");
	}

	@Test
	public void testUserEnterValidDataAndItShouldNavigateToTaskListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getSuccessMsg(), (AtomHC.propData.getProperty("get.success.msg")));
		tasks.sendTaskSearchWord(eduTitle);
		log("Verify is subflow is added successfully after entering valid data");
		softAssert.assertEquals(tasks.getTaskListHeader(), AtomHC.propData.getProperty("task.new.added.record.count"),
				"The header of the list was not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testTaskEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		tasks.clickOnTask(eduTitle);
		log("verify edit page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getTaskAddPageTitle(), AtomHC.propData.getProperty("task.edit.page.heading"),
				"task Add Page title was not displayed");
		softAssert.assertEquals(tasks.getTaskDeleteButtonCaption(),
				AtomHC.propData.getProperty("edit.page.delete.button"));
		tasks.isTaskAddPageCrossIconDisplayed();
		softAssert.assertEquals(tasks.getTaskEngLangText(), AtomHC.propData.getProperty("task.first.lang"),
				"Lang 1 was not displayed");
		softAssert.assertEquals(tasks.getTaskHindiLangText(), AtomHC.propData.getProperty("task.second.lang"),
				"Lang 2 was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageNameLabelText(), AtomHC.propData.getProperty("task.name.label"),
				"Name label was not displayed");
		softAssert.assertEquals(tasks.getTaskNamePlaceholder(), AtomHC.propData.getProperty("task.name.placeholder"),
				"Name paceholder was not displayed");
		softAssert.assertTrue(tasks.isTaskAddPageNameTextboxDisplayed(), "Add page textbox was not display");
		softAssert.assertEquals(tasks.getTaskAddPageDescriptionLabelText(),
				AtomHC.propData.getProperty("task.description.label"), "Description label was not displayed");
		tasks.isDescriptionTextboxDisplayed();
//	 softAssert.assertEquals(tasks.getTaskAddPageDescriptionPlaceholderText(),AtomHC.propData.getProperty("task.description.textbox.placeholder"),"Description placeholder not found");
		softAssert.assertEquals(tasks.getTypeTextInTaskListHeader(), AtomHC.propData.getProperty("task.type.label"),
				"task type  was not displayed");
		softAssert.assertTrue(tasks.isTaskTypeDropdownDisplayed(), "Task type dropdown was not display");
		softAssert.assertEquals(tasks.getTaskAddPageTaskDropdown(),
				AtomHC.propData.getProperty("task.type.placeholder"),
				"task type dropdown Placeholer was not displayed");
		softAssert.assertEquals(tasks.getItemTextInTaskListHeader(),
				AtomHC.propData.getProperty("task.list.header.item"), "Item label was not displayed");
		softAssert.assertTrue(tasks.isItemDropdownBoxDisplayed());
		softAssert.assertEquals(tasks.getTaskAddpageItemDropdown(),
				AtomHC.propData.getProperty("task.list.header.item"), "Item label was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageSaveButtonCaption(),
				AtomHC.propData.getProperty("task.save.button.caption"), "Save button was not displayed");
		softAssert.assertEquals(tasks.getTaskAddPageCancelButtonCaption(),
				AtomHC.propData.getProperty("task.cancel.button.caption"), "Cancel button was not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testTaskDeleteFieldsFunctionality() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		tasks.clickOnTask(eduTitle);
		tasks.clickOnTaskDeleteButton();
		log("Verify Delete Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getTaskDeleteLabel(), AtomHC.propData.getProperty("delete.page.label"));
		softAssert.assertEquals(tasks.getTaskDeleteConfirmationMsg(),
				AtomHC.propData.getProperty("delete.page.confirm.message"));
		softAssert.assertEquals(tasks.getTaskDeleteConfirmationCancelButton(),
				AtomHC.propData.getProperty("delete.page.cancel.label"));
		softAssert.assertEquals(tasks.getTaskDeleteConfirmationOkButton(),
				AtomHC.propData.getProperty("delete.page.ok.label"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnTaskAddPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		tasks.clickOnTask(eduTitle);
		tasks.clickOnTaskDeleteButton();
		tasks.clickOnCancelButtonInTaskDeletePage();
		log("Verify user lands on task add edit page after clicking on cancel button in task edit mode");
		assertEquals(tasks.getTaskAddPageTitle(), AtomHC.propData.getProperty("task.editpage.title"),
				"task Add Page title was not displayed");
	}

	@Test
	public void testUserLandsOnTaskListPageAfterClickingOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster education = new EducationMaster(driver);
		education.clickOnEducationTab();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		education.createEducation(eduTitle);
		education.publishEducation(eduTitle);
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.createTask(eduTitle);
		tasks.sendTaskSearchWord(eduTitle);
		tasks.clickOnTask(eduTitle);
		tasks.clickOnTaskDeleteButton();
		tasks.clickOnOkButtonInTaskDeletePage();
		log("Verify user lands on task list page after clicking on ok button");
		String tasksTitle = tasks.getTasksListHeader();
		String[] getTitle = tasksTitle.split(" ");
		String tasksHeader = getTitle[0];
		assertEquals(tasksHeader, "Tasks");
	}

	// Program task add/edit
	@Test
	public void testUserLandsOnAddPageWhenUserClicksOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTabs();
		tasks.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		log("Program name " + programName);
		if (program.isProgramNameDisplay(programName)) {
			log("Program already present");
		} else {
			program.clickOnProgramAddButton();
			program.createProgram(programName);
		}
		program.selectProgram(programName);
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		assertEquals(tasks.getTaskAddHeaderText(), AtomHC.propData.getProperty("get.task.add.header"),
				"task Add Page title was not displayed");
	}

	@Test
	public void testTaskAddPageCrossIconIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTabs();
		tasks.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		log("Program name " + programName);
		if (program.isProgramNameDisplay(programName)) {
			log("Program already present");
		} else {
			program.clickOnProgramAddButton();
			program.createProgram(programName);
		}
		program.selectProgram(programName);
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		log("verify if cross icon is displayed");
		assertTrue(tasks.isTaskAddPageCrossIconDisplayed());
	}

	@Test
	public void testTaskListPageIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTabs();
		tasks.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		log("Program name " + programName);
		if (program.isProgramNameDisplay(programName)) {
			log("Program already present");
		} else {
			program.clickOnProgramAddButton();
			program.createProgram(programName);
		}
		program.selectProgram(programName);
		tasks.programTaskTab();
		log("verify if task list is getting displayed");
		assertTrue(tasks.isTaskListDisplayed());
	}

	@Test(enabled=false)
	public void testProgramTaskEditPageIsDisplayedWhenUserClicksOnAnyList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTabs();
		tasks.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		log("Program name " + programName);
		if (program.isProgramNameDisplay(programName)) {
			log("Program already present");
		} else {
			program.clickOnProgramAddButton();
			program.createProgram(programName);
		}
		program.selectProgram(programName);
		tasks.programTaskTab();
		if(tasks.isProgramTaskDisplayInList()) {
			log("Task is present");
			tasks.clickOnProgramTask();
		}else {
			EducationMaster education = new EducationMaster(driver);
			education.clickOnEducationTab();
			String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
			education.createEducation(eduTitle);
			education.publishEducation(eduTitle);
			tasks.clickOnCareProgramTab();
			tasks.clickOnTasksTab();
			tasks.clickOnTasksAddButton();
			tasks.createTask(eduTitle);
			tasks.sendTaskSearchWord(eduTitle);
			tasks.clickOnTask(eduTitle);
			tasks.clickOnTasksAddButton();
			tasks.createTask(eduTitle);
		}
		tasks.clickOnAnyListItem();
		tasks.clickOnProgramtaskList();
		log("verify if edit task page is getting displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isEditTaskHeaderDisplayed());
		softAssert.assertEquals(tasks.getEditTaskHeaderHeaderCaption(),
				AtomHC.propData.getProperty("get.edit.task.header"));
		softAssert.assertAll();
	}

	// Alternate Flows list
	@Test
	public void testUserLandsOnAlternateFlowsPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		log("Verify user land on alternate flow list page");
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		log("Verify alternate flow pade display");
		assertEquals(alternateHeader, "Alternate Flows");
	}

	@Test
	public void testAlternateFlowsPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTasksName();
		String taskName = "Cancer Related Task" + BasePageObject.createRandomCharacter(2);
		tasks.sendTasksName(taskName);
		tasks.clickOnDropdown();
		tasks.clickOnTaskTabInLangFirst();
		tasks.sendTaskNameForFirstLang(taskName);
		tasks.clickOnTaskTabInLangSecond();
		tasks.sendTaskNameForSecondLang(taskName);
		tasks.clickOnTasksSaveButton();
		tasks.clickOnAnyTaskRecords();
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(alternateHeader, "Alternate Flows");
		String alternateCount = getTitle[2];
		String count = alternateCount.substring(1, 2);
		log("Alternate Flows Count is: " + count);
		int title = Integer.parseInt(count);
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();

		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.sendAssignAfterDays(AtomHC.propData.getProperty("assign.after.days"));
		tasks.sendShowForDays(AtomHC.propData.getProperty("show.for.days"));
		tasks.clickOnAlternateSaveButton();
		int newCount = title + 1;
		log("Alternate Flows Count is: " + newCount);
		log("verify all the fields of alternate flows");
		softAssert.assertTrue(tasks.isAlternateFlowsSearchTextboxDisplay());
		softAssert.assertEquals(tasks.getAlternateFlowsSearchPlaceholder(),
				AtomHC.propData.getProperty("get.alternate.searchbox.placeholder"));
		softAssert.assertTrue(tasks.isAlternateFlowsAddButtonDisplay());
		softAssert.assertEquals(tasks.getAlternateFlowsAddButtonCaption(),
				AtomHC.propData.getProperty("alternate.flow.add.button.caption"));
		softAssert.assertEquals(tasks.getAlternateNameHeaderText(),
				AtomHC.propData.getProperty("get.alternate.name.header"));
		softAssert.assertEquals(tasks.getAlternateItemHeaderText(),
				AtomHC.propData.getProperty("get.alternate.item.header"));
		softAssert.assertEquals(tasks.getAlternateTaskTypeHeaderText(),
				AtomHC.propData.getProperty("get.alternate.task.type.header"));
		softAssert.assertEquals(tasks.getAlternateSaveButtonCaption(),
				AtomHC.propData.getProperty("alternate.save.button.caption"));
		softAssert.assertEquals(tasks.getAlternateCancelButtonCaption(),
				AtomHC.propData.getProperty("alternate.cancel.button.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testAlternateTabSearchTextChangeEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTasksName();
		String taskName = "Cancer Related Task" + BasePageObject.createRandomCharacter(2);
		tasks.sendTasksName(taskName);
		tasks.clickOnDropdown();
		tasks.clickOnTaskTabInLangFirst();
		tasks.sendTaskNameForFirstLang(taskName);
		tasks.clickOnTaskTabInLangSecond();
		tasks.sendTaskNameForSecondLang(taskName);
		tasks.clickOnTasksSaveButton();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String alternateFlow = tasks.getSelectedAlternateName();
		String measurement = tasks.getTaskTypeMeasurementValue();
		String height = tasks.getTaskTypeHeightValue();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.sendAssignAfterDays(AtomHC.propData.getProperty("assign.after.days"));
		tasks.sendShowForDays(AtomHC.propData.getProperty("show.for.days"));
		tasks.clickOnAlternateSaveButton();
		tasks.sendAlternateSearchWord(alternateFlow);
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1] + " " + getTitle[2];
		log("verify search text change events");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(alternateHeader, "Alternate Flows (1)");
		tasks.clearAlternateSearchText();
		tasks.sendAlternateSearchWord(measurement);
		String alternate = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getCount = alternate.split(" ");
		String alternates = getCount[0] + " " + getCount[1] + " " + getCount[2];
		log("verify search text change events");
		softAssert.assertEquals(alternates, "Alternate Flows (1)");
		tasks.clearAlternateSearchText();
		tasks.sendAlternateSearchWord(height);
		String count = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] counts = count.split(" ");
		String alternateHeaders = counts[0] + " " + counts[1] + " " + counts[2];
		softAssert.assertEquals(alternateHeaders, "Alternate Flows (1)");
		tasks.clearAlternateSearchText();
		log("verify search text change events");
		softAssert.assertTrue(tasks.isAlternateFlowListDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testNoRecordsFoundInAlternateFlowListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnTasksAddButton();
		tasks.clickOnTasksName();
		String taskName = "Cancer Related Task" + BasePageObject.createRandomCharacter(2);
		tasks.sendTasksName(taskName);
		tasks.clickOnDropdown();
		tasks.clickOnTaskTabInLangFirst();
		tasks.sendTaskNameForFirstLang(taskName);
		tasks.clickOnTaskTabInLangSecond();
		tasks.sendTaskNameForSecondLang(taskName);
		tasks.clickOnTasksSaveButton();
		tasks.clickOnAnyTaskRecords();
		log("Verify no record found in alternate flow list page");
		assertEquals(tasks.getNoRecordsFoundInAlternateFlowList(),
				AtomHC.propData.getProperty("get.no.records.found.in.alternate.flow.list"));
	}

	@Test
	public void testUserClickOnAlternateAddButtonItShouldNavigateToAlternateAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		log("Verify user click on add button it navigate to alternate add page");
		assertEquals(tasks.getAlternateAddPageHeading(), AtomHC.propData.getProperty("get.alternate.heading"));
	}

	@Test
	public void testUserClickOnAlternateAddedRecordsItShouldNavigateToAlternateEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String alternateFlow = tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.sendAssignAfterDays(AtomHC.propData.getProperty("assign.after.days"));
		tasks.sendShowForDays(AtomHC.propData.getProperty("show.for.days"));
		tasks.clickOnAlternateSaveButton();
		tasks.clickOnAlternateRecords();
		log("Verify alternate edit page prefilled data");
		assertEquals(tasks.getAlternateAddPageHeading(),
				AtomHC.propData.getProperty("get.alternate.edit.page.heading"));
		tasks.getAlternateEditPagePrefilledData(alternateFlow);
		tasks.getAlternateEditPageAssignAfterDaysPrefilledData(sendAssignAfterDays);
		tasks.getAlternateEditPageShowAfterDaysPrefilledData(sendShowForDays);
	}

	// Alternate flow add edit
	@Test
	public void testAlternateFlowAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		log("Verify alternate add page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isAlternateFlowPageDisplay());
		softAssert.assertTrue(tasks.isAlternateFlowPageCrossIcon());
		softAssert.assertEquals(tasks.getAlternateAddPageHeading(),
				AtomHC.propData.getProperty("get.alternate.heading"));
		softAssert.assertEquals(tasks.getAlternateAddPageNameLabel(),
				AtomHC.propData.getProperty("alternate.add.page.name.label"));
		softAssert.assertTrue(tasks.isNameDropdownDisplay());
		softAssert.assertEquals(tasks.getAlternateAddPageNameDropdownPlaceholder(),
				AtomHC.propData.getProperty("name.placeholder"));
		softAssert.assertEquals(tasks.getAlternateAddPageTaskTypeLabel(),
				AtomHC.propData.getProperty("alternate.add.page.task.type.label"));
		softAssert.assertEquals(tasks.getAlternateAddPageTaskTypeValue(),
				AtomHC.propData.getProperty("task.type.textbox.data"));
		softAssert.assertEquals(tasks.getAlternateAddPageFlowItemLabel(),
				AtomHC.propData.getProperty("alternate.add.page.item.label"));
		softAssert.assertEquals(tasks.getAlternateAddPageItemDropdownValue(),
				AtomHC.propData.getProperty("item.textbox.data"));
		softAssert.assertEquals(tasks.getAlternateAddPageFlowOperationTypeDropdownValue(),
				AtomHC.propData.getProperty("alternate.add.page.operation.type.label"));
		softAssert.assertEquals(tasks.getAlternateFlowOperationTypeValue(),
				AtomHC.propData.getProperty("operation.textbox.data"));
		softAssert.assertEquals(tasks.getAssignAfterDaysLabel(),
				AtomHC.propData.getProperty("alternate.add.page.assign.after.days.label"));
		softAssert.assertTrue(tasks.isAlternateAssignAfterDayTextboxDisplay());
		softAssert.assertEquals(tasks.getAssignAfterDaysTextboxPlaceholder(),
				AtomHC.propData.getProperty("assign.after.days.textbox.placeholder"));
		softAssert.assertEquals(tasks.getShowForDaysLabel(),
				AtomHC.propData.getProperty("alternate.add.page.show.for.days.label"));
		softAssert.assertTrue(tasks.isAlternateShowForDaysTextboxDisplay());
		softAssert.assertEquals(tasks.getShowForDaysTextboxPlaceholder(),
				AtomHC.propData.getProperty("show.for.days.textbox.placeholder"));
		softAssert.assertEquals(tasks.getAlternateFlowCancelButtonCaption(),
				AtomHC.propData.getProperty("get.alternate.cancel.button.caption"));
		softAssert.assertEquals(tasks.getAlternateFlowSaveButtonCaption(),
				AtomHC.propData.getProperty("get.alternate.save.button.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testPrefilledDataInAlternateEditPage() throws Exception {

		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String alternateFlow = tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		String assignAfterDays = tasks.getSelectedAlternateAssignAfterDays();
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.getSelectedAlternateShowForDays();
		String showForDays = tasks.getSelectedAlternateShowForDays();
		tasks.clickOnAlternateSaveButton();
		tasks.clickOnAlternateRecords();
		log("Verify alternate edit page prefilled data");
		SoftAssert softAssert = new SoftAssert();
		tasks.getAlternateEditPagePrefilledData(alternateFlow);
		tasks.getAlternateEditPageAssignAfterDaysPrefilledData(sendAssignAfterDays);
		tasks.getAlternateEditPageShowAfterDaysPrefilledData(sendShowForDays);
		softAssert.assertEquals(tasks.getAlternateFlowEditPageDeleteButton(),
				AtomHC.propData.getProperty("get.delete.button.text"));
		softAssert.assertEquals(tasks.getAlternateEditPagePrefilledData(), (alternateFlow));
		// assertEquals(tasks.getAlternateEditPageAssignAfterDaysPrefilledData(),
		// (assignAfterDays));
		softAssert.assertEquals(tasks.getAlternateEditPageShowAfterDaysPrefilledData(), (showForDays));
		softAssert.assertEquals(tasks.getAlternateFlowEditPageDeleteButton(),
				AtomHC.propData.getProperty("get.delete.button.text"));
		softAssert.assertAll();
	}

	@Test
	public void testNavigateToAlternateFlowListPageAfterClickingOnCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickCrossIcon();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isAlternateFlowListDisplay());
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		log("Verify alternate flow list pade display after clicking on cross button");
		softAssert.assertEquals(alternateHeader, "Alternate Flows");
		softAssert.assertAll();
	}

	@Test
	public void testNavigateToAlternateFlowListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickCancelButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isAlternateFlowListDisplay());
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		log("Verify alternate flow list pade display after clicking on cancel button");
		softAssert.assertEquals(alternateHeader, "Alternate Flows");
		softAssert.assertAll();
	}

	@Test
	public void testNameFieldDropdownValue() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		List<String> actualDefaultNameList = tasks.getNameDropdownValue();
		List<String> expectedDefaultNameList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "nameDropdownList");
		log("Verify name dropdown list");
		assertEquals(actualDefaultNameList, expectedDefaultNameList);
	}

	@Test
	public void testSelectedValueShowsInNameFieldDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		String alternateFlow = tasks.getSelectedAlternateName();
		log("Verify selected value show in name dropdown");
		assertEquals(tasks.getTaskSelectedAlternateFlowNameDropdownValue(), alternateFlow);
	}

	@Test
	public void testSelectedFlowNameDisplay() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		tasks.clickNameFieldDropdown();
		log("Verify selected flow name display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getAlternateAddPageTaskTypeValue(),
				AtomHC.propData.getProperty("search.task.type.in.alternate"));
		softAssert.assertEquals(tasks.getAlternateAddPageItemDropdownValue(),
				AtomHC.propData.getProperty("search.task.item.in.alternate"));
		softAssert.assertEquals(tasks.getAlternateAddPageFlowOperationTypeValue(),
				AtomHC.propData.getProperty("get.operation.type.value"));
		softAssert.assertAll();
	}

	@Test
	public void testUserClickOnSaveButtonWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();

		tasks.clickOnAlternateSaveButton();
		log("Verify when user click on save button without entering data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(tasks.getNameIsRequiredErrorMsg(),
				AtomHC.propData.getProperty("name.is.required.error.msg"));
		softAssert.assertEquals(tasks.getAssignAfterDaysIsRequiredErrorMsg(),
				AtomHC.propData.getProperty("assign.after.days.is.required.error.msg"));
		softAssert.assertEquals(tasks.getShowForDaysIsRequiredErrorMsg(),
				AtomHC.propData.getProperty("show.for.days.is.required.error.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUserNotFilledDataInMandatoryFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		tasks.clickOnAlternateSaveButton();
		log("Verify when user not enter mandatory field and click on save button");
		assertEquals(tasks.getShowForDaysIsRequiredErrorMsg(),
				AtomHC.propData.getProperty("show.for.days.is.required.error.msg"));
	}

	@Test
	public void testUserEnterValidDataAndItNavigateToAlternateFlowListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		log("Verify user create new alternate task");
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.getSelectedAlternateShowForDays();
		tasks.clickOnAlternateSaveButton();
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		assertEquals(alternateHeader, "Alternate Flows");
		String alternateCount = getTitle[2];
		String count = alternateCount.substring(1, 2);
		log("Alternate Flows Count is: " + count);
	}

	@Test
	public void testDeleteButtonFunctionalityInAlternateFlowEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.getSelectedAlternateShowForDays();
		tasks.clickOnAlternateSaveButton();
		tasks.clickOnAlternateRecords();
		tasks.clickOnDeleteButton();
		log("Verify delete popup page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tasks.isDeletePopUpPageDisplayed());
		softAssert.assertEquals(tasks.getDeleteHeading(), AtomHC.propData.getProperty("delete.page.label"));
		softAssert.assertTrue(tasks.isDeleteCrossIconDisplayed());
		softAssert.assertEquals(tasks.getDeletePermissionMsg(), AtomHC.propData.getProperty("delete.confirmation.msg"));
		softAssert.assertEquals(tasks.getdeleteCancelCaption(),
				AtomHC.propData.getProperty("get.cancel.button.caption"));
		softAssert.assertEquals(tasks.getdeleteOkCaption(), AtomHC.propData.getProperty("get.ok.button.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnAddEditPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.getSelectedAlternateShowForDays();
		tasks.clickOnAlternateSaveButton();
		tasks.clickOnAlternateRecords();
		tasks.clickOnDeleteButton();
		tasks.clickOnCacelButton();
		log("Verify user lands on add edit page after clicking on cancel button");
		assertEquals(tasks.getAlternateAddPageHeading(), AtomHC.propData.getProperty("subflow.editpage.title"));
	}

	@Test
	public void testUserLandsOnAlternateListPageAfterClickingOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCareProgramTab();
		tasks.clickOnTasksTab();
		tasks.clickOnAnyTaskRecords();
		tasks.clickOnAlternateAddButton();
		tasks.clickOnAlternateNameDropdown();
		String selectNameValue = BasePageObject.getMinMaxRandomNumber(13, 15);
		tasks.clickOnAlternateNameValue(selectNameValue);
		tasks.getSelectedAlternateName();
		String sendAssignAfterDays = BasePageObject.createRandomNumericString(2);
		tasks.sendAssignAfterDays(sendAssignAfterDays);
		tasks.getSelectedAlternateAssignAfterDays();
		String sendShowForDays = BasePageObject.createRandomNumericString(2);
		tasks.sendShowForDays(sendShowForDays);
		tasks.getSelectedAlternateShowForDays();
		tasks.clickOnAlternateSaveButton();
		tasks.clickOnAlternateRecords();
		tasks.clickOnDeleteButton();
		tasks.clickOnOkButton();
		log("Verify when user click on ok button it should navigate to alternate list page");
		String alternateTitle = tasks.getAlternateFlowsHeadingInTaskEditPage();
		String[] getTitle = alternateTitle.split(" ");
		String alternateHeader = getTitle[0] + " " + getTitle[1];
		log("Verify alternate flow pade display");
		assertEquals(alternateHeader, "Alternate Flows");
	}

}
