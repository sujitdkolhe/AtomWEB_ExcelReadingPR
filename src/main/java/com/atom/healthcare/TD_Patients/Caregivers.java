package com.atom.healthcare.TD_Patients;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Caregivers extends BasePageObject {
	

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

	@FindBy(how = How.ID, using = "CaregiversView")
	private WebElement caregiverTab;

	@FindBy(how = How.CSS, using = "label.lbl-primary-text-header-3-semi-bold.col-xl-7.col-md-6.col-sm-12")
	private WebElement caregiversHeader;

	@FindBy(how = How.ID, using = "CaregiversViewAddActionKey")
	private WebElement addCaregiverButton;

	@FindBy(how = How.XPATH, using = "//input[@id='CaregiversViewIsPopupCaregiverKeyinput-text']")
	private WebElement selectCaregiverInput;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeydate")
	private WebElement fromDateKeydatePicker;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupEndDateKeydate")
	private WebElement endDateKeydatePicker;

	@FindBy(how = How.XPATH, using = "(//button[@class='next'])[2]")
	private WebElement nextMonth;

	@FindBy(how = How.ID, using = "CaregiversViewSaveActionKey")
	private WebElement caregiverSaveButton;

	@FindBy(how = How.ID, using = "CaregiversViewSearchTextKey")
	private WebElement caregiverSearchTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][1]")
	private WebElement columnName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][2]")
	private WebElement columnDepartment;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][3]")
	private WebElement columnProgram;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][4]")
	private WebElement columnFromDate;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][5]")
	private WebElement columnEndDate;

	@FindBy(how = How.ID, using = "CaregiversViewerrorLabel")
	private WebElement noRecordFoundErrorLabel;

	@FindBy(how = How.XPATH, using = "//div[@id='CaregiversViewtable-row0'][1]")
	private WebElement firstCaregiver;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement addeditPageHeader;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crossIcon;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement organisationLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupOrganisationKeyinput-text")
	private WebElement organisationDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement branchLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement branchInput;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement departmentLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement departmentInput;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement caregiverLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement fromDateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement endDateLabel;

	@FindBy(how = How.ID, using = "CaregiversViewCancelActionKey")
	private WebElement caregiverCancelButton;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupOrganisationKeyinput-text")
	private WebElement organizationSelected;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement branchSelected;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement departmentSelected;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupCaregiverKeyinput-text")
	private WebElement caregiverSelected;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeydatePicker")
	private WebElement fromDateSelected;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupEndDateKeydatePicker")
	private WebElement endDateSelected;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement caregiverDeleteButton;

	@FindBy(how = How.XPATH, using = "//div[@class='table d-flex justify-content-between flex-wrap no-border ltr']")
	private WebElement caregiverListPage;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupBranchKeyListItems']/li")
	private List<WebElement> caregiverbranchList;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[5]")
	private WebElement caregiverFirstBranch;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupCaregiverKeyListItems']/li")
	private List<WebElement> caregiverList;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	private WebElement firstDept;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupCaregiverKeyerrorLabel")
	private WebElement caregiverErrorLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeyerrorLabel")
	private WebElement caregiverFromDateErrorLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupEndDateKeyerrorLabel")
	private WebElement caregiverEndDateErrorLabel;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupDepartmentKeyListItems']/li")
	private List<WebElement> caregiverDepartmentList;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeyerrorLabel")
	private WebElement fromDateErrorMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	private WebElement patientfirstCaregiver;

	@FindBy(how = How.XPATH, using = "//p[text()='Are you sure you want to delete?']")
	private WebElement deletePoPUpDisplay;

	@FindBy(how = How.ID, using = "CaregiversViewOkActionKey")
	private WebElement caregiverOkButton;

	@FindBy(how = How.XPATH, using = "(//button[@id='CaregiversViewCancelActionKey'])[3]")
	private WebElement deleteCancelButton;
	
	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeydate")
	private WebElement caregiverFromDate;
	
	@FindBy(how = How.ID, using = "CaregiversViewIsPopupEndDateKeydate")
	private WebElement caregiverEndDate;
	
	
	
	public Caregivers(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButton);
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

	public void clickOnNewAddedPatient(String patientName) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(newAddedPatient);
		WebElement patient=driver.findElement(By.xpath("//label[text()='"+patientName+"']"));
		waitForElement(driver, patient);
		javascriptClick(patient);
	}

	public void clickOnCaregiverTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(caregiverTab);
		waitForElement(driver, caregiverTab);
		javascriptClick(caregiverTab);
	}

	public String getCaregiverHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiversHeader);
		return caregiversHeader.getText();
	}

	public void clickOnAddCaregiverButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addCaregiverButton);
		javascriptClick(addCaregiverButton);
	}

	public void addNewPatientCaregiver(String caregiverName, int currentDay, int currentDate, int addDays)
			throws InterruptedException {
		log("Adding new Caregiver ");
		TestConfig.PrintMethodName();
		waitForElement(driver, addCaregiverButton);
		javascriptClick(addCaregiverButton);
		javascriptClick(selectCaregiverInput);
		Thread.sleep(3000);
		selectCaregiverInput.clear();
		selectCaregiverInput.sendKeys(caregiverName);
		log("user name is : " + caregiverName);
		Thread.sleep(10000);
		WebElement userName = driver.findElement(By.xpath("//li[text()='" + caregiverName + "']"));
		waitForElement(driver, userName);
		javascriptClick(userName);
		try {
		log("Current Date " + currentDay);
		Actions action = new Actions(driver);
		action.click(fromDateKeydatePicker).build().perform();
		WebElement selectFromDate = driver.findElement(By.xpath(
				"(//div[@class='datepicker-days']/div[@class='days']/div/button[text()='" + currentDay + "'])[1]"));
		action.click(selectFromDate).build().perform();
		WebElement selectEndDate = null;
		Actions act = new Actions(driver);
		act.click(endDateKeydatePicker).build().perform();
		}catch(Exception e) {
			long addDt = 24 * 60 * 60 * 1000 * currentDate;
			String yyyymmdd=BasePageObject.getDate_yyyy_mm_dd(addDt);
			String[] getDate=yyyymmdd.split("-");
			String yyyy=getDate[0];
			String mm=getDate[1];
			String dd=getDate[2];
			caregiverFromDate.sendKeys(mm);
			caregiverFromDate.sendKeys(dd);
			caregiverFromDate.sendKeys(yyyy);
			
			long addDate = 24 * 60 * 60 * 1000 * addDays;
			String getFutureDate=BasePageObject.getDate_yyyy_mm_dd(addDate);
			String[] futureDate=getFutureDate.split("-");
			System.out.println("getFutureDate "+getFutureDate);
			String year=futureDate[0];
			String month=futureDate[1];
			String date=futureDate[2];
			caregiverEndDate.sendKeys(month);
			caregiverEndDate.sendKeys(date);
			caregiverEndDate.sendKeys(year);
		}
		javascriptClick(caregiverSaveButton);
	}

	public boolean isCaregiverSearchBoxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSearchTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, caregiverSearchTextbox);
			isPresent = caregiverSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSearchboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSearchTextbox);
		return caregiverSearchTextbox.getAttribute("placeholder");
	}

	public boolean isAddCaregiverButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addCaregiverButton);
			isPresent = addCaregiverButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNameColumnHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, columnName);
		return columnName.getText();
	}

	public String getPositionColumnHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, columnDepartment);
		return columnDepartment.getText();
	}

	public String getProgramColumnHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, columnProgram);
		return columnProgram.getText();
	}

	public String getFromDateColoumnHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, columnFromDate);
		return columnFromDate.getText();
	}

	public String getEndDateColoumnHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, columnEndDate);
		return columnEndDate.getText();
	}

	public boolean isNoRecordFoundTextDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordFoundErrorLabel);
		boolean isPresent = false;
		try {
			waitForElement(driver, noRecordFoundErrorLabel);
			isPresent = noRecordFoundErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void enterTextInCaregiverSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSearchTextbox);
		caregiverSearchTextbox.sendKeys(text);
	}

	public boolean isSearchElementDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(firstCaregiver);
			waitForElement(driver, firstCaregiver);
			isPresent = firstCaregiver.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearCaregiverSearchBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSearchTextbox);
		caregiverSearchTextbox.clear();
	}

	public boolean isCaregiverAddEditHeaderDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addeditPageHeader);
		boolean isPresent = false;
		try {
			waitForElement(driver, addeditPageHeader);
			isPresent = addeditPageHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnFirstCaregiverRowlist() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstCaregiver);
		javascriptClick(firstCaregiver);
	}

	public String getCaregiverAddEditPageHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addeditPageHeader);
		return addeditPageHeader.getText();
	}

	public boolean isCaregiverCrossIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, crossIcon);
			isPresent = crossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrganisationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organisationLabel);
		return organisationLabel.getText();
	}

	public boolean isOrganisationDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organisationDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, organisationDropdown);
			isPresent = organisationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBranchLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchLabel);
		return branchLabel.getText();
	}

	public boolean isBranchDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, branchInput);
			isPresent = branchInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDepartmentLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, departmentLabel);
		return departmentLabel.getText();
	}

	public boolean isDepartmentDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, departmentInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentInput);
			isPresent = departmentInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverLabel);
		return caregiverLabel.getText();
	}

	public boolean isCaregiverDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectCaregiverInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, selectCaregiverInput);
			isPresent = selectCaregiverInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFromDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fromDateLabel);
		return fromDateLabel.getText();
	}

	public boolean isFromDateDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fromDateKeydatePicker);
		boolean isPresent = false;
		try {
			waitForElement(driver, fromDateKeydatePicker);
			isPresent = fromDateKeydatePicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEndDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endDateLabel);
		return endDateLabel.getText();
	}

	public boolean isEndDateDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endDateKeydatePicker);
		boolean isPresent = false;
		try {
			waitForElement(driver, endDateKeydatePicker);
			isPresent = endDateKeydatePicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSaveButton);
		return caregiverSaveButton.getText();
	}

	public boolean isCaregiverSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSaveButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, caregiverSaveButton);
			isPresent = caregiverSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverCancelButton);
		return caregiverCancelButton.getText();
	}

	public boolean isCaregiverCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverCancelButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, caregiverCancelButton);
			isPresent = caregiverCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrganisationsSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, organizationSelected);
		return organizationSelected.getAttribute("value");
	}

	public String getBranchSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, branchSelected);
		return branchSelected.getAttribute("value");
	}

	public String getDepartmentSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, departmentSelected);
		return departmentSelected.getAttribute("value");
	}

	public String getCaregiverSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, caregiverSelected);
		return caregiverSelected.getAttribute("value");
	}

	public String getFromDateSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, caregiverFromDate);
		return caregiverFromDate.getAttribute("value");
	}

	public String getEndDateSelected() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, caregiverEndDate);
		return caregiverEndDate.getAttribute("value");
	}

	public boolean isCaregiverDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, caregiverDeleteButton);
			isPresent = caregiverDeleteButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnCaregiverCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIcon);
		javascriptClick(crossIcon);
	}

	public boolean isCaregiverListPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverListPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, caregiverListPage);
			isPresent = caregiverListPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnCaregiverCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverCancelButton);
		javascriptClick(caregiverCancelButton);
	}

	public void clickOnCaregiverBranchDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchInput);
		Actions ac = new Actions(driver);
		ac.sendKeys(branchInput, Keys.ENTER).build().perform();
	}

	public List<String> getCaregiverbranchList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : caregiverbranchList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnCaregiverFirstBranchDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchInput);
		Actions ac = new Actions(driver);
		Thread.sleep(10000);
		ac.sendKeys(branchInput, Keys.ENTER).build().perform();
		ac.sendKeys(caregiverFirstBranch, Keys.ENTER).build().perform();
	}

	public void clickOnCaregiverDeptDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, departmentInput);
		Actions ac = new Actions(driver);
		ac.sendKeys(departmentInput, Keys.ENTER).build().perform();
	}

	public List<String> getcaregiverFirstBranchDepartmentList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : caregiverDepartmentList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnCaregiverDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(selectCaregiverInput);
		waitForElement(driver, selectCaregiverInput);
		Actions ac = new Actions(driver);
		ac.sendKeys(selectCaregiverInput, Keys.ENTER).build().perform();
	}

	public List<String> getcaregiverList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(caregiverList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : caregiverList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnFirstDept() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstDept);
		javascriptClick(firstDept);
	}

	public void clickOnCaregiverSaveButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(caregiverSaveButton);
		waitForElement(driver, caregiverSaveButton);
		javascriptClick(caregiverSaveButton);
	}

	public String getCaregiverErrorTextboxColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverErrorLabel);
		String cssValue = caregiverErrorLabel.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getCaregiverErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverErrorLabel);
		return caregiverErrorLabel.getText();
	}

	public String getFromDateErrorTextboxColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverFromDateErrorLabel);
		String cssValue = caregiverFromDateErrorLabel.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getFromDateErrorMessageText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverFromDateErrorLabel);
		return caregiverFromDateErrorLabel.getText();
	}

	public String getEndDateErrorTextboxColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverEndDateErrorLabel);
		String cssValue = caregiverEndDateErrorLabel.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getEndDateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverEndDateErrorLabel);
		return caregiverEndDateErrorLabel.getText();
	}

	public String getFromDateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fromDateErrorMessage);
		String cssValue = fromDateErrorMessage.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isNewlyAddedCaregiverDisplaying() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstCaregiver);
		boolean isPresent = false;
		try {
			waitForElement(driver, firstCaregiver);
			isPresent = firstCaregiver.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientCaregiver() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientfirstCaregiver);
		return patientfirstCaregiver.getText();
	}

	public void clickOnCaregiverDeleteButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverDeleteButton);
		javascriptClick(caregiverDeleteButton);
	}

	public String getDeletePoPUpMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePoPUpDisplay);
		return deletePoPUpDisplay.getText();
	}

	public void clickOnCancelButtonOnDeletePopUp() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(deleteCancelButton);
		waitForElement(driver, deleteCancelButton);
		deleteCancelButton.click();
	}

	public void clickOnCaregiverOkButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverOkButton);
		javascriptClick(caregiverOkButton);
	}

	public boolean isPatientCaregiverDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(patientfirstCaregiver);
			waitForElement(driver, patientfirstCaregiver);
			isPresent = patientfirstCaregiver.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCaregiverFromDateColor(String caregiverName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[3]/label")));
		WebElement caregiver = driver
				.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[3]/label"));
		String getColor = caregiver.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public String getCaregiverName(String caregiver) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+caregiver+"']")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+caregiver+"']"));
		return patientName.getText();
	}
	
	public String getFromDate(String caregiver) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+caregiver+"']")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+caregiver+"']/following-sibling::label[3]"));
		return patientName.getText().trim();
	}
	
	public String getEndDate(String caregiver) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+caregiver+"']")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+caregiver+"']/following-sibling::label[4]"));
		return patientName.getText().trim();
	}
	
	public String getCaregiverEndDateColor(String caregiverName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[4]/label")));
		WebElement caregiver = driver
				.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[4]/label"));
		String getColor = caregiver.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public boolean isCaregiverDisplay(String caregiver) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + caregiver + "']")));
			WebElement caregiverName = driver.findElement(By.xpath("//label[text()='" + caregiver + "']"));
			isPresent = caregiverName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

}
