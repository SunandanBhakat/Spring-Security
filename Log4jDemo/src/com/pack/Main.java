package com.pack;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	static final Logger logger=Logger.getLogger(Main.class);
	public static void main(String[] args) {
		
		//BasicConfigurator.configure();//log all messages on the console,, default consoleappender, patternlayout
		PropertyConfigurator.configure("log4j.properties");//log all messages in properties file 
		
		logger.debug("Sample debug Message");
		logger.info("Sample infor message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
		
		
		/*Basic Configurator*/
		//The output contains the time elapsed from the start of the program in milliseconds,the threadName, type of logger level , class location and log messages.
		
		/*PropertyConfigurator*/
		//The rootLogger is the one that resides on the top of the logger hierarchy
		//We set its level to warn and added the console appender CAA. We use a layer called PatternLayout for console appender CAA. The pattern layer uses conversion pattern to format the message like 
		//%r--> print elapsed time in milliseconds
		//[%t]--> print the thread name
		//%p--> priority of the logging event
		//%c--> prints the className
		//%x--> used to output the nested diagnostic content associated with the thread that generated the logging event.
		//%m--> used to output the application supplied message associated with the logging event
		//%n--> outputs the platform dependent line separator character
		//%d --> used to output the date of logging event like %d{HH:mm:ss,sss}
		
		
	}

}
