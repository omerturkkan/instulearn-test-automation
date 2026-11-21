package io.github.omerturkkan.instulearn.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public final class DriverManager {

    private static final String HEADLESS_ARGUMENT = "--headless=new";
    private static final String WINDOW_SIZE_ARGUMENT = "--window-size=1920,1080";

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(createDriver());
        }
        return DRIVER.get();
    }

    public static boolean hasDriver() {
        return DRIVER.get() != null;
    }

    public static void quitDriver() {
        if (hasDriver()) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }

    private static WebDriver createDriver() {
        String browser = ConfigReader.get("browser");

        return switch (browser) {
            case "chrome" -> createChromeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        if (headless) {
            options.addArguments(HEADLESS_ARGUMENT);
        }

        options.addArguments(WINDOW_SIZE_ARGUMENT);

        if (Boolean.parseBoolean(ConfigReader.get("remote"))) {
            return createRemoteDriver(options);
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createRemoteDriver(ChromeOptions options) {
        String gridUrl = ConfigReader.get("grid.url");
        try {
            return new RemoteWebDriver(URI.create(gridUrl).toURL(), options);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Invalid grid.url: " + gridUrl, e);
        }
    }
}
