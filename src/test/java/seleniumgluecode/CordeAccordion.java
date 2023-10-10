package seleniumgluecode;

import java.io.IOException;

import java.util.List;
import java.util.NoSuchElementException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class CordeAccordion extends BaseClass {
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
	
	

    @Then("^Click on Menu Nav to go to the accordion page$")
    public void click_on_menu_nav_to_go_to_the_accordion_page() throws Throwable {
    	
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
    	//Logic to click Accordion grid and check images
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	getScroll(driver);
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Acctext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Acclink"))) {
	    				    Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("AccHeading"));
	    				   break;
	    			   }
	    				
	    			}
	    		if (Acc== "Success"){
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
    

    @Then("^Check the accordion list$")
    public  void check_the_accordion_list() throws Throwable {
    	getScroll700(driver);
    	List<WebElement> Accordionlinks = pag.getCordeAcc().getAccordiondrop();
    	    	if(Accordionlinks.size() > 0) {
   		for(WebElement Acclink:Accordionlinks) {
	    				   ClickElement(Acclink);
    				   WebElement image1 = pag.getCordeAcc().getAccImage();  
    				   ImageCheck(image1);
   					}
    	    	}
		    			
    }

   

	@Then("^Check Tab lists$")
    public void check_tab_lists() throws Throwable {
		
    	List<WebElement> Tablinks = pag.getCordeAcc().getTablinks();
    	if(Tablinks.size() > 0) {
    	for(WebElement Tablink:Tablinks) {
	    				   ClickElement(Tablink);
    				}
    		}
    			else
    				{
    					throw new NoSuchElementException();
    				}
    	}
}
