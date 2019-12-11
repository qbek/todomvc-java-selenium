package com.github.qbek;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class BasicInteractionTest {

    @Test
    public void handleInputs() throws InterruptedException {

        WebDriver browser = new FirefoxDriver();
        browser.get("http://webdriveruniversity.com/Login-Portal/index.html");

        WebElement usernameInput = browser.findElement(By.cssSelector("#text"));
        usernameInput.sendKeys("Jakub");

        WebElement passwordInput = browser.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("secret");

        WebElement loginButton = browser.findElement(By.cssSelector("#login-button"));
        String buttonText = loginButton.getText();
        System.out.println("Button text: " + buttonText);

        String inputText = usernameInput.getAttribute("value");
        System.out.println("Input text: " + inputText);

        assertEquals("Descrpition", "Jakub",  inputText);
        loginButton.click();
        Thread.sleep(2000);
        browser.quit();
    }
}
