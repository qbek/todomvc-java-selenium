package org.example.steps;

import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.WebDriver;

public class UserVerifications {

    TodoFilters filters;
    TodosList todosList;

    public UserVerifications (WebDriver browser) {
        filters = new TodoFilters(browser);
        todosList = new TodosList(browser);
    }

    public void userChecksIfCompletedTodoOnCompletedTab(String todoName) {
        filters.gotoCompleted();
        todosList.checkIfTodoDisplayed(todoName);
    }

    public void userChecksIfCompletedTodoNotOnActiveTab(String todoName) {
        filters.gotoActive();
        todosList.checkIfTodoNOTDisplayed(todoName);

    }

    public void userChecksIfTodoMarkedAsCompleted() {
        todosList.checkIfTodoCompleted();
    }

    public void userChecksIfTodoWasCreated(String todoName) {
        todosList.checkIfTodoDisplayed(todoName);
    }
}
