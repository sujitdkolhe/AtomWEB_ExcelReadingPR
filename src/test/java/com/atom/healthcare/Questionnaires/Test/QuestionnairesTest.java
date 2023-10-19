package com.atom.healthcare.Questionnaires.Test;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Questionnaires.Questionnaires;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class QuestionnairesTest extends BaseTest {
	HealthcareLogin loginPage;
	
	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		appointemetPage.login(AtomHC.propData.getProperty("om.user.emailid"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("om.user.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Questionnaire list
	@Test
	public void testQuestionnairPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		log("Verify Questionnair page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(quesPage.isQuestionnaireSearchTextboxDisplay());
		softAssert.assertEquals(quesPage.getSearchTextboxPlaceholder(), "Search");
		softAssert.assertTrue(quesPage.isAddButtonDisplay());
		softAssert.assertTrue(quesPage.isQuestionnairesListDisplay());
		softAssert.assertTrue(quesPage.isCardFormatDisplay());
		softAssert.assertTrue(quesPage.isQuestionCreatedDateDisplay());
		softAssert.assertTrue(quesPage.isNumberOfQuestionDisplay());
		softAssert.assertTrue(quesPage.isQuestionSubscaleDisplay());
		softAssert.assertTrue(quesPage.isQuestionnaireStatusDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testSearchBoxWithValidData() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.enterTextInSearchTextbox(AtomHC.propData.getProperty("questionnaire.name"));
		log("Verify SearchBox With Invalid Data");
		assertTrue(quesPage.isQuestionnairesName());
	}

	@Test
	public void testSearchBoxWithInvalidData() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.enterTextInSearchTextbox(AtomHC.propData.getProperty("invalid.text"));
		log("Verify SearchBox With Invalid Data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getNoRecordFoundMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
		softAssert.assertTrue(quesPage.isQuestionnairesListDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testClearTextEnteredInSearchbox() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.enterTextInSearchTextbox(AtomHC.propData.getProperty("invalid.text"));
		log("Verify SearchBox With Invalid Data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getNoRecordFoundMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
		quesPage.clearTextInSearchTextbox();
		driver.navigate().refresh();
		softAssert.assertTrue(quesPage.isQuestionnairesListDisplay());
		driver.navigate().refresh();
		String title = quesPage.getQuestionnaireTitle();
		String[] getTitle = title.split(" ");
		String quesTitle = getTitle[0];
		softAssert.assertEquals(quesTitle, "Questionnaires");
		softAssert.assertAll();
	}

	@Test
	public void testClickOnQuestionnaireListSystemShouldNavigateToQuestionnaireAddPage()
			throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		log("Verify System should navigate to add/Edit page");
		assertTrue(quesPage.isQuestionnaireTitleDisplay());
	}

	@Test
	public void testSystemShouldNavigateToQuestionnaireAddEditPage() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		log("Verify System should navigate to add/Edit page");
		assertTrue(quesPage.isQuestionnaireTitleDisplay());
	}

	@Test
	public void testUserLandsOnQuestionnairesPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		String title = quesPage.getQuestionnaireTitle();
		String[] getTitle = title.split(" ");
		String quesTitle = getTitle[0];
		assertEquals(quesTitle, "Questionnaires");
	}

	@Test
	public void testNoRecordFoundMsgOnQuesPage() throws Exception, IOException {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		String title = quesPage.getQuestionnaireTitle();
		String[] getTitle = title.split(" ");
		String quesTitle = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesTitle, "Questionnaires");
		log("verify if no record found message is displayed");
		softAssert.assertEquals(quesPage.getNoRecordFoundMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
	}
	
	//1.SetupQuestionnaire
		@Test
		public void testQuestionnairesAddEditPageFields() throws   Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			log("Verify Questionnnaires add/Edit page fields");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(quesPage.isQuestionnaireTitleDisplay());
			softAssert.assertTrue(quesPage.isQuestionnaireCancelButtonDisplay());
			softAssert.assertFalse(quesPage.isPublishStatusDisplay());
			softAssert.assertTrue(quesPage.isQuestionnaireTabDisplay());
			softAssert.assertTrue(quesPage.isQuestionsTabDisplay());
			softAssert.assertTrue(quesPage.isQuestionnaireQuesTabDisplay());
			softAssert.assertTrue(quesPage.isScoreTypeTabDisplay());
			softAssert.assertTrue(quesPage.isQuestionScoresTabDisplay());
			softAssert.assertTrue(quesPage.isSubscalesTabDisplay());
			softAssert.assertTrue(quesPage.isQuestionnaireActiveElement());
			log("Verify Questionnnaires add/Edit page labels");
			softAssert.assertEquals(quesPage.getQuestionnaireHeader(),AtomHC.propData.getProperty("questionnaire.header"));
			softAssert.assertEquals(quesPage.get1QuestionnaireTitle(),AtomHC.propData.getProperty("questionnaire.title"));
			softAssert.assertEquals(quesPage.getSaveAndNextLabelText(), AtomHC.propData.getProperty("save.and.next.label"));
			softAssert.assertEquals(quesPage.getQuestionnnaireTypeLabelText(), AtomHC.propData.getProperty("ques.type.label"));
			softAssert.assertEquals(quesPage.getCodeLabelText(), AtomHC.propData.getProperty("code.label"));
			softAssert.assertEquals(quesPage.getQuesDefaultRespodantLabelText(),
					AtomHC.propData.getProperty("ques.default.resp.label"));
			softAssert.assertEquals(quesPage.getQuestionnnaireTitleLabelText(), AtomHC.propData.getProperty("ques.title.label"));
			softAssert.assertEquals(quesPage.getInstructionsLabelText(), AtomHC.propData.getProperty("instruction.label"));
			softAssert.assertTrue(quesPage.isQuestTypeTextboxDisplay());
			softAssert.assertTrue(quesPage.isCodeTextboxDisplay());
			softAssert.assertTrue(quesPage.isQuestDefaultRespondantTextboxDisplay());
			softAssert.assertTrue(quesPage.isQuestTitleTextboxDisplay());
			softAssert.assertTrue(quesPage.isInstructionsTextboxDisplay());
			log("Verify Questionnnaires add/Edit page fields");
			softAssert.assertEquals(quesPage.getQuestTypeTextboxPlaceholder(), AtomHC.propData.getProperty("ques.type.placeholder"));
			softAssert.assertEquals(quesPage.getCodeTextboxPlaceholder(), AtomHC.propData.getProperty("enter.code.placeholder"));
			softAssert.assertEquals(quesPage.getQuestDefaultRespondantTextboxPlaceholder(),
					AtomHC.propData.getProperty("ques.def.respo.placeholder"));
			softAssert.assertEquals(quesPage.getQuestTitleTextboxPlaceholder(),
					AtomHC.propData.getProperty("question.title.placeholder"));
			softAssert.assertAll();
		}

		@Test
		public void testSystemNavigateToQuestionnaireListPageOnClicksOnCancelButton() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnCancelButton();
			String title = quesPage.getQuestionnaireTitle();
			String[] getTitle = title.split(" ");
			String quesTitle = getTitle[0];
			log("Verify It Navigate to Questionnaire list page,On Click Cancel Button");
			assertEquals(quesTitle, "Questionnaires");
		}

		@Test
		public void testSystemShouldDisplayQuestionnaireTypeDropdownList() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnQusetionnaireTypeDropdown();
			List<String> actualQuesTypeList = quesPage.getQuesTypeDropdownList();
			List<String> expectedQuesTypeList = BasePageObject
					.readJsonFile(AtomHC.propData.getProperty("ques.type.dropdown.list"), "quesTypeDropdownList");
			log("Verify Questionnaire type dropdown list");
			assertEquals(actualQuesTypeList, expectedQuesTypeList);
		}
		
		@Test
		public void testVerifyQuestionnaireTypeSelectedValue() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnStandardQuesType();
			log("Verify It display Questionnaire Type Selected Value");
			assertEquals(quesPage.getPrefilledQuestionnaireType(), AtomHC.propData.getProperty("ques.type"));
		}

		@Test
		public void testSystemShouldDisplayQuestionnaireDefaultRespondantList() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnQuestDefaultRespondantDropdown();
			List<String> actualQuesTypeList = quesPage.getQuestDefaultRespondantList();
			List<String> expectedQuesTypeList = BasePageObject.readJsonFile(
					AtomHC.propData.getProperty("ques.default.respondant.dropdown.list"),
					"quesDefaultRespondantDropdownList");
			log("Verify Questionnaire Default Respondant list");
			assertEquals(actualQuesTypeList, expectedQuesTypeList);
		}

		@Test
		public void testSystemShouldDisplayQuestionnaireDefaultRespondantSelectedValue() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnQuestDefaultRespondantDropdown();
			quesPage.clickOnProviderDefaultRespondant();
			log("Verify It display Questionnaire Default Respondant Selected Value");
			assertEquals(quesPage.getQuestDefaultRespondantSelectedValue(),
					AtomHC.propData.getProperty("default.respondant.value"));
		}

		@Test
		public void testVerifySetupQuestionnaireRequiredFieldsGetHighlightedOnClickSaveAndNextButton() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnSaveAndNext();
			log("Verify Required Fields get higlight");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesPage.isQuestTypeTextboxHighlight(), AtomHC.propData.getProperty("error.color"));
			softAssert.assertEquals(quesPage.isCodeTextboxHighlight(), AtomHC.propData.getProperty("error.color"));
			softAssert.assertEquals(quesPage.isQuesDefaultRespondantTextboxHighlight(), AtomHC.propData.getProperty("error.color"));
			softAssert.assertEquals(quesPage.isQuesTitleTextboxHighlight(), AtomHC.propData.getProperty("error.color"));
			softAssert.assertAll();
		}
		
		@Test
		public void testVerifyIfAnyMandotoryFieldsNotFilledInSetupQuestionnaireThenTextboxShouldHighlighted() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			String code = "Code" + BasePageObject.createRandomCharacter(2);
			quesPage.enterCode(code);
			quesPage.clickOnProviderDefaultRespondant();
			String title = "Test" + BasePageObject.createRandomCharacter(2);
			quesPage.enterQuesTitle(title);
			quesPage.clickOnSaveAndNext();
			log("Verify If Any One Fields Not Filled, Required Fields get higlight");
			assertEquals(quesPage.isQuestTypeTextboxHighlight(), AtomHC.propData.getProperty("error.color"));
		}

		@Test (enabled=false)
		public void testVerifyDuplicateErrorMessageGetDisplayIfUserEnterSameCodeNameWhichIsUsedBefore() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnStandardQuesType();
			quesPage.enterCode(AtomHC.propData.getProperty("same.code"));
			quesPage.clickOnProviderDefaultRespondant();
			quesPage.enterQuesTitle(AtomHC.propData.getProperty("ques.title"));
			quesPage.clickOnSaveAndNext();
			log("Verify Duplicate Error Message Display, If Same Code Name user Before");
			assertEquals(quesPage.getCodeDuplicateErrorMessage(), AtomHC.propData.getProperty("code.error"));
		}

		@Test
		public void testVerifySetupQuestionnaireRequiredFieldsErrorMessage() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnSaveAndNext();
			log("Verify Required gets Error Message");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesPage.getQuesTypeErrorMessage(), AtomHC.propData.getProperty("ques.type.error.message"));
			softAssert.assertEquals(quesPage.getCodeErrorMessage(), AtomHC.propData.getProperty("code.error.message"));
			softAssert.assertEquals(quesPage.getQuesDefaultRespondantErrorMessage(),
					AtomHC.propData.getProperty("quest.default.error.message"));
			softAssert.assertEquals(quesPage.getQuesTitleErrorMessage(), AtomHC.propData.getProperty("quest.title.error.message"));
			softAssert.assertAll();
		}

		@Test
		public void testVerifyEnteredAllValidDetailsInSetupQuestionnaire() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			String code = "Code" + BasePageObject.createRandomCharacter(2);
			String title = "Test" + BasePageObject.createRandomCharacter(2);
			quesPage.createStandardQuesType(code,title);
			log("Verify it navigate to Step 2.Questions, After Entering Valid Details");
			assertEquals(quesPage.getStep2QuestionHeader(), AtomHC.propData.getProperty("step2.question.header"));
		}

		@Test
		public void testVerifyStep1QuestionnairePrefilledData() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			String code = "Code" + BasePageObject.createRandomCharacter(2);
			String title = "Test" + BasePageObject.createRandomCharacter(2);
			quesPage.createStandardQuesType(code,title);
			quesPage.clickOnSaveAndNext();
			quesPage.clickOnCancelButton();
			quesPage.clickOnNewAddedQuestionnaire(title);
			log("Verify it Step 1.Questionnaire Prefilled Date");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesPage.getPrefilledQuestionnaireType(), AtomHC.propData.getProperty("ques.type"));
			softAssert.assertEquals(quesPage.getPrefilledCode(), code);
			softAssert.assertEquals(quesPage.getPrefilledQuestionnaireDefaultRespondant(),
					AtomHC.propData.getProperty("ques.default.respondant"));
			softAssert.assertEquals(quesPage.getPrefilledQuestionnaireTitle(), title);
			softAssert.assertAll();
		}

	// 2.Setup Question
	@Test
	public void testSetupQuestionTimelineIsEnabled() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnAddButton();
		quesPage.clickOnStandardQuesType();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		quesPage.enterCode(code);
		quesPage.clickOnProviderDefaultRespondant();
		quesPage.enterQuesTitle(AtomHC.propData.getProperty("ques.title"));
		quesPage.clickOnSaveAndNext();
		log("Verify it navigate to Step 2.Questions, After Entering Valid Details");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getStep2QuestionHeader(), AtomHC.propData.getProperty("step2.header"));
		String title = quesPage.getQuestionsCountLabel();
		String[] getTitle = title.split(" ");
		String quesTitle = getTitle[0];
		softAssert.assertEquals(quesTitle, "Questions");
		softAssert.assertTrue(quesPage.isQuestionsSearchTextbox());
		softAssert.assertTrue(quesPage.isQuestionsAddButton());
		softAssert.assertEquals(quesPage.getQuestionsViewQuestionTableLabel(),
				AtomHC.propData.getProperty("question.table.label"));
		softAssert.assertEquals(quesPage.getQuestionsViewQuestionTypeTableLabel(),
				AtomHC.propData.getProperty("question.type.table.label"));
		softAssert.assertEquals(quesPage.getQuestionsViewMedicalHistoryTableLabel(),
				AtomHC.propData.getProperty("question.medical.table.label"));
		softAssert.assertEquals(quesPage.getQuestionsViewIsRequiredTableLabel(),
				AtomHC.propData.getProperty("question.required.table.label"));
		softAssert.assertEquals(quesPage.getQuestionsViewListerrorLabel(), AtomHC.propData.getProperty("search.norecords.label"));
		softAssert.assertAll();
	}

	@Test
	public void testWhenClickOnSetupQuestionTimelineIsDisplayExistingQuestionaireQuestionList()
			throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		log("verify Display Existing Questionaire Question List");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getQuestionsLabel(), AtomHC.propData.getProperty("question.label"));
		softAssert.assertTrue(quesPage.isQuestionsViewListRow());

	}

	@Test
	public void testQuestionTabSearchBoxWithValidData() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		quesPage.clickOnSearchTextbox();
		quesPage.enterTextInSearchTextbox(AtomHC.propData.getProperty("question.name"));
		log("Verify SearchBox With Invalid Data");
		assertTrue(quesPage.isQuestionsViewListRow());

	}

	@Test
	public void testQuestionTabSearchBoxWithInvalidData() throws   Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		log("Verify SearchBox With Invalid Data");
		SoftAssert softAssert = new SoftAssert();
		quesPage.clickOnSearchTextbox();
		quesPage.enterTextInSearchTextbox(AtomHC.propData.getProperty("invalid.text"));
		softAssert.assertEquals(quesPage.getQuestionsViewListerrorLabel(), AtomHC.propData.getProperty("no.record.found.msg"));
		quesPage.clickOnSearchTextbox();
		quesPage.clearTextInSearchTextbox();
		log("Clear Search TextBox and Verify display all list again ");
		String title = quesPage.getQuestionsCountLabel();
		String[] getTitle = title.split(" ");
		String quesTitle = getTitle[0];
		String quesCount = getTitle[1];
		softAssert.assertEquals(quesTitle, "Questions");

	}
	@Test
	public void testWhenclickOnColumnHeaderSortDataAccordingInTheList  () throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		log("Verify click on list header data will sort According In The List ");
		quesPage.clickOnQuestionsViewQuestionTableLabel();
		
		
	}
	@Test
	public void testClickOnAddButtonItsNagivatedToAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		log("Verify In Question Tab, click on add button its navigated to Ouestion Add Page");
		quesPage.clickOnQuestionsTabAddButton();
		assertEquals(quesPage.getQuestionsAddPageLabel(), AtomHC.propData.getProperty("questions.add.page.label"));

	}

	@Test
	public void testClickOnListRowItsNagivatedToEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnQuestionnairesName();
		quesPage.clickOnQuestionsTab();
		log("Verify In Question Tab, click on row list its navigated to Ouestion Edit Page");
		quesPage.clickOQuestionsViewListRow();
		assertEquals(quesPage.getQuestionsAddPageLabel(), AtomHC.propData.getProperty("questions.edit.page.label"));
	}

	@Test
	public void testClickOnSaveAndNextItsNagivatedToQuestionnaireQuestionsPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Questionnaires quesPage = new Questionnaires(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		quesPage.clickOnAddButton();
		quesPage.clickOnStandardQuesType();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		quesPage.enterCode(code);
		quesPage.clickOnProviderDefaultRespondant();
		quesPage.enterQuesTitle(AtomHC.propData.getProperty("ques.title"));
		quesPage.clickOnSaveAndNext();
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.clickOnTextDropdown();
		quesPage.checkIsRequiredKeycheckbox();
		quesPage.clickOnQuestionAddMinTextbox();
		quesPage.sendQuestionAddMinTextbox(AtomHC.propData.getProperty("question.type.min"));
		quesPage.clickOnQuestionAddMaxTextbox();
		quesPage.sendQuestionAddMaxTextbox(AtomHC.propData.getProperty("question.type.max"));
		quesPage.clickOnTextboxQuestionTextbox();
		quesPage.sendTextboxQuestionTextbox(AtomHC.propData.getProperty("rich.textbox.question.textbox"));
		quesPage.clickOnQuestionAddSaveButton();
		log("Verify In Question Tab, click on Save And Next Its Nagivated To Questionnaire questions Page");
		quesPage.clickOnQuestionsSaveAndNextLabel();
		assertEquals(quesPage.getQuestionnaireQuestionsHeaderLabel(),
				AtomHC.propData.getProperty("questionnaire.questions.header.label"));
	}

	
	// Setup Question Add Edit

		@Test
		public void testQuestionAddEditPageField() throws Exception {
			
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
	
			log("Verify When Clicks On Add Button In Questionaires Question List Page its navigated to Add edit page");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesPage.getQuestionTabAddEditLabel(), AtomHC.propData.getProperty("question.tab.add.edit.label"));
			softAssert.assertEquals(quesPage.getQuestionAddQuestionTypeLabel(),
					AtomHC.propData.getProperty("question.add.question.type.label"));
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			List<String> actualQuesTypeList = quesPage.getQuestionAddQuestionTypeList();
			List<String> expectedQuesTypeList = BasePageObject.readJsonFile(
					AtomHC.propData.getProperty("question.add.question.type.dropdown.list"),
					"qestionAddQuestionTypeDropdownList");
			log("Verify Question type dropdown list");
			softAssert.assertEquals(actualQuesTypeList, expectedQuesTypeList);
			softAssert.assertEquals(quesPage.getQuestionsViewMedicalHistoryTableLabel(),
					AtomHC.propData.getProperty("question.add.checkbox2.label"));
			softAssert.assertEquals(quesPage.getQuestionsViewIsRequiredTableLabel(),
					AtomHC.propData.getProperty("question.add.checkbox1.label"));
			softAssert.assertEquals(quesPage.getQuestionAddQuestionLabel(),
					AtomHC.propData.getProperty("question.add.question.label"));
			softAssert.assertTrue(quesPage.isQuestionAddQuestionRichTextbox());
			softAssert.assertEquals(quesPage.getQuestionAddEnterAnswerPlaceholderLabel(),
					AtomHC.propData.getProperty("question.add.enter.answer.label"));
			softAssert.assertEquals(quesPage.getQuestionAnswerPlaceHolderText(),
					AtomHC.propData.getProperty("question.add.answer.placeholder.label"));
			softAssert.assertTrue(quesPage.isQuestionAddEnterAnswerPlaceholderTextbox());
			softAssert.assertEquals(quesPage.getQuestionAddInstructionsLabel(),
					AtomHC.propData.getProperty("question.add.instructions.label"));
			softAssert.assertTrue(quesPage.isQuestionAddInstructionsTextbox());
			softAssert.assertTrue(quesPage.isQuestionAddSaveButton());
			softAssert.assertTrue(quesPage.isQuestionAddCancelButton());
			softAssert.assertAll();

		}

		@Test
		public void testWhenClickOnCrossIconItsNavigatedToQuestionlistPage()
				throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			quesPage.clickOnQuestionAddCancelIcon();
			assertEquals(quesPage.getStep2QuestionHeader(), AtomHC.propData.getProperty("step2.header"));
		}

		@Test
		public void testQuestionTypeDropdownList() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify Question Type Dropdown List");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			List<String> actualQuesTypeList = quesPage.getQuestionAddQuestionTypeList();
			List<String> expectedQuesTypeList = BasePageObject.readJsonFile(
					AtomHC.propData.getProperty("question.add.question.type.dropdown.list"),
					"qestionAddQuestionTypeDropdownList");
			assertEquals(actualQuesTypeList, expectedQuesTypeList);
		}


		@Test
		public void testWhenSelectQuestionTypeNumeric() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeNumeric();
			quesPage.questionTypeMinAndMaxField();
		}

		@Test
		public void testWhenSelectQuestionTypeHorizontalSlider() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeHorizontalSlider();
			quesPage.questionTypeSliderStepField();
		}
		@Test
		public void testWhenSelectQuestionTypeVerticalSlider() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeVerticalSlider();
			quesPage.questionTypeSliderStepField();
		}
		
		@Test
		public void testWhenSelectQuestionTypeDateAndTime() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeDateAndTime();
			quesPage.questionTypeMinAndMaxField();
		}

		@Test
		public void testWhenSelectQuestionTypeDate() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeDate();
			quesPage.questionTypeMinAndMaxField();
		}

		@Test
		public void testWhenSelectQuestionTypeTime() throws Exception {
		
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeTime();
			quesPage.questionTypeMinAndMaxField();
		}

		@Test
		public void testWhenSelectQuestionTypeMultilineText() throws Exception {
			
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			Thread.sleep(3000);
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeMultilineText();
			quesPage.questionTypeMinAndMaxField();
		}

		@Test
		public void testWhenSelectQuestionTypeDropdown() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify ");
			quesPage.clickOnQuestionAddQuestionTypeDropdown();
			quesPage.clickOnQuestionTypeDropdown();
			String title = quesPage.getSetupAnswersLabel();
			String[] getTitle = title.split(" ");
			String quesTitle = getTitle[0];
			String quesCount = getTitle[1];
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesTitle, "Setup");
			softAssert.assertTrue(quesPage.isSetupAnswersSearchTextbox());
			softAssert.assertTrue(quesPage.isSetupAnsAddButton());
			softAssert.assertEquals(quesPage.getSetupAnsAnswerLabel(),AtomHC.propData.getProperty("setup.ans.answer.table.label"));
			softAssert.assertEquals(quesPage.getSetupAnsSequenceNoLabel(),AtomHC.propData.getProperty("setup.ans.sequence.no.table.label"));
			softAssert.assertEquals(quesPage.getsetupAnswersSearchInvalidMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
			softAssert.assertAll();
		}

		@Test
		public void testWhenClicksOnIsRequiredCheckbox() throws   Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify Question Type Dropdown List");
			quesPage.checkIsRequiredKeycheckbox();
			assertTrue(quesPage.isCheckboxIsRequiredSelect());

		}
		@Test
		public void testWhenClicksOnIsRequiredUnCheckbox() throws   Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsTabAddButton();
			log("Verify Question Type Dropdown List");
			quesPage.unCheckIsRequiredKeycheckbox();
			assertFalse(quesPage.isCheckboxIsRequiredSelect());

		}
		@Test
		public void testSetupAnwserSearchBoxWithValidData() throws   Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsViewListRow();
			log("Verify Question Type Dropdown List");
			quesPage.clickOnSetupAnswersSearchTextbox();
			quesPage.sendSetupAnswersSearchTextbox(AtomHC.propData.getProperty("setup.anwser.search.textbox"));
			assertTrue(quesPage.isSetupAnswersSearchValueDisplay());
			
		}
		@Test
		public void testSetupAnwserSearchBoxWithInvalidData() throws   Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			Questionnaires quesPage = new Questionnaires(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			quesPage.clickOnQuestionnairesName();
			quesPage.clickOnQuestionsTab();
			quesPage.clickOnQuestionsViewListRow();
			log("Verify Question Type Dropdown List");
			SoftAssert softAssert = new SoftAssert();
			quesPage.clickOnSetupAnswersSearchTextbox();
			quesPage.sendSetupAnswersSearchTextbox(AtomHC.propData.getProperty("setup.anwser.invalid.search"));
			softAssert.assertTrue(quesPage.isSetupAnswersSearchValueDisplay());
			softAssert.assertEquals(quesPage.getsetupAnswersSearchInvalidMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
			softAssert.assertAll();
			
		}
		@Test
		public void testSystemNavigateToQuestionnaireQuestionAddAnswerOnClickAddButton() throws Exception {
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnStandardQuesType();
			String code = "Code" + BasePageObject.createRandomCharacter(2);
			quesPage.enterCode(code);
			quesPage.clickOnProviderDefaultRespondant();
			String title = "Test" + BasePageObject.createRandomCharacter(2);
			quesPage.enterQuesTitle(title);
			quesPage.clickOnSaveAndNext();
			quesPage.clickOnQuestionsTabAddButton();
			quesPage.clickOnQuestionTypeDropdown();
			quesPage.clickOnSetupAnsAddButton();
			log("Verify Questionnaire Question Add Page header");
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(quesPage.getSetupAnsAddAnswerLabel(),AtomHC.propData.getProperty("setup.ans.addAnswer.label"));
			softAssert.assertEquals(quesPage.getSetupAnsSequenceNoLabel(),AtomHC.propData.getProperty("setup.ans.sequence.no.table.label"));
			quesPage.isSetupAnsAnswerTextbox();
			softAssert.assertEquals(quesPage.getsetupAnswersSearchInvalidMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
			quesPage.isSetupAnsSequenceNoTextbox();
			softAssert.assertAll();
		}
		
		@Test
		public void testSystemNavigateToQuestionnaireQuestionEditPageOnDoubleClickInList() throws Exception {
			
			AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
			mainPage.clickOnOrginazationTab();
			mainPage.clickOnQuestionnairsTab();
			Questionnaires quesPage = new Questionnaires(driver);
			quesPage.clickOnAddButton();
			quesPage.clickOnStandardQuesType();
			String code = "Code" + BasePageObject.createRandomCharacter(2);
			quesPage.enterCode(code);
			quesPage.clickOnProviderDefaultRespondant();
			String title = "Test" + BasePageObject.createRandomCharacter(2);
			quesPage.enterQuesTitle(title);
			quesPage.clickOnSaveAndNext();
			quesPage.clickOnQuestionsTabAddButton();
			quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
					AtomHC.propData.getProperty("ques.max.value"),
					AtomHC.propData.getProperty("enter.question"));
			quesPage.clickOnQuestionSaveNextButton();
			quesPage.clickOnQuestionnaireQuestionAddButton();
			quesPage.selectDateQuestionType();
			quesPage.clickOnQuestionnaireQuestionSaveButton();
			quesPage.clickOnDateQuestionnaireQuestion();
			log("Verify Questionnaire Question Edit Page Header");
			assertEquals(quesPage.getQuestionnaireQuestionAddEditPageHeader(),AtomHC.propData.getProperty("questionnaire.question.edit.header"));
		}
		
	//3.Questionnaire Questions
	@Test
	public void testVerifyAfterClickOnSaveAndNextButtonOfSetupQuestionsItShouldDisplayQuestionnaireQues() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		log("Verify Questionnaire Question Header, On click save & next button of Question");
		assertEquals(quesPage.getQuestionnaireQuestionHeader(),AtomHC.propData.getProperty("questionnaire.questions.header"));
	}
	
	@Test
	public void testVerifyQuestionnaireQuestionHeaderTitle() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		String quesQuestionHeader =  quesPage.getQuestionnaireQuestionTitle();
		String[] getQuesQuestionTitle = quesQuestionHeader.split(" ");
		String quesQuestionTitle = getQuesQuestionTitle[0]+ " " + getQuesQuestionTitle[1];
		log("Verify Questionnaire Question Title");
		assertEquals(quesQuestionTitle, "Questionnaire questions");
	}
	
	@Test
	public void testVerifyQuestionnaireQuestionHeaderCount() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		String quesQuestionHeader =  quesPage.getQuestionnaireQuestionTitle();
		String quesQuestionCount = quesQuestionHeader.substring(25,26);
		log("Questionnaire Question count : "+ quesQuestionCount);
		int titles = Integer.parseInt(quesQuestionCount);
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnQuestionnaireQuestionSaveButton();
		int newCount = titles +1;
		String acutalCount=String.valueOf(newCount);
		String quesQuestionHeaderCount =  quesPage.getQuestionnaireQuestionTitle();
		String quesQuestionNewCount = quesQuestionHeaderCount.substring(25,26);
		log("Veriy Questionnaire Question Count");
		log("Questionnaire Question New count : "+ quesQuestionNewCount);
		assertEquals(acutalCount,quesQuestionNewCount);
	}
	
	@Test
	public void testVerifyQuestionnaireQuestionListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		log("Verify Questionnaire Question list Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(quesPage.isQuestionnaireQuestionSaveNextButtonDisplay());
		softAssert.assertTrue(quesPage.isQuestionnaireQuestionSearchTextboxDisplay());
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionSearchTextboxPlaceholder(),AtomHC.propData.getProperty("placeholder"));
		softAssert.assertTrue(quesPage.isQuestionnaireQuestionAddButtonDisplay());
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionFirstColumnName(),AtomHC.propData.getProperty("questionnaire.question.name"));
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionSecondColumnName(),AtomHC.propData.getProperty("questionnaire.ques.is.starting.question.name"));
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionThirdColumnName(),AtomHC.propData.getProperty("questionnaire.ques.question.type.name"));
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionFourthColumnName(),AtomHC.propData.getProperty("questionnaire.ques.no.of.flows.name"));
		softAssert.assertAll();
	}
	
	@Test
	public void testSystemAbleToFilterTextInQuestionnaireQuestionSearchTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnQuestionnaireQuestionSaveButton();
		quesPage.enterTextInQuestionnaireQuestionSearchTextbox(AtomHC.propData.getProperty("questionnaire.question"));
		log("Verify if user enter Question, Question Searched Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(quesPage.isDateQuestionnaireQuestionDisplay());
		quesPage.clearTextInQuestionnaireQuestionSearchTextbox();
		quesPage.enterTextInQuestionnaireQuestionSearchTextbox(AtomHC.propData.getProperty("is.starting.question"));
		log("Verify if user enter is Starting Question, is Starting Question Searched Displayed");
		softAssert.assertTrue(quesPage.isDateQuestionnaireQuestionDisplay());
		quesPage.clearTextInQuestionnaireQuestionSearchTextbox();
		quesPage.enterTextInQuestionnaireQuestionSearchTextbox(AtomHC.propData.getProperty("question.type"));
		log("Verify if user enter Question type, Question type Searched Displayed");
		softAssert.assertTrue(quesPage.isDateQuestionnaireQuestionDisplay());
		quesPage.clearTextInQuestionnaireQuestionSearchTextbox();
		quesPage.enterTextInQuestionnaireQuestionSearchTextbox(AtomHC.propData.getProperty("questionnaire.no.of.flows"));
		log("Verify if user no of flows, no of flows Searched Displayed");
		softAssert.assertTrue(quesPage.isDateQuestionnaireQuestionDisplay());
		quesPage.clearTextInQuestionnaireQuestionSearchTextbox();
		log("Verify search Placeholder and full list displayed");
		softAssert.assertTrue(quesPage.isDateQuestionnaireQuestionDisplay());
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionSearchTextboxPlaceholder(),AtomHC.propData.getProperty("placeholder"));
		quesPage.enterTextInQuestionnaireQuestionSearchTextbox(AtomHC.propData.getProperty("invalid.questionnaire.question"));
		softAssert.assertEquals(quesPage.getQuestionnaireQuestionNoRecordFoundMessage(),AtomHC.propData.getProperty("no.record.found.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemNavigateToScoreTypeOnClickQuestionnaireQuestionSaveNextButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnQuestionnaireQuestionSaveButton();
		quesPage.clickOnQuestionnaireQuestionSaveNextButton();
		log("Verify Score Type Header display, on click save & next button of Questionnaire QUestion");
		assertEquals(quesPage.getScroreTypeHeader(),AtomHC.propData.getProperty("score.type.header"));
	}
	
	@Test
	public void testVerifyQuestionnaireQuesEditPageOnDoubleClick() throws Exception {
		
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnQuestionnaireQuestionSaveButton();
		quesPage.clickOnDateQuestionnaireQuestion();
		log("Verify Edit Page Displaye, on double click list in Questionnaire Ques");
		assertEquals(quesPage.getQuestionnaireQuestionAddEditPageHeader(),AtomHC.propData.getProperty("questionnaire.question.edit.header"));
	}
	
	@Test
	public void testVerifyQuestionnaireQuesAddPage() throws Exception {
	
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		log("Verify Add Page Displayed, on click Add button of Questionnaire Ques");
		assertEquals(quesPage.getQuestionnaireQuestionAddEditPageHeader(),AtomHC.propData.getProperty("questionnaire.question.add.header"));
	}

	//Questionnaire Question Add Edit
	@Test
	public void testVerifyQuestionnaireQuestionAddPageField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getIsStartingQuestionLabel(),AtomHC.propData.getProperty("is.starting.question.label"));
		softAssert.assertEquals(quesPage.getSelectQuestionLabel(),AtomHC.propData.getProperty("select.question.label"));
		softAssert.assertTrue(quesPage.isSelectQuestionDropdownDisplay());
		softAssert.assertTrue(quesPage.isQuestionnaireQuestionSaveButtonDisplay());
		softAssert.assertTrue(quesPage.isQuestionnaireQuestionCancelButtonDisplay());
		softAssert.assertAll();
	}
	
	@Test
	public void testVerifyDateTypeQuestionJumpingLogicFields() throws InterruptedException {
		
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getIfValueIsBlankText(),AtomHC.propData.getProperty("if.value.blank.text"));
		softAssert.assertTrue(quesPage.isActionDropdownDisplay());
		softAssert.assertTrue(quesPage.isAddMoreBetweenConditionLinkButtonDisplay());
		softAssert.assertEquals(quesPage.getElseLabel(),AtomHC.propData.getProperty("else.label"));
		softAssert.assertTrue(quesPage.isConditionActionDropdownDisplay());
		softAssert.assertAll();
	}
	
	@Test
	public void testVerifyFieldsAfterClickingOnAddMoreBetweenCondition() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(2);
		String title = "Test" + BasePageObject.createRandomCharacter(2);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnSaveAndNext();
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnAddMoreBetweenConditionLinkButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(quesPage.getAddMoreBetweenConditionText(),AtomHC.propData.getProperty("condition.text"));
		softAssert.assertTrue(quesPage.isValue1TextboxDisplay());
		softAssert.assertEquals(quesPage.getAndText(),AtomHC.propData.getProperty("and.text"));
		softAssert.assertTrue(quesPage.isValue2TextboxDisplay());
		softAssert.assertTrue(quesPage.isConditionDeleteButtonDisplay());
		softAssert.assertEquals(quesPage.getActionLabel(),AtomHC.propData.getProperty("action.label"));
		softAssert.assertTrue(quesPage.isconditionActionDropdownDisplay());
		softAssert.assertAll();
	}
	
	@Test
	public void testVerifyErrorMessageDisplayIfValue1IsGreaterThanValue2() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnQuestionnairsTab();
		Questionnaires quesPage = new Questionnaires(driver);
		quesPage.clickOnAddButton();
		String code = "Code" + BasePageObject.createRandomCharacter(4);
		String title = "Test" + BasePageObject.createRandomCharacter(4);
		quesPage.createStandardQuesType(code,title);
		quesPage.clickOnSaveAndNext();
		quesPage.clickOnQuestionsTabAddButton();
		quesPage.createDateTypeQuestion(AtomHC.propData.getProperty("ques.min.value"), 
				AtomHC.propData.getProperty("ques.max.value"),
				AtomHC.propData.getProperty("enter.question"));
		quesPage.clickOnQuestionSaveNextButton();
		quesPage.clickOnQuestionnaireQuestionAddButton();
		quesPage.selectDateQuestionType();
		quesPage.clickOnAddMoreBetweenConditionLinkButton();
		quesPage.enterValue1(AtomHC.propData.getProperty("value.one"));
		quesPage.enterValue2(AtomHC.propData.getProperty("value.two"));
		assertEquals(quesPage.getValueErrorMessage(),AtomHC.propData.getProperty("value.error.message"));
	}
	
}	