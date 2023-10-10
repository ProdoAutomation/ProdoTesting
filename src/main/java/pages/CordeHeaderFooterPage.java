package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeHeaderFooterPage {
	
	//Footer Logo
	@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__logo_link']/img")
	private WebElement Footerlogo;
	
	//Header Logo
	@FindBy(how=How.XPATH,using="//*[@class='m-site_header__logo_link']/img")
	private WebElement Headerlogo;
	
	
	//Footer links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__item m-site_footer__item--grid']"))
	private List<WebElement> Footerlinks;
	
	//Social Links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__item']/a"))
	private List<WebElement> SocialLinks;	
	
	
	//SocialIcons
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__item']//i"))
	private List<WebElement> SocialIcons;	

	//Corporate text 
	@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__corporate']")
	private WebElement CorporateText;

	//Corporate link 
	@FindBy(how=How.XPATH,using="//*[@class='m-site_footer__corporate']/a")
	private WebElement CorporateLink;	
	
	
	//submenu links
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_dropdown__column m-site_dropdown__column--half js-nav-column']/ul/li/a"))
	private List<WebElement> Submenulinks;	
	
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_dropdown__column js-sub-menu']//a"))
	private List<WebElement> Childmenulinks;	
	
	public CordeHeaderFooterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	public WebElement getFooterlogo() {
		return Footerlogo;
	}


	public WebElement getHeaderlogo() {
		return Headerlogo;
	}


	public List<WebElement> getFooterlinks() {
		return Footerlinks;
	}

	public List<WebElement> getSocialLinks() {
		return SocialLinks;
	}


	public List<WebElement> getSocialIcons() {
		return SocialIcons;
	}


	public WebElement getCorporateText() {
		return CorporateText;
	}


	public WebElement getCorporateLink() {
		return CorporateLink;
	}



	public List<WebElement> getSubmenulinks() {
		return Submenulinks;
	}



	public List<WebElement> getChildmenulinks() {
		return Childmenulinks;
	}
	
	
	
	
	
	

}
