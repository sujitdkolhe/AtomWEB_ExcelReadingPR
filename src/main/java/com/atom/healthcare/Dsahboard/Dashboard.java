package com.atom.healthcare.Dsahboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Dashboard extends BasePageObject{
	
	@FindBy(how= How.XPATH, using="//label[@class='margin-top-xxs lbl-primary-text-header-5-semi-bold text-center']")
	private WebElement orgnizationTitle;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs']")
	private WebElement dashboardTitle;
	
	@FindBy(how= How.XPATH, using="//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement noRecordMessage;
	
	@FindBy(how= How.ID, using="DashboardViewConfigureActionKey")
	private WebElement configureButton;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewRolesKeyinput-text")
	private WebElement rolesDropdown;

	@FindBy(how= How.ID, using="DashboardConfigurationViewRolesKeylabel3")
	private WebElement roleAdmin;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewAddActionKey")
	private WebElement addButton;
	
	@FindBy(how= How.XPATH, using="//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'][contains(.,'Patients')]")
	private WebElement patientsRowFeatures;
	
	@FindBy(how= How.XPATH, using="//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'][contains(.,'Caregivers')]")
	private WebElement caregiversRowFeatures;
	
	@FindBy(how= How.XPATH, using="//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'][contains(.,'Users')]")
	private WebElement usersRowFeatures;
	
	@FindBy(how= How.XPATH, using="(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[5]")
	private WebElement rowPatientSequenceNumber;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText1input-text")
	private WebElement usersParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText11input-text")
	private WebElement appointmentParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText3input-text")
	private WebElement caregiverParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText2input-text")
	private WebElement patientParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText13input-text")
	private WebElement tasksParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopuptableText10input-text")
	private WebElement chatsParameterValue;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewSaveActionKey")
	private WebElement saveButton;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewCancelActionKey")
	private WebElement cancelButton;
	
	@FindBy(how= How.ID, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Patients')]")
	private WebElement patientCount;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Users')]")
	private WebElement usersCount;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewDeleteActionKey")
	private WebElement deleteButton;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewSequenceNoKeyinput-text")
	private WebElement sequenceNo;
	
	@FindBy(how= How.XPATH, using="//input[@id='DashboardConfigurationViewIsPopupFeatureNameKeyinput-text']")
	private WebElement featuresDropdown;
	
	@FindBy(how= How.XPATH, using="(//li[@class='lbl-primary-text-body-large-regular ltr'][contains(.,'Appointments')])[1]")
	private WebElement appointmentsFeatures;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopupFeatureNameKeylabel56")
	private WebElement caregiversFeatures;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopupFeatureNameKeylabel36")
	private WebElement patientsFeatures;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopupFeatureNameKeylabel78")
	private WebElement chatsFeatures;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewIsPopupFeatureNameKeylabel142")
	private WebElement tasksFeatures;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Appointments')]")
	private WebElement appointmenttitle;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Patients')]")
	private WebElement patienttitle;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Chats')]")
	private WebElement chatstitle;
	
	@FindBy(how= How.ID, using="DashboardConfigurationViewOkActionKey")
	private WebElement okButton;
	
	@FindBy(how= How.XPATH, using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '][contains(.,'Appointments')]/parent::div//following-sibling::div[@class='table-row-1 w-available mx-2 mt-4']//label")
	private WebElement noRecordFoundAppointment;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 \"])[2]")
	private WebElement chatsTitle;
	
	@FindBy(how= How.XPATH, using="(//button[@id=\"DashboardViewShowMoreKey\"])[2]")
	private WebElement chatShowMoreButton;
	
	@FindBy(how= How.XPATH, using="(//div[@class=\"row px-0 mx-0 d-flex justify-content-center\"])[6]")
	private WebElement chatPatientProfileImg;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[5]")
	private WebElement chatPatientProfileName;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"lbl-secondary-text-body-medium-regular text-start truncate\"])[7]")
	private WebElement chatPatientMsg;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"badge-number truncate\"])[1]")
	private WebElement chatUnreadMsgBadgeCount;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[7]")
	private WebElement chatDetailViewPatient;
	
	@FindBy(how= How.XPATH, using="(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[10]")
	private WebElement patientChatDetailPage;
	
	@FindBy(how= How.XPATH, using="//label[@class=\"lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs\"]")
	private WebElement chatPageTitle;
	
	@FindBy(how= How.XPATH, using="(//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center'])[2]")
	private WebElement chatNoRecords;
	
	@FindBy(how= How.ID, using="LeftMenuOrganisationMenuDashboardView")
	private WebElement menuDashboardTab;

	
	public Dashboard(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getNoRecordMessageOfAppointment() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordFoundAppointment);
		return noRecordFoundAppointment.getText();
	}
	
	public String getDashboardTitleText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dashboardTitle);
		return dashboardTitle.getText();
	}
	
	public String getOrgnizationTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(orgnizationTitle);
		waitForElement(driver, orgnizationTitle);
		return orgnizationTitle.getText();
	}
	
	public String isNoRecordsFoundMessage () {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordMessage);
		return noRecordMessage.getText();
	}
	
	public void clickOnConfigureButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, configureButton);
		javascriptClick(configureButton);
	}
	
	public void clickOnRolesDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rolesDropdown);
		javascriptClick(rolesDropdown);
	}
	
	public void selectAdminRole() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(roleAdmin);
		waitForElement(driver, roleAdmin);
		javascriptClick(roleAdmin);
	}
	
	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButton);
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}
	
	public void clickOnPatientsFeaturesOfAdminRole() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsRowFeatures);
		javascriptClick(patientsRowFeatures);
	}
	
	public void clickOnUsersFeaturesOfAdminRole() {
		TestConfig.PrintMethodName();
		waitForElement(driver, usersRowFeatures);
		javascriptClick(usersRowFeatures);
	}
	
	public String getUsersCount() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(usersCount);
		waitForElement(driver, usersCount);
		return usersCount.getText();
	}
	
	public boolean isCaregiverFeaturesDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent=false;
		try {
			waitUntilElementIsVisible(caregiversRowFeatures);
			waitForElement(driver, caregiversRowFeatures);
			isPresent=caregiversRowFeatures.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void AddCaregiversFeaturesOfAdminRole(String seqNum, String paraNo) {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(addButton);
		javascriptClick(featuresDropdown);
		javascriptClick(caregiversFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seqNum);
		caregiverParameterValue.sendKeys(paraNo);
		javascriptClick(saveButton);
	}
	
	public void deleteCaregiversFeaturesOfAdminRole() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiversRowFeatures);
		javascriptClick(caregiversRowFeatures);
	}
	
	public void changeUsersParameterValue(String paramValue) {
		TestConfig.PrintMethodName();
		waitForElement(driver, usersParameterValue);
		usersParameterValue.clear();
		usersParameterValue.sendKeys(paramValue);
	}
	
	public void clickOnSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveButton);
		javascriptClick(saveButton);
	}
	
	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButton);
		javascriptClick(cancelButton);
	}
	
	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		javascriptClick(deleteButton);
	}
	
	public void deletePopupWindow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		javascriptClick(okButton);
	}
	
	public void clearSequenceNoTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, sequenceNo);
		sequenceNo.clear();
	}
	
	public void enterSequenceNoInTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, sequenceNo);
		sequenceNo.sendKeys("4");
	}
	
	public boolean isAppointmentTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent=false;
		try {
			waitUntilElementIsVisible(appointmenttitle);
			waitForElement(driver, appointmenttitle);
			isPresent=appointmenttitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isChatsTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent=false;
		try {
			waitForElement(driver, chatstitle);
			isPresent=chatstitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isPatientsTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent=false;
		try {
			waitForElement(driver, patienttitle);
			isPresent=patienttitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void changePatientSequenceNumber(String seqNo) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(sequenceNo);
		waitForElement(driver, sequenceNo);
		sequenceNo.clear();
		sequenceNo.sendKeys(seqNo);
		javascriptClick(saveButton);
	}
	
	public String getPatientSequenceNumber() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rowPatientSequenceNumber);
		return rowPatientSequenceNumber.getText();
	}
	
	public void clickOnFeaturesDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, featuresDropdown);
		javascriptClick(featuresDropdown);
	}
	
	public void createAppointmentFeatures(String seq1, String param1) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(featuresDropdown);
		waitForElement(driver, featuresDropdown);
		javascriptClick(featuresDropdown);
		javascriptClick(appointmentsFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seq1);
		appointmentParameterValue.sendKeys(param1);
		javascriptClick(saveButton);
	}
	
	public void createChatsFeatures(String seq2, String param2) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(featuresDropdown);
		waitForElement(driver, featuresDropdown);
		javascriptClick(featuresDropdown);
		javascriptClick(chatsFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seq2);
		chatsParameterValue.sendKeys(param2);
		javascriptClick(saveButton);
	}
	
	public void createPatientsFeatures(String seq3, String param3) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButton);
		waitForElement(driver, addButton);
		javascriptClick(featuresDropdown);
		javascriptClick(patientsFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seq3);
		patientParameterValue.sendKeys(param3);
		javascriptClick(saveButton);
	}
	
	public void createCaregiverFeatures(String seq4, String param4) {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(featuresDropdown);
		javascriptClick(caregiversFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seq4);
		caregiverParameterValue.sendKeys(param4);
		saveButton.click();
	}
	
	public void createTasksFeatures(String seq5, String param5) {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(featuresDropdown);
		javascriptClick(tasksFeatures);
		sequenceNo.clear();
		sequenceNo.sendKeys(seq5);
		tasksParameterValue.sendKeys(param5);
		saveButton.click();
	}
	
	public String getDashboardChatTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatsTitle);
		return chatsTitle.getText();
	}
	
	public boolean isChatShowMoreButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatShowMoreButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, chatShowMoreButton);
			isPresent = chatShowMoreButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnChatShowMoreButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatShowMoreButton);
		javascriptClick(chatShowMoreButton);
	}
	
	public boolean isChatPatientProfileImageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatPatientProfileImg);
		boolean isPresent = false;
		try {
			waitForElement(driver, chatPatientProfileImg);
			isPresent = chatPatientProfileImg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isChatPatientProfileNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatPatientProfileName);
		boolean isPresent = false;
		try {
			waitForElement(driver, chatPatientProfileName);
			isPresent = chatPatientProfileName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isChatPatientBadgeCountDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatUnreadMsgBadgeCount);
		boolean isPresent = false;
		try {
			waitForElement(driver, chatUnreadMsgBadgeCount);
			isPresent = chatUnreadMsgBadgeCount.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isChatMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatPatientMsg);
		boolean isPresent = false;
		try {
			waitForElement(driver, chatPatientMsg);
			isPresent = chatPatientMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnChatPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatDetailViewPatient);
		javascriptClick(chatDetailViewPatient);
	}
	
	public boolean isChatDetailPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatDetailPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientChatDetailPage);
			isPresent = patientChatDetailPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getChatPageTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatPageTitle);
		waitForElement(driver, chatPageTitle);
		return chatPageTitle.getText();
	}
	
	public String getChatNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatNoRecords);
		return chatNoRecords.getText();
	}

	public void clickOnDashboardMenuTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, menuDashboardTab);
		javascriptClick(menuDashboardTab);
	}
	
	public String getLatestChatPatientName() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatPatientProfileName);
		waitForElement(driver, chatPatientProfileName);
		return chatPatientProfileName.getText();
	}
}

