package dataProviders;


import org.openqa.selenium.WebDriver;

import pages.CordeAccordionPage;
import pages.CordeDocumentListingPage;
import pages.CordeFeaturesPage;
import pages.CordeFormsPage;
import pages.CordeGalleryThumbnailPage;
import pages.CordeGridIconPage;
import pages.CordeGridLayoutPage;
import pages.CordeHeaderFooterPage;
import pages.CordeImageGalleryPage;
import pages.CordeImageTextPage;
import pages.CordeLargeImagePage;
import pages.CordeLatestNewsPage;
import pages.CordeListingsPage;
import pages.CordeLogoRotatorPage;
import pages.CordeMapPage;
import pages.CordeNewsListingPage;
import pages.CordePropertyListingModulePage;
import pages.CordeQuickLinkPage;
import pages.CordeQuotePage;
import pages.CordeRawHTMLPage;
import pages.CordeRichTextEditorPage;
import pages.CordeSelfHelpPage;
import pages.CordeSocialPage;
import pages.CordeStatPage;
import pages.CordeTextSnippetPage;
import pages.CordeVideoPage;

public class PageObjectManager {
	public static WebDriver driver;
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
	private CordeSelfHelpPage CordeSelfHelp;
	private CordeDocumentListingPage Cordedocuments;
	private CordeFormsPage CordeForms;
	private CordeLatestNewsPage LatestNews;
	private CordePropertyListingModulePage Propertylistmodule;
	private CordeImageTextPage ImageText;
	private CordeLargeImagePage LargeImage;
	private CordeLogoRotatorPage LogoRotator;
	private CordeGalleryThumbnailPage Thumbnail;
	private CordeGridLayoutPage GridLayout;
	private CordeImageGalleryPage ImageGallery;
	private CordeRawHTMLPage Rawhtml;
	private CordeHeaderFooterPage HeadFooter;
	private CordeMapPage Maps;
	private CordeNewsListingPage NewsListing;
	

	public static WebDriver getDriver() {
		return driver;
	}
	
	public PageObjectManager(WebDriver driver1) {
		this.driver=driver1;
		
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


	public CordeSelfHelpPage getCordeSelfHelp() {
		CordeSelfHelp = new CordeSelfHelpPage(driver);
		return CordeSelfHelp;
	}

	public CordeDocumentListingPage getCordedocuments() {
		Cordedocuments= new CordeDocumentListingPage(driver);
		return Cordedocuments;
	}

	public CordeFormsPage getCordeForms() {
		CordeForms = new CordeFormsPage(driver);
		return CordeForms;
	}

	public CordeLatestNewsPage getLatestNews() {
		LatestNews = new CordeLatestNewsPage(driver);
		return LatestNews;
	}

	
	public CordePropertyListingModulePage getPropertylistmodule() {
		Propertylistmodule = new CordePropertyListingModulePage(driver);
		return Propertylistmodule;
	}

	public CordeImageTextPage getImageText() {
		ImageText = new CordeImageTextPage(driver);
		return ImageText;
	}

	public CordeLargeImagePage getLargeImage() {
		LargeImage = new CordeLargeImagePage(driver);
		return LargeImage;
	}

	public CordeLogoRotatorPage getLogoRotator() {
		LogoRotator= new CordeLogoRotatorPage(driver);
		return LogoRotator;
	}

	public CordeGalleryThumbnailPage getThumbnail() {
		Thumbnail = new CordeGalleryThumbnailPage(driver);
		return Thumbnail;
	}

	public CordeGridLayoutPage getGridLayout() {
		GridLayout= new CordeGridLayoutPage(driver);
		return GridLayout;
	}

	public CordeImageGalleryPage getImageGallery() {
		ImageGallery = new  CordeImageGalleryPage(driver);
		return ImageGallery;
	}

	public CordeRawHTMLPage getRawhtml() {
		Rawhtml = new CordeRawHTMLPage(driver);
		return Rawhtml;
	}

	public CordeHeaderFooterPage getHeadFooter() {
		HeadFooter = new CordeHeaderFooterPage(driver);
		return HeadFooter;
	}

	public CordeMapPage getMaps() {
		Maps= new CordeMapPage(driver);
		return Maps;
	}

	public CordeNewsListingPage getNewsListing() {
		NewsListing = new CordeNewsListingPage(driver);
		return NewsListing;
	}
	
	
	
	
	}
	

