package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.omerturkkan.instulearn.pages.HomePage;

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
}
