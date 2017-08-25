package com.ccfi.ecash.ecashAutomation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesReader {

	private static final Properties properties = read();

	public Properties getProperties() {
		if (properties == null)
			read();
		return properties;
	}

	public static Properties read() {
		String propertyFileName = System.getProperty("propertiesfile");
		if (StringUtils.isEmpty(propertyFileName))
			propertyFileName = "config.properties";
		Properties props = new Properties();
		InputStream is = PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			props.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
}
