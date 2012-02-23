package com.thenetdev.Examples;

import com.thenetdev.Commons.Keyboard;

/**
 * Uh. Yeah.
 * 
 * 
 * @author Matt Sowden
 *
 */

public class DoExample {
	
	public static void main(String[] args)
	{
		String word;
		char again;
		
		
		do
		{
			System.out.print("Enter a Word: ");
			word = Keyboard.readString();
			
			for(int i=0; i < word.length(); i++)
			{
				//code
			}	
			again = Keyboard.readChar();	
			
		}while(again == 'y');
	}

}
