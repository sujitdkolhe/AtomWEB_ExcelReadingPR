package com.atom.healthcare.careprogram.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Programs.Educations;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class EducationsTests extends BaseTest {
	private static final boolean False = false;
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("usr"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Program Education list
	@Test
	public void testEducationListPageIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.clickOnCareProgramTabs();
		educations.clickOnProgramTab();
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		log("verify if education tab is getting displayed");
		assertEquals(educations.getEducationTabText(),
				AtomHC.propData.getProperty("education.tab.name"));
	}

	@Test
	public void testProgramEducationListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Programs programPage = new Programs(driver);
		programPage.clickOnCareProgramTab();
		programPage.clickOnProgramTab();
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
		Educations educations = new Educations(driver);
		educations.clickOnProgramListEducationTab();
		if(educations.isEducationListRecordDisplayed()) {
			log("Education is already present");
		}else {
			educations.clickOnProgramEducationAddButton();
			educations.addEducationInProgram(programName,  AtomHC.propData.getProperty("assign.after.days.edu"), 
					AtomHC.propData.getProperty("show.for,days.edu"));
		}
		educations.sendEducationSearchWord(programName);
		educations.selectProgramFromList();
		educations.searchProgramName(programName);
		
		//String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		//educations.openProgramAddPage();
		//educations.createProgram(prgramName);
		//educations.searchProgramName(prgramName);
		//educations.clickOnProgramListRecord();
		
		String educationTitle = educations.getProgramEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(educationHeader, "Educations");
		String educationCount = getTitle[1];
		String count = educationCount.substring(1, 2);
		log("Education List Count is: " + count);
		int title = Integer.parseInt(count);
		log("Create new education");
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationDropdown();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		int newCount = title + 1;
		log("Education List New Count is: " + newCount);
		log("verify all the fields of program Education list page");
		softAssert.assertTrue(educations.isEducationSearchboxDisplayed());
		softAssert.assertEquals(educations.getEducatiobListSearchPlaceholder(),
				AtomHC.propData.getProperty("subflow.searchtextbox.placeholder"));
		softAssert.assertEquals(educations.getOnProgramEducationAddButton(), AtomHC.propData.getProperty("add.button.caption"));
		softAssert.assertEquals(educations.getListHeaderAsEducation(),
				AtomHC.propData.getProperty("program.education.column.name"));
		softAssert.assertEquals(educations.getEducationForProviderListHeader(),
				AtomHC.propData.getProperty("program.education.for.provider.column.name"));
		softAssert.assertEquals(educations.getEducationAssignAfterDaysListHeader(),
				AtomHC.propData.getProperty("program.education.assign.after.days.column.name"));
		softAssert.assertEquals(educations.getEducationShowForDaysListHeader(),
				AtomHC.propData.getProperty("program.education.show.for.days.column.name"));
		softAssert.assertTrue(educations.isEducationListRecordDisplayed());
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testProgramEducationSearchboxText() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		educations.sendEducationSearchWord(selectCategory);
		log("Verify when user search valid data");
		String educationTitle = educations.getProgramEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		assertEquals(educationHeader, "Educations");
	}

	@Test
	public void testIfNoEducationAddedInEducationProgramPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.sendEducationSearchWord(AtomHC.propData.getProperty("search.education.invalid"));
		log("Verify when user enter invalid data");
		assertEquals(educations.getEducationRecordsFound(), AtomHC.propData.getProperty("dashboard.no.Message"));
	}

	// Program Education Add Edit
	@Test
	public void testUserNavigateToAddPageAndCheckAddPageField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		
		//educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		SoftAssert softAssert= new SoftAssert();
		log("Verify user navigate to add page and check Education add page field");
		softAssert.assertEquals(educations.getEducationHeadingLabel(), AtomHC.propData.getProperty("education.heading"));
		softAssert.assertTrue(educations.isProgramEducationCrossIconDisplayed());
		softAssert.assertEquals(educations.getEducationCategoryLabel(), AtomHC.propData.getProperty("education.category"));
		softAssert.assertTrue(educations.isProgramEducationCategoryTextboxDisplay());
		softAssert.assertEquals(educations.getEducationCategoryTextboxPlaceholder(),
				AtomHC.propData.getProperty("education.category.placeholder"));
		softAssert.assertEquals(educations.getEducationLabel(), AtomHC.propData.getProperty("get.education.label"));
		softAssert.assertTrue(educations.isProgramEducationTextboxDisplay());
		softAssert.assertEquals(educations.getEducationTextboxPlaceholder(),
				AtomHC.propData.getProperty("get.education.placeholder"));
		softAssert.assertEquals(educations.getEducationAssignAfterDaysLabel(),
				AtomHC.propData.getProperty("get.education.assign.after.days"));
		softAssert.assertTrue(educations.isProgramEducationAssignAfterDaysTextboxDisplay());
		softAssert.assertEquals(educations.getEducationAssignAfterDayTextboxPlaceholder(),
				AtomHC.propData.getProperty("get.placeholder"));
		softAssert.assertEquals(educations.getEducationShowForDaysLabel(),
				AtomHC.propData.getProperty("get.education.show.for.days"));
		softAssert.assertTrue(educations.isProgramEducationShowForDayTextboxDisplay());
		softAssert.assertEquals(educations.getEducationShowForDayTextboxPlaceholder(),
				AtomHC.propData.getProperty("show.for.days.placeholder"));
		softAssert.assertTrue(educations.isForProviderCheckboxDisplay());
		softAssert.assertEquals(educations.getForProviderLabel(), AtomHC.propData.getProperty("for.provider.label"));
		softAssert.assertEquals(educations.getEducationSaveButtonCaption(), AtomHC.propData.getProperty("save.button.caption"));
		softAssert.assertEquals(educations.getEducationCancelButtonCaption(), AtomHC.propData.getProperty("cancel.button"));
		softAssert.assertAll();
	}

	@Test
	public void testUserNavigateToEducationListPageWhenClickOnCrossIcon() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnEducationCrossIcon();
		log("Verify user click on cross icon it should navigate to education list page in program");
		String educationTitle = educations.getProgramEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		assertEquals(educationHeader, "Educations");
	}
		
	@Test (enabled=False)
	public void testEducationCategoryDropdownValue() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		List<String> actualEducationCategoryDropdownList = educations.getCategoryDropdownList();
		List<String> expectedEducationCategoryDropdownList = BasePageObject.readJsonFile(
				AtomHC.propData.getProperty("ques.default.respondant.dropdown.list"), "education category");
		log("Verify education category dropdown operation list");
		assertEquals(actualEducationCategoryDropdownList, expectedEducationCategoryDropdownList);
	}

	@Test (enabled=False)
	public void testUserSelectEducationCategoryDisplayInCategoryDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(4,3);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		log("Verify selected value display in category dropdown");
		assertTrue(educations.isSelectedValueDisplayInCategoryDropdown());
	}

	@Test (enabled=False)
	public void testUserSelectEducationValueItShouldDisplayInEducationDropdown() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.createProgram("Diet And Lifestyle" + BasePageObject.createRandomCharacter(2));
		educations.clickOnProgramListRecord();educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(4,9);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(15, 17);
		educations.clickOnEducationDropdown(selectEducation);
		log("Verify when user select education value it should be display ineducation dropdown");
		assertTrue(educations.isSelectedValueDisplayInEducationDropdown());
	}

	@Test
	public void testIfUserEnterWrongFormatInAssignAfterDaysTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		SoftAssert softAssert= new SoftAssert();
		log("Verify user enter everthing except the number in assign after days textbox");
		softAssert.assertEquals(educations.getEducationAssignAfterDayTextboxPlaceholder(),
				AtomHC.propData.getProperty("get.placeholder"));
		softAssert.assertTrue(educations.isProgramEducationAssignAfterDaysTextbox(
				AtomHC.propData.getProperty("enter.alphabets.assign.after.day")));
		softAssert.assertTrue(educations.isProgramEducationAssignAfterDaysTextbox(
				AtomHC.propData.getProperty("enter.special.char.assign.after.day")));
		softAssert.assertTrue(educations.isProgramEducationAssignAfterDaysTextbox(
				AtomHC.propData.getProperty("enter.enter.space.assign.after.day")));
		softAssert.assertTrue(educations.isProgramEducationAssignAfterDaysTextbox(
				AtomHC.propData.getProperty("enter.number.assign.after.day")));
		educations.clearTextAssignAfterDaysTextbox();
		educations.sendMoreThanFourDigit(AtomHC.propData.getProperty("enter.more.than.number.assign.after.day"));
		softAssert.assertEquals(educations.getErrorMsgInAssignAfterDays(),
				AtomHC.propData.getProperty("error.msg.in.assign.after.days"));
		softAssert.assertAll();
	}

	@Test
	public void testIfUserEnterWrongFormatInShowForDaysTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		SoftAssert softAssert= new SoftAssert();
		log("Verify user enter everthing except the number in show for days textbox");
		softAssert.assertEquals(educations.getEducationShowForDayTextboxPlaceholder(),
				AtomHC.propData.getProperty("show.for.days.placeholder"));
		softAssert.assertTrue(educations
				.isProgramEducationShowForDaysTextbox(AtomHC.propData.getProperty("enter.alphabets.show.for.day")));
		softAssert.assertTrue(educations
				.isProgramEducationShowForDaysTextbox(AtomHC.propData.getProperty("enter.special.char.show.for.day")));
		softAssert.assertTrue(educations
				.isProgramEducationShowForDaysTextbox(AtomHC.propData.getProperty("enter.enter.space.show.for.day")));
		softAssert.assertTrue(educations
				.isProgramEducationShowForDaysTextbox(AtomHC.propData.getProperty("enter.number.show.for.day")));
		educations.clearTextShowForDaysTextbox();
		educations.sendMoreThanFourDigitInShowForDays(AtomHC.propData.getProperty("enter.more.than.number.show.for.day"));
		softAssert.assertEquals(educations.getErrorMsgInShowForDays(), AtomHC.propData.getProperty("error.msg.in.show.for.days"));
		softAssert.assertAll();
	}

	@Test
	public void testIfUserClickOnSaveButtonWithoutEnteringData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickEducationSaveButton();
		SoftAssert softAssert= new SoftAssert();
		log("Verify error msg display when user click on save button without entering required fields");
		softAssert.assertEquals(educations.getErrorMsgCategoryIsRequired(), AtomHC.propData.getProperty("category.is.required"));
		softAssert.assertEquals(educations.getErrorMsgEducationIsRequired(), AtomHC.propData.getProperty("education.is.required"));
		softAssert.assertEquals(educations.getErrorMsgAssignAfterDaysIsRequired(),
				AtomHC.propData.getProperty("assign.after.dyas.required"));
				softAssert.assertEquals(educations.getErrorMsgShowForDayssRequired(),
						AtomHC.propData.getProperty("show.for.days.required"));
		softAssert.assertAll();
	}

	//If user check for provider checkbox and check the Education content show in My Education menu for provider only
	@Test(enabled=false)
	public void testIfUserCheckTheCheckboxAndClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(6,7);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(6, 7);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickOnForProviderCheckbox();
		log("Verify user tick provider note check box and click on save button");
		assertTrue(educations.isForProviderCheckboxCheckDisplay());
	}

	//If user uncheck for provider checkbox and check the Education content to patient when provider assigned to patient
	@Test(enabled=false)
	public void testIfUserWithoutTickCheckboxAndClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(5,4);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(5,4);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		log("Verify user does not tick provider note check box and click on save button");
		assertTrue(educations.isForProviderCheckboxCheckDisplay());
	}

	@Test(enabled=false)
	public void testIfUserWithoutFillMandetoryFieldAndClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(12,9);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		log("Verify when user not enter the mandetory field and click on save button");
		assertEquals(educations.getErrorMsgEducationIsRequired(), AtomHC.propData.getProperty("education.is.required"));
	}

	@Test(enabled=false)
	public void testUserEntersAllTheValidDetailsAndCLickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(12,9);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(15, 17);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		log("Verify when user enter the valid data and click on save button it should be navigate to education list page");
		String educationTitle = educations.getProgramEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		assertEquals(educationHeader, "Educations");
	}

	@Test(enabled=false)
	public void testIfUSerInEditPageCheckPrefilledDataAndDeleteButtonIsVisible() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		educations.clickOnEduactionRecord();
		SoftAssert softAssert= new SoftAssert();
		
		log("Verify prefilled data in education edit page and delete button is visible");
		softAssert.assertEquals(educations.getEducationHeadingLabel(), AtomHC.propData.getProperty("education.heading"));
		softAssert.assertEquals(educations.getCategoryPrefilledData(), selectCategory);
		softAssert.assertEquals(educations.getEducationPrefilledData(), selectEducation);
		softAssert.assertEquals(educations.getAssignAfterDaysPrefilledData(), assignAfterDays);
		softAssert.assertEquals(educations.getShowForDaysPrefilledData(), showForDays);
		softAssert.assertEquals(educations.getEducationDeleteButton(), AtomHC.propData.getProperty("get.delete.button.text"));
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testDeleteButtonFunctionality() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		educations.clickOnEduactionRecord();
		educations.clickOnEduactionDeleteButton();
		log("Verify delete page functionality");
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(educations.getEducationDeleteButtonPageHeading(),
				AtomHC.propData.getProperty("get.delete.button.text"));
		softAssert.assertTrue(educations.isProgramEducationDeletePageCrossIcon());
		softAssert.assertEquals(educations.getEducationDeleteMsg(), AtomHC.propData.getProperty("delete.confirmation.msg"));
		softAssert.assertEquals(educations.getEducationDeleteCancelButtonCaption(),
				AtomHC.propData.getProperty("get.delete.page.cancel.caption"));
		softAssert.assertEquals(educations.getEducationDeleteOkButtonCaption(),
				AtomHC.propData.getProperty("get.delete.page.ok.caption"));
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testUserNavigateToAddEditPageWhenClickOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		educations.clickOnEduactionRecord();
		educations.clickOnEduactionDeleteButton();
		educations.clickOnCancelButtonInEducationDeletePage();
		log("Verify user lands on education add edit page after clicking on cancel button");
		assertEquals(educations.getEducationHeadingLabel(), AtomHC.propData.getProperty("education.heading"));
	}

	@Test(enabled=false)
	public void testUserNavigateToEducationListPageWhenClickOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Educations educations = new Educations(driver);
		educations.openProgramAddPage();
		educations.clickOnProgramNameTextbox();
		String prgramName= "Diet And Lifestyle" + BasePageObject.createRandomCharacter(2);
		educations.createProgram(prgramName);
		educations.searchProgramName(prgramName);
		educations.clickOnProgramListRecord();
		educations.clickOnProgramListEducationTab();
		educations.clickOnProgramEducationAddButton();
		educations.clickOnProgramEduactionCategoryDropdown();
		String selectCategory = BasePageObject.getMinMaxRandomNumber(7,6);
		log("selectCategory "+selectCategory);
		educations.clickOnCategoryDropdown(selectCategory);
		educations.clickOnEducationCategory();
		String selectEducation = BasePageObject.getMinMaxRandomNumber(7, 6);
		educations.clickOnEducationDropdown(selectEducation);
		String assignAfterDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationAssignAfterDays(assignAfterDays);
		String showForDays = BasePageObject.createRandomNumericString(1);
		educations.sendEducationShowForDays(showForDays);
		educations.clickEducationSaveButton();
		educations.clickOnEduactionRecord();
		educations.clickOnEduactionDeleteButton();
		educations.clickOnOkButtonInEducationDeletePage();
		log("Verify user lands on education list page after click on ok button");
		String educationTitle = educations.getProgramEducationListTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		assertEquals(educationHeader, "Educations");
	}

}
