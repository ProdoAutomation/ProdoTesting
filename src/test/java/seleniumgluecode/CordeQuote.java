package seleniumgluecode;

import java.awt.image.BufferedImage;
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

public class CordeQuote extends BaseClass{
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
	@Given("^Launch the Application to test Quote module$")
	public void launch_the_Application_to_test_Quote_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Quote page$")
	public void click_on_Menu_Nav_to_go_to_the_Quote_page() throws Throwable {
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
    	getScroll(driver);
    	//Logic to click Quote grid
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("QuoteText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    				
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("QuoteLink"))) {
	    				   ClickElement(View2);
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}

	}

	@Then("^Check Quote items$")
	public void check_Quote_items() throws Throwable {
		try {
		WebElement image1 = pag.getCordeQuote().getQuoteImage();    
		   String img = image1.getAttribute("src");
		   
			   if (img== null) {
				   throw new NoSuchElementException();
			   }
			   else {
				   BufferedImage imgs=ImageIO.read(new URL(img));
				   System.out.println("Image is displayed");
			   }
			   WebElement Quotetext = pag.getCordeQuote().getQuotetext();
			   Assert.assertTrue(Quotetext.isDisplayed());
			   boolean Qutext = Quotetext.isDisplayed();
			   if(Qutext==true) {
				   WebElement Quoteauthor = pag.getCordeQuote().getQuoteAuthor(); 
				   Assert.assertTrue(Quoteauthor.isDisplayed());
			   }
		}catch(IOException e){
		   e.printStackTrace();
	    	
				}
		

	}
}
