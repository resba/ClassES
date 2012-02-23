package com.thenetdev.Examples;

import com.thenetdev.Commons.Keyboard;
import java.text.NumberFormat;

public class Constants {
	
	public static final double BURGER = 1.99;
	public static final double FRIES = 1.29;
	public static final double SODA = 0.99;
	
	public static void main(String[] args)
	{
		int b; // # of burger
		double t; // Total for order
		System.out.print("Enter the number of hamburgers: ");
		b = Keyboard.readInt();
		
		// FRIES AND SODA STOOF :D
		
		t = b * BURGER;
		
		t = t * 1.06;
		
		NumberFormat m = NumberFormat.getCurrencyInstance();
		
		System.out.println("Total: "+m.format(t));
		
	}
	
}
