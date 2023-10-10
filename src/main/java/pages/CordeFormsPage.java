package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeFormsPage {
	
	
	// Form RTE content 
	@FindBy(how=How.XPATH,using="//*[@class='m-form__content']")
	private WebElement Formcontent;
	
	// Form Heading 
	@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-page ']/h4")
	private WebElement FormHeading;
	
	
	//Form Segment headings
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-page ']//fieldset//h1"))
	private List<WebElement> FormSegmentHeadings;
	
	
	//Form fields labels
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-form__label umbraco-forms-label']"))
	private List<WebElement> FormFieldsLabels;
	
	
	//Field Indicator
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-indicator']"))
	private List<WebElement> FieldIndicators;
	
	//Field Help text
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-tooltip m-form__help_text']"))
	private List<WebElement> FieldHelpText;
	
	 
	//Input Fields
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class=' m-form__input']"))
	private List<WebElement> InputFields;
	
	//Input Field
	@FindBy(how=How.XPATH,using="//*[@class=' m-form__input']")
	private WebElement InputField;
	
	//Long Input Field
	@FindBy(how=How.XPATH,using="//*[@class=' m-form__input m-form__input--textarea']")
	private WebElement LongInput;
	
	//Date Picker
	@FindBy(how=How.XPATH,using="//*[@class='m-form__input m-form__input--calendar  datepickerfield']")
	private WebElement DatePicker;
	
	//Multiple choices checkboxes
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='checkboxlist']//label"))
	private List<WebElement> MultipleChoices;
	
	//Dropdown field
	@FindBy(how=How.XPATH,using="//*[@class='selectric-wrapper']")
	private WebElement Dropdownfield;
	
	//Dropdown options
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric-items']//li"))
	private List<WebElement> DropdownOptions;
	
	//Dropdown 
	@FindBy(how=How.XPATH,using="//*[@class='selectric-items']")
	private WebElement Dropdown;
	
	//CheckBoxes
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class=' radiobuttonlist']//label"))
	private List<WebElement> CheckBoxes;
	
	//Consentcheckbox
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='e-custom_input__label']"))
	private List<WebElement> ConsentCheckbox;
	
	//Next button
	@FindBy(how=How.XPATH,using="//*[@class='e-btn']")
	private WebElement NextButton;
	
	//Upload
	@FindBy(how=How.XPATH,using="//*[@type='file']")
	private WebElement Upload;
	
	//Previous button //button[@name='__prev']
	@FindBys(@FindBy(how=How.CSS,using="button.e-btn"))
	private List<WebElement> PreviousButton;
	
	//Submit button
	@FindBy(how=How.XPATH,using="//*[@class='e-btn'][@name='submitbtn']")
	private WebElement SubmitButton;
	
	//Submission message
	@FindBy(how=How.XPATH,using="//*[contains(@class,'submitmessage')]/span")
	private WebElement SubmitMessage;
	
	//Month
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='pika-select pika-select-month']/option"))
	private List<WebElement> Month;
	
	//Year
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='pika-select pika-select-year']/option"))
	private List<WebElement> Year;
	
	//Day
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='pika-lendar']//table/tbody/tr/td/button[@class='pika-button pika-day']"))
	private List<WebElement> Day;	
	
	//Calender
	@FindBy(how=How.XPATH,using="//*[@class='pika-lendar']")
	private WebElement Calender;
	
	//Dropdown selected
	@FindBy(how=How.XPATH,using="//*[@class='selectric']")
	private WebElement Dropdownselected;
	
	//Radio
	@FindBys(@FindBy(how=How.XPATH,using="//*[@type='radio']"))
	private List<WebElement> Radio;
	
	//Radio Options
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='e-custom_input__label e-custom_input__label--radio']"))
	private List<WebElement> RadioOptions;
	
	//File uploaded
	@FindBy(how=How.XPATH,using="//*[@class= 'valid']")
	private WebElement ValidFile;
	
	//Footer logo
	@FindBy(how=How.XPATH,using="//*[@class= 'm-site_footer__logo_image']")
	private WebElement footerlogo;
	
	//Uploaded file check
	@FindBy(how=How.XPATH,using="//*[@type='file']//following-sibling::p/a")
	private WebElement filecheck;	
	
	//Indicator field
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-page ']/fieldset//label"))
	private List<WebElement> IndicatorField;
	
	//Indicator field
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='umbraco-forms-page ']/fieldset//label/span"))
	private List<WebElement> Indicator;
	
	//Indicator field
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='field-validation-error']/span"))
	private List<WebElement> ErrorMsg;	
	
	//Field after error
	@FindBys(@FindBy(how=How.XPATH,using="	//*[contains(@class,'m-form__input input')]"))
	private List<WebElement> Errorinput;	
	
	//Upload error message
	@FindBy(how=How.XPATH,using="//*[@class='field-validation-error']")
	private WebElement Uploaderrormsg;
	
	
	public CordeFormsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getFormcontent() {
		return Formcontent;
	}

	public WebElement getFormHeading() {
		return FormHeading;
	}

	public List<WebElement> getFormSegmentHeadings() {
		return FormSegmentHeadings;
	}

	public List<WebElement> getFormFieldsLabels() {
		return FormFieldsLabels;
	}

	public List<WebElement> getFieldIndicators() {
		return FieldIndicators;
	}

	public List<WebElement> getFieldHelpText() {
		return FieldHelpText;
	}

	public List<WebElement> getInputFields() {
		return InputFields;
	}

	public WebElement getLongInput() {
		return LongInput;
	}

	public WebElement getDatePicker() {
		return DatePicker;
	}
	

	public List<WebElement> getMultipleChoices() {
		return MultipleChoices;
	}

	public WebElement getDropdownfield() {
		return Dropdownfield;
	}

	public List<WebElement> getDropdownOptions() {
		return DropdownOptions;
	}

	public List<WebElement> getCheckBoxes() {
		return CheckBoxes;
	}

	public List<WebElement> getConsentCheckbox() {
		return ConsentCheckbox;
	}

	public WebElement getNextButton() {
		return NextButton;
	}

	public WebElement getUpload() {
		return Upload;
	}

	public List<WebElement> getPreviousButton() {
		return PreviousButton;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

	public WebElement getSubmitMessage() {
		return SubmitMessage;
	}

	public List<WebElement> getMonth() {
		return Month;
	}

	public List<WebElement> getYear() {
		return Year;
	}

	public List<WebElement> getDay() {
		return Day;
	}

	public WebElement getCalender() {
		return Calender;
	}

	public WebElement getInputField() {
		return InputField;
	}

	public WebElement getDropdown() {
		return Dropdown;
	}

	public WebElement getDropdownselected() {
		return Dropdownselected;
	}

	public List<WebElement> getRadio() {
		return Radio;
	}

	public List<WebElement> getRadioOptions() {
		return RadioOptions;
	}

	public WebElement getValidFile() {
		return ValidFile;
	}

	public WebElement getFooterlogo() {
		return footerlogo;
	}

	public WebElement getFilecheck() {
		return filecheck;
	}

	public List<WebElement> getIndicatorField() {
		return IndicatorField;
	}

	public List<WebElement> getIndicator() {
		return Indicator;
	}

	public List<WebElement> getErrorMsg() {
		return ErrorMsg;
	}

	public List<WebElement> getErrorinput() {
		return Errorinput;
	}

	public WebElement getUploaderrormsg() {
		return Uploaderrormsg;
	}
	
	
	

}
