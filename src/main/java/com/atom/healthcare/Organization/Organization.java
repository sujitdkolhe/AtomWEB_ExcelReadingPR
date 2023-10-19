package com.atom.healthcare.Organization;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import org.openqa.selenium.support.How;

public class Organization extends BasePageObject {
	private static Organization org = new Organization(driver);

	public Organization(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static Organization getOrganization() {
		return org;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='LeftMenuOrganisationMenuOrganisationTabView']")
	private WebElement organizationTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement orgTitle;

	@FindBy(how = How.XPATH, using = "(//div[@class='row px-0 mx-0 d-flex justify-content-center']/img)[2]")
	private WebElement orgLogo;

	@FindBy(how = How.XPATH, using = "(//img[@class='avatar-circle'])[2]")
	private WebElement orgLogPresent;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold d-flex ltr']")
	private WebElement orgName;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular lbl-no-wrap ltr'])[1]")
	private WebElement domainLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs lbl-no-wrap ltr'])[1]")
	private WebElement domainName;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular lbl-no-wrap ltr'])[2]")
	private WebElement createdLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs lbl-no-wrap ltr'])[2]")
	private WebElement createdDate;

	@FindBy(how = How.XPATH, using = "//li[@id='OrganisationView']")
	private WebElement organizationProfileTab;

	@FindBy(how = How.XPATH, using = "//li[@id='BranchesView']")
	private WebElement branchOverviewTab;

	@FindBy(how = How.XPATH, using = "//li[@id='OrganisationContactsView']")
	private WebElement organizationContactTab;

	@FindBy(how = How.XPATH, using = "//li[@id='OrganisationSettingsView']")
	private WebElement settingTab;

	@FindBy(how = How.XPATH, using = "//li[@id='OrganisationThemeSettingsView']")
	private WebElement themeTab;

	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement uploadLogo;

	@FindBy(how = How.ID, using = "OrganisationContactsViewSaveActionKey")
	private WebElement saveButton;

	@FindBy(how = How.ID, using = "LogoKeyDeleteActionKey")
	private WebElement deleteButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement branchViewList;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold']")
	private WebElement organizationProfileView;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement labelOrganization;

	@FindBy(how = How.XPATH, using = "(//label[text()='Domain'])[2]")
	private WebElement labelDomain;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement labelGstNumber;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement labelDefaultLang;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement labelSelectLang;

	@FindBy(how = How.ID, using = "OrganisationViewSaveActionKey")
	private WebElement profileSaveButton;

	@FindBy(how = How.XPATH, using = "//input[@id='OrganisationViewOrganisationNameKey3input-text']")
	private WebElement organizationName;

	@FindBy(how = How.ID, using = "OrganisationViewDomainKeyinput-text")
	private WebElement orgDomainName;

	@FindBy(how = How.ID, using = "OrganisationViewTaxNumberKeyinput-text")
	private WebElement orgGstNumber;

	@FindBy(how = How.ID, using = "BranchesViewSearchTextKey")
	private WebElement branchSearchTextbox;

	@FindBy(how = How.ID, using = "BranchesViewAddActionKey")
	private WebElement branchAddButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[1]")
	private WebElement branchName;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[2]")
	private WebElement branchDept;

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[2]")
	private WebElement orgNameInProfile;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement orgDomainLabel;

	@FindBy(how = How.XPATH, using = "//input[@id='OrganisationViewDefaultLanguageKeyinput-text']")
	private WebElement defaultLanguageDropdown;

	@FindBy(how = How.XPATH, using = "(//div[@class='strips d-flex justify-content-between'])[1]")
	private WebElement firstSelectedLanguages;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular'])[2]")
	private WebElement SecondSelectedLanguages;

	@FindBy(how = How.ID, using = "BranchesViewIsPopupBranchNameKey1input-text")
	private WebElement firstbranchNameTextbox;

	@FindBy(how = How.ID, using = "BranchesViewIsPopuptabs2")
	private WebElement secondLanguage;

	@FindBy(how = How.ID, using = "BranchesViewIsPopupBranchNameKey2input-text")
	private WebElement secondbranchNameTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr '])[1]")
	private WebElement firstDeptCheckbox;

	@FindBy(how = How.ID, using = "BranchesViewSaveActionKey")
	private WebElement branchSaveButton;

	@FindBy(how = How.XPATH, using = "//label[@id='BranchesViewerrorLabel']")
	private WebElement branchNoRecordFound;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	private WebElement firstbranch;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[1]")
	private WebElement branchAddEditHeader;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 px-0 table-min-height']")
	private WebElement branchList;

	@FindBy(how = How.ID, using = "OrganisationViewOrganisationNameKey1errorLabel")
	private WebElement orgErrorMessage;

	@FindBy(how = How.ID, using = "OrganisationViewerrorLabel")
	private WebElement orgLangErrorMessage;

	@FindBy(how = How.ID, using = "OrganisationViewtabs1")
	private WebElement orgFirstLanguage;

	@FindBy(how = How.ID, using = "OrganisationViewtabs2")
	private WebElement orgSecondLanguage;

	@FindBy(how = How.XPATH, using = "//input[@id='OrganisationViewOrganisationNameKey1input-text']")
	private WebElement orgFirstTextbox;

	@FindBy(how = How.ID, using = "OrganisationViewOrganisationNameKey2input-text")
	private WebElement orgSecondTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[5]")
	private WebElement thirdbranch;

	@FindBy(how = How.ID, using = "BranchesViewDeleteActionKey")
	private WebElement branchDeleteButton;

	@FindBy(how = How.ID, using = "BranchesViewOkActionKey")
	private WebElement branchOkButton;

	@FindBy(how = How.ID, using = "OrganisationViewDefaultLanguageKeyerrorLabel")
	private WebElement defaultLanguageError;

	@FindBy(how = How.ID, using = "OrganisationContactsViewerrorLabel")
	private WebElement contactErrorLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement orgContactHeader;

	@FindBy(how = How.ID, using = "OrganisationContactsViewAddActionKey")
	private WebElement addContactButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[1]")
	private WebElement contactRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[2]")
	private WebElement typeRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[3]")
	private WebElement detailsRow;

	@FindBy(how = How.XPATH, using = " //label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement addOrganisation;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	private WebElement clickonemail;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement editOrgHeader;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement addorgcrossicon;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr'])[4]")
	private WebElement orgSecondLanguageCheckbox;

	@FindBy(how = How.ID, using = "OrganisationViewSelectLanguagesKeyinput-text")
	private WebElement SelectLanguageDropdown;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-regular ']")
	private WebElement removeButton;

	@FindBy(how = How.XPATH, using = "(//div[@style='position:relative'])[2]/input")
	private WebElement orgTypePlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement orgTypeLabel;

	@FindBy(how = How.ID, using = "OrganisationContactsViewIsPopupContactTypeKeyinput-text")
	private WebElement typeTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement orgContatlabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Contact']")
	private WebElement orgContactPlaceholder;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement ContactTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr'])[1]")
	private WebElement selectAllLanguage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr'])[2]")
	private WebElement arabicLanguage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr'])[3]")
	private WebElement englishLanguage;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr'])[4]")
	private WebElement hindiLanguage;

	@FindBy(how = How.XPATH, using = "//ui[@id='OrganisationViewDefaultLanguageKeyListItems']/li")
	private List<WebElement> defaultLanguageList;

	@FindBy(how = How.XPATH, using = "//ui[@id='OrganisationViewSelectLanguagesKeyListItems']/li")
	private List<WebElement> selectLanguageList;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[7]")
	private WebElement addressDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement addressLabel;

	@FindBy(how = How.XPATH, using = "(//img[@class='avatar-circle'])[2]")
	private WebElement orgAvatar;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	private WebElement emailDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement emailLabel;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[9]")
	private WebElement phoneNoDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement phoneNoLabel;

	@FindBy(how = How.ID, using = "OrganisationContactsViewSaveActionKey")
	private WebElement saveBtn;

	@FindBy(how = How.ID, using = "OrganisationContactsViewCancelActionKey")
	private WebElement cancelBtn;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[1]")
	private WebElement emaillist;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary  ltr']")
	private WebElement emailTextbox;

	@FindBy(how = How.ID, using = "OrganisationContactsViewDeleteActionKey")
	private WebElement deletebutton;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[3]")
	private WebElement typeList;

	@FindBy(how = How.XPATH, using = "//ui[@id='OrganisationContactsViewIsPopupContactKeyListItems']/li")
	private List<WebElement> ContactTextBoxList;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='OrganisationContactsViewIsPopupContactTypeKeyListItems']/li"))
	private List<WebElement> TypeTextBoxList;

