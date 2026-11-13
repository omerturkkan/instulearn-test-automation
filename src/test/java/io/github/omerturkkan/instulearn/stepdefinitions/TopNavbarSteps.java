package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("the user clicks the {string} link on the top navbar")
    public void theUserClicksTheLinkOnTheTopNavbar(String linkText) {
        topNavbar.clickLink(linkText);
    }

    @When("the user clicks the site logo")
    public void theUserClicksTheSiteLogo() {
        topNavbar.clickSiteLogo();
    }

    @Then("the cart button should be visible")
    public void theCartButtonShouldBeVisible() {
        assertThat(topNavbar.isCartButtonVisible())
                .as("Cart button should be visible")
                .isTrue();
    }

    @Then("the notifications button should be visible and enabled")
    public void theNotificationsButtonShouldBeVisibleAndEnabled() {
        assertThat(topNavbar.isNotificationsButtonEnabled())
                .as("Notifications button should be visible and enabled")
                .isTrue();
    }

    @When("the user searches for {string} on the top navbar")
    public void theUserSearchesForOnTheTopNavbar(String keyword) {
        topNavbar.searchFor(keyword);
    }

    @When("the user clicks the Start learning button on the top navbar")
    public void theUserClicksTheStartLearningButtonOnTheTopNavbar() {
        topNavbar.clickStartLearningButton();
    }

    @When("the user clicks the login link in the top bar")
    public void theUserClicksTheLoginLinkInTheTopBar() {
        topNavbar.clickLoginLink();
    }
}
