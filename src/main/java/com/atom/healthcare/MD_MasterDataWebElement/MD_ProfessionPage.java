package com.atom.healthcare.MD_MasterDataWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_ProfessionPage extends BasePageObject{

	@FindBy(how = How.ID, using = "ProfessionsView")
	private WebElement professionTab;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-12 px-0 table-min-height']")
	private WebElement professionList;
	
	@FindBy(how = How.ID, using = "ProfessionsViewAddActionKey")
	private WebElement professionAddButton;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopupProfessionNameTextKey1input-text")
	private WebElement professionTextbox;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopupProfessionNameTextKey2input-text")
	private WebElement professionSecongLangTextbox;
	
	@FindBy(how = How.ID, using = "ProfessionsViewSaveActionKey")
	private WebElement professionSaveButton;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopupProfessionNameTextKey1errorLabel")
	private WebElement professionNameErrorMessage;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopuperrorLabel")
	private WebElement professionLangMessage;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopuptabs2")
	private WebElement professionSecondLang;
	
	@FindBy(how = How.ID, using = "ProfessionsViewIsPopupProfessionNameTextKey1errorLabel")
	private WebElement professionRangeErrorMessage;
	
	@FindBy(how = How.ID, using = "ProfessionsViewtable-row0")
	private WebElement addedProfession;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement professionSearchTextbox;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement professionAddPage;
	
	public MD_ProfessionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	public void clickOnProfessionTab(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionTab);
		professionTab.click();
	}
	public void clickOnProfessionAddButton(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionAddButton);
		professionAddButton.click();
	}
	public void addProfessionDetails(String profession)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionTextbox);
		professionTextbox.sendKeys(profession);
	}
	public void clickOnProfessionSaveButton(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionSaveButton);
		professionSaveButton.click();
	}
	public boolean isProfessionNameRequiredErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, professionNameErrorMessage);
			isPresent = professionNameErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}	
	public boolean isAllLangTypeRequiredErrorMessageDisplayedProfession() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, professionLangMessage);
			isPresent = professionLangMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnProfessionSecondLangTab(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionSecondLang);
		professionSecondLang.click();
	}
	public boolean isProfessionRangeErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, professionRangeErrorMessage);
			isPresent = professionRangeErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public void clearProfessionNameTextbox() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		professionTextbox.sendKeys(del);
		}	
	public void sendProfessionNameForSecondLang(String profession)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionSecongLangTextbox);
		professionSecongLangTextbox.sendKeys(profession);
	}
	public boolean isProfessionListPageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, professionList);
			isPresent = professionList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public void searchAddedProfessionName(String search)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  professionSearchTextbox);
		professionSearchTextbox.sendKeys(search);
		}
		public void clearProfessionSecondLangPage() throws InterruptedException {
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			professionSecongLangTextbox.sendKeys(del);
			}
		public boolean isProfessionNameRangIsMin() {
			TestConfig.PrintMethodName();
			boolean isPresent = false;
			try {
				waitForElement(driver, professionNameErrorMessage);
				isPresent = professionNameErrorMessage.isDisplayed();
				return isPresent;
			} catch (Exception e) {
				log("Element is not visible");
				return isPresent;
			}
		}	
		public void clickOnProfessionSearchTextbox(){
			TestConfig.PrintMethodName();
			waitForElement(driver,  professionSearchTextbox);
			professionSearchTextbox.click();
		}
		public void clickOnAddedProfession(){
			TestConfig.PrintMethodName();
			waitForElement(driver,  addedProfession);
			addedProfession.click();
		}
		public boolean isProfessionAddPageDisplayed() {
			TestConfig.PrintMethodName();
			boolean isPresent = false;
			try {
				waitForElement(driver, professionAddPage);
				isPresent = professionAddPage.isDisplayed();
				return isPresent;
			} catch (Exception e) {
				log("Element is not visible");
				return isPresent;
			}
		}	
}