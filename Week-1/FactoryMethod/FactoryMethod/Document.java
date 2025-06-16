package com.FactoryMethod;

public interface Document {
	//All document types share the same core operations
	    void open();
	    void save();
	    void close();
}