package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeMapPage {
	
	//Map Image
	@FindBy(how=How.XPATH,using="//*[@role='button']//img")
	private WebElement MapImage;
	
	
	
	//Map content
	@FindBy(how=How.XPATH,using="//*[@class='m-map_content__content m-rte']/p")
	private WebElement Mapcontent;
	
	
	//Close icon
	@FindBy(how=How.XPATH,using="//*[@class='m-map_content']/img")
	private WebElement Closeicon;
	
	
	
	
	//Basic map iframe
	@FindBy(how=How.XPATH,using="//*[@class='m-map']/iframe")
	private WebElement iFrame;	
	
	
	
	
	
	public  CordeMapPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public WebElement getMapImage() {
		return MapImage;
	}



	public WebElement getMapcontent() {
		return Mapcontent;
	}


	public WebElement getCloseicon() {
		return Closeicon;
	}




	public WebElement getiFrame() {
		return iFrame;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
