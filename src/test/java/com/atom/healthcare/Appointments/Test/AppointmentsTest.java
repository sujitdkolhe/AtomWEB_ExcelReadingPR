package com.atom.healthcare.Appointments.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Appointments.Appointments;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Patients.Patients;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Users.UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class AppointmentsTest extends BaseTest {//Not yet done
	HealthcareLogin appointemetPage;
	TD_RegistrationPage registerPage;
	
	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin appointemetPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url")); 
		log("Enter valid url: " + AtomHC.propData.getProperty("url")); 
		driver.navigate().refresh();
		appointemetPage.login(AtomHC.propData.getProperty("om.user.emailid"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("om.user.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}
	

//Appointment
	@Test
	public void testAppointmentPageFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		String endDates = appointment.getTodaysDateLabel();
		log("End Date is: " + endDates);
		String getDate = endDates.toString();
		String[] endDate = getDate.split(" ");
		String currentDate = endDate[0] + " " + endDate[1];
		log("verify Appointment Page Fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isAppointmentsAddButtonDisplay());
		softAssert.assertEquals(appointment.getTodaysDateLabel(), currentDate);
		softAssert.assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
		softAssert.assertEquals(appointment.getDayLabel(), AtomHC.propData.getProperty("day.label"));
		softAssert.assertEquals(appointment.getWeekLabel(), AtomHC.propData.getProperty("week.label"));
		softAssert.assertEquals(appointment.getMonthLabel(), AtomHC.propData.getProperty("month.label"));
		softAssert.assertEquals(appointment.getTabHighlightColor(), AtomHC.propData.getProperty("day.label.color.code"));
		softAssert.assertTrue(appointment.isAppointmentSwipeLeftButtonDisplay());
		softAssert.assertTrue(appointment.isAppointmentSwipeRightButtonDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testDayTabFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isAppointmentsAddButtonDisplay());
		log("verify Day page Fields");
		appointment.clickOnDayTab();
		softAssert.assertTrue(appointment.isDayTimeLabelDisplay());
		softAssert.assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
		softAssert.assertAll();
	}

	@Test
	public void testWeekTabFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		log("verify Week Page Fields");
		SoftAssert softAssert = new SoftAssert();
		appointment.clickOnWeekTab();
		softAssert.assertTrue(appointment.isWeekDateLabelDisplay());
		softAssert.assertTrue(appointment.isWeekDateLabelDsiplay());
		softAssert.assertTrue(appointment.isDayTimeLabelDisplay());
		softAssert.assertEquals(appointment.getWeekButtonLabel(), AtomHC.propData.getProperty("week.label"));
		softAssert.assertAll();

	}

	@Test
	public void testMonthTabFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		appointment.clickOnMonthTab();
		log("verify Month Page Fields");
		SoftAssert softAssert = new SoftAssert();
		appointment.clickOnMonthDateButton();
		softAssert.assertTrue(appointment.isMonthDayLabelDisplay());
		softAssert.assertTrue(appointment.isMonthCalendarDisplay());
		softAssert.assertEquals(appointment.getMonthButtonLabel(), AtomHC.propData.getProperty("month.label"));
		softAssert.assertAll();
	}

	@Test
	public void testSwipeRightSideAndSwipeLeftSideFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		mainPage.clickOnAppointmentTab();
		appointment.clickOnSwipeRightButton();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		appointment.sendAppointmentSubjectTextbox(AtomHC.propData.getProperty("appointment.subject"));
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		appointment.addNewTimeInAppointmentPage();
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		appointment.clickOnSaveButton();
		appointment.clickOnSwipeLeftButton();
		appointment.isAppointmentSwipeLeftButtonDisplay();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isAddedNewAppointmentsDisplay());
		softAssert.assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
		softAssert.assertAll();

	}

	@Test
	public void testFutureAppointmentAdded() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		appointment.sendAppointmentSubjectTextbox(AtomHC.propData.getProperty("appointment.subject"));
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 2);
		appointment.addNewTimeInAppointmentPage();
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		appointment.clickOnSaveButton();
		appointment.clickOnSwipeLeftButton();
		appointment.isAppointmentSwipeLeftButtonDisplay();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isAddedNewAppointmentsDisplay());
		softAssert.assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
		softAssert.assertAll();
	}

	@Test
	public void testAppointmentAddButtonFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		log("verify Add button display  Fields");
		assertEquals(appointment.getAppointmentAddEditLabel(),
				AtomHC.propData.getProperty("appointment.add.edit.label"));
	}

	@Test
	public void testWhenClickOnAnyApptFromCalenderControlItShouldNagivatedToApptViewPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		log("Click On Any Appt From Calender Control It Should Nagivated To Appt View");
		appointment.clickOnAppointments();
		assertEquals(appointment.getAppointmentAddEditLabel(), AtomHC.propData.getProperty("video.calling.label"));
	}

	// Add Edit appointment

	@Test
	public void testUserLandsOnAppointmentAddEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		log("Verify Add Button click In Appt view page");
		assertEquals(appointment.getAppointmentAddEditLabel(),
				AtomHC.propData.getProperty("appointment.add.edit.label"));
	}

	@Test
	public void testAppointmentAddPageFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		log("Verify Appointment Add/Edit page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(appointment.getAppointmentAddEditLabel(),
				AtomHC.propData.getProperty("appointment.add.edit.label"));
		softAssert.assertTrue(appointment.isDisplayCrossIconButtonDisplay());
		softAssert.assertEquals(appointment.getAppointmentSubjectLabel(),
				AtomHC.propData.getProperty("appointment.subject.label"));
		softAssert.assertEquals(appointment.getAppointmentSubjectPlaceholder(),
				AtomHC.propData.getProperty("appointment.subject.placeholder"));
		softAssert.assertTrue(appointment.isAppointmentSubjectTextboxDisplay());
		softAssert.assertEquals(appointment.getAppointmentInformationLabel(), AtomHC.propData.getProperty("information.label"));
		softAssert.assertEquals(appointment.getAppointmentInformationPlaceholder(),
				AtomHC.propData.getProperty("information.placeholder"));
		softAssert.assertTrue(appointment.isAppointmentInformationTextboxDisplay());
		softAssert.assertEquals(appointment.getAppointmentTypeLabel(), AtomHC.propData.getProperty("appointment.type.label"));
		softAssert.assertEquals(appointment.getAppointmentTypePlaceholder(),
				AtomHC.propData.getProperty("appointment.type.placeholder"));
		appointment.clickOnAppointmentTypeTextbox();
