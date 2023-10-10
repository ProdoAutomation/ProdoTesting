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

public class CordeImageGallery extends BaseClass{
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	
	@Before
	public void beforehooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	@After
	public void afterhooks(Scenario scenario) throws IOException {
		String status =scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	
	@Then("^Click on Menu Nav to go to the Image Gallery page$")
	public void click_on_Menu_Nav_to_go_to_the_Image_Gallery_page() throws Throwable {
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
    	
    
    	//Logic to click FunctionalModule grid in the page
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
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GalleryText"))) {
	    			Reporter.addStepLog("Image Text Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GalleryLink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("GalleryTitle"));
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

	@Then("^Check Images,summary and pagination$")
	public void check_Images_summary_and_pagination() throws Throwable {
		String CountText = pag.getImageGallery().getCounter().getText();
		int Count = Integer.valueOf(CountText);
	
		for(int i=1;i<=Count;i++) {
			String Currentcount = pag.getImageGallery().getCurrentslide().getText();
			int Current = Integer.valueOf(Currentcount);
			if(Current==i) {
			ClickElement(pag.getImageGallery().getNextarrow());
			WebElement image = pag.getImageGallery().getImages();
			ImageCheck(image);
			WebElement Summary = pag.getImageGallery().getSummary();
			if(Summary.isDisplayed()) {
				Reporter.addStepLog("Image Summary is displayed");
			}
			else {
				Reporter.addStepLog("Image Summary is not displayed");
			}
		}
	}

}
}
