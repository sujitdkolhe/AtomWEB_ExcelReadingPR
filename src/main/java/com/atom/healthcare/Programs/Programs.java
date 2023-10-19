package com.atom.healthcare.Programs;

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

public class Programs extends BasePageObject {
	public Programs(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	WebElement caregiver = null;
	WebElement showForDays = null;
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

	@FindBy(how = How.ID, using = "SubflowsViewSearchTextKey")
	private WebElement subflowSearchbar;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
	private WebElement subflowPlaceholder;

	@FindBy(how = How.ID, using = "SubflowsViewAddActionKey")
	private WebElement subflowAddbuttonlabel;

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

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowAddCancelbutton;

	@FindBy(how = How.XPATH, using = "//label[text()='Subflow Edit']")
	private WebElement subflowEditpageTitle;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowEditCancelbutton;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs1")
	public WebElement subflowpageLang1;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs2")
	public WebElement subflowpageLang2;

	@FindBy(how = How.XPATH, using = "(//label[text()='Name'])[2]")
	private WebElement subflowAddpageNameLabel;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3input-text")
	public WebElement subflowAddpageNameTextbox;

	@FindBy(how = How.XPATH, using = "(//label[text()='Description'])[1]")
	private WebElement subflowAddpageDescription;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupSubFlowDescriptionKey3input-textArea")
	public WebElement subflowAddPageDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//label[text()='Operation Type'])[2]")
	private WebElement subflowAddPageOperationLabel;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeyinput-text")
	public WebElement subflowAddpageOperationDropdown;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupOperationTypeKeyListItems']/li")
	private List<WebElement> subflowOperationTypeList;

	@FindBy(how = How.XPATH, using = "(//label[text()='Task Type'])[2]")
	private WebElement subflowAddPageTaskLabel;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeyinput-text")
	public WebElement subflowAddpageTaskDropdown;

	@FindBy(how = How.XPATH, using = "(//label[text()='Item'])[2]")
	private WebElement subflowAddPageItemLabel;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyinput-text")
	public WebElement subflowAddPageItemDropdown;

	@FindBy(how = How.ID, using = "SubflowsViewSaveActionKey")
	public WebElement subflowAddPageSaveButton;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Name\"])[1]")
	private WebElement namePlaceholder;

	@FindBy(how = How.XPATH, using = "(//textarea[@class='input-primary mb-0 pt-2  ltr'])[1]")
	private WebElement descriptionPlaceholder;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeylabel1153")
	public WebElement BetweenOperationType;

	@FindBy(how = How.ID, using = "BetweenFromKeyinput-text")
	public WebElement BetweenFromValue;

	@FindBy(how = How.ID, using = "BetweenToKeyinput-text")
	public WebElement BetweenToValue;

	@FindBy(how = How.ID, using = "FromKeyIDinput-text")
	public WebElement FromTextbox;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> subflowTaskTypeList;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Exercise and Eating Healthy')]")
	public WebElement educationItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeylabel378")
	public WebElement questionnaireItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeylabel1")
	public WebElement measurementItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeylabel2")
	public WebElement instructionItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowEducationItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowMeasurementItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private WebElement subflowQuestionniareItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private List<WebElement> subflowNotificationItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private List<WebElement> subflowEmailItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private List<WebElement> subflowSMSItem;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupItemKeyListItems']/li")
	private List<WebElement> subflowInstructionsItem;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeylabel1120")
	public WebElement subflowEducationTask;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3input-text")
	public WebElement subflowNametextbox;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey2input-text")
	public WebElement subflowNametextboxLang;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeylabel1126")
	public WebElement subflowQuestionnaireTaskType;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyListItems")
	public WebElement subflowInstructionTaskType;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupSelectRoleKey")
	public WebElement subflowSelectRoleDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Role']")
	public WebElement subflowSelectRoleDropdownPlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	private WebElement subflowSelectRole;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupSelectRoleKeyListItems']/li")
	private List<WebElement> subflowSelectRoleList;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[last()]")
	private WebElement subflowListRecord;

	@FindBy(how = How.ID, using = "SubflowsViewDeleteActionKey")
	public WebElement subflowDeleteButton;

