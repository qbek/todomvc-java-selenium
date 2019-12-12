package com.github.qbek;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TodoMvcTest {

    WebDriver browser;
    String todoMvcURL = "http://todomvc.com/examples/jquery/#/all";

    By newTodoInput = By.cssSelector(".new-todo");
    By todoList = By.cssSelector(".todo-list");


    @Before
    public void setup() {
        userOpensTodoMvcApp();
    }

    @Test
    public void userCanCreateATodo() {
        String todoName = "Learn Selenium + JAVA";
        userCreatesANewTodo(todoName);
        userChecksIfTodoIsCreated(todoName);
    }

    


    @After
    public void cleanUp() {
        userClosesAplication();
    }

    public void userOpensTodoMvcApp() {
        browser = new FirefoxDriver();
        browser.get(todoMvcURL);
        browser.manage().window().maximize();
    }

    public void userCreatesANewTodo(String todoToCreate) {
        WebElement todoInput = browser.findElement(newTodoInput);
        todoInput.sendKeys(todoToCreate);
        todoInput.sendKeys(Keys.ENTER);
    }

    public void userChecksIfTodoIsCreated(String expectedTodo) {
        WebElement todos = browser.findElement(todoList);
        String allTodos = todos.getText();
        System.out.println(allTodos);
        Assert.assertEquals("User todo should be created", expectedTodo, allTodos);
    }

    public void userClosesAplication() {
        browser.quit();
    }
}
