package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public WebDriver driver;
	
	@FindBy(linkText = "Sign In")
	private WebElement singinLink;
	
	@FindBy(linkText = "Create an Account")
	private WebElement createAccountLink;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSignInLink() {
		singinLink.click();
	}
	
	public void clickOnCreateAccountLink() {
		createAccountLink.click();	
	}

}
