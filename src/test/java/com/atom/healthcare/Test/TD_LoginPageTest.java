package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;
import com.atom.healthcare.TD_OrgnizationSetupWebElement.TD_OrgnasationSetupPageWebElement;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class TD_LoginPageTest extends BasePageTestNG {
	String OTP;
	String username;
	String password;

	/*
	 * This method is to get data from "TD_LoginPageWebElementTest" sheet it will
	 * compare scenario coloumn 0
	 */
	private void getDataForLoginPage(String className, String testScenario) throws IOException, InterruptedException {
		try {
			for (Object[] getData : BasePageObject.readExcelFile(className)) {
				if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
					username = (String) getData[3];
					password = (String) getData[4];
					OTP = (String) getData[5];
				}
			}
			TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
			loginPage.enterUsernameAndPass(username, password);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
	}

	@Test
	public void testIfLoginUsernameIsMissing() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		try {
			loginPage.clickOnLandingLogin();
			loginPage.clearloginDetails();
		} catch (Exception e) {
			log("User already on Login page");
		}
		getDataForLoginPage(getClassName(), "testIfLoginUsernameIsMissing");
		loginPage.clickOnLoginButton();
		log("Verify if username is missing then error label should be display");
		Assert.assertTrue(loginPage.isUsernameErrorLabelDisplay(), "Username error label is not dsplay");
	}

	@Test
	public void testIfLoginPasswordIsMissing() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testIfLoginPasswordIsMissing");
		loginPage.clickOnLoginButton();
		log("Verify if Password is missing then error label should be display");
		Assert.assertTrue(loginPage.isPasswordErrorLabelDisplay(), "Password error label is not dsplay");
	}

	@Test
	public void testIfLoginUsernameAndPasswordIsMissing() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testIfLoginUsernameAndPasswordIsMissing");
		loginPage.clickOnLoginButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Username and Password is missing then error label should be display");
		softAssert.assertTrue(loginPage.isUsernameErrorLabelDisplay(), "Username error label is not dsplay");
		softAssert.assertTrue(loginPage.isPasswordErrorLabelDisplay(), "Password error label is not dsplay");
		softAssert.assertAll();
	}

	@Test
	public void testIfLoginUsernameisInvalid() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testIfLoginUsernameisInvalid");
		loginPage.clickOnLoginButton();
		log("Verify if Username is invalid then error label should be display");
		Assert.assertTrue(loginPage.isYourDataIsInvalidLabelDisplay(), "Username error label is not dsplay");
	}

	@Test
	public void testIfLoginPasswordIsInvalid() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testIfLoginPasswordIsInvalid");
		loginPage.clickOnLoginButton();
		log("Verify if Password is invalid then error label should be display");
		Assert.assertTrue(loginPage.isYourDataIsInvalidLabelDisplay(), "Password error label is not dsplay");
	}

	@Test
	public void testIfUserExceedPasswordLimit() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testIfUserExceedPasswordLimit");
		loginPage.clickOnLoginButton();
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clickOntwoFactorAuth(OTP);
		log("Verify if User Exceed Password Limit");
		Assert.assertTrue(loginPage.isloginTitleLabelDisplay(), "Login page is not dsplay");
	}

	@Test
	public void testEnterValidUsernameAndPassword() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		try {
			loginPage.clickOnLandingLogin();
		} catch (Exception e) {
			log("User already on Login page");
		}
		loginPage.clearloginDetails();
		getDataForLoginPage(getClassName(), "testEnterValidUsernameAndPassword");
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		loginPage.clickOnLoginButton();
		orgSetup.enterTwoFactorCode(CommonMethods.getLoginVerificationCodeFromMail(username));
		log("Verify if user enter valid details it should navigate to dashboard page");
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		Assert.assertTrue(mainPage.isOrganisationDisplay(), "Organisation Name not display");
	}
}
