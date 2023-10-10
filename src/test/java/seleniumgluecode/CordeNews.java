package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class CordeNews extends BaseClass{
	public static 	WebDriver driver= TestRunner.driver;
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
	
	
	
	@Then("^Click the news from the menu$")
	public void click_the_news_from_the_menu() throws Throwable {
		//Logic to click menu items
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

	@Then("^Check the News listing page is displayed$")
	public void check_the_News_listing_page_is_displayed() throws Throwable {
		String Pagetitle = driver.getTitle();
		Assert.assertEquals(Pagetitle, FileReaderManager.getInstance().getCRInstance().getData("NewsText"));
		Reporter.addStepLog("News listing page is displayed");

	}

	@Then("^Select the tag and category and Click search$")
	public void select_the_tag_and_category_and_Click_search() throws Throwable {
		getScroll(driver);
		List<WebElement> Filters = pag.getNewsListing().getFilters();
		Filters.get(0).click();
		List<WebElement>  Categories = pag.getNewsListing().getCategoryOptions();
			for(WebElement Category :Categories) {
				if(Category.getText().equalsIgnoreCase("Category One")) {
					ClickElement(Category);
					Filters.get(1).click();
					}
				else if(Category.getText().equalsIgnoreCase("Taggie")) {
					ClickElement(Category);
					break;
					}
			}		
		List<WebElement> Selectedoptions = pag.getNewsListing().getSelectedoption();
			for(WebElement Selectedoption:Selectedoptions) {
				if(Selectedoption.getText().equalsIgnoreCase("Taggie") ) {
					Reporter.addStepLog(Selectedoption.getText()+"option is selected");
				}
				else if(Selectedoption.getText().equalsIgnoreCase("Category One")) {
					Reporter.addStepLog(Selectedoption.getText()+"option is selected");
				}
				
				else {
					throw new NoSuchElementException();
				}
				
			}
			ClickElement(pag.getNewsListing().getSearchbutton());
	}

	@Then("^Check selected tag article is displayed$")
	public void check_selected_tag_article_is_displayed() throws Throwable {
	List<WebElement> NewsGrids = pag.getNewsListing().getNewsGrids();
	List<WebElement> Selectedoptions = pag.getNewsListing().getSelectedoption();
	for(WebElement NewsGrid:NewsGrids) {
		if(NewsGrid.isDisplayed()) {
			List<WebElement> Tags = pag.getNewsListing().getNewsTags();
			for(WebElement Tag :Tags) {
				for(WebElement Selectedoption:Selectedoptions) {
					try {
					if(Selectedoption.getText().contains("Taggie")) {
					Reporter.addStepLog(Selectedoption.getText() +" "+"tag articles are displayed");
						}
					}
					catch(Exception e) {
						e.getMessage();
						}
					break;
					}
				}
			}
		else {
			throw new NoSuchElementException();
			}
		}
		
	}

	@Then("^Check the article tag,date and CTA are working fine$")
	public void check_the_article_tag_date_and_CTA_are_working_fine() throws Throwable {
	 List<WebElement> Tags = pag.getNewsListing().getNewsTags();
	 List<WebElement> Dates = pag.getNewsListing().getNewsDate();
	 List<WebElement> Summaries = pag.getNewsListing().getNewSummary();
	 List<WebElement> CTAs = pag.getNewsListing().getNewCTA();
	 if(Tags.size()>0) {
		 if(Dates.size()>0) {
			 if(Summaries.size()>0) {
				 if(CTAs.size()>0) {
					 for(WebElement CTA :CTAs) {
						 String URL = driver.getCurrentUrl();
						 ClickElement(CTA);
						 String ArticlePage = driver.getCurrentUrl();
						 Reporter.addStepLog( Tags.size() +" "+"Tags are displayed");
						 Reporter.addStepLog(Dates.size() +" "+"Dates are displayed");
						 Reporter.addStepLog(Summaries.size() +"Headings are displayed");
						 if(! ArticlePage.equalsIgnoreCase(URL)) {
							 driver.navigate().back();
							 String PreviousPage = driver.getCurrentUrl();
							 Assert.assertEquals(URL, PreviousPage);
							Reporter.addStepLog("CTA is working fine");
						 }
						 break;
					 }
				 }
			 }
		 }
	 }
		
	}

	@Then("^Check Images are displayed on each news article$")
	public void check_Images_are_displayed_on_each_news_article() throws Throwable {
		getScroll700(driver);
		List<WebElement> Images = pag.getNewsListing().getNewsImages();
		
		if(Images.size()>0) {
			for(WebElement Image :Images) {
				ImageCheck(Image);
				Reporter.addStepLog(Images.indexOf(Image)+" image is present");
			}
		}
	
		
	}
	
	
	@Then("^Check Pagination is present on page$")
	public void check_Pagination_is_present_on_page() throws Throwable {
		
		if(pag.getNewsListing().getPagination().isEnabled()) {
			Reporter.addStepLog(" Pagination is present");
		}
	}



}
