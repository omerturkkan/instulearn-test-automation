package io.github.omerturkkan.instulearn.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.omerturkkan.instulearn.pages.CoursesPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoursesSteps {

    private final CoursesPage coursesPage = new CoursesPage();

    @Then("the following filters should be displayed on the courses page:")
    public void theFollowingFiltersShouldBeDisplayedOnTheCoursesPage(List<String> expectedFilters) {
        assertThat(coursesPage.getFilterNames())
                .as("Courses page filters")
                .containsExactlyElementsOf(expectedFilters);
    }

    @When("the user turns on the {string} filter")
    public void theUserTurnsOnTheFilter(String filterName) {
        coursesPage.turnOnFilter(filterName);
    }
}
