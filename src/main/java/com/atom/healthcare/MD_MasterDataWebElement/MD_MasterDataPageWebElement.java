package com.atom.healthcare.MD_MasterDataWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_MasterDataPageWebElement extends BasePageObject {

	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[9]")
	private WebElement masterDataMenu;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement masterHeaderLabel;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	private WebElement educationCategoriesTab;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[2]")
	private WebElement consentsTab;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[3]")
	private WebElement welcomeScreenTab;

	@FindBy(how = How.ID, using = "ConsentsViewAddActionKey")
	private WebElement consentAddButton;

	@FindBy(how = How.ID, using = "ConsentsViewIsPopupConsentRoleKeyinput-text")
	private WebElement consentForRoleTextbox;

	@FindBy(how = How.ID, using = "ConsentsViewIsPopupConsentPageKeyinput-text")
	private WebElement consentPageTextbox;

	@FindBy(how = How.ID, using = "QuestionAddEditSequenceNoKeyinput-text")
	private WebElement sequenceNoTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-regular ltr '][text()='Is Required']")
	private WebElement isRequired;

	@FindBy(how = How.ID, using = "ConsentsViewSaveActionKey")
	private WebElement consentSaveButton;

	public MD_MasterDataPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMasterData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, masterDataMenu);
		// masterDataMenu.click();
		javascriptClick(masterDataMenu);
	}

	public void selectConsentsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, consentsTab);
		consentsTab.click();
	}

	public void addConsentDetails(String selectRole, String consentPage, String sequence,
			String isRequiredPermission) {
		TestConfig.PrintMethodName();
		log("Select Role");
		try {
			waitForElement(driver, consentAddButton);
			consentAddButton.click();
		} catch (Exception e) {
			selectConsentsTab();
			consentAddButton.click();
		}
		consentForRoleTextbox.click();
		consentForRoleTextbox.sendKeys(selectRole);
		waitForElement(driver, driver.findElement(By.xpath("//li[text()='" + selectRole + "']")));
		WebElement role = driver.findElement(By.xpath("//li[text()='" + selectRole + "']"));
		role.click();
		log("Select consent page");
		consentPageTextbox.click();
		consentPageTextbox.sendKeys(consentPage);
		waitForElement(driver, driver.findElement(By.xpath("//li[text()='" + consentPage + "']")));
		WebElement consntPage = driver.findElement(By.xpath("//li[text()='" + consentPage + "']"));
		consntPage.click();
		log("Add sequence");
		sequenceNoTextbox.click();
		sequenceNoTextbox.sendKeys(sequence);
		if (isRequiredPermission.equals("Yes"))
			isRequired.click();
		else
			log("Is required permission not required");

	}

	public boolean isCreatedConsentDisplay(String consentPage) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + consentPage + "']")));
			WebElement consntPage = driver.findElement(By.xpath("//label[text()='" + consentPage + "']"));
			isPresent = consntPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Created consent page is not visible");
			return isPresent;
		}
	}

	public void selectPlatform(String androidPlatform, String iOSPlatform) {
		TestConfig.PrintMethodName();
		if (iOSPlatform.equals("") || iOSPlatform.equals(null)) {
			waitForElement(driver, driver.findElement(By.xpath(
					"//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + androidPlatform + "']")));
			WebElement platform = driver.findElement(By.xpath(
					"//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + androidPlatform + "']"));
			platform.click();
		} else {
			waitForElement(driver, driver.findElement(By.xpath(
					"//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + androidPlatform + "']")));
			WebElement android = driver.findElement(By.xpath(
					"//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + androidPlatform + "']"));
			android.click();
			
			waitForElement(driver, driver.findElement(By.xpath(
					"//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + iOSPlatform + "']")));
			WebElement iOS = driver.findElement(By
					.xpath("//label[@class='lbl-primary-text-body-large-regular ltr '][text()='" + iOSPlatform + "']"));
			iOS.click();
		}

	}

	public void clickOnConsentSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, consentSaveButton);
		consentSaveButton.click();
	}

	public boolean isSequenceNumberDisplay(String sequenceNum) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + sequenceNum + "']")));
			WebElement sequenceNumber = driver.findElement(By.xpath("//label[text()='" + sequenceNum + "']"));
			isPresent = sequenceNumber.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Sequence Number is not visible");
			return isPresent;
		}
	}
}
