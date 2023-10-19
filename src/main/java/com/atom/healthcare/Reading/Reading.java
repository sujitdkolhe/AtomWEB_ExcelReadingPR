package com.atom.healthcare.Reading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Reading extends BasePageObject {
	
	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuReadingsView")
	private WebElement menuReadingTab;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold col-xl-7 col-md-6 col-sm-12 margin-bottom-md px-0']")
	private WebElement readingPageTitle;
	
	@FindBy(how = How.ID, using = "ReadingsViewSearchTextKey")
	private WebElement searchTextBox;
	
	@FindBy(how = How.ID, using = "ReadingsViewAddActionKey")
	private WebElement readingAddButton;
	
	@FindBy(how = How.ID, using = "ReadingsViewtable-row0")
	private WebElement readingObservationList;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[1]")
	private WebElement listHeaderObservationName;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[2]")
	private WebElement listHeaderReadingcode;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[3]")
	private WebElement listHeaderSequenceNo;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[4]")
	private WebElement listHeaderValuesAddedBy;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	private WebElement listHeaderAllowManualReading;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular ltr '])[9]")
	private WebElement supportedReadingObservation;
	
	@FindBy(how = How.ID, using = "ReadingsViewSaveActionKey")
	private WebElement readingSaveButton;
	
	@FindBy(how = How.ID, using = "ReadingsViewerrorLabel")
	private WebElement searchErrorLabel;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Readings']")
	private WebElement patientReadingTab;
	
	public Reading(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnReadingTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, menuReadingTab);
		menuReadingTab.click();
	}

	public String getReadingPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingPageTitle);
		return readingPageTitle.getText();
	}
	
	public boolean isReadingSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, searchTextBox);
			isPresent = searchTextBox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	} 
	
	public String getSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		return searchTextBox.getAttribute("placeholder");
	}
	
	public String getReadingAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingAddButton);
		return readingAddButton.getText();
	}
	
	public boolean isReadingObservationListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, readingObservationList);
			isPresent = readingObservationList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	} 
	
	public String getListHeaderObservationName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listHeaderObservationName);
		return listHeaderObservationName.getText();
	}
	
	public String getlistHeaderReadingcode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listHeaderReadingcode);
		return listHeaderReadingcode.getText();
	}
	
	public String getlistHeaderSequenceNo() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listHeaderSequenceNo);
		return listHeaderSequenceNo.getText();
	}
	
	public String getlistHeaderValuesAddedBy() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listHeaderValuesAddedBy);
		return listHeaderValuesAddedBy.getText();
	}
	
	public String getlistHeaderAllowManualReading() {
		TestConfig.PrintMethodName();
		waitForElement(driver, listHeaderAllowManualReading);
		return listHeaderAllowManualReading.getText();
	}
	
	public void clickOnAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingAddButton);
	    readingAddButton.click();
	}
	
	public void clickOnSupportedReadingObservation() {
		TestConfig.PrintMethodName();
		waitForElement(driver, supportedReadingObservation);
		supportedReadingObservation.click();
	}
	
	public void clickOnReadingSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingSaveButton);
		readingSaveButton.click();
	}
	
	public void sendSubflowSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		searchTextBox.sendKeys(searchword);
	}
	
	public void clearSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		searchTextBox.clear();
	}
	
	public void patientReadingTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextBox);
		searchTextBox.clear();
	}
	
	public void clickOnPatientReadingTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientReadingTab);
		patientReadingTab.click();
	}
	
	public boolean isReadingDisplay(String caregiver) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + caregiver + "']")));
			WebElement caregiverName = driver.findElement(By.xpath("//label[text()='" + caregiver + "']"));
			isPresent = caregiverName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Reading "+caregiver+" is not visible");
			return isPresent;
		}
	}
}




