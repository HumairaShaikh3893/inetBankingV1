package com.inetBanking.testCases;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.*;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 

{

	//now the actual test will take the data from the dataprovider method and pass the values
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		driver.get(baseURL);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			//in invalid data case
			driver.switchTo().alert().accept();//it will close the alert
			driver.switchTo().defaultContent();//it will ewturn back to the login page
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			
			lp.clickLogout();
			driver.switchTo().alert().accept();//it will close the popup after logout
			driver.switchTo().defaultContent();//will get back to the login page again
			
		}
	}
	
	
	
	
	//create user define method in case of alerts handling after valid and invalid case
	
	public boolean isAlertPresent()
	{
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		
		String path="C:\\Users\\habib\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", rownum);
		
		String loginData[][]=new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++)  //---> i representing the row number
		{
			for(int j=0;j<colcount;j++)//---> i representing the column number

			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				//here i-1 will be the value of excel sheet's first row,we are skipping this thats why we minus 1 from the row
				//means [i-1] it will directly how the 0th row and value will get as [1][0]
			}
		}
		return loginData;
		
		
	}
	
	
}
