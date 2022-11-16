package org.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelloWorld {

    @Test
    public void browserPuppeteer() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://google.pl");
        Thread.sleep(2000);
        browser.close();
    }

    @Test
    public void exercise_1() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");

        WebElement nameInput = browser.findElement(By.cssSelector("#firstname"));
        nameInput.sendKeys("Kuba");

        WebElement lastnameInput = browser.findElement(By.cssSelector("#lastname"));
        lastnameInput.sendKeys("Szewczyk");

        WebElement emailInput = browser.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("kuba@kuba.pl");


        WebElement saveButton = browser.findElement(By.cssSelector(".btn-success"));
        saveButton.click();

        WebElement nameCheck = browser.findElement(By.cssSelector("#firstname-check"));
        String nameToCheck = nameCheck.getText();
        MatcherAssert.assertThat("Name should have correct value", nameToCheck, Matchers.equalTo("Kuba"));

        WebElement lastnameCheck = browser.findElement(By.cssSelector("#lastname-check"));
        String lastnameToCheck = lastnameCheck.getText();
        MatcherAssert.assertThat("Name should have correct value", lastnameToCheck, Matchers.equalTo("Szewczyk"));

        WebElement emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        String emailToCheck = emailCheck.getAttribute("value");
        MatcherAssert.assertThat("Name should have correct value", emailToCheck, Matchers.equalTo("kuba@kuba.pl"));

        Thread.sleep(2000);
        browser.close();
    }

    @Test
    public void getElementBackgroundColor() {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        WebElement light = browser.findElement(By.cssSelector("#light"));
        System.out.println(light.getCssValue("background-color"));

        browser.close();
    }

    @Test
    public void exercise_2() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");

        WebElement switchElement = browser.findElement(By.cssSelector(".custom-control-label"));
        switchElement.click();

        WebElement textField = browser.findElement(By.cssSelector("#text"));
        MatcherAssert.assertThat("Text area is enabled", textField.isEnabled(), Matchers.equalTo(true));

        Thread.sleep(1000);
        browser.close();
    }

    @Test
    public void exercise_3() {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        WebElement rmffm = browser.findElement(By.cssSelector("[value=\"rmffm\"]"));
        rmffm.click();

        WebElement rmffmLink = browser.findElement(By.cssSelector("#rmffm-details a"));
        String href = rmffmLink.getAttribute("href");
        MatcherAssert.assertThat("Link is correct", href, Matchers.equalTo("http://rmf.fm"));


        WebElement selectEl = browser.findElement(By.cssSelector("#mojselekct"));

        Select select = new Select(selectEl);
        select.selectByIndex();

    }
}
