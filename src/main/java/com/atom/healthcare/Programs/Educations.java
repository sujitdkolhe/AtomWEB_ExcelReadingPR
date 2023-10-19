package com.atom.healthcare.Programs;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Educations extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Care Programs']")
	public WebElement careProgramTabs;

	@FindBy(how = How.ID, using = "ProgramsView")
	public WebElement programTabText;

	@FindBy(how = How.ID, using = "ProgramsViewAddActionKey")
	public WebElement programAddButton;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary  ltr']")
	public WebElement clickOnProgramName;

	@FindBy(how = How.ID, using = "ProgramAddEditSupportedCodeSystemKeyinput-text")
	public WebElement clickSupportedCodeSystem;

	@FindBy(how = How.ID, using = "ProgramAddEditSupportedCodeSystemKeylabel640")
	public WebElement selectCodeSystem;

	@FindBy(how = How.XPATH, using = "//label[text()='Education Add/Edit']")
	public WebElement programEducationHeading;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs1")
	public WebElement programpageEngLang;

	@FindBy(how = How.XPATH, using = "(//li[text()='Hindi'])[2]")
	public WebElement programpageHindiLang;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[2]")
	public WebElement sendOnFisrtLangProgramName;

	@FindBy(how = How.XPATH, using = "//div[@id='ProgramsViewIsPopupProgramNameKey2']/input")
	public WebElement sendOnSecondLangProgramName;

	@FindBy(how = How.XPATH, using = "//div[@class='table-row-1 w-available mx-2  cursor-pointer'][last()]")
	public WebElement programListRecords;

	@FindBy(how = How.XPATH, using = "//li[text()='Educations']")
	public WebElement programEducationTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Educations (0)']")
	public WebElement educationListTitle;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeyAddActionKey")
	public WebElement clickOnEducationAddButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectCategoryKeyinput-text")
	public WebElement clickOnCategory;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectEducationLabelKeyinput-text")
	public WebElement educationDropdown;

	@FindBy(how = How.XPATH, using = "//div[@id='ProgramsViewIsPopupAssignAfterDaysKey']/input")
	public WebElement educationAssignAfterDay;

	@FindBy(how = How.XPATH, using = "//div[@id='ProgramsViewIsPopupShowForDaysKey']/input")
	public WebElement educationShowForDay;

	@FindBy(how = How.ID, using = "DefaultCaregiverKeySaveActionKey")
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

	@FindBy(how = How.ID, using = "(//div[@id='PatientEducationAddEditEducationKeytable-row0']/label)[1]")
	public WebElement educationList;

	@FindBy(how = How.ID, using = "ProgramsViewSaveActionKey")
	public WebElement programSaveButton;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeyerrorLabel")
	public WebElement educationRecords;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	public WebElement programEducationCrossIcon;

	@FindBy(how = How.XPATH, using = "(//label[text()='Category'])[2]")
	public WebElement programEducationCategoryLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Education'])[2]")
	public WebElement programEducationLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Assign After Days'])[5]")
	public WebElement programEducationAssignAfterDaysLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupProgramNameKey3input-text")
	public WebElement programNamePrefilledData;

	@FindBy(how = How.XPATH, using = "//div[@id='ProgramsViewtable-row0']/label[contains(.,'Program Test')]")
	public WebElement programTest;

	@FindBy(how = How.XPATH, using = "//li[contains(.,'Caregivers')]")
	public WebElement caregiverTab;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Programs')]")
	public WebElement programsTab;

	@FindBy(how = How.XPATH, using = "(//label[text()='Show For Days'])[5]")
	public WebElement programEducationShowForDaysLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr '])[2]")
	public WebElement forProviderCheckbox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md float-right']")
	public WebElement educationCancelButton;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement errorMsgInAssignAfterDays;

	@FindBy(how = How.XPATH, using = "//ui[@id='ProgramsViewIsPopupSelectCategoryKeyListItems']//li")
	private List<WebElement> categoryDropdownList;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyerrorLabel")
	public WebElement errorMsgInShowForDays;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectCategoryKeyerrorLabel")
	public WebElement errorMsgCategoryIsRequired;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupSelectEducationLabelKeyerrorLabel")
	public WebElement errorMsgEducationIsRequired;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyerrorLabel")
	public WebElement errorMsgAssignAfterDaysIsRequired;

	@FindBy(how = How.ID, using = "ProgramsViewOkActionKey")
	public WebElement educationDeleteCaption;

	@FindBy(how = How.XPATH, using = "(//label[text()='Delete'])[2]")
	public WebElement educationDelete;

	@FindBy(how = How.ID, using = "PatientEducationAddEditEducationKeytable-row0")
	public WebElement openEducationRecord;

	@FindBy(how = How.ID, using = "ProgramsViewCancelActionKey")
	public WebElement educationDeleteCancelCaption;

	@FindBy(how = How.XPATH, using = "(//label[text()='Delete'])[1]")
	public WebElement educationDeletePageHeading;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[3]")
	public WebElement educationDeleteCrossIcon;

	@FindBy(how = How.XPATH, using = "//p[text()='Are you sure you want to delete?']")
	public WebElement educationDeleteMsg;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Educations']")
	public WebElement educationTabText;
	
	@FindBy(how = How.ID, using = "ProgramsViewSearchTextKey")
	public WebElement searchProgram;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Show For Days Is Required']")
	public WebElement showForDaysRequiredField;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='ProgramsViewIsPopupSelectCategoryKeyListItems']/li)[2]")
	public WebElement selectCategoryFromDropdown;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='ProgramsViewIsPopupSelectEducationLabelKeyListItems']/li)[2]")
	public WebElement selectEducation;
	
	@FindBy(how = How.CSS, using = "#ProgramsViewIsPopupAssignAfterDaysKey>input")
	public WebElement assignAfterDateInput;
	
	@FindBy(how = How.CSS, using = "#ProgramsViewIsPopupShowForDaysKey>input")
	public WebElement showForDaysInput;
	
	
	
	
	public Educations(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openProgramAddPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, careProgramTabs);
		javascriptClick(careProgramTabs);
		javascriptClick(programTabText);
		javascriptClick(programAddButton);  
		javascriptClick(clickOnProgramName);
	}
	
	public void clickOnCareProgramTabs() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(careProgramTabs);
		javascriptClick(careProgramTabs);
	}

	public void clickOnProgramTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programTabText);
		javascriptClick(programTabText);
	}

	public void clickOnProgramAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		javascriptClick(programAddButton);
	}

	public void clickOnProgramNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnProgramName);
		clickOnProgramName.click();
	}

	public void createProgram(String programName) throws Exception {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickSupportedCodeSystem);
		javascriptClick(clickSupportedCodeSystem);
		javascriptClick(selectCodeSystem);
		javascriptClick(clickOnProgramName);
		clickOnProgramName.sendKeys(programName);
		//javascriptClick(programpageEngLang);
		waitForElement(driver, sendOnFisrtLangProgramName);
