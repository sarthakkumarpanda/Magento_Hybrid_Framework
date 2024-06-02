package com.magento.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.Pages.HomePage;
import com.magento.Pages.MyAccountPage;
import com.magento.Pages.SignInPage;
import com.magento.Pages.WelcomePage;
import com.magento.TestBase.TestBase;
import com.magento.TestData.ExcelCode;

public class LoginTest extends TestBase	{
	
	  public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public SignInPage signinpage;
    public WelcomePage welcomepage;
    public MyAccountPage myaccountpage;
    
    
	    @BeforeMethod
	    public void createLoginSetup(){
	        driver = initializeBrowserAndOpenApplication("Chrome");
	        homepage = new HomePage(driver);
	        homepage.clickOnSignInLink();
	    }
	    
	    @Test(priority=1, dataProvider = "LoginMAGENTO", dataProviderClass = ExcelCode.class)
	    public void loginWithValidCredentials(String email, String password ) throws InterruptedException {
	    	signinpage = new SignInPage(driver);
	    	signinpage.enterEmail(email);
	    	signinpage.enterPassword(password);
	    	signinpage.clickOnSigninButton();
	    	welcomepage = new WelcomePage(driver);
	    	welcomepage.clickOnWelcomeDropdown();
	    	welcomepage.clickOnMyAccountOption();
	    	myaccountpage = new MyAccountPage(driver);
	    	myaccountpage.displayStatusOfMyOrdersLink(); 	
	    }
	    
	    @Test(priority=2)
	    public void loginWithInvalidCredentials() throws InterruptedException {
	    	signinpage = new SignInPage(driver);
	    	signinpage.enterEmail(prop.getProperty("validEmail"));
	    	signinpage.enterPassword(dataprop.getProperty("invalidPassword"));
	    	signinpage.clickOnSigninButton();
	    	Thread.sleep(3000);
	    	Assert.assertTrue(signinpage.displayStatusWarningMessage());
	    }
	    
	    
	    
	    @AfterMethod
	    public void tearDown() {
	       driver.quit();
	    }
}


