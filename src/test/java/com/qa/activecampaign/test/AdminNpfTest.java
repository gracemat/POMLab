package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.qa.activecampaign.Listeners.pdfListener;
import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.constants.ActiveCampaign_ConstantValues;
import com.qa.activecampaign.pages.AdminNPFPage;

//@Listeners(pdfListener.class)
public class AdminNpfTest 
{
	BasePage basePg;
	WebDriver driv;
	Properties pro;
	//Element_Actions_Utility elementUtil;
	AdminNPFPage adminNPFPage;
	
	@BeforeMethod
	public void setUp()
	{
		basePg = new BasePage();
		pro = basePg.properties_Initialisation();
		driv= basePg.driver_Initialisation(pro);		
		adminNPFPage = new AdminNPFPage(driv);
	}
	
	@Test
	public void verifyAdminPageTitleTest()
	{
		System.out.println(adminNPFPage.getAdminPageTitle());
		Assert.assertEquals(adminNPFPage.getAdminPageTitle(), ActiveCampaign_ConstantValues.ADMINPAGE_TITLE);
	}
	
	@Test
	public void verifyCheckBoxTest()
	{
		System.out.println(adminNPFPage.checkBoxSelection());
		Assert.assertFalse(adminNPFPage.checkBoxSelection());
	}
	
	@Test
	public void adminPageLoginTest()
	{
		//adminPage.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));
		adminNPFPage.doLogin(pro.getProperty("EmailAddress"),pro.getProperty("PassWord"));
	}
	
	@Test
	public void verifyLoginButtonLink()
	{
		System.out.println(adminNPFPage.loginButtonIsDisplayed());
		Assert.assertTrue(adminNPFPage.loginButtonIsDisplayed());
	}
	@AfterMethod
	public void tearDown()
	{
		driv.quit();
	}
	

}
