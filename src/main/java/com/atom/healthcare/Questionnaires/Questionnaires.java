package com.atom.healthcare.Questionnaires;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BasePageObject;
import com.atom.healthcare.util.TestConfig;

public class Questionnaires extends BasePageObject {

	@FindBy(how = How.XPATH, using = "//label[text()='Questionnaires']")
	private WebElement questionnairesTab;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold margin-bottom-md margin-top-xxs col-xl-7 col-md-5 col-sm-12 \"]")
	private WebElement questionnairesTitle;

	@FindBy(how = How.XPATH, using = "//img[@class=\"icon-left img-icon-medium ltr\"]")
	private WebElement searchTextboxIcon;

	@FindBy(how = How.XPATH, using = "//input[@class='input-primary-padded ltr']")
	private WebElement searchTextbox;

	@FindBy(how = How.ID, using = "QuestionnairesViewAddActionKey")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs\"]")
	private WebElement questionnairesAddTitle;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditCancelActionKey")
	private WebElement cancelButton;

	@FindBy(how = How.XPATH, using = "//label[@class=\"questionnaire-marker-active cursor-pointer\"]")
	private WebElement questionnaireStep1;

	@FindBy(how = How.XPATH, using = "//label[text()=\"Questions\"]")
	private WebElement questionsStep2;

	@FindBy(how = How.XPATH, using = "//label[text()=\"Questionnaire questions\"]")
	private WebElement questionnaireQuestionsStep3;

	@FindBy(how = How.XPATH, using = "//label[text()=\"Score Type\"]")
	private WebElement scoreTypeStep4;

	@FindBy(how = How.XPATH, using = "//label[text()=\"Question scores\"]")
	private WebElement QuestionScoreStep5;

	@FindBy(how = How.XPATH, using = "//label[text()=\"Subscales\"]")
	private WebElement subscalesStep6;

	@FindBy(how = How.XPATH, using = "//div[@class='row col px-0 mr-0 ml-0']")
	private WebElement questionnairesList;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-5-semi-bold text-center truncate'])[1]")
	private WebElement questionsTitle;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-center'])[1]")
	private WebElement questionCreatedDate;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular text-start truncate'])[1]")
	private WebElement numberOfQuestion;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-semi-bold'])[1]")
	private WebElement questionSubscale;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular'])[2]")
	private WebElement questionAssignValue;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-secondary-text-body-medium-regular'])[2]")
	private WebElement questionSubscaleValue;

	@FindBy(how = How.XPATH, using = "(//div[@class='margin-top-lg text-center'])[1]")
	private WebElement questionnairesStatus;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditUnpublishKey")
	private WebElement unpublishStatus;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditPublishKey")
	private WebElement publishStatus;

	@FindBy(how = How.XPATH, using = "//img[@class='avatar-circle d-flex']")
	private WebElement cardFormat;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-5-semi-bold text-center truncate'])[1]")
	private WebElement questionTitle;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement noQuestionnairRecordAdded;

	@FindBy(how = How.XPATH, using = "//label[@class='badge-error-fill-dark']")
	private WebElement questionnairStatus;

	@FindBy(how = How.XPATH, using = "(//label[text()='Questionnaire'])[1]")
	private WebElement questionnairTitle;

	@FindBy(how = How.ID, using = "QuestionnairesView521")
	private WebElement questionnairesName;

	@FindBy(how = How.XPATH, using = "//label[text()='2. Questions']")
	private WebElement questionsLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[1]")
	private WebElement questionsCountLabel;

	@FindBy(how = How.XPATH, using = "//span[@class='lbl-primary-text-header-5-semi-bold ui-align-center text-center']")
	private WebElement noQuestionnaireRecordAdded;

	@FindBy(how = How.XPATH, using = "//label[@class='badge-error-fill-dark']")
	private WebElement questionnaireStatus;

	@FindBy(how = How.XPATH, using = "(//label[text()='Questionnaire'])[1]")
	private WebElement questionnaireTitle;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditCancelActionKey")
	private WebElement questionnaireCancelButton;

	@FindBy(how = How.XPATH, using = "//button[@id='QuestionnaireAddEditUnpublishKey'][contains(.,'Unpublish')]")
	private WebElement unPublishStatus;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker-active cursor-pointer'][contains(.,'1. Questionnaire')]")
	private WebElement questionnaireTab;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker'][contains(.,'3. Questionnaire questions')]")
	private WebElement questionnaireQuesTab;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker'][contains(.,'4. Score Type')]")
	private WebElement scoreTypeTab;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker'][contains(.,'5. Question scores')]")
	private WebElement questionScoresTab;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker'][contains(.,'6. Subscales')]")
	private WebElement subscalesTab;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])[2]")
	private WebElement step1QuestionnaireTitle;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[2]")
	private WebElement questionnnaireTypeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[3]")
	private WebElement codeLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[4]")
	private WebElement quesDefaultRespodantLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[5]")
	private WebElement questionnnaireTitleLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[6]")
	private WebElement instructionsLabel;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditQuestionnaireTypeKeyinput-text")
	private WebElement questTypeTextbox;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditCodeTextKeyinput-text")
	private WebElement codeTextbox;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditDefaultRespondantKeyinput-text")
	private WebElement questDefaultRespondantTextbox;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditQuestionnaireTitleTextKey1input-text")
	private WebElement questTitleTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor ql-blank'])[1]")
	private WebElement instructionsTextbox;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditSave&NextActionKey")
	private WebElement saveAndNextLabel;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='QuestionnaireAddEditQuestionnaireTypeKeyListItems']/li") })
	private List<WebElement> quesTypeDropdownList;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[2]")
	private WebElement drpdown;

	// @FindBy(how = How.XPATH, using = "(//label[@class='questionnaire-marker
	// cursor-pointer'])[1]")
	// private WebElement questionsTab;

	@FindBy(how = How.ID, using = "QuestionsViewSave&NextActionKey")
	private WebElement questionsSaveAndNextLabel;

	@FindBy(how = How.ID, using = "QuestionsViewListSearchTextKey")
	private WebElement questionsSearchTextbox;

	@FindBy(how = How.ID, using = "QuestionsViewListAddActionKey")
	private WebElement questionsAddButton;

	@FindBy(how = How.XPATH, using = "(//div[@class='table-header w-available mx-2'])[1]")
	private WebElement questionsTableList;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditQuestionnaireTypeKeylabel817")
	private WebElement questionnaireTypeStandard;

	@FindBy(how = How.ID, using = "QuestionsViewListerrorLabel")
	private WebElement questionsViewListerrorLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Question'])[1]")
	private WebElement questionsViewQuestionTableLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Question Type'])[1]")
	private WebElement questionsViewQuestionTypeTableLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Add to medical history?'])[1]")
	private WebElement questionsViewMedicalHistoryTableLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Is Required'])[1]")
	private WebElement questionsViewIsRequiredTableLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement questionsAddLabel;

	@FindBy(how = How.XPATH, using = "(//label[contains(.,'3. Questionnaire questions')])[2]")
	private WebElement questionnaireQuestionsHeaderLabel;

	@FindBy(how = How.XPATH, using = "//label[@class='questionnaire-marker-active']")
	private WebElement questionnaireQuestionsActiveTab;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[3]")
	private WebElement questDefaultRespondant;

	@FindAll({ @FindBy(how = How.XPATH, using = "//ui[@id='QuestionnaireAddEditDefaultRespondantKeyListItems']/li") })
	private List<WebElement> questDefaultRespondantList;

	@FindBy(how = How.XPATH, using = "//li[text()='Provider']")
	private WebElement providerDefaultRespondant;

	@FindBy(how = How.XPATH, using = "(//input[@id='QuestionnaireAddEditQuestionnaireTypeKeyinput-text'])[1]")
	private WebElement questTypeTextboxHighlight;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary error-border ltr'])[1]")
	private WebElement codeTextboxHighlight;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select error-border ltr'])[2]")
	private WebElement quesDefaultRespondantTextboxHighlight;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary error-border ltr'])[2]")
	private WebElement quesTitleTextboxHighlight;

	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireAddEditQuestionnaireTypeKeyerrorLabel']")
	private WebElement quesTypeErrorMessage;

	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireAddEditCodeTextKeyerrorLabel']")
	private WebElement codeErrorMessage;

	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireAddEditDefaultRespondantKeyerrorLabel']")
	private WebElement quesDefaultRespondantErrorMessage;

	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireAddEditQuestionnaireTitleTextKey1errorLabel']")
	private WebElement quesTitleErrorMessage;

	@FindBy(how = How.XPATH, using = "(//li[@class='lbl-primary-text-body-large-regular ltr'])[3]")
	private WebElement standardType;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])[3]")
	private WebElement questionsHeader;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement questionTabAddEditLabel;

	@FindBy(how = How.XPATH, using = "(//label[text()='Question Type'])[2]")
	private WebElement questionAddQuestionTypeLabel;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement questionAddQuestionTypeDropdown;

	@FindAll(@FindBy(how = How.XPATH, using = "(//ui[@id='QuestionAddEditQuestionTypeKeyListItems'])/li"))
	private List<WebElement> questionAddQuestionTypeList;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditIsPopupIsRequiredKeycheckbox")
	private WebElement questionAddIsRequiredKeycheckbox;

	@FindBy(how = How.XPATH, using = "QuestionnaireAddEditIsPopupAddToMedicalHistoryKeycheckbox")
	private WebElement questionAddAddToMedicalHistoryKeycheckbox;

	@FindBy(how = How.ID, using = "QuestionAddEditPageDetailsQuestionKey1")
	private WebElement questionAddQuestionRichTextbox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Answer Placeholder']")
	private WebElement questionAnswerPlaceHolderText;

	@FindBy(how = How.ID, using = "QuestionAddEditPageDetailsAnswerPlaceHolderTextKey1input-text")
	private WebElement questionAddEnterAnswerPlaceholderTextbox;

	@FindBy(how = How.XPATH, using = "(//label[text()='Instructions'])[2]")
	private WebElement questionAddInstructionsLabel;

	@FindBy(how = How.ID, using = "QuestionAddEditPageDetailsQuestionInstructionsTextKey1")
	private WebElement questionAddInstructionsTextbox;

	@FindBy(how = How.ID, using = "//button[@class='btn btn-secondary float-right']")
	private WebElement questionAddCancelButton;

	@FindBy(how = How.ID, using = "QuestionAddEditSaveActionKey")
	private WebElement questionAddSaveButton;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement questionAddCancelIcon;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel298")
	private WebElement questionAddQuestionTypeDate;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	private WebElement questionAddMinLabel;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[10]")
	private WebElement questionAddMaxLabel;

	@FindBy(how = How.ID, using = "QuestionAddEditMinKeyinput-text")
	private WebElement questionAddMinTextbox;

	@FindBy(how = How.ID, using = "QuestionAddEditMaxKeyinput-text")
	private WebElement questionAddMaxTextbox;

	@FindBy(how = How.ID, using = "QuestionAddEditListSearchTextKey")
	private WebElement setupAnswersSearchTextbox;

	@FindBy(how = How.XPATH, using = "(//label[text()='yes'])")
	private WebElement setupAnswersSearchValue;

	@FindBy(how = How.ID, using = "QuestionAddEditListerrorLabel")
	private WebElement setupAnswersSearchInvalidMessage;

	@FindBy(how = How.XPATH, using = "(//div[@id='QuestionsViewListtable-row0'])[3]")
	private WebElement questionsViewListRow;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])[1]")
	private WebElement questionnaireHeader;

	@FindBy(how = How.XPATH, using = "//li[text()='Date']")
	private WebElement dateQuestionType;

	@FindBy(how = How.XPATH, using = "//input[@id='QuestionAddEditMinKeyinput-text']")
	private WebElement minTextbox;

	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	private WebElement maxTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor ql-blank'])[2]")
	private WebElement questionTextbox;

	@FindBy(how = How.XPATH, using = "//button[@id='QuestionAddEditSaveActionKey']")
	private WebElement questionSaveButton;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])[4]")
	private WebElement questionnaireQuestionHeader;

	@FindBy(how = How.XPATH, using = "//label[text()='Duplicate Data']")
	private WebElement codeDuplicateError;

	@FindBy(how = How.XPATH, using = "(//button[@id='QuestionsViewSave&NextActionKey'])[1]")
	private WebElement questionSaveNext;

	@FindBy(how = How.ID, using = "QuestionnaireAddEditSave&NextActionKey")
	private WebElement questionnaireSaveAndNextLabel;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel300")
	private WebElement richTextDropdown;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor ql-blank'])[2]")
	private WebElement richTextboxQuestionTextbox;

	@FindBy(how = How.XPATH, using = "(//div[@class='ql-editor ql-blank'])[3]")
	private WebElement richTextboxReadOnlyInstructions;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel278")
	private WebElement textDropdown;

	@FindBy(how = How.XPATH, using = "(//div[@contenteditable='true'])[3]")
	private WebElement textboxQuestionTextbox;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded ltr'])[2]")
	private WebElement questionSearchTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[@id='QuestionnaireQuestionsViewListAddActionKey']")
	private WebElement questionAddButton;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[5]")
	private WebElement questionColumn;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[6]")
	private WebElement isStartingQuestionColumn;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[7]")
	private WebElement questionTypeColumn;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-large-semi-bold truncate col cursor-pointer'])[8]")
	private WebElement noOfFlowsColumn;

	@FindBy(how = How.XPATH, using = "//li[text()='what is you name']")
	private WebElement dateQuestion;
	
	@FindBy(how = How.XPATH, using = "//button[@id='QuestionnaireQuestionAddEditSaveActionKey']")
	private WebElement questionnaireQuestionSave;

	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-3-semi-bold col-xl-7 col-md-6 col-sm-12'])[2]")
	private WebElement questionnaireQuestionTitle;
	
	@FindBy(how = How.XPATH, using = "//button[@id='QuestionnaireQuestionsViewListAddActionKey']")
	private WebElement questionnaireQuestionAddButton;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-padded ltr'])[2]")
	private WebElement questionnaireQuestionSearchTextbox;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Date'])[2]")
	private WebElement dateQuestionList;
	
	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireQuestionsViewListerrorLabel']")
	private WebElement questionnaireQuestionNoRecordFound;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-header-2-semi-bold text-start ']")
	private WebElement questionnaireQuestionAddEditPageHeader;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-header-2-semi-bold flex-grow-1 px-0 margin-vertical-xs'])[5]")
	private WebElement scroreTypeHeader;
	
	@FindBy(how = How.XPATH, using = "(//button[@id='QuestionsViewSave&NextActionKey'])[2]")
	private WebElement questionnaireQuestionSaveNextButton;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Question'])[2]")
	private WebElement questionAddQuestionLabel;

	@FindBy(how = How.XPATH, using = "QuestionAddEditPageDetailsAnswerPlaceHolderTextKey1")
	private WebElement questionAddEnterAnswerPlaceholderLabel;

	@FindBy(how = How.XPATH, using = "(//img[@class='cursor-pointer'])[1]")
	private WebElement crosslIcon;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel298")
	private WebElement questionTypeDate;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel278")
	private WebElement  questionTypeText;

	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel277")
	private WebElement questionTypeNumeric;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel280")
	private WebElement questionTypeHorizontalSlider;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel281")
	private WebElement questionTypeVerticalSlider;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel297")
	private WebElement questionTypeDateAndTime;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel299")
	private WebElement questionTypeTime;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel279")
	private WebElement questionTypeMultilineText;
	
	@FindBy(how = How.ID, using = "QuestionAddEditQuestionTypeKeylabel302")
	private WebElement questionTypeDropdown;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[11]")
	private WebElement questionTypeHorizontalSliderLabel;
	
	@FindBy(how = How.ID, using = "QuestionAddEditSliderStepsKeyinput-text")
	private WebElement questionTypeHorizontalSliderTextbox;

	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-large-regular ltr ']")
	private WebElement isStartingQuestionLabel;	
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[8]")
	private WebElement selectQuestionLabel;	
	
	@FindBy(how = How.XPATH, using = "//input[@id='QuestionnaireQuestionAddEditStartingQuestionSelectionKeyinput-text']")
	private WebElement selectQuestionDropdown;	
	
	@FindBy(how = How.XPATH, using = "//button[@id='QuestionnaireQuestionAddEditCancelActionKey']")
	private WebElement questionnaireQuestionCancelButton;

	@FindBy(how = How.XPATH, using = "(//label[text()='Questions'])")
	private WebElement questionsTab;

	@FindBy(how = How.XPATH, using = "(//label[text()='Setup Answers (0)'])")
	private WebElement setupAnswersLabel;

	@FindBy(how = How.ID, using = "QuestionAddEditListAddActionKey")
	private WebElement setupAnsAddButton;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Answer'])")
	private WebElement setupAnsAnswerLabel;
	
	@FindBy(how = How.XPATH, using = "(//label[text()='Sequence No'])")
	private WebElement setupAnsSequenceNoLabel;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Add Answer']")
	private WebElement setupAnsAddAnswerLabel;
	
	@FindBy(how = How.ID, using = "SetupAnswersKeySequenceNoKeyinput-text")
	private WebElement setupAnsSequenceNoTextbox;
	
	@FindBy(how = How.ID, using = "SetupAnswersKeyQuestionnaireQuestionOptionDetailsAnswerKey1input-text")
	private WebElement setupAnsAnswerTextbox;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[5]")
	private WebElement actionDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireQuestionAddEditAddBetweenConditionddl_tooltip']")
	private WebElement addMoreBetweenConditionLinkButton;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[10]")
	private WebElement elseLabel;
	
	@FindBy(how = How.XPATH, using = "//label[@class='lbl-primary-text-body-medium-bold ltr']")
	private WebElement conditionText;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[3]")
	private WebElement value1Textbox;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary  ltr'])[4]")
	private WebElement value2Textbox;
	
	@FindBy(how = How.XPATH, using = "//span[@id='QuestionnaireQuestionAddEditDeleteActionKeycondition0']")
	private WebElement conditionDeleteButton;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[13]")
	private WebElement actionLabel;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[6]")
	private WebElement conditionActionDropdown;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular ltr'])[2]")
	private WebElement andText;
	
	@FindBy(how = How.XPATH, using = "(//input[@class='input-primary-select  ltr'])[4]")
	private WebElement questionnaireQuesSelectQuesDropdown;
	
	@FindBy(how = How.XPATH, using = "(//label[@class='lbl-primary-text-body-medium-regular text-start ltr'])[9]")
	private WebElement ifValueIsBlankText;
	
	@FindBy(how = How.XPATH, using = "//label[@id='QuestionnaireQuestionAddEditAddBetweenCondition0txt_value2errorLabel']")
	private WebElement valueErrorMessage;
	
	
	
	public Questionnaires(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnQuestionnairesTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesTab);
		javascriptClick(questionnairesTab);
	}

	public String getQuestionnaireTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesTitle);
		return questionnairesTitle.getText();
	}

	public boolean isQuestionnaireSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextbox);
		boolean isPresent = false;
		try {
			waitForElement(driver, searchTextbox);
			isPresent = searchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isAddButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addButton);
			isPresent = addButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getAddButtonPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addButton);
		return addButton.getText();
	}

	public void clickOnAddButton() throws InterruptedException {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(addButton);
		waitForElement(driver, addButton);
		javascriptClick(addButton);
	}

	public String getQuestionnairesAddPageTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesAddTitle);
		return questionnairesAddTitle.getText();
	}

	public boolean isCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, cancelButton);
			isPresent = cancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getCancelButtonPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, cancelButton);
		return cancelButton.getText();
	}

	public boolean isQuestionnaireStep1Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireStep1);
			isPresent = questionnaireStep1.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionsStep2Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsStep2);
			isPresent = questionsStep2.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnaireQuestionsStep3Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireQuestionsStep3);
			isPresent = questionnaireQuestionsStep3.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isScoreTypeStep4Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, scoreTypeStep4);
			isPresent = scoreTypeStep4.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionScoresStep5Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, QuestionScoreStep5);
			isPresent = QuestionScoreStep5.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubscalesStep6Display() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, subscalesStep6);
			isPresent = subscalesStep6.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextbox);
		return searchTextbox.getAttribute("placeholder");
	}

	public boolean isQuestionnairesListDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnairesList);
			isPresent = questionnairesList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionCreatedDateDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionCreatedDate);
			isPresent = questionCreatedDate.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionsTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsTitle);
			isPresent = questionsTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isNumberOfQuestionDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, numberOfQuestion);
			isPresent = numberOfQuestion.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionSubscaleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionSubscale);
			isPresent = questionSubscale.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionAssignDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAssignValue);
			isPresent = questionAssignValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionSunscaleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionSubscaleValue);
			isPresent = questionSubscaleValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSearchTextboxIconDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, searchTextboxIcon);
			isPresent = searchTextboxIcon.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void changeQuestionnairesStatus(String status) {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesStatus);
		String getStatus = questionnairesStatus.getText();
		if (getStatus.equals(status)) {
			addButton.click();
			try {
				publishStatus.click();
			} catch (Exception e) {
				unpublishStatus.click();
			}
		}
	}

	public String getQuestionnairesStatus() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesStatus);
		return questionnairesStatus.getText();
	}

	public boolean isCardFormatDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, cardFormat);
			isPresent = cardFormat.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getNoRecordFoundMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noQuestionnairRecordAdded);
		return noQuestionnairRecordAdded.getText();
	}

	public boolean isQuestionnaireStatusDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnairStatus);
			isPresent = questionnairStatus.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void enterTextInSearchTextbox(String text) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(searchTextbox);
		waitForElement(driver, searchTextbox);
		searchTextbox.sendKeys(text);
	}

	public void clearTextInSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, searchTextbox);
		searchTextbox.clear();
	}

	public boolean isQuestionnaireTitleDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnairTitle);
			isPresent = questionnairTitle.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnairesName() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnairesName);
			isPresent = questionnairesName.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getQuestionsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsLabel);
		return questionsLabel.getText();
	}

	public String getQuestionsCountLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsCountLabel);
		return questionsCountLabel.getText();
	}

	public boolean isQuestionnaireCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireCancelButton);
			isPresent = questionnaireCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isPublishStatusDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, publishStatus);
			isPresent = publishStatus.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnaireTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireTab);
			isPresent = questionnaireTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionsTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsTab);
			isPresent = questionsTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnaireQuesTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireQuesTab);
			isPresent = questionnaireQuesTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isScoreTypeTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, scoreTypeTab);
			isPresent = scoreTypeTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionScoresTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionScoresTab);
			isPresent = questionScoresTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isSubscalesTabDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, subscalesTab);
			isPresent = subscalesTab.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionnaireActiveElement() {
		TestConfig.PrintMethodName();
		if (questionnaireTab.equals(driver.switchTo().activeElement())) {
			return true;
		} else {
			return true;
		}
	}

	public String getQuestionnnaireTypeLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnnaireTypeLabel);
		return questionnnaireTypeLabel.getText();
	}

	public String getCodeLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeLabel);
		return codeLabel.getText();
	}

	public String getQuesDefaultRespodantLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesDefaultRespodantLabel);
		return quesDefaultRespodantLabel.getText();
	}

	public String getQuestionnnaireTitleLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnnaireTitleLabel);
		return questionnnaireTitleLabel.getText();
	}

	public String getInstructionsLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, instructionsLabel);
		return instructionsLabel.getText();
	}

	public String getSaveAndNextLabelText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, saveAndNextLabel);
		return saveAndNextLabel.getText();
	}

	public boolean isQuestTypeTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questTypeTextbox);
			isPresent = questTypeTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isCodeTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, codeTextbox);
			isPresent = codeTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestDefaultRespondantTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questDefaultRespondantTextbox);
			isPresent = questDefaultRespondantTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestTitleTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questTitleTextbox);
			isPresent = questTitleTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isInstructionsTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, instructionsTextbox);
			isPresent = instructionsTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getQuestTypeTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questTypeTextbox);
		return questTypeTextbox.getAttribute("placeholder");
	}

	public String getCodeTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeTextbox);
		return codeTextbox.getAttribute("placeholder");
	}

	public String getQuestDefaultRespondantTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questDefaultRespondantTextbox);
		return questDefaultRespondantTextbox.getAttribute("placeholder");
	}

	public String getQuestTitleTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questTitleTextbox);
		return questTitleTextbox.getAttribute("placeholder");
	}

	public void clickOnCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireCancelButton);
		javascriptClick(questionnaireCancelButton);
	}

	public void clickOnQusetionnaireTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, drpdown);
		Actions act = new Actions(driver);
		act.click(drpdown).build().perform();
	}

	public List<String> getQuesTypeDropdownList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : quesTypeDropdownList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void clickOnQuestionnairesName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnairesName);
		javascriptClick(questionnairesName);
	}

	public void clickOnQuestionsTab() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsTab);
		javascriptClick(questionsTab);
	}

	public boolean isQuestionsSaveAndNextLabel() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsSaveAndNextLabel);
			isPresent = questionsSaveAndNextLabel.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionsSearchTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsSearchTextbox);
			isPresent = questionsSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionsAddButton() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsAddButton);
			isPresent = questionsAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnQuestionnaireTypeStandard() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireTypeStandard);
		javascriptClick(questionnaireTypeStandard);
	}

	public String getQuestionsViewListerrorLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewListerrorLabel);
		return questionsViewListerrorLabel.getText();
	}

	public String getQuestionsViewQuestionTableLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewQuestionTableLabel);
		return questionsViewQuestionTableLabel.getText();
	}

	public String getQuestionsViewQuestionTypeTableLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewQuestionTypeTableLabel);
		return questionsViewQuestionTypeTableLabel.getText();
	}

	public String getQuestionsViewMedicalHistoryTableLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewMedicalHistoryTableLabel);
		return questionsViewMedicalHistoryTableLabel.getText();
	}

	public String getQuestionsViewIsRequiredTableLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewIsRequiredTableLabel);
		return questionsViewIsRequiredTableLabel.getText();
	}

	public void clickOnSearchTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(searchTextbox);
		waitForElement(driver, searchTextbox);
		javascriptClick(searchTextbox);
	}

	public boolean isQuestionsViewListRow() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionsViewListRow);
			isPresent = questionsViewListRow.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnQuestionsTabAddButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionsAddButton);
		waitForElement(driver, questionsAddButton);
		javascriptClick(questionsAddButton);
	}

	public String getQuestionsAddPageLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsAddLabel);
		return questionsAddLabel.getText();
	}

	public void clickOQuestionsViewListRow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewListRow);
		javascriptClick(questionsViewListRow);
	}

	public String getQuestionnaireQuestionsHeaderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionsHeaderLabel);
		return questionnaireQuestionsHeaderLabel.getText();
	}

	public void clickOnQuestDefaultRespondantDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questDefaultRespondant);
		Actions act = new Actions(driver);
		act.click(questDefaultRespondant).build().perform();
	}

	public List<String> getQuestDefaultRespondantList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : questDefaultRespondantList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public void clickOnProviderDefaultRespondant() {
		TestConfig.PrintMethodName();
		waitForElement(driver, providerDefaultRespondant);
		javascriptClick(providerDefaultRespondant);
	}

	public String getQuestDefaultRespondantSelectedValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questDefaultRespondant);
		return questDefaultRespondant.getAttribute("value");
	}

	public String isQuestTypeTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questTypeTextboxHighlight);
		String cssValue = questTypeTextboxHighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isCodeTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeTextboxHighlight);
		String cssValue = codeTextboxHighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isQuesDefaultRespondantTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesDefaultRespondantTextboxHighlight);
		String cssValue = quesDefaultRespondantTextboxHighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String isQuesTitleTextboxHighlight() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesTitleTextboxHighlight);
		String cssValue = quesTitleTextboxHighlight.getCssValue("border-top-color");
		return Color.fromString(cssValue).asHex();
	}

	public String getQuesTypeErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesTypeErrorMessage);
		return quesTypeErrorMessage.getText();
	}

	public String getCodeErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeErrorMessage);
		return codeErrorMessage.getText();
	}

	public String getQuesDefaultRespondantErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesDefaultRespondantErrorMessage);
		return quesDefaultRespondantErrorMessage.getText();
	}

	public String getQuesTitleErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, quesTitleErrorMessage);
		return quesTitleErrorMessage.getText();
	}

	public void clickOnStandardQuesType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, standardType);
		javascriptClick(standardType);
	}

	public void enterCode(String code) {
		TestConfig.PrintMethodName();
		waitForElement(driver, standardType);
		codeTextbox.sendKeys(code);
	}

	public void enterQuesTitle(String title) {
		TestConfig.PrintMethodName();
		waitForElement(driver, questTitleTextbox);
		questTitleTextbox.sendKeys(title);
	}

	public String getStep2QuestionHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsHeader);
		return questionsHeader.getText();
	}

	public void clickOnNewAddedQuestionnaire(String questionnaire) {
		TestConfig.PrintMethodName();
		WebElement newQues = driver.findElement(By.xpath("//label[text()='" + questionnaire + "']"));
		waitForElement(driver, newQues);
		javascriptClick(newQues);
	}

	public String getPrefilledQuestionnaireType() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questTypeTextbox);
		waitForElement(driver, questTypeTextbox);
		return questTypeTextbox.getAttribute("value");
	}

	public String getPrefilledCode() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeTextbox);
		return codeTextbox.getAttribute("value");
	}

	public String getPrefilledQuestionnaireDefaultRespondant() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questDefaultRespondantTextbox);
		return questDefaultRespondantTextbox.getAttribute("value");
	}

	public String getPrefilledQuestionnaireTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questTitleTextbox);
		return questTitleTextbox.getAttribute("value");
	}

	public void clickOnQuestionsViewQuestionTableLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionsViewQuestionTableLabel);
		waitForElement(driver, questionsViewQuestionTableLabel);
		javascriptClick(questionsViewQuestionTableLabel);
	}

	public String getQuestionTabAddEditLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTabAddEditLabel);
		return questionTabAddEditLabel.getText();
	}

	public String getQuestionAddQuestionTypeLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddQuestionTypeLabel);
		return questionAddQuestionTypeLabel.getText();
	}

	public void clickOnQuestionAddQuestionTypeDropdown() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionAddQuestionTypeDropdown);
		waitForElement(driver, questionAddQuestionTypeDropdown);
		// javascriptClick(questionAddQuestionTypeDropdown);
		Actions act = new Actions(driver);
		act.click(questionAddQuestionTypeDropdown).build().perform();
	}

	public List<String> getQuestionAddQuestionTypeList() {
		TestConfig.PrintMethodName();
		List<String> dropDownList = new ArrayList<String>();
		for (WebElement e : questionAddQuestionTypeList) {
			dropDownList.add(e.getText());
		}
		return dropDownList;
	}

	public String getQuestionAddQuestionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddQuestionLabel);
		return questionAddQuestionLabel.getText();
	}

	public boolean isQuestionAddQuestionRichTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddQuestionRichTextbox);
			isPresent = questionAddQuestionRichTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getQuestionAddEnterAnswerPlaceholderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddEnterAnswerPlaceholderLabel);
		return questionAddEnterAnswerPlaceholderLabel.getText();
	}

	public String getQuestionAnswerPlaceHolderText() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionAnswerPlaceHolderText);
		waitForElement(driver, questionAnswerPlaceHolderText);
		return questionAnswerPlaceHolderText.getAttribute("placeholder");
	}

	public String getQuestionAddEnterAnswerPlaceholderTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddEnterAnswerPlaceholderTextbox);
		return questionAddEnterAnswerPlaceholderTextbox.getText();
	}

	public boolean isQuestionAddEnterAnswerPlaceholderTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddEnterAnswerPlaceholderTextbox);
			isPresent = questionAddEnterAnswerPlaceholderTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getQuestionAddInstructionsLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddInstructionsLabel);
		return questionAddInstructionsLabel.getText();
	}

	public boolean isQuestionAddInstructionsTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddInstructionsTextbox);
			isPresent = questionAddInstructionsTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionAddCancelButton() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddCancelButton);
			isPresent = questionAddCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnQuestionAddCancelIcon() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionAddCancelIcon);
		waitForElement(driver, questionAddCancelIcon);
		javascriptClick(questionAddCancelIcon);
	}

	public void clickOnQuestionsViewListRow() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionsViewListRow);
		javascriptClick(questionsViewListRow);
	}

	public void clickOnQuestionAddQuestionTypeDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddQuestionTypeDate);
		javascriptClick(questionAddQuestionTypeDate);
	}

	public String getQuestionAddMinLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMinLabel);
		return questionAddMinLabel.getText();
	}

	public String getQuestionAddMaxLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMaxLabel);
		return questionAddMaxLabel.getText();
	}

	public boolean isQuestionAddMinTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddMinTextbox);
			isPresent = questionAddMinTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public boolean isQuestionAddMaxTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddMaxTextbox);
			isPresent = questionAddMaxTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void checkIsRequiredKeycheckbox() throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean checkboxStatus = false;
		waitUntilElementIsVisible(questionAddIsRequiredKeycheckbox);
		waitForElement(driver, questionAddIsRequiredKeycheckbox);
		checkboxStatus = questionAddIsRequiredKeycheckbox.isSelected();
	
		if (checkboxStatus) {
			log("Checkbox already check");
		} else {
			javascriptClick(questionAddIsRequiredKeycheckbox);
		}
	}

	public boolean isCheckboxIsRequiredSelect() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddIsRequiredKeycheckbox);
		boolean isPresent = false;
		try {
			BasePageObject.waitForElement(driver, questionAddIsRequiredKeycheckbox);
			isPresent = questionAddIsRequiredKeycheckbox.isSelected();
			return isPresent;
		} catch (Exception e) {
			log("Checkbox already check");
			return isPresent;
		}

	}

	public boolean unCheckIsRequiredKeycheckbox() throws InterruptedException {
		TestConfig.PrintMethodName();
		boolean checkboxStatus = false;
		waitForElement(driver, questionAddIsRequiredKeycheckbox);
		checkboxStatus = questionAddIsRequiredKeycheckbox.isSelected();
		
		if (checkboxStatus) {
			javascriptClick(questionAddIsRequiredKeycheckbox);
		} else {
			log("Checkbox already uncheck");
		}
		return checkboxStatus;
	}

	public void clickOnSetupAnswersSearchTextbox() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(setupAnswersSearchTextbox);
		waitForElement(driver, setupAnswersSearchTextbox);
		javascriptClick(setupAnswersSearchTextbox);
	}

	public void sendSetupAnswersSearchTextbox(String Anwser) {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnswersSearchTextbox);
		setupAnswersSearchTextbox.sendKeys(Anwser);
	}

	public boolean isSetupAnswersSearchValueDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnswersSearchValue);
			isPresent = setupAnswersSearchValue.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public String getsetupAnswersSearchInvalidMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnswersSearchInvalidMessage);
		return setupAnswersSearchInvalidMessage.getText();
	}

	public String get1QuestionnaireTitle() {
		TestConfig.PrintMethodName();
		waitForElement(driver, step1QuestionnaireTitle);
		return step1QuestionnaireTitle.getText();
	}

	public String getQuestionnaireHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireHeader);
		return questionnaireHeader.getText();
	}

	public String getQuestionnaireTypeSelectedValue() {
		TestConfig.PrintMethodName();
		waitForElement(driver, drpdown);
		return drpdown.getAttribute("Value");
	}

	public void createDateTypeQuestion(String min, String max, String ques) {
		waitForElement(driver, dateQuestionType);
		javascriptClick(dateQuestionType);
		minTextbox.sendKeys(min);
		maxTextbox.sendKeys(max);
		questionTextbox.sendKeys(ques);
		javascriptClick(questionSaveButton);
	}

	public String getQuestionnaireQuestionHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionHeader);
		return questionnaireQuestionHeader.getText();
	}

	public String getCodeDuplicateErrorMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, codeDuplicateError);
		return codeDuplicateError.getText();
	}

	public void clickOnQuestionSaveNextButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionSaveNext);
		waitForElement(driver, questionSaveNext);
		javascriptClick(questionSaveNext);
	}

	public void clickOnQuestionsSaveAndNextLabel() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionsSaveAndNextLabel);
		waitForElement(driver, questionsSaveAndNextLabel);
		Actions act = new Actions(driver);
		act.click(questionsSaveAndNextLabel).build().perform();
		// javascriptClick(questionsSaveAndNextLabel);
	}

	public void clickOnSaveAndNext() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionnaireSaveAndNextLabel);
		waitForElement(driver, questionnaireSaveAndNextLabel);
