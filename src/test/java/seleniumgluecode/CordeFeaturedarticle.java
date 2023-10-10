package seleniumgluecode;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import baseClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class CordeFeaturedarticle extends BaseClass{
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
	
	@Then("^Click the news item from the menu$")
	public void click_the_news_item_from_the_menu() throws Throwable {
		List<WebElement> Menutext = pag.getCordeAcc().getMenulinks();
    	for(WebElement elem:Menutext) {
	    		if(elem.getAttribute("title").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("ChildAboutUs"))) {
	    			MoveToElement(elem);
	    			List<WebElement> childitems = pag.getHeadFooter().getSubmenulinks();
	    			for(WebElement childitem:childitems) {
	    				
	    				if(childitem.getAttribute("title").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Aboutsubmenu"))){
	    					ClickElement(childitem);
	    					Reporter.addStepLog("News link is clicked from menu");
	    					break;
	    					}
	    				}
	    				break;
	    			}
	    		}
	}

	@Then("^Check the News page is displayed$")
	public void check_the_News_page_is_displayed() throws Throwable {
		String Pagetitle = driver.getTitle();
		Assert.assertEquals(Pagetitle, FileReaderManager.getInstance().getCRInstance().getData("NewsText"));
		Reporter.addStepLog("News listing page is displayed");
	}

	@Then("^Check Featured article is displayed$")
	public void check_Featured_article_is_displayed() throws Throwable {
		getScroll(driver);
		if(pag.getNewsListing().getFeaturedArticle().isDisplayed()) {
			
			Reporter.addStepLog(pag.getNewsListing().getFeaturedArticle().getText()+" "+"article is displayed");
			
		}
	}

	@Then("^Check Featured article tag,date and CTA are displayed$")
	public void check_Featured_article_tag_date_and_CTA_are_displayed() throws Throwable {
		if(pag.getNewsListing().getFeatTag().isDisplayed()) {
			if(pag.getNewsListing().getFeatDate().isDisplayed()) {
				if(pag.getNewsListing().getFeatHeading().isDisplayed()) {
					if(pag.getNewsListing().getFeaturedCTA().isDisplayed()) {
						String CuurentURL = driver.getCurrentUrl();
						pag.getNewsListing().getFeaturedCTA().click();
						String ArticleURL =driver.getCurrentUrl();
						if(!CuurentURL.equalsIgnoreCase(ArticleURL)) {
							driver.navigate().back();
							String defaultURL = driver.getCurrentUrl();
							Assert.assertEquals(CuurentURL, defaultURL);
							ImageCheck(pag.getNewsListing().getFeaturedImage());
							pag.getNewsListing().getFeaturedImage().click();
							driver.navigate().back();
							Assert.assertEquals(CuurentURL, defaultURL);
							Reporter.addStepLog(pag.getNewsListing().getFeatTag().getText()+"tag is displayed");
							Reporter.addStepLog(pag.getNewsListing().getFeatDate().getText()+"date is displayed");
							Reporter.addStepLog(pag.getNewsListing().getFeatHeading().getText()+"heading is displayed");
							Reporter.addStepLog(pag.getNewsListing().getFeaturedCTA().getText()+"CTA is displayed");
							Reporter.addStepLog(pag.getNewsListing().getFeaturedImage().getTagName()+" is displayed and clickable");
						}
					}
				}
			}
		}
	}



}
