package com.magento.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.Utilities.Utils;

public class TestBase {

	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public FileInputStream ip;
	public FileInputStream ip1;
	public ChromeOptions options;

	public TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\magento\\ConfigData\\config.properties");
		prop.load(ip);
		
		dataprop = new Properties();
		ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\magento\\TestData\\dataProp.properties");
		dataprop.load(ip1);
	}
	

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equals("Chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Browser Not matching");
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
}


