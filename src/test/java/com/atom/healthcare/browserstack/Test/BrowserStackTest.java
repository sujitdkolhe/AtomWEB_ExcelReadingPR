package com.atom.healthcare.browserstack.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atom.healthcare.Utils.BrowserStackBaseTest;
import com.atom.healthcare.Utils.PropertyFileLoader;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.page.objects.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.page.objects.TD_LoginPage.TD_LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BrowserStackTest extends BrowserStackBaseTest{

//	@Test
//	public void sampleTest1() throws InterruptedException {
//		Thread.sleep(10000);
//		HealthcareLogin healthcare = new HealthcareLogin(driver);
//		healthcare.selectEngilshLanguage();
//		healthcare.clickOnNextButton();
//		Thread.sleep(5000);
//		healthcare.clickOnNextButton();
//		Thread.sleep(2000);
//		healthcare.login("vishvareath@yopmail.com", "Admin@123");
//		Thread.sleep(10000);
//		healthcare.addTwoFactorAuthentication();
//	}
//
//	@Test
//	public void sampleTest2() throws InterruptedException {
//		Thread.sleep(10000);
//		HealthcareLogin healthcare = new HealthcareLogin(driver);
//		healthcare.selectEngilshLanguage();
//		healthcare.clickOnNextButton();
//		Thread.sleep(5000);
//		healthcare.clickOnNextButton();
//		Thread.sleep(2000);
//		healthcare.login("vishvareath@yopmail.com", "Admin@123");
//		Thread.sleep(10000);
//		healthcare.addTwoFactorAuthentication();
//	}
	
	@Test
	public void sampleTest1() throws InterruptedException {
		Thread.sleep(10000);
		AtomHealthcareMainPage p = new AtomHealthcareMainPage(driver);
		p.dependencies.click();
		p.buttons.click();
		p.buttons1.click();
	}

}
