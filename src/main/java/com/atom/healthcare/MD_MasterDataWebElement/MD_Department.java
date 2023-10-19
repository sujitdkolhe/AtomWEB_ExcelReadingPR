package com.atom.healthcare.MD_MasterDataWebElement;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_Department extends BasePageObject{

	@FindBy(how = How.ID, using = "DepartmentsViewAddActionKey")
	private WebElement departmentAddButton;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopupDepartmentNameTextKey1input-text")
	private WebElement departmentTextbox;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopupDepartmentNameTextKey2input-text")
	private WebElement departmentSecongLangTextbox;
	
	@FindBy(how = How.ID, using = "DepartmentsViewSaveActionKey")
	private WebElement departmentSaveButton;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopupDepartmentNameTextKey1errorLabel")
	private WebElement departmentNameErrorMessage;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopuperrorLabel")
	private WebElement departmentLangMessage;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopuptabs2")
	private WebElement departmentSecondLang;
	
	@FindBy(how = How.ID, using = "DepartmentsViewIsPopupDepartmentNameTextKey1errorLabel")
	private WebElement departmentRangeErrorMessage;
	
	@FindBy(how = How.ID, using = "DepartmentsViewtable-row0")
	private WebElement addedDepartment;
	
	@FindBy(how = How.ID, using = "DepartmentsView")
	private WebElement departmentListPage;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement departmentSearchTextbox;
	
	@FindBy(how = How.ID, using = "7387fe6e-ff5d-425f-a78c-a7eb1a5748c9DepartmentsViewSearchTextKey")
	private WebElement searchAddedDepartment;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement departmentAddPage;
	
	public MD_Department(WebDriver driver) {
		super(driver);
	PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	} 
	
	public void clickOnDepartmentAddButton(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentAddButton);
		departmentAddButton.click();
	}
	
	public void sendDepartmentName(String name)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentTextbox);
		departmentTextbox.sendKeys(name);
	}

	public void clickOnDepartmentSaveButton(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSaveButton);
		departmentSaveButton.click();
	}
	
	public boolean isDepartmentNameRequiredErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentNameErrorMessage);
			isPresent = departmentNameErrorMessage.isDisplayed();
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
			waitForElement(driver, departmentLangMessage);
			isPresent = departmentLangMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnDepartmentSecondLang(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSecondLang);
		departmentSecondLang.click();
	}
	
	public boolean isDepartmentRangeErrorMessageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentRangeErrorMessage);
			isPresent = departmentRangeErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnDepartmentNameTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentTextbox);
		departmentTextbox.click();
	}
	
	public void clearDepartmentNameTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentTextbox);
		departmentTextbox.clear();
	}
	
	public void clickOnAddedDepartment(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  addedDepartment);
		addedDepartment.click();
	}
	
	public void clickOnDepartmentSecongLangTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSecongLangTextbox);
		departmentSecongLangTextbox.click();
	}
	
	public void sendDepartmentNameForSecondLang(String dept)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSecongLangTextbox);
		departmentSecongLangTextbox.sendKeys(dept);
	}
	
	public boolean isDepartmentListPageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentListPage);
			isPresent = departmentListPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void searchAddedDepartmentName(String search)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSearchTextbox);
		departmentSearchTextbox.sendKeys(search);
	}
	
	public void clickOnDepartmentSearchTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSearchTextbox);
		departmentSearchTextbox.click();
	}
	
	public boolean isDepartmentAddPageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, departmentAddPage);
			isPresent = departmentAddPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clearDepartmentNameSecondLangTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  departmentSecongLangTextbox);
		departmentSecongLangTextbox.clear();
	}
}