//		Actions act=new Actions(driver);
//		act.click(saveAndNextLabel).build().perform();
		javascriptClick(questionnaireSaveAndNextLabel);
	}

	public boolean isQuestionAddSaveButton() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddSaveButton);
			isPresent = questionAddSaveButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}

	public void clickOnQuestionAddSaveButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionAddSaveButton);
		waitForElement(driver, questionAddSaveButton);
		javascriptClick(questionAddSaveButton);
	}

	public String getSetupAnswersSearchInvalidMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnswersSearchInvalidMessage);
		return setupAnswersSearchInvalidMessage.getText();
	}

	public void clearSetupAnswersSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnswersSearchTextbox);
		setupAnswersSearchTextbox.clear();
	}

	public String getSetupAnswersLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnswersLabel);
		return setupAnswersLabel.getText();
	}

	public void clickOnRichTextDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, richTextDropdown);
		javascriptClick(richTextDropdown);
	}

	public void clickOnRichTextboxQuestionTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, richTextboxQuestionTextbox);
		javascriptClick(richTextboxQuestionTextbox);
	}

	public void sendRichTextboxQuestionTextbox(String Question) {
		TestConfig.PrintMethodName();
		waitForElement(driver, richTextboxQuestionTextbox);
		richTextboxQuestionTextbox.sendKeys(Question);
	}

	public void clickOnRichTextboxReadOnlyInstructions() {
		TestConfig.PrintMethodName();
		waitForElement(driver, richTextboxReadOnlyInstructions);
		// javascriptClick(richTextboxReadOnlyInstructions);
		Actions act = new Actions(driver);
		act.sendKeys(richTextboxReadOnlyInstructions, Keys.ENTER).build().perform();
		// act.click(richTextboxReadOnlyInstructions).build().perform();
	}

