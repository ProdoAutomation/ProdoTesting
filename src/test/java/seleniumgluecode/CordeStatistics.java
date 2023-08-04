package seleniumgluecode;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.print.Printable;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
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


public class CordeStatistics extends BaseClass{
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	
	
	private static Scenario scenario;
	@Before
	public void beforeHooks(Scenario scenario) {
		
		Reporter.assignAuthor("QA by Raji");
		String name = scenario.getName();
		System.out.println("This will run before the Scenario");
	}
	
	
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	@Given("^Launch the Application to test Statistics module$")
	public void launch_the_Application_to_test_Statistics_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
		Reporter.addStepLog("Application URL is Lauched");
		
	}

	@Then("^Click on Menu Nav to go to the Statistics page$")
	public void click_on_Menu_Nav_to_go_to_the_Statistics_page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	for(WebElement elem:Menutext) {
    		System.out.println(elem.getAttribute("href"));
    	
	    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
	    			ClickElement(elem);
	    			
	    			Reporter.addStepLog("Main Nav is clicked");
	    			break;
	    		}
    	}
    	//Logic to click Content module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		System.out.println(Grid.getText());
    	
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridLink"))) {
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ViewLink"))) {
	    				   ClickElement(View);
	    				   Reporter.addStepLog("Content module grid is clicked");
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
    	//Scrolling the page a bit down
    	getScroll(driver);
    	//Logic to click Quote grid
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("StatText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    				
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("StatLink"))) {
	    				   ClickElement(View2);
	    				   Reporter.addStepLog("Stats grid is clicked");
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}


	}

	@Then("^Check  Statistics number heading and link$")
	public void check_Statistics_number_heading_and_link() throws Throwable {
		
		String Stattitle = driver.getTitle();
		assertTrue(Stattitle.contains(FileReaderManager.getInstance().getCRInstance().getData("StatTitle")));
		
		WebElement Statheading= pag.getCordeStat().getStattiltle();
		if(Statheading.isDisplayed()) {
			if(Statheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Headingtext"))) {
				List<WebElement> Stats= pag.getCordeStat().getStat();
				getScroll(driver);
				WaitForAllElementvisibility(Stats);
				
				for(WebElement Statnumber:Stats) {
					if(Statnumber.getText().equalsIgnoreCase("£12.23%")) {
						 Reporter.addStepLog("First Stats grid value is  £12.23%");
						 
						}
					else {
						Reporter.addStepLog("First Stats grid value is not  £12.23%");
						throw new NoSuchElementException();
					}
					if (Statnumber.getText().equalsIgnoreCase("45.45%")) {
						Reporter.addStepLog("First Stats grid value is  45.45%");
					}else {
						Reporter.addStepLog("First Stats grid value is not  45.45%");
						throw new NoSuchElementException();
					}
					if (Statnumber.getText().equalsIgnoreCase("£1.75m")) {
						Reporter.addStepLog("First Stats grid value is  £1.75m");	
					}else {
						throw new NoSuchElementException();
					}
					if (Statnumber.getText().equalsIgnoreCase("2.2 Pound")) {
						Reporter.addStepLog("First Stats grid value is  2.2 Pound");	
					}	else {
						throw new NoSuchElementException();
					}
					if (Statnumber.getText().equalsIgnoreCase("45.45%")) {
						Reporter.addStepLog("First Stats grid value is  45.45%");	
					}else {
						throw new NoSuchElementException();
					}
					}
				
					
					
						
				List<WebElement> StatsHeadings= pag.getCordeStat().getStatHeading();
				if (StatsHeadings.size() >= 0) {
					Reporter.addStepLog("Stats headings are listed and  verified");
					
				}else {
					throw new NoSuchElementException();
				}
				List<WebElement> StatsSummaries= pag.getCordeStat().getStatSummary();
				if (StatsSummaries.size() >= 0) {
					Reporter.addStepLog("Stats Summaries are listed and  verified");
					
				}
				else {
					throw new NoSuchElementException();
				}
					
			}	
		}		
	}		
}		
			
		
	
	

