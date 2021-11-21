package org.example.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class EnvConfiguration {

    private static Properties CFG;

    static {
        String env = System.getProperty("env");
        InputStream is = env.getClass().getResourceAsStream(format("/env_%s.properties", env));
        CFG = new Properties();
        try {
            CFG.load(is);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    public static String getUrl() {
        return CFG.getProperty("todoMVC_url");
    }

}
