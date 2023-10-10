package seleniumgluecode;

import java.io.IOException;
import java.util.List;



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

public class CordeHeaderFooter extends BaseClass {
	
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
	
		@Then("^Check the header logo is displayed and clickable$")
		public void check_the_header_logo_is_displayed_and_clickable() throws Throwable {
			WebElement Headerlogo = pag.getHeadFooter().getHeaderlogo();
			if(Headerlogo.isDisplayed()) {
				String Homepage = driver.getTitle();
				ClickElement(Headerlogo);
				String Homepagelink = driver.getTitle();
				Assert.assertEquals(Homepage, Homepagelink);
				
			}
		}
		
		@Then("^Click the child items of the menu$")
		public void click_the_child_items_of_the_menu() throws Throwable {
			
			//Logic to click menu items
	    	List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
	    	for(WebElement elem:Menutext) {
	    		System.out.println(elem.getAttribute("href"));
		    		if(elem.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Menulink"))) {
		    			MoveToElement(elem);
		    			List<WebElement> childitems = pag.getHeadFooter().getSubmenulinks();
		    			for(WebElement childitem:childitems) {
		    				System.out.println(childitem.getAttribute("title"));
		    				if(childitem.getAttribute("title").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Submenu"))){
		    					MoveToElement(childitem);
		    					List<WebElement> childmenuitems = pag.getHeadFooter().getChildmenulinks();
		    							for(WebElement childmenuitem:childmenuitems) {
		    						if(childmenuitem.getAttribute("title").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ChildItem"))) {
		    							ClickElement(childmenuitem);
		    							String Pagetitle = driver.getTitle();
		    						Assert.assertEquals(Pagetitle, "Rich Text | Core Code");
		    						break;
		    						}
		    					}
		    					break;
		    				}
		    			}
		    			break;
		    			}
		    		}
	    			
			
			
		}
		
		@Then("^Check the footer logo is displayed and clickable$")
		public void check_the_footer_logo_is_displayed_and_clickable() throws Throwable {
			((JavascriptExecutor) driver).executeScript(
		            "arguments[0].scrollIntoView();", pag.getHeadFooter().getFooterlogo());
			WebElement Footerlogo = pag.getHeadFooter().getFooterlogo();
			if(Footerlogo.isDisplayed()) {
			
				ClickElement(Footerlogo);
				String FooterHomelink = driver.getTitle();
				System.out.println(FooterHomelink);
				Assert.assertEquals("Corde Housing | Core Code", FooterHomelink);
				
			}
		}
		
		@Then("^Check all footer links are working$")
		public void check_all_footer_links_are_working() throws Throwable {
			List<WebElement> FooterLinks = pag.getHeadFooter().getFooterlinks();
			for(WebElement FooterLink:FooterLinks ) {
				ClickElement(FooterLink);
				driver.navigate().back();
				
			}
			
		}
		
		@Then("^Check footer social are working$")
		public void check_footer_social_are_working() throws Throwable {
			List<WebElement> SocialLinks = pag.getHeadFooter().getSocialIcons();
			for(WebElement SocialLink:SocialLinks ) {
				ClickElement(SocialLink);
				driver.navigate().back();
				
			}
		}
		
		@Then("^Check the footer has corprate message with link$")
		public void check_the_footer_has_corprate_message_with_link() throws Throwable {
			WebElement Corporatetext = pag.getHeadFooter().getCorporateText();
			if(Corporatetext.isDisplayed()) {
				String originalWindow = driver.getWindowHandle();
				//Check we don't have other windows open already
				assert driver.getWindowHandles().size() == 1;
				ClickElement(pag.getHeadFooter().getCorporateLink());
				for (String windowHandle : driver.getWindowHandles()) {
					System.out.println(windowHandle);
				    if(!originalWindow.contentEquals(windowHandle)) {
				        driver.switchTo().window(windowHandle);
				        String Title= driver.getCurrentUrl();
				        System.out.println(Title);
				        Thread.sleep(500);
				        driver.close();
				        driver.switchTo().window(originalWindow);
				        System.out.println(driver.getCurrentUrl());
				        }}
				
			}
		}
		
		
		
		}
