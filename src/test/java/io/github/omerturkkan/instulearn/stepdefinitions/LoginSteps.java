package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.And;
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

    @When("the user logs in as {string} with password {string}")
    public void theUserLogsInAsWithPassword(String role, String password) {
        loginPage.login(
                ConfigReader.get(role + ".email"),
                password
        );
    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String expectedMessage) {
        assertThat(loginPage.getErrorMessage())
                .as("Error message should be shown for an invalid password")
                .isEqualTo(expectedMessage);
    }

    @And("the user should stay on the login page")
    public void theUserShouldStayOnTheLoginPage() {
        assertThat(loginPage.isOnLoginPage())
                .as("User should stay on the login page after an invalid login")
                .isTrue();
    }
}
