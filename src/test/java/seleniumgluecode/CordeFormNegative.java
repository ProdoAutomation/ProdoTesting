package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.cucumber.listener.Reporter;
import baseClass.BaseClass;

import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;





public class CordeFormNegative extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
		
	}
	@Given("^Launch the Application to test Neagtive sceanrio Form module$")
	public void launch_the_Application_to_test_Neagtive_sceanrio_Form_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the page$")
	public void click_on_Menu_Nav_to_go_to_the_page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	
    	String check = "Fail";
    	for(WebElement elem:Menutext) {
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
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Forms1"))) {
	    			Reporter.addStepLog("Feature Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FormsLink1"))) {
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

	@Then("^Click Next button$")
	public void click_Next_button() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", pag.getCordeForms().getFooterlogo());
		ClickElement(pag.getCordeForms().getNextButton());
	}

	@Then("^Check the error messages are displayed for mandatory field$")
	public void check_the_error_messages_are_displayed_for_mandatory_field() throws Throwable {
		List<WebElement> Indicatorfields = pag.getCordeForms().getIndicatorField();
		for(WebElement Indicatorfield :Indicatorfields) {
			System.out.println(Indicatorfield.getText());
			if(Indicatorfield.getText().equalsIgnoreCase("Short Answer *")) {
					List<WebElement> ErrorMsgs = pag.getCordeForms().getErrorMsg();
					for(WebElement ErrorMsg :ErrorMsgs ) {
						if(ErrorMsg.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ShortError"))) {
							Reporter.addStepLog(Indicatorfield.getText()+" "+" is Mandatory");
							break;
						
							}	
						}
					}
			else if(Indicatorfield.getText().equalsIgnoreCase("Second Answer *")) {
					List<WebElement> ErrorMsgs = pag.getCordeForms().getErrorMsg();
					for(WebElement ErrorMsg :ErrorMsgs ) {
						if(ErrorMsg.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("DateError"))) {
							Reporter.addStepLog(Indicatorfield.getText()+" "+" is Mandatory");
							break;
							}
						}
					break;
			}
			
			}
		
		
	}

	@Then("^Check the upload only allow PDF file$")
	public void check_the_upload_only_allow_PDF_file() throws Throwable {
		try {
		List<WebElement> ShortAnswerfields = pag.getCordeForms().getErrorinput();
		for (WebElement ShortAnswerfield : ShortAnswerfields) {
			if(ShortAnswerfield.isDisplayed()) {
				InputvaluesIntoFields(ShortAnswerfield, "arg1");
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
		WebElement upload=	pag.getCordeForms().getUpload();
		upload.sendKeys("C:\\Users\\rajalakshmiganesan\\Desktop\\git.txt");
		getScroll(driver);
		ClickElement(pag.getCordeForms().getNextButton());
		
	WebElement ErrorMsg = pag.getCordeForms().getUploaderrormsg();
		
		if(ErrorMsg.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("UploadError"))) {
			upload.sendKeys("C:\\Users\\rajalakshmiganesan\\Desktop\\test-pdf-document.pdf");
			ClickElement(pag.getCordeForms().getNextButton());
			if(pag.getCordeForms().getSubmitMessage().isDisplayed()) {
				Reporter.addStepLog(pag.getCordeForms().getSubmitMessage().getText()+" "+" message is displayed  ");
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
	}
	
}
