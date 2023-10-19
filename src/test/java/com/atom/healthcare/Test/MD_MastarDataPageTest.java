package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_MastarDataPageTest extends BasePageTestNG {
	String consentRole;
	String sequenceNo;
	String androidPlatform;
	String iOSPlatform;
	String isReuired;

	/*
	 * This method is to get data from "MD_MasterDataPageTest" sheet it will compare
	 * scenario coloumn 0
	 */
	private void getDataForConsent(String className, String testScenario) throws IOException {
		try {
			for (Object[] getData : BasePageObject.readExcelFile(className)) {
				if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
					consentRole = (String) getData[2];
					AtomHC.consentPage = (String) getData[3];
					sequenceNo = (String) getData[4];
					androidPlatform = (String) getData[5];
					iOSPlatform = (String) getData[6];
					isReuired = (String) getData[7];
				}
			}
			MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
			masterData.addConsentDetails(consentRole, AtomHC.consentPage, sequenceNo, isReuired);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
	}

	@Test
	public void testAddingValidConsentPageToAdminWeb() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("Add consent Page for Admin");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToAdminWeb");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Admin should be Display");
		softAssrt.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to Admin is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to Admin is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToSuperAdminWeb() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("Add consent Page for SuperAdmin");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToSuperAdminWeb");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for SuperAdmin should be Display");
		softAssrt.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to SuperAdmin is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to SuperAdmin is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToPatientAndroid() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}

		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToPatientAndroid");

		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Patient for Android should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to patient for Android is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to patient for Android is not visible");
		softAssrt.assertAll();
	}

	// @Test
	public void testAddingValidConsentPageToPatientiOS() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "AddingValidConsentPageToPatientForiOS");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Patient for iOS should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to patient for iOS is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to patient for iOS is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToDoctorAndroid() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToDoctorAndroid");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Doctor for Android should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to Doctor for Android is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to Doctor for Android is not visible");
		softAssrt.assertAll();
	}

	// @Test
	public void testAddingValidConsentPageToDoctoriOS() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "AddingValidConsentPageToDoctorForiOS");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Doctor for iOS should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to Doctor for iOS is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to Doctor for iOS is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToNurseAndroid() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToNurseAndroid");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Nurse for Android should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to Nurse for Android is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to Nurse for Android is not visible");
		softAssrt.assertAll();
	}

	// @Test
	public void testAddingValidConsentPageToNurseiOS() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "AddingValidConsentPageToNurseForiOS");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for nurse for iOS should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to nurse for iOS is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to nurse for iOS is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToFrontDeskWeb() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToFrontDeskWeb");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for Frontdesk for web should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to Frontdesk is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to Frontdesk for web is not visible");
		softAssrt.assertAll();
	}

	@Test
	public void testAddingValidConsentPageToCareTakerAndroid() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "testAddingValidConsentPageToCareTakerAndroid");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for CareTaker for Android should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to CareTaker for Android is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to CareTaker for Android is not visible");
		softAssrt.assertAll();
	}

	// @Test
	public void testAddingValidConsentPageToCareTakeriOS() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			masterData.selectConsentsTab();
		} catch (Exception e) {
			log("User Already on consent page");
		}
		log("AAdd consent Page for Patient");
		getDataForConsent(getClassName(), "AddingValidConsentPageToCareTakeriOS");
		masterData.selectPlatform(androidPlatform, iOSPlatform);
		masterData.clickOnConsentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Added consent page and sequence for CareTaker for iOS should be Display");
		Assert.assertTrue(masterData.isCreatedConsentDisplay(AtomHC.consentPage),
				"Added consent to CareTaker for iOS is not visible");
		softAssrt.assertTrue(masterData.isSequenceNumberDisplay(sequenceNo),
				"Added sequence number to CareTaker for iOS is not visible");
		softAssrt.assertAll();
	}
}
