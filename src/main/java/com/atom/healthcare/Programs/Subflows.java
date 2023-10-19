package com.atom.healthcare.Programs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Subflows extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement pageTitle;

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTabclcik;

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTabText;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12\"]")
	private WebElement subFlowlistHeader;

	@FindBy(how = How.ID, using = "SubflowsViewAddActionKey")
	private WebElement subflowAddbuttonlabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Subflow Name'][1]")
	public WebElement subflowAddpageNameTextbox;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeyinput-text")
	public WebElement subflowAddpageOperationDropdown;

	@FindBy(how = How.ID, using = "FromKeyIDinput-text")
	public WebElement FromTextbox;

	@FindBy(how = How.ID, using = "SubflowsViewSearchTextKey")
	private WebElement subflowSearchbar;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
	private WebElement subflowPlaceholder;

	@FindBy(how = How.ID, using = "SubflowsViewtable-row0")
	public WebElement subflowListdisplay;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SubflowsView\"]/div[2]/label[1]")
	private WebElement subFlowListHeaderName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SubflowsView\"]/div[2]/label[2]")
	private WebElement subFlowListHeaderTaskType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SubflowsView\"]/div[2]/label[3]")
	private WebElement subFlowListHeaderItem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"SubflowsView\"]/div[2]/label[4]")
	private WebElement subFlowListHeaderOpertaionType;

	@FindBy(how = How.ID, using = "SubflowsViewSearchTextKey")
	public WebElement subflowSearchTextchange;

	@FindBy(how = How.ID, using = "SubflowsViewerrorLabel")
	private WebElement subflowViewerrorlabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement subflowAddpageTitle;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs1")
	public WebElement subflowpageLang1;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs2")
	public WebElement subflowpageLang2;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeyinput-text")
	public WebElement subflowAddpageTaskDropdown;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyinput-text")
	public WebElement subflowAddPageItemDropdown;

	@FindBy(how = How.ID, using = "SubflowsViewSaveActionKey")
	public WebElement subflowAddPageSaveButton;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Almonds')]")
	public WebElement educationItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeylabel1120")
	public WebElement subflowEducationTask;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey2input-text")
	public WebElement subflowNametextboxLang;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey1input-text")
	public WebElement subflowNameTextboxLang1;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey2input-text")
	public WebElement subflowNameTextboxLang2;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement duplicateDataError;

	@FindBy(how = How.XPATH, using = "(//label[text()='Name'])[2]")
	private WebElement subflowAddpageNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Description'])[1]")
	private WebElement subflowAddpageDescription;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupSubFlowDescriptionKey3input-textArea")
	public WebElement subflowAddPageDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//label[text()='Operation Type'])[2]")
	private WebElement subflowAddPageOperationLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Task Type'])[2]")
	private WebElement subflowAddPageTaskLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Item'])[2]")
	private WebElement subflowAddPageItemLabel;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowAddCancelbutton;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Name\"])[1]")
	private WebElement namePlaceholder;

	@FindBy(how = How.XPATH, using = "//label[text()='Subflow Edit']")
	private WebElement subflowEditpageTitle;

	@FindBy(how = How.XPATH, using = "(//textarea[@class='input-primary mb-0 pt-2  ltr'])[1]")
	private WebElement descriptionPlaceholder;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupOperationTypeKeyListItems']/li")
	private List<WebElement> subflowOperationTypeList;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeylabel1153")
	public WebElement BetweenOperationType;

	@FindBy(how = How.ID, using = "BetweenFromKeyinput-text")
	public WebElement BetweenFromValue;

	@FindBy(how = How.ID, using = "BetweenToKeyinput-text")
	public WebElement BetweenToValue;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> subflowTaskTypeList;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowEducationItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowMeasurementItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowQuestionniareItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyListItems")
	public WebElement subflowInstructionTaskType;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupSelectRoleKey")
	public WebElement subflowSelectRoleDropdown;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	public WebElement selectedEducationItem;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	private WebElement subflowSelectRole;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Role']")
	public WebElement subflowSelectRoleDropdownPlaceholder;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupSelectRoleKeyListItems']/li")
	private List<WebElement> subflowSelectRoleList;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[last()]")
	private WebElement subflowListRecord;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3input-text")
	public WebElement subflowNametextbox;

	@FindBy(how = How.ID, using = "SubflowsViewDeleteActionKey")
	public WebElement subflowDeleteButton;

	@FindBy(how = How.ID, using = "SubflowsViewOkActionKey")
	public WebElement subflowDeleteOkButton;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupProgramNameKey1input-text']")
	public WebElement subflowNameTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement subflowDeleteLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Subflow New'][last()]")
	private WebElement subflowEditedName;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[last()]")
	private WebElement subflowEditedOperationType;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])\r\n")
	private WebElement subflowDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowDeleteCancelButton;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3errorLabel")
	public WebElement subflowNameErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeyerrorLabel")
	public WebElement subflowOperationErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeyerrorLabel")
	public WebElement subflowTaskErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyerrorLabel")
	public WebElement subflowItemErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuperrorLabel")
	public WebElement subflowLangErrorMsg;

	@FindBy(how = How.ID, using = "ProgramsView")
	public WebElement programTabText;

	@FindBy(how = How.ID, using = "ProgramsViewAddActionKey")
	public WebElement programAddButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs2")
	public WebElement programpageHindiLang;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[2]")
	public WebElement programSecondLangTab;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramAddEditSupportedCodeSystemKeyinput-text']")
	public WebElement programSupportedCodeSystem;

	@FindBy(how = How.XPATH, using = "//li[text()='ICD-10 Code System']")
	public WebElement icdProgramSupportedCodeSystem;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary  ltr']")
	public WebElement clickOnProgramName;

	@FindBy(how = How.ID, using = "ProgramsViewSaveActionKey")
	public WebElement programSaveButton;

	@FindBy(how = How.XPATH, using = "//li[text()='Subflows']")
	public WebElement programSubflowTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[3]")
	public WebElement subFlowsHeader;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded ltr'])[3]")
	public WebElement subflowsSearchTextbox;

	@FindBy(how = How.XPATH, using = "//button[@id='ProgramAddEditAlternateFlowKeyAddActionKey']")
	public WebElement subflowsAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[14]")
	public WebElement alternateFlowsNameColumn;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[15]")
	public WebElement alternateFlowsOperationTypeColumn;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[16]")
	public WebElement alternateFlowsAssignAfterDaysColumn;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[17]")
	public WebElement alternateFlowsShowForDays;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramAddEditAlternateFlowKeyerrorLabel']")
	public WebElement alternateFlowsNoRecordMessage;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[2]")
	public WebElement subflowTab;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupSubFlowNameKey1input-text']")
	public WebElement subflowNameFirstLangTxtbox;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupSubFlowNameKey2input-text']")
	public WebElement subflowNameSecondLangTxtbox;

	@FindBy(how = How.XPATH, using = "//li[@id='SubflowsViewIsPopuptabs2']")
	public WebElement subflowSecondLangTab;

	@FindBy(how = How.XPATH, using = "//li[text()='Completed']")
	public WebElement operationTypeCompleted;

	@FindBy(how = How.XPATH, using = "//li[text()='Education']")
	public WebElement subflowTaskEducation;

	@FindBy(how = How.XPATH, using = "//li[text()='Almonds']")
	public WebElement subflowItemAlmondsEducation;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[3]")
	public WebElement tabTask;

	@FindBy(how = How.ID, using = "TasksViewAddActionKey")
	private WebElement addButtonCaption;

	@FindBy(how = How.ID, using = "TasksViewIsPopuptabs2")
	public WebElement taskpageHindiLang;

	@FindBy(how = How.XPATH, using = "//input[@id='TasksViewIsPopupTaskNameKey2input-text']")
	public WebElement secondLangTaskTab;

	@FindBy(how = How.ID, using = "TasksViewIsPopuptabs1")
	public WebElement taskpageEngLang;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[1]")
	public WebElement taskName;

	@FindBy(how = How.XPATH, using = "//li[text()='Education']")
	public WebElement educationTaskType;

	@FindBy(how = How.XPATH, using = "//li[text()='Almonds']")
	public WebElement taskAlmondsEducation;

	@FindBy(how = How.XPATH, using = "//label[text()='Dietingiqyis']")
	public WebElement dietingProgram;

	@FindBy(how = How.ID, using = "ProgramAddEditTasksViewAddActionKey")
	public WebElement programTaskAddButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	public WebElement taskDropdown;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	public WebElement taskAssignAfterDays;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	public WebElement taskShowForDays;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement taskSaveButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs1")
	public WebElement programpageEngLang;

	@FindBy(how = How.XPATH, using = "//li[text()='Measurement Tasks']")
	public WebElement measurementTaskType;

	@FindBy(how = How.XPATH, using = "//li[text()='Instructions']")
	public WebElement taskTypeInstructions;

	@FindBy(how = How.XPATH, using = "//li[text()='Questionnaire Tasks']")
	public WebElement taskTypeQuestionnaire;

	@FindBy(how = How.ID, using = "TasksViewSaveActionKey")
	public WebElement saveButtonCaption;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupTaskTypeKeyinput-text']")
	public WebElement subflowsTaskTypeDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Education']")
	public WebElement subflowTaskTypeEducations;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupItemKeyinput-text']")
	public WebElement subflowsItemDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Almonds']")
	public WebElement itemAlmonds;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupProgramNameKeyinput-text']")
	public WebElement subflowNameDropdown;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	public WebElement subflowsAssignAfterDays;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	public WebElement subflowsShowForDays;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement subflowsSaveButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programSubflowAddEditPageTitle;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	public WebElement subflowsTasksTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start'])[1]")
	public WebElement subflowItemLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	public WebElement alternateNameLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-xxs']")
	public WebElement subflowTaskTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start'])[2]")
	public WebElement subflowOperationTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	public WebElement alternateAssignAfterDaysLabel;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupAssignAfterDaysKeyinput-text']")
	public WebElement subflowAssignAfterDaysTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	public WebElement alternateShowForDaysLabel;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupShowForDaysKeyinput-text']")
	public WebElement subflowShowForDaysTextbox;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-secondary padding-horizontal-md float-right'])[1]")
	public WebElement cancelButtonSubflow;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	public WebElement deleteButtonSubflow;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement alternateFlowCrossIcon;

	@FindBy(how = How.XPATH, using = "//ui[@id='ProgramsViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> subflowTaskTypeDropdownList;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[1]")
	public WebElement alternateTaskTypeDropdownErrorhighlight;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramsViewIsPopupTaskTypeKeyerrorLabel']")
	public WebElement alternateTaskTypeDropdownErrorMessage;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[2]")
	public WebElement alternateItemDropdownErrorhighlight;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramsViewIsPopupItemKeyerrorLabel']")
	public WebElement alternateItemDropdownErrorMessage;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[3]")
	public WebElement alternateNameDropdownErrorhighlight;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramsViewIsPopupProgramNameKeyerrorLabel']")
	public WebElement alternateNameDropdownErrorMessage;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary error-border ltr']")
	public WebElement alternateShowForDaysTextboxErrorhighlight;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramsViewIsPopupShowForDaysKeyerrorLabel']")
	public WebElement alternateShowForDaysErrorMessage;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	public WebElement alternateDeleteConfirmationMessage;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	public WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "(//button[@id='ProgramsViewCancelActionKey'])[1]")
	public WebElement alternateConfirmationCancelButton;

	@FindBy(how = How.XPATH, using = "(//button[@id='ProgramsViewOkActionKey'])[1]")
	public WebElement alternateConfirmationOkButton;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupOperationTypeKeyinput-text']")
	public WebElement subflowOperationTypeDropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupTaskTypeKeyinput-text']")
	public WebElement subflowTaskTypeTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupItemKeyinput-text']")
	public WebElement subflowItemDropdown;

	@FindBy(how = How.XPATH, using = "//button[@id='SubflowsViewCancelActionKey']")
	public WebElement subflowCancelButton;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupTaskTypeKeyinput-text']")
	public WebElement subflowTaskTypeDropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupItemKeyinput-text']")
	public WebElement subflowItemdrpdown;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupProgramNameKeyinput-text']")
	public WebElement subflowName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm  text-start']")
	public WebElement subflowTaskTypeName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm text-start']")
	public WebElement subflowItemName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start']")
	public WebElement subflowOperationType;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Instructions Tasks']")
	public WebElement taskTypeInstruction;

	public Subflows(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCareProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickCareProgramTab);
		javascriptClick(clickCareProgramTab);
	}

	public void clickOnSubflowTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowTab);
		subFlowTab.click();
	}

	public String getProgramPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pageTitle);
		return pageTitle.getText();
	}

	public String getSubflowTabText() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subFlowTabText);
		waitForElement(driver, subFlowTabText);
		return subFlowTabText.getText();
	}

	public String getSubflowListHeader() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subFlowlistHeader);
		waitForElement(driver, subFlowlistHeader);
		return subFlowlistHeader.getText();
	}

	public boolean isSubflowSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSearchbar);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowSearchbar);
			isPresent = subflowSearchbar.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowPlaceholder);
		return subflowPlaceholder.getAttribute("placeholder");
	}

	public String getSubflowAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddbuttonlabel);
		return subflowAddbuttonlabel.getText();
	}

	public boolean isSubflowListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowListdisplay);
			isPresent = subflowListdisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubFlowListHeaderNameText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowListHeaderName);
		return subFlowListHeaderName.getText();
	}

	public String getSubFlowListHeaderTaskTypeText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowListHeaderTaskType);
		return subFlowListHeaderTaskType.getText();
	}

	public String getSubFlowListHeaderItemText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowListHeaderItem);
		return subFlowListHeaderItem.getText();
	}

	public String getSubFlowListHeaderOperationTypeText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowListHeaderOpertaionType);
		return subFlowListHeaderOpertaionType.getText();
	}

	public void sendSubflowSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSearchTextchange);
		subflowSearchTextchange.sendKeys(searchword);
	}

	public void clearSubflowSearchTextChangeword() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSearchTextchange);
		subflowSearchTextchange.clear();
	}

	public String getSubflowSearchErrorlabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowViewerrorlabel);
		return subflowViewerrorlabel.getText();
	}

	public void clickOnSubflowAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowAddbuttonlabel);
		waitForElement(driver, subflowAddbuttonlabel);
		subflowAddbuttonlabel.click();
	}

	public String getSubflowAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageTitle);
		return subflowAddpageTitle.getText();
	}

	public void clickOnSubFlowListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		javascriptClick(subflowListdisplay);
	}

	public void clickOnSubflowAddPageSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageSaveButton);
		subflowAddPageSaveButton.click();
	}

	public boolean getOperationTypeValues(String operationType, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, subflowAddpageOperationDropdown);
		subflowAddpageOperationDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(//ui[@id='SubflowsViewIsPopupOperationTypeKeyListItems']/li)[" + value + "]"));
		
		operType.click();
		String type = operType.getText();
		if (type.equals(operationType)) {
			try {
				isPresent = FromTextbox.isDisplayed();
			} catch (Exception e) {
				log("Element is not visible");
			}

		} else {
			log("Element is visble");
		}
		return isPresent;
	}

	public void sendSubflowName(String name) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowAddpageNameTextbox);
		// waitForElement(driver, subflowAddpageNameTextbox);
		subflowAddpageNameTextbox.sendKeys(name);
	}

	public void addSubflowMethod() {
		TestConfig.PrintMethodName();
		javascriptClick(subflowAddpageTaskDropdown);
		javascriptClick(subflowEducationTask);
		javascriptClick(subflowAddPageItemDropdown);
		javascriptClick(educationItem);
	}

	public void sendSubflowNameLangOne(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameTextboxLang1);
		subflowNameTextboxLang1.sendKeys(name);
	}

	public void sendSubflowNameLangTwo(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNametextboxLang);
		subflowNametextboxLang.sendKeys(name);
	}

	public String getDuplicateDataErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, duplicateDataError);
		return duplicateDataError.getText();
	}

	public String getSubflowLangOneText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang1);
		return subflowpageLang1.getText();
	}

	public void clickOnSubflowLangOne() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang1);
		subflowpageLang1.click();
	}

	public String getSubflowLangTwoText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang2);
		return subflowpageLang2.getText();
	}

	public void clickOnSubflowLangTwo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang2);
		subflowpageLang2.click();
	}

	public String getSubflowAddPageNameLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageNameLabel);
		return subflowAddpageNameLabel.getText();
	}

	public boolean isSubflowAddPageNameTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddpageNameTextbox);
			isPresent = subflowAddpageNameTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowAddPageDescriptionLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageDescription);
		return subflowAddpageDescription.getText();
	}

	public boolean isSubflowAddPageDescriptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddPageDescriptionTextbox);
			isPresent = subflowAddPageDescriptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowAddPageOperationLabeText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageOperationLabel);
		return subflowAddPageOperationLabel.getText();
	}

	public boolean isSubflowAddPageOperationDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddpageOperationDropdown);
			isPresent = subflowAddpageOperationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void onSubflowOperationDropdownClick() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageOperationDropdown);
		subflowAddpageOperationDropdown.click();
		
	}

	public String getSubflowAddPageTaskLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageTaskLabel);
		return subflowAddPageTaskLabel.getText();
	}

	public boolean isSubflowAddPageTaskDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddpageTaskDropdown);
			isPresent = subFlowTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubflowTaskDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowAddpageTaskDropdown);
		// waitForElement(driver, 50, subflowAddpageTaskDropdown);
		subflowAddpageTaskDropdown.click();
