package com.atom.healthcare.page.objects.TD_SetNewPasswordPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.util.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TD_SetNewPasswordPage extends BasePageObject {

	@AndroidFindBy(accessibility = "InitializationPage.A1BeforeLoginHeaderWithNoTopMargin_Container")
	public WebElement setNewPasswordLabel;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"ResetPasswordPage.A1New password\"])[1]")
	public WebElement newPassword;
	
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"ResetPasswordPage.A1Confirm password\"])[1]")
	public WebElement confirmPassword;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='PincodePage.A1PrimaryWithMargin']")
	public WebElement setButton;
	
	public TD_SetNewPasswordPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void setNewPassword(String newPass, String confPass) {
		TestConfig.PrintMethodName();
		waitForElement(driver, 50, newPassword);
		log("Enter new password and new Password");
		newPassword.sendKeys(newPass);
		confirmPassword.sendKeys(confPass);
		setButton.click();
	}

}
