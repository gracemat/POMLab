package com.qa.activecampaign.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.constants.ActiveCampaign_ConstantValues;
import com.qa.activecampaign.utilities.Element_Actions_Utility;
import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

import io.qameta.allure.Step;

public class AdminNPFPage extends BasePage {
	Element_Actions_Utility elemAct;
	By emailaddress = By.id("user");
	By password = By.id("pass");
	By checkbox = By.id("rmu");
	By loginButton = By.cssSelector("#log_user > div.ac_login-lower.cf > input");
	
	public AdminNPFPage(WebDriver driver)
	{
		this.driver = driver;
		elemAct = new Element_Actions_Utility(driver);
	}
	
	@Step("getting the AdminPage Title and retuning the title step .....")
	public String getAdminPageTitle()
	{
		elemAct.waitForTitle(ActiveCampaign_ConstantValues.ADMINPAGE_TITLE);
		return	elemAct.getTitleUtil();
	}
	@Step("Loginbutton displayed boolean value true for isDisplayed ")
	public boolean loginButtonIsDisplayed() 
	{
		return elemAct.elementIsDisplayedUtil(loginButton);
		
	}
		/**
		 * This method is used for checkBox selection
		 * @return boolean value of isSelected method
		 */
@Step("Is Checkbox selected and returning boolean value step..")
	public boolean checkBoxSelection()
	{
		return elemAct.isSelectedUtil(checkbox);
	}
	/**This method is used for loggingin wihtout PageFactory
	 * 
	 * @param email
	 * @param pwd
	 * @return OverviewPage
	 */
	@Step("logging with : {0} and {1}")
	public OverviewNPFPage doLogin(String email,String pwd)
	{
		System.out.println("Here the User details are "+email +"*-*"+pwd);
		//emailaddress.sendKeys(email); PageFactory
		elemAct.sendKeysMethod(emailaddress, email);
		elemAct.sendKeysMethod(password, pwd);
		elemAct.clickUtil(loginButton);
		Time_Utility_ActiveCampaign.shortTimeWait();//After Pagechaining we added this step
		return new OverviewNPFPage(driver);//creating an object for pagechaining also
	}

}
