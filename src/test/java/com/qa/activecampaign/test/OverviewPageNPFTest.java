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
import com.qa.activecampaign.pages.OverviewNPFPage;

@Listeners(ExtentReportListener.class)
public class OverviewPageNPFTest {
	
	BasePage basePg;
	WebDriver driv;
	Properties pro;
	//Element_Actions_Utility elementUtil;
	AdminNPFPage adminNPFPage;
	OverviewNPFPage overviewNpf;
	
	@BeforeMethod
	public void setUp()
	{
		basePg = new BasePage();
		pro = basePg.properties_Initialisation();
		driv= basePg.driver_Initialisation(pro);		
		adminNPFPage = new AdminNPFPage(driv);
//		overviewPage = adminPage.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));
		overviewNpf = adminNPFPage.doLogin(pro.getProperty("EmailAddress"), pro.getProperty("PassWord"));	
	}
	@Test
	public void verifyUrlTest()
	{
		System.out.println(overviewNpf.getUrl());
		Assert.assertEquals(overviewNpf.getUrl(), ActiveCampaign_ConstantValues.OVERVIEW_PAGE_URL);
	}
	
	@Test
	public void verifyUserNameTest()
	{
		System.out.println(overviewNpf.giveUserName());
		Assert.assertEquals(overviewNpf.giveUserName(),ActiveCampaign_ConstantValues.USERNAME);
	}
	@Test
	public void veryUserNameisDisplayed()
	{
		System.out.println(overviewNpf.userNameIsdisplayed());
		Assert.assertTrue(overviewNpf.userNameIsdisplayed());
	}
	@Test
	public void verifyNpfOverviewTitle()
	{
		System.out.println(overviewNpf.getOverviewPageTitle());
		Assert.assertEquals(overviewNpf.getOverviewPageTitle(), ActiveCampaign_ConstantValues.OVERVIEW_PAGE_TITLE);
	}
	@AfterMethod
	public void tearDown()
	{
		driv.quit();
	}
}
