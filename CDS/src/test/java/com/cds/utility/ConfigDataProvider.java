package com.cds.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties P;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			P = new Properties();
			P.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load Config File...");
		}
	}
	
	
	public String getConfigData(String KeyToSearch)
	{
		return P.getProperty(KeyToSearch);
	}

	public String getBrowser()
	{
		return P.getProperty("Browser");
	}
	
	public String getURL()
	{
		return P.getProperty("URL");
	}
}
