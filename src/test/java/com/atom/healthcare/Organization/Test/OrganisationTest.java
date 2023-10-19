package com.atom.healthcare.Organization.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Organization.Organization;
import com.atom.healthcare.OrgnizationSetup.OrgnizationSetup;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.YopMail;

public class OrganisationTest extends BaseTest {
	HealthcareLogin loginPage;
	Organization org;
	
	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Organisation View
	@Test
	public void testSystemVerifyOrganizationViewPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		log("Verify Organisation View Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isOrganizationLogoDisplay());
		softAssert.assertEquals(org.getOrganizationName(), AtomHC.propData.getProperty("neworg.name"),
				"Organization Name is wrong");
		softAssert.assertEquals(org.getDomainLabel(), AtomHC.propData.getProperty("neworg.domain.label"), "Domain Label is wrong");
		softAssert.assertEquals(org.getDomainName(), AtomHC.propData.getProperty("neworg.domain.name"), "Domain name is wrong");
		softAssert.assertEquals(org.getCreatedLabel(), AtomHC.propData.getProperty("neworg.created.label"),
				"Created Label is wrong");
		softAssert.assertEquals(org.getCreatedDate(), AtomHC.propData.getProperty("neworg.created.date"), "Created Date is wrong");
		softAssert.assertTrue(org.isOrganizationLogoDisplay());
		softAssert.assertTrue(org.isOrganizationProfileTabDisplay());
		softAssert.assertTrue(org.isOrganizationBranchOverviewTabDisplay());
		softAssert.assertTrue(org.isOrganizationContactTabDisplay());
		softAssert.assertTrue(org.isOrganizationSettingsTabDisplay());
		softAssert.assertTrue(org.isOrganizationThemeSettingsTabDisplay());
		softAssert.assertEquals(org.getOragnizationProfileTabHighLightColor(), AtomHC.propData.getProperty("profile.tab.color"));
		softAssert.assertTrue(org.isOrganizationProfilePageDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayOrganizationLogoAbsentOrPresent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getOrganizationPageTitle(), AtomHC.propData.getProperty("org.title"),
				"Organization Title is wrong");
		org.clickOnThemeSettingsTab();
		org.uploadOrganizationLogo(System.getProperty("user.dir") + AtomHC.propData.getProperty("org.logo"));
		org.clickOnSaveButton();
		driver.navigate().refresh();
		mainPage.clickOnOrginazationTab();
		org.clickOnOrganizationMenuTab();
		log("Verify Organization Logo is Present");
		softAssert.assertTrue(org.isOrganizationLogoPresentDisplay());
		org.clickOnThemeSettingsTab();
		org.clickOndeleteButton();
		org.clickOnSaveButton();
		driver.navigate().refresh();
		mainPage.clickOnOrginazationTab();
		org.clickOnOrganizationMenuTab();
		log("Verify Organization Logo is Absent");
		softAssert.assertTrue(org.isOrganizationLogoDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayOrganizationViewPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isOrganizationLogoDisplay());
		softAssert.assertEquals(org.getOrganizationName(), AtomHC.propData.getProperty("neworg.name"),
				"Organization Name is wrong");
		softAssert.assertEquals(org.getDomainLabel(), AtomHC.propData.getProperty("neworg.domain.label"), "Domain Label is wrong");
		softAssert.assertEquals(org.getDomainName(), AtomHC.propData.getProperty("neworg.domain.name"), "Domain name is wrong");
		softAssert.assertEquals(org.getCreatedLabel(), AtomHC.propData.getProperty("neworg.created.label"),
				"Created Label is wrong");
		softAssert.assertEquals(org.getCreatedDate(), AtomHC.propData.getProperty("neworg.created.date"), "Created Date is wrong");
		softAssert.assertTrue(org.isOrganizationLogoDisplay());
		softAssert.assertTrue(org.isOrganizationProfileTabDisplay());
		softAssert.assertTrue(org.isOrganizationBranchOverviewTabDisplay());
		softAssert.assertTrue(org.isOrganizationContactTabDisplay());
		softAssert.assertTrue(org.isOrganizationSettingsTabDisplay());
		softAssert.assertTrue(org.isOrganizationThemeSettingsTabDisplay());
		log("Verify First Tab content is Displayed and Selected");
		softAssert.assertEquals(org.getOragnizationProfileTabHighLightColor(), AtomHC.propData.getProperty("profile.tab.color"));
		softAssert.assertTrue(org.isOrganizationProfilePageDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testSystemHighlightTheSelectedTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		log("Verify Selected Tab is Highlighted and content is Displayed");
		SoftAssert softAssert = new SoftAssert();
		org.clickOnBranchOverviewTab();
		softAssert.assertEquals(org.getBranchOverviewTabHighLightColor(), AtomHC.propData.getProperty("branch.tab.color"));
		softAssert.assertTrue(org.isBranchOverviewPageDisplay());
		log("Verify previous tab is unselected");
		softAssert.assertEquals(org.getOragnizationProfileTabHighLightColor(),
				AtomHC.propData.getProperty("unselected.tab.color"));
		softAssert.assertAll();
	}

	// Organisation Profile
	@Test
	public void testSystemDisplayOrganizationProfilePageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		log("Verify Organization Profile Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getOrganizationProfileHeader(), AtomHC.propData.getProperty("org.profile"));
		softAssert.assertTrue(org.isOrganizationProfileSaveButtonDisplay());
		softAssert.assertEquals(org.getOrganizationLabel(), AtomHC.propData.getProperty("organisation.label"));
		softAssert.assertEquals(org.getOrganizationNameInProfileTab(), AtomHC.propData.getProperty("organisation.name"));
		softAssert.assertEquals(org.getLabelDomain(), AtomHC.propData.getProperty("organisation.domain"));
		softAssert.assertEquals(org.getOrganizationDomain(), AtomHC.propData.getProperty("organisation.domain.name"));
		softAssert.assertEquals(org.getOrgGstNumberLabel(), AtomHC.propData.getProperty("organisation.gst.number"));
		softAssert.assertEquals(org.getOrgGstNumberField(), AtomHC.propData.getProperty("organisation.gst.number.field"));
		softAssert.assertEquals(org.getOrgDefaultLangLabel(), AtomHC.propData.getProperty("organisation.default.language"));
		softAssert.assertEquals(org.getDefaultLanguages(), AtomHC.propData.getProperty("default.languages.name"));
		softAssert.assertEquals(org.getOrgSelectLangLabel(), AtomHC.propData.getProperty("organisation.select.language"));
		softAssert.assertEquals(org.getFirstSelectedLanguages(), AtomHC.propData.getProperty("first.selected.language"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemValidateOrganisationProfileRequiredField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		log("Verify Organization Profile Validation fields");
		org.clearOrgFirstLanguage((AtomHC.propData.getProperty("invalid.org.name")));
		assertEquals(org.getOrgErrorMessage(), AtomHC.propData.getProperty("org.error.message"));
	}

	@Test
	public void testSystemDisabledSelectedLanguage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.selectNewLanguage();
		driver.navigate().refresh();
		mainPage.clickOnOrginazationTab();
		org.clickOnOrganizationMenuTab();
		log("Verify Selected Language is Enabled");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isSecondLanguageDisplayed());
		org.removeSelectedLanguage();
		driver.navigate().refresh();
		mainPage.clickOnOrginazationTab();
		org.clickOnOrganizationMenuTab();
		log("Verify Selected Language is disabled");
		softAssert.assertFalse(org.isSecondLanguageDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testSystemVerifySaveButtonValidation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		log("Verify Save button validation fields");
		SoftAssert softAssert = new SoftAssert();
		org.clearOrgFirstLanguage((AtomHC.propData.getProperty("invalid.org.name")));
		softAssert.assertEquals(org.getOrgErrorMessage(), AtomHC.propData.getProperty("orr.required.error"));
		softAssert.assertEquals(org.getOrgLangErrorMessage(), AtomHC.propData.getProperty("org.lang.data.error"));
		org.clearDefaultLanguage();
		org.clickProfileSaveButton();
		softAssert.assertEquals(org.getdefaultLangErrorMessage(), AtomHC.propData.getProperty("default.error.label"));
		softAssert.assertAll();
	}

	@Test
	public void testVerifyOrganisationLanguageList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnDefaultLanguageDropdown();
		log("verify default Language List");
		SoftAssert softAssert = new SoftAssert();
		List<String> actualDefaultLanguageList = org.getdefaultLanguageList();
		List<String> expectedDefaultLanguageList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.lang.list"), "defaultLangDropdownList");
		softAssert.assertEquals(actualDefaultLanguageList, expectedDefaultLanguageList);
		org.clickOnSelectLanguageDropdown();
		List<String> actualSelectLanguageList = org.getSelectLanguageList();
		List<String> expectedSelectLanguageList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("select.lang.list"), "selectLangDropdownList");
		log("verify select Language List");
		softAssert.assertEquals(actualSelectLanguageList, expectedSelectLanguageList);
		softAssert.assertAll();
	}

