package com.atom.healthcare.Organization;

import java.util.ArrayList;
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
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Branch extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuOrganisationTabView")
	private WebElement orginazationTab;

	@FindBy(how = How.ID, using = "BranchView")
	private WebElement branchOverviewTabLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold']")
	private WebElement basicInputLabel;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement branchOverviewSaveButton;

	@FindBy(how = How.ID, using = "BranchViewtabs1")
	private WebElement branchOverviewFirstLang;

	@FindBy(how = How.ID, using = "BranchViewtabs2")
	private WebElement branchOverviewSecondLang;

	@FindBy(how = How.XPATH, using = "(//label[text()='Branch name'])[1]")
	private WebElement branchNameLabel;

	@FindBy(how = How.ID, using = "BranchViewBranchNameKey2errorLabel")
	private WebElement BranchNameRequiredErrorMessage;

	@FindBy(how = How.ID, using = "BranchViewerrorLabel")
	private WebElement LangRequiredErrorMessage;

	@FindBy(how = How.ID, using = "BranchViewBranchNameKey1input-text")
	private WebElement branchNameFirstLangTextbox;

	@FindBy(how = How.ID, using = "BranchViewBranchNameKey2input-text")
	private WebElement branchNameSecondLangTextbox;

	@FindBy(how = How.ID, using = "BranchViewBranchNameKey1input-text")
	private WebElement branchNamePlaceholder;

	@FindBy(how = How.XPATH, using = "//label[text()='Departments']")
	private WebElement departmentLabel;

	@FindBy(how = How.ID, using = "BranchView130checkbox")
	private WebElement checkboxFirst;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement addContactLabel;

	@FindBy(how = How.ID, using = "BranchContactsView")
	private WebElement branchhContactTab;

	@FindBy(how = How.ID, using = "BranchContactsViewAddActionKey")
	private WebElement branchContactAddButton;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement addCrossIcon;

	@FindBy(how = How.XPATH, using = "(//label[text()='Type'])[2]")
	private WebElement addPageTypeLabel;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeyinput-text")
	private WebElement addPageTypePlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[text()='Contact'])[2]")
	private WebElement addPageContactLabel;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeyinput-text")
	private WebElement addPageContactPlaceholder;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='BranchContactsViewIsPopupContactKeyListItems']/li"))
	private List<WebElement> addContactList;

	@FindAll(@FindBy(how = How.XPATH, using = "//ui[@id='BranchContactsViewIsPopupContactTypeKeyListItems']/li"))
	private List<WebElement> addTypeList;

	@FindBy(how = How.XPATH, using = "//input[@id='BranchContactsViewIsPopupContactKeyinput-text']")
	private WebElement contactTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Contact']")
	private WebElement addContactListDropdown;

	@FindBy(how = How.ID, using = "BranchContactDetailsAddressContactKey1input-textArea")
	private WebElement addressFieldTextbox;

	@FindBy(how = How.ID, using = "BranchContactDetailsAddressContactKey2input-textArea")
	private WebElement secondAddressFieldTextbox;

	@FindBy(how = How.ID, using = "BranchContactDetailsEmailContactKey1input-text")
	private WebElement emailFieldTextbox;

	@FindBy(how = How.ID, using = "BranchContactDetailsEmailContactKey2input-text")
	private WebElement emailField2Textbox;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeylabel184")
	private WebElement emailFieldDropdown;

	@FindBy(how = How.ID, using = "BranchContactDetailsPhoneContactKey1phone_text")
	private WebElement phoneNoFieldTextbox;

	@FindBy(how = How.ID, using = "BranchContactDetailsPhoneContactKey2phone_text")
	private WebElement phoneNoField2Textbox;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeylabel185")
	private WebElement phoneNoDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeylabel183")
	private WebElement addressDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewSaveActionKey")
	private WebElement addPageSaveButton;

	@FindBy(how = How.ID, using = "BranchContactsViewSaveActionKey")
	private WebElement addPageSaveButtonDisplay;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary float-right']")
	private WebElement addPageCancelButton;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary float-right']")
	private WebElement addPageCancelButtonDisplay;

	@FindBy(how = How.ID, using = "BranchContactsViewtable-row0")
	private WebElement branchContactRowClick;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement branchContactEditPageLabel;

	@FindBy(how = How.ID, using = "BranchContactsViewDeleteActionKey")
	private WebElement editPageDeleteButton;

	@FindBy(how = How.ID, using = "BranchContactsViewDeleteActionKey")
	private WebElement editPageDeleteButtonDisplay;

	@FindBy(how = How.ID, using = "MasterPageLogout")
	private WebElement addEditCloseButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Type']")
	private WebElement addpageTypeDropdown;

	@FindBy(how = How.ID, using = "BranchContactDetailsAddressContactKey1errorlabel")
	private WebElement addressErrorMessage;

	@FindBy(how = How.ID, using = "BranchContactDetailsEmailContactKey1errorLabel")
	private WebElement emailErrorMessage;

	@FindBy(how = How.ID, using = "BranchContactDetailsPhoneContactKey1errorLabel")
	private WebElement phoneNoErrorMessage;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeyerrorLabel")
	private WebElement typeFieldReuiredMessage;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeyerrorLabel")
	private WebElement contactFieldReuiredMessage;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[6]")
	private WebElement homeTypeDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupDeleteActionKey")
	private WebElement deletePageMessageLabel;

	@FindBy(how = How.ID, using = "BranchContactsViewOkActionKey")
	private WebElement branchContactOkLabel;

	@FindBy(how = How.ID, using = "BranchContactsViewCancelActionKey")
	private WebElement cancelButtonLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement deletePageConfirmMessage;

	@FindBy(how = How.XPATH, using = ("//label[@class='lbl-primary-text-header-2-semi-bold text-start']"))
	private WebElement deletePageDeleteLabel;

	@FindBy(how = How.ID, using = "LeftMenuBranchMenu1047")
	private WebElement firstBranchTab;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeyinput-text")
	private WebElement addPageTypeDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeylabel181")
	private WebElement selectHomeTypeDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeylabel180")
	private WebElement selectPrimaryTypeDropdown;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeylabel182")
	private WebElement selectWorkTypeDropdown;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement branchContactAddressLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement branchContactEmailLabel;

	@FindBy(how = How.XPATH, using = "((//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement branchContactPhoneNoLabel;

	@FindBy(how = How.ID, using = "BranchContactsView")
	private WebElement branchContactLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-between align-items-center'])[1]")
	private WebElement firstBranch;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold d-flex ltr\"]")
	private WebElement orgBranchHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs lbl-no-wrap ltr\"])[1]")
	private WebElement domainName;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start margin-horizontal-xxs lbl-no-wrap ltr\"])[2]")
	private WebElement createdDate;

	@FindBy(how = How.XPATH, using = "(//span[@class=\"initials text-center w-available\"])[4]")
	private WebElement orgLogo;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	private WebElement branchOverviewTab;

	@FindBy(how = How.XPATH, using = "//li[@id='BranchContactsView']")
	private WebElement branchContactTab;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactTypeKeyinput-text")
	private WebElement typeDropdownTextbox;

	@FindBy(how = How.ID, using = "BranchContactsViewIsPopupContactKeyinput-text")
	private WebElement contactDropdownTextbox;

	@FindBy(how = How.ID, using = "BranchContactDetailserrorLabel")
	private WebElement branchContactLangErrorLabel;

	@FindBy(how = How.ID, using = "BranchContactDetailstabs2")
	private WebElement branchContactLangSecondTab;

	@FindBy(how = How.ID, using = "BranchContactDetailsPhoneContactKey2phone_text")
	private WebElement branchContactLangSecondTextbox;

	@FindBy(how = How.XPATH, using = "//label[text()='Phone No']")
	private WebElement branchContactPhoneNoDetails;

	@FindBy(how = How.XPATH, using = "(//img[@class='avatar-circle'])[2]")
	private WebElement orgAvatar;

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuOrganisationTabView")
	private WebElement branchOrg;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Branch Overview']")
	private WebElement branchOverview;

	public Branch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnBranch() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstBranch);
		javascriptClick(firstBranch);
	}

	public void clickBranchOverviewTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewTab);
		branchOverviewTab.click();
	}

	public void clickBranchTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactTab);
		branchContactTab.click();
	}

	public boolean isOrgLogoDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, orgLogo);
			isPresent = orgLogo.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDomainName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, domainName);
		return domainName.getText();
	}

	public String getCreatedDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, createdDate);
		return createdDate.getText();
	}

	public String getBranchHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgBranchHeader);
		return orgBranchHeader.getText();
	}

	public String getBranchOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewTab);
		return branchOverviewTab.getText();
	}

	public String getContactsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchhContactTab);
		return branchhContactTab.getText();
	}

	public boolean isOverviewTabSelected() {
		TestConfig.PrintMethodName();
		boolean isSelected = false;
		try {
			waitForElement(driver, branchOverviewTab);
			isSelected = branchOverviewTab.isSelected();
			return isSelected;
		} catch (Exception e) {
			log("Element is not Selected");
			return isSelected;
		}
	}

	public String getTabHighlightColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewTab);
		String cssValue = branchOverviewTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public void clickOnOrgnizationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orginazationTab);
		javascriptClick(orginazationTab);
	}

	public void clickOnBranchTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstBranchTab);
		javascriptClick(firstBranchTab);
	}

	public String getBranchOverviewTabLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverview);
		return branchOverview.getText();
	}

	public String getBasicInputLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, basicInputLabel);
		return basicInputLabel.getText();
	}

	public String getBranchOverviewFirestLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewFirstLang);
		return branchOverviewFirstLang.getText();
	}

	public String getBranchOverviewSecondLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewSecondLang);
		return branchOverviewSecondLang.getText();
	}

	public String getBranchNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNameLabel);
		return branchNameLabel.getText();
	}

	public String getBranchOverviewSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewSaveButton);
		return branchOverviewSaveButton.getText();
	}

	public String getDepartmentListLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, checkboxFirst);
		return checkboxFirst.getText();
	}

	public boolean isBranchNameTextboxDispaly() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, branchNameFirstLangTextbox);
			isPresent = branchNameFirstLangTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnBranchNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNameFirstLangTextbox);
		javascriptClick(branchNameFirstLangTextbox);
	}

	public boolean isCheckboxFirstListSelect() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, checkboxFirst);
			isPresent = checkboxFirst.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Checkbox already check");
			return isPresent;
		}
	}

	public String getBranchNameRequiredErrorMessage() {
		TestConfig.PrintMethodName();
//	waitForElement(driver, BranchNameRequiredErrorMessage);
		waitUntilElementIsVisible(BranchNameRequiredErrorMessage);
		return BranchNameRequiredErrorMessage.getText();
	}

	public String getLangRequiredErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, LangRequiredErrorMessage);
		return LangRequiredErrorMessage.getText();
	}

	public String getBranchNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNamePlaceholder);
		return branchNamePlaceholder.getAttribute("placeholder");
	}

	public String getDepartmentLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, departmentLabel);
		return departmentLabel.getText();
	}

	public void clickOnDepartmentCheckboxFirst() {
		TestConfig.PrintMethodName();
		waitForElement(driver, checkboxFirst);
		javascriptClick(checkboxFirst);
	}

	public boolean isSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, branchOverviewSaveButton);
			isPresent = branchOverviewSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnBranchOverviewSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewSaveButton);
		javascriptClick(branchOverviewSaveButton);
	}

	public String getAddContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addContactLabel);
		return addContactLabel.getText();
	}

	public void clickOnBranchContactTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactTab);
		javascriptClick(branchContactTab);
	}

	public void clickOnBranchContactAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(branchContactAddButton);
		// waitForElement(driver, 10, branchContactAddButton);
		javascriptClick(branchContactAddButton);
	}

	public boolean isAddCrossIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, addCrossIcon);
			isPresent = addCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddPageTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageTypeLabel);
		return addPageTypeLabel.getText();
	}

	public String getAddPageTypePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageTypePlaceholder);
		return addPageTypePlaceholder.getAttribute("placeholder");
	}

	public String getAddPageContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageContactLabel);
		return addPageContactLabel.getText();
	}

	public String getAddPageContactPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageContactPlaceholder);
		return addPageContactPlaceholder.getAttribute("placeholder");
	}

	public void clickOnAddContatctListDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addContactListDropdown);
