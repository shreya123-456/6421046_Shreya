package com.FactoryMethod;

public class DocumentManagementSystem {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PDFFactory();
        DocumentFactory excelFactory = new ExcelFactory();
        
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();
        
        // Test the documents
        System.out.println("\nCreated documents:");
        System.out.println(wordDoc);
        System.out.println(pdfDoc);
        System.out.println(excelDoc);
        
        System.out.println("\nTesting Word Document:");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        
        System.out.println("\nTesting PDF Document:");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        
        System.out.println("\nTesting Excel Document:");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
        
        // Demonstrate factory methods
        System.out.println("\nFactory information:");
        wordFactory.about();
        pdfFactory.about();
        excelFactory.about();
    }
}
