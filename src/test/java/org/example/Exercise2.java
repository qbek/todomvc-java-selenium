package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise2 {

    WebDriver browser = new ChromeDriver();
    private final By redCheckboxSelector = By.cssSelector("[name=\"red\"]");
    private final By blueCheckboxSelector = By.cssSelector("[name=\"blue\"]");
    private final By lightSelector = By.cssSelector("#light");

    @BeforeEach
    public void setup() {
        browser.get("https://qbek.github.io/selenium-exercises/pl/check_boxes.html");
    }

    @AfterEach
    public void close() {
        browser.close();
    }

    @Test
    public void userCanMixColors() throws InterruptedException {
        WebElement redCheckbox = browser.findElement(redCheckboxSelector);
        redCheckbox.click();

        WebElement blueCheckbox = browser.findElement(blueCheckboxSelector);
        blueCheckbox.click();

        WebElement light = browser.findElement(lightSelector);
        String color = light.getAttribute("data-color");

        Assertions.assertThat(color).as("color should be mixed").isEqualTo("#FF00FF");
//        Assertions.assertThat(color).contains("255, 0, 255");
    }

    @Test
    public void userCanEnableTextArea() {
        WebElement toggle = browser.findElement(By.cssSelector(".custom-control-label"));
        toggle.click();

        WebElement textArea = browser.findElement(By.cssSelector("#text"));
        Boolean isTextAreaEnabled = textArea.isEnabled();
        Assertions.assertThat(isTextAreaEnabled).as("Text area should be enabled").isTrue();
    }
}
