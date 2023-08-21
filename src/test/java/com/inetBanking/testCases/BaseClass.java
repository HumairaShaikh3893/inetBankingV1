package com.inetBanking.testCases;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	//to call the methods create in the readconfig class we have to create a object of readconfig class
	
	ReadConfig readconfig=new ReadConfig();
	
	
	
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getApplicationUname();
	public String password=readconfig.getApplicationPwd();
	public static WebDriver driver;
	
	public String text=readconfig.getPageText();
	public static Logger logger;
	
//add setup and teardown method as it will be common for all the test cases,like method to call before class
	//and after class
	
	
	//parameter annotation is used to take the different parametrs fromxml file
	//to run the testcase on desire browser
	
	@Parameters("browser")//here in setup method browser will be the parameter as br
	@BeforeClass

	public void setUp(String br)
	{
		
		//property file configuration
		logger=Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("log4j.properties");
		
		//to invoke the browser
		
		if (br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
	
		driver=new ChromeDriver();
		}else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfoxPath());
			
			driver=new FirefoxDriver();
		}
		else if (br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getiePath());
			
			driver=new EdgeDriver();
		}
		
	
		
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
