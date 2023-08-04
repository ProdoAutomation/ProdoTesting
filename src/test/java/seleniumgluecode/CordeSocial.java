package seleniumgluecode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

	


public class CordeSocial extends BaseClass{
		public static WebDriver driver = TestRunner.driver;
		PageObjectManager pag = new PageObjectManager(driver);
		
		@After
		public void afterhooks(Scenario scenario) throws IOException {
			String statussocial= scenario.getStatus();
			if(scenario.isFailed())
			{
				getScreenshot(driver, scenario.getName());
				}
			}
		
		
	@Given("^Launch the Application to test Social module$")
	public void launch_the_Application_to_test_Social_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
		
	}

	@Then("^Click on Menu Nav to go to the Social page$")
	public void click_on_Menu_Nav_to_go_to_the_Social_page() throws Throwable {
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
    	//Logic to click social grid
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("SocialText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    				
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("SocialLink"))) {
	    				   ClickElement(View2);
	    				   Reporter.addStepLog("Stats grid is clicked");
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
	}

	@Then("^Check all the Socialicons are displayed$")
	public void check_all_the_Socialicons_are_displayed() throws Throwable {
		List<WebElement> Socialicons = pag.getCordeSocial().getSocialIcons();
		for(WebElement SocialI :Socialicons ) {
		if (SocialI.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Twitter"))) {
			Reporter.addStepLog("Twitter icon is displayed");	
		}
		else if(SocialI.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Facebook"))) {
			Reporter.addStepLog("Facebook icon is displayed");	
		}
		else if(SocialI.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Instagram"))) {
			Reporter.addStepLog("Instagram icon is displayed");	
		}
		else if(SocialI.getAttribute("class").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Linkedin"))) {
			Reporter.addStepLog("Linkedin icon is displayed");	
		}
		}
		
		List<WebElement> SocialContent = pag.getCordeSocial().getSocialHeadings();
		if(SocialContent.size()>0) {
			Reporter.addStepLog("Social Headings are displayed");
			List<WebElement> Socialsummaries = pag.getCordeSocial().getSocialsumamries();
			if(Socialsummaries.size()>0) {
				Reporter.addStepLog("Social Summaries are displayed");
				
			}
			
		}
		
	}

	@Then("^Check Social CTAs working fine$")
	public void check_Social_CTAs_working_fine() throws Throwable {
		
		List<WebElement> SocialLinks = pag.getCordeSocial().getSocialLinks();
			for(WebElement SocialLink: SocialLinks) {
			
			getScroll(driver);
			//Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			//Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			
			List<WebElement> lin = driver.findElements(By.xpath("//*[@class='m-social__cardlink e-link']"));
			for(WebElement lins:lin ) {
			ClickElement(lins);
				for (String windowHandle : driver.getWindowHandles()) {
				System.out.println(windowHandle);
			    if(!originalWindow.contentEquals(windowHandle)) {
			        driver.switchTo().window(windowHandle);
			        String Title= driver.getCurrentUrl();
			        System.out.println(Title);
			        Thread.sleep(500);
			        driver.close();
			        if(Title.equalsIgnoreCase((FileReaderManager.getInstance().getCRInstance().getData("TwitterTitle")))){
						Reporter.addStepLog("Twitter page is displayed");	
					}else if(Title.equalsIgnoreCase((FileReaderManager.getInstance().getCRInstance().getData("FacebookTitle")))) {
						Reporter.addStepLog("Facebook page is displayed");	
					}
					else if(Title.equalsIgnoreCase((FileReaderManager.getInstance().getCRInstance().getData("InstagramTitle")))) {
						Reporter.addStepLog("Instagram page is displayed");	
					}
					else if(Title.equalsIgnoreCase((FileReaderManager.getInstance().getCRInstance().getData("LinkedInTitle")))) {
						Reporter.addStepLog("LinkedIn page is displayed");	
					}

			        driver.switchTo().window(originalWindow);
			        
			    }
			}
		}
		break;
			
			
		}
	}

}
