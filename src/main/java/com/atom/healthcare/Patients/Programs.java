package com.atom.healthcare.Patients;

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

public class Programs extends BasePageObject {

	public Programs(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsView1837")
	private WebElement selectPatientFromPatientList;

	@FindBy(how = How.ID, using = "PatientProgramsView")
	private WebElement patientProgramTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement patientProgramTabHeading;

	@FindBy(how = How.XPATH, using = "//img[@class='icon-left img-icon-medium ltr']")
	private WebElement patientProgramSearchIconDisplay;

	@FindBy(how = How.XPATH, using = "//span[text()='Programs']")
	private WebElement getProgramTab;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex align-items-center file-icon mr-3 ml-2']")
	private WebElement profileImageDisplay;

	@FindBy(how = How.XPATH, using = "//div[@class='table d-flex justify-content-between flex-wrap no-border ltr']")
	private WebElement listPage;

	@FindBy(how = How.XPATH, using = "//img[@src='images/program-Shape.svg']")
	private WebElement defaultProgramIconDisplay;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate']")
	private WebElement programNameDisplay;

	@FindBy(how = How.XPATH, using = "//label[text()='Enrolled On Jan 17 2023']")
	private WebElement programEnrolledDateDisplay;

	@FindBy(how = How.ID, using = "PatientsView1836")
	private WebElement patientProgramColor;

	@FindBy(how = How.XPATH, using = "(//div[@class='file-circle'])[1]")
	private WebElement displayPatientProgramColour;

	@FindBy(how = How.ID, using = "PatientProgramsViewSearchTextKey")
	private WebElement inputProgramSearchBox;

	@FindBy(how = How.ID, using = "PatientProgramsViewNoDataFoundKey")
	private WebElement errorMsgInPatientProgram;

	@FindBy(how = How.XPATH, using = "//div[@class='col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-12']")
	private WebElement selectFirstPatient;

	@FindBy(how = How.ID, using = "PatientProgramsViewAddActionKey")
	private WebElement addProgramButtonCaption;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement getMyProgramsTitle;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement getMyProgramsXIcon;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']")
	private WebElement getMyProgramsNameLabel;

	@FindBy(how = How.ID, using = "PatientProgramAddEditActionKeyinput-text")
	private WebElement isMyProgramsNameDropdown;

	@FindBy(how = How.XPATH, using = "//label[text()='Entry point']")
	private WebElement getEntryPointLabel;

	@FindBy(how = How.ID, using = "PatientProgramAddEditEntryPointKeyinput-text")
	private WebElement entryPointTextbox;

	@FindBy(how = How.ID, using = "PatientProgramsViewSaveActionKey")
	private WebElement getMyProgramSaveButton;

	@FindBy(how = How.ID, using = "PatientProgramsViewCancelActionKey")
	private WebElement getMyProgramCancelButton;

	@FindBy(how = How.XPATH, using = "//ui[@id='PatientProgramAddEditActionKeyListItems']/li")
	private List<WebElement> nameOperationTypeItem;

	@FindBy(how = How.ID, using = "ProgramNameKeyerrorLabel")
	private WebElement getNameIsRequiredErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='Fitness Program']")
	private WebElement getDropdownValue;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement getErrorMsgDuplicateData;

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

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	private WebElement emailLabel;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;

	@FindBy(how = How.XPATH, using = "//div[@class='margin-bottom-lg']")
	private WebElement newPatient;

	@FindBy(how = How.XPATH, using = "//div[@class='w-available padding-vertical-lg h-available ']")
	private WebElement displayMyProgramPage;

	@FindBy(how = How.ID, using = "PatientProgramAddEditActionKey")
	private WebElement displayProgramNameDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Diet and Lifestyle']")
	private WebElement getNewValueInDropdownField;

	@FindBy(how = How.XPATH, using = "//div[@class='margin-vertical-lg']")
	private WebElement displayPatientProgramList;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary float-right']")
	private WebElement clickOnCancelButton;

	@FindBy(how = How.ID, using = "PatientProgramsView")
	private WebElement againPatientProgramsListPageDisplay;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start'])[2]")
	private WebElement ConfirmationMsg;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[3]")
	private WebElement xIconInSaveButtonInEditMode;

