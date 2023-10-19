package com.atom.healthcare.MD_MasterDataWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class MD_PaymentMode extends BasePageObject {

	
	@FindBy(how = How.ID, using = "PaymentModesView")
	private WebElement paymentModesTab;
	
	@FindBy(how = How.ID, using = "PaymentModesViewAddActionKey")
	private WebElement paymentModesAddButton;
	
	
	@FindBy(how = How.ID, using = "PaymentModesViewIsPopupPaymentModeNameKey1input-text")
	private WebElement paymentModesTextbox;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='padding-horizontal-md '])[9]")
	private WebElement masterDataMenu;
	
	@FindBy (how =How.ID, using = "PaymentModesViewSaveActionKey")
	private WebElement paymentModesSaveButton;
	
	@FindBy (how = How.ID, using = "PaymentModesViewIsPopupPaymentModeNameKey1errorLabel")
	private WebElement paymentModeTextboxErrorLabel;
	
	@FindBy (how = How.ID, using = "PaymentModesViewIsPopuperrorLabel")
	private WebElement paymentModeLanguageErrorLabel;
	
	@FindBy (how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
	private WebElement paymentModesTabView;
	
	@FindBy (how = How.ID, using = "PaymentModesViewIsPopupPaymentModeNameKey2input-text")
	private WebElement paymentModesLangTextbox;
	
	@FindBy (how = How.ID, using = "PaymentModesViewIsPopuptabs2")
	private WebElement paymentModesLangTab;
	
	@FindBy(how =  How.XPATH, using ="//label[text()='PhonePay']")
	public WebElement newPaymentMode;
	
	@FindBy(how =  How.XPATH, using ="//label[text()='Gpay']")
	public WebElement updatedPaymentMode;
	
	@FindBy (how = How.ID, using = "PaymentModesViewDeleteActionKey")
	private WebElement paymentModesDeleteButton;
	
	@FindBy (how = How.ID, using = "OkActionKey")
	private WebElement paymentModesDeleteOkButton;
	
	@FindBy (how = How.ID, using = "CancelActionKey")
	private WebElement paymentModesDeleteCancelButton;
	
	@FindBy (how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement paymentModeAddEditLabel;
	
	
	
	public MD_PaymentMode(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void selectPaymentModesTab()throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, paymentModesTab);
		scrollAndWait(0, 5000, 0);
		javascriptClick(paymentModesTab);
	}
	public void clickOnPaymentModesAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, paymentModesAddButton);
		javascriptClick(paymentModesAddButton);
	}	
	 public void addPaymentMode(String payementMode) throws InterruptedException {
	        waitForElement(driver, paymentModesTextbox);
	        paymentModesTextbox.sendKeys(payementMode);
	 }
	 
	public void addValidPaymentMode(String paymentMode) throws InterruptedException {
		TestConfig.PrintMethodName();
		log("Crete Payement Mode");
		try {
			waitForElement(driver, paymentModesAddButton);
		} catch (Exception e) {
			selectPaymentModesTab();
			paymentModesAddButton.click();
		}
		paymentModesTextbox.click();
		paymentModesTextbox.sendKeys(paymentMode);
		paymentModesLangTab.click();		
		javascriptClick(paymentModesLangTextbox);	
		scrollAndWait(0, 5000, 0);
		paymentModesLangTextbox.sendKeys(paymentMode);		
		javascriptClick(paymentModesSaveButton);
} 
	public void clickOnPaymentModesSaveButton()throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, paymentModesSaveButton);
		scrollAndWait(0, 5000, 0);
		javascriptClick(paymentModesSaveButton);
	}	
	public boolean isPaymentModeTextboxErrorLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver,paymentModeTextboxErrorLabel);
			isPresent = paymentModeTextboxErrorLabel.isDisplayed();
			return isPresent;
	} catch (Exception e) {
		log ("PaymentMode textbox error label is not visible");
		return isPresent;
	}
	}
	public boolean isPaymentModeLanguageErrorLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver,paymentModeLanguageErrorLabel);
			isPresent = paymentModeLanguageErrorLabel.isDisplayed();
			return isPresent;
	} catch (Exception e) {
		log ("Payment Mode Language error label is not visible");
		return isPresent;
	}
	}
	public boolean isPaymentModeTabTextDisplayed() {
        TestConfig.PrintMethodName();
        boolean isPresent = false;
        try {
            waitForElement(driver, paymentModesTabView);
            isPresent = paymentModesTabView.isDisplayed();
            return isPresent;
        } catch (Exception e) {
            log("Payment Mode error label is not visible");
            return isPresent;
        }
    }
	public void clearPaymentModesTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, paymentModesTextbox);
		paymentModesTextbox.clear();
	} 
	public void editPaymentMode(String text) throws InterruptedException {
        waitForElement(driver, paymentModesTextbox);      
        paymentModesTextbox.click();
		paymentModesTextbox.clear();
		paymentModesTextbox.sendKeys(text);
		scrollAndWait(0, 5000, 0);
		javascriptClick(paymentModesLangTab);		
		javascriptClick(paymentModesLangTextbox);	
		paymentModesLangTextbox.clear();
		scrollAndWait(0, 5000, 0);
		paymentModesLangTextbox.sendKeys(text);
 }
	public void clickOnCreatedPaymentMode()throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, newPaymentMode);
		javascriptClick(newPaymentMode);
	}
	public void clickOnPaymentModesDeleteOkButton(String text) throws InterruptedException {
        waitForElement(driver, paymentModesDeleteButton);
        javascriptClick(paymentModesDeleteButton);
		scrollAndWait(0, 3000, 0); 
        javascriptClick(paymentModesDeleteOkButton);
 }
	public void clickOnUpdatedPaymentMode()throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, updatedPaymentMode);
		scrollAndWait(0, 3000, 0);
		javascriptClick(updatedPaymentMode);
	}
	public void clickOnPaymentModesDeleteCancelButton()throws InterruptedException {
		TestConfig.PrintMethodName();
		waitForElement(driver, paymentModesDeleteCancelButton);		
		javascriptClick(paymentModesDeleteButton);
		scrollAndWait(0, 3000, 0); 
		javascriptClick(paymentModesDeleteCancelButton);		
	}
	public boolean isPaymentModeAddEditLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver,paymentModeAddEditLabel);
			isPresent = paymentModeAddEditLabel.isDisplayed();
			return isPresent;
	} catch (Exception e) {
		log ("PaymentMode textbox error label is not visible");
		return isPresent;
	}
	}	
}