//	waitForElement(driver, addContactListDropdown);
		Actions ac = new Actions(driver);
		ac.sendKeys(addContactListDropdown, Keys.ENTER).build().perform();
	}

	public void clickOnAddPageTypeDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addpageTypeDropdown);
//	waitForElement(driver, addpageTypeDropdown);
		Actions ac = new Actions(driver);
		ac.sendKeys(addpageTypeDropdown, Keys.ENTER).build().perform();
	}

	public List<String> getAddContactList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(addContactList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : addContactList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public List<String> getTypePickerList() {
		TestConfig.PrintMethodName();
		waitUntilElementsIsVisible(addTypeList);
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : addTypeList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public boolean getContachValues(String contact, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, addContactListDropdown);
		addContactListDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(//ui[@id='BranchContactsViewIsPopupContactKeyinput-text']/li)[" + value + "]"));
		operType.click();
		String type = operType.getText();
		if (type.equals(contact)) {
			try {
				isPresent = contactTextbox.isDisplayed();
			} catch (Exception e) {
				log("Element is not visible");
			}
		} else {
			log("Element is visble");
		}
		return isPresent;
	}

	public void clickOnContactTexttbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contactTextbox);
		javascriptClick(contactTextbox);
	}

	public void clickOnAddressDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addressDropdown);
		javascriptClick(addressDropdown);
	}

	public boolean getAddressValue(String address, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, addContactListDropdown);
		addContactListDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(BranchContactsViewIsPopupContactKeyinput-text)[" + value + "]"));
		operType.click();
		String type = operType.getText();
		if (type.equals(address)) {
			try {
				isPresent = addressFieldTextbox.isDisplayed();
			} catch (Exception e) {
				log("Element is not visible");
			}
		} else {
			log("Element is visble");
		}
		return isPresent;
	}

	public boolean isAddressTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addressFieldTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, addressFieldTextbox);
			isPresent = addressFieldTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnEmailDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(emailFieldDropdown);
