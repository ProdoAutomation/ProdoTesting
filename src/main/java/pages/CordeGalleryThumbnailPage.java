package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeGalleryThumbnailPage {
	
	//Gallery Images
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-thumbnail_gallery js-thumbnail_gallery']//img"))
	private List<WebElement> Images;
	
	
	//Expand buttons
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-thumbnail_gallery__btn']"))
	private List<WebElement> ImagesBTN;
	
	
	//Forward arrow
	@FindBy(how=How.XPATH,using="//*[@class= 'pswp__button pswp__button--arrow--right']")
	private WebElement Forwardarrow;
	
	
	//Forward arrow
	@FindBy(how=How.XPATH,using="//*[@class= 'pswp__button pswp__button--arrow--left']")
	private WebElement Backwardarrow;
	
	//Image container
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='pswp__item']"))
	private List<WebElement> Imageitems;
	
	
	//Caption
	@FindBy(how=How.XPATH,using="//*[@class='pswp__caption']/div")
	private WebElement  Caption;
	
	//Counter
	@FindBy(how=How.XPATH,using="//*[@class='pswp__counter']")
	private WebElement  Counter;
	
	

	public CordeGalleryThumbnailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	

	public List<WebElement> getImages() {
		return Images;
	}


	public List<WebElement> getImagesBTN() {
		return ImagesBTN;
	}


	public WebElement getForwardarrow() {
		return Forwardarrow;
	}


	public WebElement getBackwardarrow() {
		return Backwardarrow;
	}


	public List<WebElement> getImageitems() {
		return Imageitems;
	}


	public WebElement  getCaption() {
		return Caption;
	}


	public WebElement getCounter() {
		return Counter;
	}

	
	
	
}
