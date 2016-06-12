package com.management.student.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.management.student.constant.Constant;

/**
 * The Class PropertyUtil, utility for properties, reads the required property for the file.  
 */
public class PropertyUtil {

    /** The locale en. */
    public static String CHINA = "zh_CN";    
    
    /**
     * Gets the properties.
     *
     * @return the properties
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Properties getProperties(final String locale) throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertyUtil.class.getClassLoader();
        String filePath;
        if (CHINA.equals(locale)) {
            filePath = Constant.MESSAGES_CN_FILE_PATH;
        } else {
            filePath = Constant.MESSAGES_EN_FILE_PATH;
        }
        File file = new File(classLoader.getResource(filePath).getFile());
        InputStream input = new FileInputStream(file);
        properties.load(input);
        return properties;        
    }
}
