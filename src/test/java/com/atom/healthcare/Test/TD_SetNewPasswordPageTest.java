package com.atom.healthcare.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.Utils.BaseTest;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.page.Pojo.CommonMethods;
import com.atom.healthcare.page.objects.TD_LoginPage.TD_LoginPage;
import com.atom.healthcare.page.objects.TD_SetNewPasswordPage.TD_SetNewPasswordPage;
import com.atom.healthcare.util.YopMail;

public class TD_SetNewPasswordPageTest extends BaseTest {
	@Test(priority = 1)
	public void testIfEnteringValidPassItNavigateToLoginPage() throws IOException, InterruptedException {
		CommonMethods commonMtd = new CommonMethods();
		try {
			log("Open web browser");
			BasePageObject.openWebBrowser(AHC.url);
			log("Get Email link");
			YopMail yopMail = new YopMail(AHC.webDriver);
			commonMtd.getDataForSetNewPassPage(getClassName(), "validPasswords");
			String url = yopMail.getLinkFromEmail(AHC.userName, "Your account has been created at", 5);
			log("Close Web browser");
			BasePageObject.closeWebBrowser();;
			BaseTest.openBrowserAppInMobile();
			BaseTest.getUrl(url);
			// Thread.sleep(10000);
			TD_SetNewPasswordPage setPasswordPage = new TD_SetNewPasswordPage(driver);
			setPasswordPage.setNewPassword(AHC.newPassword, AHC.confirmPassword);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		TD_LoginPage loginPage = new TD_LoginPage(driver);
		Assert.assertTrue(loginPage.isLoginPageDisplay());
	}
}
