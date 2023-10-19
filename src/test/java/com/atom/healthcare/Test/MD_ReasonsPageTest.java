package com.atom.healthcare.Test;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MD_MasterDataWebElement.MD_ReasonsPage;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_ReasonsPageTest extends BasePageTestNG{
	
	/*
	 * This method is to get data from "MD_ReasonsPageTest" sheet it will compare
	 * scenario column 2
	 */
	private static void getDataForReasons(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.reasonText = (String) getData[1];
				AtomHC.reasonDescript = (String) getData[2];
			}
		}
	}

	@Test(priority = 1)
	public void testIfNoDataEnteredAndClickOnSaveButton() throws Exception {
		TD_LoginPageTest login = new TD_LoginPageTest();
		login.testEnterValidUsernameAndPassword();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		mainPage.clickOnOrginazationTab();
		masterData.clickOnMasterData();
		reasonData.clickOnReasonsTab();
		reasonData.clickOnReasonsAddButton();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfNoDataEntered");
			reasonData.createNewReasons(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		reasonData.clickOnReasonsSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Reason and Description Data Not Entered Error message is displayed");
		softAssert.assertTrue(reasonData.isReasonErrorMessageFirstLangDisplayed(),
				"Reason text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isDescriptionFirstLangErrorMessageDisplayed(),
				"Description text Error Message is not dsplayed");
		reasonData.clickOnSecondLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfNoDataEntered");
			reasonData.clickOnSecondLangTab(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		reasonData.clickOnReasonsSaveButton();
		softAssert.assertTrue(reasonData.isReasonErrorMessageSecondLangDisplayed(),
				"Reason text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isDescriptionSecondLangErrorMessageDisplayed(),
				"Description text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isLanguageErrorMessageDisplayed(), "Language Error Message is not dsplayed");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void testIfDescriptionDataNotEntered() throws Exception {
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		reasonData.clickOnFirstLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfDescriptionDataNotEntered");
			reasonData.createNewReasons(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Description Data Not Entered Error message is displayed");
		softAssert.assertTrue(reasonData.isDescriptionFirstLangErrorMessageDisplayed(),
				"Description text Error Message is not dsplayed");
		reasonData.clickOnSecondLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfDescriptionDataNotEntered");
			reasonData.clickOnSecondLangTab(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		reasonData.clickOnReasonsSaveButton();
		softAssert.assertTrue(reasonData.isDescriptionSecondLangErrorMessageDisplayed(),
				"Description text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isLanguageErrorMessageDisplayed(), "Language Error Message is not dsplayed");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void testIfReasonNotEntered() throws Exception {
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		reasonData.clearReasonsInSecondLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfReasonDataNotEntered");
			reasonData.clickOnSecondLangTab(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		reasonData.clickOnReasonsSaveButton();
		log("Verify if Reason Not Entered Error message is displayed");
		reasonData.clickOnFirstLangTab();
		reasonData.clearReasonsInFirstLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfReasonDataNotEntered");
			reasonData.createNewReasons(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		reasonData.clickOnReasonsSaveButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(reasonData.isReasonErrorMessageFirstLangDisplayed(),
				"Reason text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isLanguageErrorMessageDisplayed(), "Language Error Message is not dsplayed");
		reasonData.clickOnSecondLangTab();
		softAssert.assertTrue(reasonData.isReasonErrorMessageSecondLangDisplayed(),
				"Reason text Error Message is not dsplayed");
		softAssert.assertTrue(reasonData.isLanguageErrorMessageDisplayed(), "Language Error Message is not dsplayed");
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void testIfReasonIsCreated() throws Exception {
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		reasonData.clickOnFirstLangTab();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfValidDataEntered");
			reasonData.addOrUpdateFirstLanguageReason(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfValidDataEntered");
			reasonData.addOrUpdateSecondLanguageReason(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		reasonData.clickOnReasonsSaveButton();
		log("Verify if Reason is Created");
		softAssert.assertTrue(reasonData.isReasonHeaderDisplayed(), "Reason header is not dsplayed");
	}

	@Test(priority = 5)
	public void testIfReasonIsUpdated() throws Exception {
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		reasonData.clickOnCreatedReasons();
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfReasonsIsUpdated");
			reasonData.addOrUpdateFirstLanguageReason(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		try {
			MD_ReasonsPageTest.getDataForReasons(getClassName(), "testIfReasonsIsUpdated");
			reasonData.addOrUpdateSecondLanguageReason(AtomHC.reasonText, AtomHC.reasonDescript);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Reason is Updated");
		softAssert.assertTrue(reasonData.isReasonHeaderDisplayed(), "Reason header is not dsplayed");
	}

	@Test(priority = 6)
	public void testIfReasonIsDeleted() throws Exception {
		MD_ReasonsPage reasonData = new MD_ReasonsPage(driver);
		reasonData.clickOnUpdatedReasons();
		reasonData.clickOnReasonDeleteButton();
		reasonData.clickOnReasonDeleteOkButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Reason is Deleted");
		softAssert.assertTrue(reasonData.isReasonHeaderDisplayed(), "Reason header is not dsplayed");
	}
}