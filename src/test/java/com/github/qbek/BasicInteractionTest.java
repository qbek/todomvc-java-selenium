package com.github.qbek;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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

    @Test
    public void checkBoxesTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        browser.manage().window().maximize();

        WebElement option1Checkbox = browser.findElement(By.cssSelector("[value=\"option-1\"]"));
        WebElement option2Checkbox = browser.findElement(By.cssSelector("[value=\"option-2\"]"));
        WebElement option3Checkbox = browser.findElement(By.cssSelector("[value=\"option-3\"]"));
        WebElement option4Checkbox = browser.findElement(By.cssSelector("[value=\"option-4\"]"));

        boolean isOption1Select = option1Checkbox.isSelected();
        Assert.assertEquals("Option-1 should be unselected", false, isOption1Select);

        boolean isOption3Selected = option3Checkbox.isSelected();
        Assert.assertEquals("Option-3 should be selected", true, isOption3Selected);


        option2Checkbox.click();
        option3Checkbox.click();

        Thread.sleep(2000);
        browser.quit();
    }

    @Test
    public void radioButtonsTest() {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        browser.manage().window().maximize();

        WebElement pumpkinSelect = browser.findElement(By.cssSelector("[value=\"pumpkin\"]"));
        WebElement yellowSelect = browser.findElement(By.cssSelector("[value=\"yellow\"]"));
        WebElement blueSelect = browser.findElement(By.cssSelector("[value=\"blue\"]"));

        boolean isPumpkinSelected = pumpkinSelect.isSelected();
        Assert.assertEquals("Pumpkin shall be selected", true, isPumpkinSelected);

        yellowSelect.click();
        blueSelect.click();

        boolean isYellowSelected = yellowSelect.isSelected();
        Assert.assertEquals("Yellow shall be NOT selected", false, isYellowSelected);

        browser.quit();
    }

    @Test
    public void selectMenuTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        browser.manage().window().maximize();

        WebElement languageSelect = browser.findElement(By.cssSelector("#dropdowm-menu-1"));
        Select language = new Select(languageSelect);

        WebElement selectedItem = language.getFirstSelectedOption();
        String selectedText = selectedItem.getText();
        Assert.assertEquals("There should be JAVA!!!!", "JAVA", selectedText);

        WebElement toolsSelect = browser.findElement(By.cssSelector("#dropdowm-menu-2"));
        Select tools = new Select(toolsSelect);

        tools.selectByIndex(1);
        Thread.sleep(2000);

        browser.quit();
    }


}
