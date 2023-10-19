package com.atom.healthcare.Users.Test;


import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Dsahboard.Dashboard;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.Users.UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;
import com.atom.healthcare.util.YopMail;

public class UsersTests extends BaseTest {
	HealthcareLogin loginPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("username"),
				AtomHC.propData.getProperty("valid.password"),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// User List
	@Test
	public void testUserPageWhenSystemLoginWithnewUser() throws Exception {
		log("Create new orginozation");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		String usersHeader = usersPage.getUserTitle();
		String[] getTitle = usersHeader.split(" ");
		String userTitle = getTitle[0];
		SoftAssert softAssert = new SoftAssert();
		log("Verify User Page When System Login With new User");
		softAssert.assertEquals(userTitle, "Users");
		softAssert.assertTrue(usersPage.isUserSearchBoxDisplay());
		softAssert.assertTrue(usersPage.isAddButtonDisplay());
		softAssert.assertTrue(usersPage.isSearchIconDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testUserPageWhenSystemLoginWithOldUser() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		String usersHeader = usersPage.getUserTitle();
		String[] getTitle = usersHeader.split(" ");
		String userTitle = getTitle[0];
		log("Verify User Page When System Login With old User");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(userTitle, "Users");
		softAssert.assertTrue(usersPage.isAllUesrDisplay());
		softAssert.assertAll();
	}

	@Test(enabled=false)
	public void testUserProfilePictureIfAdded() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify User Profile Picture If Added");
		usersPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.propData.getProperty("user.image"));
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		assertTrue(usersPage.isUserImageDisplay(
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname")));
	}

	@Test
	public void testUserProfilePictureIfNotAdded() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify User Profile Picture If not Added");
		SoftAssert softAssert = new SoftAssert();
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		softAssert.assertFalse(usersPage.isUserImageDisplay(
				AtomHC.propData.getProperty("user.first.name") + " " + AtomHC.propData.getProperty("user.last.name")));
		softAssert.assertTrue(usersPage.isUserDisplay(
				AtomHC.propData.getProperty("user.first.name") + " " + AtomHC.propData.getProperty("user.last.name")));
		softAssert.assertEquals(usersPage.getGenderAndProf(), "Male | " + AtomHC.propData.getProperty("user.prof"));
		softAssert.assertEquals(usersPage.getUserMobileNum(
				AtomHC.propData.getProperty("user.first.name") + " " + AtomHC.propData.getProperty("user.last.name")),
				"Mobile Number: +91-" + AtomHC.mobileNum);
		softAssert.assertEquals(usersPage.getUserEmail(
				AtomHC.propData.getProperty("user.first.name") + " " + AtomHC.propData.getProperty("user.last.name")),
				"Email: " + AtomHC.email);
		softAssert.assertEquals(usersPage.getAdminText(), "Admin");
		softAssert.assertAll();
	}

