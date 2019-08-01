package com.qa.activecampaign.pages;

import org.jsoup.Connection.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

public class OverviewPage extends BasePage
{
	//WebDriver driv;
	//BasePage basepage;
	//LoginPage lgpg;
	
@FindBy(xpath = "//span[@class ='ml20 item-text' ]")
WebElement contacts;

      @FindBy(xpath = "//span[@class ='name']")
		WebElement userName;

	@FindBy(xpath = "//*[@id='uxbody']/nav/div/div[3]/div/ul/li[2]/a/div/div[2]/span")////span[[@class='ml20 item-text'] & [@contains,text() = 'settings']]----Work on this after xpath custom class
	WebElement settingsLink;
	
	public OverviewPage(WebDriver driver)
	{
	this.driver = driver;	
	//lgpg= new LoginPage(driv);
	PageFactory.initElements(driver, this);
	
	}
	
	//PageActions
	public String getUrl()
	{
	Time_Utility_ActiveCampaign.longTimeWait();
	return driver.getCurrentUrl();	
	}
	
	public String giveUserName()
	{
	return userName.getText();	
	}
	
	public boolean userNameIsdisplayed()
	{
		return userName.isDisplayed();
	}
	
	public boolean checkSettingsLinkDisplay()
	{
		return settingsLink.isDisplayed();
	}
	
	public String getSettingsLinkText()
	{
		return settingsLink.getText();
	}
	
	public String getOverViewPageTitle()
	{
		return driver.getTitle();
	}
	
}
