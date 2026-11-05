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

    @Then("the login image should be displayed")
    public void theLoginImageShouldBeDisplayed() {
        assertThat(loginPage.isLoginImageDisplayed())
                .as("Login image should be displayed on the login page")
                .isTrue();
    }

    @And("the heading {string} should be displayed")
    public void theHeadingShouldBeDisplayed(String expectedHeading) {
        assertThat(loginPage.getHeadingText())
                .as("Login page heading should match the expected text")
                .isEqualTo(expectedHeading);
    }

    @And("the email and password fields should be enabled")
    public void theEmailAndPasswordFieldsShouldBeEnabled() {
        assertThat(loginPage.isEmailFieldEnabled())
                .as("The email field should be enabled")
                .isTrue();

        assertThat(loginPage.isPasswordFieldEnabled())
                .as("The password field should be enabled")
                .isTrue();
    }

    @And("the login button should be enabled")
    public void theLoginButtonShouldBeEnabled() {
        assertThat(loginPage.isLoginButtonEnabled())
                .as("The login button should be enabled")
                .isTrue();
    }

    @When("the user clicks the signup link")
    public void theUserClicksTheSignupLink() {
        loginPage.clickSignUpLink();
    }

    @Then("the user should be on the register page")
    public void theUserShouldBeOnTheRegisterPage() {
        assertThat(loginPage.isOnRegisterPage())
                .as("The user should be on the register page")
                .isTrue();
    }

    @When("the user clicks the forgot password link")
    public void theUserClicksTheForgotPasswordLink() {
        loginPage.clickForgotPasswordLink();
    }

    @Then("the forgot password page should open in a new tab")
    public void theForgotPasswordPageShouldOpenInANewTab() {
        assertThat(loginPage.isForgotPasswordPageOpenedInNewTab())
                .as("The forgot password page should open in a new tab")
                .isTrue();
    }

    @Then("the user should be on the login page")
    public void theUserShouldBeOnTheLoginPage() {
        assertThat(loginPage.isLoginPageOpened())
                .as("The user should be on the login page")
                .isTrue();
    }
}
