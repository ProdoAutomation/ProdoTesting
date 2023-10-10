package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

public class CordeRawHTML extends BaseClass{
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
	
	
	
	
	@Then("^Click on Menu Nav to go to the Raw HTML Module Page$")
	public void click_on_Menu_Nav_to_go_to_the_Raw_HTML_Module_Page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
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
    				Reporter.addStepLog("Main Menu link is Clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
    	
    
    	//Logic to click Content module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FunctionalModule"))) {
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Functionalviewlink"))) {
	    				   Grid1="Success";
	    				   ClickElement(View);
	    				   break;
	    			   }
	    			}
	    			if (Grid1== "Success"){
	    				Reporter.addStepLog("Grid link is Clicked");
	    					}   		
	    			else
	    				{
	    				throw new NoSuchElementException();
	    				}
	    			break;
	    		}
	    		
    	}
    	//Logic to click Accordion grid and check images
    	getScroll(driver);
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Rawtext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Rawlink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("RawHeading"));
	    				   Thread.sleep(5000);
	    				   break;
	    			   	}
	    			}
	    		if (Acc== "Success"){
	    			Reporter.addStepLog("Raw HTML is Clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
	    		break;
	    		}
    	}
	}

	@Then("^Check the Raw Html frame is displayed$")
	public void check_the_Raw_Html_frame_is_displayed() throws Throwable {
	WebElement iFrame = pag.getRawhtml().getRawHTML();
	if (iFrame.isDisplayed()) {
		Reporter.addStepLog("Raw HTML frame is displayed");
		}
	else {
		throw new NoSuchElementException();
	}
	}

}
