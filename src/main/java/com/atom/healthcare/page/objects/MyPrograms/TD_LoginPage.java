package com.atom.healthcare.page.objects.MyPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TD_LoginPage extends BasePageObject {

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"PatientProgramPage.A1PrimaryMediumBoldCenter\"]")
	public WebElement myProgramTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	public WebElement saveButton;

	@AndroidFindBy(className = "android.view.ViewGroup")
	public WebElement programList;

	@AndroidFindBy(accessibility = "PatientProgramPage.A1324")
	public WebElement programName;

	@AndroidFindBy(accessibility = "PatientProgramPage.A1ImagePersonalHealth.MobileClient.Images.Back.svg")
	public WebElement backArrow;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[5]")
	public WebElement programColorIcon;
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Readings\"]/android.widget.ImageView")
	public WebElement cancelButton;
	
	public TD_LoginPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public String getMyProgramText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, myProgramTab);
		return myProgramTab.getText();
	}

	public String getSaveButtonText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, saveButton);
		return saveButton.getText();
	}

	public boolean isProgramListDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, programList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, programList);
			isPresent = programList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSaveButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, programList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, saveButton);
			isPresent = saveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isProgramNameDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, programList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, programName);
			isPresent = programName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBackArrowDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, backArrow);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, backArrow);
			isPresent = backArrow.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnProgramColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, programColorIcon);
		programColorIcon.click();
	}
	
	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, cancelButton);
		cancelButton.click();
	}
	
	public boolean isProgramColorDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, programColorIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, 10, programColorIcon);
			isPresent = programColorIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

}