//	public void sendRichTextboxReadOnlyInstructions(String Instruction) {
//		TestConfig.PrintMethodName();
//		waitForElement(driver, richTextboxReadOnlyInstructions);
//		richTextboxReadOnlyInstructions.sendKeys(Instruction);
//	}
	public void clickOnTextDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, textDropdown);
		javascriptClick(textDropdown);
	}

	public void sendRichTextboxReadOnlyInstructions(String Instruction) {
		TestConfig.PrintMethodName();
		waitForElement(driver, richTextboxReadOnlyInstructions);
		richTextboxReadOnlyInstructions.sendKeys(Instruction);
	}

	public void sendQuestionAddMinTextbox(String Answer) {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMinTextbox);
		questionAddMinTextbox.sendKeys(Answer);
	}

	public void sendQuestionAddMaxTextbox(String Answer) {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMaxTextbox);
		questionAddMaxTextbox.sendKeys(Answer);
	}

	public void sendTextboxQuestionTextbox(String Answer) {
		TestConfig.PrintMethodName();
		waitForElement(driver, textboxQuestionTextbox);
		textboxQuestionTextbox.sendKeys(Answer);
	}

	public void clickOnQuestionAddMinTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMinTextbox);
		javascriptClick(questionAddMinTextbox);
	}

	public void clickOnQuestionAddMaxTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddMaxTextbox);
		javascriptClick(questionAddMaxTextbox);
	}

	public void clickOnTextboxQuestionTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, textboxQuestionTextbox);
		javascriptClick(textboxQuestionTextbox);
	}
	
	public boolean isQuestionnaireQuestionSaveNextButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionSaveNext);
			isPresent = questionSaveNext.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getQuestionQuestionSaveNextText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionSaveNext);
		return questionSaveNext.getText();
	}
	
	public boolean isQuestionnaireQuestionSearchTextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireQuestionSearchTextbox);
			isPresent = questionnaireQuestionSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getQuestionSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionSearchTextbox);
		return questionSearchTextbox.getAttribute("placeholder");
	}
	
	public boolean isQuestionnaireQuestionAddButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionAddButton);
			isPresent = questionAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getQuestionnaireQuestionFirstColumnName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionColumn);
		return questionColumn.getText();
	}
	
	public String getQuestionnaireQuestionSecondColumnName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isStartingQuestionColumn);
		return isStartingQuestionColumn.getText();
	}
	
	public String getQuestionnaireQuestionThirdColumnName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeColumn);
		return questionTypeColumn.getText();
	}
	
	public String getQuestionnaireQuestionFourthColumnName() {
		TestConfig.PrintMethodName();
		waitForElement(driver, noOfFlowsColumn);
		return noOfFlowsColumn.getText();
	}

	public void selectDateQuestionType() {
		TestConfig.PrintMethodName();
		waitForElement(driver, dateQuestion);
		javascriptClick(dateQuestion);
	}
	
	public void clickOnQuestionnaireQuestionSaveButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionSave);
		javascriptClick(questionnaireQuestionSave);
	}
	
	public String getQuestionnaireQuestionTitle() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionnaireQuestionTitle);
		waitForElement(driver, questionnaireQuestionTitle);
		return questionnaireQuestionTitle.getText();
	}
	
	public void clickOnQuestionnaireQuestionAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionAddButton);
		javascriptClick(questionnaireQuestionAddButton);
	}
	
	public String getQuestionnaireQuestionSearchTextboxPlaceholder() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionSearchTextbox);
		return questionnaireQuestionSearchTextbox.getAttribute("placeholder");
	}
	
	public void enterTextInQuestionnaireQuestionSearchTextbox(String search) {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionSearchTextbox);
		questionnaireQuestionSearchTextbox.sendKeys(search);
	}
	
	public boolean isDateQuestionnaireQuestionDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, dateQuestionList);
			isPresent = dateQuestionList.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getQuestionnaireQuestionNoRecordFoundMessage() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionNoRecordFound);
		return questionnaireQuestionNoRecordFound.getText();
	}
	
	public void clearTextInQuestionnaireQuestionSearchTextbox() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionSearchTextbox);
		questionnaireQuestionSearchTextbox.clear();
	}
	
	public String getQuestionnaireQuestionAddEditPageHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionAddEditPageHeader);
		return questionnaireQuestionAddEditPageHeader.getText();
	}
	
	public void clickOnDateQuestionnaireQuestion() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(dateQuestionList);
		waitForElement(driver, dateQuestionList);
		javascriptClick(dateQuestionList);
	}
	
	public void clickOnQuestionnaireQuestionSaveNextButton() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(questionnaireQuestionSaveNextButton);
		waitForElement(driver, questionnaireQuestionSaveNextButton);
		javascriptClick(questionnaireQuestionSaveNextButton);
	}
	
	public String getScroreTypeHeader() {
		TestConfig.PrintMethodName();
		waitForElement(driver, scroreTypeHeader);
		return scroreTypeHeader.getText();
	}

