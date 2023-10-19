package com.atom.healthcare.Chats;

import java.awt.AWTException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Chats extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuChatsView")
	private WebElement menuChatsTab;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs\"]")
	private WebElement chatHeader;

	@FindBy(how = How.ID, using = "ChatsViewAddActionKey")
	private WebElement chatAddButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-3-semi-bold margin-xs margin-top-md col-12 px-0\"]")
	private WebElement chatListTitle;

	@FindBy(how = How.ID, using = "ChatsViewSearchTextKey")
	private WebElement chatSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
	private WebElement chatSearchPlaceholder;

	@FindBy(how = How.ID, using = "ChatsViewbce834ab-9e50-4097-a026-87b8d5edac39")
	private WebElement chatListRecord;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-secondary-text-body-medium-regular text-start truncate\"])[2]")
	private WebElement chatRecipientLastMessage;

	@FindBy(how = How.XPATH, using = "//img[@class=\"avatar-circle\"][1]")
	private WebElement chatRecipientProfileImg;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[1]")
	private WebElement chatRecipientName;

	@FindBy(how = How.XPATH, using = "//label[@class=\"badge-number truncate\"]")
	private WebElement chatRecipientUnreadMsgBatchCount;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"badge-number truncate\"])[2]")
	private WebElement chatRecipientWithBatchCount;

	@FindBy(how = How.ID, using = "ChatsView4f033414-d536-42e6-aa33-4b7764aa353d")
	private WebElement chatListRecipientWithInactiveRelation;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-body-medium-semi-bold text-wrap margin-sm font-italic d-flex justify-content-center\"]")
	private WebElement chatRecipientRelationInactiveMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-regular text-start\"])[1]")
	private WebElement chatInActiveRecipientMessage;

	@FindBy(how = How.ID, using = "ChatsViewNoDataFoundKey")
	private WebElement chatSearchNoDataMsg;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement chatNewChatPageTitle;

	@FindBy(how = How.XPATH, using = "//div[@class=\"col-lg-4 col-md-4 padding-horizontal-xs flex-grow-1 px-0 margin-horizontal-md\"]")
	private WebElement chatLeftColumn;

	@FindBy(how = How.XPATH, using = "//div[@class=\"flex-grow-1 px-0 margin-vertical-xs\"]")
	private WebElement chatRightColumn;

	@FindBy(how = How.XPATH, using = "//textarea[@class=\"input-primary mb-0 pt-2  ltr\"]")
	private WebElement chatTextboxForMessage;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[8]")
	private WebElement chatNewRecipentForCount;

	@FindBy(how = How.XPATH, using = "(//button[@class=\"btn btn-primary float-right margin-sm\"])")
	private WebElement chatSendButton;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[5]")
	private WebElement chatRecipentWithMsg;

	@FindBy(how = How.ID, using = "ChatsViewNoDataFoundKey")
	private WebElement chatsViewNoData;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer']")
	private WebElement newChatCrossIcon;

	@FindBy(how = How.ID, using = "ChatsViewIsPopupSearchTextKey")
	private WebElement newChatSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder=\"Search\"]")
	private WebElement newChatSearchPlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[8]")
	private WebElement newChatPatientList;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"row px-0 mx-0 d-flex justify-content-center\"])[9]")
	private WebElement newChatPatientProfileIcon;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[8]")
	private WebElement newChatPatientName;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"lbl-primary-text-body-large-semi-bold text-start truncate\"])[7]")
	private WebElement newChatSearchedPatient;

	@FindBy(how = How.XPATH, using = "(//label[text()='Chats'])[2]")
	private WebElement chatDetailPagePatientProfile;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'])[9]")
	private WebElement chatDetailPagePatientName;

	@FindBy(how = How.XPATH, using = "//div[@id='ChatsViewIsPopup2435']")
	private WebElement chatDetailPagePatient;

	@FindBy(how = How.XPATH, using = "//div[@class='col margin-vertical-xs px-0']/textarea")
	private WebElement chatDetailTextbox;

	@FindBy(how = How.XPATH, using = "//textarea[@placeholder='Enter text here']")
	private WebElement chatDetailTextboxPlaceholder;

	@FindBy(how = How.XPATH, using = "//button[@id='ChatsViewAddActionKey'][contains(.,'Add')]")
	private WebElement chatDetailPlusIcon;

	@FindBy(how = How.XPATH, using = "//button[@class=\"btn btn-primary float-right margin-sm\"]")
	private WebElement chatDetailSendButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement chatAttachFileTitle;

	@FindBy(how = How.XPATH, using = "//label[text()='New Chat']/following::img")
	private WebElement chatAttachFileCrossIcon;

	@FindBy(how = How.XPATH, using = "//input[@type=\"file\"]")
	private WebElement chatAttachFileImageUpload;

	@FindBy(how = How.XPATH, using = "//label[text()='Add Caption/Title']")
	private WebElement chatAttachFileCaption;

	@FindBy(how = How.ID, using = "ChatsViewAddCaption/TitleKeyinput-textArea")
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

	@FindBy(how = How.ID, using = "ChatsViewCancelActionKey")
	private WebElement msgDeleteConfirmationCancelButton;

	@FindBy(how = How.ID, using = "ChatsViewOkActionKey")
	private WebElement msgDeleteConfirmationOkButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-white-body-large-regular text-start'])[last()]")
	private WebElement itemDeletedMsg;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex align-items-start chat-upload margin-sm']/img")
	private WebElement plusIcon;

	@FindBy(how = How.XPATH, using = "(//label[text()='Attach file']/following::img)[1]")
	private WebElement chatCrossIcon;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column'])[1]/label")
	private WebElement chatPatientDetailPage;

	@FindBy(how = How.XPATH, using = "//div[@class='col-12 message px-3 pb-2  right-arrow'][last()]")
	private WebElement lastChat;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-vertical-xs margin-horizontal-md col-6 px-0 d-flex flex-column'])[11]")
	private WebElement newChatPatient;

	public Chats(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenuChatsTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(menuChatsTab);
		waitForElement(driver,  menuChatsTab);
		javascriptClick(menuChatsTab);
	}

	public String getChatPageTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatHeader);
		waitForElement(driver,  chatHeader);
		return chatHeader.getText();
	}

	public String getAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAddButton);
		return chatAddButton.getText();
	}

	public String getChatListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatListTitle);
		return chatListTitle.getText();
	}

	public boolean isChatSearchtextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatSearchTextbox);
			isPresent = chatSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getChatSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSearchPlaceholder);
		return chatSearchPlaceholder.getAttribute("placeholder");
	}

	public void sendRecipientNameInSearchTextbox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSearchTextbox);
		chatSearchTextbox.sendKeys(text);
	}

	public void clearSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSearchTextbox);
		chatSearchTextbox.clear();
	}

	public boolean isChatListDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatListRecord);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatListRecord);
			isPresent = chatListRecord.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatRecipientImageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientProfileImg);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatRecipientProfileImg);
			isPresent = chatRecipientProfileImg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatRecipientSearchedNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientName);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatRecipientName);
			isPresent = chatRecipientName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatRecipentUnreadMessageBatchCountDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientUnreadMsgBatchCount);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatRecipientUnreadMsgBatchCount);
			isPresent = chatRecipientUnreadMsgBatchCount.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnChatRecipentWithBadgeCount() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientWithBatchCount);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", chatRecipientWithBatchCount);
	}

	public boolean isChatRecipientLastMessageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientLastMessage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatRecipientLastMessage);
			isPresent = chatRecipientLastMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnRecipientWithInactiveRelation() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatListRecipientWithInactiveRelation);
		waitForElement(driver,  chatListRecipientWithInactiveRelation);
		chatListRecipientWithInactiveRelation.click();
	}

	public boolean isChatInActiveRecipientMessageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatInActiveRecipientMessage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatInActiveRecipientMessage);
			isPresent = chatInActiveRecipientMessage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getchatRecipientRelationInactiveMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRecipientRelationInactiveMessage);
		return chatRecipientRelationInactiveMessage.getText();
	}

	public String getChatSearchNoDataMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSearchNoDataMsg);
		return chatSearchNoDataMsg.getText();
	}

	public void clickOnChatAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatAddButton);
		waitForElement(driver,  chatAddButton);
		javascriptClick(chatAddButton);
	}

	public String getNewChatPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatNewChatPageTitle);
		return chatNewChatPageTitle.getText();
	}

	public boolean isChatLeftColumnDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatLeftColumn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatLeftColumn);
			isPresent = chatLeftColumn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatRightColumnDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatRightColumn);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatRightColumn);
			isPresent = chatRightColumn.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnChatNewRecipentForCount() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatNewRecipentForCount);
		javascriptClick(chatNewRecipentForCount);
	}

	public void sendTextMessageToNewRecipent(String text) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatTextboxForMessage);
		waitForElement(driver,  chatTextboxForMessage);
		chatTextboxForMessage.sendKeys(text);
	}

	public void clickOnChatSendButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatSendButton);
		javascriptClick(chatSendButton);
	}

	public void clickOnChatRecipentWithMsg() {
		TestConfig.PrintMethodName();
        waitUntilElementIsVisible(chatRecipentWithMsg);
		waitForElement(driver,  chatRecipentWithMsg);
		javascriptClick(chatRecipentWithMsg);
	}

	public String getChatsViewNoData() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatsViewNoData);
		return chatsViewNoData.getText();
	}

	public boolean isNewChatCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatCrossIcon);
			isPresent = newChatCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnNewChatCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatCrossIcon);
		newChatCrossIcon.click();
	}

	public boolean isNewChatSearchTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatSearchTextbox);
			isPresent = newChatSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNewChatSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchPlaceholder);
		return newChatSearchPlaceholder.getAttribute("placeholder");
	}

	public void sendRecipientNameInNewChatSearchTextbox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchTextbox);
		newChatSearchTextbox.sendKeys(text);
	}

	public boolean isNewChatPatientListDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatPatientList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatPatientList);
			isPresent = newChatPatientList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isNewChatPatientProfileIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatPatientProfileIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatPatientProfileIcon);
			isPresent = newChatPatientProfileIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isNewChatPatientNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatPatientName);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatPatientName);
			isPresent = newChatPatientName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clearNewChatSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchTextbox);
		newChatSearchTextbox.clear();
	}

	public boolean isNewChatSearchedPatientNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchedPatient);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatSearchedPatient);
			isPresent = newChatSearchedPatient.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnPatientprofileFromNewChatPage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(newChatPatient);
		waitForElement(driver,  newChatPatient);
		javascriptClick(newChatPatient);
	}

	public boolean isNewChatPatientDetailDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  newChatSearchedPatient);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  newChatSearchedPatient);
			isPresent = newChatSearchedPatient.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailPatientProfileDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, chatDetailPagePatientProfile);
		boolean isPresent = false;
		try {
			isPresent = chatDetailPagePatientProfile.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailPatientNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailPagePatientName);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatDetailPagePatientName);
			isPresent = chatDetailPagePatientName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnChatDeatilPatient() throws AWTException, InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatDetailPagePatient);
		waitForElement(driver, chatDetailPagePatient);
		javascriptClick(chatDetailPagePatient);
	}

	public boolean isChatDetailTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatDetailTextbox);
			isPresent = chatDetailTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getChatDetailTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailTextboxPlaceholder);
		return chatDetailTextboxPlaceholder.getAttribute("placeholder");
	}

	public boolean isChatDetailPlusIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailPlusIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatDetailPlusIcon);
			isPresent = chatDetailPlusIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isChatDetailSendButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailPlusIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatDetailSendButton);
			isPresent = chatDetailSendButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getChatsDetailSendButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailSendButton);
		return chatDetailSendButton.getText();
	}

	public void clickOnSendButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatDetailSendButton);
		chatDetailSendButton.click();
	}

	public void clickOnPlusIcon() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatDetailPlusIcon);
		waitForElement(driver,  chatDetailPlusIcon);
		javascriptClick(chatDetailPlusIcon);
	}

	public String getAttachFileTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileTitle);
		return chatAttachFileTitle.getText();
	}

	public boolean isAttachFileCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatCrossIcon);
			isPresent = chatCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnAttachFileCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileCrossIcon);
		javascriptClick(chatAttachFileCrossIcon);
	}

	public void uploadFileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileImageUpload);
		chatAttachFileImageUpload.sendKeys(image);
	}

	public String getAddCaptionTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatAttachFileCaption);
		waitForElement(driver, chatAttachFileCaption);
		return chatAttachFileCaption.getText();
	}

	public boolean isAddCaptionTextboxDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatCaptionTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatCaptionTextbox);
			isPresent = chatCaptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddCaptionTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatCaptionTextbox);
		return chatCaptionTextbox.getAttribute("placeholder");
	}

	public String getAttachFileSendButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileSendButton);
		return chatAttachFileSendButton.getText();
	}

	public void clickOnAtacchFileSendButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileSendButton);
		chatAttachFileSendButton.click();
	}

	public boolean isAttachFileMsgTimeDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileMsgTime);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  chatAttachFileMsgTime);
			isPresent = chatAttachFileMsgTime.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnNewMsgSent() throws AWTException, InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileMsgTime);
		Actions action = new Actions(driver);
		action.click(chatAttachFileMsgTime).build().perform();
	}

	public void clickOnDeleteIcon() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteIcon);
		Actions action = new Actions(driver);
		action.moveToElement(lastChat).build().perform();
		javascriptClick(msgDeleteIcon);
	}

	public String getMsgDeleteConfirmationMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteConfirmationMsg);
		return msgDeleteConfirmationMsg.getText();
	}

	public String getDeleteConfirmationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteConfirmationCancelButton);
		return msgDeleteConfirmationCancelButton.getText();
	}

	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteConfirmationCancelButton);
		msgDeleteConfirmationCancelButton.click();
	}

	public String getDeleteConfirmationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteConfirmationOkButton);
		return msgDeleteConfirmationOkButton.getText();
	}

	public void clickOnOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  msgDeleteConfirmationOkButton);
		msgDeleteConfirmationOkButton.click();
	}

	public String getItemDeletedMsg() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(itemDeletedMsg);
		waitForElement(driver,  itemDeletedMsg);
		return itemDeletedMsg.getText();
	}

	public void clickOnPatientPlusIcon() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(plusIcon);
		waitForElement(driver,  plusIcon);
		javascriptClick(plusIcon);
	}

	public void clickOnPatientsChat() throws AWTException, InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(chatPatientDetailPage);
		waitForElement(driver, chatPatientDetailPage);
		javascriptClick(chatPatientDetailPage);
	}

	public void hoverOnElement() throws AWTException, InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  chatAttachFileMsgTime);
		Actions action = new Actions(driver);
		action.moveToElement(chatAddButton).build().perform();
	}

}
