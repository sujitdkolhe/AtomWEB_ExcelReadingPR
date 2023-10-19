package com.atom.healthcare.TD_Patients;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Chats extends BasePageObject {

	public Chats(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsView2416")
	private WebElement patientForChat;

	@FindBy(how = How.ID, using = "ChatView")
	private WebElement patientChatTab;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 message px-3 pb-2  right-arrow'][1]")
	private WebElement patientChatMsg;

	@FindBy(how = How.XPATH, using = "//span[@class=' truncate ltr'][contains(.,'Chats')]")
	private WebElement patientChatTabColor;

	@FindBy(how = How.XPATH, using = "(//div[@class='row px-0 mx-0 d-flex justify-content-center'])[3]")
	private WebElement patientChatProfileImg;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])")
	private WebElement patientChatName;

	@FindBy(how = How.XPATH, using = "(//img[@class='svg-icon-small cursor-pointer'])")
	private WebElement patientChatPlusIcon;

	@FindBy(how = How.ID, using = "ChatViewAddCaption/TitleKeyinput-textArea")
	private WebElement patientChatTextbox;

	@FindBy(how = How.XPATH, using = "(//textarea[@placeholder='Enter text here'])")
	private WebElement patientChatTextboxPlaceholder;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary float-right margin-sm'])")
	private WebElement patientChatSendButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement chatAttachFileTitle;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement chatAttachFileCrossIcon;

	@FindBy(how = How.XPATH, using = "//input[@type=\"file\"]")
	private WebElement chatAttachFileImageUpload;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-medium-regular text-start ltr\"])[3]")
	private WebElement chatAttachFileCaption;

	@FindBy(how = How.ID, using = "ChatViewAddCaption/TitleKeyinput-textArea")
	private WebElement chatCaptionTextbox;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Enter text here']")
	private WebElement chatCaptionTextboxPlaceholder;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-primary padding-horizontal-md  margin-left-md']")
	private WebElement chatAttachFileSendButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-white-body-medium-regular text-end margin-bottom-xs'])[last()]")
	private WebElement chatAttachFileMsgTime;

	@FindBy(how = How.XPATH, using = "(//img[@class='svg-icon-small'])[last()]")
	private WebElement msgDeleteIcon;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center'])")
	private WebElement msgDeleteConfirmationMsg;

	@FindBy(how = How.XPATH, using = "(//button[@id='ChatViewCancelActionKey'])[2]")
	private WebElement msgDeleteConfirmationCancelButton;

	@FindBy(how = How.XPATH, using = "(//button[@id='ChatViewOkActionKey'])[1]")
	private WebElement msgDeleteConfirmationOkButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-white-body-large-regular text-start'])[last()]")
	private WebElement itemDeletedMsg;

	public void clickOnChatPatient() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientForChat);
		waitForElement(driver, patientForChat);
		patientForChat.click();
	}

	public void clickOnPatientChatTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientChatTab);
		waitForElement(driver, patientChatTab);
		javascriptClick(patientChatTab);
	}

	public boolean isPatientChatMsgDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatMsg);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientChatMsg);
			isPresent = patientChatMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientChatTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientChatTabColor);
		waitForElement(driver, patientChatTabColor);
		String cssValue = patientChatTabColor.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isChatDetailPatientProfileDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatProfileImg);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientChatProfileImg);
			isPresent = patientChatProfileImg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailPatientNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatName);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientChatName);
			isPresent = patientChatName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailPlusIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatPlusIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientChatPlusIcon);
			isPresent = patientChatPlusIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, patientChatTextbox);
			isPresent = patientChatTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getChatDetailTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatTextboxPlaceholder);
		return patientChatTextboxPlaceholder.getAttribute("placeholder");
	}

	public String getChatsDetailSendButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatSendButton);
		return patientChatSendButton.getText();
	}

	public void clickOnChatSendButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatSendButton);
		javascriptClick(patientChatSendButton);
	}

	public void clickOnPlusIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatPlusIcon);
		patientChatPlusIcon.click();
	}

	public String getAttachFileTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileTitle);
		return chatAttachFileTitle.getText();
	}

	public boolean isAttachFileCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, chatAttachFileCrossIcon);
			isPresent = chatAttachFileCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnAttachFileCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileCrossIcon);
		chatAttachFileCrossIcon.click();
	}

	public void uploadFileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileImageUpload);
		chatAttachFileImageUpload.sendKeys(image);
	}

	public void patientChatSendMsg(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientChatTextbox);
		patientChatTextbox.sendKeys(text);
	}

	public String getAddCaptionTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatAttachFileCaption);
		waitForElement(driver, chatAttachFileCaption);
		return chatAttachFileCaption.getText();
	}

	public boolean isAddCaptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatCaptionTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, chatCaptionTextbox);
			isPresent = chatCaptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddCaptionTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatCaptionTextbox);
		return chatCaptionTextbox.getAttribute("placeholder");
	}

	public String getAttachFileSendButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileSendButton);
		return chatAttachFileSendButton.getText();
	}

	public void clickOnNewMsgSent() throws AWTException, InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileMsgTime);
		Actions action = new Actions(driver);
		action.click(chatAttachFileMsgTime).build().perform();
	}

	public void clickOnDeleteIcon() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteIcon);
		Actions action = new Actions(driver);
		action.sendKeys(msgDeleteIcon, Keys.ENTER).build().perform();
		Thread.sleep(5000);
	}

	public String getMsgDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteConfirmationMsg);
		return msgDeleteConfirmationMsg.getText();
	}

	public String getDeleteConfirmationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteConfirmationCancelButton);
		return msgDeleteConfirmationCancelButton.getText();
	}

	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteConfirmationCancelButton);
		javascriptClick(msgDeleteConfirmationCancelButton);
	}

	public String getDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteConfirmationOkButton);
		return msgDeleteConfirmationOkButton.getText();
	}

	public String getItemDeletedMsg() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(itemDeletedMsg);
		waitForElement(driver, itemDeletedMsg);
		return itemDeletedMsg.getText();
	}

	public boolean isAttachFileMsgTimeDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatAttachFileMsgTime);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, chatAttachFileMsgTime);
			isPresent = chatAttachFileMsgTime.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnDeleteOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, msgDeleteConfirmationOkButton);
		javascriptClick(msgDeleteConfirmationOkButton);
	}

	public void clickOnAttachFileSendButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatAttachFileSendButton);
		waitForElement(driver, chatAttachFileSendButton);
		chatAttachFileSendButton.click();
	}

}
