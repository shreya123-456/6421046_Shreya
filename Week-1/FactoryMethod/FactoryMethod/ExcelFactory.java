package com.FactoryMethod;

public class ExcelFactory  extends DocumentFactory{
	@Override
    public Document createDocument() {
        return new ExcelDocument();
    }
    
    @Override
    public void about() {
        System.out.println("Excel Document Factory");
    }
}
