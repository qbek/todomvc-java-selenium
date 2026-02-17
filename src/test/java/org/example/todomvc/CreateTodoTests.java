package org.example.todomvc;


import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodosList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    private String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";


    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie żółć";
        var browser = new FirefoxDriver();
        browser.get(TodoMVC_URL);

        var todoInput = new TodoInput(browser);
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();

        var todoList = new TodosList(browser);
        todoList.checkListContainsAnyTodo();
        todoList.checkTodoHasCorrectName(todoName);

        browser.close();
    }


}
