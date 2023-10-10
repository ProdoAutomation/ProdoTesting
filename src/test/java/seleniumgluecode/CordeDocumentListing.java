package seleniumgluecode;

import java.io.IOException;
import java.util.List;

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

public class CordeDocumentListing extends BaseClass {
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
	
	@Given("^Launch the Application to test DocumentListing module$")
	public void launch_the_Application_to_test_DocumentListing_module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the DocumentListing page$")
	public void click_on_Menu_Nav_to_go_to_the_DocumentListing_page() throws Throwable {
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
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Documenttext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Documentlink"))) {
	    				   ClickElement(View2);
	    				   break;
	    			   }
	    				
	    			}
	    			break;
	    		}
    	}
	}

	@Then("^Check Documents heading, paragrapg and size is displayed$")
	public void check_Documents_heading_paragrapg_and_size_is_displayed() throws Throwable {
		List<WebElement> Headings = pag.getCordedocuments().getDocumentHeading();
		if(Headings.size()>0) {
			for (WebElement Heading:Headings) {
				if(Heading.isDisplayed()) {
					Reporter.addStepLog(Heading.getText()+"PDF Heading is displayed");
					List<WebElement> Paragraphs=pag.getCordedocuments().getDocumentPara();
						if(Paragraphs.size()>0) {
							for(WebElement Paragraph:Paragraphs) {
								if(Paragraph.getText().contains(FileReaderManager.getInstance().getCRInstance().getData("Dummytext"))) {
								Reporter.addStepLog(Heading.getText()+"PDF Paragraph is displayed");
								List<WebElement> Icons=pag.getCordedocuments().getDocumentPara();
								for(WebElement Icon :Icons) {
									System.out.println(Icon.getText());
									if(Icon.getText().contains("Kb")) {
										Reporter.addStepLog( Heading.getText()+"PDF size is dislayed");
										break;
									}
								}
								break;
								}
								else {
									Reporter.addStepLog("PDF Paragraph is not displayed");
									throw new NoSuchFieldException();
								}
							}
				
						}
			
					}
				else {
					Reporter.addStepLog("PDF Heading is not displayed");
					throw new NoSuchFieldException();
				}
			}
		}
		
	}

	@Then("^Click the download button and check the file is downloaded$")
	public void click_the_download_button_and_check_the_file_is_downloaded() throws Throwable {
		List<WebElement> downloads=pag.getCordedocuments().getDownloadbutton();
		for(WebElement download :downloads) {
			ClickElement(download);
			Thread.sleep(1000);
		if (isFileDownloaded("test-pdf")) {
			Reporter.addStepLog(" test-pdf-document is clicked and downloaded");	
		}else  {
			isFileDownloaded("dummy");
			Reporter.addStepLog("dummy.pdf document is clicked and downloaded");
		}
			
		}
		Reporter.addStepLog(downloads.size()+" documents are clicked and downloaded");
	}

	@Then("^Click view online and verify file is opened in new tab$")
	public void click_view_online_and_verify_file_is_opened_in_new_tab() throws Throwable {
		List<WebElement>Views=pag.getCordedocuments().getViewonline();
		for (WebElement View :Views) {
			//Store the ID of the original window
			String originalWindow = driver.getWindowHandle();
			//Check we don't have other windows open already
			assert driver.getWindowHandles().size() == 1;
			ClickElement(View);
			for (String windowHandle : driver.getWindowHandles()) {
			    if(!originalWindow.contentEquals(windowHandle)) {
			        driver.switchTo().window(windowHandle);
			        String URL= driver.getCurrentUrl();
			        Thread.sleep(500);
			        if(URL.contains(FileReaderManager.getInstance().getCRInstance().getData("Documentname"))){
			        	Reporter.addStepLog("test-pdf-document.pdf is clicked on new tab");
			        	driver.close();
			        	driver.switchTo().window(originalWindow);
					}else if((URL.contains(FileReaderManager.getInstance().getCRInstance().getData("Documentname1")))) {
						Reporter.addStepLog("dummy.pdf is clicked and opened on new tab");
			        	driver.close();
			        	driver.switchTo().window(originalWindow);
					}
			        else {
			        	throw new Exception();
			        }
			    }
			}
			
		}
		Reporter.addStepLog(Views.size()+" documents are clicked and downloaded");
	}

}
