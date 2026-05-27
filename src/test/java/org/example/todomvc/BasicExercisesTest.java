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
}
