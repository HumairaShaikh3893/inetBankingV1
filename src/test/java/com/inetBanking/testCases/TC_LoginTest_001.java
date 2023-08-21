package com.inetBanking.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest()
	{
		
		driver.get(baseURL);
		
		logger.info("URL i opend");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("username is entered");
		
		lp.setPassword(password);
		logger.info("Password is enterd");
		
		
		lp.clickSubmit();
		
		
		//
		/*if(driver.getTitle().equals(title))
		{
			Assert.assertTrue(true);
			logger.info("Login Pass");
			
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login fail");
			
		}*/
		
		
	}
	
	

}
