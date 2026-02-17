package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class Exercises {

    @Test
    public void exercise_1() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        var firstNameInput = browser.findElement(By.cssSelector("#firstname"));
        firstNameInput.sendKeys("Jakub");
        firstNameInput.sendKeys(Keys.TAB);

        var focusedEl = browser.findElement(By.cssSelector(":focus"));
        focusedEl.sendKeys("Szewczyk");
        focusedEl.sendKeys(Keys.TAB);

        focusedEl = browser.findElement(By.cssSelector(":focus"));
        focusedEl.sendKeys("kuba@wp.pl");
        focusedEl.sendKeys(Keys.TAB);

        focusedEl = browser.findElement(By.cssSelector(":focus"));
        focusedEl.click();


        var poprawBtn = browser.findElement(By.cssSelector("#collapse-check .btn-warning"));

//        var lastNameInput = browser.findElement(By.cssSelector("#lastname"));
//        lastNameInput.sendKeys("Szewczyk");

//        var emailInput = browser.findElement(By.cssSelector("#email"));
//        emailInput.sendKeys("kuba@wp.pl");

//        var saveBtn = browser.findElement(By.cssSelector(".btn-success"));
//        saveBtn.click();

        var firstnameCheck = browser.findElement(By.cssSelector("#firstname-check"));
        MatcherAssert.assertThat("First name should be correct",
                firstnameCheck.getText(),
                Matchers.equalTo("Jakub"));

        var lastnameCheck = browser.findElement(By.cssSelector("#lastname-check"));
        MatcherAssert.assertThat("Last name should be correct",
                lastnameCheck.getText(),
                Matchers.equalTo("Szewczyk"));

        var emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        MatcherAssert.assertThat("Email should be correct",
                emailCheck.getAttribute("value"),
                Matchers.equalTo("kuba@wp.pl"));

        browser.close();
    }

    @Test
    public void exercise_2a() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var red = browser.findElement(By.cssSelector("[name=\"red\"]"));
        red.click();

        var blue = browser.findElement(By.cssSelector("[name=\"blue\"]"));
        blue.click();

        var light = browser.findElement(By.cssSelector("#light"));
        MatcherAssert.assertThat("Light should be ping",
                light.getCssValue("background-color"),
                Matchers.equalTo("rgb(255, 0, 255)")
        );

        MatcherAssert.assertThat("Light should be pink 2",
                light.getAttribute("data-color"),
                Matchers.equalTo("#FF00FF")
        );

        browser.close();
    }

    @Test
    public void exercise_2b() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var commentBox = browser.findElement(By.cssSelector("#text"));
        MatcherAssert.assertThat("Comments box is disabled",
                commentBox.isEnabled(), Matchers.equalTo(false));

        var switchEl = browser.findElement(By.cssSelector(".custom-control-label"));
        switchEl.click();

        MatcherAssert.assertThat("Comments box is enabled",
                commentBox.isEnabled(), Matchers.equalTo(true));

        browser.close();
    }

    @Test
    public void exercise_3() {

        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        var rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
//        var rmffm = browser.findElement(By.cssSelector("[value=\"radiozet\"]"));
        rmffm.click();

        var anchor = browser.findElement(By.cssSelector("#rmffm-details a"));
        MatcherAssert.assertThat("Link to RMF FM is correct",
                anchor.getAttribute("href"),
                Matchers.equalTo("https://www.rmf.fm/"));
        MatcherAssert.assertThat("Link is diplayed",
                anchor.isDisplayed(),
                Matchers.equalTo(true));

        browser.close();
    }
}
