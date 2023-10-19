package com.atom.healthcare.Register.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Dsahboard.Dashboard;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.OrgnizationSetup.OrgnizationSetup;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.YopMail;

public class RegisterTests extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;

	@Test
	public void testUserLandsOnRegisterationPage() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		HealthcareLogin login= new HealthcareLogin(driver);
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		log("Verify if register title is displayed");
		assertEquals(register.getRegisterPageTitle(), AtomHC.propData.getProperty("register.page.title"),
				"register title not displayed");

	}

	@Test
	public void testRegistrationPageWithInvalidDetails() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		register.enterOrgnizationDeatils(AtomHC.propData.getProperty("firstname"),
				AtomHC.propData.getProperty("lastname"), AtomHC.propData.getProperty("emailid"),
				AtomHC.propData.getProperty("mobileno"), AtomHC.propData.getProperty("newpw"),
				AtomHC.propData.getProperty("confpw"));
		register.clickOnRegisterButton();
		log("Verify registration page field with invalid details");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(register.getFirstNameError(), AtomHC.propData.getProperty("first.name.error"),
				"error msg is wrong");
		softAssert.assertEquals(register.getLastNameError(), AtomHC.propData.getProperty("last.name.error"),
				"error msg is wrong");
		softAssert.assertEquals(register.getEmailError(), AtomHC.propData.getProperty("email.name.error"),
				"error msg is wrong");
		softAssert.assertEquals(register.getMobileNoError(), AtomHC.propData.getProperty("mob.no.error"),
				"error msg is wrong");
		softAssert.assertEquals(register.getNewPwError(), AtomHC.propData.getProperty("new.pw.error"),
				"error msg is wrong");
		softAssert.assertEquals(register.getConfirmPwError(), AtomHC.propData.getProperty("confirm.pw.error"),
				"error msg is wrong");
		softAssert.assertAll();

	}

	@Test
	public void testRegistrationPageWithValidDetails() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		log("Adding orgnization details");
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		log("Adding orgnization details");
		register.enterOrgnizationDeatils(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.new.pass"));
		register.clickOnRegisterButton();
		log("Verify if valid verification code is displayed");
		register.getVerificationCode(AtomHC.propData.getProperty("two.factor.verification.Code"));
		register.clickOnVerifyButton();
		assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");

	}

	@Test
	public void testEmailValidationCode() throws InterruptedException, IOException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		SoftAssert softAssert = new SoftAssert();
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("Verify if invalid verification error is displayed");
		register.getVerificationCode(AtomHC.propData.getProperty("invalid.verification.code"));
		register.clickOnVerifyButton();
		softAssert.assertEquals(register.getVerificationError(),
				AtomHC.propData.getProperty("Verification.key.error.label"), "Label is wrong");
		register.clickOnVerifCodeTextbox();
		register.clearVerifCodeTextbox();
		log("verify valid verification code");
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		log("verify if it is navigated to organisation setup page");
		softAssert.assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");
		softAssert.assertAll();

	}

	@Test(enabled=false)
	public void testOrganizationSetupWithInvalidDetails() throws InterruptedException, IOException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		SoftAssert softAssert = new SoftAssert();
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("verify valid verification code");
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		log("verify if it is navigated to organisation setup page");
		softAssert.assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");
		OrgnizationSetup org = new OrgnizationSetup(driver);
		org.enterOrgSetupDetails(AtomHC.propData.getProperty("org.name"), AtomHC.propData.getProperty("domain.name")+"trtrertr",
				AtomHC.propData.getProperty("gst.number.name"), AtomHC.propData.getProperty("default.lang.name"));
		softAssert.assertEquals(org.getLangErrorlabel(), AtomHC.propData.getProperty("default.lang.error"),
				"error msg is wrong");
		org.enterorgsetupDetails(AtomHC.propData.getProperty("select.lang.name"));
		org.clickOnRegisterButton();
