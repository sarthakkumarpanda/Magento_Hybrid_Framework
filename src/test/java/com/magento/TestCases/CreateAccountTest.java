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
        homepage.clickOnCreateAccountLink();
        //driver.findElement(By.linkText("Create an Account")).click();
    }

    @Test(priority=1, dataProvider = "CreateAccountMAGENTO", dataProviderClass = ExcelCode.class)
    public void createAccountWithMandatoryDetails(String firstname, String lastname, String password, String confirmpassword) throws InterruptedException {
    	createnewcustomeraccountpage = new CreateNewCustomerAccountPage(driver);
    	createnewcustomeraccountpage.enterFirstname(firstname);
    	createnewcustomeraccountpage.enterLastname(lastname);
    	createnewcustomeraccountpage.enterEmail(Utils.emailWithDateTimeStamp());
    	createnewcustomeraccountpage.enterPassword(password);
    	createnewcustomeraccountpage.enterConfirmPassword(confirmpassword);
    	createnewcustomeraccountpage.clickOnCreateAccountButton();
        Thread.sleep(2000);
        myaccountpage = new MyAccountPage(driver);
        Assert.assertTrue(myaccountpage.displayStatusOfAccountCreationMessagek());
      }

    @Test(priority=2)
    public void createAccountWithInvalidConfirmPassword(){
    	createnewcustomeraccountpage = new CreateNewCustomerAccountPage(driver);
    	createnewcustomeraccountpage.enterFirstname(dataprop.getProperty("firstname"));
    	createnewcustomeraccountpage.enterLastname(dataprop.getProperty("lastname"));
    	createnewcustomeraccountpage.enterEmail(Utils.emailWithDateTimeStamp());
    	createnewcustomeraccountpage.enterPassword(prop.getProperty("validPassword"));
    	createnewcustomeraccountpage.enterConfirmPassword(dataprop.getProperty("invalidPassword"));
    	createnewcustomeraccountpage.clickOnCreateAccountButton();
    	String actualWarning = createnewcustomeraccountpage.retrieveInvalidConfirmPassword();
        String expectedWarning = dataprop.getProperty("invalidConfirmPasswordWarning");
        Assert.assertTrue(actualWarning.contains(expectedWarning));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
