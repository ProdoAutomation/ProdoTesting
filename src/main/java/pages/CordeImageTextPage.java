package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeImageTextPage {
	
	
	//Image
	@FindBy(how=How.XPATH,using="//*[@class='m-large_image_text__picture']/img")
	private WebElement Image;
	
	//Subheading
	@FindBy(how=How.XPATH,using="//span[@class='h6']")
	private WebElement Subheading;
	
	//Heading
	@FindBy(how=How.XPATH,using="//h3")
	private WebElement Heading;
	
	//Paragraph
	@FindBy(how=How.XPATH,using="//*[@class='m-image_text']//p")
	private WebElement Paragraph;
	
	
	//Image Link
	@FindBy(how=How.XPATH,using="//*[@class='m-image_text']//a")
	private WebElement ImageLink;
	
	
	
	
	
	
	public CordeImageTextPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getImage() {
		return Image;
	}


	public WebElement getSubheading() {
		return Subheading;
	}


	public WebElement getHeading() {
		return Heading;
	}


	public WebElement getParagraph() {
		return Paragraph;
	}


	public WebElement getImageLink() {
		return ImageLink;
	}
	
	
	
	

}
