package com.magento.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.TestBase.TestBase;
import com.magento.TestData.ExcelCode;
import com.tutorialsninja.qa.Utilities.Utils;

public class CreateAccountTest extends TestBase{
    public CreateAccountTest() throws Exception {
		super();
	}

	public WebDriver driver;

    @BeforeMethod
    public void createAccountSetup(){
        driver = initializeBrowserAndOpenApplication("Chrome");
        driver.findElement(By.linkText("Create an Account")).click();
    }

    @Test(priority=1, dataProvider = "CreateAccountMAGENTO", dataProviderClass = ExcelCode.class)
    public void createAccountWithMandatoryDetails(String firstname, String lastname, String password, String confirmpassword) throws InterruptedException {
        driver.findElement(By.id("firstname")).sendKeys(firstname);
        driver.findElement(By.id("lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).sendKeys(Utils.emailWithDateTimeStamp());
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password-confirmation")).sendKeys(confirmpassword);
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Thank you for registering with Main Website Store.']")).isDisplayed());
    }

    @Test(priority=2)
    public void createAccountWithInvalidConfirmPassword(){
        driver.findElement(By.id("firstname")).sendKeys("Selenium");
        driver.findElement(By.id("lastname")).sendKeys("Panda");
        driver.findElement(By.id("email_address")).sendKeys(Utils.emailWithDateTimeStamp());
        driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("password-confirmation")).sendKeys(dataprop.getProperty("invalidPassword"));
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        String actualWarning = driver.findElement(By.xpath("//div[@id = 'password-confirmation-error']")).getText();
        String expectedWarning = "Please enter the same value again.";
        Assert.assertTrue(actualWarning.contains(expectedWarning));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