public void clickOnCrosslIconIcon() {
		TestConfig.PrintMethodName();
		waitForElement(driver, crosslIcon);
		javascriptClick(crosslIcon);
	}
public void clickOnQuestionTypeDate() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeDate);
		javascriptClick(questionTypeDate);
	}

public void questionTypeMinAndMaxField() throws Exception {
	log("Adding new Appointment time");
	TestConfig.PrintMethodName();
	waitForElement(driver, questionAddQuestionTypeDropdown);
		Questionnaires quesPage = new Questionnaires(driver);
		assertTrue(quesPage.isCheckboxIsRequiredSelect());
		assertEquals(quesPage.getQuestionAddMinLabel(), AtomHC.propData.getProperty("question.type.min.label"));
		assertTrue(quesPage.isQuestionAddMinTextbox());
		assertEquals(quesPage.getQuestionAddMaxLabel(), AtomHC.propData.getProperty("question.type.max.label"));
		assertTrue(quesPage.isQuestionAddMaxTextbox());
	
	}
	

	public void clickOnQuestionTypeNumeric() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeNumeric);
		javascriptClick(questionTypeNumeric);
	}
	
	public void clickOnQuestionTypeHorizontalSlider() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeHorizontalSlider);
		javascriptClick(questionTypeHorizontalSlider);
	}
	public void clickOnQuestionTypeVerticalSlider() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeVerticalSlider);
		javascriptClick(questionTypeVerticalSlider);
	}
	public void clickOnQuestionTypeDateAndTime() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeDateAndTime);
		javascriptClick(questionTypeDateAndTime);
	}
	public void clickOnQuestionTypeTime() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeTime);
		javascriptClick(questionTypeTime);
	}
	public void clickOnQuestionTypeMultilineText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeMultilineText);
		javascriptClick(questionTypeMultilineText);
	}
	public void clickOnQuestionTypeDropdown() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeDropdown);
		javascriptClick(questionTypeDropdown);
	}
	public boolean isQuestionTypeHorizontalSliderTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionTypeHorizontalSliderTextbox);
			isPresent = questionTypeHorizontalSliderTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public void questionTypeSliderStepField() throws Exception {
		log("Adding new Appointment time");
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddQuestionTypeDropdown);
			Questionnaires quesPage = new Questionnaires(driver);
			assertEquals(quesPage.getQuestionAddMinLabel(), AtomHC.propData.getProperty("question.type.min.label"));
			assertTrue(quesPage.isQuestionAddMinTextbox());
			assertEquals(quesPage.getQuestionAddMaxLabel(), AtomHC.propData.getProperty("question.type.max.label"));
			assertTrue(quesPage.isQuestionAddMaxTextbox());
			assertEquals(quesPage.getQuestionTypeHorizontalSliderLabel(), AtomHC.propData.getProperty("question.type.Slider.label"));
			assertTrue(quesPage.isQuestionTypeHorizontalSliderTextbox());
			
		}
	public String getQuestionTypeHorizontalSliderLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionTypeHorizontalSliderLabel);
		return questionTypeHorizontalSliderLabel.getText();
	}
	public void questionTypeSetupAnswersField() throws Exception {
		log("Adding new Appointment time");
		TestConfig.PrintMethodName();
		waitForElement(driver, questionAddQuestionTypeDropdown);
			Questionnaires quesPage = new Questionnaires(driver);
			assertEquals(quesPage.getQuestionAddMinLabel(), AtomHC.propData.getProperty("question.type.min.label"));
			assertTrue(quesPage.issetupAnswersSearchTextbox());
			assertEquals(quesPage.getQuestionAddMaxLabel(), AtomHC.propData.getProperty("question.type.max.label"));
			assertTrue(quesPage.isQuestionAddMaxTextbox());
			assertEquals(quesPage.getQuestionTypeHorizontalSliderLabel(), AtomHC.propData.getProperty("question.type.Slider.label"));
			assertTrue(quesPage.isQuestionTypeHorizontalSliderTextbox());
			
		}
	public boolean issetupAnswersSearchTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnswersSearchTextbox);
			isPresent = setupAnswersSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getIsStartingQuestionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, isStartingQuestionLabel);
		return isStartingQuestionLabel.getText();
	}
	
	public String getSelectQuestionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, selectQuestionLabel);
		return selectQuestionLabel.getText();
	}
	
	public boolean isSelectQuestionDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, selectQuestionDropdown);
			isPresent = selectQuestionDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void clickOnQuestionnaireQuestionCancelButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuestionCancelButton);
		javascriptClick(questionnaireQuestionCancelButton);
	}
	
	public boolean isQuestionnaireQuestionSaveButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireQuestionSave);
			isPresent = questionnaireQuestionSave.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isQuestionnaireQuestionCancelButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, questionnaireQuestionCancelButton);
			isPresent = questionnaireQuestionCancelButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
