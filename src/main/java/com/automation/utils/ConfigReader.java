package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        // load config.properties (Loading configuration file )
    	try {
            properties = new Properties();

            InputStream input =
                    ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
		
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
