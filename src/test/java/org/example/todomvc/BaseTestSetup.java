package org.example.todomvc;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

abstract public class BaseTestSetup {
    protected WebDriver browser = new FirefoxDriver();
    protected TodoMVCApp app = new TodoMVCApp(browser);
    protected NewTodoInputPO newTodoInput = new NewTodoInputPO(browser);
    protected TodosListPO todosList = new TodosListPO(browser);
    protected TodoFiltersPO todoFilters = new TodoFiltersPO(browser);

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

}
