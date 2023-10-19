package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Instructions;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class InstructionsTest extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// InstructionList
	@Test
	public void testIfInstructionTabIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getProgramPageTitle(), AtomHC.propData.getProperty("care.program.title"));
		log("Verify user is on Intruction Tab");
		String instructionTabText = instructions.getInstructionTabText().trim();
		softAssert.assertEquals(instructionTabText, AtomHC.propData.getProperty("instruction.tab.text"));
	}

	@Test
	public void testInstructionListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		log("Verify Instruction List Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(instructions.isInstructionListPageDisplayed());
		String instructionTitle = instructions.getInstructionListTitle();
		String[] getTitle = instructionTitle.split(" ");
		String instructionHeader = getTitle[0];
		softAssert.assertEquals(instructionHeader, "Instructions");
		instructions.clickOnInstructionAddButton();
		String instructionName = AtomHC.propData.getProperty("instruction.name")+BasePageObject.createRandomCharacter(4);
		instructions.clickOnInstructionAddButton();
		instructions.createInstruction(instructionName, AtomHC.propData.getProperty("instruction.description"));
		softAssert.assertTrue(instructions.isInstructionSearchTextboxDisplayed(), "Search textbox not display");
		softAssert.assertEquals(instructions.getInstructionSearchPlaceholder(),
				AtomHC.propData.getProperty("placeholder"), "Search textbox placeholder not display");
		softAssert.assertEquals(instructions.getInstructionAddButtonCaption(),
				AtomHC.propData.getProperty("add.button.caption"), "Add button caption not display");
		softAssert.assertEquals(instructions.getInstructionNameHeader(),
				AtomHC.propData.getProperty("patient.task.list.header.name"), "Instruction name header not display");
		softAssert.assertTrue(instructions.isInstructionListPageDisplayed(), "Instruction list page not display");
		softAssert.assertAll();
	}

	@Test
	public void testInstructionSearchTextboxFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		String userName = AtomHC.propData.getProperty("instruction.name") + BasePageObject.createRandomCharacter(4);
		instructions.clickOnInstructionAddButton();
		instructions.createInstruction(userName, AtomHC.propData.getProperty("instruction.description"));
		instructions.sendInstructionSearchWord(userName);
		log("User search instruction with valid word");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getInstructionListTitle(),
				AtomHC.propData.getProperty("searched.instruction.title"), "Instruction search title not match");
		instructions.clearInstructionSearchTextbox();
		instructions.sendInstructionSearchWord(AtomHC.propData.getProperty("instruction.name"));
		log("User search instruction with invalid word");