//		Actions act= new Actions(driver);
//		act.click().build().perform();
	}

	public String getSubflowAddPageItemLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageItemLabel);
		return subflowAddPageItemLabel.getText();
	}

	public boolean isSubflowAddPageItemDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddPageItemDropdown);
			isPresent = subFlowTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void onSubflowItemDropdownClick() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageItemDropdown);
		subflowAddPageItemDropdown.click();
		
	}

	public String getSubflowAddPageSaveButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageSaveButton);
		return subflowAddPageSaveButton.getText();
	}

	public String getsubflowAddPageCancelButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddCancelbutton);
		return subflowAddCancelbutton.getText();
	}

	public String getNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, namePlaceholder);
		return namePlaceholder.getAttribute("placeholder");
	}

	public String getOperationPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageOperationDropdown);
		return subflowAddpageOperationDropdown.getAttribute("placeholder");
	}

	public String getTaskTypePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageTaskDropdown);
		return subflowAddpageTaskDropdown.getAttribute("placeholder");
	}

	public String getItemPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageItemDropdown);
		return subflowAddPageItemDropdown.getAttribute("placeholder");
	}

	public void onSubflowAddCancelButtonClick() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddCancelbutton);
		subflowAddCancelbutton.click();
	
	}

	public String getSubflowEditpageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowEditpageTitle);
		return subflowEditpageTitle.getText();
	}

	public String getDescriptionPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionPlaceholder);
		return descriptionPlaceholder.getAttribute("placeholder");
	}

	public List<String> getSubflowOperationList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(subflowOperationTypeList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowOperationTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void onBetweenOperationClick() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(BetweenOperationType);
		// waitForElement(driver, 20, BetweenOperationType);
		BetweenOperationType.click();
	}

	public boolean isSubflowBetweenFromValueTextboxDisplayed() {
		TestConfig.PrintMethodName();

		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(BetweenFromValue);
			// waitForElement(driver, BetweenFromValue);
			isPresent = BetweenFromValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowFromValueTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, BetweenFromValue);
		return BetweenFromValue.getAttribute("placeholder");
	}

	public boolean isSubflowBetweenToValueTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, BetweenToValue);
			isPresent = BetweenToValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowToValueTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, BetweenToValue);
		return BetweenToValue.getAttribute("placeholder");
	}

	public String getLangTwoTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang2);
		String cssValue = subflowpageLang2.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public List<String> getSubflowTaskList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowTaskTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void getTaskTypeValues(String taskType, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageTaskDropdown);
		javascriptClick(subflowAddpageTaskDropdown);
		WebElement taskkType = driver
				.findElement(By.xpath("(//ui[@id='SubflowsViewIsPopupTaskTypeKeyListItems']/li)[" + value + "]"));
		
		taskkType.click();
	}

	public boolean isEducationItemListDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowEducationItem);
			isPresent = subflowEducationItem.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMeasurementItemListDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowMeasurementItem);
			isPresent = subflowMeasurementItem.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnaireItemListDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowQuestionniareItem);
			isPresent = subflowQuestionniareItem.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSelectRoleDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowSelectRoleDropdown);
			isPresent = subflowSelectRoleDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionItemListDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowInstructionTaskType);
			isPresent = subflowInstructionTaskType.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void onSubflowEducationItemClick() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(educationItem);
		// waitForElement(driver, educationItem);
		educationItem.click();
	}

	public boolean isSelectedEducationItemDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, selectedEducationItem);
			isPresent = selectedEducationItem.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowSelectRoleLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSelectRole);
		return subflowSelectRole.getText();
	}

	public String getSubflowSelectRoleTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSelectRoleDropdownPlaceholder);
		return subflowSelectRoleDropdownPlaceholder.getAttribute("placeholder");
	}

	public List<String> getSubflowSelectRoleList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowSelectRoleList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnSubflowListRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListRecord);
		Actions action = new Actions(driver);
		action.click(subflowListRecord).build().perform();
	}

	public String getSubflowNameTextboxPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNametextbox);
		return subflowNametextbox.getAttribute("value");
		// return subflowNametextbox.getText();
	}

	public boolean isSelectedOperationTypeDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddpageOperationDropdown);
			isPresent = subflowAddpageOperationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSelectedTaskDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAddpageTaskDropdown);
			isPresent = subflowAddpageTaskDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteButton);
		return subflowDeleteButton.getText();
	}

	public void clickOnSubflowDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteButton);
		subflowDeleteButton.click();
	}

	public void clickOnDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteOkButton);
		subflowDeleteOkButton.click();
	}

	public void clearSubflowNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNametextbox);
		subflowNametextbox.clear();
	}

	public void clearSubflowNameTextboxForLangOne() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameTextboxLang1);
		subflowNameTextboxLang1.clear();
	}

	public void clearSubflowNameTextboxForLangTwo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameTextboxLang2);
		subflowNameTextboxLang2.clear();
	}

	public String getSubflowDeleteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteLabel);
		return subflowDeleteLabel.getText();
	}

	public String getSubflowEditedName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowEditedName);
		return subflowEditedName.getText();
	}

	public String getSubflowEditedOperationType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowEditedOperationType);
		return subflowEditedOperationType.getText();
	}

	public void clickOnSelectRoleDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSelectRoleDropdown);
		subflowSelectRoleDropdown.click();
	}

	public String getSubflowDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteConfirmationMsg);
		return subflowDeleteConfirmationMsg.getText();
	}

	public String getSubflowDeleteConfirmationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteCancelButton);
		return subflowDeleteCancelButton.getText();
	}

	public String getSubflowDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteOkButton);
		return subflowDeleteOkButton.getText();
	}

	public void clickOnDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteCancelButton);
		subflowDeleteCancelButton.click();
	}

	public String isSubflowNameTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNametextbox);
		String cssValue = subflowNametextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getSubflowNameErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameErrorMsg);
		return subflowNameErrorMsg.getText();
	}

	public String isSubflowOperationDropdownErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageOperationDropdown);
		String cssValue = subflowAddpageOperationDropdown.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getSubflowOperationErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowOperationErrorMsg);
		return subflowOperationErrorMsg.getText();
	}

	public String isSubflowTaskTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageTaskDropdown);
		String cssValue = subflowAddpageTaskDropdown.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getSubflowTaskErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskErrorMsg);
		return subflowTaskErrorMsg.getText();
	}

	public String isSubflowItemTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageItemDropdown);
		String cssValue = subflowAddPageItemDropdown.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getSubflowItemErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemErrorMsg);
		return subflowItemErrorMsg.getText();
	}

	public String getSubflowLangErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowLangErrorMsg);
		return subflowLangErrorMsg.getText();
	}

	public void clickOnNewCreatedProgram(String program) throws InterruptedException {
		TestConfig.PrintMethodName();
		WebElement newProgram = driver.findElement(By.xpath("//label[text()='" + program + "']"));
		waitForElement(driver, newProgram);
		javascriptClick(newProgram);
	}

	public void clickOnSubFlowsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubflowTab);
		javascriptClick(programSubflowTab);
	}

	public void clickOnTasksAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaption);
		javascriptClick(addButtonCaption);
	}

	public void clickOnTaskTabInLangFirst() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskpageEngLang);
		taskpageEngLang.click();
	}

	public void clickOnTaskTabInLangSecond() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskpageHindiLang);
		taskpageHindiLang.click();
	}

	public String getTaskAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaption);
		return addButtonCaption.getText();
	}

	public String getTaskEngLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskpageEngLang);
		return taskpageEngLang.getText();
	}

	public String getTaskHindiLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskpageHindiLang);
		return taskpageHindiLang.getText();
	}

	public String getProgramTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		return programTabText.getText();
	}

	public String getProgramTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		String cssValue = programTabText.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getProgramAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		return programAddButton.getText();
	}

	public void clickOnProgramAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		javascriptClick(programAddButton);
	}

	public void clickOnProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		javascriptClick(programTabText);
	}

	public boolean isProgramTaskAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programTaskAddButton);
			isPresent = programTaskAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgramSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSaveButton);
		javascriptClick(programSaveButton);
	}

	public void clickOnProgramTaskAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskAddButton);
		javascriptClick(programTaskAddButton);
	}

	public void clickOnProgramNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnProgramName);
		clickOnProgramName.click();
	}

	public void sendProgramName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnProgramName);
		clickOnProgramName.sendKeys(name);
	}

	public void clickOnProgramTabInLangFirst() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programpageEngLang);
		programpageEngLang.click();
	}

	public void clickOnProgramTabInLangSecond() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programpageHindiLang);
		programpageHindiLang.click();
	}

	public boolean isMedicationAddEditSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programSaveButton);
			isPresent = programSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void enterProgramName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnProgramName);
		clickOnProgramName.sendKeys(name);
	}

	public String getSubFlowsHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subFlowsHeader);
		return subFlowsHeader.getText();
	}

	public boolean isSubflowsSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowsSearchTextbox);
			isPresent = subflowsSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubflowsAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowsAddButton);
			isPresent = subflowsAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowsNameColumn() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsNameColumn);
		return alternateFlowsNameColumn.getText();
	}

	public String getsubflowsOperationTypeColumn() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsOperationTypeColumn);
		return alternateFlowsOperationTypeColumn.getText();
	}

	public String getsubflowsAssignAfterDaysColumn() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsAssignAfterDaysColumn);
		return alternateFlowsAssignAfterDaysColumn.getText();
	}

	public String getSubflowsShowForDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsShowForDays);
		return alternateFlowsShowForDays.getText();
	}

	public String getSubFlowsNoRecordMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsNoRecordMessage);
		return alternateFlowsNoRecordMessage.getText();
	}

	public String getSubflowsSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSearchTextbox);
		return subflowsSearchTextbox.getAttribute("placeholder");
	}

	public void enterTextInSubflowsSearchTextbox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSearchTextbox);
		subflowsSearchTextbox.sendKeys(text);
	}

	public void clearTextInSubFlowsSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSearchTextbox);
		subflowsSearchTextbox.clear();
	}

	public void createMeasurementTaskType(String afterdays, String showdays) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, measurementTaskType);
		javascriptClick(measurementTaskType);
		taskAssignAfterDays.sendKeys(afterdays);
		taskShowForDays.sendKeys(showdays);
		javascriptClick(taskSaveButton);
	}

	public void createInstructionTaskType(String afterdays, String showdays) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeInstruction);
		javascriptClick(taskTypeInstruction);
		taskAssignAfterDays.sendKeys(afterdays);
		taskShowForDays.sendKeys(showdays);
		javascriptClick(taskSaveButton);
	}

	public void createEducationTaskTypeInProgram(String Education, String afterdays, String showdays) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDropdown);
		Actions action = new Actions(driver);
		action.click(taskDropdown).build().perform();
		WebElement education = driver.findElement(By.xpath("//li[text()='" + Education + "']"));
		javascriptClick(education);
		taskAssignAfterDays.sendKeys(afterdays);
		taskShowForDays.sendKeys(showdays);
		javascriptClick(taskSaveButton);
	}

	public void createQuestionnaireTaskType(String afterdays, String showdays) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeQuestionnaire);
		javascriptClick(taskTypeQuestionnaire);
		taskAssignAfterDays.sendKeys(afterdays);
		taskShowForDays.sendKeys(showdays);
		javascriptClick(taskSaveButton);
	}

	public void clickOnSecondLangTabInProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programpageHindiLang);
		javascriptClick(programpageHindiLang);
	}

	public void addSecondLangInProgram(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSecondLangTab);
		programSecondLangTab.sendKeys(name);
	}

	public void clickOnProgramSupportedCodeSystemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSupportedCodeSystem);
		javascriptClick(programSupportedCodeSystem);
	}

	public void selectIcdSupportedCodeSystem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, icdProgramSupportedCodeSystem);
		javascriptClick(icdProgramSupportedCodeSystem);
	}

	public void createEducationSubflow(String text, String txt) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddbuttonlabel);
		javascriptClick(subflowAddbuttonlabel);
		subflowNameFirstLangTxtbox.sendKeys(text);
		javascriptClick(subflowSecondLangTab);
		subflowNameSecondLangTxtbox.sendKeys(txt);
		javascriptClick(operationTypeCompleted);
		javascriptClick(subflowTaskEducation);
		javascriptClick(subflowItemAlmondsEducation);
		javascriptClick(subflowAddPageSaveButton);
	}

	public void createEducationTask(String text, String txt) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaption);
		javascriptClick(addButtonCaption);
		taskName.sendKeys(text);
	
		javascriptClick(taskpageHindiLang);
		secondLangTaskTab.sendKeys(txt);
		javascriptClick(taskpageEngLang);
		taskName.clear();
		taskName.sendKeys(text);
		javascriptClick(educationTaskType);
		javascriptClick(taskAlmondsEducation);
		javascriptClick(saveButtonCaption);
	}

	public void clickOnTabSubflow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTab);
		javascriptClick(subflowTab);
	}

	public void clickOnTabTask() {
		TestConfig.PrintMethodName();
		waitForElement(driver, tabTask);
		javascriptClick(tabTask);
	}

	public void clickOnDietProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dietingProgram);
		javascriptClick(dietingProgram);
	}

	public void clickOnSubflowsAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsAddButton);
		javascriptClick(subflowsAddButton);
	}

	public void createSubflowEducationTaskType(String name, String days, String day) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsTaskTypeDropdown);
		javascriptClick(subflowsTaskTypeDropdown);
		javascriptClick(subflowTaskTypeEducations);
		javascriptClick(subflowsItemDropdown);
		javascriptClick(itemAlmonds);
		javascriptClick(subflowNameDropdown);
		WebElement subflowName = driver.findElement(By.xpath("//li[text()='" + name + "']"));
		javascriptClick(subflowName);
		subflowsAssignAfterDays.sendKeys(days);
		subflowsShowForDays.sendKeys(day);
		javascriptClick(subflowsSaveButton);
	}

	public String getProgramSubflowAddEditPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubflowAddEditPageTitle);
		return programSubflowAddEditPageTitle.getText();
	}

	public String isValidSubFlowSearchDisplay(String subflow) {
		TestConfig.PrintMethodName();
		WebElement subflowName = driver.findElement(By.xpath("//label[text()='" + subflow + "']"));
		return subflowName.getText();
	}

	public void clickOnAnySubflowFromList(String subflow) {
		TestConfig.PrintMethodName();
		WebElement subflowName = driver.findElement(By.xpath("//label[text()='" + subflow + "']"));
		javascriptClick(subflowName);
	}

	public String getSubflowsTasksTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsTasksTypeLabel);
		return subflowsTasksTypeLabel.getText();
	}

	public boolean isSubflowTaskTypeDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsTaskTypeDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowsTaskTypeDropdown);
			isPresent = subflowsTaskTypeDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowsTaskTypeDropdownPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsTaskTypeDropdown);
		return subflowsTaskTypeDropdown.getAttribute("placeholder");
	}

	public String getItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemLabel);
		return subflowItemLabel.getText();
	}

	public boolean isSubflowsItemDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsItemDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowsItemDropdown);
			isPresent = subflowsItemDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowsItemDropdownPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsItemDropdown);
		return subflowsItemDropdown.getAttribute("placeholder");
	}

	public String getSubflowNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameLabel);
		return alternateNameLabel.getText();
	}

	public boolean isSubflowNameDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowNameDropdown);
			isPresent = subflowNameDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowsNameDropdownPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameDropdown);
		return subflowNameDropdown.getAttribute("placeholder");
	}

	public String getSubflowTaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeLabel);
		return subflowTaskTypeLabel.getText();
	}

	public String getSubflowItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemLabel);
		return subflowItemLabel.getText();
	}

	public String getSubflowOperationTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowOperationTypeLabel);
		return subflowOperationTypeLabel.getText();
	}

	public String getSubflowAssignAfterDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDaysLabel);
		return alternateAssignAfterDaysLabel.getText();
	}

	public boolean isSubflowAssignAfterDaysTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAssignAfterDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowAssignAfterDaysTextbox);
			isPresent = subflowAssignAfterDaysTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowShowForDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDaysLabel);
		return alternateShowForDaysLabel.getText();
	}

	public boolean isSubflowShowForDaysTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowShowForDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowShowForDaysTextbox);
			isPresent = subflowShowForDaysTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubflowCancelButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonSubflow);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, cancelButtonSubflow);
			isPresent = cancelButtonSubflow.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubflowSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSaveButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subflowsSaveButton);
			isPresent = subflowsSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubflowDeleteButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, deleteButtonSubflow);
			isPresent = deleteButtonSubflow.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnCrossIconInSubflowAddPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowCrossIcon);
		javascriptClick(alternateFlowCrossIcon);
	}

	public void clickOnCancelButtonInSubflowAddPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonSubflow);
		javascriptClick(cancelButtonSubflow);
	}

	public void clickOnAlternateTaskTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsTaskTypeDropdown);
		Actions action = new Actions(driver);
		action.click(subflowsTaskTypeDropdown).build().perform();
	}

	public List<String> getSubflowTaskTypeDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : subflowTaskTypeDropdownList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void clickOnSubflowsSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSaveButton);
		javascriptClick(subflowsSaveButton);
	}

	public String getAlternateTaskTypeDropdownHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeDropdownErrorhighlight);
		String cssValue = alternateTaskTypeDropdownErrorhighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getAlternateTaskTypeDropdownErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeDropdownErrorMessage);
		return alternateTaskTypeDropdownErrorMessage.getText();
	}

	public String getAlternateItemDropdownErrorhighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateItemDropdownErrorhighlight);
		String cssValue = alternateItemDropdownErrorhighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getAlternateItemDropdownErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateItemDropdownErrorMessage);
		return alternateItemDropdownErrorMessage.getText();
	}

	public String getAlternateNameDropdownErrorhighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdownErrorhighlight);
		String cssValue = alternateNameDropdownErrorhighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getAlternateNameDropdownErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdownErrorMessage);
		return alternateNameDropdownErrorMessage.getText();
	}

	public String getAlternateShowForDaysTextboxErrorhighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDaysTextboxErrorhighlight);
		String cssValue = alternateShowForDaysTextboxErrorhighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getAlternateShowForDaysErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDaysErrorMessage);
		return alternateShowForDaysErrorMessage.getText();
	}

	public void clickOnDeleteButtonInAlternateEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButtonSubflow);
		javascriptClick(deleteButtonSubflow);
	}

	public String getAlternateDeleteConfirmationMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateDeleteConfirmationMessage);
		return alternateDeleteConfirmationMessage.getText();
	}

	public boolean isAlternateConfirmationCancelButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateConfirmationCancelButton);
			isPresent = alternateConfirmationCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAlternateConfirmationCancelButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateConfirmationCancelButton);
		return alternateConfirmationCancelButton.getText();
	}

	public String getAlternateConfirmationOkButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateConfirmationOkButton);
		return alternateConfirmationOkButton.getText();
	}

	public boolean isAlternateConfirmationOkButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateConfirmationOkButton);
			isPresent = alternateConfirmationOkButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnCancelButtonInDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateConfirmationCancelButton);
		javascriptClick(alternateConfirmationCancelButton);
	}

	public void clickOnOkButtonInDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateConfirmationOkButton);
		javascriptClick(alternateConfirmationOkButton);
	}

	public boolean deletedSuflowTaskNotDisplayed(String subflow) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			WebElement subflowName = driver.findElement(By.xpath("//li[text()='" + subflow + "']"));
			BasePageObject.waitForElement(driver, subflowName);
			isPresent = subflowName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnAnySubflow(String subflow) {
		TestConfig.PrintMethodName();
		WebElement subflowName = driver.findElement(By.xpath("//label[text()='" + subflow + "']"));
		javascriptClick(subflowName);
	}

	public String getSubflowNameValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowNameTextbox);
		return subflowNameTextbox.getAttribute("value");
	}

	public String getSubflowOperationTypeDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowOperationTypeDropdown);
		return subflowOperationTypeDropdown.getAttribute("value");
	}

	public String getSubflowTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeTextbox);
		return subflowTaskTypeTextbox.getAttribute("value");
	}

	public String getSubflowItemDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemDropdown);
		return subflowItemDropdown.getAttribute("value");
	}

	public void clickOnSubflowCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowCancelButton);
		javascriptClick(subflowCancelButton);
	}

	public String getSubflowTaskTypeDropdownName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeDropdown);
		return subflowTaskTypeDropdown.getAttribute("value");
	}

	public String getSubflowItemdropdownName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemdrpdown);
		return subflowItemdrpdown.getAttribute("value");
	}

	public String getSubflowName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowName);
		return subflowName.getAttribute("value");
	}

	public String getSubflowTaskTypeName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeName);
		return subflowTaskTypeName.getText();
	}

	public String getSubflowItemName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowItemName);
		return subflowItemName.getText();
	}

	public String getSubflowOperationType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowOperationType);
		return subflowOperationType.getText();
	}

	public String getSubflowsAssignAfterDaysValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsAssignAfterDays);
		return subflowsAssignAfterDays.getAttribute("value");
	}

	public String getSubflowsShowForDaysValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsShowForDays);
		return subflowsShowForDays.getAttribute("value");
	}

}
