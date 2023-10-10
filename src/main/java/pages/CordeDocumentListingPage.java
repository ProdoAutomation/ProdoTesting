package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CordeDocumentListingPage {
	
	
	//Document headings
	
	@FindBys(@FindBy(how=How.XPATH, using="//*[@class='m-documents__item']//h3"))
	private List<WebElement> DocumentHeading;
	
	//Document Paragraph
	@FindBys(@FindBy(how=How.XPATH, using="//*[@class='m-documents__item']//p"))
	private List<WebElement>  DocumentPara;
	
	
	//Document Icons
	@FindBys(@FindBy(how=How.XPATH, using="//*[@class='m-documents__item']//i"))
	private List<WebElement>  DocumentIcon;
	
	
	//Download button
	@FindBys(@FindBy(how=How.XPATH, using="//*[@class='e-btn e-btn--full']"))
	private List<WebElement>  Downloadbutton;
	
	//Viewonline button
	@FindBys(@FindBy(how=How.XPATH, using="//*[@class='m-documents__btn e-btn e-btn--secondary e-btn--full']"))
	private List<WebElement>  Viewonline;
	
		public CordeDocumentListingPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	
		}



		public List<WebElement> getDocumentHeading() {
			return DocumentHeading;
		}



		public List<WebElement> getDocumentPara() {
			return DocumentPara;
		}



		public List<WebElement> getDocumentIcon() {
			return DocumentIcon;
		}



		public List<WebElement> getDownloadbutton() {
			return Downloadbutton;
		}



		public List<WebElement> getViewonline() {
			return Viewonline;
		}


		
		














}
