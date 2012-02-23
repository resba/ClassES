package com.thenetdev.Commons;

public class SafeCharacter {
	
	public static String safeAlphaNumeric(String input)
	{
	    char[] allowed = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    char[] charArray = input.toString().toCharArray();
	    StringBuilder result = new StringBuilder();
	    for (char c : charArray)
	    {
	        for (char a : allowed)
	        {
	            if(c==a) result.append(a);
	        }
	    }
	    return result.toString();
	}
	
	public static String safeAlphabetic(String input)
	{
	    char[] allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    char[] charArray = input.toString().toCharArray();
	    StringBuilder result = new StringBuilder();
	    for (char c : charArray)
	    {
	        for (char a : allowed)
	        {
	            if(c==a) result.append(a);
	        }
	    }
	    return result.toString();
	}
	public static String safeNumeric(String input)
	{
	    char[] allowed = "0123456789".toCharArray();
	    char[] charArray = input.toString().toCharArray();
	    StringBuilder result = new StringBuilder();
	    for (char c : charArray)
	    {
	        for (char a : allowed)
	        {
	            if(c==a) result.append(a);
	        }
	    }
	    return result.toString();
	}

}
