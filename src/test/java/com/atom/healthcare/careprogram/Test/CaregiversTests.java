package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Caregivers;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Users.UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class CaregiversTests extends BaseTest {

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// ProgramCaregiverList
	@Test(priority = 1)
	public void testProgramCaregiverListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname");
		if ((usersPage.isUserDisplay(userName))) {
			log("Caregiver already present");
		} else {
			usersPage.clickOnAddButton();
			usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
					"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		}
		Caregivers caregivers = new Caregivers(driver);
		usersPage.clickOnUserTab();
		assertTrue(caregivers.isCaregiverdisplay(userName));
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		program.clickOnProgramAddButton();
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		log("Program name " + programName);
		if(program.isProgramNameDisplay(programName)) {
			log("Program already present");
		}else {
			program.createProgram(programName);
		}
		;
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		String caregiverTitle = caregivers.getProgramCaregiverListTitle();
		String[] getTitle = caregiverTitle.split(" ");
		String caregiverHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiverHeader, "Caregivers");
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		caregivers.clickOnProgramCaregiver(userName);
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		log("verify all the fields of program caregiver list page");
		softAssert.assertTrue(caregivers.isCaregiverSearchTextboxDisplay(), "Craegiver search textbox not display");
		softAssert.assertEquals(caregivers.getCaregiverListSearchPlaceholder(),
				AtomHC.propData.getProperty("search.box"), "Search textbox not display");
		softAssert.assertEquals(caregivers.getCaregiverAddButtonCaption(),
				AtomHC.propData.getProperty("add.button.caption"), "Add caption not match");
		softAssert.assertEquals(caregivers.getCaregiverProviderListHeader(),
				AtomHC.propData.getProperty("default.respondant.value"), "Default respondant value not match");
		softAssert.assertEquals(caregivers.getCaregiverProfessionListHeader(),
				AtomHC.propData.getProperty("caregiver.profession.header"), "caregiver profession header not match");
		softAssert.assertEquals(caregivers.getCaregiverAssignAfterDaysListHeader(),
				AtomHC.propData.getProperty("assign.after.days.header"), "Assign after days header not match");
		softAssert.assertEquals(caregivers.getCaregiverShowForDaysListHeader(),
				AtomHC.propData.getProperty("show.for.days.header"), "Show for days header not match");
		softAssert.assertTrue(caregivers.isCaregiverListRecordDisplayed(),"Prtogram list record not Display");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void testProgramCaregiverSearchTextboxWithValidAndInvalidData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.sendProgramCaregiverSearchWord(AtomHC.propData.getProperty("chat.invalid.search.word"));
		log("Verify error message is displayed when user enter invalid word");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregivers.getCaregiverSearchNoRecordMsg(),
				AtomHC.propData.getProperty("no.record.found.msg"));
		caregivers.clearProgramCaregiverSearchWord();
		caregivers.clickOnProgramCaregiverAddButton();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname");
		caregivers.clickOnProgramCaregiver(userName);
		String editCaregiverName = caregivers.getSelectedCaregivername();
		log("Caregiver name " + editCaregiverName);
		String[] NewCargName = editCaregiverName.split("-");
		String c = NewCargName[1];
		String editededCaregiver = c.trim();
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		caregivers.programCaregiverSearchTexbox.click();
		caregivers.sendProviderNameInProgramCaregiverSearchTextbox(editededCaregiver);
		log("verify it allows to search caregiver with valid data");
		softAssert.assertEquals(caregivers.getProgramCaregiverListTitle(),
				AtomHC.propData.getProperty("subscribe.caregiver"));
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void testProgramCaregiverAddPageIsDisplayedWhenUserClicksOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		log("Verify user lands on caregiver add page after clicking on add button");
		assertEquals(caregivers.getProgramCaregiverAddPageTitle(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"));
	}

	@Test(priority = 4)
	public void testProgramCaregiverEditPageIsDisplayedWhenUserClicksOnAddedCaregiver() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnSubscribedProgramCaregiverRow();
		log("Verify user lands on caregiver edit page after clicking on add button");
		assertEquals(caregivers.getProgramCaregiverAddPageTitle(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"));
	}

	@Test(priority = 5)
	public void testProgramCaregiverAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		log("Verify program caregiver add page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregivers.getProgramCaregiverAddPageTitle(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"), "Caregiver add edit header not match");
		softAssert.assertTrue(caregivers.isTaskAddPageCrossIconDisplayed(), "Cross icon not display");
		softAssert.assertEquals(caregivers.getCaregiverProviderLabel(), AtomHC.propData.getProperty("provider.label"),
				"Provider label not match");
		softAssert.assertTrue(caregivers.isCaregiverProviderDropdownDisplayed(), "Provider dropdown not display");
		softAssert.assertEquals(caregivers.getCaregiverProviderPlaceholder(),
				AtomHC.propData.getProperty("default.respondant.value"), "Default respondant value not match");
		softAssert.assertEquals(caregivers.getCaregiverAssognAfterDaysLabel(),
				AtomHC.propData.getProperty("caregiver.assign.after.days"), "Assign after days label not display");
		softAssert.assertTrue(caregivers.isCaregiverAssignAfterDaysTextboxDisplayed(),
				"Assign after days text box not display");
		softAssert.assertEquals(caregivers.getCaregiverShowForDaysLabel(),
				AtomHC.propData.getProperty("caregiver.show.for.days"), "Show for days not match");
		softAssert.assertTrue(caregivers.isCaregiverShowForDaysTextboxDisplayed(), "Show for days textbox not display");
		softAssert.assertEquals(caregivers.getProgramCaregiverSaveButtonCaption(),
				AtomHC.propData.getProperty("save.button.caption"), "Save button caption not match");
		softAssert.assertEquals(caregivers.getProgramCaregiverCancelButtonCaption(),
				AtomHC.propData.getProperty("cancel.button"), "Cancel button caption not match");
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void testUserLandsOnProgramCaregiverListPageAfterClickingOnCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnAddCaregiverPageCrossIcon();
		log("Verify user navigates to program caregiver list page after clicking on cross icon");
		assertTrue(caregivers.isCaregiverListRecordDisplayed(), "Caregiver list record not display");
	}

	@Test(priority = 7)
	public void testUserLandsOnProgramCaregiverListPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnAddCaregiverPageCancelButton();
		log("Verify user navigates to program caregiver list page after clicking on cancel button");
		assertTrue(caregivers.isCaregiverListRecordDisplayed(), "Caregiver list record not display");
	}

	@Test(priority = 8)
	public void testCaregiverAddPageProviderListPageIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		log("Verify provider list is displayed after clicking on provider dropdown");
		assertTrue(caregivers.isCaregiverAddPageProviderListDisplayed(), "Caregiver list record not display");
	}

	@Test(priority = 9)
	public void testProgramCaregiverNameSelectedFromProviderDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname");
		caregivers.clickOnProgramCaregiver(userName);
		log("verify provider name is selected from provider dropodwn");
		assertEquals(caregivers.getSelectedCaregivername(), userName, "Selected program name not match");
	}

	@Test(enabled = false, priority = 10) // check and correct
	public void testProgramCaregiverAssignAfterDaysAndShowForDyasFieldsDoNotAcceptAnyThingOtherThanNumbers()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers
				.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("caregiver.assign.after.days"));
		log("verify assign after days textbox do not accept anything other than numbers");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(caregivers.isCaregiverAddPageAssignAfterDaysTextboxEmpty(),
				"Assign after days text box is not empty");
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("caregiver.show.for.days"));
		log("verify show for days textbox do not accept anything other than numbers");
		softAssert.assertTrue(caregivers.isCaregiverAddPageShowForDaysTextboxEmpty(),"show for days not match");
		softAssert.assertAll();
	}

	@Test(priority = 11)
	public void testProgramCaregiverAddPageRequiredMessageIsDisplayedWhenDataIsNotAdded() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clearCaregiverShowForDaysTextbox();
		caregivers.clickCaregiverShowForDaysTextbox();
		assertEquals(caregivers.isCaregiverShowForDaysTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"), "Error color is not display");
		assertEquals(caregivers.getCaregiverShowForDaysRequiredMessage(),
				AtomHC.propData.getProperty("show.for.days.required.msg"), "Show for days requird message not match");
		caregivers.clearCaregiverAssignAfterDaysTextbox();
		assertEquals(caregivers.isCaregiverAssignAfterDaysTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"), "Error color is not display");
		assertEquals(caregivers.getCaregiverAssignAfterDaysRequiredMessage(),
				AtomHC.propData.getProperty("assign.after.days.required.msg"),
				"Show for days requird message not match");
		caregivers.clickOnProgramCaregiverSaveButton();
		log("Verify error message is displayed for mandatory fields");
		assertEquals(caregivers.getProviderFieldRequiredMsg(), AtomHC.propData.getProperty("provider.required.msg"),
				"field required message not display");
	}

	@Test(priority = 12)
	public void testProgramCaregiverShowForDaysFieldRangeMessageIsDisplayedWhenDataIsOutOfRange() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramCaregiverSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("verify range message is displayed when the show for days value is out of range");
		softAssert.assertEquals(caregivers.isCaregiverShowForDaysTextboxErrorColorDisplayed(),
				AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(caregivers.getCaregiverShowForDaysRangeErrorMessage(),
				AtomHC.propData.getProperty("show.for.days.range.msg"));
	}

	@Test(priority = 13)
	public void testUserSuccessfullyAddsCaregiverToTheProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname")
				+ BasePageObject.createRandomCharacter(4);
		if ((usersPage.isUserDisplay(userName))) {
			log("Caregiver already present");
		} else {
			usersPage.clickOnAddButton();
			usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
					"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		}
		Caregivers caregivers = new Caregivers(driver);
		usersPage.clickOnUserTab();
		assertTrue(caregivers.isCaregiverdisplay(userName));
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		program.clickOnProgramAddButton();
		String programName = "Alphamd" + BasePageObject.createRandomCharacter(4);
		log("Program name " + programName);
		program.createProgram(programName);
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		String caregiverTitle = caregivers.getProgramCaregiverListTitle();
		String[] getTitle = caregiverTitle.split(" ");
		String caregiverHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiverHeader, "Caregivers");
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		caregivers.clickOnProgramCaregiver(userName);
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		caregivers.clickOnProgramCaregiverListRecord();
		log("verify user successfully add a creagiver to the program");
		assertEquals(caregivers.getProgramSelectedCaregivername(), userName,"Caregiver name not match");
	}

	@Test(priority = 14)
	public void testDuplicateDataErrorMessageIsDisplayedForProgramCaregiver() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregivers = new Caregivers(driver);
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname");
		caregivers.clickOnProgramCaregiver(userName);
		caregivers.getSelectedCaregivername();
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		log("verify Duplicate Data message for caregiver is visible");
		assertEquals(caregivers.getDuplicateDataErrorLabel(),
				AtomHC.propData.getProperty("get.error.msg.duplicate.data"));
	}

	@Test(priority = 15)
	public void testProgramCaregiverEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname")
				+ BasePageObject.createRandomCharacter(4);
		if ((usersPage.isUserDisplay(userName))) {
			log("Caregiver already present");
		} else {
			usersPage.clickOnAddButton();
			usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
					"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		}
		Caregivers caregivers = new Caregivers(driver);
		usersPage.clickOnUserTab();
		assertTrue(caregivers.isCaregiverdisplay(userName));
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		program.clickOnProgramAddButton();
		String programName = "Alphamd" + BasePageObject.createRandomCharacter(4);
		log("Program name " + programName);
		program.createProgram(programName);
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		String caregiverTitle = caregivers.getProgramCaregiverListTitle();
		String[] getTitle = caregiverTitle.split(" ");
		String caregiverHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiverHeader, "Caregivers");
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		caregivers.clickOnProgramCaregiver(userName);
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		caregivers.clickOnProgramCaregiverListRecord();
		log("Verify Caregiver Edit Page Fields");
		softAssert.assertEquals(caregivers.getProgramCaregiverAddPageTitle(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"));
		softAssert.assertEquals(caregivers.getSelectedCaregivername(), userName);
		softAssert.assertEquals(caregivers.getCaregiverAssignAfterDaysPrefilledData(),
				AtomHC.propData.getProperty("assign.after.days"));
		softAssert.assertEquals(caregivers.getCaregiverShowForDaysPrefilledData(),
				AtomHC.propData.getProperty("show.for.days"));
		softAssert.assertEquals(caregivers.getCaregiverDeleteButton(),
				AtomHC.propData.getProperty("edit.page.delete.button"));
		caregivers.clickOnCaregiverDeleteButton();
		caregivers.clickOnCaregiverDeleteOkButton();
	}

	@Test(priority = 16)
	public void testProgramCaregiverDeletePageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname")
				+ BasePageObject.createRandomCharacter(4);
		usersPage.clickOnAddButton();
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		Caregivers caregivers = new Caregivers(driver);
		usersPage.clickOnUserTab();
		assertTrue(caregivers.isCaregiverdisplay(userName));
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		program.clickOnProgramAddButton();
		String programName = "Alphamd" + BasePageObject.createRandomCharacter(4);
		log("Program name " + programName);
		program.createProgram(programName);
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		String caregiverTitle = caregivers.getProgramCaregiverListTitle();
		String[] getTitle = caregiverTitle.split(" ");
		String caregiverHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiverHeader, "Caregivers");
		caregivers.clickOnProgramCaregiverAddButton();
		caregivers.clickOnProgramProviderDropdown();
		caregivers.clickOnProgramCaregiver(userName);
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		caregivers.clickOnProgramCaregiverListRecord();
		caregivers.clickOnCaregiverDeleteButton();
		log("Verify Caregiver Delete Page Fields");
		softAssert.assertEquals(caregivers.getDeleteLabel(), AtomHC.propData.getProperty("delete.page.label"),
				"Delete label not Match");
		softAssert.assertEquals(caregivers.getDeleteConfirmationMsg(),
				AtomHC.propData.getProperty("delete.page.confirm.message"), "Delete page Confirm message not match");
		softAssert.assertEquals(caregivers.getCaregiverDeleteCancelButton(),
				AtomHC.propData.getProperty("delete.page.cancel.label"), "Delete page cancel label not match");
		softAssert.assertEquals(caregivers.getCaregiverDeleteOkButton(),
				AtomHC.propData.getProperty("delete.page.ok.label"), "Delete page ok button not match");
		caregivers.clickOnCaregiverDeleteCancelButton();
		log("verify user navigates to caregiver add/edit page, after clicking on cancel button");
		softAssert.assertEquals(caregivers.getProgramCaregiverAddPageTitle(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"), "caregiver add/edit header not match");
		caregivers.clickOnCaregiverDeleteButton();
		caregivers.clickOnCaregiverDeleteOkButton();
		caregivers.sendProgramCaregiverSearchWord(userName);
		log("Verify error message is displayed when user enter deleted record name");
		softAssert.assertEquals(caregivers.getCaregiverSearchNoRecordMsg(),
				AtomHC.propData.getProperty("no.record.found.msg"), "No record found messge not display");
		softAssert.assertAll();
	}

	@Test
	public void testUserCanEditAndUpdateProgramCaregiverFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		String newUserName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname")
				+ BasePageObject.createRandomCharacter(4);
		usersPage.clickOnAddButton();
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		Caregivers caregivers = new Caregivers(driver);
		usersPage.clickOnUserTab();
		assertTrue(caregivers.isCaregiverdisplay(newUserName));
		caregivers.clickOnCareProgramTab();
		caregivers.clickOnProgramTab();
		Programs program = new Programs(driver);
		String programName = "Alphamd" + AtomHC.propData.getProperty("new.program.name");
		program.selectProgram(programName);
		caregivers.clickOnProgramCaregiverTab();
		String userName = AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname");
		caregivers.clickOnCaregiver(userName);
		caregivers.clickOnProgramProviderDropdown();
		caregivers.clickOnProgramCaregiver(newUserName);
		caregivers.getSelectedCaregivername();
		caregivers.sendProgramCaregiverAssignAfterDaysNumber(AtomHC.propData.getProperty("assign.after.days"));
		caregivers.sendProgramCaregiverShowForDaysNumber(AtomHC.propData.getProperty("show.for.days"));
		caregivers.clickOnProgramCaregiverSaveButton();
		log("verify user can edit and update program caregiver");
		assertEquals(caregivers.getSelectedCaregivername(), newUserName,"Caregiver name not match");
	}

}
