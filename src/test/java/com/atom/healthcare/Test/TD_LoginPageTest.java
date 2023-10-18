package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.Utils.BaseTest;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.page.Pojo.CommonMethods;


import com.atom.healthcare.page.objects.TD_LoginPage.TD_LoginPage;



public class TD_LoginPageTest extends BaseTest {
	
	private void getDataForLoginPage(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[2].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AHC.userName = (String) getData[0];
				AHC.password = (String) getData[1];
				AHC.pincodeSetup = (String) getData[3];
				AHC.confirmPincode = (String) getData[4];
			}
		}
	}

	@Test(priority = 1)
	public void testIfPasswordIsMissing() throws Exception {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		try {
			getDataForLoginPage(getClassName(), "PasswordMissing");
			try {
				if (loginPage.isLoginPageDisplay()) {
					loginPage.clearUsernamAndPasswordTextbox();
				} else {
					loginPage.selectPreferedLanguage(AHC.language);
					loginPage.clickOnWelcomeNextButton();
				}
			} catch (Exception e) {
				log("Already on login Page");
			}
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if Password is missing");
		Assert.assertTrue(loginPage.isPasswordRequiredMsgDisplayed(),"Pasasword required error message was not display");
	}

	@Test(priority = 2)
	public void testIfUsernameIsMissing() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		loginPage.clearUsernamAndPasswordTextbox();
		try {
			getDataForLoginPage(getClassName(), "UsenameMissing");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if username is missing");
		Assert.assertTrue(loginPage.isUserNameRequiredMsgDisplayed(),"Username required error message was not display");
	}

	 //@Test(priority = 3)
	public void testIfPasswordIsInvalid() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		loginPage.clearUsernameAndPassword();
		try {
			getDataForLoginPage(getClassName(), "InvalidPassword");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if password is invalid");
		Assert.assertTrue(loginPage.isYourDataIsInvalidMsgDisplayed(),"'Your data is invalid' error message was not display");
	}

	 //@Test(priority = 4)
	public void testIfUsernameIsInvalid() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		loginPage.clearUsernameAndPassword();
		try {
			getDataForLoginPage(getClassName(), "invalidUsername");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if isername is invalid");
		Assert.assertTrue(loginPage.isPermissionMsgDisplayed(),"Permission error message was not display");
	}

	@Test(priority = 5)
	public void testUsenameAndPasswordAreBlank() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		loginPage.clearUsernamAndPasswordTextbox();
		try {
			getDataForLoginPage(getClassName(), "UsernameAndPasswordAreBlank");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if Password and username is missing");
		Assert.assertTrue(loginPage.isPasswordRequiredMsgDisplayed(),"Pasasword required error message was not display");
		Assert.assertTrue(loginPage.isUserNameRequiredMsgDisplayed(),"Username required error message was not display");
	}

	@Test(priority = 6)
	public void testMinimumPasswordLength() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		CommonMethods commonMtd = new CommonMethods();
		loginPage.clearUsernamAndPasswordTextbox();
		try {
			getDataForLoginPage(getClassName(), "MinimumPasswordLength");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if user enter minimum password limit");
		Assert.assertTrue(loginPage.isMinimumPassLengthMsgDisplayed(),"Minimum password length error message was not display");
	}

	@Test(priority = 7)
	public void testMinimumUsernameLength() throws IOException, InterruptedException {
		log("Login to Patient");
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		CommonMethods commonMtd = new CommonMethods();
		loginPage.clearUsernamAndPasswordTextbox();
		try {
			getDataForLoginPage(getClassName(), "MinimumUsenameLength");
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if user enter minimum username limit");
		Assert.assertTrue(loginPage.isMinimumUserNameLengthMsgDisplayed(),"Minimum username length error message was not display");
	}

	@Test(priority = 8)
	public void testIfUserEnterValidPassword() throws IOException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		CommonMethods commonMtd = new CommonMethods();
		try {
			getDataForLoginPage(getClassName(), "ValidPassword");
			try {
				if (loginPage.isLoginPageDisplay()) {
					loginPage.clearUsernamAndPasswordTextbox();
				}else {
					loginPage.selectPreferedLanguage(AHC.language);
					loginPage.clickOnWelcomeNextButton();
				}
			} catch (Exception e) {
				loginPage.selectPreferedLanguage(AHC.language);
				loginPage.clickOnWelcomeNextButton();
			}
			loginPage.enterUsernameAndPassword(AHC.userName, AHC.password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
		String code=commonMtd.getVerificationCodeFromMail(AHC.url);
		SoftAssert softAssert= new SoftAssert();
		log("Verify if user enter minimum password limit");
		softAssert.assertTrue(loginPage.isTwoFactorAuthPageDisplay(),"Two factor Authentication page was not display");
		loginPage.addTwoFactorAuthentication(code);
		softAssert.assertTrue(loginPage.isPincodeSetupPageDisplay(),"Pincode setup page was not display");
		loginPage.addPincodeSetupCode(AHC.pincodeSetup);
		softAssert.assertTrue(loginPage.isConfirmPincodePageDisplay(),"Confirm Pincode page was not display");
		loginPage.addConfirmPincode(AHC.confirmPincode);
		softAssert.assertAll();
	}
	
}