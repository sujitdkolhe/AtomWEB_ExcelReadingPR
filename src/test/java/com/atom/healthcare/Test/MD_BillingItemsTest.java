package com.atom.healthcare.Test;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MD_MasterDataWebElement.MD_BillingItemsPage;
import com.atom.healthcare.MD_MasterDataWebElement.MD_Department;
import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_BillingItemsTest extends BasePageTestNG{
	
	/*
	 * This method is to get data from "MD_BillingItemsTest" sheet it will compare
	 * scenario column 1
	 */
	private static void getDataForBillingItems(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.ItemName = (String) getData[1];
			}
		}
	}

	@Test(priority = 1)
	public void testBillingItemNameNotEntered() throws Exception {
		TD_LoginPageTest login = new TD_LoginPageTest();
		login.testEnterValidUsernameAndPassword();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		MD_MasterDataPageWebElement masterData = new MD_MasterDataPageWebElement(driver);
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		mainPage.clickOnOrginazationTab();
		masterData.clickOnMasterData();
		items.clickOnBillingItemsTab();
		items.clickOnBillingItemsAddButton();
		try {
			getDataForBillingItems(getClassName(), "testIfItemNameNotEntered");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		items.clickOnBillingItemsSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify Error Message is displayed for Item name if data is not enetered in First Lang Tab");
		softAssert.assertTrue(items.isItemNameFirstLangRequiredErrorMessageDisplayed(),
				"Item name error message is not visible");
		softAssert.assertTrue(items.isAllLangTypeRequiredErrorMessageDisplayed(),
				"Item name language error message is not visible");
		softAssert.assertAll();
		items.clickOnBillingItemsSecondLangTab();
		try {
			getDataForBillingItems(getClassName(), "testIfItemNameNotEntered");
			items.addItemNameInSecondLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify Error Message is displayed for Item name if data is not enetered in Second Lang Tab");
		softAssert.assertTrue(items.isItemNameSecondLangRequiredErrorMessageDisplayed(),
				"Item name error message is not visible");
		softAssert.assertTrue(items.isAllLangTypeRequiredErrorMessageDisplayed(),
				"Item name language error message is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void testItemNameLessThenTheRequiredRange() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clickOnBillingItemsFirstLangTab();
		try {
			getDataForBillingItems(getClassName(), "testIfItemNameLessThenTheRequiredRange");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		log("Verify Error Message is displayed if Item name is not within range");
		softAssert.assertTrue(items.isRangeErrorMessageFirstlangDisplayed(),
				"Department name range error message is not visible");
		items.clickOnBillingItemsSaveButton();
		items.clickOnBillingItemsSecondLangTab();
		try {
			getDataForBillingItems(getClassName(), "testIfItemNameLessThenTheRequiredRange");
			items.addItemNameInSecondLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify Error Message is displayed if Item name is not within range");
		softAssert.assertTrue(items.isRangeErrorMessageSecondlangDisplayed(),
				"Department name range error message is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void testItemNameEnteredInOneLang() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clearItemNameSecondLangTextbox();
		items.clickOnBillingItemsFirstLangTab();
		items.clearItemNameFirstLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfItemNameEnteredInOneLang");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		items.clickOnBillingItemsSecondLangTab();
		items.clickOnBillingItemsSaveButton();
		log("Verify Error Message is displayed if Item name is entered only in one lang");
		softAssert.assertTrue(items.isAllLangTypeRequiredErrorMessageDisplayed(),
				"Item name language error message is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void testDuplicateBillingItemIsEntered() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clearItemNameSecondLangTextbox();
		items.clickOnBillingItemsFirstLangTab();
		items.clearItemNameFirstLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfDuplicateDataEntered");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		items.clickOnBillingItemsSecondLangTab();
		try {
			getDataForBillingItems(getClassName(), "testIfDuplicateDataEntered");
			items.addItemNameInSecondLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		log("Verify on adding duplicate Billing Item name it does not navigate to department list page");
		softAssert.assertTrue(items.isBillingItemAddEditPageDisplayed(), "Item Add Page is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void testValidBillingItemNameIsEntered() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clearItemNameSecondLangTextbox();
		items.clickOnBillingItemsFirstLangTab();
		items.clearItemNameFirstLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfValidBillingItemDataIsEntered");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		items.clickOnBillingItemsSecondLangTab();
		items.clearItemNameSecondLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfValidBillingItemDataIsEntered");
			items.addItemNameInSecondLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify Billing Item is added and it navigates to list page successfully");
		softAssert.assertTrue(items.isBillingItemsHeaderDisplayed(), "Item list page is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void testIfBillingItemNameIsEdited() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clickOnNewBillItemCreated();
		items.clearItemNameFirstLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfBillingItemEdited");
			items.addItemNameInFirstLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		SoftAssert softAssert = new SoftAssert();
		items.clickOnBillingItemsSecondLangTab();
		items.clearItemNameSecondLangTextbox();
		try {
			getDataForBillingItems(getClassName(), "testIfBillingItemEdited");
			items.addItemNameInSecondLangTab(AtomHC.ItemName);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify Billing Item is Edited and it navigates to list page successfully");
		softAssert.assertTrue(items.isBillingItemsHeaderDisplayed(), "Billing Items list page is not visible");
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void testIfBillingItemNameIsDeleted() throws Exception {
		MD_BillingItemsPage items = new MD_BillingItemsPage(driver);
		items.clickOnUpdatedBillItemCreated();
		items.clickOnDeleteButton();
		items.clickOnItemDeleteOkButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify Billing Item is Deleted and it navigates to list page successfully");
		softAssert.assertTrue(items.isBillingItemsHeaderDisplayed(), "Billing Items list page is not visible");
		softAssert.assertAll();
	}

}
