package com.github.qbek.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodosList extends PageObject {

    By todoList = By.cssSelector(".todo-list");

    public String getAllTodos() {
        WebDriver browser = getDriver();
        WebElement todos = browser.findElement(todoList);
        String allTodos = todos.getText();
        return allTodos;
    }
}
