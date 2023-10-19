package com.atom.healthcare.TD_LoginWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_LoginPageWebElement extends AlphaMDMainPage {

	@FindBy(how = How.XPATH, using = "//label[text()='Login']")
	private WebElement loginTitle;

	@FindBy(how = How.ID, using = "LoginViewRegisterActionKey")
	private WebElement registerButton;

	@FindBy(how = How.ID, using = "LoginViewUserNameKeyinput-text")
	private WebElement inputUserName;

	@FindBy(how = How.ID, using = "LoginViewPasswordKeyinput-text")
	private WebElement inputPassword;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	private WebElement buttonLogin;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded error-border ltr'])")
	private WebElement verificationCode;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerifyActionKey")
	private WebElement verifyButton;

	@FindBy(how = How.ID, using = "LoginViewLoginActionKey")
	private WebElement loginButton;

	@FindBy(how = How.ID, using = "LoginViewPasswordKeyerrorLabel")
	private WebElement passwordErrorLabel;

	@FindBy(how = How.ID, using = "LoginViewUserNameKeyerrorLabel")
	private WebElement usernameErrorLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-1-semi-bold w-available text-center'][contains(.,'Account is locked')]")
	private WebElement lockPopupTitle;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Verification Code']")
	private WebElement verifCode;

	@FindBy(how = How.ID, using = "LandingViewLoginActionKey")
	private WebElement loginBtn;

	@FindBy(how = How.ID, using = "//input[@placeholder='Verification Code']")
	private WebElement enterVerificationCode;

	@FindBy(how = How.ID, using = "//label[text()='Your data is invalid 1/3']")
	private WebElement yourDataIsInvalid;

	public TD_LoginPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public TD_LoginPageWebElement(WebDriver driver, String url) {
		super(driver, url);
		PageFactory.initElements(driver, this);
	}

	public void clickOnRegisterButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, registerButton);
		javascriptClick(registerButton);
	}

	public void clickOnLoginButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, loginButton);
		javascriptClick(loginButton);
	}

	public void clickOnVerifyButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(verifyButton);
		javascriptClick(verifyButton);
	}

	public void enterVerificationCode(String verificationKey) {
		TestConfig.PrintMethodName();
		waitForElement(driver, verifCode);
		verifCode.sendKeys(verificationKey);
	}

	public void clickOnLandingLogin() {
		TestConfig.PrintMethodName();
		waitForElement(driver, loginBtn);
		javascriptClick(loginBtn);
	}

	public void enterUsernameAndPass(String username, String password) {
		log("Enter username and password");
		waitForElement(driver, inputUserName);
		highlightElement(inputUserName);
		inputUserName.sendKeys(username);
		highlightElement(inputPassword);
		inputPassword.sendKeys(password);
	}

	public boolean isUsernameErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, usernameErrorLabel);
			isPresent = usernameErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Username error label is not visible");
			return isPresent;
		}
	}

	public boolean isPasswordErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, passwordErrorLabel);
			isPresent = passwordErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Password error label is not visible");
			return isPresent;
		}
	}

	public void clearloginDetails() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		inputUserName.sendKeys(del);
		inputPassword.sendKeys(del);
	}

	public boolean isYourDataIsInvalidLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, yourDataIsInvalid);
			isPresent = yourDataIsInvalid.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Your data is invalid error label is not visible");
			return isPresent;
		}
	}

	public boolean isLockPopupTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, lockPopupTitle);
			isPresent = lockPopupTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Lock popup is not visible");
			return isPresent;
		}
	}

	public void enterLoginDetails(String username, String password, String verificationKey)
			throws InterruptedException {
		log("Enter username and password");
		waitForElement(driver, inputUserName);
		highlightElement(inputUserName);
		inputUserName.sendKeys(username);
		highlightElement(inputPassword);
		inputPassword.sendKeys(password);
		javascriptClick(loginButton);
		waitForElement(driver, verifCode);
		verifCode.sendKeys(verificationKey);
		waitForElement(driver, verifyButton);
		javascriptClick(verifyButton);
	}
	
	public boolean isloginTitleLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, loginTitle);
			isPresent = loginTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Password error label is not visible");
			return isPresent;
		}
	}
}