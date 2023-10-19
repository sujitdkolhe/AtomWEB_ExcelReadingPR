package com.atom.healthcare.TD_InformedConsentWebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_InformedConsentsPageWebElement extends BasePageObject {
	private static TD_InformedConsentsPageWebElement infoCons = new TD_InformedConsentsPageWebElement(driver);

	private TD_InformedConsentsPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static TD_InformedConsentsPageWebElement getTD_InformedConsentsPage() {
		return infoCons;
	}

	@FindBy(how = How.ID, using = "UserConsentsViewNextActionKey")
	private WebElement informedConsentNextButton;

	public void clickOnInformedConsentNextButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, informedConsentNextButton);
		informedConsentNextButton.click();
	}
}
