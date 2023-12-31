package baseClass;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;




import java.time.*;
import java.time.format.*;

public class BaseClass {
	
	public static WebDriver driver;
	//Method to get the chromerdriver to run in chrome browser
	public static WebDriver getBrowser(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajalakshmiganesan\\Desktop\\Initail Setup\\ProdoTesting\\src\\test\\java\\drivers\\chromedriver.exe");
				driver = new  ChromeDriver();
		}
//			else	if(browser.equalsIgnoreCase("firefox")) {
//				System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajalakshmiganesan\\Desktop\\Initail Setup\\ProdoTesting\\src\\test\\java\\drivers\\geckodriver.exe");
//				
//				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//				capabilities.setCapability("marionette",true);
//				driver = new FirefoxDriver(capabilities);
//		}
			else {
				
				System.out.println("Invalid Browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		return driver;
		
	}
	
	
	//Method for explicit wait
	public static void WaitForElementvisibility(WebElement element) {
		try {
			WebDriverWait waits = new WebDriverWait(driver,Duration.ofMillis(6000));
			waits.until(ExpectedConditions.visibilityOf(element));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method for explicit wait
		public static void WaitForAllElementvisibility(List<WebElement> stats) {
			try {
				WebDriverWait waits = new WebDriverWait(driver,Duration.ofMillis(60000));
				waits.until(ExpectedConditions.visibilityOfAllElements(stats));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	//Method to Click the Element
	public static void ClickElement(WebElement element) {
		WaitForElementvisibility(element);
		try {
		element.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Method to enter the values in Text Box Field
	public static void InputvaluesIntoFields(WebElement element,String value) {
		WaitForElementvisibility(element);
		try {
			element.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to get the mouse actions
	public static void MoveToElement(WebElement element) {
		//WaitForElementvisibility(element);
		try {
		Actions Act = new Actions(driver);
		Act.moveToElement(element).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to Select the value from dropdown field
	public static void Selectelement(WebElement element,int index,String value,String option) {
		Select sel = new Select(element);
		if(option.equalsIgnoreCase("value")) {
			sel.selectByValue(value);
		}
		else if (option.equalsIgnoreCase("index")) {
			sel.selectByIndex(Integer.parseInt(value));
		}
	else if (option.equalsIgnoreCase("visibiletext")) {
		sel.selectByVisibleText(value);
		
	}
	}
	//Method to get the screenshot
	public static void getScreenshot(WebDriver driver,String Name) throws IOException {
		try {
			TakesScreenshot screen = (TakesScreenshot)driver;
			File file = screen.getScreenshotAs(OutputType.FILE);
			File destfile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+Name+".png");
			FileUtils.copyFile(file, destfile);
			Reporter.addScreenCaptureFromPath(destfile.toString());

		}catch(WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	
	//Method to scroll the page
	public static void getScroll(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	}
	
	//Method to scroll the page 700
	public static void getScroll700(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,700)");
	}
	
	
	public String Log(Level l,String message) {
		LocalDateTime present = LocalDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String logDateTime = present.format(f);
		return l + ":"+logDateTime + ":" +message;
		
	}
	
	
	//Method to check the file is downloaded and delete from the folder
	public static Boolean isFileDownloaded(String fileName) throws InterruptedException {
        boolean flag = false;
        String dirPath = "C:\\Users\\rajalakshmiganesan\\Downloads"; 
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if ( files == null) {
        	Reporter.addStepLog("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                	flag = true;
                 //	Reporter.addStepLog(fileName + " is present");
                    listFile.delete();
                    Thread.sleep(1000);
                    break;
                }
               // flag = true;
            }
        }
        return flag;
    }
   
	public static  void ImageCheck(WebElement element) {
	
	   String img = element.getAttribute("src");
	   try {
		   if (img== null) {
			   throw new NoSuchElementException();
		   }
		   else {
			   BufferedImage imgs=ImageIO.read(new URL(img));
			  // Reporter.addStepLog("Image is displayed");
		   }
	   }
	   catch (Exception e) {
		   e.printStackTrace();
	   }
	
	}
	
	
	
}
