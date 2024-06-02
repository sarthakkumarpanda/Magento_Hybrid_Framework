package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	public WebDriver driver;	
	
	
	@FindBy(css = "li.customer-welcome")
	private WebElement welcomeDropdown;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountOption;
	
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWelcomeDropdown() {
		welcomeDropdown.click();
	}
	
	public MyAccountPage clickOnMyAccountOption() {
		MyAccountOption.click();
		return new MyAccountPage(driver);
	}

}