//		sendOnFisrtLangProgramName.sendKeys(programName);
//		waitForElement(driver, programpageHindiLang);
//		programpageHindiLang.click();
//		sendOnSecondLangProgramName.sendKeys(programName);
		javascriptClick(programSaveButton);
	}
	public void clickOnProgramListRecord() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programListRecords);
		waitForElement(driver, programListRecords);
		javascriptClick(programListRecords);
	}

	public void clickOnProgramListEducationTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programEducationTab);
		programEducationTab.click();
	}
	
	public String getProgramEducationListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationListTitle);
		return educationListTitle.getText();
	}

	public void clickOnProgramEducationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationAddButton);
		clickOnEducationAddButton.click();
	}

	public void clickOnProgramEduactionCategoryDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnCategory);
		clickOnCategory.click();
	}

	public void clickOnCategoryDropdown(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//li[@class='lbl-primary-text-body-large-regular ltr'])[" + 9 + "]"));
		name.click();
	}

	public void clickOnEducationDropdown(String num) {
		TestConfig.PrintMethodName();
		WebElement name = driver
				.findElement(By.xpath("(//ui[@id='ProgramsViewIsPopupSelectEducationLabelKeyListItems']/li)[" + num + "]"));
		name.click();
	}

	public void clickOnEducationDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDropdown);
		educationDropdown.click();
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
		waitUntilElementIsVisible(educationSaveButton);
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
		waitForElement(driver, educationDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationDropdown);
			isPresent = educationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDropdown);
		return educationDropdown.getAttribute("placeholder");
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
		waitForElement(driver, educationDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, educationDropdown);
			isPresent = educationDropdown.isDisplayed();
			return isPresent;
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

	public void sendMoreThanFourDigit(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignAfterDay);
		educationAssignAfterDay.sendKeys(value);
	}

	public String getErrorMsgInAssignAfterDays() {
		TestConfig.PrintMethodName();
		waitForElement(driver, errorMsgInAssignAfterDays);
		return errorMsgInAssignAfterDays.getText();
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

	public void clickOnEduactionRecord() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(openEducationRecord);
		openEducationRecord.click();
	}

	public String getCategoryPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCategory);
		return clickOnCategory.getText();
	}

	public String getEducationPrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDropdown);
		return educationDropdown.getText();
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

	public void clickOnOkButtonInEducationDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCaption);
		educationDeleteCaption.click();
	}

	public void clickOnCancelButtonInEducationDeletePage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDeleteCancelCaption);
		educationDeleteCancelCaption.click();
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

	public String getEducationTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationTabText);
		return educationTabText.getText();
	}
	
	public void searchProgramName(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchProgram);
		searchProgram.sendKeys(value);
	}

	public String getErrorMsgShowForDayssRequired() {
		TestConfig.PrintMethodName();
		waitForElement(driver, showForDaysRequiredField);
		return showForDaysRequiredField.getText();
	}
	
	public void addEducationInProgram(String education,String assignAfterDays , String showForDays) {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnEducationAddButton);
		javascriptClick(clickOnEducationAddButton);
		clickOnCategory.click();
		selectCategoryFromDropdown.click();
		educationDropdown.click();
		educationDropdown.sendKeys(education);
		selectEducation.click();
		showForDaysInput.sendKeys(assignAfterDays);
		assignAfterDateInput.sendKeys(showForDays);
		educationSaveButton.click();
	}
	
	public void selectProgramFromList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationList);
		educationList.click();
	}
	
	

}