	@FindBy(how = How.ID, using = "PatientAddEditExternalCodeKeyinput-text")
	private WebElement ExternalCode;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary margin-horizontal-md float-right'])[2]")
	private WebElement clickOnCancelButtonInEditMode;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right'])[2]")
	private WebElement getOkButtonCaption;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement deleteLinkButtonDisplay;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement displayAddedProgramName;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column'])[1]")
	private WebElement deletePatientProgram;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement getErrorMsgOnClickOnDeleteButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary margin-horizontal-md float-right'])[1]")
	private WebElement getCancelTextInDeletePopUpPage;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right'])[1]")
	private WebElement getOkTextInDeletePopUpPage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start'])[1]")
	private WebElement getHeadingAsDelete;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement isXIconDisplayInDeleteButtonClick;

	@FindBy(how = How.XPATH, using = "//li[text()='Nutrition and Lifestyle']")
	private WebElement getNewValueInDropdown;

	@FindBy(how = How.XPATH, using = "//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column']")
	private WebElement fileRecordsFound;

	@FindBy(how = How.ID, using = "ProgramNameKeyinput-text")
	private WebElement programName;

	@FindBy(how = How.ID, using = "EndPointTypeKeyinput-text")
	private WebElement endPointType;

	@FindBy(how = How.ID, using = "PatientProgramDaysKeyinput-text")
	private WebElement daysInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Program Test']")
	private WebElement programAddedName;

	@FindBy(how = How.ID, using = "PatientProgramDateKeydatePicker")
	private WebElement dateCalenderBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Tracker']")
	private WebElement trackerType;

	@FindBy(how = How.XPATH, using = "//button[@class='prev']")
	private WebElement prevButton;

	@FindBy(how = How.ID, using = "PatientProgramDateKeyerrorLabel")
	private WebElement dateErrorLabel;

	@FindBy(how = How.ID, using = "PatientProgramDateKeydate")
	private WebElement DOBInput;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[1]/div/div/div/span")
	private WebElement clickOnFirstPatient;

	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void selectPatientFromPatientList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectPatientFromPatientList);
		javascriptClick(selectPatientFromPatientList);
		
	}

	public void clickOnPatientProgramTab() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientProgramTab);
		waitForElement(driver, patientProgramTab);
		javascriptClick(patientProgramTab);
	}

	public String isPatientProgramTabHightlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientProgramTab);
		String cssValue = patientProgramTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientProgramListPageTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientProgramTabHeading);
		waitForElement(driver, patientProgramTabHeading);
		return patientProgramTabHeading.getText();
	}

	public String getPatientProgramSearchBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, inputProgramSearchBox);
		return inputProgramSearchBox.getAttribute("placeholder");
	}

	public boolean isPatientProgramSearchIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientProgramSearchIconDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientProgramSearchIconDisplay);
			isPresent = patientProgramSearchIconDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getProgramTab);
		return getProgramTab.getText();
	}

	public String getPatientProgramAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addProgramButtonCaption);
		return addProgramButtonCaption.getText();
	}

	public boolean isPatientProgramListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profileImageDisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, listPage);
			isPresent = listPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String isDefaultProgramIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, defaultProgramIconDisplay);
		String cssValue = defaultProgramIconDisplay.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientsProgramName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNameDisplay);
		return programNameDisplay.getText();
	}

	public String getPatientProgramEnrolledDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEnrolledDateDisplay);
		return programEnrolledDateDisplay.getText();
	}

	public void clickOnPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientProgramColor);
		patientProgramColor.click();
	}

	public String getPatientProgramColour() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayPatientProgramColour);
		String cssValue = displayPatientProgramColour.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public void enterValueInProgramSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, inputProgramSearchBox);
		inputProgramSearchBox.sendKeys(text);
	}

	public void clearValueInProgramSearchBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, inputProgramSearchBox);
		inputProgramSearchBox.clear();
	}

	public String getNoRecordFoundMsgInProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgInPatientProgram);
		return errorMsgInPatientProgram.getText();
	}

	public void selectFirstPatientInList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectFirstPatient);
		selectFirstPatient.click();
	}

	public void clickAddButtonInPatientProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addProgramButtonCaption);
		javascriptClick(addProgramButtonCaption);
	}

