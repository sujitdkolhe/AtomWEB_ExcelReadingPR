package com.atom.healthcare.TD_Users;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_UsersPage extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Users']")
	private WebElement usersTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold margin-bottom-md margin-top-xxs col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement usersTitle;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	private WebElement searchBox;

	@FindBy(how = How.ID, using = "UsersViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//*[text()='Dashboard']")
	private WebElement dashboardTitle;

	@FindBy(how = How.XPATH, using = "//img[@class='icon-left img-icon-medium ltr']")
	private WebElement searchIcon;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-5-semi-bold text-center truncate']") })
	private List<WebElement> allUsers;

	@FindBy(how = How.ID, using = "UserAddEditFirstNameKeyinput-text")
	private WebElement firstNameInput;

	@FindBy(how = How.ID, using = "UserAddEditLastNameKeyinput-text")
	private WebElement lastNameInput;
	
	@FindBy(how = How.ID, using = "UserAddEditMiddleNameKeyinput-text")
	private WebElement middleNameInput;

	@FindBy(how = How.XPATH, using = "//div[@id='UserAddEditGenderKey']/div/input")
	private WebElement genderInput;

	@FindBy(how = How.ID, using = "UserAddEditGenderKeylabel195")
	private WebElement male;

	@FindBy(how = How.ID, using = "UserAddEditGenderKeylabel196")
	private WebElement female;

	@FindBy(how = How.ID, using = "UserAddEditGenderKeylabel197")
	private WebElement neutral;

	@FindBy(how = How.ID, using = "UserAddEditRolesKeyinput-text")
	private WebElement roles;

	@FindBy(how = How.ID, using = "UserAddEditRolesKeylabel3")
	private WebElement adminRole;

	@FindBy(how = How.ID, using = "UserAddEditProfessionKeyinput-text")
	private WebElement profession;

	@FindBy(how = How.ID, using = "UserAddEditProfessionKeylabel28")
	private WebElement selectProfession;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumberInput;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.ID, using = "UserAddEditDateOfJoiningdate")
	private WebElement dateOfJoining;

	@FindBy(how = How.XPATH, using = "//button[@class='prev']")
	private WebElement clickOnPreviousForCalender;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular']/following::input)[1]")
	private WebElement uploadProfileImage;

	@FindBy(how = How.ID, using = "UserAddEditSaveActionKey")
	private WebElement saveButton;

	@FindBy(how = How.XPATH, using = "//label[text()='david miller']/following-sibling::label")
	private WebElement GenderAndProf;

	@FindBy(how = How.XPATH, using = "(//label[text()='david miller']/following::span[@class='lbl-primary-text-body-medium-semi-bold'])[1]")
	private WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "(//label[text()='david miller']/following::span[@class='lbl-primary-text-body-medium-semi-bold'])[2]")
	private WebElement emailId;

	@FindBy(how = How.XPATH, using = "(//label[text()='Admin'])[1]")
	private WebElement admin;

	@FindBy(how = How.ID, using = "UsersViewNoDataFoundKey")
	private WebElement noRecordFoundMessage;

	@FindBy(how = How.XPATH, using = "(//label[text()='User add/edit'])")
	private WebElement userAddEditPage;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement cancelButton;

	@FindBy(how = How.XPATH, using = "//label[text()='Basic information']")
	private WebElement basicInformationLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Profile image']")
	private WebElement profileImageLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-regular']")
	private WebElement imageFileUploadInput;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'First name')]")
	private WebElement firstNameLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Last name')]")
	private WebElement lastNameLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Gender')]")
	private WebElement genderLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'DOJ')]")
	private WebElement DOJLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Organisation')]")
	private WebElement organisationLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Roles')]")
	private WebElement rolesLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Profession')]")
	private WebElement professionLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Mobile Number')]")
	private WebElement mobileNumberLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,'Email')]")
	private WebElement emailLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Organisation']")
	private WebElement orginizationDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Branch']")
	private WebElement branchDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Department']")
	private WebElement departmentDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Profession']")
	private WebElement professionDropdown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobNumberDropdown;

	@FindBy(how = How.ID, using = "UserAddEditMobileNumberKeycode_dropdown")
	private WebElement mobileNumbKeycode;

	@FindBy(how = How.XPATH, using = "//label[text()='Branch']")
	private WebElement branchLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Department']")
	private WebElement departmentLabel;

	@FindBy(how = How.ID, using = "UserViewSendActivationAgainKey")
	private WebElement resendActivationButton;

	@FindBy(how = How.ID, using = "UserViewDeleteActionKey")
	private WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//label[@class='badge-done-empty ltr']")
	private WebElement profssion;

	@FindBy(how = How.XPATH, using = "//span[text()='DM']")
	private WebElement userInitial;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold truncate ltr']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold d-flex ltr']")
	private WebElement userGender;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold d-flex col-lg-3 px-0 col-md-5 ltr']")
	private WebElement userProfession;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs text-truncate ltr'])[2]")
	private WebElement userMobileNum;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs text-truncate ltr'])[1]")
	private WebElement userEmailId;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First name']")
	private WebElement fNameInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last name']")
	private WebElement lNameInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Gender'] ")
	private WebElement genderInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='MMM d yyyy']")
	private WebElement dOJInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Roles']")
	private WebElement rolesInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Profession']")
	private WebElement profInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInputTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Organisation']")
	private WebElement organizationTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-regular text-start']")
	private WebElement userImageErrorMessage;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='UserAddEditGenderKeyListItems']/li") })
	private List<WebElement> defaultGenderDropdownList;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement organizationDropdown;

	@FindBy(how = How.ID, using = "UserAddEditOrganisationKeyinput-text")
	private WebElement organizationFields;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='UserAddEditBranchKeyListItems']/li") })
	private List<WebElement> userBranchList;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='UserAddEditDepartmentKeyListItems']/li") })
	private List<WebElement> userDepartmentList;

	@FindBy(how = How.XPATH, using = "//li[@id='UserAddEditBranchKeylabel837']")
	private WebElement selectBranch;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Roles']")
	private WebElement rolesDropdown;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='UserAddEditRolesKeyListItems']/li") })
	private List<WebElement> userRolesList;

	@FindBy(how = How.ID, using = "UserAddEditFirstNameKeyerrorLabel")
	private WebElement userFirstNameErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditLastNameKeyerrorLabel")
	private WebElement userLastNameErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditGenderKeyerrorLabel")
	private WebElement userGenderErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditDateOfJoiningerrorLabel")
	private WebElement userDOJErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditRolesKeyerrorLabel")
	private WebElement userRolesErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditProfessionKeyerrorLabel")
	private WebElement userProfErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditMobileNumberKeyerrorLabel")
	private WebElement userMobileNumErrorLabel;

	@FindBy(how = How.ID, using = "UserAddEditEmailAddressKeyerrorLabel")
	private WebElement userEmailErrorLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement deletePopupLabel;

	@FindBy(how = How.XPATH, using = "//p[text()='Are you sure you want to delete?']")
	private WebElement deletePopupConfirmationLabel;

	@FindBy(how = How.ID, using = "UserViewCancelActionKey")
	private WebElement deletePopupCancelButton;

	@FindBy(how = How.ID, using = "UserViewOkActionKey")
	private WebElement deletePopupOkButton;

	@FindBy(how = How.ID, using = "//div[@id='UserViewDeleteActionKey']/div/img")
	private WebElement deletePopupCloseButton;

	@FindBy(how = How.ID, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement userNameOnUserPage;

	@FindBy(how = How.XPATH, using = "//div[@id='UserAddEditGenderKey']/div/input")
	private WebElement genderInputBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Gender']")
	private WebElement genderInputText;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='New password']")
	private WebElement newPasswordText;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded  ltr']")
	private WebElement newPasswordBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Confirm password']")
	private WebElement confirmPasswordText;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded  ltr']")
	private WebElement confirmPasswordBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Verification Code']")
	private WebElement verificationTextbox;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerifyActionKey")
	private WebElement verifyButton;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[1]")
	private WebElement newPasswordTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[2]")
	private WebElement confirmPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//button[@id='SetNewPasswordViewSetButtonKey']")
	private WebElement setButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,username)])[1]")
	private WebElement newUserName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Email/Phone Number']")
	private WebElement newUserNameTextbox;

	@FindBy(how = How.ID, using = "LoginViewLoginActionKey")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'][contains(.,Password)])[2]")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Password']")
	private WebElement passwordTextbox;

	@FindBy(how = How.XPATH, using = "//label[@for='LoginViewRememberMeKeycheckbox']")
	private WebElement rememberMeCheckbox;

	@FindBy(how = How.ID, using = "PinCodeViewPinCodeKeyinput-text")
	private WebElement pincodeInputTextbox;

	@FindBy(how = How.ID, using = "PinCodeViewConfirmPinCodeKeyinput-text")
	private WebElement confirmPincodeTextboxLabel;

	@FindBy(how = How.XPATH, using = "//button[@id='PinCodeViewSetButtonKey']")
	private WebElement pinSetButton;

	@FindBy(how = How.ID, using = "UserAddEditFirstNameKeyerrorLabel")
	private WebElement firstNameRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditLastNameKeyerrorLabel")
	private WebElement lastNameRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditGenderKeyerrorLabel")
	private WebElement genderRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditDateOfJoiningerrorLabel")
	private WebElement DOJRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditRolesKeyerrorLabel")
	private WebElement rolesRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditProfessionKeyerrorLabel")
	private WebElement professionRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditMobileNumberKeyerrorLabel")
	private WebElement phoneNoRequiredLabel;

	@FindBy(how = How.ID, using = "UserAddEditEmailAddressKeyerrorLabel")
	private WebElement emailRequiredLabel;

	@FindBy(how = How.ID, using = "SetNewPasswordViewNewPasswordKeyerrorLabel")
	private WebElement newPassErrorMessage;

	@FindBy(how = How.ID, using = "SetNewPasswordViewConfirmPasswordKeyerrorLabel")
	private WebElement confirmPassErrorMessage;

	@FindBy(how = How.ID, using = "SetNewPasswordViewSetButtonKey")
	private WebElement resetPageSetButton;

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuPatientsView")
	private WebElement patientTab;

	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement patientTabAddButton;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientTabSaveButton;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyerrorLabel")
	private WebElement patientAddEditFirstNameKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyerrorLabel")
	private WebElement patientAddEditGenderKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditLastNameKeyerrorLabel")
	private WebElement patientAddEditLastNameKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeyerrorLabel")
	private WebElement patientAddEditDateOfBirthKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditBloodGroupKeyerrorLabel")
	private WebElement patientAddEditBloodGroupKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditPreferredLanguageKeyerrorLabel")
	private WebElement patientAddEditPreferredLanguageKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditMobileNumberKeyerrorLabel")
	private WebElement patientAddEditMobileNumberKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditEmailAddressKeyerrorLabel")
	private WebElement patientAddEditEmailAddressKeyerrorLabel;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyinput-text")
	private WebElement patientFirstNameTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditLastNameKeyinput-text")
	private WebElement patientLastNameTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyinput-text")
	private WebElement patientGenderTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeydatePicker")
	private WebElement patientDOBTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditBloodGroupKeyinput-text")
	private WebElement patientBloodGroupTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditPreferredLanguageKeyinput-text")
	private WebElement patientPreferredLanguageTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditMobileNumberKeyphone_text")
	private WebElement patientMobileTextbox;

	@FindBy(how = How.ID, using = "PatientAddEditEmailAddressKeyinput-text")
	private WebElement patientEmailTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold margin-bottom-md margin-top-xxs col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement patientTabLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs']")
	private WebElement dashboardLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold pb-3']")
	private WebElement pincodeSetupLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold pb-3']")
	private WebElement twoFactorAuthenticationLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Pincode setup']")
	private WebElement setNewPassowrdLabel;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerificationKeyinput-text")
	private WebElement registrationTwoFactorAuthentication;

	@FindBy(how = How.XPATH, using = "(//div[@class='container text-center'])[1]")
	private WebElement loginLabel;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement pincodeSetUpConfirmPincodeLabel;
	
	@FindBy(how = How.ID, using = "UserAddEditDateOfJoiningdate")
	private WebElement DOBInput;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement genderDropdown;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='margin-bottom-lg']/img)[1]")
	private WebElement prifileImage;

	public TD_UsersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnUserTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, usersTab);
		javascriptClick(usersTab);
	}

	public String getUserTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, usersTitle);
		return usersTitle.getText();
	}

	public boolean isUserSearchBoxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, searchBox);
			isPresent = searchBox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAddButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addButton);
			isPresent = addButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDashboardTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dashboardTitle);
		return dashboardTitle.getText();
	}

	public boolean isSearchIconDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, searchIcon);
			isPresent = searchIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAllUesrDisplay() {
		TestConfig.PrintMethodName();
		boolean isDisplay = false;
		for (int i = 0; i < allUsers.size(); i++) {
			isDisplay = allUsers.get(i).isDisplayed();
			if (isDisplay == false) {
				log("User's list was not found");
				break;
			}
		}
		return isDisplay;
	}

	public void clickOnAddButton()  {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}

	public void createUser(String fName, String midName,String lName, String gender, String DOJ, String role, String prof,String mobNumber,String email)
			throws InterruptedException {
		log("Adding user details");
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		firstNameInput.sendKeys(fName);
		middleNameInput.sendKeys(midName);
		lastNameInput.sendKeys(lName);
		javascriptClick(genderInput);
		log("Add Gender: " + gender);
		WebElement selectGender = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		javascriptClick(selectGender);
		scrollAndWait(0, 500, 2);
		log("Select date of joining");
		setDOJ(DOJ);
		javascriptClick(roles);
		log("Add Role: " + role);
		WebElement roles = driver.findElement(By.xpath("//li[text()='" + role + "']"));
		javascriptClick(roles);
		javascriptClick(profession);
		log("Add Profession: " + prof);
		WebElement profession = driver.findElement(By.xpath("//li[text()='" + prof + "']"));
		javascriptClick(profession);
		mobileNumberInput.sendKeys(mobNumber);
		emailInput.sendKeys(email);
		javascriptClick(saveButton);
	}

	public void uploadProfileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver, uploadProfileImage);
		uploadProfileImage.sendKeys(image);
	}

	public boolean isUserImageDisplay(String usrName) {
		TestConfig.PrintMethodName();
		try {
			waitUntilElementIsVisible(driver
					.findElement(By.xpath("(//label[text()='" + usrName + "']/parent::div/div/img)[1]")));
			WebElement userImage = driver
					.findElement(By.xpath("(//label[text()='" + usrName + "']/parent::div/div/img)[1]"));
			userImage.isDisplayed();
			return true;
		} catch (Exception e) {
			log("User image not visible to patient");
			return false;
		}
	}

	public boolean isUserDisplay(String usrName) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			WebElement userImage = driver.findElement(By.xpath("(//label[text()='" + usrName + "'])[1]"));
			waitForElement(driver, userImage);
			isPresent = userImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getGenderAndProf() {
		TestConfig.PrintMethodName();
		waitForElement(driver, GenderAndProf);
		return GenderAndProf.getText();
	}

	public String getMobileNumber() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumber);
		return mobileNumber.getText();
	}

	public String getEmailId() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailId);
		return emailId.getText();
	}

	public String getAdminText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, admin);
		return admin.getText();
	}

	public void enterTextInUserSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(searchBox);
		waitForElement(driver, searchBox);
		searchBox.sendKeys(text);
	}

	public void clearUserSearchBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchBox);
		searchBox.clear();
	}

	public boolean isUsersDisplay(String Users) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(driver.findElement(By.xpath("//label[text()='" + Users + "']")));
			WebElement userImage = driver.findElement(By.xpath("//label[text()='" + Users + "']"));
			waitForElement(driver, userImage);
			isPresent = userImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getNoRecordFoundErrorMessage(String Users) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			WebElement userImage = driver.findElement(By.xpath("//label[text()='" + Users + "']"));
			waitForElement(driver, userImage);
			isPresent = userImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNoRecordFoundMessage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(noRecordFoundMessage);
		waitForElement(driver, noRecordFoundMessage);
		return noRecordFoundMessage.getText();
	}

	public String getUserAddEditPageText() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(userAddEditPage);
		waitForElement(driver, userAddEditPage);
		return userAddEditPage.getText();
	}

	public boolean isSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, saveButton);
			isPresent = saveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, cancelButton);
			isPresent = cancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBasicInfoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, basicInformationLabel);
		return basicInformationLabel.getText();
	}

	public String getProfileImageLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profileImageLabel);
		return profileImageLabel.getText();
	}

	public String getImageFileUploadInput() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imageFileUploadInput);
		return imageFileUploadInput.getText();
	}

	public String getFirstNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstNameLabel);
		return firstNameLabel.getText();
	}

	public String getLastNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lastNameLabel);
		return lastNameLabel.getText();
	}

	public String getGenderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderLabel);
		return genderLabel.getText();
	}

	public String getDOJLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, DOJLabel);
		return DOJLabel.getText();
	}

	public String getOrginizationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organisationLabel);
		return organisationLabel.getText();
	}

	public String getRolesLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rolesLabel);
		return rolesLabel.getText();
	}

	public String getProfessionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, professionLabel);
		return professionLabel.getText();
	}

	public String getMobileNumberLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberLabel);
		return mobileNumberLabel.getText();
	}

	public String getEmailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailLabel);
		return emailLabel.getText();
	}

	public boolean isFirstNameInputTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, firstNameInput);
			isPresent = firstNameInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isLastNameInputTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, lastNameInput);
			isPresent = lastNameInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isGenderDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, genderInput);
			isPresent = genderInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDateOfJoiningDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, dateOfJoining);
			isPresent = dateOfJoining.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrginizationDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, orginizationDropdown);
			isPresent = orginizationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBranchDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, branchDropdown);
			isPresent = branchDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDepartmentDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentDropdown);
			isPresent = departmentDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isRolesDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, roles);
			isPresent = roles.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isProfessionDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, professionDropdown);
			isPresent = professionDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMobNumberDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, mobNumberDropdown);
			isPresent = mobNumberDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isMobileNumbKeycodeDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, mobileNumbKeycode);
			isPresent = mobileNumbKeycode.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isEmailInputDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, emailInput);
			isPresent = emailInput.isDisplayed();
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

	public String getBranchLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchLabel);
		return branchLabel.getText();
	}

	public boolean isResendActivationButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, resendActivationButton);
			isPresent = resendActivationButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, deleteButton);
			isPresent = deleteButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getProfssionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profssion);
		return profssion.getText();
	}

	public String getUserInitial() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userInitial);
		return userInitial.getText();
	}

	public void clickOnUser(String userName) {
		TestConfig.PrintMethodName();
		WebElement user = driver.findElement(By.xpath("(//label[text()='" + userName + "'])[1]"));
		user.click();
	}

	public String getUserName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userName);
		return userName.getText();
	}

	public String getUserGender() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userGender);
		return userGender.getText();
	}

	public String getUserProfession() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userProfession);
		return userProfession.getText();
	}

	public String getUserMobNum() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userMobileNum);
		return userMobileNum.getText();
	}

	public String getUserEmailId() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userEmailId);
		return userEmailId.getText();
	}

	public boolean isfNameInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fNameInputTextbox);
		String fNameTextbox = fNameInputTextbox.getText();
		return fNameTextbox.isEmpty();
	}

	public boolean islNameInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lNameInputTextbox);
		String lNameInputbox = lNameInputTextbox.getText();
		return lNameInputbox.isEmpty();
	}

	public boolean isGenderInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderInputTextbox);
		String genderInputbox = genderInputTextbox.getText();
		return genderInputbox.isEmpty();
	}

	public boolean isDOJInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dOJInputTextbox);
		String dOJInputbox = dOJInputTextbox.getText();
		return dOJInputbox.isEmpty();
	}

	public boolean isRolesInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rolesInputTextbox);
		String rolesInputbox = rolesInputTextbox.getText();
		return rolesInputbox.isEmpty();
	}

	public boolean isProfessionInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profInputTextbox);
		String profInputbox = profInputTextbox.getText();
		return profInputbox.isEmpty();
	}

	public boolean isMobileNumInputboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumInputTextbox);
		String mobileInputBox = mobileNumInputTextbox.getText();
		return mobileInputBox.isEmpty();
	}

	public boolean isEmailInputTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInputTextbox);
		String emailInputbox = emailInputTextbox.getText();
		return emailInputbox.isEmpty();
	}

	public boolean isOrganizationTextboxEmpty() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationTextbox);
		String orgInputbox = organizationTextbox.getText();
		return orgInputbox.isEmpty();
	}

	public void clickOnCancel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButton);
		cancelButton.click();
	}

	public String getUserImageErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userImageErrorMessage);
		return userImageErrorMessage.getText();
	}

	public void clickOnGenderDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, genderInput);
			scrollAndWait(0, 400, 3000);
			genderInput.click();
		} catch (Exception e) {
			driver.navigate().refresh();
			scrollAndWait(0, 400, 3000);
			javascriptClick(genderInput);
		}

	}

	public List<String> getDefaultGenderDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : defaultGenderDropdownList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void selectGender(String gender) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//li[text()='" + gender + "']")));
		WebElement gendr = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		gendr.click();
	}

	public String getGender() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(genderInputText);
		waitForElement(driver, genderInputText);
		BasePageObject.waitForElement(driver, genderInputText);
		return genderInputText.getAttribute("value");
	}

	public void clickOnOrganizationDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationDropdown);
		Actions act = new Actions(driver);
		scrollAndWait(0, 500, 3);
		act.moveToElement(organizationDropdown).click().perform();
	}

	public String getOrganization() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationFields);
		return organizationFields.getText();
	}

	public void clickOnBranchDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchDropdown);
		Actions act = new Actions(driver);
		scrollAndWait(0, 500, 3);
		act.moveToElement(branchDropdown).click().perform();
	}

	public List<String> getBranchList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : userBranchList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public List<String> getDepartmentList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : userDepartmentList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void selectBranch() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectBranch);
		selectBranch.click();
	}

	public void clickOnDepartmentDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, departmentDropdown);
		Actions act = new Actions(driver);
		scrollAndWait(0, 500, 3);
		act.moveToElement(departmentDropdown).click().perform();
	}

	public void clickOnRolesDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, rolesDropdown);
		Actions act = new Actions(driver);
		scrollAndWait(0, 1000, 3);
		act.moveToElement(rolesDropdown).click().perform();
	}

	public List<String> getRolesList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : userRolesList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public String getUserFirstNameErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userFirstNameErrorLabel);
		return userFirstNameErrorLabel.getText();
	}

	public String getUserLastNameErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userLastNameErrorLabel);
		return userLastNameErrorLabel.getText();
	}

	public String getUserGenderErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userGenderErrorLabel);
		return userGenderErrorLabel.getText();
	}

	public String getUserDOJErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userDOJErrorLabel);
		return userDOJErrorLabel.getText();
	}

	public String getUserRolesErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userRolesErrorLabel);
		return userRolesErrorLabel.getText();
	}

	public String getUserMobileNumErrorLabel() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, userMobileNumErrorLabel);
		scrollIntoElement(userMobileNumErrorLabel, 2);
		return userMobileNumErrorLabel.getText();
	}

	public String getUserEmailErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userEmailErrorLabel);
		return userEmailErrorLabel.getText();
	}

	public String getUserProfErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, userProfErrorLabel);
		return userProfErrorLabel.getText();
	}

	public void clickOnSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveButton);
		javascriptClick(saveButton);
	}

	public void addUser(String fName, String lName, String gender, int date, String role, String prof,
			String mobileNumber, String email) throws InterruptedException {
		log("Adding user details");
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		firstNameInput.sendKeys(fName);
		lastNameInput.sendKeys(lName);
		scrollAndWait(0, 200, 2000);
		genderDropdown.click();;
		log("Add Gender: " + gender);
		WebElement gen = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		gen.click();
		dateOfJoining.click();
		log("Select date of joining");
		clickOnPreviousForCalender.click();
		WebElement selectDate = driver.findElement(By.xpath("//button[text()='" + date + "']"));
		selectDate.click();
		roles.click();
		log("Add Role: " + role);
		WebElement roles = driver.findElement(By.xpath("//li[text()='" + role + "']"));
		roles.click();
		profession.click();
		log("Add Profession: " + prof);
		WebElement profession = driver.findElement(By.xpath("//li[text()='" + prof + "']"));
		profession.click();
		mobileNumberInput.sendKeys(mobileNumber);
		emailInput.sendKeys(email);
		javascriptClick(saveButton);
	}

	public void clearEmailInputBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		emailInput.clear();
	}

	public void enterUserEmail(String email) {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		emailInput.sendKeys(email);
	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		javascriptClick(deleteButton);
	}

	public boolean isDeletePopupLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, deletePopupLabel);
			isPresent = deletePopupLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDeleteConfirmationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePopupConfirmationLabel);
		return deletePopupConfirmationLabel.getText();
	}

	public boolean isDeletePopupCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, deletePopupCancelButton);
			isPresent = deletePopupCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDeletePopupNoButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, deletePopupOkButton);
			isPresent = deletePopupOkButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDeletePopupCloseButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, deletePopupCloseButton);
			isPresent = deletePopupCloseButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnDeletePopupCloseButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePopupCloseButton);
		deletePopupCloseButton.click();
	}

	public void clickOnDeletePopupOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePopupOkButton);
		deletePopupOkButton.click();
	}

	public void clickUserPageDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		deleteButton.click();
	}

	public void clickOnDeletePopupCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePopupCancelButton);
		javascriptClick(deletePopupCancelButton);
	}

	public String getUserMobileNum(String userName) {
		TestConfig.PrintMethodName();
		WebElement mobileNum = driver.findElement(By.xpath("(//label[text()='" + userName
				+ "']/following::span[@class='lbl-primary-text-body-medium-semi-bold'])[1]"));
		return mobileNum.getText();
	}

	public String getUserEmail(String userName) {
		TestConfig.PrintMethodName();
		WebElement emailId = driver.findElement(By.xpath("(//label[text()='" + userName
				+ "']/following::span[@class='lbl-primary-text-body-medium-semi-bold'])[2]"));
		return emailId.getText();
	}

	public void clickOnGenderDropdn() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderInputBox);
		javascriptClick(genderInputBox);
	}

	public void enterVerificationCodeInVerificationTextbox(String TwofactorCode) {
		TestConfig.PrintMethodName();
		waitForElement(driver, verificationTextbox);
		verificationTextbox.sendKeys(TwofactorCode);
		javascriptClick(registrationTwoFactorAuthentication);
	}

	public void clearVerificationTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(verificationTextbox);
		waitForElement(driver, verificationTextbox);
		verificationTextbox.clear();
	}

	public void enterNewpasswordTextbox(String Newpassword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPasswordTextbox);
		newPasswordTextbox.sendKeys("Newpassword");
	}

	public void enterconfirmPasswordTextbox(String confirmpassword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPasswordTextbox);
		confirmPasswordTextbox.sendKeys("confirmpassword");
		newPasswordTextbox.sendKeys("Newpassword");
	}

	public void clearconfirmPasswordTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPasswordTextbox);
		confirmPasswordTextbox.clear();
	}

	public void clearNewpasswordTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPasswordTextbox);
		newPasswordTextbox.clear();
	}

	public void login(String NewUser, String NewUserPass, String TwofactorCode) throws InterruptedException {
		waitForElement(driver, newUserName);
		newUserName.sendKeys(NewUser);
		passwordTextbox.sendKeys(NewUserPass);
		javascriptClick(rememberMeCheckbox);
		javascriptClick(loginButton);
		// buttonLogin.click();
		Thread.sleep(3000);
		verificationTextbox.sendKeys(TwofactorCode);
		// verifyButton.click();
		Thread.sleep(3000);
		PageFactory.initElements(driver, this);

	}

	public void clickOnVerifyButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(verifyButton);
		waitForElement(driver, verifyButton);
		javascriptClick(verifyButton);
	}

	public void enterConfirmPincodeTextboxLabel(String PinSet1) {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPasswordTextbox);
		confirmPasswordTextbox.sendKeys(PinSet1);
		javascriptClick(pinSetButton);
	}

	public void clearPincodeInputTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pincodeInputTextbox);
		pincodeInputTextbox.clear();
	}

	public void clickOnPinSetButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pinSetButton);
		javascriptClick(pinSetButton);
	}

	public void enterPincodeInputTextbox(String PinSet) {
		TestConfig.PrintMethodName();
		waitForElement(driver, pincodeInputTextbox);
		pincodeInputTextbox.sendKeys(PinSet);
	}

	public void clearConfirmPincodeTextboxLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPincodeTextboxLabel);
		confirmPincodeTextboxLabel.clear();
	}

	public void clickOnloginButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, loginButton);
		javascriptClick(loginButton);
	}

	public String getFirstNameRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstNameRequiredLabel);
		return firstNameRequiredLabel.getText();
	}

	public String getLastNameRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lastNameRequiredLabel);
		return lastNameRequiredLabel.getText();
	}

	public String getGenderRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderRequiredLabel);
		return genderRequiredLabel.getText();
	}

	public String getDOJRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, DOJRequiredLabel);
		return DOJRequiredLabel.getText();
	}

	public String getRolesRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rolesRequiredLabel);
		return rolesRequiredLabel.getText();
	}

	public String getProfessionRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, professionRequiredLabel);
		return professionRequiredLabel.getText();
	}

	public String getPhoneNoRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoRequiredLabel);
		return phoneNoRequiredLabel.getText();
	}

	public String getEmailRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailRequiredLabel);
		return emailRequiredLabel.getText();
	}

	public void clickOnNewpasswordTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(newPasswordTextbox);
		waitForElement(driver, newPasswordTextbox);
		javascriptClick(newPasswordTextbox);
	}

	public void clickOnConfirmPasswordText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPasswordText);
		javascriptClick(confirmPasswordText);
	}

	public void sendNewpasswordTextbox(String NewPass) {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPasswordTextbox);
		newPasswordTextbox.sendKeys(NewPass);
	}

	public void sendConfirmPasswordText(String ConfirmPass) {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPasswordText);
		confirmPasswordText.sendKeys(ConfirmPass);
	}

	public String getNewPassErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPassErrorMessage);
		return newPassErrorMessage.getText();
	}

	public String getConfirmPassErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, confirmPassErrorMessage);
		return confirmPassErrorMessage.getText();
	}

	public void clickOnResetPageSetButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, resetPageSetButton);
		javascriptClick(resetPageSetButton);
	}

	public void clickOnPatientTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTab);
		javascriptClick(patientTab);
	}

	public void clickOnPatientTabAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTabAddButton);
		javascriptClick(patientTabAddButton);
	}

	public void clickOnPatientTabSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTabSaveButton);
		javascriptClick(patientTabSaveButton);
	}

	public String getPatientAddEditFirstNameKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientAddEditFirstNameKeyerrorLabel);
		waitForElement(driver, patientAddEditFirstNameKeyerrorLabel);
		return patientAddEditFirstNameKeyerrorLabel.getText();
	}

	public String getPatientAddEditLastNameKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditLastNameKeyerrorLabel);
		return patientAddEditLastNameKeyerrorLabel.getText();
	}

	public String getPatientAddEditGenderKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditGenderKeyerrorLabel);
		return patientAddEditGenderKeyerrorLabel.getText();
	}

	public String getPatientAddEditDateOfBirthKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditDateOfBirthKeyerrorLabel);
		return patientAddEditDateOfBirthKeyerrorLabel.getText();
	}

	public String getPatientAddEditBloodGroupKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditBloodGroupKeyerrorLabel);
		return patientAddEditBloodGroupKeyerrorLabel.getText();
	}

	public String getPatientAddEditPreferredLanguageKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditPreferredLanguageKeyerrorLabel);
		return patientAddEditPreferredLanguageKeyerrorLabel.getText();
	}

	public String getPatientAddEditMobileNumberKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditMobileNumberKeyerrorLabel);
		return patientAddEditMobileNumberKeyerrorLabel.getText();
	}

	public String getPatientAddEditEmailAddressKeyerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAddEditEmailAddressKeyerrorLabel);
		return patientAddEditEmailAddressKeyerrorLabel.getText();
	}

	public void sendPatientFirstNameTextbox(String FirstName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientFirstNameTextbox);
		patientFirstNameTextbox.sendKeys(FirstName);
	}

	public void sendPatientLastNameTextbox(String LastName) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientLastNameTextbox);
		patientLastNameTextbox.sendKeys(LastName);
	}

	public void sendPatientpatientGenderTextbox(String Gender) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientGenderTextbox);
		patientGenderTextbox.sendKeys(Gender);
	}

	public void sendPatientDOBTextbox(String DOB) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientDOBTextbox);
		patientDOBTextbox.sendKeys(DOB);
	}

	public void sendPatientBloodGroupTextbox(String BloodGroup) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientBloodGroupTextbox);
		patientBloodGroupTextbox.sendKeys(BloodGroup);
	}

	public void sendPatientPreferredLanguageTextbox(String PreferredLanguage) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientPreferredLanguageTextbox);
		patientPreferredLanguageTextbox.sendKeys(PreferredLanguage);
	}

	public void sendPatientMobileTextbox(String Mobile) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMobileTextbox);
		patientMobileTextbox.sendKeys(Mobile);
	}

	public void sendPatientEmailTextbox(String Email) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEmailTextbox);
		patientEmailTextbox.sendKeys(Email);
	}

	public String getPatientTabLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientTabLabel);
		return patientTabLabel.getText();
	}


	public String getDashboardLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(dashboardLabel);
		waitForElement(driver, dashboardLabel);
		return dashboardLabel.getText();
	}

	public String getPincodeSetupLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pincodeSetupLabel);
		return pincodeSetupLabel.getText();
	}

	public String getTwoFactorAuthenticationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, twoFactorAuthenticationLabel);
		return twoFactorAuthenticationLabel.getText();
	}

	public String getSetPasswordPageLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(setNewPassowrdLabel);
		waitForElement(driver, setNewPassowrdLabel);
		return setNewPassowrdLabel.getText();
	}

	public String getLoginLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(loginLabel);
		waitForElement(driver, loginLabel);
		return loginLabel.getText();
	}
	public String getPincodeSetUpConfirmPincodeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pincodeSetUpConfirmPincodeLabel);
		return pincodeSetUpConfirmPincodeLabel.getText();
	}
	
	public void setDOB(String date,String month, String year) {
		TestConfig.PrintMethodName();
		waitForElement(driver, DOBInput);
		DOBInput.sendKeys(date);
		DOBInput.sendKeys(month);
		DOBInput.sendKeys(year);
	}
	
	public void setDOJ(String DOJ) {
		TestConfig.PrintMethodName();
		waitForElement(driver, DOBInput);
		log("Add DOJ");
		String[] dateOfBirth = DOJ.split("/");
		for (int i = 0; i < dateOfBirth.length; i++) {
			dateOfJoining.sendKeys(dateOfBirth[i]);
		}
	}
	
	public boolean isUserProfilePictureDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, prifileImage);
		boolean isPresent = false;
		try {
			waitForElement(driver, prifileImage);
			isPresent = prifileImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User profile is not visible");
			return isPresent;
		}
	}
	
	public boolean isUserNameDisplay(String name) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("(//label[text()='"+name+"'])[1]")));
			WebElement userName= driver.findElement(By.xpath("(//label[text()='"+name+"'])[1]"));
			isPresent = userName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User Name is not visible");
			return isPresent;
		}
	}
	
	public boolean isUserGenderAndProfDisplay(String gender, String profession) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("(//label[text()='"+gender+" | "+profession+"'])[1]")));
			WebElement Gender= driver.findElement(By.xpath("(//label[text()='"+gender+" | "+profession+"'])[1]"));
			isPresent = Gender.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User Gender and profession is not visible");
			return isPresent;
		}
	}
	
	public boolean isUserMobileNumberDisplay(String mobNumber) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("(//label[contains(.,'"+mobNumber+"')])[1]")));
			WebElement userName= driver.findElement(By.xpath("(//label[contains(.,'"+mobNumber+"')])[1]"));
			isPresent = userName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User mobile number is not visible");
			return isPresent;
		}
	}
	
	public boolean isUserEmailDisplay(String email) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("(//span[text()='"+email+"'])[1]")));
			WebElement emailId= driver.findElement(By.xpath("(//span[text()='"+email+"'])[1]"));
			isPresent = emailId.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User email is not visible");
			return isPresent;
		}
	}
	
}
