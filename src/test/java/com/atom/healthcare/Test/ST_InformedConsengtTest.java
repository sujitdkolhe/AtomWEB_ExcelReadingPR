package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_InformedConsentWebElement.TD_InformedConsentsPageWebElement;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;
import com.atom.healthcare.TD_OrgnizationSetupWebElement.TD_OrgnasationSetupPageWebElement;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_SetNewPassword.TD_SetNewPasswordPage;
import com.atom.healthcare.TD_Users.TD_UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class ST_InformedConsengtTest extends BasePageTestNG {
	
	@Test(priority = 1)
	public void testAddConsentPageToAllRole() throws Exception {
		TD_LoginPageWebElement login = new TD_LoginPageWebElement(driver);
		log("Adding Registration details");
		TD_RegistrationPageTest registrPage = new TD_RegistrationPageTest();
		registrPage.testRegisterDetailsWithValidData();
		log("Adding Orgnasation Setup Page details");
		TD_OrgnasationSetupPageTest orgSetup = new TD_OrgnasationSetupPageTest();
		orgSetup.testValidOrganisationDetails();
		log("Login to Admin");
		TD_LoginPageTest loginPage = new TD_LoginPageTest();
		loginPage.testEnterValidUsernameAndPassword();
		log("Add static contents page in master Configure contents tab");
		MD_ConfigureContentsPageTest confgContentPage = new MD_ConfigureContentsPageTest();
		confgContentPage.testAddValidStaticContents();
		log("Add Consents from Master Data to Admin");
		MD_MastarDataPageTest masterData = new MD_MastarDataPageTest();
		masterData.testAddingValidConsentPageToAdminWeb();
//		log("Add Consents from Master Data to Super Admin");
//		masterData.testAddingValidConsentPageToSuperAdminWeb();
		log("Add Consents from Master Data to Patient Android");
		masterData.testAddingValidConsentPageToPatientAndroid();
//		log("Add Consents from Master Data to Patient iOS");
//		masterData.testAddingValidConsentPageToPatientiOS();
		log("Add Consents from Master Data to Doctor Android tablet");
		masterData.testAddingValidConsentPageToDoctorAndroid();
//		log("Add Consents from Master Data to Doctor iOS tablet");
//		masterData.testAddingValidConsentPageToDoctoriOS();
		log("Add Consents from Master Data to Nurse Android tablet");
		masterData.testAddingValidConsentPageToNurseAndroid();
//		log("Add Consents from Master Data to Nurse iOS tablet");
//		masterData.testAddingValidConsentPageToNurseiOS();
		log("Add Consents from Master Data to frontDesk Web");
		masterData.testAddingValidConsentPageToFrontDeskWeb();
//		log("Add Consents from Master Data to Caretaker Android");
//		masterData.testAddingValidConsentPageToCareTakerAndroid();
//		log("Add Consents from Master Data to Caretaker iOS");
//		masterData.testAddingValidConsentPageToCareTakeriOS();
	}

	@Test(priority = 2)
	public void testAddedConsentPageDisplayedToAdminOrg() throws Exception {
		TD_LoginPageWebElement login = new TD_LoginPageWebElement(driver);
		TD_UsersPageTest uesrPage = new TD_UsersPageTest();
		login.logout();
		login.clickOnLandingLogin();
		log("Verify After login informed consents page should be visible to Admin");
		login.enterLoginDetails(AtomHC.email, AtomHC.password,
				CommonMethods.getVerificationCodeFromMail(AtomHC.email));
		MD_MasterDataPageWebElement masterDt = new MD_MasterDataPageWebElement(driver);
		SoftAssert sfAssert = new SoftAssert();
		sfAssert.assertTrue(masterDt.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent is not visible to Admin");
		log("Verify after click on consent 'Next' button should be navigate to Organization Dashboard page");
		TD_InformedConsentsPageWebElement infoConsent = TD_InformedConsentsPageWebElement.getTD_InformedConsentsPage();
		infoConsent.clickOnInformedConsentNextButton();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		sfAssert.assertTrue(mainPage.isOrganisationDisplay(), "Organisation Name not display");
		sfAssert.assertAll();
		login.logout();
	}

	@Test(priority = 3)
	public void testAddedConsentPageDisplayedToAdmin() throws Exception {
		TD_LoginPageWebElement login = new TD_LoginPageWebElement(driver);
		TD_UsersPageTest uesrPage = new TD_UsersPageTest();
		login.clickOnLandingLogin();
		login.enterLoginDetails(AtomHC.email, AtomHC.password,
				CommonMethods.getVerificationCodeFromMail(AtomHC.email));
		try {
			log("Create new admin");
			uesrPage.testCreateAdmin();
			login.logout();
			login.clickOnLandingLogin();
			String emailLink = CommonMethods.getLinkFromMail(AtomHC.userEmail);
			driver.get(emailLink);
			TD_SetNewPasswordPage setPass = new TD_SetNewPasswordPage(driver);
			TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
			orgSetup.enterTwoFactorCode(CommonMethods.getLoginVerificationCodeFromMail(AtomHC.userEmail));
			setPass.setNewPassword(AtomHC.setNewPassword, AtomHC.setConfirmPassword);
			login.enterLoginDetails(AtomHC.userEmail, AtomHC.password,
					CommonMethods.getVerificationCodeFromMail(AtomHC.userEmail));
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify After admin login informed consents page should be visible to Admin");
		MD_MasterDataPageWebElement masterDt = new MD_MasterDataPageWebElement(driver);
		SoftAssert sfAssert = new SoftAssert();
		sfAssert.assertTrue(masterDt.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent is not visible to admin");
		log("Verify after click on consent 'Next' button should be navigate to Organization Dashboard page");
		TD_InformedConsentsPageWebElement infoConsent = TD_InformedConsentsPageWebElement.getTD_InformedConsentsPage();
		infoConsent.clickOnInformedConsentNextButton();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		sfAssert.assertTrue(mainPage.isOrganisationDisplay(), "Organisation Name not display");
		sfAssert.assertAll();
		login.logout();
	}

	@Test(priority = 5)
	public void testAddedConsentPageDisplayedToFrontDesk() throws Exception {
		TD_LoginPageWebElement login = new TD_LoginPageWebElement(driver);
		TD_UsersPageTest uesrPage = new TD_UsersPageTest();
		login.clickOnLandingLogin();
		login.enterLoginDetails(AtomHC.email, AtomHC.password,
				CommonMethods.getVerificationCodeFromMail(AtomHC.email));
		try {
			log("Create new admin");
			uesrPage.testCreateFrontdesk();
			login.logout();
			login.clickOnLandingLogin();
			String emailLink = CommonMethods.getLinkFromMail(AtomHC.userEmail);
			driver.get(emailLink);
			TD_SetNewPasswordPage setPass = new TD_SetNewPasswordPage(driver);
			TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
			orgSetup.enterTwoFactorCode(CommonMethods.getLoginVerificationCodeFromMail(AtomHC.userEmail));
			setPass.setNewPassword(AtomHC.setNewPassword, AtomHC.setConfirmPassword);
			login.enterLoginDetails(AtomHC.userEmail, AtomHC.password,
					CommonMethods.getVerificationCodeFromMail(AtomHC.userEmail));
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify After admin login informed consents page should be visible to Admin");
		MD_MasterDataPageWebElement masterDt = new MD_MasterDataPageWebElement(driver);
		SoftAssert sfAssert = new SoftAssert();
		sfAssert.assertTrue(masterDt.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent is not visible to admin");
		log("Verify after click on consent 'Next' button should be navigate to Organization Dashboard page");
		TD_InformedConsentsPageWebElement infoConsent = TD_InformedConsentsPageWebElement.getTD_InformedConsentsPage();
		infoConsent.clickOnInformedConsentNextButton();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		sfAssert.assertTrue(mainPage.isOrganisationDisplay(), "Organisation Name not display");
		sfAssert.assertAll();
		login.logout();
	}

	@Test(priority = 5)
	public void testAddedConsentPageToDoctorNursePatient() throws Exception {
		TD_LoginPageWebElement login = new TD_LoginPageWebElement(driver);
		TD_UsersPageTest uesrPage = new TD_UsersPageTest();
		login.clickOnLandingLogin();
		login.enterLoginDetails(AtomHC.email, AtomHC.password,
				CommonMethods.getVerificationCodeFromMail(AtomHC.email));
		log("Create new Doctor");
		uesrPage.testCreateDoctor();
		log("Create new Nurse");
		uesrPage.testCreateNurse();
//		log("Create new Care taker");
//		uesrPage.testCreateCareTaker();
		log("Create new patient");
		TD_PatientsPageTest patientPage = new TD_PatientsPageTest();
		patientPage.testCreatePatient();
	}
}