public boolean isSetupAnswersSearchTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnswersSearchTextbox);
			isPresent = setupAnswersSearchTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isSetupAnsAddButton() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnsAddButton);
			isPresent = setupAnsAddButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public String getSetupAnsAnswerLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnsAnswerLabel);
		return setupAnsAnswerLabel.getText();
	}
	public String getSetupAnsSequenceNoLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnsSequenceNoLabel);
		return setupAnsSequenceNoLabel.getText();
	}
	public void clickOnSetupAnsAddButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnsAddButton);
		javascriptClick(setupAnsAddButton);
	}
	public String getSetupAnsAddAnswerLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, setupAnsAddAnswerLabel);
		return setupAnsAddAnswerLabel.getText();
	}
	public boolean isSetupAnsAnswerTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnsAnswerTextbox);
			isPresent = setupAnsAnswerTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	public boolean isSetupAnsSequenceNoTextbox() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, setupAnsSequenceNoTextbox);
			isPresent = setupAnsSequenceNoTextbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isActionDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, actionDropdown);
			isPresent = actionDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isAddMoreBetweenConditionLinkButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, addMoreBetweenConditionLinkButton);
			isPresent = addMoreBetweenConditionLinkButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getElseLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, elseLabel);
		return elseLabel.getText();
	}
	
	public void clickOnAddMoreBetweenConditionLinkButton() {
		TestConfig.PrintMethodName();
		waitForElement(driver, addMoreBetweenConditionLinkButton);
		javascriptClick(addMoreBetweenConditionLinkButton);
	}
	
	public String getConditionText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, conditionText);
		return conditionText.getText();
	}
	
	public void createStandardQuesType(String code,String title ) {
		javascriptClick(standardType);
		codeTextbox.sendKeys(code);
		javascriptClick(providerDefaultRespondant);
		questTitleTextbox.sendKeys(title);
		javascriptClick(questionnaireSaveAndNextLabel);
	}
	
	public String getPrefilledDateQuestion() {
		TestConfig.PrintMethodName();
		waitForElement(driver, questionnaireQuesSelectQuesDropdown);
		return questionnaireQuesSelectQuesDropdown.getAttribute("value");
	}
	
	public String getIfValueIsBlankText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, ifValueIsBlankText);
		return ifValueIsBlankText.getText();
	}
	
	public boolean isConditionActionDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, conditionActionDropdown);
			isPresent = conditionActionDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getAddMoreBetweenConditionText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, conditionText);
		return conditionText.getText();
	}
	
	public boolean isValue1TextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, value1Textbox);
			isPresent = value1Textbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getAndText() {
		TestConfig.PrintMethodName();
		waitForElement(driver, andText);
		return andText.getText();
	}
	
	public boolean isValue2TextboxDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, value2Textbox);
			isPresent = value2Textbox.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public boolean isConditionDeleteButtonDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, conditionDeleteButton);
			isPresent = conditionDeleteButton.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public String getActionLabel() {
		TestConfig.PrintMethodName();
		waitForElement(driver, actionLabel);
		return actionLabel.getText();
	}
	
	public boolean isconditionActionDropdownDisplay() {
		TestConfig.PrintMethodName();
		boolean isPresent = false;
		try {
			waitForElement(driver, conditionActionDropdown);
			isPresent = conditionActionDropdown.isDisplayed();
			return isPresent;
		} catch (Exception e) {
			log("Element is not visible");
			return isPresent;
		}
	}
	
	public void enterValue1(String value) {
		TestConfig.PrintMethodName();
		waitForElement(driver, value1Textbox);
		value1Textbox.sendKeys("value");
	}
	
	public void enterValue2(String value) {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(value2Textbox);
		waitForElement(driver, value2Textbox);
		value1Textbox.sendKeys("value");
	}
	
	public String getValueErrorMessage() {
		TestConfig.PrintMethodName();
		waitUntilElementIsVisible(valueErrorMessage);
		waitForElement(driver, valueErrorMessage);
		return valueErrorMessage.getText();
	}
	
}

