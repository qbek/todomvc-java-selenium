package org.example;

import org.apache.commons.compress.harmony.unpack200.Pack200UnpackerAdapter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise3 {

    @Test
    public void userCanVisitRadioWebPage() {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://qbek.github.io/selenium-exercises/pl/radio_buttons.html");

        WebElement radioZet = browser.findElement(By.cssSelector("[value=\"radiozet\"]"));
        radioZet.click();

        // podejscie pierwsze - najgorsze
//        radioWebPage.click();
//        String pageTitle = browser.getTitle();
//        Assertions.assertThat(pageTitle).as("Correct page is opened").isEqualTo("Radio ZET Muzyka Online - Informacje, wiadomości, pogoda | Radio ZET");

        //podejscie drugie - duzo lepsze
//        WebElement radioWebPage = browser.findElement(By.cssSelector("#radiozet-details a"));
//        String href = radioWebPage.getAttribute("href");
//        Assertions.assertThat(href).as("Link is correct").isEqualTo("https://www.radiozet.pl/");
//        Assertions.assertThat(radioWebPage.isDisplayed()).as("Link should be visible").isTrue();

        //podejscie trzecie - optymalizacja/refaktor
        WebElement radioWebPage = browser.findElement(By.cssSelector("#radiozet-details a[href=\"https://www.radiozet.pl\"]"));
        Assertions.assertThat(radioWebPage.isDisplayed()).as("Link should be visible").isTrue();
    }
}
