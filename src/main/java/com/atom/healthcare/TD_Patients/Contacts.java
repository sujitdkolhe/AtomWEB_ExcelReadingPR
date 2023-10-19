package com.atom.healthcare.TD_Patients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Contacts {



@FindBy (how=How.ID, using="PatientContactsView")
private WebElement patientContactsViewtab;

@FindBy (how=How.XPATH,using="//div[@id='PatientContactsView']/div[1]/label")
private WebElement contactscount;

@FindBy (how=How.ID,using="PatientContactsViewSearchTextKey")
private WebElement serachbox;

@FindBy (how=How.ID,using="PatientContactsViewAddActionKey")
private WebElement addEdit;

@FindBy (how=How.XPATH,using="//label[text()='Contact']")
private WebElement contactlabel;

@FindBy(how=How.XPATH,using="//label[text()='Type']")
private WebElement typelabel;

@FindBy(how=How.XPATH,using="//label[text()='Details']")
private WebElement detailslabel;

@FindBy(how=How.ID,using="PatientContactsViewerrorLabel")
private WebElement errorlabel;
}








