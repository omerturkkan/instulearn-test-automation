package io.github.omerturkkan.instulearn.pages;

import io.github.omerturkkan.instulearn.utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopNavbar extends BasePage {

    private static final By NAVBAR_LINKS = By.cssSelector("#navbar .nav-link");
    private static final By SITE_LOGO = By.cssSelector(".navbar-brand");
    private static final By CART_BUTTON = By.id("navbarShopingCart");
    private static final By NOTIFICATIONS_BUTTON = By.id("navbarNotification");
    private static final By SEARCH_INPUT = By.cssSelector(".navbar-search input[name='search']");
    private static final By SEARCH_BUTTON = By.cssSelector(".navbar-search button[type='submit']");
    private static final By START_LEARNING_BUTTON = By.cssSelector(".nav-start-a-live-btn.btn");
    private static final By LOGIN_LINK = By.cssSelector(".top-navbar a[href='/login']");

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

    public void clickSiteLogo() {
        click(SITE_LOGO);
    }

    public boolean isCartButtonVisible() {
        return isDisplayed(CART_BUTTON);
    }

    public boolean isNotificationsButtonEnabled() {
        return isEnabled(NOTIFICATIONS_BUTTON);
    }

    public void searchFor(String keyword) {
        type(SEARCH_INPUT, keyword);
        click(SEARCH_BUTTON);
    }

    public void clickStartLearningButton() {
        click(START_LEARNING_BUTTON);
    }

    public void clickLoginLink() {
        click(LOGIN_LINK);
    }
}
