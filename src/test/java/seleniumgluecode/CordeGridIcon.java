package seleniumgluecode;



import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CordeGridIcon extends BaseClass{
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	@Before
	public  void beforehooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	@After
	public  void afterhooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	@Given("^Launch the Application to test Grid module$")
	public void launch_the_Application_to_test_Grid_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Grid page$")
	public void click_on_Menu_Nav_to_go_to_the_Grid_page() throws Throwable {
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
    	//Logic to click Grid Icon
    	getScroll700(driver);
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	if(Secondtext.size()>0) {
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			String text = "Fail";
	    			if(Viewtext2.size()>0) {
	    			for(WebElement View2:Viewtext2) {
	    				System.out.println(View2.getAttribute("href"));
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Gridlink"))) {
	    				   text = "Success";
	    				   ClickElement(View2);
	    				   String Gridtitle = driver.getTitle();
	    				   Assert.assertEquals(Gridtitle,FileReaderManager.getInstance().getCRInstance().getData("GridTitle"));
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

	@Then("^Check primary grid items  are displayed$")
	public void check_primary_grid_items_are_displayed() throws Throwable {
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		ClickElement(pag.getCordeGridIcon().getAccessBTN());
		List<WebElement> PG = pag.getCordeGridIcon().getPrimaryGrids();
		for(WebElement Primary: PG) {
			boolean check = Primary.isEnabled();
			System.out.println(check);
			if(check= true) {
				ClickElement(Primary);
				String GT = driver.getTitle();
				System.out.println(GT);
				if(GT.equalsIgnoreCase("Mods | Core Code")) {
					Reporter.addStepLog("Grid has link");
					driver.navigate().back();
				}
				else if (GT.equalsIgnoreCase("Grid - Icon | Core Code")) {
					Reporter.addStepLog("Grid doesnt have link");
				}
				
			}
			else {
				System.out.println("Non Clickable");
			}
		}
	}

	@Then("^Check secondary grid items  are displayed$")
	public void check_secondary_grid_items_are_displayed() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
		
		List<WebElement> SG = pag.getCordeGridIcon().getSecondaryGrids();
		for(WebElement Secondary: SG) {
			boolean Secondarycheck = Secondary.isEnabled();
			System.out.println(Secondarycheck);
			if(Secondarycheck= true) {
				ClickElement(Secondary);
				String SecondaryTitle = driver.getTitle();
				System.out.println(SecondaryTitle);
				if(SecondaryTitle.equalsIgnoreCase("Corde Housing | Core Code")) {
					Reporter.addStepLog("Seconadary Grid has link");
					driver.navigate().back();
				}
				else if (SecondaryTitle.equalsIgnoreCase("Grid - Icon | Core Code")) {
					Reporter.addStepLog("Grid doesnt have link");
				}
				
			}
			else {
				System.out.println("Non Clickable");
			}
		}
	}

	@Then("^Check the grid with link and without links in$")
	public void check_the_grid_with_link_and_without_links_in() throws Throwable {
		List<WebElement> imgs = pag.getCordeGridIcon().getImgPrimaryGrid();
		for(WebElement img:imgs) {
			if(img.getAttribute("alt").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridImage1"))) {
				Reporter.addStepLog("Grid Image1 is displayed");
			}else if(img.getAttribute("alt").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GridImage2"))) {
				Reporter.addStepLog("Grid Image2 is displayed");
			}
		}
		List<WebElement> IconsPrimary = pag.getCordeGridIcon().getIconPrimaryGrid();
		for(WebElement IconPrimary:IconsPrimary) {
			if(IconPrimary.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("GamepadIcon"))) {
				Reporter.addStepLog("Grid GamepadIcon is displayed");
			}else if(IconPrimary.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("AppleIcon"))) {
				Reporter.addStepLog("Grid AppleIcon is displayed");
			}else if(IconPrimary.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("RobotIcon"))) {
				Reporter.addStepLog("Grid RobotIcon is displayed");
			}
		}
		if(pag.getCordeGridIcon().getImageGrid().isDisplayed()) {
			List<WebElement> IconsSec = pag.getCordeGridIcon().getIconGrid();
			for(WebElement IconSec:IconsSec) {
				if(IconSec.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("CheckIcon"))) {
					Reporter.addStepLog("Grid Sec CheckIcon is displayed");
				}else if(IconSec.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("AlgoliaIcon"))) {
					Reporter.addStepLog("Grid Sec AlgoliaIcon is displayed");
				}else if(IconSec.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ArtstationIcon"))) {
					Reporter.addStepLog("Grid ArtstationIcon is displayed");
				}
			}
		}
	}
}
