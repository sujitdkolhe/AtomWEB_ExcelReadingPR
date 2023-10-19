package com.atom.healthcare.TD_OrgnizationSetupWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_OrgnasationSetupPageWebElement extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Organization setup']")
	private WebElement orgSetupTitle;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Organisation name']")
	private WebElement organizationTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter domain']")
	private WebElement domainTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter GST']")
	private WebElement gstNumberTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Default Language']")
	private WebElement defaultLangTextbox;

	@FindBy(how = How.ID, using = "OrganisationSetupRegisterActionKey")
	private WebElement registerButton;

	@FindBy(how = How.ID, using = "OrganisationSetupOrganisationNameKeyerrorLabel")
	private WebElement orgNameTextboxErrorLabel;

	@FindBy(how = How.ID, using = "OrganisationSetupDomainKeyerrorLabel")
	private WebElement doaminTextboxErrorLabel;

	@FindBy(how = How.ID, using = "OrganisationSetupDefaultLanguageKeyerrorLabel")
	private WebElement defaultLangTextboxErrorLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[4]")
	private WebElement invalidCode;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary margin-top-sm w-available']")
	private WebElement verifyButton;

	@FindBy(how = How.ID, using = "OrganisationSetupDefaultLanguageKeylabel1")
	private WebElement defaultLang;

	@FindBy(how = How.ID, using = "OrganisationSetupLoginActionKey")
	private WebElement orgSetupLoginButton;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerificationKeyinput-text")
	private WebElement twoFactorCodeTextbox;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerifyActionKey")
	private WebElement twoFactorCodeVerifyButton;

	public TD_OrgnasationSetupPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnVerifyButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, verifyButton);
		verifyButton.click();
	}

	public void enterVerificationCode(String validOTP) {
		TestConfig.PrintMethodName();
		waitForElement(driver, invalidCode);
		invalidCode.sendKeys(validOTP);
	}

	public void registrationSetupDetails(String OrgName, String domainName, String dafaultLang)
			throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationTextbox);
		organizationTextbox.sendKeys(OrgName);
		domainTextbox.sendKeys(domainName);
		scrollAndWait(0, 2000, 0);
		javascriptClick(defaultLangTextbox);
		defaultLangTextbox.sendKeys(dafaultLang);
		javascriptClick(defaultLang);
		javascriptClick(registerButton);
	}

	public boolean isOrgSetupPageDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, orgSetupTitle);
			isPresent = orgSetupTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Orgnasation setup page is not visible");
			return isPresent;
		}
	}

	public void clearVerificationCode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, invalidCode);
		invalidCode.clear();
	}

	public boolean isOrgNameTexboxErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, orgNameTextboxErrorLabel);
			isPresent = orgNameTextboxErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Orgnasation name textbox error label is not visible");
			return isPresent;
		}
	}

	public boolean isDomainTexboxErrorLabelDIsplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, doaminTextboxErrorLabel);
			isPresent = doaminTextboxErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Domain textbox error label is not visible");
			return isPresent;
		}
	}

	public boolean isLanguageTexboxErrorLabelDIsplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, defaultLangTextboxErrorLabel);
			isPresent = defaultLangTextboxErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Domain textbox error label is not visible");
			return isPresent;
		}
	}

	public void clearDefaultLanguage() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, defaultLangTextbox);
		defaultLangTextbox.clear();
	}

	public void clearOrganisationDetails() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationTextbox);
		organizationTextbox.sendKeys(del);
		waitForElement(driver, domainTextbox);
		domainTextbox.sendKeys(del);
		waitForElement(driver, defaultLangTextbox);
		scrollAndWait(0, 2000, 0);
		defaultLangTextbox.sendKeys(del);
	}

	public void clickOnOrgSetupLoginButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgSetupLoginButton);
		orgSetupLoginButton.click();
	}

	public void registerSetupDetails(String OrgName, String domainName, String dafaultLang)
			throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationTextbox);
		organizationTextbox.sendKeys(OrgName);
		domainTextbox.sendKeys(domainName);
		scrollAndWait(0, 2000, 0);
		javascriptClick(registerButton);
	}

	public void enterTwoFactorCode(String twoFactor) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, twoFactorCodeTextbox);
		twoFactorCodeTextbox.sendKeys(twoFactor);
		javascriptClick(twoFactorCodeVerifyButton);
	}

	public void clickOntwoFactorAuth(String twoFactor) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, twoFactorCodeVerifyButton);
		for (int i = 0; i < 3; i++) {
			javascriptClick(twoFactorCodeTextbox);
			twoFactorCodeTextbox.clear();
			twoFactorCodeTextbox.sendKeys(twoFactor);
			javascriptClick(twoFactorCodeVerifyButton);
		}

	}

}