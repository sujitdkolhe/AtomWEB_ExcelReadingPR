package com.atom.healthcare.TD_Patients;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class FilesDocuments extends BasePageObject {

	public FilesDocuments(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyinput-text")
	private WebElement firstNameInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Last name']")
	private WebElement lNameLabel;

	@FindBy(how = How.ID, using = "PatientAddEditLastNameKeyinput-text")
	private WebElement lastNameInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Gender']")
	private WebElement ganderLabel;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyinput-text")
	private WebElement genderInput;

	@FindBy(how = How.XPATH, using = "//label[text()='DOB']")
	private WebElement dobLabel;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeydate")
	private WebElement dateOfBirthInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Blood group']")
	private WebElement bloodGroupLabel;

	@FindBy(how = How.ID, using = "PatientAddEditBloodGroupKeyinput-text")
	private WebElement bloodGroupInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Preferred language']")
	private WebElement preferrendLangLabel;

	@FindBy(how = How.ID, using = "PatientAddEditPreferredLanguageKeyinput-text")
	private WebElement langPreferanceInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Social security number']")
	private WebElement socialSecurityNoLabel;

	@FindBy(how = How.ID, using = "PatientAddEditSocialSecurityNumberKeyinput-text")
	private WebElement securityNumber;

	@FindBy(how = How.XPATH, using = "//label[text()='Internal code']")
	private WebElement internalCodeLabel;

	@FindBy(how = How.ID, using = "PatientAddEditInternalCodeKeyinput-text")
	private WebElement internalCode;

	@FindBy(how = How.XPATH, using = "//label[text()='External code']")
	private WebElement externalCodeLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumberInput;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;

	@FindBy(how = How.ID, using = "PatientAddEditExternalCodeKeyinput-text")
	private WebElement ExternalCode;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-bottom-lg'])[1]")
	private WebElement newAddedPatient;

	@FindBy(how = How.XPATH, using = "//div[@class='margin-bottom-lg']")
	private WebElement newPatient;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[7]")
	private WebElement filesAndDocuments;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement filesAndDocumentsHeading;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement searchbarInfilesAndDocuments;

	@FindBy(how = How.ID, using = "PatientFilesViewAddActionKey")
	private WebElement addButtonCaptionInfilesAndDocuments;

	@FindBy(how = How.ID, using = "PatientFilesViewNoDataFoundKey")
	private WebElement noRecordFoundInfilesAndDocumentsList;

	@FindBy(how = How.ID, using = "PatientFilesViewIsPopupDocumentTextKeyinput-fieChatUploadControl")
	private WebElement documentsUpload;

	@FindBy(how = How.ID, using = "PatientFilesViewDocumentCaption/TitleKeyinput-textArea")
	private WebElement addCaptionInAttachFile;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-primary padding-horizontal-md  margin-left-md']")
	private WebElement attachFileSaveButton;

	@FindBy(how = How.ID, using = "PatientFilesViewSaveActionKey")
	private WebElement fileSaveButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='row px-0 mx-0 d-flex justify-content-center'])[4]")
	private WebElement fileIcon;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate']")
	private WebElement fileName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-secondary-text-body-medium-regular text-start truncate']")
	private WebElement fileUploadedDateAndMonth;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-secondary-text-body-medium-regular truncate']")
	private WebElement fileNoOfAttachDocuments;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement selectCategoryDropdowmListValue;

	@FindBy(how = How.XPATH, using = "//li[text()='X-rays']")
	private WebElement selectAnyOneOptionInCategoryDropdowm;

	@FindBy(how = How.ID, using = "PatientFilesView")
	private WebElement displayFileListPage;

	@FindBy(how = How.ID, using = "CategoriesOptionslabel15")
	private WebElement selectOtherValueInCategoryDropdowm;

	@FindBy(how = How.ID, using = "PatientFilesViewNoDataFoundKey")
	private WebElement fileNoRecordsFound;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement fileNoRecordsAddEditPageHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement fileAddEditXIcon;

	@FindBy(how = How.XPATH, using = "//label[text()='Select Category']")
	private WebElement selectCategoryLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column']")
	private WebElement fileRecordsFound;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-error-body-medium-regular'])[1]")
	private WebElement selectCategoryAstricIconDisplay;

	@FindBy(how = How.XPATH, using = "//label[text()='Tap on the box or']")
	private WebElement getTapOnTheBox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md float-right']")
	private WebElement getCancelButtonCaptionInAddEditPage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'] )[10]")
	private WebElement educationColorBand;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	private WebElement assignEducationCategoryLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[14]")
	private WebElement assignEducationSelectLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'] )[10]")
	private WebElement assignEducationCrossIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='w-available padding-vertical-lg ']")
	private WebElement displayAttachFilePoPUpPage;

	@FindBy(how = How.XPATH, using = "//label[text()='Files & Documents (1)']")
	private WebElement getSearchCount;

	@FindBy(how = How.XPATH, using = "//div[@class='col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-12']")
	private WebElement selectFirstPatient;

	@FindBy(how = How.XPATH, using = "//label[text()='Description']")
	private WebElement fileDescriptionLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='table input-primary']")
	private WebElement descriptionReadOnlyTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Attach file']")
	private WebElement getAttachFileHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement displayAttachFilePoPUpPageXIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 px-0 d-flex align-items-center pop-message-image']")
	private WebElement displayAttachFileImage;

	@FindBy(how = How.XPATH, using = "//label[text()='Add Caption/Title']")
	private WebElement getAddCaptionTitle;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-error-body-medium-regular'])[3]")
	private WebElement displayAddCaptionTitleAstricIcon;

	@FindBy(how = How.ID, using = "PatientFilesViewDocumentCaption/TitleKeyinput-textArea")
	private WebElement getAddCaptionTitleTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='delete-label cursor-pointer']")
	private WebElement documentsDeleteButton;

	@FindBy(how = How.XPATH, using = "(//label[text()='Delete'])[3]")
	private WebElement fileAddEditDeleteButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate']")
	private WebElement clickOnAnyRecordInFileListPage;

	@FindBy(how = How.ID, using = "PatientFilesViewIsPopupDeleteActionKey")
	private WebElement fileAddEditDeletePopupPage;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement fileAddEditDeletePopupPageHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement fileAddEditDeletePopupPageXIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement fileAddEditDeletePopupPageMsg;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary margin-horizontal-md float-right']")
	private WebElement fileAddEditDeletePopupPageCancelButton;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary float-right']")
	private WebElement fileAddEditDeletePopupPageOkButton;

	@FindBy(how = How.XPATH, using = "//div[@class='w-available padding-vertical-lg h-available ']")
	private WebElement navigateFileAddEditPage;

	@FindBy(how = How.XPATH, using = "//label[@class='cursor-pointer lbl-error-body-large-regular text-start']")
	private WebElement displayErrorMsgInSelectCategoryDropdown;

	@FindBy(how = How.ID, using = "PatientFilesViewIsPopupDocumentTextKeyerrorLabel")
	private WebElement displayErrorMsgInDocumentUploadTextbox;
	
	@FindBy(how = How.XPATH, using = "//ui[@id='CategoriesOptionsListItems']/li")
	private List<WebElement> fileNameTextbox;

	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}

	public void creatPatient(String fName, String lName, String gender, String year, String month, String date,
			String bloodGroup, String langPref, String securityNum, String intCode, String extCode,
			int clickOnPrevButtonCount) throws InterruptedException {
		log("Adding patient details");
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(firstNameInput);
		waitForElement(driver, firstNameInput);
		firstNameInput.sendKeys(fName);
		waitForElement(driver, lastNameInput);
		lastNameInput.sendKeys(lName);
		javascriptClick(genderInput);
		WebElement selectGender = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		javascriptClick(selectGender);
		scrollAndWait(0, 500, 2);
		log("select date of birth");
		javascriptClick(dateOfBirthInput);
		javascriptClick(dateOfBirthInput);
		Thread.sleep(3000);
		dateOfBirthInput.sendKeys("12");
		dateOfBirthInput.sendKeys("06");
		dateOfBirthInput.sendKeys("2022");
		// javascriptClick(monthHeader);
		Thread.sleep(3000);
		// javascriptClick(monthHeader);
//		Thread.sleep(3000);
//		for (int i = 1; i <= clickOnPrevButtonCount; i++) {
//			Thread.sleep(1000);
//			javascriptClick(CalenderPrevButton);
//		}

//		WebElement selectYear = driver
//				.findElement(By.xpath("//div[@class='datepicker-years']/div[2]/button[text()='" + year + "']"));
//		javascriptClick(selectYear);
//		Thread.sleep(3000);
//		WebElement selectMonth = driver
//				.findElement(By.xpath("//div[@class='datepicker-months']/div[2]/button[text()='" + month + "']"));
//		javascriptClick(selectMonth);
//		Thread.sleep(3000);
//		WebElement selectDate = driver
//				.findElement(By.xpath("//div[@class='datepicker-days']/div[3]/div/button[text()='" + date + "']"));
//		javascriptClick(selectDate);
//		Thread.sleep(3000);
//		log("DOB: " + month + " " + date + " " + year);

		log("Select Blood group: " + bloodGroup);
		javascriptClick(bloodGroupInput);
		WebElement selectBloodGroup = driver.findElement(By.xpath("//li[text()='" + bloodGroup + "']"));
		javascriptClick(selectBloodGroup);
		log("Select language preferance: " + langPref);
		javascriptClick(langPreferanceInput);
		WebElement selectLangPref = driver.findElement(By.xpath("(//li[text()='" + langPref + "'])[2]"));
		javascriptClick(selectLangPref);
		securityNumber.sendKeys(securityNum);
		internalCode.sendKeys(intCode);
		ExternalCode.sendKeys(extCode);
		log("Add mobile number and EmailId");
		long mobileNo = BasePageObject.generateMobileNumber();
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("alphamd", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		mobileNumberInput.sendKeys(AtomHC.mobileNum);
		emailInput.sendKeys(AtomHC.email);
		jse.executeScript("arguments[0].scrollIntoView(true);", patientSaveButton);
		Thread.sleep(2000);
		javascriptClick(patientSaveButton);
	}

	public void clickOnNewPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPatient);
		javascriptClick(newPatient);
	}

	public void clickOnFilesAndDocumentsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, filesAndDocuments);
		javascriptClick(filesAndDocuments);
	}

	public String highlightedFilesAndDocuments() {
		TestConfig.PrintMethodName();
		waitForElement(driver, filesAndDocuments);
		String cssValue = filesAndDocuments.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getHeaderAsFilesAndDocuments() {
		TestConfig.PrintMethodName();
		waitForElement(driver, filesAndDocumentsHeading);
		return filesAndDocumentsHeading.getText();
	}

	public boolean displayFileAndDocumentSearchbar() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchbarInfilesAndDocuments);
		boolean isPresent = false;
		try {
			waitForElement(driver, searchbarInfilesAndDocuments);
			isPresent = searchbarInfilesAndDocuments.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFileAndDocumentSearchbarPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchbarInfilesAndDocuments);
		return searchbarInfilesAndDocuments.getAttribute("placeholder");
	}

	public String getAddButtonCaptionAsFilesAndDocuments() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaptionInfilesAndDocuments);
		return addButtonCaptionInfilesAndDocuments.getText();
	}

	public String getNoRecordFoundInFilesAndDocumentsListPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordFoundInfilesAndDocumentsList);
		return noRecordFoundInfilesAndDocumentsList.getText();
	}

	public void clickOnAddButtonFileAndDocumentsTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButtonCaptionInfilesAndDocuments);
		waitForElement(driver, addButtonCaptionInfilesAndDocuments);
		javascriptClick(addButtonCaptionInfilesAndDocuments);
	}

	public void uploadDocuments(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver, documentsUpload);
		documentsUpload.sendKeys(image);
	}

	public void clickOnCategoryDropdowmList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectCategoryDropdowmListValue);
		selectCategoryDropdowmListValue.click();
	}

	public void selectAnyOneOptionInCategoryDropdowm() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectAnyOneOptionInCategoryDropdowm);
		selectAnyOneOptionInCategoryDropdowm.click();
	}

	public void enterTextInAddCaption(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, addCaptionInAttachFile);
		addCaptionInAttachFile.sendKeys(text);
	}

	public void clickOnSaveButtonInAttachFile() {
		TestConfig.PrintMethodName();
		waitForElement(driver, attachFileSaveButton);
		javascriptClick(attachFileSaveButton);
	}

	public void clickOnSaveButtonInFileAddEditPage() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileSaveButton);
		javascriptClick(fileSaveButton);
		Thread.sleep(3000);
	}

	public boolean displayFileIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, fileIcon);
			isPresent = fileIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFileName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileName);
		return fileName.getText();
	}

	public boolean isFileListPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayFileListPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayFileListPage);
			isPresent = displayFileListPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean displayFileUpdatedDateMonth() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileUploadedDateAndMonth);
		boolean isPresent = false;
		try {
			waitForElement(driver, fileUploadedDateAndMonth);
			isPresent = fileUploadedDateAndMonth.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean displayFileUpdatedAttachDocument() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileNoOfAttachDocuments);
		boolean isPresent = false;
		try {
			waitForElement(driver, fileNoOfAttachDocuments);
			isPresent = fileNoOfAttachDocuments.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void selectOtherValueInCategoryDropdowm() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectOtherValueInCategoryDropdowm);
		selectOtherValueInCategoryDropdowm.click();
	}

	public String getNoRecordsInFileList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileNoRecordsFound);
		return fileNoRecordsFound.getText();
	}

	public void clearFileAndDocumentSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchbarInfilesAndDocuments);
		searchbarInfilesAndDocuments.clear();
	}

	public void enterTextSearchedFileName(String text) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(searchbarInfilesAndDocuments);
		waitForElement(driver, searchbarInfilesAndDocuments);
		searchbarInfilesAndDocuments.sendKeys(text);
	}

	public boolean getRecordsDataNameInFileList() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, fileRecordsFound);
			isPresent = fileRecordsFound.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFileAddEditHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileNoRecordsAddEditPageHeading);
		return fileNoRecordsAddEditPageHeading.getText();
	}

	public boolean getXIconInFileAddEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditXIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, fileAddEditXIcon);
			isPresent = fileAddEditXIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSelectCategoryLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectCategoryLabel);
		return selectCategoryLabel.getText();
	}

	public boolean getSelectCategoryAstricIconDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, selectCategoryAstricIconDisplay);
			isPresent = selectCategoryAstricIconDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getselectCategoryDropdowmPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectCategoryDropdowmListValue);
		return selectCategoryDropdowmListValue.getAttribute("placeholder");
	}

	public String getTapOnTheBoxText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTapOnTheBox);
		return getTapOnTheBox.getText();
	}

	public String getSaveButtonCaptionInFileAddEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileSaveButton);
		return fileSaveButton.getText();
	}

	public String getCancelButtonCaptionInFileAddEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getCancelButtonCaptionInAddEditPage);
		return getCancelButtonCaptionInAddEditPage.getText();
	}

	public String getPatientEducationColorBand() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationColorBand);
		String cssValue = educationColorBand.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getAssignEducationCategoryLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCategoryLabel);
		return assignEducationCategoryLabel.getText();
	}

	public String getAssignEducationSelectLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationSelectLabel);
		return assignEducationSelectLabel.getText();
	}

	public boolean isAssignEducationCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, assignEducationCrossIcon);
			isPresent = assignEducationCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAttachFilePoPUpPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayAttachFilePoPUpPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayAttachFilePoPUpPage);
			isPresent = displayAttachFilePoPUpPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getHeaderCountOnSearchBased() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getSearchCount);
		return getSearchCount.getText();
	}

	public void selectFirstPatientInList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectFirstPatient);
		selectFirstPatient.click();
	}

	public String getselectedValueInCategoryDropdowm() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(selectCategoryDropdowmListValue);
		waitForElement(driver, selectCategoryDropdowmListValue);
		return selectCategoryDropdowmListValue.getAttribute("value");
	}

	public String getFileDescriptionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileDescriptionLabel);
		return fileDescriptionLabel.getText();
	}

	public String getDescriptionReadOnlyTextboxValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionReadOnlyTextbox);
		return descriptionReadOnlyTextbox.getText();
	}

	public String getAttachFileHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getAttachFileHeading);
		return getAttachFileHeading.getText();
	}

	public boolean isAttachFilePoPUpPageXIconDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, displayAttachFilePoPUpPageXIcon);
			isPresent = displayAttachFilePoPUpPageXIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAttachFileImageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayAttachFileImage);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayAttachFileImage);
			isPresent = displayAttachFileImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddCaptionTitleLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getAddCaptionTitle);
		return getAddCaptionTitle.getText();
	}

	public boolean isAddCaptionTitleAstricIconDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, displayAddCaptionTitleAstricIcon);
			isPresent = displayAddCaptionTitleAstricIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddCaptionTitleTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getAddCaptionTitleTextbox);
		return getAddCaptionTitleTextbox.getAttribute("placeholder");
	}

	public String getAttachFileSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, attachFileSaveButton);
		return attachFileSaveButton.getText();
	}

	public String getDocumentsDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, documentsDeleteButton);
		return documentsDeleteButton.getText();
	}

	public String getFileAddEditDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeleteButton);
		return fileAddEditDeleteButton.getText();
	}

	public void clickOnAnyRecordInFileListPage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnAnyRecordInFileListPage);
		waitForElement(driver, clickOnAnyRecordInFileListPage);
		clickOnAnyRecordInFileListPage.click();
	}

	public void clickFileAddEditDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeleteButton);
		fileAddEditDeleteButton.click();
	}

	public boolean isFileAddEditDeletePopupPageDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, fileAddEditDeletePopupPage);
			isPresent = fileAddEditDeletePopupPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFileAddEditDeletePopupPageHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageHeading);
		return fileAddEditDeletePopupPageHeading.getText();
	}

	public boolean getFileAddEditDeletePopupPageXIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageXIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, fileAddEditDeletePopupPageXIcon);
			isPresent = fileAddEditDeletePopupPageXIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFileAddEditDeletePopupPageMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageMsg);
		return fileAddEditDeletePopupPageMsg.getText();
	}

	public String getFileAddEditDeletePopupPageCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageCancelButton);
		return fileAddEditDeletePopupPageCancelButton.getText();
	}

	public String getFileAddEditDeletePopupPageOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageOkButton);
		return fileAddEditDeletePopupPageOkButton.getText();
	}

	public void clickOnCancelButtonInDeletePopupPage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(fileAddEditDeletePopupPageCancelButton);
		waitForElement(driver, fileAddEditDeletePopupPageCancelButton);
		fileAddEditDeletePopupPageCancelButton.click();
	}

	public boolean isNavigateToFileAddEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, navigateFileAddEditPage);
			isPresent = navigateFileAddEditPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnOkButtonInPopupPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileAddEditDeletePopupPageOkButton);
		fileAddEditDeletePopupPageOkButton.click();
	}

	public String getErrorMsgInFileNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayErrorMsgInSelectCategoryDropdown);
		return displayErrorMsgInSelectCategoryDropdown.getText();
	}

	public String getErrorMsgInDocumentUploadTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayErrorMsgInDocumentUploadTextbox);
		return displayErrorMsgInDocumentUploadTextbox.getText();
	}

	public void clickOnCancelButtonInAddEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getCancelButtonCaptionInAddEditPage);
		getCancelButtonCaptionInAddEditPage.click();
	}

	public List<String> getSelectCategoryList() {
		TestConfig.PrintMethodName();
		List<String> dropdownList = new ArrayList<String>();
		for (WebElement o : fileNameTextbox) {
			dropdownList.add(o.getText());
		}
		return dropdownList;
	}

}
