package Runner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.cucumber.listener.Reporter;
import Data.TestData;
import Devices.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProviders.ConfigFileReader;
import managers.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features/Web/",
 glue= {"steps_definition"},
 tags ={"@PesquisaAmazon"},
 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty","json:target/cucumber-json/cucumber.json"}, 
 monochrome = false
)

public class Testrunner implements TestData {
	
	@BeforeClass
	public static void setup() throws Exception { 
		
//		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://pegasus.angular.custodia.maps.intranet/ativo/ui/");
    	
	}
	
  public static void closeBrowser() {
	  TestBase.driver.close();
}
	
    @AfterClass
    public static void writeExtentReport() {
    	Reporter.loadXMLConfig(new File("config/report.xml"));

    	TestBase.driver.close();
    }


}
