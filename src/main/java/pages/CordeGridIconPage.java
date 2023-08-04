package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeGridIconPage {
	
	//Accessibility icon
	@FindBy(how=How.XPATH,using="//*[@class='m-accessibility_trigger__toggle']")
	private WebElement AccessBTN;
	
	//Primary Grids
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='row m-icon_grid__list']/li"))
	
	private List<WebElement> PrimaryGrids;
	
	//Secondary Grids
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='row m-icon_grid__list m-icon_grid__list--secondary']/li"))
		
	private List<WebElement> SecondaryGrids;
	
	
	//Grid has link
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='row m-icon_grid__list']/li/a"))
	private List<WebElement> Gridhaslink;
	
	//Sec Image Grid
	@FindBy(how=How.XPATH,using="//*[@class='m-icon_grid__media m-icon_grid__media--secondary']/img")
	private WebElement ImageGrid;
	
	// Primary Image Grid
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-icon_grid__media']/img"))
	private List<WebElement> ImgPrimaryGrid;
	
	// Primary Icon Grid
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-icon_grid__media']/i"))
	private List<WebElement> IconPrimaryGrid;
	
	// Sec Icon Grid
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-icon_grid__media m-icon_grid__media--secondary']/i"))
	private List<WebElement> IconGrid;
	
	public CordeGridIconPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public List<WebElement> getPrimaryGrids() {
		return PrimaryGrids;
	}


	public List<WebElement> getSecondaryGrids() {
		return SecondaryGrids;
	}


	public List<WebElement> getGridhaslink() {
		return Gridhaslink;
	}


	public WebElement getAccessBTN() {
		return AccessBTN;
	}


	public WebElement getImageGrid() {
		return ImageGrid;
	}


	public List<WebElement> getIconGrid() {
		return IconGrid;
	}


	public List<WebElement> getImgPrimaryGrid() {
		return ImgPrimaryGrid;
	}


	public List<WebElement> getIconPrimaryGrid() {
		return IconPrimaryGrid;
	}

	

}
