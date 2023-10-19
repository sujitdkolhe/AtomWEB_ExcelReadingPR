package com.atom.healthcare.Patient.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.Caregivers;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.Users.UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class CaregiversTests extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// Assign Provider List
	@Test
	public void testCaregiverListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		caregiver.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		String caregiverTitle = caregiver.getCaregiverHeader();
		String[] getTitle = caregiverTitle.split(" ");
		String caregiverHeader = getTitle[0];
		log("Verify Caregiver header Title ");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiverHeader, "Caregivers");
		String caregiverCount = getTitle[1];
		log("Verify Caregiver Count ");
		String count = caregiverCount.substring(1, 2);
		log("Caregiver Count is :" + count);
		int actual = Integer.parseInt(count);
		caregiver.clickOnAddCaregiverButton();
		log("User Name : " + userName);
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, 0, 5);
		String caregiverNewCount = caregiver.getCaregiverHeader();
		String[] getCount = caregiverNewCount.split(" ");
		String newCount = getCount[1];
		String actualCount = newCount.substring(1, 2);
		log("Caregiver Count is :" + actualCount);
		int caregiverActualCount = Integer.parseInt(actualCount);
		softAssert.assertEquals(caregiverActualCount, actual);
		softAssert.assertTrue(caregiver.isCaregiverSearchBoxDisplay());
		softAssert.assertEquals(caregiver.getSearchboxPlaceholder(), AtomHC.propData.getProperty("search.placeholder"),
				"Search Bar placeholder is wrong");
		softAssert.assertTrue(caregiver.isAddCaregiverButtonDisplay());
		softAssert.assertEquals(caregiver.getNameColumnHeader(), AtomHC.propData.getProperty("caregiver.first.column"),
				"First Column name is wrong");
		softAssert.assertEquals(caregiver.getPositionColumnHeader(),
				AtomHC.propData.getProperty("caregiver.second.column"), "Second Column name is wrong");
		softAssert.assertEquals(caregiver.getProgramColumnHeader(),
				AtomHC.propData.getProperty("caregiver.third.column"), "Third Column name is wrong");
		softAssert.assertEquals(caregiver.getFromDateColoumnHeader(),
				AtomHC.propData.getProperty("caregiver.fourth.column"), "Fourth Column name is wrong");
		softAssert.assertEquals(caregiver.getEndDateColoumnHeader(),
				AtomHC.propData.getProperty("caregiver.fifth.column"), "Fifth Column name is wrong");
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayNoDataFoundInPatientsCaregiver() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Verify Patient is Added");
		caregiver.creatPatient(AtomHC.propData.getProperty("patient.fname"),
				AtomHC.propData.getProperty("patient.lname"), AtomHC.propData.getProperty("patient.gender"),
				AtomHC.propData.getProperty("patient.birth.year"), AtomHC.propData.getProperty("patient.birth.month"),
				AtomHC.propData.getProperty("patient.birth.date"), AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(
				AtomHC.propData.getProperty("patient.fname") + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		log("Verify If no record found message Display");
		assertTrue(caregiver.isNoRecordFoundTextDisplay());
	}

	@Test
	public void testSystemAbleToFilterTextInUsersSearchbox() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		caregiver.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, 0, 5);
		log("verify system able to filter text in users searchbox");
		String[] filterText = { userName, AtomHC.propData.getProperty("user.lname") };
		for (int s = 0; s <= 2; s++) {
			String text = filterText[0];
			caregiver.enterTextInCaregiverSearchBox(text);
			assertTrue(caregiver.isSearchElementDisplay());
			caregiver.clearCaregiverSearchBox();
		}
	}

	@Test
	public void testSystemDisplayCaregiverAddEditPageInPatientTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Caregiver Add Page is Displayed");
		assertTrue(caregiver.isCaregiverAddEditHeaderDisplay());
	}

	@Test
	public void testSystemDisplayAddEditPageIfUserClickOnAnyListItem() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnFirstCaregiverRowlist();
		assertTrue(caregiver.isCaregiverAddEditHeaderDisplay());
	}

	// Assign provider AddEdit
	@Test
	public void testSystemDisplayCaregiverAddEditPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Caregiver Add/Edit Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiver.getCaregiverAddEditPageHeader(),
				AtomHC.propData.getProperty("caregiver.add.edit.header"), "The caregiver is wrong");
		softAssert.assertTrue(caregiver.isCaregiverCrossIconDisplay(), "Caregiver cross button not display");
		softAssert.assertEquals(caregiver.getOrganisationLabel(), AtomHC.propData.getProperty("org.label"),
				"Organization Label is wrong");
		softAssert.assertTrue(caregiver.isOrganisationDropdownDisplay(), "Orginization dropdown button not display");
		softAssert.assertEquals(caregiver.getBranchLabel(), AtomHC.propData.getProperty("branch.label"),
				"Branch label is wrong");
		softAssert.assertTrue(caregiver.isBranchDropdownDisplay(), "Branch dropdown button not display");
		softAssert.assertEquals(caregiver.getDepartmentLabel(), AtomHC.propData.getProperty("dept.label"),
				"Dept label is wrong");
		softAssert.assertTrue(caregiver.isDepartmentDropdownDisplay(), "Department dropdown button not display");
		softAssert.assertEquals(caregiver.getCaregiverLabel(), AtomHC.propData.getProperty("caregiver.label"),
				"caregiver label is wrong");
		softAssert.assertTrue(caregiver.isCaregiverDropdownDisplay(), "Caregiver dropdown button not display");
		softAssert.assertEquals(caregiver.getFromDateLabel(), AtomHC.propData.getProperty("from.date.label"),
				"FromDate Label is wrong");
		softAssert.assertTrue(caregiver.isFromDateDropdownDisplay(), "Froma date dropdown button not display");
		softAssert.assertEquals(caregiver.getEndDateLabel(), AtomHC.propData.getProperty("end.date.label"),
				"EndDate Label is wrong");
		softAssert.assertTrue(caregiver.isEndDateDropdownDisplay(), "End dropdown button not display");
		softAssert.assertEquals(caregiver.getCaregiverSaveButtonCaption(), AtomHC.propData.getProperty("save.caption"),
				"Save Caption is wrong");
		softAssert.assertTrue(caregiver.isCaregiverSaveButtonDisplay(), "Caregiver save button not display");
		softAssert.assertEquals(caregiver.getCaregiverCancelButtonCaption(),
				AtomHC.propData.getProperty("cancel.caption"), "Cancel Caption is wrong");
		softAssert.assertTrue(caregiver.isCaregiverCancelButtonDisplay(), "Caregiver cancel button not display");
		softAssert.assertAll();
	}

	@Test
	public void testSystemDisplayDataPrefilledAndDeleteButtonFromCaregiverListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		caregiver.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, 0, 5);
		caregiver.clickOnFirstCaregiverRowlist();
		log("Verify all data prefilled in Caregiver Edit Page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiver.getOrganisationsSelected(), AtomHC.propData.getProperty("neworg.name"),
				"Organization Name is wrong");
		softAssert.assertEquals(caregiver.getBranchSelected(), AtomHC.propData.getProperty("neworg.branch"),
				"Branch Name is wrong");
		softAssert.assertEquals(caregiver.getDepartmentSelected(), AtomHC.propData.getProperty("neworg.dept"),
				"Department Name is wrong");
		softAssert.assertEquals(caregiver.getCaregiverSelected(),
				userName + " " + AtomHC.propData.getProperty("user.lname"), "Caregiver Name is wrong");

		String fromDates = caregiver.getFromDateSelected();
		log("From Date is: " + fromDates);
		String getFromDates = fromDates.toString();
		String[] fromDate = getFromDates.split("-");
		String currentFromDate = fromDate[0] + "-" + fromDate[1] + "-" + fromDate[2];
		softAssert.assertEquals(caregiver.getFromDateSelected(), currentFromDate, "From date is not  match");
		String endDates = caregiver.getEndDateSelected();
		log("End Date is: " + endDates);
		String getEndDates = endDates.toString();
		String[] endDate = getEndDates.split("-");
		String currentEndDate = endDate[0] + "-" + endDate[1] + "-" + endDate[2];
		softAssert.assertEquals(caregiver.getEndDateSelected(), currentEndDate);
		log("Verify delete Button is displayed");
		softAssert.assertTrue(caregiver.isCaregiverDeleteButtonDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testSystemNavigateToCaregiverListPageWhenClickOnCrossButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify it display caregiver listpage after clicking on cross Icon");
		caregiver.clickOnCaregiverCrossIcon();
		assertTrue(caregiver.isCaregiverListPageDisplay());
	}

	@Test
	public void testSystemNavigateToCaregiverListPageWhenClickOnCancelButton() throws Exception {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify it display caregiver listpage after clicking on cancel button");
		caregiver.clickOnCaregiverCancelButton();
		assertTrue(caregiver.isCaregiverListPageDisplay());
	}

	@Test(enabled = false)
	public void testSystemDisplayBranchDropdownListInPatientsCaregiverTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Organisation Branch list");
		caregiver.clickOnCaregiverBranchDropdown();
		List<String> actualDefaultBranchList = caregiver.getCaregiverbranchList();
		List<String> expectedDefaultBranchList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("caregiver.branch.list"), "caregiverBranchList");
		assertEquals(actualDefaultBranchList, expectedDefaultBranchList);
	}

	@Test(enabled = false)
	public void testSystemDisplayBranchDepartmentDropdownListInPatientsCaregiverTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Caregiver First Branch Department list");
		caregiver.clickOnCaregiverFirstBranchDropdown();
		caregiver.clickOnCaregiverDeptDropdown();
		List<String> actualFirstBranchDepartmentList = caregiver.getcaregiverFirstBranchDepartmentList();
		List<String> expectedDepartmentList = BasePageObject.readJsonFile(
				AtomHC.propData.getProperty("caregiver.branch.Dept.list"), "caregiverFirstBranchDeptDropdownList");
		assertEquals(actualFirstBranchDepartmentList, expectedDepartmentList);
	}

	@Test(enabled = false)
	public void testSystemDisplayOrganizationCaregiverListInPatientTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Organisation Caregiver list");
		caregiver.clickOnCaregiverDropdown();
		List<String> actualCaregiverList = caregiver.getcaregiverList();
		List<String> expectedCaregiverList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("organisation.caregiver.list"), "caregiverDropdownList");
		assertEquals(actualCaregiverList, expectedCaregiverList);
	}

	@Test(enabled = false)
	public void testSystemDisplayBranchCaregiverDropdownListInPatientsCaregiverTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Organisation First Branch Caregiver list");
		caregiver.clickOnCaregiverFirstBranchDropdown();
		caregiver.clickOnCaregiverDropdown();
		List<String> actualFirstBranchCaregiverList = caregiver.getcaregiverList();
		List<String> expectedFirstBranchCaregiverList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("caregiver.branch.list"), "caregiverFirstBranchList");
		assertEquals(actualFirstBranchCaregiverList, expectedFirstBranchCaregiverList);
	}

	@Test(enabled = false)
	public void testSystemDisplayBranchDeptCaregiverDropdownListInPatientsCaregiverTab() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		caregiver.clickOnAddCaregiverButton();
		log("Verify Organisation First Branch Caregiver list");
		caregiver.clickOnCaregiverFirstBranchDropdown();
		caregiver.clickOnFirstDept();
		caregiver.clickOnCaregiverDropdown();
		List<String> actualFirstBranchCaregiverList = caregiver.getcaregiverList();
		List<String> expectedFirstBranchCaregiverList = BasePageObject
				.readJsonFile(AtomHC.propData.getProperty("caregiver.branchdept.list"), "deptcaregiverlist");
		assertEquals(actualFirstBranchCaregiverList, expectedFirstBranchCaregiverList);
	}

	@Test
	public void testCaregiverAddPageWithoutEnteringAnyData() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		log("Verify Caregiver Add page without entering any data");
		caregiver.clickOnAddCaregiverButton();
		caregiver.clickOnCaregiverSaveButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiver.getCaregiverErrorTextboxColor(), AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(caregiver.getCaregiverErrorMessage(),
				AtomHC.propData.getProperty("caregiver.error.message"));
		softAssert.assertEquals(caregiver.getFromDateErrorTextboxColor(), AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(caregiver.getFromDateErrorMessageText(),
				AtomHC.propData.getProperty("fromdate.error.message"));
		softAssert.assertEquals(caregiver.getEndDateErrorTextboxColor(), AtomHC.propData.getProperty("error.color"));
		softAssert.assertEquals(caregiver.getEndDateErrorMessage(),
				AtomHC.propData.getProperty("enddate.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testUserEnterFromDateGreaterThanEndDateFromCaregiverListPage() throws Exception {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		caregiver.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		log("Verify User enter From Date greater then End Date");
		caregiver.clickOnAddCaregiverButton();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate) - 2;
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, -2, 5);
		assertEquals(caregiver.getFromDateErrorMessage(), AtomHC.propData.getProperty("task.error.color"));
	}

	@Test
	public void testSystemNavigateToPatientCaregiverListPageByEnteringValidDetailsAndDisplayNewAddedCaregiver()
			throws Exception {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		caregiver.clickOnCaregiverTab();
		log("Verify New Added Caregiver Displaying in list");
		caregiver.clickOnAddCaregiverButton();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, 0, 2);
		assertTrue(caregiver.isNewlyAddedCaregiverDisplaying());
	}

	@Test
	public void testSystemCanDeleteCaregiverWhichIsNotAPartofProgram() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Caregivers caregiver = new Caregivers(driver);
		mainPage.clickOnPatientsTab();
		caregiver.clickOnAddButton();
		log("Adding new Patients");
		String patientUser = "Patient" + BasePageObject.createRandomCharacter(5);
		caregiver.creatPatient(patientUser, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		caregiver.clickOnNewAddedPatient(patientUser + " " + AtomHC.propData.getProperty("patient.lname"));
		caregiver.clickOnCaregiverTab();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate);
		caregiver.addNewPatientCaregiver(userName + " " + AtomHC.propData.getProperty("user.lname"), currentDay, 0, 2);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(caregiver.getPatientCaregiver(),
				(userName + " " + AtomHC.propData.getProperty("user.lname")));
		caregiver.clickOnFirstCaregiverRowlist();
		caregiver.clickOnCaregiverDeleteButton();
		softAssert.assertEquals(caregiver.getDeletePoPUpMessage(),
				AtomHC.propData.getProperty("patient.delete.pop.up.message"));
		softAssert.assertTrue(caregiver.isCaregiverDeleteButtonDisplay(), "Caregiver delete button is not display");
		caregiver.clickOnCancelButtonOnDeletePopUp();
		caregiver.clickOnCaregiverDeleteButton();
		log("Verify Patient Caregiver is deleted");
		caregiver.clickOnCaregiverOkButton();
		softAssert.assertTrue(caregiver.isPatientCaregiverDisplay(), "Patient Caregiver is not display");
		softAssert.assertAll();
	}

}
