package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeListingsPage {
	
	
	
	
		//ALternate Listing 
	
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-listings m-listings--alternate']//li"))
		private List<WebElement> AlterListings;
		
		//ALternate Pagination

		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-listings m-listings--alternate']/following::div//nav[1]/ol[1]/li/a"))
		private List<WebElement> AlterPagination;	
		
		
		@FindBy(how=How.XPATH,using="//*[@class='e-btn m-pagination__btn m-pagination__btn--next e-btn--disabled']")
		private WebElement Alternext;
		
		//Footerlogo
		@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__logo_image']")
		private WebElement Footerlogo;
		
		
		//Listing
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-listings ']//li"))
		private List<WebElement> Listings;
		
		//Previous page
		
		@FindBy(how=How.XPATH,using="//*[@class='m-listings ']/preceding::nav/a[@title='Previous page']")
		private WebElement Previouspage;
		
		//Next page
		
		@FindBy(how=How.XPATH,using="//*[@class='m-listings ']/preceding::nav/a[@title='Next page']")
		private WebElement Nextpage;
		
		//Listing Image
		@FindBy(how=How.XPATH,using="//*[@class='m-listings__image']")
		private WebElement Listingimage;
		
		//Listing summary
		@FindBy(how=How.XPATH,using="//*[@class='m-listings ']//preceding::div[@class='m-listings m-listings--alternate']//li/div/div/h3")
		private WebElement Listingsummary;		
				
		
		public CordeListingsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}


		public List<WebElement> getAlterListings() {
			return AlterListings;
		}


		public List<WebElement> getAlterPagination() {
			return AlterPagination;
		}


		public WebElement getAlternext() {
			return Alternext;
		}


		public WebElement getFooterlogo() {
			return Footerlogo;
		}


		public List<WebElement> getListings() {
			return Listings;
		}


		public WebElement getListingimage() {
			return Listingimage;
		}


		public WebElement getListingsummary() {
			return Listingsummary;
		}


		public WebElement getPreviouspage() {
			return Previouspage;
		}


		public WebElement getNextpage() {
			return Nextpage;
		}
		
		

		
		
}
