package com.wyett.config;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 10:57
 * @description: TODO
 */

public class PropertiesUtil {

    public PropertiesUtil() {
    }

    public static Properties getProperties(String propertieStr) throws IOException {
        Properties properties = new Properties();
        properties.load(new StringReader(propertieStr));
        return properties;
    }

}
