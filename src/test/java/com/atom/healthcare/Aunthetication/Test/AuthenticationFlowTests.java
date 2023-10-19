package com.atom.healthcare.Aunthetication.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.OrgnizationSetup.OrgnizationSetup;
import com.atom.healthcare.Pages.util.Config;
import com.atom.healthcare.Pages.util.ConfigTestData;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class AuthenticationFlowTests extends BasePageTestNG {
	HealthcareLogin loginPage;
	OrgnizationSetup registerPage;

	// Authentication Flow Web

	@Test
	public void testUserEntersValidOrgUrlShouldNavigateToLandingPage() throws Exception {
		Config config= new Config();
		ConfigTestData testData= new ConfigTestData(config);
		log("user enter valid url");
		loginPage = new HealthcareLogin(driver, testData.getUrl());
		log("Enter valid url: " + testData.getUrl());
		driver.navigate().refresh();
		log("Verify Landing page should have option Login and navigate to login page");
		assertEquals(loginPage.getLoginBtnTitle(), "Login");
	}
	
	@Test
	public void testUserNavigateToLoginPage() throws Exception {
		log("user enter valid url");
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		log("Verify user navigate to login page");
		loginPage.clickOnLogin();
		assertEquals(loginPage.getLoginTitle(), "Login");
	}

	@Test
	public void testUserNavigateToRegistrationPage() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		log("Verify users lands on registration page after clicking on register button");
		assertTrue(orgSetup.isRegisterPageDisplay());
	}

	@Test
	public void testUserEnterExistingMobileNoAndEmail() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.propData.getProperty("existing.email"),
				AtomHC.propData.getProperty("existing.mobile.no"), AtomHC.propData.getProperty("org.new.pass"),
				AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		log("Verify if user enter existing mobile no and email the error message should display");
		assertEquals(orgSetup.getErrorMsgOnClickOnRegisterButton(), AtomHC.propData.getProperty("already.present.msg"));
	}

	@Test
	public void testUserEnterNewMobileNoAndEmail() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		log("Verify if user enter new mobile no and email, should display two factor Authenthication popup");
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		assertEquals(orgSetup.getTwoFactorAuthenticationPopUpPage(),
				AtomHC.propData.getProperty("two.factor.auth.pop.up"));
	}

	@Test
	public void testUserEnterInvalideOTPInTwoFactorAuthenticationPopUpPage() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		orgSetup.enterInvalidVerificationCode(AtomHC.propData.getProperty("invalid.otp"));
		orgSetup.clickOnVerifyButton();
		log("verify if user enter invalide OTP in two factor authentication error message should be display");
		assertEquals(orgSetup.getErrorMsgInvalidOTP(), AtomHC.propData.getProperty("invalid.otp.error.msg"));
	}

	@Test
	public void testUserEnterThreeTimeInvalidOTP() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		log("verify after entering Three time invalid otp, it should be navigate on registraion page");
		orgSetup.enterInvalidVerificationCode(AtomHC.propData.getProperty("invalid.otp"));
		for (int i = 1; i <= 3; i++) {
			orgSetup.clickOnVerifyButton();
		}
		assertTrue(orgSetup.isRegisterPageDisplay());
	}

	@Test
	public void testUserNavigateToOrgSetupPageAfterEnteringValidOTP() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		orgSetup.enterValidVerificationCode(AtomHC.propData.getProperty("valid.otp"));
		orgSetup.clickOnVerifyButton();
		log("verify if user enter valid otp, then it will navigate to organization setup page");
		assertEquals(orgSetup.getOrgSetupHeading(), AtomHC.propData.getProperty("org.setup.header"));
	}

	@Test
	public void testIfUserEnterValidOrganizationDetails() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		orgSetup.enterValidVerificationCode(AtomHC.propData.getProperty("valid.otp"));
		orgSetup.clickOnVerifyButton();
		BasePageObject basePageObj = new BasePageObject(driver);
		String orgnizationName = "AlphaMD" + BasePageObject.createRandomCharacter(4);
		String domainName = "www.medical" + BasePageObject.createRandomCharacter(4) + ".com";
		log("Orgnization Name: " + orgnizationName + "    Domain Name: " + domainName);
		orgSetup.enterRegistrationSetupDetails(orgnizationName, domainName, basePageObj.generatRandomNum(), 2, 4);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.getOrginizationName();
		log("verify if user entering valid organization details it lands on dashboard page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(mainPage.getOrginizationName(), "Organisation : " + orgnizationName,
				"Organization name not match");
		softAssert.assertEquals(mainPage.getOrginazationDomainName(), domainName, "Domain name not match");
		softAssert.assertAll();
	}

	@Test(enabled = false)
	public void testUserEnterExistingOrganizationDetails() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		loginPage.clickOnRegisterButton();
		registerPage = new OrgnizationSetup(driver);
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		long mobileNo = BasePageObject.generateMobileNumber();
		log("Mobile num: " + mobileNo);
		AtomHC.mobileNum = String.valueOf(mobileNo);
		AtomHC.email = BasePageObject.createRandomEmailAddress("AlphaMD", "yopmail.com");
		log("EmailId: " + AtomHC.email);
		orgSetup.enterExistsMobileNoAndEmailDetails(AtomHC.propData.getProperty("org.first.name"),
				AtomHC.propData.getProperty("org.last.name"), AtomHC.email, AtomHC.mobileNum,
				AtomHC.propData.getProperty("org.new.pass"), AtomHC.propData.getProperty("org.confirm.pass"));
		orgSetup.clickOnRegisterButton();
		orgSetup.enterValidVerificationCode(AtomHC.propData.getProperty("valid.otp"));
		orgSetup.clickOnVerifyButton();
		BasePageObject basePageObj = new BasePageObject(driver);
		orgSetup.enterRegistrationSetupDetails("AlphaMD" + BasePageObject.createRandomCharacter(4), "www.medical.com",
				basePageObj.generatRandomNum(), 2, 4);
		log("verify user enter existing organization details then should display Duplicate Data");
		assertEquals(orgSetup.getDuplicateDataErrorLabel(), "Duplicate Data");
	}

	@Test
	public void testUserEnterInvalidUrl() throws Exception {
		log("user enter invalid url");
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("user.enter.wrong.url"));
		log("Enter invalid url: " + AtomHC.propData.getProperty("user.enter.wrong.url"));
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		log("Verify when user enter wrong url");
		assertTrue(orgSetup.isWrongUrlDisplay());
	}

