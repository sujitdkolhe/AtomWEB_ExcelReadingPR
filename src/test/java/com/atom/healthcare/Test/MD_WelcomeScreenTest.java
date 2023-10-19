package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MD_MasterDataWebElement.MD_WelcomeScreen;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_WelcomeScreenTest extends BasePageTestNG {
	
	public static void getWelcomeScreenData(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className))
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) 
			{
				AtomHC.sequenceNo = (String) getData[1];
				AtomHC.welcomeImage = (String) getData[2];
				AtomHC.headerText = (String) getData[3];
				AtomHC.bodyText = (String) getData[4];	
			}
	}
	
	@Test(priority = 1)
	public void testAllMandatoryFieldsMissing() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		TD_LoginPageTest loginPage = new TD_LoginPageTest();
		loginPage.testEnterValidUsernameAndPassword();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
		try {
			mainPage.clickOnOrginazationTab();
			masterData.clickOnMasterData();
			welcomeScreen.clickOnMasterDataWelcomeScreenTab();
		} catch (Exception e) {
			log("User Already on welcome screen page");
		}
			welcomeScreen.clickOnWelcomeScreenAddButton();
		welcomeScreen.clickOnWelcomeScreenSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		log("Verify Error Message is displayed for mandatory fields if data is not enetered");
		softAssrt.assertTrue(welcomeScreen.getSequenceNoRequiredErrorMsg(),
				"Sequence No error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getUploadImageRequiredErrorMsg(),
				"Image upload error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getHeaderTextRequiredErrorMsg(),
				"Header text error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getBodyTextRequiredErrorMsg(),
				"Body text error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
				"Body text error message is not visible");
		softAssrt.assertAll();
}
	@Test(priority = 2)
	public void testSequenceNoMissing() throws Exception {
		MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
		log("Verify Error Message is displayed for sequence no field");
		getWelcomeScreenData(getClassName(), "SequenceNoMissing");
		welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
		try {
			getWelcomeScreenData(getClassName(), "SequenceNoMissing");
			welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		welcomeScreen.clickOnWelcomeScreenSaveButton();
		SoftAssert softAssrt = new SoftAssert();
		softAssrt.assertTrue(welcomeScreen.getSequenceNoRequiredErrorMsg(),
				"Sequence No error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
				"Body text error message is not visible");
		softAssrt.assertAll();

	}

	@Test(priority = 3)
	public void testImageMissing() throws Exception {
		MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
		SoftAssert softAssrt = new SoftAssert();
		welcomeScreen.clearWelcomeScreenDetails();
		welcomeScreen.clickOnImageDeleteButton();
		getWelcomeScreenData(getClassName(), "ImageMissing");
		welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
		log("Verify Error Message is displayed for sequence no field");
		welcomeScreen.clickOnWelcomeScreenSaveButton();
		softAssrt.assertTrue(welcomeScreen.getUploadImageRequiredErrorMsg(),
				"Image upload error message is not visible");
		softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
				"Body text error message is not visible");
		softAssrt.assertAll();

	}

		@Test(priority = 4)
		public void testHeaderTextMissing() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			SoftAssert softAssrt = new SoftAssert();
			welcomeScreen.clearWelcomeScreenDetails();
			log("Verify Error Message is displayed for header text field");
              getWelcomeScreenData(getClassName(), "HeaderTextMissing");
            welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
       try {
    	    getWelcomeScreenData(getClassName(), "HeaderTextMissing");
			welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+ AtomHC.welcomeImage);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
			welcomeScreen.clickOnWelcomeScreenSaveButton();
			softAssrt.assertTrue(welcomeScreen.getHeaderTextRequiredErrorMsg(),
					"Header text error message is not visible");
			softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
					"Body text error message is not visible");
			softAssrt.assertAll();
}
		
		@Test(priority = 5)
		public void testBodyTextMissing() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			welcomeScreen.clickOnImageDeleteButton();
			welcomeScreen.clearWelcomeScreenDetails();
    		SoftAssert softAssrt = new SoftAssert();
			log("Verify Error Message is displayed for body text field");
			try {
			    getWelcomeScreenData(getClassName(), "BodyTextMissing");
				welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
			} catch (SkipException e) {
				throw new SkipException("Skipping this exception");
			}
			getWelcomeScreenData(getClassName(), "BodyTextMissing");
            welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
		   welcomeScreen.clickOnWelcomeScreenSaveButton();
			softAssrt.assertTrue(welcomeScreen.getBodyTextRequiredErrorMsg(),
					"Body text error message is not visible");
			softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
					"Body text error message is not visible");
			softAssrt.assertAll();
}


		@Test(priority = 6)
		public void testIncorrectFormatImage() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			//welcomeScreen.clickOnImageDeleteButton();
			//welcomeScreen.clearWelcomeScreenDetails();
			SoftAssert softAssrt = new SoftAssert();
			log("Verify Error Message is displayed for incorrect format image");
			getWelcomeScreenData(getClassName(), "IncorrectFormatImage");
            welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
		try {
			    getWelcomeScreenData(getClassName(), "IncorrectFormatImage");
				welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
			} catch (SkipException e) {
				throw new SkipException("Skipping this exception");
			}
			welcomeScreen.clickOnWelcomeScreenSaveButton();
			softAssrt.assertTrue(welcomeScreen.isImageFormatErrorMsgDisplayed(),
					"Body text error message is not visible");
			softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
					"Body text error message is not visible");
			softAssrt.assertAll();
}
		
		@Test(priority = 7)
		public void testIncorrectSizeImage() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			welcomeScreen.clearWelcomeScreenDetails();
			SoftAssert softAssrt = new SoftAssert();
			log("Verify Error Message is displayed for incorrect image size");
			getWelcomeScreenData(getClassName(), "IncorrectSizeImage");
            welcomeScreen.addWelcomeScreenDetails( AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
		try {
			  getWelcomeScreenData(getClassName(), "IncorrectSizeImage");
			 welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
			} catch (SkipException e) {
				throw new SkipException("Skipping this exception");
			}
	    welcomeScreen.clickOnWelcomeScreenSaveButton();
	    softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
				"Body text error message is not visible");
	        softAssrt.assertAll();
}

		@Test(priority = 8)
		public void testDataEnteredOnlyForOneLang() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			welcomeScreen.clearWelcomeScreenDetails();
			SoftAssert softAssrt = new SoftAssert();
			log("Verify Error Message is displayed if data is enetered in one language");
			getWelcomeScreenData(getClassName(), "DataEnteredOnlyForOneLang");
            welcomeScreen.addWelcomeScreenDetails( AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);	
            try {
			getWelcomeScreenData(getClassName(), "DataEnteredOnlyForOneLang");
				welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
			} catch (SkipException e) {
				throw new SkipException("Skipping this exception");
			}
        	welcomeScreen.clickOnWelcomeScreenSaveButton();
			softAssrt.assertTrue(welcomeScreen.getAllLangRequiredErrorMsg(),
					"Body text error message is not visible");
			softAssrt.assertAll();
}
	
		@Test(priority = 9)
		public void testEneteredAllValidDataForWelcomeScreen() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			welcomeScreen.clickOnImageDeleteButton();
    		welcomeScreen.clearWelcomeScreenDetails();
			SoftAssert softAssrt = new SoftAssert();
			log("Verify if valid data is added for welcome screen fields");
			getWelcomeScreenData(getClassName(), "EnteredAllValidDataForWelcomeScreen");
            welcomeScreen.addWelcomeScreenDetails( AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);	
            try {
			getWelcomeScreenData(getClassName(), "EnteredAllValidDataForWelcomeScreen");
				welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
			} catch (SkipException e) {
				throw new SkipException("Skipping this exception");
			}
            welcomeScreen.clickOnSecongLang();
            welcomeScreen.addWelcomeScreenDetailsForSecondLang(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);	
        	welcomeScreen.clickOnWelcomeScreenSaveButton();
			softAssrt.assertAll();
			softAssrt.assertTrue(welcomeScreen.isWelcomeScreenListPageDisplayed(),
					"WelcomeScreen is not visible");
}

		@Test(priority = 10)
		public void testEditDataForAddedWelcomeScreen() throws Exception {
			MD_WelcomeScreen welcomeScreen = new MD_WelcomeScreen(driver);
			driver.navigate().refresh();
			welcomeScreen.clickOnSearchTextbox();
			 try {
					getWelcomeScreenData(getClassName(), "EneteredAllValidDataForWelcomeScreen");
					welcomeScreen.sendAddedWelcomeScreen(AtomHC.headerText);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
			welcomeScreen.clickOnAddedWelcomeScreen();
			welcomeScreen.clearWelcomeScreenDetails();
			welcomeScreen.clickOnImageDeleteButton();
			welcomeScreen.addWelcomeScreenDetails(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);	
	            try {
				getWelcomeScreenData(getClassName(), "testEditDataForAddedWelcomeScreen");
					welcomeScreen.uploadWelcomeScreenImage(System.getProperty("user.dir")+AtomHC.welcomeImage);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
			  welcomeScreen.clickOnSecongLang();
			  welcomeScreen.clearWelcomeScreenDetailsForSecondLang();
	            welcomeScreen.addWelcomeScreenDetailsForSecondLang(AtomHC.sequenceNo, AtomHC.headerText, AtomHC.bodyText);
	        	welcomeScreen.clickOnWelcomeScreenSaveButton();
	        	SoftAssert softAssrt = new SoftAssert();
				softAssrt.assertAll();
				softAssrt.assertTrue(welcomeScreen.isWelcomeScreenListPageDisplayed(),
						"WelcomeScreen list page is not visible");
			}	
	}

			
	

