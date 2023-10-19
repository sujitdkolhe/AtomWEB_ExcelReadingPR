package com.atom.healthcare.MainPage;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class AlphaMDMainPage extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[@class='margin-top-xxs lbl-primary-text-header-5-semi-bold text-center']")
	private WebElement orginazationName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-secondary-text-body-medium-regular']")
	private WebElement orginazationDomainName;

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenu")
	private WebElement orginazationTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Questionnaires']")
	private WebElement questionnnairsTab;

	@FindBy(how = How.XPATH, using = "(//div[@id='LeftMenuOrganisationMenuAppointmentsView'])[1]")
	private WebElement appointmentTab;

	@FindBy(how = How.ID, using = "MasterPageLogout")
	private WebElement logout;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	public AlphaMDMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public AlphaMDMainPage(WebDriver driver, String url) {
		super(driver);
		if (url != null) {
			String sanitizedUrl = url.trim();
			driver.get(sanitizedUrl);
		}

		driver.manage().window().maximize();
		printCookies();
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		PageFactory.initElements(driver, this);
	}

	public void printCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		log("Printing Cookies -------", Level.DEBUG);
		for (Cookie c : cookies) {
			log(c.toString(), Level.DEBUG);
		}
		log("--------------------------", Level.DEBUG);
	}

	public String getOrginizationName() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(orginazationName);
		waitForElement(driver, orginazationName);
		return orginazationName.getText();
	}

	public String getOrginazationDomainName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, orginazationDomainName);
		return orginazationDomainName.getText();
	}

	public void clickOnOrginazationTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(orginazationTab);
		waitForElement(driver, orginazationTab);
		javascriptClick(orginazationTab);
	}

	public void clickOnQuestionnairsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnnairsTab);
		javascriptClick(questionnnairsTab);
	}

	public void clickOnAppointmentTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(appointmentTab);
		waitForElement(driver, appointmentTab);
		javascriptClick(appointmentTab);
	}

	public void logout() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, logout);
		Thread.sleep(2000);
		logout.click();
	}
	
	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientsTab);
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}
	
	public boolean isOrganisationDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, orginazationDomainName);
			isPresent = orginazationDomainName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Orgnasation page is not visible");
			return isPresent;
		}
	}

}