//Login Flow
	@Test(enabled = false)
	public void testUserEnterInvalidPassword() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterWrongPassword(AtomHC.propData.getProperty("user.email"),
				AtomHC.propData.getProperty("invalid.pass"));
		loginPage.clickOnLoginButton();
		log("Verify if user enter wrong password in password field");
		assertEquals(orgSetup.getInvalidDataMsg(), AtomHC.propData.getProperty("invalid.data.msg"));
	}

	@Test
	public void testWhenUserEnterWrongPasswordWithXLimit() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		log("User lands on login page");
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterWrongPassword(AtomHC.propData.getProperty("valid.username"),
				AtomHC.propData.getProperty("password"));
		SoftAssert softAssert = new SoftAssert();
		for (int i = 1; i <= 3; i++) {
			loginPage.clickOnLoginButton();
		}
		softAssert.assertTrue(loginPage.getLockImage(), "Lock image not display");
		softAssert.assertEquals(loginPage.getLockPopupTitle(), AtomHC.propData.getProperty("account.lock.title"),
				"Lock popup title not match");
		softAssert.assertTrue(loginPage.getLockingPopupInstruction(), "Lock popup Instruction not display");
		softAssert.assertTrue(loginPage.getLockTiming(), "Lock tiome not display");
		softAssert.assertEquals(loginPage.getTimingInSeconds(), "seconds");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		log("User open window in next tab when user exceed password limit then account lock popup");
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		driver.navigate().to(AtomHC.propData.getProperty("url"));
		loginPage.clickOnLogin();
		orgSetup.enterWrongPassword(AtomHC.propData.getProperty("valid.username"),
				AtomHC.propData.getProperty("password"));
		for (int i = 1; i <= 3; i++) {
			loginPage.clickOnLoginButton();
		}
		log("Verify when user exceed password limit then account lock popup should be display");
		softAssert.assertTrue(loginPage.getLockImage(), "Lock image not display");
		softAssert.assertEquals(loginPage.getLockPopupTitle(), AtomHC.propData.getProperty("account.lock.title"),
				"Lock popup title not match");
		softAssert.assertTrue(loginPage.getLockingPopupInstruction(), "Lock popup Instruction not display");
		softAssert.assertTrue(loginPage.getLockTiming(), "Lock tiome not display");
		softAssert.assertEquals(loginPage.getTimingInSeconds(), "seconds");
		softAssert.assertAll();
	}

	@Test
	public void testUserDisplayAccountLockoutPopupWhenUserCloseAndOpenAgain() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		log("User lands on login page");
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterWrongPassword(AtomHC.propData.getProperty("valid.username"),
				AtomHC.propData.getProperty("password"));
		SoftAssert softAssert = new SoftAssert();
		for (int i = 1; i <= 3; i++) {
			loginPage.clickOnLoginButton();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		log("User open window in next tab when user exceed password limit then account lock popup");
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		driver.navigate().to(AtomHC.propData.getProperty("url"));
		driver.switchTo().window(list.get(0));
		driver.close();
		driver.switchTo().window(list.get(1));
		loginPage.clickOnLogin();
		orgSetup.enterWrongPassword(AtomHC.propData.getProperty("valid.username"),
				AtomHC.propData.getProperty("password"));
			loginPage.clickOnLoginButton();
		log("Verify user should be display account lockout popup when user close and open again immediatly");
		softAssert.assertTrue(loginPage.getLockImage(), "Lock image not display");
		softAssert.assertEquals(loginPage.getLockPopupTitle(), AtomHC.propData.getProperty("account.lock.title"),
				"Lock popup title not match");
		softAssert.assertTrue(loginPage.getLockingPopupInstruction(), "Lock popup Instruction not display");
		softAssert.assertTrue(loginPage.getLockTiming(), "Lock tiome not display");
		softAssert.assertEquals(loginPage.getTimingInSeconds(), "seconds");
		softAssert.assertAll();
	}


	@Test
	public void testWhenUserEnterCorrectUserNameAndPassword() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		loginPage.clickOnLoginButton();
		log("Verify when user enter correct username and password navigate on Two factor Authentication popup");
		assertEquals(orgSetup.getTwoFactorAuthenticationText(), AtomHC.propData.getProperty("two.factor.auth.pop.up"));
	}

	@Test
	public void testIfRememberMeNotCheckThenNavigateToDashboard() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		log("Verify if user not checked remember me check box then page should be navigate to dashboard");
		assertEquals(orgSetup.getDasboardText(), AtomHC.propData.getProperty("dashboard.name"));
	}

	@Test
	public void testIfRememberMeCheckThenNavigateToPincodePage() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("enter.valid.otp"));
		loginPage.clickOnVerifyButton();
		log("Verify if user checked remember me check box then page should be navigate to pincode");
		assertEquals(orgSetup.getPincodeSetupHeading(), AtomHC.propData.getProperty("pincode.page.heading"));
	}

	@Test
	public void testWhenUserEnterWrongOTPInTwoFactorAuthentication() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orgSetup.isTwoFactorAuthenticationPageDisplay(),
				"Two factor aunthetcication popup not display");
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("invalid.code"));
		loginPage.clickOnVerifyButton();
		log("Verify when user enter wrong otp in two factor authentication page then error message display");
		softAssert.assertEquals(orgSetup.getErrorMsg(), AtomHC.propData.getProperty("invalid.otp.error.msg"),
				"Invalid otp error message not match");
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterWrongOTPXTimesItNavigateToLoginPage() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		SoftAssert softAssert = new SoftAssert();
		loginPage.clickOnLoginButton();
		softAssert.assertTrue(orgSetup.isTwoFactorAuthenticationPageDisplay(),
				"Two factor aunthetcication popup not display");
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("invalid.otp"));
		for (int i = 1; i <= 3; i++) {
			loginPage.clickOnVerifyButton();
			Thread.sleep(2000);
		}
		log("Verify when user enter x times wrong otp then authentication page should be navigate login page");
		softAssert.assertEquals(orgSetup.getLoginText(), AtomHC.propData.getProperty("get.login.text"),
				"Login text not match");
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterCorrectTwoFactorAuthenticationOTP() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orgSetup.isTwoFactorAuthenticationPageDisplay(),
				"Two factor aunthetcication popup not display");
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		log("Verify user enter correct otp, display pincode page");
		softAssert.assertEquals(orgSetup.getPincodeSetupHeading(), AtomHC.propData.getProperty("pincode.page.heading"),
				"Pincode setting heading not match");
		softAssert.assertAll();
	}

