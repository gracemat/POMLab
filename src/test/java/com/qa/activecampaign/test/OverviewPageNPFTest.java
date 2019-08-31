package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.activecampaign.Listeners.ExtentReportListener;
import com.qa.activecampaign.Listeners.TestAllureListener;
//import com.qa.activecampaign.Listeners.pdfListener;
import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.constants.ActiveCampaign_ConstantValues;
import com.qa.activecampaign.pages.AdminNPFPage;
import com.qa.activecampaign.pages.OverviewNPFPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Epic("Epic - Active Campaign OverviewPage Module")
@Feature("AC- 102 after Logging Feature of Overview page")
@Listeners(TestAllureListener.class)
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
	@Description("Positive Testing- Testing URL")
	@Severity(SeverityLevel.NORMAL)
	public void verifyUrlTest()
	{
		System.out.println(overviewNpf.getUrl());
		Assert.assertEquals(overviewNpf.getUrl(), ActiveCampaign_ConstantValues.OVERVIEW_PAGE_URL);
	}
	
	@Test
	@Description("Positive Testing- Testing UserName")
	@Severity(SeverityLevel.NORMAL)
	public void verifyUserNameTest()
	{
		System.out.println(overviewNpf.giveUserName());
		Assert.assertEquals(overviewNpf.giveUserName(),ActiveCampaign_ConstantValues.USERNAME);
	}
	@Test
	@Description("Positive Testing- Testing Username display")
	@Severity(SeverityLevel.MINOR)
	public void veryUserNameisDisplayed()
	{
		System.out.println(overviewNpf.userNameIsdisplayed());
		Assert.assertTrue(overviewNpf.userNameIsdisplayed());
	}
	@Test
	@Description("Positive Testing- Testing OverviewPage title")
	@Severity(SeverityLevel.CRITICAL)
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
