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

public class CordePropertyListingModule extends BaseClass{
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
	@Given("^Launch the Application to test Property listing Module$")
	public void launch_the_Application_to_test_Property_listing_Module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Property listing Module Page$")
	public void click_on_Menu_Nav_to_go_to_the_Property_listing_Module_Page() throws Throwable {
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
    	
    
    	//Logic to click Content module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		String Grid1 = "Fail";
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FunctionalModule"))) {
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Functionalviewlink"))) {
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
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("PropListtext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("PropListlink"))) {
	    				
	    				    Acc = "Success";
	    				   ClickElement(View2);
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

	@Then("^Check the Properties are displayed$")
	public void check_the_Properties_are_displayed() throws Throwable {
		List<WebElement> Properties = pag.getPropertylistmodule().getPropertylistings();
		if(Properties.size()>0 ||Properties.size()==2 ) {
			Reporter.addStepLog(Properties.size()+" "+"properties are displayed ");
		}
		
	}

	@Then("^Check image is displayed$")
	public void check_image_is_displayed() throws Throwable {
		List<WebElement> images = pag.getPropertylistmodule(). getPropertyImages(); 
		  for(WebElement image:images) {
			  ImageCheck(image);
		  }
	}

	@Then("^Check promotion labels,property headings and property details are displayed$")
	public void check_promotion_labels_property_headings_and_property_details_are_displayed() throws Throwable {
		List<WebElement> PromotionLabels = pag.getPropertylistmodule().getPropertypromotionlabel();
		for(WebElement PromotionLabel :PromotionLabels) {
			if(PromotionLabel.isDisplayed()&& !PromotionLabel.getText().isEmpty()) {
				Reporter.addStepLog(PromotionLabel.getText()+ " "+" is displayed");
			}
			else {
				throw new NoSuchElementException();
			}
		}
			List<WebElement> PromotionHeadings = pag.getPropertylistmodule().getPropertyHeading();
				for(WebElement PromotionHeading :PromotionHeadings) {
					if(PromotionHeading.getText().equalsIgnoreCase("Sale Property")) {
						Reporter.addStepLog(PromotionHeading.getText()+ " "+" is displayed");
						List<WebElement> Promotiondetails = pag.getPropertylistmodule().getPropertydetails();
						for(WebElement Promotiondetail :Promotiondetails) {
							if(Promotiondetail.getText().equalsIgnoreCase("£10 to £10")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
							}
							else if(Promotiondetail.getText().equalsIgnoreCase("3 bedrooms")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
							}
							else if (Promotiondetail.getText().equalsIgnoreCase("Liverpool")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
								break;
							}
						}
						
					}
					else if(PromotionHeading.getText().equalsIgnoreCase("Shared ownership property")) {
						Reporter.addStepLog(PromotionHeading.getText()+ " "+" is displayed");
						List<WebElement> Promotiondetails = pag.getPropertylistmodule().getPropertydetails();
						for(WebElement Promotiondetail :Promotiondetails) {
							if(Promotiondetail.getText().equalsIgnoreCase("£400,000")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
							}
							else if(Promotiondetail.getText().equalsIgnoreCase("2 bedrooms")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
							}
							else if (Promotiondetail.getText().equalsIgnoreCase("Chester")) {
								Reporter.addStepLog(Promotiondetail.getText()+ " "+" is displayed");
								break;
							}
						}
					}
					
				}
				
			
		
		
		
	}

	@Then("^Click view button to navigate to property page$")
	public void click_view_button_to_navigate_to_property_page() throws Throwable {
		
		List<WebElement> Links = pag.getPropertylistmodule().getPropertylinks();
		for(WebElement Link:Links) {
			ClickElement(Link);
			Reporter.addStepLog("Property CTA is clicked");
			String Pagetitle =driver.getTitle();
			System.out.println(Pagetitle);
			if(Pagetitle.equalsIgnoreCase("Shared ownership property | Core Code")) {
				Reporter.addStepLog(Pagetitle+ " "+" is opened");
				
			}
			else {
				Assert.assertEquals(Pagetitle, "Sale Property | Core Code");
				Reporter.addStepLog(Pagetitle+ " "+" is opened");
				driver.navigate().back();
				
				}
			}
			
		}
	}




