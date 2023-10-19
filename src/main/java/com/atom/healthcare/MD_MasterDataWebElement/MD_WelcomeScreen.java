package com.atom.healthcare.MD_MasterDataWebElement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.Pojo.AtomHC;
//import com.atom.healthcare.Test.available;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig; 
public class MD_WelcomeScreen extends BasePageObject{
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement welcomeScreenListPage;
	
	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement searchTextbox;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewtable-row0")
	private WebElement welcomeScreenList;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupSequenceNoKeyinput-text")
	private WebElement sequenceNoTextbox;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupUploadImageTextKeyinput-fieImageUploadControl")
	private WebElement uploadImageControl;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow']/child::div/p)[1]")
	private WebElement headerTextTextbox;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow']/child::div/p)[2]")
	private WebElement bodyTextTextbox;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow']/child::div/p)[3]")
	private WebElement headerTextSecondLangTextbox;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow']/child::div/p)[4]")
	private WebElement bodyTextSecondLangTextbox;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewSaveActionKey")
	private WebElement welcomeScreenSaveButton;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewAddActionKey")
	private WebElement welcomeScreenAddButton;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupSequenceNoKeyerrorLabel")
	private WebElement sequenceNoRequiredErrorMsg;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupUploadImageTextKeyerrorLabel")
	private WebElement uploadImageRequiredErrorMsg;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupHeaderTextKey1errorLabel")
	private WebElement headerTextRequiredErrorMsg;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupBodyTextTextKey1errorLabel")
	private WebElement bodyTextRequiredErrorMsg;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopuperrorLabel")
	private WebElement allLangRequiredErrorMsg;
	
	@FindBy(how = How.ID, using = "WelcomeScreensView")
	private WebElement masterDataWelcomeScreenTab;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupUploadImageTextKeyDeleteActionKey")
	private WebElement imageDeleteButton;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopuperrorLabel")
	private WebElement langErrorMessage;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopupUploadImageTextKeyerrorLabel")
	private WebElement imageFormatErrorMessage;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewIsPopuptabs2")
	private WebElement secondLang;
	
	@FindBy(how = How.ID, using = "WelcomeScreensViewtable-row0")
	private WebElement addedWelcomeScreen;
	
