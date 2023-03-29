package org.api.utils;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static Utils manager;
    private static final Properties prop = new Properties();


    private Utils()
    {
        try {
           // InputStream inputStream = Utils.class.getResourceAsStream("/config.properties");
            FileReader reader= new FileReader("config.properties");
            prop.load(reader);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public static Utils getInstance()
    {
        if (manager == null)
        {
            synchronized (Utils.class)
            {
                manager = new Utils();
            }
        }

        return manager;
    }

    public String property(String key)
    {
        return System.getProperty(key, prop.getProperty(key));
    }
}
