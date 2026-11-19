package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.ConfigReader;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;

public class HomePage extends BasePage {

    public void open() {
        String homePageUrl = ConfigReader.get("base.url");
        log.info("Opening home page: {}", homePageUrl);
        DriverManager.getDriver().get(homePageUrl);
    }

    public boolean isOnHomePage() {
        return WaitHelper.waitForUrlToBe(ConfigReader.get("base.url") + "/");
    }
}
