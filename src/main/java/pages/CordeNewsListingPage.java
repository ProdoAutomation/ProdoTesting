package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeNewsListingPage {
	
	
	//Category 
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric']/span"))
	private List<WebElement> Filters;	
	
	
	//Category list
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric-scroll']//li"))
	private List<WebElement> CategoryOptions;
	
	//Tag 
	@FindBy(how=How.XPATH,using="//*[@id='Tag']")
	private WebElement Tag;	
	
	
	//Tag list
	@FindBys(@FindBy(how=How.XPATH,using="//*[@id='Tag']/option"))
	private List<WebElement> TagOptions;
	
	
	//Selected options
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric']/span"))
	private List<WebElement> Selectedoption;
	
	
	//Search button 
	@FindBy(how=How.XPATH,using="//*[@type='submit']")
	private WebElement Searchbutton;
	
	
	//News grids
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__article']"))
	private List<WebElement> NewsGrids;	
	
	
	//News grids
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__inner']//div[@class='m-news__tags']/a"))
	private List<WebElement> NewsTags;		
	
	
	//News Summary
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__content']//h1"))
	private List<WebElement> NewSummary;	
	
	
	//News CTA
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__inner']/a"))
	private List<WebElement> NewCTA;
	
	
	//News Date
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__inner']//div[@class='m-news__tags']/span"))
	private List<WebElement> NewsDate;
	
	
	//News Images
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__picture']//img"))
	private List<WebElement> NewsImages;
	
	
	//Pagination
	@FindBy(how=How.XPATH,using="//*[@class='m-pagination']//ol")
	private WebElement Pagination;
	
	
	//Featured Article
	@FindBy(how=How.XPATH,using="//*[@class='m-news__featured']")
	private WebElement FeaturedArticle;	
	
	//Featured Tag
	@FindBy(how=How.XPATH,using="//*[@class='m-news__inner m-news__inner--featured']/div[@class='m-news__tags']/a")
	private WebElement FeatTag;	
	
	//Featured Date
	@FindBy(how=How.XPATH,using="//*[@class='m-news__inner m-news__inner--featured']/div[@class='m-news__tags']/span")
	private WebElement FeatDate;	
	
	//Featured Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-news__heading h4']")
	private WebElement FeatHeading;	
	//Featured CTA
	@FindBy(how=How.XPATH,using="//*[@class='m-news__inner m-news__inner--featured']/a")
	private WebElement FeaturedCTA;	
	
	
	//Featured CTA
	@FindBy(how=How.XPATH,using="//*[@class='m-news__picture m-latest_news__picture--featured']/img")
	private WebElement FeaturedImage;	
	
	
	
	public CordeNewsListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getFilters() {
		return Filters;
	}

	public List<WebElement> getCategoryOptions() {
		return CategoryOptions;
	}

	public WebElement getTag() {
		return Tag;
	}

	public List<WebElement> getTagOptions() {
		return TagOptions;
	}

	public List<WebElement> getSelectedoption() {
		return Selectedoption;
	}

	public WebElement getSearchbutton() {
		return Searchbutton;
	}

	public List<WebElement> getNewsGrids() {
		return NewsGrids;
	}

	public List<WebElement> getNewsTags() {
		return NewsTags;
	}

	public List<WebElement> getNewSummary() {
		return NewSummary;
	}

	public List<WebElement> getNewCTA() {
		return NewCTA;
	}

	public List<WebElement> getNewsDate() {
		return NewsDate;
	}

	public List<WebElement> getNewsImages() {
		return NewsImages;
	}

	public WebElement getPagination() {
		return Pagination;
	}

	public WebElement getFeaturedArticle() {
		return FeaturedArticle;
	}

	public WebElement getFeatTag() {
		return FeatTag;
	}

	public WebElement getFeatDate() {
		return FeatDate;
	}

	public WebElement getFeatHeading() {
		return FeatHeading;
	}

	public WebElement getFeaturedCTA() {
		return FeaturedCTA;
	}

	public WebElement getFeaturedImage() {
		return FeaturedImage;
	}
	
	
	
	

}
