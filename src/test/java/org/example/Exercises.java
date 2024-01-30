package org.example;

import com.openhtmltopdf.resource.AbstractResource;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercises {

    @Test
    public void exercise_1 () {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        WebElement firstNameInput = browser.findElement(By.cssSelector("#firstname"));
        firstNameInput.sendKeys("Kuba");

        // rozwiązanie 1: łopatoligczne - elemcie
//        WebElement lastNameInput = browser.findElement(By.cssSelector("#lastname"));
//        lastNameInput.sendKeys("Szewczyk");
//
//        WebElement emailInput = browser.findElement(By.cssSelector("#email"));
//        emailInput.sendKeys("wp@wp.pl");

        firstNameInput.sendKeys(Keys.TAB);

        WebElement focused = browser.findElement(By.cssSelector(":focus"));
        focused.sendKeys("Szewczyk");
        focused.sendKeys(Keys.TAB);

        focused = browser.findElement(By.cssSelector(":focus"));
        focused.sendKeys("wp@wp.pl");


        WebElement button = browser.findElement(By.cssSelector(".btn-success"));
        button.click();

        WebElement firstCheck = browser.findElement(By.cssSelector("#firstname-check"));
        MatcherAssert.assertThat("First name is correct", firstCheck.getText(), Matchers.equalTo("Kuba"));

        WebElement lastCheck = browser.findElement(By.cssSelector("#lastname-check"));
        MatcherAssert.assertThat("Last name is correct", lastCheck.getText(), Matchers.equalTo("Szewczyk"));

        WebElement emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        MatcherAssert.assertThat("Email is correct", emailCheck.getAttribute("value"), Matchers.equalTo("wp@wp.pl"));
    }

    @Test
    public void exercise_2 () {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        WebElement red = browser.findElement(By.cssSelector("[name=\"red\"]"));
        red.click();

        WebElement blue = browser.findElement(By.cssSelector("[name=\"blue\"]"));
        blue.click();

        WebElement light = browser.findElement(By.cssSelector("#light"));
        MatcherAssert.assertThat("Color is pink", light.getCssValue("background-color"), Matchers.equalTo("rgb(255, 0, 255)"));

        MatcherAssert.assertThat("Color is pink 2", light.getAttribute("data-color"), Matchers.equalTo( "#FF00FF"));

        WebElement switchEl = browser.findElement(By.cssSelector(".custom-control-label"));
        switchEl.click();



        WebElement textArea = browser.findElement(By.cssSelector("#text"));
        MatcherAssert.assertThat("Text area is enabled", textArea.isEnabled(), Matchers.equalTo(true));
    }

    @Test
    public void exercise_3 () {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        WebElement rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
        rmffm.click();

        WebElement rmffmLink = browser.findElement(By.cssSelector("#rmffm-details a"));
        MatcherAssert.assertThat("Link directs to correct page", rmffmLink.getAttribute("href"), Matchers.equalTo("https://www.rmf.fm/"));
        MatcherAssert.assertThat("Link is displayed", rmffmLink.isDisplayed(), Matchers.equalTo(true));
    }
}
