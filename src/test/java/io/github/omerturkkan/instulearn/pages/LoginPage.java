package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.ConfigReader;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;

public class LoginPage {

    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("form[action='/login'] button[type='submit']");

    private static final String LOGIN_PATH = "/login";
    private static final String PANEL_PATH = "/panel";

    public void open() {
        DriverManager.getDriver().get(ConfigReader.get("base.url") + LOGIN_PATH);
    }

    public void login(String email, String password) {
        WaitHelper.waitForVisibility(EMAIL_INPUT).sendKeys(email);
        WaitHelper.waitForVisibility(PASSWORD_INPUT).sendKeys(password);
        WaitHelper.waitForVisibility(LOGIN_BUTTON).click();
    }

    public boolean isLoggedIn() {
        return WaitHelper.waitForUrlContains(PANEL_PATH);
    }
}
