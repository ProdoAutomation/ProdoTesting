package seleniumgluecode;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

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

public class CordeMLatestNews extends BaseClass {
public static 	WebDriver driver= TestRunner.driver;
PageObjectManager pag = new PageObjectManager(driver);

Assertion softAssert = new SoftAssert();

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

	@Given("^Launch the Application to test Latest News Module$")
	public void launch_the_Application_to_test_Latest_News_Module() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

	@Then("^Click on Menu Nav to go to the Latest News Module Page$")
	public void click_on_Menu_Nav_to_go_to_the_Latest_News_Module_Page() throws Throwable {
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
    	getScroll700(driver);
    	List<WebElement> Secondtext = pag.getCordeAcc().getGridlinks();
    	for(WebElement Second:Secondtext) {
    		//System.out.println(Second.getText());
    		String Acc = "Fail";
	    		if(Second.getText().equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Latesttext"))) {
	    			List<WebElement> Viewtext2 = pag.getCordeAcc().getViewlink();
	    			
	    			for(WebElement View2:Viewtext2) {
	    			   if(View2.getAttribute("href").equalsIgnoreCase(FileReaderManager.getInstance().getCRInstance().getData("Latestlink"))) {
	    				
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

	@Then("^Check the featured article is displayed$")
	public void check_the_featured_article_is_displayed() throws Throwable {
		WebElement Featured = pag.getLatestNews().getFeaturedArticle();
		if(Featured.isDisplayed()) {
			Reporter.addStepLog("Featured article is displayed");
		}
	}

	@Then("^Check First four articles pulled from news section$")
	public void check_First_four_articles_pulled_from_news_section() throws Throwable {
		ClickElement(pag.getLatestNews().getNewsPageBTN());
		//driver.navigate().back();
		List<WebElement> News = pag.getLatestNews().getNewsArticles();
		String Article1 = News.get(0).getText();
		String Article2 =News.get(1).getText();
		String Article3 =News.get(2).getText();
		String Article4 =News.get(3).getText();
		String Ar1 = Article1;
		String Ar2 = Article2;
		String Ar3 = Article3;
		String Ar4 = Article4;
		driver.navigate().back();
		List<WebElement> LatestNews = pag.getLatestNews().getLatestArticles();
		for(WebElement LatestNew:LatestNews) {
				if(Ar1.equalsIgnoreCase(LatestNew.getText()) ||Ar2.equalsIgnoreCase(LatestNew.getText())||Ar3.equalsIgnoreCase(LatestNew.getText())||Ar4.equalsIgnoreCase(LatestNew.getText()))   {
					Reporter.addStepLog(LatestNew.getText()+ "  "+" article is displayed");
					System.out.println(LatestNew.getText());
				}
			
				else {
					throw new NoSuchElementException(LatestNew.getText());
					}
			}
	}

	@Then("^Check Tags and date are displayed for the article$")
	public void check_Tags_and_date_are_displayed_for_the_article() throws Throwable {
		List<WebElement>TagsDates = pag.getLatestNews().getArticlesTags();
		for(WebElement TagsDate:TagsDates) {
			System.out.println(TagsDate.getText());
			if(TagsDate.getText().equalsIgnoreCase("01/08/2023")) {
				String Latestdate = TagsDate.getText();
				getScroll(driver);
				ClickElement(pag.getLatestNews().getFeaturedBTN());
				String ArticleDate = pag.getLatestNews().getNewsdate().getText();
				if(Latestdate.equalsIgnoreCase(ArticleDate)) {
					driver.navigate().back();
					Reporter.addStepLog(ArticleDate+" "+ "is displayed featured article");
				}
				else {
					throw new NoSuchElementException();
				}
				
			}
			
		}
		
	}

	@Then("^Check Article buttons are displayed$")
	public void check_Article_buttons_are_displayed() throws Throwable {
		List<WebElement> CTAs = pag.getLatestNews().getArticlesButtons();
		if(CTAs.size()==4) {
			Reporter.addStepLog(CTAs.size()+" "+ " article buttons are displayed ");
		}
		else {
			throw new NoSuchElementException();
		}
	}

	@Then("^Click Article button to check it navigates to new article page$")
	public void click_Article_button_to_check_it_navigates_to_new_article_page() throws Throwable {
		getScroll(driver);
		ClickElement(pag.getLatestNews().getFeaturedBTN());
		String ArticleHeading = pag.getLatestNews().getArticleHeading().getText();
		driver.navigate().back();
		String FeaturedHeading = pag.getLatestNews().getFeaturedHeading().getText();
		if(ArticleHeading.equalsIgnoreCase(FeaturedHeading)) {
			Reporter.addStepLog(("Page navigated to new article page"));
			List<WebElement> Images = pag.getLatestNews().getArticlesImage();
			if(Images.size()==4) {
			Reporter.addStepLog((Images.size()+" "+ " article Images are displayed "));
				}
		else {
			throw new NoSuchElementException();
			}
		}

	}
}