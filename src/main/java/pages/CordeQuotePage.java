package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeQuotePage {
	//Quote Heading
			@FindBy(how=How.XPATH,using="//*[@class='m-quote__image']")
			private WebElement QuoteImage;
			
	//Quote Heading
			@FindBy(how=How.XPATH,using="//*[@class='m-quote__text']")
			private WebElement Quotetext;
			
	//Quote Author
			
			@FindBy(how=How.XPATH,using="//*[@class='m-quote__source']")
			private WebElement QuoteAuthor;
			
			public CordeQuotePage(WebDriver driver) {
				PageFactory.initElements(driver, this);
				
			}

			public WebElement getQuoteImage() {
				return QuoteImage;
			}

			public WebElement getQuotetext() {
				return Quotetext;
			}

			public WebElement getQuoteAuthor() {
				return QuoteAuthor;
			}
			
			
}