//	waitForElement(driver, emailFieldDropdown);
		javascriptClick(emailFieldDropdown);
	}

	public boolean getEmailValue(String email, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, addContactListDropdown);
		addContactListDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(BranchContactDetailsEmailContactKey1input-text)[" + value + "]"));
		operType.click();
		String type = operType.getText();
		if (type.equals(email)) {
			try {
				isPresent = emailFieldTextbox.isDisplayed();
			} catch (Exception e) {
				log("Element is not visible");
			}
		} else {
			log("Element is visble");
		}
		return isPresent;
	}

	public boolean isEmailTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, emailFieldTextbox);
			isPresent = emailFieldTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnPhoneNoDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoDropdown);
		javascriptClick(phoneNoDropdown);
	}

	public boolean getphoneNoTextbox(String phoneNo, int value) throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		waitForElement(driver, addContactListDropdown);
		addContactListDropdown.click();
		WebElement operType = driver
				.findElement(By.xpath("(BranchContactDetailsPhoneContactKey1phone_text)[" + value + "]"));
		operType.click();
		String type = operType.getText();
		if (type.equals(phoneNo)) {
			try {
				isPresent = phoneNoFieldTextbox.isDisplayed();
			} catch (Exception e) {
				log("Element is not visible");
			}
		} else {
			log("Element is visble");
		}
		return isPresent;
	}

	public boolean isPhoneNoTextboxDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, phoneNoFieldTextbox);
			isPresent = phoneNoFieldTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBranchOverviewFirstLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverviewFirstLang);
		return branchOverviewFirstLang.getText();
	}

	public boolean isBranchNameTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, branchNameFirstLangTextbox);
			isPresent = branchNameFirstLangTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnDepartmentCheckbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, checkboxFirst);
		javascriptClick(checkboxFirst);
	}

	public String getAddPageSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageSaveButton);
		return addPageSaveButton.getText();
	}

	public boolean isAddPageSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addPageSaveButtonDisplay);
			isPresent = addPageSaveButtonDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddPageCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageCancelButton);
		return addPageCancelButton.getText();
	}

	public boolean isAddPageCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addPageCancelButtonDisplay);
		boolean isPresent = false;
		try {
			waitForElement(driver, addPageCancelButtonDisplay);
			isPresent = addPageCancelButtonDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEditPageDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editPageDeleteButton);
		return editPageDeleteButton.getText();
	}

	public boolean isEditPageDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, editPageDeleteButtonDisplay);
			isPresent = editPageDeleteButtonDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnBranchContactRowClick() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(branchContactRowClick);
