package com.atom.healthcare.Programs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Medications extends BasePageObject {

	@FindBy(how = How.XPATH, using = "(//div[@id='LeftMenuOrganisationMenuProramsTabView'])[1]")
	public WebElement careProgramTabs;

	@FindBy(how = How.XPATH, using = "//li[@id='ProgramsView']")
	public WebElement programTabText;

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "//li[text()='Medications']")
	public WebElement programMedicationsTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Program Task']")
	public WebElement programNameInList;

	@FindBy(how = How.XPATH, using = "//label[text()='Medication Add/Edit']")
	public WebElement medicationAddEditHeader;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Medicine name')])[2]")
	public WebElement medicationAddEditMedicineNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Doses'])[2]")
	public WebElement medicationAddEditDosesLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupMedicineNameKeyinput-text")
	public WebElement medicationAddEditMedicineNameTextbox;

	@FindBy(how = How.ID, using = "entryDosesinput-text")
	public WebElement medicationAddEditDosesTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Unit']")
	public WebElement medicationAddEditUnitLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Frequency'])[2]")
	public WebElement medicationAddEditFrequencyLabel;

	@FindBy(how = How.ID, using = "entryFrequencyinput-text")
	public WebElement medicationAddEditFrequencyTextbox;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'How often')]")
	public WebElement medicationAddEditHowOftenLabel;

	@FindBy(how = How.ID, using = "frequencyOptionsinput-text")
	public WebElement medicationAddEditHowOftenDropdown;

	@FindAll(@FindBy(how = How.XPATH, using = "(//ui[@id='frequencyOptionsListItems'])/li"))
	private List<WebElement> howOftenDropdownList;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Assign After Days')])[6]")
	public WebElement medicationAddEditAssignForDayLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupAssignAfterDaysKeyinput-text")
	public WebElement medicationAddEditAssignForDayTextbox;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Show For Days')])[6]")
	public WebElement medicationAddEditShowForDayLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupShowForDaysKeyinput-text")
	public WebElement medicationAddEditShowForDayTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Note']")
	public WebElement medicationAddEditNoteLabel;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopupNoteTextKeyinput-textArea")
	public WebElement medicationAddEditNoteTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='inhaler']")
	public WebElement clickOnMedicationRowList;

	@FindBy(how = How.ID, using = "MedicationHeaderKeyDeleteActionKey")
	public WebElement medicationAddEditDeleteButtonDisplay;

	@FindBy(how = How.XPATH, using = "(//button[text()='Add'])[7]")
	public WebElement programMedicationAddButton;

	@FindBy(how = How.ID, using = "SubflowsViewtable-row0")
	public WebElement subflowListdisplay;

	@FindBy(how = How.XPATH, using = "//input[@id='dosesUnitinput-text']")
	public WebElement medicationAddEditUnitDropdown;

	@FindBy(how = How.ID, using = "ProgramsViewSaveActionKey")
	public WebElement programSaveButton;

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

	@FindBy(how = How.ID, using = "DefaultCaregiverKeyCancelActionKey")
	public WebElement addCaregiverCancelButton;

	@FindBy(how = How.ID, using = "frequencyOptionsinput-text")
	public WebElement clickOnMedicationAddEditHowOftenDropdown;

	@FindBy(how = How.XPATH, using = "//label[@id='ProgramsViewIsPopupMedicineNameKeyerrorLabel']")
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

	@FindBy(how = How.XPATH, using = "(//img[@class='icon-left img-icon-medium ltr'])[8]")
	public WebElement searchIconInMedicationName;

	@FindBy(how = How.ID, using = "dosesUnitlabel25")
	public WebElement unitDropdownTabletselect;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	public WebElement alternateDeleteConfirmationMessage;

	@FindBy(how = How.XPATH, using = "(//button[@id='ProgramsViewCancelActionKey'])[1]")
	public WebElement alternateConfirmationCancelButton;

	@FindBy(how = How.XPATH, using = "(//button[@id='ProgramsViewOkActionKey'])[1]")
	public WebElement alternateConfirmationOkButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	public WebElement deleteButton;

	@FindBy(how = How.ID, using = "ProgramAddEditSupportedCodeSystemKeyinput-text")
	public WebElement programSupportedCodeSystem;

	@FindBy(how = How.ID, using = "ProgramsViewAddActionKey")
	public WebElement programAddButton;

	@FindBy(how = How.XPATH, using = "//li[text()='ICD-10 Code System']")
	public WebElement icdProgramSupportedCodeSystem;

	@FindBy(how = How.ID, using = "ProgramsViewIsPopuptabs2")
	public WebElement programpageHindiLang;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary  ltr']")
	public WebElement clickOnProgramName;

	@FindBy(how = How.ID, using = "ProgramsViewSearchTextKey")
	public WebElement searchProgram;

	@FindBy(how = How.XPATH, using = "(//button[text()='Save'])[1]")
	public WebElement medicationAddEditSaveButton;

	public Medications(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnExstingProgramAddMedication() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, programMedicationsTab);
		javascriptClick(programMedicationsTab);
		javascriptClick(programMedicationAddButton);
	}

	public void clickOnExstingProgram() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickCareProgramTab);
		javascriptClick(careProgramTabs);
		javascriptClick(programTabText);
