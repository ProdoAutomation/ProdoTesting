package seleniumgluecode;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CordeQuickLinks extends BaseClass {
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
	
	 	@Given("^Launch the corde$")
	    public void launch_the_application_corde() throws Throwable {
	 		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	    }

	    @Then("^Click on Menu Nav to go to the Quick Links page$")
	    public void click_on_menu_nav_to_go_to_the_quick_links_page() throws Throwable {
	    	
	    	//Logic to click menu items
	    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
	    	for(WebElement elem:Menutext) {
	    		System.out.println(elem.getAttribute("href"));
	    	
		    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
		    			ClickElement(elem);
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
		    				   break;
		    			   }
		    				
		    			}
		    			break;
		    		}
	    	}
	    	//Scrolling the page a bit down
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,500)");
	    	//Logic to click Quick Link grid
	    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
	    	for(WebElement Second:Secondtext) {
	    		System.out.println(Second.getText());
	    	
		    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Quicktext"))) {
		    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
		    			
		    			for(WebElement View2:Viewtext2) {
		    				
		    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Quicklink"))) {
		    				   ClickElement(View2);
		    				   break;
		    			   }
		    				
		    			}
		    			break;
		    		}
	    	}
	    }

	    @Then("^Check quick link image and text$")
	    public boolean check_quick_link_image_and_text() throws Throwable {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,500)");
	    	
	    //Method to check image is displayed 
	    	WebElement image1= pag.getCordeQuickLinkPage().getQuickimage();
	    	 String img = image1.getAttribute("src");
	    	 try {
	    		 if (img== null) {
	    				throw new NoSuchElementException();
	 		    }
	    		 else {
	    		    BufferedImage imgs=ImageIO.read(new URL(img));
	    		    
	    		    return true;
	    		 }
	    		   
	    	 } catch(IOException e){
	 		    	e.printStackTrace();
	 		    	return false;
	 		    	}
	    }	

	    @Then("^Check quick link items$")
	    public void check_quick_link_items() throws Throwable {
	        
	        
	    	  //Method to click and check all the quick links
	    	
	    	List<WebElement> QCLinks= pag.getCordeQuickLinkPage().getQuicklinks();
	    	for(WebElement QC: QCLinks) {
	    		if (QC.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Acclink"))) {
	    			ClickElement(QC);
	    			driver.getTitle().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("AccordionTitle"));
	    			driver.navigate().back();
	    			}
	    			else if (QC.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("DocLink"))) {
	    			ClickElement(QC);
		    		driver.getTitle().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("AccordionTitle"));
		   			driver.navigate().back();
		   			break;
					}
	    			
	    		}
	    	}
	    	
	    
	    }



