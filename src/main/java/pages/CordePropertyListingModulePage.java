package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordePropertyListingModulePage {
	
	
	//Property listing
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__item']"))
	private List <WebElement> Propertylistings;
	
	//Property Image Listing
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__item']/a"))
	private List <WebElement> PropertyImagelink;
	
	//Property Images
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__picture']/img"))
	private List <WebElement> PropertyImages;
	
	//Property promotion label
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__labels']/span"))
	private List <WebElement> Propertypromotionlabel;
	
	//Property Heading
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__labels']/following-sibling::h3/a"))
	private List <WebElement> PropertyHeading;
	
	//Property Summary
	@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__labels']/following-sibling::p")
	private WebElement PropertySummary;
	
	//Property details
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__detail']"))
	private List <WebElement> Propertydetails;
	
	//Property Links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-property_promotion__link']/a"))
	private List <WebElement> Propertylinks;
	
	public CordePropertyListingModulePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public List<WebElement> getPropertylistings() {
		return Propertylistings;
	}


	public List<WebElement> getPropertyImagelink() {
		return PropertyImagelink;
	}


	public List<WebElement> getPropertyImages() {
		return PropertyImages;
	}


	public List<WebElement> getPropertypromotionlabel() {
		return Propertypromotionlabel;
	}


	public List<WebElement> getPropertyHeading() {
		return PropertyHeading;
	}


	public WebElement getPropertySummary() {
		return PropertySummary;
	}


	public List<WebElement> getPropertydetails() {
		return Propertydetails;
	}


	public List<WebElement> getPropertylinks() {
		return Propertylinks;
	}

	
	
	
}
