package com.pack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main2 {
	
	static final Logger logger=Logger.getLogger(Main2.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
PropertyConfigurator.configure("log1.properties");//log all messages in properties file 
		
		logger.debug("Sample debug Message");
		logger.info("Sample infor message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
		
		

	}

}
