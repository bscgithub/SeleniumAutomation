package kreator.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import kreator.PageObjects.Dashboard;
import kreator.PageObjects.KreatorLandingPage;

public class BaseTest {
	
	public WebDriver driver;
	Properties globalProperties = new Properties();
	String URL;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		
//		Properties globalProperties = new Properties();
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\kreator\\resources\\GlobalData.properties");
		globalProperties.load(stream);
		
		String browser = globalProperties.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else if (browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
	}
	
	public String getKreatorURL() throws IOException
	{
		
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		String environment = globalProperties.getProperty("Environment");
		
		if(environment.equalsIgnoreCase("dev-02"))
		{
			URL = "https://kreator-dev-02.deloitteinnovation.space/";
		}
		
		else if(environment.equalsIgnoreCase("dev-01"))
		{
			URL = "https://kreator-dev-01.deloitteinnovation.space/";
		}
		
		else if(environment.equalsIgnoreCase("pre-prod"))
		{
			URL = "https://kreator-preprod.deloitteinnovation.space/";
		}
		
		else if(environment.equalsIgnoreCase("prod"))
		{
			URL = "https://kreator.deloitteinnovation.us";
		}
		
		return URL;
		
	}
	
	public Dashboard launchKreator() throws IOException
	{
		driver = initializeDriver();
		URL = getKreatorURL();
		
		driver.get(URL);
		
		/*Kreator Credentials*/
		String[] kreatorCreds = getKreatorCreds();
		String kreatorUserName = kreatorCreds[0];
		String kreatorPassword = kreatorCreds[1];
				
		/*Salesforce Connection Credentials*/
		String[] SFConnectionCreds = getSFConnectionCreds();
		String sfUserName = SFConnectionCreds[0];
		String sfPassword = SFConnectionCreds[1];
		String sfURL = SFConnectionCreds[2];
		String sfToken = SFConnectionCreds[3];
		
		KreatorLandingPage landingPage = new KreatorLandingPage(driver);
		String greetMsg = landingPage.kreatorToolLogin(kreatorUserName, kreatorPassword);
		Assert.assertTrue(greetMsg.contains(kreatorUserName),"Login not Successful");
		
		Dashboard dashboard = new Dashboard(driver);
		String connectionMessage = dashboard.SFConnection(sfUserName, sfPassword, sfURL, sfToken);
		Assert.assertEquals(connectionMessage, "Login to Salesforce Org: gc-kreator successful!", "Salesforce Connection Not Successful");
		
		return dashboard;
	}
	
	public String[] getKreatorCreds() throws IOException
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		
		String[] kreatorCreds = new String[2];
		
		kreatorCreds[0] = globalProperties.getProperty("kreatorUserName");
		kreatorCreds[1] = globalProperties.getProperty("kreatorPassword");
		
		return kreatorCreds;
	}
	
	public String[] getSFConnectionCreds() throws IOException
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		
		String[] SFConnectionCreds = new String[4];
		
		SFConnectionCreds[0] = globalProperties.getProperty("sfUserName");
		SFConnectionCreds[1] = globalProperties.getProperty("sfPassword");
		SFConnectionCreds[2] = globalProperties.getProperty("sfURL");
		SFConnectionCreds[3] = globalProperties.getProperty("sfToken");
		
		return SFConnectionCreds;
	}
	
	public String getPageNameForViewAndSearchPage() throws IOException
	{
		
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		
		String pageName = globalProperties.getProperty("pageNameForSearch");
		
		return pageName;
	}
	
	public String getFigmaPageID() throws IOException
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		
		String pageID = globalProperties.getProperty("figmaPageID");
		
		return pageID;
	}
	
	public String getFigmaAccessToken() throws IOException
	{
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");
		globalProperties.load(stream);
		
		String accessToken = globalProperties.getProperty("figmaAccessToken");
		
		return accessToken;
	}
	
	
	
}
