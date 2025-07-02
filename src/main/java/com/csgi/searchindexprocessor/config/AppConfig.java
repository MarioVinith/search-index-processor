package com.csgi.searchindexprocessor.config;

import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Configuration class to load application settings from a properties file located in the resources directory.
 */
public class AppConfig {

    private final int minLength;

    /**
     * Constructs an {@code AppConfig} instance by loading properties from the specified file.
     *
     * @param fileName the name of the properties file in the classpath
     * @throws IOException if an I/O error occurs while reading the configuration
     * @throws FileNotFoundException if the specified file is not found in the classpath
     */
    public AppConfig(String fileName) throws IOException {
        Properties props = new Properties();

        try (InputStream configStream = AppConfig.class.getClassLoader().getResourceAsStream(fileName)) {
            if (configStream == null) {
                throw new FileNotFoundException(fileName + " not found in resources");
            }
            props.load(configStream);
        }

        this.minLength = Integer.parseInt(props.getProperty("min.length", "3"));
    }

    /**
     * Returns the configured minimum length.
     *
     * @return the minimum length value loaded from the configuration file
     */
    public int getMinLength() {
        return minLength;
    }
}
