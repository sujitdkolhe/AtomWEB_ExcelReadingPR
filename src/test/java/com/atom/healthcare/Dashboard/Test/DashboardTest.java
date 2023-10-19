package com.atom.healthcare.Dashboard.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Chats.Chats;
import com.atom.healthcare.Dsahboard.Dashboard;
import com.atom.healthcare.Login.HealthcareLogin;
import com.atom.healthcare.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.OrgnizationSetup.OrgnizationSetup;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.Register.TD_RegistrationPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BaseTest;

public class DashboardTest extends BaseTest {
	HealthcareLogin loginPage;
	TD_RegistrationPage registerPage;
	
	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		HealthcareLogin loginPage = new HealthcareLogin(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("user2"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("pass1")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}
	
	@Test
	public void testUserLandOnDashboardPage() throws Exception{
		CommonMethods cm = new CommonMethods(driver);
		log("Adding Registration forms details");
		cm.registerAsOrgnization();
		registerPage = new TD_RegistrationPage(driver);
		log("Send valid verification code");
		registerPage.sendVerificationCode(AtomHC.propData.getProperty("atom.verification.key"));
		registerPage.clickOnVerifyButton();
		OrgnizationSetup orgSetup = new OrgnizationSetup(driver);
		BasePageObject basePageObj = new BasePageObject(driver);
		String orgnizationName = "AlphaMD" + BasePageObject.createRandomCharacter(4);
		String domainName = "www.medical" + BasePageObject.createRandomCharacter(4) + ".com";
		log("Orgnization Name: " + orgnizationName + "    Domain Name: " + domainName);
		orgSetup.enterRegistrationSetupDetails(orgnizationName, domainName, basePageObj.generatRandomNum(), 2, 4);
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.getOrginizationName();
		log("verify after registration user lands on dashboard page");
		Dashboard dashboardPage = new Dashboard(driver);
		log("Page Title is "+dashboardPage.getDashboardTitleText());
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(dashboardPage.getDashboardTitleText(),AtomHC.propData.getProperty("dashboard.label"),
				"The Dashboard Title is not displayed");
		log("Dashboard Message is "+dashboardPage.isNoRecordsFoundMessage());
		softAssert.assertEquals(dashboardPage.isNoRecordsFoundMessage(), AtomHC.propData.getProperty("no.record.found.msg "),
				"The No Records message is not displayed");
		softAssert.assertAll();
	}
	
	@Test
	public void testConfigurationFeaturesIsDisplayedInSequence() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		dashboardPage.clickOnConfigureButton();
		dashboardPage.clickOnRolesDropdown();
		dashboardPage.selectAdminRole();
		dashboardPage.clickOnAddButton();
		dashboardPage.createAppointmentFeatures(AtomHC.propData.getProperty("dash.seq1"),AtomHC.propData.getProperty("dash.pram1"));
		dashboardPage.clickOnAddButton();
		dashboardPage.createChatsFeatures(AtomHC.propData.getProperty("dash.seq2"),AtomHC.propData.getProperty("dash.pram1"));
		dashboardPage.clickOnAddButton();
		dashboardPage.createPatientsFeatures(AtomHC.propData.getProperty("dash.seq3"),AtomHC.propData.getProperty("dash.pram1"));
		dashboardPage.clickOnCancelButton();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(dashboardPage.isAppointmentTitleDisplay());
		softAssert.assertTrue(dashboardPage.isChatsTitleDisplay());
		softAssert.assertTrue(dashboardPage.isPatientsTitleDisplay());
		softAssert.assertAll();
	}
	
	@Test
	public void testSystemEnteringParameterValueOfUsersFeatureInDashboard() throws Exception {
		Dashboard dashboardPage = new Dashboard(driver);
		String usersTitle = dashboardPage.getUsersCount();
		String getTitle = usersTitle;
		log("Users Count is: "+ getTitle.substring(0));	
		dashboardPage.clickOnConfigureButton();
		dashboardPage.clickOnRolesDropdown();
		dashboardPage.selectAdminRole();
		dashboardPage.clickOnUsersFeaturesOfAdminRole();
		log("verify System change parameter value of User");
		dashboardPage.changeUsersParameterValue(AtomHC.propData.getProperty("users.param"));
		dashboardPage.clickOnSaveButton();
		dashboardPage.clickOnCancelButton();
		log("Users Count is: " + dashboardPage.getUsersCount());
		assertEquals(dashboardPage.getUsersCount(),AtomHC.propData.getProperty("users.count"),
				"The Users count is wrong");
	}
	
