package com.atom.healthcare.Patients;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Tasks extends BasePageObject {

	public Tasks(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsView2416")
	private WebElement patientForChat;

	@FindBy(how = How.ID, using = "PatientTasksView")
	private WebElement patientTaskTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement patientTaskListTitle;

	@FindBy(how = How.ID, using = "PatientTasksViewSearchTextKey")
	private WebElement patientTaskSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	private WebElement patientSearchPlaceholder;

	@FindBy(how = How.ID, using = "PatientTasksViewAddActionKey")
	private WebElement patientTaskAddButton;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeylabel1126")
	private WebElement patientTaskType;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupItemKeylabel148")
	private WebElement patientTaskItem;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupItemKeyinput-text")
	private WebElement patientTaskItemDropdown;

	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[39]")
	private WebElement patientTaskFromDate;

	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[39]")
	private WebElement patientTaskNewFromDate;

	@FindBy(how = How.XPATH, using = "(//button[@role='button'])[80]")
	private WebElement patientTaskEndDate;

	@FindBy(how = How.ID, using = "PatientTasksViewSaveActionKey")
	private WebElement patientTaskSaveButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[1]")
	private WebElement patientTaskNameHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[2]")
	private WebElement patientTaskTypeHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[3]")
	private WebElement patientTaskProgramHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[4]")
	private WebElement patientTaskFromDateHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	private WebElement patientTaskEndDateHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[6]")
	private WebElement patientTaskStatusHeader;

	@FindBy(how = How.XPATH, using = "//label[starts-with(@class,'badge-error')]")
	private WebElement patientTaskStatusMissed;

	@FindBy(how = How.XPATH, using = "//label[starts-with(@class,'badge-success')]")
	private WebElement patientTaskStatusCompleted;

	@FindBy(how = How.XPATH, using = "//label[starts-with(@class,'badge-done')]")
	private WebElement patientTaskNew;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[27]")
	private WebElement patientTaskProgramName;

	@FindBy(how = How.XPATH, using = "//label[text()='--'][last()]")
	private WebElement patientTaskWithoutProgramName;

	@FindBy(how = How.XPATH, using = "//label[text()='text'][last()]")
	private WebElement patientTaskWithProgramName;

	@FindBy(how = How.XPATH, using = "//label[text()='Files & Documents (1)']")
	private WebElement getSearchCount;

	@FindBy(how = How.ID, using = "PatientProgramAddEditActionKeylabel129")
	private WebElement patientTaskProgram;

	@FindBy(how = How.ID, using = "PatientTasksViewerrorLabel")
	private WebElement patientTaskSearchNoRecordMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement patientAssignTaskTitle;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement patientTaskDetailTitle;

	@FindBy(how = How.ID, using = "PatientTasksViewerrorLabel")
	private WebElement patientTaskNoRecordView;

	@FindBy(how = How.XPATH, using = "//li[text()='Diet and Fitness Assessment']")
	private WebElement selectValueItemDropdown;

	@FindBy(how = How.XPATH, using = "//div[@class='table-row-1 w-available mx-2  cursor-pointer']")
	private WebElement selectFirstPatientTask;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[3]")
	private WebElement patientTaskAddedProgramName;

	@FindBy(how = How.XPATH, using = "//div[@class='w-available padding-vertical-lg h-available ']")
	private WebElement displayTaskDetailsPage;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement getTaskDetailsPageHeader;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement displayTaskDetailsPageCrossIcon;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-xxs']")
	private WebElement getTaskTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start'])[1]")
	private WebElement getTaskTypePrefilledData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-sm'])[1]")
	private WebElement getTaskDetailsPageNameLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement filesAndDocumentsHeading;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start'])[2]")
	private WebElement getTaskDetailsPageNamePrefilledData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-sm'])[2]")
	private WebElement getProgramLabel;
	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement patientAssignTaskCrossIcon;
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement patientTaskTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement patientTaskItemLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement patientTaskFromDateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement patientTaskEndDateLabel;

	@FindBy(how = How.ID, using = "PatientTasksViewSaveActionKey")
	private WebElement patientAssignTaskSaveButton;

	@FindBy(how = How.ID, using = "PatientTasksViewCancelActionKey")
	private WebElement patientAssignTaskCancelButton;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Task Type'])")
	private WebElement patientTaskTypePlaceholder;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Item'])")
	private WebElement patientTaskItemPlaceholder;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='MMM d yyyy'])")
	private WebElement patientTaskFromDatePlaceholder;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='MMM d yyyy'])")
	private WebElement patientTaskEndDatePlaceholder;

	@FindBy(how = How.XPATH, using = "//ui[@id='PatientTasksViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> assignTaskTypeList;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeyinput-text")
	private WebElement patientAssignTaskTypeDropdown;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeylabel1120")
	private WebElement patientEducationTaskType;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeylabel1123")
	private WebElement patientMeasurementTaskType;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeylabel1126")
	private WebElement patientQuestionnaireTaskType;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeylabel2413")
	private WebElement patientInstructionTaskType;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='PatientTasksViewIsPopupItemKeyListItems']/li"))
	private List<WebElement> EducationTaskItemList;

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

	@FindBy(how = How.ID, using = "PatientAddEditExternalCodeKeyinput-text")
	private WebElement ExternalCode;

	@FindBy(how = How.XPATH, using = "//label[text()='Mobile Number']")
	private WebElement mobileNumberLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumberInput;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	private WebElement emailLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.ID, using = "PatientMedicationsViewAddActionKey")
	private WebElement patientMedicationAddButton;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;

	@FindBy(how = How.ID, using = "PatientProgramsView")
	private WebElement patientProgramTab;
	@FindBy(how = How.ID, using = "PatientProgramsViewAddActionKey")
	private WebElement addProgramButtonCaption;

	@FindBy(how = How.ID, using = "PatientProgramsViewSaveActionKey")
	private WebElement getMyProgramSaveButton;

	@FindBy(how = How.XPATH, using = "//div[@class='col-xl-3 col-lg-4 col-md-4 col-sm-6 col-xs-12']")
	private WebElement selectFirstPatient;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupFromDateKeydatePicker")
	private WebElement patientTaskFromDateCalendarControl;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='MMM d yyyy'])[2]")
	private WebElement endDateKeydatePicker;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[1]")
	private WebElement patientAssignTaskTypeDropdownBorder;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[2]")
	private WebElement patientTaskItemDropdownBorder;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeyerrorLabel")
	private WebElement patientTaskTypeRequiredMsg;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupItemKeyerrorLabel")
	private WebElement patientTaskItemRequiredMsg;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupFromDateKeyerrorLabel")
	private WebElement patientTaskFromDateRequiredMsg;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupEndDateKeyerrorLabel")
	private WebElement patientTaskEndDateRequiredMsg;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupEndDateKey")
	private WebElement patientTaskEndDateCalendarControl;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary error-border ltr'])[1]")
	private WebElement patientTaskFromDateCalendarControlBorder;

	@FindBy(how = How.ID, using = "(//input[@class='input-primary error-border ltr'])[2]")
	private WebElement patientTaskEndDateCalendarControlBorder;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupItemKeylabel355")
	private WebElement TaskQuestionnaireItem;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement duplicateDataError;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement fromDateErrorMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start'])[1]")
	private WebElement getProgramPrefilledData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-sm'])[3]")
	private WebElement getStartEndDateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start'])[2]")
	private WebElement getStartEndDateDetails;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-sm'])[4]")
	private WebElement getStatusLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start'])[3]")
	private WebElement getStatusDetails;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-sm'])[5]")
	private WebElement getLastUpdatedDateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start'])[4]")
	private WebElement getLastUpdatedDetails;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[10]")
	private WebElement instructionDetails;

	@FindBy(how = How.ID, using = "PatientTasksView")
	private WebElement isPatientTaskListPageDisplay;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-primary padding-horizontal-md float-right']")
	private WebElement getOkButtonInEditMode;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement taskDeleteButtonCrossIcon;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement deleteButtonHeading;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement deleteButtonPopUpMsg;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md margin-horizontal-md float-right']")
	private WebElement cancelButtonCaption;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md float-right'])[2]")
	private WebElement okButtonCaption;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement taskDeleteButton;

	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupDeleteActionKey")
	private WebElement deleteButtonPopUpPage;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[10]")
	private WebElement measurementValue;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start'])[1]")
	private WebElement taskTypeLabelMeasurement;
	
	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement addButton;
	
	@FindBy(how = How.ID, using = "PatientTasksViewAddActionKey")
	private WebElement taskAddButton;
	
	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupTaskTypeKeyinput-text")
	private WebElement taskTypeTextbox;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='PatientTasksViewIsPopupTaskTypeKeyListItems']/li)[2]")
	private WebElement selectTaskType;
	
	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupItemKeyinput-text")
	private WebElement itemTextbox;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='PatientTasksViewIsPopupItemKeyListItems']/li)[2]")
	private WebElement selectItem;
	
	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupFromDateKeydate")
	private WebElement taskFromDate;
	
	@FindBy(how = How.ID, using = "PatientTasksViewIsPopupEndDateKeydate")
	private WebElement taskEndDate;

	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void clickOnEducationPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientForChat);
		javascriptClick(patientForChat);
	}

	// Patient Task List
	public void clickOnPatientTaskTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientTaskTab);
		waitForElement(driver, patientTaskTab);
		javascriptClick(patientTaskTab);
	}

	public String getPatientTaskTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskListTitle);
		return patientTaskListTitle.getText();
	}

	public boolean isPatientTaskSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskSearchTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientTaskSearchTextbox);
			isPresent = patientTaskSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientTaskSearchPlaceholderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientSearchPlaceholder);
		return patientSearchPlaceholder.getAttribute("placeholder");
	}

	public void sendTaskSearchWord(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskSearchTextbox);
		patientTaskSearchTextbox.sendKeys(text);
	}

	public String getPatientTaskAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskAddButton);
		return patientTaskAddButton.getText();
	}

	public void clickOnPatientTaskAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskAddButton);
		javascriptClick(patientTaskAddButton);
	}

	public void clickOnPatientTaskTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskType);
		javascriptClick(patientTaskType);
	}

	public void clickOnPatientTaskItemDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientTaskItem);
		waitForElement(driver, patientTaskItem);
		Actions action = new Actions(driver);
		action.click(patientTaskItemDropdown).build().perform();
	}

	public void clickOnPatientTaskFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDate);
		javascriptClick(patientTaskFromDate);
	}

	public void selectPatientTaskEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDate);
		javascriptClick(patientTaskEndDate);
	}

	public void clickOnPatientTaskSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskSaveButton);
		javascriptClick(patientTaskSaveButton);
	}

	public String getPatientTaskListHeaderName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskNameHeader);
		return patientTaskNameHeader.getText();
	}

	public String getPatientTaskListHeaderTaskType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskTypeHeader);
		return patientTaskTypeHeader.getText();
	}

	public String getPatientTaskListHeaderProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskProgramHeader);
		return patientTaskProgramHeader.getText();
	}

	public String getPatientTaskListHeaderFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDateHeader);
		return patientTaskFromDateHeader.getText();
	}

	public String getPatientTaskListHeaderEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDateHeader);
		return patientTaskEndDateHeader.getText();
	}

	public String getPatientTaskListHeaderStatus() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskStatusHeader);
		return patientTaskStatusHeader.getText();
	}

	public String getPatientTaskStatusMissed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskStatusMissed);
		return patientTaskStatusMissed.getText();
	}

	public String getPatientTaskStatusCompleted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskStatusCompleted);
		return patientTaskStatusCompleted.getText();
	}

	public String getPatientTaskStatusNew() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskNew);
		return patientTaskNew.getText();
	}

	public String getProgramNameForTaskWithoutAProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskWithoutProgramName);
		return patientTaskWithoutProgramName.getText();
	}

	public void clickTaskProgramName(String programname) {
		WebElement taskprogramname = driver.findElement(By.xpath("//label[text()='\"+programName+\"'\"]"));
		javascriptClick(taskprogramname);
	}

	public void clickOnPatientTaskListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskWithoutProgramName);
		javascriptClick(patientTaskWithoutProgramName);
	}

	public boolean isPatientTaskProgramNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskProgramName);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientTaskProgramName);
			isPresent = patientTaskProgramName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isFilesAndDocumentsHeadingDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, filesAndDocumentsHeading);
		boolean isPresent = false;
		try {
			waitForElement(driver, filesAndDocumentsHeading);
			isPresent = filesAndDocumentsHeading.isDisplayed();
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

	public void clickOnProgramItemForTask() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientTaskProgram);
		waitForElement(driver, patientTaskProgram);
		javascriptClick(patientTaskProgram);
	}

	public String getPatientTaskSearchNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskSearchNoRecordMsg);
		return patientTaskSearchNoRecordMsg.getText();
	}

	public String getPatientAssignTaskTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTitle);
		return patientAssignTaskTitle.getText();
	}

	public String getPatientTaskDetailTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskDetailTitle);
		return patientTaskDetailTitle.getText();
	}

	public String getPatientTaskNoRecordView() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskNoRecordView);
		return patientTaskNoRecordView.getText();
	}

	public void selectValueItemInDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectValueItemDropdown);
		javascriptClick(selectValueItemDropdown);
	}

	public void selectAddedPatientTask() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(selectFirstPatientTask);
		waitForElement(driver, selectFirstPatientTask);
		selectFirstPatientTask.click();
	}

	public String getPatientTaskProgramName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskAddedProgramName);
		return patientTaskAddedProgramName.getText();
	}

	public boolean isTaskDetailsPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayTaskDetailsPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayTaskDetailsPage);
			isPresent = displayTaskDetailsPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTextTaskDetailsPageHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskDetailsPageHeader);
		return getTaskDetailsPageHeader.getText();
	}

	public boolean isTaskDetailsPageCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayTaskDetailsPageCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, displayTaskDetailsPageCrossIcon);
			isPresent = displayTaskDetailsPageCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskTypeLabel);
		return getTaskTypeLabel.getText();
	}

	public String getTaskTypePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskTypePrefilledData);
		return getTaskTypePrefilledData.getText();
	}

	public String getTaskDetailsPageNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskDetailsPageNameLabel);
		return getTaskDetailsPageNameLabel.getText();
	}

	public String getTaskDetailsPageNamePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskDetailsPageNamePrefilledData);
		return getTaskDetailsPageNamePrefilledData.getText();
	}

	public String getProgramLabelInTaskDetailPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getProgramLabel);
		return getProgramLabel.getText();
	}

	public boolean isAssignTaskCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientAssignTaskCrossIcon);
			isPresent = patientAssignTaskCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientTaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskTypeLabel);
		return patientTaskTypeLabel.getText();
	}

	public String getPatientTaskItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskItemLabel);
		return patientTaskItemLabel.getText();
	}

	public String getPatientTaskFromDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDateLabel);
		return patientTaskFromDateLabel.getText();
	}

	public String getPatientTaskEndDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDateLabel);
		return patientTaskEndDateLabel.getText();
	}

	public String getPatientAssignTaskSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskSaveButton);
		return patientAssignTaskSaveButton.getText();
	}

	public String getPatientAssignTaskCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskCancelButton);
		return patientAssignTaskCancelButton.getText();
	}

	public String getPatientTaskTypePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskTypePlaceholder);
		return patientTaskTypePlaceholder.getAttribute("placeholder");
	}

	public String getPatientTaskItemPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskItemPlaceholder);
		return patientTaskItemPlaceholder.getAttribute("placeholder");
	}

	public String getPatientTaskFromDatePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDatePlaceholder);
		return patientTaskFromDatePlaceholder.getAttribute("placeholder");
	}

	public String getPatientTaskEndDatePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDatePlaceholder);
		return patientTaskEndDatePlaceholder.getAttribute("placeholder");
	}

	public void clickOnPatientAssignTaskCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskCancelButton);
		javascriptClick(patientAssignTaskCancelButton);
	}

	public List<String> getAssignTaskTypeList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : assignTaskTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnTaskTypeDropdwon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTypeDropdown);
		patientAssignTaskTypeDropdown.click();
	}

	public void clickOnEducationTaskType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationTaskType);
		patientEducationTaskType.click();
	}

	public void clickOnMeasurementTaskType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMeasurementTaskType);
		javascriptClick(patientMeasurementTaskType);
	}

	public void clickOnQuestionnaireTaskType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientQuestionnaireTaskType);
		patientQuestionnaireTaskType.click();
	}

	public void clickOnInstructionTaskType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInstructionTaskType);
		patientInstructionTaskType.click();
	}

	public List<String> getSelectedTaskItemList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : EducationTaskItemList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
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

	public void clickOnPatientProgramTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientProgramTab);
		waitForElement(driver, patientProgramTab);
		javascriptClick(patientProgramTab);
	}

	public void clickAddButtonInPatientProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addProgramButtonCaption);
		addProgramButtonCaption.click();
	}

	public void clickOnSaveButtonInMyProgramsPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMyProgramSaveButton);
		getMyProgramSaveButton.click();
	}

	public void selectFirstPatientInList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectFirstPatient);
		selectFirstPatient.click();
	}

	public boolean isPatientTaskTypeDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTypeDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientAssignTaskTypeDropdown);
			isPresent = patientAssignTaskTypeDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isPatientItemDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTypeDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientTaskItemDropdown);
			isPresent = patientTaskItemDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isTaskFromDateCanlendarControlDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTypeDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientTaskFromDateCalendarControl);
			isPresent = patientTaskFromDateCalendarControl.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isTaskEndDateCanlendarControlDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDateCalendarControl);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientTaskEndDateCalendarControl);
			isPresent = patientTaskEndDateCalendarControl.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAssignTaskFromDateEnabled(int currentDay) throws InterruptedException {
		log("Current From Date " + currentDay);
		int curDate;
		String d = String.valueOf(currentDay);
		if (d.equals("1")) {
			curDate = 30;
		} else {
			curDate = currentDay - 1;
			log("Past From Date " + curDate);
		}
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.click(patientTaskFromDateCalendarControl).build().perform();
		Thread.sleep(10000);
		WebElement selectFromDate = driver.findElement(By
				.xpath("(//div[@class='datepicker-days']/div[@class='days']/div/button[text()='" + curDate + "'])[1]"));
		javascriptClick(selectFromDate);
		boolean isPresent = false;
		try {
			waitForElement(driver, selectFromDate);
			isPresent = selectFromDate.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAssignTaskEndDateEnabled(int currentDay) throws InterruptedException {
		log("Current End Date " + currentDay);
		int curDate;
		String d = String.valueOf(currentDay);
		if (d.equals("1")) {
			curDate = 30;
		} else {
			curDate = currentDay - 1;
			log("Past End Date " + curDate);
		}
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.click(endDateKeydatePicker).build().perform();
		Thread.sleep(10000);
		WebElement selectEndDate = driver.findElement(
				By.xpath("(//div[@class='datepicker-days']/div[3]/div/button[text()='" + currentDay + "'])[2]"));
		javascriptClick(selectEndDate);
		boolean isPresent = false;
		try {
			waitForElement(driver, selectEndDate);
			isPresent = selectEndDate.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnAssignTaskSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskSaveButton);
		javascriptClick(patientAssignTaskSaveButton);
	}

	public String isPatientTaskTypeRequiredErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAssignTaskTypeDropdownBorder);
		String cssValue = patientAssignTaskTypeDropdownBorder.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientTaskRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskTypeRequiredMsg);
		return patientTaskTypeRequiredMsg.getText();
	}

	public String isPatientTaskItemRequiredErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskItemDropdownBorder);
		String cssValue = patientTaskItemDropdownBorder.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientItemRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskItemRequiredMsg);
		return patientTaskItemRequiredMsg.getText();
	}

	public String isPatientTaskFromDateRequiredErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDateCalendarControlBorder);
		String cssValue = patientTaskFromDateCalendarControlBorder.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientFromDateRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskFromDateRequiredMsg);
		return patientTaskFromDateRequiredMsg.getText();
	}

	public String isPatientTaskEndDateRequiredErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDateCalendarControlBorder);
		String cssValue = patientTaskEndDateCalendarControlBorder.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientEndDateRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskEndDateRequiredMsg);
		return patientTaskEndDateRequiredMsg.getText();
	}

	public void assignTaskToPatient() {
		TestConfig.PrintMethodName();
		javascriptClick(patientsTab);
		javascriptClick(patientForChat);
		javascriptClick(patientTaskTab);
		javascriptClick(patientTaskAddButton);
		javascriptClick(patientTaskType);
		Actions action = new Actions(driver);
		action.click(patientTaskItemDropdown).build().perform();
		javascriptClick(TaskQuestionnaireItem);
		javascriptClick(patientTaskFromDate);
		javascriptClick(patientTaskEndDate);
		javascriptClick(patientTaskSaveButton);
	}

	public String getDuplicateDataErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, duplicateDataError);
		return duplicateDataError.getText();
	}

	public void clickOnTaskQuestionnaireItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TaskQuestionnaireItem);
		javascriptClick(TaskQuestionnaireItem);
	}

	public String getFromDateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fromDateErrorMessage);
		return fromDateErrorMessage.getText();
	}

	public void selectpatientTaskFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTaskNewFromDate);
		javascriptClick(patientTaskNewFromDate);
	}

	public String getProgramPrefilledDetail() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getProgramPrefilledData);
		return getProgramPrefilledData.getText();
	}

	public String getStartEndDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getStartEndDateLabel);
		return getStartEndDateLabel.getText();
	}

	public String getStartEndDateDetails() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, getStartEndDateDetails);
		return getStartEndDateDetails.getText();
	}

	public String getStatusLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getStatusLabel);
		return getStatusLabel.getText();
	}

	public String getStatusLabellPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getStatusDetails);
		return getStatusDetails.getText();
	}

	public String getLastUpdatedLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getLastUpdatedDateLabel);
		return getLastUpdatedDateLabel.getText();
	}

	public String getLastUpdatedDateDetails() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, getLastUpdatedDetails);
		return getLastUpdatedDetails.getText();
	}

	public void clickOnInstructionValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDetails);
		javascriptClick(instructionDetails);
	}

	public void clickOkButtonInEditMode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkButtonInEditMode);
		getOkButtonInEditMode.click();
	}

	public boolean isPatientTaskListPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isPatientTaskListPageDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, isPatientTaskListPageDisplay);
			isPresent = isPatientTaskListPageDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOkButtonInEditMode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getOkButtonInEditMode);
		return getOkButtonInEditMode.getText();
	}

	public boolean isCrossIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButtonCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, taskDeleteButtonCrossIcon);
			isPresent = taskDeleteButtonCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskDeleteButtonPageMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButtonPopUpMsg);
		return deleteButtonPopUpMsg.getText();
	}

	public String getTaskCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonCaption);
		return cancelButtonCaption.getText();
	}

	public String getTaskOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okButtonCaption);
		return okButtonCaption.getText();
	}

	public void clickOnTaskDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButton);
		taskDeleteButton.click();
	}

	public void clickOnTaskCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonCaption);
		cancelButtonCaption.click();
	}

	public boolean isTaskDeleteButtonNotDiaplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, taskDeleteButton);
			isPresent = taskDeleteButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButtonCrossIcon);
		taskDeleteButtonCrossIcon.click();
	}

	public String getTaskDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButton);
		return taskDeleteButton.getText();
	}

	public boolean isDeleteButtonPopUpPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButtonPopUpPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, deleteButtonPopUpPage);
			isPresent = deleteButtonPopUpPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskDeleteButtonPageHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButtonHeading);
		return deleteButtonHeading.getText();
	}

	public void clickOnTaskOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okButtonCaption);
		okButtonCaption.click();
	}

	public void clickOnMeasurementValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, measurementValue);
		measurementValue.click();
	}

	public String getTaskTypeLabelMeasurementValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeLabelMeasurement);
		return taskTypeLabelMeasurement.getText();
	}
	

	public String getTaskName(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + task + "']")));
		WebElement taskName = driver.findElement(By.xpath("//label[text()='" + task + "']"));
		return taskName.getText();
	}


	public String getTaskFromDate(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+task+"']/following-sibling::label[3]/label")));
		WebElement taskName =driver.findElement(By.xpath("//label[text()='"+task+"']/following-sibling::label[3]"));
		return taskName.getText().trim();
	}
	
	public String getTaskEndDate(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+task+"']/following-sibling::label[4]/label")));
		WebElement taskName =driver.findElement(By.xpath("//label[text()='"+task+"']/following-sibling::label[4]/label"));
		return taskName.getText().trim();
	}
	
	public boolean isTaskDisplay(String task) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + task + "']")));
			WebElement taskName = driver.findElement(By.xpath("//label[text()='" + task + "']"));
			isPresent = taskName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getMedicationEndDateColor(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + task + "']/following-sibling::label[4]/label")));
		WebElement taskName = driver
				.findElement(By.xpath("//label[text()='" + task + "']/following-sibling::label[4]/label"));
		String getColor = taskName.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public String getTaskFromDateColor(String educationName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[3]/label")));
		WebElement education = driver
				.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[3]/label"));
		String getColor = education.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public String getTaskEndDateColor(String educationName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[4]/label")));
		WebElement education = driver
				.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[4]/label"));
		String getColor = education.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public void addNewTask(String medicineName, String doses, String frequency, int currentDate, int addDays)
			throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddButton);
		javascriptClick(taskAddButton);
		waitForElement(driver, taskTypeTextbox);
		javascriptClick(taskTypeTextbox);
		javascriptClick(selectTaskType);
		itemTextbox.sendKeys(frequency);
		javascriptClick(selectItem);

		long addDt = 24 * 60 * 60 * 1000 * currentDate;
		String yyyymmdd = BasePageObject.getDate_yyyy_mm_dd(addDt);
		String[] getDate = yyyymmdd.split("-");
		String yyyy = getDate[0];
		String mm = getDate[1];
		String dd = getDate[2];
		taskFromDate.sendKeys(mm);
		taskFromDate.sendKeys(dd);
		taskFromDate.sendKeys(yyyy);

		long addDate = 24 * 60 * 60 * 1000 * addDays;
		String getFutureDate = BasePageObject.getDate_yyyy_mm_dd(addDate);
		String[] futureDate = getFutureDate.split("-");
		System.out.println("getFutureDate " + getFutureDate);
		String year = futureDate[0];
		String month = futureDate[1];
		String date = futureDate[2];
		taskEndDate.sendKeys(month);
		taskEndDate.sendKeys(date);
		taskEndDate.sendKeys(year);
		javascriptClick(patientTaskSaveButton);
	}	       


}