	@FindBy(how = How.XPATH, using = "//label[text()='Subflow New'][last()]")
	private WebElement subflowEditedName;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[last()]")
	private WebElement subflowEditedOperationType;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey1input-text")
	public WebElement subflowNameTextboxLang1;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey2input-text")
	public WebElement subflowNameTextboxLang2;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement subflowDeleteLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])\r\n")
	private WebElement subflowDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowDeleteCancelButton;

	@FindBy(how = How.ID, using = "SubflowsViewOkActionKey")
	public WebElement subflowDeleteOkButton;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3errorLabel")
	public WebElement subflowNameErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuperrorLabel")
	public WebElement subflowLangErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeyerrorLabel")
	public WebElement subflowOperationErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupTaskTypeKeyerrorLabel")
	public WebElement subflowTaskErrorMsg;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupItemKeyerrorLabel")
	public WebElement subflowItemErrorMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement duplicateDataError;

	@FindBy(how = How.ID, using = "TasksView")
	private WebElement tasksTab;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-between align-items-center col-12 px-0  ltr']/label")
	private WebElement getTaskListHeader;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKey3input-text")
	private WebElement taskAddpageNameTextbox;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKey")
	public WebElement taskAddpageOperationDropdown;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> taskOperationTypeList;

	@FindBy(how = How.ID, using = "TasksViewIsPopupItemKeyinput-text")
	public WebElement taskAddpageItemDropdown;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKey1input-text")
	public WebElement taskNameTextboxLang1;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKey2input-text")
	public WebElement taskNameTextboxLang2;

	@FindBy(how = How.ID, using = "TasksViewSearchTextKey")
	public WebElement taskSearchboxPlaceholder;

	@FindBy(how = How.XPATH, using = "//*[@id=\"TasksView\"]/div[2]/label[1]")
	public WebElement taskListHeaderName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"TasksView\"]/div[2]/label[2]")
	public WebElement taskListHeaderTaskType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"TasksView\"]/div[2]/label[3]")
	public WebElement taskListHeaderItem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"TasksView\"]/div[2]/label[4]")
	public WebElement taskListHeaderNoOfSubflows;

	@FindBy(how = How.ID, using = "TasksViewerrorLabel")
	public WebElement taskViewerrorlabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	public WebElement taskAddpageTitle;

	@FindBy(how = How.XPATH, using = "//div[@class='table-row-1 w-available mx-2  cursor-pointer']")
	public WebElement clickAnyTask;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	public WebElement instructionTabText;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[1]")
	public WebElement instructionList;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	public WebElement instructionListTitle;

	@FindBy(how = How.ID, using = "InstructionsViewSearchTextKey")
	public WebElement instructionSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement instructionSearchPlaceholder;

	@FindBy(how = How.ID, using = "InstructionsViewAddActionKey")
	public WebElement instructionAddButton;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupProgramNameKey3input-text")
	public WebElement instructionNameTextbox;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupProgramNameKey1input-text")
	public WebElement instructionNameTextboxOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupProgramNameKey2input-text")
	public WebElement instructionNameTextboxTwo;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[1]")
	public WebElement instructionDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[2]/div/p")
	public WebElement instructionDescriptionTextboxOne;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[3]/div/p")
	public WebElement instructionDescriptionTextboxTwo;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs1")
	public WebElement instructionLangOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs2")
	public WebElement instructionLangTwo;

	@FindBy(how = How.ID, using = "InstructionsViewSaveActionKey")
	public WebElement instructionSaveButton;

	@FindBy(how = How.ID, using = "InstructionsViewCancelActionKey")
	public WebElement instructionCancelButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	public WebElement taskNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	public WebElement taskDescriptionLabel;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskDescriptionKey3input-textArea")
	public WebElement descriptionTextboxPlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	public WebElement taskTypeLabel;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeyinput-text")
	public WebElement taskTypeDropdownPlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	public WebElement taskItemLabel;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md float-right']")
	public WebElement cancelButtonCaption;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	public WebElement taskAddPageCrossIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='table-header w-available mx-2']")
	public WebElement instructionNameHeader;

	@FindBy(how = How.ID, using = "TasksViewIsPopuptabs1")
	public WebElement engLangTabHighlighted;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	public WebElement selectedEducationItem;

	@FindBy(how = How.ID, using = "InstructionsViewerrorLabel")
	public WebElement instructionSearchErrorLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])")
	public WebElement instructionAddPageTitle;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Name')])[2]")
	public WebElement instructionNameLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Name']")
	public WebElement instructionNamePlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Description')])[1]")
	public WebElement instructionDescriptionLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs3")
	public WebElement instructionLangOneLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs1")
	public WebElement instructionLangTwoLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs2")
	public WebElement instructionLangThreeLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor'])[1]/p")
	public WebElement instructionEditDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@id='TasksViewIsPopupTaskTypeKey'])")
	public WebElement taskTypeValue;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeylabel1120")
	public WebElement taskEducationTypeValue;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[7]")
	public WebElement questionnaireValue;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[6]")
	public WebElement measurementValue;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	public WebElement instructionValue;

	@FindBy(how = How.XPATH, using = "(//p[text()='Instruction Test'])")
	public WebElement instructionEditDescriptionTextboxText;

	@FindBy(how = How.ID, using = "InstructionsViewDeleteActionKey")
	public WebElement instructionDeleteButton;

	@FindBy(how = How.ID, using = "InstructionsViewCancelActionKey")
	public WebElement instructionDeleteCancelButton;

	@FindBy(how = How.ID, using = "InstructionsViewOkActionKey")
	public WebElement instructionDeleteOkButton;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupProgramNameKey3errorLabel")
	public WebElement instructionNameErrorMsg;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionDescriptionKey3errorLabel")
	public WebElement instructionDescriptionErrorMsg;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLanguageErrorMsg;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupItemKeyListItems']/li")
	private List<WebElement> taskItemList;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[10]")
	public WebElement selectedItemValue;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKey3errorLabel")
	public WebElement getNameIsRequiredMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeyerrorLabel")
	public WebElement getTaskTypeIsRequiredMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupItemKeyerrorLabel")
	public WebElement getTaskItemIsRequiredMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	public WebElement programListTitle;

	@FindBy(how = How.ID, using = "ProgramsViewSearchTextKey")
	public WebElement programSearchTextbox;

	@FindBy(how = How.ID, using = "ProgramsViewSubscribeProgramActionKey")
	public WebElement programSubscribeButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[1]")
	public WebElement programNameHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[2]")
	public WebElement programTypeHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[3]")
	public WebElement programTaskHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[4]")
	public WebElement programSubflowHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	public WebElement programCaregiverHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[6]")
	public WebElement programReadingHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[7]")
	public WebElement programEducationHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[8]")
	public WebElement programMedicationHeader;

	@FindBy(how = How.XPATH, using = "//div[@class='table-row-1 w-available mx-2  cursor-pointer'][last()]")
	public WebElement programListRecords;

	@FindBy(how = How.ID, using = "ProgramSubscribeViewActionKeyinput-text")
	public WebElement programSubscribeNameDropdown;

	@FindBy(how = How.ID, using = "ProgramSubscribeViewActionKeylabel121")
	public WebElement programSubscribeNameDropdownItem;

	@FindBy(how = How.XPATH, using = "//button[text()='Subscribe']")
	public WebElement subscribeButton;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement subscribeCancel;

	@FindBy(how = How.ID, using = "ProgramsViewOkActionKey")
	public WebElement subscribeConfirmationOkButton;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement subscribeConfirmationCancelButton;

	@FindBy(how = How.ID, using = "ProgramsViewerrorLabel")
	public WebElement programNoRecordErrorMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])")
	public WebElement subscribeOtherProgramTitle;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])")
	public WebElement programAddPageTitle;

	@FindBy(how = How.XPATH, using = "//label[text()='Login Program']")
	public WebElement programEditRecord;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupProgramNameKey1input-text")
	public WebElement programNamePrefilledData;

	@FindBy(how = How.ID, using = "TasksViewIsPopuperrorLabel")
	public WebElement getAllLangRequiredErrorMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupItemKeylabel440")
	public WebElement educationValue;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[last()]")
	public WebElement clickOnAnyTask;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button cursor-pointer']")
	public WebElement deletebutton;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])")
	private WebElement taskDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement TaskDeleteCancelButton;

	@FindBy(how = How.ID, using = "TasksViewOkActionKey")
	public WebElement taskDeleteOkButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[2]")
	public WebElement alternateFlowsHeading;

	@FindBy(how = How.ID, using = "TasksViewDeleteActionKey")
	public WebElement taskDeleteButton;

	@FindBy(how = How.ID, using = "TasksViewIsPopupAddActionKey")
	public WebElement alternateAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	public WebElement subscribeNameLabel;

	@FindBy(how = How.ID, using = "ProgramSubscribeViewActionKey")
	public WebElement subscribeNameDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	public WebElement subscribeDescriptionLabel;

	@FindBy(how = How.ID, using = "ProgramSubscribeViewActionKeyinput-text")
	public WebElement subscribeDescriptionArea;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKeyinput-text")
	public WebElement alternateNameDropdown;

	@FindBy(how = How.ID, using = "TasksViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement alternateAssignAfterDay;

	@FindBy(how = How.ID, using = "TasksViewIsPopupShowForDaysKeyinput-text")
	public WebElement alternateShowForDays;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement alternateSaveButton;

	@FindBy(how = How.ID, using = "TasksViewIsPopupSearchTextKey")
	public WebElement TasksViewIsPopupSearchTextKey;

	@FindBy(how = How.ID, using = "ProgramSubscribeViewActionKeynone")
	public WebElement subscribeNoRecordMsg;

	@FindBy(how = How.XPATH, using = "(//span[text()='Subscribed'])[last()]")
	public WebElement programListSubscribedLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAllowSelfSubscriptionKeycheckbox")
	public WebElement programAllowSelfSubscription;

	@FindBy(how = How.ID, using = "ProgramAddEditAlternateFlowKeyAddActionKey")
	public WebElement programAlternateFlowAddButton;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeyAddActionKey")
	public WebElement programCaregiverAddButton;

	@FindBy(how = How.ID, using = "ProgramAddEditReadingsKeyAddActionKey")
	public WebElement programReadingAddButton;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeyAddActionKey")
	public WebElement programEducationsAddButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-secondary padding-horizontal-md margin-left-md'])[7]")
	public WebElement programMedicationAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programCaregiverAddPageTitle;

	@FindBy(how = How.XPATH, using = "(//li[@class='default ltr'])[3]")
	public WebElement programAlternateFlowTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default ltr'])[4]")
	public WebElement programCaregiverTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default ltr'])[5]")
	public WebElement programReadingsTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default ltr'])[6]")
	public WebElement programEducationsTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	public WebElement alternateNameHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[6]")
	public WebElement alternateTaskTypeHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[7]")
	public WebElement alternateItemHeader;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement alternateCancelButton;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	public WebElement allowSelfSubscriptionCheckbox;

	@FindBy(how = How.ID, using = "ProgramAddEditTasksViewtable-row0")
	public WebElement susbcribedProgramTaskRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programTaskAddEditPageTitle;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2 mt-4'])[1]")
	public WebElement susbcribedProgramAlternateFlowsRow;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeytable-row0")
	public WebElement susbcribedProgramCaregiverRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programCaregiverAddEditPageTitle;

	@FindBy(how = How.ID, using = "ProgramAddEditReadingsKeytable-row0")
	public WebElement susbcribedProgramReadingRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programReadingAddEditPageTitle;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeytable-row0")
	public WebElement susbcribedProgramEducationRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programEducationAddEditPageTitle;

	@FindBy(how = How.ID, using = "PatientMedicationAddEditMedicationHeaderKeytable-row0")
	public WebElement susbcribedProgramMedicationRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programMeasurementAddEditPageTitle;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement programCaregiverAssignAfterDaysTextbox;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyinput-text")
	public WebElement programCaregiverShowForDaysTextbox;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeySaveActionKey")
	public WebElement programCaregiverSaveButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyinput-text")
	public WebElement programProviderDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	public WebElement programlist;

	@FindBy(how = How.XPATH, using = "(//li[text()='Tasks'])")
	public WebElement programTaskTab;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeySearchTextKey")
	public WebElement programCaregiverSearchTexbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[4]")
	public WebElement programCaregiverListTitle;

	@FindBy(how = How.XPATH, using = "(//li[text()='Caregivers'])")
	public WebElement programCaregiverTabForSubscribe;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[7]")
	public WebElement alternateFlowList;

	@FindBy(how = How.ID, using = "TasksViewIsPopuperrorLabel")
	public WebElement noRecordsFoundInAlternateFlowList;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement alternateAddPageHeading;

	@FindBy(how = How.XPATH, using = "(//div[@id=\"TasksViewIsPopuptable-row0\"][last()])")
	public WebElement clickOnAlternateRecords;

	@FindBy(how = How.XPATH, using = "(//span[text()='Subscribed'])[1]")
	public WebElement subscribedProgramClick;

	@FindBy(how = How.XPATH, using = "(//div[@class='padding-horizontal-lg padding-bottom-lg'])[2]")
	public WebElement alternateFlowPage;

	@FindBy(how = How.XPATH, using = "(//label[text()='Name'])[6]")
	public WebElement nameTextLabelInAlternateAddPage;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start margin-top-xxs']")
	public WebElement alternateTaskTypeLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm  text-start']")
	public WebElement alternateTaskTypeData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start'])[1]")
	public WebElement alternateFlowItemLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm text-start']")
	public WebElement alternateFlowItemData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start'])[2]")
	public WebElement alternateFlowOperationTypeLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start']")
	public WebElement alternateFlowOperationTypeData;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	public WebElement assignAfterDaysLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[12]")
	public WebElement showForDaysLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[12]")
	public WebElement careProgramTabs;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[18]")
	public WebElement caregiverProviderListHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[19]")
	public WebElement caregiverProfessionListHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[20]")
	public WebElement caregiverAssignAfterDaysListHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[21]")
	public WebElement caregiverShowForDaysListHeader;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeytable-row0")
	public WebElement caregiverListRecord;

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[3]")
	public WebElement defaultProgramTaskIdentifierColorTextbox;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeyerrorLabel")
	public WebElement caregiverSearchNoRecordMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='success']")
	public WebElement successMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm  text-start']")
	public WebElement measurementValueSearch;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm text-start']")
	public WebElement heightValueSearch;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2 '])[1]")
	public WebElement taskListTable;

	@FindBy(how = How.XPATH, using = "//li[@class='active activeLabel ltr']")
	public WebElement taskTab;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement crossIcon;

	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramsViewtable-row0'][last()]")
	public WebElement listRecord;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement taskAddHeader;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupProgramNameKeyListItems']/li")
	private List<WebElement> nameListValue;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	public WebElement caregiverProviderLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKey")
	public WebElement caregiverProviderDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[10]")
	public WebElement caregiverAssignAfterDaysLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKey")
	public WebElement caregiverAssignAfterDaysTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	public WebElement caregiverShowForDaysLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKey")
	public WebElement caregiverShowForDaysTextbox;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeyCancelActionKey")
	public WebElement addCaregiverCancelButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Provider\"]")
	private WebElement caregiverProviderPlaceholder;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyListItems")
	public WebElement addProviderList;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[241]")
	private WebElement anyListItem;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[257]")
	private WebElement programtasklist;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	private WebElement editTaskHeader;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyerrorLabel")
	public WebElement providerFieldRequiredMsg;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysFeildRequiredRangeMsg;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement assignAfterDaysFeildRequiredRangeMsg;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysFeildRequiredMsg;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	private WebElement addTaskNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[last()]")
	private WebElement programCaregiverListRecord;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKeylabel208")
	public WebElement selectAnyValueInNameDropdown;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start']")
	public WebElement alternateFlowType;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKeyerrorLabel")
	public WebElement nameIsRequiredErroMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement assignAfterDaysIsRequiredErrorMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysIsRequiredErrorMsg;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[last()]")
	private WebElement duplicateProviderName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	public WebElement getDeleteHeading;

	@FindBy(how = How.ID, using = "TasksViewIsPopupDeleteActionKey")
	public WebElement deletePage;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement deleteCrossIconPage;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])[1]")
	public WebElement getDeletePermissionMsg;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement deleteCancelCaption;

	@FindBy(how = How.ID, using = "TasksViewOkActionKey")
	public WebElement deletePageOkCaption;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeyDeleteActionKey")
	public WebElement caregiverDeleteButton;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement caregiverDeleteCancelButton;

	@FindBy(how = How.ID, using = "ProgramsViewOkActionKey")
	public WebElement caregiverDeleteOkButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupProgramNameKeyinput-text")
	public WebElement nameTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Name\"])[2]")
	public WebElement taskNamePlaceholder;

	@FindBy(how = How.XPATH, using = "//li[text()='Educations']")
	public WebElement programEducationTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[6]")
	public WebElement educationListTitle;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[2]")
	public WebElement sendOnFisrtLangProgramName;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	public WebElement sendOnSecondLangProgramName;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeyAddActionKey")
	public WebElement clickOnEducationAddButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	public WebElement clickOnCategory;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectEducationLabelKeyinput-text")
	public WebElement clickOnEducationCategory;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	public WebElement educationAssignAfterDay;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[5]")
	public WebElement educationShowForDay;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement educationSaveButton;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeySearchTextKey")
	public WebElement educationSearchbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Education']")
	public WebElement educationListHeader;

	@FindBy(how = How.XPATH, using = "//label[text()='For providers']")
	public WebElement educationForProviderListHeader;

	@FindBy(how = How.XPATH, using = "(//label[text()='Assign After Days'])[4]")
	public WebElement educationAssignAfterDaysListHeader;

	@FindBy(how = How.XPATH, using = "(//label[text()='Show For Days'])[4]")
	public WebElement educationShowForDaysListHeader;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeytable-row0")
	public WebElement educationList;

	@FindBy(how = How.XPATH, using = "//li[text()='Medications']")
	public WebElement programMedicationsTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Program Task']")
	public WebElement programNameInList;

	@FindBy(how = How.XPATH, using = "//label[text()='Medication Add/Edit']")
	public WebElement medicationAddEditHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	public WebElement medicationAddEditMedicineNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	public WebElement medicationAddEditDosesLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupMedicineNameKeyinput-text")
	public WebElement medicationAddEditMedicineNameTextbox;

	@FindBy(how = How.ID, using = "entryDosesinput-text")
	public WebElement medicationAddEditDosesTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	public WebElement medicationAddEditUnitLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	public WebElement medicationAddEditFrequencyLabel;

	@FindBy(how = How.ID, using = "entryFrequencyinput-text")
	public WebElement medicationAddEditFrequencyTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[10]")
	public WebElement medicationAddEditHowOftenLabel;

	@FindBy(how = How.ID, using = "frequencyOptionsinput-text")
	public WebElement medicationAddEditHowOftenDropdown;

	@FindAll(@FindBy(how = How.XPATH, using = "(//ui[@id='frequencyOptionsListItems'])/li"))
	private List<WebElement> howOftenDropdownList;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	public WebElement medicationAddEditAssignForDayLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement medicationAddEditAssignForDayTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[12]")
	public WebElement medicationAddEditShowForDayLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyinput-text")
	public WebElement medicationAddEditShowForDayTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	public WebElement medicationAddEditNoteLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupNoteTextKeyinput-textArea")
	public WebElement medicationAddEditNoteTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='inhaler']")
	public WebElement clickOnMedicationRowList;

	@FindBy(how = How.ID, using = "MedicationHeaderKeyDeleteActionKey")
	public WebElement medicationAddEditDeleteButtonDisplay;

	@FindBy(how = How.XPATH, using = "//li[text()='Subflows']")
	public WebElement alternateFlowsTab;

	@FindBy(how = How.XPATH, using = "//li[text()='Calories measurement Intake']")
	public WebElement taskCalories;

	@FindBy(how = How.XPATH, using = "//li[text()='Measurement']")
	public WebElement taskTypeMeasurement;

	@FindBy(how = How.XPATH, using = "//li[text()='Calories']")
	public WebElement itemCalories;

	@FindBy(how = How.XPATH, using = "//li[text()='Measurement subflow']")
	public WebElement subflowsName;

	@FindBy(how = How.XPATH, using = "//li[text()='blood glucose level']")
	public WebElement bloodGlucoseTask;

	@FindBy(how = How.XPATH, using = "//li[text()='Test your blood glucose']")
	public WebElement itemBloodGlucose;

	@FindBy(how = How.XPATH, using = "//label[text()='Measurement subflow']")
	public WebElement alternateTask;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	public WebElement ItemLabel;

	@FindBy(how = How.XPATH, using = "(//img[@class='icon-left img-icon-medium ltr'])[8]")
	public WebElement searchIconInMedicationName;

	@FindBy(how = How.ID, using = "frequencyOptionsinput-text")
	public WebElement clickOnMedicationAddEditHowOftenDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Education Tasks']")
	public WebElement taskTypeEducation;

	@FindBy(how = How.XPATH, using = "//ui[@id='ProgramsViewIsPopupItemKeyListItems']/li")
	private List<WebElement> taskTypeItemList;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupItemKeyinput-text']")
	public WebElement itemDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Questionnaire']")
	public WebElement alternateTaskTypeQuestionnaire;

	@FindBy(how = How.XPATH, using = "//li[text()='Instructions']")
	public WebElement alternateTaskTypeInstruction;

	@FindBy(how = How.XPATH, using = "//label[text()='Measurement subflow']")
	public WebElement subflowTaskTypeMeasurement;

	@FindBy(how = How.XPATH, using = "//label[text()='Questionnaire subflow']")
	public WebElement subflowTaskTypeQuestionnaire;

	@FindBy(how = How.XPATH, using = "//label[text()='Instructions subflow']")
	public WebElement subflowTaskTypeInstructions;

	@FindBy(how = How.XPATH, using = "//input[@id='SubflowsViewIsPopupSubFlowNameKey1input-text']")
	public WebElement subflowNameTextbox;

	@FindBy(how = How.XPATH, using = "//li[text()='Measurement']")
	public WebElement alternatetaskTypeMeasurement;

	@FindBy(how = How.XPATH, using = "//input[@id='FromKeyIDinput-text']")
	public WebElement subflowFromValue;

	@FindBy(how = How.ID, using = "dosesUnitlabel25")
	public WebElement unitDropdownTabletselect;

	@FindBy(how = How.XPATH, using = "(//button[@id='ProgramsViewCancelActionKey'])[1]")
	public WebElement medicationAddEditCancelButton;

	@FindBy(how = How.XPATH, using = "//label[text()='Alternate for']")
	public WebElement medicationAddEditAlternateForLabel;

	@FindBy(how = How.ID, using = "alternateDaysinput-text")
	public WebElement medicationAddEditAlternateForTextbox;

	@FindBy(how = How.ID, using = "frequencyOptionslabel567")
	public WebElement medicationAddEditAlternateForDropdownSelect;

	@FindBy(how = How.ID, using = "alternateDayserrorLabel")
	public WebElement medicationAddEditAlternateForErrorMessage;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement medicationAddEditAssignForErrorMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[7]")
	public WebElement medicationListLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement medicationAddEditShowErrorMessage;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeyerrorLabel")
	public WebElement educationRecords;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	public WebElement clickSupportedCodeSystem;

	@FindBy(how = How.ID, using = "ProgramAddEditSupportedCodeSystemKeylabel640")
	public WebElement selectCodeSystem;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programEducationHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement programEducationCrossIcon;

	@FindBy(how = How.XPATH, using = "(//label[text()='Category'])[2]")
	public WebElement programEducationCategoryLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Education'])[2]")
	public WebElement programEducationLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Assign After Days'])[5]")
	public WebElement programEducationAssignAfterDaysLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Show For Days'])[5]")
	public WebElement programEducationShowForDaysLabel;

	@FindBy(how = How.XPATH, using = "//div[@id='ProgramsViewtable-row0']/label[contains(.,'Program Test')]")
	public WebElement programTest;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Caregivers')]")
	public WebElement caregiverTab;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyinput-text")
	public WebElement providerDropdown;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement assignAfterDaysTextbox;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyinput-text")
	public WebElement showForDaysTextbox;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Programs')]")
	public WebElement programsTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr '])[2]")
	public WebElement forProviderCheckbox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md float-right']")
	public WebElement educationCancelButton;

	@FindBy(how = How.XPATH, using = "//ui[@id='ProgramsViewIsPopupSelectCategoryKeyListItems']//li")
	private List<WebElement> categoryDropdownList;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement errorMsgInAssignAfterDays;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement errorMsgInShowForDays;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupMedicineNameKeyerrorLabel")
	public WebElement programMedicationMedicineNameErrorLabel;

	@FindBy(how = How.ID, using = "entryDoseserrorLabel")
	public WebElement programMedicationDosesErrorLabel;

	@FindBy(how = How.ID, using = "entryFrequencyerrorLabel")
	public WebElement programMedicationFrequencyErrorLabel;

	@FindBy(how = How.ID, using = "frequencyOptionserrorLabel")
	public WebElement programMedicationHowOftenErrorLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement programMedicationAssignAfterDaysErrorLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement programMedicationShowForDaysErrorLabel;

	@FindBy(how = How.ID, using = "frequencyOptionslabel564")
	public WebElement programMedicationDailyDropdownLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start'])[1]")
	public WebElement programMedicationDeleteLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectCategoryKeyerrorLabel")
	public WebElement errorMsgCategoryIsRequired;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectEducationLabelKeyerrorLabel")
	public WebElement errorMsgEducationIsRequired;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement errorMsgAssignAfterDaysIsRequired;

	@FindBy(how = How.XPATH, using = "//li[text()='Tablet']")
	public WebElement programMedicationTabletLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	public WebElement medicationAddEditUnitDropdown;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement errorMsgShowForDaysIsRequired;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeytable-row0")
	public WebElement openEducationRecord;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	public WebElement educationDelete;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	public WebElement educationDeletePageHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[3]")
	public WebElement educationDeleteCrossIcon;

	@FindBy(how = How.XPATH, using = "//p[text()='Are you sure you want to delete?']")
	public WebElement educationDeleteMsg;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement educationDeleteCancelCaption;

	@FindBy(how = How.ID, using = "ProgramsViewOkActionKey")
	public WebElement educationDeleteCaption;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[2]")
	public WebElement programTaskLabel;

	@FindBy(how = How.ID, using = "ProgramAddEditTasksViewSearchTextKey")
	public WebElement programTaskSearchTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']")
	public WebElement programTaskListNameLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Task Type']")
	public WebElement programTaskListTaskTypeLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Item']")
	public WebElement programTaskListItemLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Assign After Days']")
	public WebElement programTaskListAssignAfterDaysLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Show For Days']")
	public WebElement programTaskListShowForDaysLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	public WebElement itemSubflowDropdown;

	@FindBy(how = How.XPATH, using = "//input[@id='ProgramsViewIsPopupProgramNameKeyinput-text']")
	public WebElement nameSubflowDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	public WebElement itemLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[10]")
	public WebElement subflowNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	public WebElement subflowAssignAfterDaysLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[12]")
	public WebElement subflowShowForDaysLabel;

	@FindBy(how = How.ID, using = "TasksViewSaveActionKey")
	public WebElement saveButtonCaption;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programSubflowAddEditPageTitle;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement alternateFlowCrossIcon;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-secondary padding-horizontal-md float-right'])[1]")
	public WebElement cancelButtonSubflow;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	public WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	public WebElement taskAssignAfterDays;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	public WebElement taskShowForDays;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement taskSaveButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	public WebElement subflowsAssignAfterDays;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	public WebElement subflowsShowForDays;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right'])[1]")
	public WebElement subflowsSaveButton;

	@FindBy(how = How.XPATH, using = "//li[text()='Instructions']")
	public WebElement taskTypeInstructions;

	@FindBy(how = How.XPATH, using = "//li[text()='Education']")
	public WebElement subflowTaskTypeEducations;

	@FindBy(how = How.XPATH, using = "//li[text()='Measurement Tasks']")
	public WebElement measurementTaskType;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary  ltr']")
	public WebElement clickOnProgramName;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs1")
	public WebElement programpageEngLang;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs2")
	public WebElement programpageHindiLang;

	@FindBy(how = How.ID, using = "ProgramsViewSaveActionKey")
	public WebElement programSaveButton;
	
	@FindBy(how = How.ID, using = "ProgramsViewAddActionKey")
	public WebElement programAddButton;
	
	@FindBy(how = How.ID, using = "ProgramsView")
	public WebElement programTabText;
	
	@FindBy(how = How.ID, using = "ProgramAddEditTasksViewAddActionKey")
	public WebElement programTaskAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programAlternateAddEditPageTitle;
	
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
		waitForElement(driver, subFlowTabText);
		return subFlowTabText.getText();
	}

	public String getSubflowListHeader() {
		TestConfig.PrintMethodName();
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
		waitForElement(driver, subflowAddbuttonlabel);
		subflowAddbuttonlabel.click();
	}

	public String getSubflowAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageTitle);
		return subflowAddpageTitle.getText();
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

	public void clickOnSubFlowListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		javascriptClick(subflowListdisplay);
	}

	public void onSubflowEditCancelButtonClick() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowEditCancelbutton);
		subflowEditCancelbutton.click();
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
		waitForElement(driver, subflowAddpageTaskDropdown);
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

	public void clickOnSubflowAddPageSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageSaveButton);
		subflowAddPageSaveButton.click();
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

	public String getDescriptionPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionPlaceholder);
		return descriptionPlaceholder.getAttribute("placeholder");
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

	public List<String> getSubflowOperationList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowOperationTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void onBetweenOperationClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, BetweenOperationType);
		BetweenOperationType.click();
	}

	public boolean isSubflowBetweenFromValueTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, BetweenFromValue);
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

	public boolean isFromTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, FromTextbox);
			isPresent = FromTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowFromTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, FromTextbox);
		return FromTextbox.getAttribute("placeholder");
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

