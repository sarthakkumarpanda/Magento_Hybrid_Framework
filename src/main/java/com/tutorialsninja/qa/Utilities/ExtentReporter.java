package com.tutorialsninja.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	//STEP 1: Add the dependencies of extentreports in pom.xml file
	
	//Step 2: Go to the url https://extentreports.com/docs/versions/5/java/index.html
	         //Getting Started > Reporters
	         //Complete Example - Click on 'OnlineHere'
	
	//Step 3: Create a method generateExtentReporter()
	
	public static ExtentReports generateExtentReporter() throws Exception {
		//Step 4: Create the Object of ExtentReports class
		   ExtentReports extentReport = new ExtentReports();
		   
		//Step 5: Create the Object of File Class and pass the path of the .html file in the constructor
		   File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreporterMagento.html");
		   
		//Step 6: Create the Object of ExtentSparkReporter and pass the .html file in its constructor
		   ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		   
		//Step 7: using sparkReporter we can configure a lot of things in our ExtentReport file
		   
		   sparkReporter.config().setTheme(Theme.DARK);
		   sparkReporter.config().setReportName("Magento REGRESSION Test");
		   sparkReporter.config().setDocumentTitle("Magento | PnT Weekend Batch");
		   sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		   
		//Step 8: We need to attach the ExtentReport with the SparkReporter
		   extentReport.attachReporter(sparkReporter);
		   
		//Step 9: Additional Information and pass it on to the Extent Reports
		   //url of the application
		   //browser
		   //validEmail
		   //validPassword
		   //Operating System
		   //OS version
		   //User Name
		   //Java Version
		   //Java Vendor
		   
		   Properties prop = new Properties();
		   FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\magento\\ConfigData\\config.properties");
		   prop.load(ip);
		   
		   extentReport.setSystemInfo("application url", prop.getProperty("url"));
		   extentReport.setSystemInfo("browser name ", prop.getProperty("browser"));
		   extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		   extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		   extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
		   extentReport.setSystemInfo("java version", prop.getProperty("java.version"));
		   extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
		   extentReport.setSystemInfo("SDET CountryName", prop.getProperty("user.country"));
		   
		   
		 //Step 10: Return the extentReport
		   return extentReport;
		   
	}
	
	
	

}
