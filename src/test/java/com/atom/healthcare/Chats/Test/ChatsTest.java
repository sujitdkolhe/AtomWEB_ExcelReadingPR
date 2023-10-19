package com.atom.healthcare.Chats.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Chats.Chats;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.Test.LoginTests;
import com.atom.healthcare.util.BaseTest;

public class ChatsTest extends BaseTest {
	HealthcareLogin loginPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("doctor.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("doctor.pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

//ChatList
	@Test
	public void testIfUserNavigatesToChatsListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		log("verify user navigates to chats list page");
		assertEquals(chatsPage.getChatPageTitle(), AtomHC.propData.getProperty("chat.page.title"));
	}

	@Test(enabled = false)
	public void testChatListPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		log("verify chat list page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(chatsPage.getChatPageTitle(), AtomHC.propData.getProperty("chat.page.title"));
		softAssert.assertEquals(chatsPage.getAddButtonCaption(), AtomHC.propData.getProperty("chat.add.button.caption"));
		softAssert.assertTrue(chatsPage.isChatLeftColumnDisplayed());
		softAssert.assertTrue(chatsPage.isChatRightColumnDisplayed());
		String chatsTitle = chatsPage.getChatListTitle();
		String[] getTitle = chatsTitle.split(" ");
		String educationHeader = getTitle[0];
		softAssert.assertEquals(educationHeader, "Chats");
		String educationCount = getTitle[1];
		String count = educationCount.substring(1, 2);
		log("Chats Count is: " + count);
		int title = Integer.parseInt(count);
		chatsPage.clickOnChatAddButton();
		chatsPage.clickOnChatNewRecipentForCount();
		chatsPage.sendTextMessageToNewRecipent(AtomHC.propData.getProperty("chat.text.msg"));
		chatsPage.clickOnChatSendButton();
		int newCount = title + 1;
		log("Chats New Count is: " + newCount);
		softAssert.assertTrue(chatsPage.isChatSearchtextboxDisplayed());
		softAssert.assertEquals(chatsPage.getChatSearchPlaceholder(), AtomHC.propData.getProperty("chat.search.placeholder"));
		softAssert.assertTrue(chatsPage.isChatListDisplayed());
		softAssert.assertTrue(chatsPage.isChatRecipientLastMessageDisplayed());
		softAssert.assertTrue(chatsPage.isChatRecipientImageDisplayed());
		chatsPage.sendRecipientNameInSearchTextbox(AtomHC.propData.getProperty("chat.valid.search.word"));
		softAssert.assertTrue(chatsPage.isChatRecipientSearchedNameDisplayed());
		driver.navigate().refresh();
		softAssert.assertTrue(chatsPage.isChatRecipientLastMessageDisplayed());
		softAssert.assertTrue(chatsPage.isChatRecipentUnreadMessageBatchCountDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testChatRecipientWithInactiveRelation() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.sendRecipientNameInSearchTextbox(AtomHC.propData.getProperty("search.recipient.inactive.relation"));
		chatsPage.clickOnRecipientWithInactiveRelation();
		log("verify if patient with inactive relation has existing messages");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(chatsPage.getchatRecipientRelationInactiveMessage(),
				AtomHC.propData.getProperty("chat.relation.inactive.message"));
		softAssert.assertTrue(chatsPage.isChatInActiveRecipientMessageDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testChatsSearchTextboxScenarios() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.sendRecipientNameInSearchTextbox(AtomHC.propData.getProperty("chat.valid.search.word"));
		log("verify if searched patient name is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(chatsPage.isChatRecipientSearchedNameDisplayed());
		chatsPage.clearSearchTextbox();
		chatsPage.sendRecipientNameInSearchTextbox(AtomHC.propData.getProperty("chat.invalid.search.word"));
		log("verify if error message is displayed, if no record is found");
		softAssert.assertEquals(chatsPage.getChatSearchNoDataMessage(),
				AtomHC.propData.getProperty("chat.search.no.record.message"));
		chatsPage.clearSearchTextbox();
		softAssert.assertAll();
	}

	@Test
	public void testExistingChatIfReceipentHasPermission() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatRecipentWithMsg();
		log("verify if existing messages are played if user has permission to open chat");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(chatsPage.isChatRightColumnDisplayed());
		softAssert.assertTrue(chatsPage.isChatRecipientLastMessageDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testUserLandsOnAddReceipentPageAferClickingOnAddButton() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatAddButton();
		log("verify user navigates to chat add page");
		assertEquals(chatsPage.getNewChatPageTitle(), AtomHC.propData.getProperty("chat.add.page.title"));
	}

	@Test
	public void testChatsNoRecordView() throws Exception {
		log("Create new organization");
		LoginTests loginTest = new LoginTests();
		loginTest.testUserAbleToFillRegisterSetupPage();
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		Chats chatsPage = new Chats(driver);
		mainPage.clickOnOrginazationTab();
		chatsPage.clickOnMenuChatsTab();
		log("verify if error message is displayed if there is no chat record");
		assertEquals(chatsPage.getChatsViewNoData(), AtomHC.propData.getProperty("chat.no.data"));
	}

//NewChat
	@Test
	public void testNewChatPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		mainPage.clickOnOrginazationTab();
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatAddButton();
		log("verify new chat page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(chatsPage.getNewChatPageTitle(), AtomHC.propData.getProperty("chat.add.page.title"));
		softAssert.assertTrue(chatsPage.isNewChatCrossIconDisplayed());
		softAssert.assertTrue(chatsPage.isChatSearchtextboxDisplayed());
		softAssert.assertEquals(chatsPage.getChatSearchPlaceholder(),
				AtomHC.propData.getProperty("chat.add.page.search.placeholder"));
		softAssert.assertTrue(chatsPage.isNewChatPatientListDisplayed());
		softAssert.assertTrue(chatsPage.isNewChatPatientProfileIconDisplayed());
		softAssert.assertTrue(chatsPage.isNewChatPatientNameDisplayed());
		softAssert.assertAll();
	}

	@Test
	public void testIfUserClickOnCrossIconItLandsOnRecepientListPage() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		mainPage.clickOnOrginazationTab();
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatAddButton();
		chatsPage.clickOnAttachFileCrossIcon();
		log("verify after clicking on cross icon, user lands on patient list page");
		assertEquals(chatsPage.getChatPageTitle(), AtomHC.propData.getProperty("chat.page.title"));
	}

	@Test
	public void testNewChatPageSearchEvents() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		mainPage.clickOnOrginazationTab();
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatAddButton();
		chatsPage.sendRecipientNameInNewChatSearchTextbox(AtomHC.propData.getProperty("search.new.recepient"));
		log("verify if searched patient name is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(chatsPage.isNewChatSearchedPatientNameDisplayed());
		chatsPage.clearNewChatSearchTextbox();
		chatsPage.sendRecipientNameInNewChatSearchTextbox(AtomHC.propData.getProperty("search.invalid.patient"));
		log("verify error message is displayed for invalid data");
		softAssert.assertEquals(chatsPage.getChatSearchNoDataMessage(),
				AtomHC.propData.getProperty("new.chat.search.error.message"));
		softAssert.assertAll();
	}

	@Test
	public void testIfRecepientDetailPageIsVisible() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		mainPage.clickOnOrginazationTab();
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnChatAddButton();
		chatsPage.clickOnPatientprofileFromNewChatPage();
		log("verify if patient detail page is displayed");
		assertTrue(chatsPage.isNewChatPatientDetailDisplayed());
	}

//Chat Detail
	@Test
	public void testChatDetailPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPatientsChat();
		log("verify if existing messages are played if user has permission to open chat");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(chatsPage.isChatRightColumnDisplayed());
		softAssert.assertTrue(chatsPage.isChatDetailPatientProfileDisplayed());
		softAssert.assertTrue(chatsPage.isChatDetailPatientNameDisplayed());
		softAssert.assertTrue(chatsPage.isChatRecipientLastMessageDisplayed());
		softAssert.assertTrue(chatsPage.isChatDetailPlusIconDisplayed());
		softAssert.assertTrue(chatsPage.isChatDetailTextboxDisplayed());
		softAssert.assertTrue(chatsPage.isChatDetailSendButtonDisplayed());
		softAssert.assertEquals(chatsPage.getChatDetailTextboxPlaceholder(),
				AtomHC.propData.getProperty("chat.detail.textbox.placeholder"));
		softAssert.assertEquals(chatsPage.getChatsDetailSendButtonCaption(),
				AtomHC.propData.getProperty("chat.detail.send.button"));
		softAssert.assertAll();
	}

