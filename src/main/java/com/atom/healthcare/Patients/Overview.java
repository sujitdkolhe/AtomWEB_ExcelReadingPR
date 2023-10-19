package com.atom.healthcare.Patients;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Overview extends BasePageObject {

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[8]")
	private WebElement bloodPressureReadingCard;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start truncate'])[1]")
	private WebElement readingCardWeightLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start truncate'])[2]")
	private WebElement readingCardBloodGlucoseLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start truncate'])[3]")
	private WebElement readingCardHeartRateLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start truncate'])[4]")
	private WebElement readingCardBabyKickLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start truncate'])[5]")
	private WebElement readingCardBloodPressureLabel;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex text-start ltr'])[1]")
	private WebElement weightValue;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular margin-horizontal-xs margin-top-xs'])[1]")
	private WebElement weightUnit;

	@FindBy(how = How.XPATH, using = "(//div[@class='d-flex text-start ltr'])[2]")
	private WebElement bloodGlucoseValue;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular margin-horizontal-xs margin-top-xs'])[2]")
	private WebElement bloodGlucoseUnit;

	@FindBy(how = How.XPATH, using = "(//canvas[@class='chartjs-render-monitor'])[1]")
	private WebElement weightGraph;

	@FindBy(how = How.XPATH, using = "(//canvas[@class='chartjs-render-monitor'])[2]")
	private WebElement bloodGlucoseGraph;

	@FindBy(how = How.XPATH, using = "//button[@id='ShowMoreKey']")
	private WebElement readingShowMore;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold ']")
	private WebElement weightHeader;

	@FindBy(how = How.XPATH, using = "//label[text()='Supported file upload types are png,jpeg,jpg']")
	private WebElement invalidProfileImage;

	@FindBy(how = How.ID, using = "PatientAddEditGenderKeyinput-text")
	private WebElement genderInput;

	@FindBy(how = How.XPATH, using = "//ui[@class='select-menu show']/li")
	private List<WebElement> genderDropdownList;

	@FindBy(how = How.XPATH, using = "(//img[@class='margin-horizontal-xxs margin-bottom-xxs '])[1]")
	private WebElement vitalsIcon;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular text-center truncate'])[1]")
	private WebElement vitalsLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular text-center truncate'])[2]")
	private WebElement foodLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular text-center truncate'])[3]")
	private WebElement exerciseLabel;

	@FindBy(how = How.XPATH, using = "//label[text()='Blood Glucose']")
	private WebElement bloodGlucoseLabel;

	@FindBy(how = How.XPATH, using = "(//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center'])[2]")
	private WebElement readingOverviewNoRecordMessage;

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[4]")
	private WebElement weightReadingCard;

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[5]")
	private WebElement bloodGlucoseReadingCard;

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[6]")
	private WebElement heartRateReadingCard;

	@FindBy(how = How.XPATH, using = "(//div[@class='cursor-pointer-children'])[7]")
	private WebElement babyKickCounterReadingCard;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 px-0 ']")
	private WebElement readingOverviewHeader;

	@FindBy(how = How.XPATH, using = "(//img[@class='margin-horizontal-xxs margin-bottom-xxs '])[2]")
	private WebElement foodIcon;

	@FindBy(how = How.XPATH, using = "(//img[@class='margin-horizontal-xxs margin-bottom-xxs '])[3]")
	private WebElement exerciseIcon;

	public Overview(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isBloodPressureReadingCardDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodPressureReadingCard);
		boolean isPresent = false;
		try {
			waitForElement(driver, bloodPressureReadingCard);
			isPresent = bloodPressureReadingCard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getReadingCardWeightLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardWeightLabel);
		return readingCardWeightLabel.getText();
	}

	public String getReadingCardBloodGlucoseLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardBloodGlucoseLabel);
		return readingCardBloodGlucoseLabel.getText();
	}

	public String getReadingCardHeartRateLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardHeartRateLabel);
		return readingCardHeartRateLabel.getText();
	}

	public String getReadingCardBabyKickCounterLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardBabyKickLabel);
		return readingCardBabyKickLabel.getText();
	}

	public String getReadingCardBloodPressureLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardBloodPressureLabel);
		return readingCardBloodPressureLabel.getText();
	}

	public String getReadingWeightValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weightValue);
		return weightValue.getText();
	}

	public String getReadingWeightUnit() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weightUnit);
		return weightUnit.getText();
	}

	public String getReadingBloodGlucoseValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseValue);
		return bloodGlucoseValue.getText();
	}

	public String getReadingBloodGlucoseUnit() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseUnit);
		return bloodGlucoseUnit.getText();
	}

	public boolean isWeightGraphDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weightGraph);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, weightGraph);
			isPresent = weightGraph.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBloodGlucoseGraphDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseGraph);
		boolean isPresent = false;
		try {
			waitForElement(driver, bloodGlucoseGraph);
			isPresent = bloodGlucoseGraph.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnReadingShowMoreButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingShowMore);
		javascriptClick(readingShowMore);
	}

	public void clickOnWeightReadingCard() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingCardWeightLabel);
		javascriptClick(readingCardWeightLabel);
	}

	public String getWeightHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weightHeader);
		return weightHeader.getText();
	}

	public String getIncorrectFormatErrorMsgDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, invalidProfileImage);
		return invalidProfileImage.getText();
	}

	public void clickOnGenderDropdownValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, genderInput);
		genderInput.click();
	}

	public List<String> getGenderList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement o : genderDropdownList) {
			dropDownList.add(o.getText());
		}
		return dropDownList;
	}

	public boolean isVitalsIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, vitalsIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, vitalsIcon);
			isPresent = vitalsIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getVitalsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, vitalsLabel);
		return vitalsLabel.getText();
	}

	public String getFoodLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, foodLabel);
		return foodLabel.getText();
	}

	public String getExerciseLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, exerciseLabel);
		return exerciseLabel.getText();
	}

	public String getBloodGlucoseLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseLabel);
		return bloodGlucoseLabel.getText();
	}

	public boolean isFoodIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, foodIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, foodIcon);
			isPresent = foodIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isExerciseIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, exerciseIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, exerciseIcon);
			isPresent = exerciseIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getReadingOverviewNoDataFoundMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingOverviewNoRecordMessage);
		return readingOverviewNoRecordMessage.getText();
	}

	public boolean isWeightReadingCardDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, weightReadingCard);
		boolean isPresent = false;
		try {
			waitForElement(driver, weightReadingCard);
			isPresent = weightReadingCard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBloodGlucoseReadingCardDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, bloodGlucoseReadingCard);
		boolean isPresent = false;
		try {
			waitForElement(driver, bloodGlucoseReadingCard);
			isPresent = bloodGlucoseReadingCard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isHeartRateReadingCardDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, heartRateReadingCard);
		boolean isPresent = false;
		try {
			waitForElement(driver, heartRateReadingCard);
			isPresent = heartRateReadingCard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isBabyKickCounterReadingCardDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, babyKickCounterReadingCard);
		boolean isPresent = false;
		try {
			waitForElement(driver, babyKickCounterReadingCard);
			isPresent = babyKickCounterReadingCard.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getReadingOverviewHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, readingOverviewHeader);
		return readingOverviewHeader.getText();
	}

}
