package com.qa.activecampaign.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.activecampaign.base.BasePage;

public class Element_Actions_Utility extends BasePage {
	
	BasePage basePage = new BasePage();
	public Element_Actions_Utility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver getDriverUtil() 
	{
		return basePage.driver_Initialisation(prop);
	}
	/**
	 * This method returns the titl of the page Utility method
	 * @return
	 */
	public String getTitleUtil() 
	{
		String pAgeTitle = null;
		try 
		{
		 pAgeTitle= driver.getTitle();
		}
	catch(Exception e)
		{
		System.out.println("Driver is not found");
		}
		return pAgeTitle;
	}
	public WebElement getElement(By locator)
	{	
		WebElement element = null;
		try {
		element = driver.findElement(locator);
		}
	catch (Exception e) {
		System.out.println("Exception during creating an element");	}
		return element;
	}
	/**
	 * This method returns the Text of that particular Webelement associated with the locator
	 * @param locator
	 * @return
	 */
	public String getTextUtil(By locator)
	{
		return getElement(locator).getText();
	}
	/**
	 * This method is used to get current URL where the driver is on 
	 * @return
	 */
	public String getUrlUtility() 
	{
		//Time_Utility_ActiveCampaign.longTimeWait();
		return driver.getCurrentUrl();
	}
	public void waitForElement(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	/**
	 * This method waits for title using WebDriverWait class object and calling ExpectedConditions.titleContains method
	 * @param title
	 */
	public void waitForTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 11);
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	/**
	 * This method helps us to know wether the element is displayed or not
	 * @param locator
	 * @return true/False
	 */
	public boolean elementIsDisplayedUtil(By locator) 
	{
		waitForElement(locator);
	return getElement(locator).isDisplayed();
	}
	
	public void sendKeysMethod(By locator,String keyValue)
	{
		getElement(locator).sendKeys(keyValue);
	}
	
	public boolean isSelectedUtil(By locator) 
		{
		return getElement(locator).isSelected();
		}
	
	public void clickUtil(By locator) 
	{
	getElement(locator).click();
	}
	
}
