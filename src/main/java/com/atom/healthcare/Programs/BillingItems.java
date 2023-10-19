package com.atom.healthcare.Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import com.atom.healthcare.util.BasePageObject;

public class BillingItems extends BasePageObject {
	public BillingItems(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (how=How.XPATH, using="(//li[text()='Billing Items'])")
	 private WebElement billItemstab;

	@FindBy(how = How.ID,using="(//div[@id='ProgramBillingItemAddEditBillsKey']/div[1]/label)")
	private WebElement billingItemsLable;
	
	@FindBy(how=How.ID,using="ProgramBillingItemAddEditBillsKeySearchTextKey")
	private WebElement searchbox;
	
	@FindBy(how=How.ID,using="ProgramBillingItemAddEditBillsKeyAddActionKey")
	private WebElement addEdit;
	
	@FindBy(how=How.XPATH,using="(//label[text()='Item'])")
	private WebElement item;
	
	@FindBy(how=How.XPATH,using="(//label[text()='Amount'])")
	private WebElement amount;
	
	@FindBy(how=How.ID,using="ProgramBillingItemAddEditBillsKeyerrorLabel")
	private WebElement billsKeyerrorLabel;
		
	@FindBy(how=How.ID, using="ProgramsViewSaveActionKey")
	private WebElement save;
	
	@FindBy (how=How.ID, using="ProgramsViewCancelActionKey")
	private WebElement cancel;
	
	
}


