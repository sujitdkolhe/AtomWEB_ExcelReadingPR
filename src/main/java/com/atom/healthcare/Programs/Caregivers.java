package com.atom.healthcare.Programs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Caregivers extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement pageTitle;

	@FindBy(how = How.ID, using = "SubflowsViewAddActionKey")
	private WebElement subflowAddbuttonlabel;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowAddCancelbutton;

	@FindBy(how = How.XPATH, using = "//label[text()='Subflow Edit']")
	private WebElement subflowEditpageTitle;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowEditCancelbutton;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs1")
	public WebElement subflowpageLang1;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopuptabs2")
	public WebElement subflowPageSecondLang;

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

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTabText;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
	private WebElement subflowPlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[text()='Item'])[2]")
	private WebElement subflowAddPageItemLabel;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement alternateFlowCrossIcon;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeySearchTextKey")
	public WebElement programCaregiverSearchTexbox;

	@FindBy(how = How.XPATH, using = "//li[text()='Caregivers']")
	public WebElement programCaregiverListTitle;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder=\"Name\"])[1]")
	private WebElement namePlaceholder;

	@FindBy(how = How.XPATH, using = "(//textarea[@class='input-primary mb-0 pt-2  ltr'])[1]")
	private WebElement descriptionPlaceholder;

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupOperationTypeKeylabel1153")
	public WebElement betweenOperationType;

	@FindBy(how = How.ID, using = "BetweenFromKeyinput-text")
	public WebElement betweenFromValue;

	@FindBy(how = How.ID, using = "BetweenToKeyinput-text")
	public WebElement betweenToValue;

	@FindBy(how = How.ID, using = "FromKeyIDinput-text")
	public WebElement fromTextbox;

	@FindBy(how = How.XPATH, using = "//ui[@id='SubflowsViewIsPopupTaskTypeKeyListItems']/li")
	private List<WebElement> subflowTaskTypeList;

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

	@FindBy(how = How.ID, using = "SubflowsViewIsPopupProgramNameKey3input-text")
	public WebElement subflowNametextbox;

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

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement subflowDeleteLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])\r\n")
	private WebElement subflowDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "SubflowsViewCancelActionKey")
	public WebElement subflowDeleteCancelButton;

	@FindBy(how = How.ID, using = "SubflowsViewOkActionKey")
	public WebElement subflowDeleteOkButton;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement duplicateDataError;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement taskAddPageCrossIcon;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	public WebElement selectedEducationItem;

	@FindBy(how = How.ID, using = "ProgramsView")
	public WebElement programTabText;

	@FindBy(how = How.XPATH, using = "//div[@class='table-row-1 w-available mx-2  cursor-pointer'][last()]")
	public WebElement programListRecords;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeyAddActionKey")
	public WebElement programCaregiverAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programCaregiverAddPageTitle;

	@FindBy(how = How.XPATH, using = "//li[text()='Caregivers']")
	public WebElement programCaregiverTab;

	@FindBy(how = How.ID, using = "ProgramAddEditDefaultCaregiverKeytable-row0")
	public WebElement susbcribedProgramCaregiverRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	public WebElement programMeasurementAddEditPageTitle;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement programCaregiverAssignAfterDaysTextbox;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyinput-text")
	public WebElement programCaregiverShowForDaysTextbox;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeySaveActionKey")
	public WebElement programCaregiverSaveButton;

	@FindBy(how = How.ID, using = "ProgramsViewSaveActionKey")
	public WebElement programSaveButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyinput-text")
	public WebElement programProviderDropdown;

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

	@FindBy(how = How.XPATH, using = "(//label[text()='Provider'])[2]")
	public WebElement caregiverProviderLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKey")
	public WebElement caregiverProviderDropdown;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Assign After Days')])[4]")
	public WebElement caregiverAssignAfterDaysLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKey")
	public WebElement caregiverAssignAfterDaysTextbox;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Show For Days')])[4]")
	public WebElement caregiverShowForDaysLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKey")
	public WebElement caregiverShowForDaysTextbox;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeyCancelActionKey")
	public WebElement addCaregiverCancelButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Provider\"]")
	private WebElement caregiverProviderPlaceholder;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyListItems")
	public WebElement addProviderList;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyerrorLabel")
	public WebElement providerFieldRequiredMsg;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysFeildRequiredRangeMsg;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[last()]")
	private WebElement programCaregiverListRecord;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[last()]")
	private WebElement duplicateProviderName;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeyDeleteActionKey")
	public WebElement caregiverDeleteButton;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement caregiverDeleteCancelButton;

	@FindBy(how = How.ID, using = "ProgramsViewOkActionKey")
	public WebElement caregiverDeleteOkButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs2")
	public WebElement programpageHindiLang;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Caregivers')])[2]")
	public WebElement caregiverCountTitle;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectProviderKeyinput-text")
	public WebElement programProviderDropdownName;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement showForDaysFeildRequiredMsg;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement assignAfterDaysFeildRequiredRangeMsg;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramAddEditDefaultCaregiverKeytable-row0']/label)[1]")
	public WebElement providerName;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramAddEditDefaultCaregiverKeytable-row0']/label)[2]")
	public WebElement profession;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramAddEditDefaultCaregiverKeytable-row0']/label)[3]")
	public WebElement assignFoprDays;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='ProgramAddEditDefaultCaregiverKeytable-row0']/label)[4]")
	public WebElement showForDays;

	public Caregivers(WebDriver driver) {
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
		waitForElement(driver, subFlowTabText);
		return subFlowTabText.getText();
	}

	public String getSubflowAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddbuttonlabel);
		return subflowAddbuttonlabel.getText();
	}

	public void clickOnSubflowAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddbuttonlabel);
		subflowAddbuttonlabel.click();
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
		waitForElement(driver, subflowPageSecondLang);
		return subflowPageSecondLang.getText();
	}

	public void clickOnSubflowLangTwo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowPageSecondLang);
		subflowPageSecondLang.click();
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
			waitForElement(driver, subflowAddpageNameTextbox);
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
			waitForElement(driver, subflowAddPageDescriptionTextbox);
			isPresent = subflowAddPageDescriptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubflowAddPageOperationDropdownDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, subflowAddpageOperationDropdown);
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

	public String getSubflowAddPageItemLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowAddPageItemLabel);
		return subflowAddPageItemLabel.getText();
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
		waitForElement(driver, betweenOperationType);
		betweenOperationType.click();
	}

	public boolean isSubflowBetweenFromValueTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, betweenFromValue);
			isPresent = betweenFromValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowFromValueTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, betweenFromValue);
		return betweenFromValue.getAttribute("placeholder");
	}

	public boolean isSubflowBetweenToValueTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, betweenToValue);
			isPresent = betweenToValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowToValueTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, betweenToValue);
		return betweenToValue.getAttribute("placeholder");
	}

	public boolean isFromTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, fromTextbox);
			isPresent = fromTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSubflowFromTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fromTextbox);
		return fromTextbox.getAttribute("placeholder");
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
				isPresent = fromTextbox.isDisplayed();
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

	public String getDeleteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteLabel);
		return subflowDeleteLabel.getText();
	}

	public String getDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteConfirmationMsg);
		return subflowDeleteConfirmationMsg.getText();
	}

	public String getDeleteConfirmationCancelButton() {
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

	public String getDuplicateDataErrorLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(duplicateDataError);
		return duplicateDataError.getText();
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

	public void clickOnProgramTab() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, programTabText);
		waitUntilElementIsVisible(programTabText);
		javascriptClick(programTabText);
		Thread.sleep(5000);
	}

	public void clickOnProgramListRecord() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programListRecords);
		waitForElement(driver, programListRecords);
		javascriptClick(programListRecords);
	}

	public void clickOnProgramCaregiverAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programCaregiverAddButton);
		programCaregiverAddButton.click();
	}

	public String getProgramCaregiverAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAddPageTitle);
		return programCaregiverAddPageTitle.getText();
	}

	public void clickOnProgramCaregiverTab() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverTab);
		javascriptClick(programCaregiverTab);
		
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

	public void sendProgramCaregiverAssignAfterDaysNumber(String num) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programCaregiverAssignAfterDaysTextbox);
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

	public void clickOnProgramCaregiver(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//ui[@id='ProgramsViewIsPopupSelectProviderKeyListItems'])/li[" + num + "]"));
		name.click();

	}

	public void clickOnProgramProviderDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programProviderDropdown);
		programProviderDropdown.click();
	}

	public void sendProviderNameInProgramCaregiverSearchTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverSearchTexbox);
		programCaregiverSearchTexbox.sendKeys(name);
	}

	public String getProgramCaregiverListTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(caregiverCountTitle);
		return caregiverCountTitle.getText();
	}

	public String getSelectedCaregivername() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programProviderDropdown);
		return programProviderDropdown.getAttribute("value");
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
		waitUntilElementIsVisible(programCaregiverSearchTexbox);
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

	public String isCaregiverShowForDaysTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		String cssValue = programCaregiverShowForDaysTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public void clickOnProgramCaregiverListRecord() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programCaregiverListRecord);
		waitForElement(driver, programCaregiverListRecord);
		javascriptClick(programCaregiverListRecord);
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

	public void clickOnProgramTabInLangSecond() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programpageHindiLang);
		programpageHindiLang.click();
	}

	public String getCaregiverDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteButton);
		return caregiverDeleteButton.getText();
	}

	public void clickOnCaregiverDeleteButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(caregiverDeleteButton);
		caregiverDeleteButton.click();
	}

	public String getCaregiverDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteCancelButton);
		return caregiverDeleteCancelButton.getText();
	}

	public void clickOnCaregiverDeleteCancelButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(caregiverDeleteCancelButton);
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

	public String getProgramSelectedCaregivername() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programProviderDropdownName);
		return programProviderDropdownName.getText();
	}

	public void clearCaregiverShowForDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		programCaregiverShowForDaysTextbox.clear();
	}

	public String getCaregiverShowForDaysRequiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysFeildRequiredMsg);
		return showForDaysFeildRequiredMsg.getText();
	}

	public void clearCaregiverAssignAfterDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		programCaregiverAssignAfterDaysTextbox.clear();
	}

	public String isCaregiverAssignAfterDaysTextboxErrorColorDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		String cssValue = programCaregiverAssignAfterDaysTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getCaregiverAssignAfterDaysRequiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignAfterDaysFeildRequiredRangeMsg);
		return assignAfterDaysFeildRequiredRangeMsg.getText();
	}
	
	public void clickCaregiverShowForDaysTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverShowForDaysTextbox);
		programCaregiverShowForDaysTextbox.click();
	}
	
	public void clickOnCaregiver(String caregiverName) {
		TestConfig.PrintMethodName();
		WebElement userImage = driver.findElement(By.xpath("//label[text()='" + caregiverName + "']"));
		userImage.click();
	}
	

	public boolean isCaregiverdisplay(String caregiverName ) {
		TestConfig.PrintMethodName();
		waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, programCaregiverAssignAfterDaysTextbox);
			WebElement userImage = driver.findElement(By.xpath("//span[text()='" + caregiverName + "']"));
			
			isPresent = userImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Caregiver is not visible");
			return isPresent;
		}
	}


	public boolean isCaregiverNameDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, providerName);
			isPresent = providerName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isProfessionDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, profession);
			isPresent = profession.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}   
	}
	   
	public boolean isAssignForDaysDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, assignFoprDays);
			isPresent = assignFoprDays.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isShowForDaysDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, showForDays);
			isPresent = showForDays.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

}