	// Organisation Branch List
	@Test
	public void testSystemDisplayBranchOverviewListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnBranchOverviewTab();
		String branchTitle = org.getOrganizationBranchHeader();
		String[] getTitle = branchTitle.split(" ");
		String branchHeader = getTitle[0] + " " + getTitle[1];
		log("Verify Branch Overview Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branchHeader, "Branch Overview");
		String branchCount = branchTitle.substring(17, 18);
		log("Branch Overview Count is: " + branchCount);
		org.addNewBranch(AtomHC.propData.getProperty("first.branch.name"),
				(AtomHC.propData.getProperty("second.branch.name")));
		softAssert.assertEquals(org.getOrganizationBranchHeader(), AtomHC.propData.getProperty("branch.new.count"));
		log("Branch Overview Count is: " + branchCount);
		softAssert.assertTrue(org.isBranchSearchTextboxDisplay());
		softAssert.assertTrue(org.isBranchAddButtonDisplay());
		softAssert.assertEquals(org.getBranchLabel(), AtomHC.propData.getProperty("branch.list.header.name"));
		softAssert.assertEquals(org.getBranchDepartmentLabel(), AtomHC.propData.getProperty("dept.list.header.name"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemAbleToFilterTextInBranchOverviewSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnBranchOverviewTab();
		org.enterTextInbranchOverviewSearchBox(AtomHC.propData.getProperty("branch.search.name"));
		log("verify if Searched branch is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isFirstBranchNameDisplay());
		org.clearbranchOverviewSearchBox();
		org.enterTextInbranchOverviewSearchBox(AtomHC.propData.getProperty("branch.invalid.search.name"));
		log("verify if message is displayed, if no record is found");
		softAssert.assertEquals(org.getbranchNoRecordFoundText(), AtomHC.propData.getProperty("branch.no.record.found"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayBranchAddEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnBranchOverviewTab();
		org.clickOnBranchAddButton();
		log("Verify it display branch Add Page On Click Add button");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getBranchAddEditHeader(), AtomHC.propData.getProperty("branch.addedit.header"));
		log("Verify it display branch Edit Page on list Item Click");
		org.clickOnFirstBranch();
		softAssert.assertEquals(org.getBranchAddEditHeader(), AtomHC.propData.getProperty("branch.addedit.header"));
		softAssert.assertAll();
	}

	@Test
	public void testDisplayAddEditPageAfterClickOnListHeader() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnBranchOverviewTab();
		org.clickOnFirstHeader();
		log("verify list get sort on Click list header");
		assertTrue(org.isBranchListDisplay());
	}

	@Test
	public void testSystemDisplayNoDataFoundViewIfNoBranchAdded() throws Exception {
		loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.clickOnRegisterBtn();
		TD_RegistrationPage register = new TD_RegistrationPage(driver);
		CommonMethods cm = new CommonMethods(driver);
		cm.registerAsOrgnization();
		register.clickOnRegisterButton();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.code.subject"),
				AtomHC.propData.getProperty("email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		driver.close();
		driver.switchTo().window(list.get(0));
		register.getVerificationCode(verificationCode);
		register.clickOnVerifyButton();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		BasePageObject basePageObj = new BasePageObject(driver);
		String orgnizationName = "AlphaMD" + BasePageObject.createRandomCharacter(4);
		String domainName = "www.medical" + BasePageObject.createRandomCharacter(4) + ".com";
		log("Orgnization Name: " + orgnizationName + "    Domain Name: " + domainName);
		orgSetup.enterRegistrationSetupDetails(orgnizationName, domainName, basePageObj.generatRandomNum(), 2, 4);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnBranchOverviewTab();
		log("Verify No data found message display, if no branch added");
		assertEquals(org.getbranchNoRecordFoundText(), AtomHC.propData.getProperty("branch.no.record.found"));
	}

	// Organization contact list
	@Test
	public void testOrgContactInfoViewPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		log("Verify if tab is getting highlighted");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getTabHighlightColor(), AtomHC.propData.getProperty("org.contact.highl.color"));
		String getOrgContactHeader = org.getOrgContactHeader();
		String[] getTitle = getOrgContactHeader.split(" ");
		String getOrgContactListHeader = getTitle[0] + " " + getTitle[1];
		softAssert.assertEquals(getOrgContactListHeader, "Organisation contacts");
		String count = getOrgContactHeader.substring(23, 25);
		log("Contacts Count is: " + count);
		//softAssert.assertEquals(org.getOrgContactHeader(), AtomHC.propData.getProperty("get.contact.header"));
		softAssert.assertAll();
	}

	@Test
	public void testNoRecordsFoundMsgFromOrgContactPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		log("Verify if no records found error label is getting displayed");
		assertEquals(org.getOrgContactRecordsMessage(), AtomHC.propData.getProperty("contact.body.message"),
				"Message not displayed");

	}

	@Test
	public void testOrgListPageIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getContactLabel(), AtomHC.propData.getProperty("contact.label"), "Label not displayed");
		softAssert.assertEquals(org.getTypeLabel(), AtomHC.propData.getProperty("type.label"), "Label not displayed");
		softAssert.assertEquals(org.getDetailLabel(), AtomHC.propData.getProperty("details.label"), "Label not displayed");
		softAssert.assertAll();

	}

	@Test
	public void testUserNavigateOnOrgContactPageAfterClickOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		log("Verify if add organisation contact header is getting displayed");
		assertEquals(org.getAddOrgHeader(), AtomHC.propData.getProperty("org.contact.header"));
	}

	@Test
	public void testClickOnAnyListItemItShouldNavigateToOrgCantactAddEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnAnyListItem();
		log("Verify if edit organisation header is getting displayed");
		assertEquals(org.getEditOrgPage(), AtomHC.propData.getProperty("get.edit.org.header"));
	}

	// contacts add/edit

	@Test
	public void testUserLandsOnOrgContactAddPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		log("Verify if add organisation contact header is getting displayed");
		assertEquals(org.getAddOrgHeader(), AtomHC.propData.getProperty("org.contact.header"));

	}

	@Test
	public void testOrgContactAddEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isOrganizationCrossIconDisplayed());
		log("verify if contact add/edit cross icon is getting displayed");
		softAssert.assertEquals(org.getOrgTypeLabel(), AtomHC.propData.getProperty("org.type.label"));
		org.clickOnTypeTextbox();
		log("verify if contact add/edit placeholder is getting displayed");
		softAssert.assertEquals(org.getOrgTypeTextboxPlaceholder(), AtomHC.propData.getProperty("org.type.placeholder"));
		softAssert.assertEquals(org.getOrgContactLabel(), AtomHC.propData.getProperty("org.contact.label"));
		org.clickOnContactTextbox();
		softAssert.assertEquals(org.getOrgContactTextboxPlaceholder(), AtomHC.propData.getProperty("org.contact.placeholder"));
		softAssert.assertAll();

	}

	@Test
	public void testContactTypeEntryOnOrgAddEditPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnAddressDropdown();
		log("Verify if address label is getting displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getAddressLabel(), AtomHC.propData.getProperty("address.label"));
		org.clickOnContactTextbox();
		org.clickOnEmailDropdown();
		softAssert.assertEquals(org.getEmailLabel(), AtomHC.propData.getProperty("email.label"));
		org.clickOnContactTextbox();
		org.clickOnPhoneNoDropdown();
		softAssert.assertEquals(org.getPhoneNoLabel(), AtomHC.propData.getProperty("phone.no.label"));
		softAssert.assertAll();
	}

	@Test
	public void testOrgContactAddPageDetailsAreDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.isContactSaveButtonDisplayed();
		log("verify if add page details are displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getSaveText(), AtomHC.propData.getProperty("save.text"));
		softAssert.assertTrue(org.isContactCancelButtonDisplayed());
		softAssert.assertEquals(org.getCancelText(), AtomHC.propData.getProperty("cancel.text"));
		softAssert.assertAll();

	}

	@Test
	public void testOrgEditPagePrefilledDataIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnEmailList();
		log("Verify if Organisation Edit Page Prefilled Data Is Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getEditOrgPage(), AtomHC.propData.getProperty("get.edit.org.header"));
		softAssert.assertEquals(org.getTypeTextboxPrefilled(), AtomHC.propData.getProperty("get.type.prefilled"));
		softAssert.assertEquals(org.getContactTextboxPrefilled(), AtomHC.propData.getProperty("get.contact.prefilled"));
		softAssert.assertEquals(org.getEmailTextboxPrefilled(), AtomHC.propData.getProperty("get.email.prefilled"));
		softAssert.assertTrue(org.isContactDeleteButtonDisplayed());
		softAssert.assertEquals(org.getDeleteButtonText(), AtomHC.propData.getProperty("get.delete.text"));
		softAssert.assertAll();

	}

	@Test
	public void testSystemAbleToClickOnCloseButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnEmailList();
		org.clickOnCrossIcon();
		log("verify if org contact list page is displayed");
		assertEquals(org.getOrgContactHeader(), AtomHC.propData.getProperty("get.contact.header"));

	}

	@Test
	public void testSystemAbleToClickOnCancelButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnEmailList();
		org.clickOnCancelButton();
		log("verify if org contact list page is displayed");
		assertEquals(org.getOrgContactHeader(), AtomHC.propData.getProperty("get.contact.header"));

	}

	@Test
	public void testSystemAbleToSelectType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnTypeTextBox();
		List<String> actualTypeTextList = org.getTypeTextboxList();
		List<String> expectedTypeTextList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.Type.Text.List"), "orgTypetextboxList");
		log("verify if type textbox dropdown list is getting displayed");
		assertEquals(actualTypeTextList, expectedTypeTextList);

	}

	@Test
	public void testSystemAbleToSelectContactPickerList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		List<String> actualContactTextList = org.getContactTextboxList();
		List<String> expectedContactTextList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.Type.Text.List"), "orgContactTextboxList");
		log("verify if contact textbox dropdown list is getting displayed");
		assertEquals(actualContactTextList, expectedContactTextList);
	}

	@Test
	public void testUserDosentSelectAnyContactType() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnAddressDropdown();
		org.enterTextInAddressTextbox(AtomHC.propData.getProperty("enter.text"));
		log("verify if address error message is getting displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getAddressError(), AtomHC.propData.getProperty("get.address.error"));
		org.clickOnContactTextbox();
		org.clickOnEmailDropdown();
		log("verify if email error message is getting displayed");
		org.enterTextInEmailTextbox(AtomHC.propData.getProperty("enter.email.text"));
		softAssert.assertEquals(org.getEmailError(), AtomHC.propData.getProperty("get.email.error"));
		org.clickOnContactTextbox();
		org.clickOnPhoneNoDropdown();
		log("verify if phone no error message is getting displayed");
		org.enterTextInPhoneNoTextBox(AtomHC.propData.getProperty("enter.phone.no.text"));
		softAssert.assertEquals(org.getPhoneNoError(), AtomHC.propData.getProperty("get.phone.no.error"));
		softAssert.assertAll();
	}

	@Test
	public void testUserClickOnOrgContactSaveButtonWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnSaveButton();
		log("Verify if error label is getting displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getTypeTextboxError(), AtomHC.propData.getProperty("get.type.error"));
		softAssert.assertEquals(org.getContactTextboxError(), AtomHC.propData.getProperty("get.contact.error"));
		softAssert.assertAll();
	}

	@Test
	public void testUserClicksOnSaveWithoutEnteringAnyOneOfTheRequiredField() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnAddressDropdown();
		org.clickOnSaveButton();
		log("Verify if error label is getting displayed");
		assertEquals(org.getTypeTextboxError(), AtomHC.propData.getProperty("get.type.error"));

	}

	@Test
	public void testUserEntersAllValidDetails() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnTypeTxtBox();
		org.clickOnHomeDropdown();
		org.clickOnContactTextbox();
		org.clickOnAddressDropdown();
		org.enterTextInAddressTextbox(AtomHC.propData.getProperty("enter.add.text"));
		org.clickOnSaveButton();
		String contactHeader = org.getOrgContactHeader();
		String[] getTitle = contactHeader.split(" ");
		String contactTitle = getTitle[0] + " " + getTitle[1];
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(contactTitle, "Organisation contacts");
		log("verify if org contact list page is displayed");
		softAssert.assertEquals(contactTitle, AtomHC.propData.getProperty("get.contact.header"));
		softAssert.assertAll();

	}

	@Test
	public void testUserAbleToSeeRemovePopupMessage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnPhoneNoList();
		org.clickOnDeleteButton();
		assertEquals(org.getDeletePopupScreen(), AtomHC.propData.getProperty("get.popup.msg"));
		org.isCancelPopupBtnDisplayed();
		org.isOkPopupBtnDisplayed();
	}

	@Test
	public void testUserClicksOnCancelBtnAndNavigatesToEditOrgContactPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnPhoneNoList();
		org.clickOnDeleteButton();
		org.clickOnCancelBtn();
		log("Verify if edit organisation header is getting displayed");
		assertEquals(org.getEditOrgPage(), AtomHC.propData.getProperty("get.edit.org.header"));
	}

	@Test
	public void testUserClicksOnOkBtnAndNavigatesToEditOrgContPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnPhoneNoList();
		org.clickOnDeleteButton();
		org.clickOnOkBtn();
		log("Verify if edit organisation header is getting displayed");
		assertEquals(org.getEditOrgPage(), AtomHC.propData.getProperty("get.edit.org.header"));
	}

	@Test
	public void testUserClicksOnContactTabAndEntersInvalidAddress() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnAddressDropdown();
		org.enterTextInAddressTextbox(AtomHC.propData.getProperty("address.error.msg"));
		log("verify if address error msg is getting displayed");
		assertEquals(org.getAddressError(), AtomHC.propData.getProperty("get.address.error"));
	}

	@Test
	public void testUserClicksOnContactTabAndEntersInvalidEmail() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnEmailDropdown();
		org.enterTextInEmailTextbox(AtomHC.propData.getProperty("email.error.msg"));
		log("verify if email error msg is getting displayed");
		assertEquals(org.getEmailError(), AtomHC.propData.getProperty("get.email.error"));
	}

	@Test
	public void testUserClicksOnContactTabAndEntersInvalidPhoneNo() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnContactTab();
		org.clickOnContactAddButton();
		org.clickOnContactTextbox();
		org.clickOnPhoneNoDropdown();
		org.enterTextInPhoneNoTextBox(AtomHC.propData.getProperty("phone.error.msg"));
		log("verify if phone no error msg is getting displayed");
		assertEquals(org.getPhoneNoError(), AtomHC.propData.getProperty("get.phone.error"));
	}