//	public List<String> getSubflowEducationItemList() {
//		TestConfig.PrintMethodName();
//		List<String> dropDownList = new ArrayList<String>();
//		for (WebElement o : subflowEducationItem) {
//			dropDownList.add(o.getText());
//		}
//		return dropDownList;
//	}
//
//	public List<String> getSubflowMeasurementList() {
//		TestConfig.PrintMethodName();
//		List<String> dropDownList = new ArrayList<String>();
//		for (WebElement o : subflowMeasurementItem) {
//			dropDownList.add(o.getText());
//		}
//		return dropDownList;
//	}
//
//	public List<String> getSubflowQuestionnaireList() {
//		TestConfig.PrintMethodName();
//		List<String> dropDownList = new ArrayList<String>();
//		for (WebElement o : subflowQuestionniareItem) {
//			dropDownList.add(o.getText());
//		}
//		return dropDownList;
//	}

	public List<String> getSubflowEmailList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowEmailItem) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public List<String> getSubflowSMSList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowSMSItem) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public List<String> getSubflowInstructionsList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : subflowInstructionsItem) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void sendSubflowName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddpageNameTextbox);
		subflowAddpageNameTextbox.sendKeys(name);
	}

	public void onSubflowEducationTaskClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowEducationTask);
		subflowEducationTask.click();
	}

	public void onSubflowEducationItemClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationItem);
		educationItem.click();
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

	public void onSubflowQuestionnaireTaskClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowQuestionnaireTaskType);
		subflowQuestionnaireTaskType.click();
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

	public void clickOnSelectRoleDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowSelectRoleDropdown);
		subflowSelectRoleDropdown.click();
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

	public void clickOnDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteCancelButton);
		subflowDeleteCancelButton.click();
	}

	public String getSubflowDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteOkButton);
		return subflowDeleteOkButton.getText();
	}

	public void clickOnDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteOkButton);
		subflowDeleteOkButton.click();
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

	public String getDuplicateDataErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, duplicateDataError);
		return duplicateDataError.getText();
	}

	// Task list page
	public void clickOnTasksTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, tasksTab);
		tasksTab.click();
	}

	public String getTasksTabName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, tasksTab);
		return tasksTab.getText();
	}

	public String getTasksListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskListHeader);
		return getTaskListHeader.getText();
	}

	public void clickOnTasksName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		taskAddpageNameTextbox.click();
	}

	public void sendTasksName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		taskAddpageNameTextbox.sendKeys(name);
	}

	public boolean getTaskOperationTypeValues(String operationType, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, taskAddpageOperationDropdown);
		taskAddpageOperationDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(//ui[@id='TasksViewIsPopupTaskTypeKeyListItems']/li)[" + value + "]"));
		
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

	public List<String> getTaskList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : taskOperationTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void addTaskMethod() {
		TestConfig.PrintMethodName();
		javascriptClick(taskAddpageItemDropdown);
	}

	public void sendTaskNameForFirstLang(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskNameTextboxLang1);
		taskNameTextboxLang1.sendKeys(name);
	}

	public void sendTaskNameForSecondLang(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskNameTextboxLang2);
		taskNameTextboxLang2.sendKeys(name);
	}

	public void clickOnTasksSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveButtonCaption);
		saveButtonCaption.click();
	}

	public boolean isTaskSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskSearchboxPlaceholder);
			isPresent = taskSearchboxPlaceholder.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskSearchboxPlaceholder);
		return taskSearchboxPlaceholder.getAttribute("placeholder");
	}

	public boolean isTaskListDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, tasksTab);
			isPresent = tasksTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNameTextInTaskListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskListHeaderName);
		return taskListHeaderName.getText();
	}

	public String getTypeTextInTaskListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskListHeaderTaskType);
		return taskListHeaderTaskType.getText();
	}

	public String getItemTextInTaskListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskListHeaderItem);
		return taskListHeaderItem.getText();
	}

	public String getNoOfSubflowTypeTextInTaskListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskListHeaderNoOfSubflows);
		return taskListHeaderNoOfSubflows.getText();
	}

	public void sendTaskSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskSearchboxPlaceholder);
		taskSearchboxPlaceholder.sendKeys(searchword);
	}

	public String getTaskListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskListHeader);
		return getTaskListHeader.getText();
	}

	public void clearTaskSearchTextChangeword() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskSearchboxPlaceholder);
		taskSearchboxPlaceholder.clear();
	}

	public String getTaskSearchErrorlabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskViewerrorlabel);
		return taskViewerrorlabel.getText();
	}

	public boolean isTaskListPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, tasksTab);
			isPresent = tasksTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageTitle);
		return taskAddpageTitle.getText();
	}

	public void clickOnTaskListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickAnyTask);
		clickAnyTask.click();
	}

	public String getInstructionTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionTabText);
		return instructionTabText.getText();
	}

	public String getLangTwoTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang2);
		String cssValue = subflowpageLang2.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getInstructionTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionTabText);
		String cssValue = instructionTabText.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isInstructionListPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionList);
			isPresent = tasksTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddPageNameLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskNameLabel);
		return taskNameLabel.getText();
	}

	public String getTaskNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		return taskAddpageNameTextbox.getAttribute("placeholder");
	}

	public boolean isTaskAddPageNameTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskAddpageNameTextbox);
			isPresent = taskAddpageNameTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getInstructionListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionListTitle);
		return instructionListTitle.getText();
	}

	public boolean isInstructionSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionSearchTextbox);
			isPresent = instructionSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearInstructionSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		instructionSearchTextbox.clear();
	}

	public void sendInstructionSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		instructionSearchTextbox.sendKeys(searchword);
	}

	public String getInstructionSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchPlaceholder);
		return instructionSearchPlaceholder.getAttribute("placeholder");
	}

	public String getInstructionAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddButton);
		return instructionAddButton.getText();
	}

	public void clickOnInstructionAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddButton);
		instructionAddButton.click();
	}

	public void sendInstructionName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		instructionNameTextbox.sendKeys(name);
	}

	public void sendInstructionNameOnFirstTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextboxOne);
		instructionNameTextboxOne.sendKeys(name);
	}

	public void sendInstructionNameOnSecondTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextboxTwo);
		instructionNameTextboxTwo.sendKeys(name);
	}

	public void sendInstructionDescription(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextbox);
		driver.findElement(By.xpath("(//div[@data-gramm='false'])[3]/p/br"));
		Actions action = new Actions(driver);
		action.sendKeys(instructionDescriptionTextbox, name).build().perform();
	}

	public void clickOnFirstInstructionLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangOne);
		instructionLangOne.click();
	}

	public void clickOnSecondInstructionLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangTwo);
		instructionLangTwo.click();
	}

	public void clickOnInstructionSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSaveButton);
		instructionSaveButton.click();
	}

	public String getInstructionSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSaveButton);
		return instructionSaveButton.getText();
	}

	public void clickOnInstructionCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionCancelButton);
		instructionCancelButton.click();
	}

	public String getInstructionCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionCancelButton);
		return instructionCancelButton.getText();
	}

	public String getTaskAddPageDescriptionLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDescriptionLabel);
		return taskDescriptionLabel.getText();
	}

	public String getTaskAddPageDescriptionPlaceholderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionTextboxPlaceholder);
		return descriptionTextboxPlaceholder.getAttribute("placeholder");
	}

	public boolean isDescriptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionTextboxPlaceholder);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, descriptionTextboxPlaceholder);
			isPresent = descriptionTextboxPlaceholder.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddPagetaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeLabel);
		return taskTypeLabel.getText();
	}

	public String getTaskAddPageTaskDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeDropdownPlaceholder);
		return taskTypeDropdownPlaceholder.getAttribute("placeholder");
	}

	public boolean isTaskTypeDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeDropdownPlaceholder);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskTypeDropdownPlaceholder);
			isPresent = taskTypeDropdownPlaceholder.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddPageItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskItemLabel);
		return taskItemLabel.getText();
	}

	public String getTaskAddpageItemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		return taskAddpageItemDropdown.getAttribute("placeholder");
	}

	public boolean isItemDropdownBoxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskAddpageItemDropdown);
			isPresent = taskAddpageItemDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddPageSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveButtonCaption);
		return saveButtonCaption.getText();
	}

	public String getTaskAddPageCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonCaption);
		return cancelButtonCaption.getText();
	}

	public boolean isTaskAddPageCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddPageCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskAddPageCrossIcon);
			isPresent = taskAddPageCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void sendInstructionForFirstDescriptionTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextboxOne);
		instructionDescriptionTextboxOne.sendKeys(name);
		Actions action = new Actions(driver);
		action.sendKeys(instructionDescriptionTextboxOne, name).build().perform();
	}

	public void sendInstructionForSecondDescriptionTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextboxTwo);
		instructionDescriptionTextboxTwo.sendKeys(name);
		Actions action = new Actions(driver);
		action.sendKeys(instructionDescriptionTextboxTwo, name).build().perform();
	}

	public String getInstructionNameHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameHeader);
		return instructionNameHeader.getText();
	}

	public void clickOnTaskCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonCaption);
		cancelButtonCaption.click();
	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddPageCrossIcon);
		taskAddPageCrossIcon.click();
	}

	public String getTaskLangTwoTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, engLangTabHighlighted);
		String cssValue = engLangTabHighlighted.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getInstructionSearchErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchErrorLabel);
		return instructionSearchErrorLabel.getText();
	}

	public void clickOnInstructionListRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListRecord);
		subflowListRecord.click();
	}

	public String getInstructionAddEditPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddPageTitle);
		return instructionAddPageTitle.getText();
	}

	public String getInstructionNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameLabel);
		return instructionNameLabel.getText();
	}

	public String getInstructionDescriptionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionLabel);
		return instructionDescriptionLabel.getText();
	}

	public String getInstructionNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNamePlaceholder);
		return instructionNamePlaceholder.getAttribute("placeholder");
	}

	public String getInstructionLangLabelForFirstLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangOneLabel);
		return instructionLangOneLabel.getText();
	}

	public String getInstructionLangLabelForSecondLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangTwoLabel);
		return instructionLangTwoLabel.getText();
	}

	public String getInstructionLangLabelForThirdLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangThreeLabel);
		return instructionLangThreeLabel.getText();
	}

	public boolean isInstructionNameTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionNameTextbox);
			isPresent = instructionNameTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnTaskTypeDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageOperationDropdown);
		taskAddpageOperationDropdown.click();
		
	}

	public void selectAnyTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeValue);
		taskTypeValue.click();
	}

	public boolean isSelectValueInTypeDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeValue);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskTypeValue);
			isPresent = taskTypeValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionDescriptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionDescriptionTextbox);
			isPresent = instructionDescriptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void selectQuestionnaireValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireValue);
		questionnaireValue.click();
	}

	public void selectMeasurementValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, measurementValue);
		measurementValue.click();
	}

	public void selectInstructionsValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionValue);
		instructionValue.click();
	}

	public String getInstructionNamePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		return instructionNameTextbox.getAttribute("value");
	}

	public String getInstructionDescriptionPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionEditDescriptionTextboxText);
		return instructionEditDescriptionTextboxText.getText();
	}

	public String getInstructionDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteButton);
		return instructionDeleteButton.getText();
	}

	public void clickOnInstructionDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteButton);
		instructionDeleteButton.click();
	}

	public void clickOnInstructionDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteCancelButton);
		instructionDeleteCancelButton.click();
	}

	public void clickOnInstructionDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteOkButton);
		instructionDeleteOkButton.click();
	}

	public String getInstructionDeleteCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteCancelButton);
		return instructionDeleteCancelButton.getText();
	}

	public String getInstructionDeleteOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteOkButton);
		return instructionDeleteOkButton.getText();
	}

	public String getInstructionNameErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameErrorMsg);
		return instructionNameErrorMsg.getText();
	}

	public String getInstructionDescriptionErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionErrorMsg);
		return instructionDescriptionErrorMsg.getText();
	}

	public String getInstructionLanguageErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLanguageErrorMsg);
		return instructionLanguageErrorMsg.getText();
	}

	public void clearTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageOperationDropdown);
		taskAddpageOperationDropdown.clear();
	}

	public void clickOnItemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		taskAddpageItemDropdown.click();
	}

	public List<String> getTaskItemList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : taskItemList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnTaskItemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectedItemValue);
		selectedItemValue.click();
	}

	public String getTaskItemValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		return taskAddpageItemDropdown.getAttribute("value");
	}

	public String getNameIsRequiredErrorMsgLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getNameIsRequiredMsg);
		return getNameIsRequiredMsg.getText();
	}

	public String getTaskTypeIsRequiredErrorMsgLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskTypeIsRequiredMsg);
		return getTaskTypeIsRequiredMsg.getText();
	}

	public String getTaskItemIsRequiredErrorMsgLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getTaskItemIsRequiredMsg);
		return getTaskItemIsRequiredMsg.getText();
	}

	public String getProgramListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programListTitle);
		return programListTitle.getText();
	}

	public boolean isProgramSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programSearchTextbox);
			isPresent = programSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProgramSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowPlaceholder);
		return subflowPlaceholder.getAttribute("placeholder");
	}

	public void sendProgramSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSearchTextbox);
		programSearchTextbox.sendKeys(searchword);
	}

	public String getProgramSubscribeButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubscribeButton);
		return programSubscribeButton.getText();
	}

	public void clickOnProgramSubscribeButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubscribeButton);
		programSubscribeButton.click();
	}

	public void clickOnSubscribeButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeButton);
		subscribeButton.click();
	}

	public void clickOnSubscribeNameDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubscribeNameDropdown);
		programSubscribeNameDropdown.click();
	}

	public void clickOnProgramItemForSubscription(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//ui[@id='ProgramSubscribeViewActionKeyListItems']/li)[" + num + "]"));
		name.click();
	}

	public void clickOnSubscribeConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeConfirmationOkButton);
		subscribeConfirmationOkButton.click();
	}

	public String getProgramListNameHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNameHeader);
		return programNameHeader.getText();
	}

	public String getProgramTypeListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTypeHeader);
		return programTypeHeader.getText();
	}

	public String getProgramListTaskHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskHeader);
		return programTaskHeader.getText();
	}

	public String getProgramListSubflowHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubflowHeader);
		return programSubflowHeader.getText();
	}

	public String getProgramListCaregiverHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverHeader);
		return programCaregiverHeader.getText();
	}

	public String getProgramListReadingHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programReadingHeader);
		return programReadingHeader.getText();
	}

	public String getProgramListEducationHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationHeader);
		return programEducationHeader.getText();
	}

	public String getProgramListMedicationHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationHeader);
		return programMedicationHeader.getText();
	}

	public boolean isProgramListRecordsDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programListRecords);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programListRecords);
			isPresent = programListRecords.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProgramNoRecordErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNoRecordErrorMessage);
		return programNoRecordErrorMessage.getText();
	}

	public void clearProgramSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSearchTextbox);
		programSearchTextbox.clear();
	}

	public String getSubscribeOtherProgramTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeOtherProgramTitle);
		return subscribeOtherProgramTitle.getText();
	}

	public String getProgramAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddPageTitle);
		return programAddPageTitle.getText();
	}

	public void clickOnProgramListRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programListRecords);
		programListRecords.click();
	}

	public void clickOnProgramEditRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEditRecord);
		programEditRecord.click();
	}

	public String getPrefilledProgramName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNamePrefilledData);
		return programNamePrefilledData.getAttribute("value");
	}

	public String getAllLangRequiredErrorMsgLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getAllLangRequiredErrorMsg);
		return getAllLangRequiredErrorMsg.getText();
	}

	public void clickEducationValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationValue);
		educationValue.click();
	}

	public void clickTaskEducationTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskEducationTypeValue);
		taskEducationTypeValue.click();
	}

	public void clickOnAnyTaskRecords() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnAnyTask);
		Actions action = new Actions(driver);
		action.click(clickOnAnyTask).build().perform();
	}

	public void clickOnTaskDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebutton);
		deletebutton.click();
	}

	public String getTaskDeleteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteLabel);
		return subflowDeleteLabel.getText();
	}

	public String getTaskDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteConfirmationMsg);
		return taskDeleteConfirmationMsg.getText();
	}

	public String getTaskDeleteConfirmationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TaskDeleteCancelButton);
		return TaskDeleteCancelButton.getText();
	}

	public void clickOnCancelButtonInTaskDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TaskDeleteCancelButton);
		TaskDeleteCancelButton.click();
	}

	public String getTaskDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteOkButton);
		return taskDeleteOkButton.getText();
	}

	public void clickOnOkButtonInTaskDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteOkButton);
		taskDeleteOkButton.click();
	}

	public String getAlternateFlowsHeadingInTaskEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsHeading);
		return alternateFlowsHeading.getText();
	}

	public void getTaskNameTextboxPrefilledData(String namePrefilledData) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		taskAddpageNameTextbox.sendKeys(namePrefilledData);
	}

	public String getTaskDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButton);
		return taskDeleteButton.getText();
	}

	public void clickOnAlternateAddButton() {

		waitForElement(driver, alternateAddButton);
		alternateAddButton.click();
	}

	public String getSubscribeNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeNameLabel);
		return subscribeNameLabel.getText();
	}

	public String getSubscribeDescriptionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeDescriptionLabel);
		return subscribeDescriptionLabel.getText();
	}

	public boolean isSubscribeNameDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeNameDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subscribeNameDropdown);
			isPresent = subscribeNameDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubscribeButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeButton);
		return subscribeButton.getText();
	}

	public String getSubscribeCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeCancel);
		return subscribeCancel.getText();
	}

	public boolean isSubscribeDescriptionAreaEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeDescriptionArea);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, subscribeDescriptionArea);
			String text = subscribeDescriptionArea.getText();
			isPresent = text.isEmpty();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAlternateAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAddButton);
		return alternateAddButton.getText();
	}

	public void clickOnAlternateNameDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		alternateNameDropdown.click();
	}

	public void clickOnAlternateNameValue(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'])[" + num + "]"));
		name.click();
	}

	public void sendAssignAfterDays(String assignAfterDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		alternateAssignAfterDay.sendKeys(assignAfterDays);
	}

	public void sendShowForDays(String showForDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		alternateShowForDays.sendKeys(showForDays);
	}

	public void clickOnAlternateSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateSaveButton);
		alternateSaveButton.click();
	}

	public boolean isAlternateFlowsSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TasksViewIsPopupSearchTextKey);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, TasksViewIsPopupSearchTextKey);
			isPresent = TasksViewIsPopupSearchTextKey.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAlternateFlowsSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TasksViewIsPopupSearchTextKey);
		return TasksViewIsPopupSearchTextKey.getAttribute("placeholder");
	}

	public String getAlternateFlowsAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAddButton);
		return alternateAddButton.getText();
	}

	public void clickOnSubscribeCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeCancel);
		subscribeCancel.click();
	}

	public boolean isSubscribeOtherProgramButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubscribeButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programSubscribeButton);
			isPresent = programSubscribeButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void sendSubscribedProgramWord(String word) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeNameDropdown);
		Actions action = new Actions(driver);
		action.sendKeys(subscribeNameDropdown, word).build().perform();
		// subscribeNameDropdown.sendKeys(word);
	}

	public String getSubscribeNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribeNoRecordMsg);
		return subscribeNoRecordMsg.getText();
	}

	public boolean isSelectedSubscribeProgramDescriptionVisible() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, subscribeDescriptionArea);
			isPresent = subscribeDescriptionArea.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Description is not visible");
			return true;
		}
	}

	public String getProgramListSubscribedLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programListSubscribedLabel);
		return programListSubscribedLabel.getText();
	}

	public void clickOnAllowSelfSubscriptionCheckbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, allowSelfSubscriptionCheckbox);
		javascriptClick(allowSelfSubscriptionCheckbox);
		Actions action = new Actions(driver);
		//// action.click(allowSelfSubscriptionCheckbox).build().perform();
		// allowSelfSubscriptionCheckbox.click();
	}

	public boolean isProgramCaregiverAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programCaregiverAddButton);
			isPresent = programCaregiverAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgramCaregiverAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddButton);
		programCaregiverAddButton.click();
	}

	public boolean isProgramReadingAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programReadingAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programReadingAddButton);
			isPresent = programReadingAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isProgramEducationAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationsAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programEducationsAddButton);
			isPresent = programEducationsAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isProgramMedicationAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programMedicationAddButton);
			isPresent = programMedicationAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProgramCaregiverAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddPageTitle);
		return programCaregiverAddPageTitle.getText();
	}

	public void clickOnProgramAlternateFlowTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAlternateFlowTab);
		programAlternateFlowTab.click();
	}

	public void clickOnProgramCaregiverTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverTab);
		programCaregiverTab.click();
	}

	public void clickOnProgramReadingTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programReadingsTab);
		programReadingsTab.click();
	}

	public void clickOnProgramEducationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationsTab);
		programEducationsTab.click();
	}

	public void clickOnProgramMeasurementTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationsTab);
		programMedicationsTab.click();
	}

	public String getAlternateNameHeaderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameHeader);
		return alternateNameHeader.getText();
	}

	public String getAlternateItemHeaderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateItemHeader);
		return alternateItemHeader.getText();
	}

	public String getAlternateTaskTypeHeaderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeHeader);
		return alternateTaskTypeHeader.getText();
	}

	public String getAlternateSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateSaveButton);
		return alternateSaveButton.getText();
	}

	public String getAlternateCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateCancelButton);
		return alternateCancelButton.getText();
	}

	public boolean isProgramAllowSeldSubscriptionCheckboxSelected() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAllowSelfSubscription);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programAllowSelfSubscription);
			isPresent = programAllowSelfSubscription.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramTaskRow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, susbcribedProgramTaskRow);
		susbcribedProgramTaskRow.click();
	}

	public boolean isProgramTaskAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programTaskAddEditPageTitle);
			isPresent = programTaskAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramAlternateFlowsRow() {
		TestConfig.PrintMethodName();
		try {
			BasePageObject.waitForElement(driver, susbcribedProgramAlternateFlowsRow);
			susbcribedProgramAlternateFlowsRow.click();
		} catch (Exception e) {
			log("Alternate Flows are not added");
		}
	}

	public boolean isProgramSubFlowsAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubflowAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programSubflowAddEditPageTitle);
			isPresent = programSubflowAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramCaregiverRow() {
		TestConfig.PrintMethodName();
		try {
			BasePageObject.waitForElement(driver, susbcribedProgramCaregiverRow);
			susbcribedProgramCaregiverRow.click();
		} catch (Exception e) {
			log("Caregivers are not addded");
		}
	}

	public boolean isProgramCaregiverAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programCaregiverAddEditPageTitle);
			isPresent = programCaregiverAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramReadingRow() {
		TestConfig.PrintMethodName();
		try {
			BasePageObject.waitForElement(driver, susbcribedProgramReadingRow);
			susbcribedProgramReadingRow.click();
		} catch (Exception e) {
			log("Readings are not addded");
		}
	}

	public boolean isProgramReadingAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programReadingAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programReadingAddEditPageTitle);
			isPresent = programReadingAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramEducationsRow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, susbcribedProgramEducationRow);
		try {
			BasePageObject.waitForElement(driver, susbcribedProgramEducationRow);
			susbcribedProgramEducationRow.click();
		} catch (Exception e) {
			log("Educations are not added");
		}
	}

	public boolean isProgramEducationAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programEducationAddEditPageTitle);
			isPresent = programEducationAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSubscribedProgramMedicationRow() {
		TestConfig.PrintMethodName();

		waitForElement(driver, susbcribedProgramMedicationRow);
		try {
			BasePageObject.waitForElement(driver, susbcribedProgramMedicationRow);
			susbcribedProgramEducationRow.click();
		} catch (Exception e) {
			log("Medications are not added");
		}
	}

	public boolean isProgramMeasurementAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMeasurementAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programMeasurementAddEditPageTitle);
			isPresent = programMeasurementAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void sendProgramCaregiverAssignAfterDaysNumber(String num) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		programCaregiverAssignAfterDaysTextbox.sendKeys(num);
	}

	public void sendProgramCaregiverShowForDaysNumber(String num) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		programCaregiverShowForDaysTextbox.sendKeys(num);
	}

	public void clickOnProgramCaregiverSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSaveButton);
		programCaregiverSaveButton.click();
	}

	public void clickOnProgramCaregiverForSubscription(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//ui[@id='ProgramsViewIsPopupSelectProviderKeyListItems']/li)[" + num + "]"));
		name.click();

	}

	public void clickOnProgramProviderDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		programProviderDropdown.click();
	}

	public void clickOnProgramList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programlist);
		programlist.click();
	}

	public boolean isprogramTaskTabDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programTaskTab);
			isPresent = programTaskTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getprogramTaskTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskTab);
		return programTaskTab.getText();
	}

	public void sendProviderNameInProgramCaregiverSearchTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSearchTexbox);
		programCaregiverSearchTexbox.sendKeys(name);
	}

	public void clickOnDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageOperationDropdown);
		taskAddpageOperationDropdown.click();
		taskEducationTypeValue.click();
		taskAddpageItemDropdown.click();
		educationValue.click();
	}

	public String getProgramCaregiverListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverListTitle);
		return programCaregiverListTitle.getText();
	}

	public void clickOnProgramCaregiverTabForSubscribe() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverTabForSubscribe);
		programCaregiverTabForSubscribe.click();
	}

	public String getProgramSelectedCaregivernameForSubscription() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		return programProviderDropdown.getAttribute("value");
	}

	public void sendAlternateSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, TasksViewIsPopupSearchTextKey);
		TasksViewIsPopupSearchTextKey.sendKeys(searchword);
	}

	public String getSelectedAlternateName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("value");
	}

	public void clearAlternateSearchText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TasksViewIsPopupSearchTextKey);
		TasksViewIsPopupSearchTextKey.clear();
	}

	public boolean isAlternateFlowListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateFlowList);
			isPresent = alternateFlowList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNoRecordsFoundInAlternateFlowList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordsFoundInAlternateFlowList);
		return noRecordsFoundInAlternateFlowList.getText();
	}

	public String getAlternateAddPageHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAddPageHeading);
		return alternateAddPageHeading.getText();
	}

	public void clickOnAlternateRecords() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnAlternateRecords);
		Actions action = new Actions(driver);
		action.click(clickOnAlternateRecords).build().perform();
	}

	public void getAlternateEditPagePrefilledData(String namePrefilledData) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		alternateNameDropdown.sendKeys(namePrefilledData);
	}

	public void getAlternateEditPageAssignAfterDaysPrefilledData(String assignAfterDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		alternateAssignAfterDay.sendKeys(assignAfterDays);
	}

	public void getAlternateEditPageShowAfterDaysPrefilledData(String showForDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		alternateShowForDays.sendKeys(showForDays);
	}

	public String getProgramSubscribeNameDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSubscribeNameDropdown);
		return programSubscribeNameDropdown.getAttribute("value");
	}

	public void clickOnSusbcribedProgramFromProgramList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subscribedProgramClick);
		javascriptClick(subscribedProgramClick);
	}

	public void clickOnSusbcribedProgramAddedCaregiver() {
		TestConfig.PrintMethodName();
		waitForElement(driver, susbcribedProgramCaregiverRow);
		susbcribedProgramCaregiverRow.click();
	}

	public boolean isAlternateFlowPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowPage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateFlowPage);
			isPresent = alternateFlowPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAlternateFlowPageCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateFlowCrossIcon);
			isPresent = alternateFlowCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAlternateAddPageNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, nameTextLabelInAlternateAddPage);
		return nameTextLabelInAlternateAddPage.getText();
	}

	public String getAlternateAddPageNameDropdownPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("placeholder");
	}

	public boolean isNameDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateNameDropdown);
			isPresent = alternateNameDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAlternateAddPageTaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeLabel);
		return alternateTaskTypeLabel.getText();
	}

	public String getAlternateAddPageTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeData);
		return alternateTaskTypeData.getText();
	}

	public String getAlternateAddPageFlowItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowItemLabel);
		return alternateFlowItemLabel.getText();
	}

	public String getAlternateAddPageItemDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowItemData);
		return alternateFlowItemData.getText();
	}

	public String getAlternateAddPageFlowOperationTypeDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowOperationTypeLabel);
		return alternateFlowOperationTypeLabel.getText();
	}

	public String getAlternateFlowOperationTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowOperationTypeData);
		return alternateFlowOperationTypeData.getText();
	}

	public String getAssignAfterDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignAfterDaysLabel);
		return assignAfterDaysLabel.getText();
	}

	public boolean isAlternateAssignAfterDayTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateAssignAfterDay);
			isPresent = alternateAssignAfterDay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAssignAfterDaysTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		return alternateAssignAfterDay.getAttribute("placeholder");
	}

	public String getShowForDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysLabel);
		return showForDaysLabel.getText();
	}

	public boolean isAlternateShowForDaysTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateShowForDays);
			isPresent = alternateShowForDays.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getShowForDaysTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		return alternateShowForDays.getAttribute("placeholder");
	}

	public String getSubflowCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonSubflow);
		return cancelButtonSubflow.getText();
	}

	public String getAlternateFlowSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateSaveButton);
		return alternateSaveButton.getText();
	}

	public String getAlternateFlowEditPageDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		return deleteButton.getText();
	}

	public String getTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskEducationTypeValue);
		return taskEducationTypeValue.getText();
	}

	public void clickOnCareProgramTabs() {
		TestConfig.PrintMethodName();
		waitForElement(driver, careProgramTabs);
		javascriptClick(careProgramTabs);
	}

	public String getCaregiverListSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowPlaceholder);
		return subflowPlaceholder.getAttribute("placeholder");
	}

	public boolean isCaregiverSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSearchTexbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programCaregiverSearchTexbox);
			isPresent = programCaregiverSearchTexbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddButton);
		return programCaregiverAddButton.getText();
	}

	public String getCaregiverProviderListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProviderListHeader);
		return caregiverProviderListHeader.getText();
	}

	public String getCaregiverProfessionListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProfessionListHeader);
		return caregiverProfessionListHeader.getText();
	}

	public String getCaregiverAssignAfterDaysListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverAssignAfterDaysListHeader);
		return caregiverAssignAfterDaysListHeader.getText();
	}

	public String getCaregiverShowForDaysListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverShowForDaysListHeader);
		return caregiverShowForDaysListHeader.getText();
	}

	public boolean isCaregiverListRecordDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverListRecord);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, caregiverListRecord);
			isPresent = caregiverListRecord.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDefaultProgramTaskIdentifierColorSelected() {
		TestConfig.PrintMethodName();
		waitForElement(driver, defaultProgramTaskIdentifierColorTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, defaultProgramTaskIdentifierColorTextbox);
			isPresent = defaultProgramTaskIdentifierColorTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void sendProgramCaregiverSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSearchTexbox);
		programCaregiverSearchTexbox.sendKeys(searchword);
	}

	public void clearProgramCaregiverSearchWord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSearchTexbox);
		programCaregiverSearchTexbox.clear();
	}

	public String getCaregiverSearchNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSearchNoRecordMsg);
		return caregiverSearchNoRecordMsg.getText();
	}

	public String getSuccessMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, successMsg);
		return successMsg.getText();
	}

	public String getTaskTypeMeasurementValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, measurementValueSearch);
		return measurementValueSearch.getText();
	}

	public String getTaskTypeHeightValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, heightValueSearch);
		return heightValueSearch.getText();
	}

	public boolean isTaskListDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskListTable);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskListTable);
			isPresent = taskListTable.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnTaskTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTab);
		taskTab.click();
	}

	public void clickOnListRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listRecord);
		listRecord.click();

	}

	public boolean isTaskAddHeaderDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddHeader);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskAddHeader);
			isPresent = taskAddHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getTaskAddHeaderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddHeader);
		return taskAddHeader.getText();
	}

	public void clickCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIcon);
		crossIcon.click();
	}

	public void clickCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateCancelButton);
		alternateCancelButton.click();
	}

	public String getCaregiverProviderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProviderLabel);
		return caregiverProviderLabel.getText();
	}

	public String getCaregiverProviderPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProviderPlaceholder);
		return caregiverProviderPlaceholder.getAttribute("placeholder");
	}

	public boolean isCaregiverProviderDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProviderDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, caregiverProviderDropdown);
			isPresent = caregiverProviderDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverAssognAfterDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverAssignAfterDaysLabel);
		return caregiverAssignAfterDaysLabel.getText();
	}

	public String getCaregiverShowForDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverShowForDaysLabel);
		return caregiverShowForDaysLabel.getText();
	}

	public boolean isCaregiverAssignAfterDaysTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverAssignAfterDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, caregiverAssignAfterDaysTextbox);
			isPresent = caregiverAssignAfterDaysTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isCaregiverShowForDaysTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverShowForDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, caregiverShowForDaysTextbox);
			isPresent = caregiverShowForDaysTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProgramCaregiverSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSaveButton);
		return programCaregiverSaveButton.getText();
	}

	public String getProgramCaregiverCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addCaregiverCancelButton);
		return addCaregiverCancelButton.getText();
	}

	public void clickOnAddCaregiverPageCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowCrossIcon);
		alternateFlowCrossIcon.click();
	}

	public void clickOnAddCaregiverPageCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addCaregiverCancelButton);
		addCaregiverCancelButton.click();
	}

	public boolean isCaregiverAddPageProviderListDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addProviderList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addProviderList);
			isPresent = addProviderList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public List<String> getNameDropdownValue() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : nameListValue) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public boolean isCaregiverAddPageProviderNameSelected() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programProviderDropdown);
			isPresent = programProviderDropdown.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnAnyListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, anyListItem);
		anyListItem.click();
	}

	public void clickOnProgramtaskList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programtasklist);
		programtasklist.click();
	}

	public boolean isCaregiverAddPageShowForDaysTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programProviderDropdown);
			String text = programProviderDropdown.getText();
			isPresent = text.isEmpty();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isCaregiverAddPageAssignAfterDaysTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
			String text = programCaregiverAssignAfterDaysTextbox.getText();
			isPresent = text.isEmpty();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEditTaskHeaderHeaderCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editTaskHeader);
		return editTaskHeader.getText();
	}

	public boolean isEditTaskHeaderDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editTaskHeader);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, editTaskHeader);
			isPresent = editTaskHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProviderFieldRequiredMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, providerFieldRequiredMsg);
		return providerFieldRequiredMsg.getText();
	}

	public String getCaregiverShowForDaysRangeErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysFeildRequiredRangeMsg);
		return showForDaysFeildRequiredRangeMsg.getText();
	}

	public void clearCaregiverAssignAfterDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		programCaregiverAssignAfterDaysTextbox.clear();
	}

	public void clearCaregiverShowForDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		programCaregiverShowForDaysTextbox.clear();
	}

	public String getCaregiverAssignAfterDaysRequiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignAfterDaysFeildRequiredRangeMsg);
		return assignAfterDaysFeildRequiredRangeMsg.getText();
	}

	public String getCaregiverShowForDaysRequiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysFeildRequiredMsg);
		return showForDaysFeildRequiredMsg.getText();
	}

	public String isCaregiverProviderFieldDropdownErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverProviderDropdown);
		String cssValue = caregiverProviderDropdown.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isCaregiverAssignAfterDaysTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		String cssValue = programCaregiverAssignAfterDaysTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isCaregiverShowForDaysTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		String cssValue = programCaregiverShowForDaysTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public void clickOnProgramCaregiverListRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverListRecord);
		programCaregiverListRecord.click();
	}

	public String getAddTaskNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addTaskNameLabel);
		return addTaskNameLabel.getText();
	}

	public String getTaskSelectedAlternateFlowNameDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("value");
	}

	public String getAlternateEditPageAssignAfterDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		return alternateAssignAfterDay.getAttribute("value");
	}

	public String getAlternateEditPageShowAfterDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		return alternateShowForDays.getAttribute("value");
	}

	public String getAlternateEditPagePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("value");
	}

	public String getSelectedAlternateAssignAfterDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAssignAfterDay);
		return alternateAssignAfterDay.getAttribute("value");
	}

	public String getSelectedAlternateShowForDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		return alternateShowForDays.getAttribute("value");
	}

	public void clickNameFieldDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectAnyValueInNameDropdown);
		selectAnyValueInNameDropdown.click();
	}

	public String getAlternateAddPageFlowOperationTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowType);
		return alternateFlowType.getText();
	}

	public String getNameIsRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, nameIsRequiredErroMsg);
		return nameIsRequiredErroMsg.getText();
	}

	public String getAssignAfterDaysIsRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignAfterDaysIsRequiredErrorMsg);
		return assignAfterDaysIsRequiredErrorMsg.getText();
	}

	public String getShowForDaysIsRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysIsRequiredErrorMsg);
		return showForDaysIsRequiredErrorMsg.getText();
	}

	public void sendProgramProviderName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		programProviderDropdown.sendKeys(name);
	}

	public void clickOnDuplicateProviderName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, duplicateProviderName);
		duplicateProviderName.click();
	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		deleteButton.click();
	}

	public boolean isDeletePopUpPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, deletePage);
			isPresent = deletePage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDeleteHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDeleteHeading);
		return getDeleteHeading.getText();
	}

	public boolean isDeleteCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteCrossIconPage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, deleteCrossIconPage);
			isPresent = deleteCrossIconPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDeletePermissionMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDeletePermissionMsg);
		return getDeletePermissionMsg.getText();
	}

	public String getdeleteCancelCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteCancelCaption);
		return deleteCancelCaption.getText();
	}

	public String getdeleteOkCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePageOkCaption);
		return deletePageOkCaption.getText();
	}

	public void clickOnCacelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteCancelCaption);
		deleteCancelCaption.click();
	}

	public void clickOnOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePageOkCaption);
		deletePageOkCaption.click();
	}

	public String getTasksNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskNamePlaceholder);
		return taskNamePlaceholder.getAttribute("placeholder");
	}

	public void sendNameTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, nameTextbox);
		nameTextbox.sendKeys(name);
	}

	public void clickOnProgramListEducationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationTab);
		programEducationTab.click();
	}

	public String getProgramEducationListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationListTitle);
		return educationListTitle.getText();
	}

	public String getCaregiverDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteButton);
		return caregiverDeleteButton.getText();
	}

	public void clickOnCaregiverDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteButton);
		caregiverDeleteButton.click();
	}

	public String getCaregiverDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteCancelButton);
		return caregiverDeleteCancelButton.getText();
	}

	public void clickOnCaregiverDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteCancelButton);
		caregiverDeleteCancelButton.click();
	}

	public String getCaregiverDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteOkButton);
		return caregiverDeleteOkButton.getText();
	}

	public void clickOnCaregiverDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteOkButton);
		caregiverDeleteOkButton.click();
	}

	public String getCaregiverAssignAfterDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		return programCaregiverAssignAfterDaysTextbox.getText();
	}

	public String getCaregiverShowForDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		return programCaregiverShowForDaysTextbox.getText();
	}

	public void sendOnFisrtLangProgramName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, sendOnFisrtLangProgramName);
		sendOnFisrtLangProgramName.sendKeys(name);
	}

	public void sendOnSecondLangProgramName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, sendOnSecondLangProgramName);
		sendOnSecondLangProgramName.sendKeys(name);
	}

	public void clickOnProgramEducationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationAddButton);
		clickOnEducationAddButton.click();
	}

	public void clickOnProgramEduactionCategoryDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		clickOnCategory.click();
	}

	public void clickOnCategoryDropdown(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'])[" + num + "]"));
		name.click();
	}

	public void clickOnEducationDropdown(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'])[" + num + "]"));
		name.click();
	}

	public void clickOnEducationCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationCategory);
		clickOnEducationCategory.click();
	}

	public void clickOnSubscribedProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programListSubscribedLabel);
		programListSubscribedLabel.click();
	}

	public void sendEducationAssignAfterDays(String assignAfterDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		educationAssignAfterDay.sendKeys(assignAfterDays);
	}

	public void sendEducationShowForDays(String showForDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		educationShowForDay.sendKeys(showForDays);
	}

	public void clickEducationSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSaveButton);
		educationSaveButton.click();
	}

	public boolean isEducationSearchboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationSearchbox);
			isPresent = educationSearchbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducatiobListSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		return educationSearchbox.getAttribute("placeholder");
	}

	public String getOnProgramEducationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationAddButton);
		return clickOnEducationAddButton.getText();
	}

	public String getListHeaderAsEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationListHeader);
		return educationListHeader.getText();
	}

	public String getEducationForProviderListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationForProviderListHeader);
		return educationForProviderListHeader.getText();
	}

	public String getEducationAssignAfterDaysListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDaysListHeader);
		return educationAssignAfterDaysListHeader.getText();
	}

	public String getEducationShowForDaysListHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDaysListHeader);
		return educationShowForDaysListHeader.getText();
	}

	public boolean isEducationListRecordDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationList);
			isPresent = educationList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgramNameInList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNameInList);
		javascriptClick(programNameInList);
	}

	public void clickOnProgramMedicationsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationsTab);
		javascriptClick(programMedicationsTab);
	}

	public void clickOnProgramMedicationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationAddButton);
		javascriptClick(programMedicationAddButton);
	}

	public String getMedicationAddEditHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditHeader);
		return medicationAddEditHeader.getText();
	}

	public String getMedicationAddEditMedicineNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditMedicineNameLabel);
		return medicationAddEditMedicineNameLabel.getText();
	}

	public boolean isMedicationAddEditMedicineNameTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditMedicineNameTextbox);
			isPresent = medicationAddEditMedicineNameTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditDosesLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditDosesLabel);
		return medicationAddEditDosesLabel.getText();
	}

	public boolean isMedicationAddEditDosesTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditDosesTextbox);
			isPresent = medicationAddEditDosesTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditUnitLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditUnitLabel);
		return medicationAddEditUnitLabel.getText();
	}

	public boolean isMedicationAddEditUnitDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditUnitDropdown);
			isPresent = medicationAddEditUnitDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditFrequencyLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditFrequencyLabel);
		return medicationAddEditFrequencyLabel.getText();
	}

	public boolean isMedicationAddEditFrequencyTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditFrequencyTextbox);
			isPresent = medicationAddEditFrequencyTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditHowOftenLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditHowOftenLabel);
		return medicationAddEditHowOftenLabel.getText();
	}

	public boolean isMedicationAddEditHowOftenDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditHowOftenDropdown);
			isPresent = medicationAddEditHowOftenDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public List<String> getHowOftenDropdownListList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : howOftenDropdownList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public String getMedicationAddEditAssignForDayLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAssignForDayLabel);
		return medicationAddEditAssignForDayLabel.getText();
	}

	public boolean isMedicationAddEditAssignForDayTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditAssignForDayTextbox);
			isPresent = medicationAddEditAssignForDayTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditShowForDayLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditShowForDayLabel);
		return medicationAddEditShowForDayLabel.getText();
	}

	public boolean isMedicationAddEditShowForDayTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditShowForDayTextbox);
			isPresent = medicationAddEditShowForDayTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditNoteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditNoteLabel);
		return medicationAddEditNoteLabel.getText();
	}

	public boolean isMedicationAddEditNoteTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditNoteTextbox);
			isPresent = medicationAddEditNoteTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMedicationAddEditCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditCancelButton);
			isPresent = medicationAddEditCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnMedicationRowList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnMedicationRowList);
		javascriptClick(clickOnMedicationRowList);
	}

	public boolean isMedicationAddEditDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addCaregiverCancelButton);
			isPresent = addCaregiverCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnNewCreatedProgram(String program) throws InterruptedException {
		TestConfig.PrintMethodName();
		WebElement newProgram = driver.findElement(By.xpath("//label[text()='" + program + "']"));
		waitForElement(driver, newProgram);
		javascriptClick(newProgram);
	}

	public void clickOnAlternateFlowsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsTab);
		javascriptClick(alternateFlowsTab);
	}

	public void SelectTaskCalories() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskCalories);
		javascriptClick(taskCalories);
	}

	public void enterTaskAssignAfterDays(String days) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAssignAfterDays);
		taskAssignAfterDays.sendKeys(days);
	}

	public void enterTaskShowForDays(String days) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskShowForDays);
		taskShowForDays.sendKeys(days);
	}

	public void clickOnTaskSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskSaveButton);
		javascriptClick(taskSaveButton);
	}

	public void selectTaskTypeMeasurement() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeMeasurement);
		javascriptClick(taskTypeMeasurement);
	}

	public void selectItemCalories() {
		TestConfig.PrintMethodName();
		waitForElement(driver, itemCalories);
		javascriptClick(itemCalories);
//		Actions action = new Actions(driver);
//		action.click(itemCalories).build().perform();
	}

	public void selectSubflowsName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsName);
		javascriptClick(subflowsName);
	}

	public void enterSubflowsAssignAfterDays(String days) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsAssignAfterDays);
		subflowsAssignAfterDays.sendKeys(days);
	}

	public void enterSubflowsShowForDays(String days) {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsShowForDays);
		subflowsShowForDays.sendKeys(days);
	}

	public void ClickOnSubflowsSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSaveButton);
		javascriptClick(subflowsSaveButton);
	}

	public void selectBloodGlucoseTask() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseTask);
		javascriptClick(bloodGlucoseTask);
	}

	public void selectTaskTypeInstructions() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeInstructions);
		javascriptClick(taskTypeInstructions);
	}

	public void selectItemBloodGlucose() {
		TestConfig.PrintMethodName();
		waitForElement(driver, itemBloodGlucose);
		javascriptClick(itemBloodGlucose);
	}

	public void clcikOnSearchIconInMedicationName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchIconInMedicationName);
		javascriptClick(searchIconInMedicationName);
	}

	public List<String> getAlternatetaskTypeItemList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : taskTypeItemList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void clickOnDropdownItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, itemDropdown);
		Actions action = new Actions(driver);
		action.click(itemDropdown).build().perform();
	}

	public void selectTaskTypeInstruction() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeInstruction);
		javascriptClick(alternateTaskTypeInstruction);
	}

	public void selectTaskTypeEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeEducations);
		javascriptClick(subflowTaskTypeEducations);
	}

	public void selectTaskTypeQuestionnaire() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeQuestionnaire);
		javascriptClick(alternateTaskTypeQuestionnaire);
	}

	public void clickOnSubflowTaskTypeQuestionnaire() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateTaskTypeQuestionnaire);
		javascriptClick(alternateTaskTypeQuestionnaire);
	}

	public void clickOnSubflowTaskTypeEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeEducations);
		javascriptClick(subflowTaskTypeEducations);
	}

	public void clickOnSubflowTaskTypeInstructions() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowTaskTypeInstructions);
		javascriptClick(subflowTaskTypeInstructions);
	}

	public String getSubflowFromValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowFromValue);
		return subflowFromValue.getAttribute("value");
	}

	public void createAlternateMeasurementTaskType(String days, String day) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, measurementTaskType);
		javascriptClick(taskTypeMeasurement);
		javascriptClick(itemCalories);
		javascriptClick(subflowsName);
		subflowsAssignAfterDays.sendKeys(days);
		subflowsShowForDays.sendKeys(day);
		javascriptClick(subflowsSaveButton);
	}

	public boolean isMedicationDosesField(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddEditDosesTextbox);
			medicationAddEditDosesTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void selectUnitDropdownTabletselect() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitDropdownTabletselect);
		javascriptClick(unitDropdownTabletselect);
	}

	public void clickOnMedicationAddEditUnitDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditUnitDropdown);
		javascriptClick(unitDropdownTabletselect);
	}
