package Devices;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

import Data.TestData;
import Pages.ElementosLogin;

public class TestBase implements TestData {

	public static ChromeOptions option;
	public static String jsonAsString;
	public static WebDriver driver;

	public static void Chrome(String url) {
		System.setProperty("webdriver.chrome.whitelistedIps", "");

		String foo = System.getProperty("env", "chrome");
		switch (foo) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--start-maximized");
			options.addArguments("--headless");
			options.addArguments("disable-gpu");
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(options);
			driver.get(url);
			return;

		}

	}

	public static void Firefox(String url) {

		String foo = System.getProperty("env", "firefox");
		switch (foo) {

		case "firefox":
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.setProfile(new FirefoxProfile());
			optionsFirefox.addArguments("--no-sandbox");
			optionsFirefox.addArguments("--disable-dev-shm-usage");
			optionsFirefox.addArguments("--window-size=1920,1080");
			optionsFirefox.addArguments("--start-maximized");
			optionsFirefox.addArguments("--headless");
			driver = new FirefoxDriver(optionsFirefox);
			driver.get(url);
			return;
		}

	}

	public static void Mobile(String url) {

		String foo = System.getProperty("env", "mobile");
		switch (foo) {

		case "mobile":
			ChromeOptions optionsMobile = new ChromeOptions();
			optionsMobile.addArguments("--no-sandbox");
			optionsMobile.addArguments("--disable-dev-shm-usage");
			optionsMobile.addArguments("--headless");
			optionsMobile.addArguments("disable-gpu");
			optionsMobile.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			Map<String, Object> deviceMetricsMobile = new HashMap<>();
			deviceMetricsMobile.put("width", 412);
			deviceMetricsMobile.put("height", 915);
			deviceMetricsMobile.put("pixelRatio", 3.0);
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			optionsMobile.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(optionsMobile);
			driver.get(url);
			return;
		}

	}

}