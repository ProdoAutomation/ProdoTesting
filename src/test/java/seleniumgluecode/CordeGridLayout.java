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

public class CordeGridLayout extends BaseClass {
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
	@Then("^Click on Menu Nav to go to the Grid Layout page$")
	public void click_on_Menu_Nav_to_go_to_the_Grid_Layout_page() throws Throwable {
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
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridLayout"))) {
	    			Reporter.addStepLog("Image Text Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridLayoutLink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("GridLayoutTitle"));
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

	@Then("^Check Grid Child pages$")
	public void check_Grid_Child_pages() throws Throwable {
		List<WebElement> Childpages = pag.getGridLayout().getPaginations();
		if(Childpages.size()>0) {
			for(WebElement Childpage:Childpages ) {
				boolean disabled = pag.getGridLayout().getNext().getAttribute("class").contains("e-btn--disabled");
			while(disabled==false) {
				ClickElement(pag.getGridLayout().getNext());
				Thread.sleep(100);
				 disabled = pag.getGridLayout().getNext().getAttribute("class").contains("e-btn--disabled");
				break;
				}
			}
		if(	pag.getGridLayout().getPrevious().isEnabled()	) {
			Thread.sleep(100);
			ClickElement(pag.getGridLayout().getPrevious());
		}
		else {
			throw new NoSuchElementException();
		}
			}
		
	}

	@Then("^Check Grid Manual pages$")
	public void check_Grid_Manual_pages() throws Throwable {
		
	List<WebElement> GridHeadings = pag.getGridLayout().getGridHeadings();
	List<WebElement> GridLinks = pag.getGridLayout().getGridLinks();
	if(GridHeadings.size()==GridLinks.size()) {
		Reporter.addStepLog(GridHeadings.size()+"Grid items are displayed");
	}
	else{
		
		throw new NoSuchElementException();
	}
	}

	@Then("^Check Grid Picker pages$")
	public void check_Grid_Picker_pages() throws Throwable {
		List<WebElement> GridImages = pag.getGridLayout().getGridImages();
		for(WebElement GridImage:GridImages ) {
			ImageCheck(GridImage);
			Reporter.addStepLog(GridImages.indexOf(GridImage)+"  image is  displayed");
			
			
			
		}
		List<WebElement> Summary = pag.getGridLayout().getGridSummary();
		if(Summary.size()>0) {
			Reporter.addStepLog(Summary.size()+"  Summaries are displayed");
		}
		
	}



}
