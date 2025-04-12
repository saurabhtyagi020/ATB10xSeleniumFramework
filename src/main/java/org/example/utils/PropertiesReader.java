package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    static String path= System.getProperty("user.dir")+"/src/test/resources/data.properties";
    public static String readKey(String key) {
        Properties prop = null;
        try {
            FileInputStream file = new FileInputStream(path);
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);

    }
}
