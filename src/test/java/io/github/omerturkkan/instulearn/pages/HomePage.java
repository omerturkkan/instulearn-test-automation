package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.ConfigReader;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    public void open() {
        String homePageUrl = ConfigReader.get("base.url");
        LOG.info("Opening home page: {}", homePageUrl);
        DriverManager.getDriver().get(homePageUrl);
    }

    public boolean isOnHomePage() {
        return WaitHelper.waitForUrlToBe(ConfigReader.get("base.url") + "/");
    }
}