//		javascriptClick(programNameInList);
//		javascriptClick(programNameInList);		
//		javascriptClick(programMedicationsTab);
//		javascriptClick(programMedicationAddButton);

	}

	public void CreateNewProgram() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickCareProgramTab);
		javascriptClick(careProgramTabs);
		javascriptClick(programTabText);
		javascriptClick(programAddButton);
		javascriptClick(programSupportedCodeSystem);
		javascriptClick(icdProgramSupportedCodeSystem);
	}

	public void clickOnMedicationAddButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programMedicationsTab);
		javascriptClick(programMedicationsTab);
		javascriptClick(programMedicationAddButton);
	}

	public void goToProgramTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickCareProgramTab);
		javascriptClick(careProgramTabs);
		javascriptClick(programTabText);

	}

	public void clickOnProgramSupportedCodeSystemDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programSupportedCodeSystem);
		javascriptClick(programSupportedCodeSystem);
	}

	public void clickOnNewCreatedProgram(String program) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programTabText);
		log("Program Name is : " + program);
		WebElement newProgram = driver.findElement(By.xpath("//label[text()='" + program + "']"));
		javascriptClick(newProgram);
	}

	public void selectIcdSupportedCodeSystem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, icdProgramSupportedCodeSystem);
		javascriptClick(icdProgramSupportedCodeSystem);
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

	public void clickOnProgramMedicationsTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programMedicationsTab);
		// waitForElement(driver, programMedicationsTab);
		javascriptClick(programMedicationsTab);
	}

	public void clickOnProgramMedicationAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programMedicationAddButton);
		// waitForElement(driver, programMedicationAddButton);
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
			BasePageObject.waitForElement(driver, medicationAddEditDeleteButtonDisplay);
			isPresent = medicationAddEditDeleteButtonDisplay.isDisplayed();
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

	public void clickOnMedicationAddEditHowOftenDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnMedicationAddEditHowOftenDropdown);
		// waitForElement(driver, clickOnMedicationAddEditHowOftenDropdown);
		Actions act = new Actions(driver);
		act.click(clickOnMedicationAddEditHowOftenDropdown).build().perform();
	}

	public void enterTextInMedicationSearchTextbox(String text) {
		log("Adding appointment Subject");
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditMedicineNameTextbox);
		// waitForElement(driver, medicationAddEditMedicineNameTextbox);
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
		waitUntilElementIsVisible(programMedicationsTab);
		log("medication Name is : " + AtomHC.medicationName);
		WebElement medicationList = driver.findElement(By.xpath("//label[text()='" + AtomHC.medicationName + "']"));
		javascriptClick(medicationList);
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
			waitUntilElementIsVisible(medicationAddEditAssignForDayTextbox);
			// waitForElement(driver, medicationAddEditAssignForDayTextbox);
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
			waitUntilElementIsVisible(medicationAddEditShowForDayTextbox);
			// waitForElement(driver, medicationAddEditShowForDayTextbox);
			medicationAddEditShowForDayTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnMedicationAddEditCancelButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditCancelButton);
		// waitForElement(driver, medicationAddEditCancelButton);
		javascriptClick(medicationAddEditCancelButton);
	}

	public String getMedicationListLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationListLabel);
		return medicationListLabel.getText();
	}

	public void clearTextInMedicationSearchTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditMedicineNameTextbox);
		// waitForElement(driver, medicationAddEditMedicineNameTextbox);
		medicationAddEditMedicineNameTextbox.clear();
	}

	public void clickOnMedicationNameTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditMedicineNameTextbox);
		// waitForElement(driver, medicationAddEditMedicineNameTextbox);
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

	public void clcikOnSearchIconInMedicationName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchIconInMedicationName);
		javascriptClick(searchIconInMedicationName);
	}

	public void clickOnMedicationAddEditUnitDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programSaveButton);
		// waitForElement(driver, medicationAddEditUnitDropdown);
		javascriptClick(unitDropdownTabletselect);
	}

	public void selectUnitDropdownTabletselect() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitDropdownTabletselect);
		javascriptClick(unitDropdownTabletselect);
	}

	public void clickOnMedicationAddEditFrequencyTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditFrequencyTextbox);
		javascriptClick(medicationAddEditFrequencyTextbox);
	}

	public boolean isMedicationUnitTabletLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditUnitDropdown);
		// waitForElement(driver, medicationAddEditUnitDropdown);
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

	public void clickOnMedicationAddEditDosesTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicationAddEditDosesTextbox);
		// waitForElement(driver, medicationAddEditDosesTextbox);
		Actions action = new Actions(driver);
		action.click(medicationAddEditDosesTextbox).build().perform();
		// javascriptClick(medicationAddEditDosesTextbox);
	}

	public boolean isMedicationDosesField(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(medicationAddEditDosesTextbox);
			// waitForElement(driver, medicationAddEditDosesTextbox);
			medicationAddEditDosesTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMedicationFrequencyField(String Value) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(medicationAddEditFrequencyTextbox);
			// waitForElement(driver, medicationAddEditFrequencyTextbox);
			medicationAddEditFrequencyTextbox.sendKeys(Value);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgramSaveButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(programSaveButton);
		// waitForElement(driver, programSaveButton);
		javascriptClick(programSaveButton);
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

	public String getMedicationAddEditAssignForErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditAssignForErrorMessage);
		return medicationAddEditAssignForErrorMessage.getText();
	}

	public void clickOnProgramAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, programAddButton);
		javascriptClick(programAddButton);
	}

	public void searchProgramName(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchProgram);
		searchProgram.sendKeys(value);
	}

	public void enterProgramName(String program) {
		log("Adding appointment Subject");
		TestConfig.PrintMethodName();
		// waitUntilElementIsVisible(clickOnProgramName);
		waitForElement(driver, clickOnProgramName);
		clickOnProgramName.sendKeys(program);
	}

	public void saveNewMedication(String textName) throws Exception {
		log("Adding appointment Subject");
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnProgramName);
		medicationAddEditMedicineNameTextbox.sendKeys(textName);
		javascriptClick(searchIconInMedicationName);
		medicationAddEditDosesTextbox.sendKeys(textName);
		javascriptClick(unitDropdownTabletselect);
		javascriptClick(unitDropdownTabletselect);
		javascriptClick(medicationAddEditDosesTextbox);
		javascriptClick(clickOnMedicationAddEditHowOftenDropdown);
		javascriptClick(programMedicationDailyDropdownLabel);
		medicationAddEditAssignForDayTextbox.sendKeys(textName);
		medicationAddEditShowForDayTextbox.sendKeys(textName);
		javascriptClick(programSaveButton);
	}

	public void clickOnMedicationAddEditSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddEditSaveButton);
		Actions act = new Actions(driver);
		act.click(medicationAddEditSaveButton).build().perform();
	}

}