//Pincode setup

	@Test
	public void testWhenUserCheckedTheRememberMeCheckboxThenPageRedirectToPincodeSetup() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orgSetup.isTwoFactorAuthenticationPageDisplay());
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		log("Verify when user checked the remember me chechbox then page should be navigate to pincode setup page");
		softAssert.assertEquals(orgSetup.getPincodeSetupHeading(), AtomHC.propData.getProperty("pincode.page.heading"),
				"Pincode p[age heading not display");
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterCorrectPatternPincodeItShouldDisplayConfirmPincodeField() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orgSetup.isSetPincodePageDisplay());
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		log("Verify when user enter correct pincode it should display confirm pincode field");
		assertEquals(orgSetup.getConfirmPincodeLabel(), AtomHC.propData.getProperty("confirm.pincode.textbox.label"),
				"Pincode textbox label not display");
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterDifferentPincodeInConfirmPincodeField() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(orgSetup.isSetPincodePageDisplay());
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.invalid.pin"));
		orgSetup.clickOnSetButton();
		log("Verify when user enter different pincode in confirm pincode field then error message should be diasplay");
		softAssert.assertEquals(orgSetup.getWeakPincodeMsg(),
				(AtomHC.propData.getProperty("error.msg.pincode.not.match")), "pincode error message not display");
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterXTimesWrongConfirmPincode() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.invalid.pin"));
		SoftAssert softAssert = new SoftAssert();
		for (int i = 1; i <= 3; i++) {
			orgSetup.clickOnSetButton();
			log("Verify if user enter wrong pincode in confirm pincode fiels for many time it should display error msg");
			softAssert.assertEquals(orgSetup.getNotMatchErrorMsg(),
					(AtomHC.propData.getProperty("error.msg.pincode.not.match")), "pincode error message not display");
			softAssert.assertAll();
		}
	}

