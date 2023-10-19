package com.atom.healthcare.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestNGMethod;
import org.testng.SkipException;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;
import com.atom.healthcare.TD_OrgnizationSetupWebElement.TD_OrgnasationSetupPageWebElement;
import com.atom.healthcare.TD_RegistrationWebElement.TD_RegistrationPageWebElement;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class TD_RegistrationPageTest extends BasePageTestNG implements IAnnotationTransformer{
	String firstName;
	String lastName;
	String mobileNumber;
	String newPassword;
	String confirmPass;
	String OTP;
	String email;

	/*
	 * This method is to get data from "TD_RegistrationPage" sheet it will compare
	 * scenario coloumn 0
	 */
	private void getDataForRegistrationPage(String className, String testScenario) throws IOException {
		try {
			for (Object[] getData : BasePageObject.readExcelFile(className)) {
				if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
					firstName = (String) getData[3];
					lastName = (String) getData[4];
					email = (String) getData[5];
					mobileNumber = (String) getData[6];
					newPassword = (String) getData[7];
					confirmPass = (String) getData[8];
					OTP = (String) getData[9];
				}
			}
			TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
			regiPage.enterRegisterDetails(firstName, lastName, email, mobileNumber,
					newPassword, confirmPass);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
	}

	@Test
	public void testIfEmailIsInvalid() throws Exception {
		TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
		loginPage.clickOnLandingLogin();
		loginPage.clickOnRegisterButton();
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		getDataForRegistrationPage(getClassName(), "testIfEmailIsInvalid");
		regiPage.clickOnRegisterButton();
		log("Verify if user enter invalid email the error message should display");
		assertTrue(regiPage.isYourDataIsInvalidLabelDisplay(), "Invalid Email message is not display");
	}

	@Test
	public void testIfFirstNameIsMissing() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfFirstNameIsMissing");
		regiPage.clickOnRegisterButton();
		log("Verify if first name is not entered");
		assertTrue(regiPage.isFirstNameRequiredLabelDisplay(), "First name required label is not display");
	}

	@Test
	public void testIfLastNameIsMissing() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfLastNameIsMissing");
		regiPage.clickOnRegisterButton();
		log("Verify if Last name is not enter");
		assertTrue(regiPage.isLastNameRequiredLabelDisplay(), "Last name is missing");
	}

	@Test
	public void testIfNewPasswordIsMissing() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfNewPasswordIsMissing");
		regiPage.clickOnRegisterButton();
		log("Verify if new password is missing");
		assertTrue(regiPage.isNewPasswordIsRequirdLabelDisplay(), "New password is missing");
	}

	@Test
	public void testIfConfirmPasswordIsMissing() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfConfirmPasswordIsMissing");
		regiPage.clickOnRegisterButton();
		log("Verify if confirm password is missing");
		assertTrue(regiPage.isConfirmNameRequiredLabelDisplay(), "Confirm passwoprd is missing");
	}

	@Test
	public void testBothPasswordAreNotSame() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testBothPasswordAreNotSame");
		regiPage.clickOnRegisterButton();
		log("Verify if Both password are not same");
		assertTrue(regiPage.isPasswordDoNotMatchLabelDisplay(), "Both password are not same");
	}

	@Test
	public void testIfUserEnterInvalidMobileNumber() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfUserEnterInvalidMobileNumber");
		regiPage.clickOnRegisterButton();
		log("Verify when user enter invalid Mobile Number");
		assertTrue(regiPage.isMobileNumberErrorLabelDisplay());
	}

	@Test
	public void testIfEmailAndMobileNumberMissing() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfEmailAndMobileNumberMissing");
		SoftAssert softAssert = new SoftAssert();
		regiPage.clickOnRegisterButton();
		log("Verify if Email and Mobile Number is missing");
		softAssert.assertTrue(regiPage.isMobileNumberErrorLabelDisplay());
		softAssert.assertTrue(regiPage.isYourDataIsInvalidLabelDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserEnterAlreadyExistingOrgDetails() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfUserEnterAlreadyExistingOrgDetails");
		regiPage.clickOnRegisterButton();
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clickOnVerifyButton();
		log("Verify if user enter already existing details then error message should display");
		assertTrue(regiPage.isUserAlreadyPresentLabel(), "User Already present label is not display");
	}

	@Test
	public void testIfUserEnterInvalidOTP() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfUserEnterInvalidOTP");
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		regiPage.clickOnRegisterButton();
		orgSetup.enterVerificationCode(OTP);
		orgSetup.clickOnVerifyButton();
		log("verify if user enter invalide OTP in two factor authentication, error message should be display");
		assertTrue(regiPage.isInvalidOTPErrorLabelDisplay(), "Invalid OTP error message label is not display");
		driver.navigate().refresh();
	}

	@Test
	public void testIfUserEnterThreeTimeInvalidOTP() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testIfUserEnterThreeTimeInvalidOTP");
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		regiPage.clickOnRegisterButton();
		for (int i = 1; i <= 3; i++) {
			orgSetup.clearVerificationCode();
			orgSetup.enterVerificationCode(OTP);
			orgSetup.clickOnVerifyButton();
		}
		log("verify after entering Three time invalid otp, it should be navigate on registraion page");
		assertTrue(regiPage.isRegisterPageDisplay(),
				"Registration page is not display afterentering three time invalid OTP");
		driver.navigate().refresh();
	}

	@Test
	public void testRegisterDetailsWithValidData() throws Exception {
		TD_RegistrationPageWebElement regiPage = new TD_RegistrationPageWebElement(driver);
		try {
			TD_LoginPageWebElement loginPage = new TD_LoginPageWebElement(driver);
			loginPage.clickOnLandingLogin();
			loginPage.clickOnRegisterButton();
		} catch (Exception e) {
			log("User is already on register page");
		}
		regiPage.clearRegisterDetails();
		getDataForRegistrationPage(getClassName(), "testRegisterDetailsWithValidData");
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		regiPage.clickOnRegisterButton();
		orgSetup.clearVerificationCode();
		orgSetup.enterVerificationCode(CommonMethods.getRegistrationCodeFromMail(email));
		orgSetup.clickOnVerifyButton();
		log("Verify if user entering valid registration details then it navigate to Organization setup page");
		assertTrue(orgSetup.isOrgSetupPageDisplay(), "Organisation setup Page is not display");
	}
	
}
