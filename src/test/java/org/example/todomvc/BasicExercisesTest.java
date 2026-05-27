package org.example.todomvc;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicExercisesTest {

    @Test
    public void exercise_1() throws InterruptedException {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        // wersja oparta o nawigacje TAB'em
        var name = browser.findElement(By.cssSelector("#firstname"));
        name.sendKeys("Kuba");
        name.sendKeys(Keys.TAB);

        var lastname = browser.findElement(By.cssSelector(":focus"));
        lastname.sendKeys("Szewczyk");
        lastname.sendKeys(Keys.TAB);

        var email = browser.findElement(By.cssSelector(":focus"));
        email.sendKeys("kuba@wp.pl");
        email.sendKeys(Keys.TAB);

        var button = browser.findElement(By.cssSelector(":focus"));
        button.click();

// wersja podstawowa - szukam element po elementcie
//        var lastname = browser.findElement(By.cssSelector("#lastname"));
//        lastname.sendKeys("Szewczyk");
//
//        var email = browser.findElement(By.cssSelector("#email"));
//        email.sendKeys("kuba@wp.pl");
//
//        var button = browser.findElement(By.cssSelector(".btn-success"));
//        button.click();

        var nameCheck = browser.findElement(By.cssSelector("#firstname-check"));
        var nameValue = nameCheck.getText();
        MatcherAssert.assertThat("Name should be correct",
                nameValue,
                Matchers.equalTo("Kuba"));

        //to samo co wyżej ale skrócony zapis w formie
        MatcherAssert.assertThat("Last name should be correct",
                browser.findElement(By.cssSelector("#lastname-check")).getText(),
                Matchers.equalTo("Szewczyk"));

        var emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        var emailValue = emailCheck.getAttribute("value");
        MatcherAssert.assertThat("Email is correct",
                emailValue,
                Matchers.equalTo("kuba@wp.pl"));
        browser.close();
    }

    @Test
    public void exercise_2a() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var redCheckbox = browser.findElement(By.cssSelector("[name=\"red\"]"));
        redCheckbox.click();
        //ANTYPATTERN - funkcjonalnosc checkboxow jest funkcjonalnoscia przegladarki
        // funkcji przegladarki NIE TEST-TU-JE-MY!!!!
//        MatcherAssert.assertThat("After click checkbox is selected",
//                redCheckbox.isSelected(),
//                Matchers.equalTo(true));

        var blueCheckbox = browser.findElement(By.cssSelector("[name=\"blue\"]"));
        blueCheckbox.click();

        var light = browser.findElement(By.cssSelector("#light"));
        MatcherAssert.assertThat("Light has pink color",
                light.getAttribute("data-color"),
                Matchers.equalTo("#FF00FF"));
        browser.close();
    }

    @Test
    public void exercise_2b() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        var textField = browser.findElement(By.cssSelector("#text"));

        MatcherAssert.assertThat("At the start text area is disabled",
                textField.isEnabled(),
                Matchers.equalTo(false));

        // czasami trzeba kliknac w element ktory przykrywa element docelowy
        // (w naszym przypadku checkbox #switch)
        var textFiledToggle = browser.findElement(By.cssSelector(".custom-control-label"));
        textFiledToggle.click();

        MatcherAssert.assertThat("After pressing toggle text area is enabled",
                textField.isEnabled(),
                Matchers.equalTo(true));
        browser.close();
    }

    @Test
    public void exercise_3() {
        var browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        var rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
        rmffm.click();

        var rmffmLink = browser.findElement(By.cssSelector("#rmffm-details a"));
        MatcherAssert.assertThat("Link to rmffm is visible",
                rmffmLink.isDisplayed(),
                Matchers.equalTo(true));
        MatcherAssert.assertThat("Link to rmffm is correct",
                rmffmLink.getAttribute("href"),
                Matchers.equalTo("https://www.rmf.fm/"));

        //anty-pattern: podążanie za linkami jest funkcjonalnoscia przegladarki
//        rmffmLink.click();
//        MatcherAssert.assertThat("correct page is open",
//                browser.getTitle(),
//                Matchers.equalTo("Radio RMF FM - Najlepsza muzyka"));
        browser.close();
    }
}
