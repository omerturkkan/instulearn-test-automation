package io.github.omerturkkan.instulearn.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException(CONFIG_FILE + " not found on classpath");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load " + CONFIG_FILE, e);
        }
    }

    public static String get(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = System.getenv(toEnvName(key));
        }
        if (value == null) {
            value = PROPERTIES.getProperty(key);
        }
        if (value == null) {
            throw new IllegalStateException("Missing config value for key: " + key);
        }
        return value.trim();
    }

    private static String toEnvName(String key) {
        return key.toUpperCase().replace('.', '_');
    }
}
