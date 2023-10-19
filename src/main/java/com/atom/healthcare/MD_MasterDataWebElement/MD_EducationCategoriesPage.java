package com.atom.healthcare.MD_MasterDataWebElement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_EducationCategoriesPage extends BasePageObject {

	@FindBy(how = How.ID, using = "EducationCategoriesView")
	private WebElement educationCategorie;

	@FindBy(how = How.ID, using = "EducationCategoriesViewAddActionKey")
	private WebElement educationCategorieAddButton;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupImageNameKeyinput-fieImageUploadControl")
	private WebElement educationCategorieImageControl;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupCategoryNameKey1input-text")
	private WebElement educationCategorieName;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupDescriptionKey1input-textArea")
	private WebElement educationDescription;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopuptabs2")
	private WebElement langTabTwo;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupCategoryNameKey2input-text")
	private WebElement educationCategorieNameLangTwo;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupDescriptionKey2input-textArea")
	private WebElement educationDescriptionLangTwo;

	@FindBy(how = How.ID, using = "EducationCategoriesViewSaveActionKey")
	private WebElement educationCategorieSave;

	@FindBy(how = How.ID, using = "EducationCategoriesViewCancelActionKey")
	private WebElement educationCategorieCancel;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupImageNameKeyerrorLabel")
	private WebElement educationCategoriesImageError;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupCategoryNameKey1errorLabel")
	private WebElement educationCategoryErrorLabel;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupDescriptionKey1errorlabel")
	private WebElement educationDescriptionErrorLabel;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopuperrorLabel")
	private WebElement ecAllLanguageErrorLabel;

	@FindBy(how = How.ID, using = "EducationCategoriesViewIsPopupImageNameKeyDeleteActionKey")
	private WebElement ecImageDelete;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 px-0 table-min-height']")
	private WebElement educationCategoriesList;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement educationSearchbox;

	@FindBy(how = How.ID, using = "EducationCategoriesViewtable-row0")
	private WebElement addedCategory;

	public MD_EducationCategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickOnEducationCategoriesTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorie);
		javascriptClick(educationCategorie);
	}
	public void clickOnEducationCategoriesAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorieAddButton);
		javascriptClick(educationCategorieAddButton);
	}
	public String getEducationCategoryImage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorieImageControl);
		return educationCategorieImageControl.getText();
	}
	public void clickOnEducationCategoriesSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorieSave);
		educationCategorieSave.click();
	}
	public boolean isCategoryImageErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationCategoriesImageError);
			isPresent = educationCategoriesImageError.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isCategoryNameErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationCategoryErrorLabel);
			isPresent = educationCategoryErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isCategoryNameRangeErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationCategoryErrorLabel);
			isPresent = educationCategoryErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isDescriptionErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDescriptionErrorLabel);
			isPresent = educationDescriptionErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isDescriptionRangeErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDescriptionErrorLabel);
			isPresent = educationDescriptionErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isLangTypeDataErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, ecAllLanguageErrorLabel);
			isPresent = ecAllLanguageErrorLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public void addCategoryDetails(String categoryImageIcon, String Categoryname, String Description) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorieAddButton);
		waitForElement(driver, educationCategorieImageControl);
		educationCategorieImageControl.sendKeys(categoryImageIcon);
		educationCategorieName.sendKeys(Categoryname);
		educationDescription.sendKeys(Description);
	}
	public void clickOnImageDelete() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategorie);
		ecImageDelete.click();
	}
	public void clearEducationCategoryAddPage() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		educationCategorieName.sendKeys(del);
		educationDescription.sendKeys(del);
	}
	public void clickOnSecondLangTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, langTabTwo);
		langTabTwo.click();
	}
	public void addCategoryDetailsInSecondLangAddPage(String Categoryname, String Description) {
		TestConfig.PrintMethodName();
		educationCategorieNameLangTwo.sendKeys(Categoryname);
		educationDescriptionLangTwo.sendKeys(Description);
	}
	public boolean isCategoriesListPage() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationCategoriesList);
			isPresent = educationCategoriesList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public void clickOnEducationCategorySearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		javascriptClick(educationSearchbox);
		educationSearchbox.click();
	}
	public void searchAddedCategoryName(String search) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		educationSearchbox.sendKeys(search);
	}
	public void clickOnCategorySearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchbox);
		educationSearchbox.click();
	}
	public void clickOnAddedCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addedCategory);
		addedCategory.click();
	}
	public void clearEducationCategorySecondLangPage() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		educationCategorieNameLangTwo.sendKeys(del);
		educationDescriptionLangTwo.sendKeys(del);
	}
}
