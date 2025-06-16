package com.FactoryMethod;

public class PDFDocument implements Document {
	@Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
    
    @Override
    public String toString() {
        return "PDF Document";
    }
}
