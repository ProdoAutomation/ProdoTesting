package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YHGHomepage {
	        //Banner 
			@FindBy(how=How.XPATH,using="//*[@class='m-banner__headingwrapper']/h1")
			private WebElement Bannertitle;
			

			//Banner CTA  
			@FindBy(how=How.XPATH,using="//*[@class='e-btn e-btn--primary m-banner__btn']")
			private WebElement BannerCTA;
			
			public YHGHomepage(WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}

			public WebElement getBannertitle() {
				return Bannertitle;
			}


			public WebElement getBannerCTA() {
				return BannerCTA;
			}
}
