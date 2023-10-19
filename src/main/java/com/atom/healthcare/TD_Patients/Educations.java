package com.atom.healthcare.TD_Patients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Educations extends BasePageObject {

	public Educations(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Patients']")
	private WebElement patientsTab;

	@FindBy(how = How.ID, using = "PatientsViewSearchTextKey")
	private WebElement patientInputTextbox;

	@FindBy(how = How.ID, using = "PatientsView1879")
	private WebElement overviewpatient;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'][contains(.,'Educations')]")
	private WebElement patientOverviewEducationName;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-secondary-text-body-medium-regular text-start truncate\"] ")
	private WebElement patientOverviewEducationCategory;

	@FindBy(how = How.ID, using = "PatientDetailViewShowMoreKey")
	private WebElement patientEducationShowMoreButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsViewtable-row0']/label)[1]")
	private WebElement patientOverviewEducationListItem;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold text-start \"]")
	private WebElement patientEducationDetailPage;

	@FindBy(how = How.ID, using = "PatientsView2665")
	private WebElement patientWithNoEducation;

	@FindBy(how = How.XPATH, using = "//span[text()='Educations']")
	private WebElement patientEducationTitle;

	@FindBy(how = How.ID, using = "PatientEducationsViewerrorLabel")
	private WebElement patientEducationOverviewNoRecord;

	@FindBy(how = How.ID, using = "PatientsView2416")
	private WebElement patientForChat;

	@FindBy(how = How.ID, using = "PatientEducationsView")
	private WebElement patientEducationTab;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsView']/div)[1]")
	private WebElement educationCountTitle;

	@FindBy(how = How.ID, using = "PatientEducationsViewSearchTextKey")
	private WebElement educationSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	private WebElement educationSearchPlaceholder;

	@FindBy(how = How.ID, using = "PatientEducationsViewAddActionKey")
	private WebElement educationAddButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='row px-0 mx-0 d-flex justify-content-center'])[3]")
	private WebElement educationPreviewImage;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsViewtable-row0']/label)[1]")
	private WebElement educationName;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsViewtable-row0']/label)[2]")
	private WebElement educationCategoryName;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsViewtable-row0']/label)[3]")
	private WebElement educationProgramName;

	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectCategoryKeyinput-text")
	private WebElement educationAddCategoryDropdown;

	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectCategoryKeylabel98")
	private WebElement educationAddCategoryOption;

	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectEducationLabelKeyinput-text")
	private WebElement educationSelectDropdown;

	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectEducationLabelKeylabel378")
	private WebElement educationSelectOption;

	@FindBy(how = How.ID, using = "PatientEducationsViewAssignButtonTextKey")
	private WebElement educationAssignButton;

	@FindBy(how = How.ID, using = "PatientEducationsViewNoDataFoundKey")
	private WebElement educationNoRecord;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start '] ")
	private WebElement educationAssignTitle;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-semi-bold text-start truncate'] [1]")
	private WebElement assignedEducation;

	@FindBy(how = How.XPATH, using = "(//div[@id='PatientEducationsViewtable-row0']/label)[1]")
	private WebElement assignedEducationDetailView;

	@FindBy(how = How.ID, using = "PatientsView1472")
	private WebElement patientWithNoEducationRecord;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[8]")
	private WebElement firstDept;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'] )[10]")
	private WebElement educationColorBand;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Category')])[2]")
	private WebElement assignEducationCategoryLabel;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'Education')])[5]")
	private WebElement assignEducationSelectLabel;

	@FindBy(how = How.ID, using = "PatientEducationsViewCancelActionKey")
	private WebElement assignEducationCancelButton;

	@FindBy(how = How.ID, using = "PatientEducationsViewPreviewKey")
	private WebElement assignEducationPreviewButton;
	
	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectCategoryKeyerrorLabel")
	private WebElement assignEducationCategoryErrorMsg;

	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupSelectEducationLabelKeyerrorLabel")
	private WebElement assignEducationSelectError;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start ']) [2]")
	private WebElement educationDetailPageTitle;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer']) [1]")
	private WebElement educationDetailCrossIcon;

	@FindBy(how = How.XPATH, using = "(//div[@class='text-center']) [2]")
	private WebElement educationDetailTextContent;

	@FindBy(how = How.ID, using = "PatientEducationsViewOkActionKey")
	private WebElement educationDetailOkButton;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='PatientEducationsViewIsPopupSelectCategoryKeyListItems']/li)[2]")
	private WebElement educationCategory;
	
	@FindBy(how = How.XPATH, using = "//div[@id='PatientEducationsViewIsPopupSelectEducationLabelKey']")
	private WebElement educationDropdown;
	
	@FindBy(how = How.XPATH, using = "(//ui[@id='PatientEducationsViewIsPopupSelectEducationLabelKeyListItems']/li)[2]")
	private WebElement selectEducationDropdown;
	
	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupFromDateKeydate")
	private WebElement patientEducationFromDate;
	
	@FindBy(how = How.ID, using = "PatientEducationsViewIsPopupEndDateKeydate")
	private WebElement patientEducationEndDate;
	
	@FindBy(how = How.ID, using = "PatientEducationsViewSaveActionKey")
	private WebElement patientEducationSaveButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Assign Education']")
	private WebElement assignEducationTitle;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	private WebElement previewPageDisplay;
	
	public void clickOnPatientsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientsTab);
		javascriptClick(patientsTab);
	}

	public void enterTextInPatientsSearchBox(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientInputTextbox);
		patientInputTextbox.sendKeys(text);
	}

	public void clickOnFirstPatient() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(overviewpatient);
		waitForElement(driver, overviewpatient);
		javascriptClick(overviewpatient);
	}

	public boolean isPatientEducationShowMoreButtonDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationShowMoreButton);
		boolean isPresent = false;
		try {
			waitForElement(driver, patientEducationShowMoreButton);
			isPresent = patientEducationShowMoreButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientEducationNameInOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientOverviewEducationName);
		return patientOverviewEducationName.getText();
	}

	public String getPatientEducationCategoryInOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientOverviewEducationCategory);
		return patientOverviewEducationCategory.getText();
	}

	public void clickOnEducationShowMoreButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationShowMoreButton);
		javascriptClick(patientEducationShowMoreButton);
	}

	public void clickOnEducationListItemInPatientOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientOverviewEducationListItem);
		javascriptClick(patientOverviewEducationListItem);
	}

	public String getPatientEducationDetailPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationDetailPage);
		return patientEducationDetailPage.getText();
	}

	public void clickOnPatientWithNoEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientWithNoEducation);
		patientWithNoEducation.click();
	}

	public String getTitleForPatientEducationOverview() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationTitle);
		return patientEducationTitle.getText();
	}

	public String getPatientEducationOverviewNoRecordMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationOverviewNoRecord);
		return patientEducationOverviewNoRecord.getText();
	}

	public void clickOnEducationPatient() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientForChat);
		javascriptClick(patientForChat);
	}

	public void clickOnPatientEducationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationTab);
		javascriptClick(patientEducationTab);
	}

	public String getPatientEducationTabText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationTab);
		return patientEducationTab.getText();
	}

	public String getPatientEducationTabHighlightedColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationTab);
		String cssValue = patientEducationTab.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getPatientEducationListTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCountTitle);
		return educationCountTitle.getText();
	}

	public boolean isEducationSearchTextDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationSearchTextbox);
			isPresent = educationSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnFirstDept() {
		TestConfig.PrintMethodName();
		waitForElement(driver, firstDept);
		javascriptClick(firstDept);
	}

	public String getEducationListSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchPlaceholder);
		return educationSearchPlaceholder.getAttribute("placeholder");
	}

	public String getPatientEducationListAddButtoncaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddButton);
		return educationAddButton.getText();
	}

	public void clickOnEducationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddButton);
		javascriptClick(educationAddButton);
	}

	public boolean isEducationPreviewImageDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationPreviewImage);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationPreviewImage);
			isPresent = educationPreviewImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnEducationCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddCategoryDropdown);
		javascriptClick(educationAddCategoryDropdown);
	}

	public void clickOnEducationCategoryOption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddCategoryOption);
		javascriptClick(educationAddCategoryOption);
	}

	public void clickOnEducationSelectCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSelectDropdown);
		javascriptClick(educationSelectDropdown);
	}

	public void clickOnEducationSelectOption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSelectOption);
		javascriptClick(educationSelectOption);
	}

	public void clickOnEducationAssignButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignButton);
		educationAssignButton.click();
	}

	public String getPatientEducationColorBand() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationColorBand);
		String cssValue = educationColorBand.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isEducationNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationName);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationName);
			isPresent = educationName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isEducationCategoryNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCategoryName);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationCategoryName);
			isPresent = educationCategoryName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isEducationProgramNameDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationProgramName);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationProgramName);
			isPresent = educationProgramName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getPatientEducationListCountBasedOnSearch() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationCountTitle);
		return educationCountTitle.getText();
	}

	public void clearEducationSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchTextbox);
		educationSearchTextbox.clear();
	}

	public void sendPatientEducationSearchWord(String text) {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationSearchTextbox);
		educationSearchTextbox.sendKeys(text);
	}

	public String getPatientEducationSearchNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationNoRecord);
		return educationNoRecord.getText();
	}

	public String getAssignEducationPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAssignTitle);
		return educationAssignTitle.getText();
	}

	public void clickOnEducationListItem() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignedEducation);
		javascriptClick(assignedEducation);
	}

	public boolean isEducationDetailViewDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignedEducationDetailView);
		boolean isPresent = false;
		try {
			waitForElement(driver, assignedEducationDetailView);
			isPresent = assignedEducationDetailView.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnPatientWithNoEducationRecord() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientWithNoEducationRecord);
		javascriptClick(patientWithNoEducationRecord);
	}

	public String getPatientEducationNoRecordMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationNoRecord);
		return educationNoRecord.getText();
	}

	public boolean isAssignEducationCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailCrossIcon);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDetailCrossIcon);
			isPresent = educationDetailCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAssignEducationCategoryLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCategoryLabel);
		return assignEducationCategoryLabel.getText();
	}

	public boolean isAssignEducationCategoryDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddCategoryDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationAddCategoryDropdown);
			isPresent = educationAddCategoryDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAssignEducationSelectLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationSelectLabel);
		return assignEducationSelectLabel.getText();
	}

	public boolean isAssignEducationSelectDropdownDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDropdown);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDropdown);
			isPresent = educationDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAssignEducationCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCancelButton);
		return assignEducationCancelButton.getText();
	}

	public String getAssignEducationPreviewButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationPreviewButton);
		return assignEducationPreviewButton.getText();
	}

	public void clickOnAssignEducationCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCancelButton);
		javascriptClick(assignEducationCancelButton);
	}

	public void clickOnAssignEducationPreviewButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationPreviewButton);
		javascriptClick(assignEducationPreviewButton);
	}

	public String getAssignEducationCategoryErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationCategoryErrorMsg);
		return assignEducationCategoryErrorMsg.getText();
	}

	public String getAssignEducationSelectErrorMsg() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationSelectError);
		return assignEducationSelectError.getText();
	}

	public boolean isEducationDetailPageTitleDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailPageTitle);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDetailPageTitle);
			isPresent = educationDetailPageTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isEducationDetailPageCrossIconDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDetailCrossIcon);
			isPresent = educationDetailCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isEducationDetailTextContentDisplayed() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailTextContent);
		boolean isPresent = false;
		try {
			waitForElement(driver, educationDetailTextContent);
			isPresent = educationDetailTextContent.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducatioDetailOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailOkButton);
		return educationDetailOkButton.getText();
	}

	public void clickOnEducationDetailPageCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailPageTitle);
		javascriptClick(educationDetailPageTitle);
	}

	public void clickOnEducationDetailOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailOkButton);
		javascriptClick(educationDetailOkButton);
	}
	
	public String getEducationName(String education) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+education+"']")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+education+"']"));
		return patientName.getText();
	}
	
	public String getFromDate(String education) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+education+"']/following-sibling::label[3]/label")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+education+"']/following-sibling::label[3]"));
		return patientName.getText().trim();
	}
	
	public String getEndDate(String education) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='"+education+"']/following-sibling::label[4]/label")));
		WebElement patientName =driver.findElement(By.xpath("//label[text()='"+education+"']/following-sibling::label[4]/label"));
		return patientName.getText().trim();
	}
	
	public String getEducationFromDateColor(String educationName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[3]/label")));
		WebElement education = driver
				.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[3]/label"));
		String getColor = education.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public String getEducationEndDateColor(String educationName) {
		TestConfig.PrintMethodName();
		waitForElement(driver,
				driver.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[4]/label")));
		WebElement education = driver
				.findElement(By.xpath("//label[text()='" + educationName + "']/following-sibling::label[4]/label"));
		String getColor = education.getCssValue("color");
		return Color.fromString(getColor).asHex();
	}
	
	public boolean isEducationDisplay(String education) {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + education + "']")));
			WebElement educationName = driver.findElement(By.xpath("//label[text()='" + education + "']"));
			isPresent = educationName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isEducationTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, patientOverviewEducationName);
			isPresent = patientOverviewEducationName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void addEducationFromPatientTab(int currentDate, int addDays) throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddButton);
		javascriptClick(educationAddButton);
		educationAddCategoryDropdown.click();
		educationCategory.click();
		waitForElement(driver, educationSelectDropdown);
		//Thread.sleep(2000);
		educationDropdown.click();
		//Thread.sleep(2000);
		waitForElement(driver, selectEducationDropdown);
		selectEducationDropdown.click();
		long addDt = 24 * 60 * 60 * 1000 * currentDate;
		String yyyymmdd=BasePageObject.getDate_yyyy_mm_dd(addDt);
		String[] getDate=yyyymmdd.split("-");
		String yyyy=getDate[0];
		String mm=getDate[1];
		String dd=getDate[2];
		
		patientEducationFromDate.sendKeys(mm);
		patientEducationFromDate.sendKeys(dd);
		patientEducationFromDate.sendKeys(yyyy);
		
		long addDate = 24 * 60 * 60 * 1000 * addDays;
		String getFutureDate=BasePageObject.getDate_yyyy_mm_dd(addDate);
		String[] futureDate=getFutureDate.split("-");
		System.out.println("getFutureDate "+getFutureDate);
		String year=futureDate[0];
		String month=futureDate[1];
		String date=futureDate[2];
		patientEducationEndDate.sendKeys(month);
		patientEducationEndDate.sendKeys(date);
		patientEducationEndDate.sendKeys(year);
		javascriptClick(patientEducationSaveButton);
		//Thread.sleep(2000);
	}
	
	public String getAssignEducationTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, assignEducationTitle);
		return assignEducationTitle.getText();
	}
	
	public void clickOnEducationCrossTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationDetailCrossIcon);
		 educationDetailCrossIcon.click();
	}
	
	public void clickEducationName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationName);
		educationName.click();
	}
	
	public boolean isPreviewPageDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, previewPageDisplay);
			isPresent = previewPageDisplay.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnEducationSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, patientEducationSaveButton);
		patientEducationSaveButton.click();
	}
	
	public void selectEducationCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationAddCategoryDropdown);
		educationAddCategoryDropdown.click();
		educationCategory.click();
	}
	
	
}
