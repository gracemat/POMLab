package com.qa.activecampaign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.utilities.Element_Actions_Utility;


public class OverviewNPFPage extends BasePage
{
	Element_Actions_Utility elem_act;
	By contactsLocator = By.xpath("//span[@class ='ml20 item-text' ]");
	By userNameLocator =  By.xpath("//span[@class ='name']");
	By settingsLinkLocator = By.xpath("//*[@id='uxbody']/nav/div/div[3]/div/ul/li[2]/a/div/div[2]/span");
	
	//Adding these two locaors and webElements for Data Provider concept
	/*
	 * @FindBy(xpath = "//span[text()='Contacts']") WebElement contactsClick;
	 */
		
		By contactsClick = By.xpath("//span[text()='Contacts']");
		
		

	public OverviewNPFPage(WebDriver driver)
	{
		this.driver = driver;
		elem_act = new Element_Actions_Utility(driver);
	}
	
	public String getUrl()
	{
	return elem_act.getUrlUtility();
	}
	/**
	 * 
	 * @return
	 */
	public String giveUserName()
	{
	return elem_act.getTextUtil(userNameLocator);
	}
	/**
	 * By Locator pattern of using isDisplayed method
	 * @return
	 */
	public boolean userNameIsdisplayed()
	{
		//return elem_act.getElement(settingsLinkLocator).isDisplayed();
		return elem_act.elementIsDisplayedUtil(userNameLocator);
	}
	/**
	 * NPF way of getting title of the page
	 * @return
	 */
	public String getOverviewPageTitle() {
		return elem_act.getTitleUtil();
	}
	//these 2 methods got added after Excel file creation
	public void clickOnContacts() 
	{
	elem_act.clickUtil(contactsClick);		
	}
	//Page chaining and creating ContactsPageObj
	public ContactsNPFPage goToContactsPage() 
	{
		clickOnContacts();//we are landing on ContactsPage
		return  new ContactsNPFPage(driver);//returns new ContactsPageObject
	}
	
	
}
