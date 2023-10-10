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

public class CordeSelfHelp extends BaseClass {
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
	
	
	
	@Given("^Launch the Application to test Selfhelp module$")
	public void launch_the_Application_to_test_Selfhelp_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Selfhelp page$")
	public void click_on_Menu_Nav_to_go_to_the_Selfhelp_page() throws Throwable {
		//Logic to click menu items
    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	for(WebElement elem:Menutext) {
    		System.out.println(elem.getAttribute("href"));
    	
	    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
	    			ClickElement(elem);
	    			break;
	    		}
    	}
    	//Logic to click Functional module grid in the page
    	List<WebElement> Gridtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Grid:Gridtext) {
    		System.out.println(Grid.getText());
    	
	    		if(Grid.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("FunctionalModule"))) {
	    			List<WebElement> Viewtext = pag.getCordeAcc().getViewlink();
	    			for(WebElement View:Viewtext) {
	    			   if(View.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Functionalviewlink"))) {
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
    	//Logic to click Self Help grid
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Selftext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    				
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Selflink"))) {
	    				   ClickElement(View2);
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
	}

	@Then("^Click all three tabs$")
	public void click_all_three_tabs() throws Throwable {
		
		List<WebElement>Tabs = pag.getCordeSelfHelp().getSelfTabs();
		if(Tabs.size()>0) {
		for(WebElement Tab: Tabs) {
			if(Tab.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Tab1"))){
				List<WebElement>Categories = pag.getCordeSelfHelp().getSelftopics();
				if(Categories.size()>0){
					for (WebElement Category:Categories) {
						if(Category.getText().equalsIgnoreCase("Repairs")) {
							ClickElement(Category);
							List<WebElement>Options = pag.getCordeSelfHelp().getSelfoptions();
							for(WebElement Option:Options) {
								if(Option.getText().equalsIgnoreCase("How do I report a repair?")) {
									Thread.sleep(500);
									ClickElement(Option);
									Reporter.addStepLog("Select a topic tab is displayed and opened");
									break;
								}
							}
						}
					}
				}
			}else if(Tab.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Tab2"))) {
				Reporter.addStepLog("Select a Catgeory tab is displayed and opened");
				
			}
			else if(Tab.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Tab3"))) {
				Reporter.addStepLog("Choose an option tab is displayed and opened");
				
			}
		}
	}
		else {
			throw new Exception();
		}
		
}

	@Then("^Click all the topics, catgeory and options$")
	public void click_all_the_topics_catgeory_and_options() throws Throwable {
		List<WebElement>Tabs = pag.getCordeSelfHelp().getSelfTabs();
		if(Tabs.size()>0) {
		for(WebElement Tab: Tabs) {
			if(Tab.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Tab1"))){
				List<WebElement>Categories = pag.getCordeSelfHelp().getSelftopics();
				if(Categories.size()>0){
					for (WebElement Category:Categories) {
						if(Category.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Topic1"))) {
							ClickElement(Category);
							Reporter.addStepLog("Repairs topic  is clicked");
							List<WebElement>Options = pag.getCordeSelfHelp().getSelfoptions();
							for(WebElement Option:Options) {
								if(Option.getText().equalsIgnoreCase(
										FileReaderManager.getInstance().getCRInstance().getData("Category1"))) {
									ClickElement(Option);
									Reporter.addStepLog("How do I report a repair? category  is clicked");
									List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
									for(WebElement Outcomeheading:Outcomeheadings) {
										if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option1"))) {
											Reporter.addStepLog("Report an emergency repair Details are displayed");
											//Store the ID of the original window
											String originalWindow = driver.getWindowHandle();
											//Check we don't have other windows open already
											assert driver.getWindowHandles().size() == 1;
											ClickElement(pag.getCordeSelfHelp().getOutcomebutton());
											for (String windowHandle : driver.getWindowHandles()) {
											    if(!originalWindow.contentEquals(windowHandle)) {
											        driver.switchTo().window(windowHandle);
											        String URL= driver.getCurrentUrl();
											        Thread.sleep(500);
											        if(URL.equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"))){
											        	Reporter.addStepLog("Report an emergency repair link is clicked and closed");
											        	driver.close();
											        	driver.switchTo().window(originalWindow);
													}
											        else {
											        	throw new Exception();
											        }
											    }
											}
											getScroll(driver);
											Thread.sleep(700);
											ClickElement(pag.getCordeSelfHelp().getOutcomevideo());
//											Thread.sleep(200);
//											ClickElement(pag.getCordeSelfHelp().getOutcomevideo());
											Reporter.addStepLog("Report an emergency repair video is clicked and closed");
											 WebElement image1 = pag.getCordeSelfHelp().getOutcomeImage();   
						    				   String img = image1.getAttribute("src");
						    				   try {
						    					   if (img== null) {
						    						   throw new NoSuchElementException();
						    					   }
						    					   else {
						    						   BufferedImage imgs=ImageIO.read(new URL(img));
						    						   Reporter.addStepLog("Report an emergency repair image is dispalyed");
						    					   }
						    				   }
						    				   catch(IOException e){
						    					   e.printStackTrace();
								    	
								    			}
											break;
										}
										else {
											throw new NoSuchElementException();
										}
									}
								}
								else if (Option.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Category2"))) {
									ClickElement(Option);
									Reporter.addStepLog("What is an emergency repair? category  is clicked");
									List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
									for(WebElement Outcomeheading:Outcomeheadings) {
										if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option2"))) {
											Reporter.addStepLog("Emergency repairs Details are displayed");
											break;
										}
									}
								}
								else if (Option.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Category3"))) {
									ClickElement(Option);
									Reporter.addStepLog("I'm a tenant - which repairs am I responsible for? category  is clicked");
									List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
									for(WebElement Outcomeheading:Outcomeheadings) {
										if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option3"))) {
											Reporter.addStepLog("I'm a tenant - which repairs am I responsible for? Details are displayed");
											break;
										}
									}
									break;
								}
								
							}
						}
						else if(Category.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Topic2"))) {
							ClickElement(Category);
							Reporter.addStepLog("Paying your rent topic  is clicked");
							List<WebElement>Options = pag.getCordeSelfHelp().getSelfoptions();
							for(WebElement Option:Options) {
								if(Option.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Category4"))) {
									ClickElement(Option);
									Reporter.addStepLog("How do I pay my rent or service charge? category  is clicked");
									List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
									for(WebElement Outcomeheading:Outcomeheadings) {
										if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option4"))) {
											Reporter.addStepLog("How do I pay my rent or service charge? Details are displayed");
											break;
										}
									}
									break;
								}
							}
						}
							else if(Category.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Topic3"))) {
								ClickElement(Category);
								
								List<WebElement>Options = pag.getCordeSelfHelp().getSelfoptions();
								for(WebElement Option:Options) {
									if(Option.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Category5"))) {
										ClickElement(Option);
										Reporter.addStepLog("Contact us online category  is clicked");
										List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
										for(WebElement Outcomeheading:Outcomeheadings) {
											if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option5"))) {
												Reporter.addStepLog("Contact us online Details are displayed");
												break;
												}
											}
										}
									else if (Option.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Category6"))) {
										ClickElement(Option);
										Reporter.addStepLog("Contact us by phone category  is clicked");
										List<WebElement>Outcomeheadings = pag.getCordeSelfHelp().getOutcomeHeading();
										for(WebElement Outcomeheading:Outcomeheadings) {
											if(Outcomeheading.isDisplayed() && Outcomeheading.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Option6"))) {
												Reporter.addStepLog("Contact us by phone Details are displayed");
												break;
												}
											}
										break;
										}
								}
						
							}
						}
					}
				break;
				}
			}
		}
	}

}
