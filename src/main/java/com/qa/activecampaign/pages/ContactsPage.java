package com.qa.activecampaign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.activecampaign.base.BasePage;

public class ContactsPage extends BasePage
{	
	@FindBy(xpath = "//*//span[text()='Contacts']")
	WebElement Contacts;
	
	@FindBy(xpath = "//a//span[text()='Add a contact']")
	WebElement addAContact;
		
	@FindBy(id = "add-contact-email")
	WebElement email;
	
	@FindBy(id = " add-contact-first-name")
	WebElement firstName;
	
	@FindBy(id = "add-contact-last-name")
	WebElement lastName;
	
	@FindBy(id = "add-contact-phone")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement add;
	
	public ContactsPage(WebDriver contactsDriver)
	{
		this.driver = contactsDriver;
		PageFactory.initElements(contactsDriver, this);
	}
	
	public void addAContact(String emailId,String fName,String lName,String phNum)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 3);//here we are writing ExplicitWAit
		
		//wait.until(ExpectedConditions.elementToBeClickable(addAContact));
		Contacts.click();
		
		addAContact.click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailId);
		
		//wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(fName);
		
		//wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lName);
		
		//wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
		phoneNumber.sendKeys(phNum);
		
		//wait.until(ExpectedConditions.elementToBeClickable(add));
		add.click();
	}
	

}
