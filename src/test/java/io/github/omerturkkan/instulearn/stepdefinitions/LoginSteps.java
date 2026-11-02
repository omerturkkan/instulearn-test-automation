package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.omerturkkan.instulearn.pages.LoginPage;
import io.github.omerturkkan.instulearn.utilities.ConfigReader;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("the user logs in with valid {string} credentials")
    public void theUserLogsInWithValidCredentials(String role) {
        loginPage.login(
                ConfigReader.get(role + ".email"),
                ConfigReader.get(role + ".password")
        );
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        assertThat(loginPage.isLoggedIn())
                .as("User should be redirected to the panel after login")
                .isTrue();
    }
}
