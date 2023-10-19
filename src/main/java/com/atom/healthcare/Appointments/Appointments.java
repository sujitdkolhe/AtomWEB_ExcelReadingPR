package com.atom.healthcare.Appointments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Appointments extends BasePageObject {

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])")
	private WebElement appointmentsLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewAddActionKey")
	private WebElement appointmentsAddButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-timeGridDay-button fc-button fc-button-primary fc-button-active'])")
	private WebElement dayLabel;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-timeGridWeek-button fc-button fc-button-primary'])")
	private WebElement weekLabel;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-dayGridMonth-button fc-button fc-button-primary'])")
	private WebElement monthLabel;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-timeGridWeek-button fc-button fc-button-primary fc-button-active'])")
	private WebElement weekButtonLabel;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-dayGridMonth-button fc-button fc-button-primary fc-button-active'])")
	private WebElement monthButtonLabel;

	@FindBy(how = How.XPATH, using = "(//button[@class='fc-dayGridMonth-button fc-button fc-button-primary'])")
	private WebElement monthButtonTab;

	@FindBy(how = How.XPATH, using = "//div[@id='calendar']")
	private WebElement monthCalendar;

	@FindBy(how = How.ID, using = "calendar")
	private WebElement weekCalendar;

	@FindBy(how = How.XPATH, using = "(//td[@class='fc-day fc-widget-content fc-thu fc-past'])")
	private WebElement monthDateButton;

	@FindBy(how = How.XPATH, using = "(//span[@class='fc-icon fc-icon-chevron-right'])")
	private WebElement swipeRightButton;

	@FindBy(how = How.XPATH, using = "(//span[@class='fc-icon fc-icon-chevron-left'])")
	private WebElement swipeLeftButton;

	@FindBy(how = How.ID, using = "AppointmentsViewAddActionKey")
	private WebElement appointmentAddButtonClick;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])")
	private WebElement appointmentAddEditLabel;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crossIconButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement appointmentSubjectLabel;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Appointment Subject'])")
	private WebElement appointmentSubjectPlaceholder;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentSubjectTextKey1input-text")
	private WebElement appointmentSubjectTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentSubjectTextKey2input-text")
	private WebElement appointmentSubjectSecondTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement appointmentInformationLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupInformationTextKey1input-textArea")
	private WebElement appointmentInformationTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupInformationTextKey1input-textArea")
	private WebElement appointmentInformationPlaceholder;

	@FindBy(how = How.XPATH, using = "//th[@class='fc-day-header fc-widget-header fc-wed fc-today']/span")
	private WebElement todaysDateLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopuptabs1")
	private WebElement firstLangTab;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopuptabs2")
	private WebElement secondLangTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement appointmentTypeLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement appointmentTypeTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentTypeTextKeyinput-text")
	private WebElement appointmentTypePlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement startsLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupStartsTextKeydatePicker")
	private WebElement startsDateTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupStartsTextKeytimePicker")
	private WebElement startsTimePickerTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement endLabel;

	@FindBy(how = How.XPATH, using = "//input[@id='AppointmentsViewIsPopupEndsTextKeydatePicker']")
	private WebElement endDateTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupEndsTextKeytimePicker")
	private WebElement endTimePickerTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement participantsLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupParticipantsTextKeyinput-text")
	private WebElement participantsTextbox;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupParticipantsTextKeyinput-text")
	private WebElement participantsPlaceholder;

	@FindBy(how = How.ID, using = "AppointmentsViewSaveActionKey")
	private WebElement appointmentSaveLabel;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement appointmentSaveButton;

	@FindBy(how = How.ID, using = "AppointmentsViewCancelActionKey")
	private WebElement appointmentCancelLabel;

	@FindBy(how = How.XPATH, using = "//button[text()=")
	private WebElement appointmentCancelButton;

	@FindBy(how = How.XPATH, using = "(//li[@class='text-start padding-horizontal-md'])[21]")
	private WebElement participantsDropdownSelect;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentSubjectTextKey1errorLabel")
	private WebElement appointmentSubjectTextKeyErrorLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentTypeTextKeyerrorLabel")
	private WebElement appointmentTypeTextKeyErrorLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupStartsTextKeyerrorLabel")
	private WebElement startsTextKeyErrorLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupEndsTextKeyerrorLabel")
	private WebElement endTextKeyErrorLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupParticipantsTextKeyerrorLabel")
	private WebElement participantsTextKeyErrorLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewIsPopupAppointmentTypeTextKeylabel312")
	private WebElement appointmentTypeFirstDropdown;

	@FindBy(how = How.XPATH, using = "(//div[@class='datepicker datepicker-dropdown-menu'])[1]")
	private WebElement startDatePicker;

	@FindBy(how = How.XPATH, using = "(//div[@class='datepicker datepicker-dropdown-menu'])[2]")
	private WebElement endDatePicker;

	@FindBy(how = How.XPATH, using = "(//button[@class='next'])[1]")
	private WebElement nextMonth;

	@FindBy(how = How.XPATH, using = "(//a[@class='fc-time-grid-event fc-event fc-start fc-end'])[1]")
	private WebElement appointments;

	@FindBy(how = How.XPATH, using = "//div[@class='fc-title']")
	private WebElement appointmentsNameLabel;

	@FindBy(how = How.XPATH, using = "(//a[@class='fc-time-grid-event fc-event fc-start fc-end'])[2]")
	private WebElement addNewAppointments;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement appointmentViewTypeLabel;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-border-error float-right margin-left-md']")
	private WebElement declineLabelButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement declineAppointmentLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])")
	private WebElement declineAppointmentErrorMessage;

	@FindBy(how = How.ID, using = "AppointmentsViewCancelActionKey")
	private WebElement declineAppointmentCancelButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	private WebElement declineAppointmentOkButton;

	@FindBy(how = How.ID, using = "AppointmentsViewEditActionKey")
	private WebElement editButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-5-semi-bold text-start'])")
	private WebElement appointmentViewSubjectLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular text-start margin-top-sm'])")
	private WebElement appointmentViewDateTimeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular text-start font-weight-bold margin-top-xxl'])")
	private WebElement appointmentViewParticipantsLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='avatar-circle d-flex'])[3]")
	private WebElement appointmentViewProfilePicture;

	@FindBy(how = How.XPATH, using = "(//li[@class='text-start padding-horizontal-md'])[19]")
	private WebElement appointmentViewParticipantsPatient;

	@FindBy(how = How.XPATH, using = "(//li[@class='text-start padding-horizontal-md'])[3]")
	private WebElement appointmentViewParticipantsCaregiver;

	@FindBy(how = How.XPATH, using = "(//li[@class='text-start padding-horizontal-md'])[20]")
	private WebElement appntViewParticipantsCaregiver;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs'])[1]")
	private WebElement appointmentViewAppointmentViewProfilePic;

	@FindBy(how = How.XPATH, using = "(//Label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])[1]")
	private WebElement appointmentViewProfileName;

	@FindBy(how = How.XPATH, using = "(//Label[@class='lbl-secondary-text-body-medium-regular text-start truncate'])[1]")
	private WebElement appointmentViewProfileProfession;

	@FindBy(how = How.XPATH, using = "(//Label[@class='badge-error truncate'])[1]")
	private WebElement appointmentViewAppointmentStatus;

	@FindBy(how = How.ID, using = "AppointmentsViewInvalidData")
	private WebElement appointmentViewDateValidData;

	@FindBy(how = How.ID, using = "AppointmentsViewAcceptedStatusKey")
	private WebElement appointmentsViewAcceptedButton;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement declineAppointmentCrossIconButton;

	@FindBy(how = How.XPATH, using = "(//Label[@class='lbl-primary-text-header-2-semi-bold text-start'])[2]")
	private WebElement caregiverSelectionErrorLabel;

	@FindBy(how = How.XPATH, using = "(//Label[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])")
	private WebElement caregiverSelectionErrorMessage;

	@FindBy(how = How.ID, using = "AppointmentsViewYesActionKey")
	private WebElement caregiverSelectionYesLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewNoActionKey")
	private WebElement caregiverSelectionNoLabel;

	@FindBy(how = How.ID, using = "AppointmentsViewInvalidData")
	private WebElement appointmentGreaterThanErrorMessage;

	@FindBy(how = How.XPATH, using = "(//table/thead)[2]/tr/th[2]")
	private WebElement weekDateLabel;

	@FindBy(how = How.XPATH, using = "//td[@class='fc-axis']")
	private WebElement weekTimeLabel;

	@FindBy(how = How.XPATH, using = "//th[@class='fc-day-header fc-widget-header fc-mon']")
	private WebElement monthDayLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='fc-right']")
	private WebElement rightSideTodaysDate;

	@FindBy(how = How.XPATH, using = "//label[text()='Om Admin - Admin']")
	private WebElement selectAdmin;

	@FindBy(how = How.XPATH, using = "(//div[text()='Regular checkup'])[1]")
	private WebElement addedNewAppointment;

	@FindBy(how = How.XPATH, using = "(//input[@id='AppointmentsViewIsPopupStartsTextKeytimePicker'])[1]")
	private WebElement startCalendar;

	@FindBy(how = How.XPATH, using = "//input[@id='AppointmentsViewIsPopupEndsTextKeytimePicker']")
	private WebElement endCalendar;

	@FindBy(how = How.XPATH, using = "(//button[@class='timepicker-hour timepicker-button'])[1]")
	private WebElement startTime;

	@FindBy(how = How.XPATH, using = "(//button[@class='timepicker-hour timepicker-button'])")
	private WebElement endTime;

	@FindAll(@FindBy(how = How.XPATH, using = "(//ui[@id='AppointmentsViewIsPopupAppointmentTypeTextKeyListItems'])/li"))
	private List<WebElement> appointmentTypeList;

	@FindBy(how = How.XPATH, using = "(//a[@class='fc-time-grid-event fc-event fc-start fc-end'])")
	private WebElement clickOnAppointmentsList;

	@FindBy(how = How.XPATH, using = "//label[text()='Accepted']")
	private WebElement appointmentsAcceptedLabelDisplay;

	@FindBy(how = How.XPATH, using = "//label[text()='New']")
	private WebElement appointmentsNewLabelDisplay;

	@FindBy(how = How.XPATH, using = "//b[text()='Available']")
	private WebElement participantsAvailableStausDisplay;

	@FindBy(how = How.XPATH, using = "(//b[text()='Unavailable'])[2]")
	private WebElement participantsUnavailableStausDisplay;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement cancelMeetingLabel;

	public Appointments(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getAppointmentsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentsLabel);
		return appointmentsLabel.getText();
	}

	public boolean isAppointmentsAddButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentsAddButton);
			isPresent = appointmentsAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Add Button not Visible");
			return isPresent;
		}
	}

	public String getDayLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dayLabel);
		return dayLabel.getText();
	}

	public String getWeekLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weekLabel);
		return weekLabel.getText();
	}

	public String getWeekButtonLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weekButtonLabel);
		return weekButtonLabel.getText();
	}

	public void clickOnWeekTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(weekLabel);
		waitForElement(driver, weekLabel);
		javascriptClick(weekLabel);
	}

	public String getMonthLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, monthLabel);
		return monthLabel.getText();
	}

	public String getMonthButtonLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, monthButtonLabel);
		return monthButtonLabel.getText();
	}

	public void clickOnDayTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dayLabel);
		javascriptClick(dayLabel);
	}

	public void clickOnMonthTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, monthButtonTab);
		javascriptClick(monthButtonTab);
	}

	public boolean isWeekDateLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(weekCalendar);
			waitForElement(driver, weekCalendar);
			isPresent = weekCalendar.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("week Calender not Visible");
			return isPresent;
		}
	}

	public void clickOnMonthDateButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(monthDateButton);
		waitForElement(driver, monthDateButton);
		javascriptClick(monthDateButton);
	}

	public boolean isAppointmentSwipeLeftButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(swipeLeftButton);
			waitForElement(driver, swipeLeftButton);
			isPresent = swipeLeftButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("swipe Left Button not Visible");
			return isPresent;
		}
	}

	public void clickOnSwipeRightButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, swipeRightButton);
		javascriptClick(swipeRightButton);
	}

	public boolean isAppointmentSwipeRightButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, swipeRightButton);
			isPresent = swipeRightButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("swipe Right Button not isible");
			return isPresent;
		}
	}

	public void clickOnAppointmentAddButton() {
		TestConfig.PrintMethodName();
		//waitForElement(driver, appointmentAddButtonClick);
		waitUntilElementIsVisible(appointmentAddButtonClick);
		javascriptClick(appointmentAddButtonClick);
	}

	public void clickOnSwipeLeftButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, swipeLeftButton);
		javascriptClick(swipeLeftButton);
	}

	public String getAppointmentAddEditLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentAddEditLabel);
		return appointmentAddEditLabel.getText();
	}

	public boolean isDisplayCrossIconButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, crossIconButton);
			isPresent = crossIconButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Cross button not Visible");
			return isPresent;
		}
	}

	public String getAppointmentSubjectLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectLabel);
		return appointmentSubjectLabel.getText();
	}

	public String getAppointmentSubjectPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectPlaceholder);
		return appointmentSubjectPlaceholder.getAttribute("placeholder");
	}

	public boolean isAppointmentSubjectTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentSubjectTextbox);
			isPresent = appointmentSubjectTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Add Button not Visible");
			return isPresent;
		}
	}

	public String getAppointmentInformationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentInformationLabel);
		return appointmentInformationLabel.getText();
	}

	public String getAppointmentInformationPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentInformationPlaceholder);
		return appointmentInformationPlaceholder.getAttribute("placeholder");
	}

	public boolean isAppointmentInformationTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentInformationTextbox);
			isPresent = appointmentInformationTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Information Textbox not Visible");
			return isPresent;
		}
	}

	public boolean isTodaysDateLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, todaysDateLabel);
			isPresent = todaysDateLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Todays date not Visible");
			return isPresent;
		}
	}

	public String getAppointmentTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentTypeLabel);
		return appointmentTypeLabel.getText();
	}

	public String getAppointmentTypePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentTypePlaceholder);
		return appointmentTypePlaceholder.getAttribute("placeholder");
	}

	public boolean isAppointmentTypeTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentTypeTextbox);
			isPresent = appointmentTypeTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Add Button not Visible");
			return isPresent;
		}
	}

	public String getStartsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, startsLabel);
		return startsLabel.getText();
	}

	public boolean isStartsTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, startsDateTextbox);
			isPresent = startsDateTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Start textbox is not Visible");
			return isPresent;
		}
	}

	public boolean isStartTimePickerTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, endTimePickerTextbox);
			isPresent = endTimePickerTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Start time picker is not Visible");
			return isPresent;
		}
	}

	public String getEndLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endLabel);
		return endLabel.getText();
	}

	public boolean isEndTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, endDateTextbox);
			isPresent = endDateTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("End textbox is not Visible");
			return isPresent;
		}
	}

	public boolean isEndTimePickerTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, endTimePickerTextbox);
			isPresent = endTimePickerTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("End time picker is not Visible");
			return isPresent;
		}
	}

	public String getParticipantsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsLabel);
		return participantsLabel.getText();
	}

	public String getParticipantsPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsPlaceholder);
		return participantsPlaceholder.getAttribute("placeholder");
	}

	public boolean isParticipantsTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, participantsTextbox);
			isPresent = participantsTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Participants Textbox is not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentsSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentSaveButton);
			isPresent = appointmentSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Save Button is not Visible");
			return isPresent;
		}
	}

	public String getAppointmentSaveLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSaveLabel);
		return appointmentSaveLabel.getText();
	}

	public boolean isAppointmentsCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentCancelButton);
			isPresent = appointmentCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Cancel Button is not Visible");
			return isPresent;
		}
	}

	public String getAppointmentCancelLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentCancelLabel);
		return appointmentCancelLabel.getText();
	}

	public void clickOnParticipantsTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsTextbox);
		Actions ac = new Actions(driver);
		ac.sendKeys(participantsTextbox, Keys.ENTER).build().perform();
	}

	public void clickOnParticipantsDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsDropdownSelect);
		javascriptClick(participantsDropdownSelect);
	}

	public void clickOnSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSaveButton);
		javascriptClick(appointmentSaveButton);
	}

	public String getAppointmentSubjectTextKey1ErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectTextKeyErrorLabel);
		return appointmentSubjectTextKeyErrorLabel.getText();
	}

	public String getAppointmentTypeTextKeyErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentTypeTextKeyErrorLabel);
		return appointmentTypeTextKeyErrorLabel.getText();
	}

	public String getStartsTextKeyErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, startsTextKeyErrorLabel);
		return startsTextKeyErrorLabel.getText();
	}

	public String getEndTextKeyErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endTextKeyErrorLabel);
		return endTextKeyErrorLabel.getText();
	}

	public String getParticipantsTextKeyErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsTextKeyErrorLabel);
		return participantsTextKeyErrorLabel.getText();
	}

	public void sendAppointmentSubjectTextbox(String appointment) {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectTextbox);
		appointmentSubjectTextbox.sendKeys(appointment);
	}

	public void sendAppointmentSubjectSecondTextbox(String appointment) {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectSecondTextbox);
		appointmentSubjectSecondTextbox.sendKeys(appointment);
	}

	public void clickOnAppointmentSubjectTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectTextbox);
		javascriptClick(appointmentSubjectTextbox);
	}

	public void clickOnAppointmentTypeFirstDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentTypeFirstDropdown);
		javascriptClick(appointmentTypeFirstDropdown);
	}

	public void clickOnAppointmentTypeTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(appointmentTypeTextbox);
		//waitForElement(driver, appointmentTypeTextbox);
		Actions act = new Actions(driver);
		act.click(appointmentTypeTextbox).build().perform();
	}

	public void addNewDateInAppointmentPage(int startDt, int endDt) throws InterruptedException {
		log("Adding new Appointment Date");
		TestConfig.PrintMethodName();
		waitForElement(driver, startsDateTextbox);
		javascriptClick(startsDateTextbox);
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentDate = dateFormat.format(cal.getTime());
		int currentDay = Integer.valueOf(currentDate) + startDt;
		log("Current Date " + currentDay);
		WebElement selectFromDate = driver.findElement(By.xpath(
				"(//div[@class='datepicker-days']/div[@class='days']/div/button[text()='" + currentDay + "'])[1]"));
		javascriptClick(selectFromDate);
		WebElement selectEndDate = null;
		javascriptClick(endDatePicker);
		if (currentDate.equals("30")) {
			int day = currentDay - 25;
			javascriptClick(nextMonth);
			log("Day 1" + day);
			selectEndDate = driver.findElement(By
					.xpath("(//div[@class='datepicker-days']/div[@class='days']/div/button[text()='" + day + "'])[2]"));
		} else {
			int day = currentDay + endDt;
			log("Day " + day);
			selectEndDate = driver.findElement(By
					.xpath("(//div[@class='datepicker-days']/div[@class='days']/div/button[text()='" + day + "'])[2]"));
			javascriptClick(selectEndDate);
		}
	}

	public void addNewTimeInAppointmentPage() throws Exception {
		log("Adding new Appointment time");
		TestConfig.PrintMethodName();
		waitForElement(driver, startsTimePickerTextbox);
		javascriptClick(startsTimePickerTextbox);
		javascriptClick(startTime);
		DateFormat dateFormat1 = new SimpleDateFormat("hh");
		Date dat = new Date();
		log("Current Hours " + dateFormat1.format(dat));
		String st = dateFormat1.format(dat);
		int et = Integer.valueOf(st);
		WebElement startHour = driver.findElement(By.xpath("(//button[contains(.,'" + st + "')])"));
		javascriptClick(startHour);
		javascriptClick(endTimePickerTextbox);
		javascriptClick(endTime);
		log("End Time " + et);
		WebElement endHour = driver.findElement(By.xpath("(//button[contains(.,'" + et + "')])"));
		javascriptClick(endHour);
	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIconButton);
		javascriptClick(crossIconButton);
	}

	public void clickOnSecondLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, secondLangTab);
		javascriptClick(secondLangTab);
	}

	public void clickOnAppointmentSubjectSecondTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectSecondTextbox);
		javascriptClick(appointmentSubjectSecondTextbox);
	}

	public void clickOnDeclineButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineLabelButton);
		Actions act = new Actions(driver);
		act.sendKeys(declineLabelButton, Keys.ENTER).build().perform();
	}

	public void addAppointmentsSubject(String appointmentName) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSaveButton);
		log("appointment Subject is : " + AtomHC.apptName);
		WebElement appointment = driver.findElement(By.xpath("//div[text()='" + AtomHC.apptName + "']"));
		javascriptClick(appointment);
	}

	public String getAddedAppointment(String appointmentName) {
		TestConfig.PrintMethodName();
		log("appointment Subject is : " + appointmentName);
		WebElement appointment = driver.findElement(By.xpath("//div[text()='" + appointmentName + "']"));
		return appointment.getText();
	}

	public void clickOnAppointments() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnAppointmentsList);
		javascriptClick(clickOnAppointmentsList);
	}

	public boolean isAddedNewAppointmentsDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addedNewAppointment);
			isPresent = addedNewAppointment.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("New appointments is not Visible");
			return isPresent;
		}
	}

	public String getAppointmentViewTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewTypeLabel);
		return appointmentViewTypeLabel.getText();
	}

	public String getDeclineAppointmentLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineAppointmentLabel);
		return declineAppointmentLabel.getText();
	}

	public String getDeclineAppointmentErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineAppointmentErrorMessage);
		return declineAppointmentErrorMessage.getText();
	}

	public void clickOnDeclineAppointmentCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineAppointmentCancelButton);
		javascriptClick(declineAppointmentCancelButton);
	}

	public boolean isDeclineAppointmentCancelButton() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, declineAppointmentCancelButton);
			isPresent = declineAppointmentCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Decline appoinment cancel Button not Visible");
			return isPresent;
		}
	}

	public void clickOnDeclineAppointmentOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineAppointmentOkButton);
		javascriptClick(declineAppointmentOkButton);
	}

	public boolean isDeclineAppointmentOkButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, declineAppointmentOkButton);
			isPresent = declineAppointmentOkButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Decline appoinment ok Button not Visible");
			return isPresent;
		}
	}

	public void clickOnEditButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editButton);
		javascriptClick(editButton);
	}

	public String getAppointmentViewSubjectLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewSubjectLabel);
		return appointmentViewSubjectLabel.getText();
	}

	public String getAppointmentViewProfilePicture() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewParticipantsLabel);
		return appointmentViewParticipantsLabel.getText();
	}

	public String getAppointmentViewParticipantsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewParticipantsLabel);
		return appointmentViewParticipantsLabel.getText();
	}

	public void clickOnAppointmentViewParticipantsPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewParticipantsPatient);
		javascriptClick(appointmentViewParticipantsPatient);
	}

	public void clickOnParticipantsCaregiverDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewParticipantsCaregiver);
		javascriptClick(appointmentViewParticipantsCaregiver);
	}

	public void clickOnParticipantsCaregiver2Dropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appntViewParticipantsCaregiver);
		javascriptClick(appntViewParticipantsCaregiver);
	}

	public void clearStartTimeTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, startsTimePickerTextbox);
		startsTimePickerTextbox.clear();
	}

	public void clearEndTimeTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endTimePickerTextbox);
		endTimePickerTextbox.clear();
	}

	public void sendStartTimeTextbox(String startTime) {
		TestConfig.PrintMethodName();
		waitForElement(driver, startsTimePickerTextbox);
		startsTimePickerTextbox.sendKeys(startTime);
	}

	public void clickOnEndTimeTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, endTimePickerTextbox);
		javascriptClick(endTimePickerTextbox);
	}

	public void sendEndTimeTextbox(String endTime) {
		TestConfig.PrintMethodName();
		waitForElement(driver, endTimePickerTextbox);
		endTimePickerTextbox.sendKeys(endTime);
	}

	public boolean isAppointmentViewProfilePicDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentViewParticipantsLabel);
			isPresent = appointmentViewParticipantsLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appoinment view Profile not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentViewProfileNameDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentViewProfileName);
			isPresent = appointmentViewProfileName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appoinemnt view Profile Name not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentViewProfileProfessionDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentViewProfileProfession);
			isPresent = appointmentViewProfileProfession.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Profile Profession isn not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentStatusDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentViewAppointmentStatus);
			isPresent = appointmentViewAppointmentStatus.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appointment Status is not Visible");
			return isPresent;
		}

	}

	public String getAppointmentViewDateValidData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentViewDateValidData);
		return appointmentViewDateValidData.getText();
	}

	public boolean isAppointmentViewEditButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, editButton);
			isPresent = editButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appointment view Button is not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentViewDeclineButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, declineLabelButton);
			isPresent = declineLabelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appoinemnt view cancel Button is not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentViewAcceptButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentsViewAcceptedButton);
			isPresent = appointmentsViewAcceptedButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appointment View Accept Button is not Visible");
			return isPresent;
		}
	}

	public void clickOnAppointmentsViewAcceptedButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentsViewAcceptedButton);
		javascriptClick(appointmentsViewAcceptedButton);
	}

	public void clickOnDeclineAppointmentcrossIconButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, declineAppointmentCrossIconButton);
		javascriptClick(declineAppointmentCrossIconButton);
	}

	public String getTodaysDateLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(todaysDateLabel);
		waitForElement(driver, todaysDateLabel);
		return todaysDateLabel.getText();
	}

	public String getCaregiverSelectionErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSelectionErrorLabel);
		return caregiverSelectionErrorLabel.getText();
	}

	public String getCaregiverSelectionErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSelectionErrorMessage);
		return caregiverSelectionErrorMessage.getText();
	}

	public boolean isCaregiverSelectionYesButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, caregiverSelectionYesLabel);
			isPresent = caregiverSelectionYesLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Caregiver Selection Yes Button is not  Visible");
			return isPresent;
		}
	}

	public void clickOnAppointmentsAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentsAddButton);
		javascriptClick(appointmentsAddButton);
	}

	public String getAppointmentGreaterThanErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentGreaterThanErrorMessage);
		return appointmentGreaterThanErrorMessage.getText();
	}

	public boolean isMonthCalendarDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, monthCalendar);
			isPresent = monthCalendar.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Month calendar is not visible");
			return isPresent;
		}
	}

	public void addPatient(String patient) throws InterruptedException {
		log("Adding new Patient");
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(participantsTextbox);
		waitForElement(driver, participantsTextbox);
		javascriptClick(participantsTextbox);
		participantsTextbox.sendKeys(patient);
		log("Patient name " + patient);
		WebElement patientName = driver.findElement(By.xpath("//label[contains(.,'" + patient + "')]"));
		javascriptClick(patientName);
	}

	public void addUser(String caregiverName) throws InterruptedException {
		log("Adding new User");
		TestConfig.PrintMethodName();
		waitForElement(driver, participantsTextbox);
		javascriptClick(participantsTextbox);
		participantsTextbox.clear();
		participantsTextbox.sendKeys(caregiverName);
		log("User name " + caregiverName);
		WebElement userName = driver.findElement(By.xpath("//label[contains(.,'" + caregiverName + "')]"));
		javascriptClick(userName);
	}

	public boolean isWeekDateLabelDsiplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, weekDateLabel);
			isPresent = weekDateLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("week Date lable is not Visible");
			return isPresent;
		}
	}

	public boolean isDayTimeLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, weekTimeLabel);
			isPresent = weekTimeLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Day Time label is not Visible");
			return isPresent;
		}
	}

	public boolean isMonthDayLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, monthDayLabel);
			isPresent = monthDayLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Month Day lable is not Visible");
			return isPresent;
		}
	}

	public boolean isAddNewAppointmentsDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addNewAppointments);
			isPresent = addNewAppointments.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("New Appointments is not Visible");
			return isPresent;
		}
	}

	public boolean isAppointmentViewDateTimeLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentViewDateTimeLabel);
			isPresent = appointmentViewDateTimeLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("New Appointments Visible");
			return isPresent;
		}
	}

	public boolean isRightSideTodaysDateLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, rightSideTodaysDate);
			isPresent = rightSideTodaysDate.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Right side Todays Date is not Visible");
			return isPresent;
		}
	}

	public void clickOnStartTimeTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, startsTimePickerTextbox);
		javascriptClick(startsTimePickerTextbox);

	}

	public void selectAdmin() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectAdmin);
		javascriptClick(selectAdmin);

	}

	public String getTabHighlightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dayLabel);
		String cssValue = dayLabel.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public List<String> getAppointmentTypeList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : appointmentTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getAppointmentsName() {
		TestConfig.PrintMethodName();
		BasePageObject.waitForElement(driver, appointmentsNameLabel);
		return appointmentsNameLabel.getAttribute("value");
	}

	public void addSubjectInTextbox(String appointmentSubject) {
		log("Adding appointment Subject");
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentSubjectTextbox);
		appointmentSubjectTextbox.sendKeys(appointmentSubject);
	}

	public boolean isAppointmentsAcceptedLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentsAcceptedLabelDisplay);
			isPresent = appointmentsAcceptedLabelDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appointment Accepted label is not Visible");
			return isPresent;
		}
	}

	public void clickOnNewAddedAppointments() {
		TestConfig.PrintMethodName();
		WebElement appointName = driver.findElement(By.xpath("//div[text()='" + AtomHC.apptName + "']"));
		String apptName = appointName.getText();
		log("Appointment name " + apptName);
		javascriptClick(appointName);
	}

	public String getAppointmentsAcceptedLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentsAcceptedLabelDisplay);
		return appointmentsAcceptedLabelDisplay.getText();
	}

	public boolean isAppointmentsNewLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, appointmentsNewLabelDisplay);
			isPresent = appointmentsNewLabelDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Appointment New label is not Visible");
			return isPresent;
		}
	}

	public boolean isParticipantsAvailableStatusDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, participantsAvailableStausDisplay);
			isPresent = participantsAvailableStausDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Participant Available status is not Visible");
			return isPresent;
		}
	}

	public boolean isParticipantsUnavailableStatusDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, participantsUnavailableStausDisplay);
			isPresent = participantsUnavailableStausDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Participants Unavailable status is not Visible");
			return isPresent;
		}
	}

	public void clickOnCaregiverSelectionNoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, caregiverSelectionNoLabel);
		javascriptClick(caregiverSelectionNoLabel);

	}

	public boolean isCancelMeetingButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, cancelMeetingLabel);
			isPresent = cancelMeetingLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Cancel Meeting button is not visible");
			return isPresent;
		}
	}

	public String getAppointmentCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, appointmentCancelButton);
		return appointmentCancelButton.getText();
	}

	public boolean isSecondLangTab() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, secondLangTab);
			isPresent = secondLangTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Second language Hindi India not Visible");
			return isPresent;
		}
	}

	public boolean isFirstLangTab() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, firstLangTab);
			isPresent = firstLangTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("First language English India not Visible");
			return isPresent;
		}
	}
}