//	waitForElement(driver, branchContactRowClick);
		javascriptClick(branchContactRowClick);
	}

	public String getBranchContactEditPageLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactEditPageLabel);
		return branchContactEditPageLabel.getText();
	}

	public void clickOnAddEditCloseButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addEditCloseButton);
		javascriptClick(addEditCloseButton);
	}

	public void clickOnAddEditCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageCancelButton);
		javascriptClick(addPageCancelButton);
	}

	public String getAddressFieldErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addressErrorMessage);
		return addressErrorMessage.getText();
	}

	public void sendAddressFieldTextbox(String address) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addressFieldTextbox);
//	waitForElement(driver, addressFieldTextbox);
		addressFieldTextbox.sendKeys(address);
	}

	public String getEmailFieldErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, emailErrorMessage);
		return emailErrorMessage.getText();
	}

	public void sendTextInEmailTextbox(String email) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(emailFieldTextbox);
//	waitForElement(driver, emailFieldTextbox);
		emailFieldTextbox.sendKeys(email);
	}

	public String getPhoneNoErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoErrorMessage);
		return phoneNoErrorMessage.getText();
	}

	public void enterPhoneNumber(String email) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(phoneNoFieldTextbox);
//	waitForElement(driver, phoneNoFieldTextbox);
		phoneNoFieldTextbox.sendKeys(email);
	}

	public void clickOnPhoneNoFieldTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, phoneNoFieldTextbox);
		javascriptClick(phoneNoFieldTextbox);
	}

	public void clickOnAddPageSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageSaveButton);
		javascriptClick(addPageSaveButton);
	}

	public String getTypeFieldReuiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, typeFieldReuiredMessage);
		return typeFieldReuiredMessage.getText();
	}

	public String getContactFieldReuiredMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contactFieldReuiredMessage);
		return contactFieldReuiredMessage.getText();
	}

	public void clickOnHomeTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, homeTypeDropdown);
		javascriptClick(homeTypeDropdown);
	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, editPageDeleteButton);
		javascriptClick(editPageDeleteButton);
	}

	public String getDeletePageCancelLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonLabel);
		return cancelButtonLabel.getText();
	}

	public void clickOnDeletePageCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButtonLabel);
		javascriptClick(cancelButtonLabel);
	}

	public String getDeletePageOkLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactOkLabel);
		return branchContactOkLabel.getText();
	}

	public void clickOnDeletePageOkButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(branchContactOkLabel);
