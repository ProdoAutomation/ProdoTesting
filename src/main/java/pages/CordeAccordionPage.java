package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeAccordionPage {
	
	//Menulinks
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_navigation__link']"))
	
	private List<WebElement> Menulinks;
	
	
	//Grid links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__heading']"))
	
	private List<WebElement> Gridlinks;
	
	//Viewlink
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__inner']/a"))
	
	private List<WebElement> Viewlink;
	
	//Accordionlinks
	
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-accordion']/div/div/div"))
	
	private List<WebElement> Accordionlinks;
	
	//AccDrop
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-accordion']/div/div/a"))
	
	private List<WebElement> Accordiondrop;
	
	
	//Tab links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-tabs__tabs tabs']/li"))
	
	private List<WebElement> Tablinks;
	
	//Tab title
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-tabs__inner']/ul/li/a"))
	
	private List<WebElement> Tabtitle;

	//Acc image 
	
	@FindBy(how=How.XPATH,using="//*[@class='m-accordion__image']")
	private WebElement AccImage;


	public CordeAccordionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public List<WebElement> getMenulinks() {
		return Menulinks;
	}


	public List<WebElement> getGridlinks() {
		return Gridlinks;
	}


	public List<WebElement> getViewlink() {
		return Viewlink;
	}


	public List<WebElement> getAccordionlinks() {
		return Accordionlinks;
	}


	public List<WebElement> getAccordiondrop() {
		return Accordiondrop;
	}


	public List<WebElement> getTablinks() {
		return Tablinks;
	}


	public List<WebElement> getTabtitle() {
		return Tabtitle;
	}


	public WebElement getAccImage() {
		return AccImage;
	}


	
	
	
	
}