//		
//		List<String> actualAppointmentTypeList = appointment.getAppointmentTypeList();
//		List<String> expectedAppointmentTypeList = BasePageObject
//				.readJsonFile(AtomHC.propData.getProperty("appointment.type.list"), "appointmentTypeList");
		//softAssert.assertEquals(actualAppointmentTypeList, expectedAppointmentTypeList);
		softAssert.assertEquals(appointment.getStartsLabel(), AtomHC.propData.getProperty("appointment.start.label"));
		softAssert.assertTrue(appointment.isStartsTextboxDisplay());
		softAssert.assertTrue(appointment.isStartTimePickerTextboxDisplay());
		softAssert.assertEquals(appointment.getEndLabel(), AtomHC.propData.getProperty("appointment.end.label"));
		softAssert.assertTrue(appointment.isEndTextboxDisplay());
		softAssert.assertTrue(appointment.isEndTimePickerTextboxDisplay());
		softAssert.assertEquals(appointment.getParticipantsLabel(), AtomHC.propData.getProperty("appointment.participants.label"));
		softAssert.assertEquals(appointment.getParticipantsPlaceholder(),
				AtomHC.propData.getProperty("appointment.participants.placeholder"));
		softAssert.assertTrue(appointment.isParticipantsTextboxDisplay());
		softAssert.assertTrue(appointment.isAppointmentsSaveButtonDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testParticipantDropdownSatusLabelDisplayFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		// appointment.addNewTimeInAppointmentPage();
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.clickOnCaregiverSelectionNoLabel();
		log("Verify in Participant Dropdown after select caregiver, caregiver status display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isParticipantsAvailableStatusDisplay());
		softAssert.assertTrue(appointment.isParticipantsUnavailableStatusDisplay());
		softAssert.assertAll();

	}

	@Test
	public void testSaveButtonWithoutEnteringMandatoryFields() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnAppointmentAddButton();
		
		appointment.clickOnSaveButton();
		log("Verify click on Save Button Without Entering Mandatory is display error message");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(appointment.getAppointmentSubjectTextKey1ErrorLabel(),
				AtomHC.propData.getProperty("appointment.subject.is.required"));
		softAssert.assertEquals(appointment.getAppointmentTypeTextKeyErrorLabel(),
				AtomHC.propData.getProperty("appointment.type.is.required"));
		softAssert.assertEquals(appointment.getStartsTextKeyErrorLabel(), AtomHC.propData.getProperty("starts.is.required"));
		softAssert.assertEquals(appointment.getEndTextKeyErrorLabel(), AtomHC.propData.getProperty("end.is.required"));
		softAssert.assertEquals(appointment.getParticipantsTextKeyErrorLabel(),
				AtomHC.propData.getProperty("participants.is.required"));
		softAssert.assertAll();
	}

	@Test
	public void testSelectStartDateGreaterThanEndDate() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, -1);
		// appointment.addNewTimeInAppointmentPage();
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		log("Verify appt start Date greater then End Date");
		assertEquals(appointment.getAppointmentGreaterThanErrorMessage(),
				AtomHC.propData.getProperty("data.invalid.error.label"));

	}

	@Test(priority = 1)
	public void testSaveButtonWithValidData() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		// appointment.addNewTimeInAppointmentPage();
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.addAppointmentsSubject(AtomHC.apptName);
		log("verify Click on Save Button its navigate to Appointment view page");
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));

	}

	@Test(priority = 2, dependsOnMethods = { "testSaveButtonWithValidData" })
	public void testAddNewAppointmentAndViewApptStatusField() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		log("verify Add New Appointment And View appt Status ");
		assertTrue(appointment.isAppointmentsNewLabelDisplay());
	}

	@Test(priority = 3, dependsOnMethods = { "testSaveButtonWithValidData" })
	public void testClickOnAppointmentGoToEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		appointment.clickOnEditButton();
		log("click on edit button,verify edit page Field");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(appointment.isCancelMeetingButtonDisplay());
		softAssert.assertEquals(appointment.getAppointmentViewTypeLabel(),
				AtomHC.propData.getProperty("appointment.add.edit.label"));
		softAssert.assertAll();

	}

	@Test
	public void testCloseAppointmentAddEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		
		appointment.clickOnCrossIcon();
		log("click on close icon its navigate Appt View page");
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
	}

	@Test(priority = 1)
	public void testEditDeclineButtonPageField() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients"); 
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		// appointment.addNewTimeInAppointmentPage();
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.addAppointmentsSubject(AtomHC.apptName);
		appointment.clickOnDeclineButton();
		
		log("verify decline page fields from add/edit page");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(appointment.getDeclineAppointmentLabel(),
				AtomHC.propData.getProperty("decline.appointment.label"));
		softAssert.assertTrue(appointment.isDeclineAppointmentCancelButton());
		softAssert.assertTrue(appointment.isDeclineAppointmentOkButtonDisplay());
		softAssert.assertTrue(appointment.isDeclineAppointmentOkButtonDisplay());
		softAssert.assertAll();
	}

	@Test(priority = 2, dependsOnMethods = { "testEditDeclineButtonPageField" })
	public void testEditDeleteAppointmentCancelButton() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		appointment.clickOnDeclineButton();
		
		appointment.clickOnDeclineAppointmentCancelButton();
		log("verify cancel Button from Decline page its navigate to Appointment view page");
		assertEquals(appointment.getAppointmentViewTypeLabel(), AtomHC.propData.getProperty("video.calling.label"));
	}

	@Test(priority = 3, dependsOnMethods = { "testEditDeclineButtonPageField" })
	public void testEditDeleteAppointmentOkButton() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		appointment.clickOnDeclineButton();
		
		appointment.clickOnDeclineAppointmentOkButton();
		log("verify ok Button from Decline button its navigate to Appointment page");
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
	}

	// Appointment View
	@Test
	public void testAppointmentViewPageField() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		String appointmentSubject = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + appointmentSubject);
		appointment.addSubjectInTextbox(appointmentSubject);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		appointment.addNewTimeInAppointmentPage();
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.addAppointmentsSubject(appointmentSubject);
		
		log("verify Appointment view page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(appointment.getAppointmentViewTypeLabel(), AtomHC.propData.getProperty("video.calling.label"));
		String participantsLabel = appointment.getAppointmentViewParticipantsLabel();
		String[] getTitle = participantsLabel.split(" ");
		String participantsLabelHeader = getTitle[0];
		softAssert.assertEquals(participantsLabelHeader, "Participants");
		String ParticipantsCount = participantsLabel.substring(13, 14);
		log("Participants Count is: " + ParticipantsCount);
		softAssert.assertTrue(appointment.isAppointmentViewDateTimeLabel());
		softAssert.assertTrue(appointment.isAppointmentViewProfilePicDisplay());
		softAssert.assertTrue(appointment.isAppointmentViewProfileNameDisplay());
		softAssert.assertTrue(appointment.isAppointmentViewProfileProfessionDisplay());
		softAssert.assertTrue(appointment.isAppointmentStatusDisplay());
		softAssert.assertTrue(appointment.isAppointmentViewDeclineButtonDisplay());
		softAssert.assertTrue(appointment.isAppointmentViewEditButtonDisplay());
		softAssert.assertTrue(appointment.isAppointmentViewAcceptButtonDisplay());
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void testWhenClickOnCancelButtonItsNagivatedToApptPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		// appointment.addNewTimeInAppointmentPage();
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.addAppointmentsSubject(AtomHC.apptName);
		
		appointment.clickOnCrossIcon();
		log("verify Appointment view Cross Icon Fields");
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));

	}

	@Test(priority = 2, dependsOnMethods = { "testClinkOnCancelButtonFields" })
	public void testWhenClickOnEditButtonItsNagivatedToAddEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		appointment.clickOnEditButton();
		log("verify When Click On Edit Button Its Nagivated To Add/Edit Page");
		assertEquals(appointment.getAppointmentAddEditLabel(),
				AtomHC.propData.getProperty("appointment.add.edit.label"));

	}

	@Test(priority = 3, dependsOnMethods = { "testClinkOnCancelButtonFields" })
	public void testWhenClickOnAcceptButtonItsNavigatedApptViewPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		
		appointment.clickOnAppointmentsViewAcceptedButton();
		log("verify click on Accept button fields  its nagivated to appt view page");
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));

	}

	@Test(priority = 4, dependsOnMethods = { "testClinkOnCancelButtonFields" })
	public void testAppointmentWillBeMarkedAsAccepted() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		log("In appointment page after click On accept button, Verify Appointment will be marked as Accepted");
		
		assertTrue(appointment.isAppointmentsAcceptedLabelDisplay());

	}

	@Test
	public void testAppointmentViewDeclinePageField() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		UsersPage usersPage = new UsersPage(driver);
		mainPage.clickOnOrginazationTab();
		usersPage.clickOnUserTab();
		usersPage.clickOnAddButton();
		
		log("Adding user details");
		String userName = "lokesh" + BasePageObject.createRandomCharacter(5);
		log("User name-- " + userName);
		usersPage.createUser(userName, AtomHC.propData.getProperty("user.lname"), "Male", 5, "Doctor",
				AtomHC.propData.getProperty("user.prof"));
		Patients patientPage = new Patients(driver);
		
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		log("Adding new Patients");
		String patientName = "Patient" + BasePageObject.createRandomCharacter(5);
		log("Patient name-- " + patientName);
		patientPage.creatPatient(patientName, AtomHC.propData.getProperty("patient.lname"),
				AtomHC.propData.getProperty("patient.gender"), AtomHC.propData.getProperty("patient.birth.year"),
				AtomHC.propData.getProperty("patient.birth.month"), AtomHC.propData.getProperty("patient.birth.date"),
				AtomHC.propData.getProperty("patient.blood.group"),
				AtomHC.propData.getProperty("patient.lang.preferance"),
				AtomHC.propData.getProperty("patient.security.code"),
				AtomHC.propData.getProperty("patient.internal.code"),
				AtomHC.propData.getProperty("patient.external.code"), 3);
		
		mainPage.clickOnAppointmentTab();
		appointment.clickOnAppointmentAddButton();
		appointment.clickOnAppointmentSubjectTextbox();
		AtomHC.apptName = "Regular" + BasePageObject.createRandomCharacter(5);
		log("Appointment Subject-- " + AtomHC.apptName);
		appointment.addSubjectInTextbox(AtomHC.apptName);
		appointment.clickOnAppointmentTypeFirstDropdown();
		appointment.addNewDateInAppointmentPage(1, 1);
		
		appointment.addPatient(patientName + " " + AtomHC.propData.getProperty("patient.lname"));
		appointment.addUser(userName + " " + AtomHC.propData.getProperty("user.lname"));
		appointment.clickOnParticipantsTextbox();
		appointment.selectAdmin();
		
		appointment.clickOnSaveButton();
		
		appointment.addAppointmentsSubject(AtomHC.apptName);
		appointment.clickOnDeclineButton();
		log("verify Cross Button from Decline button its navigate to Appointment view page");
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(appointment.getDeclineAppointmentLabel(),
				AtomHC.propData.getProperty("decline.appointment.label"));
		softAssert.assertTrue(appointment.isDeclineAppointmentCancelButton());
		softAssert.assertTrue(appointment.isDeclineAppointmentOkButtonDisplay());
		softAssert.assertAll();
	}

	@Test(priority = 1, dependsOnMethods = { "testDeclinePageField" })
	public void testWhenClickOnDeclineCrossButtonItsNavigatedToApptAddEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		appointment.clickOnDeclineButton();
		appointment.clickOnDeclineAppointmentcrossIconButton();
		log("verify Cross Button from Decline button its navigate to Appointment view page");
		
		assertEquals(appointment.getAppointmentViewTypeLabel(), AtomHC.propData.getProperty("video.calling.label"));
	}

	@Test(priority = 2, dependsOnMethods = { "testDeclinePageField" })
	public void testWhenClickOnDeclineCancelButtonItsNavigatedToApptAddEditPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		appointment.clickOnDeclineButton();
		appointment.clickOnDeclineAppointmentCancelButton();
		log("verify cancel Button from delete button its navigate to Appointment view page");
		
		assertEquals(appointment.getAppointmentViewTypeLabel(), AtomHC.propData.getProperty("video.calling.label"));
	}

	@Test(priority = 3, dependsOnMethods = { "testDeclinePageField" })
	public void testWhenClickOnDeclineOkButtonItsNavigatedToApptViewPage() throws Exception {
		Appointments appointment = new Appointments(driver);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		mainPage.clickOnAppointmentTab();
		
		appointment.clickOnNewAddedAppointments();
		appointment.clickOnDeclineButton();
		appointment.clickOnDeclineAppointmentOkButton();
		log("verify ok Button from Decline button its navigate to Appointment page");
		
		assertEquals(appointment.getAppointmentsLabel(), AtomHC.propData.getProperty("appointments.label"));
	}
}