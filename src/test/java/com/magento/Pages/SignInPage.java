package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	public WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement emailTextBox;
	
	@FindBy(id = "pass")
	private WebElement passwordTextBox;
	
	@FindBy(css = "button.action.login.primary")
    private WebElement signinbutton;	
	
	@FindBy(xpath = "//div[text() = 'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
	private WebElement warningMessage;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public WelcomePage navigateToWelcomePage(String emailText, String passwordText) {
		emailTextBox.sendKeys(emailText);
		passwordTextBox.sendKeys(passwordText);
		signinbutton.click();
		return new WelcomePage(driver);
	}
	
	public boolean displayStatusWarningMessage() {
		boolean display = warningMessage.isDisplayed();
		return display;
	}
}
