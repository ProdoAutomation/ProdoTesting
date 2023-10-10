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

public class CordeRichTextEditor extends BaseClass {
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


	@Then("^Click on Menu Nav to go to the RTE page$")
	public void click_on_Menu_Nav_to_go_to_the_RTE_page() throws Throwable {
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
    	    	//Logic to click RTE 
    	    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	    	if(Secondtext.size()>0) {
    	    	for(WebElement Second:Secondtext) {
    	    		System.out.println(Second.getText());
    	    	
    		    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("RTE"))) {
    		    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
    		    			String text = "Fail";
    		    			if(Viewtext2.size()>0) {
    		    			for(WebElement View2:Viewtext2) {
    		    				System.out.println(View2.getAttribute("href"));
    		    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("RTElink"))) {
    		    				   text = "Success";
    		    				   ClickElement(View2);
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

	@Then("^Check RTE Heading items$")
	public void check_RTE_Heading_items() throws Throwable {
	    WebElement H1= pag.getCordeRTE().getHeading1();
	    WebElement H2= pag.getCordeRTE().getHeading2();
	    WebElement H3= pag.getCordeRTE().getHeading3();
	    WebElement H4= pag.getCordeRTE().getHeading4();
	    WebElement H5= pag.getCordeRTE().getHeading5();
	    WebElement H6= pag.getCordeRTE().getHeading6();
	    
	    Assert.assertTrue(H1.isDisplayed());
	    boolean Heading1 = H1.isDisplayed();
	   if(Heading1== true) {
		 // String Head1= H1.getText();
		  String SizeH1 = H1.getCssValue("font-size");
		  System.out.println(SizeH1);
		//  Assert.assertEquals(Head1,FileReaderManager.getInstance().getCRInstance().getData("Headingtext"));
		  Assert.assertTrue(H1.isDisplayed());
		  Reporter.addScenarioLog(H1.getText()+" "+"is displayed");
		  boolean Heading2 = H2.isDisplayed();
		  if(Heading2==true) {
			  String SizeH2 = H2.getCssValue("font-size");
			  System.out.println(SizeH2);  
//			  Assert.assertEquals(SizeH2,FileReaderManager.getInstance().getCRInstance().getData("H2"));
			  Assert.assertTrue(H2.isDisplayed());
			  Reporter.addScenarioLog(H2.getText()+" "+"is displayed");
		  	}
		 
			  boolean Heading3 = H3.isDisplayed();
			  if(Heading3==true) {
				  String SizeH3 = H3.getCssValue("font-size");
				  System.out.println(SizeH3);  
				 // Assert.assertEquals(SizeH3,FileReaderManager.getInstance().getCRInstance().getData("H3"));
				  Assert.assertTrue(H3.isDisplayed());
				  Reporter.addScenarioLog(H3.getText()+" "+"is displayed");
			  	}
		  
			  Assert.assertTrue(H4.isDisplayed());
			  boolean Heading4 = H4.isDisplayed();
			  if(Heading4==true) {
				  String SizeH4 = H4.getCssValue("font-size");
				  System.out.println(SizeH4);  
				  Reporter.addScenarioLog(H4.getText()+" "+"is displayed");
			  	}
			  Assert.assertTrue(H5.isDisplayed());
			  boolean Heading5 = H5.isDisplayed();
			  if(Heading5==true) {
				  String SizeH5 = H5.getCssValue("font-size");
				  System.out.println(SizeH5);  
				  Reporter.addScenarioLog(H5.getText()+" "+"is displayed");
			  	}
			  Assert.assertTrue(H6.isDisplayed());
			  boolean Heading6 = H6.isDisplayed();
			  if(Heading6==true) {
				  String SizeH6 = H6.getCssValue("font-size");
				  System.out.println(SizeH6);  
				  Reporter.addScenarioLog(H6.getText()+" "+"is displayed");
			  	}
		  }
	   List<WebElement> ULtag= pag.getCordeRTE().getULTags();
	   if(ULtag.size()>0) {
		   List<WebElement> OLtag= pag.getCordeRTE().getOLTags();
		   		if(OLtag.size()>0) {
		   			getScroll(driver);
		   		//Store the ID of the original window
					String originalWindow = driver.getWindowHandle();
					//Check we don't have other windows open already
					assert driver.getWindowHandles().size() == 1;
		   			ClickElement(pag.getCordeRTE().getPrimaryBT());
		   			for (String windowHandle : driver.getWindowHandles()) {
						System.out.println(windowHandle);
					    if(!originalWindow.contentEquals(windowHandle)) {
					        driver.switchTo().window(windowHandle);
					        Thread.sleep(500);
					        driver.close();
					        driver.switchTo().window(originalWindow);
					    		}
		   			}
		   			getScroll(driver);
		   			ClickElement(pag.getCordeRTE().getSecondaryBT());
		   			driver.navigate().back();
		   			String SecPage = driver.getTitle();
		   			Assert.assertEquals(SecPage,FileReaderManager.getInstance().getCRInstance().getData("Primarypage"));
		   		
		   		}
		   
	   }
	   
	   }
	   
	   
	   
	   
	}


