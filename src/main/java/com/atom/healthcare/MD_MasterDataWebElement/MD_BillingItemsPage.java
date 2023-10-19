package com.atom.healthcare.MD_MasterDataWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;
import org.openqa.selenium.support.PageFactory;

public class MD_BillingItemsPage extends BasePageObject{

	@FindBy(how = How.XPATH, using = "//span[text()='Billing Items']")
	private WebElement billingItemsTab;
	
	@FindBy(how = How.XPATH, using = "//button[@id='BillingItemsViewAddActionKey']")
	private WebElement billingItemsAddButton;
	
	@FindBy(how = How.XPATH, using = "//li[@id='BillingItemsViewIsPopuptabs1']")
	private WebElement billingItemsFirstLangTab;
	
	@FindBy(how = How.XPATH, using = "//li[@id='BillingItemsViewIsPopuptabs2']")
	private WebElement billingItemsSecondLangTab;
	
	@FindBy(how = How.XPATH, using = "//input[@id='BillingItemsViewIsPopupBillingItemNameKey1input-text']")
	private WebElement billingItemsNameFirstLangTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='BillingItemsViewIsPopupBillingItemNameKey2input-text']")
	private WebElement billingItemsNameSecondLangTextbox;

	@FindBy(how = How.XPATH, using = "//button[@id='BillingItemsViewSaveActionKey']")
	private WebElement billingItemsSaveButton;

	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewIsPopupBillingItemNameKey1errorLabel']")
	private WebElement itemNameErrorMessageFirstLang;
	
	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewIsPopupBillingItemNameKey2errorLabel']")
	private WebElement itemNameErrorMessageSecondLang;
	
	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewIsPopuperrorLabel']")
	private WebElement langErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewIsPopupBillingItemNameKey1errorLabel']")
	private WebElement billingItemRangeErrorMessageFirstLang;
	
	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewIsPopupBillingItemNameKey2errorLabel']")
	private WebElement billingItemRangeErrorMessageSecondLang;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement billingItemsHeader;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Blood Glucose']")
	private WebElement newBillItemCreated;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Update Glucose']")
	private WebElement updatedBillItem;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement addEditBillingItemHeader;
	
	@FindBy(how = How.XPATH, using = "//label[@id='BillingItemsViewDeleteActionKey']")
	private WebElement itemDeleteButton;
	
	@FindBy(how = How.XPATH, using = "//button[@id='OkActionKey']")
	private WebElement itemDeleteOkButton;
	
	public MD_BillingItemsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBillingItemsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsTab);
		javascriptClick(billingItemsTab);
	}

	public void clickOnBillingItemsAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsAddButton);
		javascriptClick(billingItemsAddButton);
	}

	public void clickOnBillingItemsSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsSaveButton);
		javascriptClick(billingItemsSaveButton);
	}

	public void clickOnBillingItemsFirstLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsFirstLangTab);
		javascriptClick(billingItemsFirstLangTab);
	}

	public void clickOnBillingItemsSecondLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsSecondLangTab);
		javascriptClick(billingItemsSecondLangTab);
	}

	public void clickOnItemNameFirstLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameFirstLangTextbox);
		javascriptClick(billingItemsNameFirstLangTextbox);
	}

	public void clearItemNameFirstLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameFirstLangTextbox);
		javascriptClick(billingItemsNameFirstLangTextbox);
		billingItemsNameFirstLangTextbox.clear();
	}

	public void clickOnItemNameSecondLangTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameSecondLangTextbox);
		javascriptClick(billingItemsNameSecondLangTextbox);
	}

	public void clickOnNewBillItemCreated() {
		TestConfig.PrintMethodName();
		waitForElement(driver, newBillItemCreated);
		javascriptClick(newBillItemCreated);
	}

	public void clickOnUpdatedBillItemCreated() {
		TestConfig.PrintMethodName();
		waitForElement(driver, updatedBillItem);
		javascriptClick(updatedBillItem);
	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, itemDeleteButton);
		javascriptClick(itemDeleteButton);
	}

	public void clickOnItemDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, itemDeleteOkButton);
		javascriptClick(itemDeleteOkButton);
	}

	public void clearItemNameSecondLangTextbox() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameSecondLangTextbox);
		javascriptClick(billingItemsNameSecondLangTextbox);
		billingItemsNameSecondLangTextbox.sendKeys(Keys.CONTROL, Keys.chord("a"));
		billingItemsNameSecondLangTextbox.sendKeys(Keys.BACK_SPACE);
	}

	public void addItemNameInFirstLangTab(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameFirstLangTextbox);
		javascriptClick(billingItemsNameFirstLangTextbox);
		billingItemsNameFirstLangTextbox.sendKeys(text);
	}

	public void addItemNameInSecondLangTab(String text) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, billingItemsNameSecondLangTextbox);
		javascriptClick(billingItemsNameSecondLangTextbox);
		billingItemsNameSecondLangTextbox.sendKeys(text);
		javascriptClick(billingItemsSaveButton);
	}

	public boolean isItemNameFirstLangRequiredErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, itemNameErrorMessageFirstLang);
			isPresent = itemNameErrorMessageFirstLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isItemNameSecondLangRequiredErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, itemNameErrorMessageSecondLang);
			isPresent = itemNameErrorMessageSecondLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAllLangTypeRequiredErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, langErrorMessage);
			isPresent = langErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isRangeErrorMessageFirstlangDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, billingItemRangeErrorMessageFirstLang);
			isPresent = billingItemRangeErrorMessageFirstLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isRangeErrorMessageSecondlangDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, billingItemRangeErrorMessageSecondLang);
			isPresent = billingItemRangeErrorMessageSecondLang.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBillingItemsHeaderDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, billingItemsHeader);
			isPresent = billingItemsHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBillingItemAddEditPageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addEditBillingItemHeader);
			isPresent = addEditBillingItemHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
}
