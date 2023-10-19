package com.atom.healthcare.Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;
import com.google.gson.annotations.Until;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Instructions extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;

	@FindBy(how = How.ID, using = "SubflowsView")
	private WebElement subFlowTab;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	public WebElement instructionTabText;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[1]")
	public WebElement instructionList;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	public WebElement instructionListTitle;

	@FindBy(how = How.ID, using = "InstructionsViewSearchTextKey")
	public WebElement instructionSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement instructionSearchPlaceholder;

	@FindBy(how = How.XPATH, using = "//button[text()='Add']")
	public WebElement instructionAddButton;

	@FindBy(how = How.XPATH, using = "//div[@id='InstructionsViewIsPopupInstructionNameKey1']/input")
	public WebElement instructionNameTextbox;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey1input-text")
	public WebElement instructionNameTextboxOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey2input-text")
	public WebElement instructionNameTextboxTwo;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[1]")
	public WebElement instructionDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[2]/div/p")
	public WebElement instructionDescriptionTextboxOne;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[3]/div/p")
	public WebElement instructionDescriptionTextboxTwo;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs1")
	public WebElement instructionLangOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs2")
	public WebElement instructionLangTwo;

	@FindBy(how = How.ID, using = "InstructionsViewSaveActionKey")
	public WebElement instructionSaveButton;

	@FindBy(how = How.ID, using = "InstructionsViewCancelActionKey")
	public WebElement instructionCancelButton;

	@FindBy(how = How.XPATH, using = "//div[@class='table-header w-available mx-2']")
	public WebElement instructionNameHeader;

	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[12]")
	public WebElement careProgramTabs;

	@FindBy(how = How.ID, using = "TasksView")
	private WebElement tasksTab;

	@FindBy(how = How.ID, using = "InstructionsViewerrorLabel")
	public WebElement instructionSearchErrorLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[last()]")
	private WebElement subflowListRecord;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])")
	public WebElement instructionAddPageTitle;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Instruction Text')])[2]")
	public WebElement instructionNameLabel;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Description')])[1]")
	public WebElement instructionDescriptionLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLangOneLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLangTwoLabel;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLangThreeLabel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Instruction Text']")
	public WebElement instructionNamePlaceholder;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	public WebElement addPageCrossIcon;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false'])[1]")
	public WebElement instructionEditDescriptionTextboxText;

	@FindBy(how = How.ID, using = "InstructionsViewDeleteActionKey")
	public WebElement instructionDeleteButton;

	@FindBy(how = How.ID, using = "InstructionsViewOkActionKey")
	public WebElement instructionDeleteOkButton;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start']")
	private WebElement subflowDeleteLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])\r\n")
	private WebElement subflowDeleteConfirmationMsg;

	@FindBy(how = How.ID, using = "InstructionsViewCancelActionKey")
	public WebElement instructionDeleteCancelButton;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLanguageErrorMsg;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey1errorLabel")
	public WebElement instructionNameErrorMsg;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionDescriptionKey1errorLabel")
	public WebElement instructionDescriptionErrorMsg;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false'])[1]")
	public WebElement instDescFirstLangTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false'])[2]")
	public WebElement instDescSecondLangTextbox;

	@FindBy(how = How.XPATH, using = "(//li[text()='English'])[2]")
	public WebElement instructionEnglishLangLabel;

	@FindBy(how = How.XPATH, using = "(//li[text()='Hindi'])[2]")
	public WebElement instructionHindiLangLabel;

	@FindBy(how = How.XPATH, using = "//div[@id='InstructionsViewIsPopupInstructionNameKey1']/input")
	public WebElement instructionTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false']/p)[1]")
	public WebElement descriptionTextbox;

	public Instructions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCareProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickCareProgramTab);
		javascriptClick(clickCareProgramTab);
	}

	public String getProgramPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, pageTitle);
		return pageTitle.getText();
	}

	public String getInstructionTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionTabText);
		return instructionTabText.getText();
	}

	public void clickOnCareProgramTabs() {
		TestConfig.PrintMethodName();
		waitForElement(driver, careProgramTabs);
		javascriptClick(careProgramTabs);
	}

	public String getInstructionTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionTabText);
		String cssValue = instructionTabText.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getInstructionListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionListTitle);
		return instructionListTitle.getText();
	}

	public void clickOnInstructionAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddButton);
		javascriptClick(instructionAddButton);
	}

	public void sendInstructionName(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		instructionNameTextbox.sendKeys(name);
	}

	public void sendInstructionDescription(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextbox);
		driver.findElement(By.xpath("(//div[@data-gramm='false'])[1]"));
		Actions action = new Actions(driver);
		action.sendKeys(instructionDescriptionTextbox, name).build().perform();
	}

	public void clickOnFirstInstructionLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangOne);
		instructionLangOne.click();
	}

	public void sendInstructionNameOnFirstTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextboxOne);
		instructionNameTextboxOne.sendKeys(name);
	}

	public void sendInstructionForFirstDescriptionTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instDescFirstLangTextbox);
		Actions action = new Actions(driver);
		action.sendKeys(instDescFirstLangTextbox, name).build().perform();
	}

	public void clickOnSecondInstructionLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangTwo);
		instructionLangTwo.click();
	}

	public void sendInstructionNameOnSecondTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextboxTwo);
		instructionNameTextboxTwo.sendKeys(name);
	}

	public void sendInstructionForSecondDescriptionTextbox(String name) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instDescSecondLangTextbox);
		instDescSecondLangTextbox.sendKeys(name);
		Actions action = new Actions(driver);
		action.sendKeys(instDescSecondLangTextbox, name).build().perform();
	}

	public void clickOnInstructionSaveButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSaveButton);
		instructionSaveButton.click();
		Thread.sleep(2000);
	}

	public boolean isInstructionSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionSearchTextbox);
			isPresent = instructionSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getInstructionSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchPlaceholder);
		return instructionSearchPlaceholder.getAttribute("placeholder");
	}

	public String getInstructionAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddButton);
		return instructionAddButton.getText();
	}

	public String getInstructionNameHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameHeader);
		return instructionNameHeader.getText();
	}

	public boolean isInstructionListPageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionList);
			isPresent = tasksTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getInstructionSearchErrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchErrorLabel);
		return instructionSearchErrorLabel.getText();
	}

	public void clearInstructionSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		instructionSearchTextbox.clear();
	}

	public void clickOnInstructionListRecord() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowListRecord);
		javascriptClick(subflowListRecord);
	}

	public String getInstructionAddEditPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddPageTitle);
		return instructionAddPageTitle.getText();
	}

	public String getInstructionNameLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameLabel);
		return instructionNameLabel.getText();
	}

	public String getInstructionDescriptionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionLabel);
		return instructionDescriptionLabel.getText();
	}

	public String getInstructionNamePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNamePlaceholder);
		return instructionNamePlaceholder.getAttribute("placeholder");
	}

	public String getInstructionLangLabelForFirstLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionEnglishLangLabel);
		return instructionEnglishLangLabel.getText();
	}

	public String getInstructionLangLabelForSecondLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionHindiLangLabel);
		return instructionHindiLangLabel.getText();
	}

	public String getInstructionLangLabelForThirdLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLangThreeLabel);
		return instructionLangThreeLabel.getText();
	}

	public boolean isInstructionNameTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionNameTextbox);
			isPresent = instructionNameTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void sendInstructionSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSearchTextbox);
		instructionSearchTextbox.sendKeys(searchword);
	}

	public boolean isAddPageCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, addPageCrossIcon);
			isPresent = addPageCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionDescriptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, instructionDescriptionTextbox);
			isPresent = instructionDescriptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getInstructionSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSaveButton);
		return instructionSaveButton.getText();
	}

	public String getInstructionCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionCancelButton);
		return instructionCancelButton.getText();
	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addPageCrossIcon);
		addPageCrossIcon.click();
	}

	public String getInstructionNamePrefilledData() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionTextbox);
		return instructionTextbox.getAttribute("value");
	}

	public String getInstructionDescriptionPrefilledData() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(descriptionTextbox);
		return descriptionTextbox.getAttribute("value");
	}

	public String getInstructionDeleteButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteButton);
		return instructionDeleteButton.getText();
	}

	public void clickOnInstructionDeleteButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(instructionDeleteButton);
		javascriptClick(instructionDeleteButton);
	}

	public void clickOnInstructionDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteOkButton);
		javascriptClick(instructionDeleteOkButton);
	}

	public String getDeleteLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowDeleteLabel);
		return subflowDeleteLabel.getText();
	}

	public String getDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, subflowDeleteConfirmationMsg);
		return subflowDeleteConfirmationMsg.getText();
	}

	public String getInstructionDeleteCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteCancelButton);
		return instructionDeleteCancelButton.getText();
	}

	public String getInstructionDeleteOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteOkButton);
		return instructionDeleteOkButton.getText();
	}

	public void clickOnInstructionCancelButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(instructionCancelButton);
		instructionCancelButton.click();
	}

	public String getInstructionLanguageErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionLanguageErrorMsg);
		return instructionLanguageErrorMsg.getText();
	}

	public String getInstructionNameErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameErrorMsg);
		return instructionNameErrorMsg.getText();
	}

	public String getInstructionDescriptionErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionErrorMsg);
		return instructionDescriptionErrorMsg.getText();
	}

	public void createInstruction(String instName, String distrName) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		Actions action = new Actions(driver);
		instructionLangOne.click();
		instructionNameTextboxOne.sendKeys(instName);
		waitForElement(driver, instDescFirstLangTextbox);
		action.sendKeys(instDescFirstLangTextbox, distrName).build().perform();
		instructionLangTwo.click();
		instructionNameTextboxTwo.sendKeys(instName);
		action.sendKeys(instDescSecondLangTextbox, distrName).build().perform();
		instructionSaveButton.click();
		Thread.sleep(2000);
	}

	public void selectInstructionListRecord(String instName) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(subflowListRecord);
		WebElement element = driver.findElement(By.xpath("//label[text()='" + instName + "']"));
		javascriptClick(element);
	}
}
