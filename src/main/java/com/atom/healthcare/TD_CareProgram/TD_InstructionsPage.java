package com.atom.healthcare.TD_CareProgram;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class TD_InstructionsPage extends BasePageObject {

	@FindBy(how = How.ID, using = "LeftMenuOrganisationMenuProramsTabView")
	private WebElement clickCareProgramTab;
	
	@FindBy(how = How.XPATH, using = "(//span[@class=' truncate ltr'])[1]")
	public WebElement instructionTabText;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-row-1 w-available mx-2  cursor-pointer'])[1]")
	public WebElement instructionList;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	public WebElement instructionListTitle;

	@FindBy(how = How.ID, using = "InstructionsViewSearchTextKey")
	public WebElement instructionSearchTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement instructionSearchPlaceholder;

	@FindBy(how = How.XPATH, using = "//button[text()='Add']")
	public WebElement instructionAddButton;

	@FindBy(how = How.XPATH, using = "//input[@id='InstructionsViewIsPopupInstructionNameKey1input-text']")
	public WebElement instructionNameTextbox;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey1input-text")
	public WebElement instructionNameTextboxOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey2input-text")
	public WebElement instructionNameTextboxTwo;

	@FindBy(how = How.XPATH, using = "//div[@class='ql-editor ql-blank']")
	public WebElement instructionDescriptionTextbox;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ql-editor']")
	public WebElement updateInstructionDescriptionTextbox;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[2]/div/p")
	public WebElement instructionDescriptionTextboxOne;

	@FindBy(how = How.XPATH, using = "(//div[@class='ltr ql-container ql-snow'])[3]/div/p")
	public WebElement instructionDescriptionTextboxTwo;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs1")
	public WebElement instructionLangOne;

	@FindBy(how = How.ID, using = "InstructionsViewIsPopuptabs2")
	public WebElement instructionLangTwo;

	@FindBy(how = How.ID, using = "InstructionsViewSaveActionKey")
	public WebElement instructionSaveButton;

	@FindBy(how = How.ID, using = "InstructionsViewCancelActionKey")
	public WebElement instructionCancelButton;

	@FindBy(how = How.XPATH, using = "//div[@class='table-header w-available mx-2']")
	public WebElement instructionNameHeader;
	
	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionNameKey1errorLabel")
	public WebElement instructionNameErrorMsg;
	
	@FindBy(how = How.ID, using = "InstructionsViewIsPopupInstructionDescriptionKey1errorLabel")
	public WebElement instructionDescriptionErrorMsg;
	
	@FindBy(how = How.ID, using = "InstructionsViewIsPopuperrorLabel")
	public WebElement instructionLangErrorLabel;
	
	@FindBy(how =  How.XPATH, using ="//label[text()='First Instructions']")
	public WebElement newInstructions;
	
	@FindBy(how =  How.XPATH, using ="//label[text()='Second Instructions']")
	public WebElement updatedInstructions;
	
	@FindBy(how = How.ID, using = "InstructionsViewDeleteActionKey")
	public WebElement instructionDeleteButton;
	
	@FindBy(how = How.ID, using = "OkActionKey")
	public WebElement instructionDeleteOkButton;
	
	@FindBy(how =  How.XPATH, using ="//img[@src='images/imageIcon.png']")
	public WebElement descriptionImageControl;
	
	@FindBy(how =  How.XPATH, using ="//input[@type='file']")
	public WebElement imageUpload;
	

	public TD_InstructionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	BasePageObject baseMethods = new BasePageObject(driver);

	public void createNewInstructions(String text, String descript) throws InterruptedException {
		waitForElement(driver, instructionNameTextbox);
		javascriptClick(instructionNameTextbox);
		instructionNameTextbox.sendKeys(text);
		javascriptClick(instructionDescriptionTextbox);
		instructionDescriptionTextbox.sendKeys(descript);
	}

	public void updateInstructions(String text, String descript) throws InterruptedException {
		waitForElement(driver, instructionNameTextbox);
		javascriptClick(instructionNameTextbox);
		instructionNameTextbox.clear();
		instructionNameTextbox.sendKeys(text);
		javascriptClick(updateInstructionDescriptionTextbox);
		updateInstructionDescriptionTextbox.clear();
		instructionDescriptionTextbox.sendKeys(descript);
	}

	public boolean isInstructionTabDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionTabText);
			isPresent = instructionTabText.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Instruction Tab is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionTextErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionNameErrorMsg);
			isPresent = instructionNameErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Instruction Text error label is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionDescriptionErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionDescriptionErrorMsg);
			isPresent = instructionDescriptionErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Instruction Description Error label is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionLangErrorLabelDisplayed() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionNameErrorMsg);
			isPresent = instructionNameErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Language error label is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionRangeErrorLabelDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionNameErrorMsg);
			isPresent = instructionNameErrorMsg.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Range error label is not visible");
			return isPresent;
		}
	}

	public void clickOnInstructionNameTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		javascriptClick(instructionNameTextbox);
	}

	public void clickOnInstructionDescriptionTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDescriptionTextbox);
		javascriptClick(instructionDescriptionTextbox);
	}

	public void clickOnCareProgramTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, clickCareProgramTab);
		javascriptClick(clickCareProgramTab);
	}

	public void clickOnInstructionCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionCancelButton);
		javascriptClick(instructionCancelButton);
	}

	public void clickOnCreatedInstructions() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, newInstructions);
		javascriptClick(newInstructions);
		Thread.sleep(1000);
	}

	public void clickOnUpdatedInstructions() {
		TestConfig.PrintMethodName();
		waitForElement(driver, updatedInstructions);
		javascriptClick(updatedInstructions);
	}

	public void clickOnDeleteButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteButton);
		javascriptClick(instructionDeleteButton);
	}

	public void clickOnOkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionDeleteOkButton);
		javascriptClick(instructionDeleteOkButton);
	}

	public void clickOnInstructionAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionAddButton);
		javascriptClick(instructionAddButton);
	}

	public void clickOnInstructionSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionSaveButton);
		javascriptClick(instructionSaveButton);
	}

	public void clearInstructionText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionNameTextbox);
		javascriptClick(instructionNameTextbox);
		instructionNameTextbox.clear();
	}

	public void clearDescriptionTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, updateInstructionDescriptionTextbox);
		javascriptClick(updateInstructionDescriptionTextbox);
		updateInstructionDescriptionTextbox.clear();
	}
}