//organisation theme settings

	@Test
	public void testOrgThemeSettingsTabIsHighlighted() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify if Org Theme Settings Tab Is Highlighted");
		assertEquals(org.getOrgThemeSettingsTabHighLightColor(), AtomHC.propData.getProperty("theme.highlight.color"));
	}

	@Test
	public void testOrgThemeSettingsDetailsAreDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify if theme settings header and save button is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getThemeSettingsHeader(), AtomHC.propData.getProperty("theme.header"));
		softAssert.assertTrue(org.isThemeSaveButtonDisplayed());
		softAssert.assertEquals(org.getThemeSaveButton(), AtomHC.propData.getProperty("theme.save.text"));
		softAssert.assertAll();
	}

	@Test
	public void testThemeSettingsImageControlDetails() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify if logo key label , image name and delete button is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isImageControlBoxDisplayed());
		softAssert.assertEquals(org.getLogoKeyLabelText(), AtomHC.propData.getProperty("get.logo.label"));
		softAssert.assertTrue(org.isImagePreviewDisplayed());
		softAssert.assertEquals(org.getImageName(), AtomHC.propData.getProperty("image.name"));
		softAssert.assertTrue(org.isDeleteBtnDisplayed());
		softAssert.assertEquals(org.getDeleteBtnText(), AtomHC.propData.getProperty("get.delete.button.text"));
		softAssert.assertAll();
	}

	@Test
	public void testUserIfAllTheConfigurableThemesAreDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify If All The Configurable Themes Are Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getPrimaryThemeColorLabel(), AtomHC.propData.getProperty("primary.theme.label"));
		softAssert.assertTrue(org.isPrimaryThemeColorPickerDisplayed());
		softAssert.assertEquals(org.getPrimaryThemeColorText(), AtomHC.propData.getProperty("get.primary.theme.color"));
		softAssert.assertEquals(org.getHeaderBackgroundColorLabel(), AtomHC.propData.getProperty("header.bachground.label"));
		softAssert.assertTrue(org.isHeaderBackgroundColorPickerDisplayed());
		softAssert.assertEquals(org.getHeaderBackgroundColorText(), AtomHC.propData.getProperty("get.header.background.color"));
		softAssert.assertEquals(org.getHeaderFontColorLabel(), AtomHC.propData.getProperty("header.font.label"));
		softAssert.assertTrue(org.isHeaderFontColorPickerDisplayed());
		softAssert.assertEquals(org.getHeaderFontColorText(), AtomHC.propData.getProperty("get.header.font.color"));
		softAssert.assertEquals(org.getFooterBackgroundColorLabel(), AtomHC.propData.getProperty("footer.background.label"));
		softAssert.assertTrue(org.isFooterBackgroundColorPickerDisplayed());
		softAssert.assertEquals(org.getFooterBackGroundColorText(), AtomHC.propData.getProperty("get.footer.background.color"));
		softAssert.assertEquals(org.getFooterFontColorLabel(), AtomHC.propData.getProperty("footer.font.label"));
		softAssert.assertTrue(org.isFooterFontColorPickerDisplayed());
		softAssert.assertEquals(org.getFooterFontColorText(), AtomHC.propData.getProperty("get.footer.font.color"));
		softAssert.assertAll();
	}

	@Test
	public void testUserUploadUnsupportedTypeLogo() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify if upload image error is getting displayed");
		org.uploadOrganizationLogo(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("org.upload.error.image"));
		assertEquals(org.getLogoImageUploadError(), AtomHC.propData.getProperty("logo.error"));
	}

	@Test
	public void testUserAbleToUploadLogo() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		org.uploadOrganizationLogo(System.getProperty("user.dir") + AtomHC.propData.getProperty("org.logo"));
		org.clickOnSaveButton();
		log("verify if org image name is displayed");
		assertTrue(org.isOrgUploadNameDisplayed());
	}

	@Test
	public void testIfAddedColorValueIsNotValid() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		org.clearPrimaryThemeColorBox();
		org.enterPrimaryThemeColorTextBox(AtomHC.propData.getProperty("enter.primary.textbox"));
		org.clickOnThemeSaveButton();
		log("verify if primary textbox error msg is displayed");
		assertEquals(org.getPrimaryThemeTextboxError(), AtomHC.propData.getProperty("get.primary.textbox.error"));
	}
	
	@Test
	public void testUserIfAllTheDetailsAreValidThanNavigatesToDashboardPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify If All The Configurable Themes Are Displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(org.getPrimaryThemeColorLabel(), AtomHC.propData.getProperty("primary.theme.label"));
		softAssert.assertTrue(org.isPrimaryThemeColorPickerDisplayed());
		softAssert.assertEquals(org.getPrimaryThemeColorText(), AtomHC.propData.getProperty("get.primary.theme.color"));
		softAssert.assertEquals(org.getHeaderBackgroundColorLabel(), AtomHC.propData.getProperty("header.bachground.label"));
		softAssert.assertTrue(org.isHeaderBackgroundColorPickerDisplayed());
		softAssert.assertEquals(org.getHeaderBackgroundColorText(), AtomHC.propData.getProperty("get.header.background.color"));
		softAssert.assertEquals(org.getHeaderFontColorLabel(), AtomHC.propData.getProperty("header.font.label"));
		softAssert.assertTrue(org.isHeaderFontColorPickerDisplayed());
		softAssert.assertEquals(org.getHeaderFontColorText(), AtomHC.propData.getProperty("get.header.font.color"));
		softAssert.assertEquals(org.getFooterBackgroundColorLabel(), AtomHC.propData.getProperty("footer.background.label"));
		softAssert.assertTrue(org.isFooterBackgroundColorPickerDisplayed());
		softAssert.assertEquals(org.getFooterBackGroundColorText(), AtomHC.propData.getProperty("get.footer.background.color"));
		softAssert.assertEquals(org.getFooterFontColorLabel(), AtomHC.propData.getProperty("footer.font.label"));
		softAssert.assertTrue(org.isFooterFontColorPickerDisplayed());
		softAssert.assertEquals(org.getFooterFontColorText(), AtomHC.propData.getProperty("get.footer.font.color"));
		org.clickOnThemeSaveButton();
        log("verify if it navigates to dashboard page");
		softAssert.assertTrue(org.isDashboardDisplayed());
		softAssert.assertEquals(org.getDashboardText(), AtomHC.propData.getProperty("dashboard.text"));
		softAssert.assertAll();
	}
	
	@Test
	public void testUserUploadWrongFileSize() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnThemeSettingsTab();
		log("verify if upload image error is getting displayed");
		org.uploadOrganizationLogo(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("org.upload.error.image.size"));
		assertEquals(org.getImageSizeErrorText(), AtomHC.propData.getProperty("logo.error.size"));
	}

//org settings

	@Test
	public void testIfOrgSettingsTabIsGettingHighlighted() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnSettingsTab();
		log("verify if settings tab is getting highlighted");
		assertEquals(org.getOrgSettingsTabHighLightColor(), AtomHC.propData.getProperty("get.org.settings.color"));
	}

	@Test
	public void testIfOrgSettingsHeaderIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnSettingsTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isSettingsHeaderDisplayed());
		softAssert.assertEquals(org.getSettingsHeaderText(), AtomHC.propData.getProperty("get.settings.header"));
		softAssert.assertAll();
	}

	@Test
	public void testIfOrgSettingsSaveButtonIsDisplayed() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Organization org = new Organization(driver);
		org.clickOnOrganizationMenuTab();
		org.clickOnSettingsTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(org.isSettingSaveButtonDisplayed());
		softAssert.assertEquals(org.getSettingSaveButtonText(), AtomHC.propData.getProperty("get.program.task.tab"));
		softAssert.assertAll();
	}
}
