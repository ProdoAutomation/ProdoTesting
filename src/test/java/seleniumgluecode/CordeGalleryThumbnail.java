package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

public class CordeGalleryThumbnail extends BaseClass{

	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
	}
	
	
	@After
	
	public void afterHooks(Scenario scenario) throws IOException {
		String status =scenario.getStatus();
		if(scenario.isFailed()) {
			getScreenshot(driver, scenario.getName());
		}
	}
	
	
	@Then("^Click on Menu Nav to go to the Gallery Thumbnail page$")
	public void click_on_Menu_Nav_to_go_to_the_Gallery_Thumbnail_page() throws Throwable {
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
    	getScroll(driver);
    	for(WebElement Second:Secondtext) {
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Thumbtext"))) {
	    			Reporter.addStepLog("Image Text Link is found");
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Thumblink"))) {
	    				   Acc = "Success";
	    				   ClickElement(View2);
	    				   String Title = driver.getTitle();
	    				   Assert.assertEquals(Title, FileReaderManager.getInstance().getCRInstance().getData("ThumbnailHeading"));
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

	@Then("^Check Gallery Thumbnail Images and click expand and click arrows to navigate the images$")
	public void check_Gallery_Thumbnail_Images_and_click_expand_and_click_arrows_to_navigate_the_images() throws Throwable {
		List<WebElement> Images = pag.getThumbnail().getImages();
		int Thumnails= Images.size();
		if(Images.size()>0) {
			List<WebElement> ImagesBTN = pag.getThumbnail().getImagesBTN();
			int BTNs = ImagesBTN.size();
			if (Thumnails==BTNs) {
				Reporter.addStepLog(Images.size()+" "+"Images are displayed");
				for(WebElement BTN :ImagesBTN) {
					Thread.sleep(500);
					BTN.click();
					List<WebElement> ImageContainers = pag.getThumbnail().getImageitems();
					int containers=	ImageContainers.size();
					if(Thumnails==containers) {
						for(int i = 1;i<=ImageContainers.size();i++) {
							Thread.sleep(500);
							String counetr=	pag.getThumbnail().getCounter().getText();
							try {
							String Caption = pag.getThumbnail().getCaption().getText();
							Reporter.addStepLog("Caption is  displayed");
							}
							catch(Exception e) {
								Reporter.addStepLog("Caption is not displayed");
							}
						String num = Character.toString(counetr.charAt(0));
						int num1 = Integer.valueOf(num);
								System.out.println(i);
						System.out.println(num1);
						if(i==num1) {
						ClickElement(pag.getThumbnail().getForwardarrow());
						}
						}
						
						
					}
					break;
				}
			}
		}
	}

	@Then("^Click expand on image and check its expanded$")
	public void click_expand_on_image_and_check_its_expanded() throws Throwable {
		List<WebElement> ImageContainers = pag.getThumbnail().getImageitems();
		for(int i = 1;i<=ImageContainers.size();i++) {
			Thread.sleep(500);
			ClickElement(pag.getThumbnail().getBackwardarrow());
			}
		
		}
	
}
