package com.github.qbek.pageobjects;

import com.github.qbek.aux.IsElementDisplayed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodosList extends PageObject implements IsElementDisplayed {

    By todoList = By.cssSelector(".todo-list");

    public String getAllTodos() {
        WebDriver browser = getDriver();
        WebElement todos = browser.findElement(todoList);
        String allTodos = todos.getText();
        return allTodos;
    }

    @Override
    public List<WebElement> getWebElements() {
        return null;
    }

    @Override
    public Boolean isDisplayed() {
        return true;
    }
}
