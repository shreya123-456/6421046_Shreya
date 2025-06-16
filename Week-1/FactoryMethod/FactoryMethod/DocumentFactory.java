package com.FactoryMethod;

public abstract class DocumentFactory {
    
    public abstract Document createDocument();
    
    public void about() {
        System.out.println(" Welcome To Document Factory");
    }
}
