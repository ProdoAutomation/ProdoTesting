package seleniumgluecode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import javax.imageio.ImageIO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class CordeListings extends BaseClass {
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


	@Then("^Click on Menu Nav to go to the Listing page$")
	public void click_on_Menu_Nav_to_go_to_the_Listing_page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	for(WebElement elem:Menutext) {
    		System.out.println(elem.getAttribute("href"));
    	
	    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
	    			ClickElement(elem);
	    			
	    			Reporter.addStepLog("Main Nav is clicked");
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
	    				   Reporter.addStepLog("Content module grid is clicked");
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
    	//Scrolling the page a bit down
    	getScroll(driver);
    	//Logic to click listing grid
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ListingText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    				
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ListingLink"))) {
	    				   ClickElement(View2);
	    				   Reporter.addStepLog("Listing grid is clicked");
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
	}

	@Then("^Check all the Listings are displayed$")
	public void check_all_the_Listings_are_displayed() throws Throwable {
		getScroll700(driver);
		try {
		List<WebElement> ListPaginations = pag.getCordeListings().getAlterPagination();
		
		for(WebElement ListPagination :ListPaginations) {
			System.out.println(ListPagination.getAttribute("href"));
			CharSequence searchString = "page_1=1";
			CharSequence searchString1 = "page_1=2";
			CharSequence searchString2 = "page_2=1";
			CharSequence searchString3 = "page_2=2";
			if(ListPagination.getAttribute("href").contains(searchString)) {
				if (ListPagination.getAttribute("title").equalsIgnoreCase("Go to page 1")) {
					System.out.println(ListPagination.getAttribute("class"));
					if (ListPagination.getAttribute("class").equalsIgnoreCase("m-pagination__link active")) {
						Reporter.addStepLog("Listing grid is in first page alternative");
						WebElement Listimage = pag.getCordeListings().getListingimage() ;
						WebElement Listsummary = pag.getCordeListings().getListingsummary();
	    				   String img = Listimage.getAttribute("src");
	    				   try {
	    					   if (img== null) {
	    						   throw new NoSuchElementException();
	    					   }
	    					   else {
	    						   BufferedImage imgs=ImageIO.read(new URL(img));
	    						   Reporter.addStepLog("Alternative Listing grid image is displayed");
	    					   }
	    				   }
	    				   catch(IOException e){
	    					   e.printStackTrace();
			    	
			    			}
	    				if(! Listsummary.getText().isEmpty()) {
	    					 Reporter.addStepLog("Alternative Listing grid Heading is displayed");
	    				}else {
	    					throw new NoSuchElementException();
	    					
	    				}
	    				   
					}
					
				}
				
			}
				else if(ListPagination.getAttribute("href").contains(searchString1)) {
					System.out.println(ListPagination.getAttribute("title"));
				if (ListPagination.getAttribute("title").equalsIgnoreCase("Go to page 2")) {
					System.out.println(ListPagination.getAttribute("class"));
					if (ListPagination.getAttribute("class").equalsIgnoreCase("m-pagination__link ")) {
						ClickElement(ListPagination);
						Reporter.addStepLog("Listing grid is in second page alternative");
						WebElement Listimage = pag.getCordeListings().getListingimage() ;
						WebElement Listsummary = pag.getCordeListings().getListingsummary();
	    				   String img = Listimage.getAttribute("src");
	    				   try {
	    					   if (img== null) {
	    						   throw new NoSuchElementException();
	    					   }
	    					   else {
	    						   BufferedImage imgs=ImageIO.read(new URL(img));
	    						   Reporter.addStepLog("Alternative Listing second grid image is displayed");
	    					   }
	    				   }
	    				   catch(IOException e){
	    					   e.printStackTrace();
			    	
			    			}
	    				   if(! Listsummary.getText().isEmpty()) {
		    					 Reporter.addStepLog("Alternative Listing grid Heading is displayed");
		    				}else {
		    					throw new NoSuchElementException();
		    					
		    				}
						driver.navigate().back();
						
					}
					
				}
				
			}
				else if(ListPagination.getAttribute("href").contains(searchString2)) {
					System.out.println(ListPagination.getAttribute("title"));
				if (ListPagination.getAttribute("title").equalsIgnoreCase("Go to page 1")) {
					System.out.println(ListPagination.getAttribute("class"));
					if (ListPagination.getAttribute("class").equalsIgnoreCase("m-pagination__link active")) {
						Reporter.addStepLog("Listing grid is in first page ");
						List<WebElement> Listing = pag.getCordeListings().getListings();
						if(Listing.size()>1) {
							Reporter.addStepLog("Pages are getting listed on page1");
						}
					}
					
				}
				
			}
				else if(ListPagination.getAttribute("href").contains(searchString3)) {
					((JavascriptExecutor) driver).executeScript(
				            "arguments[0].scrollIntoView();", pag.getCordeListings().getFooterlogo());
				if (ListPagination.getAttribute("title").equalsIgnoreCase("Go to page 2")) {
					System.out.println(ListPagination.getAttribute("class"));
					if (ListPagination.getAttribute("class").equalsIgnoreCase("m-pagination__link ")) {
						ClickElement(ListPagination);
						Reporter.addStepLog("Listing grid is in second page");
						List<WebElement> Listing = pag.getCordeListings().getListings();
						if(Listing.size()>1) {
							Reporter.addStepLog("Pages are getting listed on page2");
											}
									}
					
								}
							}
						}
					}
			catch(Exception e) {
			e.printStackTrace();
					}
		
		}

	@Then("^Check Listing pagination working fine$")
	public void check_Listing_pagination_working_fine() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		WebElement Previous = pag.getCordeListings().getPreviouspage();
		boolean check = Previous.getAttribute("class").contains("disabled");
		if(check==true){
		  ClickElement(pag.getCordeListings().getNextpage());
		  Thread.sleep(500);
		  boolean check1 = Previous.getAttribute("class").contains("disabled");
		  System.out.println(check1);
		  Actions actions = new Actions(driver); actions.moveToElement(Previous).click().build().perform();
		 
		  if(check1==false) {
			  ClickElement(Previous);
			  Reporter.addStepLog("Paginations are working fine");
		  				}
				}
		}
}
