package com.atom.healthcare.Patients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Trackers  extends BasePageObject {

	@FindBy(how = How.XPATH, using = "(//label[text()='From date']/following::input)[1]")
	private WebElement taskFromDatePlaceholder;

	@FindBy(how = How.XPATH, using = "(//label[text()='End date']/following::input)[1]")
	private WebElement taskEndDatePlaceholder;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Trackers']")
	private WebElement patientTaskTab;
	
	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crossIcon;
	
	public Trackers(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPatientTrackerTab() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(patientTaskTab);
		waitForElement(driver, patientTaskTab);
		javascriptClick(patientTaskTab);
	}

	public String getTrackerName(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + task + "']")));
		WebElement taskName = driver.findElement(By.xpath("//label[text()='" + task + "']"));
		return taskName.getText();
	}


	public String getTrackerFromDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskFromDatePlaceholder);
		return taskFromDatePlaceholder.getAttribute("value");
	}

	public String getTrackerEndDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, taskEndDatePlaceholder);
		return taskEndDatePlaceholder.getAttribute("value");
	}
	
	public boolean isTrackerDisplay(String task) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + task + "']")));
			WebElement taskName = driver.findElement(By.xpath("//label[text()='" + task + "']"));
			isPresent = taskName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getTrackerEndDateColor(String task) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + task + "']/following-sibling::label[4]/label")));
		WebElement taskName = driver
				.findElement(By.xpath("//label[text()='" + task + "']/following-sibling::label[4]/label"));
		String getColor = taskName.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public String getTrackerFromDateColor(String trackerName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + trackerName + "']/following-sibling::label[3]/label")));
		WebElement education = driver
				.findElement(By.xpath("//label[text()='" + trackerName + "']/following-sibling::label[3]/label"));
		String getColor = education.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public void clickOnTrackerName(String tracker) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + tracker + "']")));
		WebElement trackerName = driver.findElement(By.xpath("//label[text()='" + tracker + "']"));
		javascriptClick(trackerName);
		//medicationName.click();
	}
	
	public void clickOnTrackerCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crossIcon);
		javascriptClick(crossIcon);
	}
	
}
