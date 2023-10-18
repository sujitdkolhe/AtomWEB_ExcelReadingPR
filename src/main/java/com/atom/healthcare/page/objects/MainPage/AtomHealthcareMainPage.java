package com.atom.healthcare.page.objects.MainPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AtomHealthcareMainPage extends BasePageObject {

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"More\"]/android.widget.ImageView")
	public WebElement moreButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Programs']")
	public WebElement myProgramTab;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"AlertControllerViewController\"]")
	public WebElement dependencies;

	@AndroidFindBy(className = "android.widget.Button")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Text Entry']")
	public WebElement buttons;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"DashboardPage.A1PrimaryMediumBoldCenter\"]")
	public WebElement dashboardTitle;
	
	@AndroidFindBy(className = "android.widget.Button")
	@iOSXCUITFindBy(xpath="**//XCUIElementTypeStaticText['label**']")
	public WebElement buttons1;
	
	
//	public AtomHealthcareMainPage(AppiumDriver driver) {
//		super(driver);
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}
	
	public AtomHealthcareMainPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//ios Demo
	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"AlertControllerViewController\"]")
//	public WebElement dependencies;
//
//	@AndroidFindBy(className = "android.widget.Button")
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Text Entry']")
//	public WebElement buttons;
//
//	@AndroidFindBy(className = "android.widget.Button")
//	@iOSXCUITFindBy(xpath="**//XCUIElementTypeStaticText['label**']")
//	public WebElement buttons1;
	
	public void clickOnMoreButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, moreButton);
		moreButton.click();
	}
	
	public void clickOnMyProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, myProgramTab);
		myProgramTab.click();
	}
	
	public boolean isDashboardTitleDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, dashboardTitle);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, dashboardTitle);
			isPresent = dashboardTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Dashboard title is not visible");
			return isPresent;
		}
	}
	
	
}