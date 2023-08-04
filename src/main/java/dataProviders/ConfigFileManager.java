package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {
	
	private Properties properties;
	
	public ConfigFileManager() throws IOException {
		String Path = "ConfigDetails/Configurations.properties";
		String Path1 = "ConfigDetails/ContentConfig.properties";
	//String[] names = new String[]{"ConfigDetails/ContentConfig.properties","ConfigDetails/Configurations.properties"};
		
		try {
			//for (String name : names) {
		//FileInputStream Locator = new FileInputStream(name);
		properties = new Properties();
		
			//properties.load(Locator);
		properties.load(new FileInputStream(new File(Path)));
		properties.load(new FileInputStream(new File(Path1)));
		
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public String  getData(String ElementName) {
		
		String data = properties.getProperty(ElementName);
		if(data!=null)
		return data;
		else throw new RuntimeException("DriverPath is not specified in the Configurations.properties file");
		
	}

}
