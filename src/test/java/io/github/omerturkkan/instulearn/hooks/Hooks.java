package io.github.omerturkkan.instulearn.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.omerturkkan.instulearn.utilities.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed() && DriverManager.hasDriver()) {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            DriverManager.quitDriver();
        }
    }
}
