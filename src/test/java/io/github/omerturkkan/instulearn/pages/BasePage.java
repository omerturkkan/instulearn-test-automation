package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;

public abstract class BasePage {

    protected void click(By locator) {
        WaitHelper.waitForClickable(locator).click();
    }
}
