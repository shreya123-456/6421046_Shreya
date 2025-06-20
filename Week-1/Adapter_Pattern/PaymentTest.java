package com;

public class PaymentTest {
	public static void main(String[] args) {
	PayPalGateway payPal = new PayPalGateway();
    StripeGateway stripe = new StripeGateway();
    
    // Create adapters
    PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
    PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
    
    // Process payments using the common interface
    System.out.println("Processing payments through adapters:");
    payPalAdapter.processPayment(100.50);
    stripeAdapter.processPayment(75.25);
}
}