//		softAssert.assertEquals(instructions.getInstructionSearchErrorLabel(),//in element &nbsp
//				AtomHC.propData.getProperty("no.record.found.msg"));
		instructions.clearInstructionSearchTextbox();
		log("Verify search placeholder and list is displayed, after clearing textbox");
		softAssert.assertEquals(instructions.getInstructionSearchPlaceholder(),
				AtomHC.propData.getProperty("placeholder"), "Instruction search placeholder not match");
		String instructionTitle = instructions.getInstructionListTitle();
		String[] getTitle = instructionTitle.split(" ");
		String instructionHeader = getTitle[0];
		softAssert.assertEquals(instructionHeader, "Instructions", "Instruction header not match");
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnInstructionAddPageAfterClickingOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		log("Verify user lands on instruction add page");
		assertEquals(instructions.getInstructionAddEditPageTitle(),
				AtomHC.propData.getProperty("instruction.add.edit.title"), "Instruction add/edit Title not match");
	}

	@Test
	public void testUserLandsOnInstructionEditPageAfterClickingOnAnyListRecord() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionListRecord();
		log("verify user lands on instruction edit page");
		assertEquals(instructions.getInstructionAddEditPageTitle(),
				AtomHC.propData.getProperty("instruction.add.edit.title"));
	}

	@Test
	public void testInstructionListNoRecordView() throws Exception {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Instructions instructions = new Instructions(driver);
		mainPage.clickOnOrginazationTab();
		instructions.clickOnCareProgramTab();
		log("verify if error message is displayed if there is no instruction record added");
		assertEquals(instructions.getInstructionSearchErrorLabel(), AtomHC.propData.getProperty("no.record.found.msg"));
	}

	// InstructionAdd/Edit
	@Test
	public void testInstructionAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		log("verify instruction add page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(instructions.isAddPageCrossIconDisplayed(), "Add page cross icon not display");
		softAssert.assertEquals(instructions.getInstructionAddEditPageTitle(),
				AtomHC.propData.getProperty("instruction.add.edit.title"),
				"Instruction Add edit page title not display");
		softAssert.assertEquals(instructions.getInstructionLangLabelForFirstLang(),
				AtomHC.propData.getProperty("first.lang"), "First language not display");
		softAssert.assertEquals(instructions.getInstructionLangLabelForSecondLang(),
				AtomHC.propData.getProperty("second.lang"), "Second language not display");
		softAssert.assertEquals(instructions.getInstructionNameLabel(),
				AtomHC.propData.getProperty("instruction.name.label"), "Instruction name label not match");
		softAssert.assertTrue(instructions.isInstructionNameTextboxDisplayed(),
				"Instruction name textbox name not display");
		softAssert.assertEquals(instructions.getInstructionNamePlaceholder(),
				AtomHC.propData.getProperty("instruction.name.placeholder"),
				"Instruction name placeholder not display");
		softAssert.assertEquals(instructions.getInstructionDescriptionLabel(),
				AtomHC.propData.getProperty("instruction.description.label"),
				"Instruction description label not match");
		softAssert.assertTrue(instructions.isInstructionDescriptionTextboxDisplayed(),
				"Instruction description not display");
		softAssert.assertEquals(instructions.getInstructionSaveButtonCaption(),
				AtomHC.propData.getProperty("save.button.caption"), "Save button caption not match");
		softAssert.assertEquals(instructions.getInstructionCancelButtonCaption(),
				AtomHC.propData.getProperty("cancel.button"), "Cancel button not display");
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnInstructionListPageAfterClickingOnCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		instructions.clickOnCrossIcon();
		log("Verify user navigates to instruction list page after clicking on cross icon");
		assertTrue(instructions.isInstructionListPageDisplayed());
	}

	@Test
	public void testInstructionEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		String instructionName = AtomHC.propData.getProperty("instruction.name")
				+ BasePageObject.createRandomCharacter(4);
		instructions.clickOnInstructionAddButton();
		instructions.createInstruction(instructionName, AtomHC.propData.getProperty("instruction.description"));
		instructions.selectInstructionListRecord(instructionName);
		log("verify instruction edit page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getInstructionAddEditPageTitle(),
				AtomHC.propData.getProperty("instruction.add.edit.title"), "Instruction add edit page title not match");
		softAssert.assertEquals(instructions.getInstructionNamePrefilledData(), instructionName,
				"Instruction edit name not match");
		softAssert.assertEquals(instructions.getInstructionDescriptionPrefilledData(),
				AtomHC.propData.getProperty("instruction.edit.name"), "Instruction description edit name not match");
		softAssert.assertEquals(instructions.getInstructionDeleteButtonCaption(),
				AtomHC.propData.getProperty("edit.page.delete.button"), "Edit page delete caption not match");
		softAssert.assertAll();
	}

	@Test
	public void testInstructionDeletePageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		String instructionName = AtomHC.propData.getProperty("instruction.name")+BasePageObject.createRandomCharacter(4);
		instructions.clickOnInstructionAddButton();
		instructions.createInstruction(instructionName, AtomHC.propData.getProperty("instruction.description"));
		instructions.selectInstructionListRecord(instructionName);
		instructions.clickOnInstructionDeleteButton();
		log("Verify Delete Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getDeleteLabel(), AtomHC.propData.getProperty("delete.page.label"),"Delete label not match");
		softAssert.assertEquals(instructions.getDeleteConfirmationMsg(),
				AtomHC.propData.getProperty("delete.page.confirm.message"),"delete label confirm message not match");
		softAssert.assertEquals(instructions.getInstructionDeleteCancelButtonCaption(),
				AtomHC.propData.getProperty("delete.page.cancel.label"),"delete page cancel label not match");
		softAssert.assertEquals(instructions.getInstructionDeleteOkButtonCaption(),
				AtomHC.propData.getProperty("delete.page.ok.label"),"Delete page 'OK' button not display");
		instructions.clickOnInstructionCancelButton();
		log("verify user navigates to instruction add/edit page, after clicking on cancel button");
		softAssert.assertEquals(instructions.getInstructionAddEditPageTitle(),
				AtomHC.propData.getProperty("instruction.add.edit.title"),"Instruction add/edit title not display");
		instructions.clickOnInstructionDeleteButton();
		instructions.clickOnInstructionDeleteOkButton();
		log("verify user navigates to instruction list page, after clicking on ok button");
		softAssert.assertTrue(instructions.isInstructionListPageDisplayed(),"Instruction list page not display");
		instructions.clickOnInstructionListRecord();
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnInstructionListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		instructions.clickOnInstructionCancelButton();
		log("Verify user navigates to instruction list page after clicking on cancel button");
		assertTrue(instructions.isInstructionListPageDisplayed());
	}

	@Test
	public void testLangErrorMsgIsDisplayedWhenInstructionDataIsNotEnteredForAllLang() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		instructions.sendInstructionName(AtomHC.propData.getProperty("instruction.edit.name"));
		instructions.sendInstructionDescription(AtomHC.propData.getProperty("instruction.edit.name"));
		instructions.clickOnFirstInstructionLang();
		instructions.sendInstructionNameOnFirstTextbox(AtomHC.propData.getProperty("instruction.edit.name"));
		instructions.sendInstructionForFirstDescriptionTextbox(AtomHC.propData.getProperty("instruction.edit.name"));
		instructions.clickOnInstructionSaveButton();
		log("verify language error message is displayed when user does enter data for all languages");
		assertEquals(instructions.getInstructionLanguageErrorMsg(), AtomHC.propData.getProperty("lang.error.message"));
	}

	@Test
	public void testErrorMsgIsDisplayedWhenMandatoryFieldDataForInstructionIsNotEntered() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		instructions.clickOnInstructionSaveButton();
		log("Verify error message is displayed for mandatory instruction fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getInstructionNameErrorMsg(),
				AtomHC.propData.getProperty("name.error.msg"));
		softAssert.assertEquals(instructions.getInstructionDescriptionErrorMsg(),
				AtomHC.propData.getProperty("description.error.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUserSavesInstructionSuccessfully() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Instructions instructions = new Instructions(driver);
		instructions.clickOnCareProgramTab();
		instructions.clickOnInstructionAddButton();
		String instructionName = AtomHC.propData.getProperty("instruction.name")+BasePageObject.createRandomCharacter(4);
		instructions.clickOnInstructionAddButton();
		instructions.createInstruction(instructionName, AtomHC.propData.getProperty("instruction.description"));
		log("Verify instruction list is displayed when user saves instruction successfully");
		assertTrue(instructions.isInstructionListPageDisplayed());
		instructions.selectInstructionListRecord(instructionName);
		log("verify instruction is added to the list");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(instructions.getInstructionNamePrefilledData(), instructionName);
		softAssert.assertEquals(instructions.getInstructionDeleteButtonCaption(),
				AtomHC.propData.getProperty("edit.page.delete.button"));
		instructions.clickOnInstructionDeleteButton();
		instructions.clickOnInstructionDeleteOkButton();
		softAssert.assertAll();
	}
}
