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
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class CordeMap extends BaseClass {
	
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforehooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	@After
	public void afterhooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	
	
	@Then("^Click on Menu Nav to go to the Map page$")
	public void click_on_Menu_Nav_to_go_to_the_Map_page() throws Throwable {
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
    				Reporter.addStepLog("Main Menu link is Clicked");
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
    		System.out.println(Second.getText());
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Maptext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Maplink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("MapHeading"));
	    				   break;
	    			   	}
	    			}
	    		if (Acc== "Success"){
	    			Reporter.addStepLog("Map module is Clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
	    		break;
	    		}
    	}
	}

	@Then("^Check Map frame is displayed$")
	public void check_Map_frame_is_displayed() throws Throwable {
	WebElement MapFrame = pag.getMaps().getiFrame();
	if(MapFrame.isDisplayed()) {
		Reporter.addStepLog("Basic Map module is displayed");
	}
		
	}

	@Then("^Click Map location$")
	public void click_Map_location() throws Throwable {
		getScroll700(driver);
		getScroll(driver);
		Thread.sleep(5000);
		ClickElement(pag.getMaps().getMapImage());
		Reporter.addStepLog("Map module location is clicked");
	}

	@Then("^Check the pop up content and close it$")
	public void check_the_pop_up_content_and_close_it() throws Throwable {
	String Content = pag.getMaps().getMapcontent().getText();
	if(!Content.isBlank()) {
		Reporter.addStepLog(Content+" "+" content is displayed");
		ClickElement(pag.getMaps().getCloseicon());
		Reporter.addStepLog("Content pop is closed");
	}
	}

}
