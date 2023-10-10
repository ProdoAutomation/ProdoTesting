package seleniumgluecode;



import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;


public class CordeStatistics extends BaseClass{
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	SoftAssert softAssert = new SoftAssert();
	
	private static Scenario scenario;
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
		softAssert.assertTrue(Stattitle.contains(FileReaderManager.getInstance().getCRInstance().getData("StatTitle")));
		WebElement Statheading= pag.getCordeStat().getStattiltle();
		if(Statheading.isDisplayed()) {
			if(Statheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Headingtext"))) {
				List<WebElement> Stats= pag.getCordeStat().getStat();
				getScroll(driver);
				WaitForAllElementvisibility(Stats);
				Thread.sleep(5000);
				
				for(WebElement Statnumber:Stats) {
					System.out.println(Statnumber.getText());
					if(Statnumber.getText().equalsIgnoreCase("£12.23%")) {
						
						 Reporter.addStepLog("First Stats grid value is  £12.23%");
						}
					else	if (Statnumber.getText().equalsIgnoreCase("45.45%")) {
						 
						Reporter.addStepLog("First Stats grid value is  45.45%");
					}
					else	if (Statnumber.getText().equalsIgnoreCase("£1.75m")) {
						 
						Reporter.addStepLog("First Stats grid value is  £1.75m");	
					}
					else	if (Statnumber.getText().equalsIgnoreCase("2.2 Pound")) {
						 
						Reporter.addStepLog("First Stats grid value is  2.2 Pound");	
					}	
					else	if (Statnumber.getText().equalsIgnoreCase("45.45%")) {
						 
						Reporter.addStepLog("First Stats grid value is  45.45%");	
					}
					else {
						throw new NoSuchElementException();
						}
					}
					List<WebElement> StatsHeadings= pag.getCordeStat().getStatHeading();
					if(StatsHeadings.size() >= 0) {
					Reporter.addStepLog("Stats headings are listed and  verified");
					}
					else {
						throw new NoSuchElementException();
					}
					List<WebElement> StatsSummaries= pag.getCordeStat().getStatSummary();
					if(StatsSummaries.size() >= 0) {
						Reporter.addStepLog("Stats Summaries are listed and  verified");
					}
					else {
						throw new NoSuchElementException();
					}
					
			}	
		}		
	}
	
}		
			
		
	
	

