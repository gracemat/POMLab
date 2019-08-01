package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.constants.ActiveCampaign_ConstantValues;
import com.qa.activecampaign.pages.AdminPage;
import com.qa.activecampaign.pages.OverviewPage;
import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

public class OverViewPageTest {
	WebDriver driv;
	Properties properties;
	BasePage basePage;
	AdminPage adminPage;
	OverviewPage overviewPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.properties_Initialisation();
		driv = basePage.driver_Initialisation(properties);
		adminPage = new AdminPage(driv);
		overviewPage = adminPage.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));// PAGE
																														// CHAINING
		// Time_Utility_ActiveCampaign.longTimeWait();
		// overviewPage = loginPage.LogInMethod(properties.getProperty("Accountname"));
	}

	@Test
	public void Verify_Url_Test() {
		Assert.assertEquals(overviewPage.getUrl(), ActiveCampaign_ConstantValues.OVERVIEW_PAGE_URL);
	}

	@Test
	public void verify_OverviewPageTitle_Test() {
		String overviewTitle = overviewPage.getOverViewPageTitle();
		System.out.println("OverviewPage Title is :: " + overviewTitle);
		Assert.assertEquals(overviewTitle, ActiveCampaign_ConstantValues.OVERVIEW_PAGE_TITLE);
	}

	@Test
	public void verify_UserName_Test()//Here we are verifying two tests to make it more perfect if its not displayed test will be terminated immediately
	{
		Assert.assertTrue(overviewPage.userNameIsdisplayed());
		Assert.assertEquals(overviewPage.giveUserName(),ActiveCampaign_ConstantValues.USERNAME);
	}
	
	@Test(enabled = false)
	public void verify_settingsLink_Test()
	{
		Assert.assertTrue(overviewPage.checkSettingsLinkDisplay());
		Assert.assertEquals(overviewPage.getSettingsLinkText(),"Settings");
	}
	
	@AfterMethod
	public void tearDown() {
		driv.quit();
	}
}