// My Programs Add Page Fields

	public String getMyProgramsPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramsTitle);
		return getMyProgramsTitle.getText();
	}

	public boolean isMyProgramsPageXIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramsXIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, getMyProgramsXIcon);
			isPresent = getMyProgramsXIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getMyProgramsNameLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramsNameLabel);
		return getMyProgramsNameLabel.getText();
	}

	public boolean isMyProgramsNameDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isMyProgramsNameDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, isMyProgramsNameDropdown);
			isPresent = isMyProgramsNameDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getMyProgramNameTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isMyProgramsNameDropdown);
		return isMyProgramsNameDropdown.getAttribute("placeholder");
	}

	public String getMyProgramsEntryPointLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getEntryPointLabel);
		return getEntryPointLabel.getText();
	}

	public boolean isMyProgramsEntryPointTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, entryPointTextbox);
			isPresent = entryPointTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String isMyProgramNameByDefaultEntryPointDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		return entryPointTextbox.getAttribute("value");
	}

	public String getMyProgramsAddPageSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramSaveButton);
		return getMyProgramSaveButton.getText();
	}

	public String getMyProgramsAddPageCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramCancelButton);
		return getMyProgramCancelButton.getText();
	}

	public void clickOnNameLabelDropdownInMyPrograms() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isMyProgramsNameDropdown);
		isMyProgramsNameDropdown.click();
	}

	public List<String> getMyProgramsNameTypeOperationList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : nameOperationTypeItem) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clearEntryPointDefaultValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.clear();
	}

	public void changeEntryPointValueAndEnterChar(String entryPoint) {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.sendKeys("value");
	}

	public void clickOnSaveButtonInMyProgramsPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramSaveButton);
		getMyProgramSaveButton.click();
	}

	public String getNameIsRequiresErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getNameIsRequiredErrorMsg);
		return getNameIsRequiredErrorMsg.getText();
	}

	public void clickOnNameDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDropdownValue);
		getDropdownValue.click();
	}

	public void clickOnEntryPointTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.click();
	}

	public void clearEntryPointTextboxValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.clear();
	}

	public void enterDuplicateEntryPointData(String entryPoint) {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.sendKeys("value");
	}

	public String getErrorMsgOnHeaderIsDuplicateData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getErrorMsgDuplicateData);
		return getErrorMsgDuplicateData.getText();
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

	public boolean displayMyProgramPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayMyProgramPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayMyProgramPage);
			isPresent = displayMyProgramPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean displayProgramNameDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayProgramNameDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayProgramNameDropdown);
			isPresent = displayProgramNameDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void getNewValueInDropdownField() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getNewValueInDropdownField);
		getNewValueInDropdownField.click();
	}

	public void clearEntryPointValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.clear();
	}

	public boolean displayentryPointTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, entryPointTextbox);
			isPresent = entryPointTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void enterNewValueInEntryPointTextbox(String entryPoint) {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.sendKeys("value");
	}

	public boolean displayPatientProgramList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayPatientProgramList);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayPatientProgramList);
			isPresent = displayPatientProgramList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnCancelButtonInMyProgramAddPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCancelButton);
		clickOnCancelButton.click();
	}

	public boolean isPatientProgramsListPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, againPatientProgramsListPageDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, againPatientProgramsListPageDisplay);
			isPresent = againPatientProgramsListPageDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public void changeEntryPointValue(String entryPoint) {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		entryPointTextbox.sendKeys("value");
	}

	public String getConfirmationMsgOnSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ConfirmationMsg);
		return ConfirmationMsg.getText();
	}

	public boolean isXIconDisplayInEditModeSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, xIconInSaveButtonInEditMode);
		boolean isPresent = false;
		try {
			waitForElement(driver, xIconInSaveButtonInEditMode);
			isPresent = xIconInSaveButtonInEditMode.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String isCancelButtonDisplayInEditModeSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCancelButtonInEditMode);
		return clickOnCancelButtonInEditMode.getText();
	}

	public String getOkButtonDisplayInEditModeSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkButtonCaption);
		return getOkButtonCaption.getText();
	}

	public void clickOnCancelButtonDisplayInEditModeSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCancelButtonInEditMode);
		clickOnCancelButtonInEditMode.click();
	}

	public void clickOnOkButtonInEditModeSaveButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkButtonCaption);
		getOkButtonCaption.click();
	}

	public void clickOnDeleteButtonInEditMode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteLinkButtonDisplay);
		deleteLinkButtonDisplay.click();
	}

	public String getAlreadyAddedProgramName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayAddedProgramName);
		String val = displayAddedProgramName.getAttribute("value");
		return val;
	}

	public String getAlreadyAddedEntryPoint() {
		TestConfig.PrintMethodName();
		waitForElement(driver, entryPointTextbox);
		String val = entryPointTextbox.getAttribute("value");
		return val;
	}

	public boolean isDeleteLinkButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteLinkButtonDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, deleteLinkButtonDisplay);
			isPresent = deleteLinkButtonDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public void clickOnAnyRecordInPatientProgramsListPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNameDisplay);
		javascriptClick(programNameDisplay);
	}

	public void clickOnAnyPatientProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePatientProgram);
		javascriptClick(deletePatientProgram);
	}

	public String getDeleteButtonHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getHeadingAsDelete);
		return getHeadingAsDelete.getText();
	}

	public boolean isXIconDisplayWhenClickOnDeleteButtonPopUp() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isXIconDisplayInDeleteButtonClick);
		boolean isPresent = false;
		try {
			waitForElement(driver, isXIconDisplayInDeleteButtonClick);
			isPresent = isXIconDisplayInDeleteButtonClick.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getErrorMsgInDeleteButtonPopUpPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getErrorMsgOnClickOnDeleteButton);
		return getErrorMsgOnClickOnDeleteButton.getText();
	}

	public String getCancelButtonDeleteButtonPopUpPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getCancelTextInDeletePopUpPage);
		return getCancelTextInDeletePopUpPage.getText();
	}

	public String getOkButtonDeleteButtonPopUpPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkTextInDeletePopUpPage);
		return getOkTextInDeletePopUpPage.getText();
	}

	public void clickOnCancelButtonInEditMode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getCancelTextInDeletePopUpPage);
		getCancelTextInDeletePopUpPage.click();
	}

	public void getNewValueInNameDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getNewValueInDropdown);
		getNewValueInDropdown.click();
	}

	public void clickOnOkButtonInEditMode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkTextInDeletePopUpPage);
		getOkTextInDeletePopUpPage.click();

	}

	public boolean deleteProgramData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fileRecordsFound);
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

	public void addProgramEntryPointWithTypeAsDay(String ProgName, String dayPtType, String daysEntry) throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, programName);
			String name = programAddedName.getText();
			if (name.equals(ProgName)) {
				programAddedName.click();
				log("Add program name");
				// programName.click();
				log("Add entry point Type");
				WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
				program.click();
				endPointType.click();
				log("Add entry point");
				WebElement endType = driver.findElement(By.xpath(
						"//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + dayPtType + "')]"));
				endType.click();
				daysInput.clear();
				daysInput.sendKeys(daysEntry);
				getMyProgramSaveButton.click();
			}
		} catch (Exception e) {
			waitForElement(driver, addProgramButtonCaption);
			addProgramButtonCaption.click();
			// addProgramButtonCaption.click();
			waitForElement(driver, programName);
			programName.click();
			log("Add program name");
			programName.sendKeys(ProgName);
			log("Add entry point Type");
			waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
			WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
			program.click();
			endPointType.click();
			log("Add entry point");
			WebElement endType = driver.findElement(By
					.xpath("//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + dayPtType + "')]"));
			endType.click();
			daysInput.clear();
			daysInput.sendKeys(daysEntry);
			getMyProgramSaveButton.click();
		}
	}

	public void addProgramEntryPointWithTypeAsDate(String ProgName, String datePtType, String dateEntry, String getDate)
			throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, programName);
			String name = programAddedName.getText();
			if (name.equals(ProgName)) {
				programAddedName.click();
				log("Add program name");
				log("Add entry point Type");
				waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
				WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
				program.click();
				endPointType.click();
				log("Add entry point");
				WebElement endType = driver.findElement(By.xpath(
						"//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + datePtType + "')]"));
				endType.click();
				dateCalenderBox.clear();
				WebElement selectDate = driver.findElement(By.xpath("//button[contains(.,'" + dateEntry + "')]"));
				selectDate.click();
				getMyProgramSaveButton.click();
			}
		} catch (Exception e) {
			addProgramButtonCaption.click();
			waitForElement(driver, programName);
			programName.click();
			log("Add program name");
			programName.sendKeys(ProgName);
			log("Add entry point Type");
			waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
			WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
			program.click();
			endPointType.click();
			log("Add entry point");
			WebElement endType = driver.findElement(By.xpath("//li[contains(.,'" + datePtType + "')]"));
			endType.click();
			try {
				dateCalenderBox.click();
				WebElement selectDate = driver
						.findElement(By.xpath("//button[@class='day weekday today'][contains(.,'" + dateEntry + "')]"));
				// WebElement selectDate =
				// driver.findElement(By.xpath("//div[@class='day-wrapper'][contains(.,'" +
				// dateEntry + "')][2]"));
				selectDate.click();
			} catch (Exception exp) {
				String[] get_dd_mm_yyy = getDate.split(" ");
				for (int i = 0; i <= get_dd_mm_yyy.length - 1; i++) {
					String value = get_dd_mm_yyy[i];
					log("Print Date:- " + value);
					DOBInput.sendKeys(value);
				}
			}
			getMyProgramSaveButton.click();
		}
	}

	public void addProgramEntryPointWithTypeAsTracker(String ProgName, String trackerPtType, String trackerName,
			String dateEntry, String getDate) throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, programName);
			String name = programAddedName.getText();
			if (name.equals(ProgName)) {
				programAddedName.click();
				log("Add program name");
				log("Add entry point Type");
				waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
				WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
				program.click();
				endPointType.click();
				log("Add entry point");
				WebElement endType = driver.findElement(By.xpath(
						"//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + trackerPtType + "')]"));
				endType.click();
				trackerType.click();
				// select tracker type
				dateCalenderBox.clear();
				WebElement selectDate = driver.findElement(By.xpath("//button[contains(.,'" + dateEntry + "')]"));
				selectDate.click();
				getMyProgramSaveButton.click();
			}
		} catch (Exception e) {
			addProgramButtonCaption.click();
			waitForElement(driver, programName);
			programName.click();
			log("Add program name");
			programName.sendKeys(ProgName);
			log("Add entry point Type");
			waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
			WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
			program.click();
			endPointType.click();
			log("Add entry point");
			WebElement endType = driver.findElement(By.xpath(
					"(//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + trackerPtType + "')])[2]"));
			Thread.sleep(5000);
			endType.click();
			trackerType.click();
			log("Select tracker type");
			WebElement trackerTy = driver.findElement(By.xpath("//li[contains(.,'" + trackerName + "')]"));
			trackerTy.click();
			try {
				dateCalenderBox.click();
				WebElement selectDate = driver
						.findElement(By.xpath("//button[@class='day weekday today'][contains(.,'" + dateEntry + "')]"));
				// WebElement selectDate =
				// driver.findElement(By.xpath("//div[@class='day-wrapper'][contains(.,'" +
				// dateEntry + "')][2]"));
				selectDate.click();
			} catch (Exception exp) {
//				 String getDate =getDate_MM_d_yyyy(date);
				String[] get_dd_mm_yyy = getDate.split(" ");
				for (int i = 0; i <= get_dd_mm_yyy.length - 1; i++) {
					String value = get_dd_mm_yyy[i];
					log("Print Date:- " + value);
					DOBInput.sendKeys(value);
				}
			}
			getMyProgramSaveButton.click();
			Thread.sleep(2000);
		}
	}

	public String getProgramName(String programName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + programName + "']")));
		WebElement program = driver.findElement(By.xpath("//label[text()='" + programName + "']"));
		return program.getText();
	}

	public void addPrevProgramEntryPointWithTypeAsDate(String ProgName, String datePtType, String dateEntry,
			String getDate) throws InterruptedException {
		TestConfig.PrintMethodName();
			addProgramButtonCaption.click();
			waitForElement(driver, programName);
			programName.click();
			log("Add program name");
			programName.sendKeys(ProgName);
			log("Add entry point Type");
			waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
			WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
			program.click();
			endPointType.click();
			log("Add entry point");
			WebElement endType = driver.findElement(By.xpath("//li[contains(.,'" + datePtType + "')]"));
			endType.click();
			try {
				waitForElement(driver, driver.findElement(By.xpath("//button[text()='" + dateEntry + "']")));
				WebElement selectDate = driver.findElement(By.xpath("//button[text()='" + dateEntry + "']"));
				selectDate.click();
				getMyProgramSaveButton.click();
				String errorLabel = dateErrorLabel.getText();
				if (errorLabel.equals("Date Is Required")) {
					dateCalenderBox.click();
					Thread.sleep(5000);
					prevButton.click();
					waitForElement(driver, driver.findElement(By.xpath("//button[text()='" + dateEntry + "']")));
					WebElement selectDt = driver.findElement(By.xpath("//button[text()='" + dateEntry + "']"));
					selectDt.click();
					getMyProgramSaveButton.click();
				}

			} catch (Exception exp) {
				log("Element is not present");
			}
		try {
			dateCalenderBox.click();
			WebElement selectDate = driver
					.findElement(By.xpath("//button[@class='day weekday today'][contains(.,'" + dateEntry + "')]"));
			// WebElement selectDate =
			// driver.findElement(By.xpath("//div[@class='day-wrapper'][contains(.,'" +
			// dateEntry + "')][2]"));
			selectDate.click();
		} catch (Exception exp) {
			String[] get_dd_mm_yyy = getDate.split(" ");
			log("Get cal Length "+get_dd_mm_yyy.length);
			for (int i = 0; i <= get_dd_mm_yyy.length - 1; i++) {
				String value = get_dd_mm_yyy[i];
				log("Print Date:- " + value);
				DOBInput.sendKeys(value.trim());
			}
		}
		getMyProgramSaveButton.click();
		Thread.sleep(2000);
	}

	public void addPrevProgramEntryPointWithTypeAsTracker(String ProgName, String trackerPtType, String trackerName,
			String dateEntry,String getDate) throws InterruptedException {
		TestConfig.PrintMethodName();
		addProgramButtonCaption.click();
		waitForElement(driver, programName);
		programName.click();
		log("Add program name");
		programName.sendKeys(ProgName);
		log("Add entry point Type");
		waitForElement(driver, driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]")));
		WebElement program = driver.findElement(By.xpath("//li[contains(.,'" + ProgName + "')]"));
		program.click();
		endPointType.click();
		log("Add entry point");
		WebElement endType = driver.findElement(By
				.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + trackerPtType + "')])[2]"));
		endType.click();
		trackerType.click();
		Thread.sleep(5000);
		log("Select tracker type");
		WebElement trackerTy = driver.findElement(By.xpath("//li[contains(.,'" + trackerName + "')]"));
		javascriptClick(trackerTy);
		//trackerTy.click();
		
		
		try {
			waitForElement(driver, driver.findElement(By.xpath("//button[text()='" + dateEntry + "']")));
			WebElement selectDate = driver.findElement(By.xpath("//button[text()='" + dateEntry + "']"));
			selectDate.click();
			getMyProgramSaveButton.click();
			String errorLabel = dateErrorLabel.getText();
			if (errorLabel.equals("Date Is Required")) {
				dateCalenderBox.click();
				prevButton.click();
				waitForElement(driver, driver.findElement(By.xpath("//button[text()='" + dateEntry + "']")));
				WebElement selectDt = driver.findElement(By.xpath("//button[text()='" + dateEntry + "']"));
				selectDt.click();
				getMyProgramSaveButton.click();
			}
		} catch (Exception exp) {
			log("Element is present");
		}
		try {
			dateCalenderBox.click();
			WebElement selectDate = driver
					.findElement(By.xpath("//button[@class='day weekday today'][contains(.,'" + dateEntry + "')]"));
			// WebElement selectDate =
			// driver.findElement(By.xpath("//div[@class='day-wrapper'][contains(.,'" +
			// dateEntry + "')][2]"));
			selectDate.click();
		} catch (Exception exp) {
			String[] get_dd_mm_yyy = getDate.split(" ");
			log("Get cal Length "+get_dd_mm_yyy.length);
			for (int i = 0; i <= get_dd_mm_yyy.length - 1; i++) {
				String value = get_dd_mm_yyy[i];
				log("Print Date:- " + value);
				DOBInput.sendKeys(value.trim());
			}
		}
		getMyProgramSaveButton.click();
		Thread.sleep(2000);
	}
	
	public void selectProgram(String dayPtType,String addDayEntry) throws InterruptedException {
				log("Add program");
				waitForElement(driver, addProgramButtonCaption);
				javascriptClick(addProgramButtonCaption);
				
				// addProgramButtonCaption.click();
				waitForElement(driver, programName);
				programName.click();
				log("Add entry point Type");
				WebElement program = driver.findElement(By.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'])[3]"));
				program.click();
				endPointType.click();
				log("Add entry point");
				WebElement endType = driver.findElement(By.xpath(
						"//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'" + dayPtType + "')]"));
				endType.click();
				daysInput.clear();
				daysInput.sendKeys(addDayEntry);
				getMyProgramSaveButton.click();
	}
	
	public void clickOnFirstPatient() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnFirstPatient);
		waitForElement(driver, clickOnFirstPatient);
		javascriptClick(clickOnFirstPatient);
	}
	
	public boolean isProgramDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePatientProgram);
		boolean isPresent = false;
		try {
			waitForElement(driver, deletePatientProgram);
			isPresent = deletePatientProgram.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}
	
}
