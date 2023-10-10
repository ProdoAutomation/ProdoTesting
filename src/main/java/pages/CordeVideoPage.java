package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeVideoPage {
	//Light house video Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-video m-video--lightbox']//h2")
	private WebElement VideoHeading;	
	
	//Light house video paragraph
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-video m-video--lightbox']//p"))
	private List<WebElement> VideoPara;

	
	//Light house video button
	@FindBy(how=How.XPATH,using="//*[@class='m-video__btn']")
	private WebElement VideoBTN;
	

	//Light house iframe video button
	@FindBy(how=How.CSS,using="button.ytp-large-play-button.ytp-button.ytp-large-play-button-red-bg")
	private WebElement VideoLightBTN;
	
	//Lightbox video iframe
	@FindBy(how=How.XPATH,using="//*[@class='m-modal__embed']/iframe")
	private WebElement VideoIframe;
	
	//video iframe
	@FindBy(how=How.XPATH,using="//*[@class='m-video__embed']/iframe")
	private WebElement VideoNonLight;
		
	// video Heading
	@FindBy(how=How.XPATH,using="//*[@class='m-video m-video--embed']//h2")
	private WebElement VideoH2;	
	
	// video Paragraph
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-video m-video--embed']//p"))
	private List<WebElement> VideoP2;	
	
	//Close button
	@FindBy(how=How.XPATH,using="//*[@type='button'][@class='m-modal__close js-close_modal']")
	private WebElement Closebutton;	
	
	//Modal frame
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-video m-video--lightbox']//a[@class='m-video__btn']"))
	private List<WebElement> Modalframe;	
	
	//Modal play button
	@FindBy(how=How.XPATH,using="//*[@class='m-modal__embed']/iframe")
	private WebElement Modalplaybutton;	

	public CordeVideoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getVideoHeading() {
		return VideoHeading;
	}

	public List<WebElement> getVideoPara() {
		return VideoPara;
	}

	public WebElement getVideoBTN() {
		return VideoBTN;
	}

	public WebElement getVideoIframe() {
		return VideoIframe;
	}

	public WebElement getVideoNonLight() {
		return VideoNonLight;
	}

	public WebElement getVideoLightBTN() {
		return VideoLightBTN;
	}

	public WebElement getVideoH2() {
		return VideoH2;
	}

	public List<WebElement> getVideoP2() {
		return VideoP2;
	}

	public WebElement getClosebutton() {
		return Closebutton;
	}

	public List<WebElement> getModalframe() {
		return Modalframe;
	}

	public WebElement getModalplaybutton() {
		return Modalplaybutton;
	}

	
	
	
}

