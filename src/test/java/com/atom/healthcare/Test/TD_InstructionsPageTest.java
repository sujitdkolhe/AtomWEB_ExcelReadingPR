package com.atom.healthcare.Test;
import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.atom.healthcare.MainPage.AlphaMDMainPage;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.TD_CareProgram.TD_InstructionsPage;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;

public class TD_InstructionsPageTest extends BasePageTestNG{
	
	/*
	 * This method is to get data from "TD_InstructionsPageTest" sheet it will
	 * compare scenario column 2
	 */
	private void getDataForInstructions(String className, String testScenario) throws IOException {
		for (Object[] getData : BasePageObject.readExcelFile(className)) {
			if (getData[0].toString().toLowerCase().trim().equals(testScenario.toLowerCase().trim())) {
				AtomHC.instText = (String) getData[1];
				AtomHC.instDescription = (String) getData[2];
			}
		}
	}

	@Test(priority = 1)
	public void testIfInstructionTextAndDescriptionNotEntered() throws Exception {
		TD_LoginPageTest login = new TD_LoginPageTest();
		login.testEnterValidUsernameAndPassword();
		AlphaMDMainPage mainPage = new AlphaMDMainPage(driver);
		mainPage.clickOnOrginazationTab();
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clickOnCareProgramTab();
		inst.clickOnInstructionAddButton();
		try {
			getDataForInstructions(getClassName(), "testIfNoDataEntered");
			inst.createNewInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		SoftAssert softAssert = new SoftAssert();
		log("Verify if Instruction Text and Description Data Not Entered Error message is displayed");
		softAssert.assertTrue(inst.isInstructionTextErrorLabelDisplay(),
				"Instruction text Error Message is not dsplayed");
		softAssert.assertTrue(inst.isInstructionDescriptionErrorLabelDisplay(),
				"Instruction text Error Message is not dsplayed");
		softAssert.assertTrue(inst.isInstructionLangErrorLabelDisplayed(),
				"Instruction text Error Message is not dsplayed");
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void testIfInstructionsTextNotEntered() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		try {
			getDataForInstructions(getClassName(), "testIfInstructionTextNotEntered");
			inst.createNewInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		log("Verify if Instruction Text Not Entered Error message is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionTextErrorLabelDisplay(),
				"Instruction text Error Message is not dsplayed");
	}

	@Test(priority = 3)
	public void testIfInstructionsDescriptionNotEntered() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clearDescriptionTextbox();
		try {
			getDataForInstructions(getClassName(), "testIfInstructionDescriptionNotEntered");
			inst.createNewInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		log("Verify if Description Data Not Entered Error message is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionDescriptionErrorLabelDisplay(),
				"Description error label is not dsplayed");
	}

	@Test(priority = 4)
	public void testIfInstructionsTextEnteredLessThanRangeValue() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clearInstructionText();
		try {
			getDataForInstructions(getClassName(), "testIfInstructionTextEnteredBelowRangeValue");
			inst.createNewInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		log("Verify if Range Data Error message is displayed");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionRangeErrorLabelDisplay(), "Range error label is not dsplayed");
	}

	@Test(priority = 5)
	public void testIfInstructionIsCreated() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clearInstructionText();
		try {
			getDataForInstructions(getClassName(), "testIfNewInstructionCreatedWithValidData");
			inst.createNewInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		log("Verify Instruction is Created");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionTabDisplayed(), "Instruction is not Created");
	}

	@Test(priority = 6)
	public void testIfInstructionIsUpdated() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clickOnCreatedInstructions();
		try {
			getDataForInstructions(getClassName(), "testIfInstructionIsUpdated");
			inst.updateInstructions(AtomHC.instText, AtomHC.instDescription);
		} catch (SkipException e) {
			throw new SkipException("Skipping this exception");
		}
		inst.clickOnInstructionSaveButton();
		log("Verify Instruction is Created");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionTabDisplayed(), "Instruction is not Updated");
	}

	@Test(priority = 7)
	public void testIfInstructionIsDeleted() throws Exception {
		TD_InstructionsPage inst = new TD_InstructionsPage(driver);
		inst.clickOnUpdatedInstructions();
		inst.clickOnDeleteButton();
		inst.clickOnOkButton();
		log("Verify Instruction is Deleted");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(inst.isInstructionTabDisplayed(), "Instruction is not Deleted");
	}
}