package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeSelfHelpPage {
	//Self tabs list
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-self_help_module__tabs js-selfhelp_tabs']/li//span[@class='m-self_help_module__tab_button_heading']"))
	private List<WebElement> SelfTabs;
	
	
	//Self options list
	@FindBys(@FindBy(how=How.XPATH,using="//*[contains(@class, 'selfhelp_categorys ')]//li/a"))
	private List<WebElement> Selfoptions;
	
	
	//Self topics list
	@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-self_help_module__option_list']/li/a"))
	private List<WebElement> Selftopics;
	
	
	//Outcome heading
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[contains(@class, 'selfhelp_options ')]//h4[@class='m-self_help_module__outcome_heading']"))
	private List<WebElement> OutcomeHeading;
	
	
	//Outcome text
	
	@FindBys(@FindBy(how=How.XPATH,using="//*[contains(@class, 'selfhelp_options ')]//div[@class='m-self_help_module__outcome_text']"))
	private List<WebElement> OutcomeText;
	
	
	//Outcome button
	
	@FindBy(how=How.XPATH,using="//*[contains(@class, 'selfhelp_options ')]//a[@class='e-btn e-btn--primary m-self_help_module__outcome_button']")
	private WebElement Outcomebutton;
	
	
	//Video
	
	@FindBy(how=How.XPATH,using="//*[@class='mceNonEditable embeditem']")
	private WebElement Outcomevideo;
	
	//Image

	@FindBy(how=How.XPATH,using="//*[@class='mceNonEditable embeditem']//following-sibling::p/img")
	private WebElement OutcomeImage;
	
	
	
	
	
	public CordeSelfHelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getSelfTabs() {
		return SelfTabs;
	}

	public List<WebElement> getSelfoptions() {
		return Selfoptions;
	}

	public List<WebElement> getSelftopics() {
		return Selftopics;
	}

	public List<WebElement> getOutcomeHeading() {
		return OutcomeHeading;
	}

	public List<WebElement> getOutcomeText() {
		return OutcomeText;
	}

	public WebElement getOutcomebutton() {
		return Outcomebutton;
	}

	public WebElement getOutcomevideo() {
		return Outcomevideo;
	}

	public WebElement getOutcomeImage() {
		return OutcomeImage;
	}
	
	

}
