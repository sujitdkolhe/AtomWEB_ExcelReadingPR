package com.atom.healthcare.Test;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.Dsahboard.Dashboard;
import com.atom.healthcare.MD_MasterDataWebElement.MD_MasterDataPageWebElement;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.TD_RegistrationWebElement.TD_RegistrationPageWebElement;
import com.atom.healthcare.TD_Users.TD_UsersPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;
import com.atom.healthcare.util.YopMail;

public class TD_UsersPageTest extends BasePageTestNG {

	public void testCreateSuperAdmin() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateSuperAdmin");
			log("Create SuperAdmin");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created Super admin is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "user profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userMidName + " " + AtomHC.userLastName),
				"SuperAdmin name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"SuperAdmin age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"SuperAdmin mobile number on card details iod not display");
		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
				"SuperAdmin Email on card details iod not display");
		softAssert.assertAll();
	}

	public void testCreateAdmin() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateAdmin");
			log("Create Admin");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created admin is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "Admin profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userLastName),
				"Admin name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"Admin age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"Admin mobile number on card details is not display");
//		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
//				"Admin Email on card details is not display");
		softAssert.assertAll();
	}

	public void testCreateDoctor() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateDoctor");
			log("Create Doctor");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created Doctor is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "Doctor profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userLastName),
				"Doctor name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"Doctor age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"Doctor mobile number on card details is not display");
//		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
//				"Doctor Email on card details is not display");
		softAssert.assertAll();
	}

	public void testCreateNurse() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateNurse");
			log("Create Nurse");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created Nurse is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "Nurse profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userLastName),
				"Nurse name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"Nurse age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"Nurse mobile number on card details is not display");
//		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
//				"Nurse Email on card details is not display");
		softAssert.assertAll();
	}

	public void testCreateFrontdesk() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateFrontdesk");
			log("Create Frontdesk");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created Frontdesk is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "Frontdesk profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userLastName),
				"Frontdesk name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"Frontdesk age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"Frontdesk mobile number on card details is not display");
//		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
//				"Frontdesk Email on card details is not display");
		softAssert.assertAll();
	}

	public void testCreateCareTaker() throws IOException, InterruptedException {
		TD_UsersPage userPage = new TD_UsersPage(driver);
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		userPage.clickOnUserTab();
		userPage.clickOnAddButton();
		try {
			CommonMethods.getDataForCreateUser(getClassName(), "CreateCareTaker");
			log("Create CareTaker");
			userPage.uploadProfileImage(System.getProperty("user.dir") + AtomHC.userImage);
			userPage.createUser(AtomHC.userFirstName, AtomHC.userMidName, AtomHC.userLastName, AtomHC.userGender,
					AtomHC.userDOJ, AtomHC.userRole, AtomHC.userProfession, AtomHC.userMobNumber, AtomHC.userEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created CareTaker is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(userPage.isUserProfilePictureDisplay(), "CareTaker profile is not display");
		softAssert.assertTrue(
				userPage.isUserNameDisplay(AtomHC.userFirstName + " " + AtomHC.userLastName),
				"CareTaker name is not display");
		softAssert.assertTrue(userPage.isUserGenderAndProfDisplay(AtomHC.userGender, AtomHC.userProfession),
				"CareTaker age and gendert is not display");
		softAssert.assertTrue(userPage.isUserMobileNumberDisplay(AtomHC.userMobNumber),
				"CareTaker mobile number on card details is not display");
//		softAssert.assertTrue(userPage.isUserEmailDisplay(AtomHC.userEmail),
//				"CareTaker Email on card details is not display");
		softAssert.assertAll();
	}

}