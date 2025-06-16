package com.example.logger;

public class Logger {
	
	    // Private static instance 
	    private static Logger instance;
	    
	    // Private constructor to prevent instantiation from outside
	    private Logger() {
	        System.out.println("Logger instance created");
	    }
	    
	    public static Logger getInstance() {
	        if (instance == null) {
	            instance = new Logger();
	        }
	        return instance;
	    }
	    
	    public void log(String message) {
	        System.out.println("LOG: " + message);
	    }
	    
	    public void error(String message) {
	        System.out.println("ERROR: " + message);
	    }
	
}
