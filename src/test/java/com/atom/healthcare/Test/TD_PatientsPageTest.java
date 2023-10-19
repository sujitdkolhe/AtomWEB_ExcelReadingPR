package com.atom.healthcare.Test;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.Pojo.CommonMethods;
import com.atom.healthcare.TD_Patients.TD_PatientsPage;
import com.atom.healthcare.util.BasePageTestNG;

public class TD_PatientsPageTest extends BasePageTestNG {

	@Test(priority = 1)
	public void testCreatePatient() throws Exception {
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_PatientsPage patientPage = new TD_PatientsPage(driver);
		patientPage.clickOnPatientsTab();
		patientPage.clickOnAddButton();
		try {
			log("Create Patient");
			CommonMethods.getDataForCreatePatients(getClassName(), "CreateNewPatient");
			 patientPage.uploadProfileImage(System.getProperty("user.dir") +
			 AtomHC.ptProfileImage);
			patientPage.creatPatient(AtomHC.ptFirstName, AtomHC.ptMidName, AtomHC.ptLastName, AtomHC.ptGenderName,
					AtomHC.ptDOB, AtomHC.ptBloodGrp, AtomHC.ptPreferredLang, AtomHC.socialSecurNum, AtomHC.internalCode,
					AtomHC.externalCode, AtomHC.ptMobileNum, AtomHC.PtEmail);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		log("Verify if created patient is display");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(patientPage.isPatientProfileDisplay(), "Patient profile is not display");
		softAssert.assertTrue(patientPage.isPatientNameOnCardDetailsDisplay(), "Patient name is not display");
		softAssert.assertTrue(patientPage.isPatientAgeAndGenderDetailsDisplay(),
				"Patient age and gendert is not display");
		softAssert.assertTrue(patientPage.isPatientMobileNoInCardDetailsDisplay(),
				"Patient mobile number on card details iod not display");
		softAssert.assertTrue(patientPage.isPatientEmailInCardDetailsDisplay(),
				"Patient Email on card details iod not display");
		softAssert.assertAll();

	}

}
