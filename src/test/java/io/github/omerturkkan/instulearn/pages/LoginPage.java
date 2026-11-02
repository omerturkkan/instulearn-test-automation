package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.ConfigReader;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("form[action='/login'] button[type='submit']");
    private static final By ERROR_MESSAGE = By.className("invalid-feedback");

    private static final String LOGIN_PATH = "/login";
    private static final String PANEL_PATH = "/panel";

    public void open() {
        String loginUrl = ConfigReader.get("base.url") + LOGIN_PATH;
        LOG.info("Opening login page: {}", loginUrl);
        DriverManager.getDriver().get(loginUrl);
    }

    public void login(String email, String password) {
        LOG.info("Logging in with email: {}", email);
        WaitHelper.waitForVisibility(EMAIL_INPUT).sendKeys(email);
        WaitHelper.waitForVisibility(PASSWORD_INPUT).sendKeys(password);
        WaitHelper.waitForVisibility(LOGIN_BUTTON).click();
    }

    public boolean isLoggedIn() {
        boolean loggedIn = WaitHelper.waitForUrlContains(PANEL_PATH);
        LOG.info("Logged in: {}", loggedIn);
        return loggedIn;
    }

    public boolean isOnLoginPage() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        return currentUrl != null && currentUrl.contains(LOGIN_PATH);
    }

    public String getErrorMessage() {
        return WaitHelper.waitForVisibility(ERROR_MESSAGE).getText();
    }
}
