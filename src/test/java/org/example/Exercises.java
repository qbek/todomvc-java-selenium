package org.example;

import io.cucumber.java.de.Wenn;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class Exercises {


    @Test
    public void exercise_1() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        WebElement nameInput = browser.findElement(By.cssSelector("#firstname"));
        nameInput.sendKeys("Kuba");
        nameInput.sendKeys(Keys.TAB);

        WebElement lastnameInput = browser.findElement(By.cssSelector(":focus"));
        lastnameInput.sendKeys("Szewczyk");
        lastnameInput.sendKeys(Keys.TAB);


        WebElement emailInput = browser.findElement(By.cssSelector(":focus"));
        emailInput.sendKeys("wp@wp.pl");

//        WebElement lastnameInput = browser.findElement(By.cssSelector("#lastname"));
//        lastnameInput.sendKeys("Szewczyk");
//
//        WebElement emailInput = browser.findElement(By.cssSelector("#email"));
//        emailInput.sendKeys("wp@wp.pl");

        WebElement saveButton = browser.findElement(By.cssSelector(".btn-success"));
        saveButton.click();

        WebElement nameCheck = browser.findElement(By.cssSelector("#firstname-check"));
        String name = nameCheck.getText();
        MatcherAssert.assertThat("Name value is correct", name, Matchers.equalTo("Kuba") );

        WebElement lastNameCheck = browser.findElement(By.cssSelector("#lastname-check"));
        String lastname = lastNameCheck.getText();
        MatcherAssert.assertThat("Last name is correct", lastname, Matchers.equalTo("Szewczyk"));

        WebElement emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        String email = emailCheck.getDomProperty("value");
        MatcherAssert.assertThat("Email is correct", email, Matchers.equalTo("wp@wp.pl"));

        Thread.sleep(2000);
        browser.close();
    }

    @Test
    public void exercise_2a () {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        WebElement redCheckbox = browser.findElement(By.cssSelector("[name=\"red\"]"));
        redCheckbox.click();

        WebElement blueCheckbox = browser.findElement(By.cssSelector("[name=\"blue\"]"));
        blueCheckbox.click();

        WebElement light = browser.findElement(By.cssSelector("#light"));

        MatcherAssert.assertThat("Light is pink", light.getDomAttribute("data-color"), Matchers.equalTo("#FF00FF"));
        MatcherAssert.assertThat("Light is pink (by cssValue)", light.getCssValue("background-color"), Matchers.equalTo("rgb(255, 0, 255)"));
        browser.close();
    }

    @Test
    public void exercise_2b() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var textAreaEl = browser.findElement(By.cssSelector("#text"));
        MatcherAssert.assertThat("Text area should be disabled", textAreaEl.isEnabled(), Matchers.equalTo(false));

        var switchEl = browser.findElement(By.cssSelector(".custom-control-label"));
        switchEl.click();
        MatcherAssert.assertThat("Text area should be enabled", textAreaEl.isEnabled(), Matchers.equalTo(true));

        browser.close();
    }

    @Test
    public void exercise_3() {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        WebElement rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
        rmffm.click();

        var rmffmLink = browser.findElement(By.cssSelector("#rmffm-details a"));
        MatcherAssert.assertThat("Link is diplayed", rmffmLink.isDisplayed(), Matchers.equalTo(true));
        MatcherAssert.assertThat("Link directs to correct page", rmffmLink.getDomAttribute("href"), Matchers.equalTo("https://www.rmf.fm"));
    }
}
