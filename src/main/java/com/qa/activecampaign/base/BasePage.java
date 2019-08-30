package com.qa.activecampaign.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.activecampaign.utilities.Time_Utility_ActiveCampaign;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * author = Greeshma
 */
public class BasePage {
	public  WebDriver driver;
	public  Properties prop;
	//with ThreadLocal concept driver will remain the same always
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();//ThreadLocal class will generate a common copy of driver
	
	/**
	 * This method is used to initialise the driver
	 * @return driver
	 */
	public  WebDriver driver_Initialisation(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		tldriver.set(new ChromeDriver());
		}
		else if(browserName.equals("firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());	//with threadLocal concept driver will remain everywhere the same		
		}
		else
		{
			System.out.println("Browser Name" +browserName + " is not mentioned properly");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		getDriver().get(prop.getProperty("url"));
		Time_Utility_ActiveCampaign.mediumTimeWait();//I missed writing this previously
		return getDriver();
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
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		getDriver().get(prop.getProperty("loginurl"));
		//Time_Utility_ActiveCampaign.mediumTimeWait();//I missed writing this previously
		return getDriver();
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
	//Take a screenshot method in ExtentReportListener
	//to avoid Null pointer error for driver which is not initialised, we need to create getDriver method or use Thread Local concept
	public String getScreenshot()
	{
		File scrnShot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);//TakesScreenshot is an Interface and use getScreenshotAs method
		String  path = System.getProperty("user.dir")+"/screenshots/"+ System.currentTimeMillis() + ".png";//user.dir = ur project folder /screenshots filewith current time filename
		File destination =	new File(path);//destination is ur file with the given path
		try {
			FileUtils.copyFile(scrnShot, destination);
		} catch (IOException e) {
		//	e.printStackTrace();
		System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}
	
	//tldriver is a copy of driver which will be shared across the same
	  public static synchronized WebDriver getDriver()//always set the driver and get the driver
	  { 
	  return tldriver.get();
	  }
	 
	
	
}
