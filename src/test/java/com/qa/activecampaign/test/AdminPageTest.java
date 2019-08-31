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
import com.qa.activecampaign.pages.AdminPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//@Listeners(pdfListener.class)
@Epic("Epic ActiveCampaign AdminPage test")
@Feature("AC - 101 With PageFactory")
public class AdminPageTest {
	WebDriver driver;
	Properties properties;
	BasePage basepage;
	AdminPage adminPage;
	
	@BeforeMethod
	public void setUp()
	{
		basepage = new BasePage();
		properties = basepage.properties_Initialisation();
		driver = basepage.driver_Initialisation(properties);
		adminPage = new AdminPage(driver);
	}

	@Test 
	@Description("AdminPAge Title Test - Positive Test case ")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyAdminPageTitleTest()
	{
		String title = adminPage.getAdminPageTitle();
		System.out.println(adminPage.getAdminPageTitle());
		Assert.assertEquals(title, ActiveCampaign_ConstantValues.ADMINPAGE_TITLE);
	}
	@Test(priority =1)
	@Description("AdminPAge Login Test - Positive Test case ")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest()
	{
		adminPage.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));
		String overviewPageTile = driver.getCurrentUrl();
		System.out.println("Next Page URL is :: "+overviewPageTile);
		Assert.assertEquals(overviewPageTile, ActiveCampaign_ConstantValues.OVERVIEW_PAGE_URL);
	}
	/*
	 * @Test(priority=3) public void checkingWithWrongCredentialsTest() { // String
	 * errorMsgText = adminPage.negativeTestCase("greeshmahere@gmail.com",
	 * "L0g!nnow"); // System.out.println(errorMsgText); //
	 * //*[@id="log_user"]/div[1]/text()
	 * //adminPage.doLogin("greeshmahere@gmail.com", "L0g!nnow");
	 * Assert.assertTrue(adminPage.negativeTestCase("greeshmahere@gmail.com",
	 * "L0g!nnow","Invalid username or password. Forgot your password? Reset it"));
	 * 
	 * }
	 */
	
	@Test(priority = 2)
	public void verifyCheckBoxSelectionTest()
	{
		System.out.println(adminPage.checkBoxSelection());
		Assert.assertFalse(adminPage.checkBoxSelection());
	}
	@Test
	public void verifyLoginButtonLink()
	{
		System.out.println(adminPage.loginButtonisDisplayed());
		Assert.assertTrue(adminPage.loginButtonisDisplayed());
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
