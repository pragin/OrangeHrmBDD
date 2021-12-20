package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp {

    static Properties properties = new Properties();
    static FileInputStream input;
    static String propertiesFileLocation = "src/test/java/TestConfig/testData.properties";

    public String getProperty(String key) {

        try {
            input = new FileInputStream(propertiesFileLocation);
            properties.load(input);
            input.close();
        } catch (IOException ioe) {

        }
        return properties.getProperty(key);
    }
}
