package com.atom.healthcare.TD_Patients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientBills {

@FindBy (how=How.ID,using="PatientBillsView")
private WebElement patientbillstab;

@FindBy (how=How.XPATH,using="//div[@id='PatientBillsView']/label")
private WebElement billscount;

@FindBy (how=How.ID,using="PatientBillsViewSearchTextKey")
private WebElement searchbox;

@FindBy (how=How.ID,using="PatientBillsViewAddActionKey")
private WebElement addEdit;

@FindBy (how=How.XPATH,using="//label[text()='Bill Date']")
private WebElement billdatelabel;

@FindBy (how=How.XPATH,using="//label[text()='Name']")
private WebElement name;

@FindBy (how=How.XPATH,using="//label[text()='Amount Paid']")
private WebElement amountpaid;

@FindBy (how=How.XPATH,using="//label[text()='Payment Mode']")
private WebElement paymentmode;

@FindBy (how=How.XPATH,using="id=PatientBillsViewerrorLabel")
private WebElement errorlabel;

}
