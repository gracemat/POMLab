package com.qa.activecampaign.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.activecampaign.base.BasePage;
import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

public class AdminPage extends BasePage
{
	@FindBy(id = "user")
	WebElement emailaddress;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(id = "rmu")
	WebElement checkbox;
	
	@FindBy(xpath = "//*[@id=\"log_user\"]/div[3]/input")//*[@id="log_user"]/div[3]/input
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"log_user\"]/div[1]/text()")
	WebElement errormsg;
	
	public AdminPage(WebDriver driver)
	{
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public String getAdminPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean checkBoxSelection()
	{
		return checkbox.isSelected();
	}
	
	public OverviewPage doLogin(String email,String pwd)
	{
		System.out.println("Here the User details are "+email +"*-*"+pwd);
		emailaddress.sendKeys(email);
		password.sendKeys(pwd);
		loginButton.click();
		Time_Utility_ActiveCampaign.shortTimeWait();//After Pagechaining we added this step
		return new OverviewPage(driver);//creating an object for pagechaining also
	}
	
	public boolean loginButtonisDisplayed()
	{
		return loginButton.isDisplayed();
	}
	
	public boolean negativeTestCase(String email,String passwd,String msg)
	{
		System.out.println("Incorrect credentials are : "+email+"/" + passwd);
		emailaddress.sendKeys(email);
		password.sendKeys(passwd);
		loginButton.click();
		Time_Utility_ActiveCampaign.longTimeWait();
		//return errormsg.toString(); //it works well with this 
		//return errormsg.getText(); //Why there is error with .getText()  The result of the xpath expression "//*[@id="log_user"]/div[1]/text()" is: [object Text]. It should be an element.
		boolean flag=false;
		//msg = errormsg.getText();
		/*
		 * if(msg.equals(errormsg.getText())) { flag = true;}
		 */
		 if(msg.equals(errormsg.toString())) { flag = true;}
		 return flag;
	}
}


/*
 * package com.qa.activecampaign.pages;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import org.openqa.selenium.support.FindBy;
 * import org.openqa.selenium.support.PageFactory;
 * 
 * import com.qa.activecampaign.base.BasePage; import
 * com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;
 * 
 * public class AdminPage extends BasePage {
 * 
 * //PageFactory or PageObjects
 * 
 * @FindBy(id = "accountname") WebElement accountName;
 * 
 * @FindBy(css = "#loginform > p > a") WebElement forgotAccName;
 * 
 * @FindBy(xpath = "//*[@id=\"loginform\"]/input") WebElement loginButton;
 * 
 * @FindBy(xpath="//*[@id='domain']/a/span/text()") //New Xpath Keep this in
 * mind WebElement activeHosted;
 * 
 * //Constructor public AdminPage(WebDriver driver) { this.driver =
 * driver;//parent class driver= local class driver
 * PageFactory.initElements(driver, this);//PageFactory methods are used to
 * activate WebElements //BasePage basePg = new BasePage(); }
 * 
 * //Page Actions
 * 
 * public String getLoginPageTitle() { return driver.getTitle(); }
 * 
 * public void LogInMethod(String accName) {
 * System.out.println("UserDetails:"+accName); accountName.sendKeys(accName);
 * loginButton.click(); //Time_Utility_ActiveCampaign.shortTimeWait(); //return
 * new OverviewPage(driver); }
 * 
 * public boolean forgotAccLinkDisplay() { return forgotAccName.isDisplayed(); }
 * 
 * public boolean activeHostedEnability() { return activeHosted.isEnabled(); }
 * 
 * 
 * }
 */