package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties properties ;	
	
	// Constructor for instanciate properties variable/object 
	public ReadConfig() {
	
	 properties = new Properties();
	String path = ("config.properties");
	//to open config.properties file in input mode and load the file  
	try {
		FileInputStream input = new FileInputStream(path);
		 properties.load(input);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}	
	
	public String getbrowser () {
	String value = properties.getProperty("browser"); 
	return value ;
	}
	}
	
	
	
	