	@Test
	public void testChatDetailAttachFileFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPlusIcon();
		chatsPage.clickOnChatDeatilPatient();
		chatsPage.clickOnPatientPlusIcon();
		log("verify attach file page fields");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(chatsPage.getAttachFileTitle(), AtomHC.propData.getProperty("chat.attach.file.title"));
		softAssert.assertTrue(chatsPage.isAttachFileCrossIconDisplayed());
		chatsPage.uploadFileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.correct.image.format"));
		softAssert.assertEquals(chatsPage.getAddCaptionTitle(), AtomHC.propData.getProperty("chat.file.add.caption"));
		softAssert.assertTrue(chatsPage.isAddCaptionTextboxDisplayed());
		softAssert.assertEquals(chatsPage.getAddCaptionTextboxPlaceholder(),
				AtomHC.propData.getProperty("chat.detail.textbox.placeholder"));
		softAssert.assertEquals(chatsPage.getAttachFileSendButtonCaption(),
				AtomHC.propData.getProperty("chat.detail.send.button"));
		softAssert.assertAll();
	}

	@Test
	public void testChatDetailAttachFileCrossIconClick() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPatientsChat();
		chatsPage.clickOnPlusIcon();
		chatsPage.clickOnAttachFileCrossIcon();
		log("verify user lands on Chat Detail Page after clicking on cross icon");
		assertEquals(chatsPage.getChatPageTitle(), AtomHC.propData.getProperty("patient.chats.tabs.display"));
	}

	@Test
	public void testFieldsWhenFileIsSent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPlusIcon();
		chatsPage.clickOnChatDeatilPatient();
		chatsPage.clickOnPatientPlusIcon();
		chatsPage.uploadFileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.correct.image.format"));
		chatsPage.clickOnAtacchFileSendButton();
		log("verify if Time is displayed when an attachment is sent");
		assertTrue(chatsPage.isAttachFileMsgTimeDisplayed());
	}

	@Test(enabled=false)
	public void testFieldsWhenMsgIsSent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPatientsChat();
		chatsPage.sendTextMessageToNewRecipent(AtomHC.propData.getProperty("chat.text.msg"));
		chatsPage.clickOnChatSendButton();
		log("verify if Time is displayed when text msg is sent");
		assertTrue(chatsPage.isAttachFileMsgTimeDisplayed());
	}

	@Test(enabled=false)
	public void testFieldsWhenAMsgIsDeleted() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.clickOnPatientsChat();
		chatsPage.sendTextMessageToNewRecipent(AtomHC.propData.getProperty("chat.text.msg"));
		chatsPage.clickOnChatSendButton();
		chatsPage.clickOnDeleteIcon();
		log("verify fields when a message is deleted from chat");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(chatsPage.getMsgDeleteConfirmationMsg(),
				AtomHC.propData.getProperty("chat.delete.confirmation.msg"));
		softAssert.assertEquals(chatsPage.getDeleteConfirmationCancelButton(), AtomHC.propData.getProperty("chat.cancel.button"));
		softAssert.assertEquals(chatsPage.getDeleteConfirmationOkButton(), AtomHC.propData.getProperty("chat.ok.button"));
		chatsPage.clickOnCancelButton();
		softAssert.assertTrue(chatsPage.isChatDetailPatientProfileDisplayed());
		chatsPage.clickOnNewMsgSent();
		chatsPage.clickOnDeleteIcon();
		chatsPage.clickOnOkButton();
		softAssert.assertEquals(chatsPage.getItemDeletedMsg(), AtomHC.propData.getProperty("chat.item.deleted.msg"));
		softAssert.assertAll();
	}
}
