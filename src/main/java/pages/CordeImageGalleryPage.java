package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeImageGalleryPage {
	
	//Images
		@FindBy(how=How.XPATH,using="//*[@class='js-rotator__item slick-slide slick-current slick-active']//img")
		private WebElement Images;
		
	//Next arrow	
		@FindBy(how=How.XPATH,using="//*[@class='m-arrows__btn m-arrows__btn--next slick-arrow']")
		private WebElement Nextarrow;
		
	//Current slide
		
		@FindBy(how=How.XPATH,using="//*[@class='m-counter__current']")
		private WebElement Currentslide;
		
	//Counter
		@FindBy(how=How.XPATH,using="//*[@class='m-counter__count']")
		private WebElement Counter;
		
	//Summary
	@FindBy(how=How.XPATH,using="//*[@class='js-rotator__item slick-slide slick-current slick-active']//p")
	private WebElement Summary;
		

	public CordeImageGalleryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public WebElement getImages() {
		return Images;
	}




	public WebElement getNextarrow() {
		return Nextarrow;
	}




	public WebElement getCurrentslide() {
		return Currentslide;
	}




	public WebElement getCounter() {
		return Counter;
	}




	public WebElement getSummary() {
		return Summary;
	}
	
	
	
	
}
