package com.thenetdev.Examples;
/**
 * 
 * Everyone loves And OR Not. LOGICAL OPERATOR EXCERCISE.
 * 
 * @author Matthew Sowden
 *
 */
public class AndOrNot {

	public static void ex()
	{
		int n1 = 1, n2 = 2, n3 = 3;
		
		if(n1 == 1 || n2 == 2 || n3 == 1)
		{
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
		if(n1 == 1 && n2 == 2 && n3 == 1)
		{
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		
	}
	
}
