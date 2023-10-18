package com.atom.healthcare.page.objects.TD_LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.util.TestConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TD_LoginPage extends BasePageObject {

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"en-IN\"])[5]")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
	public WebElement englishLang;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Next\"])[6]")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
	public WebElement nextButton;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"LoginPage.A1Username\"])[4]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"LoginPage.A1Username\"])[2]/android.view.ViewGroup/android.widget.EditText")
	public WebElement inputUserName;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"LoginPage.A1Password\"])[7]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"LoginPage.A1Password\"])[2]/android.view.ViewGroup/android.widget.EditText")
	public WebElement inputPassword;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Login\"])[6]")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public WebElement loginButton;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='InitializationPage.A1ClientErrorLabel'])[14]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup)[2]")
	public WebElement passwordRequiredMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"InitializationPage.A1ClientErrorLabel\"])[10]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup)[1]")
	public WebElement usernameRequiredMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"InitializationPage.A1ServerErrorLabel\"])[3]")
	@AndroidFindBy(accessibility = "InitializationPage.A1ServerErrorLabel")
	public WebElement yourDataIsInvalidMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"InitializationPage.A1ServerErrorLabel\"])[3]")
	@AndroidFindBy(accessibility = "InitializationPage.A1ServerErrorLabel_Container")
	public WebElement permissionMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"InitializationPage.A1ClientErrorLabel\"])[14]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup)[1]")
	public WebElement minimumPassLengthMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"InitializationPage.A1ClientErrorLabel\"])[10]")
	@AndroidFindBy(xpath = "(//android.view.ViewGroup)[2]")
	public WebElement minimumUsernameLengthMsg;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='LoginPage.A1PrimaryMediumBoldCenter'])[6]")
	@AndroidFindBy(accessibility = "LoginPage.A1PrimaryMediumBoldCenter")
	public WebElement twoFactorAuthHeader;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"PincodePage.A1PrimaryMediumBoldCenter\"])[6]")
	@AndroidFindBy(accessibility = "PincodePage.A1PrimaryMediumBoldCenter")
	public WebElement pincodeSetupHeader;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"PincodePage.A1PrimaryMediumBoldCenter\"])[6]")
	@AndroidFindBy(accessibility = "PincodePage.A1PrimaryMediumBoldCenter")
	public WebElement confirmPincodeHeader;

	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	public WebElement two;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Next\"])[2]")
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
	public WebElement welcomeScreenNextButton;

	public TD_LoginPage(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterUsernameAndPassword(String username, String pass) throws InterruptedException {
		log("Enter username to Patient");
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, inputUserName);
		try {
			inputUserName.sendKeys(username);
		} catch (Exception e) {
			log("username is blank");
		}
		try {
			inputPassword.sendKeys(pass);
		} catch (Exception e) {
			log("Password is blank");
		}
		loginButton.click();

	}

	public void selectEngilshLanguage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, englishLang);
		englishLang.click();
	}

	public void clickOnNextButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, nextButton);
		nextButton.click();
	}

	public String getEnglishLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, englishLang);
		return englishLang.getText();
	}

	public void selectPreferedLanguage(String language) throws InterruptedException {
		log("Select Language");
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver, 10,
					driver.findElementByXPath("//android.widget.TextView[@text='" + language + "']"));
			WebElement lang = driver.findElementByXPath("//android.widget.TextView[@text='" + language + "']");
		} catch (Exception e) {
			englishLang.click();
		}
		nextButton.click();
	}

	public boolean isLoginPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, loginButton);
		boolean isPresent = false;
		try {
			isPresent = loginButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Login button was not display");
			return isPresent;
		}
	}

	public void clickOnWelcomeNextButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, welcomeScreenNextButton);
		for (int i = 0; i <= 2; i++) {
			try {
				welcomeScreenNextButton.click();
			} catch (NoSuchElementException e) {
				log("Move from Welcome screen");
			}
		}
	}

	public void clearUsernameAndPassword() throws InterruptedException {
		log("clear username and password");
		TestConfig.PrintMethodName();
		waitForElement(driver, 60, inputUserName);
		inputUserName.clear();
		inputPassword.clear();
	}

	public boolean isTwoFactorAuthPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, twoFactorAuthHeader);
		boolean isPresent = false;
		try {
			isPresent = twoFactorAuthHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Two Factor AuthHeader was not display");
			return isPresent;
		}
	}

	public boolean isPincodeSetupPageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, pincodeSetupHeader);
		boolean isPresent = false;
		try {
			isPresent = pincodeSetupHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Pincode setup was not display");
			return isPresent;
		}
	}

	public boolean isConfirmPincodePageDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, confirmPincodeHeader);
		boolean isPresent = false;
		try {
			isPresent = confirmPincodeHeader.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Confirm pincode was not display");
			return isPresent;
		}
	}

	public void addPincodeSetupCode(String pincodeSetupCode) {
		TestConfig.PrintMethodName();
		WebElement number;
		log("Add Pincode setup code");
		for (int i = 0; i < 5; i++) {
			char pin = pincodeSetupCode.charAt(i);
			if (AHC.platformName.equals("Android")) {
				waitForElement(driver, 10, driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]")));
				number = driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]"));
			} else {
				waitForElement(driver, 10,
						driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]")));
				number = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]"));
			}
			number.click();
		}
	}

	public void addConfirmPincode(String confirmPincode) {
		TestConfig.PrintMethodName();
		WebElement number;
		for (int i = 0; i < 5; i++) {
			char pin = confirmPincode.charAt(i);
			if (AHC.platformName.equals("Android")) {
				waitForElement(driver, 10, driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]")));
				number = driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]"));
			} else {
				waitForElement(driver, 10,
						driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]")));
				number = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]"));
			}
			number.click();
		}
	}

	public void addTwoFactorAuthentication(String vCode) throws InterruptedException {
		TestConfig.PrintMethodName();
		WebElement twoFactorboxes;
		for (int i = 0; i < 5; i++) {
			char pin = vCode.charAt(i);
			if (AHC.platformName.equals("Android")) {
				waitForElement(driver, 10, driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]")));
				twoFactorboxes = driver.findElement(By.xpath("(//android.widget.Button)[" + pin + "]"));
			} else {
				waitForElement(driver, 10,
						driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]")));
				twoFactorboxes = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='" + pin + "'])[5]"));
			}
			twoFactorboxes.click();
		}
	}

	public boolean isPasswordRequiredMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, passwordRequiredMsg);
		boolean isPresent = false;
		try {
			isPresent = passwordRequiredMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Password requird message is not visible");
			return isPresent;
		}
	}

	public boolean isUserNameRequiredMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, usernameRequiredMsg);
		boolean isPresent = false;
		try {
			isPresent = usernameRequiredMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Username requird message is not visible");
			return isPresent;
		}
	}

	public boolean isYourDataIsInvalidMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, yourDataIsInvalidMsg);
		boolean isPresent = false;
		try {
			isPresent = yourDataIsInvalidMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Your data is invalid is not visible");
			return isPresent;
		}
	}

	public boolean isPermissionMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, permissionMsg);
		boolean isPresent = false;
		try {
			isPresent = permissionMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("permission messsgae is not visible");
			return isPresent;
		}
	}

	public boolean isMinimumPassLengthMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, minimumPassLengthMsg);
		boolean isPresent = false;
		try {
			isPresent = minimumPassLengthMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Minimum password length message is not visible");
			return isPresent;
		}
	}

	public boolean isMinimumUserNameLengthMsgDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, 10, minimumUsernameLengthMsg);
		boolean isPresent = false;
		try {
			isPresent = minimumUsernameLengthMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Minimum username length message is not visible");
			return isPresent;
		}
	}

	public void clearUsernamAndPasswordTextbox() {
		log("clear username and password");
		TestConfig.PrintMethodName();
		if (AHC.platformName.equals("Android")) {
			waitForElement(driver, 60, inputUserName);
			inputUserName.clear();
			inputPassword.clear();
		} else {

			String userName = driver
					.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"LoginPage.A1Username\"])[4]")).getText();
			int userNameChar = userName.length();
			for (int i = 0; i < userNameChar; i++) {
				if (userName.equals(null)) {
					break;
				}
				inputUserName.sendKeys(Keys.BACK_SPACE);
			}

			String password = driver
					.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"LoginPage.A1Password\"])[7]")).getText();
			int passwordChar = password.length();
			for (int i = 0; i < passwordChar; i++) {
				if (password.equals(null)) {
					break;
				}
				inputPassword.sendKeys(Keys.BACK_SPACE);
			}
		}
	}
//	String clear=Keys.chord(Keys.CONTROL," ")+Keys.DELETE+Keys.BACK_SPACE;
//	inputUserName.sendKeys(clear);
//	inputUserName.sendKeys(Keys.BACK_SPACE);
//	inputPassword.sendKeys(clear);
//	inputPassword.sendKeys(Keys.BACK_SPACE);

}
