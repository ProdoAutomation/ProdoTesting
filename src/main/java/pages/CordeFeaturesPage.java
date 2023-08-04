package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeFeaturesPage {
		//Features Heading
	
		@FindBy(how=How.XPATH,using="//*[@class='m-features']//h2")
		
		private WebElement FeatHeading;

		//Features cards
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-features__card']"))
		
		private List<WebElement> Featcards;
		
		
		//Features Icons
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-features__featuresicon']"))
				
		private List<WebElement> FeatIcons;
		
		//Features Heading
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-features__featuresicon']"))
						
		private List<WebElement> FeatHeadings;
		
		//Features Summaries
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-features__featuresicon']"))
					
		private List<WebElement> FeatSummaries;
		
		//Features Links
		
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='e-link m-features__link']"))
							
		private List<WebElement> FeatLinks;
		
		


		public CordeFeaturesPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}




		public WebElement getFeatHeading() {
			return FeatHeading;
		}




		public List<WebElement> getFeatcards() {
			return Featcards;
		}




		public List<WebElement> getFeatIcons() {
			return FeatIcons;
		}




		public List<WebElement> getFeatHeadings() {
			return FeatHeadings;
		}




		public List<WebElement> getFeatSummaries() {
			return FeatSummaries;
		}




		public List<WebElement> getFeatLinks() {
			return FeatLinks;
		}




		
}
