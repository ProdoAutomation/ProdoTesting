package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeSocialPage {
	//Social Cards
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-social__card']"))
			private List<WebElement> Socialcards;
			
		
	//Social Icons
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-social__iconwrapper']/i"))
			private List<WebElement> SocialIcons;	
			
			
	//Social Headings
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-social__cardcontent']/h4"))
			private List<WebElement> SocialHeadings;	
			
			
	//Social Headings
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-social__cardcontent']/p"))
			private List<WebElement> Socialsumamries;	
			
			
	//Social Links
			
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-social__cardlink e-link']"))
			private List<WebElement> SocialLinks;
			
			
			
			
		public CordeSocialPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}




		public List<WebElement> getSocialcards() {
			return Socialcards;
		}




		public List<WebElement> getSocialIcons() {
			return SocialIcons;
		}




		public List<WebElement> getSocialHeadings() {
			return SocialHeadings;
		}




		public List<WebElement> getSocialsumamries() {
			return Socialsumamries;
		}




		public List<WebElement> getSocialLinks() {
			return SocialLinks;
		}
		
		
		
}
