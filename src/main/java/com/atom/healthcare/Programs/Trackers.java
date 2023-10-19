package com.atom.healthcare.Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;

public class Trackers extends BasePageObject {
	
	public Trackers(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

}
	//@FindBy (how=How.XPATH, using="(//li[text()='Billing Items'])")
	// private WebElement billItemstab;
	
	@FindBy (how=How.XPATH, using="(//li[text()='Trackers'])")
	private WebElement trackerstab;
	
	@FindBy(how=How.ID,using="//div [@id='ProgramTrackerAddEditTrackerKey']/div[1]/label")
	private WebElement trackerslabel;
			
	@FindBy (how=How.ID,using="ProgramTrackerAddEditTrackerKeyerrorLabel")
	private WebElement errorlabel;
		
	@FindBy (how=How.ID, using="ProgramTrackerAddEditTrackerKeySearchTextKey")
	private WebElement searchbox;
	
	@FindBy (how=How.XPATH,using="(//label[text()='Tracker Name'])")
	private WebElement trackernamelabel;
	
	@FindBy (how=How.XPATH,using="(//label[text()='Assign After Days'])[6]")
	private WebElement assignafterdayslabel;
	
	@FindBy (how=How.XPATH,using="(//label[text()='Show For Days'])[6]")
	private WebElement showfordays;
		
	@FindBy(how=How.ID,using="ProgramsViewSaveActionKey")
	private WebElement save;
	
	@FindBy(how=How.ID,using="ProgramsViewCancelActionKey")
	private WebElement cancel;
	
	
	
	
	
	
	
}