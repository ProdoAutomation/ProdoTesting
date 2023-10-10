package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordePropertySearchFilters {
	
	
	//Dropdowns
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric']/span"))
	private List<WebElement> Dropdowns;
	
	//Dropdowns
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='selectric-scroll']/ul/li"))
	private List<WebElement> DropdownLists;	
	
	
	//Property Summary
	@FindBy(how=How.XPATH,using="//*[@class='e-btn m-findahome__btn']")
	private WebElement SearchButton;
	
	
	//View map button
	@FindBy(how=How.XPATH,using="m-property_search__mapbtn e-btn e-btn--white")
	private WebElement MapButton;	
	
	
	public CordePropertySearchFilters(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getDropdowns() {
		return Dropdowns;
	}

	public List<WebElement> getDropdownLists() {
		return DropdownLists;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getMapButton() {
		return MapButton;
	}
	
	
	
	
	
	
	
	
	

}
