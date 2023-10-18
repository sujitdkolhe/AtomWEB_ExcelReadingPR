package com.atom.healthcare.page.Pojo;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.util.YopMail;

public class CommonMethods {

	public void getDataForSetNewPassPage(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[3].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AHC.userName = (String) getData[0];
				AHC.newPassword = (String) getData[1];
				AHC.confirmPassword = (String) getData[2];
			}
		}
	}
	
	public static String getVerificationCodeFromMail(String url) throws IOException, InterruptedException {
	BasePageObject.openWebBrowser(url);
	YopMail yopMail = new YopMail(AHC.webDriver);
	String verificationCode = yopMail.getVerificationCode(AHC.userName, "Login verification code at ", 5);
	AHC.webDriver.quit();
	return verificationCode;
}
}
