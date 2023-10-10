package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeLargeImagePage {
	
	//Large image
	@FindBy(how=How.XPATH,using="//*[@class='m-largeimagecta']//img")
	private WebElement Image;
	
	//Large Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-largeimagecta__heading']")
	private WebElement LargeHeading;
	
	//Large Summary
	@FindBy(how=How.XPATH,using="//*[@class='m-largeimagecta__summary']")
	private WebElement LargeSummary;
	
	//Large Link
	@FindBy(how=How.XPATH,using="//*[@class='m-largeimagecta__heading']/following-sibling::a")
	private WebElement LargeLink;
	
	
	
	
	public CordeLargeImagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public WebElement getImage() {
		return Image;
	}


	public WebElement getLargeHeading() {
		return LargeHeading;
	}


	public WebElement getLargeSummary() {
		return LargeSummary;
	}


	public WebElement getLargeLink() {
		return LargeLink;
	}

	
	
}
