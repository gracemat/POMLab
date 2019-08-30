package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.activecampaign.Listeners.ExtentReportListener;
//import com.qa.activecampaign.Listeners.pdfListener;
import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.constants.ActiveCampaign_ConstantValues;
import com.qa.activecampaign.pages.LoginPage;

@Listeners(ExtentReportListener.class)
public class ActiveCampaign_LoginPageTest {
	WebDriver driv;
	Properties pro;
	BasePage bspg;
	LoginPage logPg;
	
	@BeforeMethod
	public void setUp()
	{
		bspg = new BasePage();
		pro = bspg.properties_Initialisation();
		driv = bspg.loginPage_driver_Initialisation(pro);	
		logPg = new LoginPage(driv);
	}
	/**
	 * This method is to verify the Login Process
	 */
	@Test
	public void verifyAccountLogin()
	{
		logPg.LogInMethod(pro.getProperty("Accountname"));
	}
	/**
	 * This method is used to  get LoginPAge Title
	 */
	@Test(priority = 1)
	public void verifyLoginPageTitle()
	{
		String title = logPg.getLoginPageTitle();
		System.out.println(title + "<--This is the title");
		Assert.assertEquals(title, ActiveCampaign_ConstantValues.ACTIVECAMPAIGN_LOGINPAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyForgotAccLinkDisplay()
	{
		Assert.assertTrue(logPg.forgotAccLinkDisplay());
	}
	
	@Test 
	public void incorrectUserDetails()
	{
		//logPg.
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driv.quit();
	}
}
