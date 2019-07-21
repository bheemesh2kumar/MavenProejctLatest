package Com.FirstAutomation.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigUtility {

	public Properties prop;
	
	        public static int globalwaitMax=50000;
			public static int globalwaitMed=30000;
			public static int globalwaitMin=15000;

	public ReadConfigUtility()  {
		
		try{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/home/git/MavenProejctLatest/MavenProject/Configurations/Applications.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
	}

	
	public String getApplicationurl()
	{
		String url=prop.getProperty("Applcation.url");
		return url;
	}
	
	
	
	public String getUserName()
	{
		String UserName=prop.getProperty("UserName");
		return UserName;
	}
	
	public String getPassward()
	{
		String Passward=prop.getProperty("Passward");
		return Passward;
	}
	
	public String getBrowser()
	{
		String Browser=prop.getProperty("Browser");
		return Browser;
	}
	
	
	public String getChromekey()
	{
		String Chromekey=prop.getProperty("Chrome.key");
		return Chromekey;
	}
	
	
}
