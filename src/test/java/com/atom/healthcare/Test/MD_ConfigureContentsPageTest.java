package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.atom.healthcare.MD_ConfigureContentsWebElement.MD_ConfigureContentsPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class MD_ConfigureContentsPageTest extends BasePageTestNG {
	String selectIcon;
	String title;
	String description;
	String editor;

	/*
	 * This method is to get data from "MD_ConfigureContentsPageTest" sheet it will
	 * compare scenario coloumn 0
	 */
	private void getDataForStaticContents(String className, String testScenario) throws IOException {
		try {
			for (Object[] getData : BasePageObject.readExcelFile(className)) {
				if (getData[1].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
					selectIcon = (String) getData[3];
					title = (String) getData[4];
					description = (String) getData[5];
					editor = (String) getData[6];
				}
			}
			MD_ConfigureContentsPageWebElement consentPage = new MD_ConfigureContentsPageWebElement(driver);
			consentPage.addStaticContent(System.getProperty("user.dir") + selectIcon, title, description, editor);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
	}

	@Test
	public void testAddValidStaticContents() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		MD_ConfigureContentsPageWebElement consentPage = new MD_ConfigureContentsPageWebElement(driver);
		consentPage.clickOnConfigureContentMenu();
		consentPage.selectStaticContentTab();
		log("Add Static consent Page");
		getDataForStaticContents(getClassName(), "testAddValidStaticContents");
		log("Verify After Adding static content should be visible");
		Assert.assertTrue(consentPage.isCreatedStaticContentDisplay(title),
				"Created informrd consent is not displayed");
		log("Publish static content page");
		consentPage.clickOnCreatedStaticContent(title);
		consentPage.clickOnPublishButton();
		consentPage.clickOnOKButton();
	}

}