	public MD_WelcomeScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnWelcomeScreenAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, welcomeScreenAddButton);
		welcomeScreenAddButton.click();
	}

	public void clickOnWelcomeScreenSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, welcomeScreenSaveButton);
		welcomeScreenSaveButton.click();
	}
	
	public boolean getSequenceNoRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, sequenceNoRequiredErrorMsg);
			isPresent = sequenceNoRequiredErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean getUploadImageRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, uploadImageRequiredErrorMsg);
			isPresent = uploadImageRequiredErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean getHeaderTextRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, headerTextRequiredErrorMsg);
			isPresent = headerTextRequiredErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean getBodyTextRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, bodyTextRequiredErrorMsg);
			isPresent = bodyTextRequiredErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean getAllLangRequiredErrorMsg() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, allLangRequiredErrorMsg);
			isPresent = allLangRequiredErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnMasterDataWelcomeScreenTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, masterDataWelcomeScreenTab);
		masterDataWelcomeScreenTab.click();
	}
	
	public void clickOnSecongLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, secondLang);
		secondLang.click();
	}
	
	public void uploadWelcomeScreenImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  uploadImageControl);
		uploadImageControl.sendKeys(image);
	}

	public void sendHeaderText(String header) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  headerTextTextbox);
		headerTextTextbox.sendKeys(header);
	}
	
	public void sendBodyText(String body)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  bodyTextTextbox);
		bodyTextTextbox.sendKeys(body);
	}
	
	public void sendSecondLangHeaderText(String header) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  headerTextSecondLangTextbox);
		headerTextSecondLangTextbox.sendKeys(header);
	}
	
	public void sendSecondLangBodyText(String body)throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  bodyTextSecondLangTextbox);
		bodyTextSecondLangTextbox.sendKeys(body);
	}

	public void sendSequenceNo(String sequenceNo) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  sequenceNoTextbox);
		sequenceNoTextbox.sendKeys(sequenceNo);
	}
	

	public void clearSequenceNo(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  sequenceNoTextbox);
		sequenceNoTextbox.clear();
	}
	
	public void clearHeaderText(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  headerTextTextbox);
		headerTextTextbox.clear();
	}
	
	public void clearWelcomeScreenAddPage(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  sequenceNoTextbox);
		sequenceNoTextbox.clear();
		waitForElement(driver,  headerTextTextbox);
		headerTextTextbox.clear();
		waitForElement(driver,  bodyTextTextbox);
		bodyTextTextbox.clear();
	}
	
	
	public void clickOnUploadImageControl(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  uploadImageControl);
		uploadImageControl.click();
	}
	
	public void clickOnImageDeleteButton(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  imageDeleteButton);
		imageDeleteButton.click();
	}
	
	public void clickOnSequenceNoTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  sequenceNoTextbox);
		sequenceNoTextbox.click();
	}
	
	public void clickOnHeaderTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  headerTextTextbox);
		headerTextTextbox.click();
	}
	
	public void clickOnBodyTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  bodyTextTextbox);
		bodyTextTextbox.click();
	}
	
	public boolean isImageFormatErrorMsgDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, imageFormatErrorMessage);
			isPresent = imageFormatErrorMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void sendAddedWelcomeScreen(String search) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  searchTextbox);
		searchTextbox.sendKeys(search);
	}
	
	public boolean isWelcomeScreenListPageDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, welcomeScreenListPage);
			isPresent = welcomeScreenListPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnAddedWelcomeScreen(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  addedWelcomeScreen);
		addedWelcomeScreen.click();
	}
	
	public void clickOnSearchTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  searchTextbox);
		searchTextbox.click();
	}
	
	public void clickOnSecondLangHeaderTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  headerTextSecondLangTextbox);
		headerTextSecondLangTextbox.click();
	}
	
	public void clickOnSecondLangBodyTextbox(){
		TestConfig.PrintMethodName();
		waitForElement(driver,  bodyTextSecondLangTextbox);
		headerTextSecondLangTextbox.click();
	}
	
	public void addWelcomeScreenDetails(String sequenceNo, String headerText, String bodyText) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, welcomeScreenAddButton);
		waitForElement(driver, uploadImageControl);
		sequenceNoTextbox.click();
		sequenceNoTextbox.sendKeys(sequenceNo);
		//uploadImageControl.sendKeys(image);
		Thread.sleep(500);
		headerTextTextbox.click();
		headerTextTextbox.sendKeys(headerText);  
		Thread.sleep(500);
		bodyTextTextbox.click();
		bodyTextTextbox.sendKeys(bodyText);
	}
	
	public void addWelcomeScreenDetailsForSecondLang(String sequenceNo, String headerText, String bodyText) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, welcomeScreenAddButton);
		waitForElement(driver, uploadImageControl);
		sequenceNoTextbox.click();
		sequenceNoTextbox.sendKeys(sequenceNo);
		//uploadImageControl.sendKeys(image);
		headerTextSecondLangTextbox.click();
		headerTextSecondLangTextbox.sendKeys(headerText);  
		Thread.sleep(500);
		bodyTextSecondLangTextbox.click();
		bodyTextSecondLangTextbox.sendKeys(bodyText);
	}
	
	public void clearWelcomeScreenDetails() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		TestConfig.PrintMethodName();
		waitForElement(driver, sequenceNoTextbox);
		sequenceNoTextbox.sendKeys(del);
		waitForElement(driver, headerTextTextbox);
		headerTextTextbox.sendKeys(del);
		waitForElement(driver, bodyTextTextbox);
		scrollAndWait(0, 4000, 0);
		bodyTextTextbox.sendKeys(del);
	}
	
	public void clearWelcomeScreenDetailsForSecondLang() throws InterruptedException {
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		TestConfig.PrintMethodName();
		waitForElement(driver, headerTextTextbox);
		headerTextSecondLangTextbox.sendKeys(del);
		waitForElement(driver, bodyTextTextbox);
		scrollAndWait(0, 4000, 0);
		bodyTextSecondLangTextbox.sendKeys(del);
	}
}





