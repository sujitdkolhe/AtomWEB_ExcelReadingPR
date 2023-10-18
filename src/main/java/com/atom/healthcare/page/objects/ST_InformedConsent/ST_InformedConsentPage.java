package com.atom.healthcare.page.objects.ST_InformedConsent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ST_InformedConsentPage extends BasePageObject {

	@AndroidFindBy(accessibility = "PincodePage.A1BeforeLoginHeaderWithNoTopMargin")
	public WebElement informedConsentHeader;

	@AndroidFindBy(accessibility = "UserConsentsPage.A1LinkLabelSmallLeft")
	public WebElement consentPageTitle;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
	public WebElement nextButton;

	@AndroidFindBy(accessibility = "UserConsentsPage.A1MessageControlMediumCenter")
	public WebElement consentPageAcceptTitle;

	@AndroidFindBy(accessibility = "StaticMessagePage.A1PrimaryWithoutMargin")
	public WebElement acceptButton;

	public ST_InformedConsentPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public boolean isInformedConsentHeaderDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, informedConsentHeader);
		boolean isPresent = false;
		try {
			isPresent = informedConsentHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Informed Consent Header was not display");
			return isPresent;
		}
	}

	public boolean isConsentPageTitleDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, consentPageTitle);
		boolean isPresent = false;
		try {
			isPresent = consentPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Consent Page title was not display");
			return isPresent;
		}
	}

	public boolean isConsentPageAcceptTitleDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, consentPageAcceptTitle);
		boolean isPresent = false;
		try {
			isPresent = consentPageAcceptTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Consent Page title was not display");
			return isPresent;
		}
	}

	public void clickOnConsentPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, consentPageTitle);
		consentPageTitle.click();
	}

	public void clickOnNextButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, nextButton);
		nextButton.click();
	}

	public void clickOnAcceptButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, acceptButton);
		acceptButton.click();
	}

}
