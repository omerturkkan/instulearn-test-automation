package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

    private static final int EXPECTED_WINDOW_COUNT = 2;

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected void click(By locator) {
        log.info("Clicking: {}", locator);
        WaitHelper.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        log.info("Typing into: {}", locator);
        WebElement element = WaitHelper.waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isEnabled(By locator) {
        return WaitHelper.waitForVisibility(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return WaitHelper.waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void switchToNewTab() {
        WebDriver driver = DriverManager.getDriver();
        String originalTab = driver.getWindowHandle();
        WaitHelper.waitForNumberOfWindows(EXPECTED_WINDOW_COUNT);
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }
}
