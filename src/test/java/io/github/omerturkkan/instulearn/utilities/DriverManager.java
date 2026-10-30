package io.github.omerturkkan.instulearn.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(createDriver());
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
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
            options.addArguments("--headless=new");
        }

        options.addArguments("--window-size=1920,1080");

        return new ChromeDriver(options);
    }
}
