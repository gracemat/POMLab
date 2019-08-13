package com.qa.activecampaign.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.qa.activecampaign.Listeners.pdfListener;
import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.pages.AdminPage;
import com.qa.activecampaign.pages.ContactsPage;
//import com.qa.activecampaign.pages.LoginPage;
import com.qa.activecampaign.pages.OverviewPage;

//@Listeners(pdfListener.class)
public class ContactsPageTest {
	BasePage bspg;
	Properties p;
	WebDriver d;
	AdminPage admin;
	OverviewPage overpg;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp()
	{
		bspg = new BasePage();
		p = bspg.properties_Initialisation();
		d= bspg.driver_Initialisation(p);
		admin = new AdminPage(d);
		overpg = admin.doLogin(p.getProperty("EmailAddress"), p.getProperty("PassWord"));
		contactsPage = overpg.goToContactsPage();//Page chaining LoginPAge to OverviewPage and OverviewPAge to ContactsPAge
	}
	
	@Test
	public void addAContactTest()
	{
		contactsPage.addAContact("Ishitha@gmail.com", "Ishitha", "Iyer", "9004007001");
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
