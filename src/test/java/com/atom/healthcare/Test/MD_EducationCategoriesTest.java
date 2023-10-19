
package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_EducationCategoriesPage;
import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_EducationCategoriesTest extends BasePageTestNG {

	public void getDataForEducationCategoriesPage(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.edCategoryImage = (String) getData[1];
				AtomHC.CategoryName = (String) getData[2];
				AtomHC.DescriptionText = (String) getData[3];
			}
		}
	}
	@Test(priority = 1)
	public void testIfEducationCategoriesDetailsPageMissing() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		TD_LoginPageTest loginPage = new TD_LoginPageTest();
		loginPage.testEnterValidUsernameAndPassword();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			educationCategories.clickOnEducationCategoriesTab();
		} catch (Exception e) {
			log("User Already on education category page");
		}
		getDataForEducationCategoriesPage(getClassName(), "testIfEducationCategoriesDetailsPageMissing");
		educationCategories.clickOnEducationCategoriesAddButton();
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify all mandatory fields is required error msg");
		softAssrt.assertTrue(educationCategories.isCategoryImageErrorMsgDisplay(),
				"Education category image is Required error msg");
		softAssrt.assertTrue(educationCategories.isCategoryNameErrorMsgDisplay(),
				"Education category name is Required error msg");
		softAssrt.assertTrue(educationCategories.isDescriptionErrorMsgDisplay(), "Description is Required error msg");
		softAssrt.assertTrue(educationCategories.isLangTypeDataErrorMsgDisplay(),
				"All Lang Type Data is Required error msg");
		softAssrt.assertAll();
	}
	@Test(priority = 2)
	public void testIfCategoriesAndDescriptionFieldIsMissing() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testIfCategoriesAndDescriptionFieldIsMissing");
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify If User Not Entering Category And Description field data it display error msg");
		softAssrt.assertTrue(educationCategories.isCategoryNameErrorMsgDisplay(),
				"Education category name is Required error msg");
		softAssrt.assertTrue(educationCategories.isDescriptionErrorMsgDisplay(), "Description is Required error msg");
		softAssrt.assertTrue(educationCategories.isLangTypeDataErrorMsgDisplay(),
				"All Lang Type Data is Required error msg");
		softAssrt.assertAll();
	}
	@Test(priority = 3)
	public void ImageMissing() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "ImageMissing");
		educationCategories.clickOnImageDelete();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user Not Uplaod image and click on save it should displaying error mgs");
		softAssrt.assertTrue(educationCategories.isCategoryImageErrorMsgDisplay(),
				"Education category image is Required error msg");
	}
	@Test(priority = 4)
	public void testIfIncorrectImageFormat() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testIfIncorrectImageFormat");
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user upload wrong image formet");
		softAssrt.assertTrue(educationCategories.isCategoryImageErrorMsgDisplay(), "Incorrect image format");
	}
	@Test(priority = 5)
	public void testIncorrectImageSize() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testIncorrectImageSize");
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user Uplaod incorrect image size");
		softAssrt.assertTrue(educationCategories.isCategoryImageErrorMsgDisplay(), "Incorrect image size");
	}
	@Test(priority = 6)
	public void testCategorynameisMissing() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testCategorynameisMissing");
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user Not enter category field data");
		softAssrt.assertTrue(educationCategories.isCategoryNameErrorMsgDisplay(), "category name is missing");
	}
	@Test(priority = 7)
	public void testIfCategoryRangeisMin() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testIfCategoryRangeisMin");
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user enter min range in category field");
		softAssrt.assertTrue(educationCategories.isCategoryNameRangeErrorMessageDisplayed(),
				"category range not proper");
	}
	@Test(priority = 8)
	public void testDescriptionisMissing() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testDescriptionisMissing");
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user not enter sescription field data");
		softAssrt.assertTrue(educationCategories.isDescriptionErrorMsgDisplay(), "description field missing");
	}
	@Test(priority = 9)
	public void testIfDescriptionRangeisMin() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testIfDescriptionRangeisMin");
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user enter min range in description field");
		softAssrt.assertTrue(educationCategories.isDescriptionRangeErrorMessageDisplayed(),
				"description range not proper");
	}
	@Test(priority = 10)
	public void testEnteringSingleLanguageData() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testEnteringSingleLanguageData");
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssrt = new SoftAssert();
		log("Verify if user enter entering single language data it display error msg");
		softAssrt.assertTrue(educationCategories.isLangTypeDataErrorMsgDisplay(), "description range not proper");
	}
	@Test(priority = 11)
	public void testDataSavedSuccessfully() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		getDataForEducationCategoriesPage(getClassName(), "testDataSavedSuccessfully");
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnSecondLangTab();
		try {
			educationCategories.addCategoryDetailsInSecondLangAddPage(AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify after saving it navigate to category list page");
		softAssrt.assertTrue(educationCategories.isCategoriesListPage(), "category list page");
	}
	@Test(priority = 12)
	public void testEditNameOfAddedProfessionName() throws Exception {
		MD_EducationCategoriesPage educationCategories = new MD_EducationCategoriesPage(driver);
		driver.navigate().refresh();
		educationCategories.clickOnEducationCategorySearchTextbox();
		try {
			getDataForEducationCategoriesPage(getClassName(), "testDataSavedSuccessfully");
			educationCategories.searchAddedCategoryName(AtomHC.CategoryName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnAddedCategory();
		educationCategories.clickOnImageDelete();
		educationCategories.clearEducationCategoryAddPage();
		try {
			getDataForEducationCategoriesPage(getClassName(), "testEditEducationCategoryFields");
			educationCategories.addCategoryDetails(System.getProperty("user.dir") + AtomHC.edCategoryImage,
					AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnSecondLangTab();
		educationCategories.clearEducationCategorySecondLangPage();
		try {
			getDataForEducationCategoriesPage(getClassName(), "testEditEducationCategoryFields");
			educationCategories.addCategoryDetailsInSecondLangAddPage(AtomHC.CategoryName, AtomHC.DescriptionText);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		educationCategories.clickOnEducationCategoriesSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertAll();
		log("Verify profession is edited and it navigates to list page successfully");
		softAssrt.assertTrue(educationCategories.isCategoriesListPage(), "Education category list page is not visible");
}
}