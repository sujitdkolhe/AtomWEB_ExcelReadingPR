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

public class Tasks extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement pageTitle;

	@FindBy(how = How.ID, using = "TasksView")
	private WebElement tasksTab;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-between align-items-center col-12 px-0  ltr']/label")
	private WebElement getTaskListHeader;

	@FindBy(how = How.ID, using = "TasksViewAddActionKey")
	private WebElement addButtonCaption;

	@FindBy(how = How.CSS, using = "#TasksViewIsPopupTaskNameKey1>input")
	private WebElement taskAddpageNameTextbox;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKey")
	public WebElement taskTypeDropdown;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> taskOperationTypeList;

	@FindBy(how = How.ID, using = "TasksViewIsPopupItemKeyinput-text")
	public WebElement taskAddpageItemDropdown;

	@FindBy(how = How.ID, using = "TasksViewIsPopuptabs1")
	public WebElement taskpageEngLang;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKey1input-text")
	public WebElement taskNameTextboxLang1;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskNameKey2input-text")
	public WebElement secondTaskNameTextboxLang;

	@FindBy(how = How.XPATH, using = "(//li[text()='Hindi'])[2]")
	public WebElement taskpageHindiLang;

	@FindBy(how = How.ID, using = "TasksViewSaveActionKey")
	public WebElement saveButtonCaption;

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

	@FindBy(how = How.ID, using = "FromKeyIDinput-text")
	public WebElement FromTextbox;

	@FindBy(how = How.ID, using = "SubflowsViewtable-row0")
	public WebElement subflowListdisplay;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs2")
	public WebElement subflowpageLang2;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	public WebElement taskNameLabel;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeylabel1120")
	public WebElement taskEducationTypeValue;

	@FindBy(how = How.ID, using = "(//ui[@id='TasksViewIsPopupItemKeyListItems']/li)[2]")
	public WebElement educationValue;

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

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start ']/following::img)[1]")
	public WebElement taskAddPageCrossIcon;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[last()]")
	public WebElement clickOnAnyTask;

	@FindBy(how = How.XPATH, using = "(//div[@id='TasksViewIsPopupTaskTypeKey'])")
	public WebElement taskTypeValue;

	@FindBy(how = How.ID, using = "TasksViewIsPopuptabs1")
	public WebElement engLangTabHighlighted;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	public WebElement instructionValue;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[10]")
	public WebElement selectedItemValue;

	@FindBy(how = How.XPATH, using = "//label[text()='Task Name Is Required']")
	public WebElement getNameIsRequiredMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeyerrorLabel")
	public WebElement getTaskTypeIsRequiredMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupItemKeyerrorLabel")
	public WebElement getTaskItemIsRequiredMsg;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	private WebElement editTaskHeader;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[7]")
	public WebElement questionnaireValue;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[6]")
	public WebElement measurementValue;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupItemKeyListItems']/li")
	private List<WebElement> taskItemList;

	@FindBy(how = How.ID, using = "TasksViewIsPopuperrorLabel")
	public WebElement getAllLangRequiredErrorMsg;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement duplicateDataError;

	@FindBy(how = How.XPATH, using = "//label[@class='success']")
	public WebElement successMsg;

	@FindBy(how = How.ID, using = "TasksViewDeleteActionKey")
	public WebElement taskDeleteButton;

	@FindBy(how = How.ID, using = "TasksViewDeleteActionKey")
	public WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement subflowDeleteLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])")
	private WebElement taskDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement TaskDeleteCancelButton;

	@FindBy(how = How.ID, using = "TasksViewOkActionKey")
	public WebElement taskDeleteOkButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[12]")
	public WebElement careProgramTabs;

	@FindBy(how = How.ID, using = "ProgramsView")
	public WebElement programTabText;
	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramsViewtable-row0'][last()]")
	public WebElement listRecord;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	public WebElement taskAddHeader;

	@FindBy(how = How.ID, using = "ProgramAddEditTasksViewAddActionKey")
	public WebElement programTaskAddButton;

	@FindBy(how = How.XPATH, using = "//li[@class='active activeLabel ltr']")
	public WebElement taskTab;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-header w-available mx-2'])[2]")
	public WebElement taskListTable;

	@FindBy(how = How.XPATH, using = "(//div[@id='TasksViewtable-row0']/label)[1]")
	private WebElement anyListItem;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[257]")
	private WebElement programtasklist;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	public WebElement programlist;

	@FindBy(how = How.ID, using = "TasksViewIsPopupAddActionKey")
	public WebElement alternateAddButton;

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

	@FindBy(how = How.ID, using = "ProgramAddEditAlternateFlowKeyAddActionKey")
	public WebElement programAlternateFlowAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	public WebElement alternateNameHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[6]")
	public WebElement alternateTaskTypeHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[7]")
	public WebElement alternateItemHeader;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement alternateCancelButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[7]")
	public WebElement alternateFlowList;

	@FindBy(how = How.ID, using = "TasksViewIsPopuperrorLabel")
	public WebElement noRecordsFoundInAlternateFlowList;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement alternateAddPageHeading;

	@FindBy(how = How.XPATH, using = "(//div[@id=\"TasksViewIsPopuptable-row0\"][last()])")
	public WebElement clickOnAlternateRecords;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm  text-start']")
	public WebElement measurementValueSearch;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm text-start']")
	public WebElement heightValueSearch;

	@FindBy(how = How.XPATH, using = "(//div[@class='padding-horizontal-lg padding-bottom-lg'])[2]")
	public WebElement alternateFlowPage;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement alternateFlowCrossIcon;

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

	@FindBy(how = How.XPATH, using = "(//button[@class='btn-secondary padding-horizontal-md float-right'])[1]")
	public WebElement alternateFlowCancelButton;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement crossIcon;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[2]")
	public WebElement alternateFlowsHeading;

	@FindBy(how = How.XPATH, using = "//ui[@id='TasksViewIsPopupProgramNameKeyListItems']/li")
	private List<WebElement> nameListValue;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKeylabel208")
	public WebElement selectAnyValueInNameDropdown;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-xxs text-start']")
	public WebElement alternateFlowType;

	@FindBy(how = How.ID, using = "TasksViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement assignAfterDaysIsRequiredErrorMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysIsRequiredErrorMsg;

	@FindBy(how = How.ID, using = "TasksViewCancelActionKey")
	public WebElement deleteCancelCaption;

	@FindBy(how = How.ID, using = "TasksViewOkActionKey")
	public WebElement deletePageOkCaption;

	@FindBy(how = How.ID, using = "TasksViewIsPopupDeleteActionKey")
	public WebElement deletePage;
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	public WebElement getDeleteHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement deleteCrossIconPage;

	@FindBy(how = How.ID, using = "TasksViewIsPopupProgramNameKeyerrorLabel")
	public WebElement nameIsRequiredErroMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])[1]")
	public WebElement getDeletePermissionMsg;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskDescriptionKey1input-textArea")
	public WebElement firstLangDescriptionTextbox;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskDescriptionKey2input-textArea")
	public WebElement secondLangDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//li[text()='English'])[2]")
	public WebElement taskpageEnglishLang;

	@FindBy(how = How.ID, using = "(//div[@id='TasksViewtable-row0']/label)[1]")
	public WebElement selectAnyTask;

	@FindBy(how = How.ID, using = "TasksViewIsPopupTaskTypeKeyListItems")
	public WebElement taskItemsValue;

	@FindBy(how = How.XPATH, using = "//li[text()='Tasks']")
	public WebElement programTaskTab;

	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramAddEditTasksViewtable-row0']/label)[1]")
	public WebElement programTask;

	public Tasks(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCareProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickCareProgramTab);
		javascriptClick(clickCareProgramTab);
	}

	public String getProgramPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pageTitle);
		return pageTitle.getText();
	}

	public void clickOnTasksTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, tasksTab);
		javascriptClick(tasksTab);
	}

	public String getTasksTabName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, tasksTab);
		return tasksTab.getText();
	}

	public String getTasksListHeader() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(getTaskListHeader);
		// waitForElement(driver, getTaskListHeader);
		return getTaskListHeader.getText();
	}

	public void clickOnTasksAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButtonCaption);
		// waitForElement(driver, addButtonCaption);
		// addButtonCaption.click();
		javascriptClick(addButtonCaption);
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
		waitForElement(driver, taskTypeDropdown);
		taskTypeDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(//ui[@id='TasksViewIsPopupTaskTypeKeyListItems']/li)[" + value + "]"));
		Thread.sleep(2000);
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

	public void clickOnTaskTabInLangFirst() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(taskpageEngLang);
		// waitForElement(driver, taskpageEngLang);
		taskpageEngLang.click();
	}

	public void sendTaskNameForFirstLang(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskNameTextboxLang1);
		taskNameTextboxLang1.sendKeys(name);
	}

	public void clickOnTaskTabInLangSecond() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskpageHindiLang);
		taskpageHindiLang.click();
	}

	public void sendTaskNameForSecondLang(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, secondTaskNameTextboxLang);
		secondTaskNameTextboxLang.sendKeys(name);
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

	public String getTaskAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaption);
		return addButtonCaption.getText();
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
		waitUntilElementIsVisible(taskSearchboxPlaceholder);
		// waitForElement(driver, taskSearchboxPlaceholder);
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

	public String getLangTwoTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowpageLang2);
		String cssValue = subflowpageLang2.getCssValue("color");
		return Color.fromString(cssValue).asHex();
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

	public void clickOnDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(taskTypeDropdown);
		// waitForElement(driver, taskTypeDropdown);
		taskTypeDropdown.click();
		taskEducationTypeValue.click();
		taskAddpageItemDropdown.click();
		educationValue.click();
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

	public String getTaskAddPageDescriptionLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDescriptionLabel);
		return taskDescriptionLabel.getText();
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

	public void clickOnAnyTaskRecords() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnAnyTask);
		// waitForElement(driver, clickOnAnyTask);
		Actions action = new Actions(driver);
		action.click(clickOnAnyTask).build().perform();
	}

	public void getTaskNameTextboxPrefilledData(String namePrefilledData) {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		taskAddpageNameTextbox.sendKeys(namePrefilledData);
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

	public String getTaskItemValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		return taskAddpageItemDropdown.getAttribute("value");
	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddPageCrossIcon);
		taskAddPageCrossIcon.click();
	}

	public void clickOnTaskCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonCaption);
		cancelButtonCaption.click();
	}

	public String getTaskLangTwoTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, engLangTabHighlighted);
		String cssValue = engLangTabHighlighted.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public void clickOnTaskTypeDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeDropdown);
		taskTypeDropdown.click();
		Thread.sleep(2000);
	}

	public void selectAnyTaskTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeValue);
		javascriptClick(taskTypeValue);
	}

	public void clickTaskEducationTypeValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskEducationTypeValue);
		taskEducationTypeValue.click();
	}

	public void selectInstructionsValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionValue);
		instructionValue.click();
	}

	public void clickOnItemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageItemDropdown);
		taskAddpageItemDropdown.click();
	}

	public void clickOnTaskItemDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectedItemValue);
		selectedItemValue.click();
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

	public List<String> getTaskItemList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(taskItemList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : taskItemList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getAllLangRequiredErrorMsgLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getAllLangRequiredErrorMsg);
		return getAllLangRequiredErrorMsg.getText();
	}

	public String getDuplicateDataErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, duplicateDataError);
		return duplicateDataError.getText();
	}

	public String getSuccessMsg() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(successMsg);
		// waitForElement(driver, successMsg);
		return successMsg.getText();
	}

	public String getTaskDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteButton);
		return taskDeleteButton.getText();
	}

	public void clickOnTaskDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		deleteButton.click();
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

	public String getTaskDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskDeleteOkButton);
		return taskDeleteOkButton.getText();
	}

	public void clickOnCancelButtonInTaskDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, TaskDeleteCancelButton);
		TaskDeleteCancelButton.click();
	}

	public void clickOnOkButtonInTaskDeletePage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(taskDeleteOkButton);
		// waitForElement(driver, taskDeleteOkButton);
		taskDeleteOkButton.click();
	}

	public void clickOnCareProgramTabs() {
		TestConfig.PrintMethodName();
		waitForElement(driver, careProgramTabs);
		javascriptClick(careProgramTabs);
	}

	public void clickOnProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		javascriptClick(programTabText);
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

	public void clickOnProgramTaskAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskAddButton);
		javascriptClick(programTaskAddButton);
	}

	public void clickOnProgramList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programlist);
		programlist.click();
	}

	public void clickOnTaskTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTab);
		taskTab.click();
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

	public String getEditTaskHeaderHeaderCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editTaskHeader);
		return editTaskHeader.getText();
	}

	public void clickOnAlternateAddButton() {

		waitForElement(driver, alternateAddButton);
		alternateAddButton.click();
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

	public boolean isAlternateFlowsAddButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, alternateAddButton);
			isPresent = alternateAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isProgramAlternateFlowAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAlternateFlowAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programAlternateFlowAddButton);
			isPresent = programAlternateFlowAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
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
		waitUntilElementIsVisible(clickOnAlternateRecords);
		// waitForElement(driver, clickOnAlternateRecords);
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
		waitUntilElementIsVisible(alternateAssignAfterDay);
		// waitForElement(driver, alternateAssignAfterDay);
		alternateAssignAfterDay.sendKeys(assignAfterDays);
	}

	public void getAlternateEditPageShowAfterDaysPrefilledData(String showForDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		alternateShowForDays.sendKeys(showForDays);
	}

	public String getTaskTypeMeasurementValue() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(measurementValueSearch);
		// waitForElement(driver, measurementValueSearch);
		return measurementValueSearch.getText();
	}

	public String getTaskTypeHeightValue() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(heightValueSearch);
		// waitForElement(driver, heightValueSearch);
		return heightValueSearch.getText();
	}

	public void sendAlternateSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(TasksViewIsPopupSearchTextKey);
		// waitForElement(driver, TasksViewIsPopupSearchTextKey);
		TasksViewIsPopupSearchTextKey.sendKeys(searchword);
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

	public String getAlternateFlowCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowCancelButton);
		return alternateFlowCancelButton.getText();
	}

	public String getAlternateFlowSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateSaveButton);
		return alternateSaveButton.getText();
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

	public String getAlternateFlowEditPageDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		return deleteButton.getText();
	}

	public String getAlternateEditPagePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("value");
	}

	public String getAlternateEditPageShowAfterDaysPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateShowForDays);
		return alternateShowForDays.getAttribute("value");
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

	public String getAlternateFlowsHeadingInTaskEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFlowsHeading);
		return alternateFlowsHeading.getText();
	}

	public List<String> getNameDropdownValue() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : nameListValue) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getTaskSelectedAlternateFlowNameDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateNameDropdown);
		return alternateNameDropdown.getAttribute("value");
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

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		deleteButton.click();
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

	public void createTask(String name) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskAddpageNameTextbox);
		taskpageEnglishLang.click();
		taskAddpageNameTextbox.sendKeys(name);
		firstLangDescriptionTextbox.click();
		firstLangDescriptionTextbox.sendKeys(name);
		taskpageHindiLang.click();
		secondTaskNameTextboxLang.sendKeys(name);
		secondLangDescriptionTextbox.click();
		secondLangDescriptionTextbox.sendKeys(name);
		taskTypeDropdown.click();
		taskEducationTypeValue.click();
		taskAddpageItemDropdown.click();
		WebElement element = driver
				.findElement(By.xpath("//ui[@id='TasksViewIsPopupItemKeyListItems']/li[text()='" + name + "']"));
		element.click();
		javascriptClick(saveButtonCaption);
	}

	public void clickOnTask(String taskName) {
		TestConfig.PrintMethodName();
		WebElement element = driver.findElement(By.xpath("//label[text()='" + taskName + "']"));
		javascriptClick(element);
	}

	public boolean isTaskItemsValueDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteCrossIconPage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, taskItemsValue);
			isPresent = taskItemsValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isTaskDisplayInList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskTypeValue);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, anyListItem);
			isPresent = anyListItem.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void programTaskTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTaskTab);
		javascriptClick(programTaskTab);
	}

	public boolean isProgramTaskDisplayInList() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, programTask);
			BasePageObject.waitForElement(driver, programTask);
			isPresent = programTask.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnProgramTask() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTask);
		javascriptClick(programTask);
	}

}