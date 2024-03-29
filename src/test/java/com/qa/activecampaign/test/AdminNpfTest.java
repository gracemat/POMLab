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
import com.qa.activecampaign.pages.AdminNPFPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - ActiveCampaign AdminPage NonPageFactory Module")
@Feature("AC-101 :Defines the Admin page Login")
@Listeners(ExtentReportListener.class)
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
	@Description("AdminPAge Title Test - Positive Test case ")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyAdminPageTitleTest()
	{
		System.out.println(adminNPFPage.getAdminPageTitle());
		Assert.assertEquals(adminNPFPage.getAdminPageTitle(), ActiveCampaign_ConstantValues.ADMINPAGE_TITLE);
	}
	
	@Test(enabled = true)
	@Description("CheckBox Test - Positive Test case ")
	@Severity(SeverityLevel.MINOR)
	public void verifyCheckBoxTest()
	{
		System.out.println(adminNPFPage.checkBoxSelection());
		Assert.assertTrue(adminNPFPage.checkBoxSelection());
	}
	
	@Test(enabled = true)
	@Description("AdminPAge Login Test - Positive Test case ")
	@Severity(SeverityLevel.CRITICAL)
	public void adminPageLoginTest()
	{
		//adminPage.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));
		adminNPFPage.doLogin(pro.getProperty("EmailAddress"),pro.getProperty("PassWord"));
	}
	
	@Test
	@Description("AdminPAge LoginButtonDisplay Test - Positive Test case ")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoginButtonLink()
	{
		System.out.println(adminNPFPage.loginButtonIsDisplayed());
		Assert.assertTrue((adminNPFPage.loginButtonIsDisplayed()));
	}
	@AfterMethod
	public void tearDown()
	{
		driv.quit();
	}
	

}
