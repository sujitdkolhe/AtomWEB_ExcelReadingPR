package com.atom.healthcare.TD_SetNewPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_SetNewPasswordPage extends BasePageObject {
	@FindBy(how = How.ID, using = "SetNewPasswordViewNewPasswordKeyinput-text")
	private WebElement newPassowrdInput;
	
	@FindBy(how = How.ID, using = "SetNewPasswordViewConfirmPasswordKeyinput-text")
	private WebElement confirmPassowrdInput;
	
	@FindBy(how = How.ID, using = "SetNewPasswordViewSetButtonKey")
	private WebElement setButton;
	
	public TD_SetNewPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public void setNewPassword(String newPassowrd, String confirmPassword) {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPassowrdInput);
		newPassowrdInput.sendKeys(newPassowrd);
		confirmPassowrdInput.sendKeys(confirmPassword);
		setButton.click();
	}
}
