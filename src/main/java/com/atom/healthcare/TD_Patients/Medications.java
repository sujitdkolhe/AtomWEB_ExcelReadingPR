package com.atom.healthcare.TD_Patients;

import java.util.ArrayList;
import java.util.LinkedList;
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

public class Medications extends BasePageObject {

	public Medications(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-bottom-lg'])[1]")
	private WebElement newAddedPatient;

	@FindBy(how = How.XPATH, using = "//li[@id='PatientMedicationsView']/span")
	private WebElement patientMedicationTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement patientMedicationHeader;

	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.ID, using = "PatientMedicationsViewAddActionKey")
	private WebElement patientMedicationAddButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[1]")
	private WebElement medicatioNameTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[1]")
	private WebElement dosesTextbox;

	@FindBy(how = How.XPATH, using = "//li[text()='Tablet']")
	private WebElement unitTablet;

	@FindBy(how = How.ID, using = "frequencyOptionslabel564")
	private WebElement daily;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-primary padding-horizontal-md margin-horizontal-md float-right']")
	private WebElement medicationSaveButton;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyinput-text")
	private WebElement firstNameInput;

	@FindBy(how = How.XPATH, using = "//label[@id='PatientMedicationsViewNoDataFoundKey']")
	private WebElement noMedicineFound;

	@FindBy(how = How.XPATH, using = "//input[@id='PatientMedicationsViewSearchTextKey']")
	private WebElement patientMedicationSearchTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[2]")
	private WebElement frequencyTextbox;

