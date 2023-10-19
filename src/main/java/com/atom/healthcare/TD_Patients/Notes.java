package com.atom.healthcare.TD_Patients;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Notes {



@FindBy(how=How.XPATH,using="//li[@id='PatientProviderNotesView']/span")
private WebElement notestab;

@FindBy(how=How.XPATH,using="//li[@id='PatientProviderNotesView']/span")
private WebElement notescount;

@FindBy (how=How.XPATH,using="PatientProviderNotesViewSearchTextKey")
private WebElement searchbox;

@FindBy(how=How.ID,using="PatientProviderNotesViewAddActionKey")
private WebElement addEdit;

@FindBy (how=How.ID,using="PatientProviderNotesViewNoDataFoundKey")
private WebElement errorlabel;

}