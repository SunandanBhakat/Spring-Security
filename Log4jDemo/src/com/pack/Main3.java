package com.pack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Main3 {

	static final Logger logger = Logger.getLogger(Main3.class);

	public static void main(String[] args) {

		DOMConfigurator.configure("log2.xml");// log all messages in properties
												// file

	
		  logger.debug("Sample debug Message");
		 logger.info("Sample infor message");
		 logger.warn("Sample warn message");
		  logger.error("Sample error message");
		  logger.fatal("Sample fatal message");
		 

	}

}
