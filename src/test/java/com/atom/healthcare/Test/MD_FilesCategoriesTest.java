package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_FilesCategories;
import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MD_MasterDataWebElement.MD_PaymentMode;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_FilesCategoriesTest extends BasePageTestNG {

	
	/* This method is to get data from "MD_PaymentModeTest" sheet
	 * it will compare scenario column 1
	 */
	
	public void getDataForFileCategories(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.fileCategoryImage= (String) getData[1];	
				AtomHC.FileCategoryName= (String) getData[2];	
				AtomHC.Description= (String) getData[3];									
				}
			}
		} 	
	
	@Test(priority = 1)
	public void testIfFileCategoryDataIsMissing() throws Exception {	
		TD_LoginPageTest login= new TD_LoginPageTest();
		login.testEnterValidUsernameAndPassword();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		masterData.clickOnMasterData();	
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clickOnFilesCategoriesViewTab();
		fileC.clickOnFilesCategoriesAddButton();
		try {
			getDataForFileCategories(getClassName(), "testIfFileCategoryDataIsMissing");
			//fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFilesCImageErrorLabelDisplayed(), "File Categories Image error label is not display");
	    softAssert.assertTrue(fileC.isFilesCNameErrorLabelDisplayed(), "File Categories Name error label is not display");
	    softAssert.assertTrue(fileC.isFilesCDescriptionErrorLabelDisplayed(), "File Categories Desription error label is not display");
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
				
	}
	@Test(priority = 2)
	public void testIfDescriptionRangeIsMin() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		try {
			getDataForFileCategories(getClassName(), "testIfDescriptionRangeIsMin");
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFilesCDescriptionErrorLabelDisplayed(), "File Categories Desription Min charcter error label is not display");		
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	
	}
	@Test(priority = 3)
	public void testIfFileCategoryRangeIsMin() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		try {
			getDataForFileCategories(getClassName(), "testIfFileCategoryRangeIsMin");
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFilesCNameErrorLabelDisplayed(), "File Categories Name Min charcter error label is not display");
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	
	}
	
	@Test(priority = 4)
	public void testIfImageIsRequired() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clearFilesCNameTextbox();
		fileC.clearFilesCDescriptionTextbox();
		try {
			getDataForFileCategories(getClassName(), "testIfImageIsRequired");
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFilesCImageErrorLabelDisplayed(), "File Categories Image error label is not display");		
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	
	}
	@Test(priority = 5)
	public void testIfIncorrectImageFormat() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		try {
			getDataForFileCategories(getClassName(), "testIfIncorrectImageFormat");
			fileC.uploadFileCategoryImage(System.getProperty("user.dir")+AtomHC.fileCategoryImage);
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
			} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFileImageValidationErrorLabelDisplayed(), "File Categories Invalid Image error label is not display");		
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	
	}
	@Test(priority = 6)
	public void testIncorrectImageSize() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		try {
			getDataForFileCategories(getClassName(), "testIncorrectImageSize");
			fileC.uploadFileCategoryImage(System.getProperty("user.dir")+AtomHC.fileCategoryImage);
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFileImageValidationErrorLabelDisplayed(), "File Categories Invalid Image error label is not display");		
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	
	}
	@Test(priority = 7)
	public void testIfFilecategoryNameIsRequired() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clearFilesCNameTextbox();		
		try {
			getDataForFileCategories(getClassName(), "testIfFilecategoryNameIsRequired");
			fileC.uploadFileCategoryImage(System.getProperty("user.dir")+AtomHC.fileCategoryImage);
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFilesCNameErrorLabelDisplayed(), "File Categories Name error label is not display");			
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	}
	
	@Test(priority = 8)
	public void testIfDescriptionIsRequired() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clearFilesCDescriptionTextbox();
		try {
			getDataForFileCategories(getClassName(), "testIfDescriptionIsRequired");						
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");
	    softAssert.assertTrue(fileC.isFileImageValidationErrorLabelDisplayed(), "File Categories invalid Image error label is not display");					
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	}
	@Test(priority = 9)
	public void testIfLanguageTypeDataMissing() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		try {
			getDataForFileCategories(getClassName(), "testIfLanguageTypeDataMissing");
			fileC.addFilesCategories(AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFilesCLangErrorLabelDisplayed(), "File Category Language error label is not display");
	}		
	@Test(priority = 10)
	public void testIfAddingFileCategoryValidData() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);		
		try {
			getDataForFileCategories(getClassName(), "testIfAddingFileCategoryValidData");
			fileC.createFileCategory(System.getProperty("user.dir")+AtomHC.fileCategoryImage,AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFileCategoryLabelDisplayed(), "File Category label is not display");
	}	
	@Test(priority = 11)
	public void testIfUpdatedFileCategoryName() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clickOnNewFileCategoryName();	
		try {
			getDataForFileCategories(getClassName(), "testIfUpdatedFileCategoryName");
			fileC.updatedFileCategory(System.getProperty("user.dir")+AtomHC.fileCategoryImage,AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFileCategoryLabelDisplayed(), "File Category label is not display");
	}
	
	@Test(priority = 12)
	public void testIfDuplicateDataEntered() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);		
		fileC.clickOnFilesCategoriesAddButton();
		try {
			getDataForFileCategories(getClassName(), "testIfDuplicateDataEntered");
			fileC.createFileCategory(System.getProperty("user.dir")+AtomHC.fileCategoryImage,AtomHC.FileCategoryName, AtomHC.Description);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		fileC.clickOnFilesCSaveButton();	
		fileC.clickOnFileCategoriesCancelButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFileCategoryAddEditLabelDisplayed(), "File Category Add Edit label is not display");
	}	
	@Test(priority = 13)
	public void testIfFileCategoryIsDeleteCancelButton() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clickOnUpdatedFileCategoryName();			
		fileC.clickOnFileCategoryDeleteButton();
		fileC.clickOnFileCategoriesDeleteCancelButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFileCategoryLabelDisplayed(), "File Category label is not display");
	}
	
	@Test(priority = 14)
	public void testIfFileCategoryIsDelete() throws Exception {		
		MD_FilesCategories fileC = new MD_FilesCategories(driver);
		fileC.clickOnUpdatedFileCategoryName();			
		fileC.clickOnFileCategoryDeleteButton();
		fileC.clickOnFileCategoryDeleteOkButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if File Category data is Invalid");	    		
	    softAssert.assertTrue(fileC.isFileCategoryLabelDisplayed(), "File Category label is not display");
	}
	
	
	
	
}

