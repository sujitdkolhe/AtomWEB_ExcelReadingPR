package com.atom.healthcare.MD_MasterDataWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_ReasonsPage extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//span[text()='Reasons']")
	private WebElement reasonsTab;
	
	@FindBy(how = How.XPATH, using = "//button[@id='ResonsViewAddActionKey']")
	private WebElement reasonsAddButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ResonsViewIsPopupReasonNameTextKey1input-text']")
	private WebElement reasonsFirstLangTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ResonsViewIsPopupReasonNameTextKey2input-text']")
	private WebElement reasonsSecondLangTextbox;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='ResonsViewIsPopupDescriptionNameTextKey1input-textArea']")
	private WebElement descriptionFirstLangTextbox;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='ResonsViewIsPopupDescriptionNameTextKey2input-textArea']")
	private WebElement descriptionSecondLangTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary margin-horizontal-md float-right']")
	private WebElement reasonsSaveButton;
	
	@FindBy(how = How.XPATH, using = "//button[@id='ResonsViewCancelActionKey']")
	private WebElement reasonsCancelButton;
	
	@FindBy(how = How.XPATH, using = "//li[@id='ResonsViewIsPopuptabs1']")
	private WebElement firstLangTab;
	
	@FindBy(how = How.XPATH, using = "//li[@id='ResonsViewIsPopuptabs2']")
	private WebElement secondLangTab;
	
	@FindBy(how = How.XPATH, using = "//label[@id='ResonsViewIsPopupReasonNameTextKey1errorLabel']")
	private WebElement reasonErrorMessageFirstLang;
	
	@FindBy(how = How.XPATH, using = "//label[@id='ResonsViewIsPopupReasonNameTextKey2errorLabel']")
	private WebElement reasonErrorMessageSecondLang;
	
	@FindBy(how = How.XPATH, using = "//label[@id='ResonsViewIsPopupDescriptionNameTextKey1errorlabel']")
	private WebElement descriptionFirstLangErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//label[@id='ResonsViewIsPopupDescriptionNameTextKey2errorlabel']")
	private WebElement descriptionSecondLangErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//label[@id='ResonsViewIsPopuperrorLabel']")
	private WebElement LangErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement reasonsHeader;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Heart Reason']")
	private WebElement createdReasons;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Update Heart']")
	private WebElement updatedReasons;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-error-body-large-semi-bold label-button']")
	private WebElement reasonDeleteButton;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary float-right']")
	private WebElement reasonDeleteOkButton;
	
	
	public MD_ReasonsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnReasonsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsTab);
		javascriptClick(reasonsTab);
	}

	public void clickOnReasonsAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsAddButton);
		javascriptClick(reasonsAddButton);
	}

	public void clickOnFirstLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstLangTab);
		javascriptClick(firstLangTab);
	}

	public void clickOnSecondLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, secondLangTab);
		javascriptClick(secondLangTab);
	}

	public void clickOnReasonsFirstLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsFirstLangTextbox);
		javascriptClick(reasonsFirstLangTextbox);
	}

	public void clickOnReasonsSecondLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsSecondLangTextbox);
		javascriptClick(reasonsSecondLangTextbox);
	}

	public void clickOnDescriptionFirstLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionFirstLangTextbox);
		javascriptClick(descriptionFirstLangTextbox);
	}

	public void clickOnDescriptionSecondLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, descriptionSecondLangTextbox);
		javascriptClick(descriptionSecondLangTextbox);
	}

	public void clickOnReasonsSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsSaveButton);
		javascriptClick(reasonsSaveButton);
	}

	public void clickOnCreatedReasons() {
		TestConfig.PrintMethodName();
		waitForElement(driver, createdReasons);
		javascriptClick(createdReasons);
	}

	public void clickOnUpdatedReasons() {
		TestConfig.PrintMethodName();
		waitForElement(driver, updatedReasons);
		javascriptClick(updatedReasons);
	}

	public void clickOnReasonDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonDeleteButton);
		javascriptClick(reasonDeleteButton);
	}

	public void clickOnReasonDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonDeleteOkButton);
		javascriptClick(reasonDeleteOkButton);
	}

	public void clearReasonsInFirstLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsFirstLangTextbox);
		javascriptClick(reasonsFirstLangTextbox);
		reasonsFirstLangTextbox.sendKeys(Keys.CONTROL, Keys.chord("a"));
		reasonsFirstLangTextbox.sendKeys(Keys.BACK_SPACE);
	}

	public void clearReasonsInSecondLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, reasonsSecondLangTextbox);
		javascriptClick(reasonsSecondLangTextbox);
		reasonsSecondLangTextbox.sendKeys(Keys.CONTROL, Keys.chord("a"));
		reasonsSecondLangTextbox.sendKeys(Keys.BACK_SPACE);
	}

	public void createNewReasons(String text, String descript) throws InterruptedException {
		waitForElement(driver, reasonsFirstLangTextbox);
		javascriptClick(reasonsFirstLangTextbox);
		reasonsFirstLangTextbox.sendKeys(text);
		javascriptClick(descriptionFirstLangTextbox);
		descriptionFirstLangTextbox.sendKeys(descript);
	}

	public void clickOnSecondLangTab(String text, String descript) throws InterruptedException {
		waitForElement(driver, reasonsSecondLangTextbox);
		javascriptClick(reasonsSecondLangTextbox);
		reasonsSecondLangTextbox.sendKeys(text);
		javascriptClick(descriptionSecondLangTextbox);
		descriptionSecondLangTextbox.sendKeys(descript);
	}

	public void addOrUpdateFirstLanguageReason(String text, String descript) throws InterruptedException {
		waitForElement(driver, reasonsFirstLangTextbox);
		javascriptClick(reasonsFirstLangTextbox);
		reasonsFirstLangTextbox.clear();
		Thread.sleep(500);
		reasonsFirstLangTextbox.sendKeys(text);
		javascriptClick(descriptionFirstLangTextbox);
		descriptionFirstLangTextbox.clear();
		descriptionFirstLangTextbox.sendKeys(descript);
	}

	public void addOrUpdateSecondLanguageReason(String text, String descript) throws InterruptedException {
		waitForElement(driver, secondLangTab);
		javascriptClick(secondLangTab);
		javascriptClick(reasonsSecondLangTextbox);
		reasonsSecondLangTextbox.clear();
		reasonsSecondLangTextbox.sendKeys(text);
		javascriptClick(descriptionSecondLangTextbox);
		descriptionSecondLangTextbox.clear();
		descriptionSecondLangTextbox.sendKeys(descript);
		javascriptClick(reasonsSaveButton);
	}

	public boolean isReasonErrorMessageFirstLangDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, reasonErrorMessageFirstLang);
			isPresent = reasonErrorMessageFirstLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Reason error label is not visible");
			return isPresent;
		}
	}

	public boolean isReasonErrorMessageSecondLangDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, reasonErrorMessageSecondLang);
			isPresent = reasonErrorMessageSecondLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Reason error label is not visible");
			return isPresent;
		}
	}

	public boolean isDescriptionFirstLangErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, descriptionFirstLangErrorMessage);
			isPresent = descriptionFirstLangErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Description error label is not visible");
			return isPresent;
		}
	}

	public boolean isDescriptionSecondLangErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, descriptionSecondLangErrorMessage);
			isPresent = descriptionSecondLangErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Description error label is not visible");
			return isPresent;
		}
	}

	public boolean isLanguageErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, LangErrorMessage);
			isPresent = LangErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Language error label is not visible");
			return isPresent;
		}
	}

	public boolean isReasonHeaderDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, reasonsHeader);
			isPresent = reasonsHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Reason header is not visible");
			return isPresent;
		}
	}
}
