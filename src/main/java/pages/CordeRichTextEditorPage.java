package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeRichTextEditorPage {

	//Heading1
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h1")
		private WebElement Heading1;
		
	//Heading2
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h2")
		private WebElement Heading2;
		
	//Heading3
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h3")
		private WebElement Heading3;
		
	//Heading4
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h4")
		private WebElement Heading4;
		
	//Heading5
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h5")
		private WebElement Heading5;
	
	//Heading6
		@FindBy(how=How.XPATH,using="//*[@class='m-rte']/h6")
		private WebElement Heading6;
		
		
	//ul Tags
	@FindBys(	@FindBy(how=How.XPATH,using="//*[@class='m-rte']/ul"))
		private List<WebElement> ULTags;
		
	//ul Tags
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-rte']/ol"))
		private List<WebElement>OLTags;
		
	//Secondary button
		@FindBy(how=How.XPATH,using="//*[@class=\"rte_btn__primary\"]/following::span/a/span[@class=\"rte_btn__primary\"]")
		private WebElement SecondaryBT;
		
	//Primary button
		@FindBy(how=How.XPATH,using="//*[@class=\"rte_btn__primary\"]/a")
		private WebElement PrimaryBT;
		
	public CordeRichTextEditorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getHeading1() {
		return Heading1;
	}

	public WebElement getHeading2() {
		return Heading2;
	}

	public WebElement getHeading3() {
		return Heading3;
	}

	public WebElement getHeading4() {
		return Heading4;
	}

	public WebElement getHeading5() {
		return Heading5;
	}

	public WebElement getHeading6() {
		return Heading6;
	}

	public List<WebElement> getULTags() {
		return ULTags;
	}

	public List<WebElement> getOLTags() {
		return OLTags;
	}

	public WebElement getSecondaryBT() {
		return SecondaryBT;
	}

	public WebElement getPrimaryBT() {
		return PrimaryBT;
	}
	
	

}