	@Test
	public void testItDisplayDataIsNotFoundtIfFeaturesHasNoData() throws Exception {
		Dashboard dashboardPage = new Dashboard(driver);
		log("Message is: "+dashboardPage.getNoRecordMessageOfAppointment());
		log("verify Changed Sequence No of Admin Features page");
		dashboardPage.changePatientSequenceNumber(AtomHC.propData.getProperty("feature.patient.sequence"));
		log("Patient seq is: "+dashboardPage.getPatientSequenceNumber());
		assertEquals(dashboardPage.getPatientSequenceNumber(),AtomHC.propData.getProperty("feature.patient.sequenceNo"),
				"The Sequence Number is wrong");
	}

	@Test
	public void testUserCanDeleteFeaturesOfAnyRoles() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		dashboardPage.clickOnConfigureButton();
		dashboardPage.clickOnRolesDropdown();
		dashboardPage.selectAdminRole();
		log("verify User add caregiver features");
		SoftAssert softAssert = new SoftAssert();
		dashboardPage.AddCaregiversFeaturesOfAdminRole(AtomHC.propData.getProperty("caregiver.seq.no"),
				AtomHC.propData.getProperty("caregiver.param"));
		softAssert.assertTrue(dashboardPage.isCaregiverFeaturesDisplay());
		log("verify User delete the caregiver features");
		dashboardPage.deleteCaregiversFeaturesOfAdminRole();
		dashboardPage.clickOnDeleteButton();
		dashboardPage.deletePopupWindow();
		softAssert.assertFalse(dashboardPage.isCaregiverFeaturesDisplay());
		softAssert.assertAll();
	}
	
	//Caregiver Dashboard Chats
	@Test
	public void testDashboardChatFields() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		log("verify fields of Chat column on Provider's Dashboard");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(dashboardPage.getDashboardChatTitle(),AtomHC.propData.getProperty("dashboard.chat.title"));
	    softAssert.assertTrue(dashboardPage.isChatShowMoreButtonDisplayed());
	    softAssert.assertTrue(dashboardPage.isChatPatientProfileImageDisplayed());
	    softAssert.assertTrue(dashboardPage.isChatPatientProfileNameDisplayed());
	    softAssert.assertTrue(dashboardPage.isChatMsgDisplayed());
	    softAssert.assertTrue(dashboardPage.isChatPatientBadgeCountDisplayed());
	    softAssert.assertAll();
}
	
	@Test
	public void testFieldsWhenUserClickOnChatShowMoreButton() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		dashboardPage.clickOnChatShowMoreButton();
		log("verify user lands on Chats Page, after clicking on Show More Button");
		assertEquals(dashboardPage.getChatPageTitle(),AtomHC.propData.getProperty("chat.page.title"));
}
	@Test
	public void testFieldsWhenUserClickOnAnyChatOnDashboard() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		dashboardPage.clickOnChatPatient();
		log("verify user lands on Chat Detail Page, after clicking on patient profile in dashboard");
		assertTrue(dashboardPage.isChatDetailPageDisplayed());
}
	@Test
	public void testChatNoRecordViewOnDashboard() throws Exception{
		Dashboard dashboardPage = new Dashboard(driver);
		log("veirfy chat no record message is visible, if there is not chat record");
		assertEquals(dashboardPage.getChatNoRecordMsg(),AtomHC.propData.getProperty("chat.no.record.msg"));
}
	@Test
	public void testLatestChatPatientShouldBeVisibleOnTopInDashboard() throws Exception{
		AtomHealthcareMainPage mainPage = new AtomHealthcareMainPage(driver);
		mainPage.clickOnOrginazationTab();
		Dashboard dashboardPage = new Dashboard(driver);
		Chats chatsPage = new Chats(driver);
		chatsPage.clickOnMenuChatsTab();
		chatsPage.sendRecipientNameInSearchTextbox(AtomHC.propData.getProperty("search.latest.chat.patient"));
		chatsPage.clickOnChatDeatilPatient();
		chatsPage.sendTextMessageToNewRecipent(AtomHC.propData.getProperty("chat.text.msg"));
		chatsPage.clickOnChatSendButton();
		dashboardPage.clickOnDashboardMenuTab();
		log("Verify the patient with latest chat with provider is visible on top in provider dashboard");
		assertEquals(dashboardPage.getLatestChatPatientName(),AtomHC.propData.getProperty("latest.chat.patient.name"));
}
}

