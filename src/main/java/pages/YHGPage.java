package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YHGPage {

	//Menu Nav
		@FindBy(how=How.XPATH,using="//*[@class='m-site_navigation__toggle m-site_navigation__toggle--toggle js-navigation-toggle']")
		private WebElement MenuNav;
		
	//Example&Testing dropdown
		@FindBy(how=How.XPATH,using="//*[@class='m-site_navigation__toggle m-site_navigation__toggle--toggle js-navigation-toggle']")
		private WebElement ExamTest;
		
	//Main Nav list
		@FindBys(@FindBy(how=How.XPATH,using="//*[@class='m-site_navigation__item js-hover']/a"))
		private List<WebElement> MainNavList;
		
		//Search page
		@FindBy(how=How.XPATH,using="//*[@class='m-site_search__input_wrapper m-form__input']")
		private WebElement Search;
		
		//Search text
		
		@FindBy(how=How.XPATH,using="//*[@class='m-site_search__input_wrapper m-form__input']/input[@id='Term']")
		private WebElement Searchtext;

		//Entertext
		
		@FindBy(how=How.XPATH,using="//*[@class='m-site_search__searchsubmit'][@type='submit']")
		private WebElement Entertext;

		
		public YHGPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}

		public List<WebElement> getMainNavList() {
			return MainNavList;
		}

		public WebElement getMenuNav() {
			return MenuNav;
		}

		public WebElement getExamTest() {
			return ExamTest;
		}

		public WebElement getSearch() {
			return Search;
		}
		public WebElement getSearchtext() {
			return Searchtext;
		}
		public WebElement getEntertext() {
			return Entertext;
		}
}
