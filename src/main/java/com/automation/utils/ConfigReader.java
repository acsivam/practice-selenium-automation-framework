package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.automation.exceptions.FrameworkException;

public class ConfigReader {

	private static Logger logger = LoggerUtil.getLogger(ConfigReader.class);
    private static Properties properties = new Properties();

    static {
        logger.info("Loading configuration from config.properties");
    	
        properties = new Properties();
    	try(InputStream input =
                    ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties")){
    		   			
            if(input == null) {
            	logger.error("config.properties not found.");
            	throw new FrameworkException("config.properties not found.");
            }
           
            properties.load(input);
            logger.info("Configuration loaded successfully");
            
        } catch (IOException e) {
        	logger.error("Failed to load config.properties", e);
            throw new FrameworkException("Failed to load config file", e);
        }
    	
    	
        // 2. Read environment
        String env = properties.getProperty("environment");
        logger.info("Environment : {}", env);


        // 3. Load environment file
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(env + ".properties")) {

            if (input == null) {
                throw new FrameworkException(env + ".properties not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new FrameworkException("Unable to load " + env + ".properties", e);
        }

        logger.info("Configuration loaded successfully.");
    }

    public static String getProperty(String key) {
    	String value = properties.getProperty(key);
    	if(value ==null) {
    		logger.error("Configuration key '{}' not found.", key);
    		throw new FrameworkException(
                    "Missing configuration property: : " + key);
    	}
    	
    	return value;
    }
    
    public static int getIntProperty(String key) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
        	logger.error("Configuration key '{}' contains an invalid integer.", key, e);
            throw new FrameworkException(
                    "Invalid integer value for config key: " + key, e);
        }
    }
    
    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }
}
