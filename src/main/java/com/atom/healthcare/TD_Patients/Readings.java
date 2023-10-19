package com.atom.healthcare.TD_Patients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Readings {
	
	@FindBy(how=How.XPATH,using="//li[@id='PatientReadingsView']/span")
	private WebElement readingstab;
	
	@FindBy (how=How.XPATH,using="//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-5 col-sm-12 px-0']")
	private WebElement readingslabel;
	
	@FindBy (how=How.ID,using="AddActionKey")
	private WebElement add;
	
	@FindBy (how=How.XPATH,using="//img [@class=\"margin-horizontal-xxs margin-bottom-xxs \"]")
	private WebElement vitalsimg;
	
	@FindBy (how=How.XPATH,using="//label [text()=\"Vitals\"]")
	private WebElement vitals;
		
	@FindBy (how=How.XPATH,using="//label [text()=\"Lab Values\"]")
	private WebElement lablable;
	
	@FindBy (how=How.XPATH,using="//label [text()=\"Food\"]")
	private WebElement food;
		
	@FindBy (how=How.XPATH,using="//label [text()=\"Exercise\"]")
	private WebElement exerciselabel;
	
	@FindBy (how=How.XPATH,using="//span [@class=\"lbl-primary-text-header-5-semi-bold ui-align-center text-center\"]")	
	private WebElement norecordlable;

}
