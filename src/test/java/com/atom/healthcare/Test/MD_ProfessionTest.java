package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MD_MasterDataWebElement.MD_ProfessionPage;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_ProfessionTest extends BasePageTestNG {
	
	public static void getProfessionData(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className))
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) 
			{
				AtomHC.professionName = (String) getData[1];
			}
	}
	@Test(priority = 1)
	public void testProfessionNameIsMissing() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		TD_LoginPageTest loginPage = new TD_LoginPageTest();
		loginPage.testEnterValidUsernameAndPassword();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_ProfessionPage profession = new MD_ProfessionPage(driver); 
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			profession.clickOnProfessionTab();
			profession.clickOnProfessionAddButton();
		} catch (Exception e) {
			log("User Already on department add page");
		}
		profession.clickOnProfessionSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed for profession name if data is not enetered");
		softAssrt.assertTrue(profession.isProfessionNameRequiredErrorMessageDisplayed(),
				"Department name error message is not visible");
		softAssrt.assertTrue(profession.isProfessionNameRequiredErrorMessageDisplayed(),
				"Department name language error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 2)
	public void testLangTypeDataMissing() throws Exception {
		MD_ProfessionPage profession = new MD_ProfessionPage(driver); 
		profession.clearProfessionNameTextbox();
		try {
			getProfessionData(getClassName(), "testLangTypeDataMissing");
			profession.addProfessionDetails( AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed if profession name is entered only in one lang");
		softAssrt.assertTrue(profession.isAllLangTypeRequiredErrorMessageDisplayedProfession(),
				"Department name language error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 3)
	public void testProfessionNameRangIsMin() throws Exception {
		MD_ProfessionPage profession = new MD_ProfessionPage(driver);  
		profession.clearProfessionNameTextbox();
		try {
			getProfessionData(getClassName(), "testProfessionNameRangIsMin");
			profession.addProfessionDetails( AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed if profession name rang is min");
		softAssrt.assertTrue(profession.isProfessionNameRangIsMin(),
				"Profession name rang is min");
		softAssrt.assertAll();
	}
	
	@Test(priority = 4)
	public void testCreatedProfessionSuccessfully() throws Exception {
		MD_ProfessionPage profession = new MD_ProfessionPage(driver);  
		profession.clearProfessionNameTextbox();
		try {
			getProfessionData(getClassName(), "testCreatedProfessionSuccessfully");
			profession.addProfessionDetails( AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSecondLangTab();
		try {
			getProfessionData(getClassName(), "testCreatedProfessionSuccessfully");
			profession.sendProfessionNameForSecondLang(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify profession is added and it navigates to list page successfully");
		softAssrt.assertTrue(profession.isProfessionListPageDisplayed(),
				"Profession list page is not visible");
}
	@Test(priority = 5)
	public void testEditNameOfAddedProfessionName() throws Exception {
		MD_ProfessionPage profession = new MD_ProfessionPage(driver); 
		driver.navigate().refresh();
		profession.clickOnProfessionSearchTextbox();
		try {
			getProfessionData(getClassName(), "testCreatedProfessionSuccessfully");
			profession.searchAddedProfessionName(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnAddedProfession();
		profession.clearProfessionNameTextbox();
		try {
			getProfessionData(getClassName(), "testEditNameOfAddedProfessionName");
			profession.addProfessionDetails(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSecondLangTab();
		profession.clearProfessionSecondLangPage();
		try {
			getProfessionData(getClassName(), "testEditNameOfAddedProfessionName");
			profession.sendProfessionNameForSecondLang(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify profession is edited and it navigates to list page successfully");
		softAssrt.assertTrue(profession.isProfessionListPageDisplayed(),
				"Profession list page is not visible");
}
	@Test(priority = 6)
	public void testDuplicateDepartmentNameIsEntered() throws Exception {
		MD_ProfessionPage profession = new MD_ProfessionPage(driver); 
		driver.navigate().refresh();
		profession.clickOnProfessionAddButton();
		try {
			getProfessionData(getClassName(), "testEditNameOfAddedProfessionName");
			profession.addProfessionDetails(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSecondLangTab();
		try {
			getProfessionData(getClassName(), "testEditNameOfAddedProfessionName");
			profession.sendProfessionNameForSecondLang(AtomHC.professionName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		profession.clickOnProfessionSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify on adding duplicate profession name it does not navigate to department list page");
		softAssrt.assertTrue(profession.isProfessionAddPageDisplayed(),
				"Profession list page is not visible");
}
}
