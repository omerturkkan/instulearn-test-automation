package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopNavbar {

    private static final By NAVBAR_LINKS = By.cssSelector("#navbar .nav-link");

    public List<String> getLinkTexts() {
        return WaitHelper.waitForAllVisible(NAVBAR_LINKS).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }

    public void clickLink(String linkText) {
        WaitHelper.waitForAllVisible(NAVBAR_LINKS).stream()
                .filter(link -> link.getText().trim().equals(linkText))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Top navbar link not found: " + linkText))
                .click();
    }
}
