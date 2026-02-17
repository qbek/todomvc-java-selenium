package org.example.todomvc;

import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTestSetup {

    String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";
    WebDriver browser = new FirefoxDriver();
    TodoInput todoInput = new TodoInput(browser);
    TodosList todoList = new TodosList(browser);

    @BeforeEach
    public void openApp() {
        browser.get(TodoMVC_URL);
    }


    @AfterEach
    public void closeApp() {
        browser.close();
    }
}
