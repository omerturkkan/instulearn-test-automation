package io.github.omerturkkan.instulearn.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitHelper {

    private WaitHelper() {
    }

    public static WebElement waitForVisibility(By locator) {
        return createWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForUrlContains(String urlPart) {
        try {
            return createWait().until(ExpectedConditions.urlContains(urlPart));
        } catch (TimeoutException e) {
            return false;
        }
    }

    private static WebDriverWait createWait() {
        long timeoutSeconds = Long.parseLong(ConfigReader.get("explicit.wait.seconds"));
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutSeconds));
    }
}
