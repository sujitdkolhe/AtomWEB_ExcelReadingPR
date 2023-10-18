package com.atom.healthcare.page.Pojo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Utils.BasePageObject;
import com.atom.healthcare.Utils.TestConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebAppMethods {
	JavascriptExecutor jse;
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[1]")
	private WebElement inputUserName;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])[2]")
	private WebElement inputPassword;

	@FindBy(how = How.XPATH, using = "//button[text()='Login']")
	private WebElement buttonLogin;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded  ltr'])")
	private WebElement verificationCode;

	@FindBy(how = How.ID, using = "SMSAuthenticationViewVerifyActionKey")
	private WebElement verifyButton;

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenu")
	private WebElement orginazationTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.ID, using = "PatientAddEditFirstNameKeyinput-text")
	private WebElement firstNameInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Last name']")
	private WebElement lNameLabel;

	@FindBy(how = How.ID, using = "PatientAddEditLastNameKeyinput-text")
	private WebElement lastNameInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Gender']")
	private WebElement ganderLabel;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyinput-text")
	private WebElement genderInput;

	@FindBy(how = How.XPATH, using = "//label[text()='DOB']")
	private WebElement dobLabel;

	@FindBy(how = How.ID, using = "PatientAddEditDateOfBirthKeydatePicker")
	private WebElement dateOfBirthInput;

	@FindBy(how = How.XPATH, using = "//label[text()='Blood group']")
	private WebElement bloodGroupLabel;

	@FindBy(how = How.ID, using = "PatientAddEditBloodGroupKeyinput-text")
	private WebElement bloodGroupInput;

	@FindBy(how = How.XPATH, using = "//button[@class='header-text']")
	private WebElement monthHeader;

	@FindBy(how = How.XPATH, using = "//button[@class='prev']")
	private WebElement CalenderPrevButton;

	@FindBy(how = How.ID, using = "PatientAddEditPreferredLanguageKeyinput-text")
	private WebElement langPreferanceInput;

	@FindBy(how = How.ID, using = "PatientAddEditSocialSecurityNumberKeyinput-text")
	private WebElement securityNumber;

	@FindBy(how = How.XPATH, using = "//label[text()='Internal code']")
	private WebElement internalCodeLabel;

	@FindBy(how = How.ID, using = "PatientAddEditInternalCodeKeyinput-text")
	private WebElement internalCode;

	@FindBy(how = How.ID, using = "PatientAddEditExternalCodeKeyinput-text")
	private WebElement ExternalCode;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNumberInput;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement emailInput;

	@FindBy(how = How.ID, using = "PatientAddEditSaveActionKey")
	private WebElement patientSaveButton;
	
	WebDriver driver;
	
	public WebAppMethods(WebDriver driver) {
		this.driver=driver;
		jse = (JavascriptExecutor) AHC.webDriver;
		PageFactory.initElements(AHC.webDriver, this);
	}

	public void login(String username, String NewUserPass, String verificationKey)
			throws IOException, InterruptedException {
        TestConfig.PrintMethodName();
		inputUserName.sendKeys(username);
		inputPassword.sendKeys(NewUserPass);
		jse.executeScript("arguments[0].click();", buttonLogin);
		Thread.sleep(3000);
		verificationCode.sendKeys(verificationKey);
		jse.executeScript("arguments[0].click();", verifyButton);
		Thread.sleep(3000);
	}

	public void createNewPatient(String fName, String lName, String gender, String year, String month, String date,
			String bloodGroup, String langPref, String securityNum, String intCode, String extCode,
			int clickOnPrevButtonCount) throws IOException, InterruptedException {
		jse.executeScript("arguments[0].click();", orginazationTab);
		//Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", patientsTab);
		//Thread.sleep(1000);
		jse.executeScript("arguments[0].click();", addButton);
		BasePageObject.log("Adding patient details");
		TestConfig.PrintMethodName();
		//Thread.sleep(2000);
		firstNameInput.sendKeys(fName);
		lastNameInput.sendKeys(lName);
		jse.executeScript("arguments[0].click();", genderInput);
		WebElement selectGender = driver.findElement(By.xpath("//li[text()='" + gender + "']"));
		jse.executeScript("arguments[0].click();", selectGender);
		BasePageObject.scrollAndWait(0, 500, 2);
		BasePageObject.log("select date of birth");
		jse.executeScript("arguments[0].click();", dateOfBirthInput);
		jse.executeScript("arguments[0].click();", dateOfBirthInput);
		jse.executeScript("arguments[0].click();", monthHeader);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", monthHeader);
		Thread.sleep(1000);
		for (int i = 1; i <= clickOnPrevButtonCount; i++) {
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", CalenderPrevButton);
		}
		
		Thread.sleep(2000);
		WebElement selectYear = driver
				.findElement(By.xpath("//div[@class='datepicker-years']/div[2]/button[text()='" + year + "']"));
		jse.executeScript("arguments[0].click();", selectYear);
		Thread.sleep(2000);
		WebElement selectMonth = driver
				.findElement(By.xpath("//div[@class='datepicker-months']/div[2]/button[text()='" + month + "']"));
		
		jse.executeScript("arguments[0].click();", selectMonth);
		Thread.sleep(2000);
		WebElement selectDate = driver
				.findElement(By.xpath("//div[@class='datepicker-days']/div[3]/div/button[text()='" + date + "']"));
		
		jse.executeScript("arguments[0].click();", selectDate);
		Thread.sleep(3000);
		BasePageObject.log("DOB: " + month + " " + date + " " + year);
		BasePageObject.log("Select Blood group: " + bloodGroup);
		
		jse.executeScript("arguments[0].click();", bloodGroupInput);
		WebElement selectBloodGroup = driver.findElement(By.xpath("//li[text()='" + bloodGroup + "']"));
		jse.executeScript("arguments[0].click();", selectBloodGroup);
		
		BasePageObject.log("Select language preferance: " + langPref);
		
		jse.executeScript("arguments[0].click();", langPreferanceInput);
		Thread.sleep(3000);
		WebElement selectLangPref = driver.findElement(By.xpath("(//li[text()='" + langPref + "'])[2]"));
		jse.executeScript("arguments[0].click();", selectLangPref);
		securityNumber.sendKeys(securityNum);
		internalCode.sendKeys(intCode);
		ExternalCode.sendKeys(extCode);
		BasePageObject.log("Add mobile number and EmailId");
		long mobileNo = BasePageObject.generateMobileNumber();
		AHC.mobileNum = String.valueOf(mobileNo);
		AHC.email = BasePageObject.createRandomEmailAddress("alphamd", "yopmail.com");
		BasePageObject.log("EmailId: " + AHC.email);
		mobileNumberInput.sendKeys(AHC.mobileNum);
		emailInput.sendKeys(AHC.email);
		jse.executeScript("arguments[0].scrollIntoView(true);", patientSaveButton);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", patientSaveButton);
	}

	public void openBrowser(String url, AppiumDriver driver) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.closeApp();
		File appDir = new File(AHC.propData.getProperty("application.path"));// application path
		File app = new File(appDir, AHC.deviceName);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//HealthcareLogin health = new HealthcareLogin(driver);
		//health.selectEngilshLanguage();
		Thread.sleep(15000);
	}
}
