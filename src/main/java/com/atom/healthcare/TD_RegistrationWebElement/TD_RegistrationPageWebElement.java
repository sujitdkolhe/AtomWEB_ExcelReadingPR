package com.atom.healthcare.TD_RegistrationWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_RegistrationPageWebElement extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Register']")
	private WebElement registerTitle;

	@FindBy(how = How.ID, using = "RegistrationViewRegisterActionKey")
	private WebElement registerButton;

	@FindBy(how = How.ID, using = "RegistrationViewFirstNameKeyerrorLabel")
	private WebElement firstNameRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewLastNameKeyerrorLabel")
	private WebElement lastNameRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewEmailAddressKeyerrorLabel")
	private WebElement emailRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewMobileNumberKeyerrorLabel")
	private WebElement mobileNoRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewNewPasswordKeyerrorLabel")
	private WebElement newPasswordRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewConfirmPasswordKeyerrorLabel")
	private WebElement confirmPasswordRequiredLabel;

	@FindBy(how = How.ID, using = "RegistrationViewMobileNumberKeyerrorLabel")
	private WebElement mobileNoErrorMsg;

	@FindBy(how = How.XPATH, using = "//label[text()='Passwords do not match']")
	private WebElement passDoNotMatchLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Two-factor Authentication']")
	private WebElement twoFactorAuth;

	@FindBy(how = How.XPATH, using = "//label[text()='User already present']")
	private WebElement yourUsernameIsAlreadyPresentLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold padding-top-xs padding-bottom-xs']")
	private WebElement getInvalidOtpErrorMsg;

	@FindBy(how = How.CSS, using = "#RegistrationViewEmailAddressKey>input")
	private WebElement emailIdTextbox;

	@FindBy(how = How.ID, using = "RegistrationViewFirstNameKeyinput-text")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "RegistrationViewLastNameKeyinput-text")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "RegistrationViewEmailAddressKeyinput-text")
	private WebElement emailId;

	@FindBy(how = How.ID, using = "RegistrationViewMobileNumberKeyphone_text")
	private WebElement mobileNo;

	@FindBy(how = How.ID, using = "RegistrationViewNewPasswordKeyinput-text")
	private WebElement newPassword;

	@FindBy(how = How.ID, using = "RegistrationViewConfirmPasswordKeyinput-text")
	private WebElement confirmPass;

	public TD_RegistrationPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnRegisterButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, registerButton);
		javascriptClick(registerButton);
	}

	public void enterRegisterDetails(String FName, String LName, String email, String MobileNo, String NewPass,
			String ConfirmPass)  {
		TestConfig.PrintMethodName();
		firstName.sendKeys(FName);
		lastName.sendKeys(LName);
		emailId.sendKeys(email);
		mobileNo.clear();
		mobileNo.sendKeys(MobileNo);
		newPassword.sendKeys(NewPass);
		confirmPass.sendKeys(ConfirmPass);
	}

	public boolean isRegisterPageDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, registerTitle);
			isPresent = registerTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Register Title is not visible");
			return isPresent;
		}
	}

	public boolean isTwoFactorAuthenPopupDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, twoFactorAuth);
			isPresent = twoFactorAuth.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Two Factor AUthentication is not visible");
			return isPresent;
		}
	}

	public boolean isUserAlreadyPresentLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, yourUsernameIsAlreadyPresentLabel);
			isPresent = yourUsernameIsAlreadyPresentLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("User already present is not visible");
			return isPresent;
		}
	}

	public boolean isYourDataIsInvalidLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, emailRequiredLabel);
			isPresent = emailRequiredLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Your data is Invalid is not visible");
			return isPresent;
		}
	}

	public boolean isFirstNameRequiredLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, firstNameRequiredLabel);
			isPresent = firstNameRequiredLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("First name required label is not visible");
			return isPresent;
		}
	}

	public boolean isLastNameRequiredLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, lastNameRequiredLabel);
			isPresent = lastNameRequiredLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Last name Required label is not visible");
			return isPresent;
		}
	}

	public boolean isNewPasswordIsRequirdLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, newPasswordRequiredLabel);
			isPresent = newPasswordRequiredLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("New Password is Required label is not visible");
			return isPresent;
		}
	}

	public boolean isConfirmNameRequiredLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, confirmPasswordRequiredLabel);
			isPresent = confirmPasswordRequiredLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Confirm is Required label is not visible");
			return isPresent;
		}
	}

	public boolean isPasswordDoNotMatchLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, passDoNotMatchLabel);
			isPresent = passDoNotMatchLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Password do not match label is not visible");
			return isPresent;
		}
	}

	public boolean isInvalidOTPErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, getInvalidOtpErrorMsg);
			isPresent = getInvalidOtpErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Invalid OTP error message label is not visible");
			return isPresent;
		}
	}

	public boolean isMobileNumberErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, mobileNoErrorMsg);
			isPresent = mobileNoErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Invalid Mobile number error message label is not visible");
			return isPresent;
		}
	}

	public void clearRegisterDetails() {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		firstName.sendKeys(del);
		lastName.sendKeys(del);
		emailId.sendKeys(del);
		mobileNo.clear();
		mobileNo.sendKeys(del);
		newPassword.sendKeys(del);
		confirmPass.sendKeys(del);
	}
}