	@FindBy(how = How.XPATH, using = "(//button[@class='next'])[2]")
	private WebElement nextMonth;

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

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "(//label[@class='badge-success truncate'])[1]")
	private WebElement openStatus;
	@FindBy(how = How.XPATH, using = "//label[text()='Patientngvku kaif']")
	private WebElement medicationPatient;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column'])[1]")
	private WebElement firstMedicine;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientMedicationsView09eecab8-1ca2-439e-bcea-e7f9d6bfba88'])")
	private WebElement thirdMedicine;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])[1]")
	private WebElement getMedicineName;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular text-start truncate'])[1]")
	private WebElement dosesName;

	@FindBy(how = How.XPATH, using = "//img[@src='images/Medication-list-icon.svg']")
	private WebElement medicineIcon;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-secondary-text-body-medium-regular truncate']")
	private WebElement medicineEndDate;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[10]")
	private WebElement measurementValue;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column'])[2]")
	private WebElement searchedMedicine;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement getMedicationAddEditTitle;

	@FindBy(how = How.XPATH, using = "//div[@id='dosesUnit']/div/input")
	private WebElement unitDropdown;

	@FindAll(@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])[1]"))
	private List<WebElement> newAddedMedicine;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[1]")
	private WebElement medicationAddEditHeader;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement xIconDisplay;

	@FindBy(how = How.XPATH, using = "//div[@id='frequencyOptions']/div/input")
	private WebElement howOftenDropdown;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationStartDateKeydate")
	private WebElement medicationFromDatePlaceholder;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationEndDateKeydate")
	private WebElement medicationEndDatePlaceholder;

	@FindBy(how = How.XPATH, using = "//textarea[@class='input-primary mb-0 pt-2  ltr']")
	private WebElement noteTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Doses']")
	private WebElement dosesLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Unit']")
	private WebElement unitLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Frequency']")
	private WebElement frequencyLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='How often']")
	private WebElement howOftenLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='From date']")
	private WebElement medicationFromDateLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='End date']")
	private WebElement medicationEndDateLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Medicine name']")
	private WebElement medicineNameLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Note']")
	private WebElement noteLabel;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='frequencyOptionsListItems']/li"))
	private List<WebElement> howOftenDropdownList;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='dosesUnitListItems']/li"))
	private List<WebElement> unitDropdownList;

	@FindBy(how = How.XPATH, using = "//input[@id='PatientMedicationsViewIsPopupMedicationStartDateKeydatePicker']")
	private WebElement medicationPrefilledFromDate;

	@FindBy(how = How.XPATH, using = "//input[@id='PatientMedicationsViewIsPopupMedicationEndDateKeydatePicker']")
	private WebElement medicationPrefilledEndDate;

	@FindBy(how = How.ID, using = "PatientMedicationsViewCancelActionKey")
	private WebElement medicationCancelButton;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded error-border ltr']")
	private WebElement medicationNameErrorTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary error-border ltr'])[1]")
	private WebElement dosesErrorTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary error-border ltr'])[2]")
	private WebElement frequencyErrorTextbox;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-select error-border ltr']")
	private WebElement howOftenErrorTextbox;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationStartDateKeyerrorLabel")
	private WebElement medicationFromDateErrorTextbox;

	@FindBy(how = How.XPATH, using = "PatientMedicationsViewIsPopupMedicationEndDateKeyerrorLabel")
	private WebElement medicationEndDateErrorTextbox;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicineNameKeyerrorLabel")
	private WebElement medicationNameErrorMessage;

	@FindBy(how = How.ID, using = "entryDoseserrorLabel")
	private WebElement dosesErrorMessage;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crossIcon;

	@FindBy(how = How.ID, using = "entryFrequencyerrorLabel")
	private WebElement frequencyErrorMessage;

	@FindBy(how = How.ID, using = "frequencyOptionserrorLabel")
	private WebElement howOftenErrorMessage;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationStartDateKeyerrorLabel")
	private WebElement medicationFromDateErrorMessage;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationEndDateKeyerrorLabel")
	private WebElement medicationEndDateErrorMessage;

	@FindBy(how = How.XPATH, using = "//label[text()='Added by']")
	private WebElement medicationAddedByLabel;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupAddedByKeyinput-text")
	private WebElement medicationAddedByTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='MasterPageLogout']")
	private WebElement logOut;

	@FindBy(how = How.XPATH, using = "//label[text()='raju tej']")
	private WebElement patient;

	@FindBy(how = How.XPATH, using = "//li[text()='Alternate for']")
	private WebElement alternateFor;

	@FindBy(how = How.XPATH, using = "//label[text()='Alternate for']")
	private WebElement alternateForLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	private WebElement alternateForTextbox;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationStartDateKeydate")
	private WebElement medicationFromDate;

	@FindBy(how = How.ID, using = "PatientMedicationsViewIsPopupMedicationEndDateKeydate")
	private WebElement medicationEndDate;

	@FindBy(how = How.XPATH, using = "//label[text()='Rahul Khan']")
	private WebElement medicationPatientName;

	@FindBy(how = How.XPATH, using = "//label[text()='Benadryl Nightime']")
	private WebElement patientMedicineName;

	@FindBy(how = How.ID, using = "PatientsViewSearchTextKey")
	private WebElement searchTextBox;

	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void clickOnNewAddedPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newAddedPatient);
		javascriptClick(newAddedPatient);
	}

	public void clickOnPatientMedicationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationTab);
		javascriptClick(patientMedicationTab);
	}

	public String getPatientMedicationHeader() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientMedicationHeader);
		waitForElement(driver, patientMedicationHeader);
		return patientMedicationHeader.getText();
	}

	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}

	public void clickOnPatientMedicationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationAddButton);
		javascriptClick(patientMedicationAddButton);
	}

	public void addMedicineName(String medicine) {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		medicatioNameTextbox.sendKeys(medicine);
	}

	public void addDoses(String doses) {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesTextbox);
		dosesTextbox.sendKeys(doses);
	}

	public void selectTablet() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitTablet);
		javascriptClick(unitTablet);
	}

	public void addFrequency(String frequency) {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyTextbox);
		frequencyTextbox.sendKeys(frequency);
	}

	public void selectDaily() {
		TestConfig.PrintMethodName();
		waitForElement(driver, daily);
		javascriptClick(daily);
	}

	public void addNewMedication(String medicineName, String doses, String frequency, int currentDate, int addDays)
			throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		medicatioNameTextbox.sendKeys(medicineName);
		dosesTextbox.sendKeys(doses);

		// javascriptClick(unitTablet);
		frequencyTextbox.sendKeys(frequency);
		javascriptClick(daily);

		long addDt = 24 * 60 * 60 * 1000 * currentDate;
		String yyyymmdd = BasePageObject.getDate_yyyy_mm_dd(addDt);
		String[] getDate = yyyymmdd.split("-");
		String yyyy = getDate[0];
		String mm = getDate[1];
		String dd = getDate[2];
		medicationFromDate.sendKeys(mm);
		medicationFromDate.sendKeys(dd);
		medicationFromDate.sendKeys(yyyy);

		long addDate = 24 * 60 * 60 * 1000 * addDays;
		String getFutureDate = BasePageObject.getDate_yyyy_mm_dd(addDate);
		String[] futureDate = getFutureDate.split("-");
		System.out.println("getFutureDate " + getFutureDate);
		String year = futureDate[0];
		String month = futureDate[1];
		String date = futureDate[2];
		medicationEndDate.sendKeys(month);
		medicationEndDate.sendKeys(date);
		medicationEndDate.sendKeys(year);
		javascriptClick(medicationSaveButton);
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

	public String getNoRecordFoundTextInMedicine() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noMedicineFound);
		return noMedicineFound.getText();
	}

	public boolean isPatientMedicationSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationSearchTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientMedicationSearchTextbox);
			isPresent = patientMedicationSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationSearchTextbox);
		return patientMedicationSearchTextbox.getAttribute("placeholder");
	}

	public boolean isPatientMedicationAddButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationAddButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientMedicationAddButton);
			isPresent = patientMedicationAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOpenStatusDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, openStatus);
		boolean isPresent = false;
		try {
			waitForElement(driver, openStatus);
			isPresent = openStatus.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnMedicationPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationPatient);
		javascriptClick(medicationPatient);
	}

	public boolean isSearchedMedicineDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchedMedicine);
		boolean isPresent = false;
		try {
			waitForElement(driver, searchedMedicine);
			isPresent = searchedMedicine.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearMedicineInSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationSearchTextbox);
		patientMedicationSearchTextbox.clear();
	}

	public void enterMedicineInSearchTextbox(String medicine) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicationSearchTextbox);
		patientMedicationSearchTextbox.sendKeys(medicine);
	}

	public String getMedicationAddEditTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMedicationAddEditTitle);
		return getMedicationAddEditTitle.getText();
	}

	public void clickOnFirstMedicine() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstMedicine);
		javascriptClick(firstMedicine);
	}

	public void clickOnThirdMedicine() {
		TestConfig.PrintMethodName();
		waitForElement(driver, thirdMedicine);
		javascriptClick(thirdMedicine);
	}

	public String getFirstMedicineName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getMedicineName);
		return getMedicineName.getText();
	}

	public String getthirdMedicineName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, thirdMedicine);
		return thirdMedicine.getText();
	}

	public String getMedicineName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		return medicatioNameTextbox.getAttribute("medicine");
	}

	public void clearMedicine() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		medicatioNameTextbox.clear();
	}

	public void clickOnMedicineTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		javascriptClick(medicatioNameTextbox);
	}

	public void clickOnUnitDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitDropdown);
		Actions act = new Actions(driver);
		act.click(unitDropdown).build().perform();
	}

	public boolean isMedicationTextboxNotEditable(String medicine) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicatioNameTextbox);
			medicatioNameTextbox.sendKeys(medicine);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDosesName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesName);
		return dosesName.getText();
	}

	public String getMedicineEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicineEndDate);
		return medicineEndDate.getText();
	}

	public boolean isMedicineIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicineIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, medicineIcon);
			isPresent = medicineIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMedicationSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationSaveButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationSaveButton);
			isPresent = medicationSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNewAddedMedicine() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new LinkedList<String>();
		String medicine = null;
		for (WebElement o : newAddedMedicine) {
			dropDownList.add(o.getText());
			medicine = dropDownList.get(0);

		}
		return medicine;
	}

	public String getMedicationAddEditHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noteTextbox);
		return medicationAddEditHeader.getText();
	}

	public boolean isXIconButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, xIconDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, xIconDisplay);
			isPresent = xIconDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getMedicineNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicineNameLabel);
		return medicineNameLabel.getText();
	}

	public String getMedicineNameTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicatioNameTextbox);
		return medicatioNameTextbox.getAttribute("placeholder");
	}

	public String getDosesTextboxPlacholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesTextbox);
		return dosesTextbox.getAttribute("placeholder");
	}

	public String getUnitTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitDropdown);
		return unitDropdown.getAttribute("placeholder");
	}

	public String getFrequencyTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyTextbox);
		return frequencyTextbox.getAttribute("placeholder");
	}

	public String getHowOftenTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenDropdown);
		return howOftenDropdown.getAttribute("placeholder");
	}

	public String getMedicationFromDateTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationFromDatePlaceholder);
		return medicationFromDatePlaceholder.getAttribute("placeholder");
	}

	public String getMedicationEndDateTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationEndDatePlaceholder);
		return medicationEndDatePlaceholder.getAttribute("placeholder");
	}

	public String getNoteTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noteTextbox);
		return noteTextbox.getAttribute("placeholder");
	}

	public String getDosesLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesLabel);
		return dosesLabel.getText();
	}

	public String getUnitLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitLabel);
		return unitLabel.getText();
	}

	public String getFrequencyLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyLabel);
		return frequencyLabel.getText();
	}

	public String getHowOftenLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenLabel);
		return howOftenLabel.getText();
	}

	public String getMedicationFromDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationFromDateLabel);
		return medicationFromDateLabel.getText();
	}

	public String getMedicationEndDateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationEndDateLabel);
		return medicationEndDateLabel.getText();
	}

	public String getNoteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noteLabel);
		return noteLabel.getText();
	}

	public void clickOnHowOftenDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenDropdown);
		Actions act = new Actions(driver);
		act.click(howOftenDropdown).build().perform();
	}

	public List<String> getHowOftenDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : howOftenDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public List<String> getUnitDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : unitDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getPrefilledMedicineName() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(medicatioNameTextbox);
		waitForElement(driver, medicatioNameTextbox);
		return medicatioNameTextbox.getAttribute("value");
	}

	public String getPrefilledDoses() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesTextbox);
		return dosesTextbox.getAttribute("value");
	}

	public String getPrefilledUnit() {
		TestConfig.PrintMethodName();
		waitForElement(driver, unitDropdown);
		return unitDropdown.getAttribute("value");
	}

	public String getPrefilledFrequency() {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyTextbox);
		return frequencyTextbox.getAttribute("value");
	}

	public String getPrefilledHowOften() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenDropdown);
		return howOftenDropdown.getAttribute("value");
	}

	public String getMedicationPrefilledFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationPrefilledFromDate);
		return medicationPrefilledFromDate.getAttribute("value");
	}

	public String getMedicationPrefilledEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationPrefilledEndDate);
		return medicationPrefilledEndDate.getAttribute("value");
	}

	public void clickOnMedicationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationCancelButton);
		javascriptClick(medicationCancelButton);
	}

	public void clickOnMedicationCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIcon);
		javascriptClick(crossIcon);
	}

	public void clickOnMedicationSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationSaveButton);
		javascriptClick(medicationSaveButton);
	}

	public String isMedicineNameTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationNameErrorTextbox);
		String cssValue = medicationNameErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isDosesTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesErrorTextbox);
		String cssValue = dosesErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isFrequencyTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyErrorTextbox);
		String cssValue = frequencyErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isHowOftenTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenErrorTextbox);
		String cssValue = howOftenErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isMedicationFromDateTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationFromDateErrorTextbox);
		String cssValue = medicationFromDateErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isMedicationEndDateTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationEndDateErrorTextbox);
		String cssValue = medicationEndDateErrorTextbox.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getMedicationNameErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationNameErrorMessage);
		return medicationNameErrorMessage.getText();
	}

	public String getDosesErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dosesErrorMessage);
		return dosesErrorMessage.getText();
	}

	public String getFrequencyErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, frequencyErrorMessage);
		return frequencyErrorMessage.getText();
	}

	public String getHowOftenErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, howOftenErrorMessage);
		return howOftenErrorMessage.getText();
	}

	public String getMedicationFromDateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationFromDateErrorMessage);
		return medicationFromDateErrorMessage.getText();
	}

	public String getMedicationEndDateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationEndDateErrorMessage);
		return medicationEndDateErrorMessage.getText();
	}

	public void clickOnLogOut() {
		TestConfig.PrintMethodName();
		waitForElement(driver, logOut);
		javascriptClick(logOut);
	}

	public void clickOnExistingPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patient);
		javascriptClick(patient);
	}

	public String getmedicationAddedByLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddedByLabel);
		return medicationAddedByLabel.getText();
	}

	public boolean isMedicationAddedByTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddedByTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddedByTextbox);
			isPresent = medicationAddedByTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean ismedicationAddedByTextboxNotEditable(String medicine) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, medicationAddedByTextbox);
			medicationAddedByTextbox.sendKeys(medicine);
			return isPresent = true;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getmedicationAddedByName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationAddedByTextbox);
		return medicationAddedByTextbox.getAttribute("value");
	}

	public void clickOnAlternateFor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateFor);
		javascriptClick(alternateFor);
	}

	public String getAlternateForLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateForLabel);
		return alternateForLabel.getText();
	}

	public String getAlternateForPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateForTextbox);
		return alternateForTextbox.getAttribute("placeholder");
	}

	public boolean isAlternateForTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, alternateForTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, alternateForTextbox);
			isPresent = alternateForTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationName(String medication) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + medication + "']")));
		WebElement medicationName = driver.findElement(By.xpath("//label[text()='" + medication + "']"));
		return medicationName.getText();
	}

	public void clickOnMedicationName(String medication) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + medication + "']")));
		WebElement medicationName = driver.findElement(By.xpath("//label[text()='" + medication + "']"));
		javascriptClick(medicationName);
		// medicationName.click();
	}

	public String getMedicationFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationFromDatePlaceholder);
		return medicationFromDatePlaceholder.getAttribute("value");
	}

	public String getMedicationEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, medicationEndDatePlaceholder);
		return medicationEndDatePlaceholder.getAttribute("value");
	}

	public void clickOnMedicationCrossIcon(String medication) {
		TestConfig.PrintMethodName();
		waitForElement(driver, xIconDisplay);
		xIconDisplay.click();
	}

	public boolean isMedicationDisplay(String medication) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + medication + "']")));
			WebElement medicationName = driver.findElement(By.xpath("//label[text()='" + medication + "']"));
			isPresent = medicationName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getMedicationEndDateColor(String medicationName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver
				.findElement(By.xpath("//label[text()='" + medicationName + "']/following-sibling::label[4]/label")));
		WebElement medication = driver
				.findElement(By.xpath("//label[text()='" + medicationName + "']/following-sibling::label[4]/label"));
		String getColor = medication.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}

	public String getMedicationFromDateColor(String caregiverName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver
				.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[3]/label")));
		WebElement caregiver = driver
				.findElement(By.xpath("//label[text()='" + caregiverName + "']/following-sibling::label[3]/label"));
		String getColor = caregiver.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}

	public void clickOnPatientMedication(String patientName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		searchTextBox.sendKeys(patientName);
		waitForElement(driver, medicationPatientName);

		javascriptClick(medicationPatientName);
	}

	public void clickOnPatientMedicine() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMedicineName);
		javascriptClick(patientMedicineName);
	}

}
