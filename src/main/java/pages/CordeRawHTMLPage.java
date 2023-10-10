package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeRawHTMLPage {
	
	
	
	//Raw HTML iFrame
		@FindBy(how=How.XPATH,using="//*[@class='m-raw_html']//iframe")
		private WebElement RawHTML;
	
	public CordeRawHTMLPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRawHTML() {
		return RawHTML;
	}

	
	
}
