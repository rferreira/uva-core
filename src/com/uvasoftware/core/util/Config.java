package com.uvasoftware.core.util;

import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Properties;



import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import com.uvasoftware.core.SIFObjectName;

/**
 * Helper classes that handles loading and unloading of system and custom properties
 * All properties can be overwritten via system properties.
 *
 * This class loads properties in the following order:
 * 1) From the built in uva.properties shipped with the jar (defaults)

 *
 * @author <a href="http://uvasoftware.com">Uva Software</a>
 */
public class Config {

	private static Logger log = Logger.getLogger(Config.class);
	private Properties properties = new Properties();
	private final static String CLASSNAME_PREFIX = "uva.core.classmap.";

	private static Config instance = new Config();

	/** 
	 * Loads the base and user properties if it has not already been done
	 *
	 * */
	private Config() {

		loadBaseProperties();
		banner();

	}

	/**
	 * Returns the config instance - please note this is a singleton instance
	 */
	public static Config getInstance() {
		return (instance);
	}

	/**
	 * Returns a copy of the config wrapped up in a nice properties object 
	 */
	public Properties getProperties() {
		return (Properties) (properties.clone());
	}

	private void loadBaseProperties() {

		URL config = this.getClass().getClassLoader().getResource(
				ConfigConstants.CONFIG_FILE);


		try {

			properties.load(config.openStream());
			
			/*
			 * Configuring LOG4J
			 */
			PropertyConfigurator.configure(config);
			
			
		} catch (Exception e) {
			System.out.println("Generic error loading configuration file: "
					+ ConfigConstants.CONFIG_FILE);
			e.printStackTrace();
			System.exit(1);

		}

		
		log.info(String.format("...UVA CORE INIT (v%s)...",
				get(ConfigConstants.VERSION)));
	}

	/**
	 * Loads custom agent configuration from an input stream 
	 * @param ins the input stream containing the configuration to be used
	 * @throws IOException 
	 */
	public void load(InputStream ins) throws IOException {

		try {
			properties.load(ins);
		} catch (IOException e) {

			log.error("Error loading custom custom properties", e);
			throw (e);
		}

	}

	/**
	 * Loads custom agent configuration from an input stream 
	 * @param ins the properties containing the configuration to be used
	 */
	public void load(Properties props) throws Exception {
		try {
			properties.putAll(props);
		} catch (Exception e) {

			log.error("Error loading custom custom properties", e);
			throw (e);
		}

	}

	/**
	 * Loads custom agent configuration from a string that represents the name of a file
	 * @param location the name of the file containing the agent configuration
	 * @throws Exception
	 */
	public void load(String location) throws Exception {
		load(new FileInputStream(location));

	}

	public void banner() {

		System.out.println("====================================================");
		System.out.println("                   " + get(ConfigConstants.BANNER));
		System.out.println("====================================================");
		System.out.println();
		System.out.println("Copyright 2008 Uva Software (http://uvasoftware.com)");
		System.out.println("Licensed under the terms of the GNU GPL");
		System.out.println("Version: " + get(ConfigConstants.VERSION));
		System.out.println("Protocol support: " + get(ConfigConstants.PROTOCOL_VERSION));
		System.out.println("====================================================");

	}

	/**
	 * Returns a config entry referenced by key
	 *
	 * @param key the config entry name
	 * @return the value that matches that key
	 *
	 */
	public String get(String key) {
		// checking the system properties first
		String ret = System.getProperty(key);
		if (ret == null)
			ret = properties.getProperty(key);

		// I'm disabling this because it's too chatty 
		//log.debug(String.format("request for key [%s] returning [%s]",key,ret));

		return (ret);

	}

	/**
	 * Sets a config entry referenced by key
	 *
	 * @param key the property name
	 * @param value the value that the key will have
	 *
	 */
	public void set(String key, String value) {

		properties.setProperty(key, value);
		return;

	}

	/**
	 * Works the same way as "get" except that it throws an exception if they key does not exist<br>
	 * this is handy when querying for config entries that must exist in order for Uva Core to work
	 *
	 * @param key the config entry name
	 */
	public String getOrException(String key) throws Exception {
		String ret = get(key);
		if (ret == null) {
			throw new Exception(String.format(
					"incorrect OR missing tag [%s] in your configuration file",
					key));
		}

		return (ret);

	}

	/**
	 * Returns the class name for a specific object name or null if it can't find it 
	 * @param name the sif objectname
	 * @return the string represention for the requested class
	 */
	public String getClassMap(SIFObjectName name) {
		String ret = get(CLASSNAME_PREFIX + name.toString());

		if (ret == null) {
			log
					.fatal(String
							.format(
									"could not resolve object name %s to a class! Please check your uva.properties file",
									name.toString()));
		}

		return (ret);
	}
	
	

}
