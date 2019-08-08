package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.pages.AdminNPFPage;
import com.qa.activecampaign.pages.ContactsNPFPage;
import com.qa.activecampaign.pages.OverviewNPFPage;

public class ContactsNPFTest {
	BasePage basePage;
	WebDriver driver;
	Properties properties;
	AdminNPFPage adminNpfPg;
	OverviewNPFPage overviewNpfPg;
	ContactsNPFPage contactsNpfobj;
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		properties = basePage.properties_Initialisation();
		driver = basePage.driver_Initialisation(properties);
		adminNpfPg = new AdminNPFPage(driver);
		overviewNpfPg = adminNpfPg.doLogin(properties.getProperty("EmailAddress"), properties.getProperty("PassWord"));
		contactsNpfobj = overviewNpfPg.goToContactsPage();
	}
	
		
	@Test
	public void createNewContactTest()
	{
		contactsNpfobj.addAContact("greeshmahere@gmail.com", "Ishitha", "Iyer","9008007001");
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
