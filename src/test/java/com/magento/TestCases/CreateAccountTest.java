package com.magento.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.Pages.CreateNewCustomerAccountPage;
import com.magento.Pages.HomePage;
import com.magento.Pages.MyAccountPage;
import com.magento.TestBase.TestBase;
import com.magento.TestData.ExcelCode;
import com.tutorialsninja.qa.Utilities.Utils;

public class CreateAccountTest extends TestBase{
    public CreateAccountTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public CreateNewCustomerAccountPage createnewcustomeraccountpage;
	public MyAccountPage myaccountpage;

    @BeforeMethod
    public void createAccountSetup(){
        driver = initializeBrowserAndOpenApplication("Chrome");
        homepage = new HomePage(driver);
        createnewcustomeraccountpage  =  homepage.clickOnCreateAccountLink(); //this will return a new CreateNewCustomerAccountPage
    }

    @Test(priority=1, dataProvider = "CreateAccountMAGENTO", dataProviderClass = ExcelCode.class)
    public void createAccountWithMandatoryDetails(String firstname, String lastname, String password, String confirmpassword) throws InterruptedException {
    	
    	myaccountpage = createnewcustomeraccountpage.navigateToMyAccountPage(firstname, lastname, Utils.emailWithDateTimeStamp(), password, confirmpassword);
        Thread.sleep(2000);
        Assert.assertTrue(myaccountpage.displayStatusOfAccountCreationMessagek());
      }

    @Test(priority=2)
    public void createAccountWithInvalidConfirmPassword(){
    	myaccountpage = createnewcustomeraccountpage.navigateToMyAccountPage(dataprop.getProperty("firstname"), 
    			dataprop.getProperty("lastname"), Utils.emailWithDateTimeStamp(), prop.getProperty("validPassword"),
    			dataprop.getProperty("invalidPassword"));

        Assert.assertTrue(createnewcustomeraccountpage.retrieveInvalidConfirmPassword().contains(dataprop.getProperty("invalidConfirmPasswordWarning")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
