package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.ConfigReader;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    private static final By TOP_BAR_LOGIN_LINK = By.cssSelector(".top-navbar a[href='/login']");

    public void open() {
        String homePageUrl = ConfigReader.get("base.url");
        LOG.info("Opening home page: {}", homePageUrl);
        DriverManager.getDriver().get(homePageUrl);
    }

    public void clickTopBarLoginLink() {
        click(TOP_BAR_LOGIN_LINK);
    }

    public boolean isOnHomePage() {
        return WaitHelper.waitForUrlToBe(ConfigReader.get("base.url") + "/");
    }
}
