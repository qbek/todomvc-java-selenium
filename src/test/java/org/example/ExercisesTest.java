package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.TAB;

public class ExercisesTest {

    @Test
    public void exercise_1() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        //klasyczne wpisywanie na zasadzie element po elementcie
//        var nameInput = browser.findElement(cssSelector("#firstname"));
//        nameInput.sendKeys("Kuba");
//
//        var surnameInput = browser.findElement(cssSelector("#lastname"));
//        surnameInput.sendKeys("Szewczyk");
//
//        var emailInput = browser.findElement(cssSelector("#email"));
//        emailInput.sendKeys("kuba@szewczyk.com");


        //alterantywa - wykorzystanie TAB
        var nameInput = browser.findElement(cssSelector("#firstname"));
        nameInput.sendKeys("Kuba");
        nameInput.sendKeys(TAB);


        var surnameInput = browser.findElement(cssSelector(":focus"));
        surnameInput.sendKeys("Szewczyk");
        surnameInput.sendKeys(TAB);

        var emailInput = browser.findElement(cssSelector(":focus"));
        emailInput.sendKeys("kuba@szewczyk.com");

        var submitButton = browser.findElement(cssSelector(".btn-success"));
        submitButton.click();

        var nameCheck = browser.findElement(cssSelector("#firstname-check"));
        assertThat("Name value should be eql to expected", nameCheck.getText(), equalTo("Kuba"));

        var surnameCheck = browser.findElement(cssSelector("#lastname-check"));
        assertThat("Last name is correct", surnameCheck.getText(), equalTo("Szewczyk"));

        var emailCheck = browser.findElement(cssSelector(".form-control-plaintext"));
        assertThat("Email is correct", emailCheck.getAttribute("value"), equalTo("kuba@szewczyk.com"));

        browser.close();
    }

    @Test
    public void exercise_2a() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var redCheckbox = browser.findElement(cssSelector("[name=\"red\"]"));
        redCheckbox.click();

        var blueCheckbox = browser.findElement(cssSelector("[name=\"blue\"]"));
        blueCheckbox.click();

        var lightEl = browser.findElement(cssSelector("#light"));
        assertThat("Color is pink", lightEl.getAttribute("data-color"), equalTo("#FF00FF"));
        assertThat("Color is pink", lightEl.getCssValue("background-color"), equalTo("rgb(255, 0, 255)"));

        browser.close();
    }

    @Test
    public void exercise_2b() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var textAreaEl = browser.findElement(cssSelector("#text"));
        assertThat("Text area should be disabled", textAreaEl.isEnabled(), equalTo(false));

//        var switchEl = browser.findElement(cssSelector("#switch"));
        var switchEl = browser.findElement(cssSelector(".custom-control-label"));
        switchEl.click();

        assertThat("Text area should be enabled", textAreaEl.isEnabled(), equalTo(true));

        browser.close();
    }

    @Test
    public void exercise_3() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        var rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
        rmffm.click();

        var rmffmLink = browser.findElement(By.cssSelector("#rmffm-details a"));
        assertThat("Link directs to correct page", rmffmLink.getAttribute("href"), equalTo("https://www.rmf.fm/"));
        assertThat("Link is displayed", rmffmLink.isDisplayed(), equalTo(true));
    }
}
