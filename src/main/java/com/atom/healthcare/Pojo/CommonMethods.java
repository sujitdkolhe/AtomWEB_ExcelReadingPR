package com.atom.healthcare.Pojo;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Programs.Programs;
import com.atom.healthcare.TD_LoginWebElement.TD_LoginPageWebElement;
import com.atom.healthcare.TD_RegistrationWebElement.TD_RegistrationPageWebElement;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.PropertyFileLoader;
import com.atom.healthcare.util.YopMail;

public class CommonMethods extends BasePageObject {
	TD_LoginPageWebElement loginPage;
	TD_RegistrationPageWebElement registerPage;

	public CommonMethods(WebDriver driver) {
		super(driver);
	}
	
	public static String getVerificationCodeFromMail(String email) throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		log("Get verification code from mail");
		YopMail yopMail = new YopMail(driver);
		String verificationCode = yopMail.getVerificationCode(email, "Login verification code at ", 5);
		log("Verification code: " + verificationCode);
		driver.close();
		driver.switchTo().window(list.get(0));
		return verificationCode;
	}
	
	/*
	 * This method is to get data from "TD_PatientsPageTest" sheet
	 * it will compare scenario coloumn 10
	 */
	public static void getDataForCreatePatients(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[13].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.ptProfileImage= (String) getData[0];
				AtomHC.ptFirstName = (String) getData[1];
				AtomHC.ptMidName = (String) getData[2];
				AtomHC.ptLastName = (String) getData[3];
				AtomHC.ptGenderName = (String) getData[4];
				AtomHC.ptDOB = (String) getData[5];
				AtomHC.ptBloodGrp = (String) getData[6];
				AtomHC.ptPreferredLang = (String) getData[7];
				AtomHC.socialSecurNum = (String) getData[8];
				AtomHC.internalCode = (String) getData[9];
				AtomHC.externalCode = (String) getData[10];
				AtomHC.ptMobileNum = (String) getData[11];
				AtomHC.PtEmail = (String) getData[12];
			}
		}
	}
	
	/*
	 * This method is to get data from "TD_UserPageTest" sheet
	 * it will compare scenario coloumn 10
	 */
	public static void getDataForCreateUser(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[12].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.userImage= (String) getData[0];
				AtomHC.userFirstName = (String) getData[1];
				AtomHC.userMidName = (String) getData[2];
				AtomHC.userLastName = (String) getData[3];
				AtomHC.userGender = (String) getData[4];
				AtomHC.userDOJ = (String) getData[5];
				AtomHC.userRole = (String) getData[6];
				AtomHC.userProfession = (String) getData[7];
				AtomHC.userMobNumber = (String) getData[8];
				AtomHC.userEmail = (String) getData[9];
				AtomHC.setNewPassword = (String) getData[10];
				AtomHC.setConfirmPassword = (String) getData[11];
			}
		}
	}
	
	public static String getLinkFromMail() throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		log("Get verification code from mail");
		YopMail yopMail = new YopMail(driver);
		String link = yopMail.getLinkFromEmail(AtomHC.email, "Your account has been created at ", 5);
		log("Verification link: " + link);
		driver.close();
		driver.switchTo().window(list.get(0));
		return link;
	}
	
	public static String getLinkFromMail(String email) throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		log("Get verification code from mail");
		YopMail yopMail = new YopMail(driver);
		String link = yopMail.getLinkFromEmail(email, "Your account has been created at ", 5);
		log("Verification link: " + link);
		driver.close();
		driver.switchTo().window(list.get(0));
		return link;
	}
	
	public static String getRegistrationCodeFromMail(String email) throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		log("Get verification code from mail");
		YopMail yopMail = new YopMail(driver);
		String verificationCode = yopMail.getVerificationCode(email, "Registration code at ", 5);
		log("Verification code: " + verificationCode);
		driver.close();
		driver.switchTo().window(list.get(0));
		return verificationCode;
	}
	
	public static String getLoginVerificationCodeFromMail(String email) throws IOException, InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		log("Get verification code from mail");
		YopMail yopMail = new YopMail(driver);
		String verificationCode = yopMail.getVerificationCode(email, "Login verification code at", 5);
		log("Verification code: " + verificationCode);
		driver.close();
		driver.switchTo().window(list.get(0));
		return verificationCode;
	}
	
	public static void getScenarioTestClasses(String className) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
				AtomHC.internalClassName = (String) getData[0];
				AtomHC.methodName = (String) getData[1];
			}
		}
}
	