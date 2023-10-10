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

public class CordeLogoRotator extends BaseClass {
	
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
			getScreenshot(driver,scenario.getName());
		}
	}
	
	@Then("^Click on Menu Nav to go to the Logo Rotator page$")
	public void click_on_Menu_Nav_to_go_to_the_Logo_Rotator_page() throws Throwable {
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
    	
    
    	//Logic to click Image Module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	getScroll(driver);
    	for(WebElement Grid:Gridtext) {
    		System.out.println(Grid.getText());
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ImageMText"))) {
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ImageModule"))) {
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
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("LogoText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Logolink"))) {
	    				
	    				    Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("LogoHeading"));
	    				   break;
	    			   }
	    				
	    			}
	    		if (Acc== "Success"){
	    			Reporter.addStepLog("Latestlink is Clicked");
    					}   		
    			else
    				{
    				throw new NoSuchElementException();
    				}
	    		break;
	    		}
    	}
	}

	@Then("^Check Logo Rotator Images are displayed$")
	public void check_Logo_Rotator_Images_are_displayed() throws Throwable {
		getScroll(driver);
		List<WebElement> Images = pag.getLogoRotator().getLogoImages();
		
			for (int i = 0; i < Images.size();i++) {
			Reporter.addStepLog("Image "+i+  " is displayed");
			ImageCheck(Images.get(i));
		
			}
	}

	@Then("^Check Logo Rotator Heading,summary and CTA are displayed$")
	public void check_Logo_Rotator_Heading_summary_and_CTA_are_displayed() throws Throwable {
		WebElement Heading = pag.getLogoRotator().getLogoHeading();
		if(Heading.isDisplayed()) {
			Reporter.addStepLog("Logo Rotator Heading is displayed");
			WebElement Summary = pag.getLogoRotator().getLogoParagraph();
			if(Summary.isDisplayed()) {
				Reporter.addStepLog("Logo Rotator Summary is displayed");
				WebElement CTA = pag.getLogoRotator().getLogoLink();
				if(CTA.isDisplayed()) {
				String actualtitle=driver.getTitle();
				getScroll(driver);
				ClickElement(CTA);
				String title = driver.getTitle();
				Assert.assertFalse(title.equalsIgnoreCase(actualtitle), "Link is clicked");
				Reporter.addStepLog("Logo Rotator Link is clicked");
				}
			}
			
		}
	}



}
