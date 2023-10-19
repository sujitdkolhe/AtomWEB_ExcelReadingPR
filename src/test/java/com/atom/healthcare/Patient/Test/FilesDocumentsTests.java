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
import com.atom.healthcare.TD_Patients.FilesDocuments;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class FilesDocumentsTests extends BaseTest {
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

	// Provider File And Documents List Page
	@Test
	public void testFileAndDocumentsListPageField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		log("Verify file and documents list page fields");
		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(filesDocuments.highlightedFilesAndDocuments(),
//				AtomHC.propData.getProperty("file.documents.tab.color"));
		softAssert.assertEquals(filesDocuments.getHeaderAsFilesAndDocuments(),
				AtomHC.propData.getProperty("files.&.documents.heading"));
		softAssert.assertTrue(filesDocuments.displayFileAndDocumentSearchbar());
		softAssert.assertEquals(filesDocuments.getFileAndDocumentSearchbarPlaceholder(),
				AtomHC.propData.getProperty("files.&.documents.searchbar.placeholder"));
		softAssert.assertEquals(filesDocuments.getAddButtonCaptionAsFilesAndDocuments(),
				AtomHC.propData.getProperty("files.&.documents.add.button.caption"));
		softAssert.assertEquals(filesDocuments.getNoRecordFoundInFilesAndDocumentsListPage(),
				AtomHC.propData.getProperty("no.Record.Found.In.files.And.Documents.List"));
		softAssert.assertAll();
	}

	@Test
	public void testIfFileDataIsPresent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments
				.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("documents.upload"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		log("Verify File name icon date");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(filesDocuments.isFileListPageDisplay());
		softAssert.assertTrue(filesDocuments.displayFileIcon());
		softAssert.assertEquals(filesDocuments.getFileName(), AtomHC.propData.getProperty("file.report.name"));
		softAssert.assertTrue(filesDocuments.displayFileUpdatedDateMonth());
		softAssert.assertTrue(filesDocuments.displayFileUpdatedAttachDocument());
		softAssert.assertAll();
	}

	@Test
	public void testSystemAbleToFilterTextInFileAndDocumentsSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments
				.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("documents.upload"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectOtherValueInCategoryDropdowm();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.new.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		log("Verify when user enter invalid file name in searchbox");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.enterTextSearchedFileName(AtomHC.propData.getProperty("search.invalid.file.name"));
		softAssert.assertEquals(filesDocuments.getNoRecordsInFileList(),
				AtomHC.propData.getProperty("search.file.data"));
		filesDocuments.clearFileAndDocumentSearchTextbox();
		log("verify when user enter valid file name in searchbox");
		filesDocuments.enterTextSearchedFileName(AtomHC.propData.getProperty("search.file.name"));
		softAssert.assertTrue(filesDocuments.getRecordsDataNameInFileList());
		filesDocuments.clearFileAndDocumentSearchTextbox();
		String patientFileAndDocumentsListHeader = filesDocuments.getHeaderAsFilesAndDocuments();
		String[] getTitle = patientFileAndDocumentsListHeader.split(" ");
		String patientFileAndDocumentsListTitle = getTitle[0] + " " + getTitle[1] + " " + getTitle[2];
		softAssert.assertEquals(patientFileAndDocumentsListTitle, "Files & Documents");
		String count = patientFileAndDocumentsListHeader.substring(18, 21);
		log("Files Count is: " + count);
		softAssert.assertEquals(filesDocuments.getHeaderCountOnSearchBased(),
				AtomHC.propData.getProperty("file.and.documents.count"));
		softAssert.assertAll();
	}

	// Provider File And Documents Add Page Fields
	@Test
	public void testFilesAndDocumentsAddPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		log("Verify When user click on patient tab");
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		log("Verify File And Documents Add Page Fields");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		softAssert.assertEquals(filesDocuments.getFileAddEditHeading(),
				AtomHC.propData.getProperty("get.file.add.edit.heading"));
		softAssert.assertTrue(filesDocuments.getXIconInFileAddEditPage());
		softAssert.assertEquals(filesDocuments.getSelectCategoryLabel(),
				AtomHC.propData.getProperty("get.select.category.label"));
		softAssert.assertTrue(filesDocuments.getSelectCategoryAstricIconDisplay());
		softAssert.assertEquals(filesDocuments.getselectCategoryDropdowmPlaceholder(),
				AtomHC.propData.getProperty("select.category.dropdown.placeholder"));
		softAssert.assertEquals(filesDocuments.getTapOnTheBoxText(), AtomHC.propData.getProperty("file.upload.tap"));
		softAssert.assertEquals(filesDocuments.getSaveButtonCaptionInFileAddEditPage(),
				AtomHC.propData.getProperty("file.documents.save.button.caption"));
		softAssert.assertEquals(filesDocuments.getCancelButtonCaptionInFileAddEditPage(),
				AtomHC.propData.getProperty("file.documents.cancel.button.caption"));
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testOnSelectCategoryDropdownFromFilesAbdDocumentPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		log("Verify select category dropdown value");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickOnCategoryDropdowmList();
		List<String> actualCategoryOperation = filesDocuments.getSelectCategoryList();
		List<String> expectedCategoryOperation = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.operation.list.path"), "selectCategorydropdownlist");
		softAssert.assertEquals(actualCategoryOperation, expectedCategoryOperation);
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		softAssert.assertEquals(filesDocuments.getselectedValueInCategoryDropdowm(),
				AtomHC.propData.getProperty("select.category.selected.value"));
		softAssert.assertAll();
	}

	@Test
	public void testUserSelectsFileCategoryDropdownItDisplaysTheDescriptionField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		log("Verify when user selects file category dropdown it displays the description field as read only testbox");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(filesDocuments.getFileDescriptionLabel(),
				AtomHC.propData.getProperty("get.description.label"));
		softAssert.assertEquals(filesDocuments.getDescriptionReadOnlyTextboxValue(),
				AtomHC.propData.getProperty("read.only.description.value"));
		softAssert.assertAll();
	}

	@Test
	public void testAttachFilePopUpPageFieldsFromDocumentsAndFile() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		log("Verify when user select file in upload control and display Attach file popup page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(filesDocuments.isAttachFilePoPUpPageDisplay());
		softAssert.assertEquals(filesDocuments.getAttachFileHeading(),
				AtomHC.propData.getProperty("attach.file.heading"));
		softAssert.assertTrue(filesDocuments.isAttachFilePoPUpPageXIconDisplay());
		softAssert.assertTrue(filesDocuments.isAttachFileImageDisplay());
		softAssert.assertEquals(filesDocuments.getAddCaptionTitleLabel(),
				AtomHC.propData.getProperty("get.add.caption.title"));
		softAssert.assertTrue(filesDocuments.isAddCaptionTitleAstricIconDisplay());
		softAssert.assertEquals(filesDocuments.getAddCaptionTitleTextboxPlaceholder(),
				AtomHC.propData.getProperty("add.caption.title.textbox.placeholder"));
		softAssert.assertEquals(filesDocuments.getAttachFileSaveButtonCaption(),
				AtomHC.propData.getProperty("attach.File.Save.Button"));
		softAssert.assertAll();
	}

	@Test
	public void testEditModeFilesAndDocumentsPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.new.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		log("Verify when user click on any records and its open edit file page");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickOnAnyRecordInFileListPage();
		softAssert.assertEquals(filesDocuments.getFileAddEditHeading(),
				AtomHC.propData.getProperty("get.file.add.edit.heading"));
		softAssert.assertTrue(filesDocuments.getXIconInFileAddEditPage());
		softAssert.assertEquals(filesDocuments.getDocumentsDeleteButton(),
				AtomHC.propData.getProperty("document.delete.button"));
		softAssert.assertEquals(filesDocuments.getFileAddEditDeleteButton(),
				AtomHC.propData.getProperty("file.add.edit.delete.button"));
		softAssert.assertAll();
	}

	@Test
	public void testDeleteButtonFunctionalityInFilesAndDocumentsAddEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.new.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		filesDocuments.clickOnAnyRecordInFileListPage();
		log("Verify when user click on delete button it display popup page");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickFileAddEditDeleteButton();
		softAssert.assertTrue(filesDocuments.isFileAddEditDeletePopupPageDisplay());
		softAssert.assertEquals(filesDocuments.getFileAddEditDeletePopupPageHeading(),
				AtomHC.propData.getProperty("file.add.edit.delete.popup.page.heading"));
		softAssert.assertTrue(filesDocuments.getFileAddEditDeletePopupPageXIcon());
		softAssert.assertEquals(filesDocuments.getFileAddEditDeletePopupPageMsg(),
				AtomHC.propData.getProperty("file.add.edit.delete.popup.page.msg"));
		softAssert.assertEquals(filesDocuments.getFileAddEditDeletePopupPageCancelButton(),
				AtomHC.propData.getProperty("file.add.edit.delete.popup.page.cancel.button"));
		softAssert.assertEquals(filesDocuments.getFileAddEditDeletePopupPageOkButton(),
				AtomHC.propData.getProperty("file.add.edit.delete.popup.page.ok.button"));
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnFileAddEditPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.new.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		filesDocuments.clickOnAnyRecordInFileListPage();
		filesDocuments.clickFileAddEditDeleteButton();
		log("Verify user lands on file add edit page after clicking on cancel button");
		filesDocuments.clickOnCancelButtonInDeletePopupPage();
		assertTrue(filesDocuments.isNavigateToFileAddEditPage());
	}

	@Test
	public void testUserLandsOnFileAddEditPageAfterClickingOnOkButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.selectAnyOneOptionInCategoryDropdowm();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.enterTextInAddCaption(AtomHC.propData.getProperty("add.new.caption"));
		filesDocuments.clickOnSaveButtonInAttachFile();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		filesDocuments.clickOnAnyRecordInFileListPage();
		filesDocuments.clickFileAddEditDeleteButton();
		log("Verify user lands on file list page after clicking on ok button");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickOnOkButtonInPopupPage();
		softAssert.assertTrue(filesDocuments.isFileListPageDisplay());
		String patientFileAndDocumentsListHeader = filesDocuments.getHeaderAsFilesAndDocuments();
		String[] getTitle = patientFileAndDocumentsListHeader.split(" ");
		String patientFileAndDocumentsListTitle = getTitle[0];
		softAssert.assertEquals(patientFileAndDocumentsListTitle, "Files");
		softAssert.assertAll();
	}

	@Test
	public void testWhenUserClickOnSaveButtonWithoutEnteringAnyRequiredFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		log("Verify user click on save button without enter any required fields");
		SoftAssert softAssert = new SoftAssert();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		softAssert.assertEquals(filesDocuments.getErrorMsgInFileNameTextbox(),
				AtomHC.propData.getProperty("get.error.msg.in.select.category"));
		softAssert.assertEquals(filesDocuments.getErrorMsgInDocumentUploadTextbox(),
				AtomHC.propData.getProperty("get.error.msg.in.document.upload.textbox"));
		softAssert.assertAll();
	}

	@Test
	public void testWhenUserClickOnSaveButtonWithoutUploadDocumentField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		log("Verify user not upload document and click on save button");
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		assertEquals(filesDocuments.getErrorMsgInDocumentUploadTextbox(),
				AtomHC.propData.getProperty("get.error.msg.in.document.upload.textbox"));
	}

	@Test
	public void testWhenUserEnterAllValidDetailsAndClickOnSaveButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnAddButton();
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		patient.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		patient.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		log("Verify user enter valid data and click on save button");
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		filesDocuments.clickOnCategoryDropdowmList();
		filesDocuments.uploadDocuments(System.getProperty("user.dir") + AtomHC.propData.getProperty("new.report"));
		filesDocuments.clickOnSaveButtonInFileAddEditPage();
		assertTrue(filesDocuments.isFileListPageDisplay());
	}

	@Test
	public void testUserLandOnAddEditPageAfterClickingOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		FilesDocuments filesDocuments = new FilesDocuments(driver);
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnPatientsTab();
		patient.clickOnFirstPatient();
		filesDocuments.clickOnFilesAndDocumentsTab();
		filesDocuments.clickOnAddButtonFileAndDocumentsTab();
		log("Verify user lands on add edit page after clicking on cancel button");
		filesDocuments.clickOnCancelButtonInAddEditPage();
		assertTrue(filesDocuments.isFileListPageDisplay());
	}
}
