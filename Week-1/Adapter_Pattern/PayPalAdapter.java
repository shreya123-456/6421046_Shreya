package com;

public class PayPalAdapter implements PaymentProcessor {
	private PayPalGateway paypal;
	
	public PayPalAdapter(PayPalGateway paypal) {
		this.paypal=paypal;
	}
	
	public void processPayment(double amount) {
		paypal.SendPayment(amount);
	}
}
