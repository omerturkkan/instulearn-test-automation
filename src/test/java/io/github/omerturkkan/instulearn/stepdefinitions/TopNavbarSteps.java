package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Then;
import io.github.omerturkkan.instulearn.pages.TopNavbar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TopNavbarSteps {

    private final TopNavbar topNavbar = new TopNavbar();

    @Then("the following links should be displayed on the top navbar:")
    public void theFollowingLinksShouldBeDisplayedOnTheTopNavbar(List<String> expectedLinks) {
        assertThat(topNavbar.getLinkTexts())
                .as("Top navbar links")
                .containsExactlyElementsOf(expectedLinks);
    }
}
