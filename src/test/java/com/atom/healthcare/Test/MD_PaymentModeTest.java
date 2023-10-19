package com.atom.healthcare.Test;
import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MD_MasterDataWebElement.MD_PaymentMode;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;
	

public class MD_PaymentModeTest extends BasePageTestNG {
	
	/* This method is to get data from "MD_PaymentModeTest" sheet
	 * it will compare scenario column 1
	 */
	
	public void getDataForPaymentMode(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.paymentMode= (String) getData[1];				
				}
			}
		} 	
	@Test(priority = 1)
	public void testIfPaymentModeMissing() throws Exception {
		TD_LoginPageTest login= new TD_LoginPageTest();
		login.testEnterValidUsernameAndPassword();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		masterData.clickOnMasterData();		
		MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);		
		paymentModeData.selectPaymentModesTab();
		paymentModeData.clickOnPaymentModesAddButton();
		try {
			getDataForPaymentMode(getClassName(), "testIfPaymentModeMissing");
			paymentModeData.addPaymentMode(AtomHC.paymentMode);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
	    paymentModeData.clickOnPaymentModesSaveButton();
	    SoftAssert softAssert = new SoftAssert();
	    log("Verify if Payement Mode data is Invalid");
	    softAssert.assertTrue(paymentModeData.isPaymentModeTextboxErrorLabel(), "Payment Mode textbox error label is display");
	    softAssert.assertTrue(paymentModeData.isPaymentModeLanguageErrorLabel(), "In Payment Mode Language error are display");
	    softAssert.assertAll();
	}
	@Test(priority = 2)
	public void testIfPaymetModeAddMinLengthCharacter()  throws Exception {				
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);		
				try {
					getDataForPaymentMode(getClassName(), "testIfPaymetModeAddMinLengthCharacter");				
					paymentModeData.addPaymentMode(AtomHC.paymentMode);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
				SoftAssert softAssert = new SoftAssert();
				log("Verify if Payement Mode data is Invalid");
				softAssert.assertTrue(paymentModeData.isPaymentModeTextboxErrorLabel(), "Payment Mode textbox error label is display");
				softAssert.assertTrue(paymentModeData.isPaymentModeLanguageErrorLabel(), "In Payment Mode Language error are display");
				softAssert.assertAll();		
		}		
	@Test(priority = 3)
	public void testIfLanguageTypeDataMissing()  throws Exception {			
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);		
				try {
					getDataForPaymentMode(getClassName(), "testIfLanguageTypeDataMissing");	
					paymentModeData.addPaymentMode(AtomHC.paymentMode);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
				SoftAssert softAssert = new SoftAssert();
				log("Verify if Data Added In One Language");
				softAssert.assertTrue(paymentModeData.isPaymentModeLanguageErrorLabel(), "In Payment Mode Language error are display");
				softAssert.assertAll();						
		}
	@Test(priority = 4)
	public void testAddingValidPaymetModeData() throws Exception {			
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);	
			paymentModeData.clearPaymentModesTextbox();
				try {
					getDataForPaymentMode(getClassName(), "testAddingValidPaymetModeData");	
					paymentModeData.addValidPaymentMode(AtomHC.paymentMode);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
				log("Verify payment mode is Created");
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(paymentModeData.isPaymentModeTabTextDisplayed(), "payment mode is not Created");
		}
	@Test(priority = 5)
	public void testIfPayemetModeIsUpdated() throws Exception {			
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);	
			paymentModeData.clickOnCreatedPaymentMode();
				try {
					getDataForPaymentMode(getClassName(), "testIfPayemetModeIsUpdated");	
					paymentModeData.editPaymentMode(AtomHC.paymentMode);
				} catch (SkipException e) {
					throw new SkipException("Skipping this exception");
				}
				paymentModeData.clickOnPaymentModesSaveButton();
				log("Verify payment mode is Created");
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(paymentModeData.isPaymentModeTabTextDisplayed(),  "payment mode is not updated");
		}
	
	@Test(priority = 6)
	public void testIfPayemetModeIsDeleteCancelButton() throws Exception {			
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);	
			paymentModeData.clickOnUpdatedPaymentMode();
			paymentModeData.clickOnPaymentModesDeleteCancelButton();
				log("Verify payment mode Delete popup displayed");
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(paymentModeData.isPaymentModeAddEditLabel(),  "payment mode not Add Edit Page");		
	}
	@Test(priority = 7)
	public void testIfPayemetModeIsDelete() throws Exception {			
			MD_PaymentMode paymentModeData = new MD_PaymentMode(driver);	
			paymentModeData.clickOnPaymentModesDeleteOkButton(getClassName());			
				log("Verify payment mode is Deleted");
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(paymentModeData.isPaymentModeTabTextDisplayed(),  "payment mode is not Deleted");										
	}	
		}
