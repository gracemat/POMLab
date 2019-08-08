package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.pages.AdminNPFPage;
import com.qa.activecampaign.pages.ContactsNPFPage;
import com.qa.activecampaign.pages.OverviewNPFPage;
import com.qa.activecampaign.utilities.Excel_Utility;

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
	//
	@DataProvider(name = "createNewContactsData")//giving a name to** DataProvider**
	public Object[][] getContactsTestData()
	{
		Object testDataObj[][]=Excel_Utility.fetchTestData("contacts");//This method comes from ExcelUtil static method and store in 2D object array
		return testDataObj;
	}
		
	@Test(dataProvider = "createNewContactsData")//here we are passing dataProvider to test class
	public void createNewContactTest(String email,String firstName,String lastName,String phoneNumber)
	{
		contactsNpfobj.addAContact(email,firstName,lastName,phoneNumber);
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
