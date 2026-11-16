package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CoursesPage extends BasePage {

    private static final By FILTER_LABELS = By.cssSelector("label.cursor-pointer.mb-0");

    public List<String> getFilterNames() {
        return WaitHelper.waitForAllVisible(FILTER_LABELS).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }
}