//	waitForElement(driver, branchContactOkLabel);
		javascriptClick(branchContactOkLabel);
	}

	public String getDeletePageMessageLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePageConfirmMessage);
		return deletePageConfirmMessage.getText();
	}

	public String getDeletePageDeleteLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, deletePageDeleteLabel);
		return deletePageDeleteLabel.getText();
	}

	public void checkDepartmentCheckbox() throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean checkboxStatus = false;
		waitForElement(driver, checkboxFirst);
		checkboxStatus = checkboxFirst.isSelected();
		if (checkboxStatus) {
			log("Checkbox already check");
		} else {
			javascriptClick(checkboxFirst);
		}
	}

	public boolean uncheckDepartmentCheckbox() throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean checkboxStatus = false;
		waitForElement(driver, checkboxFirst);
		checkboxStatus = checkboxFirst.isSelected();
		if (checkboxStatus) {
			javascriptClick(checkboxFirst);
		} else {
			log("Checkbox already uncheck");
		}
		return checkboxStatus;
	}

	public void clickOnSelectHomeTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectHomeTypeDropdown);
		javascriptClick(selectHomeTypeDropdown);
	}

	public void clickOnSelectPrimaryTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectPrimaryTypeDropdown);
		javascriptClick(selectPrimaryTypeDropdown);
	}

	public void clickOnSelectWorkTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectWorkTypeDropdown);
		javascriptClick(selectWorkTypeDropdown);
	}

	public String getBranchContactAddressLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactAddressLabel);
		return branchContactAddressLabel.getText();
	}

	public String getBranchContactEmailLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactEmailLabel);
		return branchContactEmailLabel.getText();
	}

	public String getBranchContactPhoneNoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactPhoneNoLabel);
		return branchContactPhoneNoLabel.getText();
	}

	public String getAddressPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactAddressLabel);
		return branchContactAddressLabel.getAttribute("placeholder");
	}

	public String getEmailPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactEmailLabel);
		return branchContactEmailLabel.getAttribute("placeholder");
	}

	public String getPhoneNoPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactPhoneNoLabel);
		return branchContactPhoneNoLabel.getAttribute("placeholder");
	}

	public String getSaveButtonLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageSaveButtonDisplay);
		return addPageSaveButtonDisplay.getText();
	}

	public boolean isAddPageCloseButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addEditCloseButton);
			isPresent = addEditCloseButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getBranchContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactLabel);
		return branchContactLabel.getText();
	}

	public String getEditBranchContactLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactEditPageLabel);
		return branchContactEditPageLabel.getText();
	}

	public boolean isTypeDropdownTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, typeDropdownTextbox);
			isPresent = typeDropdownTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Type Textbox visible");
			return isPresent;
		}
	}

	public boolean isContactDropdownTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, contactDropdownTextbox);
			isPresent = contactDropdownTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Contact Textbox visible");
			return isPresent;
		}
	}

	public void clearBranchNameFirstLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNameFirstLangTextbox);
		branchNameFirstLangTextbox.clear();
	}

	public void clearBranchNameSecondLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNameSecondLangTextbox);
		branchNameSecondLangTextbox.clear();
	}

	public void clickOnBranchOverviewSecondLang() {
		TestConfig.PrintMethodName();
		// waitForElement(driver, 10, branchOverviewSecondLang);
		waitUntilElementIsVisible(branchOverviewSecondLang);
		javascriptClick(branchOverviewSecondLang);
	}

	public void clickOnBranchNameSecondLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchNameSecondLangTextbox);
		javascriptClick(branchNameSecondLangTextbox);
	}

	public String getBranchContactLangErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactLangErrorLabel);
		return branchContactLangErrorLabel.getText();
	}

	public void clickOnBranchContactLangSecondTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactLangSecondTab);
		javascriptClick(branchContactLangSecondTab);
	}

	public void clickOnBranchContactLangSecondTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactLangSecondTextbox);
		javascriptClick(branchContactLangSecondTextbox);
	}

	public void sendPhoneNoFieldSecondTextbox(String Number) {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactLangSecondTextbox);
		branchContactLangSecondTextbox.sendKeys(Number);
	}

	public String getBranchContactPhoneNoDetails() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchContactPhoneNoDetails);
		return branchContactPhoneNoDetails.getText();
	}

	public void addNewBranchContact(String type, String contact, String detail) throws InterruptedException {
		try {
			WebElement cont = driver.findElement(By.xpath("//label[text()='" + contact + "']"));
			String brnchCont = cont.getText();
			log("getText: " + brnchCont);
			if (brnchCont.equals(contact)) {
				javascriptClick(cont);
				javascriptClick(editPageDeleteButton);
			}
		} catch (Exception e) {
			TestConfig.PrintMethodName();
			javascriptClick(branchContactAddButton);
			javascriptClick(addpageTypeDropdown);
			WebElement typ = driver.findElement(By.xpath("//li[text()='" + type + "']"));
			javascriptClick(typ);
			Actions ac = new Actions(driver);
			ac.sendKeys(addContactListDropdown, Keys.ENTER).build().perform();
			WebElement cnt = driver.findElement(By.xpath("//li[text()='" + contact + "']"));
			javascriptClick(cnt);
			try {
				phoneNoFieldTextbox.sendKeys(detail);
			} catch (Exception e1) {
				log("phone number filed not selected");
			}
			try {
				addressFieldTextbox.sendKeys(detail);
			} catch (Exception e2) {
				log("Address filed not selected");
			}

			try {
				emailFieldTextbox.sendKeys(detail);
			} catch (Exception e3) {
				log("Email filed not selected");
			}

			javascriptClick(branchContactLangSecondTab);
			try {
				phoneNoField2Textbox.sendKeys(detail);
			} catch (Exception e1) {
				log("phone number filed not selected");
			}

			try {
				secondAddressFieldTextbox.sendKeys(detail);
			} catch (Exception e2) {
				log("Address filed not selected");
			}

			try {
				emailField2Textbox.sendKeys(detail);
			} catch (Exception e3) {
				log("Email filed not selected");
			}
			javascriptClick(addPageSaveButton);
		}
	}

	public boolean isOrganizationAvatarPresent() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orgAvatar);
		boolean isPresent = false;
		try {
			waitForElement(driver, orgAvatar);
			isPresent = orgAvatar.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSelctedTabActive() {
		waitForElement(driver, branchOverviewTab);
		return isActiveElement(branchOverviewTab);
	}

	public void clickOnBranchOrg() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible( branchOrg);
		branchOrg.click();
	}
	
	public void clickOnBranchOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, branchOverview);
		branchOverview.click();
	}
}
