package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private static final int EXPECTED_WINDOW_COUNT = 2;

    protected void click(By locator) {
        WaitHelper.waitForClickable(locator).click();
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
