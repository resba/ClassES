// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Keyboard.java

package com.thenetdev.Commons;

import java.io.*;
import java.util.StringTokenizer;

public class Keyboard
{

    public Keyboard()
    {
    }

    public static int getErrorCount()
    {
        return errorCount;
    }

    public static void resetErrorCount(int i)
    {
        errorCount = 0;
    }

    public static boolean getPrintErrors()
    {
        return printErrors;
    }

    public static void setPrintErrors(boolean flag)
    {
        printErrors = flag;
    }

    private static void error(String s)
    {
        errorCount++;
        if(printErrors)
            System.out.println(s);
    }

    private static String getNextToken()
    {
        return getNextToken(true);
    }

    private static String getNextToken(boolean flag)
    {
        String s;
        if(current_token == null)
        {
            s = getNextInputToken(flag);
        } else
        {
            s = current_token;
            current_token = null;
        }
        return s;
    }

    private static String getNextInputToken(boolean flag)
    {
        String s = null;
        try
        {
            if(reader == null)
                reader = new StringTokenizer(in.readLine(), " \t\n\r\f", true);
            for(; s == null || " \t\n\r\f".indexOf(s) >= 0 && flag; s = reader.nextToken())
                while(!reader.hasMoreTokens()) 
                    reader = new StringTokenizer(in.readLine(), " \t\n\r\f", true);

        }
        catch(Exception exception)
        {
            s = null;
        }
        return s;
    }

    public static boolean endOfLine()
    {
        return !reader.hasMoreTokens();
    }

    public static String readString()
    {
        String s;
        try
        {
            for(s = getNextToken(false); !endOfLine(); s = s + getNextToken(false));
        }
        catch(Exception exception)
        {
            error("Error reading String data, null value returned.");
            s = null;
        }
        return s;
    }

    public static String readWord()
    {
        String s;
        try
        {
            s = getNextToken();
        }
        catch(Exception exception)
        {
            error("Error reading String data, null value returned.");
            s = null;
        }
        return s;
    }

    public static boolean readBoolean()
    {
        String s = getNextToken();
        boolean flag;
        try
        {
            if(s.toLowerCase().equals("true"))
                flag = true;
            else
            if(s.toLowerCase().equals("false"))
            {
                flag = false;
            } else
            {
                error("Error reading boolean data, false value returned.");
                flag = false;
            }
        }
        catch(Exception exception)
        {
            error("Error reading boolean data, false value returned.");
            flag = false;
        }
        return flag;
    }

    public static char readChar()
    {
        String s = getNextToken(false);
        char c;
        try
        {
            if(s.length() > 1)
                current_token = s.substring(1, s.length());
            else
                current_token = null;
            c = s.charAt(0);
        }
        catch(Exception exception)
        {
            error("Error reading char data, MIN_VALUE value returned.");
            c = '\0';
        }
        return c;
    }

    public static int readInt()
    {
        String s = getNextToken();
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch(Exception exception)
        {
            error("Error reading int data, MIN_VALUE value returned.");
            i = 0x80000000;
        }
        return i;
    }

    public static long readLong()
    {
        String s = getNextToken();
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        catch(Exception exception)
        {
            error("Error reading long data, MIN_VALUE value returned.");
            l = 0x8000000000000000L;
        }
        return l;
    }

    public static float readFloat()
    {
        String s = getNextToken();
        float f;
        try
        {
            f = (new Float(s)).floatValue();
        }
        catch(Exception exception)
        {
            error("Error reading float data, NaN value returned.");
            f = (0.0F / 0.0F);
        }
        return f;
    }

    public static double readDouble()
    {
        String s = getNextToken();
        double d;
        try
        {
            d = (new Double(s)).doubleValue();
        }
        catch(Exception exception)
        {
            error("Error reading double data, NaN value returned.");
            d = (0.0D / 0.0D);
        }
        return d;
    }

    private static boolean printErrors = true;
    private static int errorCount = 0;
    private static String current_token = null;
    private static StringTokenizer reader;
    private static BufferedReader in;

    static 
    {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
}
