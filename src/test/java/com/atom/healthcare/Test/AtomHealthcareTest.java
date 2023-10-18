package com.atom.healthcare.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_RegistrationWebElement.TD_RegistrationPageWebElement;
import com.atom.healthcare.Utils.BaseTest;
import com.atom.healthcare.Utils.PropertyFileLoader;
import com.atom.healthcare.Utils.YopMail;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.page.objects.MainPage.AtomHealthcareMainPage;
import com.atom.healthcare.page.objects.TD_LoginPage.TD_LoginPage;
import com.atom.healthcare.util.BasePageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AtomHealthcareTest extends BaseTest {

	@Test
	public void apiDemoTest(Method method) throws IOException, InterruptedException {
		Thread.sleep(10000);
		TD_LoginPage healthcare = new TD_LoginPage(driver);
		healthcare.selectEngilshLanguage();;
		healthcare.clickOnNextButton();
		Thread.sleep(5000);
		healthcare.clickOnNextButton();
		Thread.sleep(2000);
		healthcare.login("vishvareath@yopmail.com","Admin@123");
		//Thread.sleep(10000);
		healthcare.addTwoFactorAuthentication();
		
	}
	
	@Test
	public void apiDemoTest1(Method method) throws IOException, InterruptedException {
		Thread.sleep(10000);
		TD_LoginPage healthcare = new TD_LoginPage(driver);
		healthcare.selectEngilshLanguage();;
		healthcare.clickOnNextButton();
		Thread.sleep(5000);
		healthcare.clickOnNextButton();
		Thread.sleep(2000);
		healthcare.login("vishvareath@yopmail.com","Admin@123");
//		Thread.sleep(10000);
		healthcare.addTwoFactorAuthentication();
		
	}
	


}
