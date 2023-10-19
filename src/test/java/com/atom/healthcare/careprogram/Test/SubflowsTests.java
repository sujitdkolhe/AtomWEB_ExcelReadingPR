package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Programs.Subflows;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class SubflowsTests extends BaseTest {
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
	
	// SubflowList
	@Test
	public void testIfSubflowTabIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		log("verify if subflow tab is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		softAssert.assertEquals(subflows.getSubflowTabText(), AtomHC.propData.getProperty("sub.flow.tab.text"));
		softAssert.assertAll();
	}

	@Test
	public void testSubflowTabFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		softAssert.assertEquals(subflows.getSubflowTabText(), AtomHC.propData.getProperty("sub.flow.tab.text"));
		String educationTitle = subflows.getSubflowListHeader();
		String[] getTitle = educationTitle.split(" ");
		String subflowHeader = getTitle[0];
		softAssert.assertEquals(subflowHeader, "Subflows");
		String subflowCount = getTitle[1];
		String count = subflowCount.substring(1, 2);
		log("Subflow Count is: " + count);
		int title = Integer.parseInt(count);
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.name"));
		softAssert.assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		int newCount = title + 1;
		log("Subflow New Count is: " + newCount);
		log("verify all the fields of subflow tab");
		softAssert.assertTrue(subflows.isSubflowSearchTextboxDisplay());
		softAssert.assertEquals(subflows.getSubflowSearchPlaceholder(),
				AtomHC.propData.getProperty("subflow.searchtextbox.placeholder"));
		softAssert.assertEquals(subflows.getSubflowAddButtonCaption(),
				AtomHC.propData.getProperty("add.button.caption"), "The add button caption was not displayed");
		softAssert.assertTrue(subflows.isSubflowListDisplay());
		softAssert.assertEquals(subflows.getSubFlowListHeaderNameText(), AtomHC.propData.getProperty("list.header.1"),
				"List header Name is not visible");
		softAssert.assertEquals(subflows.getSubFlowListHeaderTaskTypeText(),
				AtomHC.propData.getProperty("list.header.2"), "List header Task Type is not visible");
		softAssert.assertEquals(subflows.getSubFlowListHeaderItemText(), AtomHC.propData.getProperty("list.header.3"),
				"List header Item is not visible");
		softAssert.assertEquals(subflows.getSubFlowListHeaderOperationTypeText(),
				AtomHC.propData.getProperty("list.header.4"), "List headerOperation Type is not visible");
		softAssert.assertAll();
	}

	@Test
	public void testSubflowTabSearchTextChangeEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		log("verify search text change events");
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("search.name.header.word"));
		softAssert.assertEquals(subflows.getSubflowListHeader(),
				AtomHC.propData.getProperty("subflow.search.header.count"), "The header of the list was not displayed");
		subflows.clearSubflowSearchTextChangeword();
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("search.task.header.word"));
		softAssert.assertEquals(subflows.getSubflowListHeader(),
				AtomHC.propData.getProperty("subflow.search.header.count"), "The header of the list was not displayed");
		subflows.clearSubflowSearchTextChangeword();
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("search.item.word"));
		softAssert.assertEquals(subflows.getSubflowListHeader(),
				AtomHC.propData.getProperty("subflow.search.header.count"), "The header of the list was not displayed");
		subflows.clearSubflowSearchTextChangeword();
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("search.operation.type"));
		softAssert.assertEquals(subflows.getSubflowListHeader(),
				AtomHC.propData.getProperty("subflow.search.header.count"), "The header of the list was not displayed");
		subflows.clearSubflowSearchTextChangeword();
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("subflow.random.search.text"));
		softAssert.assertEquals(subflows.getSubflowSearchErrorlabelText(),
				AtomHC.propData.getProperty("subflow.search.no.data.label"), "Search error label was not displayed");
		subflows.clearSubflowSearchTextChangeword();
		driver.navigate().refresh();
		softAssert.assertTrue(subflows.isSubflowListDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserIsOnSubflowAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		log("verify if user is on subflow add page");
		subflows.clickOnSubflowAddButton();
		assertEquals(subflows.getSubflowAddPageTitle(), AtomHC.propData.getProperty("subflow.add.page.title"),
				"Subflow Add Page title was not displayed");
	}

	@Test
	public void testIfUserIsOnSubflowEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		subflows.clickOnSubFlowListItem();
		log("verify if user is on subflow edit page");
		softAssert.assertEquals(subflows.getSubflowAddPageTitle(),
				AtomHC.propData.getProperty("subflow.editpage.title"), "Subflow Edit Page title was not displayed");
		softAssert.assertAll();
	}

	// Subflow Add/Edit
	@Test
	public void testSubflowAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		log("verify all the fields of subflow add page");
		subflows.clickOnSubflowAddButton();
		softAssert.assertEquals(subflows.getSubflowAddPageTitle(),
				AtomHC.propData.getProperty("subflow.add.page.title"), "Subflow Add page Title was not displayed");
		softAssert.assertEquals(subflows.getSubflowLangOneText(), AtomHC.propData.getProperty("subflow.lang.one"));
		softAssert.assertEquals(subflows.getSubflowLangTwoText(), AtomHC.propData.getProperty("subflow.lang.two"));
		softAssert.assertEquals(subflows.getSubflowAddPageNameLabelText(),
				AtomHC.propData.getProperty("subflow.add.name.label"), "Name label was not displayed");
		softAssert.assertEquals(subflows.getNamePlaceholder(), AtomHC.propData.getProperty("subflow.name.placeholder"),
				"Name paceholder was not displayed");
		softAssert.assertTrue(subflows.isSubflowAddPageNameTextboxDisplayed());
		softAssert.assertEquals(subflows.getSubflowAddPageDescriptionLabelText(),
				AtomHC.propData.getProperty("subflow.add.description.label"), "Description label was not displayed");
