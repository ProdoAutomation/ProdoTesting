package seleniumgluecode;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import dataProviders.FileReaderManager;
import dataProviders.PageObjectManager;
import runner.TestRunner;

public class BackgroundSteps {
	
	
	public static WebDriver driver = TestRunner.driver;
	PageObjectManager pag = new PageObjectManager(driver);
	
	@Given("^Launch the Application$")
	public void launch_the_Application() throws Throwable {
		driver.get(FileReaderManager.getInstance().getCRInstance().getData("CordeURL"));
	}

}
