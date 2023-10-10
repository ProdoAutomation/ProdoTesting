package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeLatestNewsPage {
	
	
	//News page articles
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news']/div/div//h1"))
	private List<WebElement> NewsArticles;
	
	
	//Latest News articles
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news']/div//article//h3"))
	private List<WebElement> LatestArticles;
	
	
	//Latest News articles
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news__tags']/span[@class='m-news__tag']"))
	private List<WebElement> ArticlesTags;
	
	//Featured Article
	@FindBy(how=How.XPATH,using="//*[@class='m-news__featured']")
	private WebElement FeaturedArticle;
	
	
	//Article Buttons
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news']/div//article//a[@class='e-btn']"))
	private List<WebElement> ArticlesButtons;
		
		
	//Article Image
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-news']//img"))
	private List<WebElement> ArticlesImage;
	
	//News Page BTN
	@FindBy(how=How.XPATH,using="//*[@class='m-news']//a[@title='News']")
	private WebElement NewsPageBTN;
	
	//Featured BTN
	@FindBy(how=How.XPATH,using="//*[@class='m-news__inner m-news__inner--featured']//a")
	private WebElement FeaturedBTN;
	
	

	//Article date
	@FindBy(how=How.XPATH,using="//*[@class='m-banner__summary']")
	private WebElement Newsdate;
	
	//Article Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-banner']//h1")
	private WebElement ArticleHeading;
	
	//Feature Heading
	
	@FindBy(how=How.XPATH,using="//*[@class='m-news__heading m-news__heading--featured']")
	private WebElement FeaturedHeading;
	
	
	
	

	public CordeLatestNewsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public List<WebElement> getNewsArticles() {
		return NewsArticles;
	}

	public List<WebElement> getLatestArticles() {
		return LatestArticles;
	}

	public List<WebElement> getArticlesTags() {
		return ArticlesTags;
	}

	public WebElement getFeaturedArticle() {
		return FeaturedArticle;
	}

	public List<WebElement> getArticlesButtons() {
		return ArticlesButtons;
	}

	public List<WebElement> getArticlesImage() {
		return ArticlesImage;
	}

	public WebElement getNewsPageBTN() {
		return NewsPageBTN;
	}

	public WebElement getFeaturedBTN() {
		return FeaturedBTN;
	}

	public WebElement getNewsdate() {
		return Newsdate;
	}
	

	public WebElement getArticleHeading() {
		return ArticleHeading;
	}

	public WebElement getFeaturedHeading() {
		return FeaturedHeading;
	}
	
	
	
	
	
}
