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

public class CordeLargeImage extends BaseClass {
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
	
	@Then("^Click on Menu Nav to go to the Large Image page$")
	public void click_on_Menu_Nav_to_go_to_the_Large_Image_page() throws Throwable {
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
    	
    
    	//Logic to click Image Module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	getScroll(driver);
    	for(WebElement Grid:Gridtext) {
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ImageMText"))) {
	    			Reporter.addStepLog("Image modules link is found");
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ImageModule"))) {
	    				   Grid1="Success";
	    				   ClickElement(View);
	    				   break;
	    			   }
	    			}
	    			if (Grid1== "Success"){
	    				Reporter.addStepLog("Image modules grids page is displayed");
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
    	getScroll(driver);
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("LargeImageText"))) {
	    			Reporter.addStepLog("Image Text Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("LargeImagelink"))) {
	    				   Acc = "Success";
	    				   getScroll(driver);
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("LargeHeading"));
	    				   break;
	    			   }
	    			}
	    		if (Acc== "Success"){
	    			Reporter.addStepLog("Image Text page is displayed");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
	    		break;
	    		}
    		}
	}

	@Then("^Check Large Image is displayed$")
	public void check_Large_Image_is_displayed() throws Throwable {
		WebElement Image = pag.getLargeImage().getImage();
		ImageCheck(Image);
		  
	}

	@Then("^Check Large Image Heading,summary and CTA are displayed$")
	public void check_Large_Image_Heading_summary_and_CTA_are_displayed() throws Throwable {
		getScroll(driver);
			WebElement Heading = pag.getLargeImage().getLargeHeading();
			if(Heading.isDisplayed()) {
				Reporter.addStepLog("Large Image Heading is displayed");
				WebElement Summary = pag.getLargeImage().getLargeSummary();
				if(Summary.isDisplayed()) {
					Reporter.addStepLog("Large Image Summary is displayed");
					WebElement CTA = pag.getLargeImage().getLargeLink();
					if(CTA.isDisplayed()) {
					String actualtitle=driver.getTitle();
					ClickElement(CTA);
					String title = driver.getTitle();
					Assert.assertFalse(title.equalsIgnoreCase(actualtitle), "Link is clicked");
					Reporter.addStepLog("Large Image Link is clicked");
					}
				}
				
			}
	}


}
