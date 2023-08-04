package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeStatPage {
	// button
			@FindBy(how=How.XPATH,using="//*[@class='e-btn']")
			private WebElement StatBT;
	
	// Title
			@FindBy(how=How.XPATH,using="//*[@class='m-statistics__introtitle']")
			private WebElement Stattiltle;
			
	//Number
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-statistics__cardstat js-count h2 animated']"))
			private List<WebElement> Stat;
			
	//Heading
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-statistics__cardtitle h6']"))
			private List<WebElement> StatHeading;	
	//Summary
			@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-statistics__cardsummary']"))
			private List<WebElement> StatSummary;	
	
			
		public CordeStatPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}


		public WebElement getStatBT() {
			return StatBT;
		}


		public WebElement getStattiltle() {
			return Stattiltle;
		}


		public List<WebElement> getStat() {
			return Stat;
		}


		public List<WebElement> getStatHeading() {
			return StatHeading;
		}


		public List<WebElement> getStatSummary() {
			return StatSummary;
		}
		
		

}