//		public void sendSubflowSearchWord(String searchword) {
//			TestConfig.PrintMethodName();
//			waitForElement(driver, subflowSearchTextchange);
//			subflowSearchTextchange.sendKeys(searchword);
	//

	public String getMedicationUnitTabletLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditUnitDropdown);
		return medicationAddEditUnitDropdown.getText();
	}

	public void clickOnMedicationAddEditDosesTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditDosesTextbox);
		Actions action = new Actions(driver);
		action.click(medicationAddEditDosesTextbox).build().perform();
		// javascriptClick(medicationAddEditDosesTextbox);
	}

	public boolean isMedicationUnitTabletLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditUnitDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditUnitDropdown);
			isPresent = medicationAddEditUnitDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void enterNumberInMedicationDosesTextbox(String Number) {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditMedicineNameTextbox);
		medicationAddEditMedicineNameTextbox.sendKeys(Number);
	}

	public void clickOnMedicationAddEditFrequencyTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditFrequencyTextbox);
		javascriptClick(medicationAddEditFrequencyTextbox);
	}

	public boolean isMedicationFrequencyField(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddEditFrequencyTextbox);
			medicationAddEditFrequencyTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearTextInMedicationSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditMedicineNameTextbox);
	}

	public void clickOnMedicationNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditMedicineNameTextbox);
		javascriptClick(medicationAddEditMedicineNameTextbox);
	}

	public String getMedicationAddEditAlternateForLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAlternateForLabel);
		return medicationAddEditAlternateForLabel.getText();
	}

	public void clickOnMedicationAddEditAlternateFor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAlternateForDropdownSelect);
		javascriptClick(medicationAddEditAlternateForDropdownSelect);
	}

	public boolean isMedicationAddEditAlternateForTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowListdisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, medicationAddEditAlternateForTextbox);
			isPresent = medicationAddEditAlternateForTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationAddEditAlternateForDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAlternateForDropdownSelect);
		return medicationAddEditAlternateForDropdownSelect.getText();
	}

	public void sendMedicationAddEditAlternateForTextboxd(String Value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAlternateForTextbox);
		medicationAddEditAlternateForTextbox.sendKeys(Value);
	}

	public String getMedicationAddEditAlternateForErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAlternateForErrorMessage);
		return medicationAddEditAlternateForErrorMessage.getText();
	}

	public void clickOnMedicationAddEditAssignForDay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAssignForDayTextbox);
		javascriptClick(medicationAddEditAssignForDayTextbox);
	}

	public boolean isMedicationAddEditAssignForDayTextbox(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddEditAssignForDayTextbox);
			medicationAddEditAssignForDayTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnMedicationAddEditShowForDay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditShowForDayTextbox);
		javascriptClick(medicationAddEditShowForDayTextbox);
	}

	public void clearTextInMedicationShowForDayTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditShowForDayTextbox);
		medicationAddEditShowForDayTextbox.clear();
	}

	public String getMedicationAddEditShowForErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditShowErrorMessage);
		return medicationAddEditShowErrorMessage.getText();
	}

	public boolean isMedicationAddEditShowForDayTextbox(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddEditShowForDayTextbox);
			medicationAddEditShowForDayTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnMedicationAddEditCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditCancelButton);
		javascriptClick(medicationAddEditCancelButton);
	}

	public String getMedicationListLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationListLabel);
		return medicationListLabel.getText();
	}

	public void createProgram(String programName) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickSupportedCodeSystem);
		javascriptClick(clickSupportedCodeSystem);
		javascriptClick(selectCodeSystem);
		javascriptClick(clickOnProgramName);
		clickOnProgramName.sendKeys(programName);
		
		javascriptClick(programpageEngLang);
		sendOnFisrtLangProgramName.sendKeys(programName);
		javascriptClick(programpageHindiLang);
		sendOnSecondLangProgramName.sendKeys(programName);
		javascriptClick(programSaveButton);
	}

	public void sendEducationSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		educationSearchbox.sendKeys(searchword);
	}

	public String getEducationRecordsFound() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationRecords);
		return educationRecords.getText();
	}

	public String getEducationHeadingLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationHeading);
		return programEducationHeading.getText();
	}

	public boolean isProgramEducationCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programEducationCrossIcon);
			isPresent = programEducationCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationCategoryLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationCategoryLabel);
		return programEducationCategoryLabel.getText();
	}

	public boolean isProgramEducationCategoryTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, clickOnCategory);
			isPresent = clickOnCategory.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationCategoryTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		return clickOnCategory.getAttribute("placeholder");
	}

	public String getEducationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationLabel);
		return programEducationLabel.getText();
	}

	public boolean isProgramEducationTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationCategory);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, clickOnEducationCategory);
			isPresent = clickOnEducationCategory.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationCategory);
		return clickOnEducationCategory.getAttribute("placeholder");
	}

	public String getEducationAssignAfterDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationAssignAfterDaysLabel);
		return programEducationAssignAfterDaysLabel.getText();
	}

	public boolean isProgramEducationAssignAfterDaysTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationAssignAfterDay);
			isPresent = educationAssignAfterDay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationAssignAfterDayTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		return educationAssignAfterDay.getAttribute("placeholder");
	}

	public void addProgramName(String programName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programNamePrefilledData);
		programNamePrefilledData.sendKeys(programName);
	}

	public boolean isProgramDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programTest);
			isPresent = programTest.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgram() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTest);
		programTest.click();
	}

	public void clickOnCaregiverTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverTab);
		caregiverTab.click();
	}

	public void clickOnProgramsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programsTab);
		programsTab.click();
	}

	public void addCaregivers(String caregivrName, String assignDays, String showDays) throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			caregiver = driver.findElement(
					By.xpath("(//div[@id='ProgramAddEditDefaultCaregiverKey'])/div[3]/div/label[contains(.,'"
							+ caregivrName + "')]"));
			String caregiverName = caregiver.getText();
			log("Caregiverl already present");

			if (caregiverName.equals(caregiverName)) {
				WebElement assignForDays = driver.findElement(
						By.xpath("(//div[@id='ProgramAddEditDefaultCaregiverKey'])/div[3]/div/label[contains(.,'"
								+ caregivrName + "')]/following::label[2]"));
				String assignDay = assignForDays.getText();
				log("Assign For Days: " + assignDay);

				if (assignDay.equals(assignDays)) {
					log("Assign For Days already present");
				} else {
					log("Delete caregiver");
					caregiver.click();
					caregiverDeleteButton.click();
					subscribeConfirmationOkButton.click();
				}
				showForDays = driver.findElement(
						By.xpath("(//div[@id='ProgramAddEditDefaultCaregiverKey'])/div[3]/div/label[contains(.,'"
								+ caregivrName + "')]/following::label[3]"));
				String showDay = showForDays.getText();
				log("Show for Days: " + showDay);

				if (showDay.equals(showDay)) {
					log("Show for days already present");
				} else {
					log("Delete caregiver");
					caregiver.click();
					caregiverDeleteButton.click();
					subscribeConfirmationOkButton.click();
				}
			}
		} catch (Exception e) {
			log("Adding new Caregiver");
			programCaregiverAddButton.click();
			providerDropdown.click();
			
			providerDropdown.sendKeys(caregivrName);
		
			WebElement selectProvider = driver.findElement(By.xpath("//li[contains(.,'" + caregivrName + "')]"));
			selectProvider.click();
			log("Adding Assign for Days: " + assignDays);
			assignAfterDaysTextbox.click();
			assignAfterDaysTextbox.clear();
			assignAfterDaysTextbox.sendKeys(assignDays);
			log("Adding Show for Days: " + showDays);
			showForDaysTextbox.click();
			showForDaysTextbox.clear();
			showForDaysTextbox.sendKeys(showDays);
			programCaregiverSaveButton.click();
		}
	}

	public String getEducationShowForDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationShowForDaysLabel);
		return programEducationShowForDaysLabel.getText();
	}

	public boolean isProgramEducationShowForDayTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationShowForDay);
			isPresent = educationShowForDay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationShowForDayTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		return educationShowForDay.getAttribute("placeholder");
	}

	public boolean isForProviderCheckboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, forProviderCheckbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, forProviderCheckbox);
			isPresent = forProviderCheckbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getForProviderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, forProviderCheckbox);
		return forProviderCheckbox.getText();
	}

	public String getEducationSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSaveButton);
		return educationSaveButton.getText();
	}

	public String getEducationCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCancelButton);
		return educationCancelButton.getText();
	}

	public void clickOnEducationCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programEducationCrossIcon);
		programEducationCrossIcon.click();
	}

	public List<String> getCategoryDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : categoryDropdownList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public boolean isSelectedValueDisplayInCategoryDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, clickOnCategory);
			isPresent = clickOnCategory.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSelectedValueDisplayInEducationDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationCategory);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, clickOnEducationCategory);
			isPresent = clickOnEducationCategory.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnNewCreatedProgram() {
		TestConfig.PrintMethodName();
		WebElement newProgram = driver.findElement(By.xpath("//label[text()='" + AtomHC.program + "']"));
		waitForElement(driver, newProgram);
		javascriptClick(newProgram);
	}

	public void enterTextInMedicationSearchTextbox(String text) {
		log("Adding appointment Subject");
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditMedicineNameTextbox);
		medicationAddEditMedicineNameTextbox.sendKeys(text);
	}

	public String getProgramMedicationMedicineNameErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationMedicineNameErrorLabel);
		return programMedicationMedicineNameErrorLabel.getText();
	}

	public String getProgramMedicationDosesErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationDosesErrorLabel);
		return programMedicationDosesErrorLabel.getText();
	}

	public String getProgramMedicationFrequencyErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationFrequencyErrorLabel);
		return programMedicationFrequencyErrorLabel.getText();
	}

	public String getProgramMedicationHowOftenErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationHowOftenErrorLabel);
		return programMedicationHowOftenErrorLabel.getText();
	}

	public String getProgramMedicationAssignAfterDaysErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationAssignAfterDaysErrorLabel);
		return programMedicationAssignAfterDaysErrorLabel.getText();
	}

	public String getProgramMedicationShowForDaysErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationShowForDaysErrorLabel);
		return programMedicationShowForDaysErrorLabel.getText();
	}

	public void selectProgramMedicationDailyDropdownLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationDailyDropdownLabel);
		javascriptClick(programMedicationDailyDropdownLabel);
	}

	public void addMedicationName(String medicationName) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSaveButton);
		log("medication Name is : " + AtomHC.medicationName);
		WebElement MedicationList = driver.findElement(By.xpath("//label[text()='" + AtomHC.medicationName + "']"));
	
		javascriptClick(MedicationList);
	}

	public void clickOnMedicationAddEditDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditDeleteButtonDisplay);
		javascriptClick(medicationAddEditDeleteButtonDisplay);
	}

	public String getProgramMedicationDeleteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationDeleteLabel);
		return programMedicationDeleteLabel.getText();
	}

	public boolean isProgramEducationAssignAfterDaysTextbox(String Value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationAssignAfterDay);
			educationAssignAfterDay.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearTextAssignAfterDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		educationAssignAfterDay.clear();
	}

	public String getErrorMsgInAssignAfterDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgInAssignAfterDays);
		return errorMsgInAssignAfterDays.getText();
	}

	public void sendMoreThanFourDigit(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		educationAssignAfterDay.sendKeys(value);
	}

	public boolean isProgramEducationShowForDaysTextbox(String Value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationShowForDay);
			educationShowForDay.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearTextShowForDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		educationShowForDay.clear();
	}

	public void sendMoreThanFourDigitInShowForDays(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		educationShowForDay.sendKeys(value);
	}

	public String getErrorMsgInShowForDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgInShowForDays);
		return errorMsgInShowForDays.getText();
	}

	public String getErrorMsgCategoryIsRequired() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgCategoryIsRequired);
		return errorMsgCategoryIsRequired.getText();
	}

	public String getErrorMsgEducationIsRequired() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgEducationIsRequired);
		return errorMsgEducationIsRequired.getText();
	}

	public String getErrorMsgAssignAfterDaysIsRequired() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgAssignAfterDaysIsRequired);
		return errorMsgAssignAfterDaysIsRequired.getText();
	}

	public String getProgramMedicationTabletLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditUnitDropdown);
		return medicationAddEditUnitDropdown.getText();
	}

	public void clickOnMedicationAddEditHowOftenDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnMedicationAddEditHowOftenDropdown);
		Actions act = new Actions(driver);
		act.click(clickOnMedicationAddEditHowOftenDropdown).build().perform();
	}

	public void clickOnNewProgram(String programName) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, programSaveButton);
		log("Program Name is : " + AtomHC.program);
		WebElement ProgramName = driver.findElement(By.xpath("//label[text()='" + AtomHC.program + "']"));
		
	}

	public String getErrorMsgShowForDaysIsRequired() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgShowForDaysIsRequired);
		return errorMsgShowForDaysIsRequired.getText();
	}

	public String getProgramTaskHeadderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskLabel);
		return programTaskLabel.getText();
	}

	public boolean isProgramTaskSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowsSaveButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programTaskSearchTextbox);
			isPresent = programTaskSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnForProviderCheckbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, forProviderCheckbox);
		javascriptClick(forProviderCheckbox);
	}

	public boolean isForProviderCheckboxCheckDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, forProviderCheckbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, forProviderCheckbox);
			isPresent = forProviderCheckbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProgramTaskListNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskListNameLabel);
		return programTaskListNameLabel.getText();
	}

	public String getProgramTaskListTaskTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskListTaskTypeLabel);
		return programTaskListTaskTypeLabel.getText();
	}

	public String getProgramTaskListItemLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskListItemLabel);
		return programTaskListItemLabel.getText();
	}

	public String getProgramTaskListAssignAfterDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskListAssignAfterDaysLabel);
		return programTaskListAssignAfterDaysLabel.getText();
	}

	public String getProgramTaskListShowForDaysLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskListShowForDaysLabel);
		return programTaskListShowForDaysLabel.getText();
	}

	public void clickOnEduactionRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, openEducationRecord);
		openEducationRecord.click();
	}

	public String getCategoryPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		return clickOnCategory.getText();
	}

	public String getEducationPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationCategory);
		return clickOnEducationCategory.getText();
	}

	public String getAssignAfterDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		return educationAssignAfterDay.getText();
	}

	public String getShowForDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationShowForDay);
		return educationShowForDay.getText();
	}

	public String getEducationDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDelete);
		return educationDelete.getText();
	}

	public void clickOnEduactionDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDelete);
		educationDelete.click();
	}

	public String getEducationDeleteButtonPageHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeletePageHeading);
		return educationDeletePageHeading.getText();
	}

	public boolean isProgramEducationDeletePageCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationDeleteCrossIcon);
			isPresent = educationDeleteCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationDeleteMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteMsg);
		return educationDeleteMsg.getText();
	}

	public String getEducationDeleteCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCancelCaption);
		return educationDeleteCancelCaption.getText();
	}

	public String getEducationDeleteOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCaption);
		return educationDeleteCaption.getText();
	}

	public void clickOnCancelButtonInEducationDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCancelCaption);
		educationDeleteCancelCaption.click();
	}

	public void clickOnOkButtonInEducationDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCaption);
		educationDeleteCaption.click();
	}
	
	public String getProgramAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		return programAddButton.getText();
	}
	
	public void clickOnProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		javascriptClick(programTabText);
	}
	
	public String getProgramTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		String cssValue = programTabText.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}
	
	public String getProgramTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		return programTabText.getText();
	}
	
	public void clickOnProgramAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		javascriptClick(programAddButton);
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
	
	public boolean isProgramAlternateFlowsAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAlternateAddEditPageTitle);
		waitForElement(driver, programSubflowAddEditPageTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programAlternateAddEditPageTitle);
			isPresent = programAlternateAddEditPageTitle.isDisplayed();
			BasePageObject.waitForElement(driver,programSubflowAddEditPageTitle);
			isPresent = programSubflowAddEditPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void selectProgram(String programName) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programListRecords);
		waitForElement(driver, programListRecords);
		programSearchTextbox.sendKeys(programName);
		WebElement element =driver.findElement(By.xpath("//label[text()='"+programName+"']"));
		javascriptClick(element);
	}
	
	public boolean isProgramNameDisplay(String programName) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			WebElement program = driver.findElement(By.xpath("(//label[text()='" + programName + "'])"));
			isPresent = program.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

}