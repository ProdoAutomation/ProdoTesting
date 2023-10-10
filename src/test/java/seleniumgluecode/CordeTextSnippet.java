package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

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

public class CordeTextSnippet extends BaseClass {

	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforeHooks(Scenario scenario) {
		Reporter.assignAuthor("QA by Raji");
		String name = scenario.getName();
		
	}
	
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
			
		}
	}
	
	

    @Then("^Click on Menu Nav to go to the Text Snippet page$")
    public void click_on_menu_nav_to_go_to_the_text_snippet_page() throws Throwable {
    	//Logic to click menu items
    	
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	System.out.println(Menutext);
    	String check = "Fail";
    	for(WebElement elem:Menutext) {
    		System.out.println(elem.getAttribute("href"));
	    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
	    			check = "Success";
	    			ClickElement(elem);
	    			break;
	    			}
	    		}
    			if (check== "Success"){
    				System.out.println("Menu Link clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
    	//Logic to click Content module grid in the page
    			List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	    	for(WebElement Grid:Gridtext) {
    	    		System.out.println(Grid.getText());
    	    		String Grid1 = "Fail";
    		    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridLink"))) {
    		    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
    		    			for(WebElement View:Viewtext) {
    		    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ViewLink"))) {
    		    				   Grid1="Success";
    		    				   ClickElement(View);
    		    				   break;
    		    			   }
    		    			}
    		    			if (Grid1== "Success"){
    		    				System.out.println("Content module Link clicked");
    		    					}   		
    		    			else
    		    				{
    		    				throw new NoSuchElementException();
    		    				}
    		    			break;
    		    		}
    		    		
    	    	}
    	//Scrolling the page a bit down
    	 getScroll(driver);
    	//Logic to click Text snippet 
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	if(Secondtext.size()>0) {
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Textsnippet"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			String text = "Fail";
	    			if(Viewtext2.size()>0) {
	    			for(WebElement View2:Viewtext2) {
	    				System.out.println(View2.getAttribute("href"));
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Textlink"))) {
	    				   text = "Success";
	    				   ClickElement(View2);
	    				   break;
	    			   }
	    				
	    			}
	    			if (text== "Success"){
	    				System.out.println("Menu Link clicked");
	    					}   		
	    			else
	    				{
	    				throw new NoSuchElementException();
	    				}
	    			break;
	    			}
	    		}
    		}
    	}
    }

    @Then("^Check Heading and summary items$")
    public void check_heading_and_summary_items() throws Throwable {
    	try {
    	WebElement TextHeading = pag.getCordeText().getTextSnippetHeading();
    	Assert.assertTrue(TextHeading.isDisplayed());
    	String Para=TextHeading.getText();
    	if(Para.equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("TextSnippetPara"))) {
    		if((TextHeading.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("CordeURL")))){
    			getScroll(driver);
    			WebElement button = pag.getCordeText().getTextSnippetCTA();
    		//boolean ButtonVisible = button.isDisplayed();
    			ClickElement(pag.getCordeText().getTextSnippetCTA());
    		}
    	
    	
    	}
    	}
    	catch(Exception ex)
    	{
    		System.out.print(ex.getMessage());
    	}
    	
        
    }

  
}
