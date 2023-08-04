package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeQuickLinkPage {
	
	//Image 
	@FindBy(how=How.XPATH,using="//*[@class='m-quicklinks__image']")
	private WebElement Quickimage;
	
	//Quick link items
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-quicklinks__links']/li/a"))
	private List<WebElement> Quicklinks;
	
	// Quick links RTE
	
	@FindBy(how=How.XPATH,using="//*[@class='m-rte']")
	private WebElement QuickLinksRTE;
	
	//Quicks Links CTA
	
	@FindBy(how=How.XPATH,using="//*[@class='m-quicklinks__content']/div/a")
	private WebElement QuickLinksCTA;
	
	
	
	public CordeQuickLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getQuickimage() {
		return Quickimage;
	}

	public List<WebElement> getQuicklinks() {
		return Quicklinks;
	}

	public WebElement getQuickLinksRTE() {
		return QuickLinksRTE;
	}
	public WebElement getQuickLinksCTA() {
		return QuickLinksCTA;
	}
	
	
	

}