	@FindBy(how = How.ID, using = "OrganisationContactDetailsAddressContactKey1errorlabel")
	private WebElement addresserror;

	@FindBy(how = How.ID, using = "OrganisationContactsViewIsPopupContactKeylabel183")
	private WebElement addressclick;

	@FindBy(how = How.ID, using = "OrganisationContactDetailsAddressContactKey1input-textArea")
	private WebElement addressTextbox;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	private WebElement emailclick;

	@FindBy(how = How.ID, using = "OrganisationContactDetailsEmailContactKey1errorLabel")
	private WebElement emailerror;

	@FindBy(how = How.ID, using = "OrganisationContactDetailsPhoneContactKey1errorLabel")
	private WebElement phoneNoError;

	@FindBy(how = How.ID, using = "OrganisationContactDetailsPhoneContactKey1phone_text")
	private WebElement phoneNoTextBox;

	@FindBy(how = How.ID, using = "OrganisationContactsViewIsPopupContactTypeKeyerrorLabel")
	private WebElement typeTextboxError;

	@FindBy(how = How.ID, using = "OrganisationContactsViewIsPopupContactKeyerrorLabel")
	private WebElement contactTextboxError;

	@FindBy(how = How.ID, using = "OrganisationContactsViewIsPopupContactTypeKeylabel181")
	private WebElement homeDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='childdisplay truncate col browser-specific-padding-remove d-flex flex-column  cursor-pointer lbl-primary-text-body-large-regular'])[4]")
	private WebElement phoneNoList;

	@FindBy(how = How.ID, using = "OrganisationContactsViewCancelActionKey")
	private WebElement cancelPopupBtn;

	@FindBy(how = How.ID, using = "OrganisationContactsViewOkActionKey")
	private WebElement okPopupBtn;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement popupScreen;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[5]")
	private WebElement themeSettingsTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold']")
	private WebElement themeSettingsHeader;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewSaveActionKey")
	private WebElement themeSaveButton;

	@FindBy(how = How.XPATH, using = "(//input[@id='OrganisationThemeSettingsViewPrimaryAppColorKeycolorLabel'])[1]")
	private WebElement primarythemecolor;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewHeaderBackgroundColorKeycolorLabel")
	private WebElement headerbackgroundcolor;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewHeaderTextColorKeycolorLabel")
	private WebElement headerfontcolor;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewFooterBackgroundColorKeycolorLabel")
	private WebElement footerbackgroundcolor;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewFooterTextColorKeycolorLabel")
	private WebElement footerfontcolor;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement primarythemecolorlabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement headerbackgroundcolorlabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement headerfontcolorlabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement footerbackgroundcolorlabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement footerfontcolorlabel;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement popupscreenmsg;

	@FindBy(how = How.XPATH, using = "(//input[@class='color-picker align-items-center cursor-pointer ltr'])[1]")
	private WebElement primarythemecolorpicker;

	@FindBy(how = How.XPATH, using = "(//input[@class='color-picker align-items-center cursor-pointer ltr'])[2]")
	private WebElement headerbackgroundcolorpicker;

	@FindBy(how = How.XPATH, using = "(//input[@class='color-picker align-items-center cursor-pointer ltr'])[3]")
	private WebElement headerfontcolorpicker;

	@FindBy(how = How.XPATH, using = "(//input[@class='color-picker align-items-center cursor-pointer ltr'])[4]")
	private WebElement footerbackgroundcolorpicker;

	@FindBy(how = How.XPATH, using = "(//input[@class='color-picker align-items-center cursor-pointer ltr'])[5]")
	private WebElement footerfontcolorpicker;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement logokeylabel;

	@FindBy(how = How.ID, using = "LogoKeyerrorLabel")
	private WebElement logoimageuploaderror;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex w-available align-items-center']")
	private WebElement imageuploadcontrol;

	@FindBy(how = How.XPATH, using = "(//img[@class='avatar-circle'])[3]")
	private WebElement imagepreview;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-regular margin-right-md']")
	private WebElement imagename;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 d-flex upload-btn-wrapper']")
	private WebElement imagecontrolbox;

	@FindBy(how = How.ID, using = "OrganisationThemeSettingsViewPrimaryAppColorKeyerrorLabel")
	private WebElement primarythemetextboxerror;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[4]")
	private WebElement orgsettingstab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold']")
	private WebElement settingsheader;

	@FindBy(how = How.ID, using = "OrganisationSettingsViewSaveActionKey")
	private WebElement settingsavebutton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-regular margin-right-md']")
	private WebElement orguploadname;

	@FindBy(how = How.XPATH, using = "//label[@class='flex-end mr-2 delete-label cursor-pointer']")
	private WebElement deletebtn;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs']")
	private WebElement dashboard;

	@FindBy(how = How.ID, using = "LogoKeyerrorLabel")
	private WebElement imageSizeError;

	public String getOrganizationPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgTitle);
		return orgTitle.getText();
	}

	public boolean isOrganizationLogoPresentDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgLogPresent);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, orgLogPresent);
			isPresent = orgLogPresent.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrganizationLogoDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgLogo);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, orgLogo);
			isPresent = orgLogo.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrganizationName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgName);
		return orgName.getText();
	}

	public String getDomainLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, domainLabel);
		return domainLabel.getText();
	}

	public String getDomainName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, domainName);
		return domainName.getText();
	}

	public String getCreatedLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, createdLabel);
		return createdLabel.getText();
	}

	public String getCreatedDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, createdDate);
		return createdDate.getText();
	}

	public boolean isOrganizationProfileTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationProfileTab);
		boolean isPresent = false;
		try {
			waitForElement(driver, organizationProfileTab);
			isPresent = organizationProfileTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrganizationBranchOverviewTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, branchOverviewTab);
			isPresent = branchOverviewTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrganizationContactTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationContactTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, organizationContactTab);
			isPresent = organizationContactTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrganizationSettingsTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, settingTab);
			isPresent = settingTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isOrganizationThemeSettingsTabDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, themeTab);
			isPresent = themeTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnOrganizationProfileTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationProfileTab);
		javascriptClick(organizationProfileTab);
	}

	public void clickOnBranchOverviewTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewTab);
		javascriptClick(branchOverviewTab);
	}

	public void clickOnContactTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationContactTab);
		// organizationContactTab.click();
		javascriptClick(organizationContactTab);
	}

	public void clickOnSettingsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingTab);
		settingTab.click();
	}

	public void clickOnThemeSettingsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeTab);
		javascriptClick(themeTab);
	}

	public void uploadOrganizationLogo(String image) throws InterruptedException {
		TestConfig.PrintMethodName();
		scrollAndWait(0, 1000, 1000);
		waitUntilElementIsVisible(uploadLogo);
		waitForElement(driver, uploadLogo);
		try {
			javascriptClick(deleteButton);
			javascriptClick(uploadLogo);
			uploadLogo.sendKeys(image);
			Thread.sleep(15000);
		} catch (Exception e) {
			javascriptClick(uploadLogo);
			uploadLogo.sendKeys(image);
			Thread.sleep(15000);
		}
	}

	public void clickOndeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deleteButton);
		deleteButton.click();
	}

	public void clickOnOrganizationMenuTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(organizationTab);
		waitForElement(driver, organizationTab);
		javascriptClick(organizationTab);
	}

	public String getOragnizationProfileTabHighLightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationContactTab);
		String cssValue = organizationProfileTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isOrganizationProfilePageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeTab);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, organizationProfileView);
			isPresent = organizationProfileView.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBranchOverviewTabHighLightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationContactTab);
		String cssValue = branchOverviewTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isBranchOverviewPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchViewList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, branchViewList);
			isPresent = branchViewList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrganizationProfileHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationProfileView);
		return organizationProfileView.getText();
	}

	public String getOrganizationLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, labelOrganization);
		return labelOrganization.getText();
	}

	public String getOrgDomainLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, labelOrganization);
		return domainLabel.getText();
	}

	public String getOrgGstNumberLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, labelGstNumber);
		return labelGstNumber.getText();
	}

	public String getOrgDefaultLangLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, labelDefaultLang);
		return labelDefaultLang.getText();
	}

	public String getOrgSelectLangLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, labelSelectLang);
		return labelSelectLang.getText();
	}

	public boolean isOrganizationProfileSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, profileSaveButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, profileSaveButton);
			isPresent = profileSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrganizationNameInProfileTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgNameInProfile);
		return orgNameInProfile.getAttribute("value");
	}

	public String getOrganizationDomain() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgDomainName);
		return orgDomainName.getAttribute("value");
	}

	public String getOrgGstNumberField() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgGstNumber);
		return orgGstNumber.getAttribute("value");
	}

	public String getOrganizationBranchHeader() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(branchViewList);
		waitForElement(driver, branchViewList);
		return branchViewList.getText();
	}

	public String getBranchLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchName);
		return branchName.getText();
	}

	public String getBranchDepartmentLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchDept);
		return branchDept.getText();
	}

	public boolean isBranchSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, branchSearchTextbox);
			isPresent = branchSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBranchAddButtonDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchAddButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, branchAddButton);
			isPresent = branchAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnOrgNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgNameInProfile);
		javascriptClick(orgNameInProfile);
	}

	public String getDefaultLanguages() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchDept);
		return defaultLanguageDropdown.getAttribute("value");
	}

	public String getFirstSelectedLanguages() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstSelectedLanguages);
		return firstSelectedLanguages.getText();
	}

	public String getSecondSelectedLanguages() {
		TestConfig.PrintMethodName();
		waitForElement(driver, SecondSelectedLanguages);
		return SecondSelectedLanguages.getText();
	}

	public void clickOnBranchAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchAddButton);
		javascriptClick(branchAddButton);
	}

	public void addNewBranch(String newfirstbranch, String newsecondbranch) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, thirdbranch);
		try {
			javascriptClick(thirdbranch);
			javascriptClick(branchDeleteButton);
			javascriptClick(branchOkButton);
			javascriptClick(branchAddButton);
			firstbranchNameTextbox.sendKeys(newfirstbranch);
			javascriptClick(secondLanguage);
			secondbranchNameTextbox.sendKeys(newsecondbranch);
			javascriptClick(firstDeptCheckbox);
			javascriptClick(branchSaveButton);
		} catch (Exception e) {
			javascriptClick(branchAddButton);
			firstbranchNameTextbox.sendKeys(newfirstbranch);
			javascriptClick(secondLanguage);
			secondbranchNameTextbox.sendKeys(newsecondbranch);
			javascriptClick(firstDeptCheckbox);
			javascriptClick(branchSaveButton);
		}
	}

	public void enterTextInbranchOverviewSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchSearchTextbox);
		branchSearchTextbox.sendKeys(text);
	}

	public void clearbranchOverviewSearchBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchSearchTextbox);
		branchSearchTextbox.clear();
	}

	public String getbranchNoRecordFoundText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNoRecordFound);
		return branchNoRecordFound.getText();
	}

	public boolean isFirstBranchNameDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstbranch);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, firstbranch);
			isPresent = firstbranch.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBranchAddEditHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchAddEditHeader);
		return branchAddEditHeader.getText();
	}

	public void clickOnFirstBranch() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstbranch);
		javascriptClick(firstbranch);
	}

	public void clickOnFirstHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstbranch);
		javascriptClick(branchName);
	}

	public boolean isBranchListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, branchList);
			isPresent = branchList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getLabelDomain() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(labelDomain);
		waitForElement(driver, labelDomain);
		return labelDomain.getText();
	}

	public void clearOrgFirstLanguage(String value) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(orgFirstTextbox);
		waitForElement(driver, orgFirstTextbox);
		javascriptClick(orgFirstTextbox);
		orgFirstTextbox.clear();
		orgFirstTextbox.sendKeys(value);
	}

	public String getOrgErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgErrorMessage);
		return orgErrorMessage.getText();
	}

	public String getOrgLangErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgLangErrorMessage);
		return orgLangErrorMessage.getText();
	}

	public void clickOnOrgSecondLanguageTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgSecondLanguage);
		javascriptClick(orgSecondLanguage);
	}

	public void clearOrgSecondLanguage(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgSecondTextbox);
		Actions act = new Actions(driver);
		act.click(orgSecondTextbox).build().perform();
		// javascriptClick(orgSecondTextbox);
		orgSecondTextbox.clear();
		orgSecondTextbox.sendKeys(value);
	}

	public String getBranchSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchSearchTextbox);
		return branchSearchTextbox.getAttribute("value");
	}

	public void clickOnSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchSearchTextbox);
		Actions action = new Actions(driver);
		action.click(branchSearchTextbox).build().perform();
	}

	public String getdefaultLangErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, defaultLanguageError);
		return defaultLanguageError.getText();
	}

	public void cleardefaultLanguage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, defaultLanguageError);
		javascriptClick(defaultLanguageError);
		defaultLanguageError.clear();
	}

	public String getOrgContactRecordsMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contactErrorLabel);
		return contactErrorLabel.getText();
	}

	public void clickOnContactAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addContactButton);
		// addContactButton.click();
		javascriptClick(addContactButton);
	}

	public String getTabHighlightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, organizationContactTab);
		String cssValue = organizationContactTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getOrgContactHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgContactHeader);
		return orgContactHeader.getText();
	}

	public String getContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contactRow);
		return contactRow.getText();
	}

	public String getTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeRow);
		return typeRow.getText();
	}

	public String getDetailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, detailsRow);
		return detailsRow.getText();
	}

	public String getAddOrgHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addOrganisation);
		return addOrganisation.getText();
	}

	public void clickOnAnyListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickonemail);
		// clickonemail.click();
		javascriptClick(clickonemail);
	}

	public String getEditOrgPage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editOrgHeader);
		return editOrgHeader.getText();
	}

	public boolean isOrganizationCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addorgcrossicon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addorgcrossicon);
			isPresent = addorgcrossicon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void removeSelectedLanguage() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, removeButton);
		javascriptClick(removeButton);
		javascriptClick(profileSaveButton);
	}

	public boolean isSecondLanguageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(SecondSelectedLanguages);
			waitForElement(driver, SecondSelectedLanguages);
			isPresent = SecondSelectedLanguages.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getOrgTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgTypeLabel);
		return orgTypeLabel.getText();
	}

	public String getOrgTypePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgTypePlaceholder);
		return orgTypePlaceholder.getText();
	}

	public void clearDefaultLanguage() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickonemail);
		defaultLanguageDropdown.click();
		defaultLanguageDropdown.clear();
	}

	public void clickProfileSaveButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, profileSaveButton);
		javascriptClick(profileSaveButton);
	}

	public void clickOnTypeTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(orgTypePlaceholder);
		waitForElement(driver, orgTypePlaceholder);
		// typeTextbox.click();
		Actions act = new Actions(driver);
		act.click().build().perform();
		// act.sendKeys(orgTypePlaceholder, Keys.ENTER).build().perform();
		// javascriptClick(orgTypePlaceholder);
	}

	public String getOrgTypeTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgTypePlaceholder);
		return orgTypePlaceholder.getAttribute("value");
	}

	public void selectNewLanguage() throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, removeButton);
			if (removeButton.isDisplayed()) {
				javascriptClick(removeButton);
				javascriptClick(SelectLanguageDropdown);
				javascriptClick(orgSecondLanguageCheckbox);
				javascriptClick(profileSaveButton);
			}
		} catch (Exception e) {
			log("Language is already removed");
			javascriptClick(SelectLanguageDropdown);
			javascriptClick(orgSecondLanguageCheckbox);
			javascriptClick(profileSaveButton);
		}
	}

	public void clickOnDefaultLanguageDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(defaultLanguageDropdown);
		waitForElement(driver, defaultLanguageDropdown);
		Actions act = new Actions(driver);
		act.click(defaultLanguageDropdown).build().perform();
	}

	public void clickOnSelectLanguageDropdown() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, SelectLanguageDropdown);
		Actions act = new Actions(driver);
		act.click(SelectLanguageDropdown).build().perform();
	}

	public List<String> getdefaultLanguageList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : defaultLanguageList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public List<String> getSelectLanguageList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : selectLanguageList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getOrgContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgTypeLabel);
		return orgTypeLabel.getText();

	}

	public String getOrgContactTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgContactPlaceholder);
		return orgContactPlaceholder.getAttribute("value");
	}

	public void clickOnContactTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ContactTextbox);
		// typeTextbox.click();
		Actions act = new Actions(driver);
		act.click(ContactTextbox).build().perform();
		// act.sendKeys(ContactTextbox, Keys.ENTER).build().perform();
		// javascriptClick(ContactTextbox);
	}

	public void clickOnAddressDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addressDropdown);
		Actions act = new Actions(driver);
		act.click(addressDropdown).build().perform();

	}

	public String getAddressLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addressLabel);
		return addressLabel.getText();
	}

	public void clickOnEmailDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailDropdown);
		Actions act = new Actions(driver);
		act.click(emailDropdown).build().perform();

	}

	public void clickOnPhoneNoDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoDropdown);
		Actions act = new Actions(driver);
		act.click(phoneNoDropdown).build().perform();

	}

	public String getEmailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailLabel);
		return emailLabel.getText();
	}

	public String getPhoneNoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoLabel);
		return phoneNoLabel.getText();
	}

	public boolean isContactSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveBtn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, saveBtn);
			isPresent = saveBtn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSaveText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveBtn);
		return saveBtn.getText();
	}

	public boolean isContactCancelButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelBtn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, cancelBtn);
			isPresent = cancelBtn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCancelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelBtn);
		return cancelBtn.getText();
	}

	public void clickOnEmailList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emaillist);
		Actions act = new Actions(driver);
		act.click(emaillist).build().perform();

	}

	public String getTypeTextboxPrefilled() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeTextbox);
		return typeTextbox.getAttribute("value");
	}

	public String getContactTextboxPrefilled() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ContactTextbox);
		return ContactTextbox.getAttribute("value");
	}

	public String getEmailTextboxPrefilled() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailTextbox);
		return emailTextbox.getAttribute("value");
	}

	public boolean isContactDeleteButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebutton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, deletebutton);
			isPresent = deletebutton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addorgcrossicon);
		Actions act = new Actions(driver);
		act.click(addorgcrossicon).build().perform();

	}

	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelBtn);
		Actions act = new Actions(driver);
		act.click(cancelBtn).build().perform();

	}

	public String getTypeList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeList);
		return typeList.getText();
	}

	public void clickOnCancelSelectTypePicker() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeTextbox);
		Actions act = new Actions(driver);
		act.click(typeTextbox).build().perform();

	}

	public List<String> getTypeTextboxList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : TypeTextBoxList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public void clickOnTypeTextBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeTextbox);
		Actions act = new Actions(driver);
		act.click(typeTextbox).build().perform();

	}

	public List<String> getContactTextboxList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(ContactTextBoxList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : ContactTextBoxList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public String getAddressError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addresserror);
		return addresserror.getText();
	}

	public void enterTextInAddressTextbox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, addressTextbox);
		addressTextbox.sendKeys(text);
	}

	public void enterTextInEmailTextbox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailTextbox);
		emailTextbox.sendKeys(text);
	}

	public String getEmailError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailerror);
		return emailerror.getText();
	}

	public void clickOnPhoneNoTextBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoTextBox);
		Actions act = new Actions(driver);
		act.click(phoneNoTextBox).build().perform();

	}

	public String getPhoneNoError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoError);
		return phoneNoError.getText();
	}

	public void enterTextInPhoneNoTextBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoTextBox);
		phoneNoTextBox.sendKeys(text);
	}

	public void clickOnSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveButton);
		Actions act = new Actions(driver);
		act.click(saveButton).build().perform();
	}

	public String getTypeTextboxError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeTextboxError);
		return typeTextboxError.getText();
	}

	public String getContactTextboxError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contactTextboxError);
		return contactTextboxError.getText();
	}

	public void clickOnHomeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, homeDropdown);
		Actions act = new Actions(driver);
		act.click(homeDropdown).build().perform();

	}

	public void clickOnTypeTxtBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeTextbox);
		Actions act = new Actions(driver);
		act.click(typeTextbox).build().perform();

	}

	public void clickOnPhoneNoList() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoList);
		Actions act = new Actions(driver);
		act.click(phoneNoList).build().perform();

	}

	public String getDeletePopupScreen() {
		TestConfig.PrintMethodName();
		waitForElement(driver, popupscreenmsg);
		return popupscreenmsg.getText();
	}

	public boolean isCancelPopupBtnDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelPopupBtn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, cancelPopupBtn);
			isPresent = cancelPopupBtn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public boolean isOkPopupBtnDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okPopupBtn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, okPopupBtn);
			isPresent = okPopupBtn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebutton);
		Actions act = new Actions(driver);
		act.click(deletebutton).build().perform();

	}

	public void clickOnCancelBtn() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelPopupBtn);
		Actions act = new Actions(driver);
		act.click(cancelPopupBtn).build().perform();

	}

	public void clickOnOkBtn() {
		TestConfig.PrintMethodName();
		waitForElement(driver, okPopupBtn);
		Actions act = new Actions(driver);
		act.click(okPopupBtn).build().perform();

	}

	public void clickThemeSettingsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSettingsTab);
		Actions act = new Actions(driver);
		act.click(themeSettingsTab).build().perform();
	}

	public boolean isThemeSettingsHeaderDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSettingsHeader);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, themeSettingsHeader);
			isPresent = themeSettingsHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getDeleteButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebutton);
		return deletebutton.getText();
	}

	public String getOrgThemeSettingsTabHighLightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSettingsTab);
		String cssValue = themeSettingsTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getThemeSettingsHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSettingsHeader);
		return themeSettingsHeader.getText();
	}

	public boolean isThemeSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSaveButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, themeSaveButton);
			isPresent = themeSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getThemeSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSaveButton);
		return themeSaveButton.getText();
	}

	public boolean isPrimaryThemeColorTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolor);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, primarythemecolor);
			isPresent = primarythemecolor.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public boolean isHeaderBackgroundColorTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerbackgroundcolor);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, headerbackgroundcolor);
			isPresent = headerbackgroundcolor.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public boolean isHeaderFontColorTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerfontcolor);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, headerfontcolor);
			isPresent = headerfontcolor.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isFooterBackgroundColorTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerbackgroundcolor);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, footerbackgroundcolor);
			isPresent = footerbackgroundcolor.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isFooterFontColorTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerfontcolor);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, footerfontcolor);
			isPresent = footerfontcolor.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getPrimaryThemeColorLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(primarythemecolorlabel);
		waitForElement(driver, primarythemecolorlabel);
		return primarythemecolorlabel.getText();
	}

	public String getHeaderBackgroundColorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerbackgroundcolorlabel);
		return headerbackgroundcolorlabel.getText();
	}

	public String getHeaderFontColorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerfontcolorlabel);
		return headerfontcolorlabel.getText();
	}

	public String getFooterBackgroundColorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerbackgroundcolorlabel);
		return footerbackgroundcolorlabel.getText();
	}

	public String getFooterFontColorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerfontcolorlabel);
		return footerfontcolorlabel.getText();
	}

	public String getPrimaryThemeColorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolor);
		return primarythemecolor.getAttribute("value");
	}

	public String getHeaderBackgroundColorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerbackgroundcolor);
		return headerbackgroundcolor.getAttribute("value");
	}

	public String getHeaderFontColorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerfontcolor);
		return headerfontcolor.getAttribute("value");
	}

	public String getFooterBackGroundColorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerbackgroundcolor);
		return footerbackgroundcolor.getAttribute("value");
	}

	public String getFooterFontColorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerfontcolor);
		return footerfontcolor.getAttribute("value");
	}

	public boolean isPrimaryThemeColorPickerDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolorpicker);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, primarythemecolorpicker);
			isPresent = primarythemecolorpicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isHeaderBackgroundColorPickerDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerbackgroundcolorpicker);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, headerbackgroundcolorpicker);
			isPresent = headerbackgroundcolorpicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isHeaderFontColorPickerDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, headerfontcolorpicker);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, headerfontcolorpicker);
			isPresent = headerfontcolorpicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isFooterBackgroundColorPickerDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerbackgroundcolorpicker);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, footerbackgroundcolorpicker);
			isPresent = footerbackgroundcolorpicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isFooterFontColorPickerDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, footerfontcolorpicker);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, footerfontcolorpicker);
			isPresent = footerfontcolorpicker.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isLogoKeyLabelDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, logokeylabel);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, logokeylabel);
			isPresent = logokeylabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getLogoKeyLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, logokeylabel);
		return logokeylabel.getText();
	}

	public String getLogoImageUploadError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, logoimageuploaderror);
		return logoimageuploaderror.getText();
	}

	public boolean isImageUploadControlDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imageuploadcontrol);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, imageuploadcontrol);
			isPresent = imageuploadcontrol.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public boolean isImagePreviewDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imagepreview);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, imagepreview);
			isPresent = imagepreview.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getImageName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imagename);
		return imagename.getText();
	}

	public boolean isImageControlBoxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imagecontrolbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, imagecontrolbox);
			isPresent = imagecontrolbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public void clickpOnPimaryThemeColorPicker() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolorpicker);
		Actions act = new Actions(driver);
		act.click(primarythemecolorpicker).build().perform();

	}

	public void clearPrimaryThemeColorBox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolor);
		primarythemecolor.clear();
	}

	public void enterPrimaryThemeColorTextBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemecolor);
		primarythemecolor.sendKeys(text);
	}

	public String getPrimaryThemeTextboxError() {
		TestConfig.PrintMethodName();
		waitForElement(driver, primarythemetextboxerror);
		return primarythemetextboxerror.getText();
	}

	public void clickOnThemeSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, themeSaveButton);
		Actions act = new Actions(driver);
		act.click(themeSaveButton).build().perform();

	}

	public void clickOnOrgSettingsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgsettingstab);
		Actions act = new Actions(driver);
		act.click(orgsettingstab).build().perform();
	}

	public String getOrgSettingsTabHighLightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgsettingstab);
		String cssValue = orgsettingstab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isSettingsHeaderDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingsheader);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, settingsheader);
			isPresent = settingsheader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getSettingsHeaderText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingsheader);
		return settingsheader.getText();

	}

	public boolean isSettingSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingsavebutton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, settingsavebutton);
			isPresent = settingsavebutton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getSettingSaveButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, settingsavebutton);
		return settingsavebutton.getText();
	}

	public String getOrgUploadName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orguploadname);
		return orguploadname.getAttribute("value");
	}

	public boolean isOrgUploadNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orguploadname);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, orguploadname);
			isPresent = orguploadname.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isDeleteBtnDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebtn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, deletebtn);
			isPresent = deletebtn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDeleteBtnText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletebtn);
		return deletebtn.getText();
	}

	public boolean isDashboardDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dashboard);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, dashboard);
			isPresent = dashboard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}

	}

	public String getDashboardText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dashboard);
		return dashboard.getText();
	}

	public String getImageSizeErrorText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, imageSizeError);
		return imageSizeError.getText();
	}
}
