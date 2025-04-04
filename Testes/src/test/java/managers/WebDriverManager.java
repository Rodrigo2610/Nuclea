package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Data.TestData;
import Devices.TestBase;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager extends TestBase implements TestData {
	
	WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
//		if(driver == null) driver = createDriver();
		driver = TestBase.driver;
		return driver;
	}

//	public WebDriver createDriver() {
//		   switch (environmentType) {	    
////	        case LOCAL : driver = createLocalDriver();
//	        case CUSTODIADEV : driver = TestBase.driver = new ChromeDriver();
//	        	break;
//	        case EVOLUCAO : driver = TestBase.driver = new ChromeDriver();
//                         
//	        	break;
//		   }
//		   return driver;
//	}

	private WebDriver createRemoteDriver() {
		
		//throw new RuntimeException("RemoteWebDriver is not yet implemented");
		
		return driver;

	}

	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX :
        	TestBase.driver = driver;
	    	break;
        case CHROME : 
//        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	TestBase.driver = driver;
   
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
//		driver.close();
//		driver.quit();
	}

}

