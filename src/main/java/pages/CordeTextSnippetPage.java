package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeTextSnippetPage {
	
	
	//Text snippet heading
	@FindBy(how=How.XPATH,using="//*[@class='m-text_snippet']/div/div/p/a")
	private WebElement TextSnippetHeading;
	
	//Text Content
	
	@FindBy(how=How.XPATH,using="//*[@class='m-text_snippet__content']")
	private WebElement TextSnippetContent;
	
	//CTA 
	
	@FindBy(how=How.XPATH,using="//*[@class='e-btn']")
	private WebElement TextSnippetCTA;
	
	
	
	public CordeTextSnippetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getTextSnippetHeading() {
		return TextSnippetHeading;
	}

	public WebElement getTextSnippetContent() {
		return TextSnippetContent;
	}

	public WebElement getTextSnippetCTA() {
		return TextSnippetCTA;
	}

	
}
