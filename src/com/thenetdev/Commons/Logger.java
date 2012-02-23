package com.thenetdev.Commons;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by: Chris G. Ward; Adapted for TheNetDev Commons by
 * Matt Sowden.
 * This file is licensed under Creative Commons BY-NC-SA 3.0
 */
public class Logger {
    private static FileWriter writer;
    private static FileWriter writer2;    
    private static boolean writing;
    public static void init()
    {
        try {
            Logger.writer = new FileWriter(System.getProperty("user.home") + System.getProperty("file.separator") + ".crumb" + System.getProperty("file.separator") + "crumb.log", true);
            Logger.writer2 = new FileWriter(System.getProperty("user.home") + System.getProperty("file.separator") + ".crumb" + System.getProperty("file.separator") + "last.log", false);
            Logger.writing = true;
        }
        catch (Exception e)
        {
            Logger.printErrorStack(e);
            Logger.severe("Could not write to log file.");
            Logger.writing = false;
        }
    }
    public static void close()
    {
        try 
        {
            if(Logger.writer != null)
            {
                Logger.writer.close();
                Logger.writer = null;
            }
            if(Logger.writer2 != null)
            {
                Logger.writer2.close();
                Logger.writer2 = null;
            }
            if(Logger.writer == null && Logger.writer2 == null)
            {
                Logger.writing = false;
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            Logger.severe("Could not close the log file stream. Attempting again.");
            Logger.printErrorStack(e);
            Logger.close();
        }
    }
    private static boolean debug = true;
    private static void log(String message)
    {
        System.out.println(message);
        if(Logger.writing)
        {
            try 
            {
                if(Logger.writer == null)
                    Logger.init();
                else
                    Logger.writer.write(new SimpleDateFormat("[d/M/y k:m:s] ").format(new Date()) + message + "\n");
                if(Logger.writer2 == null)
                    Logger.init();
                else
                    Logger.writer2.write(new SimpleDateFormat("[d/M/y k:m:s] ").format(new Date()) + message + "\n");
            }
            catch (Exception e)
            {
                Logger.printErrorStack(e);
            }
        }
    }
    public static void info(String message)
    {
        Logger.log("[INFO] " + message);        
    }
    public static void debug(String message)
    {
        if(Logger.debug)
            Logger.log("[DEBUG] " + message);
    }
    public static void warn(String message)
    {
        Logger.log("[WARNING]" + message);
    }
    public static void severe(String message)
    {
        Logger.log("[SEVERE] " + message);

    }
    public static void printErrorStack(Exception e)
    {
        Logger.severe(e.getMessage());
        for(StackTraceElement element : e.getStackTrace())
            Logger.severe(element.toString());
    }
    
    
    public static void setDebugging(boolean debugging)
    {
        Logger.debug = debugging;
    }
    public static boolean getDebugging()
    {
        return Logger.debug;
    }
}