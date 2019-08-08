package com.qa.activecampaign.pages;




	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.qa.activecampaign.base.BasePage;
	import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

	public class LoginPage extends BasePage {
		//PageFactory or PageObjects
		@FindBy(id = "accountname")
		WebElement accountName;
		
		@FindBy(css = "#loginform > p > a")
		WebElement forgotAccName;
		
		@FindBy(css= "#loginform > input")//#loginform > input  //After css selections path lesson check it again
		WebElement loginButton;
		
		@FindBy(xpath="//*[@id='domain']/a/span/text()") //New Xpath Keep this in mind
		WebElement activeHosted;
		
		//Constructor
		public LoginPage(WebDriver driver)
		{
			this.driver = driver;//parent class driver= local class driver
			PageFactory.initElements(driver, this);//PageFactory methods are used to activate WebElements
			//BasePage basePg = new BasePage();
		}
		
		//Page Actions
		
		public String getLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public OverviewPage LogInMethod(String accName) {
			System.out.println("UserDetails:"+accName);
			accountName.sendKeys(accName);
			loginButton.click();
			//Time_Utility_ActiveCampaign.shortTimeWait();
			return new OverviewPage(driver);
		}
		
		public boolean forgotAccLinkDisplay()
		{
			return forgotAccName.isDisplayed();
		}
		
		public boolean activeHostedEnability()
		{
			return activeHosted.isEnabled();
		}
		

	}


