package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.omerturkkan.instulearn.pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeSteps {

    private final HomePage homePage = new HomePage();

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.open();
    }

    @When("the user clicks the login link in the top bar")
    public void theUserClicksTheLoginLinkInTheTopBar() {
        homePage.clickTopBarLoginLink();
    }

    @Then("the user should be on the home page")
    public void theUserShouldBeOnTheHomePage() {
        assertThat(homePage.isOnHomePage())
                .as("The user should be on the home page")
                .isTrue();
    }
}
