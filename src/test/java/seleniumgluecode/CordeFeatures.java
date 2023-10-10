package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.testng.Assert;
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

public class CordeFeatures extends BaseClass {
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		
	}
	
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		String status= scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	

	@Then("^Click on Menu Nav to go to the Features page$")
	public void click_on_Menu_Nav_to_go_to_the_Features_page() throws Throwable {
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
    				Reporter.addStepLog("Main Menu link is clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
    	
    
    	//Logic to click Content module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridLink"))) {
	    			Reporter.addStepLog("Content modules link is found");
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ViewLink"))) {
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
    	//Logic to click Accordion grid and check images
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Features"))) {
	    			Reporter.addStepLog("Feature Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FeaturesLink"))) {
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
	@Then("^Check all the icons are displayed$")
	public void check_all_the_icons_are_displayed() throws Throwable {
		List<WebElement> Featicons = pag.getCordeFeatures().getFeatIcons();
		if (Featicons.size()>0) {
			Reporter.addStepLog("Feature Icons are didplayed");
			
			List<WebElement> FeatHeadings = pag.getCordeFeatures().getFeatHeadings();
			if (FeatHeadings.size()>0) {
				Reporter.addStepLog("Feature Headings are didplayed");
				List<WebElement> FeatSummaries = pag.getCordeFeatures().getFeatSummaries();
				if (FeatSummaries.size()>0) {
					Reporter.addStepLog("Feature summaries are didplayed");	
					
				}
			}
			
			
		}
	}

	@Then("^Check Features CTAs working fine$")
	public void check_Features_CTAs_working_fine() throws Throwable {
		List<WebElement> FeatLinks = pag.getCordeFeatures().getFeatLinks();
		for(WebElement FeatLink: FeatLinks) {
			getScroll(driver);
			ClickElement(FeatLink);
			String Feature=driver.getTitle();
			Assert.assertNotEquals(Feature,FileReaderManager.getInstance().getCRInstance().getData("FeatureTitle"));
			driver.navigate().back();
			String FeatureTitle1=driver.getTitle();
			System.out.println(FeatureTitle1);
			Assert.assertEquals(FeatureTitle1,FileReaderManager.getInstance().getCRInstance().getData("FeatureTitle"));
			
			Reporter.addStepLog("Feature Link is clicked");	
			
		}
		
	}

}
