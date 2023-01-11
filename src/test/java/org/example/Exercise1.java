package org.example;


import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Exercise1 {

    @Test
    public void userCanEneterHisDetails() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/basic_form.html");
        WebElement firstNameInput = browser.findElement(By.cssSelector("#firstname"));
        firstNameInput.sendKeys("Jakub");

        WebElement lastNameInput = browser.findElement(By.cssSelector("#lastname"));
        lastNameInput.sendKeys("Szewczyk");

        WebElement emailInput = browser.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("jakub@polska.pl");

        WebElement saveButton = browser.findElement(By.cssSelector(".btn-success"));
        saveButton.click();

        WebElement firstNameCheck = browser.findElement(By.cssSelector("#firstname-check"));
        String firstNameValue = firstNameCheck.getText();
        Assertions.assertThat(firstNameValue).as("first name should be correct").isEqualTo("Jakub");

        WebElement lastNameCheck = browser.findElement(By.cssSelector("#lastname-check"));
        String lastNameValue = lastNameCheck.getText();
        Assertions.assertThat(lastNameValue).as("last name should be correct").isEqualTo("Szewczyk");

        WebElement emailCheck = browser.findElement(By.cssSelector(".form-control-plaintext"));
        String emailValue = emailCheck.getAttribute("value");
        Assertions.assertThat(emailValue).as("Email should be correct").isEqualTo("jakub@polska.pl");

//        Thread.sleep(3000);
        browser.close();
    }

}
