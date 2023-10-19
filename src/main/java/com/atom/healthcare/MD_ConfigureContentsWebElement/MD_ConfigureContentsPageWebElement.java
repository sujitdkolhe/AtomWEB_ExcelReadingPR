package com.atom.healthcare.MD_ConfigureContentsWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_ConfigureContentsPageWebElement extends BasePageObject {
	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[10]")
	private WebElement ConfigureContentMenu;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 col-8 margin-vertical-xs truncate']")
	private WebElement configureContentsLabel;

	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	private WebElement staticContentTab;

	@FindBy(how = How.ID, using = "StaticContentsViewAddActionKey")
	private WebElement configContentAddButton;

	@FindBy(how = How.CSS, using = "#StaticContentsViewIsPopupSelectIconKeyinput-fieImageUploadControl")
	private WebElement selectIconImageControl;

	@FindBy(how = How.CSS, using = "#StaticContentsViewTitleKey1input-text")
	private WebElement contentTitleTextbox;

	@FindBy(how = How.CSS, using = "#StaticContentsViewPageDescriptionKey1input-textArea")
	private WebElement descriptionTextbox;

	@FindBy(how = How.CSS, using = "div.ql-editor.ql-blank")
	private WebElement editorTextbox;

	@FindBy(how = How.CSS, using = "#StaticContentsViewSaveActionKey")
	private WebElement staticContentSaveButton;

	@FindBy(how = How.CSS, using = "#StaticContentsViewPublishKey")
	private WebElement contentPublishButton;

	@FindBy(how = How.CSS, using = "#OkActionKey")
	private WebElement OKButton;

	public MD_ConfigureContentsPageWebElement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnConfigureContentMenu() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ConfigureContentMenu);
		javascriptClick(ConfigureContentMenu);
		// ConfigureContentMenu.click();
	}

	public void selectStaticContentTab() throws InterruptedException {
		TestConfig.PrintMethodName();
		Thread.sleep(2000);
		waitForElement(driver, staticContentTab);
		javascriptClick(staticContentTab);
		// staticContentTab.click();
	}

	public void addStaticContent(String contentIcon, String title, String description, String editor) {
		TestConfig.PrintMethodName();
		waitForElement(driver, staticContentTab);
		configContentAddButton.click();
		waitForElement(driver, selectIconImageControl);
		selectIconImageControl.sendKeys(contentIcon);
		contentTitleTextbox.sendKeys(title);
		descriptionTextbox.sendKeys(description);
		editorTextbox.sendKeys(editor);
		javascriptClick(staticContentSaveButton);
	}

	public void clickOnCreatedStaticContent(String contentTitle) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + contentTitle + "']")));
		WebElement title = driver.findElement(By.xpath("//label[text()='" + contentTitle + "']"));
		waitForElement(driver, title);
		title.click();
	}

	public void clickOnPublishButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, contentPublishButton);
		contentPublishButton.click();
	}

	public void clickOnOKButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, OKButton);
		OKButton.click();
	}

	public boolean isCreatedStaticContentDisplay(String contentTitle) {
		TestConfig.PrintMethodName();
		waitForElement(driver, driver.findElement(By.xpath("//label[text()='" + contentTitle + "']")));
		WebElement title = driver.findElement(By.xpath("//label[text()='" + contentTitle + "']"));
		waitForElement(driver, title);
		boolean isPresent = false;
		try {
			waitForElement(driver, title);
			isPresent = title.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Created Static Contents is not visible");
			return isPresent;
		}
	}

}
