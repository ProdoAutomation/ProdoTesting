package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeLogoRotatorPage {
	
	
	//Logo Images
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-logo_rotator']//img"))
	private List<WebElement> LogoImages;
	
	//Logo Link
	@FindBy(how=How.XPATH,using="//*[@class='m-logo_rotator']//a")
	private WebElement LogoLink;
	
	//Logo Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-logo_rotator']//h2")
	private WebElement LogoHeading;
	
	//Logo Paragraph
	@FindBy(how=How.XPATH,using="//*[@class='m-logo_rotator']//p")
	private WebElement LogoParagraph;
	
	
	
	
	
	public CordeLogoRotatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public List<WebElement> getLogoImages() {
		return LogoImages;
	}


	public WebElement getLogoLink() {
		return LogoLink;
	}


	public WebElement getLogoHeading() {
		return LogoHeading;
	}


	public WebElement getLogoParagraph() {
		return LogoParagraph;
	}
	
	

}
