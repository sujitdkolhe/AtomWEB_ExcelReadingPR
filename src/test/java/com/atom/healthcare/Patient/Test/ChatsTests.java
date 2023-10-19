package com.atom.healthcare.Patient.Test;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Patients.Chats;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BaseTest;

public class ChatsTests extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("doctor.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("doctor.pswrd")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}

	// PatientChat
	@Test
	public void testPatientChatTabFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		chats.clickOnPatientChatTab();
		log("verify patient chat tab fields");
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(chats.getPatientChatTabHighlightedColor(),
				AtomHC.propData.getProperty("patient.chat.highlight.color"));
		softAssert.assertTrue(chats.isPatientChatMsgDisplay());
		softAssert.assertAll();
	}

	@Test
	public void testPatientChatDetailPageFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		TD_PatientsPage patient = new TD_PatientsPage(driver);
		patient.clickOnFirstPatient();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		log("verify if existing messages are played if user has permission to open chat");
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertTrue(chats.isChatDetailPatientProfileDisplayed());
		softAssert.assertTrue(chats.isChatDetailPatientNameDisplayed());
		softAssert.assertTrue(chats.isChatDetailPlusIconDisplayed());
		softAssert.assertTrue(chats.isChatDetailTextboxDisplayed());
		softAssert.assertEquals(chats.getChatDetailTextboxPlaceholder(),
				AtomHC.propData.getProperty("patient.chat.detail.textbox.placeholder"));
		softAssert.assertEquals(chats.getChatsDetailSendButtonCaption(),
				AtomHC.propData.getProperty("patient.chat.detail.send.button"));
		softAssert.assertAll();
	}

	@Test
	public void testPatientChatAttachFileFields() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		chats.clickOnPlusIcon();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(chats.getAttachFileTitle(), AtomHC.propData.getProperty("chat.attach.file.title"));
		softAssert.assertTrue(chats.isAttachFileCrossIconDisplayed());
		chats.uploadFileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.correct.image.format"));
		softAssert.assertEquals(chats.getAddCaptionTitle(), AtomHC.propData.getProperty("chat.file.add.caption"));
		softAssert.assertTrue(chats.isAddCaptionTextboxDisplayed());
		softAssert.assertEquals(chats.getAddCaptionTextboxPlaceholder(),
				AtomHC.propData.getProperty("chat.detail.textbox.placeholder"));
		softAssert.assertEquals(chats.getAttachFileSendButtonCaption(), AtomHC.propData.getProperty("chat.detail.send.button"));
		softAssert.assertAll();
	}

	@Test
	public void testPatientChatAttachFileCrossIconClick() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		chats.clickOnPlusIcon();
		chats.clickOnAttachFileCrossIcon();
		log("verify user lands on Chat Detail Page after clicking on cross icon");
		assertTrue(chats.isChatDetailPatientProfileDisplayed());
	}

	@Test
	public void testpatientChatFieldsWhenFileIsSent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		chats.clickOnPlusIcon();
		chats.uploadFileImage(
				System.getProperty("user.dir") + AtomHC.propData.getProperty("education.correct.image.format"));
		chats.clickOnAttachFileSendButton();
		log("verify if Time is displayed when an attachment is sent");
		assertTrue(chats.isAttachFileMsgTimeDisplayed());
	}

	@Test
	public void testPatientChatFieldsWhenMsgIsSent() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		chats.patientChatSendMsg(AtomHC.propData.getProperty("chat.text.msg"));
		chats.clickOnChatSendButton();
		log("verify if Time is displayed when text msg is sent");
		assertTrue(chats.isAttachFileMsgTimeDisplayed());
	}

	@Test
	public void testPatientChatFieldsWhenAMsgIsDeleted() throws Exception {
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Chats chats = new Chats(driver);
		mainPage.clickOnPatientsTab();
		chats.clickOnChatPatient();
		chats.clickOnPatientChatTab();
		chats.patientChatSendMsg(AtomHC.propData.getProperty("chat.text.msg"));
		chats.clickOnChatSendButton();
		chats.clickOnNewMsgSent();
		chats.clickOnDeleteIcon();
		log("verify fields when a message is deleted from chat");
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(chats.getMsgDeleteConfirmationMsg(), AtomHC.propData.getProperty("chat.delete.confirmation.msg"));
		softAssert.assertEquals(chats.getDeleteConfirmationCancelButton(), AtomHC.propData.getProperty("chat.cancel.button"));
		softAssert.assertEquals(chats.getDeleteConfirmationOkButton(), AtomHC.propData.getProperty("chat.ok.button"));
		chats.clickOnCancelButton();
		softAssert.assertTrue(chats.isChatDetailPatientProfileDisplayed());
		chats.clickOnNewMsgSent();
		chats.clickOnDeleteIcon();
		chats.clickOnDeleteOkButton();
		softAssert.assertEquals(chats.getItemDeletedMsg(), AtomHC.propData.getProperty("chat.item.deleted.msg"));
	}
}
