package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

public WebDriver driver;	
	
	
	@FindBy(linkText = "My Orders")
	private WebElement myorderslink;
	
	@FindBy(xpath = "//div[text() = 'Thank you for registering with Main Website Store.']")
	private WebElement accountAcknowledgeMessage;
	
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    
	public boolean displayStatusOfMyOrdersLink() {
		boolean displayStatus = myorderslink.isDisplayed();
		return displayStatus;
	}
	
	public boolean displayStatusOfAccountCreationMessagek() {
		boolean displayStatus = accountAcknowledgeMessage.isDisplayed();
		return displayStatus;
	}
	
	
}