//		softAssert.assertEquals(org.getSelectLangErrorlabel(), AtomHC.propData.getProperty("select.lang.error"),
//				"error msg is wrong");
		log("verify if error msg is getting displayed");
		softAssert.assertEquals(org.getDomainErrorlabel(), AtomHC.propData.getProperty("domain.error.label"),
				"error msg is wrong");
		softAssert.assertEquals(org.getTaxErrorlabel(), AtomHC.propData.getProperty("gst.error.label"),
				"error msg is wrong");
		softAssert.assertAll();

	}

	@Test(enabled=false)
	public void testUserEnteredAlreadyRegisteredDomain() throws InterruptedException, IOException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		log("verify if it is navigated to organisation setup page");
		softAssert.assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");
		OrgnizationSetup org = new OrgnizationSetup(driver);
		org.setOrganizationName(AtomHC.propData.getProperty("org.name.textbox"));
		org.setDopmainName(AtomHC.propData.getProperty("domain.error.msg"));
		org.setGSTNumber(AtomHC.propData.getProperty("GST.number"));
		org.clickOnDefaultLangDropdown();
		org.getLangDropdownValue();
		org.clickOnSelectLangDropdown();
		org.clickOnOrgRegisterBtn();
		log("Verify if error msg is getting displayed");
		softAssert.assertEquals(register.getDuplicateDataError(), AtomHC.propData.getProperty("error.domain.msg"),
				"error msg not displayed");
		softAssert.assertAll();

	}

	@Test
	public void testEnteredValidOrgnizationDetails() throws InterruptedException, IOException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		log("verify if it is navigated to organisation setup page");
		softAssert.assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		BasePageObject basePageObj = new BasePageObject(driver);
		String orgnizationName = "AlphaMD" + BasePageObject.createRandomCharacter(4);
		String domainName = "www.medical" + BasePageObject.createRandomCharacter(4) + ".com";
		log("Orgnization Name: " + orgnizationName + "    Domain Name: " + domainName);
		orgSetup.enterRegistrationSetupDetails(orgnizationName, domainName, basePageObj.generatRandomNum(), 2, 4);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.getOrginizationName();
		log("verify after registration user lands on dashboard page");
		Dashboard dashboardPage = new Dashboard(driver);
		log("Page Title is " + dashboardPage.getDashboardTitleText());
		softAssert.assertEquals(dashboardPage.getDashboardTitleText(), AtomHC.propData.getProperty("dashboard.label"),
				"The Dashboard Title is not displayed");
		log("Dashboard Message is " + dashboardPage.isNoRecordsFoundMessage());
		softAssert.assertEquals(dashboardPage.isNoRecordsFoundMessage(),
				AtomHC.propData.getProperty("no.record.found.msg"), "The No Records message is not displayed");
		softAssert.assertEquals(register.getDashboardTitle(), AtomHC.propData.getProperty("dashboard.page"),
				"header not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testUserDoesNotSelectMandatoryConsent() throws InterruptedException, IOException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		HealthcareLogin login= new HealthcareLogin(driver);
		login.clickOnLogin();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("verify valid verification code");
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		log("verify if it is navigated to organisation setup page");
		softAssert.assertEquals(register.getOrgSetupHeader(), AtomHC.propData.getProperty("org.setup.header"),
				"header is not displayed");
		OrgnizationSetup org = new OrgnizationSetup(driver);
		log("Verify if organisation details are filled");
		org.setGSTNumber(AtomHC.propData.getProperty("GST.number"));
		org.clickOnSelectLangDropdown();
		
		org.clickOnOrgRegisterBtn();
		softAssert.assertEquals(org.getOrgErrorlabel(), AtomHC.propData.getProperty("organisation.error"),
				"error msg is not displayed");
		softAssert.assertEquals(org.getDomainErrorlabel(), AtomHC.propData.getProperty("domain.error.new"),
				"error msg is not displayed");
		softAssert.assertEquals(org.getDefaultLangErrorlabel(), AtomHC.propData.getProperty("default.error.label"),
				"error msg is not displayed");
		softAssert.assertAll();
	}
}
