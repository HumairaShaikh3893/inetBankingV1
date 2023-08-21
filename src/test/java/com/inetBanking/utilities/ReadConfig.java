package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("C:\\Users\\habib\\eclipse-workspace\\inetBankingV1\\Configuration\\config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is" +e.getMessage());
		}
		
		
	}
	
	//creating method which will read the variable from the properties file and return in the baseclass
	public String getApplicationURL()
	{
	
		//this methood will use to run the test on the different browser
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	
	
	
	public String getApplicationUname()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	
	
	public String getApplicationPwd()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	
	public String getChromePath()
	{
		String chropath=pro.getProperty("chromepath");
		return chropath;
		
	}
	
	public String getfoxPath()
	{
		String foxpath=pro.getProperty("foxpath");
		return foxpath;
		
	}
	
	public String getiePath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
		
	}
	
	
	
	public String getPageText()
	{
		String text=pro.getProperty("text");
		return text;
		
	}
	
	
	
	
	

}
