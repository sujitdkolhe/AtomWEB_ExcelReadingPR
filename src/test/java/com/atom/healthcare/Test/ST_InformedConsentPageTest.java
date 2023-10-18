package com.atom.healthcare.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Utils.BaseTest;
import com.atom.healthcare.page.objects.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.page.objects.ST_InformedConsent.ST_InformedConsentPage;

public class ST_InformedConsentPageTest extends BaseTest {

	@Test(priority = 1)
	public void testInformedConsentPageForPatient() throws Exception {
		TD_LoginPageTest loginTest = new TD_LoginPageTest();
		loginTest.testIfUserEnterValidPassword();
		ST_InformedConsentPage consentPage = new ST_InformedConsentPage(driver);
		log("Verify consent page display to patient");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(consentPage.isInformedConsentHeaderDisplay(),"Informed consent header is not display");
		softAssert.assertTrue(consentPage.isConsentPageTitleDisplay(),"Consent page title is not display");
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		consentPage.clickOnConsentPageTitle();
		softAssert.assertTrue(consentPage.isConsentPageAcceptTitleDisplay(),"Consent page Aceepte title is not display");
	    consentPage.clickOnAcceptButton();
        consentPage.clickOnNextButton();
		softAssert.assertTrue(mainPage.isDashboardTitleDisplayed());

	}

}
