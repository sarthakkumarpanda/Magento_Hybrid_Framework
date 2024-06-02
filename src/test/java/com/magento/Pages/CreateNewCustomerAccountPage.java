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
	
	
	public void enterFirstname(String firstnametext) {
		firstnameTextBox.sendKeys(firstnametext);
	}
	
	public void enterLastname(String lastnametext) {
		lastnameTextBox.sendKeys(lastnametext);
	}
	
	public void enterEmail(String emailtext) {
		emailTextBox.sendKeys(emailtext);
	}
	
	public void enterPassword(String passwordtext) {
		passwordTextBox.sendKeys(passwordtext);
	}
	
	public void enterConfirmPassword(String confirmpasswordtext) {
		passwordconfirmationTextBox.sendKeys(confirmpasswordtext);
	}
	
	public void clickOnCreateAccountButton() {
		createAccountButton.click();
	}
	
	
	public String retrieveInvalidConfirmPassword() {
		String warning = invalidConfirmPasswordWarning.getText();
		return warning;
	}

}
