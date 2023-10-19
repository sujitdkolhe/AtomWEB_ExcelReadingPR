package com.atom.healthcare.TD_Patients;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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

public class TD_PatientsPage extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Programs']")
	private WebElement patientProgramTab;

	@FindBy(how = How.XPATH, using = "//button[@class='header-text']")
	private WebElement monthHeader;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;

	@FindBy(how = How.ID, using = "PatientAddEditCancelActionKey")
	private WebElement patientCancelButton;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyinput-text")
	private WebElement firstNameInput;

	@FindBy(how = How.ID, using = "PatientAddEditMiddleNameKeyinput-text")
	private WebElement middleNameInput;

	@FindBy(how = How.ID, using = "PatientAddEditLastNameKeyinput-text")
	private WebElement lastNameInput;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyinput-text")
	private WebElement genderInput;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeydate")
	private WebElement dateOfBirthInput;

	@FindBy(how = How.ID, using = "PatientAddEditBloodGroupKeyinput-text")
	private WebElement bloodGroupInput;

	@FindBy(how = How.ID, using = "PatientAddEditPreferredLanguageKeyinput-text")
	private WebElement langPreferanceInput;

	@FindBy(how = How.ID, using = "PatientAddEditSocialSecurityNumberKeyinput-text")
	private WebElement securityNumber;

	@FindBy(how = How.ID, using = "PatientAddEditInternalCodeKeyinput-text")
	private WebElement internalCode;

	@FindBy(how = How.ID, using = "PatientAddEditExternalCodeKeyinput-text")
	private WebElement ExternalCode;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumberInput;

	@FindBy(how = How.ID, using = "PatientAddEditEmailAddressKeyinput-text")
	private WebElement emailInput;

	@FindBy(how = How.XPATH, using = "//button[@class='prev']")
	private WebElement CalenderPrevButton;

	@FindBy(how = How.XPATH, using = "//label[text()='Patient add/edit']")
	private WebElement patientsAddEditLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold margin-bottom-md margin-top-xxs col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement headerTitle;

	@FindBy(how = How.ID, using = "PatientsViewSearchTextKey")
	private WebElement patientInputTextbox;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-primary padding-horizontal-md margin-left-md']")
	private WebElement addButtonCaption;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement noRecordFoundMessage;

	@FindBy(how = How.XPATH, using = "//div[@class=\"row col px-0 mr-0 ml-0\"]")
	private WebElement patientListDisplay;

	@FindBy(how = How.ID, using = "PatientsView1211")
	private WebElement patientDataDisplay;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-center'])[1]")
	private WebElement patientAgeGender;

	@FindBy(how = How.XPATH, using = "(//span[text()='Email: '])[1]")
	private WebElement patientEmailInListPage;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-primary-text-body-medium-semi-bold'])[1]")
	private WebElement patientMobileNoInListPage;

	@FindBy(how = How.XPATH, using = "//label[text()='Basic information']")
	private WebElement patientBasicInfoLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Profile image']")
	private WebElement patientProfileImage;

	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement uploadProfileImage;

	@FindBy(how = How.XPATH, using = "//label[text()='First name']")
	private WebElement fNameLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Last name']")
	private WebElement lNameLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Gender']")
	private WebElement ganderLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='DOB']")
	private WebElement dobLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Blood group']")
	private WebElement bloodGroupLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Preferred language']")
	private WebElement preferrendLangLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Social security number']")
	private WebElement socialSecurityNoLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Internal code']")
	private WebElement internalCodeLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='External code']")
	private WebElement externalCodeLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Mobile Number']")
	private WebElement mobileNumberLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	private WebElement emailLabel;

	@FindBy(how = How.ID, using = "PatientsView1211")
	private WebElement clickPatientCard;

	@FindBy(how = How.ID, using = "PatientView")
	private WebElement DemographicsTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement patientHeadingDisplay;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement demographicsCancelButtonCaption;

	@FindBy(how = How.ID, using = "PatientViewSendActivationAgainKey")
	private WebElement resendActivationButtonCaption;

	@FindBy(how = How.ID, using = "PatientViewDeleteActionKey")
	private WebElement demographicsDeleteButtonCaption;

	@FindBy(how = How.ID, using = "//span[@style='--font-size:70px']")
	private WebElement profileImage;

	@FindBy(how = How.XPATH, using = "//label[text()='Taehyung Kim']")
	private WebElement patientFName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold d-flex col-3 px-0 truncate ltr']")
	private WebElement patientAgeAndGender;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs text-truncate ltr'])[1]")
	private WebElement addedPatientEmail;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs text-truncate ltr'])[2]")
	private WebElement addedPatientMobileNo;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-large-semi-bold text-start truncate'])[1]")
	private WebElement demographicsPatientHeightlabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-bold d-flex text-start'])[1]")
	private WebElement addedDemographicsPatientHeight;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-large-semi-bold text-start truncate'])[2]")
	private WebElement demographicsPatientBloodGrouplabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-bold d-flex text-start'])[2]")
	private WebElement addedDemographicsPatientBloodGroup;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-large-semi-bold text-start truncate'])[3]")
	private WebElement demographicsPatientWeightLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-bold d-flex text-start'])[3]")
	private WebElement addedDemographicsPatientWeight;

	@FindBy(how = How.XPATH, using = "//label[text()='First name Is Required']")
	private WebElement fNameRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Last name Is Required']")
	private WebElement lNameRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Gender Is Required']")
	private WebElement genderRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='DOB Is Required']")
	private WebElement getDOBRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Blood group Is Required']")
	private WebElement bloodgroupRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Preferred language Is Required']")
	private WebElement preferredLangRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Mobile Number Is Required']")
	private WebElement mobileNoRequired;

	@FindBy(how = How.XPATH, using = "//label[text()='Email Is Required']")
	private WebElement emailRequired;

	@FindBy(how = How.ID, using = "PatientAddEditProfileImageKeyerrorLabel")
	private WebElement invalidProfileImage;

	@FindBy(how = How.XPATH, using = "//label[text()='Minimum length should be 10']")
	private WebElement minimumLenghtMobileNo;

	@FindBy(how = How.ID, using = "PatientAddEditEmailAddressKeyerrorLabel")
	private WebElement rangeShouldBeEmailid;

	@FindBy(how = How.XPATH, using = "//label[text()='Your data is invalid']")
	private WebElement yourDataShouldBeInvalidEmailid;

	@FindBy(how = How.ID, using = "PatientsView1203")
	private WebElement clickOnCardToDeleteDetails;

	@FindBy(how = How.ID, using = "PatientDetailViewDeleteActionKey")
	private WebElement clickOnDeleteButton;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement xIconDisplay;

	@FindBy(how = How.XPATH, using = "//p[text()='Are you sure you want to delete?']")
	private WebElement deletePoPUpDisplay;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-secondary padding-horizontal-md  margin-horizontal-md float-right']")
	private WebElement patientEditCancelButton;

	@FindBy(how = How.ID, using = "PatientDetailViewOkActionKey")
	private WebElement okButtonDisplay;

	@FindBy(how = How.ID, using = "CaregiversViewSaveActionKey")
	private WebElement cargiverSaveButton;

	@FindBy(how = How.ID, using = "PatientsView1837")
	private WebElement selectPatientFromPatientList;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 ']")
	private WebElement patientProgramTabHeading;

	@FindBy(how = How.ID, using = "PatientProgramsViewSearchTextKey")
	private WebElement inputProgramSearchBox;

	@FindBy(how = How.XPATH, using = "//img[@class='icon-left img-icon-medium ltr']")
	private WebElement patientProgramSearchIconDisplay;

	@FindBy(how = How.ID, using = "PatientProgramsViewAddActionKey")
	private WebElement addProgramButtonCaption;

	@FindBy(how = How.XPATH, using = "//img[@src='images/program-Shape.svg']")
	private WebElement defaultProgramIconDisplay;

	@FindBy(how = How.XPATH, using = "//label[text()='Fitness Program']")
	private WebElement programNameDisplay;

	@FindBy(how = How.XPATH, using = "//label[text()='Enrolled On Jan 17 2023']")
	private WebElement programEnrolledDateDisplay;

	@FindBy(how = How.ID, using = "PatientProgramsViewNoDataFoundKey")
	private WebElement errorMsgInPatientProgram;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement getMyProgramsTitle;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement getMyProgramsXIcon;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']")
	private WebElement getMyProgramsNameLabel;

	@FindBy(how = How.ID, using = "PatientProgramAddEditActionKeyinput-text")
	private WebElement isMyProgramsNameDropdown;

	@FindBy(how = How.XPATH, using = "//label[text()='Entry point']")
	private WebElement getEntryPointLabel;

	@FindBy(how = How.ID, using = "PatientProgramAddEditEntryPointKeyinput-text")
	private WebElement entryPointTextbox;

	@FindBy(how = How.ID, using = "PatientProgramsViewSaveActionKey")
	private WebElement getMyProgramSaveButton;

	@FindBy(how = How.ID, using = "PatientProgramsViewCancelActionKey")
	private WebElement getMyProgramCancelButton;

	@FindBy(how = How.XPATH, using = "//ui[@id='PatientProgramAddEditActionKeyListItems']/li")
	private List<WebElement> nameOperationTypeItem;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[6]")
	private WebElement getSelectedValueInDropdown;

	@FindBy(how = How.ID, using = "PatientProgramAddEditActionKeyerrorLabel")
	private WebElement getNameIsRequiredErrorMsg;

	@FindBy(how = How.XPATH, using = "//li[text()='Fitness Program']")
	private WebElement getDropdownValue;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement getErrorMsgDuplicateData;

	@FindBy(how = How.XPATH, using = "//li[text()='Nutrition and Lifestyle']")
	private WebElement getNewValueInDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()='Diet and Lifestyle']")
	private WebElement getNewValueInDropdownField;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary float-right']")
	private WebElement clickOnCancelButton;

	@FindBy(how = How.ID, using = "PatientProgramsView")
	private WebElement againPatientProgramsListPageDisplay;

	@FindBy(how = How.XPATH, using = "//div[@class='file-circle']")
	private WebElement clickOnAnyRecord;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement deleteLinkButtonDisplay;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start'])[2]")
	private WebElement ConfirmationMsg;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[3]")
	private WebElement xIconInSaveButtonInEditMode;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary margin-horizontal-md float-right'])[2]")
	private WebElement clickOnCancelButtonInEditMode;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right'])[2]")
	private WebElement getOkButtonCaption;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start'])[1]")
	private WebElement getHeadingAsDelete;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement isXIconDisplayInDeleteButtonClick;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement getErrorMsgOnClickOnDeleteButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary margin-horizontal-md float-right'])[1]")
	private WebElement getCancelTextInDeletePopUpPage;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right'])[1]")
	private WebElement getOkTextInDeletePopUpPage;

	@FindBy(how = How.ID, using = "PatientsView1879")
	private WebElement overviewpatient;

	@FindBy(how = How.ID, using = "CaregiversView")
	private WebElement caregiverTab;

	@FindBy(how = How.CSS, using = "label.lbl-primary-text-header-3-semi-bold.col-xl-7.col-md-6.col-sm-12")
	private WebElement caregiversHeader;

	@FindBy(how = How.ID, using = "CaregiversViewSearchTextKey")
	private WebElement caregiverSearchTextbox;

	@FindBy(how = How.ID, using = "CaregiversViewAddActionKey")
	private WebElement addCaregiverButton;

	@FindBy(how = How.ID, using = "CaregiversViewerrorLabel")
	private WebElement noRecordFoundErrorLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement branchInput;

	@FindBy(how = How.XPATH, using = "//li[@value='846']")
	private WebElement selectBranch;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement departmentInput;

	@FindBy(how = How.XPATH, using = "//input[@id='CaregiversViewIsPopupCaregiverKeyinput-text']")
	private WebElement selectCaregiverInput;

	@FindBy(how = How.XPATH, using = "//li[@value='1508']")
	private WebElement selectCaregiver;

	@FindBy(how = How.ID, using = "CaregiversViewSaveActionKey")
	private WebElement caregiverSaveButton;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeydatePicker")
	private WebElement fromDateKeydatePicker;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='MMM d yyyy'])[2]")
	private WebElement endDateKeydatePicker;

	@FindBy(how = How.XPATH, using = "//button[@class='next']")
	private WebElement CalenderNextButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement caregiverHeader;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][1]")
	private WebElement columnName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][2]")
	private WebElement columnDepartment;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][3]")
	private WebElement columnProgram;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][4]")
	private WebElement columnFromDate;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'][5]")
	private WebElement columnEndDate;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement addeditPageHeader;

	@FindBy(how = How.XPATH, using = "//div[@id='CaregiversViewtable-row0'][1]")
	private WebElement firstCaregiver;

	@FindBy(how = How.XPATH, using = "//div[@id='CaregiversViewtable-row0'][3]")
	private WebElement thirdCaregiver;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement organisationLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupOrganisationKeyinput-text")
	private WebElement organisationDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement branchLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement departmentLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement caregiverLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement fromDateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement endDateLabel;

	@FindBy(how = How.XPATH, using = "(//button[@id='CaregiversViewCancelActionKey'])[2]")
	private WebElement caregiverCancelButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement caregiverDeleteButton;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crossIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='table d-flex justify-content-between flex-wrap no-border ltr']")
	private WebElement caregiverListPage;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupBranchKeyListItems']/li")
	private List<WebElement> caregiverbranchList;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupDepartmentKeyListItems']/li")
	private List<WebElement> caregiverDepartmentList;

	@FindBy(how = How.XPATH, using = "//ui[@id='CaregiversViewIsPopupCaregiverKeyListItems']/li")
	private List<WebElement> caregiverList;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[5]")
	private WebElement caregiverFirstBranch;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[5]")
	private WebElement caregiverDelhiBranch;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupBranchKeylabel-1")
	private WebElement caregiverSelectValue;

	@FindBy(how = How.ID, using = "PatientDetailView")
	private WebElement overviewTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	private WebElement patientfirstCaregiver;

	@FindBy(how = How.ID, using = "CaregiversViewOkActionKey")
	private WebElement caregiverOkButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold margin-bottom-sm text-start']")
	private WebElement caregiverProgram;

	@FindBy(how = How.XPATH, using = "//li[@class='lbl-primary-text-body-large-regular ltr'][4]")
	private WebElement caregiverOrganisationName;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupCaregiverKeylabel1929")
	private WebElement firstCaregiverSelect;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupCaregiverKeyerrorLabel")
	private WebElement caregiverErrorLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupFromDateKeyerrorLabel")
	private WebElement caregiverFromDateErrorLabel;

	@FindBy(how = How.ID, using = "CaregiversViewIsPopupEndDateKeyerrorLabel")
	private WebElement caregiverEndDateErrorLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='error padding-top-xs padding-bottom-xs']")
	private WebElement fromDateErrorMessage;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 '] ")
	private WebElement patientEducationOverviewTitle;

	@FindBy(how = How.ID, using = "PatientDetailViewShowMoreKey")
	private WebElement patientEducationShowMoreButton;

	@FindBy(how = How.ID, using = "PatientDetailView535")
	private WebElement patientOverviewEducationListItem;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"row px-0 mx-0 d-flex justify-content-center\"]) [4]")
	private WebElement patientOverviewEducationImage;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"] ")
	private WebElement patientOverviewEducationName;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-secondary-text-body-medium-regular text-start truncate\"] ")
	private WebElement patientOverviewEducationCategory;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 \"]")
	private WebElement patientEducationListPage;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement patientEducationDetailPage;

	@FindBy(how = How.ID, using = "PatientDetailViewNoDataFoundKey")
	private WebElement patientEducationOverviewNoRecord;

	@FindBy(how = How.ID, using = "PatientsView2665")
	private WebElement patientWithNoEducation;

	@FindBy(how = How.ID, using = "PatientsView1925")
	private WebElement checkPatientDataInCardFormat;

	@FindBy(how = How.XPATH, using = "//div[@class='avatar-circle d-flex'][1]")
	private WebElement profilePictureNotAdded;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-bottom-lg'])[1]")
	private WebElement profilePictureDisplay;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-5-semi-bold text-center truncate'])[1]")
	private WebElement patientName;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-center'])[1]")
	private WebElement patientAgeAndGenderDisplay;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-secondary-text-body-medium-regular'])[1]")
	private WebElement patientMobileNo;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-secondary-text-body-medium-regular'])[2]")
	private WebElement patientEmail;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[1]")
	private WebElement displayOverviewTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[2]")
	private WebElement displayReadingTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[3]")
	private WebElement displayPatientEducationsTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[4]")
	private WebElement displayPatientTasksTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[5]")
	private WebElement displayChatsTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[6]")
	private WebElement displayMedicationTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[7]")
	private WebElement displayFilesAndDocumentsTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[8]")
	private WebElement displayPatientAppoinmentTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[9]")
	private WebElement displayCaregiverTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[10]")
	private WebElement displayPatientProgramTab;

	@FindBy(how = How.XPATH, using = "(//li[@class='default truncate ltr'])[11]")
	private WebElement displayContactTab;

	@FindBy(how = How.XPATH, using = "//li[@class='active truncate ltr']")
	private WebElement displayDemographicsTab;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement displayAddedProgramName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-5-semi-bold text-center truncate']")
	private WebElement getPatientName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-regular text-center']")
	private WebElement getPatientAgeAndGender;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-secondary-text-body-medium-regular']")
	private WebElement getPatientMobileNumber;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-secondary-text-body-medium-regular'])[2]")
	private WebElement getPatientEmail;

	@FindBy(how = How.XPATH, using = "//label[text()='Maximum image upload size is 2 MB']")
	private WebElement uploadSize;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex align-items-center file-icon mr-3 ml-2']")
	private WebElement profileImageDisplay;

	@FindBy(how = How.XPATH, using = "//ui[@class='select-menu show']/li")
	private List<WebElement> genderDropdownList;

	@FindBy(how = How.XPATH, using = "//ui[@class='select-menu show']/li")
	private List<WebElement> bloodGroupDropdownList;

	@FindBy(how = How.XPATH, using = "//ui[@class='select-menu show']/li")
	private List<WebElement> preferredLangDropdownList;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[1]")
	private WebElement getDemographicsPatientFName;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[2]")
	private WebElement getDemographicsPatientLName;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	private WebElement getDemographicsPatientDOB;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement getPatientDemographicsPatientGender;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement getPatientDemographicsPatientPreferredLang;

	@FindBy(how = How.XPATH, using = "//input[@class='input-mobile  ltr']")
	private WebElement getPatientDemographicsPatientPhoneNo;

	@FindBy(how = How.ID, using = "PatientViewEmailAddressKeyinput-text")
	private WebElement getPatientDemographicsPatientEmail;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement getPatientDemographicsPatientBloodGroup;

	@FindBy(how = How.XPATH, using = "//div[@class='table d-flex justify-content-between flex-wrap no-border ltr']")
	private WebElement listPage;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-secondary-text-body-medium-regular'])[7]")
	private WebElement patientMobileNum;

	@FindBy(how = How.XPATH, using = "//div[@class='main-content p-0 margin-top-xxlx']")
	private WebElement cancelButtonClickBackToEditPage;

	@FindBy(how = How.XPATH, using = "(//button[@class='margin-left-md btn-secondary padding-horizontal-md '])[2]")
	private WebElement clickOnResendActivationButton;

	@FindBy(how = How.ID, using = "PatientsView1926")
	private WebElement clickOnPatientProfile;

	@FindBy(how = How.ID, using = "PatientsView2416")
	private WebElement patientForChat;

	@FindBy(how = How.ID, using = "ChatView")
	private WebElement patientChatTab;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 message px-3 pb-2  right-arrow'][1]")
	private WebElement patientChatMsg;

	@FindBy(how = How.XPATH, using = "//span[@class=' truncate ltr'][contains(.,'Chats')]")
	private WebElement patientChatTabColor;

	@FindBy(how = How.XPATH, using = "(//div[@class='row px-0 mx-0 d-flex justify-content-center'])[3]")
	private WebElement patientChatProfileImg;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])")
	private WebElement patientChatName;

	@FindBy(how = How.XPATH, using = "(//img[@class='svg-icon-small cursor-pointer'])")
	private WebElement patientChatPlusIcon;

	@FindBy(how = How.ID, using = "ChatViewAddCaption/TitleKeyinput-textArea")
	private WebElement patientChatTextbox;

	@FindBy(how = How.XPATH, using = "(//textarea[@placeholder='Enter text here'])")
	private WebElement patientChatTextboxPlaceholder;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right margin-sm'])")
	private WebElement patientChatSendButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement chatAttachFileTitle;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement chatAttachFileCrossIcon;

	@FindBy(how = How.XPATH, using = "//button[@id='ShowMoreKey']")
	private WebElement readingShowMore;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 px-0 ']")
	private WebElement readingOverviewHeader;

	@FindBy(how = How.XPATH, using = "//label[text()='raju tej']")
	private WebElement patient;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-bottom-lg'])[1]")
	private WebElement newAddedPatient;

	@FindBy(how = How.XPATH, using = "//label[text()='Taehyung Kim']")
	private WebElement patientNameCard;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeydate")
	private WebElement DOBInput;

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[1]/div/div/div/span")
	private WebElement clickOnFirstPatient;

	@FindBy(how = How.XPATH, using = "//div[@id='PatientAddEditGenderKey']/div/input")
	private WebElement genderIP;

	public TD_PatientsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientsTab);
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}

	public void creatPatient(String fName, String midName, String lName, String gender, String DOB, String bloodGroup,
			String langPref, String securityNo, String intCode, String extCode,String mobNum,String emaiID)
			throws InterruptedException {
		log("Adding patient details");
		TestConfig.PrintMethodName();
		waitForElement(driver, firstNameInput);
		firstNameInput.sendKeys(fName);
		middleNameInput.sendKeys(midName);
		lastNameInput.sendKeys(lName);
		javascriptClick(genderInput);
		WebElement selectGender = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		javascriptClick(selectGender);
		scrollAndWait(0, 500, 2);
		setDOB(DOB);
		log("Select Blood group: " + bloodGroup);
		javascriptClick(bloodGroupInput);
		WebElement selectBloodGroup = driver.findElement(By.xpath("//li[text()='" + bloodGroup + "']"));
		javascriptClick(selectBloodGroup);
		log("Select language preferance: " + langPref);
		javascriptClick(langPreferanceInput);
		WebElement selectLangPref = driver.findElement(By.xpath("(//li[text()='" + langPref + "'])[2]"));
		javascriptClick(selectLangPref);
		// securityNumber.sendKeys(securityNo);
		// internalCode.sendKeys(intCode);
		// ExternalCode.sendKeys(extCode);
		log("Add mobile number and EmailId");
		mobileNumberInput.sendKeys(mobNum);
		emailInput.sendKeys(emaiID);
		javascriptClick(patientSaveButton);
	}

	public void clickOnPatient(String patient) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + patient + "']")));
		WebElement patientName = driver.findElement(By.xpath("//label[text()='" + patient + "']"));
		javascriptClick(patientName);
	}

	public boolean isPatientDisplay(String patient) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + patient + "']")));
			WebElement patientName = driver.findElement(By.xpath("//label[text()='" + patient + "']"));
			isPresent = patientName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientListPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerTitle);
		return headerTitle.getText();
	}

	public String getAddPageHeadingText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsAddEditLabel);
		return patientsAddEditLabel.getText();
	}

	public boolean isPatientSearchBoxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientInputTextbox);
			isPresent = patientInputTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isPatientSearchIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientInputTextbox);
			isPresent = patientInputTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientListSearchPlaceholderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		return patientInputTextbox.getAttribute("placeholder");
	}

	public String getAddButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButtonCaption);
		return addButtonCaption.getText();
	}

	public void enterTextInPatientsSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		patientInputTextbox.sendKeys(text);
	}

	public String getNoRecordFoundMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noRecordFoundMessage);
		return noRecordFoundMessage.getText();
	}

	public boolean displayFullPatientList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientListDisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientListDisplay);
			isPresent = patientListDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void uploadProfileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver, uploadProfileImage);
		uploadProfileImage.sendKeys(image);
	}

	public boolean isPatientProfileDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profilePictureDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, profilePictureDisplay);
			isPresent = profilePictureDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Patient profile is not visible");
			return isPresent;
		}
	}

	public String getPatientNameInCardDetailsFormat() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientName);
		return patientName.getText();
	}

	public String getPatientAgeAndGenderInCardDetailsFormat() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAgeAndGenderDisplay);
		return patientAgeAndGenderDisplay.getText();
	}

	public boolean isPatientMobileNoInCardDetailsDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientMobileNo);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientMobileNo);
			isPresent = patientMobileNo.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isPatientEmailInCardDetailsDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEmail);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientEmail);
			isPresent = patientEmail.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isPatientProfileIsNotAdded() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profilePictureNotAdded);
		boolean isPresent = false;
		try {
			waitForElement(driver, profilePictureNotAdded);
			isPresent = profilePictureNotAdded.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSearchbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		patientInputTextbox.click();
	}

	public void clearSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		patientInputTextbox.clear();
	}

	public String getSearchedPatientName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientName);
		return getPatientName.getText();
	}

	public String getSearchedPatientAgeAndGender() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientAgeAndGender);
		return getPatientAgeAndGender.getText();
	}

	public String getSearchedPatientMobileNo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientMobileNumber);
		return getPatientMobileNumber.getText();
	}

	public String getSearchedPatientEmail() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientEmail);
		return getPatientEmail.getText();
	}

	public String getSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientSaveButton);
		return patientSaveButton.getText();
	}

	public String getCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientCancelButton);
		return patientCancelButton.getText();
	}

	public String getBasicInformationHeading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientBasicInfoLabel);
		return patientBasicInfoLabel.getText();
	}

	public String getProfileImageLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientProfileImage);
		return patientProfileImage.getText();
	}

	public String getFNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fNameLabel);
		return fNameLabel.getText();
	}

	public boolean isFNameTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstNameInput);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, firstNameInput);
			isPresent = firstNameInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;

		}
	}

	public String getFNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstNameInput);
		return firstNameInput.getAttribute("placeholder");
	}

	public String getLNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lNameLabel);
		return lNameLabel.getText();
	}

	public boolean isLNameTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lastNameInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, lastNameInput);
			isPresent = lastNameInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getLNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lastNameInput);
		return lastNameInput.getAttribute("placeholder");
	}

	public String getGenderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ganderLabel);
		return ganderLabel.getText();
	}

	public boolean isGenderDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, genderInput);
			isPresent = genderInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getGenderPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderInput);
		return genderInput.getAttribute("placeholder");
	}

	public String getDOBLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dobLabel);
		return dobLabel.getText();
	}

	public boolean isDOBCalenderControlDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dateOfBirthInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, dateOfBirthInput);
			isPresent = dateOfBirthInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getDOBPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dateOfBirthInput);
		return dateOfBirthInput.getAttribute("value");
	}

	public String getBloodGroupLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGroupLabel);
		return bloodGroupLabel.getText();
	}

	public boolean isBloodGroupDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGroupInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, bloodGroupInput);
			isPresent = bloodGroupInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getBloodGroupPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGroupInput);
		return bloodGroupInput.getAttribute("placeholder");
	}

	public String getPreferredLangLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, preferrendLangLabel);
		return preferrendLangLabel.getText();
	}

	public boolean isPreferredLangDropdownDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, langPreferanceInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, langPreferanceInput);
			isPresent = langPreferanceInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getPreferredLangDropdownPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, langPreferanceInput);
		return langPreferanceInput.getAttribute("placeholder");

	}

	public String getSocialSecurityNoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, socialSecurityNoLabel);
		return socialSecurityNoLabel.getText();
	}

	public boolean isSocialSecurityNoTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, securityNumber);
		boolean isPresent = false;
		try {
			waitForElement(driver, securityNumber);
			isPresent = securityNumber.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getSocialSecurityNoTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, securityNumber);
		return securityNumber.getAttribute("placeholder");
	}

	public String getInternalCodeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, internalCodeLabel);
		return internalCodeLabel.getText();
	}

	public boolean isInternalCodeTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, internalCode);
		boolean isPresent = false;
		try {
			waitForElement(driver, internalCode);
			isPresent = internalCode.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getInternalCodeTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, internalCode);
		return internalCode.getAttribute("placeholder");
	}

	public String getExternalCodeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, externalCodeLabel);
		return externalCodeLabel.getText();
	}

	public boolean isExternalCodeTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ExternalCode);
		boolean isPresent = false;
		try {
			waitForElement(driver, ExternalCode);
			isPresent = ExternalCode.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getExternalCodeTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ExternalCode);
		return ExternalCode.getAttribute("placeholder");
	}

	public String getMobileNumberLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberLabel);
		return mobileNumberLabel.getText();
	}

	public boolean isMobileNumberTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, mobileNumberInput);
			isPresent = mobileNumberInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getMobileNumberTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberInput);
		return mobileNumberInput.getAttribute("placeholder");
	}

	public String getEmailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailLabel);
		return emailLabel.getText();
	}

	public boolean isEmailTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		boolean isPresent = false;
		try {
			waitForElement(driver, emailInput);
			isPresent = emailInput.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getEmailTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		return emailInput.getAttribute("placeholder");
	}

	public void clickOnBloodGroupDropdownValue() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGroupInput);
		scrollAndWait(0, 500, 1000);
		bloodGroupInput.click();
	}

	public List<String> getBloodGroupList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : bloodGroupDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnPreferredLangDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, langPreferanceInput);
		langPreferanceInput.click();
	}

	public List<String> getPreferredLangList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : preferredLangDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnAnyCardInPatientList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientNameCard);
		javascriptClick(patientNameCard);
	}

	public boolean isOverViewTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, overviewTab);
		boolean isPresent = false;
		try {
			waitForElement(driver, overviewTab);
			isPresent = overviewTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnDemographicsTab() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, DemographicsTab);
		javascriptClick(DemographicsTab);
	}

	public boolean isSelctedPatientHeadingDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientHeadingDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientHeadingDisplay);
			isPresent = patientHeadingDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getDemographicsCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsCancelButtonCaption);
		return demographicsCancelButtonCaption.getText();
	}

	public String getResendActivationButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, resendActivationButtonCaption);
		return resendActivationButtonCaption.getText();
	}

	public String getDemographicsDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsDeleteButtonCaption);
		return demographicsDeleteButtonCaption.getText();
	}

	public boolean isPatientProfileImageDisplay(String patient) {
		TestConfig.PrintMethodName();
		try {
			WebElement demographicsProfileImage = driver.findElement(
					By.xpath("(//div[@class=\"row px-0 mx-0 d-flex justify-content-center\"]/parent::div/div/img)[3]"));
			profileImage.isDisplayed();
			return true;
		} catch (Exception e) {
			log("Image not visible");
			return false;
		}
	}

	public boolean isProfileDisplay(String patient) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			WebElement demographicsProfileImage = driver.findElement(
					By.xpath("(//div[@class=\"row px-0 mx-0 d-flex justify-content-center\"]/parent::div/div/img)[3]"));
			waitForElement(driver, demographicsProfileImage);
			isPresent = demographicsProfileImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Profile image not found");
			return isPresent;
		}
	}

	public String getDemographicsPatientName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientFName);
		return patientFName.getText();
	}

	public String getDemographicsPatientAgeGender() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAgeAndGender);
		return patientAgeAndGender.getText();
	}

	public String getDemographicsPatientEmail() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedPatientEmail);
		return addedPatientEmail.getText();
	}

	public String getDemographicsPatientEmailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailLabel);
		return emailLabel.getText();
	}

	public String getDemographicsPatientMobileNo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedPatientMobileNo);
		return addedPatientMobileNo.getText();
	}

	public String getDemographicsPatientMobileNumberLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberLabel);
		return mobileNumberLabel.getText();
	}

	public String getDemographicsPatientHeightLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsPatientHeightlabel);
		return demographicsPatientHeightlabel.getText();
	}

	public String getDemographicsPatientHeight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedDemographicsPatientHeight);
		return addedDemographicsPatientHeight.getText();
	}

	public String getDemographicsPatientBloodgroupLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsPatientBloodGrouplabel);
		return demographicsPatientBloodGrouplabel.getText();
	}

	public String getDemographicsPatientBloodgroup() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedDemographicsPatientBloodGroup);
		return addedDemographicsPatientBloodGroup.getText();
	}

	public String getDemographicsPatientWeightLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsPatientWeightLabel);
		return demographicsPatientWeightLabel.getText();
	}

	public String getDemographicsPatientWeight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedDemographicsPatientWeight);
		return addedDemographicsPatientWeight.getText();
	}

	public void clickOnDemographicsCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, demographicsCancelButtonCaption);
		demographicsCancelButtonCaption.click();
	}

	public boolean navigateToPatientListPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientListDisplay);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientListDisplay);
			isPresent = patientListDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOverViewTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayOverviewTab);
		return displayOverviewTab.getText();
	}

	public String getReadingsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayReadingTab);
		return displayReadingTab.getText();
	}

	public String getPatientEducationsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayPatientEducationsTab);
		return displayPatientEducationsTab.getText();
	}

	public String getPatientTasksTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayPatientTasksTab);
		return displayPatientTasksTab.getText();
	}

	public String getChatsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayChatsTab);
		return displayChatsTab.getText();
	}

	public String getMedicationsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayMedicationTab);
		return displayMedicationTab.getText();
	}

	public String getFilesAndDocumentsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayFilesAndDocumentsTab);
		return displayFilesAndDocumentsTab.getText();
	}

	public String getPatientAppointmentsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayPatientAppoinmentTab);
		return displayPatientAppoinmentTab.getText();
	}

	public String getCaregiversTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayCaregiverTab);
		return displayCaregiverTab.getText();
	}

	public String getPatientProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientProgramTab);
		return patientProgramTab.getText();
	}

	public String getDemographicsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, DemographicsTab);
		return DemographicsTab.getText();
	}

	public String getContactsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, displayContactTab);
		return displayContactTab.getText();
	}

	public void clickOnAddButtonToFillPatientDetails() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		addButton.click();
	}

	public String getEditPatientName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientFName);
		String val = patientFName.getText();
		return val;
	}

	public String getEditPatientAgeAndGender() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAgeAndGender);
		String val = patientAgeAndGender.getText();
		return val;
	}

	public String getEditPatientEmail() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedPatientEmail);
		String val = addedPatientEmail.getText();
		return val;
	}

	public String getEditPatientMobileNo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedPatientMobileNo);
		String val = addedPatientMobileNo.getText();
		return val;
	}

	public void uploadInvalidFormatProfileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver, uploadProfileImage);
		uploadProfileImage.sendKeys(image);
	}

	public String getInvalidImageUploadSizeFormat() {
		TestConfig.PrintMethodName();
		waitForElement(driver, uploadSize);
		return uploadSize.getText();
	}

	public boolean isPatientProfileImageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profileImageDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, profileImageDisplay);
			isPresent = profileImageDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientSaveButton);
		javascriptClick(patientSaveButton);
	}

	public String getFirstNameRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fNameRequired);
		return fNameRequired.getText();
	}

	public String getLastNameRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lNameRequired);
		return lNameRequired.getText();
	}

	public String getGenderRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderRequired);
		return genderRequired.getText();
	}

	public String getDOBRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDOBRequired);
		return getDOBRequired.getText();
	}

	public String getBloodgroupRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodgroupRequired);
		return bloodgroupRequired.getText();
	}

	public String getPreferredLangRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, preferredLangRequired);
		return preferredLangRequired.getText();
	}

	public String getMobileNoRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNoRequired);
		return mobileNoRequired.getText();
	}

	public String getEmailRequiredLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailRequired);
		return emailRequired.getText();
	}

	public boolean getFirstNameFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, fNameRequired);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, fNameRequired);
			isPresent = fNameRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getLastNameFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, lNameRequired);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, lNameRequired);
			isPresent = lNameRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getGenderFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderRequired);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, genderRequired);
			isPresent = genderRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getDOBFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDOBRequired);
		boolean isPresent = false;
		try {
			waitForElement(driver, getDOBRequired);
			isPresent = getDOBRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getBloodgroupFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodgroupRequired);
		boolean isPresent = false;
		try {
			waitForElement(driver, bloodgroupRequired);
			isPresent = bloodgroupRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getPreferredLangFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, preferredLangRequired);
		boolean isPresent = false;
		try {
			waitForElement(driver, preferredLangRequired);
			isPresent = preferredLangRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getMobileNoFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNoRequired);
		boolean isPresent = false;
		try {
			waitForElement(driver, mobileNoRequired);
			isPresent = mobileNoRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getEmailFieldHighlighted() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailRequired);
		boolean isPresent = false;
		try {
			waitForElement(driver, emailRequired);
			isPresent = emailRequired.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void wrongMobileNoAndEmail(String invalidMobileNo, String invalidEmail) throws Exception {
		log("Adding patient invalid mobileno and email details");
		TestConfig.PrintMethodName();
		waitForElement(driver, mobileNumberInput);
		mobileNumberInput.sendKeys(invalidMobileNo);
		waitForElement(driver, emailInput);
		emailInput.sendKeys(invalidEmail);
	}

	public String getMobileNoErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, minimumLenghtMobileNo);
		return minimumLenghtMobileNo.getText();
	}

	public String getEmailErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, rangeShouldBeEmailid);
		return rangeShouldBeEmailid.getText();
	}

	public void clearEmailTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		emailInput.clear();
	}

	public void fillAgainEmailFiled(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailInput);
		emailInput.sendKeys(text);
	}

	public String getEmailErrorMessageDataInvalid() {
		TestConfig.PrintMethodName();
		waitForElement(driver, yourDataShouldBeInvalidEmailid);
		return yourDataShouldBeInvalidEmailid.getText();
	}

	public String getPatientDemographicesFName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDemographicsPatientFName);
		Actions ac = new Actions(driver);
		ac.moveToElement(getDemographicsPatientFName);
		String val = getDemographicsPatientFName.getAttribute("value");
		return val;
	}

	public String getPatientDemographicesLName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDemographicsPatientLName);
		String val = getDemographicsPatientLName.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientDOB() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getDemographicsPatientDOB);
		String val = getDemographicsPatientDOB.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientGender() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientDemographicsPatientGender);
		String val = getPatientDemographicsPatientGender.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientBloodGroup() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientDemographicsPatientBloodGroup);
		String val = getPatientDemographicsPatientBloodGroup.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientPreferredLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientDemographicsPatientPreferredLang);
		String val = getPatientDemographicsPatientPreferredLang.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientEmail() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientDemographicsPatientEmail);
		String val = getPatientDemographicsPatientEmail.getAttribute("value");
		return val;
	}

	public String getPatientDemographicsPatientPhoneNo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, getPatientDemographicsPatientPhoneNo);
		String val = getPatientDemographicsPatientPhoneNo.getAttribute("value");
		return val;
	}

	public void clickOnCardToDeletePatientDetails() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnCardToDeleteDetails);
		clickOnCardToDeleteDetails.click();
	}

	public void clickOnDeleteButtonInPatient() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickOnDeleteButton);
		scrollAndWait(0, 0, 3000);
		javascriptClick(clickOnDeleteButton);
	}

	public String getDeletePoPUpMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePoPUpDisplay);
		return deletePoPUpDisplay.getText();
	}

	public boolean isXIconButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, xIconDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, xIconDisplay);
			isPresent = xIconDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element not found");
			return isPresent;
		}
	}

	public String getEditPageCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEditCancelButton);
		return patientEditCancelButton.getText();
	}

	public String isOKButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okButtonDisplay);
		return okButtonDisplay.getText();
	}

	public void clickOnCancelButtonInPatientEditPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEditCancelButton);
		patientEditCancelButton.click();
	}

	public void clickOnOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okButtonDisplay);
		okButtonDisplay.click();
	}

	public boolean isAgainEditPatientPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonClickBackToEditPage);
		boolean isPresent = false;
		try {
			waitForElement(driver, cancelButtonClickBackToEditPage);
			isPresent = cancelButtonClickBackToEditPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isReadingShowMoreDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingShowMore);
		boolean isPresent = false;
		try {
			waitForElement(driver, readingShowMore);
			isPresent = readingShowMore.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getReadingOverviewHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingOverviewHeader);
		return readingOverviewHeader.getText();
	}

	public void clickOnGenderDropdownValue() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderIP);
		scrollAndWait(0, 300, 1000);
		genderIP.click();
		;
	}

	public List<String> getGenderList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : genderDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getIncorrectFormatErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, invalidProfileImage);
		return invalidProfileImage.getText();
	}

	public void clickOnExistingPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patient);
		javascriptClick(patient);
	}

	public void clickOnNewAddedPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newAddedPatient);
		javascriptClick(newAddedPatient);
	}

	public void setDOB(String DOB) {
		TestConfig.PrintMethodName();
		waitForElement(driver, DOBInput);
		log("Add DOB");
		String[] dateOfBirth = DOB.split("/");
		for (int i = 0; i < dateOfBirth.length; i++) {
			DOBInput.sendKeys(dateOfBirth[i]);
		}
	}

	public void clickOnFirstPatient() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(clickOnFirstPatient);
		waitForElement(driver, clickOnFirstPatient);
		javascriptClick(clickOnFirstPatient);
	}

	public void clickOnNewAddedPatient(String patientName) {
		TestConfig.PrintMethodName();
		WebElement patient = driver.findElement(By.xpath("//label[text()='" + patientName + "']"));
		waitForElement(driver, patient);
		javascriptClick(patient);
	}

	public boolean isPatientNameOnCardDetailsDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientName);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientName);
			isPresent = patientName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Patient name on card details is not visible");
			return isPresent;
		}
	}

	public boolean isPatientAgeAndGenderDetailsDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientAgeAndGenderDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientAgeAndGenderDisplay);
			isPresent = patientAgeAndGenderDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Patient Age and Gender details is not visible");
			return isPresent;
		}
	}

}