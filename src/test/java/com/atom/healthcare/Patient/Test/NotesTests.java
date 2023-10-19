package com.atom.healthcare.Patient.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_Login.TD_LoginPage;
import com.atom.healthcare.TD_Registration.TD_RegistrationPage;
import com.atom.healthcare.util.BaseTest;

public class NotesTests  extends BaseTest {
	TD_LoginPage loginPage;
	TD_RegistrationPage registerPage;

	@BeforeMethod
	public void login() throws NullPointerException, InterruptedException {
		TD_LoginPage loginPage = new TD_LoginPage(driver, AtomHC.propData.getProperty("url"));
		log("Enter valid url: " + AtomHC.propData.getProperty("url"));
		driver.navigate().refresh();
		loginPage.login(AtomHC.propData.getProperty("admin.user"),
				AtomHC.key.getDecrypt(AtomHC.propData.getProperty("admin.pass")),
				AtomHC.propData.getProperty("atom.verification.key"));
	}
	@Test
	public void providernotes() {}
	

}
