package dataProviders;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;

import pages.CordeAccordionPage;
import pages.CordeFeaturesPage;
import pages.CordeGridIconPage;
import pages.CordeListingsPage;
import pages.CordeQuickLinkPage;
import pages.CordeQuotePage;
import pages.CordeRichTextEditorPage;
import pages.CordeSocialPage;
import pages.CordeStatPage;
import pages.CordeTextSnippetPage;
import pages.CordeVideoPage;
import pages.YHGHomepage;
import pages.YHGPage;

public class PageObjectManager {
	public static WebDriver driver;
	private YHGPage yhg;
	private YHGHomepage YHGhome;
	private CordeAccordionPage CordeAcc;
	private CordeQuickLinkPage CordeQuick;
	private CordeTextSnippetPage CordeText;
	private CordeRichTextEditorPage CordeRTE;
	private CordeQuotePage CordeQuote;
	private CordeStatPage CordeStat;
	private CordeVideoPage Cordevideo;
	private CordeFeaturesPage CordeFeatures;
	private CordeSocialPage CordeSocial;
	private CordeListingsPage CordeListings;
	private CordeGridIconPage CordeGridIcon;
	
	


	
	public PageObjectManager(WebDriver driver1) {
		this.driver=driver1;
		
	}


	public YHGPage getYhg() {
		yhg = new YHGPage(driver);
		return yhg;
	}


	public YHGHomepage getYHGhome() {
		YHGhome = new YHGHomepage(driver);
		return YHGhome;
	}
	
	public CordeAccordionPage getCordeAcc() {
		CordeAcc = new CordeAccordionPage(driver);
		return CordeAcc;
	}

	public CordeQuickLinkPage getCordeQuickLinkPage() {
		CordeQuick = new CordeQuickLinkPage(driver);
		return CordeQuick;
	}

	public CordeTextSnippetPage getCordeText() {
		CordeText = new CordeTextSnippetPage(driver);
		return CordeText;
	}
	

	public CordeRichTextEditorPage getCordeRTE() {
		CordeRTE = new CordeRichTextEditorPage(driver);
		return CordeRTE;
	}

	public CordeQuotePage getCordeQuote() {
		CordeQuote= new CordeQuotePage(driver);
		return CordeQuote;
	}

	public CordeStatPage getCordeStat() {
		CordeStat = new CordeStatPage(driver);
		return CordeStat;
	}
	public CordeVideoPage getCordevideo() {
		Cordevideo = new CordeVideoPage(driver);
		return Cordevideo;
	}


	public CordeFeaturesPage getCordeFeatures() {
		CordeFeatures = new CordeFeaturesPage(driver);
		return CordeFeatures;
	}


	public CordeSocialPage getCordeSocial() {
		CordeSocial = new CordeSocialPage(driver);
		return CordeSocial;
	}


	public CordeListingsPage getCordeListings() {
		CordeListings = new CordeListingsPage(driver);
		return CordeListings;
	}


	public CordeGridIconPage getCordeGridIcon() {
		CordeGridIcon = new CordeGridIconPage(driver);
		return CordeGridIcon;
	}
	
	
	
	}
	

