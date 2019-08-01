package com.qa.activecampaign.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * author = Greeshma
 */
public class BasePage {
	public WebDriver driver;
	public Properties prop;
	
	
	/**
	 * This method is used to initialise the driver
	 * @return driver
	 */
	public WebDriver driver_Initialisation(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		else
		{
			System.out.println("Browser Name" +browserName + " is not mentioned properly");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		Time_Utility_ActiveCampaign.mediumTimeWait();//I missed writing this previously
		return driver;
	}
	/**
	 * This method is used to get Loginpage details
	 * @param prop
	 * @return
	 */
	//We can reduce the code by checking with if-else too
	public WebDriver loginPage_driver_Initialisation(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		else
		{
			System.out.println("Browser Name" +browserName + " is not mentioned properly");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("loginurl"));
		Time_Utility_ActiveCampaign.mediumTimeWait();//I missed writing this previously
		return driver;
	}
	/**
	 * This method is used to Initialise the properties file
	 * @return properties object
	 */
	public Properties properties_Initialisation()
	{
		prop = new Properties();
		FileInputStream fis;
			try {
				fis = new FileInputStream("C:\\Users\\prave\\eclipse-workspace\\POMLab\\src\\main\\java\\com\\qa\\activecampaign\\configuration\\config.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop;
	}

}
