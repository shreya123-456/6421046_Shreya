package com.example.JuintDemo;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
public class CalculatorAAAPattern {
	private Calculator calc;
	@Before
	public void setup() {
		calc=new Calculator();
		System.out.println("SetUp Complete");
	}
	
	@After
	public void teardown() {
		System.out.println("Taerdown Complete");
	}
	@Test
	 public void testSubtract() {
        // Act
        int result = calc.sub(7, 4);
        System.out.println("Tested. Subtraction result is "+result);
        // Assert
        assertEquals(3, result);
    }
}
