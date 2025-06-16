package com.FactoryMethod;

public class PDFFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
    
    @Override
    public void about() {
        System.out.println("PDF Document Factory");
    }
}
