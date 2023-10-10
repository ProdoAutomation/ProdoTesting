//package runner;
//
//import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;
//
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "src/test/java/feature/Corde.feature",
//		glue = {"seleniumgluecode"},
//	//	tags = {"@stat"},
//		//plugin= {"json:TestReports/cucumber.json"},
//		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/CucumberTestReport.html"},
//				monochrome = true
//				
//		
//		)
//
//public class TestngRunner extends AbstractTestNGCucumberTests {
//	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//		
//	}
//
//}
