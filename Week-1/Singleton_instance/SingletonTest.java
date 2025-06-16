package com.example.logger;

public class SingletonTest {
	
	    public static void main(String[] args) {
	        // instance1
	        Logger logger1 = Logger.getInstance();
	        logger1.log("First log message");
	        
	        // instance2
	        Logger logger2 = Logger.getInstance();
	        logger2.error("First error message");
	        
	        // Verify both references point to the same object
	        if (logger1 == logger2) {
	            System.out.println("Both logger instances are the same - Singleton works!");
	        } 
	        else {
	            System.out.println("Different instances created - Singleton failed!");
	        }
	        
	    }
}
