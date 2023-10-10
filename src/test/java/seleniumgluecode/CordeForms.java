package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cucumber.listener.Reporter;
import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;

import runner.TestRunner;

public class CordeForms extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	@After
	public void afterHooks(Scenario scenario ) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver,scenario.getName() );
		}
	}
	
	
	@Given("^Launch the Application to test Form module$")
	public void launch_the_Application_to_test_Form_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Form page$")
	public void click_on_Menu_Nav_to_go_to_the_Form_page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	
    	String check = "Fail";
    	for(WebElement elem:Menutext) {
    	//	System.out.println(elem.getAttribute("href"));
	    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
	    			check = "Success";
	    			ClickElement(elem);
	    			break;
	    			}
	    		}
    			if (check== "Success"){
    				Reporter.addStepLog("Main Menu link is clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
    	
    
    	//Logic to click FunctionalModule grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FunctionalModule"))) {
	    			Reporter.addStepLog("Content modules link is found");
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Functionalviewlink"))) {
	    				   Grid1="Success";
	    				   ClickElement(View);
	    				   break;
	    			   }
	    			}
	    			if (Grid1== "Success"){
	    				Reporter.addStepLog("Content modules grids page is displayed");
	    					}   		
	    			else
	    				{
	    				throw new NoSuchElementException();
	    				}
	    			break;
	    		}
	    		
    	}
    	//Logic to click Form grid and check images
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Forms"))) {
	    			Reporter.addStepLog("Feature Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FormsLink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   break;
	    			   }
	    			}
	    		if (Acc== "Success"){
	    			Reporter.addStepLog("Featuers page is displayed");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
	    		break;
	    		}
    		}
	}

	@Then("^Check the form RTE content is prersent on page(\\d+)$")
	public void check_the_form_RTE_content_is_prersent_on_page(int arg1) throws Throwable {
		WebElement PageContent= pag.getCordeForms().getFormcontent();
		if(PageContent.isDisplayed()) {
			Reporter.addStepLog("Form page content is displayed");
		}else {
			throw new NoSuchElementException();
		}
		
	}
	
	@Then("^Check Form Heading is displayed$")
	public void check_Form_Heading_is_displayed() throws Throwable {
		WebElement PageHeading= pag.getCordeForms().getFormHeading();
		if(PageHeading.isDisplayed()) {
			Reporter.addStepLog(PageHeading.getText()+" "+"Form Heading  is displayed");
		}else {
			throw new NoSuchElementException();
		}
		
	}

	@Then("^Check Page Heading is displayed$")
	public void check_Page_Heading_is_displayed() throws Throwable {
		List<WebElement> FormFieldLabels= pag.getCordeForms().getFormSegmentHeadings();
		for(WebElement FormFieldLabel :FormFieldLabels) {
		if(FormFieldLabel.isDisplayed()) {
			getScroll(driver);
			Reporter.addStepLog(FormFieldLabel.getText()+" "+"Form Heading  is displayed");
		}else {
			throw new NoSuchElementException();
			}
		}
	}

	@Then("^Enter \"([^\"]*)\" values$")
	public void enter_values(String arg1) throws Throwable {
		try {
		List<WebElement> ShortAnswerfields = pag.getCordeForms().getInputFields();
		for (WebElement ShortAnswerfield : ShortAnswerfields) {
			if(ShortAnswerfield.isDisplayed()) {
				InputvaluesIntoFields(ShortAnswerfield, arg1);
				Reporter.addStepLog("Entered short input field values is displayed");
		}
			else {
				Reporter.addStepLog("3rd input field  is hidden");
			}
			}
		}
			catch(Exception e) {
				
				e.printStackTrace();
				
		}
	
	}

	@Then("^Enter \"([^\"]*)\" value$")
	public void enter_value(String arg1) throws Throwable {
		InputvaluesIntoFields(pag.getCordeForms().getLongInput(), arg1);
		Reporter.addStepLog("Entered long answer input field values is displayed");
	}

	@Then("^Select date \"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\" from date picker$")
	public void select_date_and_and_from_date_picker(String arg1, String arg2, String arg3) throws Throwable {
		getScroll(driver);
		ClickElement(pag.getCordeForms().getDatePicker());
		MoveToElement(pag.getCordeForms().getCalender());
		List<WebElement> elements = pag.getCordeForms().getMonth();
		List<WebElement> Years = pag.getCordeForms().getYear();
			for (WebElement element:elements)
				{
					//Selecting the month
					if(element.getText().equals(arg2))
					{ 
						//Selecting the year
						for(WebElement Year :Years ) {
							if(Year.getText().equalsIgnoreCase(arg3)) {
								//Selecting the date 
								List<WebElement> days = pag.getCordeForms().getDay();
								for (WebElement d:days)
								{ 
									if(d.getText().equals(arg1))
									{
										d.click();
										Reporter.addStepLog(arg1+" "+arg2+" "+arg3 +" "+"Date is selected");
										Thread.sleep(500);
										return;
									}
								} 

							}
						}
					}
				}
		
		}
	

	@Then("^Click ALL the Multi choice question$")
	public void click_ALL_the_Multi_choice_question() throws Throwable {
		getScroll(driver);
		List<WebElement>Multiplechecks = pag.getCordeForms().getMultipleChoices();
		for(WebElement Multiplecheck :Multiplechecks) {
			ClickElement(Multiplecheck);
			Reporter.addStepLog(Multiplecheck.getText()+" " +"Date is selected");
		}
	}

	@Then("^Check hidden onput field is displayed and enter the \"([^\"]*)\" value$")
	public void check_hidden_onput_field_is_displayed_and_enter_the_value(String arg1) throws Throwable {
		InputvaluesIntoFields(pag.getCordeForms().getInputField(), arg1);
		Reporter.addStepLog(arg1+" "+" value is entered");
	}
		
			
	@Then("^Select first value from drop down$")
	public void select_first_value_from_drop_down() throws Throwable {
		try {
		ClickElement(pag.getCordeForms().getDropdownfield());
		MoveToElement(pag.getCordeForms().getDropdown());
		List<WebElement>Options = pag.getCordeForms().getDropdownOptions();
		for (WebElement Option : Options) {
			if(Option.getText().equalsIgnoreCase("Answer 1")) {
				Reporter.addStepLog(Option.getText()+" "+" value is selected from dropdown");
				ClickElement(Option);
			break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Check the hidden field is displayed after selecting the first dropdown option$")
	public void check_the_hidden_field_is_displayed_after_selecting_the_first_dropdown_option() throws Throwable {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			
		ClickElement(pag.getCordeForms().getDropdownselected());
		MoveToElement(pag.getCordeForms().getDropdown());
		List<WebElement>Options = pag.getCordeForms().getDropdownOptions();
		for (WebElement Option : Options) {
			if(Option.getText().equalsIgnoreCase("Answer 2")) {
				Reporter.addStepLog(Option.getText()+" "+" value is selected from dropdown");
				ClickElement(Option);
				List<WebElement> Radios= pag.getCordeForms().getRadio();
				for(WebElement radio: Radios){
					if(!radio.isDisplayed()) {
						Reporter.addStepLog("Hidden field is not displayed");
						//Thread.sleep(1000);
						ClickElement(pag.getCordeForms().getDropdownselected());
						MoveToElement(pag.getCordeForms().getDropdown());
						List<WebElement>Options1 = pag.getCordeForms().getDropdownOptions();
						for (WebElement Option1 : Options1) {
							if(Option1.getText().equalsIgnoreCase("Answer 1")) {
								Reporter.addStepLog(Option1.getText()+" "+"value is Selected");
								ClickElement(Option1);
								List<WebElement> Radios1= pag.getCordeForms().getRadioOptions();
								for(WebElement radio1: Radios1){
									if(radio1.isDisplayed()) {
										Reporter.addStepLog("Hidden field  is displayed");
										ClickElement(radio1);
										Reporter.addStepLog(radio1.getText()+" "+"value is Selected");
										break;
									}
									
								}
								break;	
							}
							
							}
						break;
					}
					
				}
				
			break;
				}
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("^Click the consent question$")
	public void click_the_consent_question() throws Throwable {
		try {
			getScroll(driver);
		List<WebElement> Consents= pag.getCordeForms().getConsentCheckbox();
		for(WebElement Consent:Consents) {
			if(Consent.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Consent"))){
				Reporter.addStepLog(Consent.getText()+" "+"value is Selected");
				ClickElement(Consent);
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Click the checkbox$")
	public void click_the_checkbox() throws Throwable {
		try {
			
			List<WebElement> Consents= pag.getCordeForms().getConsentCheckbox();
			for(WebElement Consent:Consents) {
				if(Consent.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Checkbox"))){
					Reporter.addStepLog(Consent.getText()+" "+"value is Selected");
					ClickElement(Consent);
				}
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Then("^Click next button to navigate to next page$")
	public void click_next_button_to_navigate_to_next_page() throws Throwable {
		ClickElement(pag.getCordeForms().getNextButton());
		Reporter.addStepLog("Clicked next button  ");
	}

	@Then("^Upload the PDF file \"([^\"]*)\"$")
	public void upload_the_PDF_file(String arg1) throws Throwable {
	WebElement upload=	pag.getCordeForms().getUpload();
	upload.sendKeys(arg1);
	Reporter.addStepLog(arg1+" "+"uploaded the file  ");
	Thread.sleep(10000);
	}

	@Then("^Check the title and description is displayed$")
	public void check_the_title_and_description_is_displayed() throws Throwable {
	}

	@Then("^Click previous button to check page navigates to page(\\d+)$")
	public void click_previous_button_to_check_page_navigates_to_page(int arg1) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", pag.getCordeForms().getFooterlogo());
		//ClickElement(pag.getCordeGridIcon().getAccessBTN());
		Thread.sleep(5000);
		List<WebElement> previous= pag.getCordeForms().getPreviousButton();
		for(WebElement previou :previous) {
			if(previou.getText().equalsIgnoreCase("Previous")) {
				ClickElement(previou);
				break;
			}
		}
		Reporter.addStepLog("Clicked previous button");
	
	}

	@Then("^Click next button from page(\\d+) to navigate to next page(\\d+)$")
	public void click_next_button_from_page_to_navigate_to_next_page(int arg1, int arg2) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		WebElement PageHeading= pag.getCordeForms().getFormHeading();
		if(PageHeading.isDisplayed()&& PageHeading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("PageHeading")) ) {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", pag.getCordeForms().getFooterlogo());
			Reporter.addStepLog("Page navigates to page 1 ");
			ClickElement(pag.getCordeForms().getNextButton());
			Thread.sleep(1000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].scrollIntoView();", pag.getCordeForms().getFooterlogo());
			Reporter.addStepLog("Next button is clicked and  navigated to page 2 ");
			if(pag.getCordeForms().getFilecheck().isDisplayed()) {
				Reporter.addStepLog(pag.getCordeForms().getFilecheck().getText()+" "+ "File is uploaded");
				
			}
		}else {
			throw new NoSuchElementException();
		}
	}

	@Then("^Click Submit to compelete form$")
	public void click_Submit_to_compelete_form() throws Throwable {
		
		List<WebElement> previous= pag.getCordeForms().getPreviousButton();
		for(WebElement previou :previous) {
			if(previou.getText().equalsIgnoreCase("Submit")) {
				Reporter.addStepLog("Submit button is clicked  ");
				ClickElement(previou);
				break;
			}
		}
		Reporter.addStepLog("Clicked previous button  ");
	}

	@Then("^Check the Form submission message is displayed$")
	public void check_the_Form_submission_message_is_displayed() throws Throwable {
		if(pag.getCordeForms().getSubmitMessage().isDisplayed()) {
			Reporter.addStepLog(pag.getCordeForms().getSubmitMessage().getText()+" "+" message is displayed  ");
		}
		else {
			throw new NoSuchElementException();
		}
	}



}
