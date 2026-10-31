package io.github.omerturkkan.instulearn.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @After
    public void tearDown(Scenario scenario) {
        try {
            LOG.info("Scenario finished: {} - status: {}", scenario.getName(), scenario.getStatus());
            if (scenario.isFailed() && DriverManager.hasDriver()) {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            DriverManager.quitDriver();
        }
    }
}