	@Test
	public void testSystemAbleToFilterTextInUsersSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Create new User");
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		log("verify system able to filter text in users searchbox");
		String[] filterText = { AtomHC.propData.getProperty("user.fname.lname"),
				AtomHC.propData.getProperty("user.role"), AtomHC.propData.getProperty("user.profession") };
		for (int s = 0; s <= 2; s++) {
			String text = filterText[0];
			usersPage.enterTextInUserSearchBox(text);
			assertTrue(usersPage.isUsersDisplay(text));
			usersPage.clearUserSearchBox();
		}
	}

	@Test
	public void testSystemDisplayNoRecordFoundMsg() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		log("verify system Display no record found message");
		usersPage.enterTextInUserSearchBox(AtomHC.propData.getProperty("invalid.user.data"));
		assertEquals(usersPage.getNoRecordFoundMessage(), AtomHC.propData.getProperty("no.record.found.msg"));
	}

	@Test
	public void testUserAbleToNavigatAddUserPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("verify user able to navigate to add page");
		assertEquals(usersPage.getUserAddEditPageText(), AtomHC.propData.getProperty("user.add.edit.page"));
	}

	// User Add / Edit
	@Test
	public void testUsersPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("verify user able to navigate on users add/edit page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(usersPage.getUserAddEditPageText(), AtomHC.propData.getProperty("user.add.edit.page"));
		softAssert.assertTrue(usersPage.isSaveButtonDisplay());
		softAssert.assertTrue(usersPage.isCancelButtonDisplay());
		softAssert.assertEquals(usersPage.getBasicInfoLabel(), AtomHC.propData.getProperty("basic.info.label"));
		softAssert.assertEquals(usersPage.getProfileImageLabel(), AtomHC.propData.getProperty("profile.image.label"));
		softAssert.assertEquals(usersPage.getImageFileUploadInput(), AtomHC.propData.getProperty("user.upload.image.label"));
		softAssert.assertEquals(usersPage.getFirstNameLabel(), AtomHC.propData.getProperty("user.fname.label"));
		softAssert.assertTrue(usersPage.isFirstNameInputTextboxDisplay());
		softAssert.assertEquals(usersPage.getLastNameLabel(), AtomHC.propData.getProperty("user.lname.label"));
		softAssert.assertTrue(usersPage.isLastNameInputTextboxDisplay());
		softAssert.assertEquals(usersPage.getGenderLabel(), AtomHC.propData.getProperty("user.gender.label"));
		softAssert.assertTrue(usersPage.isGenderDropdownDisplay());
		softAssert.assertEquals(usersPage.getDOJLabel(), AtomHC.propData.getProperty("user.doj.label"));
		softAssert.assertTrue(usersPage.isDateOfJoiningDropdownDisplay());
		softAssert.assertEquals(usersPage.getOrginizationLabel(), AtomHC.propData.getProperty("user.org.label"));
		softAssert.assertTrue(usersPage.isOrginizationDropdownDisplay());
		softAssert.assertEquals(usersPage.getBranchLabel(), AtomHC.propData.getProperty("user.branch.label"));
		softAssert.assertTrue(usersPage.isBranchDropdownDisplay());
		softAssert.assertEquals(usersPage.getDepartmentLabel(), AtomHC.propData.getProperty("user.dept.label"));
		softAssert.assertTrue(usersPage.isDepartmentDropdownDisplay());
		softAssert.assertEquals(usersPage.getRolesLabel(), AtomHC.propData.getProperty("user.roles.label"));
		softAssert.assertTrue(usersPage.isRolesDropdownDisplay());
		softAssert.assertEquals(usersPage.getProfessionLabel(), AtomHC.propData.getProperty("user.prof.label"));
		softAssert.assertTrue(usersPage.isProfessionDropdownDisplay());
		softAssert.assertEquals(usersPage.getMobileNumberLabel(), AtomHC.propData.getProperty("user.mobile.num.label"));
		softAssert.assertTrue(usersPage.isMobNumberDropdownDisplay());
		softAssert.assertTrue(usersPage.isMobileNumbKeycodeDisplay());
		softAssert.assertEquals(usersPage.getEmailLabel(), AtomHC.propData.getProperty("user.email.label"));
		softAssert.assertTrue(usersPage.isEmailInputDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testAlreadyAddedUsersFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		usersPage.clickOnUser(
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname"));
		log("Verify Already added user fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(usersPage.isCancelButtonDisplay());
		softAssert.assertTrue(usersPage.isResendActivationButtonDisplay());
		softAssert.assertTrue(usersPage.isDeleteButtonDisplay());
		softAssert.assertEquals(usersPage.getUserName(),
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname"));
		softAssert.assertEquals(usersPage.getUserGender(), AtomHC.propData.getProperty("user.gender.male"));
		softAssert.assertEquals(usersPage.getUserProfession(), AtomHC.propData.getProperty("user.profession"));
		softAssert.assertEquals(usersPage.getUserMobNum(), "+91-" + AtomHC.mobileNum);
		softAssert.assertEquals(usersPage.getUserEmailId(), AtomHC.email);
		softAssert.assertEquals(usersPage.getProfssionLabel(), AtomHC.propData.getProperty("user.role"));
		softAssert.assertEquals(usersPage.getUserInitial(), AtomHC.propData.getProperty("user.name.initial"));
		softAssert.assertAll();
	}

	@Test
	public void testSystemShouldDisplayAllPrefilledData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		usersPage.clickOnUser(
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname"));
		log("Verify System should display all prefilled data");
		SoftAssert softAssert = new SoftAssert();
		usersPage.isfNameInputTextboxEmpty();
		softAssert.assertTrue(usersPage.islNameInputTextboxEmpty());
		softAssert.assertTrue(usersPage.islNameInputTextboxEmpty());
		softAssert.assertTrue(usersPage.isGenderInputTextboxEmpty());
		softAssert.assertTrue(usersPage.isDOJInputTextboxEmpty());
		softAssert.assertTrue(usersPage.isOrganizationTextboxEmpty());
		softAssert.assertTrue(usersPage.isRolesInputTextboxEmpty());
		softAssert.assertTrue(usersPage.isProfessionInputTextboxEmpty());
		softAssert.assertTrue(usersPage.isMobileNumInputboxEmpty());
		softAssert.assertTrue(usersPage.isEmailInputTextboxEmpty());
		softAssert.assertAll();
	}

	@Test
	public void testUserNavigateToUsersListPageAfterClickOnCancel() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		String getUserTitle = usersPage.getUserTitle();
		usersPage.clickOnAddButton();
		usersPage.clickOnCancel();
		log("Verify user navigate to users list page when click on cancel button");
		assertEquals(usersPage.getUserTitle(), getUserTitle);
	}

	@Test
	public void testUserSelectIncorrectFormatForUserImage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("User upload incorrect image format");
		usersPage.uploadProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("user.incorrect.image.format"));
		log("verify user select incorrect format of user Image");
		assertEquals(usersPage.getUserImageErrorMessage(), AtomHC.propData.getProperty("user.incorrect.error.message"));
	}

	@Test
	public void testUserSelectMoreThan2MBSizeForUserImage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("User upload image more than 2MB size");
		usersPage.uploadProfileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("user.more.than.2MB.image.size"));
		log("User select image where image size is not as per criteria");
		assertEquals(usersPage.getUserImageErrorMessage(), AtomHC.propData.getProperty("user.size.error.message"));
	}

	@Test
	public void testUserGenderDropDownFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		usersPage.clickOnGenderDropdown();
		log("Get user Gender dropdown field");
		List<String> actualDefaultGenderList = usersPage.getDefaultGenderDropdownList();
		List<String> expectedDefaultGenderList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.languages.list.path"), "usersGenderDropdownList");
		log("Verify user Default Gender dropdown list");
		assertEquals(actualDefaultGenderList, expectedDefaultGenderList);
	}

	@Test
	public void testSelectedUserGenderShouldBeDisplay() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		usersPage.clickOnGenderDropdown();
		usersPage.selectGender(AtomHC.propData.getProperty("user.gender.male"));
		String selectedGender = usersPage.getGender();
		log("Verify selected gender should be display");
		assertEquals(selectedGender, AtomHC.propData.getProperty("user.gender.male"));
	}
	
	@Test(enabled= false)
	public void testUserBranchDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		usersPage.clickOnBranchDropdown();
		log("Get Branch names");
		List<String> actualDefaultGenderList = usersPage.getBranchList();
		List<String> expectedDefaultGenderList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.languages.list.path"), "branchDropdownList");
		log("Verify user branch dropdown list");
		assertEquals(actualDefaultGenderList, expectedDefaultGenderList);
	}

	@Test(enabled= false)
	public void testUserDepartmentDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Select branch");
		usersPage.clickOnBranchDropdown();
		usersPage.selectBranch();
		log("Get Department names");
		usersPage.clickOnDepartmentDropdown();
		List<String> departmentList = usersPage.getDepartmentList();
		List<String> expectedDepartmentList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.languages.list.path"), "departmentDropdownList");
		log("Verify user department dropdown list");
		assertEquals(departmentList, expectedDepartmentList);
	}

	@Test(enabled= false)
	public void testUserRoleDropdownList() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Get user roles names");
		usersPage.clickOnRolesDropdown();
		List<String> userRolestList = usersPage.getRolesList();
		List<String> expectedRolesList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("default.languages.list.path"), "userRolesDropdownList");
		log("Verify user roles dropdown list");
		assertEquals(userRolestList, expectedRolesList);
	}

	@Test
	public void testUsersSaveButtonWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		usersPage.clickOnSaveButton();
		log("Verify user save button without entering any data");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(usersPage.getUserFirstNameErrorLabel(), AtomHC.propData.getProperty("user.fname.error.label"));
		softAssert.assertEquals(usersPage.getUserLastNameErrorLabel(), AtomHC.propData.getProperty("user.lname.error.label"));
		softAssert.assertEquals(usersPage.getUserGenderErrorLabel(), AtomHC.propData.getProperty("user.gender.error.label"));
		softAssert.assertEquals(usersPage.getUserDOJErrorLabel(), AtomHC.propData.getProperty("user.doj.error.label"));
		softAssert.assertEquals(usersPage.getUserRolesErrorLabel(), AtomHC.propData.getProperty("user.roles.error.label"));
		softAssert.assertEquals(usersPage.getUserProfErrorLabel(), AtomHC.propData.getProperty("user.prof.error.label"));
		softAssert.assertEquals(usersPage.getUserMobileNumErrorLabel(), AtomHC.propData.getProperty("user.mobile.error.label"));
		softAssert.assertEquals(usersPage.getUserEmailErrorLabel(), AtomHC.propData.getProperty("user.email.error.label"));
		softAssert.assertAll();
	}

	@Test
	public void testUsersMobileNumAndEmailFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		usersPage.addUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"), "Male",
				5, "Admin", AtomHC.propData.getProperty("user.prof"), AtomHC.propData.getProperty("invalid.mobile.no"),
				AtomHC.propData.getProperty("under.range.email"));
		log("Verify mobile number and email field on user page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(usersPage.getUserMobileNumErrorLabel(), AtomHC.propData.getProperty("mobile.textbox.error"));
		softAssert.assertEquals(usersPage.getUserEmailErrorLabel(), AtomHC.propData.getProperty("email.in.range.msg"));
		usersPage.clearEmailInputBox();
		usersPage.enterUserEmail(AtomHC.propData.getProperty("invalid.email"));
		softAssert.assertEquals(usersPage.getUserEmailErrorLabel(), AtomHC.propData.getProperty("email.invalid.msg"));
		softAssert.assertAll();
	}

	@Test
	public void testUsersDeleteButtonFunctionality() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		usersPage.clickOnUser(
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname"));
		log("Verify delete button functionality form users page");
		usersPage.clickOnDeleteButton();
		log("Delete button popup fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(usersPage.isDeletePopupLabelDisplay());
		softAssert.assertEquals(usersPage.getDeleteConfirmationLabel(), AtomHC.propData.getProperty("delete.confirmation.msg"));
		softAssert.assertTrue(usersPage.isDeletePopupCancelButtonDisplay());
		softAssert.assertTrue(usersPage.isDeletePopupNoButtonDisplay());
		log("verify user able to navigate to add page");
		usersPage.clickOnDeletePopupCancelButton();
		softAssert.assertEquals(usersPage.getUserName(),
				AtomHC.propData.getProperty("user.fname") + " " + AtomHC.propData.getProperty("user.lname"));
		usersPage.clickOnDeleteButton();
		usersPage.clickOnDeletePopupOkButton();
		String usersHeader = usersPage.getUserTitle();
		String[] getTitle = usersHeader.split(" ");
		String userTitle = getTitle[0];
		softAssert.assertEquals(userTitle, "Users");
		softAssert.assertAll();
	}

	@Test
	public void testUsersWillGetInvitationLinkOnEmailId() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		usersPage.createUser(AtomHC.propData.getProperty("user.fname"), AtomHC.propData.getProperty("user.lname"),
				"Male", 5, "Admin", AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		log("verify Users Will GetI nvitation Link On EmailId");
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("Invitation link: " + registrationLink);
		assertFalse(registrationLink.isEmpty());
	}

	// New Patient registration
	@Test
	public void testAdminAbleToLoginAndNavigateToDashboardPage() throws Exception {
		UsersPage usersPage = new UsersPage(driver);
		assertEquals(usersPage.getDashboardLabel(), AtomHC.propData.getProperty("dashboard.label"));
	}

	@Test
	public void testUserAbleToNavigateToPatientAccountCreationForm() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Patients patientPage = new Patients(driver);
		log("Verify User Navigate To Patient Account Creation Form");
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnPatientTab();
		usersPage.clickOnPatientTabAddButton();
		assertEquals(patientPage.getAddPageHeadingText(), AtomHC.propData.getProperty("patient.add.page.title"));
	}

	@Test
	public void testAdminEntersInvalidDetailsInPatientCreationForm() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnPatientTab();
		usersPage.clickOnPatientTabAddButton();
		log("Verify Admin Enters Invalid Details In Patient Creation Form");
		SoftAssert softAssert = new SoftAssert();
		usersPage.clickOnPatientTabSaveButton();
		softAssert.assertEquals(usersPage.getPatientAddEditFirstNameKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.first.name.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditLastNameKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.last.name.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditGenderKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.gender.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditDateOfBirthKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.DOB.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditPreferredLanguageKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.language.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditMobileNumberKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.number.keyerror.label"));
		softAssert.assertEquals(usersPage.getPatientAddEditEmailAddressKeyerrorLabel(),
				AtomHC.propData.getProperty("patient.addedit.email.keyerror.label"));
		softAssert.assertAll();
	}

	@Test
	public void testAdminEntersvalidDetailsInPatientCreationForm() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnPatientTab();
		usersPage.clickOnPatientTabAddButton();
		Patients patient = new Patients(driver);
		Patients patientPage = new Patients(driver);
		log("Verify Admin Enters Valid Details In Patient Creation Form");
		patient.creatPatient(AtomHC.propData.getProperty("patient.fname"), AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		String patientHeader = patientPage.getPatientListPageTitle();
		String[] getTitle = patientHeader.split(" ");
		String patientTitle = getTitle[0];
		assertEquals(patientTitle, "Patients");
	}

	// New Admin registration
	@Test
	public void testAdminAbleToLandsOnUserCreationForm() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		log("Verify Admin Able To Lands On User Creation Form");
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		assertEquals(usersPage.getBasicInfoLabel(), AtomHC.propData.getProperty("basic.info.label"));
	}

	@Test
	public void testAdminEntersInvalidDetailsInUserCreationForm() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		usersPage.clickOnSaveButton();
		log("Verify Admin Enters Invalid Details In User Creation Form");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(usersPage.getFirstNameRequiredLabel(), AtomHC.propData.getProperty("first.name.required.fields"));
		softAssert.assertEquals(usersPage.getLastNameRequiredLabel(), AtomHC.propData.getProperty("last.name.required.fields"));
		softAssert.assertEquals(usersPage.getGenderRequiredLabel(), AtomHC.propData.getProperty("gender.required.fields"));
		softAssert.assertEquals(usersPage.getDOJRequiredLabel(), AtomHC.propData.getProperty("doj.required.fields"));
		softAssert.assertEquals(usersPage.getRolesRequiredLabel(), AtomHC.propData.getProperty("roles.required.fields"));
		softAssert.assertEquals(usersPage.getProfessionRequiredLabel(), AtomHC.propData.getProperty("profession.required.fields"));
		softAssert.assertEquals(usersPage.getPhoneNoRequiredLabel(), AtomHC.propData.getProperty("phoneNO.required.fields"));
		softAssert.assertEquals(usersPage.getEmailRequiredLabel(), AtomHC.propData.getProperty("email.required.fields"));
		softAssert.assertAll();
	}

	@Test
	public void testIfAdminEntersValidDetailsThenItShouldGetLinkOnEmail() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		SoftAssert softAssert = new SoftAssert();
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		softAssert.assertFalse(registrationLink.isEmpty());
		softAssert.assertEquals(usersPage.getLoginLabel(), AtomHC.propData.getProperty("login.label"));
		softAssert.assertAll();
	}

	@Test
	public void testUserAgainUseSameRegistrationLink() throws Exception {
		UsersPage users = new UsersPage(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		SoftAssert softAssert = new SoftAssert();
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		softAssert.assertFalse(registrationLink.isEmpty());
		driver.navigate().to(registrationLink);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.subject"),
				AtomHC.propData.getProperty("login.email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		usersPage.enterVerificationCodeInVerificationTextbox(verificationCode);
		usersPage.clickOnVerifyButton();
		users.clickOnNewpasswordTextbox();
		users.sendNewpasswordTextbox(AtomHC.propData.getProperty("set.new.pass"));
		users.clickOnConfirmPasswordText();
		users.sendConfirmPasswordText(AtomHC.propData.getProperty("set.new.pass"));
		users.clickOnResetPageSetButton();
		log("verify User Set New Password And Navigated To Login Page");
		softAssert.assertEquals(usersPage.getLoginLabel(), AtomHC.propData.getProperty("login.label"));
		driver.navigate().to(registrationLink);
		log("verify User Again Use Same Registration Link Navigated To Login Page");
		softAssert.assertEquals(usersPage.getLoginLabel(), AtomHC.propData.getProperty("login.label"));
		softAssert.assertAll();
	}

	@Test
	public void testAdminEntersInvalidTwoFactorRegistartion() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(registrationLink.isEmpty());
		driver.navigate().to(registrationLink);
		UsersPage users = new UsersPage(driver);
		log("verify user enter invalid otp Three times");
		
		String filterText = null;
		for (int s = 0; s <= 2; s++) {
			filterText = AtomHC.propData.getProperty("code");
			users.enterVerificationCodeInVerificationTextbox(filterText);
			users.clearVerificationTextbox();
			softAssert.assertEquals(users.getTwoFactorAuthenticationLabel(), AtomHC.propData.getProperty("two.factor.auth.label"));
		}
		softAssert.assertAll();
	}

	@Test
	public void testAdminEntersValidTwoFactorRegistartion() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(registrationLink.isEmpty());
		driver.navigate().to(registrationLink);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.subject"),
				AtomHC.propData.getProperty("login.email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("verify valid verification code");
		usersPage.enterVerificationCodeInVerificationTextbox(verificationCode);
		usersPage.clickOnVerifyButton();
		softAssert.assertEquals(usersPage.getSetPasswordPageLabel(), AtomHC.propData.getProperty("pincode.setup.label"));
		softAssert.assertAll();
	}

	@Test
	public void testAdminEntersInvalidSetPassword() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(registrationLink.isEmpty());
		driver.navigate().to(registrationLink);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.subject"),
				AtomHC.propData.getProperty("login.email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("verify valid verification code");
		usersPage.enterVerificationCodeInVerificationTextbox(verificationCode);
		usersPage.clickOnVerifyButton();
		UsersPage users = new UsersPage(driver);
		users.clickOnNewpasswordTextbox();
		users.sendNewpasswordTextbox(AtomHC.propData.getProperty("NewPass"));
		users.clickOnConfirmPasswordText();
		users.sendConfirmPasswordText(AtomHC.propData.getProperty("ConfirmPass"));
		log("Verify  invalid Reset Password field");
		users.clickOnResetPageSetButton();
		softAssert.assertEquals(users.getNewPassErrorMessage(), AtomHC.propData.getProperty("new.pass.error.message"));
		softAssert.assertEquals(users.getConfirmPassErrorMessage(), AtomHC.propData.getProperty("confirm.pass.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testAdminEntersValidSetPassword() throws Exception {
		UsersPage users = new UsersPage(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		Dashboard dashboardPage = new Dashboard(driver);
		String orgName = dashboardPage.getOrgnizationTitle();
		String[] orgTitle = orgName.split(":");
		String title = orgTitle[1];
		log("getTitle: " + title);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Verify Admin Enters valid Details In User Creation Form ");
		usersPage.createUser(AtomHC.propData.getProperty("user.first.name"),
				AtomHC.propData.getProperty("user.last.name"), "Male", 5, "Admin",
				AtomHC.propData.getProperty("user.prof"));
		YopMail yopMail = new YopMail(driver);
		String registrationLink = yopMail.getLinkFromEmail(AtomHC.email,
				AtomHC.propData.getProperty("user.creat.link.subject") + title, 5);
		log("getTitle: " + title);
		log("Invitation link: " + registrationLink);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(registrationLink.isEmpty());
		driver.navigate().to(registrationLink);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		YopMail yopmail = new YopMail(driver);
		String verificationCode = yopmail.getVerificationCode(AtomHC.email,
				AtomHC.propData.getProperty("email.verification.subject"),
				AtomHC.propData.getProperty("login.email.verification.message"), 5);
		log("Verification code: " + verificationCode);
		softAssert.assertFalse(verificationCode.isEmpty());
		driver.close();
		driver.switchTo().window(list.get(0));
		log("verify valid verification code");
		usersPage.enterVerificationCodeInVerificationTextbox(verificationCode);
		usersPage.clickOnVerifyButton();
		log("Verify Valid Reset Password field");
		users.clickOnNewpasswordTextbox();
		users.sendNewpasswordTextbox(AtomHC.propData.getProperty("set.new.pass"));
		users.clickOnConfirmPasswordText();
		users.sendConfirmPasswordText(AtomHC.propData.getProperty("set.new.pass"));
		users.clickOnResetPageSetButton();
		softAssert.assertEquals(users.getLoginLabel(), AtomHC.propData.getProperty("login.label"));
		softAssert.assertAll();
	}

//	@Test
//	public void testUserEntersInvalidDetailsInLoginPage() throws Exception {
//		UsersPage users = new UsersPage(driver);
//		log("Verify  User Enters Invalid Details In Login Page");
//		assertEquals(users.getLoginLabel(), AtomHC.propData.getProperty("login.label"));
//	}

	@Test
	public void testUserEntersValidDetailsInLoginPage() throws Exception {
		UsersPage usersPage = new UsersPage(driver);
		log("Verify User Enters Valid Details In Login Page");
		assertEquals(usersPage.getDashboardLabel(), AtomHC.propData.getProperty("dashboard.label"));
	}

	@Test
	public void testOTPForMaximumTimeAttempt() throws Exception {
		HealthcareLogin loginPage= new HealthcareLogin(driver);
		loginPage.logout();
		loginPage.enterUsrAndPass(AtomHC.propData.getProperty("username"),
				AtomHC.propData.getProperty("valid.password"));
		UsersPage users = new UsersPage(driver);
		log("verify user enter OTP For Maximum Time");
		String[] filterText = {	"23488" };
		for (int s = 0; s <= 2; s++) {
			String text = filterText[0];
			users.enterVerificationCodeInVerificationTextbox(text);
			users.clearVerificationTextbox();
			assertEquals(users.getTwoFactorAuthenticationLabel(), AtomHC.propData.getProperty("two.factor.auth.label"));
		}
	}

	@Test
	public void testAdminEntersValidTwoFactorAuthorizationPage() throws Exception {
		UsersPage users = new UsersPage(driver);
		log("verify Valid Two Factor Authorization Page");
		assertEquals(users.getTwoFactorAuthenticationLabel(), AtomHC.propData.getProperty("two.factor.auth.label"));
	}

	@Test
	public void testNavigateToSetPincodePage() throws Exception {
		HealthcareLogin loginPage= new HealthcareLogin(driver);
		loginPage.logout();
		loginPage.enterUsrAndPassWithRememberme(AtomHC.propData.getProperty("username"),
				AtomHC.propData.getProperty("valid.password"),AtomHC.propData.getProperty("atom.verification.key"));
		UsersPage users = new UsersPage(driver);
		log("verify Navigate To Set Pincode Page");
		users.clickOnVerifyButton();
		assertEquals(users.getSetPasswordPageLabel(), AtomHC.propData.getProperty("pincode.setup.title"));
	}

	@Test
	public void testAdminClickOnRememberMeCheck() throws Exception {
		HealthcareLogin loginPage= new HealthcareLogin(driver);
		loginPage.logout();
		loginPage.enterUsrAndPassWithRememberme(AtomHC.propData.getProperty("username"),
				AtomHC.propData.getProperty("valid.password"),AtomHC.propData.getProperty("atom.verification.key"));
		UsersPage users = new UsersPage(driver);
		log("verify User click On Remember MeCheck Page In Login Page");
		SoftAssert softAssert = new SoftAssert();
		users.clickOnVerifyButton();
		users.enterPincodeInputTextbox(AtomHC.propData.getProperty("PinSet"));
		users.enterConfirmPincodeTextboxLabel(AtomHC.propData.getProperty("PinSet"));
		softAssert.assertEquals(users.getPincodeSetUpConfirmPincodeLabel(), AtomHC.propData.getProperty("confirm.password.label"));
		softAssert.assertEquals(users.getSetPasswordPageLabel(), AtomHC.propData.getProperty("pincode.setup.title"));
		softAssert.assertEquals(users.getDashboardLabel(), AtomHC.propData.getProperty("dashboard.label"));
		softAssert.assertAll();
	}
}