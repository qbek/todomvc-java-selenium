package com.github.qbek.basics;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)
public class InputFieldsTest {

    @Managed
    WebDriver driver;

    @Before
    public void setup() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
    }

    @Test
    public void inputsExists() throws InterruptedException {

        WebElement loginInput = driver.findElement(By.cssSelector("#text"));
        Assert.assertNotNull(loginInput);

        //to nie zadziłą, ponieważ w przypadku nie znalezienia elementu rzuca exception
        //WebElement fakeInput = driver.findElement(By.cssSelector("#fake"));
        List<WebElement> fakeInput = driver.findElements(By.cssSelector("#fake"));
        assertEquals("There should be FAKE input", 1, fakeInput.size());
    }


    @Test
    public void playWithInputs() throws InterruptedException {

        WebElement loginInput = driver.findElement(By.cssSelector("#text"));
        loginInput.clear();
        loginInput.sendKeys("my_login");
        Thread.sleep(2000);

        WebElement passInput = driver.findElement(By.cssSelector("#password"));
        loginInput.clear();
        passInput.sendKeys("secret");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.cssSelector("#login-button"));
        button.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);

        // musimy to pole jeszcze raz zczytac, poniewaz przeladowywuje się strona
        // i selenium utraciło linka od naszego web elementu
        loginInput = driver.findElement(By.cssSelector("#text"));
        String login = loginInput.getText();
        assertEquals(login, "my_login");
    }
}
