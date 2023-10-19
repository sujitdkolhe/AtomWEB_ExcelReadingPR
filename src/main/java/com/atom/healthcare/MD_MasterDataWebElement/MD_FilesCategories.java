package com.atom.healthcare.MD_MasterDataWebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.BasePageTestNG;
import com.atom.healthcare.util.TestConfig;


	public class MD_FilesCategories extends BasePageObject  {

		
		@FindBy(how = How.ID, using = "FilesCategoriesView")
		private WebElement filesCategoriesViewTab;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewAddActionKey")
		private WebElement filesCAddButton;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryNameKey1input-text")
		private WebElement filesCNameTextbox;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryNameKey2input-text")
		private WebElement filesCNameLangTabTextbox;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryDescriptionKey2input-textArea")
		private WebElement filesCDescriptionLangTabTextbox;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryDescriptionKey1input-textArea")
		private WebElement filesCDescriptionTextbox;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewSaveActionKey")
		private WebElement filesCSaveButton;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryImageNameKeyinput-fieImageUploadControl")
		private WebElement filesCImageControl;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryImageNameKeyerrorLabel")
		private WebElement filesCImageErrorLabel;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryNameKey1errorLabel")
		private WebElement filesCNameErrorLabel;
				
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryDescriptionKey1errorlabel")
		private WebElement filesCDescriptionErrorLabel;		
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopuperrorLabel")
		private WebElement filesCLangErrorLabel;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopuptabs2")
		private WebElement filesCLangTab;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryImageNameKeyerrorLabel")
		private WebElement fileImageValidationError;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewIsPopupFileCategoryImageNameKeyDeleteActionKey")
		private WebElement fileImageDeleteButton;
		
		@FindBy (how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12']")
		private WebElement fileCategoryLabel;
		
		@FindBy (how = How.XPATH, using = "//label[text()='BloodReport']")
		private WebElement newFileCategoryName;
		
		@FindBy(how = How.ID, using = "FilesCategoriesViewCancelActionKey")
		private WebElement fileCategoriesCancelButton;
		
		@FindBy (how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
		private WebElement fileCategoryAddEditLabel;
		
		@FindBy (how = How.XPATH, using = "//label[text()='Health LifeStyle']")
		private WebElement  updatedFileCategoryName;
		
		@FindBy(how = How.ID, using = "CancelActionKey")
		private WebElement fileCategoriesDeleteCancelButton;

		@FindBy (how = How.XPATH, using = "(//label[@class='lbl-error-body-large-semi-bold label-button']")
		private WebElement fileCategoryDeleteButton;
		
		@FindBy(how = How.ID, using = "OkActionKey")
		private WebElement fileCategoriesDeleteOkButton;
		
		
		public MD_FilesCategories(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}		
		public void clickOnFilesCategoriesViewTab() {
			TestConfig.PrintMethodName();
			waitForElement(driver, filesCategoriesViewTab);
			javascriptClick(filesCategoriesViewTab);
		}	
		public void clickOnFilesCategoriesAddButton() {
			TestConfig.PrintMethodName();
			waitForElement(driver, filesCAddButton);
			javascriptClick(filesCAddButton);
		}			
		public void addFilesCategories(String FileCName,String FileCDescription) throws InterruptedException {
	        waitForElement(driver, filesCAddButton);	
	        filesCNameTextbox.sendKeys(FileCName);
	        filesCDescriptionTextbox.sendKeys(FileCDescription);	        	  
	 }
		public void uploadFileCategoryImage(String image) {
			TestConfig.PrintMethodName();			
			waitForElement(driver,  filesCImageControl);		
			filesCImageControl.sendKeys(image);
		}				
		public void clickOnFilesCSaveButton() {
			TestConfig.PrintMethodName();
			waitForElement(driver, filesCSaveButton);
			javascriptClick(filesCSaveButton);
		}
		public boolean isFilesCImageErrorLabelDisplayed() {
	        TestConfig.PrintMethodName();
	        boolean isPresent = false;
	        try {
	            waitForElement(driver, filesCImageErrorLabel);
	            isPresent = filesCImageErrorLabel.isDisplayed();
	            return isPresent;
	        } catch (Exception e) {
	            log("File Category name error label is not visible");
	            return isPresent;
	        }
	    }
		public boolean isFilesCNameErrorLabelDisplayed() {
	        TestConfig.PrintMethodName();
	        boolean isPresent = false;
	        try {
	            waitForElement(driver, filesCNameErrorLabel);
	            isPresent = filesCNameErrorLabel.isDisplayed();
	            return isPresent;
	        } catch (Exception e) {
	            log("File Category name error label is not visible");
	            return isPresent;
	        }
	    }
		public boolean isFilesCDescriptionErrorLabelDisplayed() {
	        TestConfig.PrintMethodName();
	        boolean isPresent = false;
	        try {
	            waitForElement(driver, filesCDescriptionErrorLabel);
	            isPresent = filesCDescriptionErrorLabel.isDisplayed();
	            return isPresent;
	        } catch (Exception e) {
	            log("File Category Description error label is not visible");
	            return isPresent;
	        }
		}
	        public boolean isFilesCLangErrorLabelDisplayed() {
	        TestConfig.PrintMethodName();
	        boolean isPresent = false;
	        try {
	            waitForElement(driver, filesCLangErrorLabel);
	            isPresent = filesCLangErrorLabel.isDisplayed();
	            return isPresent;
	        } catch (Exception e) {
	            log("Language Text error label is not visible");
	            return isPresent;
	        }
	    }	    	
//	    	public void addFileCName(String file) throws InterruptedException {
//	            waitForElement(driver, filesCNameTextbox);      
//	            filesCNameTextbox.click();
//	            filesCNameTextbox.clear();
//	            filesCNameTextbox.sendKeys(file);
//	    		
//	     }
//	    	public void addFilesCDescription(String file) throws InterruptedException {
//	            waitForElement(driver, filesCNameTextbox);      
//	            filesCDescriptionTextbox.click();
//	            filesCDescriptionTextbox.clear();
//	            filesCDescriptionTextbox.sendKeys(file);            
//	    		
//	     }
	    	public void clearFilesCNameTextbox() {
	    		TestConfig.PrintMethodName();
	    		waitForElement(driver, filesCNameTextbox);
	    		filesCNameTextbox.clear();
	    	} 
	    	public void clearFilesCDescriptionTextbox() {
	    		TestConfig.PrintMethodName();
	    		waitForElement(driver,  filesCDescriptionTextbox);
	    		 filesCDescriptionTextbox.clear();
	    	} 
	    	
	    	 public boolean isFileImageValidationErrorLabelDisplayed() {
		        TestConfig.PrintMethodName();
		        boolean isPresent = false;
		        try {
		            waitForElement(driver, fileImageValidationError);
		            isPresent = fileImageValidationError.isDisplayed();
		            return isPresent;
		        } catch (Exception e) {
		            log("Language Text error label is not visible");
		            return isPresent;
		        }
		    }	
	    		public void clickOnFilesCImageControl() {
		    		TestConfig.PrintMethodName();
		    		waitForElement(driver,  filesCImageControl);
		    		javascriptClick(filesCImageControl);
		    	} 
		    	
	    		public void clickOnFileImageDeleteButton() {
		    		TestConfig.PrintMethodName();
		    		waitForElement(driver,  fileImageDeleteButton);
		    		javascriptClick(fileImageDeleteButton);
		    	} 
	    		public void createFileCategory(String image,String FileCName,String FileCDescription) {
		    		TestConfig.PrintMethodName();
		    		waitForElement(driver,filesCImageControl);
		    		filesCImageControl.sendKeys(image);
		    		javascriptClick(filesCNameTextbox);
		    		waitForElement(driver,filesCNameTextbox);
		    		filesCNameTextbox.clear();
		    		filesCNameTextbox.sendKeys(FileCName);
		    		javascriptClick(filesCDescriptionTextbox);
		    		filesCDescriptionTextbox.clear();
		    		filesCDescriptionTextbox.sendKeys(FileCDescription);	
		    		javascriptClick(filesCLangTab);
		    		javascriptClick(filesCNameLangTabTextbox);
		    		filesCNameLangTabTextbox.sendKeys(FileCName);
		    		javascriptClick(filesCDescriptionLangTabTextbox);
		    		filesCDescriptionLangTabTextbox.sendKeys(FileCDescription);			    		
		    	} 
	    		 public boolean isFileCategoryLabelDisplayed() {
	 		        TestConfig.PrintMethodName();
	 		        boolean isPresent = false;
	 		        try {
	 		            waitForElement(driver, fileCategoryLabel);
	 		            isPresent = fileCategoryLabel.isDisplayed();
	 		            return isPresent;
	 		        } catch (Exception e) {
	 		            log("File Category label is not visible");
	 		            return isPresent;
	 		        }
	 		    }
	    		 public void clickOnNewFileCategoryName() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  newFileCategoryName);
			    		javascriptClick(newFileCategoryName);
			    	} 
	    		 public void clickOnFileCategoriesCancelButton() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  fileCategoriesCancelButton);
			    		javascriptClick(fileCategoriesCancelButton);
			    	} 
	    		 public boolean isFileCategoryAddEditLabelDisplayed() {
		 		        TestConfig.PrintMethodName();
		 		        boolean isPresent = false;
		 		        try {
		 		            waitForElement(driver, fileCategoryAddEditLabel);
		 		            isPresent = fileCategoryAddEditLabel.isDisplayed();
		 		            return isPresent;
		 		        } catch (Exception e) {
		 		            log("File Category Add Edit label is not visible");
		 		            return isPresent;
		 		        }
		 		    }
	    		 public void updatedFileCategory(String image,String FileCName,String FileCDescription) {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  filesCDescriptionTextbox);
			    		javascriptClick(fileImageDeleteButton);
			    		filesCImageControl.sendKeys(image);
			    		javascriptClick(filesCNameTextbox);
			    		filesCNameTextbox.clear();
			    		filesCNameTextbox.sendKeys(FileCName);
			    		javascriptClick(filesCDescriptionTextbox);
			    		filesCDescriptionTextbox.clear();
			    		filesCDescriptionTextbox.sendKeys(FileCDescription);	
			    		javascriptClick(filesCLangTab);
			    		filesCNameLangTabTextbox.clear();
			    		javascriptClick(filesCNameLangTabTextbox);
			    		filesCNameLangTabTextbox.sendKeys(FileCName);
			    		filesCDescriptionLangTabTextbox.clear();
			    		javascriptClick(filesCDescriptionLangTabTextbox);
			    		filesCDescriptionLangTabTextbox.sendKeys(FileCDescription);			    		
			    	} 
	    		 public void clickOnUpdatedFileCategoryName() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  updatedFileCategoryName);
			    		javascriptClick(updatedFileCategoryName);
			    	} 
	    		 public void clickOnFileCategoriesDeleteCancelButton() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  fileCategoriesDeleteCancelButton);
			    		javascriptClick(fileCategoriesDeleteCancelButton);
			    	} 
	    		 public void clickOnFileCategoryDeleteButton() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  fileCategoryDeleteButton);
			    		javascriptClick(fileCategoryDeleteButton);
			    	} 
	    		 public void clickOnFileCategoryDeleteOkButton() {
			    		TestConfig.PrintMethodName();
			    		waitForElement(driver,  fileCategoriesDeleteOkButton);
			    		javascriptClick(fileCategoriesDeleteOkButton);
			    	} 
	    		 	 
}