//			String subFlowTxtboxDescri =subflows.getDescriptionPlaceholder();
//			String descri =subFlowTxtboxDescri.trim();
//			//assertEquals(descri,AtomHC.propData.getProperty
//					("subflow.description.placeholder"),"Description placeholder was not displayed");
		softAssert.assertTrue(subflows.isSubflowAddPageDescriptionTextboxDisplayed());
		softAssert.assertEquals(subflows.getSubflowAddPageOperationLabeText(),
				AtomHC.propData.getProperty("subflow.add.operation.label"), "operation Item  was not displayed");
		softAssert.assertEquals(subflows.getOperationPlaceholder(),
				AtomHC.propData.getProperty("subflow.operation.placeholder"), "Operation Placeholer was not displayed");
		softAssert.assertTrue(subflows.isSubflowAddPageOperationDropdownDisplayed());
		softAssert.assertEquals(subflows.getSubflowAddPageTaskLabelText(),
				AtomHC.propData.getProperty("subflow.add.task.label"), "Task label was not displayed");
		softAssert.assertTrue(subflows.isSubflowAddPageTaskDropdownDisplayed());
		softAssert.assertEquals(subflows.getTaskTypePlaceholder(),
				AtomHC.propData.getProperty("subflow.task.placeholder"), "Task label was not displayed");
		softAssert.assertEquals(subflows.getSubflowAddPageItemLabelText(),
				AtomHC.propData.getProperty("subflow.add.item.label"), "Item label was not displayed");
		softAssert.assertTrue(subflows.isSubflowAddPageItemDropdownDisplayed());
		softAssert.assertEquals(subflows.getItemPlaceholder(), AtomHC.propData.getProperty("subflow.item.placeholder"),
				"Item label was not displayed");
		softAssert.assertEquals(subflows.getSubflowAddPageSaveButtonText(),
				AtomHC.propData.getProperty("subflow.add.page.save.button"), "Save button was not displayed");
		softAssert.assertEquals(subflows.getsubflowAddPageCancelButtonText(),
				AtomHC.propData.getProperty("subflow.add.page.cancel.button"), "Cancel button was not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testIfUserNavigatesToSubflowListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		log("verify on cancel button click of subflow add page, user naviagtes to subflow list page");
		subflows.clickOnSubflowAddButton();
		subflows.onSubflowAddCancelButtonClick();
		assertTrue(subflows.isSubflowListDisplay());
	}

	@Test
	public void testIfUserSelectsADifferentLang() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		log("verify  if it changes to the selected lang");
		subflows.clickOnSubflowAddButton();
		subflows.clickOnSubflowLangTwo();
		softAssert.assertEquals(subflows.getLangTwoTabHighlightedColor(),
				AtomHC.propData.getProperty("instruction.tab.highlight.color"));
		softAssert.assertEquals(subflows.getSubflowLangTwoText(), AtomHC.propData.getProperty("subflow.lang.two"),
				"Lang 2 was not displayed");
		softAssert.assertAll();

	}

	@Test
	public void testSubflowOperationTypeList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.onSubflowOperationDropdownClick();
		List<String> actualDefaultOperationList = subflows.getSubflowOperationList();
		List<String> expectedDefaultOperationList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "subflowOperationList");
		log("Verify subflow operation type list");
		softAssert.assertEquals(actualDefaultOperationList, expectedDefaultOperationList);
		subflows.onSubflowOperationDropdownClick();
		subflows.onBetweenOperationClick();
		softAssert.assertTrue(subflows.isSubflowBetweenFromValueTextboxDisplayed());
		softAssert.assertTrue(subflows.isSubflowBetweenToValueTextboxDisplayed());
		softAssert.assertTrue(subflows.getOperationTypeValues("Greater Than ( > )", 2));
		softAssert.assertTrue(subflows.getOperationTypeValues("Greater Than Equal To ( >= )", 3));
		softAssert.assertTrue(subflows.getOperationTypeValues("Less Than ( < )", 4));
		softAssert.assertTrue(subflows.getOperationTypeValues("Less Than Equal To ( <= )", 5));
		softAssert.assertTrue(subflows.getOperationTypeValues("Equal To ( = )", 6));
		softAssert.assertFalse(subflows.getOperationTypeValues("New", 8));
		softAssert.assertFalse(subflows.getOperationTypeValues("In Progress", 9));
		softAssert.assertFalse(subflows.getOperationTypeValues("Completed", 10));
		softAssert.assertFalse(subflows.getOperationTypeValues("Missed", 11));
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testSubflowTaskTypeList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.clickOnSubflowTaskDropdown();
		List<String> actualDefaultTaskList = subflows.getSubflowTaskList();
		List<String> expectedDefaultTaskList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "subflowTaskList");
		log("Verify subflow task type list");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualDefaultTaskList, expectedDefaultTaskList);
		subflows.getTaskTypeValues("Education", 2);
		subflows.onSubflowItemDropdownClick();
		softAssert.assertTrue(subflows.isEducationItemListDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Measurement", 3);
		subflows.onSubflowItemDropdownClick();
		softAssert.assertTrue(subflows.isMeasurementItemListDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Questionnaire", 4);
		subflows.onSubflowItemDropdownClick();
		softAssert.assertTrue(subflows.isQuestionnaireItemListDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Notification", 5);
		subflows.onSubflowItemDropdownClick();
		List<String> actualDefaultNotificationList = subflows.getSubflowTaskList();
		List<String> expectedDefaultNotificationList = BasePageObject.readJsonFile(
				AtomHC.propData.getProperty("default.operation.list.path"), "subflowNotificationItemList");
		log("Verify subflow education item list");
		softAssert.assertEquals(actualDefaultNotificationList, expectedDefaultNotificationList);
		softAssert.assertTrue(subflows.isSelectRoleDropdownDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Email", 6);
		subflows.onSubflowItemDropdownClick();
		List<String> actualDefaultEmailList = subflows.getSubflowTaskList();
		List<String> expectedDefaultEmailList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "subflowEmailItemList");
		log("Verify subflow education item list");
		softAssert.assertEquals(actualDefaultEmailList, expectedDefaultEmailList);
		softAssert.assertTrue(subflows.isSelectRoleDropdownDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("SMS", 7);
		subflows.onSubflowItemDropdownClick();
		List<String> actualDefaultSMSList = subflows.getSubflowTaskList();
		List<String> expectedDefaulSMSList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "subflowSMSItemList");
		log("Verify subflow education item list");
		softAssert.assertEquals(actualDefaultSMSList, expectedDefaulSMSList);
		softAssert.assertTrue(subflows.isSelectRoleDropdownDisplayed());
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Instruction", 8);
		subflows.onSubflowItemDropdownClick();
		softAssert.assertTrue(subflows.isInstructionItemListDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testSubflowItemDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Education", 2);
		subflows.onSubflowItemDropdownClick();
		log("verify selected subflow item is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(subflows.isEducationItemListDisplayed());
		subflows.onSubflowEducationItemClick();
		softAssert.assertTrue(subflows.isSelectedEducationItemDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testSubflowSelectRoleDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.clickOnSubflowTaskDropdown();
		subflows.getTaskTypeValues("Email", 6);
		log("Verify Select Role Dropdown List");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getSubflowSelectRoleLabel(),
				AtomHC.propData.getProperty("subflow.select.role"));
		softAssert.assertTrue(subflows.isSelectRoleDropdownDisplayed());
		softAssert.assertEquals(subflows.getSubflowSelectRoleTextboxPlaceholder(),
				AtomHC.propData.getProperty("subflow.select.role.placeholder"));
		subflows.clickOnSelectRoleDropdown();
		List<String> actualDefaultRoleList = subflows.getSubflowSelectRoleList();
		List<String> expectedDefaultRoleList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "subflowSelectRoleList");
		log("Verify subflow select role list");
		softAssert.assertEquals(actualDefaultRoleList, expectedDefaultRoleList);
		softAssert.assertAll();
	}

	@Test
	public void testSubflowEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.name"));
		assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		driver.navigate().refresh();
		subflows.clickOnSubflowListRecord();
		log("verify edit page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getSubflowNameTextboxPrefilledData(),
				AtomHC.propData.getProperty("subflow.edited.name"));
		softAssert.assertTrue(subflows.isSelectedOperationTypeDisplayed());
		softAssert.assertTrue(subflows.isSelectedTaskDropdownDisplayed());
		softAssert.assertTrue(subflows.isSelectedEducationItemDisplayed());
		softAssert.assertEquals(subflows.getSubflowDeleteButtonCaption(),
				AtomHC.propData.getProperty("edit.page.delete.button"));
		subflows.clickOnSubflowListRecord();
		subflows.clickOnSubflowDeleteButton();
		subflows.clickOnDeleteOkButton();
		softAssert.assertAll();
	}

	@Test
	public void testUserCanEditAndUpdateSubflowEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowListRecord();
		subflows.clearSubflowNameTextbox();
		subflows.sendSubflowName(AtomHC.propData.getProperty("edit.subflow.name"));
		assertFalse(subflows.getOperationTypeValues("In Progress", 9));
		subflows.clickOnSubflowLangOne();
		subflows.clearSubflowNameTextboxForLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("edit.subflow.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.clearSubflowNameTextboxForLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("edit.subflow.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		log("verify user can edit and update subflow edit page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getSubflowEditedName(), AtomHC.propData.getProperty("subflow.edit.name"));
		softAssert.assertEquals(subflows.getSubflowEditedOperationType(),
				AtomHC.propData.getProperty("subflow.edit.operation"));
		softAssert.assertAll();
	}

	@Test
	public void testSubflowDeleteFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowListRecord();
		subflows.clickOnSubflowDeleteButton();
		log("Verify Delete Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.getSubflowDeleteLabel(), AtomHC.propData.getProperty("delete.page.label"));
		softAssert.assertEquals(subflows.getSubflowDeleteConfirmationMsg(),
				AtomHC.propData.getProperty("delete.page.confirm.message"));
		softAssert.assertEquals(subflows.getSubflowDeleteConfirmationCancelButton(),
				AtomHC.propData.getProperty("delete.page.cancel.label"));
		softAssert.assertEquals(subflows.getSubflowDeleteConfirmationOkButton(),
				AtomHC.propData.getProperty("delete.page.ok.label"));
		subflows.clickOnDeleteCancelButton();
		softAssert.assertEquals(subflows.getSubflowTabText(), AtomHC.propData.getProperty("sub.flow.tab.text"));
		String educationTitle = subflows.getSubflowListHeader();
		String[] getTitle = educationTitle.split(" ");
		String subflowHeader = getTitle[0];
		assertEquals(subflowHeader, "Subflows");
		String subflowCount = getTitle[1];
		String count = subflowCount.substring(1, 2);
		log("Subflow Count is: " + count);
		int title = Integer.parseInt(count);
		subflows.clickOnSubflowListRecord();
		subflows.clickOnSubflowDeleteButton();
		subflows.clickOnDeleteOkButton();
		int newCount = title - 1;
		log("Subflow Count After Delete is: " + newCount);
		softAssert.assertAll();
	}

	@Test
	public void testUserDoesNotEnterAnySubflowDataAndClicksOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.clickOnSubflowAddPageSaveButton();
		log("Verify when user does not enter data for any field, mandatory fields are highlighted and error message is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.isSubflowNameTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowNameErrorMsg(), AtomHC.propData.getProperty("name.error.msg"));
		softAssert.assertEquals(subflows.isSubflowOperationDropdownErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowOperationErrorMsg(),
				AtomHC.propData.getProperty("operation.error.msg"));
		softAssert.assertEquals(subflows.isSubflowTaskTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowTaskErrorMsg(), AtomHC.propData.getProperty("task.error.msg"));
		softAssert.assertEquals(subflows.isSubflowItemTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowItemErrorMsg(), AtomHC.propData.getProperty("item.error.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUserDoesNotEnterDataForOneSubflowMandatoryField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.name"));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowAddPageSaveButton();
		log("verify mandatory field is highlighted and error msg is displayed when user does not enter data for one mandatory field");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.isSubflowOperationDropdownErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowOperationErrorMsg(),
				AtomHC.propData.getProperty("operation.error.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUserDoesNotEnterDataForOneLanguage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		log("Language error message is displayed and field is highlighted, when user does not enter for one language");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflows.isSubflowNameTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflows.getSubflowLangErrorMsg(), AtomHC.propData.getProperty("lang.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testDuplicateDataErrorMsgIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.duplicate.name"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.duplicate.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.duplicate.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.duplicate.name"));
		softAssert.assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.duplicate.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.duplicate.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		log("Verify Duplicate Data error message is displayed for subflow");
		softAssert.assertEquals(subflows.getDuplicateDataErrorLabel(), "Duplicate Data");
		subflows.onSubflowAddCancelButtonClick();
		subflows.clickOnSubflowListRecord();
		subflows.clickOnSubflowDeleteButton();
		subflows.clickOnDeleteOkButton();
		softAssert.assertAll();
	}

	@Test
	public void testUserAddsSubflowSuccessfully() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflows = new Subflows(driver);
		subflows.clickOnCareProgramTab();
		subflows.clickOnSubflowTab();
		String educationTitle = subflows.getSubflowListHeader();
		String[] getTitle = educationTitle.split(" ");
		String subflowHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflowHeader, "Subflows");
		String subflowCount = getTitle[1];
		String count = subflowCount.substring(1, 2);
		log("Subflow Count is: " + count);
		int title = Integer.parseInt(count);
		subflows.clickOnSubflowAddButton();
		subflows.sendSubflowName(AtomHC.propData.getProperty("subflow.name"));
		softAssert.assertFalse(subflows.getOperationTypeValues("New", 8));
		subflows.addSubflowMethod();
		subflows.clickOnSubflowLangOne();
		subflows.sendSubflowNameLangOne(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowLangTwo();
		subflows.sendSubflowNameLangTwo(AtomHC.propData.getProperty("subflow.name"));
		subflows.clickOnSubflowAddPageSaveButton();
		int newCount = title + 1;
		log("Subflow New Count is: " + newCount);
		subflows.sendSubflowSearchWord(AtomHC.propData.getProperty("added.subflow.search"));
		log("Verify is subflow is added successfully after entering valid data");
		softAssert.assertEquals(subflows.getSubflowListHeader(),
				AtomHC.propData.getProperty("subflow.search.header.count"));
		subflows.clearSubflowSearchTextChangeword();
		driver.navigate().refresh();
		subflows.clickOnSubflowListRecord();
		subflows.clickOnSubflowDeleteButton();
		subflows.clickOnDeleteOkButton();
		softAssert.assertAll();
	}

	// Program SubFlows
	@Test
	public void testProgramSubflowListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnProgramAddButton();
		subflow.clickOnProgramSupportedCodeSystemDropdown();
		subflow.selectIcdSupportedCodeSystem();
		String programName = "Dieting" + BasePageObject.createRandomCharacter(5);
		subflow.enterProgramName(programName);
		subflow.clickOnSecondLangTabInProgram();
		subflow.addSecondLangInProgram(programName);
		subflow.clickOnProgramSaveButton();
		subflow.clickOnNewCreatedProgram(programName);
		subflow.clickOnSubFlowsTab();
		String title = subflow.getSubFlowsHeader();
		String[] getTitle = title.split(" ");
		String subflowsTitle = getTitle[0];
		log("Verify Subflows List Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflowsTitle, "Subflows");
		softAssert.assertTrue(subflow.isSubflowsSearchTextboxDisplayed());
		softAssert.assertTrue(subflow.isSubflowsAddButtonDisplayed());
		softAssert.assertEquals(subflow.getSubflowsSearchTextboxPlaceholder(),
				AtomHC.propData.getProperty("search.placeholder"));
		softAssert.assertEquals(subflow.getSubflowsNameColumn(), AtomHC.propData.getProperty("name.column"));
		softAssert.assertEquals(subflow.getsubflowsOperationTypeColumn(),
				AtomHC.propData.getProperty("operation.type.column"));
		softAssert.assertEquals(subflow.getsubflowsAssignAfterDaysColumn(),
				AtomHC.propData.getProperty("assign.after.days.column"));
		softAssert.assertEquals(subflow.getSubflowsShowForDays(),
				AtomHC.propData.getProperty("show.for.days.column"));
		softAssert.assertEquals(subflow.getSubFlowsNoRecordMessage(),AtomHC.propData.getProperty("no.record.found.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testProgramSubFlowHeaderCount() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		log("Edu Task is: " + educationTask);
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		String title = subflow.getSubFlowsHeader();
		String getCount = title.substring(10, 11);
		log("Subflows Count is: " + getCount);
		int titles = Integer.parseInt(getCount);
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		Thread.sleep(1000);
		int newCount = titles + 1;
		String acutalCount = String.valueOf(newCount);
		String subFlowHeaderCount = subflow.getSubFlowsHeader();
		String subFlowNewCount = subFlowHeaderCount.substring(10, 11);
		log("Verify Subflows Header Count");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(acutalCount, subFlowNewCount);
		softAssert.assertAll();
	}

	@Test
	public void testVerifyOnClickAddButonSubFlowsAddPageDisplay() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		log("Verify SubFlows Add Page Display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflow.getProgramSubflowAddEditPageTitle(),
				AtomHC.propData.getProperty("subflow.add.page.title"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateFlowsSearchTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		Thread.sleep(1000);
		subflow.enterTextInSubflowsSearchTextbox(educationSub);
		log("Verify if Searched SubFlow display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationSub, subflow.isValidSubFlowSearchDisplay(educationSub));
		subflow.clearTextInSubFlowsSearchTextbox();
		subflow.enterTextInSubflowsSearchTextbox(AtomHC.propData.getProperty("subflow.invalid.search"));
		log("verify if error message is found if user enters data which is not present in the list");
		softAssert.assertEquals(subflow.getSubFlowsNoRecordMessage(),
				AtomHC.propData.getProperty("no.record.found.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyOnClickListSubflowEditPageDisplay() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnAnySubflowFromList(educationSub);
		SoftAssert softAssert = new SoftAssert();
		log("Verify SubFlow Edit Page Display");
		softAssert.assertEquals(subflow.getProgramSubflowAddEditPageTitle(),
				AtomHC.propData.getProperty("subflow.edit.page.title"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifySubFlowsAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		log("Verify Subflows Add Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflow.getSubflowsTasksTypeLabel(),
				AtomHC.propData.getProperty("task.type.label"));
		softAssert.assertTrue(subflow.isSubflowTaskTypeDropdownDisplayed());
		softAssert.assertEquals(subflow.getSubflowsTaskTypeDropdownPlaceholder(),
				AtomHC.propData.getProperty("task.type.dropdown.placeholder"));
		softAssert.assertEquals(subflow.getSubflowItemLabel(), AtomHC.propData.getProperty("item.label"));
		softAssert.assertTrue(subflow.isSubflowsItemDropdownDisplayed());
		softAssert.assertEquals(subflow.getSubflowsItemDropdownPlaceholder(),
				AtomHC.propData.getProperty("item.dropdown.placeholder"));
		softAssert.assertEquals(subflow.getSubflowNameLabel(), AtomHC.propData.getProperty("name.label"));
		softAssert.assertTrue(subflow.isSubflowNameDropdownDisplayed());
		softAssert.assertEquals(subflow.getSubflowsNameDropdownPlaceholder(),
				AtomHC.propData.getProperty("name.dropdown.placeholder"));
		softAssert.assertEquals(subflow.getSubflowTaskTypeLabel(),
				AtomHC.propData.getProperty("sublow.task.type.label"));
		softAssert.assertEquals(subflow.getItemLabel(), AtomHC.propData.getProperty("sublow.item.type.label"));
		softAssert.assertEquals(subflow.getSubflowOperationTypeLabel(),
				AtomHC.propData.getProperty("sublow.operation.type.label"));
		softAssert.assertEquals(subflow.getSubflowAssignAfterDaysLabel(),
				AtomHC.propData.getProperty("assign.after.day.label"));
		softAssert.assertTrue(subflow.isSubflowAssignAfterDaysTextboxDisplayed());
		softAssert.assertEquals(subflow.getSubflowShowForDaysLabel(),
				AtomHC.propData.getProperty("show.after.day.label"));
		softAssert.assertTrue(subflow.isSubflowShowForDaysTextboxDisplayed());
		softAssert.assertTrue(subflow.isSubflowCancelButtonDisplayed());
		softAssert.assertTrue(subflow.isSubflowSaveButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateEditPageDeleteButtonDisplay() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnAnySubflowFromList(educationSub);
		log("Verify Delete Button Display in Alternate Edit Page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(subflow.isSubflowDeleteButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateFlowListPageDisplayOnClickCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.clickOnCrossIconInSubflowAddPage();
		String title = subflow.getSubFlowsHeader();
		String[] getTitle = title.split(" ");
		String subflowsTitle = getTitle[0];
		log("Verify Subflows List Page Display After Clicking on Cross Icon");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflowsTitle, "Subflows");
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateFlowListPageDisplayOnClickCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		Thread.sleep(2000);
		subflow.clickOnCancelButtonInSubflowAddPage();
		String title = subflow.getSubFlowsHeader();
		String[] getTitle = title.split(" ");
		String subflowsTitle = getTitle[0];
		log("Verify Subflows List Page Display After Clicking on Cancel Button");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflowsTitle, "Subflows");
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateTaskTypeDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.clickOnAlternateTaskTypeDropdown();
		List<String> actualSubflowTaskTypeDropdownList = subflow.getSubflowTaskTypeDropdownList();
		List<String> expectedSubflowTaskTypeDropdownList = BasePageObject.readJsonFile(
				AtomHC.propData.getProperty("subflow.task.type.dropdown.list.path"), "subflowTaskTypeDropdownList");
		log("Verify Subflow Task Type Dropdown operation list");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualSubflowTaskTypeDropdownList, expectedSubflowTaskTypeDropdownList);
		softAssert.assertAll();
	}

	@Test
	public void testVerifyMandatoryFieldsGetHighlightedAndErrorMessageDisplayOnClickSaveButtonInAlternateAddEditPage()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		Thread.sleep(1000);
		subflow.clickOnSubflowsSaveButton();
		log("Verify Mandatory Fields get Highlighted");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflow.getAlternateTaskTypeDropdownHighlightedColor(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflow.getAlternateItemDropdownErrorhighlightedColor(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflow.getAlternateNameDropdownErrorhighlightedColor(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(subflow.getAlternateShowForDaysTextboxErrorhighlightedColor(),
				AtomHC.propData.getProperty("error.color"));
		log("Verify Mandatory Fields Error Message");
		softAssert.assertEquals(subflow.getAlternateTaskTypeDropdownErrorMessage(),
				AtomHC.propData.getProperty("alternate.task.type.error.message"));
		softAssert.assertEquals(subflow.getAlternateItemDropdownErrorMessage(),
				AtomHC.propData.getProperty("alternate.item.error.message"));
		softAssert.assertEquals(subflow.getAlternateNameDropdownErrorMessage(),
				AtomHC.propData.getProperty("alternate.name.error.message"));
		softAssert.assertEquals(subflow.getAlternateShowForDaysErrorMessage(),
				AtomHC.propData.getProperty("alternate.show.for.days.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateFlowDeletedOnClickDeleteButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnAnySubflowFromList(educationSub);
		subflow.clickOnDeleteButtonInAlternateEditPage();
		log("Verify Delete Confirmation Message");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflow.getAlternateDeleteConfirmationMessage(),
				AtomHC.propData.getProperty("delete.confirmation.msg"));
		softAssert.assertTrue(subflow.isAlternateConfirmationCancelButtonDisplayed());
		softAssert.assertEquals(subflow.getAlternateConfirmationCancelButtonText(),
				AtomHC.propData.getProperty("cancel.button"));
		softAssert.assertTrue(subflow.isAlternateConfirmationOkButtonDisplayed());
		softAssert.assertEquals(subflow.getAlternateConfirmationOkButtonText(),
				AtomHC.propData.getProperty("delete.page.ok.label"));
		log("Verify SubFlow Edit Page On Click Cancel button");
		subflow.clickOnCancelButtonInDeletePage();
		softAssert.assertEquals(subflow.getProgramSubflowAddEditPageTitle(),
				AtomHC.propData.getProperty("subflow.edit.page.title"));
		subflow.clickOnDeleteButtonInAlternateEditPage();
		subflow.clickOnOkButtonInDeletePage();
		Thread.sleep(1000);
		log("Verify Deleted SubFlow is Not displaying");
		softAssert.assertFalse(subflow.deletedSuflowTaskNotDisplayed(educationSub));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyAlternateFlowPrefilledDataOnClickAnyList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Subflows subflow = new Subflows(driver);
		subflow.clickOnCareProgramTab();
		subflow.clickOnTabSubflow();
		String educationSub = "Education" + BasePageObject.createRandomCharacter(5);
		subflow.createEducationSubflow(educationSub, educationSub);
		subflow.clickOnTabTask();
		String educationTask = "Task" + BasePageObject.createRandomCharacter(6);
		subflow.createEducationTask(educationTask, educationTask);
		subflow.clickOnTabSubflow();
		subflow.clickOnAnySubflow(educationSub);
		String subflowMeasurementName = subflow.getSubflowNameValue();
		String subflowOperationType = subflow.getSubflowOperationTypeDropdownValue();
		String subflowTaskName = subflow.getSubflowTaskTypeValue();
		String subflowItemName = subflow.getSubflowItemDropdownValue();
		subflow.clickOnSubflowCancelButton();
		subflow.clickOnProgramTab();
		subflow.clickOnDietProgram();
		subflow.clickOnProgramTaskAddButton();
		subflow.createEducationTaskTypeInProgram(educationTask,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnSubFlowsTab();
		subflow.clickOnSubflowsAddButton();
		subflow.createSubflowEducationTaskType(educationSub,
				AtomHC.propData.getProperty("subflow.assign.after.day"),
				AtomHC.propData.getProperty("subflow.show.for.day"));
		subflow.clickOnAnySubflowFromList(educationSub);
		log("Verify Prefilled Data in Edit Page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(subflow.getSubflowTaskTypeDropdownName(),
				AtomHC.propData.getProperty("alternate.task.type"));
		softAssert.assertEquals(subflow.getSubflowItemdropdownName(),
				AtomHC.propData.getProperty("alternate.item"));
		softAssert.assertEquals(subflowMeasurementName, subflow.getSubflowName());
		softAssert.assertEquals(subflowTaskName, subflow.getSubflowTaskTypeName());
		softAssert.assertEquals(subflowItemName, subflow.getSubflowItemName());
		String actualSubflowOperationType = subflow.getSubflowOperationType();
		softAssert.assertEquals(subflowOperationType, actualSubflowOperationType);
		softAssert.assertEquals(subflow.getSubflowsAssignAfterDaysValue(),
				AtomHC.propData.getProperty("alternate.show.for.days"));
		softAssert.assertEquals(subflow.getSubflowsShowForDaysValue(),
				AtomHC.propData.getProperty("alternate.assign.after.days"));
		softAssert.assertAll();
	}
}
