package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Then;
import io.github.omerturkkan.instulearn.utilities.WaitHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    @Then("the page URL should contain {string}")
    public void thePageUrlShouldContain(String expectedPath) {
        assertThat(WaitHelper.waitForUrlContains(expectedPath))
                .as("The page URL should contain the path: " + expectedPath)
                .isTrue();
    }
}
