package io.github.omerturkkan.instulearn.hooks;

import io.cucumber.java.After;
import io.github.omerturkkan.instulearn.utilities.DriverManager;

public class Hooks {

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
