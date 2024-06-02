package com.magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerAccountPage {
	
	public WebDriver driver;
	
	@FindBy(id = "firstname")
	private WebElement firstnameTextBox;
	
	@FindBy(id = "lastname")
	private WebElement lastnameTextBox;
	
	@FindBy(id = "email_address")
	private WebElement emailTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "password-confirmation")
	private WebElement passwordconfirmationTextBox;
	
	@FindBy(css = "button.action.submit.primary")
	private WebElement createAccountButton;
	
	@FindBy(xpath = "//div[@id = 'password-confirmation-error']")
	private WebElement invalidConfirmPasswordWarning;
	
	public CreateNewCustomerAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	public MyAccountPage navigateToMyAccountPage(String firstnametext, String lastnametext, String emailtext, String passwordtext, String confirmpasswordtext) {
		firstnameTextBox.sendKeys(firstnametext);
		lastnameTextBox.sendKeys(lastnametext);
		emailTextBox.sendKeys(emailtext);
		passwordTextBox.sendKeys(passwordtext);
		passwordconfirmationTextBox.sendKeys(confirmpasswordtext);
		createAccountButton.click();
		return new MyAccountPage(driver);
		
	}
	
	
	public String retrieveInvalidConfirmPassword() {
		String warning = invalidConfirmPasswordWarning.getText();
		return warning;
	}

}
