package com.FactoryMethod;

public class WordFactory extends DocumentFactory {
	    @Override
	    public Document createDocument() {
	        return new WordDocument();
	    }
	    
	    @Override
	    public void about() {
	        System.out.println("Word Document Factory");
	    }
}