//pincode login
	@Test
	public void testUserEnterIncorrectPincode() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.invalid.pin"));
		orgSetup.clickOnSetButton();
		log("Verify user enter incorrect pincode then it should display error msg");
		assertEquals(orgSetup.getNotMatchErrorMsg(), (AtomHC.propData.getProperty("error.msg.pincode.not.match")),
				"pincode error message not display");
	}

	@Test
	public void testUserEnterCorrectPincodeThenNavigateToDashboard() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("valid.otp"));
		loginPage.clickOnVerifyButton();
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.pincode"));
		orgSetup.clickOnSetButton();
		log("Verify when user enter correct pincode in both the field it navigate to dashboard page");
		assertEquals(orgSetup.getDasboardText(), AtomHC.propData.getProperty("dashboard.name"));
	}

	// login flow user data security
	@Test
	public void testWhenUserClickOnLoginIconItNavigateToLoginPage() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("enter.valid.otp"));
		loginPage.clickOnVerifyButton();
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.pincode"));
		orgSetup.clickOnSetButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(orgSetup.getDasboardText(), AtomHC.propData.getProperty("dashboard.name"),
				"Dashboard page name not match");
		orgSetup.clickOnLogoutIcon();
		log("Verify when user click on login icon in first user login it navigate to login page");
		softAssert.assertEquals(orgSetup.getLoginText(), AtomHC.propData.getProperty("get.login.text"),
				"Login text not match");
		softAssert.assertAll();
	}

	@Test
	public void testEnterValidOTPItNavigateToPincodeSetupPage() throws InterruptedException {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(orgSetup.getTwoFactorAuthenticationText(),
				AtomHC.propData.getProperty("two.factor.auth.pop.up"));
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("enter.valid.otp"));
		loginPage.clickOnVerifyButton();
		log("Verify when user enter two factor it's navigate to pincode setup page");
		softAssert.assertEquals(orgSetup.getPincodeSetupHeading(), AtomHC.propData.getProperty("pincode.page.heading"),
				"Pincode heading not match");
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnDashboardPage() throws InterruptedException {
		 loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnLogin();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		orgSetup.enterCorrectUsernameAndPassd(AtomHC.propData.getProperty("user.id"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("user.pass")));
		orgSetup.clickRememberMeCheckbox();
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(orgSetup.getTwoFactorAuthenticationText(),
				AtomHC.propData.getProperty("two.factor.auth.pop.up"));
		loginPage.enterVerificationKey(AtomHC.propData.getProperty("enter.valid.otp"));
		loginPage.clickOnVerifyButton();
		softAssert.assertEquals(orgSetup.getPincodeSetupHeading(), AtomHC.propData.getProperty("pincode.page.heading"));
		orgSetup.setPincode(AtomHC.propData.getProperty("pincode"));
		orgSetup.setConfirmPincode(AtomHC.propData.getProperty("confirm.pincode"));
		orgSetup.clickOnSetButton();
		log("Verify user lands on dashboard page whje enter valid OTP and set pincod");
		softAssert.assertEquals(orgSetup.getDasboardText(), AtomHC.propData.getProperty("dashboard.name"),
				"Dashboard page name not match");
	}
}