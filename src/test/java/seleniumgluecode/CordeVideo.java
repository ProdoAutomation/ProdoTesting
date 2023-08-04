package seleniumgluecode;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

public class CordeVideo extends BaseClass{
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
		
	@Given("^Launch the Application to test video module$")
	public void launch_the_Application_to_test_video_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the video page$")
	public void click_on_Menu_Nav_to_go_to_the_video_page() throws Throwable {
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
    	//Logic to click Video 
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	if(Secondtext.size()>0) {
    	for(WebElement Second:Secondtext) {
    		System.out.println(Second.getText());
    	
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("VideoText"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			String text = "Fail";
	    			if(Viewtext2.size()>0) {
	    			for(WebElement View2:Viewtext2) {
	    				System.out.println(View2.getAttribute("href"));
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Videolink"))) {
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
	

	@Then("^Click  Video play button and check if its playing$")
	public void click_Video_play_button_and_check_if_its_playing() throws Throwable {
		getScroll700(driver);
		ClickElement(pag.getCordevideo().getVideoNonLight());
		ClickElement(pag.getCordevideo().getVideoNonLight());
		WebElement video = pag.getCordevideo().getVideoH2();
		System.out.println(video.getText());
		if(video.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("VideoH2"))) {
		List<WebElement> videoP2 = pag.getCordevideo().getVideoP2();
		if(videoP2.size()>0) {
			Reporter.addStepLog("Embeded video has paragrap and Heading");
			
		}
		else {
			Reporter.addStepLog("Embeded video paragrph section is missing");
			throw new NoSuchElementException(); 
		}
			
		}else {
			Reporter.addStepLog("Embeded video Heading  text differs");
			throw new NoSuchElementException(); 
		}
		
		
	}

	@Then("^close the video$")
	public void close_the_video() throws Throwable {
		
		List<WebElement> modals = driver.findElements(By.xpath("//*[@class='m-video m-video--lightbox']//a[@class='m-video__btn']"));
		for(WebElement Modal:modals) {
			ClickElement(Modal);
			 int size = driver.findElements(By.tagName("iframe")).size();
			 System.out.println(size);
			
			
		String sys = driver.findElement(By.xpath("//*[@class='m-modal__embed']/iframe")).getAttribute("title");
		driver.findElement(By.xpath("//*[@class='m-modal__embed']/iframe")).click();
		
		driver.findElement(By.xpath("//*[@class='m-modal__embed']/iframe")).click();
		System.out.println(sys);
//			Robot robot = new Robot();
//			System.out.println("About to zoom in");
//			for (int i = 0; i < 3; i++) {			
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				robot.keyPress(KeyEvent.VK_ADD);
//				robot.keyRelease(KeyEvent.VK_ADD);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//			}
		//driver.findElement(By.xpath("//*[@class='m-modal__embed']/iframe")).click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			//driver.findElement(By.xpath("//*[@class='m-modal__close js-close_modal']")).click();
			
		}
	}

}
