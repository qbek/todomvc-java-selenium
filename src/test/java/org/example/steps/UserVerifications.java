package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.WebDriver;

public class UserVerifications {

    @Steps
    TodoFilters filters;

    @Steps
    TodosList todosList;

    @Step
    public void userChecksIfCompletedTodoOnCompletedTab(String todoName) {
        filters.gotoCompleted();
        todosList.checkIfTodoDisplayed(todoName);
    }

    @Step
    public void userChecksIfCompletedTodoNotOnActiveTab(String todoName) {
        filters.gotoActive();
        todosList.checkIfTodoNOTDisplayed(todoName);

    }

    @Step
    public void userChecksIfTodoMarkedAsCompleted() {
        todosList.checkIfTodoCompleted();
    }

    @Step
    public void userChecksIfTodoWasCreated(String todoName) {
        todosList.checkIfTodoDisplayed(todoName);
    }
}
