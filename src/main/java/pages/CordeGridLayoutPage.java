package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeGridLayoutPage {
	
	
	//Pagination
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-pagination__list']/li"))
	private List<WebElement> Paginations;
	
	//Next CTA
	@FindBy(how=How.XPATH,using="//*[@title='Next page']")
	private WebElement Next;
	
	
	
	//Previous CTA
	@FindBy(how=How.XPATH,using="//*[@title='Previous page']")
	private WebElement Previous;
	
	
	//Grid Links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__card']//a[@class='e-btn e-btn--full']"))
	private List<WebElement> GridLinks;
	
	//Grids Headings
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__card']//h3"))
	private List<WebElement> GridHeadings;
	
	//Grid Images
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__picture']/img"))
	private List<WebElement> GridImages;
	
	//Grid Summary
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-grid__inner']//p"))
	private List<WebElement> GridSummary;
	
		
	
	public CordeGridLayoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public List<WebElement> getPaginations() {
		return Paginations;
	}


	public WebElement getNext() {
		return Next;
	}


	public WebElement getPrevious() {
		return Previous;
	}


	public List<WebElement> getGridLinks() {
		return GridLinks;
	}


	public List<WebElement> getGridHeadings() {
		return GridHeadings;
	}


	public List<WebElement> getGridImages() {
		return GridImages;
	}


	public List<WebElement> getGridSummary() {
		return GridSummary;
	}
	
	

}
