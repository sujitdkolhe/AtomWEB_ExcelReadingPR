package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_Department;
import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_DepartmentTest extends BasePageTestNG {
	
	public static void getDepartnameData(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className))
			if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) 
			{
				AtomHC.departmentName = (String) getData[0];
			}
	}
	
	@Test(priority = 1)
	public void testDepartmentNameNotEntered() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		TD_LoginPageTest loginPage = new TD_LoginPageTest();
		loginPage.testEnterValidUsernameAndPassword();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_Department department = new MD_Department(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			department.clickOnDepartmentAddButton();
		} catch (Exception e) {
			log("User Already on department add page");
		}
			department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed for department name if data is not enetered");
		softAssrt.assertTrue(department.isDepartmentNameRequiredErrorMessageDisplayed(),
				"Department name error message is not visible");
		softAssrt.assertTrue(department.isDepartmentNameRequiredErrorMessageDisplayed(),
				"Department name language error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 2)
	public void testDepartmentNameLessThenTheRequiredRange() throws Exception {
		MD_Department department = new MD_Department(driver);
		department.clickOnDepartmentNameTextbox();
		try {
			getDepartnameData(getClassName(), "DepartmentNameLessThenTheRequiredRange");
			department.sendDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed if department name is not within range");
		softAssrt.assertTrue(department.isDepartmentNameRequiredErrorMessageDisplayed(),
				"Department name range error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 3)
	public void testDepartmentNameEnteredInOneLang() throws Exception {
		MD_Department department = new MD_Department(driver);
		department.clickOnDepartmentNameTextbox();
		try {
			getDepartnameData(getClassName(), "DepartmentNameEnteredInOneLang");
			department.sendDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed if department name is entered only in one lang");
		softAssrt.assertTrue(department.isAllLangTypeRequiredErrorMessageDisplayed(),
				"Department name language error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 4)
	public void testValidDepartmentNameIsEntered() throws Exception {
		MD_Department department = new MD_Department(driver);
		department.clearDepartmentNameTextbox();
		department.clickOnDepartmentNameTextbox();
		try {
			getDepartnameData(getClassName(), "ValidDepartmentNameIsEntered");
			department.sendDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSecondLang();
		department.clickOnDepartmentSecongLangTextbox();
		try {
			getDepartnameData(getClassName(), "ValidDepartmentNameIsEntered");
			department.sendDepartmentNameForSecondLang(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify department is added and it navigates to list page successfully");
		softAssrt.assertTrue(department.isDepartmentListPageDisplayed(),
				"Department list page is not visible");
}
	@Test(priority = 5)
	public void testEditNameOfAddedDepartment() throws Exception {
		MD_Department department = new MD_Department(driver);
		driver.navigate().refresh();
		department.clickOnDepartmentSearchTextbox();
		try {
			getDepartnameData(getClassName(), "ValidDepartmentNameIsEntered");
			department.searchAddedDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnAddedDepartment();
		department.clearDepartmentNameTextbox();
		department.clickOnDepartmentNameTextbox();
		try {
			getDepartnameData(getClassName(), "EditDepartmentName");
			department.sendDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSecondLang();
		department.clearDepartmentNameSecondLangTextbox();
		department.clickOnDepartmentSecongLangTextbox();
		try {
			getDepartnameData(getClassName(), "EditDepartmentName");
			department.sendDepartmentNameForSecondLang(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify department is edited and it navigates to list page successfully");
		softAssrt.assertTrue(department.isDepartmentListPageDisplayed(),
				"Department list page is not visible");
}
	@Test(priority = 6)
	public void testDuplicateDepartmentNameIsEntered() throws Exception {
		MD_Department department = new MD_Department(driver);
		driver.navigate().refresh();
		department.clickOnDepartmentAddButton();
		try {
			getDepartnameData(getClassName(), "ValidDepartmentNameIsEntered");
			department.sendDepartmentName(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSecondLang();
		department.clickOnDepartmentSecongLangTextbox();
		try {
			getDepartnameData(getClassName(), "ValidDepartmentNameIsEntered");
			department.sendDepartmentNameForSecondLang(AtomHC.departmentName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		department.clickOnDepartmentSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify on adding duplicate department name it does not navigate to department list page");
		softAssrt.assertTrue(department.isDepartmentAddPageDisplayed(),
				"Department list page is not visible");
}
}
