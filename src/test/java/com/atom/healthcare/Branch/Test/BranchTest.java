
package com.atom.healthcare.Branch.Test;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Organization.Branch;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class BranchTest extends BaseTest {
	HealthcareLogin loginPage;
	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.username"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.password")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// BranchOverview
	@Test
	public void testBranchOverviewFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchOrg();
		branch.clickOnBranchOverview();
		log("Verify Branch Overview page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getBranchOverviewTabLabel(), AtomHC.propData.getProperty("branch.overview.tab"));
		softAssert.assertEquals(branch.getBranchNameLabel(), AtomHC.propData.getProperty("branch.name.label"));
		softAssert.assertEquals(branch.getDepartmentLabel(), AtomHC.propData.getProperty("department.label"));
		softAssert.assertAll();
	}

	@Test
	public void testOrgSupportsMultipleLanguagesFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		log("Verify Org Supports Multiple Languages Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getBranchOverviewFirstLang(), AtomHC.propData.getProperty("first.lang"));
		softAssert.assertEquals(branch.getBranchOverviewSecondLang(), AtomHC.propData.getProperty("second.lang"));
		softAssert.assertAll();
	}

	@Test
	public void testDepartmentCheckboxCheckedFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.checkDepartmentCheckbox();
		log("Verify Department Checkbox Checked Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(branch.isCheckboxFirstListSelect());
		softAssert.assertEquals(branch.getBasicInputLabel(), AtomHC.propData.getProperty("basic.input.label"));
		softAssert.assertAll();
	}

	@Test
	public void testDepartmentCheckboxUnCheckedFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.uncheckDepartmentCheckbox();
		log("Verify Department Checkbox UnChecked Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(branch.isCheckboxFirstListSelect());
		softAssert.assertEquals(branch.getBasicInputLabel(), AtomHC.propData.getProperty("basic.input.label"));
		softAssert.assertAll();
	}

	@Test
	public void testSaveButtonFunctionalityOnBranchOverview() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchOverviewSecondLang();
		branch.clickOnBranchNameSecondLangTextbox();
		branch.clearBranchNameSecondLangTextbox();
		branch.clickOnBranchOverviewSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify required fields error message,if user does not enter data");
		softAssert.assertEquals(branch.getBranchNameRequiredErrorMessage(), AtomHC.propData.getProperty("branch.required.field"));
		softAssert.assertEquals(branch.getLangRequiredErrorMessage(), AtomHC.propData.getProperty("lang.required.error.message"));
		softAssert.assertAll();
	}

	// BranchContact
	@Test
	public void testBranchContactAddPageFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		log(" Verify Branch Contact Add page field");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getAddPageTypeLabel(), AtomHC.propData.getProperty("add.page.type.label"));
		softAssert.assertEquals(branch.getAddPageTypePlaceholder(), AtomHC.propData.getProperty("add.page.type.placeholde"));
		softAssert.assertTrue(branch.isTypeDropdownTextboxDisplay());
		softAssert.assertEquals(branch.getAddPageContactLabel(), AtomHC.propData.getProperty("add.page.contact.label"));
		softAssert.assertEquals(branch.getAddPageContactPlaceholder(),
				AtomHC.propData.getProperty("add.page.contact.placeholder"));
		softAssert.assertTrue(branch.isContactDropdownTextboxDisplay());
		softAssert.assertTrue(branch.isAddPageSaveButtonDisplay());
		softAssert.assertTrue(branch.isAddPageCancelButtonDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactHomeTypeDropdownFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectHomeTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnAddressDropdown();
		log("Verify Home type dropdown fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(branch.isAddressTextboxDisplayed());
		branch.clickOnAddContatctListDropdown();
		branch.clickOnEmailDropdown();
		softAssert.assertTrue(branch.isEmailTextboxDisplayed());
		branch.clickOnAddContatctListDropdown();
		branch.clickOnPhoneNoDropdown();
		softAssert.assertTrue(branch.isPhoneNoTextboxDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactPrimaryTypeDropdownFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectPrimaryTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnAddressDropdown();
		log("Verify Primary type dropdown fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(branch.isAddressTextboxDisplayed());
		branch.clickOnEmailDropdown();
		softAssert.assertTrue(branch.isEmailTextboxDisplayed());
		branch.clickOnPhoneNoDropdown();
		softAssert.assertTrue(branch.isPhoneNoTextboxDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactWorkTypeDropdownFields() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectWorkTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnAddressDropdown();
		log("Verify Work type dropdown fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(branch.isAddressTextboxDisplayed());
		branch.clickOnAddContatctListDropdown();
		branch.clickOnEmailDropdown();
		softAssert.assertTrue(branch.isEmailTextboxDisplayed());
		branch.clickOnAddContatctListDropdown();
		branch.clickOnPhoneNoDropdown();
		softAssert.assertTrue(branch.isPhoneNoTextboxDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactCloseButtonInAddEditPage() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		log("verify Close Button In Add/Edit fields");
		assertEquals(branch.getBranchContactLabel(), AtomHC.propData.getProperty("branch.contact.tab"));
	}

	@Test
	public void testBranchContactCancelButtonInAddEditPage() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddEditCancelButton();
		log("verify Cancel Button In Add/Edit fields");
		assertEquals(branch.getBranchContactLabel(), AtomHC.propData.getProperty("branch.contact.tab"));
	}

	@Test
	public void testBranchContactSelectTypePicker() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		log("verify Select Type Picker fields");
		List<String> actualaddTypeList = branch.getTypePickerList();
		List<String> expectedaddTypeList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("Branch.Contact.type.list"), "branchContactTypeList");
		assertEquals(actualaddTypeList, expectedaddTypeList);
	}

	@Test
	public void testBranchContactSelectContactPicker() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		log("verify Select Contact Picker fields");
		branch.clickOnAddContatctListDropdown();
		List<String> actualBranchContactList = branch.getAddContactList();
		List<String> expectedBranchContactList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("Branch.Contact.list"), "branchContactList");
		assertEquals(actualBranchContactList, expectedBranchContactList);
	}

	@Test
	public void testBranchContactAddressFieldsWithLessthanMinimumLength() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectWorkTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnAddressDropdown();
		log("verify Address Fields less than Minimum Length");
		branch.sendAddressFieldTextbox(AtomHC.propData.getProperty("address.textbox"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getAddressFieldErrorMessage(), AtomHC.propData.getProperty("address.field.error.message"));
		softAssert.assertEquals(branch.getBranchContactLangErrorLabel(), AtomHC.propData.getProperty("lang.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactEmailFieldsEnteredWrongRegex() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectWorkTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnEmailDropdown();
		log("verify Email Fields Entered Wrong Regex");
		branch.sendTextInEmailTextbox(AtomHC.propData.getProperty("email.field.textbox"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getEmailFieldErrorMessage(), AtomHC.propData.getProperty("email.field.error.message"));
		softAssert.assertEquals(branch.getBranchContactLangErrorLabel(), AtomHC.propData.getProperty("lang.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactPhoneNoFieldsWithEnteredMinimumLength() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		branch.clickOnSelectWorkTypeDropdown();
		branch.clickOnAddContatctListDropdown();
		branch.clickOnPhoneNoDropdown();
		log("verify PhoneNo Fields Entered Minimum Length");
		branch.enterPhoneNumber(AtomHC.propData.getProperty("phoneno.field.invalid.textbox"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getPhoneNoErrorMessage(), AtomHC.propData.getProperty("phoneno.field.error.message"));
		softAssert.assertEquals(branch.getBranchContactLangErrorLabel(), AtomHC.propData.getProperty("lang.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactSaveButtonWithoutEnteringData() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		log("verify click Save Button Without Entering Data");
		branch.clickOnAddPageSaveButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getTypeFieldReuiredMessage(), AtomHC.propData.getProperty("type.field.required.message"));
		softAssert.assertEquals(branch.getContactFieldReuiredMessage(),
				AtomHC.propData.getProperty("contact.field.required.message"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactSaveButtonWithValidData() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		branch.clickOnBranchContactAddButton();
		branch.clickOnAddPageTypeDropdown();
		log("verify click Save Button With valid Data");
		branch.addNewBranchContact("Work", "Phone No", AtomHC.mobileNum);
		assertEquals(branch.getBranchContactLabel(), AtomHC.propData.getProperty("branch.contact.tab"));
	}

	@Test
	public void testBranchContactDeleteButton() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		long mobileNo = BasePageObject.generateMobileNumber();
		AtomHC.mobileNum = String.valueOf(mobileNo);
		branch.addNewBranchContact("Work", "Phone No", AtomHC.mobileNum);
		log("verify click Delete Button field");
		branch.clickOnBranchContactRowClick();
		branch.clickOnDeleteButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getDeletePageCancelLabel(), AtomHC.propData.getProperty("delete.page.cancel.label"));
		softAssert.assertEquals(branch.getDeletePageOkLabel(), AtomHC.propData.getProperty("delete.page.ok.label"));
		softAssert.assertEquals(branch.getDeletePageDeleteLabel(), AtomHC.propData.getProperty("delete.page.label"));
		softAssert.assertEquals(branch.getDeletePageMessageLabel(), AtomHC.propData.getProperty("delete.page.confirm.message"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactDeletePageCancelButtonAction() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		long mobileNo = BasePageObject.generateMobileNumber();
		AtomHC.mobileNum = String.valueOf(mobileNo);
		branch.addNewBranchContact("Work", "Phone No", AtomHC.mobileNum);
		branch.clickOnBranchContactRowClick();
		log("verify Cancel Button from delete button its navigate to branch contact page");
		branch.clickOnDeleteButton();
		branch.clickOnDeletePageCancelButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getEditBranchContactLabel(), AtomHC.propData.getProperty("edit.branch.contact.label"));
		softAssert.assertEquals(branch.getBranchContactLabel(), AtomHC.propData.getProperty("branch.contact.tab"));
		softAssert.assertAll();
	}

	@Test
	public void testBranchContactDeletePageOkButtonAction() throws Exception {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		branch.clickOnBranchContactTab();
		long mobileNo = BasePageObject.generateMobileNumber();
		AtomHC.mobileNum = String.valueOf(mobileNo);
		branch.addNewBranchContact("Work", "Phone No", AtomHC.mobileNum);
		branch.clickOnBranchContactRowClick();
		branch.clickOnDeleteButton();
		log("verify ok Button from delete button its navigate to branch contact page");
		branch.clickOnDeletePageOkButton();
		assertEquals(branch.getBranchContactLabel(), AtomHC.propData.getProperty("branch.contact.label"));
	}

	// Branch View
	@Test
	public void testBranchViewPageFields() throws InterruptedException {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		log("verify if branch header is getting displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(branch.getBranchHeader(), AtomHC.propData.getProperty("branch.header"),
				"branch header not displayed");
		softAssert.assertTrue(branch.isOrgLogoDisplayed());
		softAssert.assertEquals(branch.getDomainName(), AtomHC.propData.getProperty("domain.name"), "domain name not displayed");
		softAssert.assertEquals(branch.getCreatedDate(), AtomHC.propData.getProperty("created.date"),
				"created date not displayed");
		softAssert.assertEquals(branch.getBranchOverview(), AtomHC.propData.getProperty("branch.overviewtab"),
				"overview tab not displayed");
		softAssert.assertEquals(branch.getContactsTab(), AtomHC.propData.getProperty("branch.contacttab"),
				"contacts tab not displayed");
		softAssert.assertAll();
	}

	@Test
	public void testTabSelectionChange() throws InterruptedException {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		log("verify if tab is getting highlighted");
		assertEquals(branch.getTabHighlightColor(), AtomHC.propData.getProperty("color.code"));
	}

	@Test
	public void testIfOrgAvatarIsPresent() throws InterruptedException {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		log("verify is org avatar is displayed");
		assertTrue(branch.isOrganizationAvatarPresent());
	}

	@Test
	public void testFirstTabShouldBeSelectedByDefault() throws InterruptedException {
		Branch branch = new Branch(driver);
		branch.clickOnBranch();
		log("verify if first tab is selected by default");
		assertEquals(branch.getTabHighlightColor(), AtomHC.propData.getProperty("color.code"));
		branch.clickOnBranchContactTab();
		assertNotEquals(branch.getTabHighlightColor(), AtomHC.propData.getProperty("color.code"));
	}
}