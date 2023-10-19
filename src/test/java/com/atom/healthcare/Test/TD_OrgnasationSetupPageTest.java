package com.atom.healthcare.Test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.TD_OrgnizationSetupWebElement.TD_OrgnasationSetupPageWebElement;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class TD_OrgnasationSetupPageTest extends BasePageTestNG {
	String OrganizationName;
	String domain;
	String GSTNumber;
	String defaultLanguage;

	/*
	 * This method is to get data from "TD_OrganisationSetupTest" sheet it will
	 * compare scenario coloumn 0
	 */
	private void getDataForOrgSetupPage(String className, String testScenario) throws Exception {
		try {
			for (Object[] getData : BasePageObject.readExcelFile(className)) {
				if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
					OrganizationName = (String) getData[3];
					domain = (String) getData[4];
					GSTNumber = (String) getData[5];
					defaultLanguage = (String) getData[6];
				}
			}
			TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
			orgSetup.registrationSetupDetails(OrganizationName, domain, defaultLanguage);
		} catch (IllegalArgumentException e) {
			throw new SkipException("Skipping this exception");
		}
	}

	@Test
	public void testIfOrgnizationNameAndDomainIsInvalid() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testIfOrgnizationNameAndDomainIsInvalid");
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Organisation name  is Invalid");
		softAssert.assertTrue(orgSetup.isOrgNameTexboxErrorLabelDisplay(),
				"Organisation name textbox error label is not display");
		softAssert.assertTrue(orgSetup.isDomainTexboxErrorLabelDIsplay(), "Domain textbox error label is not display");
		softAssert.assertAll();
	}

	@Test
	public void testIfMinLengthCharInOrgNameAndDomainTextbox() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testIfMinLengthCharInOrgNameAndDomainTextbox");
		SoftAssert softAssert = new SoftAssert();
		log("Verify if enter minimum length in Organization textbox and Domain textbox");
		softAssert.assertTrue(orgSetup.isOrgNameTexboxErrorLabelDisplay(),
				"Organisation name textbox error label is not display");
		softAssert.assertTrue(orgSetup.isDomainTexboxErrorLabelDIsplay(), "Domain textbox error label is not display");
		softAssert.assertAll();
	}

	@Test
	public void testIfOrganizationNameIsMissing() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testIfOrganizationNameIsMissing");
		log("Verify if Odinasation name is missing");
		Assert.assertTrue(orgSetup.isOrgNameTexboxErrorLabelDisplay(),
				"Organisation name textbox error label is not display");
	}

	@Test
	public void testIfDomainNameIsMissing() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testIfDomainNameIsMissing");
		log("Verify if Domain language is missing");
		Assert.assertTrue(orgSetup.isDomainTexboxErrorLabelDIsplay(), "Domain textbox error label is not display");
		driver.navigate().refresh();
	}

	@Test
	public void testIfDefaultLanguageIsMissing() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testIfDefaultLanguageIsMissing");
		log("Verify if default language is missing");
		Assert.assertTrue(orgSetup.isLanguageTexboxErrorLabelDIsplay(), "Default Language error label is not display");
	}

	@Test
	public void testValidOrganisationDetails() throws Exception {
		TD_OrgnasationSetupPageWebElement orgSetup = new TD_OrgnasationSetupPageWebElement(driver);
		orgSetup.clearOrganisationDetails();
		getDataForOrgSetupPage(getClassName(), "testValidOrganisationDetails");
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Enter valid oganisation detail it will navigate on Organization dashboard page");
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		softAssert.assertTrue(mainPage.isOrganisationDisplay(), "Organisation Name not display");
		softAssert.assertAll();
		mainPage.logout();
	}

}
