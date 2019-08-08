package com.qa.activecampaign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.utilities.Element_Actions_Utility;

public class ContactsNPFPage extends BasePage {
	
	Element_Actions_Utility elem_act;
	
	By addOneContact = By.xpath("//span[text()='Add a contact']");	
	By e_mail = By.id("add-contact-email");
	By first_Name = By.id("add-contact-first-name");
	By last_Name = By.id("add-contact-last-name");
	By phone_Number =  By.id("add-contact-phone");
	By finalAdd = By.xpath("//button[text()='Add']");
	
	public ContactsNPFPage(WebDriver contactsNpfDriver)
	{
		this.driver = contactsNpfDriver;
		elem_act = new Element_Actions_Utility(contactsNpfDriver);
//		PageFactory.initElements(contactsNpfDriver, this); here not required as we are using NPF locators pattern
	}
	
	public void addAContact(String emailId,String fName,String lName,String phNum)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);//here we are writing ExplicitWAit
		wait.until(ExpectedConditions.elementToBeClickable(addOneContact));
		elem_act.clickUtil(addOneContact);
		
		wait.until(ExpectedConditions.elementToBeClickable(e_mail));
	elem_act.sendKeysMethod(e_mail, emailId);
		
		wait.until(ExpectedConditions.elementToBeClickable(first_Name));
		elem_act.sendKeysMethod(first_Name, fName);
//		firstName.sendKeys(fName);
		
		wait.until(ExpectedConditions.elementToBeClickable(last_Name));
		elem_act.sendKeysMethod(last_Name, lName);
		
		wait.until(ExpectedConditions.elementToBeClickable(phone_Number));
		elem_act.sendKeysMethod(phone_Number, phNum);
		
		wait.until(ExpectedConditions.elementToBeClickable(finalAdd));
		elem_act.clickUtil(finalAdd);
	}

}
