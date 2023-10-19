package com.atom.healthcare.Education;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Education extends BasePageObject {

	public Education(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuEducationsView")
	private WebElement menuEducationTab;

	@FindBy(how = How.ID, using = "EducationsView")
	private WebElement educationPageTitle;

	@FindBy(how = How.ID, using = "EducationsViewSearchTextKey")
	private WebElement educationSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	private WebElement educationSearchPlaceholder;

	@FindBy(how = How.ID, using = "EducationsViewAddActionKey")
	private WebElement educationAddButton;

	@FindBy(how = How.ID, using = "EducationsView440")
	private WebElement educationList;

	@FindBy(how = How.XPATH, using = "(//label[@class='badge-done-fill'])[1]")
	private WebElement educationCardPublishTag;

	@FindBy(how = How.XPATH, using = "//div[@class='card-img-overlay'][1]")
	private WebElement educationCardImg;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-white-body-large-semi-bold text-start card-bg-truncate ']")
	private WebElement educationCardName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-white-body-medium-regular text-start card-bg-truncate ']")
	private WebElement educationCategoryName;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement educationAddEditPageTitle;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupSelectCategoryKeyinput-text")
	private WebElement educationCategoryDropdown;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupSelectCategoryKeylabel93")
	private WebElement educationCategoryOption;

	@FindBy(how = How.ID, using = "EducationsViewtabs1")
	private WebElement educationFirstLang;

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Title'])[1]")
	private WebElement educationFirstTitleTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement educationFirstEditorTextbox;

	@FindBy(how = How.ID, using = "EducationsViewtabs2")
	private WebElement educationSecondLang;

	@FindBy(how = How.ID, using = "EducationsViewTitleKey1input-text")
	private WebElement educationSecondTitleTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false'])[2]/p")
	public WebElement educationSecondEditorTextbox;

	@FindBy(how = How.ID, using = "EducationsViewTitleKey2input-text")
	private WebElement educationThirdTitleTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@data-gramm='false'])[3]/p/br")
	private WebElement educationThirdEditorTextbox;

	@FindBy(how = How.ID, using = "EducationsViewtabs2")
	private WebElement educationThirdLang;

	@FindBy(how = How.ID, using = "EducationsViewSaveActionKey")
	private WebElement educationSaveButton;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement searchNoRecordsLabel;

	@FindBy(how = How.XPATH, using = "//div[@class='card-img-overlay'][1]")
	private WebElement educationClick;

	@FindBy(how = How.XPATH, using = "//img[@class='cursor-pointer'][1]")
	private WebElement educationAddPageCrossIcon;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement educationTakePictureLabel;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupTakePictureTextKey")
	private WebElement educationPictureControl;

	@FindBy(how = How.XPATH, using = "//input[@type=\"file\"][1]")
	private WebElement educationUploadPictureControl;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement educationCategoryLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement educationPageTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular margin-right-md ltr'])[1]")
	private WebElement educationContentLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-regular margin-right-md ltr'])[2]")
	private WebElement educationLinkLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement educationTagsLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement educationTitleLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement educationDescriptionLabel;

	@FindBy(how = How.XPATH, using = "(//textarea[@placeholder='Enter Description'])[1]")
	private WebElement educationDescriptionTextbox;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	private WebElement educationEditorLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[7]")
	private WebElement educationLinkFieldLabel;

	@FindBy(how = How.ID, using = "EducationsViewLinksKey1input-text")
	private WebElement educationLinkTextbox;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupTagsKeyinput-text")
	private WebElement educationTagsTextbox;

	@FindBy(how = How.ID, using = "EducationsViewPreviewKey")
	private WebElement educationPreviewButton;

	@FindBy(how = How.ID, using = "EducationsViewUnpublishKey")
	private WebElement educationUnPublishButton;

	@FindBy(how = How.ID, using = "EducationsViewCancelActionKey")
	private WebElement educationCancelButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='padding-lg'])[2]")
	private WebElement unpublishEducationClick;

	@FindBy(how = How.XPATH, using = "(//div[@class='padding-lg'])[4]")
	private WebElement unPublishEducationClick;

	@FindBy(how = How.XPATH, using = "(//label[@class='badge-error-fill'])")
	private WebElement unpublishEducationBadge;

	@FindBy(how = How.ID, using = "EducationsViewPublishKey")
	private WebElement publishButton;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupTakePictureTextKeyerrorLabel")
	private WebElement imageErrorMessage;

	@FindBy(how = How.XPATH, using = "(//img[@class='avatar-circle'])[2]")
	private WebElement correctFormatImage;

	@FindBy(how = How.XPATH, using = "//div[@class=\"table\"]")
	private WebElement educationPreviewPage;

	@FindBy(how = How.ID, using = "EducationsViewIsPopupSelectCategoryKeyerrorLabel")
	private WebElement educationCategoryRequiredErrorMessage;

	@FindBy(how = How.ID, using = "EducationsViewTitleKey1errorLabel")
	private WebElement educationTitleRequiredErrorMessage;

	@FindBy(how = How.ID, using = "EducationsViewEditorKey1errorLabel")
	private WebElement educationEditorRequiredErrorMessage;

	@FindBy(how = How.ID, using = "EducationsViewerrorLabel")
	private WebElement educationLangRequiredErrorMessage;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement educationPublishConfirmationMessage;

	@FindBy(how = How.ID, using = "EducationsViewCancelActionKey")
	private WebElement publishCancelButton;

	@FindBy(how = How.ID, using = "EducationsViewOkActionKey")
	private WebElement publishOKButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='card-img-overlay'])[2]")
	private WebElement educationPublished;

	@FindBy(how = How.XPATH, using = "//div[@class='d-flex justify-content-center margin-vertical-sm ui-align-center']")
	private WebElement educationUnPublishConfirmationMessage;

	@FindBy(how = How.ID, using = "EducationsViewCancelActionKey")
	private WebElement unpublishCancelButton;

	@FindBy(how = How.ID, using = "EducationsViewOkActionKey")
	private WebElement unpublishOKButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start '])[2]")
	private WebElement previewEducationTitle;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[2]")
	private WebElement educationPreviewCrossIcon;

	@FindBy(how = How.ID, using = "EducationsViewOkActionKey")
	private WebElement PreviewOKButton;

	@FindBy(how = How.XPATH, using = "(//input[@type=\"radio\"])[1]")
	private WebElement contentRadioButton;

	@FindBy(how = How.XPATH, using = "(//input[@type=\"radio\"])[2]")
	private WebElement linkRadioButton;

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[5]")
	private WebElement editTitleTextbox;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement noEducationRecordAdded;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-border-error float-right']")
	private WebElement educationStatusButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[1]/div/h1")
	private WebElement educationEditorTextboxContent;
	
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Title'])[2]")
	private WebElement educationSeconLangTextbox;
	
	public void clickOnEducationTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  menuEducationTab);
		javascriptClick(menuEducationTab);
	}

	public String getEducationPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPageTitle);
		return educationPageTitle.getText();
	}

	public boolean isEducationSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSearchTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationSearchTextbox);
			isPresent = educationSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationSearchPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSearchPlaceholder);
		return educationSearchPlaceholder.getAttribute("placeholder");
	}

	public String getEducationAddButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationAddButton);
		return educationAddButton.getText();
	}

	public boolean isEducationCardImgDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCardImg);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationCardImg);
			isPresent = educationCardImg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationPublishTag() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCardPublishTag);
		return educationCardPublishTag.getText();
	}

	public String getEducationCardName() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCardName);
		return educationCardName.getText();
	}

	public String getEducationCategoryName(String eduTitle) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(driver.findElement(By.xpath("//label[text()='" + eduTitle + "']")));
		WebElement educationTitle = driver.findElement(By.xpath("//label[text()='" + eduTitle + "']"));
		return educationTitle.getText();
	}

	public boolean isEducationListDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationList);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationList);
			isPresent = educationList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnEducationAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationAddButton);
		javascriptClick(educationAddButton);
	}

	public String getEducationAddEditPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationAddEditPageTitle);
		return educationAddEditPageTitle.getText();
	}

	public void clickOnEducationCategoryDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryDropdown);
		educationCategoryDropdown.click();
	}

	public void clickOnEducationCategoryDropdownOption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryOption);
		educationCategoryOption.click();
	}

	public void sendEducationTitleForFirstLang(String title) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		educationFirstTitleTextbox.sendKeys(title);
	}

	public void sendEducationEditorContentForFirstLang(String editor) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(educationFirstEditorTextbox);
		waitForElement(driver,  educationFirstEditorTextbox);
		educationFirstEditorTextbox.sendKeys(editor);
	}

	public void clickOnSecondEducationLang() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSecondLang);
		educationSecondLang.click();
	}

	public void sendEducationTitleForSecondLang(String title2) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSeconLangTextbox);
		educationSeconLangTextbox.sendKeys(title2);
	}

	public void sendEducationEditorContentForSecondLang(String editor2) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(educationSecondEditorTextbox);
		waitForElement(driver,  educationSecondEditorTextbox);
		educationSecondEditorTextbox.sendKeys(editor2);
	}

	public void clickOnThirdEducationLang() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(educationThirdLang);
		waitForElement(driver,  educationThirdLang);
		educationThirdLang.click();
	}

	public void sendEducationTitleForThirdLang(String title3) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationThirdTitleTextbox);
		educationThirdTitleTextbox.sendKeys(title3);
	}

	public void sendEducationEditorContentForThirdLang(String editor3) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(educationThirdEditorTextbox);
		waitForElement(driver,  educationThirdEditorTextbox);
		driver.findElement(By.xpath("(//div[@data-gramm='false'])[3]/p/br"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.DOWN, Keys.UP).build().perform();
		educationThirdEditorTextbox.sendKeys("Nutrients, Proteins and Healthcare");
	}

	public void sendSearchWord(String searchword) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSearchTextbox);
		educationSearchTextbox.sendKeys(searchword);
	}

	public void clearSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSearchTextbox);
		educationSearchTextbox.clear();
	}

	public String getSearchNoRecordText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  searchNoRecordsLabel);
		return searchNoRecordsLabel.getText();
	}

	public void clickOnEducationSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSaveButton);
		educationSaveButton.click();
	}

	public void clickOnEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationClick);
		educationClick.click();
	}

	public String getTakePictureLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTakePictureLabel);
		return educationTakePictureLabel.getText();
	}

	public boolean isPictureControlAreaDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, educationPictureControl);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationPictureControl);
			isPresent = educationPictureControl.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isCrossIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationAddPageCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationAddPageCrossIcon);
			isPresent = educationAddPageCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCategoryLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryLabel);
		return educationCategoryLabel.getText();
	}

	public boolean isCategoryTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryDropdown);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationCategoryDropdown);
			isPresent = educationCategoryDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCategoryPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryDropdown);
		return educationCategoryDropdown.getAttribute("placeholder");
	}

	public String getPageTypeLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPageTypeLabel);
		return educationPageTypeLabel.getText();
	}

	public String getContentLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationContentLabel);
		return educationContentLabel.getText();
	}

	public String getLinkLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLinkLabel);
		return educationLinkLabel.getText();
	}

	public String getTagsLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTagsLabel);
		return educationTagsLabel.getText();
	}

	public String getTagsPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTagsTextbox);
		return educationTagsTextbox.getAttribute("placeholder");
	}

	public boolean isTagTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTagsTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationTagsTextbox);
			isPresent = educationTagsTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getFirstLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstLang);
		return educationFirstLang.getText();
	}

	public String getSecondLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSecondLang);
		return educationSecondLang.getText();
	}

	public String getThirdLangText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationThirdLang);
		return educationThirdLang.getText();
	}

	public String getTitleLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTitleLabel);
		return educationTitleLabel.getText();
	}

	public boolean isTitleTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationFirstTitleTextbox);
			isPresent = educationFirstTitleTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEducationEditTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		return educationFirstTitleTextbox.getText();
	}

	public void moveToTitleElement() {
		Actions action = new Actions(driver);
		action.moveToElement(educationFirstTitleTextbox);
	}

	public String getTitlePlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		return educationFirstTitleTextbox.getAttribute("placeholder");
	}

	public String getDescriptionLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationDescriptionLabel);
		return educationDescriptionLabel.getText();
	}

	public boolean isDescriptionTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationDescriptionTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationDescriptionTextbox);
			isPresent = educationDescriptionTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getDescriptionPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationDescriptionTextbox);
		return educationDescriptionTextbox.getAttribute("placeholder");
	}

	public String getEditorLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationEditorLabel);
		return educationEditorLabel.getText();
	}

	public boolean isEditorTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstEditorTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationFirstEditorTextbox);
			isPresent = educationFirstEditorTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getLinkPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLinkTextbox);
		return educationLinkTextbox.getAttribute("placeholder");
	}

	public boolean isLinkTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTagsTextbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationLinkTextbox);
			isPresent = educationLinkTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getLinkFieldText() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLinkFieldLabel);
		return educationLinkFieldLabel.getText();
	}

	public void onLinkButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLinkLabel);
		educationLinkLabel.click();
	}

	public String getSaveButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSaveButton);
		return educationSaveButton.getText();
	}

	public String getCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCancelButton);
		return educationCancelButton.getText();
	}

	public void onCancelButtonClick() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCancelButton);
		educationCancelButton.click();
	}

	public String getPreviewButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPreviewButton);
		return educationPreviewButton.getText();
	}

	public String getUnPublishButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationUnPublishButton);
		return educationUnPublishButton.getText();
	}

	public void clickOnUnpublishEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  unpublishEducationClick);
		javascriptClick(unpublishEducationClick);
	}

	public String getUnPublishTag() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  unpublishEducationBadge);
		return unpublishEducationBadge.getText();
	}

	public String getPublishButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishButton);
		return publishButton.getText();
	}

	public void clickOnCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationAddPageCrossIcon);
		educationAddPageCrossIcon.click();
	}

	public void uploadProfileImage(String image) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationUploadPictureControl);
		educationUploadPictureControl.sendKeys(image);
	}

	public String getEducationImageErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  imageErrorMessage);
		return imageErrorMessage.getText();
	}

	public boolean isEducationCorrectImgVisible() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(correctFormatImage);
			waitForElement(driver,  correctFormatImage);
			BasePageObject.waitForElement(driver,  correctFormatImage);
			isPresent = correctFormatImage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnContentButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationContentLabel);
		educationContentLabel.click();
	}

	public String getHighlitedFirstLangLabelColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstLang);
		String cssValue = educationFirstLang.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getHighlitedSecondLangLabelColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationSecondLang);
		String cssValue = educationSecondLang.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public String getHighlitedThirdLangLabelColor() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationThirdLang);
		String cssValue = educationThirdLang.getCssValue("color");
		return Color.fromString(cssValue).asHex();
	}

	public boolean isPreviewEducationDetailDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPreviewPage);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationPreviewPage);
			isPresent = educationPreviewPage.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnPreviewButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPreviewButton);
		educationPreviewButton.click();
	}

	public String getCategoryRequiredErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryRequiredErrorMessage);
		return educationCategoryRequiredErrorMessage.getText();
	}

	public String getTitleRequiredErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationTitleRequiredErrorMessage);
		return educationTitleRequiredErrorMessage.getText();
	}

	public String getEditorRequiredErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationEditorRequiredErrorMessage);
		return educationEditorRequiredErrorMessage.getText();
	}

	public String getLangRequiredErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLangRequiredErrorMessage);
		return educationLangRequiredErrorMessage.getText();
	}

	public String getPublishConfirmationMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPublishConfirmationMessage);
		return educationPublishConfirmationMessage.getText();
	}

	public String getPublishCancelButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishCancelButton);
		return publishCancelButton.getText();
	}

	public String getPublishOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishOKButton);
		return publishOKButton.getText();
	}

	public void clickOnEducationPublishStatusButton(String status) {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishButton);
		try {
			String s = publishButton.getText();
			if (s.equals(status)) {
				publishButton.click();
			} else {
				publishButton.click();
			}
		} catch (Exception e) {
			educationUnPublishButton.click();
			publishOKButton.click();
			driver.navigate().refresh();
			unpublishEducationClick.click();
			publishButton.click();
		}
	}

	public void clickOnEducationUnpublishStatusButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		try {
			waitForElement(driver,  educationUnPublishButton);
			educationUnPublishButton.click();
		} catch (Exception e) {
			publishButton.click();
			//Thread.sleep(3000);
			publishOKButton.click();
			///Thread.sleep(3000);
			waitForElement(driver,  unpublishEducationClick);
			unpublishEducationClick.click();
			educationUnPublishButton.click();
		}
	}

	public void clickOnPublishCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishCancelButton);
		publishCancelButton.click();
	}

	public void clickOnPublishOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  publishOKButton);
		publishOKButton.click();
	}

	public void clickOnUnPublishEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  unPublishEducationClick);
		unPublishEducationClick.click();
	}

	public String getPreviewEducationTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  previewEducationTitle);
		return previewEducationTitle.getText();
	}

	public boolean isPreviewEducationCrossIconDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPreviewCrossIcon);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  educationPreviewCrossIcon);
			isPresent = educationPreviewCrossIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnPreviewEducationCrossIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationPreviewCrossIcon);
		javascriptClick(PreviewOKButton);
	}

	public String getPreviewEducationOkButtonCaption() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  PreviewOKButton);
		return PreviewOKButton.getText();
	}

	public void clickOnPreviewEducationOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  PreviewOKButton);
		javascriptClick(PreviewOKButton);
	}

	public boolean isEducationContentPageTypeSelected() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  contentRadioButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  contentRadioButton);
			isPresent = contentRadioButton.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNoEducationAddedMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  noEducationRecordAdded);
		return noEducationRecordAdded.getText();
	}

	public boolean isEducationStatusButtonDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitUntilElementIsVisible(educationStatusButton);
			waitForElement(driver,  educationStatusButton);
			BasePageObject.waitForElement(driver,  educationStatusButton);
			isPresent = educationStatusButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getEditEducationTitleContent() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		String val = educationFirstTitleTextbox.getAttribute("value");
		return val;
	}

	public String getEditEducationEditorContent() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationEditorTextboxContent);
		Actions ac = new Actions(driver);
		ac.moveToElement(educationEditorTextboxContent);
		String val = educationEditorTextboxContent.getText();
		return val;
	}

	public void clickOnLinkEducation() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationList);
		educationList.click();
	}

	public String getEditLinkEducationTitleContent() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationFirstTitleTextbox);
		String val = educationFirstTitleTextbox.getAttribute("value");
		return val;
	}

	public String getEditLinkEducationLinkContent() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationLinkTextbox);
		String val = educationLinkTextbox.getAttribute("value");
		return val;
	}

	public boolean isContentRadioButtonEnabled() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  contentRadioButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  contentRadioButton);
			isPresent = contentRadioButton.isEnabled();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isLinkRadioButtonEnabled() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  linkRadioButton);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver,  linkRadioButton);
			isPresent = linkRadioButton.isEnabled();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void selectEducationCategory() {
		TestConfig.PrintMethodName();
		waitForElement(driver,  educationCategoryDropdown);
		educationCategoryDropdown.click();
		educationCategoryOption.click();
	}
}
