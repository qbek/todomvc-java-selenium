package org.example.todomvc;

import org.example.todomvc.pageobjects.NewTodoInputPO;
import org.example.todomvc.pageobjects.TodoFiltersPO;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosListPO;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CompleteTodoTest {

    private WebDriver browser = new FirefoxDriver();
    private TodoMVCApp app = new TodoMVCApp(browser);
    private NewTodoInputPO newTodoInput = new NewTodoInputPO(browser);
    private TodosListPO todosList = new TodosListPO(browser);
    private TodoFiltersPO todoFilters = new TodoFiltersPO(browser);

    @AfterEach
    public void closeBrowser() {
        browser.close();
    }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Zadanie do zakończenia";
        app.openTodoMVCPage();

        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();

        todosList.completeTodo();
        todosList.checkTodoMarkedAsCompleted();

        todoFilters.gotoActiveTodos();
        todosList.checkTodoListIsEmpty();

        todoFilters.gotoCompletedTodos();
        todosList.checkTodoIsOnTheList(todoName);
    }
}
