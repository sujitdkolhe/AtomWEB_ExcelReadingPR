package com.atom.healthcare.EducationsMaster.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.EducationMaster.EducationMaster;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class EducationMasterTest extends BaseTest {
	HealthcareLogin loginPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("usr"), AtomHC.key.getDecrypt(AtomHC.propData.getProperty("pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

//Education list page
	@Test
	public void testIfUserNavigatesToEducationListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		log("verify if user navigates to education list page");
		String educationTitle = educationPage.getEducationPageTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		assertEquals(educationHeader, "Education");
	}

	@Test
	public void testEducationListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		log("verify education list page fields");
		SoftAssert softAssert = new SoftAssert();
		String educationTitle = educationPage.getEducationPageTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		softAssert.assertEquals(educationHeader, "Education");
		String educationCount = getTitle[2];
		String count = educationCount.substring(1, 3);
		log("Education Count is: " + count);
		int title = Integer.parseInt(count);
		educationPage.clickOnEducationAddButton();
		driver.navigate().refresh();
		educationPage.clickOnEducationAddButton();
		educationPage.selectEducationCategory();
		String eduTitle = AtomHC.propData.getProperty("educ.title") + BasePageObject.createRandomCharacter(5);
		educationPage.sendEducationTitleForFirstLang(eduTitle);
		educationPage.sendEducationEditorContentForFirstLang(AtomHC.propData.getProperty("education.editor"));
		educationPage.clickOnSecondEducationLang();
		educationPage.sendEducationTitleForSecondLang(eduTitle);
		educationPage.sendEducationEditorContentForSecondLang(AtomHC.propData.getProperty("education.editor"));
		educationPage.clickOnEducationSaveButton();
		int newCount = title + 1;
		log("Education Count is: " + newCount);
		softAssert.assertTrue(educationPage.isEducationSearchTextboxDisplay());
		softAssert.assertEquals(educationPage.getEducationSearchPlaceholder(),
				AtomHC.propData.getProperty("education.search.placeholder"));
		softAssert.assertEquals(educationPage.getEducationAddButtonCaption(),
				AtomHC.propData.getProperty("education.add.button"));
		softAssert.assertTrue(educationPage.isEducationListDisplay());
		softAssert.assertEquals(educationPage.getEducationPublishTag(), AtomHC.propData.getProperty("education.tag"));
		softAssert.assertEquals(educationPage.getEducationCardName(), AtomHC.propData.getProperty("education.name"));
		softAssert.assertTrue(educationPage.isEducationCardImgDisplay());
		softAssert.assertEquals(educationPage.getEducationCategoryName(eduTitle), eduTitle);
		softAssert.assertEquals(educationPage.getUnPublishTag(),
				AtomHC.propData.getProperty("education.unpublish.tag"));
		softAssert.assertAll();
	}

	@Test
	public void testIfEducationsAreNotAddedItDisplaysNoRecordView() throws Exception {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		EducationMaster educationPage = new EducationMaster(driver);
		mainPage.clickOnOrginazationTab();
		educationPage.clickOnEducationTab();
		String educationTitle = educationPage.getEducationPageTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		log("verify if user is on education page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationHeader, "Education");
		log("verify if no record found message is displayed");
		softAssert.assertEquals(educationPage.getNoEducationAddedMessage(),
				AtomHC.propData.getProperty("no.education.record"));
		softAssert.assertAll();
	}

	@Test
	public void testEducationSearchTextbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.sendSearchWord(AtomHC.propData.getProperty("valid.searchword"));
		String educationTitle = educationPage.getEducationPageTitle();
		String[] getTitle = educationTitle.split(" ");
		String educationHeader = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationHeader, "Education");
		String educationCount = getTitle[2];
		String count = educationCount.substring(1, 2);
		System.out.println(count);
		int title = Integer.parseInt(count);
		log("Reading Count is: " + title);
		educationPage.clearSearchTextbox();
		log("verify if searched education is displayed");
		softAssert.assertTrue(educationPage.isEducationListDisplay());
		educationPage.sendSearchWord(AtomHC.propData.getProperty("invalid.searchword"));
		log("verify if error message is found if user enters data which is not present in the list");
		softAssert.assertEquals(educationPage.getSearchNoRecordText(),
				AtomHC.propData.getProperty("search.norecords.label"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnEducationAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		log("verify if user lands on education add page");
		assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
	}

	@Test
	public void testUserLandsOnEducationEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		log("verify user is on education edit page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		log("Verify Education Edit Page Fields for Content Page Type");
		softAssert.assertTrue(educationPage.isContentRadioButtonEnabled());
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		softAssert.assertEquals(educationPage.getEditEducationTitleContent(),
				AtomHC.propData.getProperty("education.edit.title.content"));
		log("Value  " + educationPage.getEditEducationTitleContent());
		softAssert.assertEquals(educationPage.getEditEducationEditorContent(),
				AtomHC.propData.getProperty("education.edit.editor.content"));
		log("Value  " + educationPage.getEditEducationEditorContent());
		softAssert.assertEquals(educationPage.getPreviewButtonCaption(),
				AtomHC.propData.getProperty("education.preview.caption"));
		softAssert.assertTrue(educationPage.isEducationStatusButtonDisplayed());
		softAssert.assertAll();
	}

	// Create Education page
	@Test
	public void testEducationAddPageFieldsForContentPageType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		log("verify education add page fields for content page type");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		softAssert.assertTrue(educationPage.isCrossIconDisplay());
		softAssert.assertEquals(educationPage.getTakePictureLabelText(),
				AtomHC.propData.getProperty("education.take.picture.label"));
		softAssert.assertTrue(educationPage.isPictureControlAreaDisplay());
		softAssert.assertEquals(educationPage.getCategoryLabelText(),
				AtomHC.propData.getProperty("education.category"));
		softAssert.assertTrue(educationPage.isCategoryTextboxDisplay());
		softAssert.assertEquals(educationPage.getCategoryPlaceholder(),
				AtomHC.propData.getProperty("education.category.placeholder"));
		softAssert.assertEquals(educationPage.getPageTypeLabelText(),
				AtomHC.propData.getProperty("education.page.type"));
		softAssert.assertTrue(educationPage.isEducationContentPageTypeSelected());
		softAssert.assertEquals(educationPage.getContentLabelText(), AtomHC.propData.getProperty("education.content"));
		softAssert.assertEquals(educationPage.getLinkLabelText(), AtomHC.propData.getProperty("education.link"));
		softAssert.assertEquals(educationPage.getTagsLabelText(), AtomHC.propData.getProperty("education.tags"));
		softAssert.assertTrue(educationPage.isTagTextboxDisplay());
		softAssert.assertEquals(educationPage.getTagsPlaceholder(),
				AtomHC.propData.getProperty("education.tags.placeholder"));
		softAssert.assertEquals(educationPage.getHighlitedFirstLangLabelColor(),
				AtomHC.propData.getProperty("lang.highlight.color"));
		softAssert.assertEquals(educationPage.getFirstLangText(), AtomHC.propData.getProperty("education.second.lang"));
		softAssert.assertEquals(educationPage.getSecondLangText(), AtomHC.propData.getProperty("education.third.lang"));
		softAssert.assertEquals(educationPage.getTitleLabelText(), AtomHC.propData.getProperty("education.title"));
		softAssert.assertTrue(educationPage.isTitleTextboxDisplay());
		softAssert.assertEquals(educationPage.getTitlePlaceholder(),
				AtomHC.propData.getProperty("education.title.placeholder"));
		softAssert.assertEquals(educationPage.getDescriptionLabelText(),
				AtomHC.propData.getProperty("education.description"));
		softAssert.assertTrue(educationPage.isDescriptionTextboxDisplay());
		softAssert.assertEquals(educationPage.getDescriptionPlaceholder(),
				AtomHC.propData.getProperty("education.description.placeholder"));
		softAssert.assertEquals(educationPage.getEditorLabelText(), AtomHC.propData.getProperty("education.editor"));
		softAssert.assertTrue(educationPage.isEditorTextboxDisplay());
		softAssert.assertEquals(educationPage.getSaveButtonCaption(),
				AtomHC.propData.getProperty("education.save.caption"));
		softAssert.assertEquals(educationPage.getCancelButtonCaption(),
				AtomHC.propData.getProperty("education.cancel.caption"));
		softAssert.assertAll();
	}

	@Test
	public void testEducationAddPageFieldsForLinkPageType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		log("verify education add page fields for link page");
		educationPage.onLinkButtonClick();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getLinkFieldText(), AtomHC.propData.getProperty("education.link.label"));
		softAssert.assertTrue(educationPage.isLinkTextboxDisplay());
		softAssert.assertEquals(educationPage.getLinkPlaceholder(),
				AtomHC.propData.getProperty("education.link.placeholder"));
		softAssert.assertFalse(educationPage.isEditorTextboxDisplay());
		softAssert.assertEquals(educationPage.getSaveButtonCaption(),
				AtomHC.propData.getProperty("education.save.caption"));
		softAssert.assertEquals(educationPage.getCancelButtonCaption(),
				AtomHC.propData.getProperty("education.cancel.caption"));
		educationPage.onCancelButtonClick();
		softAssert.assertAll();
	}

	@Test
	public void testEducationEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		log("Verify Education Edit Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		log("Value  " + educationPage.getEditEducationTitleContent());
		softAssert.assertEquals(educationPage.getEditEducationTitleContent(),
				AtomHC.propData.getProperty("education.edit.title.content"));
		softAssert.assertEquals(educationPage.getPreviewButtonCaption(),
				AtomHC.propData.getProperty("education.preview.caption"));
		softAssert.assertTrue(educationPage.isEducationStatusButtonDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testEducationEditPageFieldsForContentPageType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		log("Verify Education Edit Page Fields for Content Page Type");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(educationPage.isContentRadioButtonEnabled());
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		softAssert.assertEquals(educationPage.getEditEducationTitleContent(),
				AtomHC.propData.getProperty("education.edit.title.content"));
		log("Value  " + educationPage.getEditEducationTitleContent());
		softAssert.assertEquals(educationPage.getEditEducationEditorContent(),
				AtomHC.propData.getProperty("education.edit.editor.content"));
		log("Value  " + educationPage.getEditEducationEditorContent());
		softAssert.assertAll();
	}

	@Test
	public void testEducationEditPageFieldsForLinkPageType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnLinkEducation();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(educationPage.isLinkRadioButtonEnabled());
		log("Verify Education Edit Page Fields for Link Page Type");
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		softAssert.assertEquals(educationPage.getEditLinkEducationTitleContent(),
				AtomHC.propData.getProperty("education.edit.link.title"));
		log("Value  " + educationPage.getEditLinkEducationTitleContent());
		softAssert.assertEquals(educationPage.getEditLinkEducationLinkContent(),
				AtomHC.propData.getProperty("education.edit.link.content"));
		log("Value  " + educationPage.getEditLinkEducationLinkContent());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserClicksOnCrossIconItShouldNavigateToEducationListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		educationPage.clickOnCrossIcon();
		log("verify if user lands on list page after clicking on cross icon");
		assertTrue(educationPage.isEducationListDisplay());
	}

	@Test
	public void testEducationPictureControlEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationAddButton();
		log("User upload incorrect image format");
		educationPage.uploadProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.incorrect.image.format"));
		log("verify user select incorrect format of education Image");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getEducationImageErrorMessage(),
				AtomHC.propData.getProperty("education.incorrect.error.message"));
		log("User upload correct image format");
		educationPage.uploadProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.correct.image.format"));
		log("verify user select correct format of education Image");
		softAssert.assertTrue(educationPage.isEducationCorrectImgVisible());
		softAssert.assertAll();
	}

	@Test
	public void testEducationPageTypeEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		educationPage.onLinkButtonClick();
		log("Verify link field is visible when user selects link radio button");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(educationPage.isEditorTextboxDisplay());
		softAssert.assertEquals(educationPage.getLinkFieldText(), AtomHC.propData.getProperty("education.link.label"));
		educationPage.clickOnContentButton();
		log("Verify editor field is visible when user selects content radio button");
		softAssert.assertFalse(educationPage.isLinkTextboxDisplay());
		softAssert.assertEquals(educationPage.getEditorLabelText(), AtomHC.propData.getProperty("education.editor"));
		softAssert.assertAll();
	}

	@Test
	public void testUserSelectedLangIsVisible() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		log("verify if user's selected lang is highlighted");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getHighlitedFirstLangLabelColor(),
				AtomHC.propData.getProperty("lang.highlight.color"));
		educationPage.clickOnSecondEducationLang();
		softAssert.assertEquals(educationPage.getHighlitedSecondLangLabelColor(),
				AtomHC.propData.getProperty("lang.highlight.color"));
		educationPage.clickOnThirdEducationLang();
		softAssert.assertEquals(educationPage.getHighlitedThirdLangLabelColor(),
				AtomHC.propData.getProperty("lang.highlight.color"));
		softAssert.assertAll();
	}

	@Test
	public void testUserIsOnEduactionPreviewPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		educationPage.clickOnPreviewButton();
		log("verify if user lands on education preview page");
		assertTrue(educationPage.isPreviewEducationDetailDisplay());
	}

	@Test
	public void testValidateEducationSaveButtonWithoutAddingAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		educationPage.clickOnEducationSaveButton();
		log("Verify required fields error message,if user does not enter data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getCategoryRequiredErrorMessage(),
				AtomHC.propData.getProperty("category.error.message"));
		softAssert.assertEquals(educationPage.getTitleRequiredErrorMessage(),
				AtomHC.propData.getProperty("title.error.message"));
		softAssert.assertEquals(educationPage.getEditorRequiredErrorMessage(),
				AtomHC.propData.getProperty("editor.error.message"));
		softAssert.assertEquals(educationPage.getLangRequiredErrorMessage(),
				AtomHC.propData.getProperty("lang.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testValidateEducationSaveButtonAddingValidData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducationAddButton();
		educationPage.sendEducationTitleForFirstLang(AtomHC.propData.getProperty("education.title"));
		educationPage.sendEducationEditorContentForFirstLang(AtomHC.propData.getProperty("education.editor"));
		educationPage.clickOnSecondEducationLang();
		educationPage.sendEducationTitleForSecondLang(AtomHC.propData.getProperty("education.title"));
		educationPage.sendEducationEditorContentForSecondLang(AtomHC.propData.getProperty("education.editor"));
		educationPage.clickOnEducationSaveButton();
		log("verify user lands on list page, if user successfully adds an education");
		assertTrue(educationPage.isEducationListDisplay());
	}

	@Test
	public void testIfUserCanPublishEducation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnUnpublishEducation();
		educationPage.clickOnEducationPublishStatusButton("Unpublish");
		log("Verify if user can publish education");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getPublishConfirmationMessage(),
				AtomHC.propData.getProperty("publish.confirmation.message"));
		softAssert.assertEquals(educationPage.getPublishCancelButtonCaption(),
				AtomHC.propData.getProperty("publish.cancel.button"));
		softAssert.assertEquals(educationPage.getPublishOkButtonCaption(),
				AtomHC.propData.getProperty("publish.ok.button"));
		educationPage.clickOnPublishCancelButton();
		log("Verify after clicking on cancel button user navigates to Education add/edit page");
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		educationPage.clickOnEducationPublishStatusButton("Unpublish");
		educationPage.clickOnPublishOkButton();
		log("Verify after clicking on ok button user navigates to Education list page");
		softAssert.assertEquals(educationPage.getEducationPublishTag(), AtomHC.propData.getProperty("education.tag"));
		softAssert.assertTrue(educationPage.isEducationListDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserCanUnpublishEducation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnUnpublishEducation();
		educationPage.clickOnEducationUnpublishStatusButton();
		log("Verify if user can unpublish education");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getPublishConfirmationMessage(),
				AtomHC.propData.getProperty("unpublish.confirmation.message"));
		softAssert.assertEquals(educationPage.getPublishCancelButtonCaption(),
				AtomHC.propData.getProperty("unpublish.cancel.button"));
		softAssert.assertEquals(educationPage.getPublishOkButtonCaption(),
				AtomHC.propData.getProperty("unpublish.ok.button"));
		educationPage.clickOnPublishCancelButton();
		log("Verify after clicking on cancel button user navigates to Education add/edit page");
		softAssert.assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
		educationPage.clickOnEducationUnpublishStatusButton();
		educationPage.clickOnPublishOkButton();
		log("Verify after clicking on ok button user navigates to Education list page");
		softAssert.assertEquals(educationPage.getUnPublishTag(),
				AtomHC.propData.getProperty("education.unpublish.tag"));
		softAssert.assertTrue(educationPage.isEducationListDisplay());
		softAssert.assertAll();
	}

	// Education detail Page
	@Test
	public void testPreviewEducationDeatilPageVerification() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		educationPage.clickOnPreviewButton();
		log("verify preview education detail page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(educationPage.getPreviewEducationTitle(),
				AtomHC.propData.getProperty("preview.education.title"));
		softAssert.assertTrue(educationPage.isPreviewEducationCrossIconDisplay());
		softAssert.assertTrue(educationPage.isPreviewEducationDetailDisplay());
		softAssert.assertEquals(educationPage.getPreviewEducationOkButtonCaption(),
				AtomHC.propData.getProperty("preview.ok.button"));
		softAssert.assertAll();
	}

	@Test
	public void testPreviewEducationCrossIconClick() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		educationPage.clickOnPreviewButton();
		educationPage.clickOnPreviewEducationCrossIcon();
		log("verify user naviagtes to education add/edit page after clicking on cross icon");
		assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
	}

	@Test
	public void testPreviewEducationOkButtonClick() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		EducationMaster educationPage = new EducationMaster(driver);
		educationPage.clickOnEducationTab();
		educationPage.clickOnEducation();
		educationPage.clickOnPreviewButton();
		log("verify user naviagtes to education add/edit page after clicking on preview okay button");
		educationPage.clickOnPreviewEducationOkButton();
		assertEquals(educationPage.getEducationAddEditPageTitle(),
				AtomHC.propData.getProperty("education.add.page.title"));
	}

}
